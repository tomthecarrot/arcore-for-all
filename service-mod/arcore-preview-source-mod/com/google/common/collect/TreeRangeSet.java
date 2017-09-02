package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("uses NavigableMap")
public class TreeRangeSet<C extends Comparable<?>>
  extends AbstractRangeSet<C>
{
  private transient Set<Range<C>> asDescendingSetOfRanges;
  private transient Set<Range<C>> asRanges;
  private transient RangeSet<C> complement;
  @VisibleForTesting
  final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
  
  private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> paramNavigableMap)
  {
    this.rangesByLowerBound = paramNavigableMap;
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create()
  {
    return new TreeRangeSet(new TreeMap());
  }
  
  public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> paramRangeSet)
  {
    TreeRangeSet localTreeRangeSet = create();
    localTreeRangeSet.addAll(paramRangeSet);
    return localTreeRangeSet;
  }
  
  @Nullable
  private Range<C> rangeEnclosing(Range<C> paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    if ((localEntry != null) && (((Range)localEntry.getValue()).encloses(paramRange))) {
      return (Range)localEntry.getValue();
    }
    return null;
  }
  
  private void replaceRangeWithSameLowerBound(Range<C> paramRange)
  {
    if (paramRange.isEmpty())
    {
      this.rangesByLowerBound.remove(paramRange.lowerBound);
      return;
    }
    this.rangesByLowerBound.put(paramRange.lowerBound, paramRange);
  }
  
  public void add(Range<C> paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    if (paramRange.isEmpty()) {
      return;
    }
    Object localObject3 = paramRange.lowerBound;
    Object localObject2 = paramRange.upperBound;
    Object localObject4 = this.rangesByLowerBound.lowerEntry(localObject3);
    Object localObject1 = localObject3;
    paramRange = (Range<C>)localObject2;
    if (localObject4 != null)
    {
      localObject4 = (Range)((Map.Entry)localObject4).getValue();
      localObject1 = localObject3;
      paramRange = (Range<C>)localObject2;
      if (((Range)localObject4).upperBound.compareTo((Cut)localObject3) >= 0)
      {
        paramRange = (Range<C>)localObject2;
        if (((Range)localObject4).upperBound.compareTo((Cut)localObject2) >= 0) {
          paramRange = ((Range)localObject4).upperBound;
        }
        localObject1 = ((Range)localObject4).lowerBound;
      }
    }
    localObject3 = this.rangesByLowerBound.floorEntry(paramRange);
    localObject2 = paramRange;
    if (localObject3 != null)
    {
      localObject3 = (Range)((Map.Entry)localObject3).getValue();
      localObject2 = paramRange;
      if (((Range)localObject3).upperBound.compareTo(paramRange) >= 0) {
        localObject2 = ((Range)localObject3).upperBound;
      }
    }
    this.rangesByLowerBound.subMap(localObject1, localObject2).clear();
    replaceRangeWithSameLowerBound(Range.create((Cut)localObject1, (Cut)localObject2));
  }
  
  public Set<Range<C>> asDescendingSetOfRanges()
  {
    Set localSet = this.asDescendingSetOfRanges;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new AsRanges(this.rangesByLowerBound.descendingMap().values());
      this.asDescendingSetOfRanges = ((Set)localObject);
    }
    return (Set<Range<C>>)localObject;
  }
  
  public Set<Range<C>> asRanges()
  {
    Set localSet = this.asRanges;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new AsRanges(this.rangesByLowerBound.values());
      this.asRanges = ((Set)localObject);
    }
    return (Set<Range<C>>)localObject;
  }
  
  public RangeSet<C> complement()
  {
    RangeSet localRangeSet = this.complement;
    Object localObject = localRangeSet;
    if (localRangeSet == null)
    {
      localObject = new Complement();
      this.complement = ((RangeSet)localObject);
    }
    return (RangeSet<C>)localObject;
  }
  
  public boolean encloses(Range<C> paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(paramRange.lowerBound);
    return (localEntry != null) && (((Range)localEntry.getValue()).encloses(paramRange));
  }
  
  @Nullable
  public Range<C> rangeContaining(C paramC)
  {
    Preconditions.checkNotNull(paramC);
    Map.Entry localEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(paramC));
    if ((localEntry != null) && (((Range)localEntry.getValue()).contains(paramC))) {
      return (Range)localEntry.getValue();
    }
    return null;
  }
  
  public void remove(Range<C> paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    if (paramRange.isEmpty()) {
      return;
    }
    Object localObject = this.rangesByLowerBound.lowerEntry(paramRange.lowerBound);
    if (localObject != null)
    {
      localObject = (Range)((Map.Entry)localObject).getValue();
      if (((Range)localObject).upperBound.compareTo(paramRange.lowerBound) >= 0)
      {
        if ((paramRange.hasUpperBound()) && (((Range)localObject).upperBound.compareTo(paramRange.upperBound) >= 0)) {
          replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, ((Range)localObject).upperBound));
        }
        replaceRangeWithSameLowerBound(Range.create(((Range)localObject).lowerBound, paramRange.lowerBound));
      }
    }
    localObject = this.rangesByLowerBound.floorEntry(paramRange.upperBound);
    if (localObject != null)
    {
      localObject = (Range)((Map.Entry)localObject).getValue();
      if ((paramRange.hasUpperBound()) && (((Range)localObject).upperBound.compareTo(paramRange.upperBound) >= 0)) {
        replaceRangeWithSameLowerBound(Range.create(paramRange.upperBound, ((Range)localObject).upperBound));
      }
    }
    this.rangesByLowerBound.subMap(paramRange.lowerBound, paramRange.upperBound).clear();
  }
  
  public Range<C> span()
  {
    Map.Entry localEntry1 = this.rangesByLowerBound.firstEntry();
    Map.Entry localEntry2 = this.rangesByLowerBound.lastEntry();
    if (localEntry1 == null) {
      throw new NoSuchElementException();
    }
    return Range.create(((Range)localEntry1.getValue()).lowerBound, ((Range)localEntry2.getValue()).upperBound);
  }
  
  public RangeSet<C> subRangeSet(Range<C> paramRange)
  {
    if (paramRange.equals(Range.all())) {
      return this;
    }
    return new SubRangeSet(paramRange);
  }
  
  final class AsRanges
    extends ForwardingCollection<Range<C>>
    implements Set<Range<C>>
  {
    final Collection<Range<C>> delegate;
    
    AsRanges()
    {
      Collection localCollection;
      this.delegate = localCollection;
    }
    
    protected Collection<Range<C>> delegate()
    {
      return this.delegate;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return Sets.equalsImpl(this, paramObject);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
  
  private final class Complement
    extends TreeRangeSet<C>
  {
    Complement()
    {
      super(null);
    }
    
    public void add(Range<C> paramRange)
    {
      TreeRangeSet.this.remove(paramRange);
    }
    
    public RangeSet<C> complement()
    {
      return TreeRangeSet.this;
    }
    
    public boolean contains(C paramC)
    {
      return !TreeRangeSet.this.contains(paramC);
    }
    
    public void remove(Range<C> paramRange)
    {
      TreeRangeSet.this.add(paramRange);
    }
  }
  
  private static final class ComplementRangesByLowerBound<C extends Comparable<?>>
    extends AbstractNavigableMap<Cut<C>, Range<C>>
  {
    private final Range<Cut<C>> complementLowerBoundWindow;
    private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
    private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;
    
    ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> paramNavigableMap)
    {
      this(paramNavigableMap, Range.all());
    }
    
    private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> paramNavigableMap, Range<Cut<C>> paramRange)
    {
      this.positiveRangesByLowerBound = paramNavigableMap;
      this.positiveRangesByUpperBound = new TreeRangeSet.RangesByUpperBound(paramNavigableMap);
      this.complementLowerBoundWindow = paramRange;
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> paramRange)
    {
      if (!this.complementLowerBoundWindow.isConnected(paramRange)) {
        return ImmutableSortedMap.of();
      }
      paramRange = paramRange.intersection(this.complementLowerBoundWindow);
      return new ComplementRangesByLowerBound(this.positiveRangesByLowerBound, paramRange);
    }
    
    public Comparator<? super Cut<C>> comparator()
    {
      return Ordering.natural();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return get(paramObject) != null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
    {
      Cut localCut;
      boolean bool;
      label46:
      final PeekingIterator localPeekingIterator;
      if (this.complementLowerBoundWindow.hasUpperBound())
      {
        localCut = (Cut)this.complementLowerBoundWindow.upperEndpoint();
        if ((!this.complementLowerBoundWindow.hasUpperBound()) || (this.complementLowerBoundWindow.upperBoundType() != BoundType.CLOSED)) {
          break label143;
        }
        bool = true;
        localPeekingIterator = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(localCut, bool).descendingMap().values().iterator());
        if (!localPeekingIterator.hasNext()) {
          break label176;
        }
        if (((Range)localPeekingIterator.peek()).upperBound != Cut.aboveAll()) {
          break label148;
        }
        localCut = ((Range)localPeekingIterator.next()).lowerBound;
      }
      for (;;)
      {
        new AbstractIterator()
        {
          Cut<C> nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
          
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if (this.nextComplementRangeUpperBound == Cut.belowAll()) {
              return (Map.Entry)endOfData();
            }
            Range localRange1;
            if (localPeekingIterator.hasNext())
            {
              localRange1 = (Range)localPeekingIterator.next();
              Range localRange2 = Range.create(localRange1.upperBound, this.nextComplementRangeUpperBound);
              this.nextComplementRangeUpperBound = localRange1.lowerBound;
              if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan(localRange2.lowerBound)) {
                return Maps.immutableEntry(localRange2.lowerBound, localRange2);
              }
            }
            else if (TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.lowerBound.isLessThan(Cut.belowAll()))
            {
              localRange1 = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
              this.nextComplementRangeUpperBound = Cut.belowAll();
              return Maps.immutableEntry(Cut.belowAll(), localRange1);
            }
            return (Map.Entry)endOfData();
          }
        };
        localCut = Cut.aboveAll();
        break;
        label143:
        bool = false;
        break label46;
        label148:
        localCut = (Cut)this.positiveRangesByLowerBound.higherKey(((Range)localPeekingIterator.peek()).upperBound);
        continue;
        label176:
        if ((!this.complementLowerBoundWindow.contains(Cut.belowAll())) || (this.positiveRangesByLowerBound.containsKey(Cut.belowAll()))) {
          return Iterators.emptyIterator();
        }
        localCut = (Cut)this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
      }
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator()
    {
      final Object localObject2;
      boolean bool;
      if (this.complementLowerBoundWindow.hasLowerBound())
      {
        localObject1 = this.positiveRangesByUpperBound;
        localObject2 = this.complementLowerBoundWindow.lowerEndpoint();
        if (this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED)
        {
          bool = true;
          localObject1 = ((NavigableMap)localObject1).tailMap(localObject2, bool).values();
          label52:
          localObject2 = Iterators.peekingIterator(((Collection)localObject1).iterator());
          if ((!this.complementLowerBoundWindow.contains(Cut.belowAll())) || ((((PeekingIterator)localObject2).hasNext()) && (((Range)((PeekingIterator)localObject2).peek()).lowerBound == Cut.belowAll()))) {
            break label135;
          }
        }
      }
      for (final Object localObject1 = Cut.belowAll();; localObject1 = ((Range)((PeekingIterator)localObject2).next()).upperBound)
      {
        new AbstractIterator()
        {
          Cut<C> nextComplementRangeLowerBound = localObject1;
          
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if ((TreeRangeSet.ComplementRangesByLowerBound.this.complementLowerBoundWindow.upperBound.isLessThan(this.nextComplementRangeLowerBound)) || (this.nextComplementRangeLowerBound == Cut.aboveAll())) {
              return (Map.Entry)endOfData();
            }
            Range localRange2;
            Range localRange1;
            if (localObject2.hasNext())
            {
              localRange2 = (Range)localObject2.next();
              localRange1 = Range.create(this.nextComplementRangeLowerBound, localRange2.lowerBound);
            }
            for (this.nextComplementRangeLowerBound = localRange2.upperBound;; this.nextComplementRangeLowerBound = Cut.aboveAll())
            {
              return Maps.immutableEntry(localRange1.lowerBound, localRange1);
              localRange1 = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
            }
          }
        };
        bool = false;
        break;
        localObject1 = this.positiveRangesByUpperBound.values();
        break label52;
        label135:
        if (!((PeekingIterator)localObject2).hasNext()) {
          break label160;
        }
      }
      label160:
      return Iterators.emptyIterator();
    }
    
    @Nullable
    public Range<C> get(Object paramObject)
    {
      if ((paramObject instanceof Cut)) {
        try
        {
          paramObject = (Cut)paramObject;
          Map.Entry localEntry = tailMap((Cut)paramObject, true).firstEntry();
          if ((localEntry != null) && (((Cut)localEntry.getKey()).equals(paramObject)))
          {
            paramObject = (Range)localEntry.getValue();
            return (Range<C>)paramObject;
          }
        }
        catch (ClassCastException paramObject)
        {
          return null;
        }
      }
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.upTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
    
    public int size()
    {
      return Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> paramCut1, boolean paramBoolean1, Cut<C> paramCut2, boolean paramBoolean2)
    {
      return subMap(Range.range(paramCut1, BoundType.forBoolean(paramBoolean1), paramCut2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.downTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
  }
  
  @VisibleForTesting
  static final class RangesByUpperBound<C extends Comparable<?>>
    extends AbstractNavigableMap<Cut<C>, Range<C>>
  {
    private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
    private final Range<Cut<C>> upperBoundWindow;
    
    RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> paramNavigableMap)
    {
      this.rangesByLowerBound = paramNavigableMap;
      this.upperBoundWindow = Range.all();
    }
    
    private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> paramNavigableMap, Range<Cut<C>> paramRange)
    {
      this.rangesByLowerBound = paramNavigableMap;
      this.upperBoundWindow = paramRange;
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> paramRange)
    {
      if (paramRange.isConnected(this.upperBoundWindow)) {
        return new RangesByUpperBound(this.rangesByLowerBound, paramRange.intersection(this.upperBoundWindow));
      }
      return ImmutableSortedMap.of();
    }
    
    public Comparator<? super Cut<C>> comparator()
    {
      return Ordering.natural();
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return get(paramObject) != null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
    {
      if (this.upperBoundWindow.hasUpperBound()) {}
      for (final Object localObject = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();; localObject = this.rangesByLowerBound.descendingMap().values())
      {
        localObject = Iterators.peekingIterator(((Collection)localObject).iterator());
        if ((((PeekingIterator)localObject).hasNext()) && (this.upperBoundWindow.upperBound.isLessThan(((Range)((PeekingIterator)localObject).peek()).upperBound))) {
          ((PeekingIterator)localObject).next();
        }
        new AbstractIterator()
        {
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if (!localObject.hasNext()) {
              return (Map.Entry)endOfData();
            }
            Range localRange = (Range)localObject.next();
            if (TreeRangeSet.RangesByUpperBound.this.upperBoundWindow.lowerBound.isLessThan(localRange.upperBound)) {
              return Maps.immutableEntry(localRange.upperBound, localRange);
            }
            return (Map.Entry)endOfData();
          }
        };
      }
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator()
    {
      final Object localObject;
      if (!this.upperBoundWindow.hasLowerBound()) {
        localObject = this.rangesByLowerBound.values().iterator();
      }
      for (;;)
      {
        new AbstractIterator()
        {
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if (!localObject.hasNext()) {
              return (Map.Entry)endOfData();
            }
            Range localRange = (Range)localObject.next();
            if (TreeRangeSet.RangesByUpperBound.this.upperBoundWindow.upperBound.isLessThan(localRange.upperBound)) {
              return (Map.Entry)endOfData();
            }
            return Maps.immutableEntry(localRange.upperBound, localRange);
          }
        };
        localObject = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
        if (localObject == null) {
          localObject = this.rangesByLowerBound.values().iterator();
        } else if (this.upperBoundWindow.lowerBound.isLessThan(((Range)((Map.Entry)localObject).getValue()).upperBound)) {
          localObject = this.rangesByLowerBound.tailMap(((Map.Entry)localObject).getKey(), true).values().iterator();
        } else {
          localObject = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
        }
      }
    }
    
    public Range<C> get(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Cut)) {
        try
        {
          paramObject = (Cut)paramObject;
          if (!this.upperBoundWindow.contains((Comparable)paramObject)) {
            return null;
          }
          Map.Entry localEntry = this.rangesByLowerBound.lowerEntry(paramObject);
          if ((localEntry != null) && (((Range)localEntry.getValue()).upperBound.equals(paramObject)))
          {
            paramObject = (Range)localEntry.getValue();
            return (Range<C>)paramObject;
          }
        }
        catch (ClassCastException paramObject)
        {
          return null;
        }
      }
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.upTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
    
    public boolean isEmpty()
    {
      if (this.upperBoundWindow.equals(Range.all())) {
        return this.rangesByLowerBound.isEmpty();
      }
      return !entryIterator().hasNext();
    }
    
    public int size()
    {
      if (this.upperBoundWindow.equals(Range.all())) {
        return this.rangesByLowerBound.size();
      }
      return Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> paramCut1, boolean paramBoolean1, Cut<C> paramCut2, boolean paramBoolean2)
    {
      return subMap(Range.range(paramCut1, BoundType.forBoolean(paramBoolean1), paramCut2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.downTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
  }
  
  private final class SubRangeSet
    extends TreeRangeSet<C>
  {
    private final Range<C> restriction;
    
    SubRangeSet()
    {
      super(null);
      this.restriction = localRange;
    }
    
    public void add(Range<C> paramRange)
    {
      Preconditions.checkArgument(this.restriction.encloses(paramRange), "Cannot add range %s to subRangeSet(%s)", new Object[] { paramRange, this.restriction });
      super.add(paramRange);
    }
    
    public void clear()
    {
      TreeRangeSet.this.remove(this.restriction);
    }
    
    public boolean contains(C paramC)
    {
      return (this.restriction.contains(paramC)) && (TreeRangeSet.this.contains(paramC));
    }
    
    public boolean encloses(Range<C> paramRange)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!this.restriction.isEmpty())
      {
        bool1 = bool2;
        if (this.restriction.encloses(paramRange))
        {
          paramRange = TreeRangeSet.this.rangeEnclosing(paramRange);
          bool1 = bool2;
          if (paramRange != null)
          {
            bool1 = bool2;
            if (!paramRange.intersection(this.restriction).isEmpty()) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    @Nullable
    public Range<C> rangeContaining(C paramC)
    {
      if (!this.restriction.contains(paramC)) {}
      do
      {
        return null;
        paramC = TreeRangeSet.this.rangeContaining(paramC);
      } while (paramC == null);
      return paramC.intersection(this.restriction);
    }
    
    public void remove(Range<C> paramRange)
    {
      if (paramRange.isConnected(this.restriction)) {
        TreeRangeSet.this.remove(paramRange.intersection(this.restriction));
      }
    }
    
    public RangeSet<C> subRangeSet(Range<C> paramRange)
    {
      if (paramRange.encloses(this.restriction)) {
        return this;
      }
      if (paramRange.isConnected(this.restriction)) {
        return new SubRangeSet(this, this.restriction.intersection(paramRange));
      }
      return ImmutableRangeSet.of();
    }
  }
  
  private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>>
    extends AbstractNavigableMap<Cut<C>, Range<C>>
  {
    private final Range<Cut<C>> lowerBoundWindow;
    private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
    private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
    private final Range<C> restriction;
    
    private SubRangeSetRangesByLowerBound(Range<Cut<C>> paramRange, Range<C> paramRange1, NavigableMap<Cut<C>, Range<C>> paramNavigableMap)
    {
      this.lowerBoundWindow = ((Range)Preconditions.checkNotNull(paramRange));
      this.restriction = ((Range)Preconditions.checkNotNull(paramRange1));
      this.rangesByLowerBound = ((NavigableMap)Preconditions.checkNotNull(paramNavigableMap));
      this.rangesByUpperBound = new TreeRangeSet.RangesByUpperBound(paramNavigableMap);
    }
    
    private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> paramRange)
    {
      if (!paramRange.isConnected(this.lowerBoundWindow)) {
        return ImmutableSortedMap.of();
      }
      return new SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(paramRange), this.restriction, this.rangesByLowerBound);
    }
    
    public Comparator<? super Cut<C>> comparator()
    {
      return Ordering.natural();
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return get(paramObject) != null;
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
    {
      if (this.restriction.isEmpty()) {
        return Iterators.emptyIterator();
      }
      Cut localCut = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
      NavigableMap localNavigableMap = this.rangesByLowerBound;
      Comparable localComparable = localCut.endpoint();
      if (localCut.typeAsUpperBound() == BoundType.CLOSED) {}
      for (boolean bool = true;; bool = false) {
        new AbstractIterator()
        {
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if (!this.val$completeRangeItr.hasNext()) {
              return (Map.Entry)endOfData();
            }
            Range localRange = (Range)this.val$completeRangeItr.next();
            if (TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction.lowerBound.compareTo(localRange.upperBound) >= 0) {
              return (Map.Entry)endOfData();
            }
            localRange = localRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction);
            if (TreeRangeSet.SubRangeSetRangesByLowerBound.this.lowerBoundWindow.contains(localRange.lowerBound)) {
              return Maps.immutableEntry(localRange.lowerBound, localRange);
            }
            return (Map.Entry)endOfData();
          }
        };
      }
    }
    
    Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator()
    {
      boolean bool = false;
      if (this.restriction.isEmpty()) {
        return Iterators.emptyIterator();
      }
      if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound)) {
        return Iterators.emptyIterator();
      }
      if (this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound)) {}
      Comparable localComparable;
      for (final Object localObject = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();; localObject = ((NavigableMap)localObject).tailMap(localComparable, bool).values().iterator())
      {
        new AbstractIterator()
        {
          protected Map.Entry<Cut<C>, Range<C>> computeNext()
          {
            if (!localObject.hasNext()) {
              return (Map.Entry)endOfData();
            }
            Range localRange = (Range)localObject.next();
            if (this.val$upperBoundOnLowerBounds.isLessThan(localRange.lowerBound)) {
              return (Map.Entry)endOfData();
            }
            localRange = localRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.this.restriction);
            return Maps.immutableEntry(localRange.lowerBound, localRange);
          }
        };
        localObject = this.rangesByLowerBound;
        localComparable = this.lowerBoundWindow.lowerBound.endpoint();
        if (this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED) {
          bool = true;
        }
      }
    }
    
    @Nullable
    public Range<C> get(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Cut)) {
        try
        {
          paramObject = (Cut)paramObject;
          if ((this.lowerBoundWindow.contains((Comparable)paramObject)) && (((Cut)paramObject).compareTo(this.restriction.lowerBound) >= 0))
          {
            if (((Cut)paramObject).compareTo(this.restriction.upperBound) >= 0) {
              return null;
            }
            if (((Cut)paramObject).equals(this.restriction.lowerBound))
            {
              paramObject = (Range)Maps.valueOrNull(this.rangesByLowerBound.floorEntry(paramObject));
              if ((paramObject != null) && (((Range)paramObject).upperBound.compareTo(this.restriction.lowerBound) > 0)) {
                return ((Range)paramObject).intersection(this.restriction);
              }
            }
            else
            {
              paramObject = (Range)this.rangesByLowerBound.get(paramObject);
              if (paramObject != null)
              {
                paramObject = ((Range)paramObject).intersection(this.restriction);
                return (Range<C>)paramObject;
              }
            }
          }
        }
        catch (ClassCastException paramObject) {}
      }
      return null;
    }
    
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.upTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
    
    public int size()
    {
      return Iterators.size(entryIterator());
    }
    
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> paramCut1, boolean paramBoolean1, Cut<C> paramCut2, boolean paramBoolean2)
    {
      return subMap(Range.range(paramCut1, BoundType.forBoolean(paramBoolean1), paramCut2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> paramCut, boolean paramBoolean)
    {
      return subMap(Range.downTo(paramCut, BoundType.forBoolean(paramBoolean)));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/TreeRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */