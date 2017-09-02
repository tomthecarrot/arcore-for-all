package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets
{
  private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING = new Ordering()
  {
    public int compare(Multiset.Entry<?> paramAnonymousEntry1, Multiset.Entry<?> paramAnonymousEntry2)
    {
      return Ints.compare(paramAnonymousEntry2.getCount(), paramAnonymousEntry1.getCount());
    }
  };
  
  static <E> boolean addAllImpl(Multiset<E> paramMultiset, Collection<? extends E> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    if ((paramCollection instanceof Multiset))
    {
      paramCollection = cast(paramCollection).entrySet().iterator();
      while (paramCollection.hasNext())
      {
        Multiset.Entry localEntry = (Multiset.Entry)paramCollection.next();
        paramMultiset.add(localEntry.getElement(), localEntry.getCount());
      }
    }
    Iterators.addAll(paramMultiset, paramCollection.iterator());
    return true;
  }
  
  static <T> Multiset<T> cast(Iterable<T> paramIterable)
  {
    return (Multiset)paramIterable;
  }
  
  public static boolean containsOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2)
  {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    paramMultiset2 = paramMultiset2.entrySet().iterator();
    while (paramMultiset2.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)paramMultiset2.next();
      if (paramMultiset1.count(localEntry.getElement()) < localEntry.getCount()) {
        return false;
      }
    }
    return true;
  }
  
  @Beta
  public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> paramMultiset)
  {
    return ImmutableMultiset.copyFromEntries(DECREASING_COUNT_ORDERING.immutableSortedCopy(paramMultiset.entrySet()));
  }
  
  @Beta
  public static <E> Multiset<E> difference(Multiset<E> paramMultiset, final Multiset<?> paramMultiset1)
  {
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramMultiset1);
    new AbstractMultiset()
    {
      public int count(@Nullable Object paramAnonymousObject)
      {
        int i = this.val$multiset1.count(paramAnonymousObject);
        if (i == 0) {
          return 0;
        }
        return Math.max(0, i - paramMultiset1.count(paramAnonymousObject));
      }
      
      int distinctElements()
      {
        return Iterators.size(entryIterator());
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            while (this.val$iterator1.hasNext())
            {
              Multiset.Entry localEntry = (Multiset.Entry)this.val$iterator1.next();
              Object localObject = localEntry.getElement();
              int i = localEntry.getCount() - Multisets.4.this.val$multiset2.count(localObject);
              if (i > 0) {
                return Multisets.immutableEntry(localObject, i);
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
    };
  }
  
  static boolean equalsImpl(Multiset<?> paramMultiset, @Nullable Object paramObject)
  {
    if (paramObject == paramMultiset) {}
    Multiset.Entry localEntry;
    do
    {
      while (!((Iterator)paramObject).hasNext())
      {
        return true;
        if (!(paramObject instanceof Multiset)) {
          break;
        }
        paramObject = (Multiset)paramObject;
        if ((paramMultiset.size() != ((Multiset)paramObject).size()) || (paramMultiset.entrySet().size() != ((Multiset)paramObject).entrySet().size())) {
          return false;
        }
        paramObject = ((Multiset)paramObject).entrySet().iterator();
      }
      localEntry = (Multiset.Entry)((Iterator)paramObject).next();
    } while (paramMultiset.count(localEntry.getElement()) == localEntry.getCount());
    return false;
    return false;
  }
  
  @CheckReturnValue
  @Beta
  public static <E> Multiset<E> filter(Multiset<E> paramMultiset, Predicate<? super E> paramPredicate)
  {
    if ((paramMultiset instanceof FilteredMultiset))
    {
      paramMultiset = (FilteredMultiset)paramMultiset;
      paramPredicate = Predicates.and(paramMultiset.predicate, paramPredicate);
      return new FilteredMultiset(paramMultiset.unfiltered, paramPredicate);
    }
    return new FilteredMultiset(paramMultiset, paramPredicate);
  }
  
  public static <E> Multiset.Entry<E> immutableEntry(@Nullable E paramE, int paramInt)
  {
    return new ImmutableEntry(paramE, paramInt);
  }
  
  static int inferDistinctElements(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Multiset)) {
      return ((Multiset)paramIterable).elementSet().size();
    }
    return 11;
  }
  
  public static <E> Multiset<E> intersection(Multiset<E> paramMultiset, final Multiset<?> paramMultiset1)
  {
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramMultiset1);
    new AbstractMultiset()
    {
      public int count(Object paramAnonymousObject)
      {
        int i = this.val$multiset1.count(paramAnonymousObject);
        if (i == 0) {
          return 0;
        }
        return Math.min(i, paramMultiset1.count(paramAnonymousObject));
      }
      
      Set<E> createElementSet()
      {
        return Sets.intersection(this.val$multiset1.elementSet(), paramMultiset1.elementSet());
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            while (this.val$iterator1.hasNext())
            {
              Multiset.Entry localEntry = (Multiset.Entry)this.val$iterator1.next();
              Object localObject = localEntry.getElement();
              int i = Math.min(localEntry.getCount(), Multisets.2.this.val$multiset2.count(localObject));
              if (i > 0) {
                return Multisets.immutableEntry(localObject, i);
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
    };
  }
  
  static <E> Iterator<E> iteratorImpl(Multiset<E> paramMultiset)
  {
    return new MultisetIteratorImpl(paramMultiset, paramMultiset.entrySet().iterator());
  }
  
  static boolean removeAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection)
  {
    if ((paramCollection instanceof Multiset)) {
      paramCollection = ((Multiset)paramCollection).elementSet();
    }
    for (;;)
    {
      return paramMultiset.elementSet().removeAll(paramCollection);
    }
  }
  
  public static boolean removeOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2)
  {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    boolean bool = false;
    Iterator localIterator = paramMultiset1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      int i = paramMultiset2.count(localEntry.getElement());
      if (i >= localEntry.getCount())
      {
        localIterator.remove();
        bool = true;
      }
      else if (i > 0)
      {
        paramMultiset1.remove(localEntry.getElement(), i);
        bool = true;
      }
    }
    return bool;
  }
  
  public static boolean removeOccurrences(Multiset<?> paramMultiset, Iterable<?> paramIterable)
  {
    boolean bool2;
    if ((paramIterable instanceof Multiset))
    {
      bool2 = removeOccurrences(paramMultiset, (Multiset)paramIterable);
      return bool2;
    }
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramIterable);
    boolean bool1 = false;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      bool2 = bool1;
      if (!paramIterable.hasNext()) {
        break;
      }
      bool1 |= paramMultiset.remove(paramIterable.next());
    }
  }
  
  static boolean retainAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection);
    if ((paramCollection instanceof Multiset)) {
      paramCollection = ((Multiset)paramCollection).elementSet();
    }
    for (;;)
    {
      return paramMultiset.elementSet().retainAll(paramCollection);
    }
  }
  
  public static boolean retainOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2)
  {
    return retainOccurrencesImpl(paramMultiset1, paramMultiset2);
  }
  
  private static <E> boolean retainOccurrencesImpl(Multiset<E> paramMultiset, Multiset<?> paramMultiset1)
  {
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramMultiset1);
    Iterator localIterator = paramMultiset.entrySet().iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      int i = paramMultiset1.count(localEntry.getElement());
      if (i == 0)
      {
        localIterator.remove();
        bool = true;
      }
      else if (i < localEntry.getCount())
      {
        paramMultiset.setCount(localEntry.getElement(), i);
        bool = true;
      }
    }
    return bool;
  }
  
  static <E> int setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "count");
    int i = paramMultiset.count(paramE);
    paramInt -= i;
    if (paramInt > 0) {
      paramMultiset.add(paramE, paramInt);
    }
    while (paramInt >= 0) {
      return i;
    }
    paramMultiset.remove(paramE, -paramInt);
    return i;
  }
  
  static <E> boolean setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt1, int paramInt2)
  {
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    if (paramMultiset.count(paramE) == paramInt1)
    {
      paramMultiset.setCount(paramE, paramInt2);
      return true;
    }
    return false;
  }
  
  static int sizeImpl(Multiset<?> paramMultiset)
  {
    long l = 0L;
    paramMultiset = paramMultiset.entrySet().iterator();
    while (paramMultiset.hasNext()) {
      l += ((Multiset.Entry)paramMultiset.next()).getCount();
    }
    return Ints.saturatedCast(l);
  }
  
  @Beta
  public static <E> Multiset<E> sum(Multiset<? extends E> paramMultiset1, final Multiset<? extends E> paramMultiset2)
  {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    new AbstractMultiset()
    {
      public boolean contains(@Nullable Object paramAnonymousObject)
      {
        return (this.val$multiset1.contains(paramAnonymousObject)) || (paramMultiset2.contains(paramAnonymousObject));
      }
      
      public int count(Object paramAnonymousObject)
      {
        return this.val$multiset1.count(paramAnonymousObject) + paramMultiset2.count(paramAnonymousObject);
      }
      
      Set<E> createElementSet()
      {
        return Sets.union(this.val$multiset1.elementSet(), paramMultiset2.elementSet());
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            Multiset.Entry localEntry;
            Object localObject;
            if (this.val$iterator1.hasNext())
            {
              localEntry = (Multiset.Entry)this.val$iterator1.next();
              localObject = localEntry.getElement();
              return Multisets.immutableEntry(localObject, localEntry.getCount() + Multisets.3.this.val$multiset2.count(localObject));
            }
            while (this.val$iterator2.hasNext())
            {
              localEntry = (Multiset.Entry)this.val$iterator2.next();
              localObject = localEntry.getElement();
              if (!Multisets.3.this.val$multiset1.contains(localObject)) {
                return Multisets.immutableEntry(localObject, localEntry.getCount());
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      public boolean isEmpty()
      {
        return (this.val$multiset1.isEmpty()) && (paramMultiset2.isEmpty());
      }
      
      public int size()
      {
        return this.val$multiset1.size() + paramMultiset2.size();
      }
    };
  }
  
  @Beta
  public static <E> Multiset<E> union(Multiset<? extends E> paramMultiset1, final Multiset<? extends E> paramMultiset2)
  {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    new AbstractMultiset()
    {
      public boolean contains(@Nullable Object paramAnonymousObject)
      {
        return (this.val$multiset1.contains(paramAnonymousObject)) || (paramMultiset2.contains(paramAnonymousObject));
      }
      
      public int count(Object paramAnonymousObject)
      {
        return Math.max(this.val$multiset1.count(paramAnonymousObject), paramMultiset2.count(paramAnonymousObject));
      }
      
      Set<E> createElementSet()
      {
        return Sets.union(this.val$multiset1.elementSet(), paramMultiset2.elementSet());
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            Multiset.Entry localEntry;
            Object localObject;
            if (this.val$iterator1.hasNext())
            {
              localEntry = (Multiset.Entry)this.val$iterator1.next();
              localObject = localEntry.getElement();
              return Multisets.immutableEntry(localObject, Math.max(localEntry.getCount(), Multisets.1.this.val$multiset2.count(localObject)));
            }
            while (this.val$iterator2.hasNext())
            {
              localEntry = (Multiset.Entry)this.val$iterator2.next();
              localObject = localEntry.getElement();
              if (!Multisets.1.this.val$multiset1.contains(localObject)) {
                return Multisets.immutableEntry(localObject, localEntry.getCount());
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      public boolean isEmpty()
      {
        return (this.val$multiset1.isEmpty()) && (paramMultiset2.isEmpty());
      }
    };
  }
  
  @Deprecated
  public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> paramImmutableMultiset)
  {
    return (Multiset)Preconditions.checkNotNull(paramImmutableMultiset);
  }
  
  public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> paramMultiset)
  {
    if (((paramMultiset instanceof UnmodifiableMultiset)) || ((paramMultiset instanceof ImmutableMultiset))) {
      return paramMultiset;
    }
    return new UnmodifiableMultiset((Multiset)Preconditions.checkNotNull(paramMultiset));
  }
  
  @Beta
  public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> paramSortedMultiset)
  {
    return new UnmodifiableSortedMultiset((SortedMultiset)Preconditions.checkNotNull(paramSortedMultiset));
  }
  
  static abstract class AbstractEntry<E>
    implements Multiset.Entry<E>
  {
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Multiset.Entry))
      {
        paramObject = (Multiset.Entry)paramObject;
        bool1 = bool2;
        if (getCount() == ((Multiset.Entry)paramObject).getCount())
        {
          bool1 = bool2;
          if (Objects.equal(getElement(), ((Multiset.Entry)paramObject).getElement())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      Object localObject = getElement();
      if (localObject == null) {}
      for (int i = 0;; i = localObject.hashCode()) {
        return i ^ getCount();
      }
    }
    
    public String toString()
    {
      String str = String.valueOf(getElement());
      int i = getCount();
      if (i == 1) {
        return str;
      }
      return str + " x " + i;
    }
  }
  
  static abstract class ElementSet<E>
    extends Sets.ImprovedAbstractSet<E>
  {
    public void clear()
    {
      multiset().clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return multiset().contains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return multiset().containsAll(paramCollection);
    }
    
    public boolean isEmpty()
    {
      return multiset().isEmpty();
    }
    
    public Iterator<E> iterator()
    {
      new TransformedIterator(multiset().entrySet().iterator())
      {
        E transform(Multiset.Entry<E> paramAnonymousEntry)
        {
          return (E)paramAnonymousEntry.getElement();
        }
      };
    }
    
    abstract Multiset<E> multiset();
    
    public boolean remove(Object paramObject)
    {
      return multiset().remove(paramObject, Integer.MAX_VALUE) > 0;
    }
    
    public int size()
    {
      return multiset().entrySet().size();
    }
  }
  
  static abstract class EntrySet<E>
    extends Sets.ImprovedAbstractSet<Multiset.Entry<E>>
  {
    public void clear()
    {
      multiset().clear();
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Multiset.Entry))
      {
        paramObject = (Multiset.Entry)paramObject;
        if (((Multiset.Entry)paramObject).getCount() > 0) {
          break label23;
        }
      }
      label23:
      while (multiset().count(((Multiset.Entry)paramObject).getElement()) != ((Multiset.Entry)paramObject).getCount()) {
        return false;
      }
      return true;
    }
    
    abstract Multiset<E> multiset();
    
    public boolean remove(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Multiset.Entry))
      {
        paramObject = (Multiset.Entry)paramObject;
        Object localObject = ((Multiset.Entry)paramObject).getElement();
        int i = ((Multiset.Entry)paramObject).getCount();
        bool1 = bool2;
        if (i != 0) {
          bool1 = multiset().setCount(localObject, i, 0);
        }
      }
      return bool1;
    }
  }
  
  private static final class FilteredMultiset<E>
    extends AbstractMultiset<E>
  {
    final Predicate<? super E> predicate;
    final Multiset<E> unfiltered;
    
    FilteredMultiset(Multiset<E> paramMultiset, Predicate<? super E> paramPredicate)
    {
      this.unfiltered = ((Multiset)Preconditions.checkNotNull(paramMultiset));
      this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
    }
    
    public int add(@Nullable E paramE, int paramInt)
    {
      Preconditions.checkArgument(this.predicate.apply(paramE), "Element %s does not match predicate %s", new Object[] { paramE, this.predicate });
      return this.unfiltered.add(paramE, paramInt);
    }
    
    public void clear()
    {
      elementSet().clear();
    }
    
    public int count(@Nullable Object paramObject)
    {
      int i = this.unfiltered.count(paramObject);
      if (i > 0)
      {
        if (this.predicate.apply(paramObject)) {
          return i;
        }
        return 0;
      }
      return 0;
    }
    
    Set<E> createElementSet()
    {
      return Sets.filter(this.unfiltered.elementSet(), this.predicate);
    }
    
    Set<Multiset.Entry<E>> createEntrySet()
    {
      Sets.filter(this.unfiltered.entrySet(), new Predicate()
      {
        public boolean apply(Multiset.Entry<E> paramAnonymousEntry)
        {
          return Multisets.FilteredMultiset.this.predicate.apply(paramAnonymousEntry.getElement());
        }
      });
    }
    
    int distinctElements()
    {
      return elementSet().size();
    }
    
    Iterator<Multiset.Entry<E>> entryIterator()
    {
      throw new AssertionError("should never be called");
    }
    
    public UnmodifiableIterator<E> iterator()
    {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    public int remove(@Nullable Object paramObject, int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "occurrences");
      if (paramInt == 0) {
        return count(paramObject);
      }
      if (contains(paramObject)) {
        return this.unfiltered.remove(paramObject, paramInt);
      }
      return 0;
    }
  }
  
  static class ImmutableEntry<E>
    extends Multisets.AbstractEntry<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final int count;
    @Nullable
    private final E element;
    
    ImmutableEntry(@Nullable E paramE, int paramInt)
    {
      this.element = paramE;
      this.count = paramInt;
      CollectPreconditions.checkNonnegative(paramInt, "count");
    }
    
    public final int getCount()
    {
      return this.count;
    }
    
    @Nullable
    public final E getElement()
    {
      return (E)this.element;
    }
    
    public ImmutableEntry<E> nextInBucket()
    {
      return null;
    }
  }
  
  static final class MultisetIteratorImpl<E>
    implements Iterator<E>
  {
    private boolean canRemove;
    private Multiset.Entry<E> currentEntry;
    private final Iterator<Multiset.Entry<E>> entryIterator;
    private int laterCount;
    private final Multiset<E> multiset;
    private int totalCount;
    
    MultisetIteratorImpl(Multiset<E> paramMultiset, Iterator<Multiset.Entry<E>> paramIterator)
    {
      this.multiset = paramMultiset;
      this.entryIterator = paramIterator;
    }
    
    public boolean hasNext()
    {
      return (this.laterCount > 0) || (this.entryIterator.hasNext());
    }
    
    public E next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      if (this.laterCount == 0)
      {
        this.currentEntry = ((Multiset.Entry)this.entryIterator.next());
        int i = this.currentEntry.getCount();
        this.laterCount = i;
        this.totalCount = i;
      }
      this.laterCount -= 1;
      this.canRemove = true;
      return (E)this.currentEntry.getElement();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(this.canRemove);
      if (this.totalCount == 1) {
        this.entryIterator.remove();
      }
      for (;;)
      {
        this.totalCount -= 1;
        this.canRemove = false;
        return;
        this.multiset.remove(this.currentEntry.getElement());
      }
    }
  }
  
  static class UnmodifiableMultiset<E>
    extends ForwardingMultiset<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Multiset<? extends E> delegate;
    transient Set<E> elementSet;
    transient Set<Multiset.Entry<E>> entrySet;
    
    UnmodifiableMultiset(Multiset<? extends E> paramMultiset)
    {
      this.delegate = paramMultiset;
    }
    
    public int add(E paramE, int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    Set<E> createElementSet()
    {
      return Collections.unmodifiableSet(this.delegate.elementSet());
    }
    
    protected Multiset<E> delegate()
    {
      return this.delegate;
    }
    
    public Set<E> elementSet()
    {
      Set localSet2 = this.elementSet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = createElementSet();
        this.elementSet = localSet1;
      }
      return localSet1;
    }
    
    public Set<Multiset.Entry<E>> entrySet()
    {
      Set localSet2 = this.entrySet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = Collections.unmodifiableSet(this.delegate.entrySet());
        this.entrySet = localSet1;
      }
      return localSet1;
    }
    
    public Iterator<E> iterator()
    {
      return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
    
    public int remove(Object paramObject, int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int setCount(E paramE, int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean setCount(E paramE, int paramInt1, int paramInt2)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Multisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */