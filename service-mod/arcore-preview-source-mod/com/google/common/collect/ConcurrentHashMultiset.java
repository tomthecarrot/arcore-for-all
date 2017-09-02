package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final transient ConcurrentMap<E, AtomicInteger> countMap;
  
  @VisibleForTesting
  ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> paramConcurrentMap)
  {
    Preconditions.checkArgument(paramConcurrentMap.isEmpty());
    this.countMap = paramConcurrentMap;
  }
  
  public static <E> ConcurrentHashMultiset<E> create()
  {
    return new ConcurrentHashMultiset(new ConcurrentHashMap());
  }
  
  @Beta
  public static <E> ConcurrentHashMultiset<E> create(MapMaker paramMapMaker)
  {
    return new ConcurrentHashMultiset(paramMapMaker.makeMap());
  }
  
  public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    ConcurrentHashMultiset localConcurrentHashMultiset = create();
    Iterables.addAll(localConcurrentHashMultiset, paramIterable);
    return localConcurrentHashMultiset;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (ConcurrentMap)paramObjectInputStream.readObject();
    FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, paramObjectInputStream);
  }
  
  private List<E> snapshot()
  {
    ArrayList localArrayList = Lists.newArrayListWithExpectedSize(size());
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      Object localObject = localEntry.getElement();
      int i = localEntry.getCount();
      while (i > 0)
      {
        localArrayList.add(localObject);
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.countMap);
  }
  
  public int add(E paramE, int paramInt)
  {
    Preconditions.checkNotNull(paramE);
    if (paramInt == 0) {
      return count(paramE);
    }
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger localAtomicInteger2;
    AtomicInteger localAtomicInteger1;
    do
    {
      localAtomicInteger2 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger2 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
        localAtomicInteger1 = localAtomicInteger2;
        if (localAtomicInteger2 == null) {
          return 0;
        }
      }
      for (;;)
      {
        int i = localAtomicInteger1.get();
        if (i != 0) {
          try
          {
            boolean bool = localAtomicInteger1.compareAndSet(i, IntMath.checkedAdd(i, paramInt));
            if (bool) {
              return i;
            }
          }
          catch (ArithmeticException paramE)
          {
            throw new IllegalArgumentException("Overflow adding " + paramInt + " occurrences to a count of " + i);
          }
        }
      }
      localAtomicInteger2 = new AtomicInteger(paramInt);
    } while ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null) && (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2)));
    return 0;
  }
  
  public void clear()
  {
    this.countMap.clear();
  }
  
  public int count(@Nullable Object paramObject)
  {
    paramObject = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
    if (paramObject == null) {
      return 0;
    }
    return ((AtomicInteger)paramObject).get();
  }
  
  Set<E> createElementSet()
  {
    new ForwardingSet()
    {
      public boolean contains(@Nullable Object paramAnonymousObject)
      {
        return (paramAnonymousObject != null) && (Collections2.safeContains(this.val$delegate, paramAnonymousObject));
      }
      
      public boolean containsAll(Collection<?> paramAnonymousCollection)
      {
        return standardContainsAll(paramAnonymousCollection);
      }
      
      protected Set<E> delegate()
      {
        return this.val$delegate;
      }
      
      public boolean remove(Object paramAnonymousObject)
      {
        return (paramAnonymousObject != null) && (Collections2.safeRemove(this.val$delegate, paramAnonymousObject));
      }
      
      public boolean removeAll(Collection<?> paramAnonymousCollection)
      {
        return standardRemoveAll(paramAnonymousCollection);
      }
    };
  }
  
  public Set<Multiset.Entry<E>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  int distinctElements()
  {
    return this.countMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    new ForwardingIterator()
    {
      private Iterator<Map.Entry<E, AtomicInteger>> mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
      
      protected Multiset.Entry<E> computeNext()
      {
        Map.Entry localEntry;
        int i;
        do
        {
          if (!this.mapEntries.hasNext()) {
            return (Multiset.Entry)endOfData();
          }
          localEntry = (Map.Entry)this.mapEntries.next();
          i = ((AtomicInteger)localEntry.getValue()).get();
        } while (i == 0);
        return Multisets.immutableEntry(localEntry.getKey(), i);
      }
    }
    {
      private Multiset.Entry<E> last;
      
      protected Iterator<Multiset.Entry<E>> delegate()
      {
        return this.val$readOnlyIterator;
      }
      
      public Multiset.Entry<E> next()
      {
        this.last = ((Multiset.Entry)super.next());
        return this.last;
      }
      
      public void remove()
      {
        if (this.last != null) {}
        for (boolean bool = true;; bool = false)
        {
          CollectPreconditions.checkRemove(bool);
          ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
          this.last = null;
          return;
        }
      }
    };
  }
  
  public boolean isEmpty()
  {
    return this.countMap.isEmpty();
  }
  
  public int remove(@Nullable Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = count(paramObject);
    }
    AtomicInteger localAtomicInteger;
    int i;
    int j;
    do
    {
      return paramInt;
      CollectPreconditions.checkPositive(paramInt, "occurences");
      localAtomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
      if (localAtomicInteger == null) {
        return 0;
      }
      do
      {
        i = localAtomicInteger.get();
        if (i == 0) {
          break;
        }
        j = Math.max(0, i - paramInt);
      } while (!localAtomicInteger.compareAndSet(i, j));
      paramInt = i;
    } while (j != 0);
    this.countMap.remove(paramObject, localAtomicInteger);
    return i;
    return 0;
  }
  
  public boolean removeExactly(@Nullable Object paramObject, int paramInt)
  {
    if (paramInt == 0) {}
    AtomicInteger localAtomicInteger;
    int j;
    do
    {
      return true;
      CollectPreconditions.checkPositive(paramInt, "occurences");
      localAtomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
      if (localAtomicInteger == null) {
        return false;
      }
      int i;
      do
      {
        i = localAtomicInteger.get();
        if (i < paramInt) {
          return false;
        }
        j = i - paramInt;
      } while (!localAtomicInteger.compareAndSet(i, j));
    } while (j != 0);
    this.countMap.remove(paramObject, localAtomicInteger);
    return true;
  }
  
  public int setCount(E paramE, int paramInt)
  {
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt, "count");
    AtomicInteger localAtomicInteger2 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
    AtomicInteger localAtomicInteger1 = localAtomicInteger2;
    int i;
    if (localAtomicInteger2 == null) {
      if (paramInt == 0) {
        i = 0;
      }
    }
    int j;
    do
    {
      return i;
      localAtomicInteger2 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null) {
        return 0;
      }
      do
      {
        j = localAtomicInteger1.get();
        if (j == 0)
        {
          if (paramInt == 0) {
            return 0;
          }
          localAtomicInteger2 = new AtomicInteger(paramInt);
          if ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null) && (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2))) {
            break;
          }
          return 0;
        }
      } while (!localAtomicInteger1.compareAndSet(j, paramInt));
      i = j;
    } while (paramInt != 0);
    this.countMap.remove(paramE, localAtomicInteger1);
    return j;
  }
  
  public boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    AtomicInteger localAtomicInteger1 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
    if (localAtomicInteger1 == null) {
      if (paramInt1 != 0) {
        bool1 = false;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramInt2 == 0);
        bool1 = bool2;
      } while (this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt2)) == null);
      return false;
      int i = localAtomicInteger1.get();
      if (i != paramInt1) {
        break;
      }
      if (i == 0)
      {
        if (paramInt2 == 0)
        {
          this.countMap.remove(paramE, localAtomicInteger1);
          return true;
        }
        AtomicInteger localAtomicInteger2 = new AtomicInteger(paramInt2);
        if ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) == null) || (this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2))) {
          bool1 = true;
        }
        return bool1;
      }
      if (!localAtomicInteger1.compareAndSet(i, paramInt2)) {
        break;
      }
      bool1 = bool2;
    } while (paramInt2 != 0);
    this.countMap.remove(paramE, localAtomicInteger1);
    return true;
    return false;
  }
  
  public int size()
  {
    long l = 0L;
    Iterator localIterator = this.countMap.values().iterator();
    while (localIterator.hasNext()) {
      l += ((AtomicInteger)localIterator.next()).get();
    }
    return Ints.saturatedCast(l);
  }
  
  public Object[] toArray()
  {
    return snapshot().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return snapshot().toArray(paramArrayOfT);
  }
  
  private class EntrySet
    extends AbstractMultiset<E>.EntrySet
  {
    private EntrySet()
    {
      super();
    }
    
    private List<Multiset.Entry<E>> snapshot()
    {
      ArrayList localArrayList = Lists.newArrayListWithExpectedSize(size());
      Iterators.addAll(localArrayList, iterator());
      return localArrayList;
    }
    
    ConcurrentHashMultiset<E> multiset()
    {
      return ConcurrentHashMultiset.this;
    }
    
    public Object[] toArray()
    {
      return snapshot().toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return snapshot().toArray(paramArrayOfT);
    }
  }
  
  private static class FieldSettersHolder
  {
    static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ConcurrentHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */