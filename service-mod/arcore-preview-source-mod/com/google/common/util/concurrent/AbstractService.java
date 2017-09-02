package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
public abstract class AbstractService
  implements Service
{
  private static final ListenerCallQueue.Callback<Service.Listener> RUNNING_CALLBACK;
  private static final ListenerCallQueue.Callback<Service.Listener> STARTING_CALLBACK = new ListenerCallQueue.Callback("starting()")
  {
    void call(Service.Listener paramAnonymousListener)
    {
      paramAnonymousListener.starting();
    }
  };
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_STARTING_CALLBACK;
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service.State.NEW);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service.State.STOPPING);
  private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
  private final Monitor.Guard isStartable = new IsStartableGuard();
  private final Monitor.Guard isStoppable = new IsStoppableGuard();
  private final Monitor.Guard isStopped = new IsStoppedGuard();
  @GuardedBy("monitor")
  private final List<ListenerCallQueue<Service.Listener>> listeners = Collections.synchronizedList(new ArrayList());
  private final Monitor monitor = new Monitor();
  @GuardedBy("monitor")
  private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);
  
  static
  {
    RUNNING_CALLBACK = new ListenerCallQueue.Callback("running()")
    {
      void call(Service.Listener paramAnonymousListener)
      {
        paramAnonymousListener.running();
      }
    };
    STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service.State.STARTING);
  }
  
  @GuardedBy("monitor")
  private void checkCurrentState(Service.State paramState)
  {
    Service.State localState = state();
    if (localState != paramState)
    {
      if (localState == Service.State.FAILED) {
        throw new IllegalStateException("Expected the service to be " + paramState + ", but the service has FAILED", failureCause());
      }
      throw new IllegalStateException("Expected the service to be " + paramState + ", but was " + localState);
    }
  }
  
  private void executeListeners()
  {
    if (!this.monitor.isOccupiedByCurrentThread())
    {
      int i = 0;
      while (i < this.listeners.size())
      {
        ((ListenerCallQueue)this.listeners.get(i)).execute();
        i += 1;
      }
    }
  }
  
  @GuardedBy("monitor")
  private void failed(final Service.State paramState, final Throwable paramThrowable)
  {
    new ListenerCallQueue.Callback("failed({from = " + paramState + ", cause = " + paramThrowable + "})")
    {
      void call(Service.Listener paramAnonymousListener)
      {
        paramAnonymousListener.failed(paramState, paramThrowable);
      }
    }.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void running()
  {
    RUNNING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void starting()
  {
    STARTING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void stopping(Service.State paramState)
  {
    if (paramState == Service.State.STARTING)
    {
      STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    if (paramState == Service.State.RUNNING)
    {
      STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    throw new AssertionError();
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> stoppingCallback(final Service.State paramState)
  {
    new ListenerCallQueue.Callback("stopping({from = " + paramState + "})")
    {
      void call(Service.Listener paramAnonymousListener)
      {
        paramAnonymousListener.stopping(paramState);
      }
    };
  }
  
  @GuardedBy("monitor")
  private void terminated(Service.State paramState)
  {
    switch (paramState)
    {
    case ???: 
    default: 
      throw new AssertionError();
    case ???: 
      TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
      return;
    case ???: 
      TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> terminatedCallback(final Service.State paramState)
  {
    new ListenerCallQueue.Callback("terminated({from = " + paramState + "})")
    {
      void call(Service.Listener paramAnonymousListener)
      {
        paramAnonymousListener.terminated(paramState);
      }
    };
  }
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramListener, "listener");
    Preconditions.checkNotNull(paramExecutor, "executor");
    this.monitor.enter();
    try
    {
      if (!state().isTerminal()) {
        this.listeners.add(new ListenerCallQueue(paramListener, paramExecutor));
      }
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitRunning()
  {
    this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
    try
    {
      checkCurrentState(Service.State.RUNNING);
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, paramLong, paramTimeUnit)) {
      try
      {
        checkCurrentState(Service.State.RUNNING);
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
  }
  
  public final void awaitTerminated()
  {
    this.monitor.enterWhenUninterruptibly(this.isStopped);
    try
    {
      checkCurrentState(Service.State.TERMINATED);
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    if (this.monitor.enterWhenUninterruptibly(this.isStopped, paramLong, paramTimeUnit)) {
      try
      {
        checkCurrentState(Service.State.TERMINATED);
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. " + "Current state: " + state());
  }
  
  protected abstract void doStart();
  
  protected abstract void doStop();
  
  public final Throwable failureCause()
  {
    return this.snapshot.failureCause();
  }
  
  public final boolean isRunning()
  {
    return state() == Service.State.RUNNING;
  }
  
  protected final void notifyFailed(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    this.monitor.enter();
    try
    {
      localState = state();
      switch (localState)
      {
      case ???: 
        throw new AssertionError("Unexpected state: " + localState);
      }
    }
    finally
    {
      Service.State localState;
      this.monitor.leave();
      executeListeners();
      throw paramThrowable;
      throw new IllegalStateException("Failed while in state:" + localState, paramThrowable);
      this.snapshot = new StateSnapshot(Service.State.FAILED, false, paramThrowable);
      failed(localState, paramThrowable);
      this.monitor.leave();
      executeListeners();
    }
  }
  
  protected final void notifyStarted()
  {
    this.monitor.enter();
    try
    {
      if (this.snapshot.state != Service.State.STARTING)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);
        notifyFailed(localIllegalStateException);
        throw localIllegalStateException;
      }
    }
    finally
    {
      this.monitor.leave();
      executeListeners();
    }
    if (this.snapshot.shutdownWhenStartupFinishes)
    {
      this.snapshot = new StateSnapshot(Service.State.STOPPING);
      doStop();
    }
    for (;;)
    {
      this.monitor.leave();
      executeListeners();
      return;
      this.snapshot = new StateSnapshot(Service.State.RUNNING);
      running();
    }
  }
  
  protected final void notifyStopped()
  {
    this.monitor.enter();
    try
    {
      Object localObject = this.snapshot.state;
      if ((localObject != Service.State.STOPPING) && (localObject != Service.State.RUNNING))
      {
        localObject = new IllegalStateException("Cannot notifyStopped() when the service is " + localObject);
        notifyFailed((Throwable)localObject);
        throw ((Throwable)localObject);
      }
    }
    finally
    {
      this.monitor.leave();
      executeListeners();
    }
    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
    terminated(localState);
    this.monitor.leave();
    executeListeners();
  }
  
  public final Service startAsync()
  {
    if (this.monitor.enterIf(this.isStartable)) {
      try
      {
        this.snapshot = new StateSnapshot(Service.State.STARTING);
        starting();
        doStart();
        return this;
      }
      catch (Throwable localThrowable)
      {
        notifyFailed(localThrowable);
        return this;
      }
      finally
      {
        this.monitor.leave();
        executeListeners();
      }
    }
    throw new IllegalStateException("Service " + this + " has already been started");
  }
  
  public final Service.State state()
  {
    return this.snapshot.externalState();
  }
  
  public final Service stopAsync()
  {
    if (this.monitor.enterIf(this.isStoppable)) {}
    try
    {
      Service.State localState = state();
      switch (localState)
      {
      case ???: 
        throw new AssertionError("Unexpected state: " + localState);
      }
    }
    catch (Throwable localThrowable)
    {
      notifyFailed(localThrowable);
      this.monitor.leave();
      executeListeners();
      return this;
      this.snapshot = new StateSnapshot(Service.State.TERMINATED);
      terminated(Service.State.NEW);
      this.monitor.leave();
      executeListeners();
      return this;
      this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);
      stopping(Service.State.STARTING);
    }
    finally
    {
      for (;;)
      {
        this.monitor.leave();
        executeListeners();
        throw ((Throwable)localObject);
        this.snapshot = new StateSnapshot(Service.State.STOPPING);
        stopping(Service.State.RUNNING);
        doStop();
      }
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " [" + state() + "]";
  }
  
  private final class HasReachedRunningGuard
    extends Monitor.Guard
  {
    HasReachedRunningGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
    }
  }
  
  private final class IsStartableGuard
    extends Monitor.Guard
  {
    IsStartableGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state() == Service.State.NEW;
    }
  }
  
  private final class IsStoppableGuard
    extends Monitor.Guard
  {
    IsStoppableGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
    }
  }
  
  private final class IsStoppedGuard
    extends Monitor.Guard
  {
    IsStoppedGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().isTerminal();
    }
  }
  
  @Immutable
  private static final class StateSnapshot
  {
    @Nullable
    final Throwable failure;
    final boolean shutdownWhenStartupFinishes;
    final Service.State state;
    
    StateSnapshot(Service.State paramState)
    {
      this(paramState, false, null);
    }
    
    StateSnapshot(Service.State paramState, boolean paramBoolean, @Nullable Throwable paramThrowable)
    {
      int i;
      label40:
      int j;
      if ((!paramBoolean) || (paramState == Service.State.STARTING))
      {
        bool = true;
        Preconditions.checkArgument(bool, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[] { paramState });
        if (paramThrowable == null) {
          break label102;
        }
        i = 1;
        if (paramState != Service.State.FAILED) {
          break label108;
        }
        j = 1;
        label50:
        if ((i ^ j) != 0) {
          break label114;
        }
      }
      label102:
      label108:
      label114:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[] { paramState, paramThrowable });
        this.state = paramState;
        this.shutdownWhenStartupFinishes = paramBoolean;
        this.failure = paramThrowable;
        return;
        bool = false;
        break;
        i = 0;
        break label40;
        j = 0;
        break label50;
      }
    }
    
    Service.State externalState()
    {
      if ((this.shutdownWhenStartupFinishes) && (this.state == Service.State.STARTING)) {
        return Service.State.STOPPING;
      }
      return this.state;
    }
    
    Throwable failureCause()
    {
      if (this.state == Service.State.FAILED) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "failureCause() is only valid if the service has failed, service is %s", new Object[] { this.state });
        return this.failure;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AbstractService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */