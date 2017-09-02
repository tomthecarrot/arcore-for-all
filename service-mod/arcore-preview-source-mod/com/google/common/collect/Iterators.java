package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterators
{
  static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public boolean hasPrevious()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public int nextIndex()
    {
      return 0;
    }
    
    public Object previous()
    {
      throw new NoSuchElementException();
    }
    
    public int previousIndex()
    {
      return -1;
    }
  };
  private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(false);
    }
  };
  
  public static <T> boolean addAll(Collection<T> paramCollection, Iterator<? extends T> paramIterator)
  {
    Preconditions.checkNotNull(paramCollection);
    Preconditions.checkNotNull(paramIterator);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramCollection.add(paramIterator.next());
    }
    return bool;
  }
  
  public static int advance(Iterator<?> paramIterator, int paramInt)
  {
    Preconditions.checkNotNull(paramIterator);
    if (paramInt >= 0) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "numberToAdvance must be nonnegative");
      i = 0;
      while ((i < paramInt) && (paramIterator.hasNext()))
      {
        paramIterator.next();
        i += 1;
      }
    }
    return i;
  }
  
  public static <T> boolean all(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    while (paramIterator.hasNext()) {
      if (!paramPredicate.apply(paramIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static <T> boolean any(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    return indexOf(paramIterator, paramPredicate) != -1;
  }
  
  public static <T> Enumeration<T> asEnumeration(Iterator<T> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    new Enumeration()
    {
      public boolean hasMoreElements()
      {
        return this.val$iterator.hasNext();
      }
      
      public T nextElement()
      {
        return (T)this.val$iterator.next();
      }
    };
  }
  
  static <T> ListIterator<T> cast(Iterator<T> paramIterator)
  {
    return (ListIterator)paramIterator;
  }
  
  static void checkNonnegative(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("position (" + paramInt + ") must not be negative");
    }
  }
  
  static void clear(Iterator<?> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    new Iterator()
    {
      Iterator<? extends T> current = Iterators.emptyIterator();
      Iterator<? extends T> removeFrom;
      
      public boolean hasNext()
      {
        boolean bool;
        for (;;)
        {
          bool = ((Iterator)Preconditions.checkNotNull(this.current)).hasNext();
          if ((bool) || (!this.val$inputs.hasNext())) {
            break;
          }
          this.current = ((Iterator)this.val$inputs.next());
        }
        return bool;
      }
      
      public T next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        this.removeFrom = this.current;
        return (T)this.current.next();
      }
      
      public void remove()
      {
        if (this.removeFrom != null) {}
        for (boolean bool = true;; bool = false)
        {
          CollectPreconditions.checkRemove(bool);
          this.removeFrom.remove();
          this.removeFrom = null;
          return;
        }
      }
    };
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2)
  {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    return concat(new ConsumingQueueIterator(new Iterator[] { paramIterator1, paramIterator2 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3)
  {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    Preconditions.checkNotNull(paramIterator3);
    return concat(new ConsumingQueueIterator(new Iterator[] { paramIterator1, paramIterator2, paramIterator3 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3, Iterator<? extends T> paramIterator4)
  {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    Preconditions.checkNotNull(paramIterator3);
    Preconditions.checkNotNull(paramIterator4);
    return concat(new ConsumingQueueIterator(new Iterator[] { paramIterator1, paramIterator2, paramIterator3, paramIterator4 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T>... paramVarArgs)
  {
    Iterator[] arrayOfIterator = (Iterator[])Preconditions.checkNotNull(paramVarArgs);
    int j = arrayOfIterator.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(arrayOfIterator[i]);
      i += 1;
    }
    return concat(new ConsumingQueueIterator(paramVarArgs));
  }
  
  public static <T> Iterator<T> consumingIterator(Iterator<T> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return this.val$iterator.hasNext();
      }
      
      public T next()
      {
        Object localObject = this.val$iterator.next();
        this.val$iterator.remove();
        return (T)localObject;
      }
      
      public String toString()
      {
        return "Iterators.consumingIterator(...)";
      }
    };
  }
  
  public static boolean contains(Iterator<?> paramIterator, @Nullable Object paramObject)
  {
    return any(paramIterator, Predicates.equalTo(paramObject));
  }
  
  public static <T> Iterator<T> cycle(Iterable<T> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    new Iterator()
    {
      Iterator<T> iterator = Iterators.emptyModifiableIterator();
      
      public boolean hasNext()
      {
        return (this.iterator.hasNext()) || (this.val$iterable.iterator().hasNext());
      }
      
      public T next()
      {
        if (!this.iterator.hasNext())
        {
          this.iterator = this.val$iterable.iterator();
          if (!this.iterator.hasNext()) {
            throw new NoSuchElementException();
          }
        }
        return (T)this.iterator.next();
      }
      
      public void remove()
      {
        this.iterator.remove();
      }
    };
  }
  
  public static <T> Iterator<T> cycle(T... paramVarArgs)
  {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterator<?> paramIterator1, Iterator<?> paramIterator2)
  {
    if (paramIterator1.hasNext()) {
      if (paramIterator2.hasNext()) {}
    }
    while (paramIterator2.hasNext())
    {
      return false;
      if (Objects.equal(paramIterator1.next(), paramIterator2.next())) {
        break;
      }
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static <T> UnmodifiableIterator<T> emptyIterator()
  {
    return emptyListIterator();
  }
  
  static <T> UnmodifiableListIterator<T> emptyListIterator()
  {
    return EMPTY_LIST_ITERATOR;
  }
  
  static <T> Iterator<T> emptyModifiableIterator()
  {
    return EMPTY_MODIFIABLE_ITERATOR;
  }
  
  @CheckReturnValue
  public static <T> UnmodifiableIterator<T> filter(Iterator<T> paramIterator, final Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterator);
    Preconditions.checkNotNull(paramPredicate);
    new AbstractIterator()
    {
      protected T computeNext()
      {
        while (this.val$unfiltered.hasNext())
        {
          Object localObject = this.val$unfiltered.next();
          if (paramPredicate.apply(localObject)) {
            return (T)localObject;
          }
        }
        return (T)endOfData();
      }
    };
  }
  
  @CheckReturnValue
  @GwtIncompatible("Class.isInstance")
  public static <T> UnmodifiableIterator<T> filter(Iterator<?> paramIterator, Class<T> paramClass)
  {
    return filter(paramIterator, Predicates.instanceOf(paramClass));
  }
  
  public static <T> T find(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    return (T)filter(paramIterator, paramPredicate).next();
  }
  
  @Nullable
  public static <T> T find(Iterator<? extends T> paramIterator, Predicate<? super T> paramPredicate, @Nullable T paramT)
  {
    return (T)getNext(filter(paramIterator, paramPredicate), paramT);
  }
  
  public static <T> UnmodifiableIterator<T> forArray(T... paramVarArgs)
  {
    return forArray(paramVarArgs, 0, paramVarArgs.length, 0);
  }
  
  static <T> UnmodifiableListIterator<T> forArray(final T[] paramArrayOfT, final int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfT.length);
      Preconditions.checkPositionIndex(paramInt3, paramInt2);
      if (paramInt2 != 0) {
        break;
      }
      return emptyListIterator();
    }
    new AbstractIndexedListIterator(paramInt2, paramInt3)
    {
      protected T get(int paramAnonymousInt)
      {
        return (T)paramArrayOfT[(paramInt1 + paramAnonymousInt)];
      }
    };
  }
  
  public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> paramEnumeration)
  {
    Preconditions.checkNotNull(paramEnumeration);
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return this.val$enumeration.hasMoreElements();
      }
      
      public T next()
      {
        return (T)this.val$enumeration.nextElement();
      }
    };
  }
  
  public static int frequency(Iterator<?> paramIterator, @Nullable Object paramObject)
  {
    return size(filter(paramIterator, Predicates.equalTo(paramObject)));
  }
  
  public static <T> T get(Iterator<T> paramIterator, int paramInt)
  {
    checkNonnegative(paramInt);
    int i = advance(paramIterator, paramInt);
    if (!paramIterator.hasNext()) {
      throw new IndexOutOfBoundsException("position (" + paramInt + ") must be less than the number of elements that remained (" + i + ")");
    }
    return (T)paramIterator.next();
  }
  
  @Nullable
  public static <T> T get(Iterator<? extends T> paramIterator, int paramInt, @Nullable T paramT)
  {
    checkNonnegative(paramInt);
    advance(paramIterator, paramInt);
    return (T)getNext(paramIterator, paramT);
  }
  
  public static <T> T getLast(Iterator<T> paramIterator)
  {
    Object localObject;
    do
    {
      localObject = paramIterator.next();
    } while (paramIterator.hasNext());
    return (T)localObject;
  }
  
  @Nullable
  public static <T> T getLast(Iterator<? extends T> paramIterator, @Nullable T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = getLast(paramIterator);
    }
    return paramT;
  }
  
  @Nullable
  public static <T> T getNext(Iterator<? extends T> paramIterator, @Nullable T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = paramIterator.next();
    }
    return paramT;
  }
  
  public static <T> T getOnlyElement(Iterator<T> paramIterator)
  {
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return (T)localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected one element but was: <" + localObject);
    int i = 0;
    while ((i < 4) && (paramIterator.hasNext()))
    {
      localStringBuilder.append(", " + paramIterator.next());
      i += 1;
    }
    if (paramIterator.hasNext()) {
      localStringBuilder.append(", ...");
    }
    localStringBuilder.append('>');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @Nullable
  public static <T> T getOnlyElement(Iterator<? extends T> paramIterator, @Nullable T paramT)
  {
    if (paramIterator.hasNext()) {
      paramT = getOnlyElement(paramIterator);
    }
    return paramT;
  }
  
  public static <T> int indexOf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate, "predicate");
    int i = 0;
    while (paramIterator.hasNext())
    {
      if (paramPredicate.apply(paramIterator.next())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static <T> Iterator<T> limit(final Iterator<T> paramIterator, int paramInt)
  {
    Preconditions.checkNotNull(paramIterator);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "limit is negative");
      new Iterator()
      {
        private int count;
        
        public boolean hasNext()
        {
          return (this.count < this.val$limitSize) && (paramIterator.hasNext());
        }
        
        public T next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          this.count += 1;
          return (T)paramIterator.next();
        }
        
        public void remove()
        {
          paramIterator.remove();
        }
      };
    }
  }
  
  @Beta
  public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> paramIterable, Comparator<? super T> paramComparator)
  {
    Preconditions.checkNotNull(paramIterable, "iterators");
    Preconditions.checkNotNull(paramComparator, "comparator");
    return new MergingIterator(paramIterable, paramComparator);
  }
  
  public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> paramIterator, int paramInt)
  {
    return partitionImpl(paramIterator, paramInt, true);
  }
  
  public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> paramIterator, int paramInt)
  {
    return partitionImpl(paramIterator, paramInt, false);
  }
  
  private static <T> UnmodifiableIterator<List<T>> partitionImpl(Iterator<T> paramIterator, final int paramInt, final boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramIterator);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new UnmodifiableIterator()
      {
        public boolean hasNext()
        {
          return this.val$iterator.hasNext();
        }
        
        public List<T> next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          Object localObject = new Object[paramInt];
          int i = 0;
          while ((i < paramInt) && (this.val$iterator.hasNext()))
          {
            localObject[i] = this.val$iterator.next();
            i += 1;
          }
          int j = i;
          while (j < paramInt)
          {
            localObject[j] = null;
            j += 1;
          }
          localObject = Collections.unmodifiableList(Arrays.asList((Object[])localObject));
          if ((paramBoolean) || (i == paramInt)) {
            return (List<T>)localObject;
          }
          return ((List)localObject).subList(0, i);
        }
      };
    }
  }
  
  @Deprecated
  public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> paramPeekingIterator)
  {
    return (PeekingIterator)Preconditions.checkNotNull(paramPeekingIterator);
  }
  
  public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> paramIterator)
  {
    if ((paramIterator instanceof PeekingImpl)) {
      return (PeekingImpl)paramIterator;
    }
    return new PeekingImpl(paramIterator);
  }
  
  @Nullable
  static <T> T pollNext(Iterator<T> paramIterator)
  {
    if (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      paramIterator.remove();
      return (T)localObject;
    }
    return null;
  }
  
  public static boolean removeAll(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    return removeIf(paramIterator, Predicates.in(paramCollection));
  }
  
  public static <T> boolean removeIf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramPredicate.apply(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  public static boolean retainAll(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    return removeIf(paramIterator, Predicates.not(Predicates.in(paramCollection)));
  }
  
  public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable T paramT)
  {
    new UnmodifiableIterator()
    {
      boolean done;
      
      public boolean hasNext()
      {
        return !this.done;
      }
      
      public T next()
      {
        if (this.done) {
          throw new NoSuchElementException();
        }
        this.done = true;
        return (T)this.val$value;
      }
    };
  }
  
  public static int size(Iterator<?> paramIterator)
  {
    int i = 0;
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      i += 1;
    }
    return i;
  }
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static <T> T[] toArray(Iterator<? extends T> paramIterator, Class<T> paramClass)
  {
    return Iterables.toArray(Lists.newArrayList(paramIterator), paramClass);
  }
  
  public static String toString(Iterator<?> paramIterator)
  {
    return ']';
  }
  
  public static <F, T> Iterator<T> transform(Iterator<F> paramIterator, final Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    new TransformedIterator(paramIterator)
    {
      T transform(F paramAnonymousF)
      {
        return (T)paramFunction.apply(paramAnonymousF);
      }
    };
  }
  
  public static <T> Optional<T> tryFind(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    paramIterator = filter(paramIterator, paramPredicate);
    if (paramIterator.hasNext()) {
      return Optional.of(paramIterator.next());
    }
    return Optional.absent();
  }
  
  @Deprecated
  public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> paramUnmodifiableIterator)
  {
    return (UnmodifiableIterator)Preconditions.checkNotNull(paramUnmodifiableIterator);
  }
  
  public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<T> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    if ((paramIterator instanceof UnmodifiableIterator)) {
      return (UnmodifiableIterator)paramIterator;
    }
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return this.val$iterator.hasNext();
      }
      
      public T next()
      {
        return (T)this.val$iterator.next();
      }
    };
  }
  
  private static class MergingIterator<T>
    extends UnmodifiableIterator<T>
  {
    final Queue<PeekingIterator<T>> queue;
    
    public MergingIterator(Iterable<? extends Iterator<? extends T>> paramIterable, final Comparator<? super T> paramComparator)
    {
      this.queue = new PriorityQueue(2, new Comparator()
      {
        public int compare(PeekingIterator<T> paramAnonymousPeekingIterator1, PeekingIterator<T> paramAnonymousPeekingIterator2)
        {
          return paramComparator.compare(paramAnonymousPeekingIterator1.peek(), paramAnonymousPeekingIterator2.peek());
        }
      });
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        paramComparator = (Iterator)paramIterable.next();
        if (paramComparator.hasNext()) {
          this.queue.add(Iterators.peekingIterator(paramComparator));
        }
      }
    }
    
    public boolean hasNext()
    {
      return !this.queue.isEmpty();
    }
    
    public T next()
    {
      PeekingIterator localPeekingIterator = (PeekingIterator)this.queue.remove();
      Object localObject = localPeekingIterator.next();
      if (localPeekingIterator.hasNext()) {
        this.queue.add(localPeekingIterator);
      }
      return (T)localObject;
    }
  }
  
  private static class PeekingImpl<E>
    implements PeekingIterator<E>
  {
    private boolean hasPeeked;
    private final Iterator<? extends E> iterator;
    private E peekedElement;
    
    public PeekingImpl(Iterator<? extends E> paramIterator)
    {
      this.iterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
    }
    
    public boolean hasNext()
    {
      return (this.hasPeeked) || (this.iterator.hasNext());
    }
    
    public E next()
    {
      if (!this.hasPeeked) {
        return (E)this.iterator.next();
      }
      Object localObject = this.peekedElement;
      this.hasPeeked = false;
      this.peekedElement = null;
      return (E)localObject;
    }
    
    public E peek()
    {
      if (!this.hasPeeked)
      {
        this.peekedElement = this.iterator.next();
        this.hasPeeked = true;
      }
      return (E)this.peekedElement;
    }
    
    public void remove()
    {
      if (!this.hasPeeked) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Can't remove after you've peeked at next");
        this.iterator.remove();
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Iterators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */