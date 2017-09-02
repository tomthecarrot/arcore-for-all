package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class ImmutableCollection<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private transient ImmutableList<E> asList;
  
  @Deprecated
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList()
  {
    ImmutableList localImmutableList2 = this.asList;
    ImmutableList localImmutableList1 = localImmutableList2;
    if (localImmutableList2 == null)
    {
      localImmutableList1 = createAsList();
      this.asList = localImmutableList1;
    }
    return localImmutableList1;
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@Nullable Object paramObject);
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      paramArrayOfObject[paramInt] = localIterator.next();
      paramInt += 1;
    }
    return paramInt;
  }
  
  ImmutableList<E> createAsList()
  {
    switch (size())
    {
    default: 
      return new RegularImmutableAsList(this, toArray());
    case 0: 
      return ImmutableList.of();
    }
    return ImmutableList.of(iterator().next());
  }
  
  abstract boolean isPartialView();
  
  public abstract UnmodifiableIterator<E> iterator();
  
  @Deprecated
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    int i = size();
    if (i == 0) {
      return ObjectArrays.EMPTY_ARRAY;
    }
    Object[] arrayOfObject = new Object[i];
    copyIntoArray(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    Preconditions.checkNotNull(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i) {
      localObject = ObjectArrays.newArray(paramArrayOfT, i);
    }
    for (;;)
    {
      copyIntoArray((Object[])localObject, 0);
      return (T[])localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
  }
  
  Object writeReplace()
  {
    return new ImmutableList.SerializedForm(toArray());
  }
  
  static abstract class ArrayBasedBuilder<E>
    extends ImmutableCollection.Builder<E>
  {
    Object[] contents;
    int size;
    
    ArrayBasedBuilder(int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "initialCapacity");
      this.contents = new Object[paramInt];
      this.size = 0;
    }
    
    private void ensureCapacity(int paramInt)
    {
      if (this.contents.length < paramInt) {
        this.contents = ObjectArrays.arraysCopyOf(this.contents, expandedCapacity(this.contents.length, paramInt));
      }
    }
    
    public ArrayBasedBuilder<E> add(E paramE)
    {
      Preconditions.checkNotNull(paramE);
      ensureCapacity(this.size + 1);
      Object[] arrayOfObject = this.contents;
      int i = this.size;
      this.size = (i + 1);
      arrayOfObject[i] = paramE;
      return this;
    }
    
    public ImmutableCollection.Builder<E> add(E... paramVarArgs)
    {
      ObjectArrays.checkElementsNotNull(paramVarArgs);
      ensureCapacity(this.size + paramVarArgs.length);
      System.arraycopy(paramVarArgs, 0, this.contents, this.size, paramVarArgs.length);
      this.size += paramVarArgs.length;
      return this;
    }
    
    public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      if ((paramIterable instanceof Collection))
      {
        Collection localCollection = (Collection)paramIterable;
        ensureCapacity(this.size + localCollection.size());
      }
      super.addAll(paramIterable);
      return this;
    }
  }
  
  public static abstract class Builder<E>
  {
    static final int DEFAULT_INITIAL_CAPACITY = 4;
    
    static int expandedCapacity(int paramInt1, int paramInt2)
    {
      if (paramInt2 < 0) {
        throw new AssertionError("cannot store more than MAX_VALUE elements");
      }
      int i = (paramInt1 >> 1) + paramInt1 + 1;
      paramInt1 = i;
      if (i < paramInt2) {
        paramInt1 = Integer.highestOneBit(paramInt2 - 1) << 1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = Integer.MAX_VALUE;
      }
      return paramInt2;
    }
    
    public abstract Builder<E> add(E paramE);
    
    public Builder<E> add(E... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        add(paramVarArgs[i]);
        i += 1;
      }
      return this;
    }
    
    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        add(paramIterable.next());
      }
      return this;
    }
    
    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      while (paramIterator.hasNext()) {
        add(paramIterator.next());
      }
      return this;
    }
    
    public abstract ImmutableCollection<E> build();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */