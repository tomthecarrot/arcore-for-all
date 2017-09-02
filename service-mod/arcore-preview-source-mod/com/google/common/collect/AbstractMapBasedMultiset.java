package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractMapBasedMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  @GwtIncompatible("not needed in emulated source.")
  private static final long serialVersionUID = -2250766705698539974L;
  private transient Map<E, Count> backingMap;
  private transient long size;
  
  protected AbstractMapBasedMultiset(Map<E, Count> paramMap)
  {
    this.backingMap = ((Map)Preconditions.checkNotNull(paramMap));
    this.size = super.size();
  }
  
  private static int getAndSet(Count paramCount, int paramInt)
  {
    if (paramCount == null) {
      return 0;
    }
    return paramCount.getAndSet(paramInt);
  }
  
  @GwtIncompatible("java.io.ObjectStreamException")
  private void readObjectNoData()
    throws ObjectStreamException
  {
    throw new InvalidObjectException("Stream data required");
  }
  
  public int add(@Nullable E paramE, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramE);
    }
    if (paramInt > 0) {}
    Count localCount;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
      localCount = (Count)this.backingMap.get(paramE);
      if (localCount != null) {
        break;
      }
      i = 0;
      this.backingMap.put(paramE, new Count(paramInt));
      this.size += paramInt;
      return i;
    }
    int i = localCount.get();
    long l = i + paramInt;
    if (l <= 2147483647L) {}
    for (bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "too many occurrences: %s", new Object[] { Long.valueOf(l) });
      localCount.getAndAdd(paramInt);
      break;
    }
  }
  
  public void clear()
  {
    Iterator localIterator = this.backingMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Count)localIterator.next()).set(0);
    }
    this.backingMap.clear();
    this.size = 0L;
  }
  
  public int count(@Nullable Object paramObject)
  {
    paramObject = (Count)Maps.safeGet(this.backingMap, paramObject);
    if (paramObject == null) {
      return 0;
    }
    return ((Count)paramObject).get();
  }
  
  int distinctElements()
  {
    return this.backingMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    new Iterator()
    {
      Map.Entry<E, Count> toRemove;
      
      public boolean hasNext()
      {
        return this.val$backingEntries.hasNext();
      }
      
      public Multiset.Entry<E> next()
      {
        final Map.Entry localEntry = (Map.Entry)this.val$backingEntries.next();
        this.toRemove = localEntry;
        new Multisets.AbstractEntry()
        {
          public int getCount()
          {
            Count localCount1 = (Count)localEntry.getValue();
            if ((localCount1 == null) || (localCount1.get() == 0))
            {
              Count localCount2 = (Count)AbstractMapBasedMultiset.this.backingMap.get(getElement());
              if (localCount2 != null) {
                return localCount2.get();
              }
            }
            if (localCount1 == null) {
              return 0;
            }
            return localCount1.get();
          }
          
          public E getElement()
          {
            return (E)localEntry.getKey();
          }
        };
      }
      
      public void remove()
      {
        if (this.toRemove != null) {}
        for (boolean bool = true;; bool = false)
        {
          CollectPreconditions.checkRemove(bool);
          AbstractMapBasedMultiset.access$122(AbstractMapBasedMultiset.this, ((Count)this.toRemove.getValue()).getAndSet(0));
          this.val$backingEntries.remove();
          this.toRemove = null;
          return;
        }
      }
    };
  }
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    return super.entrySet();
  }
  
  public Iterator<E> iterator()
  {
    return new MapBasedMultisetIterator();
  }
  
  public int remove(@Nullable Object paramObject, int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      i = count(paramObject);
    }
    boolean bool;
    Count localCount;
    do
    {
      return i;
      if (paramInt <= 0) {
        break;
      }
      bool = true;
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
      localCount = (Count)this.backingMap.get(paramObject);
    } while (localCount == null);
    i = localCount.get();
    if (i > paramInt) {}
    for (;;)
    {
      localCount.addAndGet(-paramInt);
      this.size -= paramInt;
      return i;
      bool = false;
      break;
      paramInt = i;
      this.backingMap.remove(paramObject);
    }
  }
  
  void setBackingMap(Map<E, Count> paramMap)
  {
    this.backingMap = paramMap;
  }
  
  public int setCount(@Nullable E paramE, int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "count");
    int i;
    if (paramInt == 0) {
      i = getAndSet((Count)this.backingMap.remove(paramE), paramInt);
    }
    for (;;)
    {
      this.size += paramInt - i;
      return i;
      Count localCount = (Count)this.backingMap.get(paramE);
      int j = getAndSet(localCount, paramInt);
      i = j;
      if (localCount == null)
      {
        this.backingMap.put(paramE, new Count(paramInt));
        i = j;
      }
    }
  }
  
  public int size()
  {
    return Ints.saturatedCast(this.size);
  }
  
  private class MapBasedMultisetIterator
    implements Iterator<E>
  {
    boolean canRemove;
    Map.Entry<E, Count> currentEntry;
    final Iterator<Map.Entry<E, Count>> entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
    int occurrencesLeft;
    
    MapBasedMultisetIterator() {}
    
    public boolean hasNext()
    {
      return (this.occurrencesLeft > 0) || (this.entryIterator.hasNext());
    }
    
    public E next()
    {
      if (this.occurrencesLeft == 0)
      {
        this.currentEntry = ((Map.Entry)this.entryIterator.next());
        this.occurrencesLeft = ((Count)this.currentEntry.getValue()).get();
      }
      this.occurrencesLeft -= 1;
      this.canRemove = true;
      return (E)this.currentEntry.getKey();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(this.canRemove);
      if (((Count)this.currentEntry.getValue()).get() <= 0) {
        throw new ConcurrentModificationException();
      }
      if (((Count)this.currentEntry.getValue()).addAndGet(-1) == 0) {
        this.entryIterator.remove();
      }
      AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
      this.canRemove = false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractMapBasedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */