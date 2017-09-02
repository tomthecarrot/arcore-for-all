package io.grpc.internal;

import java.util.HashSet;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class InUseStateAggregator<T>
{
  private final HashSet<T> inUseObjects = new HashSet();
  
  abstract void handleInUse();
  
  abstract void handleNotInUse();
  
  final boolean isInUse()
  {
    return !this.inUseObjects.isEmpty();
  }
  
  final void updateObjectInUse(T paramT, boolean paramBoolean)
  {
    int i = this.inUseObjects.size();
    if (paramBoolean)
    {
      this.inUseObjects.add(paramT);
      if (i == 0) {
        handleInUse();
      }
    }
    while ((!this.inUseObjects.remove(paramT)) || (i != 1)) {
      return;
    }
    handleNotInUse();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/InUseStateAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */