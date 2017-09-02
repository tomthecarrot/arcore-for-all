package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
public final class MinMaxPriorityQueue<E>
  extends AbstractQueue<E>
{
  private static final int DEFAULT_CAPACITY = 11;
  private static final int EVEN_POWERS_OF_TWO = 1431655765;
  private static final int ODD_POWERS_OF_TWO = -1431655766;
  private final MinMaxPriorityQueue<E>.Heap maxHeap;
  @VisibleForTesting
  final int maximumSize;
  private final MinMaxPriorityQueue<E>.Heap minHeap;
  private int modCount;
  private Object[] queue;
  private int size;
  
  private MinMaxPriorityQueue(Builder<? super E> paramBuilder, int paramInt)
  {
    Ordering localOrdering = paramBuilder.ordering();
    this.minHeap = new Heap(localOrdering);
    this.maxHeap = new Heap(localOrdering.reverse());
    this.minHeap.otherHeap = this.maxHeap;
    this.maxHeap.otherHeap = this.minHeap;
    this.maximumSize = paramBuilder.maximumSize;
    this.queue = new Object[paramInt];
  }
  
  private int calculateNewCapacity()
  {
    int i = this.queue.length;
    if (i < 64) {}
    for (i = (i + 1) * 2;; i = IntMath.checkedMultiply(i / 2, 3)) {
      return capAtMaximumSize(i, this.maximumSize);
    }
  }
  
  private static int capAtMaximumSize(int paramInt1, int paramInt2)
  {
    return Math.min(paramInt1 - 1, paramInt2) + 1;
  }
  
  public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create()
  {
    return new Builder(Ordering.natural(), null).create();
  }
  
  public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> paramIterable)
  {
    return new Builder(Ordering.natural(), null).create(paramIterable);
  }
  
  public static Builder<Comparable> expectedSize(int paramInt)
  {
    return new Builder(Ordering.natural(), null).expectedSize(paramInt);
  }
  
  private MoveDesc<E> fillHole(int paramInt, E paramE)
  {
    Heap localHeap = heapForIndex(paramInt);
    int i = localHeap.fillHoleAt(paramInt);
    int j = localHeap.bubbleUpAlternatingLevels(i, paramE);
    if (j == i) {
      return localHeap.tryCrossOverAndBubbleUp(paramInt, i, paramE);
    }
    if (j < paramInt) {
      return new MoveDesc(paramE, elementData(paramInt));
    }
    return null;
  }
  
  private int getMaxElementIndex()
  {
    switch (this.size)
    {
    default: 
      if (this.maxHeap.compareElements(1, 2) > 0) {
        break;
      }
    case 2: 
      return 1;
    case 1: 
      return 0;
    }
    return 2;
  }
  
  private void growIfNeeded()
  {
    if (this.size > this.queue.length)
    {
      Object[] arrayOfObject = new Object[calculateNewCapacity()];
      System.arraycopy(this.queue, 0, arrayOfObject, 0, this.queue.length);
      this.queue = arrayOfObject;
    }
  }
  
  private MinMaxPriorityQueue<E>.Heap heapForIndex(int paramInt)
  {
    if (isEvenLevel(paramInt)) {
      return this.minHeap;
    }
    return this.maxHeap;
  }
  
  @VisibleForTesting
  static int initialQueueSize(int paramInt1, int paramInt2, Iterable<?> paramIterable)
  {
    if (paramInt1 == -1) {
      paramInt1 = 11;
    }
    for (;;)
    {
      int i = paramInt1;
      if ((paramIterable instanceof Collection)) {
        i = Math.max(paramInt1, ((Collection)paramIterable).size());
      }
      return capAtMaximumSize(i, paramInt2);
    }
  }
  
  @VisibleForTesting
  static boolean isEvenLevel(int paramInt)
  {
    paramInt += 1;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "negative index");
      if ((0x55555555 & paramInt) <= (0xAAAAAAAA & paramInt)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static Builder<Comparable> maximumSize(int paramInt)
  {
    return new Builder(Ordering.natural(), null).maximumSize(paramInt);
  }
  
  public static <B> Builder<B> orderedBy(Comparator<B> paramComparator)
  {
    return new Builder(paramComparator, null);
  }
  
  private E removeAndGet(int paramInt)
  {
    Object localObject = elementData(paramInt);
    removeAt(paramInt);
    return (E)localObject;
  }
  
  public boolean add(E paramE)
  {
    offer(paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      offer(paramCollection.next());
      bool = true;
    }
    return bool;
  }
  
  @VisibleForTesting
  int capacity()
  {
    return this.queue.length;
  }
  
  public void clear()
  {
    int i = 0;
    while (i < this.size)
    {
      this.queue[i] = null;
      i += 1;
    }
    this.size = 0;
  }
  
  public Comparator<? super E> comparator()
  {
    return this.minHeap.ordering;
  }
  
  E elementData(int paramInt)
  {
    return (E)this.queue[paramInt];
  }
  
  @VisibleForTesting
  boolean isIntact()
  {
    int i = 1;
    while (i < this.size)
    {
      if (!heapForIndex(i).verifyIndex(i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Iterator<E> iterator()
  {
    return new QueueIterator(null);
  }
  
  public boolean offer(E paramE)
  {
    Preconditions.checkNotNull(paramE);
    this.modCount += 1;
    int i = this.size;
    this.size = (i + 1);
    growIfNeeded();
    heapForIndex(i).bubbleUp(i, paramE);
    return (this.size <= this.maximumSize) || (pollLast() != paramE);
  }
  
  public E peek()
  {
    if (isEmpty()) {
      return null;
    }
    return (E)elementData(0);
  }
  
  public E peekFirst()
  {
    return (E)peek();
  }
  
  public E peekLast()
  {
    if (isEmpty()) {
      return null;
    }
    return (E)elementData(getMaxElementIndex());
  }
  
  public E poll()
  {
    if (isEmpty()) {
      return null;
    }
    return (E)removeAndGet(0);
  }
  
  public E pollFirst()
  {
    return (E)poll();
  }
  
  public E pollLast()
  {
    if (isEmpty()) {
      return null;
    }
    return (E)removeAndGet(getMaxElementIndex());
  }
  
  @VisibleForTesting
  MoveDesc<E> removeAt(int paramInt)
  {
    Object localObject1 = null;
    Preconditions.checkPositionIndex(paramInt, this.size);
    this.modCount += 1;
    this.size -= 1;
    if (this.size == paramInt) {
      this.queue[this.size] = null;
    }
    Object localObject2;
    int i;
    Object localObject3;
    MoveDesc localMoveDesc;
    do
    {
      return (MoveDesc<E>)localObject1;
      localObject2 = elementData(this.size);
      i = heapForIndex(this.size).getCorrectLastElement(localObject2);
      localObject3 = elementData(this.size);
      this.queue[this.size] = null;
      localMoveDesc = fillHole(paramInt, localObject3);
      localObject1 = localMoveDesc;
    } while (i >= paramInt);
    if (localMoveDesc == null) {
      return new MoveDesc(localObject2, localObject3);
    }
    return new MoveDesc(localObject2, localMoveDesc.replaced);
  }
  
  public E removeFirst()
  {
    return (E)remove();
  }
  
  public E removeLast()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return (E)removeAndGet(getMaxElementIndex());
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.size];
    System.arraycopy(this.queue, 0, arrayOfObject, 0, this.size);
    return arrayOfObject;
  }
  
  @Beta
  public static final class Builder<B>
  {
    private static final int UNSET_EXPECTED_SIZE = -1;
    private final Comparator<B> comparator;
    private int expectedSize = -1;
    private int maximumSize = Integer.MAX_VALUE;
    
    private Builder(Comparator<B> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    private <T extends B> Ordering<T> ordering()
    {
      return Ordering.from(this.comparator);
    }
    
    public <T extends B> MinMaxPriorityQueue<T> create()
    {
      return create(Collections.emptySet());
    }
    
    public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> paramIterable)
    {
      MinMaxPriorityQueue localMinMaxPriorityQueue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, paramIterable), null);
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localMinMaxPriorityQueue.offer(paramIterable.next());
      }
      return localMinMaxPriorityQueue;
    }
    
    public Builder<B> expectedSize(int paramInt)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.expectedSize = paramInt;
        return this;
      }
    }
    
    public Builder<B> maximumSize(int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.maximumSize = paramInt;
        return this;
      }
    }
  }
  
  private class Heap
  {
    final Ordering<E> ordering;
    @Weak
    MinMaxPriorityQueue<E>.Heap otherHeap;
    
    Heap()
    {
      Ordering localOrdering;
      this.ordering = localOrdering;
    }
    
    private int getGrandparentIndex(int paramInt)
    {
      return getParentIndex(getParentIndex(paramInt));
    }
    
    private int getLeftChildIndex(int paramInt)
    {
      return paramInt * 2 + 1;
    }
    
    private int getParentIndex(int paramInt)
    {
      return (paramInt - 1) / 2;
    }
    
    private int getRightChildIndex(int paramInt)
    {
      return paramInt * 2 + 2;
    }
    
    private boolean verifyIndex(int paramInt)
    {
      if ((getLeftChildIndex(paramInt) < MinMaxPriorityQueue.this.size) && (compareElements(paramInt, getLeftChildIndex(paramInt)) > 0)) {}
      while (((getRightChildIndex(paramInt) < MinMaxPriorityQueue.this.size) && (compareElements(paramInt, getRightChildIndex(paramInt)) > 0)) || ((paramInt > 0) && (compareElements(paramInt, getParentIndex(paramInt)) > 0)) || ((paramInt > 2) && (compareElements(getGrandparentIndex(paramInt), paramInt) > 0))) {
        return false;
      }
      return true;
    }
    
    void bubbleUp(int paramInt, E paramE)
    {
      int i = crossOverUp(paramInt, paramE);
      if (i == paramInt) {}
      for (Heap localHeap = this;; localHeap = this.otherHeap)
      {
        localHeap.bubbleUpAlternatingLevels(paramInt, paramE);
        return;
        paramInt = i;
      }
    }
    
    int bubbleUpAlternatingLevels(int paramInt, E paramE)
    {
      for (;;)
      {
        int i;
        Object localObject;
        if (paramInt > 2)
        {
          i = getGrandparentIndex(paramInt);
          localObject = MinMaxPriorityQueue.this.elementData(i);
          if (this.ordering.compare(localObject, paramE) > 0) {}
        }
        else
        {
          MinMaxPriorityQueue.this.queue[paramInt] = paramE;
          return paramInt;
        }
        MinMaxPriorityQueue.this.queue[paramInt] = localObject;
        paramInt = i;
      }
    }
    
    int compareElements(int paramInt1, int paramInt2)
    {
      return this.ordering.compare(MinMaxPriorityQueue.this.elementData(paramInt1), MinMaxPriorityQueue.this.elementData(paramInt2));
    }
    
    int crossOver(int paramInt, E paramE)
    {
      int i = findMinChild(paramInt);
      if ((i > 0) && (this.ordering.compare(MinMaxPriorityQueue.this.elementData(i), paramE) < 0))
      {
        MinMaxPriorityQueue.this.queue[paramInt] = MinMaxPriorityQueue.this.elementData(i);
        MinMaxPriorityQueue.this.queue[i] = paramE;
        return i;
      }
      return crossOverUp(paramInt, paramE);
    }
    
    int crossOverUp(int paramInt, E paramE)
    {
      if (paramInt == 0)
      {
        MinMaxPriorityQueue.this.queue[0] = paramE;
        return 0;
      }
      int j = getParentIndex(paramInt);
      Object localObject2 = MinMaxPriorityQueue.this.elementData(j);
      Object localObject1 = localObject2;
      int i = j;
      if (j != 0)
      {
        int k = getRightChildIndex(getParentIndex(j));
        localObject1 = localObject2;
        i = j;
        if (k != j)
        {
          localObject1 = localObject2;
          i = j;
          if (getLeftChildIndex(k) >= MinMaxPriorityQueue.this.size)
          {
            Object localObject3 = MinMaxPriorityQueue.this.elementData(k);
            localObject1 = localObject2;
            i = j;
            if (this.ordering.compare(localObject3, localObject2) < 0)
            {
              i = k;
              localObject1 = localObject3;
            }
          }
        }
      }
      if (this.ordering.compare(localObject1, paramE) < 0)
      {
        MinMaxPriorityQueue.this.queue[paramInt] = localObject1;
        MinMaxPriorityQueue.this.queue[i] = paramE;
        return i;
      }
      MinMaxPriorityQueue.this.queue[paramInt] = paramE;
      return paramInt;
    }
    
    int fillHoleAt(int paramInt)
    {
      for (;;)
      {
        int i = findMinGrandChild(paramInt);
        if (i <= 0) {
          break;
        }
        MinMaxPriorityQueue.this.queue[paramInt] = MinMaxPriorityQueue.this.elementData(i);
        paramInt = i;
      }
      return paramInt;
    }
    
    int findMin(int paramInt1, int paramInt2)
    {
      int j;
      if (paramInt1 >= MinMaxPriorityQueue.this.size)
      {
        j = -1;
        return j;
      }
      if (paramInt1 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        int k = Math.min(paramInt1, MinMaxPriorityQueue.this.size - paramInt2);
        int i = paramInt1;
        paramInt1 += 1;
        for (;;)
        {
          j = i;
          if (paramInt1 >= k + paramInt2) {
            break;
          }
          j = i;
          if (compareElements(paramInt1, i) < 0) {
            j = paramInt1;
          }
          paramInt1 += 1;
          i = j;
        }
      }
    }
    
    int findMinChild(int paramInt)
    {
      return findMin(getLeftChildIndex(paramInt), 2);
    }
    
    int findMinGrandChild(int paramInt)
    {
      paramInt = getLeftChildIndex(paramInt);
      if (paramInt < 0) {
        return -1;
      }
      return findMin(getLeftChildIndex(paramInt), 4);
    }
    
    int getCorrectLastElement(E paramE)
    {
      int i = getParentIndex(MinMaxPriorityQueue.this.size);
      if (i != 0)
      {
        int j = getRightChildIndex(getParentIndex(i));
        if ((j != i) && (getLeftChildIndex(j) >= MinMaxPriorityQueue.this.size))
        {
          Object localObject = MinMaxPriorityQueue.this.elementData(j);
          if (this.ordering.compare(localObject, paramE) < 0)
          {
            MinMaxPriorityQueue.this.queue[j] = paramE;
            MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = localObject;
            return j;
          }
        }
      }
      return MinMaxPriorityQueue.this.size;
    }
    
    MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int paramInt1, int paramInt2, E paramE)
    {
      int i = crossOver(paramInt2, paramE);
      if (i == paramInt2) {}
      for (;;)
      {
        return null;
        if (i < paramInt1) {}
        for (Object localObject = MinMaxPriorityQueue.this.elementData(paramInt1); this.otherHeap.bubbleUpAlternatingLevels(i, paramE) < paramInt1; localObject = MinMaxPriorityQueue.this.elementData(getParentIndex(paramInt1))) {
          return new MinMaxPriorityQueue.MoveDesc(paramE, localObject);
        }
      }
    }
  }
  
  static class MoveDesc<E>
  {
    final E replaced;
    final E toTrickle;
    
    MoveDesc(E paramE1, E paramE2)
    {
      this.toTrickle = paramE1;
      this.replaced = paramE2;
    }
  }
  
  private class QueueIterator
    implements Iterator<E>
  {
    private boolean canRemove;
    private int cursor = -1;
    private int expectedModCount = MinMaxPriorityQueue.this.modCount;
    private Queue<E> forgetMeNot;
    private E lastFromForgetMeNot;
    private List<E> skipMe;
    
    private QueueIterator() {}
    
    private boolean containsExact(Iterable<E> paramIterable, E paramE)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        if (paramIterable.next() == paramE) {
          return true;
        }
      }
      return false;
    }
    
    private int nextNotInSkipMe(int paramInt)
    {
      int i = paramInt;
      if (this.skipMe != null) {
        for (;;)
        {
          i = paramInt;
          if (paramInt >= MinMaxPriorityQueue.this.size()) {
            break;
          }
          i = paramInt;
          if (!containsExact(this.skipMe, MinMaxPriorityQueue.this.elementData(paramInt))) {
            break;
          }
          paramInt += 1;
        }
      }
      return i;
    }
    
    void checkModCount()
    {
      if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
    }
    
    public boolean hasNext()
    {
      checkModCount();
      return (nextNotInSkipMe(this.cursor + 1) < MinMaxPriorityQueue.this.size()) || ((this.forgetMeNot != null) && (!this.forgetMeNot.isEmpty()));
    }
    
    public E next()
    {
      checkModCount();
      int i = nextNotInSkipMe(this.cursor + 1);
      if (i < MinMaxPriorityQueue.this.size())
      {
        this.cursor = i;
        this.canRemove = true;
        return (E)MinMaxPriorityQueue.this.elementData(this.cursor);
      }
      if (this.forgetMeNot != null)
      {
        this.cursor = MinMaxPriorityQueue.this.size();
        this.lastFromForgetMeNot = this.forgetMeNot.poll();
        if (this.lastFromForgetMeNot != null)
        {
          this.canRemove = true;
          return (E)this.lastFromForgetMeNot;
        }
      }
      throw new NoSuchElementException("iterator moved past last element in queue.");
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(this.canRemove);
      checkModCount();
      this.canRemove = false;
      this.expectedModCount += 1;
      if (this.cursor < MinMaxPriorityQueue.this.size())
      {
        MinMaxPriorityQueue.MoveDesc localMoveDesc = MinMaxPriorityQueue.this.removeAt(this.cursor);
        if (localMoveDesc != null)
        {
          if (this.forgetMeNot == null)
          {
            this.forgetMeNot = new ArrayDeque();
            this.skipMe = new ArrayList(3);
          }
          this.forgetMeNot.add(localMoveDesc.toTrickle);
          this.skipMe.add(localMoveDesc.replaced);
        }
        this.cursor -= 1;
        return;
      }
      Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
      this.lastFromForgetMeNot = null;
    }
    
    boolean removeExact(Object paramObject)
    {
      int i = 0;
      while (i < MinMaxPriorityQueue.this.size)
      {
        if (MinMaxPriorityQueue.this.queue[i] == paramObject)
        {
          MinMaxPriorityQueue.this.removeAt(i);
          return true;
        }
        i += 1;
      }
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/MinMaxPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */