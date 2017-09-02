package io.grpc;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeoutException;

public final class Contexts
{
  public static <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(Context paramContext, ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata, ServerCallHandler<ReqT, RespT> paramServerCallHandler)
  {
    Context localContext = paramContext.attach();
    try
    {
      paramServerCall = new ContextualizedServerCallListener(paramServerCallHandler.startCall(paramServerCall, paramMetadata), paramContext);
      return paramServerCall;
    }
    finally
    {
      paramContext.detach(localContext);
    }
  }
  
  public static Status statusFromCancelled(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "context must not be null");
    if (!paramContext.isCancelled()) {
      return null;
    }
    paramContext = paramContext.cancellationCause();
    if (paramContext == null) {
      return Status.CANCELLED;
    }
    if ((paramContext instanceof TimeoutException)) {
      return Status.DEADLINE_EXCEEDED.withDescription(paramContext.getMessage()).withCause(paramContext);
    }
    Status localStatus = Status.fromThrowable(paramContext);
    if ((Status.Code.UNKNOWN.equals(localStatus.getCode())) && (localStatus.getCause() == paramContext)) {
      return Status.CANCELLED.withCause(paramContext);
    }
    return localStatus.withCause(paramContext);
  }
  
  private static class ContextualizedServerCallListener<ReqT>
    extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>
  {
    private final Context context;
    
    public ContextualizedServerCallListener(ServerCall.Listener<ReqT> paramListener, Context paramContext)
    {
      super();
      this.context = paramContext;
    }
    
    public void onCancel()
    {
      Context localContext = this.context.attach();
      try
      {
        super.onCancel();
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
    
    public void onComplete()
    {
      Context localContext = this.context.attach();
      try
      {
        super.onComplete();
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
    
    public void onHalfClose()
    {
      Context localContext = this.context.attach();
      try
      {
        super.onHalfClose();
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
    
    public void onMessage(ReqT paramReqT)
    {
      Context localContext = this.context.attach();
      try
      {
        super.onMessage(paramReqT);
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
    
    public void onReady()
    {
      Context localContext = this.context.attach();
      try
      {
        super.onReady();
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Contexts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */