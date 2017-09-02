package io.grpc.internal;

import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class ConnectivityStateManager
{
  private ArrayList<StateCallbackEntry> callbacks;
  private ConnectivityState state;
  
  ConnectivityStateManager(ConnectivityState paramConnectivityState)
  {
    this.state = paramConnectivityState;
  }
  
  ConnectivityState getState()
  {
    return this.state;
  }
  
  void gotoState(ConnectivityState paramConnectivityState)
  {
    if (this.state != paramConnectivityState)
    {
      if (this.state == ConnectivityState.SHUTDOWN) {
        throw new IllegalStateException("Cannot transition out of SHUTDOWN to " + paramConnectivityState);
      }
      this.state = paramConnectivityState;
      if (this.callbacks != null) {
        break label58;
      }
    }
    for (;;)
    {
      return;
      label58:
      paramConnectivityState = this.callbacks;
      this.callbacks = null;
      paramConnectivityState = paramConnectivityState.iterator();
      while (paramConnectivityState.hasNext()) {
        ((StateCallbackEntry)paramConnectivityState.next()).runInExecutor();
      }
    }
  }
  
  void notifyWhenStateChanged(Runnable paramRunnable, Executor paramExecutor, ConnectivityState paramConnectivityState)
  {
    paramRunnable = new StateCallbackEntry(paramRunnable, paramExecutor);
    if (this.state != paramConnectivityState)
    {
      paramRunnable.runInExecutor();
      return;
    }
    if (this.callbacks == null) {
      this.callbacks = new ArrayList();
    }
    this.callbacks.add(paramRunnable);
  }
  
  private static class StateCallbackEntry
  {
    final Runnable callback;
    final Executor executor;
    
    StateCallbackEntry(Runnable paramRunnable, Executor paramExecutor)
    {
      this.callback = paramRunnable;
      this.executor = paramExecutor;
    }
    
    void runInExecutor()
    {
      this.executor.execute(this.callback);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ConnectivityStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */