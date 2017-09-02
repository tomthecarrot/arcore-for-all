package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("NavigableMap")
public class ImmutableRangeMap<K extends Comparable<?>, V>
  implements RangeMap<K, V>, Serializable
{
  private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
  private static final long serialVersionUID = 0L;
  private final transient ImmutableList<Range<K>> ranges;
  private final transient ImmutableList<V> values;
  
  ImmutableRangeMap(ImmutableList<Range<K>> paramImmutableList, ImmutableList<V> paramImmutableList1)
  {
    this.ranges = paramImmutableList;
    this.values = paramImmutableList1;
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> paramRangeMap)
  {
    if ((paramRangeMap instanceof ImmutableRangeMap)) {
      return (ImmutableRangeMap)paramRangeMap;
    }
    Object localObject = paramRangeMap.asMapOfRanges();
    paramRangeMap = new ImmutableList.Builder(((Map)localObject).size());
    ImmutableList.Builder localBuilder = new ImmutableList.Builder(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramRangeMap.add(localEntry.getKey());
      localBuilder.add(localEntry.getValue());
    }
    return new ImmutableRangeMap(paramRangeMap.build(), localBuilder.build());
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of()
  {
    return EMPTY;
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> paramRange, V paramV)
  {
    return new ImmutableRangeMap(ImmutableList.of(paramRange), ImmutableList.of(paramV));
  }
  
  public ImmutableMap<Range<K>, V> asDescendingMapOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableMap.of();
    }
    return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse()), this.values.reverse());
  }
  
  public ImmutableMap<Range<K>, V> asMapOfRanges()
  {
    if (this.ranges.isEmpty()) {
      return ImmutableMap.of();
    }
    return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING), this.values);
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof RangeMap))
    {
      paramObject = (RangeMap)paramObject;
      return asMapOfRanges().equals(((RangeMap)paramObject).asMapOfRanges());
    }
    return false;
  }
  
  @Nullable
  public V get(K paramK)
  {
    int i = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(paramK), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (i == -1) {}
    while (!((Range)this.ranges.get(i)).contains(paramK)) {
      return null;
    }
    return (V)this.values.get(i);
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K paramK)
  {
    int i = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(paramK), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (i == -1) {}
    Range localRange;
    do
    {
      return null;
      localRange = (Range)this.ranges.get(i);
    } while (!localRange.contains(paramK));
    return Maps.immutableEntry(localRange, this.values.get(i));
  }
  
  public int hashCode()
  {
    return asMapOfRanges().hashCode();
  }
  
  public void put(Range<K> paramRange, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(RangeMap<K, V> paramRangeMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public void remove(Range<K> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public Range<K> span()
  {
    if (this.ranges.isEmpty()) {
      throw new NoSuchElementException();
    }
    Range localRange1 = (Range)this.ranges.get(0);
    Range localRange2 = (Range)this.ranges.get(this.ranges.size() - 1);
    return Range.create(localRange1.lowerBound, localRange2.upperBound);
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(final Range<K> paramRange)
  {
    if (((Range)Preconditions.checkNotNull(paramRange)).isEmpty()) {
      return of();
    }
    if ((this.ranges.isEmpty()) || (paramRange.encloses(span()))) {
      return this;
    }
    final int i = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), paramRange.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    int j = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), paramRange.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    if (i >= j) {
      return of();
    }
    new ImmutableRangeMap(new ImmutableList()
    {
      public Range<K> get(int paramAnonymousInt)
      {
        Preconditions.checkElementIndex(paramAnonymousInt, this.val$len);
        if ((paramAnonymousInt == 0) || (paramAnonymousInt == this.val$len - 1)) {
          return ((Range)ImmutableRangeMap.this.ranges.get(i + paramAnonymousInt)).intersection(paramRange);
        }
        return (Range)ImmutableRangeMap.this.ranges.get(i + paramAnonymousInt);
      }
      
      boolean isPartialView()
      {
        return true;
      }
      
      public int size()
      {
        return this.val$len;
      }
    }, this.values.subList(i, j))
    {
      public ImmutableRangeMap<K, V> subRangeMap(Range<K> paramAnonymousRange)
      {
        if (paramRange.isConnected(paramAnonymousRange)) {
          return jdField_this.subRangeMap(paramAnonymousRange.intersection(paramRange));
        }
        return ImmutableRangeMap.of();
      }
    };
  }
  
  public String toString()
  {
    return asMapOfRanges().toString();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(asMapOfRanges());
  }
  
  public static final class Builder<K extends Comparable<?>, V>
  {
    private final RangeSet<K> keyRanges = TreeRangeSet.create();
    private final RangeMap<K, V> rangeMap = TreeRangeMap.create();
    
    public ImmutableRangeMap<K, V> build()
    {
      Object localObject = this.rangeMap.asMapOfRanges();
      ImmutableList.Builder localBuilder1 = new ImmutableList.Builder(((Map)localObject).size());
      ImmutableList.Builder localBuilder2 = new ImmutableList.Builder(((Map)localObject).size());
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localBuilder1.add(localEntry.getKey());
        localBuilder2.add(localEntry.getValue());
      }
      return new ImmutableRangeMap(localBuilder1.build(), localBuilder2.build());
    }
    
    public Builder<K, V> put(Range<K> paramRange, V paramV)
    {
      Preconditions.checkNotNull(paramRange);
      Preconditions.checkNotNull(paramV);
      if (!paramRange.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Range must not be empty, but was %s", new Object[] { paramRange });
        if (this.keyRanges.complement().encloses(paramRange)) {
          break;
        }
        Iterator localIterator = this.rangeMap.asMapOfRanges().entrySet().iterator();
        Map.Entry localEntry;
        Range localRange;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)localIterator.next();
          localRange = (Range)localEntry.getKey();
        } while ((!localRange.isConnected(paramRange)) || (localRange.intersection(paramRange).isEmpty()));
        throw new IllegalArgumentException("Overlapping ranges: range " + paramRange + " overlaps with entry " + localEntry);
      }
      this.keyRanges.add(paramRange);
      this.rangeMap.put(paramRange, paramV);
      return this;
    }
    
    public Builder<K, V> putAll(RangeMap<K, ? extends V> paramRangeMap)
    {
      paramRangeMap = paramRangeMap.asMapOfRanges().entrySet().iterator();
      while (paramRangeMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramRangeMap.next();
        put((Range)localEntry.getKey(), localEntry.getValue());
      }
      return this;
    }
  }
  
  private static class SerializedForm<K extends Comparable<?>, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final ImmutableMap<Range<K>, V> mapOfRanges;
    
    SerializedForm(ImmutableMap<Range<K>, V> paramImmutableMap)
    {
      this.mapOfRanges = paramImmutableMap;
    }
    
    Object createRangeMap()
    {
      ImmutableRangeMap.Builder localBuilder = new ImmutableRangeMap.Builder();
      Iterator localIterator = this.mapOfRanges.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.put((Range)localEntry.getKey(), localEntry.getValue());
      }
      return localBuilder.build();
    }
    
    Object readResolve()
    {
      if (this.mapOfRanges.isEmpty()) {
        return ImmutableRangeMap.of();
      }
      return createRangeMap();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */