package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableBiMap<K, V>
  extends ImmutableMap<K, V>
  implements BiMap<K, V>
{
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  @Beta
  public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    paramIterable = (Map.Entry[])Iterables.toArray(paramIterable, EMPTY_ENTRY_ARRAY);
    switch (paramIterable.length)
    {
    default: 
      return RegularImmutableBiMap.fromEntries(paramIterable);
    case 0: 
      return of();
    }
    paramIterable = paramIterable[0];
    return of(paramIterable.getKey(), paramIterable.getValue());
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if ((paramMap instanceof ImmutableBiMap))
    {
      ImmutableBiMap localImmutableBiMap = (ImmutableBiMap)paramMap;
      if (!localImmutableBiMap.isPartialView()) {
        return localImmutableBiMap;
      }
    }
    return copyOf(paramMap.entrySet());
  }
  
  public static <K, V> ImmutableBiMap<K, V> of()
  {
    return RegularImmutableBiMap.EMPTY;
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK, V paramV)
  {
    return new SingletonImmutableBiMap(paramK, paramV);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return RegularImmutableBiMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return RegularImmutableBiMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return RegularImmutableBiMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return RegularImmutableBiMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  @Deprecated
  public V forcePut(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ImmutableBiMap<V, K> inverse();
  
  public ImmutableSet<V> values()
  {
    return inverse().keySet();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static final class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    public Builder() {}
    
    Builder(int paramInt)
    {
      super();
    }
    
    public ImmutableBiMap<K, V> build()
    {
      switch (this.size)
      {
      default: 
        if (this.valueComparator != null)
        {
          if (this.entriesUsed) {
            this.entries = ((ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size));
          }
          Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
        }
        if (this.size != this.entries.length) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.entriesUsed = bool;
        return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
        return ImmutableBiMap.of();
        return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
      }
    }
    
    @Beta
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> paramComparator)
    {
      super.orderEntriesByValue(paramComparator);
      return this;
    }
    
    public Builder<K, V> put(K paramK, V paramV)
    {
      super.put(paramK, paramV);
      return this;
    }
    
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      super.put(paramEntry);
      return this;
    }
    
    @Beta
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.putAll(paramIterable);
      return this;
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap)
    {
      super.putAll(paramMap);
      return this;
    }
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    
    SerializedForm(ImmutableBiMap<?, ?> paramImmutableBiMap)
    {
      super();
    }
    
    Object readResolve()
    {
      return createMap(new ImmutableBiMap.Builder());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */