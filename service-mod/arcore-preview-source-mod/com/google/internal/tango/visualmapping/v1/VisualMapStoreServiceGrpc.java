package com.google.internal.tango.visualmapping.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ListVenueGroupRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ListVenueGroupResponseProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadAdfClusterNavigationGraphRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadAdfClusterNavigationGraphResponseProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadTilesRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.ReadTilesResponseProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.WriteFileRequestProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.WriteFileResponseProto;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerServiceDefinition.Builder;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.ServerCalls.BidiStreamingMethod;
import io.grpc.stub.ServerCalls.ClientStreamingMethod;
import io.grpc.stub.ServerCalls.ServerStreamingMethod;
import io.grpc.stub.ServerCalls.UnaryMethod;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;

public class VisualMapStoreServiceGrpc
{
  private static final int METHODID_LIST_VENUE_GROUP = 4;
  private static final int METHODID_READ_ADF_CLUSTER_NAVIGATION_GRAPH = 3;
  private static final int METHODID_READ_TILES = 0;
  private static final int METHODID_READ_TILES_STREAM = 1;
  private static final int METHODID_WRITE_FILE = 2;
  public static final MethodDescriptor<VisualMapWire.ListVenueGroupRequestProto, VisualMapWire.ListVenueGroupResponseProto> METHOD_LIST_VENUE_GROUP = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.visualmapping.v1.VisualMapStoreService", "ListVenueGroup"), ProtoLiteUtils.marshaller(VisualMapWire.ListVenueGroupRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VisualMapWire.ListVenueGroupResponseProto.getDefaultInstance()));
  public static final MethodDescriptor<VisualMapWire.ReadAdfClusterNavigationGraphRequestProto, VisualMapWire.ReadAdfClusterNavigationGraphResponseProto> METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH;
  public static final MethodDescriptor<VisualMapWire.ReadTilesRequestProto, VisualMapWire.ReadTilesResponseProto> METHOD_READ_TILES = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.visualmapping.v1.VisualMapStoreService", "ReadTiles"), ProtoLiteUtils.marshaller(VisualMapWire.ReadTilesRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VisualMapWire.ReadTilesResponseProto.getDefaultInstance()));
  public static final MethodDescriptor<VisualMapWire.ReadTilesRequestProto, VisualMapWire.ReadTilesResponseProto> METHOD_READ_TILES_STREAM = MethodDescriptor.create(MethodDescriptor.MethodType.SERVER_STREAMING, MethodDescriptor.generateFullMethodName("google.internal.tango.visualmapping.v1.VisualMapStoreService", "ReadTilesStream"), ProtoLiteUtils.marshaller(VisualMapWire.ReadTilesRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VisualMapWire.ReadTilesResponseProto.getDefaultInstance()));
  public static final MethodDescriptor<VisualMapWire.WriteFileRequestProto, VisualMapWire.WriteFileResponseProto> METHOD_WRITE_FILE = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.visualmapping.v1.VisualMapStoreService", "WriteFile"), ProtoLiteUtils.marshaller(VisualMapWire.WriteFileRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VisualMapWire.WriteFileResponseProto.getDefaultInstance()));
  public static final String SERVICE_NAME = "google.internal.tango.visualmapping.v1.VisualMapStoreService";
  
  static
  {
    METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.visualmapping.v1.VisualMapStoreService", "ReadAdfClusterNavigationGraph"), ProtoLiteUtils.marshaller(VisualMapWire.ReadAdfClusterNavigationGraphRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VisualMapWire.ReadAdfClusterNavigationGraphResponseProto.getDefaultInstance()));
  }
  
  public static ServiceDescriptor getServiceDescriptor()
  {
    return new ServiceDescriptor("google.internal.tango.visualmapping.v1.VisualMapStoreService", new MethodDescriptor[] { METHOD_READ_TILES, METHOD_READ_TILES_STREAM, METHOD_WRITE_FILE, METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, METHOD_LIST_VENUE_GROUP });
  }
  
  public static VisualMapStoreServiceBlockingStub newBlockingStub(Channel paramChannel)
  {
    return new VisualMapStoreServiceBlockingStub(paramChannel, null);
  }
  
  public static VisualMapStoreServiceFutureStub newFutureStub(Channel paramChannel)
  {
    return new VisualMapStoreServiceFutureStub(paramChannel, null);
  }
  
  public static VisualMapStoreServiceStub newStub(Channel paramChannel)
  {
    return new VisualMapStoreServiceStub(paramChannel, null);
  }
  
  private static class MethodHandlers<Req, Resp>
    implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp>
  {
    private final int methodId;
    private final VisualMapStoreServiceGrpc.VisualMapStoreServiceImplBase serviceImpl;
    
    public MethodHandlers(VisualMapStoreServiceGrpc.VisualMapStoreServiceImplBase paramVisualMapStoreServiceImplBase, int paramInt)
    {
      this.serviceImpl = paramVisualMapStoreServiceImplBase;
      this.methodId = paramInt;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> paramStreamObserver)
    {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req paramReq, StreamObserver<Resp> paramStreamObserver)
    {
      switch (this.methodId)
      {
      default: 
        throw new AssertionError();
      case 0: 
        this.serviceImpl.readTiles((VisualMapWire.ReadTilesRequestProto)paramReq, paramStreamObserver);
        return;
      case 1: 
        this.serviceImpl.readTilesStream((VisualMapWire.ReadTilesRequestProto)paramReq, paramStreamObserver);
        return;
      case 2: 
        this.serviceImpl.writeFile((VisualMapWire.WriteFileRequestProto)paramReq, paramStreamObserver);
        return;
      case 3: 
        this.serviceImpl.readAdfClusterNavigationGraph((VisualMapWire.ReadAdfClusterNavigationGraphRequestProto)paramReq, paramStreamObserver);
        return;
      }
      this.serviceImpl.listVenueGroup((VisualMapWire.ListVenueGroupRequestProto)paramReq, paramStreamObserver);
    }
  }
  
  public static final class VisualMapStoreServiceBlockingStub
    extends AbstractStub<VisualMapStoreServiceBlockingStub>
  {
    private VisualMapStoreServiceBlockingStub(Channel paramChannel)
    {
      super();
    }
    
    private VisualMapStoreServiceBlockingStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected VisualMapStoreServiceBlockingStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new VisualMapStoreServiceBlockingStub(paramChannel, paramCallOptions);
    }
    
    public VisualMapWire.ListVenueGroupResponseProto listVenueGroup(VisualMapWire.ListVenueGroupRequestProto paramListVenueGroupRequestProto)
    {
      return (VisualMapWire.ListVenueGroupResponseProto)ClientCalls.blockingUnaryCall(getChannel(), VisualMapStoreServiceGrpc.METHOD_LIST_VENUE_GROUP, getCallOptions(), paramListVenueGroupRequestProto);
    }
    
    public VisualMapWire.ReadAdfClusterNavigationGraphResponseProto readAdfClusterNavigationGraph(VisualMapWire.ReadAdfClusterNavigationGraphRequestProto paramReadAdfClusterNavigationGraphRequestProto)
    {
      return (VisualMapWire.ReadAdfClusterNavigationGraphResponseProto)ClientCalls.blockingUnaryCall(getChannel(), VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, getCallOptions(), paramReadAdfClusterNavigationGraphRequestProto);
    }
    
    public VisualMapWire.ReadTilesResponseProto readTiles(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto)
    {
      return (VisualMapWire.ReadTilesResponseProto)ClientCalls.blockingUnaryCall(getChannel(), VisualMapStoreServiceGrpc.METHOD_READ_TILES, getCallOptions(), paramReadTilesRequestProto);
    }
    
    public Iterator<VisualMapWire.ReadTilesResponseProto> readTilesStream(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto)
    {
      return ClientCalls.blockingServerStreamingCall(getChannel(), VisualMapStoreServiceGrpc.METHOD_READ_TILES_STREAM, getCallOptions(), paramReadTilesRequestProto);
    }
    
    public VisualMapWire.WriteFileResponseProto writeFile(VisualMapWire.WriteFileRequestProto paramWriteFileRequestProto)
    {
      return (VisualMapWire.WriteFileResponseProto)ClientCalls.blockingUnaryCall(getChannel(), VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, getCallOptions(), paramWriteFileRequestProto);
    }
  }
  
  public static final class VisualMapStoreServiceFutureStub
    extends AbstractStub<VisualMapStoreServiceFutureStub>
  {
    private VisualMapStoreServiceFutureStub(Channel paramChannel)
    {
      super();
    }
    
    private VisualMapStoreServiceFutureStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected VisualMapStoreServiceFutureStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new VisualMapStoreServiceFutureStub(paramChannel, paramCallOptions);
    }
    
    public ListenableFuture<VisualMapWire.ListVenueGroupResponseProto> listVenueGroup(VisualMapWire.ListVenueGroupRequestProto paramListVenueGroupRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_LIST_VENUE_GROUP, getCallOptions()), paramListVenueGroupRequestProto);
    }
    
    public ListenableFuture<VisualMapWire.ReadAdfClusterNavigationGraphResponseProto> readAdfClusterNavigationGraph(VisualMapWire.ReadAdfClusterNavigationGraphRequestProto paramReadAdfClusterNavigationGraphRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, getCallOptions()), paramReadAdfClusterNavigationGraphRequestProto);
    }
    
    public ListenableFuture<VisualMapWire.ReadTilesResponseProto> readTiles(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_TILES, getCallOptions()), paramReadTilesRequestProto);
    }
    
    public ListenableFuture<VisualMapWire.WriteFileResponseProto> writeFile(VisualMapWire.WriteFileRequestProto paramWriteFileRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, getCallOptions()), paramWriteFileRequestProto);
    }
  }
  
  public static abstract class VisualMapStoreServiceImplBase
    implements BindableService
  {
    public ServerServiceDefinition bindService()
    {
      return ServerServiceDefinition.builder(VisualMapStoreServiceGrpc.getServiceDescriptor()).addMethod(VisualMapStoreServiceGrpc.METHOD_READ_TILES, ServerCalls.asyncUnaryCall(new VisualMapStoreServiceGrpc.MethodHandlers(this, 0))).addMethod(VisualMapStoreServiceGrpc.METHOD_READ_TILES_STREAM, ServerCalls.asyncServerStreamingCall(new VisualMapStoreServiceGrpc.MethodHandlers(this, 1))).addMethod(VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, ServerCalls.asyncUnaryCall(new VisualMapStoreServiceGrpc.MethodHandlers(this, 2))).addMethod(VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, ServerCalls.asyncUnaryCall(new VisualMapStoreServiceGrpc.MethodHandlers(this, 3))).addMethod(VisualMapStoreServiceGrpc.METHOD_LIST_VENUE_GROUP, ServerCalls.asyncUnaryCall(new VisualMapStoreServiceGrpc.MethodHandlers(this, 4))).build();
    }
    
    public void listVenueGroup(VisualMapWire.ListVenueGroupRequestProto paramListVenueGroupRequestProto, StreamObserver<VisualMapWire.ListVenueGroupResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(VisualMapStoreServiceGrpc.METHOD_LIST_VENUE_GROUP, paramStreamObserver);
    }
    
    public void readAdfClusterNavigationGraph(VisualMapWire.ReadAdfClusterNavigationGraphRequestProto paramReadAdfClusterNavigationGraphRequestProto, StreamObserver<VisualMapWire.ReadAdfClusterNavigationGraphResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, paramStreamObserver);
    }
    
    public void readTiles(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto, StreamObserver<VisualMapWire.ReadTilesResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(VisualMapStoreServiceGrpc.METHOD_READ_TILES, paramStreamObserver);
    }
    
    public void readTilesStream(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto, StreamObserver<VisualMapWire.ReadTilesResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(VisualMapStoreServiceGrpc.METHOD_READ_TILES_STREAM, paramStreamObserver);
    }
    
    public void writeFile(VisualMapWire.WriteFileRequestProto paramWriteFileRequestProto, StreamObserver<VisualMapWire.WriteFileResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, paramStreamObserver);
    }
  }
  
  public static final class VisualMapStoreServiceStub
    extends AbstractStub<VisualMapStoreServiceStub>
  {
    private VisualMapStoreServiceStub(Channel paramChannel)
    {
      super();
    }
    
    private VisualMapStoreServiceStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected VisualMapStoreServiceStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new VisualMapStoreServiceStub(paramChannel, paramCallOptions);
    }
    
    public void listVenueGroup(VisualMapWire.ListVenueGroupRequestProto paramListVenueGroupRequestProto, StreamObserver<VisualMapWire.ListVenueGroupResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_LIST_VENUE_GROUP, getCallOptions()), paramListVenueGroupRequestProto, paramStreamObserver);
    }
    
    public void readAdfClusterNavigationGraph(VisualMapWire.ReadAdfClusterNavigationGraphRequestProto paramReadAdfClusterNavigationGraphRequestProto, StreamObserver<VisualMapWire.ReadAdfClusterNavigationGraphResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_ADF_CLUSTER_NAVIGATION_GRAPH, getCallOptions()), paramReadAdfClusterNavigationGraphRequestProto, paramStreamObserver);
    }
    
    public void readTiles(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto, StreamObserver<VisualMapWire.ReadTilesResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_TILES, getCallOptions()), paramReadTilesRequestProto, paramStreamObserver);
    }
    
    public void readTilesStream(VisualMapWire.ReadTilesRequestProto paramReadTilesRequestProto, StreamObserver<VisualMapWire.ReadTilesResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncServerStreamingCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_READ_TILES_STREAM, getCallOptions()), paramReadTilesRequestProto, paramStreamObserver);
    }
    
    public void writeFile(VisualMapWire.WriteFileRequestProto paramWriteFileRequestProto, StreamObserver<VisualMapWire.WriteFileResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(VisualMapStoreServiceGrpc.METHOD_WRITE_FILE, getCallOptions()), paramWriteFileRequestProto, paramStreamObserver);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/visualmapping/v1/VisualMapStoreServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */