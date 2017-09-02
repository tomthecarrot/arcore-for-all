package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableSet<E>
  extends ImmutableCollection<E>
  implements Set<E>
{
  private static final int CUTOFF = 751619276;
  private static final double DESIRED_LOAD_FACTOR = 0.7D;
  static final int MAX_TABLE_SIZE = 1073741824;
  
  public static <E> Builder<E> builder()
  {
    return new Builder();
  }
  
  @VisibleForTesting
  static int chooseTableSize(int paramInt)
  {
    int j = 1073741824;
    if (paramInt < 751619276)
    {
      int i = Integer.highestOneBit(paramInt - 1) << 1;
      for (;;)
      {
        j = i;
        if (i * 0.7D >= paramInt) {
          break;
        }
        i <<= 1;
      }
    }
    if (paramInt < 1073741824) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "collection too large");
      return j;
    }
  }
  
  private static <E> ImmutableSet<E> construct(int paramInt, Object... paramVarArgs)
  {
    int n;
    Object[] arrayOfObject;
    int i1;
    int k;
    int j;
    int i;
    Object localObject1;
    int i2;
    int m;
    switch (paramInt)
    {
    default: 
      n = chooseTableSize(paramInt);
      arrayOfObject = new Object[n];
      i1 = n - 1;
      k = 0;
      j = 0;
      i = 0;
      if (j < paramInt)
      {
        localObject1 = ObjectArrays.checkElementNotNull(paramVarArgs[j], j);
        i2 = localObject1.hashCode();
        m = Hashing.smear(i2);
      }
      break;
    case 0: 
    case 1: 
      for (;;)
      {
        int i3 = m & i1;
        Object localObject2 = arrayOfObject[i3];
        if (localObject2 == null)
        {
          m = i + 1;
          paramVarArgs[i] = localObject1;
          arrayOfObject[i3] = localObject1;
          k += i2;
          i = m;
        }
        while (localObject2.equals(localObject1))
        {
          j += 1;
          break;
          return of();
          return of(paramVarArgs[0]);
        }
        m += 1;
      }
    }
    Arrays.fill(paramVarArgs, i, paramInt, null);
    if (i == 1) {
      return new SingletonImmutableSet(paramVarArgs[0], k);
    }
    if (n != chooseTableSize(i)) {
      return construct(i, paramVarArgs);
    }
    if (i < paramVarArgs.length) {
      paramVarArgs = ObjectArrays.arraysCopyOf(paramVarArgs, i);
    }
    for (;;)
    {
      return new RegularImmutableSet(paramVarArgs, k, arrayOfObject, i1);
    }
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return copyOf((Collection)paramIterable);
    }
    return copyOf(paramIterable.iterator());
  }
  
  public static <E> ImmutableSet<E> copyOf(Collection<? extends E> paramCollection)
  {
    if (((paramCollection instanceof ImmutableSet)) && (!(paramCollection instanceof ImmutableSortedSet)))
    {
      ImmutableSet localImmutableSet = (ImmutableSet)paramCollection;
      if (!localImmutableSet.isPartialView()) {
        return localImmutableSet;
      }
    }
    else if ((paramCollection instanceof EnumSet))
    {
      return copyOfEnumSet((EnumSet)paramCollection);
    }
    paramCollection = paramCollection.toArray();
    return construct(paramCollection.length, paramCollection);
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> paramIterator)
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
  
  public static <E> ImmutableSet<E> copyOf(E[] paramArrayOfE)
  {
    switch (paramArrayOfE.length)
    {
    default: 
      return construct(paramArrayOfE.length, (Object[])paramArrayOfE.clone());
    case 0: 
      return of();
    }
    return of(paramArrayOfE[0]);
  }
  
  private static ImmutableSet copyOfEnumSet(EnumSet paramEnumSet)
  {
    return ImmutableEnumSet.asImmutable(EnumSet.copyOf(paramEnumSet));
  }
  
  public static <E> ImmutableSet<E> of()
  {
    return RegularImmutableSet.EMPTY;
  }
  
  public static <E> ImmutableSet<E> of(E paramE)
  {
    return new SingletonImmutableSet(paramE);
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2)
  {
    return construct(2, new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(3, new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(4, new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(5, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 6];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
    return construct(arrayOfObject.length, arrayOfObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ImmutableSet)) && (isHashCodeFast()) && (((ImmutableSet)paramObject).isHashCodeFast()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return Sets.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  public abstract UnmodifiableIterator<E> iterator();
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
  
  public static class Builder<E>
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
    
    public ImmutableSet<E> build()
    {
      ImmutableSet localImmutableSet = ImmutableSet.construct(this.size, this.contents);
      this.size = localImmutableSet.size();
      return localImmutableSet;
    }
  }
  
  static abstract class Indexed<E>
    extends ImmutableSet<E>
  {
    ImmutableList<E> createAsList()
    {
      new ImmutableAsList()
      {
        ImmutableSet.Indexed<E> delegateCollection()
        {
          return ImmutableSet.Indexed.this;
        }
        
        public E get(int paramAnonymousInt)
        {
          return (E)ImmutableSet.Indexed.this.get(paramAnonymousInt);
        }
      };
    }
    
    abstract E get(int paramInt);
    
    public UnmodifiableIterator<E> iterator()
    {
      return asList().iterator();
    }
  }
  
  private static class SerializedForm
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
      return ImmutableSet.copyOf(this.elements);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */