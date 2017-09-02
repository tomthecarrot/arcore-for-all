package io.grpc.internal;

import io.grpc.Context;

abstract class ContextRunnable
  implements Runnable
{
  private final Context context;
  
  public ContextRunnable(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void run()
  {
    Context localContext = this.context.attach();
    try
    {
      runInContext();
      return;
    }
    finally
    {
      this.context.detach(localContext);
    }
  }
  
  public abstract void runInContext();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ContextRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */