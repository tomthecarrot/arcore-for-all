package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class RegularContiguousSet<C extends Comparable>
  extends ContiguousSet<C>
{
  private static final long serialVersionUID = 0L;
  private final Range<C> range;
  
  RegularContiguousSet(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain)
  {
    super(paramDiscreteDomain);
    this.range = paramRange;
  }
  
  private static boolean equalsOrThrow(Comparable<?> paramComparable1, @Nullable Comparable<?> paramComparable2)
  {
    return (paramComparable2 != null) && (Range.compareOrThrow(paramComparable1, paramComparable2) == 0);
  }
  
  private ContiguousSet<C> intersectionInCurrentDomain(Range<C> paramRange)
  {
    if (this.range.isConnected(paramRange)) {
      return ContiguousSet.create(this.range.intersection(paramRange), this.domain);
    }
    return new EmptyContiguousSet(this.domain);
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = this.range.contains((Comparable)paramObject);
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  @GwtIncompatible("NavigableSet")
  public UnmodifiableIterator<C> descendingIterator()
  {
    new AbstractSequentialIterator(last())
    {
      final C first = RegularContiguousSet.this.first();
      
      protected C computeNext(C paramAnonymousC)
      {
        if (RegularContiguousSet.equalsOrThrow(paramAnonymousC, this.first)) {
          return null;
        }
        return RegularContiguousSet.this.domain.previous(paramAnonymousC);
      }
    };
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    RegularContiguousSet localRegularContiguousSet;
    do
    {
      return true;
      if (!(paramObject instanceof RegularContiguousSet)) {
        break;
      }
      localRegularContiguousSet = (RegularContiguousSet)paramObject;
      if (!this.domain.equals(localRegularContiguousSet.domain)) {
        break;
      }
    } while ((first().equals(localRegularContiguousSet.first())) && (last().equals(localRegularContiguousSet.last())));
    return false;
    return super.equals(paramObject);
  }
  
  public C first()
  {
    return this.range.lowerBound.leastValueAbove(this.domain);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Range.upTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible("not used by GWT emulation")
  int indexOf(Object paramObject)
  {
    if (contains(paramObject)) {
      return (int)this.domain.distance(first(), (Comparable)paramObject);
    }
    return -1;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet)
  {
    Preconditions.checkNotNull(paramContiguousSet);
    Preconditions.checkArgument(this.domain.equals(paramContiguousSet.domain));
    if (paramContiguousSet.isEmpty()) {
      return paramContiguousSet;
    }
    Comparable localComparable = (Comparable)Ordering.natural().max(first(), paramContiguousSet.first());
    paramContiguousSet = (Comparable)Ordering.natural().min(last(), paramContiguousSet.last());
    if (localComparable.compareTo(paramContiguousSet) < 0) {}
    for (paramContiguousSet = ContiguousSet.create(Range.closed(localComparable, paramContiguousSet), this.domain);; paramContiguousSet = new EmptyContiguousSet(this.domain)) {
      return paramContiguousSet;
    }
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<C> iterator()
  {
    new AbstractSequentialIterator(first())
    {
      final C last = RegularContiguousSet.this.last();
      
      protected C computeNext(C paramAnonymousC)
      {
        if (RegularContiguousSet.equalsOrThrow(paramAnonymousC, this.last)) {
          return null;
        }
        return RegularContiguousSet.this.domain.next(paramAnonymousC);
      }
    };
  }
  
  public C last()
  {
    return this.range.upperBound.greatestValueBelow(this.domain);
  }
  
  public Range<C> range()
  {
    return range(BoundType.CLOSED, BoundType.CLOSED);
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    return Range.create(this.range.lowerBound.withLowerBoundType(paramBoundType1, this.domain), this.range.upperBound.withUpperBoundType(paramBoundType2, this.domain));
  }
  
  public int size()
  {
    long l = this.domain.distance(first(), last());
    if (l >= 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l + 1;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    if ((paramC1.compareTo(paramC2) == 0) && (!paramBoolean1) && (!paramBoolean2)) {
      return new EmptyContiguousSet(this.domain);
    }
    return intersectionInCurrentDomain(Range.range(paramC1, BoundType.forBoolean(paramBoolean1), paramC2, BoundType.forBoolean(paramBoolean2)));
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Range.downTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible("serialization")
  Object writeReplace()
  {
    return new SerializedForm(this.range, this.domain, null);
  }
  
  @GwtIncompatible("serialization")
  private static final class SerializedForm<C extends Comparable>
    implements Serializable
  {
    final DiscreteDomain<C> domain;
    final Range<C> range;
    
    private SerializedForm(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain)
    {
      this.range = paramRange;
      this.domain = paramDiscreteDomain;
    }
    
    private Object readResolve()
    {
      return new RegularContiguousSet(this.range, this.domain);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */