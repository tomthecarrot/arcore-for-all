package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator<T>
  extends AbstractIterator<T>
{
  private final Queue<T> queue;
  
  ConsumingQueueIterator(Queue<T> paramQueue)
  {
    this.queue = ((Queue)Preconditions.checkNotNull(paramQueue));
  }
  
  ConsumingQueueIterator(T... paramVarArgs)
  {
    this.queue = Lists.newLinkedList();
    Collections.addAll(this.queue, paramVarArgs);
  }
  
  public T computeNext()
  {
    if (this.queue.isEmpty()) {
      return (T)endOfData();
    }
    return (T)this.queue.remove();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ConsumingQueueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */