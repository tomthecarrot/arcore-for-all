package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class ImmutableMapEntrySet<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  public boolean contains(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = map().get(((Map.Entry)paramObject).getKey());
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.equals(((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return map().hashCode();
  }
  
  @GwtIncompatible("not used in GWT")
  boolean isHashCodeFast()
  {
    return map().isHashCodeFast();
  }
  
  boolean isPartialView()
  {
    return map().isPartialView();
  }
  
  abstract ImmutableMap<K, V> map();
  
  public int size()
  {
    return map().size();
  }
  
  @GwtIncompatible("serialization")
  Object writeReplace()
  {
    return new EntrySetSerializedForm(map());
  }
  
  @GwtIncompatible("serialization")
  private static class EntrySetSerializedForm<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMap<K, V> map;
    
    EntrySetSerializedForm(ImmutableMap<K, V> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    Object readResolve()
    {
      return this.map.entrySet();
    }
  }
  
  static final class RegularEntrySet<K, V>
    extends ImmutableMapEntrySet<K, V>
  {
    private final transient Map.Entry<K, V>[] entries;
    @Weak
    private final transient ImmutableMap<K, V> map;
    
    RegularEntrySet(ImmutableMap<K, V> paramImmutableMap, Map.Entry<K, V>[] paramArrayOfEntry)
    {
      this.map = paramImmutableMap;
      this.entries = paramArrayOfEntry;
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      return new RegularImmutableAsList(this, this.entries);
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return asList().iterator();
    }
    
    ImmutableMap<K, V> map()
    {
      return this.map;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMapEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */