package com.google.location.visualmapping.client.vpsmanagement;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.internal.tango.vpsmanagement.v1.ManagementServiceGrpc;
import com.google.internal.tango.vpsmanagement.v1.ManagementServiceGrpc.ManagementServiceBlockingStub;
import com.google.internal.tango.vpsmanagement.v1.ManagementServiceGrpc.ManagementServiceStub;
import com.google.location.visualmapping.client.clock.AndroidClock;
import com.google.location.visualmapping.client.clock.Clock;
import com.google.location.visualmapping.client.grpc.Utils;
import com.google.location.visualmapping.vpsmanagement.MapObjectOuterClass.MapObjectCategory;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListCollectionsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListCollectionsRequestProto.Builder;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListCollectionsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListLocalizationResultsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListLocalizationResultsRequestProto.Builder;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListLocalizationResultsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListMapObjectsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListMapObjectsRequestProto.Builder;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListMapObjectsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListTrajectoriesRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListTrajectoriesRequestProto.Builder;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListTrajectoriesResponseProto;
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
import io.grpc.StatusRuntimeException;
import io.grpc.okhttp.OkHttpChannelBuilder;
import java.util.concurrent.atomic.AtomicReference;

public class VpsManagementClient
{
  private static final Metadata.Key<String> HEADER_ANDROID_CERT = Metadata.Key.of("X-Android-Cert", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> HEADER_ANDROID_PACKAGE = Metadata.Key.of("X-Android-Package", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> HEADER_API_KEY;
  private static final String KEY_ANDROID_CERT = "X-Android-Cert";
  private static final String KEY_ANDROID_PACKAGE = "X-Android-Package";
  private static final String KEY_API_KEY = "x-goog-api-key";
  private static final int SECURE_PORT = 443;
  private static final StatusRuntimeException STUB_UNINITIALIZED_EXCEPTION = new StatusRuntimeException(Status.FAILED_PRECONDITION.withDescription("Stub has not been initialized."));
  private static final String TAG = VpsManagementClient.class.getSimpleName();
  @VisibleForTesting
  final AtomicReference<ManagementServiceGrpc.ManagementServiceStub> asyncStub;
  @VisibleForTesting
  final AtomicReference<ManagementServiceGrpc.ManagementServiceBlockingStub> blockingStub;
  private final ClientInterceptor clientInterceptor;
  @VisibleForTesting
  final Clock clock;
  private final Context context;
  private ManagedChannel managedChannel = null;
  private final int maxMessageSize;
  
  static
  {
    HEADER_API_KEY = Metadata.Key.of("x-goog-api-key", Metadata.ASCII_STRING_MARSHALLER);
  }
  
  public VpsManagementClient(@NonNull Context paramContext, @NonNull String paramString1, @NonNull int paramInt, @NonNull String paramString2)
  {
    this(paramContext, paramString1, paramInt, paramString2, new AndroidClock());
  }
  
  @VisibleForTesting
  VpsManagementClient(@NonNull final Context paramContext, @NonNull final String paramString1, @NonNull int paramInt, @NonNull String paramString2, @NonNull Clock paramClock)
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
            paramAnonymous2Metadata.put(VpsManagementClient.HEADER_API_KEY, VpsManagementClient.1.this.val$apiKey);
            paramAnonymous2Metadata.put(VpsManagementClient.HEADER_ANDROID_CERT, Utils.getCertFingerprint(VpsManagementClient.1.this.val$context));
            paramAnonymous2Metadata.put(VpsManagementClient.HEADER_ANDROID_PACKAGE, VpsManagementClient.1.this.val$context.getPackageName());
            super.start(paramAnonymous2Listener, paramAnonymous2Metadata);
          }
        };
      }
    };
    updateEndpoint(paramString2);
  }
  
  private <T> T performBlockingCall(Function<ManagementServiceGrpc.ManagementServiceBlockingStub, T> paramFunction)
  {
    ManagementServiceGrpc.ManagementServiceBlockingStub localManagementServiceBlockingStub = (ManagementServiceGrpc.ManagementServiceBlockingStub)this.blockingStub.get();
    if (localManagementServiceBlockingStub == null)
    {
      Log.e(TAG, "blockingStub is null. VpsManagementClient might fail to initialize.");
      throw STUB_UNINITIALIZED_EXCEPTION;
    }
    try
    {
      paramFunction = paramFunction.apply(localManagementServiceBlockingStub);
      return paramFunction;
    }
    catch (Throwable paramFunction)
    {
      throw new StatusRuntimeException(Status.fromThrowable(paramFunction));
    }
  }
  
  @Nullable
  public VpsManagementWire.ListCollectionsResponseProto listCollections(String paramString, int paramInt)
  {
    (VpsManagementWire.ListCollectionsResponseProto)performBlockingCall(new Function()
    {
      @Nullable
      public VpsManagementWire.ListCollectionsResponseProto apply(@Nullable ManagementServiceGrpc.ManagementServiceBlockingStub paramAnonymousManagementServiceBlockingStub)
      {
        return paramAnonymousManagementServiceBlockingStub.listCollections(this.val$request);
      }
    });
  }
  
  @Nullable
  public VpsManagementWire.ListLocalizationResultsResponseProto listLocalizationResults(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    (VpsManagementWire.ListLocalizationResultsResponseProto)performBlockingCall(new Function()
    {
      @Nullable
      public VpsManagementWire.ListLocalizationResultsResponseProto apply(@Nullable ManagementServiceGrpc.ManagementServiceBlockingStub paramAnonymousManagementServiceBlockingStub)
      {
        return paramAnonymousManagementServiceBlockingStub.listLocalizationResults(this.val$request);
      }
    });
  }
  
  @Nullable
  public VpsManagementWire.ListMapObjectsResponseProto listMapObjects(String paramString, Iterable<MapObjectOuterClass.MapObjectCategory> paramIterable)
  {
    (VpsManagementWire.ListMapObjectsResponseProto)performBlockingCall(new Function()
    {
      @Nullable
      public VpsManagementWire.ListMapObjectsResponseProto apply(@Nullable ManagementServiceGrpc.ManagementServiceBlockingStub paramAnonymousManagementServiceBlockingStub)
      {
        return paramAnonymousManagementServiceBlockingStub.listMapObjects(this.val$request);
      }
    });
  }
  
  @Nullable
  public VpsManagementWire.ListTrajectoriesResponseProto listTrajectories(Iterable<String> paramIterable)
  {
    (VpsManagementWire.ListTrajectoriesResponseProto)performBlockingCall(new Function()
    {
      @Nullable
      public VpsManagementWire.ListTrajectoriesResponseProto apply(@Nullable ManagementServiceGrpc.ManagementServiceBlockingStub paramAnonymousManagementServiceBlockingStub)
      {
        return paramAnonymousManagementServiceBlockingStub.listTrajectories(this.val$request);
      }
    });
  }
  
  public void shutdown()
  {
    if (this.managedChannel != null)
    {
      Log.d(TAG, "Shutting down managed channel.");
      this.managedChannel.shutdown();
      this.managedChannel = null;
      this.asyncStub.set(null);
    }
  }
  
  public void updateEndpoint(@NonNull String paramString)
  {
    Log.d(TAG, "Updating endpoint: " + paramString);
    shutdown();
    paramString = (OkHttpChannelBuilder)OkHttpChannelBuilder.forAddress(paramString, 443).maxInboundMessageSize(this.maxMessageSize);
    if (Build.VERSION.SDK_INT <= 19)
    {
      SSLCertificateSocketFactory localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(10000);
      localSSLCertificateSocketFactory.setNpnProtocols(new byte[][] { "h2".getBytes(Charsets.US_ASCII) });
      paramString.sslSocketFactory(localSSLCertificateSocketFactory);
    }
    this.managedChannel = paramString.build();
    this.asyncStub.set(ManagementServiceGrpc.newStub(ClientInterceptors.intercept(this.managedChannel, new ClientInterceptor[] { this.clientInterceptor })));
    this.blockingStub.set(ManagementServiceGrpc.newBlockingStub(ClientInterceptors.intercept(this.managedChannel, new ClientInterceptor[] { this.clientInterceptor })));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/vpsmanagement/VpsManagementClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */