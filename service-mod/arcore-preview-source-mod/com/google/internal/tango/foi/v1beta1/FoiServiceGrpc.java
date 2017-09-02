package com.google.internal.tango.foi.v1beta1;

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

public class FoiServiceGrpc
{
  private static final int METHODID_GET_FOIS = 1;
  private static final int METHODID_MUTATE_FOIS = 0;
  public static final MethodDescriptor<GetFoisRequest, GetFoisReply> METHOD_GET_FOIS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.foi.v1beta1.FoiService", "GetFois"), ProtoLiteUtils.marshaller(GetFoisRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(GetFoisReply.getDefaultInstance()));
  public static final MethodDescriptor<MutateFoisRequest, MutateFoisReply> METHOD_MUTATE_FOIS = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.foi.v1beta1.FoiService", "MutateFois"), ProtoLiteUtils.marshaller(MutateFoisRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(MutateFoisReply.getDefaultInstance()));
  public static final String SERVICE_NAME = "google.internal.tango.foi.v1beta1.FoiService";
  
  public static ServiceDescriptor getServiceDescriptor()
  {
    return new ServiceDescriptor("google.internal.tango.foi.v1beta1.FoiService", new MethodDescriptor[] { METHOD_MUTATE_FOIS, METHOD_GET_FOIS });
  }
  
  public static FoiServiceBlockingStub newBlockingStub(Channel paramChannel)
  {
    return new FoiServiceBlockingStub(paramChannel, null);
  }
  
  public static FoiServiceFutureStub newFutureStub(Channel paramChannel)
  {
    return new FoiServiceFutureStub(paramChannel, null);
  }
  
  public static FoiServiceStub newStub(Channel paramChannel)
  {
    return new FoiServiceStub(paramChannel, null);
  }
  
  public static final class FoiServiceBlockingStub
    extends AbstractStub<FoiServiceBlockingStub>
  {
    private FoiServiceBlockingStub(Channel paramChannel)
    {
      super();
    }
    
    private FoiServiceBlockingStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected FoiServiceBlockingStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new FoiServiceBlockingStub(paramChannel, paramCallOptions);
    }
    
    public GetFoisReply getFois(GetFoisRequest paramGetFoisRequest)
    {
      return (GetFoisReply)ClientCalls.blockingUnaryCall(getChannel(), FoiServiceGrpc.METHOD_GET_FOIS, getCallOptions(), paramGetFoisRequest);
    }
    
    public MutateFoisReply mutateFois(MutateFoisRequest paramMutateFoisRequest)
    {
      return (MutateFoisReply)ClientCalls.blockingUnaryCall(getChannel(), FoiServiceGrpc.METHOD_MUTATE_FOIS, getCallOptions(), paramMutateFoisRequest);
    }
  }
  
  public static final class FoiServiceFutureStub
    extends AbstractStub<FoiServiceFutureStub>
  {
    private FoiServiceFutureStub(Channel paramChannel)
    {
      super();
    }
    
    private FoiServiceFutureStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected FoiServiceFutureStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new FoiServiceFutureStub(paramChannel, paramCallOptions);
    }
    
    public ListenableFuture<GetFoisReply> getFois(GetFoisRequest paramGetFoisRequest)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FoiServiceGrpc.METHOD_GET_FOIS, getCallOptions()), paramGetFoisRequest);
    }
    
    public ListenableFuture<MutateFoisReply> mutateFois(MutateFoisRequest paramMutateFoisRequest)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FoiServiceGrpc.METHOD_MUTATE_FOIS, getCallOptions()), paramMutateFoisRequest);
    }
  }
  
  public static abstract class FoiServiceImplBase
    implements BindableService
  {
    public ServerServiceDefinition bindService()
    {
      return ServerServiceDefinition.builder(FoiServiceGrpc.getServiceDescriptor()).addMethod(FoiServiceGrpc.METHOD_MUTATE_FOIS, ServerCalls.asyncUnaryCall(new FoiServiceGrpc.MethodHandlers(this, 0))).addMethod(FoiServiceGrpc.METHOD_GET_FOIS, ServerCalls.asyncUnaryCall(new FoiServiceGrpc.MethodHandlers(this, 1))).build();
    }
    
    public void getFois(GetFoisRequest paramGetFoisRequest, StreamObserver<GetFoisReply> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(FoiServiceGrpc.METHOD_GET_FOIS, paramStreamObserver);
    }
    
    public void mutateFois(MutateFoisRequest paramMutateFoisRequest, StreamObserver<MutateFoisReply> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(FoiServiceGrpc.METHOD_MUTATE_FOIS, paramStreamObserver);
    }
  }
  
  public static final class FoiServiceStub
    extends AbstractStub<FoiServiceStub>
  {
    private FoiServiceStub(Channel paramChannel)
    {
      super();
    }
    
    private FoiServiceStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected FoiServiceStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new FoiServiceStub(paramChannel, paramCallOptions);
    }
    
    public void getFois(GetFoisRequest paramGetFoisRequest, StreamObserver<GetFoisReply> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FoiServiceGrpc.METHOD_GET_FOIS, getCallOptions()), paramGetFoisRequest, paramStreamObserver);
    }
    
    public void mutateFois(MutateFoisRequest paramMutateFoisRequest, StreamObserver<MutateFoisReply> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FoiServiceGrpc.METHOD_MUTATE_FOIS, getCallOptions()), paramMutateFoisRequest, paramStreamObserver);
    }
  }
  
  private static class MethodHandlers<Req, Resp>
    implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp>
  {
    private final int methodId;
    private final FoiServiceGrpc.FoiServiceImplBase serviceImpl;
    
    public MethodHandlers(FoiServiceGrpc.FoiServiceImplBase paramFoiServiceImplBase, int paramInt)
    {
      this.serviceImpl = paramFoiServiceImplBase;
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
        this.serviceImpl.mutateFois((MutateFoisRequest)paramReq, paramStreamObserver);
        return;
      }
      this.serviceImpl.getFois((GetFoisRequest)paramReq, paramStreamObserver);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/FoiServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */