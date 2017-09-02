package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class ImmutableRangeSet<C extends Comparable>
  extends AbstractRangeSet<C>
  implements Serializable
{
  private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
  private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet(ImmutableList.of());
  private transient ImmutableRangeSet<C> complement;
  private final transient ImmutableList<Range<C>> ranges;
  
  ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList)
  {
    this.ranges = paramImmutableList;
  }
  
  private ImmutableRangeSet(ImmutableList<Range<C>> paramImmutableList, ImmutableRangeSet<C> paramImmutableRangeSet)
  {
    this.ranges = paramImmutableList;
    this.complement = paramImmutableRangeSet;
  }
  
  static <C extends Comparable> ImmutableRangeSet<C> all()
  {
    return ALL;
  }
  
  public static <C extends Comparable<?>> Builder<C> builder()
  {
    return new Builder();
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> paramRangeSet)
  {
    Preconditions.checkNotNull(paramRangeSet);
    Object localObject;
    if (paramRangeSet.isEmpty()) {
      localObject = of();
    }
    ImmutableRangeSet localImmutableRangeSet;
    do
    {
      return (ImmutableRangeSet<C>)localObject;
      if (paramRangeSet.encloses(Range.all())) {
        return all();
      }
      if (!(paramRangeSet instanceof ImmutableRangeSet)) {
        break;
      }
      localImmutableRangeSet = (ImmutableRangeSet)paramRangeSet;
      localObject = localImmutableRangeSet;
    } while (!localImmutableRangeSet.isPartialView());
    return new ImmutableRangeSet(ImmutableList.copyOf(paramRangeSet.asRanges()));
  }
  
  private ImmutableList<Range<C>> intersectRanges(final Range<C> paramRange)
  {
    if ((this.ranges.isEmpty()) || (paramRange.isEmpty())) {
      return ImmutableList.of();
    }
    if (paramRange.encloses(span())) {
      return this.ranges;
    }
    final int i;
    if (paramRange.hasLowerBound())
    {
      i = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), paramRange.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
      if (!paramRange.hasUpperBound()) {
        break label110;
      }
    }
    label110:
    for (final int j = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), paramRange.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);; j = this.ranges.size())
    {
      j -= i;
      if (j != 0) {
        break label121;
      }
      return ImmutableList.of();
      i = 0;
      break;
    }
    label121:
    new ImmutableList()
    {
      public Range<C> get(int paramAnonymousInt)
      {
        Preconditions.checkElementIndex(paramAnonymousInt, j);
        if ((paramAnonymousInt == 0) || (paramAnonymousInt == j - 1)) {
          return ((Range)ImmutableRangeSet.this.ranges.get(i + paramAnonymousInt)).intersection(paramRange);
        }
        return (Range)ImmutableRangeSet.this.ranges.get(i + paramAnonymousInt);
      }
      
      boolean isPartialView()
      {
        return true;
      }
      
      public int size()
      {
        return j;
      }
    };
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of()
  {
    return EMPTY;
  }
  
  public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    if (paramRange.isEmpty()) {
      return of();
    }
    if (paramRange.equals(Range.all())) {
      return all();
    }
    return new ImmutableRangeSet(ImmutableList.of(paramRange));
  }
  
  public void add(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public void addAll(RangeSet<C> paramRangeSet)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSet<Range<C>> asDescendingSetOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableSet.of();
    }
    return new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
  }
  
  public ImmutableSet<Range<C>> asRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableSet.of();
    }
    return new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
  }
  
  public ImmutableSortedSet<C> asSet(DiscreteDomain<C> paramDiscreteDomain)
  {
    Preconditions.checkNotNull(paramDiscreteDomain);
    if (isEmpty()) {
      return ImmutableSortedSet.of();
    }
    Range localRange = span().canonical(paramDiscreteDomain);
    if (!localRange.hasLowerBound()) {
      throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }
    if (!localRange.hasUpperBound()) {}
    try
    {
      paramDiscreteDomain.maxValue();
      return new AsSet(paramDiscreteDomain);
    }
    catch (NoSuchElementException paramDiscreteDomain)
    {
      throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
    }
  }
  
  public ImmutableRangeSet<C> complement()
  {
    ImmutableRangeSet localImmutableRangeSet = this.complement;
    if (localImmutableRangeSet != null) {
      return localImmutableRangeSet;
    }
    if (this.ranges.isEmpty())
    {
      localImmutableRangeSet = all();
      this.complement = localImmutableRangeSet;
      return localImmutableRangeSet;
    }
    if ((this.ranges.size() == 1) && (((Range)this.ranges.get(0)).equals(Range.all())))
    {
      localImmutableRangeSet = of();
      this.complement = localImmutableRangeSet;
      return localImmutableRangeSet;
    }
    localImmutableRangeSet = new ImmutableRangeSet(new ComplementRanges(), this);
    this.complement = localImmutableRangeSet;
    return localImmutableRangeSet;
  }
  
  public boolean encloses(Range<C> paramRange)
  {
    int i = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), paramRange.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    return (i != -1) && (((Range)this.ranges.get(i)).encloses(paramRange));
  }
  
  public boolean isEmpty()
  {
    return this.ranges.isEmpty();
  }
  
  boolean isPartialView()
  {
    return this.ranges.isPartialView();
  }
  
  public Range<C> rangeContaining(C paramC)
  {
    int i = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(paramC), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (i != -1)
    {
      Range localRange = (Range)this.ranges.get(i);
      if (localRange.contains(paramC)) {
        return localRange;
      }
      return null;
    }
    return null;
  }
  
  public void remove(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public void removeAll(RangeSet<C> paramRangeSet)
  {
    throw new UnsupportedOperationException();
  }
  
  public Range<C> span()
  {
    if (this.ranges.isEmpty()) {
      throw new NoSuchElementException();
    }
    return Range.create(((Range)this.ranges.get(0)).lowerBound, ((Range)this.ranges.get(this.ranges.size() - 1)).upperBound);
  }
  
  public ImmutableRangeSet<C> subRangeSet(Range<C> paramRange)
  {
    if (!isEmpty())
    {
      Range localRange = span();
      if (paramRange.encloses(localRange)) {
        return this;
      }
      if (paramRange.isConnected(localRange)) {
        return new ImmutableRangeSet(intersectRanges(paramRange));
      }
    }
    return of();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this.ranges);
  }
  
  private final class AsSet
    extends ImmutableSortedSet<C>
  {
    private final DiscreteDomain<C> domain;
    private transient Integer size;
    
    AsSet()
    {
      super();
      DiscreteDomain localDiscreteDomain;
      this.domain = localDiscreteDomain;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if (paramObject == null) {
        return false;
      }
      try
      {
        paramObject = (Comparable)paramObject;
        boolean bool = ImmutableRangeSet.this.contains((Comparable)paramObject);
        return bool;
      }
      catch (ClassCastException paramObject) {}
      return false;
    }
    
    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<C> descendingIterator()
    {
      new AbstractIterator()
      {
        Iterator<C> elemItr = Iterators.emptyIterator();
        final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.reverse().iterator();
        
        protected C computeNext()
        {
          while (!this.elemItr.hasNext()) {
            if (this.rangeItr.hasNext()) {
              this.elemItr = ContiguousSet.create((Range)this.rangeItr.next(), ImmutableRangeSet.AsSet.this.domain).descendingIterator();
            } else {
              return (Comparable)endOfData();
            }
          }
          return (Comparable)this.elemItr.next();
        }
      };
    }
    
    ImmutableSortedSet<C> headSetImpl(C paramC, boolean paramBoolean)
    {
      return subSet(Range.upTo(paramC, BoundType.forBoolean(paramBoolean)));
    }
    
    int indexOf(Object paramObject)
    {
      if (contains(paramObject))
      {
        paramObject = (Comparable)paramObject;
        long l = 0L;
        Iterator localIterator = ImmutableRangeSet.this.ranges.iterator();
        while (localIterator.hasNext())
        {
          Range localRange = (Range)localIterator.next();
          if (localRange.contains((Comparable)paramObject)) {
            return Ints.saturatedCast(ContiguousSet.create(localRange, this.domain).indexOf(paramObject) + l);
          }
          l += ContiguousSet.create(localRange, this.domain).size();
        }
        throw new AssertionError("impossible");
      }
      return -1;
    }
    
    boolean isPartialView()
    {
      return ImmutableRangeSet.this.ranges.isPartialView();
    }
    
    public UnmodifiableIterator<C> iterator()
    {
      new AbstractIterator()
      {
        Iterator<C> elemItr = Iterators.emptyIterator();
        final Iterator<Range<C>> rangeItr = ImmutableRangeSet.this.ranges.iterator();
        
        protected C computeNext()
        {
          while (!this.elemItr.hasNext()) {
            if (this.rangeItr.hasNext()) {
              this.elemItr = ContiguousSet.create((Range)this.rangeItr.next(), ImmutableRangeSet.AsSet.this.domain).iterator();
            } else {
              return (Comparable)endOfData();
            }
          }
          return (Comparable)this.elemItr.next();
        }
      };
    }
    
    public int size()
    {
      Integer localInteger = this.size;
      Object localObject = localInteger;
      if (localInteger == null)
      {
        long l1 = 0L;
        localObject = ImmutableRangeSet.this.ranges.iterator();
        long l2;
        do
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          l2 = l1 + ContiguousSet.create((Range)((Iterator)localObject).next(), this.domain).size();
          l1 = l2;
        } while (l2 < 2147483647L);
        localObject = Integer.valueOf(Ints.saturatedCast(l2));
        this.size = ((Integer)localObject);
      }
      return ((Integer)localObject).intValue();
    }
    
    ImmutableSortedSet<C> subSet(Range<C> paramRange)
    {
      return ImmutableRangeSet.this.subRangeSet(paramRange).asSet(this.domain);
    }
    
    ImmutableSortedSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
    {
      if ((!paramBoolean1) && (!paramBoolean2) && (Range.compareOrThrow(paramC1, paramC2) == 0)) {
        return ImmutableSortedSet.of();
      }
      return subSet(Range.range(paramC1, BoundType.forBoolean(paramBoolean1), paramC2, BoundType.forBoolean(paramBoolean2)));
    }
    
    ImmutableSortedSet<C> tailSetImpl(C paramC, boolean paramBoolean)
    {
      return subSet(Range.downTo(paramC, BoundType.forBoolean(paramBoolean)));
    }
    
    public String toString()
    {
      return ImmutableRangeSet.this.ranges.toString();
    }
    
    Object writeReplace()
    {
      return new ImmutableRangeSet.AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
    }
  }
  
  private static class AsSetSerializedForm<C extends Comparable>
    implements Serializable
  {
    private final DiscreteDomain<C> domain;
    private final ImmutableList<Range<C>> ranges;
    
    AsSetSerializedForm(ImmutableList<Range<C>> paramImmutableList, DiscreteDomain<C> paramDiscreteDomain)
    {
      this.ranges = paramImmutableList;
      this.domain = paramDiscreteDomain;
    }
    
    Object readResolve()
    {
      return new ImmutableRangeSet(this.ranges).asSet(this.domain);
    }
  }
  
  public static class Builder<C extends Comparable<?>>
  {
    private final RangeSet<C> rangeSet = TreeRangeSet.create();
    
    public Builder<C> add(Range<C> paramRange)
    {
      if (paramRange.isEmpty()) {
        throw new IllegalArgumentException("range must not be empty, but was " + paramRange);
      }
      if (!this.rangeSet.complement().encloses(paramRange))
      {
        Iterator localIterator = this.rangeSet.asRanges().iterator();
        if (localIterator.hasNext())
        {
          Range localRange = (Range)localIterator.next();
          if ((!localRange.isConnected(paramRange)) || (localRange.intersection(paramRange).isEmpty())) {}
          for (boolean bool = true;; bool = false)
          {
            Preconditions.checkArgument(bool, "Ranges may not overlap, but received %s and %s", new Object[] { localRange, paramRange });
            break;
          }
        }
        throw new AssertionError("should have thrown an IAE above");
      }
      this.rangeSet.add(paramRange);
      return this;
    }
    
    public Builder<C> addAll(RangeSet<C> paramRangeSet)
    {
      paramRangeSet = paramRangeSet.asRanges().iterator();
      while (paramRangeSet.hasNext()) {
        add((Range)paramRangeSet.next());
      }
      return this;
    }
    
    public ImmutableRangeSet<C> build()
    {
      return ImmutableRangeSet.copyOf(this.rangeSet);
    }
  }
  
  private final class ComplementRanges
    extends ImmutableList<Range<C>>
  {
    private final boolean positiveBoundedAbove = ((Range)Iterables.getLast(ImmutableRangeSet.this.ranges)).hasUpperBound();
    private final boolean positiveBoundedBelow = ((Range)ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
    private final int size;
    
    ComplementRanges()
    {
      int j = ImmutableRangeSet.this.ranges.size() - 1;
      int i = j;
      if (this.positiveBoundedBelow) {
        i = j + 1;
      }
      j = i;
      if (this.positiveBoundedAbove) {
        j = i + 1;
      }
      this.size = j;
    }
    
    public Range<C> get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, this.size);
      Cut localCut;
      if (this.positiveBoundedBelow) {
        if (paramInt == 0) {
          localCut = Cut.belowAll();
        }
      }
      while ((this.positiveBoundedAbove) && (paramInt == this.size - 1))
      {
        localObject = Cut.aboveAll();
        return Range.create(localCut, (Cut)localObject);
        localCut = ((Range)ImmutableRangeSet.this.ranges.get(paramInt - 1)).upperBound;
        continue;
        localCut = ((Range)ImmutableRangeSet.this.ranges.get(paramInt)).upperBound;
      }
      Object localObject = ImmutableRangeSet.this.ranges;
      if (this.positiveBoundedBelow) {}
      for (int i = 0;; i = 1)
      {
        localObject = ((Range)((ImmutableList)localObject).get(i + paramInt)).lowerBound;
        break;
      }
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.size;
    }
  }
  
  private static final class SerializedForm<C extends Comparable>
    implements Serializable
  {
    private final ImmutableList<Range<C>> ranges;
    
    SerializedForm(ImmutableList<Range<C>> paramImmutableList)
    {
      this.ranges = paramImmutableList;
    }
    
    Object readResolve()
    {
      if (this.ranges.isEmpty()) {
        return ImmutableRangeSet.of();
      }
      if (this.ranges.equals(ImmutableList.of(Range.all()))) {
        return ImmutableRangeSet.all();
      }
      return new ImmutableRangeSet(this.ranges);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */