package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

@Beta
@GwtIncompatible("hasn't been tested yet")
public abstract class ImmutableSortedMultiset<E>
  extends ImmutableSortedMultisetFauxverideShim<E>
  implements SortedMultiset<E>
{
  private static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(NATURAL_ORDER);
  private static final Comparator<Comparable> NATURAL_ORDER = ;
  transient ImmutableSortedMultiset<E> descendingMultiset;
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> paramIterable)
  {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof ImmutableSortedMultiset))
    {
      localObject = (ImmutableSortedMultiset)paramIterable;
      if (paramComparator.equals(((ImmutableSortedMultiset)localObject).comparator()))
      {
        paramIterable = (Iterable<? extends E>)localObject;
        if (((ImmutableSortedMultiset)localObject).isPartialView()) {
          paramIterable = copyOfSortedEntries(paramComparator, ((ImmutableSortedMultiset)localObject).entrySet().asList());
        }
        return paramIterable;
      }
    }
    paramIterable = Lists.newArrayList(paramIterable);
    Object localObject = TreeMultiset.create((Comparator)Preconditions.checkNotNull(paramComparator));
    Iterables.addAll((Collection)localObject, paramIterable);
    return copyOfSortedEntries(paramComparator, ((TreeMultiset)localObject).entrySet());
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    Preconditions.checkNotNull(paramComparator);
    return new Builder(paramComparator).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] paramArrayOfE)
  {
    return copyOf(Ordering.natural(), Arrays.asList(paramArrayOfE));
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> paramSortedMultiset)
  {
    return copyOfSortedEntries(paramSortedMultiset.comparator(), Lists.newArrayList(paramSortedMultiset.entrySet()));
  }
  
  private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> paramComparator, Collection<Multiset.Entry<E>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return emptyMultiset(paramComparator);
    }
    ImmutableList.Builder localBuilder = new ImmutableList.Builder(paramCollection.size());
    long[] arrayOfLong = new long[paramCollection.size() + 1];
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      localBuilder.add(localEntry.getElement());
      arrayOfLong[(i + 1)] = (arrayOfLong[i] + localEntry.getCount());
      i += 1;
    }
    return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(localBuilder.build(), paramComparator), arrayOfLong, 0, paramCollection.size());
  }
  
  static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> paramComparator)
  {
    if (NATURAL_ORDER.equals(paramComparator)) {
      return NATURAL_EMPTY_MULTISET;
    }
    return new RegularImmutableSortedMultiset(paramComparator);
  }
  
  public static <E extends Comparable<?>> Builder<E> naturalOrder()
  {
    return new Builder(Ordering.natural());
  }
  
  public static <E> ImmutableSortedMultiset<E> of()
  {
    return NATURAL_EMPTY_MULTISET;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE)
  {
    return new RegularImmutableSortedMultiset((RegularImmutableSortedSet)ImmutableSortedSet.of(paramE), new long[] { 0L, 1L }, 0, 1);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramE1, paramE2 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3, paramE4 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    ArrayList localArrayList = Lists.newArrayListWithCapacity(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(Ordering.natural(), localArrayList);
  }
  
  public static <E> Builder<E> orderedBy(Comparator<E> paramComparator)
  {
    return new Builder(paramComparator);
  }
  
  public static <E extends Comparable<?>> Builder<E> reverseOrder()
  {
    return new Builder(Ordering.natural().reverse());
  }
  
  public final Comparator<? super E> comparator()
  {
    return elementSet().comparator();
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    Object localObject = this.descendingMultiset;
    if (localObject == null)
    {
      if (isEmpty()) {}
      for (localObject = emptyMultiset(Ordering.from(comparator()).reverse());; localObject = new DescendingImmutableSortedMultiset(this))
      {
        this.descendingMultiset = ((ImmutableSortedMultiset)localObject);
        return (ImmutableSortedMultiset<E>)localObject;
      }
    }
    return (ImmutableSortedMultiset<E>)localObject;
  }
  
  public abstract ImmutableSortedSet<E> elementSet();
  
  public abstract ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType);
  
  @Deprecated
  public final Multiset.Entry<E> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Multiset.Entry<E> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    if (comparator().compare(paramE1, paramE2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected lowerBound <= upperBound but %s > %s", new Object[] { paramE1, paramE2 });
      return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
    }
  }
  
  public abstract ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType);
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<E>
    extends ImmutableMultiset.Builder<E>
  {
    public Builder(Comparator<? super E> paramComparator)
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
    
    public Builder<E> addCopies(E paramE, int paramInt)
    {
      super.addCopies(paramE, paramInt);
      return this;
    }
    
    public ImmutableSortedMultiset<E> build()
    {
      return ImmutableSortedMultiset.copyOfSorted((SortedMultiset)this.contents);
    }
    
    public Builder<E> setCount(E paramE, int paramInt)
    {
      super.setCount(paramE, paramInt);
      return this;
    }
  }
  
  private static final class SerializedForm<E>
    implements Serializable
  {
    Comparator<? super E> comparator;
    int[] counts;
    E[] elements;
    
    SerializedForm(SortedMultiset<E> paramSortedMultiset)
    {
      this.comparator = paramSortedMultiset.comparator();
      int i = paramSortedMultiset.entrySet().size();
      this.elements = ((Object[])new Object[i]);
      this.counts = new int[i];
      i = 0;
      paramSortedMultiset = paramSortedMultiset.entrySet().iterator();
      while (paramSortedMultiset.hasNext())
      {
        Multiset.Entry localEntry = (Multiset.Entry)paramSortedMultiset.next();
        this.elements[i] = localEntry.getElement();
        this.counts[i] = localEntry.getCount();
        i += 1;
      }
    }
    
    Object readResolve()
    {
      int j = this.elements.length;
      ImmutableSortedMultiset.Builder localBuilder = new ImmutableSortedMultiset.Builder(this.comparator);
      int i = 0;
      while (i < j)
      {
        localBuilder.addCopies(this.elements[i], this.counts[i]);
        i += 1;
      }
      return localBuilder.build();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */