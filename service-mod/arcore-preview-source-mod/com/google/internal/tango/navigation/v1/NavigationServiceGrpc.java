package com.google.internal.tango.navigation.v1;

import com.google.common.util.concurrent.ListenableFuture;
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

public class NavigationServiceGrpc
{
  private static final int METHODID_GET_DIRECTIONS = 0;
  public static final MethodDescriptor<GetDirectionsRequest, Directions> METHOD_GET_DIRECTIONS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.navigation.v1.NavigationService", "GetDirections"), ProtoLiteUtils.marshaller(GetDirectionsRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(Directions.getDefaultInstance()));
  public static final String SERVICE_NAME = "google.internal.tango.navigation.v1.NavigationService";
  
  public static ServiceDescriptor getServiceDescriptor()
  {
    return new ServiceDescriptor("google.internal.tango.navigation.v1.NavigationService", new MethodDescriptor[] { METHOD_GET_DIRECTIONS });
  }
  
  public static NavigationServiceBlockingStub newBlockingStub(Channel paramChannel)
  {
    return new NavigationServiceBlockingStub(paramChannel, null);
  }
  
  public static NavigationServiceFutureStub newFutureStub(Channel paramChannel)
  {
    return new NavigationServiceFutureStub(paramChannel, null);
  }
  
  public static NavigationServiceStub newStub(Channel paramChannel)
  {
    return new NavigationServiceStub(paramChannel, null);
  }
  
  private static class MethodHandlers<Req, Resp>
    implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp>
  {
    private final int methodId;
    private final NavigationServiceGrpc.NavigationServiceImplBase serviceImpl;
    
    public MethodHandlers(NavigationServiceGrpc.NavigationServiceImplBase paramNavigationServiceImplBase, int paramInt)
    {
      this.serviceImpl = paramNavigationServiceImplBase;
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
      }
      this.serviceImpl.getDirections((GetDirectionsRequest)paramReq, paramStreamObserver);
    }
  }
  
  public static final class NavigationServiceBlockingStub
    extends AbstractStub<NavigationServiceBlockingStub>
  {
    private NavigationServiceBlockingStub(Channel paramChannel)
    {
      super();
    }
    
    private NavigationServiceBlockingStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected NavigationServiceBlockingStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new NavigationServiceBlockingStub(paramChannel, paramCallOptions);
    }
    
    public Directions getDirections(GetDirectionsRequest paramGetDirectionsRequest)
    {
      return (Directions)ClientCalls.blockingUnaryCall(getChannel(), NavigationServiceGrpc.METHOD_GET_DIRECTIONS, getCallOptions(), paramGetDirectionsRequest);
    }
  }
  
  public static final class NavigationServiceFutureStub
    extends AbstractStub<NavigationServiceFutureStub>
  {
    private NavigationServiceFutureStub(Channel paramChannel)
    {
      super();
    }
    
    private NavigationServiceFutureStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected NavigationServiceFutureStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new NavigationServiceFutureStub(paramChannel, paramCallOptions);
    }
    
    public ListenableFuture<Directions> getDirections(GetDirectionsRequest paramGetDirectionsRequest)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(NavigationServiceGrpc.METHOD_GET_DIRECTIONS, getCallOptions()), paramGetDirectionsRequest);
    }
  }
  
  public static abstract class NavigationServiceImplBase
    implements BindableService
  {
    public ServerServiceDefinition bindService()
    {
      return ServerServiceDefinition.builder(NavigationServiceGrpc.getServiceDescriptor()).addMethod(NavigationServiceGrpc.METHOD_GET_DIRECTIONS, ServerCalls.asyncUnaryCall(new NavigationServiceGrpc.MethodHandlers(this, 0))).build();
    }
    
    public void getDirections(GetDirectionsRequest paramGetDirectionsRequest, StreamObserver<Directions> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(NavigationServiceGrpc.METHOD_GET_DIRECTIONS, paramStreamObserver);
    }
  }
  
  public static final class NavigationServiceStub
    extends AbstractStub<NavigationServiceStub>
  {
    private NavigationServiceStub(Channel paramChannel)
    {
      super();
    }
    
    private NavigationServiceStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected NavigationServiceStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new NavigationServiceStub(paramChannel, paramCallOptions);
    }
    
    public void getDirections(GetDirectionsRequest paramGetDirectionsRequest, StreamObserver<Directions> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(NavigationServiceGrpc.METHOD_GET_DIRECTIONS, getCallOptions()), paramGetDirectionsRequest, paramStreamObserver);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/NavigationServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */