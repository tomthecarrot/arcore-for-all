package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ClientCalls
{
  private static final Logger log = Logger.getLogger(ClientCalls.class.getName());
  
  public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver)
  {
    return asyncStreamingRequestCall(paramClientCall, paramStreamObserver, true);
  }
  
  public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver)
  {
    return asyncStreamingRequestCall(paramClientCall, paramStreamObserver, false);
  }
  
  public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver)
  {
    asyncUnaryRequestCall(paramClientCall, paramReqT, paramStreamObserver, true);
  }
  
  private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver, boolean paramBoolean)
  {
    CallToStreamObserverAdapter localCallToStreamObserverAdapter = new CallToStreamObserverAdapter(paramClientCall);
    startCall(paramClientCall, new StreamObserverToCallListenerAdapter(paramClientCall, paramStreamObserver, localCallToStreamObserverAdapter, paramBoolean), paramBoolean);
    return localCallToStreamObserverAdapter;
  }
  
  public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver)
  {
    asyncUnaryRequestCall(paramClientCall, paramReqT, paramStreamObserver, false);
  }
  
  private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, ClientCall.Listener<RespT> paramListener, boolean paramBoolean)
  {
    startCall(paramClientCall, paramListener, paramBoolean);
    try
    {
      paramClientCall.sendMessage(paramReqT);
      paramClientCall.halfClose();
      return;
    }
    catch (Throwable paramReqT)
    {
      paramClientCall.cancel(null, paramReqT);
      if (!(paramReqT instanceof RuntimeException)) {}
    }
    for (paramClientCall = (RuntimeException)paramReqT;; paramClientCall = new RuntimeException(paramReqT)) {
      throw paramClientCall;
    }
  }
  
  private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver, boolean paramBoolean)
  {
    asyncUnaryRequestCall(paramClientCall, paramReqT, new StreamObserverToCallListenerAdapter(paramClientCall, paramStreamObserver, new CallToStreamObserverAdapter(paramClientCall), paramBoolean), paramBoolean);
  }
  
  public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel paramChannel, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, ReqT paramReqT)
  {
    ThreadlessExecutor localThreadlessExecutor = new ThreadlessExecutor(null);
    paramChannel = paramChannel.newCall(paramMethodDescriptor, paramCallOptions.withExecutor(localThreadlessExecutor));
    paramMethodDescriptor = new BlockingResponseStream(paramChannel, localThreadlessExecutor, null);
    asyncUnaryRequestCall(paramChannel, paramReqT, paramMethodDescriptor.listener(), true);
    return paramMethodDescriptor;
  }
  
  public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT)
  {
    BlockingResponseStream localBlockingResponseStream = new BlockingResponseStream(paramClientCall, null);
    asyncUnaryRequestCall(paramClientCall, paramReqT, localBlockingResponseStream.listener(), true);
    return localBlockingResponseStream;
  }
  
  public static <ReqT, RespT> RespT blockingUnaryCall(Channel paramChannel, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, ReqT paramReqT)
  {
    ThreadlessExecutor localThreadlessExecutor = new ThreadlessExecutor(null);
    paramChannel = paramChannel.newCall(paramMethodDescriptor, paramCallOptions.withExecutor(localThreadlessExecutor));
    try
    {
      paramMethodDescriptor = futureUnaryCall(paramChannel, paramReqT);
      for (;;)
      {
        boolean bool = paramMethodDescriptor.isDone();
        if (bool) {
          break label88;
        }
        try
        {
          localThreadlessExecutor.waitAndDrain();
        }
        catch (InterruptedException paramMethodDescriptor)
        {
          Thread.currentThread().interrupt();
          throw Status.CANCELLED.withCause(paramMethodDescriptor).asRuntimeException();
        }
      }
      paramChannel = (RuntimeException)paramMethodDescriptor;
    }
    catch (Throwable paramMethodDescriptor)
    {
      paramChannel.cancel(null, paramMethodDescriptor);
      if (!(paramMethodDescriptor instanceof RuntimeException)) {}
    }
    for (;;)
    {
      throw paramChannel;
      label88:
      paramMethodDescriptor = getUnchecked(paramMethodDescriptor);
      return paramMethodDescriptor;
      paramChannel = new RuntimeException(paramMethodDescriptor);
    }
  }
  
  public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT)
  {
    try
    {
      paramReqT = getUnchecked(futureUnaryCall(paramClientCall, paramReqT));
      return paramReqT;
    }
    catch (Throwable paramReqT)
    {
      paramClientCall.cancel(null, paramReqT);
      if (!(paramReqT instanceof RuntimeException)) {}
    }
    for (paramClientCall = (RuntimeException)paramReqT;; paramClientCall = new RuntimeException(paramReqT)) {
      throw paramClientCall;
    }
  }
  
  public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT)
  {
    GrpcFuture localGrpcFuture = new GrpcFuture(paramClientCall);
    asyncUnaryRequestCall(paramClientCall, paramReqT, new UnaryStreamToFuture(localGrpcFuture), false);
    return localGrpcFuture;
  }
  
  private static <V> V getUnchecked(Future<V> paramFuture)
  {
    try
    {
      paramFuture = paramFuture.get();
      return paramFuture;
    }
    catch (InterruptedException paramFuture)
    {
      Thread.currentThread().interrupt();
      throw Status.CANCELLED.withCause(paramFuture).asRuntimeException();
    }
    catch (ExecutionException paramFuture)
    {
      throw toStatusRuntimeException(paramFuture);
    }
  }
  
  private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> paramClientCall, ClientCall.Listener<RespT> paramListener, boolean paramBoolean)
  {
    paramClientCall.start(paramListener, new Metadata());
    if (paramBoolean)
    {
      paramClientCall.request(1);
      return;
    }
    paramClientCall.request(2);
  }
  
  private static StatusRuntimeException toStatusRuntimeException(Throwable paramThrowable)
  {
    for (Throwable localThrowable = (Throwable)Preconditions.checkNotNull(paramThrowable, "t"); localThrowable != null; localThrowable = localThrowable.getCause())
    {
      if ((localThrowable instanceof StatusException))
      {
        paramThrowable = (StatusException)localThrowable;
        return new StatusRuntimeException(paramThrowable.getStatus(), paramThrowable.getTrailers());
      }
      if ((localThrowable instanceof StatusRuntimeException))
      {
        paramThrowable = (StatusRuntimeException)localThrowable;
        return new StatusRuntimeException(paramThrowable.getStatus(), paramThrowable.getTrailers());
      }
    }
    return Status.UNKNOWN.withCause(paramThrowable).asRuntimeException();
  }
  
  private static class BlockingResponseStream<T>
    implements Iterator<T>
  {
    private final BlockingQueue<Object> buffer = new ArrayBlockingQueue(2);
    private final ClientCall<?, T> call;
    private Object last;
    private final ClientCall.Listener<T> listener = new QueuingListener(null);
    private final ClientCalls.ThreadlessExecutor threadless;
    
    private BlockingResponseStream(ClientCall<?, T> paramClientCall)
    {
      this(paramClientCall, null);
    }
    
    private BlockingResponseStream(ClientCall<?, T> paramClientCall, ClientCalls.ThreadlessExecutor paramThreadlessExecutor)
    {
      this.call = paramClientCall;
      this.threadless = paramThreadlessExecutor;
    }
    
    private Object waitForNext()
      throws InterruptedException
    {
      Object localObject2;
      if (this.threadless == null)
      {
        localObject2 = this.buffer.take();
        return localObject2;
      }
      for (Object localObject1 = this.buffer.poll();; localObject1 = this.buffer.poll())
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        this.threadless.waitAndDrain();
      }
    }
    
    public boolean hasNext()
    {
      if (this.last == null) {}
      try
      {
        this.last = waitForNext();
        if ((this.last instanceof StatusRuntimeException))
        {
          StatusRuntimeException localStatusRuntimeException = (StatusRuntimeException)this.last;
          throw localStatusRuntimeException.getStatus().asRuntimeException(localStatusRuntimeException.getTrailers());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        throw Status.CANCELLED.withCause(localInterruptedException).asRuntimeException();
      }
      return this.last != this;
    }
    
    ClientCall.Listener<T> listener()
    {
      return this.listener;
    }
    
    public T next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      try
      {
        this.call.request(1);
        Object localObject1 = this.last;
        return (T)localObject1;
      }
      finally
      {
        this.last = null;
      }
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
    
    private class QueuingListener
      extends ClientCall.Listener<T>
    {
      private boolean done = false;
      
      private QueuingListener() {}
      
      public void onClose(Status paramStatus, Metadata paramMetadata)
      {
        boolean bool;
        if (!this.done)
        {
          bool = true;
          Preconditions.checkState(bool, "ClientCall already closed");
          if (!paramStatus.isOk()) {
            break label50;
          }
          ClientCalls.BlockingResponseStream.this.buffer.add(ClientCalls.BlockingResponseStream.this);
        }
        for (;;)
        {
          this.done = true;
          return;
          bool = false;
          break;
          label50:
          ClientCalls.BlockingResponseStream.this.buffer.add(paramStatus.asRuntimeException(paramMetadata));
        }
      }
      
      public void onHeaders(Metadata paramMetadata) {}
      
      public void onMessage(T paramT)
      {
        if (!this.done) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkState(bool, "ClientCall already closed");
          ClientCalls.BlockingResponseStream.this.buffer.add(paramT);
          return;
        }
      }
    }
  }
  
  private static class CallToStreamObserverAdapter<T>
    extends ClientCallStreamObserver<T>
  {
    private boolean autoFlowControlEnabled = true;
    private final ClientCall<T, ?> call;
    private boolean frozen;
    private Runnable onReadyHandler;
    
    public CallToStreamObserverAdapter(ClientCall<T, ?> paramClientCall)
    {
      this.call = paramClientCall;
    }
    
    private void freeze()
    {
      this.frozen = true;
    }
    
    public void disableAutoInboundFlowControl()
    {
      if (this.frozen) {
        throw new IllegalStateException("Cannot disable auto flow control call started");
      }
      this.autoFlowControlEnabled = false;
    }
    
    public boolean isReady()
    {
      return this.call.isReady();
    }
    
    public void onCompleted()
    {
      this.call.halfClose();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.call.cancel("Cancelled by client with StreamObserver.onError()", paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.call.sendMessage(paramT);
    }
    
    public void request(int paramInt)
    {
      this.call.request(paramInt);
    }
    
    public void setMessageCompression(boolean paramBoolean)
    {
      this.call.setMessageCompression(paramBoolean);
    }
    
    public void setOnReadyHandler(Runnable paramRunnable)
    {
      if (this.frozen) {
        throw new IllegalStateException("Cannot alter onReadyHandler after call started");
      }
      this.onReadyHandler = paramRunnable;
    }
  }
  
  private static class GrpcFuture<RespT>
    extends AbstractFuture<RespT>
  {
    private final ClientCall<?, RespT> call;
    
    GrpcFuture(ClientCall<?, RespT> paramClientCall)
    {
      this.call = paramClientCall;
    }
    
    protected void interruptTask()
    {
      this.call.cancel("GrpcFuture was cancelled", null);
    }
    
    protected boolean set(@Nullable RespT paramRespT)
    {
      return super.set(paramRespT);
    }
    
    protected boolean setException(Throwable paramThrowable)
    {
      return super.setException(paramThrowable);
    }
  }
  
  private static class StreamObserverToCallListenerAdapter<ReqT, RespT>
    extends ClientCall.Listener<RespT>
  {
    private final ClientCalls.CallToStreamObserverAdapter<ReqT> adapter;
    private final ClientCall<ReqT, RespT> call;
    private boolean firstResponseReceived;
    private final StreamObserver<RespT> observer;
    private final boolean streamingResponse;
    
    StreamObserverToCallListenerAdapter(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver, ClientCalls.CallToStreamObserverAdapter<ReqT> paramCallToStreamObserverAdapter, boolean paramBoolean)
    {
      this.call = paramClientCall;
      this.observer = paramStreamObserver;
      this.streamingResponse = paramBoolean;
      this.adapter = paramCallToStreamObserverAdapter;
      if ((paramStreamObserver instanceof ClientResponseObserver)) {
        ((ClientResponseObserver)paramStreamObserver).beforeStart(paramCallToStreamObserverAdapter);
      }
      paramCallToStreamObserverAdapter.freeze();
    }
    
    public void onClose(Status paramStatus, Metadata paramMetadata)
    {
      if (paramStatus.isOk())
      {
        this.observer.onCompleted();
        return;
      }
      this.observer.onError(paramStatus.asRuntimeException(paramMetadata));
    }
    
    public void onHeaders(Metadata paramMetadata) {}
    
    public void onMessage(RespT paramRespT)
    {
      if ((this.firstResponseReceived) && (!this.streamingResponse)) {
        throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
      }
      this.firstResponseReceived = true;
      this.observer.onNext(paramRespT);
      if ((this.streamingResponse) && (this.adapter.autoFlowControlEnabled)) {
        this.call.request(1);
      }
    }
    
    public void onReady()
    {
      if (this.adapter.onReadyHandler != null) {
        this.adapter.onReadyHandler.run();
      }
    }
  }
  
  private static class ThreadlessExecutor
    implements Executor
  {
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue();
    
    public void execute(Runnable paramRunnable)
    {
      this.queue.add(paramRunnable);
    }
    
    public void waitAndDrain()
      throws InterruptedException
    {
      Runnable localRunnable = (Runnable)this.queue.take();
      for (;;)
      {
        if (localRunnable != null) {
          try
          {
            localRunnable.run();
            localRunnable = (Runnable)this.queue.poll();
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ClientCalls.log.log(Level.WARNING, "Runnable threw exception", localThrowable);
            }
          }
        }
      }
    }
  }
  
  private static class UnaryStreamToFuture<RespT>
    extends ClientCall.Listener<RespT>
  {
    private final ClientCalls.GrpcFuture<RespT> responseFuture;
    private RespT value;
    
    public UnaryStreamToFuture(ClientCalls.GrpcFuture<RespT> paramGrpcFuture)
    {
      this.responseFuture = paramGrpcFuture;
    }
    
    public void onClose(Status paramStatus, Metadata paramMetadata)
    {
      if (paramStatus.isOk())
      {
        if (this.value == null) {
          this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(paramMetadata));
        }
        this.responseFuture.set(this.value);
        return;
      }
      this.responseFuture.setException(paramStatus.asRuntimeException(paramMetadata));
    }
    
    public void onHeaders(Metadata paramMetadata) {}
    
    public void onMessage(RespT paramRespT)
    {
      if (this.value != null) {
        throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
      }
      this.value = paramRespT;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/ClientCalls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */