package io.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;

final class ThreadLocalContextStorage
  extends Context.Storage
{
  private static final ThreadLocal<Context> localContext = new ThreadLocal();
  private static final Logger log = Logger.getLogger(ThreadLocalContextStorage.class.getName());
  
  public void attach(Context paramContext)
  {
    localContext.set(paramContext);
  }
  
  public Context current()
  {
    return (Context)localContext.get();
  }
  
  public void detach(Context paramContext1, Context paramContext2)
  {
    if (current() != paramContext1) {
      log.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
    }
    attach(paramContext2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ThreadLocalContextStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */