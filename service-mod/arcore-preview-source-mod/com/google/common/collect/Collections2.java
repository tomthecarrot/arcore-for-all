package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Collections2
{
  static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");
  
  static <T> Collection<T> cast(Iterable<T> paramIterable)
  {
    return (Collection)paramIterable;
  }
  
  static boolean containsAllImpl(Collection<?> paramCollection1, Collection<?> paramCollection2)
  {
    return Iterables.all(paramCollection2, Predicates.in(paramCollection1));
  }
  
  @CheckReturnValue
  public static <E> Collection<E> filter(Collection<E> paramCollection, Predicate<? super E> paramPredicate)
  {
    if ((paramCollection instanceof FilteredCollection)) {
      return ((FilteredCollection)paramCollection).createCombined(paramPredicate);
    }
    return new FilteredCollection((Collection)Preconditions.checkNotNull(paramCollection), (Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  private static boolean isPermutation(List<?> paramList1, List<?> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    return HashMultiset.create(paramList1).equals(HashMultiset.create(paramList2));
  }
  
  private static boolean isPositiveInt(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 2147483647L);
  }
  
  static StringBuilder newStringBuilderForCollection(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "size");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  @Beta
  public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> paramIterable)
  {
    return orderedPermutations(paramIterable, Ordering.natural());
  }
  
  @Beta
  public static <E> Collection<List<E>> orderedPermutations(Iterable<E> paramIterable, Comparator<? super E> paramComparator)
  {
    return new OrderedPermutationCollection(paramIterable, paramComparator);
  }
  
  @Beta
  public static <E> Collection<List<E>> permutations(Collection<E> paramCollection)
  {
    return new PermutationCollection(ImmutableList.copyOf(paramCollection));
  }
  
  static boolean safeContains(Collection<?> paramCollection, @Nullable Object paramObject)
  {
    Preconditions.checkNotNull(paramCollection);
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException paramCollection)
    {
      return false;
    }
    catch (NullPointerException paramCollection) {}
    return false;
  }
  
  static boolean safeRemove(Collection<?> paramCollection, @Nullable Object paramObject)
  {
    Preconditions.checkNotNull(paramCollection);
    try
    {
      boolean bool = paramCollection.remove(paramObject);
      return bool;
    }
    catch (ClassCastException paramCollection)
    {
      return false;
    }
    catch (NullPointerException paramCollection) {}
    return false;
  }
  
  static String toStringImpl(Collection<?> paramCollection)
  {
    StringBuilder localStringBuilder = newStringBuilderForCollection(paramCollection.size()).append('[');
    STANDARD_JOINER.appendTo(localStringBuilder, Iterables.transform(paramCollection, new Function()
    {
      public Object apply(Object paramAnonymousObject)
      {
        Object localObject = paramAnonymousObject;
        if (paramAnonymousObject == this.val$collection) {
          localObject = "(this Collection)";
        }
        return localObject;
      }
    }));
    return ']';
  }
  
  public static <F, T> Collection<T> transform(Collection<F> paramCollection, Function<? super F, T> paramFunction)
  {
    return new TransformedCollection(paramCollection, paramFunction);
  }
  
  static class FilteredCollection<E>
    extends AbstractCollection<E>
  {
    final Predicate<? super E> predicate;
    final Collection<E> unfiltered;
    
    FilteredCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate)
    {
      this.unfiltered = paramCollection;
      this.predicate = paramPredicate;
    }
    
    public boolean add(E paramE)
    {
      Preconditions.checkArgument(this.predicate.apply(paramE));
      return this.unfiltered.add(paramE);
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        Preconditions.checkArgument(this.predicate.apply(localObject));
      }
      return this.unfiltered.addAll(paramCollection);
    }
    
    public void clear()
    {
      Iterables.removeIf(this.unfiltered, this.predicate);
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if (Collections2.safeContains(this.unfiltered, paramObject)) {
        return this.predicate.apply(paramObject);
      }
      return false;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return Collections2.containsAllImpl(this, paramCollection);
    }
    
    FilteredCollection<E> createCombined(Predicate<? super E> paramPredicate)
    {
      return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, paramPredicate));
    }
    
    public boolean isEmpty()
    {
      return !Iterables.any(this.unfiltered, this.predicate);
    }
    
    public Iterator<E> iterator()
    {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    public boolean remove(Object paramObject)
    {
      return (contains(paramObject)) && (this.unfiltered.remove(paramObject));
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(paramCollection)));
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(paramCollection))));
    }
    
    public int size()
    {
      return Iterators.size(iterator());
    }
    
    public Object[] toArray()
    {
      return Lists.newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return Lists.newArrayList(iterator()).toArray(paramArrayOfT);
    }
  }
  
  private static final class OrderedPermutationCollection<E>
    extends AbstractCollection<List<E>>
  {
    final Comparator<? super E> comparator;
    final ImmutableList<E> inputList;
    final int size;
    
    OrderedPermutationCollection(Iterable<E> paramIterable, Comparator<? super E> paramComparator)
    {
      this.inputList = Ordering.from(paramComparator).immutableSortedCopy(paramIterable);
      this.comparator = paramComparator;
      this.size = calculateSize(this.inputList, paramComparator);
    }
    
    private static <E> int calculateSize(List<E> paramList, Comparator<? super E> paramComparator)
    {
      long l2 = 1L;
      int j = 1;
      int i = 1;
      long l1;
      int k;
      if (j < paramList.size())
      {
        l1 = l2;
        k = i;
        if (paramComparator.compare(paramList.get(j - 1), paramList.get(j)) < 0)
        {
          l2 *= LongMath.binomial(j, i);
          k = 0;
          l1 = l2;
          if (Collections2.isPositiveInt(l2)) {}
        }
      }
      do
      {
        return Integer.MAX_VALUE;
        j += 1;
        i = k + 1;
        l2 = l1;
        break;
        l1 = l2 * LongMath.binomial(j, i);
      } while (!Collections2.isPositiveInt(l1));
      return (int)l1;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        return Collections2.isPermutation(this.inputList, (List)paramObject);
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<List<E>> iterator()
    {
      return new Collections2.OrderedPermutationIterator(this.inputList, this.comparator);
    }
    
    public int size()
    {
      return this.size;
    }
    
    public String toString()
    {
      return "orderedPermutationCollection(" + this.inputList + ")";
    }
  }
  
  private static final class OrderedPermutationIterator<E>
    extends AbstractIterator<List<E>>
  {
    final Comparator<? super E> comparator;
    List<E> nextPermutation;
    
    OrderedPermutationIterator(List<E> paramList, Comparator<? super E> paramComparator)
    {
      this.nextPermutation = Lists.newArrayList(paramList);
      this.comparator = paramComparator;
    }
    
    void calculateNextPermutation()
    {
      int i = findNextJ();
      if (i == -1)
      {
        this.nextPermutation = null;
        return;
      }
      int j = findNextL(i);
      Collections.swap(this.nextPermutation, i, j);
      j = this.nextPermutation.size();
      Collections.reverse(this.nextPermutation.subList(i + 1, j));
    }
    
    protected List<E> computeNext()
    {
      if (this.nextPermutation == null) {
        return (List)endOfData();
      }
      ImmutableList localImmutableList = ImmutableList.copyOf(this.nextPermutation);
      calculateNextPermutation();
      return localImmutableList;
    }
    
    int findNextJ()
    {
      int i = this.nextPermutation.size() - 2;
      while (i >= 0)
      {
        if (this.comparator.compare(this.nextPermutation.get(i), this.nextPermutation.get(i + 1)) < 0) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    
    int findNextL(int paramInt)
    {
      Object localObject = this.nextPermutation.get(paramInt);
      int i = this.nextPermutation.size() - 1;
      while (i > paramInt)
      {
        if (this.comparator.compare(localObject, this.nextPermutation.get(i)) < 0) {
          return i;
        }
        i -= 1;
      }
      throw new AssertionError("this statement should be unreachable");
    }
  }
  
  private static final class PermutationCollection<E>
    extends AbstractCollection<List<E>>
  {
    final ImmutableList<E> inputList;
    
    PermutationCollection(ImmutableList<E> paramImmutableList)
    {
      this.inputList = paramImmutableList;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        return Collections2.isPermutation(this.inputList, (List)paramObject);
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<List<E>> iterator()
    {
      return new Collections2.PermutationIterator(this.inputList);
    }
    
    public int size()
    {
      return IntMath.factorial(this.inputList.size());
    }
    
    public String toString()
    {
      return "permutations(" + this.inputList + ")";
    }
  }
  
  private static class PermutationIterator<E>
    extends AbstractIterator<List<E>>
  {
    final int[] c;
    int j;
    final List<E> list;
    final int[] o;
    
    PermutationIterator(List<E> paramList)
    {
      this.list = new ArrayList(paramList);
      int i = paramList.size();
      this.c = new int[i];
      this.o = new int[i];
      Arrays.fill(this.c, 0);
      Arrays.fill(this.o, 1);
      this.j = Integer.MAX_VALUE;
    }
    
    void calculateNextPermutation()
    {
      this.j = (this.list.size() - 1);
      int i = 0;
      if (this.j == -1) {
        return;
      }
      int k;
      for (;;)
      {
        k = this.c[this.j] + this.o[this.j];
        if (k < 0)
        {
          switchDirection();
        }
        else
        {
          if (k != this.j + 1) {
            break label85;
          }
          if (this.j == 0) {
            break;
          }
          i += 1;
          switchDirection();
        }
      }
      label85:
      Collections.swap(this.list, this.j - this.c[this.j] + i, this.j - k + i);
      this.c[this.j] = k;
    }
    
    protected List<E> computeNext()
    {
      if (this.j <= 0) {
        return (List)endOfData();
      }
      ImmutableList localImmutableList = ImmutableList.copyOf(this.list);
      calculateNextPermutation();
      return localImmutableList;
    }
    
    void switchDirection()
    {
      this.o[this.j] = (-this.o[this.j]);
      this.j -= 1;
    }
  }
  
  static class TransformedCollection<F, T>
    extends AbstractCollection<T>
  {
    final Collection<F> fromCollection;
    final Function<? super F, ? extends T> function;
    
    TransformedCollection(Collection<F> paramCollection, Function<? super F, ? extends T> paramFunction)
    {
      this.fromCollection = ((Collection)Preconditions.checkNotNull(paramCollection));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public void clear()
    {
      this.fromCollection.clear();
    }
    
    public boolean isEmpty()
    {
      return this.fromCollection.isEmpty();
    }
    
    public Iterator<T> iterator()
    {
      return Iterators.transform(this.fromCollection.iterator(), this.function);
    }
    
    public int size()
    {
      return this.fromCollection.size();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Collections2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */