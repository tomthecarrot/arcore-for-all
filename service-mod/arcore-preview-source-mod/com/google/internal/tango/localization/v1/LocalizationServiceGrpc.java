package com.google.internal.tango.localization.v1;

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

public class LocalizationServiceGrpc
{
  private static final int METHODID_LOCALIZE = 0;
  public static final MethodDescriptor<Model.LocalizeRequestProto, Model.LocalizeResponseProto> METHOD_LOCALIZE = MethodDescriptor.create(MethodDescriptor.MethodType.UNARY, MethodDescriptor.generateFullMethodName("google.internal.tango.localization.v1.LocalizationService", "Localize"), ProtoLiteUtils.marshaller(Model.LocalizeRequestProto.getDefaultInstance()), ProtoLiteUtils.marshaller(Model.LocalizeResponseProto.getDefaultInstance()));
  public static final String SERVICE_NAME = "google.internal.tango.localization.v1.LocalizationService";
  
  public static ServiceDescriptor getServiceDescriptor()
  {
    return new ServiceDescriptor("google.internal.tango.localization.v1.LocalizationService", new MethodDescriptor[] { METHOD_LOCALIZE });
  }
  
  public static LocalizationServiceBlockingStub newBlockingStub(Channel paramChannel)
  {
    return new LocalizationServiceBlockingStub(paramChannel, null);
  }
  
  public static LocalizationServiceFutureStub newFutureStub(Channel paramChannel)
  {
    return new LocalizationServiceFutureStub(paramChannel, null);
  }
  
  public static LocalizationServiceStub newStub(Channel paramChannel)
  {
    return new LocalizationServiceStub(paramChannel, null);
  }
  
  public static final class LocalizationServiceBlockingStub
    extends AbstractStub<LocalizationServiceBlockingStub>
  {
    private LocalizationServiceBlockingStub(Channel paramChannel)
    {
      super();
    }
    
    private LocalizationServiceBlockingStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected LocalizationServiceBlockingStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new LocalizationServiceBlockingStub(paramChannel, paramCallOptions);
    }
    
    public Model.LocalizeResponseProto localize(Model.LocalizeRequestProto paramLocalizeRequestProto)
    {
      return (Model.LocalizeResponseProto)ClientCalls.blockingUnaryCall(getChannel(), LocalizationServiceGrpc.METHOD_LOCALIZE, getCallOptions(), paramLocalizeRequestProto);
    }
  }
  
  public static final class LocalizationServiceFutureStub
    extends AbstractStub<LocalizationServiceFutureStub>
  {
    private LocalizationServiceFutureStub(Channel paramChannel)
    {
      super();
    }
    
    private LocalizationServiceFutureStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected LocalizationServiceFutureStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new LocalizationServiceFutureStub(paramChannel, paramCallOptions);
    }
    
    public ListenableFuture<Model.LocalizeResponseProto> localize(Model.LocalizeRequestProto paramLocalizeRequestProto)
    {
      return ClientCalls.futureUnaryCall(getChannel().newCall(LocalizationServiceGrpc.METHOD_LOCALIZE, getCallOptions()), paramLocalizeRequestProto);
    }
  }
  
  public static abstract class LocalizationServiceImplBase
    implements BindableService
  {
    public ServerServiceDefinition bindService()
    {
      return ServerServiceDefinition.builder(LocalizationServiceGrpc.getServiceDescriptor()).addMethod(LocalizationServiceGrpc.METHOD_LOCALIZE, ServerCalls.asyncUnaryCall(new LocalizationServiceGrpc.MethodHandlers(this, 0))).build();
    }
    
    public void localize(Model.LocalizeRequestProto paramLocalizeRequestProto, StreamObserver<Model.LocalizeResponseProto> paramStreamObserver)
    {
      ServerCalls.asyncUnimplementedUnaryCall(LocalizationServiceGrpc.METHOD_LOCALIZE, paramStreamObserver);
    }
  }
  
  public static final class LocalizationServiceStub
    extends AbstractStub<LocalizationServiceStub>
  {
    private LocalizationServiceStub(Channel paramChannel)
    {
      super();
    }
    
    private LocalizationServiceStub(Channel paramChannel, CallOptions paramCallOptions)
    {
      super(paramCallOptions);
    }
    
    protected LocalizationServiceStub build(Channel paramChannel, CallOptions paramCallOptions)
    {
      return new LocalizationServiceStub(paramChannel, paramCallOptions);
    }
    
    public void localize(Model.LocalizeRequestProto paramLocalizeRequestProto, StreamObserver<Model.LocalizeResponseProto> paramStreamObserver)
    {
      ClientCalls.asyncUnaryCall(getChannel().newCall(LocalizationServiceGrpc.METHOD_LOCALIZE, getCallOptions()), paramLocalizeRequestProto, paramStreamObserver);
    }
  }
  
  private static class MethodHandlers<Req, Resp>
    implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp>
  {
    private final int methodId;
    private final LocalizationServiceGrpc.LocalizationServiceImplBase serviceImpl;
    
    public MethodHandlers(LocalizationServiceGrpc.LocalizationServiceImplBase paramLocalizationServiceImplBase, int paramInt)
    {
      this.serviceImpl = paramLocalizationServiceImplBase;
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
      this.serviceImpl.localize((Model.LocalizeRequestProto)paramReq, paramStreamObserver);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/localization/v1/LocalizationServiceGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */