package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class ComputingConcurrentHashMap<K, V>
  extends MapMakerInternalMap<K, V>
{
  private static final long serialVersionUID = 4L;
  final Function<? super K, ? extends V> computingFunction;
  
  ComputingConcurrentHashMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  MapMakerInternalMap.Segment<K, V> createSegment(int paramInt1, int paramInt2)
  {
    return new ComputingSegment(this, paramInt1, paramInt2);
  }
  
  V getOrCompute(K paramK)
    throws ExecutionException
  {
    int i = hash(Preconditions.checkNotNull(paramK));
    return (V)segmentFor(i).getOrCompute(paramK, i, this.computingFunction);
  }
  
  ComputingSegment<K, V> segmentFor(int paramInt)
  {
    return (ComputingSegment)super.segmentFor(paramInt);
  }
  
  Object writeReplace()
  {
    return new ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
  }
  
  private static final class ComputationExceptionReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final Throwable t;
    
    ComputationExceptionReference(Throwable paramThrowable)
    {
      this.t = paramThrowable;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference) {}
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, V paramV, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }
    
    public V get()
    {
      return null;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public V waitForValue()
      throws ExecutionException
    {
      throw new ExecutionException(this.t);
    }
  }
  
  private static final class ComputedReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final V value;
    
    ComputedReference(@Nullable V paramV)
    {
      this.value = paramV;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference) {}
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, V paramV, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }
    
    public V get()
    {
      return (V)this.value;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
  }
  
  static final class ComputingSegment<K, V>
    extends MapMakerInternalMap.Segment<K, V>
  {
    ComputingSegment(MapMakerInternalMap<K, V> paramMapMakerInternalMap, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    /* Error */
    V compute(K paramK, int paramInt, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry, ComputingConcurrentHashMap.ComputingValueReference<K, V> paramComputingValueReference)
      throws ExecutionException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 9
      //   3: aconst_null
      //   4: astore 10
      //   6: invokestatic 25	java/lang/System:nanoTime	()J
      //   9: pop2
      //   10: lconst_0
      //   11: lstore 7
      //   13: lload 7
      //   15: lstore 5
      //   17: aload_3
      //   18: monitorenter
      //   19: lload 7
      //   21: lstore 5
      //   23: aload 10
      //   25: astore 9
      //   27: aload 4
      //   29: aload_1
      //   30: iload_2
      //   31: invokevirtual 30	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:compute	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   34: astore 10
      //   36: lload 7
      //   38: lstore 5
      //   40: aload 10
      //   42: astore 9
      //   44: invokestatic 25	java/lang/System:nanoTime	()J
      //   47: lstore 7
      //   49: lload 7
      //   51: lstore 5
      //   53: aload 10
      //   55: astore 9
      //   57: aload_3
      //   58: monitorexit
      //   59: aload 10
      //   61: ifnull +42 -> 103
      //   64: lload 7
      //   66: lstore 5
      //   68: aload 10
      //   70: astore 9
      //   72: aload_0
      //   73: aload_1
      //   74: iload_2
      //   75: aload 10
      //   77: iconst_1
      //   78: invokevirtual 34	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:put	(Ljava/lang/Object;ILjava/lang/Object;Z)Ljava/lang/Object;
      //   81: ifnull +22 -> 103
      //   84: lload 7
      //   86: lstore 5
      //   88: aload 10
      //   90: astore 9
      //   92: aload_0
      //   93: aload_1
      //   94: iload_2
      //   95: aload 10
      //   97: getstatic 40	com/google/common/collect/MapMaker$RemovalCause:REPLACED	Lcom/google/common/collect/MapMaker$RemovalCause;
      //   100: invokevirtual 44	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:enqueueNotification	(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/common/collect/MapMaker$RemovalCause;)V
      //   103: lload 7
      //   105: lconst_0
      //   106: lcmp
      //   107: ifne +7 -> 114
      //   110: invokestatic 25	java/lang/System:nanoTime	()J
      //   113: pop2
      //   114: aload 10
      //   116: ifnonnull +12 -> 128
      //   119: aload_0
      //   120: aload_1
      //   121: iload_2
      //   122: aload 4
      //   124: invokevirtual 48	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:clearValue	(Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$ValueReference;)Z
      //   127: pop
      //   128: aload 10
      //   130: areturn
      //   131: astore 10
      //   133: aload_3
      //   134: monitorexit
      //   135: aload 10
      //   137: athrow
      //   138: astore_3
      //   139: lload 5
      //   141: lconst_0
      //   142: lcmp
      //   143: ifne +7 -> 150
      //   146: invokestatic 25	java/lang/System:nanoTime	()J
      //   149: pop2
      //   150: aload 9
      //   152: ifnonnull +12 -> 164
      //   155: aload_0
      //   156: aload_1
      //   157: iload_2
      //   158: aload 4
      //   160: invokevirtual 48	com/google/common/collect/ComputingConcurrentHashMap$ComputingSegment:clearValue	(Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$ValueReference;)Z
      //   163: pop
      //   164: aload_3
      //   165: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	166	0	this	ComputingSegment
      //   0	166	1	paramK	K
      //   0	166	2	paramInt	int
      //   0	166	3	paramReferenceEntry	MapMakerInternalMap.ReferenceEntry<K, V>
      //   0	166	4	paramComputingValueReference	ComputingConcurrentHashMap.ComputingValueReference<K, V>
      //   15	125	5	l1	long
      //   11	93	7	l2	long
      //   1	150	9	localObject1	Object
      //   4	125	10	localObject2	Object
      //   131	5	10	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   27	36	131	finally
      //   44	49	131	finally
      //   57	59	131	finally
      //   133	135	131	finally
      //   17	19	138	finally
      //   72	84	138	finally
      //   92	103	138	finally
      //   135	138	138	finally
    }
    
    V getOrCompute(K paramK, int paramInt, Function<? super K, ? extends V> paramFunction)
      throws ExecutionException
    {
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject2 = getEntry(paramK, paramInt);
          if (localObject2 != null)
          {
            localObject1 = getLiveValue((MapMakerInternalMap.ReferenceEntry)localObject2);
            if (localObject1 != null)
            {
              recordRead((MapMakerInternalMap.ReferenceEntry)localObject2);
              return (V)localObject1;
            }
          }
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((MapMakerInternalMap.ReferenceEntry)localObject2).getValueReference().isComputingReference()) {
              break;
            }
          }
          else
          {
            int j = 1;
            localObject3 = null;
            lock();
            int m;
            AtomicReferenceArray localAtomicReferenceArray;
            int k;
            MapMakerInternalMap.ReferenceEntry localReferenceEntry;
            int i;
            try
            {
              preWriteCleanup();
              m = this.count;
              localAtomicReferenceArray = this.table;
              k = paramInt & localAtomicReferenceArray.length() - 1;
              localReferenceEntry = (MapMakerInternalMap.ReferenceEntry)localAtomicReferenceArray.get(k);
              localObject1 = localReferenceEntry;
              i = j;
              if (localObject1 != null)
              {
                localObject2 = ((MapMakerInternalMap.ReferenceEntry)localObject1).getKey();
                if ((((MapMakerInternalMap.ReferenceEntry)localObject1).getHash() != paramInt) || (localObject2 == null) || (!this.map.keyEquivalence.equivalent(paramK, localObject2))) {
                  break label424;
                }
                if (((MapMakerInternalMap.ReferenceEntry)localObject1).getValueReference().isComputingReference()) {
                  i = 0;
                }
              }
              else
              {
                localObject2 = localObject1;
                if (i != 0)
                {
                  localObject2 = new ComputingConcurrentHashMap.ComputingValueReference(paramFunction);
                  if (localObject1 != null) {
                    break label436;
                  }
                }
              }
            }
            finally {}
          }
        }
        finally
        {
          postReadCleanup();
        }
        try
        {
          localObject1 = newEntry(paramK, paramInt, localReferenceEntry);
          ((MapMakerInternalMap.ReferenceEntry)localObject1).setValueReference((MapMakerInternalMap.ValueReference)localObject2);
          localAtomicReferenceArray.set(k, localObject1);
          localObject3 = localObject2;
          localObject2 = localObject1;
          unlock();
          postWriteCleanup();
          localObject1 = localObject2;
          if (i == 0) {
            break;
          }
          paramK = compute(paramK, paramInt, (MapMakerInternalMap.ReferenceEntry)localObject2, (ComputingConcurrentHashMap.ComputingValueReference)localObject3);
          postReadCleanup();
          return paramK;
        }
        finally
        {
          label424:
          label436:
          boolean bool;
          continue;
        }
        Object localObject4 = ((MapMakerInternalMap.ReferenceEntry)localObject1).getValueReference().get();
        if (localObject4 == null)
        {
          enqueueNotification(localObject2, paramInt, localObject4, MapMaker.RemovalCause.COLLECTED);
          this.evictionQueue.remove(localObject1);
          this.expirationQueue.remove(localObject1);
          this.count = (m - 1);
          i = j;
          continue;
          unlock();
          postWriteCleanup();
          throw paramK;
        }
        else if ((this.map.expires()) && (this.map.isExpired((MapMakerInternalMap.ReferenceEntry)localObject1)))
        {
          enqueueNotification(localObject2, paramInt, localObject4, MapMaker.RemovalCause.EXPIRED);
        }
        else
        {
          recordLockedRead((MapMakerInternalMap.ReferenceEntry)localObject1);
          unlock();
          postWriteCleanup();
          postReadCleanup();
          return (V)localObject4;
          localObject1 = ((MapMakerInternalMap.ReferenceEntry)localObject1).getNext();
          continue;
          ((MapMakerInternalMap.ReferenceEntry)localObject1).setValueReference((MapMakerInternalMap.ValueReference)localObject2);
          localObject3 = localObject2;
          localObject2 = localObject1;
        }
      }
      if (!Thread.holdsLock(localObject1)) {}
      for (bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Recursive computation");
        localObject2 = ((MapMakerInternalMap.ReferenceEntry)localObject1).getValueReference().waitForValue();
        if (localObject2 == null) {
          break;
        }
        recordRead((MapMakerInternalMap.ReferenceEntry)localObject1);
        postReadCleanup();
        return (V)localObject2;
      }
    }
  }
  
  static final class ComputingSerializationProxy<K, V>
    extends MapMakerInternalMap.AbstractSerializationProxy<K, V>
  {
    private static final long serialVersionUID = 4L;
    final Function<? super K, ? extends V> computingFunction;
    
    ComputingSerializationProxy(MapMakerInternalMap.Strength paramStrength1, MapMakerInternalMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapMaker.RemovalListener<? super K, ? super V> paramRemovalListener, ConcurrentMap<K, V> paramConcurrentMap, Function<? super K, ? extends V> paramFunction)
    {
      super(paramStrength2, paramEquivalence1, paramEquivalence2, paramLong1, paramLong2, paramInt1, paramInt2, paramRemovalListener, paramConcurrentMap);
      this.computingFunction = paramFunction;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.delegate = readMapMaker(paramObjectInputStream).makeComputingMap(this.computingFunction);
      readEntries(paramObjectInputStream);
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      writeMapTo(paramObjectOutputStream);
    }
    
    Object readResolve()
    {
      return this.delegate;
    }
  }
  
  private static final class ComputingValueReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    @GuardedBy("this")
    volatile MapMakerInternalMap.ValueReference<K, V> computedReference = MapMakerInternalMap.unset();
    final Function<? super K, ? extends V> computingFunction;
    
    public ComputingValueReference(Function<? super K, ? extends V> paramFunction)
    {
      this.computingFunction = paramFunction;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
      setValueReference(paramValueReference);
    }
    
    V compute(K paramK, int paramInt)
      throws ExecutionException
    {
      try
      {
        paramK = this.computingFunction.apply(paramK);
        setValueReference(new ComputingConcurrentHashMap.ComputedReference(paramK));
        return paramK;
      }
      catch (Throwable paramK)
      {
        setValueReference(new ComputingConcurrentHashMap.ComputationExceptionReference(paramK));
        throw new ExecutionException(paramK);
      }
    }
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, @Nullable V paramV, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry)
    {
      return this;
    }
    
    public V get()
    {
      return null;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }
    
    public boolean isComputingReference()
    {
      return true;
    }
    
    void setValueReference(MapMakerInternalMap.ValueReference<K, V> paramValueReference)
    {
      try
      {
        if (this.computedReference == MapMakerInternalMap.UNSET)
        {
          this.computedReference = paramValueReference;
          notifyAll();
        }
        return;
      }
      finally {}
    }
    
    /* Error */
    public V waitForValue()
      throws ExecutionException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 32	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:computedReference	Lcom/google/common/collect/MapMakerInternalMap$ValueReference;
      //   4: getstatic 84	com/google/common/collect/MapMakerInternalMap:UNSET	Lcom/google/common/collect/MapMakerInternalMap$ValueReference;
      //   7: if_acmpne +52 -> 59
      //   10: iconst_0
      //   11: istore_1
      //   12: iconst_0
      //   13: istore_2
      //   14: aload_0
      //   15: monitorenter
      //   16: iload_2
      //   17: istore_1
      //   18: aload_0
      //   19: getfield 32	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:computedReference	Lcom/google/common/collect/MapMakerInternalMap$ValueReference;
      //   22: astore_3
      //   23: getstatic 84	com/google/common/collect/MapMakerInternalMap:UNSET	Lcom/google/common/collect/MapMakerInternalMap$ValueReference;
      //   26: astore 4
      //   28: aload_3
      //   29: aload 4
      //   31: if_acmpne +16 -> 47
      //   34: aload_0
      //   35: invokevirtual 93	java/lang/Object:wait	()V
      //   38: goto -20 -> 18
      //   41: astore_3
      //   42: iconst_1
      //   43: istore_1
      //   44: goto -26 -> 18
      //   47: aload_0
      //   48: monitorexit
      //   49: iload_1
      //   50: ifeq +9 -> 59
      //   53: invokestatic 99	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   56: invokevirtual 102	java/lang/Thread:interrupt	()V
      //   59: aload_0
      //   60: getfield 32	com/google/common/collect/ComputingConcurrentHashMap$ComputingValueReference:computedReference	Lcom/google/common/collect/MapMakerInternalMap$ValueReference;
      //   63: invokeinterface 104 1 0
      //   68: areturn
      //   69: astore_3
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_3
      //   73: athrow
      //   74: astore_3
      //   75: iload_1
      //   76: ifeq +9 -> 85
      //   79: invokestatic 99	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   82: invokevirtual 102	java/lang/Thread:interrupt	()V
      //   85: aload_3
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	ComputingValueReference
      //   11	65	1	i	int
      //   13	4	2	j	int
      //   22	7	3	localValueReference1	MapMakerInternalMap.ValueReference
      //   41	1	3	localInterruptedException	InterruptedException
      //   69	4	3	localObject1	Object
      //   74	12	3	localObject2	Object
      //   26	4	4	localValueReference2	MapMakerInternalMap.ValueReference
      // Exception table:
      //   from	to	target	type
      //   34	38	41	java/lang/InterruptedException
      //   18	28	69	finally
      //   34	38	69	finally
      //   47	49	69	finally
      //   70	72	69	finally
      //   14	16	74	finally
      //   72	74	74	finally
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ComputingConcurrentHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */