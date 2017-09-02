package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

public final class ServerCalls
{
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> paramBidiStreamingMethod)
  {
    return asyncStreamingRequestCall(paramBidiStreamingMethod);
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> paramClientStreamingMethod)
  {
    return asyncStreamingRequestCall(paramClientStreamingMethod);
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> paramServerStreamingMethod)
  {
    return asyncUnaryRequestCall(paramServerStreamingMethod);
  }
  
  private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncStreamingRequestCall(StreamingRequestMethod<ReqT, RespT> paramStreamingRequestMethod)
  {
    new ServerCallHandler()
    {
      public ServerCall.Listener<ReqT> startCall(final ServerCall<ReqT, RespT> paramAnonymousServerCall, final Metadata paramAnonymousMetadata)
      {
        paramAnonymousMetadata = new ServerCalls.ServerCallStreamObserverImpl(paramAnonymousServerCall);
        final StreamObserver localStreamObserver = ServerCalls.this.invoke(paramAnonymousMetadata);
        ServerCalls.ServerCallStreamObserverImpl.access$100(paramAnonymousMetadata);
        if (ServerCalls.ServerCallStreamObserverImpl.access$400(paramAnonymousMetadata)) {
          paramAnonymousServerCall.request(1);
        }
        new ServerCalls.EmptyServerCallListener(localStreamObserver)
        {
          boolean halfClosed = false;
          
          public void onCancel()
          {
            paramAnonymousMetadata.cancelled = true;
            if (ServerCalls.ServerCallStreamObserverImpl.access$200(paramAnonymousMetadata) != null) {
              ServerCalls.ServerCallStreamObserverImpl.access$200(paramAnonymousMetadata).run();
            }
            if (!this.halfClosed) {
              localStreamObserver.onError(Status.CANCELLED.asException());
            }
          }
          
          public void onHalfClose()
          {
            this.halfClosed = true;
            localStreamObserver.onCompleted();
          }
          
          public void onMessage(ReqT paramAnonymous2ReqT)
          {
            localStreamObserver.onNext(paramAnonymous2ReqT);
            if (ServerCalls.ServerCallStreamObserverImpl.access$400(paramAnonymousMetadata)) {
              paramAnonymousServerCall.request(1);
            }
          }
          
          public void onReady()
          {
            if (ServerCalls.ServerCallStreamObserverImpl.access$300(paramAnonymousMetadata) != null) {
              ServerCalls.ServerCallStreamObserverImpl.access$300(paramAnonymousMetadata).run();
            }
          }
        };
      }
    };
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> paramUnaryMethod)
  {
    return asyncUnaryRequestCall(paramUnaryMethod);
  }
  
  private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryRequestCall(UnaryRequestMethod<ReqT, RespT> paramUnaryRequestMethod)
  {
    new ServerCallHandler()
    {
      public ServerCall.Listener<ReqT> startCall(final ServerCall<ReqT, RespT> paramAnonymousServerCall, final Metadata paramAnonymousMetadata)
      {
        paramAnonymousMetadata = new ServerCalls.ServerCallStreamObserverImpl(paramAnonymousServerCall);
        paramAnonymousServerCall.request(2);
        new ServerCalls.EmptyServerCallListener(paramAnonymousMetadata)
        {
          ReqT request;
          
          public void onCancel()
          {
            paramAnonymousMetadata.cancelled = true;
            if (ServerCalls.ServerCallStreamObserverImpl.access$200(paramAnonymousMetadata) != null) {
              ServerCalls.ServerCallStreamObserverImpl.access$200(paramAnonymousMetadata).run();
            }
          }
          
          public void onHalfClose()
          {
            if (this.request != null)
            {
              ServerCalls.this.invoke(this.request, paramAnonymousMetadata);
              ServerCalls.ServerCallStreamObserverImpl.access$100(paramAnonymousMetadata);
              if (paramAnonymousServerCall.isReady()) {
                onReady();
              }
              return;
            }
            paramAnonymousServerCall.close(Status.INTERNAL.withDescription("Half-closed without a request"), new Metadata());
          }
          
          public void onMessage(ReqT paramAnonymous2ReqT)
          {
            this.request = paramAnonymous2ReqT;
          }
          
          public void onReady()
          {
            if (ServerCalls.ServerCallStreamObserverImpl.access$300(paramAnonymousMetadata) != null) {
              ServerCalls.ServerCallStreamObserverImpl.access$300(paramAnonymousMetadata).run();
            }
          }
        };
      }
    };
  }
  
  public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> paramMethodDescriptor, StreamObserver<?> paramStreamObserver)
  {
    asyncUnimplementedUnaryCall(paramMethodDescriptor, paramStreamObserver);
    return new NoopStreamObserver();
  }
  
  public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> paramMethodDescriptor, StreamObserver<?> paramStreamObserver)
  {
    Preconditions.checkNotNull(paramMethodDescriptor, "methodDescriptor");
    Preconditions.checkNotNull(paramStreamObserver, "responseObserver");
    paramStreamObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", new Object[] { paramMethodDescriptor.getFullMethodName() })).asException());
  }
  
  public static abstract interface BidiStreamingMethod<ReqT, RespT>
    extends ServerCalls.StreamingRequestMethod<ReqT, RespT>
  {}
  
  public static abstract interface ClientStreamingMethod<ReqT, RespT>
    extends ServerCalls.StreamingRequestMethod<ReqT, RespT>
  {}
  
  private static class EmptyServerCallListener<ReqT>
    extends ServerCall.Listener<ReqT>
  {
    public void onCancel() {}
    
    public void onComplete() {}
    
    public void onHalfClose() {}
    
    public void onMessage(ReqT paramReqT) {}
  }
  
  static class NoopStreamObserver<V>
    implements StreamObserver<V>
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onNext(V paramV) {}
  }
  
  private static final class ServerCallStreamObserverImpl<ReqT, RespT>
    extends ServerCallStreamObserver<RespT>
  {
    private boolean autoFlowControlEnabled = true;
    final ServerCall<ReqT, RespT> call;
    volatile boolean cancelled;
    private boolean frozen;
    private Runnable onCancelHandler;
    private Runnable onReadyHandler;
    private boolean sentHeaders;
    
    ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> paramServerCall)
    {
      this.call = paramServerCall;
    }
    
    private void freeze()
    {
      this.frozen = true;
    }
    
    public void disableAutoInboundFlowControl()
    {
      if (this.frozen) {
        throw new IllegalStateException("Cannot disable auto flow control after initialization");
      }
      this.autoFlowControlEnabled = false;
    }
    
    public boolean isCancelled()
    {
      return this.call.isCancelled();
    }
    
    public boolean isReady()
    {
      return this.call.isReady();
    }
    
    public void onCompleted()
    {
      if (this.cancelled) {
        throw Status.CANCELLED.asRuntimeException();
      }
      this.call.close(Status.OK, new Metadata());
    }
    
    public void onError(Throwable paramThrowable)
    {
      Metadata localMetadata2 = Status.trailersFromThrowable(paramThrowable);
      Metadata localMetadata1 = localMetadata2;
      if (localMetadata2 == null) {
        localMetadata1 = new Metadata();
      }
      this.call.close(Status.fromThrowable(paramThrowable), localMetadata1);
    }
    
    public void onNext(RespT paramRespT)
    {
      if (this.cancelled) {
        throw Status.CANCELLED.asRuntimeException();
      }
      if (!this.sentHeaders)
      {
        this.call.sendHeaders(new Metadata());
        this.sentHeaders = true;
      }
      this.call.sendMessage(paramRespT);
    }
    
    public void request(int paramInt)
    {
      this.call.request(paramInt);
    }
    
    public void setCompression(String paramString)
    {
      this.call.setCompression(paramString);
    }
    
    public void setMessageCompression(boolean paramBoolean)
    {
      this.call.setMessageCompression(paramBoolean);
    }
    
    public void setOnCancelHandler(Runnable paramRunnable)
    {
      if (this.frozen) {
        throw new IllegalStateException("Cannot alter onCancelHandler after initialization");
      }
      this.onCancelHandler = paramRunnable;
    }
    
    public void setOnReadyHandler(Runnable paramRunnable)
    {
      if (this.frozen) {
        throw new IllegalStateException("Cannot alter onReadyHandler after initialization");
      }
      this.onReadyHandler = paramRunnable;
    }
  }
  
  public static abstract interface ServerStreamingMethod<ReqT, RespT>
    extends ServerCalls.UnaryRequestMethod<ReqT, RespT>
  {}
  
  private static abstract interface StreamingRequestMethod<ReqT, RespT>
  {
    public abstract StreamObserver<ReqT> invoke(StreamObserver<RespT> paramStreamObserver);
  }
  
  public static abstract interface UnaryMethod<ReqT, RespT>
    extends ServerCalls.UnaryRequestMethod<ReqT, RespT>
  {}
  
  private static abstract interface UnaryRequestMethod<ReqT, RespT>
  {
    public abstract void invoke(ReqT paramReqT, StreamObserver<RespT> paramStreamObserver);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/ServerCalls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */