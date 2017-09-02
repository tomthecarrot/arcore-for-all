package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible(emulated=true)
abstract class AggregateFutureState
{
  private static final AtomicIntegerFieldUpdater<AggregateFutureState> REMAINING_COUNT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining");
  private static final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> SEEN_EXCEPTIONS_UDPATER = AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions");
  private volatile int remaining;
  private volatile Set<Throwable> seenExceptions = null;
  
  AggregateFutureState(int paramInt)
  {
    this.remaining = paramInt;
  }
  
  abstract void addInitialException(Set<Throwable> paramSet);
  
  final int decrementRemainingAndGet()
  {
    return REMAINING_COUNT_UPDATER.decrementAndGet(this);
  }
  
  final Set<Throwable> getOrInitSeenExceptions()
  {
    Set localSet2 = this.seenExceptions;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = Sets.newConcurrentHashSet();
      addInitialException(localSet1);
      SEEN_EXCEPTIONS_UDPATER.compareAndSet(this, null, localSet1);
      localSet1 = this.seenExceptions;
    }
    return localSet1;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AggregateFutureState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */