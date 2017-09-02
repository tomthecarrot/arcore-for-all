package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterables
{
  public static <T> boolean addAll(Collection<T> paramCollection, Iterable<? extends T> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll(Collections2.cast(paramIterable));
    }
    return Iterators.addAll(paramCollection, ((Iterable)Preconditions.checkNotNull(paramIterable)).iterator());
  }
  
  public static <T> boolean all(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.all(paramIterable.iterator(), paramPredicate);
  }
  
  public static <T> boolean any(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.any(paramIterable.iterator(), paramPredicate);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.concat(Iterables.iterators(this.val$inputs));
      }
    };
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    return concat(ImmutableList.of(paramIterable1, paramIterable2));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3)
  {
    return concat(ImmutableList.of(paramIterable1, paramIterable2, paramIterable3));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3, Iterable<? extends T> paramIterable4)
  {
    return concat(ImmutableList.of(paramIterable1, paramIterable2, paramIterable3, paramIterable4));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T>... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  public static <T> Iterable<T> consumingIterable(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof Queue)) {
      new FluentIterable()
      {
        public Iterator<T> iterator()
        {
          return new ConsumingQueueIterator((Queue)this.val$iterable);
        }
        
        public String toString()
        {
          return "Iterables.consumingIterable(...)";
        }
      };
    }
    Preconditions.checkNotNull(paramIterable);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.consumingIterator(this.val$iterable.iterator());
      }
      
      public String toString()
      {
        return "Iterables.consumingIterable(...)";
      }
    };
  }
  
  public static boolean contains(Iterable<?> paramIterable, @Nullable Object paramObject)
  {
    if ((paramIterable instanceof Collection)) {
      return Collections2.safeContains((Collection)paramIterable, paramObject);
    }
    return Iterators.contains(paramIterable.iterator(), paramObject);
  }
  
  public static <T> Iterable<T> cycle(Iterable<T> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.cycle(this.val$iterable);
      }
      
      public String toString()
      {
        return this.val$iterable.toString() + " (cycled)";
      }
    };
  }
  
  public static <T> Iterable<T> cycle(T... paramVarArgs)
  {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  @CheckReturnValue
  public static boolean elementsEqual(Iterable<?> paramIterable1, Iterable<?> paramIterable2)
  {
    if (((paramIterable1 instanceof Collection)) && ((paramIterable2 instanceof Collection)))
    {
      Collection localCollection1 = (Collection)paramIterable1;
      Collection localCollection2 = (Collection)paramIterable2;
      if (localCollection1.size() != localCollection2.size()) {
        return false;
      }
    }
    return Iterators.elementsEqual(paramIterable1.iterator(), paramIterable2.iterator());
  }
  
  @CheckReturnValue
  public static <T> Iterable<T> filter(Iterable<T> paramIterable, final Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramPredicate);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.filter(this.val$unfiltered.iterator(), paramPredicate);
      }
    };
  }
  
  @CheckReturnValue
  @GwtIncompatible("Class.isInstance")
  public static <T> Iterable<T> filter(Iterable<?> paramIterable, final Class<T> paramClass)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramClass);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.filter(this.val$unfiltered.iterator(), paramClass);
      }
    };
  }
  
  public static <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return (T)Iterators.find(paramIterable.iterator(), paramPredicate);
  }
  
  @Nullable
  public static <T> T find(Iterable<? extends T> paramIterable, Predicate<? super T> paramPredicate, @Nullable T paramT)
  {
    return (T)Iterators.find(paramIterable.iterator(), paramPredicate, paramT);
  }
  
  public static int frequency(Iterable<?> paramIterable, @Nullable Object paramObject)
  {
    if ((paramIterable instanceof Multiset)) {
      return ((Multiset)paramIterable).count(paramObject);
    }
    if ((paramIterable instanceof Set))
    {
      if (((Set)paramIterable).contains(paramObject)) {
        return 1;
      }
      return 0;
    }
    return Iterators.frequency(paramIterable.iterator(), paramObject);
  }
  
  public static <T> T get(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof List)) {
      return (T)((List)paramIterable).get(paramInt);
    }
    return (T)Iterators.get(paramIterable.iterator(), paramInt);
  }
  
  @Nullable
  public static <T> T get(Iterable<? extends T> paramIterable, int paramInt, @Nullable T paramT)
  {
    Preconditions.checkNotNull(paramIterable);
    Iterators.checkNonnegative(paramInt);
    if ((paramIterable instanceof List))
    {
      paramIterable = Lists.cast(paramIterable);
      if (paramInt < paramIterable.size()) {
        paramT = paramIterable.get(paramInt);
      }
      return paramT;
    }
    paramIterable = paramIterable.iterator();
    Iterators.advance(paramIterable, paramInt);
    return (T)Iterators.getNext(paramIterable, paramT);
  }
  
  @Nullable
  public static <T> T getFirst(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    return (T)Iterators.getNext(paramIterable.iterator(), paramT);
  }
  
  public static <T> T getLast(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if (paramIterable.isEmpty()) {
        throw new NoSuchElementException();
      }
      return (T)getLastInNonemptyList(paramIterable);
    }
    return (T)Iterators.getLast(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getLast(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    if ((paramIterable instanceof Collection))
    {
      if (Collections2.cast(paramIterable).isEmpty()) {
        return paramT;
      }
      if ((paramIterable instanceof List)) {
        return (T)getLastInNonemptyList(Lists.cast(paramIterable));
      }
    }
    return (T)Iterators.getLast(paramIterable.iterator(), paramT);
  }
  
  private static <T> T getLastInNonemptyList(List<T> paramList)
  {
    return (T)paramList.get(paramList.size() - 1);
  }
  
  public static <T> T getOnlyElement(Iterable<T> paramIterable)
  {
    return (T)Iterators.getOnlyElement(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getOnlyElement(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    return (T)Iterators.getOnlyElement(paramIterable.iterator(), paramT);
  }
  
  public static <T> int indexOf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.indexOf(paramIterable.iterator(), paramPredicate);
  }
  
  public static boolean isEmpty(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).isEmpty();
    }
    return !paramIterable.iterator().hasNext();
  }
  
  private static <T> Iterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    new TransformedIterator(paramIterable.iterator())
    {
      Iterator<? extends T> transform(Iterable<? extends T> paramAnonymousIterable)
      {
        return paramAnonymousIterable.iterator();
      }
    };
  }
  
  public static <T> Iterable<T> limit(Iterable<T> paramIterable, final int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "limit is negative");
      new FluentIterable()
      {
        public Iterator<T> iterator()
        {
          return Iterators.limit(this.val$iterable.iterator(), paramInt);
        }
      };
    }
  }
  
  @Beta
  public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> paramIterable, final Comparator<? super T> paramComparator)
  {
    Preconditions.checkNotNull(paramIterable, "iterables");
    Preconditions.checkNotNull(paramComparator, "comparator");
    new UnmodifiableIterable(new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.access$200()), paramComparator);
      }
    }, null);
  }
  
  public static <T> Iterable<List<T>> paddedPartition(Iterable<T> paramIterable, final int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new FluentIterable()
      {
        public Iterator<List<T>> iterator()
        {
          return Iterators.paddedPartition(this.val$iterable.iterator(), paramInt);
        }
      };
    }
  }
  
  public static <T> Iterable<List<T>> partition(Iterable<T> paramIterable, final int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new FluentIterable()
      {
        public Iterator<List<T>> iterator()
        {
          return Iterators.partition(this.val$iterable.iterator(), paramInt);
        }
      };
    }
  }
  
  public static boolean removeAll(Iterable<?> paramIterable, Collection<?> paramCollection)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).removeAll((Collection)Preconditions.checkNotNull(paramCollection));
    }
    return Iterators.removeAll(paramIterable.iterator(), paramCollection);
  }
  
  @Nullable
  static <T> T removeFirstMatching(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramPredicate.apply(localObject))
      {
        paramIterable.remove();
        return (T)localObject;
      }
    }
    return null;
  }
  
  public static <T> boolean removeIf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    if (((paramIterable instanceof RandomAccess)) && ((paramIterable instanceof List))) {
      return removeIfFromRandomAccessList((List)paramIterable, (Predicate)Preconditions.checkNotNull(paramPredicate));
    }
    return Iterators.removeIf(paramIterable.iterator(), paramPredicate);
  }
  
  private static <T> boolean removeIfFromRandomAccessList(List<T> paramList, Predicate<? super T> paramPredicate)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        int k = j;
        if ((paramPredicate.apply(localObject)) || (i > j)) {}
        try
        {
          paramList.set(j, localObject);
          k = j + 1;
          i += 1;
          j = k;
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          slowRemoveIfForRemainingElements(paramList, paramPredicate, j, i);
        }
      }
    }
    do
    {
      return true;
      paramList.subList(j, paramList.size()).clear();
    } while (i != j);
    return false;
  }
  
  public static boolean retainAll(Iterable<?> paramIterable, Collection<?> paramCollection)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).retainAll((Collection)Preconditions.checkNotNull(paramCollection));
    }
    return Iterators.retainAll(paramIterable.iterator(), paramCollection);
  }
  
  public static int size(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).size();
    }
    return Iterators.size(paramIterable.iterator());
  }
  
  public static <T> Iterable<T> skip(Iterable<T> paramIterable, final int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "number to skip cannot be negative");
      if (!(paramIterable instanceof List)) {
        break;
      }
      new FluentIterable()
      {
        public Iterator<T> iterator()
        {
          int i = Math.min(this.val$list.size(), paramInt);
          return this.val$list.subList(i, this.val$list.size()).iterator();
        }
      };
    }
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        final Iterator localIterator = this.val$iterable.iterator();
        Iterators.advance(localIterator, paramInt);
        new Iterator()
        {
          boolean atStart = true;
          
          public boolean hasNext()
          {
            return localIterator.hasNext();
          }
          
          public T next()
          {
            Object localObject = localIterator.next();
            this.atStart = false;
            return (T)localObject;
          }
          
          public void remove()
          {
            if (!this.atStart) {}
            for (boolean bool = true;; bool = false)
            {
              CollectPreconditions.checkRemove(bool);
              localIterator.remove();
              return;
            }
          }
        };
      }
    };
  }
  
  private static <T> void slowRemoveIfForRemainingElements(List<T> paramList, Predicate<? super T> paramPredicate, int paramInt1, int paramInt2)
  {
    int i = paramList.size() - 1;
    while (i > paramInt2)
    {
      if (paramPredicate.apply(paramList.get(i))) {
        paramList.remove(i);
      }
      i -= 1;
    }
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      paramList.remove(paramInt2);
      paramInt2 -= 1;
    }
  }
  
  static Object[] toArray(Iterable<?> paramIterable)
  {
    return toCollection(paramIterable).toArray();
  }
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static <T> T[] toArray(Iterable<? extends T> paramIterable, Class<T> paramClass)
  {
    paramIterable = toCollection(paramIterable);
    return paramIterable.toArray(ObjectArrays.newArray(paramClass, paramIterable.size()));
  }
  
  static <T> T[] toArray(Iterable<? extends T> paramIterable, T[] paramArrayOfT)
  {
    return toCollection(paramIterable).toArray(paramArrayOfT);
  }
  
  private static <E> Collection<E> toCollection(Iterable<E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return (Collection)paramIterable;
    }
    return Lists.newArrayList(paramIterable.iterator());
  }
  
  private static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator()
  {
    new Function()
    {
      public Iterator<? extends T> apply(Iterable<? extends T> paramAnonymousIterable)
      {
        return paramAnonymousIterable.iterator();
      }
    };
  }
  
  public static String toString(Iterable<?> paramIterable)
  {
    return Iterators.toString(paramIterable.iterator());
  }
  
  @CheckReturnValue
  public static <F, T> Iterable<T> transform(Iterable<F> paramIterable, final Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunction);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.transform(this.val$fromIterable.iterator(), paramFunction);
      }
    };
  }
  
  public static <T> Optional<T> tryFind(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.tryFind(paramIterable.iterator(), paramPredicate);
  }
  
  @Deprecated
  public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> paramImmutableCollection)
  {
    return (Iterable)Preconditions.checkNotNull(paramImmutableCollection);
  }
  
  public static <T> Iterable<T> unmodifiableIterable(Iterable<T> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if (((paramIterable instanceof UnmodifiableIterable)) || ((paramIterable instanceof ImmutableCollection))) {
      return paramIterable;
    }
    return new UnmodifiableIterable(paramIterable, null);
  }
  
  private static final class UnmodifiableIterable<T>
    extends FluentIterable<T>
  {
    private final Iterable<T> iterable;
    
    private UnmodifiableIterable(Iterable<T> paramIterable)
    {
      this.iterable = paramIterable;
    }
    
    public Iterator<T> iterator()
    {
      return Iterators.unmodifiableIterator(this.iterable.iterator());
    }
    
    public String toString()
    {
      return this.iterable.toString();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Iterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */