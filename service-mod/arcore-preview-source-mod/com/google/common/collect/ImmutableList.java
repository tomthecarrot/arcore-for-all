package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableList<E>
  extends ImmutableCollection<E>
  implements List<E>, RandomAccess
{
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject)
  {
    return asImmutableList(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Object[] arrayOfObject = paramArrayOfObject;
      if (paramInt < paramArrayOfObject.length) {
        arrayOfObject = ObjectArrays.arraysCopyOf(paramArrayOfObject, paramInt);
      }
      return new RegularImmutableList(arrayOfObject);
    case 0: 
      return of();
    }
    return new SingletonImmutableList(paramArrayOfObject[0]);
  }
  
  public static <E> Builder<E> builder()
  {
    return new Builder();
  }
  
  private static <E> ImmutableList<E> construct(Object... paramVarArgs)
  {
    return asImmutableList(ObjectArrays.checkElementsNotNull(paramVarArgs));
  }
  
  public static <E> ImmutableList<E> copyOf(Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection)) {
      return copyOf((Collection)paramIterable);
    }
    return copyOf(paramIterable.iterator());
  }
  
  public static <E> ImmutableList<E> copyOf(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof ImmutableCollection))
    {
      ImmutableList localImmutableList = ((ImmutableCollection)paramCollection).asList();
      paramCollection = localImmutableList;
      if (localImmutableList.isPartialView()) {
        paramCollection = asImmutableList(localImmutableList.toArray());
      }
      return paramCollection;
    }
    return construct(paramCollection.toArray());
  }
  
  public static <E> ImmutableList<E> copyOf(Iterator<? extends E> paramIterator)
  {
    if (!paramIterator.hasNext()) {
      return of();
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return of(localObject);
    }
    return new Builder().add(localObject).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableList<E> copyOf(E[] paramArrayOfE)
  {
    switch (paramArrayOfE.length)
    {
    default: 
      return new RegularImmutableList(ObjectArrays.checkElementsNotNull((Object[])paramArrayOfE.clone()));
    case 0: 
      return of();
    }
    return new SingletonImmutableList(paramArrayOfE[0]);
  }
  
  public static <E> ImmutableList<E> of()
  {
    return RegularImmutableList.EMPTY;
  }
  
  public static <E> ImmutableList<E> of(E paramE)
  {
    return new SingletonImmutableList(paramE);
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2)
  {
    return construct(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10, paramE11 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 12];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    arrayOfObject[6] = paramE7;
    arrayOfObject[7] = paramE8;
    arrayOfObject[8] = paramE9;
    arrayOfObject[9] = paramE10;
    arrayOfObject[10] = paramE11;
    arrayOfObject[11] = paramE12;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
    return construct(arrayOfObject);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final ImmutableList<E> asList()
  {
    return this;
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[(paramInt + i)] = get(i);
      i += 1;
    }
    return paramInt + j;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return Lists.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    int j = 1;
    int k = size();
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
      i += 1;
    }
    return j;
  }
  
  public int indexOf(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    return Lists.indexOfImpl(this, paramObject);
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return listIterator();
  }
  
  public int lastIndexOf(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    return Lists.lastIndexOfImpl(this, paramObject);
  }
  
  public UnmodifiableListIterator<E> listIterator()
  {
    return listIterator(0);
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    new AbstractIndexedListIterator(size(), paramInt)
    {
      protected E get(int paramAnonymousInt)
      {
        return (E)ImmutableList.this.get(paramAnonymousInt);
      }
    };
  }
  
  @Deprecated
  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> reverse()
  {
    if (size() <= 1) {
      return this;
    }
    return new ReverseImmutableList(this);
  }
  
  @Deprecated
  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    if (i == size()) {
      return this;
    }
    switch (i)
    {
    default: 
      return subListUnchecked(paramInt1, paramInt2);
    case 0: 
      return of();
    }
    return of(get(paramInt1));
  }
  
  ImmutableList<E> subListUnchecked(int paramInt1, int paramInt2)
  {
    return new SubList(paramInt1, paramInt2 - paramInt1);
  }
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
  
  public static final class Builder<E>
    extends ImmutableCollection.ArrayBasedBuilder<E>
  {
    public Builder()
    {
      this(4);
    }
    
    Builder(int paramInt)
    {
      super();
    }
    
    public Builder<E> add(E paramE)
    {
      super.add(paramE);
      return this;
    }
    
    public Builder<E> add(E... paramVarArgs)
    {
      super.add(paramVarArgs);
      return this;
    }
    
    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      super.addAll(paramIterable);
      return this;
    }
    
    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      super.addAll(paramIterator);
      return this;
    }
    
    public ImmutableList<E> build()
    {
      return ImmutableList.asImmutableList(this.contents, this.size);
    }
  }
  
  private static class ReverseImmutableList<E>
    extends ImmutableList<E>
  {
    private final transient ImmutableList<E> forwardList;
    
    ReverseImmutableList(ImmutableList<E> paramImmutableList)
    {
      this.forwardList = paramImmutableList;
    }
    
    private int reverseIndex(int paramInt)
    {
      return size() - 1 - paramInt;
    }
    
    private int reversePosition(int paramInt)
    {
      return size() - paramInt;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      return this.forwardList.contains(paramObject);
    }
    
    public E get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return (E)this.forwardList.get(reverseIndex(paramInt));
    }
    
    public int indexOf(@Nullable Object paramObject)
    {
      int i = this.forwardList.lastIndexOf(paramObject);
      if (i >= 0) {
        return reverseIndex(i);
      }
      return -1;
    }
    
    boolean isPartialView()
    {
      return this.forwardList.isPartialView();
    }
    
    public int lastIndexOf(@Nullable Object paramObject)
    {
      int i = this.forwardList.indexOf(paramObject);
      if (i >= 0) {
        return reverseIndex(i);
      }
      return -1;
    }
    
    public ImmutableList<E> reverse()
    {
      return this.forwardList;
    }
    
    public int size()
    {
      return this.forwardList.size();
    }
    
    public ImmutableList<E> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      return this.forwardList.subList(reversePosition(paramInt2), reversePosition(paramInt1)).reverse();
    }
  }
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Object[] elements;
    
    SerializedForm(Object[] paramArrayOfObject)
    {
      this.elements = paramArrayOfObject;
    }
    
    Object readResolve()
    {
      return ImmutableList.copyOf(this.elements);
    }
  }
  
  class SubList
    extends ImmutableList<E>
  {
    final transient int length;
    final transient int offset;
    
    SubList(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.length = paramInt2;
    }
    
    public E get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, this.length);
      return (E)ImmutableList.this.get(this.offset + paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.length;
    }
    
    public ImmutableList<E> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, this.length);
      return ImmutableList.this.subList(this.offset + paramInt1, this.offset + paramInt2);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */