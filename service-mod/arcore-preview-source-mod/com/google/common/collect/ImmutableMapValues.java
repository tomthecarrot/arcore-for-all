package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class ImmutableMapValues<K, V>
  extends ImmutableCollection<V>
{
  @Weak
  private final ImmutableMap<K, V> map;
  
  ImmutableMapValues(ImmutableMap<K, V> paramImmutableMap)
  {
    this.map = paramImmutableMap;
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (paramObject != null) && (Iterators.contains(iterator(), paramObject));
  }
  
  ImmutableList<V> createAsList()
  {
    new ImmutableAsList()
    {
      ImmutableCollection<V> delegateCollection()
      {
        return ImmutableMapValues.this;
      }
      
      public V get(int paramAnonymousInt)
      {
        return (V)((Map.Entry)this.val$entryList.get(paramAnonymousInt)).getValue();
      }
    };
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public UnmodifiableIterator<V> iterator()
  {
    new UnmodifiableIterator()
    {
      final UnmodifiableIterator<Map.Entry<K, V>> entryItr = ImmutableMapValues.this.map.entrySet().iterator();
      
      public boolean hasNext()
      {
        return this.entryItr.hasNext();
      }
      
      public V next()
      {
        return (V)((Map.Entry)this.entryItr.next()).getValue();
      }
    };
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  @GwtIncompatible("serialization")
  Object writeReplace()
  {
    return new SerializedForm(this.map);
  }
  
  @GwtIncompatible("serialization")
  private static class SerializedForm<V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMap<?, V> map;
    
    SerializedForm(ImmutableMap<?, V> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    Object readResolve()
    {
      return this.map.values();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */