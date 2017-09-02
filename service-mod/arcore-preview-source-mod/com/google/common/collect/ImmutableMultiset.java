package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableMultiset<E>
  extends ImmutableCollection<E>
  implements Multiset<E>
{
  private transient ImmutableSet<Multiset.Entry<E>> entrySet;
  
  public static <E> Builder<E> builder()
  {
    return new Builder();
  }
  
  private static <E> ImmutableMultiset<E> copyFromElements(E... paramVarArgs)
  {
    LinkedHashMultiset localLinkedHashMultiset = LinkedHashMultiset.create();
    Collections.addAll(localLinkedHashMultiset, paramVarArgs);
    return copyFromEntries(localLinkedHashMultiset.entrySet());
  }
  
  static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return of();
    }
    return new RegularImmutableMultiset(paramCollection);
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof ImmutableMultiset))
    {
      ImmutableMultiset localImmutableMultiset = (ImmutableMultiset)paramIterable;
      if (!localImmutableMultiset.isPartialView()) {
        return localImmutableMultiset;
      }
    }
    if ((paramIterable instanceof Multiset)) {}
    for (paramIterable = Multisets.cast(paramIterable);; paramIterable = LinkedHashMultiset.create(paramIterable)) {
      return copyFromEntries(paramIterable.entrySet());
    }
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> paramIterator)
  {
    LinkedHashMultiset localLinkedHashMultiset = LinkedHashMultiset.create();
    Iterators.addAll(localLinkedHashMultiset, paramIterator);
    return copyFromEntries(localLinkedHashMultiset.entrySet());
  }
  
  public static <E> ImmutableMultiset<E> copyOf(E[] paramArrayOfE)
  {
    return copyFromElements(paramArrayOfE);
  }
  
  private final ImmutableSet<Multiset.Entry<E>> createEntrySet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new EntrySet(null);
  }
  
  public static <E> ImmutableMultiset<E> of()
  {
    return RegularImmutableMultiset.EMPTY;
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE)
  {
    return copyFromElements(new Object[] { paramE });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2)
  {
    return copyFromElements(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return copyFromElements(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    return new Builder().add(paramE1).add(paramE2).add(paramE3).add(paramE4).add(paramE5).add(paramE6).add(paramVarArgs).build();
  }
  
  @Deprecated
  public final int add(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  @GwtIncompatible("not present in emulated superclass")
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      Arrays.fill(paramArrayOfObject, paramInt, localEntry.getCount() + paramInt, localEntry.getElement());
      paramInt += localEntry.getCount();
    }
    return paramInt;
  }
  
  public ImmutableSet<Multiset.Entry<E>> entrySet()
  {
    ImmutableSet localImmutableSet2 = this.entrySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createEntrySet();
      this.entrySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  abstract Multiset.Entry<E> getEntry(int paramInt);
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    new UnmodifiableIterator()
    {
      E element;
      int remaining;
      
      public boolean hasNext()
      {
        return (this.remaining > 0) || (this.val$entryIterator.hasNext());
      }
      
      public E next()
      {
        if (this.remaining <= 0)
        {
          Multiset.Entry localEntry = (Multiset.Entry)this.val$entryIterator.next();
          this.element = localEntry.getElement();
          this.remaining = localEntry.getCount();
        }
        this.remaining -= 1;
        return (E)this.element;
      }
    };
  }
  
  @Deprecated
  public final int remove(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final int setCount(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<E>
    extends ImmutableCollection.Builder<E>
  {
    final Multiset<E> contents;
    
    public Builder()
    {
      this(LinkedHashMultiset.create());
    }
    
    Builder(Multiset<E> paramMultiset)
    {
      this.contents = paramMultiset;
    }
    
    public Builder<E> add(E paramE)
    {
      this.contents.add(Preconditions.checkNotNull(paramE));
      return this;
    }
    
    public Builder<E> add(E... paramVarArgs)
    {
      super.add(paramVarArgs);
      return this;
    }
    
    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      if ((paramIterable instanceof Multiset))
      {
        paramIterable = Multisets.cast(paramIterable).entrySet().iterator();
        while (paramIterable.hasNext())
        {
          Multiset.Entry localEntry = (Multiset.Entry)paramIterable.next();
          addCopies(localEntry.getElement(), localEntry.getCount());
        }
      }
      super.addAll(paramIterable);
      return this;
    }
    
    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      super.addAll(paramIterator);
      return this;
    }
    
    public Builder<E> addCopies(E paramE, int paramInt)
    {
      this.contents.add(Preconditions.checkNotNull(paramE), paramInt);
      return this;
    }
    
    public ImmutableMultiset<E> build()
    {
      return ImmutableMultiset.copyOf(this.contents);
    }
    
    public Builder<E> setCount(E paramE, int paramInt)
    {
      this.contents.setCount(Preconditions.checkNotNull(paramE), paramInt);
      return this;
    }
  }
  
  private final class EntrySet
    extends ImmutableSet.Indexed<Multiset.Entry<E>>
  {
    private static final long serialVersionUID = 0L;
    
    private EntrySet() {}
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof Multiset.Entry))
      {
        paramObject = (Multiset.Entry)paramObject;
        if (((Multiset.Entry)paramObject).getCount() > 0) {
          break label23;
        }
      }
      label23:
      while (ImmutableMultiset.this.count(((Multiset.Entry)paramObject).getElement()) != ((Multiset.Entry)paramObject).getCount()) {
        return false;
      }
      return true;
    }
    
    Multiset.Entry<E> get(int paramInt)
    {
      return ImmutableMultiset.this.getEntry(paramInt);
    }
    
    public int hashCode()
    {
      return ImmutableMultiset.this.hashCode();
    }
    
    boolean isPartialView()
    {
      return ImmutableMultiset.this.isPartialView();
    }
    
    public int size()
    {
      return ImmutableMultiset.this.elementSet().size();
    }
    
    Object writeReplace()
    {
      return new ImmutableMultiset.EntrySetSerializedForm(ImmutableMultiset.this);
    }
  }
  
  static class EntrySetSerializedForm<E>
    implements Serializable
  {
    final ImmutableMultiset<E> multiset;
    
    EntrySetSerializedForm(ImmutableMultiset<E> paramImmutableMultiset)
    {
      this.multiset = paramImmutableMultiset;
    }
    
    Object readResolve()
    {
      return this.multiset.entrySet();
    }
  }
  
  private static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final int[] counts;
    final Object[] elements;
    
    SerializedForm(Multiset<?> paramMultiset)
    {
      int i = paramMultiset.entrySet().size();
      this.elements = new Object[i];
      this.counts = new int[i];
      i = 0;
      paramMultiset = paramMultiset.entrySet().iterator();
      while (paramMultiset.hasNext())
      {
        Multiset.Entry localEntry = (Multiset.Entry)paramMultiset.next();
        this.elements[i] = localEntry.getElement();
        this.counts[i] = localEntry.getCount();
        i += 1;
      }
    }
    
    Object readResolve()
    {
      LinkedHashMultiset localLinkedHashMultiset = LinkedHashMultiset.create(this.elements.length);
      int i = 0;
      while (i < this.elements.length)
      {
        localLinkedHashMultiset.add(this.elements[i], this.counts[i]);
        i += 1;
      }
      return ImmutableMultiset.copyOf(localLinkedHashMultiset);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */