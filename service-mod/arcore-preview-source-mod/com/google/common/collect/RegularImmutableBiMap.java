package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
class RegularImmutableBiMap<K, V>
  extends ImmutableBiMap<K, V>
{
  static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap(null, null, (Map.Entry[])ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
  static final double MAX_LOAD_FACTOR = 1.2D;
  private final transient Map.Entry<K, V>[] entries;
  private final transient int hashCode;
  private transient ImmutableBiMap<V, K> inverse;
  private final transient ImmutableMapEntry<K, V>[] keyTable;
  private final transient int mask;
  private final transient ImmutableMapEntry<K, V>[] valueTable;
  
  private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry1, ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry2, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt1, int paramInt2)
  {
    this.keyTable = paramArrayOfImmutableMapEntry1;
    this.valueTable = paramArrayOfImmutableMapEntry2;
    this.entries = paramArrayOfEntry;
    this.mask = paramInt1;
    this.hashCode = paramInt2;
  }
  
  private static void checkNoConflictInValueBucket(Object paramObject, Map.Entry<?, ?> paramEntry, @Nullable ImmutableMapEntry<?, ?> paramImmutableMapEntry)
  {
    if (paramImmutableMapEntry != null)
    {
      if (!paramObject.equals(paramImmutableMapEntry.getValue())) {}
      for (boolean bool = true;; bool = false)
      {
        checkNoConflict(bool, "value", paramEntry, paramImmutableMapEntry);
        paramImmutableMapEntry = paramImmutableMapEntry.getNextInValueBucket();
        break;
      }
    }
  }
  
  static <K, V> RegularImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... paramVarArgs)
  {
    return fromEntryArray(paramVarArgs.length, paramVarArgs);
  }
  
  static <K, V> RegularImmutableBiMap<K, V> fromEntryArray(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry)
  {
    Preconditions.checkPositionIndex(paramInt, paramArrayOfEntry.length);
    int i = Hashing.closedTableSize(paramInt, 1.2D);
    int m = i - 1;
    ImmutableMapEntry[] arrayOfImmutableMapEntry1 = ImmutableMapEntry.createEntryArray(i);
    ImmutableMapEntry[] arrayOfImmutableMapEntry2 = ImmutableMapEntry.createEntryArray(i);
    Object localObject2;
    int j;
    label45:
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int n;
    int i1;
    int i2;
    int i3;
    ImmutableMapEntry localImmutableMapEntry1;
    ImmutableMapEntry localImmutableMapEntry2;
    int k;
    if (paramInt == paramArrayOfEntry.length)
    {
      localObject2 = paramArrayOfEntry;
      j = 0;
      i = 0;
      if (i >= paramInt) {
        break label276;
      }
      localObject1 = paramArrayOfEntry[i];
      localObject3 = ((Map.Entry)localObject1).getKey();
      localObject4 = ((Map.Entry)localObject1).getValue();
      CollectPreconditions.checkEntryNotNull(localObject3, localObject4);
      n = localObject3.hashCode();
      i1 = localObject4.hashCode();
      i2 = Hashing.smear(n) & m;
      i3 = Hashing.smear(i1) & m;
      localImmutableMapEntry1 = arrayOfImmutableMapEntry1[i2];
      RegularImmutableMap.checkNoConflictInKeyBucket(localObject3, (Map.Entry)localObject1, localImmutableMapEntry1);
      localImmutableMapEntry2 = arrayOfImmutableMapEntry2[i3];
      checkNoConflictInValueBucket(localObject4, (Map.Entry)localObject1, localImmutableMapEntry2);
      if ((localImmutableMapEntry2 != null) || (localImmutableMapEntry1 != null)) {
        break label256;
      }
      if ((!(localObject1 instanceof ImmutableMapEntry)) || (!((ImmutableMapEntry)localObject1).isReusable())) {
        break label234;
      }
      k = 1;
      label178:
      if (k == 0) {
        break label240;
      }
      localObject1 = (ImmutableMapEntry)localObject1;
    }
    for (;;)
    {
      arrayOfImmutableMapEntry1[i2] = localObject1;
      arrayOfImmutableMapEntry2[i3] = localObject1;
      localObject2[i] = localObject1;
      j += (n ^ i1);
      i += 1;
      break label45;
      localObject2 = ImmutableMapEntry.createEntryArray(paramInt);
      break;
      label234:
      k = 0;
      break label178;
      label240:
      localObject1 = new ImmutableMapEntry(localObject3, localObject4);
      continue;
      label256:
      localObject1 = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(localObject3, localObject4, localImmutableMapEntry1, localImmutableMapEntry2);
    }
    label276:
    return new RegularImmutableBiMap(arrayOfImmutableMapEntry1, arrayOfImmutableMapEntry2, (Map.Entry[])localObject2, m, j);
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
  }
  
  @Nullable
  public V get(@Nullable Object paramObject)
  {
    if (this.keyTable == null) {
      return null;
    }
    return (V)RegularImmutableMap.get(paramObject, this.keyTable, this.mask);
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  public ImmutableBiMap<V, K> inverse()
  {
    if (isEmpty()) {
      localObject = ImmutableBiMap.of();
    }
    ImmutableBiMap localImmutableBiMap;
    do
    {
      return (ImmutableBiMap<V, K>)localObject;
      localImmutableBiMap = this.inverse;
      localObject = localImmutableBiMap;
    } while (localImmutableBiMap != null);
    Object localObject = new Inverse(null);
    this.inverse = ((ImmutableBiMap)localObject);
    return (ImmutableBiMap<V, K>)localObject;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.entries.length;
  }
  
  private final class Inverse
    extends ImmutableBiMap<V, K>
  {
    private Inverse() {}
    
    ImmutableSet<Map.Entry<V, K>> createEntrySet()
    {
      return new InverseEntrySet();
    }
    
    public K get(@Nullable Object paramObject)
    {
      if ((paramObject == null) || (RegularImmutableBiMap.this.valueTable == null)) {}
      for (;;)
      {
        return null;
        int i = Hashing.smear(paramObject.hashCode());
        int j = RegularImmutableBiMap.this.mask;
        for (ImmutableMapEntry localImmutableMapEntry = RegularImmutableBiMap.this.valueTable[(i & j)]; localImmutableMapEntry != null; localImmutableMapEntry = localImmutableMapEntry.getNextInValueBucket()) {
          if (paramObject.equals(localImmutableMapEntry.getValue())) {
            return (K)localImmutableMapEntry.getKey();
          }
        }
      }
    }
    
    public ImmutableBiMap<K, V> inverse()
    {
      return RegularImmutableBiMap.this;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public int size()
    {
      return inverse().size();
    }
    
    Object writeReplace()
    {
      return new RegularImmutableBiMap.InverseSerializedForm(RegularImmutableBiMap.this);
    }
    
    final class InverseEntrySet
      extends ImmutableMapEntrySet<V, K>
    {
      InverseEntrySet() {}
      
      ImmutableList<Map.Entry<V, K>> createAsList()
      {
        new ImmutableAsList()
        {
          ImmutableCollection<Map.Entry<V, K>> delegateCollection()
          {
            return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
          }
          
          public Map.Entry<V, K> get(int paramAnonymousInt)
          {
            Map.Entry localEntry = RegularImmutableBiMap.this.entries[paramAnonymousInt];
            return Maps.immutableEntry(localEntry.getValue(), localEntry.getKey());
          }
        };
      }
      
      public int hashCode()
      {
        return RegularImmutableBiMap.this.hashCode;
      }
      
      boolean isHashCodeFast()
      {
        return true;
      }
      
      public UnmodifiableIterator<Map.Entry<V, K>> iterator()
      {
        return asList().iterator();
      }
      
      ImmutableMap<V, K> map()
      {
        return RegularImmutableBiMap.Inverse.this;
      }
    }
  }
  
  private static class InverseSerializedForm<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private final ImmutableBiMap<K, V> forward;
    
    InverseSerializedForm(ImmutableBiMap<K, V> paramImmutableBiMap)
    {
      this.forward = paramImmutableBiMap;
    }
    
    Object readResolve()
    {
      return this.forward.inverse();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */