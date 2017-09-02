package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AggregateFuture<InputT, OutputT>
  extends AbstractFuture.TrustedFuture<OutputT>
{
  private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
  private AggregateFuture<InputT, OutputT>.RunningState runningState;
  
  private static boolean addCausalChain(Set<Throwable> paramSet, Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if (!paramSet.add(paramThrowable)) {
        return false;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return true;
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    Object localObject = this.runningState;
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((RunningState)localObject).futures;
      bool2 = super.cancel(paramBoolean);
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!(bool1 & bool2)) {
        return bool2;
      }
      localObject = ((ImmutableCollection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListenableFuture)((Iterator)localObject).next()).cancel(paramBoolean);
      }
      localObject = null;
      break;
    }
    return bool2;
  }
  
  final void done()
  {
    super.done();
    this.runningState = null;
  }
  
  final void init(AggregateFuture<InputT, OutputT>.RunningState paramAggregateFuture)
  {
    this.runningState = paramAggregateFuture;
    paramAggregateFuture.init();
  }
  
  @GwtIncompatible("Interruption not supported")
  protected final void interruptTask()
  {
    RunningState localRunningState = this.runningState;
    if (localRunningState != null) {
      localRunningState.interruptTask();
    }
  }
  
  abstract class RunningState
    extends AggregateFutureState
    implements Runnable
  {
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
    
    RunningState(boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.futures = ((ImmutableCollection)Preconditions.checkNotNull(paramBoolean1));
      this.allMustSucceed = paramBoolean2;
      boolean bool;
      this.collectsValues = bool;
    }
    
    private void decrementCountAndMaybeComplete()
    {
      int i = decrementRemainingAndGet();
      if (i >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Less than 0 remaining futures");
        if (i == 0) {
          processCompleted();
        }
        return;
      }
    }
    
    private void handleException(Throwable paramThrowable)
    {
      Preconditions.checkNotNull(paramThrowable);
      boolean bool2 = false;
      boolean bool4 = true;
      boolean bool3 = bool4;
      boolean bool1;
      if (this.allMustSucceed)
      {
        bool2 = AggregateFuture.this.setException(paramThrowable);
        if (bool2)
        {
          releaseResourcesAfterFailure();
          bool3 = bool4;
        }
      }
      else
      {
        bool4 = paramThrowable instanceof Error;
        boolean bool5 = this.allMustSucceed;
        if (bool2) {
          break label110;
        }
        bool1 = true;
        label60:
        if ((bool1 & bool5 & bool3 | bool4)) {
          if (!(paramThrowable instanceof Error)) {
            break label115;
          }
        }
      }
      label110:
      label115:
      for (String str = "Input Future failed with Error";; str = "Got more than one input Future failure. Logging failures after the first")
      {
        AggregateFuture.logger.log(Level.SEVERE, str, paramThrowable);
        return;
        bool3 = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), paramThrowable);
        break;
        bool1 = false;
        break label60;
      }
    }
    
    private void handleOneInputDone(int paramInt, Future<? extends InputT> paramFuture)
    {
      boolean bool = false;
      if ((this.allMustSucceed) || (!AggregateFuture.this.isDone()) || (AggregateFuture.this.isCancelled())) {
        bool = true;
      }
      Preconditions.checkState(bool, "Future was done before all dependencies completed");
      try
      {
        Preconditions.checkState(paramFuture.isDone(), "Tried to set value from future which is not done");
        if (this.allMustSucceed)
        {
          if (paramFuture.isCancelled())
          {
            AggregateFuture.this.cancel(false);
            return;
          }
          paramFuture = Uninterruptibles.getUninterruptibly(paramFuture);
          if (!this.collectsValues) {
            return;
          }
          collectOneValue(this.allMustSucceed, paramInt, paramFuture);
        }
      }
      catch (ExecutionException paramFuture)
      {
        handleException(paramFuture.getCause());
        return;
        if ((this.collectsValues) && (!paramFuture.isCancelled()))
        {
          collectOneValue(this.allMustSucceed, paramInt, Uninterruptibles.getUninterruptibly(paramFuture));
          return;
        }
      }
      catch (Throwable paramFuture)
      {
        handleException(paramFuture);
      }
    }
    
    private void init()
    {
      if (this.futures.isEmpty()) {
        handleAllCompleted();
      }
      for (;;)
      {
        return;
        Iterator localIterator;
        if (this.allMustSucceed)
        {
          final int i = 0;
          localIterator = this.futures.iterator();
          while (localIterator.hasNext())
          {
            final ListenableFuture localListenableFuture = (ListenableFuture)localIterator.next();
            localListenableFuture.addListener(new Runnable()
            {
              public void run()
              {
                try
                {
                  AggregateFuture.RunningState.this.handleOneInputDone(i, localListenableFuture);
                  return;
                }
                finally
                {
                  AggregateFuture.RunningState.this.decrementCountAndMaybeComplete();
                }
              }
            }, MoreExecutors.directExecutor());
            i += 1;
          }
        }
        else
        {
          localIterator = this.futures.iterator();
          while (localIterator.hasNext()) {
            ((ListenableFuture)localIterator.next()).addListener(this, MoreExecutors.directExecutor());
          }
        }
      }
    }
    
    private void processCompleted()
    {
      boolean bool = this.collectsValues;
      if (!this.allMustSucceed) {}
      int j;
      for (int i = 1; (i & bool) != 0; j = 0)
      {
        i = 0;
        Iterator localIterator = this.futures.iterator();
        while (localIterator.hasNext())
        {
          handleOneInputDone(i, (ListenableFuture)localIterator.next());
          i += 1;
        }
      }
      handleAllCompleted();
    }
    
    final void addInitialException(Set<Throwable> paramSet)
    {
      if (!AggregateFuture.this.isCancelled()) {
        AggregateFuture.addCausalChain(paramSet, AggregateFuture.this.trustedGetException());
      }
    }
    
    abstract void collectOneValue(boolean paramBoolean, int paramInt, @Nullable InputT paramInputT);
    
    abstract void handleAllCompleted();
    
    void interruptTask() {}
    
    void releaseResourcesAfterFailure()
    {
      this.futures = null;
    }
    
    public final void run()
    {
      decrementCountAndMaybeComplete();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AggregateFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */