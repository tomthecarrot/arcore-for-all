package com.google.internal.tango.vpsmanagement.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListCollectionsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListCollectionsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListLocalizationResultsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListLocalizationResultsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListMapObjectsRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListMapObjectsResponseProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListTrajectoriesRequestProto;
import com.google.location.visualmapping.vpsmanagement.VpsManagementWire.ListTrajectoriesResponseProto;
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

public class ManagementServiceGrpc
{
  private static final int METHODID_LIST_COLLECTIONS = 1;
  private static final int METHODID_LIST_LOCALIZATION_RESULTS = 0;
  private static final int METHODID_LIST_MAP_OBJECTS = 3;
  private static final int METHODID_LIST_TRAJECTORIES = 2;
  public static final MethodDescriptor<VpsManagementWire.ListCollectionsRequestProto, VpsManagementWire.ListCollectionsResponseProto> METHOD_LIST_COLLECTIONS;
  public static final MethodDescriptor<VpsManagementWire.ListLocalizationResultsRequestProto, VpsManagementWire.ListLocalizationResultsResponseProto> METHOD_LIST_LOCALIZATION_RESULTS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.vpsmanagement.v1.ManagementService", "ListLocalizationResults"), ProtoLiteUtils.marshaller(VpsManagementWire.ListLocalizationResultsRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VpsManagementWire.ListLocalizationResultsResponseProto.getDefaultInstance()));
  public static final MethodDescriptor<VpsManagementWire.ListMapObjectsRequestProto, VpsManagementWire.ListMapObjectsResponseProto> METHOD_LIST_MAP_OBJECTS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.vpsmanagement.v1.ManagementService", "ListMapObjects"), ProtoLiteUtils.marshaller(VpsManagementWire.ListMapObjectsRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VpsManagementWire.ListMapObjectsResponseProto.getDefaultInstance()));
  public static final MethodDescriptor<VpsManagementWire.ListTrajectoriesRequestProto, VpsManagementWire.ListTrajectoriesResponseProto> METHOD_LIST_TRAJECTORIES;
  public static final String SERVICE_NAME = "google.internal.tango.vpsmanagement.v1.ManagementService";
  
  static
  {
    METHOD_LIST_COLLECTIONS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.vpsmanagement.v1.ManagementService", "ListCollections"), ProtoLiteUtils.marshaller(VpsManagementWire.ListCollectionsRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VpsManagementWire.ListCollectionsResponseProto.getDefaultInstance()));
    METHOD_LIST_TRAJECTORIES = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.vpsmanagement.v1.ManagementService", "ListTrajectories"), ProtoLiteUtils.marshaller(VpsManagementWire.ListTrajectoriesRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(VpsManagementWire.ListTrajectoriesResponseProto.getDefaultInstance()));
  }
  
  public static ServiceDescriptor getServiceDescriptor()
  {
    return new ServiceDescriptor("google.internal.tango.vpsmanagement.v1.ManagementService", new MethodDescriptor[] { METHOD_LIST_LOCALIZATION_RESULTS, METHOD_LIST_COLLECTIONS, METHOD_LIST_TRAJECTORIES, METHOD_LIST_MAP_OBJECTS });
  }
  
  public static ManagementServiceBlockingStub newBlockingStub(Channel paramChannel)
  {
    return new ManagementServiceBlockingStub(paramChannel, null);
  }
  
  public static ManagementServiceFutureStub newFutureStub(Channel paramChannel)
  {
    return new ManagementServiceFutureStub(paramChannel, null);
  }
  
  public static ManagementServiceStub newStub(Channel paramChannel)
  {
    return new ManagementServiceStub(paramChannel, null);
  }
  
  public static final class ManagementServiceBlockingStub
    extends AbstractStub<ManagementServiceBlockingStub>
  {
    private ManagementServiceBlockingStub(Channel paramChannel)
    {
      super();
    }
    
    private ManagementServiceBlockingStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected ManagementServiceBlockingStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new ManagementServiceBlockingStub(paramChannel, paramCallOptions);
    }
    
    public VpsManagementWire.ListCollectionsResponseProto listCollections(VpsManagementWire.ListCollectionsRequestProto paramListCollectionsRequestProto)
    {
      return (VpsManagementWire.ListCollectionsResponseProto)ClientCalls.blockingUnaryCall(getChannel(), ManagementServiceGrpc.METHOD_LIST_COLLECTIONS, getCallOptions(), paramListCollectionsRequestProto);
    }
    
    public VpsManagementWire.ListLocalizationResultsResponseProto listLocalizationResults(VpsManagementWire.ListLocalizationResultsRequestProto paramListLocalizationResultsRequestProto)
    {
      return (VpsManagementWire.ListLocalizationResultsResponseProto)ClientCalls.blockingUnaryCall(getChannel(), ManagementServiceGrpc.METHOD_LIST_LOCALIZATION_RESULTS, getCallOptions(), paramListLocalizationResultsRequestProto);
    }
    
    public VpsManagementWire.ListMapObjectsResponseProto listMapObjects(VpsManagementWire.ListMapObjectsRequestProto paramListMapObjectsRequestProto)
    {
      return (VpsManagementWire.ListMapObjectsResponseProto)ClientCalls.blockingUnaryCall(getChannel(), ManagementServiceGrpc.METHOD_LIST_MAP_OBJECTS, getCallOptions(), paramListMapObjectsRequestProto);
    }
    
    public VpsManagementWire.ListTrajectoriesResponseProto listTrajectories(VpsManagementWire.ListTrajectoriesRequestProto paramListTrajectoriesRequestProto)
    {
      return (VpsManagementWire.ListTrajectoriesResponseProto)ClientCalls.blockingUnaryCall(getChannel(), ManagementServiceGrpc.METHOD_LIST_TRAJECTORIES, getCallOptions(), paramListTrajectoriesRequestProto);
    }
  }
  
  public static final class ManagementServiceFutureStub
    extends AbstractStub<ManagementServiceFutureStub>
  {
    private ManagementServiceFutureStub(Channel paramChannel)
    {
      super();
    }
    
    private ManagementServiceFutureStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected ManagementServiceFutureStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new ManagementServiceFutureStub(paramChannel, paramCallOptions);
    }
    
    public ListenableFuture<VpsManagementWire.ListCollectionsResponseProto> listCollections(VpsManagementWire.ListCollectionsRequestProto paramListCollectionsRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_COLLECTIONS, getCallOptions()), paramListCollectionsRequestProto);
    }
    
    public ListenableFuture<VpsManagementWire.ListLocalizationResultsResponseProto> listLocalizationResults(VpsManagementWire.ListLocalizationResultsRequestProto paramListLocalizationResultsRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_LOCALIZATION_RESULTS, getCallOptions()), paramListLocalizationResultsRequestProto);
    }
    
    public ListenableFuture<VpsManagementWire.ListMapObjectsResponseProto> listMapObjects(VpsManagementWire.ListMapObjectsRequestProto paramListMapObjectsRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_MAP_OBJECTS, getCallOptions()), paramListMapObjectsRequestProto);
    }
    
    public ListenableFuture<VpsManagementWire.ListTrajectoriesResponseProto> listTrajectories(VpsManagementWire.ListTrajectoriesRequestProto paramListTrajectoriesRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_TRAJECTORIES, getCallOptions()), paramListTrajectoriesRequestProto);
    }
  }
  
  public static abstract class ManagementServiceImplBase
    implements BindableService
  {
    public ServerServiceDefinition bindService()
    {
      return ServerServiceDefinition.builder(ManagementServiceGrpc.getServiceDescriptor()).addMethod(ManagementServiceGrpc.METHOD_LIST_LOCALIZATION_RESULTS, ServerCalls.asyncUnaryCall(new ManagementServiceGrpc.MethodHandlers(this, 0))).addMethod(ManagementServiceGrpc.METHOD_LIST_COLLECTIONS, ServerCalls.asyncUnaryCall(new ManagementServiceGrpc.MethodHandlers(this, 1))).addMethod(ManagementServiceGrpc.METHOD_LIST_TRAJECTORIES, ServerCalls.asyncUnaryCall(new ManagementServiceGrpc.MethodHandlers(this, 2))).addMethod(ManagementServiceGrpc.METHOD_LIST_MAP_OBJECTS, ServerCalls.asyncUnaryCall(new ManagementServiceGrpc.MethodHandlers(this, 3))).build();
    }
    
    public void listCollections(VpsManagementWire.ListCollectionsRequestProto paramListCollectionsRequestProto, StreamObserver<VpsManagementWire.ListCollectionsResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(ManagementServiceGrpc.METHOD_LIST_COLLECTIONS, paramStreamObserver);
    }
    
    public void listLocalizationResults(VpsManagementWire.ListLocalizationResultsRequestProto paramListLocalizationResultsRequestProto, StreamObserver<VpsManagementWire.ListLocalizationResultsResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(ManagementServiceGrpc.METHOD_LIST_LOCALIZATION_RESULTS, paramStreamObserver);
    }
    
    public void listMapObjects(VpsManagementWire.ListMapObjectsRequestProto paramListMapObjectsRequestProto, StreamObserver<VpsManagementWire.ListMapObjectsResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(ManagementServiceGrpc.METHOD_LIST_MAP_OBJECTS, paramStreamObserver);
    }
    
    public void listTrajectories(VpsManagementWire.ListTrajectoriesRequestProto paramListTrajectoriesRequestProto, StreamObserver<VpsManagementWire.ListTrajectoriesResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(ManagementServiceGrpc.METHOD_LIST_TRAJECTORIES, paramStreamObserver);
    }
  }
  
  public static final class ManagementServiceStub
    extends AbstractStub<ManagementServiceStub>
  {
    private ManagementServiceStub(Channel paramChannel)
    {
      super();
    }
    
    private ManagementServiceStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected ManagementServiceStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new ManagementServiceStub(paramChannel, paramCallOptions);
    }
    
    public void listCollections(VpsManagementWire.ListCollectionsRequestProto paramListCollectionsRequestProto, StreamObserver<VpsManagementWire.ListCollectionsResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_COLLECTIONS, getCallOptions()), paramListCollectionsRequestProto, paramStreamObserver);
    }
    
    public void listLocalizationResults(VpsManagementWire.ListLocalizationResultsRequestProto paramListLocalizationResultsRequestProto, StreamObserver<VpsManagementWire.ListLocalizationResultsResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_LOCALIZATION_RESULTS, getCallOptions()), paramListLocalizationResultsRequestProto, paramStreamObserver);
    }
    
    public void listMapObjects(VpsManagementWire.ListMapObjectsRequestProto paramListMapObjectsRequestProto, StreamObserver<VpsManagementWire.ListMapObjectsResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_MAP_OBJECTS, getCallOptions()), paramListMapObjectsRequestProto, paramStreamObserver);
    }
    
    public void listTrajectories(VpsManagementWire.ListTrajectoriesRequestProto paramListTrajectoriesRequestProto, StreamObserver<VpsManagementWire.ListTrajectoriesResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(ManagementServiceGrpc.METHOD_LIST_TRAJECTORIES, getCallOptions()), paramListTrajectoriesRequestProto, paramStreamObserver);
    }
  }
  
  private static class MethodHandlers<Req, Resp>
    implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp>
  {
    private final int methodId;
    private final ManagementServiceGrpc.ManagementServiceImplBase serviceImpl;
    
    public MethodHandlers(ManagementServiceGrpc.ManagementServiceImplBase paramManagementServiceImplBase, int paramInt)
    {
      this.serviceImpl = paramManagementServiceImplBase;
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
        this.serviceImpl.listLocalizationResults((VpsManagementWire.ListLocalizationResultsRequestProto)paramReq, paramStreamObserver);
        return;
      case 1: 
        this.serviceImpl.listCollections((VpsManagementWire.ListCollectionsRequestProto)paramReq, paramStreamObserver);
        return;
      case 2: 
        this.serviceImpl.listTrajectories((VpsManagementWire.ListTrajectoriesRequestProto)paramReq, paramStreamObserver);
        return;
      }
      this.serviceImpl.listMapObjects((VpsManagementWire.ListMapObjectsRequestProto)paramReq, paramStreamObserver);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/vpsmanagement/v1/ManagementServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */