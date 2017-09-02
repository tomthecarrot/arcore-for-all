package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class ImmutableMapKeySet<K, V>
  extends ImmutableSet.Indexed<K>
{
  @Weak
  private final ImmutableMap<K, V> map;
  
  ImmutableMapKeySet(ImmutableMap<K, V> paramImmutableMap)
  {
    this.map = paramImmutableMap;
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  K get(int paramInt)
  {
    return (K)((Map.Entry)this.map.entrySet().asList().get(paramInt)).getKey();
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public UnmodifiableIterator<K> iterator()
  {
    return this.map.keyIterator();
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  @GwtIncompatible("serialization")
  Object writeReplace()
  {
    return new KeySetSerializedForm(this.map);
  }
  
  @GwtIncompatible("serialization")
  private static class KeySetSerializedForm<K>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMap<K, ?> map;
    
    KeySetSerializedForm(ImmutableMap<K, ?> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    Object readResolve()
    {
      return this.map.keySet();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMapKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */