package com.google.location.visualmapping.client.visualmapstore;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.internal.tango.visualmapping.v1.VisualMapStoreServiceGrpc;
import com.google.internal.tango.visualmapping.v1.VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub;
import com.google.internal.tango.visualmapping.v1.VisualMapStoreServiceGrpc.VisualMapStoreServiceStub;
import com.google.location.visualmapping.client.GrpcErrorListener;
import com.google.location.visualmapping.client.clock.AndroidClock;
import com.google.location.visualmapping.client.clock.Clock;
import com.google.location.visualmapping.client.grpc.Utils;
import com.google.location.visualmapping.visualmapstore.S2CellId.S2CellIdProto;
import com.google.location.visualmapping.visualmapstore.S2CellId.S2CellIdProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapKey.AdfClusterNavigationGraphKeyProto;
import com.google.location.visualmapping.visualmapstore.VisualMapKey.AdfClusterNavigationGraphKeyProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapKey.TileKeyProto;
import com.google.location.visualmapping.visualmapstore.VisualMapKey.TileKeyProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.AdfClusterNavigationGraphProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ListVenueGroupRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ListVenueGroupRequestProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ListVenueGroupResponseProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadAdfClusterNavigationGraphRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadAdfClusterNavigationGraphRequestProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadAdfClusterNavigationGraphResponseProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.VenueGroupExternalSafeProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.WriteFileRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.WriteFileRequestProto.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.WriteFileResponseProto;
import com.google.protobuf.ByteString;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class VisualMapStoreClient
{
  @VisibleForTesting
  static final long CHANNEL_RECREATION_PERIOD_IN_MS = 1000L;
  private static final Metadata.Key<String> HEADER_ANDROID_CERT = Metadata.Key.of("X-Android-Cert", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> HEADER_ANDROID_PACKAGE = Metadata.Key.of("X-Android-Package", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> HEADER_API_KEY;
  private static final Metadata.Key<byte[]> HEADER_GOOGLE_RPC_DEBUGINFO_BIN = Metadata.Key.of("google.rpc.debuginfo-bin", Metadata.BINARY_BYTE_MARSHALLER);
  private static final String KEY_ANDROID_CERT = "X-Android-Cert";
  private static final String KEY_ANDROID_PACKAGE = "X-Android-Package";
  private static final String KEY_API_KEY = "x-goog-api-key";
  private static final String KEY_GOOGLE_RPC_DEBUGINFO_BIN = "google.rpc.debuginfo-bin";
  private static final int SECURE_PORT = 443;
  private static final StatusRuntimeException STUB_UNINITIALIZED_EXCEPTION = new StatusRuntimeException(Status.FAILED_PRECONDITION.withDescription("Stub has not been initialized."));
  private static final String TAG = VisualMapStoreClient.class.getSimpleName();
  @VisibleForTesting
  final AtomicReference<VisualMapStoreServiceGrpc.VisualMapStoreServiceStub> asyncStub;
  @VisibleForTesting
  final AtomicReference<VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub> blockingStub;
  private final ClientInterceptor clientInterceptor;
  @VisibleForTesting
  final Clock clock;
  private final Context context;
  private String endpoint = null;
  private long lastChannelCreationTimeInMs = -1L;
  private ManagedChannel managedChannel = null;
  private final int maxMessageSize;
  
  static
  {
    HEADER_API_KEY = Metadata.Key.of("x-goog-api-key", Metadata.ASCII_STRING_MARSHALLER);
  }
  
  public VisualMapStoreClient(@NonNull Context paramContext, @NonNull String paramString1, @NonNull int paramInt, @NonNull String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramString2, new AndroidClock());
  }
  
  @VisibleForTesting
  VisualMapStoreClient(@NonNull final Context paramContext, @NonNull final String paramString1, @NonNull int paramInt, @NonNull String paramString2, @NonNull Clock paramClock)
  {
    this.maxMessageSize = paramInt;
    this.context = paramContext;
    this.clock = paramClock;
    this.asyncStub = new AtomicReference(null);
    this.blockingStub = new AtomicReference(null);
    this.clientInterceptor = new ClientInterceptor()
    {
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramAnonymousMethodDescriptor, CallOptions paramAnonymousCallOptions, Channel paramAnonymousChannel)
      {
        new ForwardingClientCall.SimpleForwardingClientCall(paramAnonymousChannel.newCall(paramAnonymousMethodDescriptor, paramAnonymousCallOptions))
        {
          public void start(ClientCall.Listener<RespT> paramAnonymous2Listener, Metadata paramAnonymous2Metadata)
          {
            paramAnonymous2Metadata.put(VisualMapStoreClient.HEADER_API_KEY, VisualMapStoreClient.1.this.val$apiKey);
            paramAnonymous2Metadata.put(VisualMapStoreClient.HEADER_ANDROID_CERT, Utils.getCertFingerprint(VisualMapStoreClient.1.this.val$context));
            paramAnonymous2Metadata.put(VisualMapStoreClient.HEADER_ANDROID_PACKAGE, VisualMapStoreClient.1.this.val$context.getPackageName());
            super.start(paramAnonymous2Listener, paramAnonymous2Metadata);
          }
        };
      }
    };
    updateEndpoint(paramString2);
  }
  
  private void reportError(@NonNull GrpcErrorListener paramGrpcErrorListener, Throwable paramThrowable)
  {
    paramThrowable = Status.fromThrowable(paramThrowable);
    if (paramGrpcErrorListener != null) {
      paramGrpcErrorListener.onError(new StatusRuntimeException(paramThrowable));
    }
    if (((paramThrowable.getCode().equals(Status.Code.UNAVAILABLE)) || (paramThrowable.getCode().equals(Status.Code.DEADLINE_EXCEEDED))) && (this.clock.uptimeMillis() - this.lastChannelCreationTimeInMs > 1000L))
    {
      Log.w(TAG, "Recreating gRPC channel because of network unavailable.");
      updateEndpoint(this.endpoint);
    }
  }
  
  @Nullable
  public ImmutableList<VisualMapWire.VenueGroupExternalSafeProto> listVenueGroups()
  {
    Object localObject = (VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub)this.blockingStub.get();
    if (localObject == null)
    {
      Log.e(TAG, "blockingStub is null. VisualMapStoreClient might fail to initialize.");
      throw STUB_UNINITIALIZED_EXCEPTION;
    }
    VisualMapWire.ListVenueGroupRequestProto localListVenueGroupRequestProto = (VisualMapWire.ListVenueGroupRequestProto)VisualMapWire.ListVenueGroupRequestProto.newBuilder().build();
    try
    {
      localObject = ImmutableList.copyOf(((VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub)localObject).listVenueGroup(localListVenueGroupRequestProto).getVenueGroupsList());
      return (ImmutableList<VisualMapWire.VenueGroupExternalSafeProto>)localObject;
    }
    catch (Throwable localThrowable)
    {
      throw new StatusRuntimeException(Status.fromThrowable(localThrowable));
    }
  }
  
  @Nullable
  public ClientCall readAdfClusterNavigationGraphAsync(@NonNull final Set<Long> paramSet, @NonNull List<String> paramList, @NonNull final ReadAdfClusterNavigationGraphResponseListener paramReadAdfClusterNavigationGraphResponseListener, @Nullable final GrpcErrorListener paramGrpcErrorListener)
  {
    VisualMapStoreServiceGrpc.VisualMapStoreServiceStub localVisualMapStoreServiceStub = (VisualMapStoreServiceGrpc.VisualMapStoreServiceStub)this.asyncStub.get();
    if (localVisualMapStoreServiceStub == null)
    {
      Log.e(TAG, "asyncStub is null. VisualMapStoreClient might fail to initialize.");
      if (paramGrpcErrorListener != null) {
        paramGrpcErrorListener.onError(STUB_UNINITIALIZED_EXCEPTION);
      }
      return null;
    }
    VisualMapWire.ReadAdfClusterNavigationGraphRequestProto.Builder localBuilder = VisualMapWire.ReadAdfClusterNavigationGraphRequestProto.newBuilder();
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      localBuilder.addTileKeys(VisualMapKey.TileKeyProto.newBuilder().setS2CellId(S2CellId.S2CellIdProto.newBuilder().setId(l)));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      localBuilder.addNavGraphKeysAlreadyDownloaded(VisualMapKey.AdfClusterNavigationGraphKeyProto.newBuilder().setUuid((String)localObject));
    }
    paramList = localVisualMapStoreServiceStub.getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, localVisualMapStoreServiceStub.getCallOptions());
    ClientCalls.asyncUnaryCall(paramList, localBuilder.build(), new StreamObserver()
    {
      public void onCompleted() {}
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        VisualMapStoreClient.this.reportError(paramGrpcErrorListener, paramAnonymousThrowable);
      }
      
      public void onNext(VisualMapWire.ReadAdfClusterNavigationGraphResponseProto paramAnonymousReadAdfClusterNavigationGraphResponseProto)
      {
        HashMap localHashMap = new HashMap();
        paramAnonymousReadAdfClusterNavigationGraphResponseProto = paramAnonymousReadAdfClusterNavigationGraphResponseProto.getGraphsList().iterator();
        while (paramAnonymousReadAdfClusterNavigationGraphResponseProto.hasNext())
        {
          VisualMapWire.AdfClusterNavigationGraphProto localAdfClusterNavigationGraphProto = (VisualMapWire.AdfClusterNavigationGraphProto)paramAnonymousReadAdfClusterNavigationGraphResponseProto.next();
          localHashMap.put(localAdfClusterNavigationGraphProto.getKey().getUuid(), localAdfClusterNavigationGraphProto.getRawData().toByteArray());
        }
        paramReadAdfClusterNavigationGraphResponseListener.onResponse(paramSet, localHashMap);
      }
    });
    return paramList;
  }
  
  public void shutdown()
  {
    if (this.managedChannel != null)
    {
      Log.d(TAG, "Shutting down managed channel.");
      this.managedChannel.shutdown();
      this.managedChannel = null;
      this.endpoint = null;
      this.lastChannelCreationTimeInMs = -1L;
      this.asyncStub.set(null);
    }
  }
  
  public void updateEndpoint(@NonNull String paramString)
  {
    Log.d(TAG, "Updating endpoint: " + paramString);
    shutdown();
    this.lastChannelCreationTimeInMs = this.clock.uptimeMillis();
    OkHttpChannelBuilder localOkHttpChannelBuilder = (OkHttpChannelBuilder)OkHttpChannelBuilder.forAddress(paramString, 443).maxInboundMessageSize(this.maxMessageSize);
    if (Build.VERSION.SDK_INT <= 19)
    {
      SSLCertificateSocketFactory localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(10000);
      localSSLCertificateSocketFactory.setNpnProtocols(new byte[][] { "h2".getBytes(Charsets.US_ASCII) });
      localOkHttpChannelBuilder.sslSocketFactory(localSSLCertificateSocketFactory);
    }
    this.managedChannel = localOkHttpChannelBuilder.build();
    this.asyncStub.set(VisualMapStoreServiceGrpc.newStub(ClientInterceptors.intercept(this.managedChannel, new ClientInterceptor[] { this.clientInterceptor })));
    this.blockingStub.set(VisualMapStoreServiceGrpc.newBlockingStub(ClientInterceptors.intercept(this.managedChannel, new ClientInterceptor[] { this.clientInterceptor })));
    this.endpoint = paramString;
  }
  
  public String writeFile(@NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3)
  {
    VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub localVisualMapStoreServiceBlockingStub = (VisualMapStoreServiceGrpc.VisualMapStoreServiceBlockingStub)this.blockingStub.get();
    if (localVisualMapStoreServiceBlockingStub == null)
    {
      Log.e(TAG, "blockingStub is null. VisualMapStoreClient might fail to initialize.");
      throw STUB_UNINITIALIZED_EXCEPTION;
    }
    VisualMapWire.WriteFileRequestProto.Builder localBuilder = VisualMapWire.WriteFileRequestProto.newBuilder();
    localBuilder.setBucket(paramString1);
    localBuilder.setFileFullName(paramString2);
    if (paramString3 != null) {
      localBuilder.setIdToken(paramString3);
    }
    try
    {
      paramString1 = localVisualMapStoreServiceBlockingStub.writeFile((VisualMapWire.WriteFileRequestProto)localBuilder.build()).getSignedUploadRequestUrl();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new StatusRuntimeException(Status.fromThrowable(paramString1));
    }
  }
  
  @Nullable
  public ClientCall writeFileAsync(@NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, @NonNull final WriteFileResponseListener paramWriteFileResponseListener, @Nullable final GrpcErrorListener paramGrpcErrorListener)
  {
    VisualMapStoreServiceGrpc.VisualMapStoreServiceStub localVisualMapStoreServiceStub = (VisualMapStoreServiceGrpc.VisualMapStoreServiceStub)this.asyncStub.get();
    if (localVisualMapStoreServiceStub == null)
    {
      Log.e(TAG, "asyncStub is null. VisualMapStoreClient might fail to initialize.");
      if (paramGrpcErrorListener != null) {
        paramGrpcErrorListener.onError(STUB_UNINITIALIZED_EXCEPTION);
      }
      return null;
    }
    VisualMapWire.WriteFileRequestProto.Builder localBuilder = VisualMapWire.WriteFileRequestProto.newBuilder();
    localBuilder.setBucket(paramString1);
    localBuilder.setFileFullName(paramString2);
    if (paramString3 != null) {
      localBuilder.setIdToken(paramString3);
    }
    paramString1 = localVisualMapStoreServiceStub.getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, localVisualMapStoreServiceStub.getCallOptions());
    ClientCalls.asyncServerStreamingCall(paramString1, localBuilder.build(), new StreamObserver()
    {
      public void onCompleted() {}
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        VisualMapStoreClient.this.reportError(paramGrpcErrorListener, paramAnonymousThrowable);
      }
      
      public void onNext(VisualMapWire.WriteFileResponseProto paramAnonymousWriteFileResponseProto)
      {
        paramWriteFileResponseListener.onResponse(paramAnonymousWriteFileResponseProto.getSignedUploadRequestUrl());
      }
    });
    return paramString1;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/visualmapstore/VisualMapStoreClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */