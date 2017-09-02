package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class ImmutableEnumMap<K extends Enum<K>, V>
  extends ImmutableMap.IteratorBasedImmutableMap<K, V>
{
  private final transient EnumMap<K, V> delegate;
  
  private ImmutableEnumMap(EnumMap<K, V> paramEnumMap)
  {
    this.delegate = paramEnumMap;
    if (!paramEnumMap.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> paramEnumMap)
  {
    switch (paramEnumMap.size())
    {
    default: 
      return new ImmutableEnumMap(paramEnumMap);
    case 0: 
      return ImmutableMap.of();
    }
    paramEnumMap = (Map.Entry)Iterables.getOnlyElement(paramEnumMap.entrySet());
    return ImmutableMap.of(paramEnumMap.getKey(), paramEnumMap.getValue());
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.delegate.containsKey(paramObject);
  }
  
  UnmodifiableIterator<Map.Entry<K, V>> entryIterator()
  {
    return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ImmutableEnumMap)) {
      localObject = ((ImmutableEnumMap)paramObject).delegate;
    }
    return this.delegate.equals(localObject);
  }
  
  public V get(Object paramObject)
  {
    return (V)this.delegate.get(paramObject);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  UnmodifiableIterator<K> keyIterator()
  {
    return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
  }
  
  public int size()
  {
    return this.delegate.size();
  }
  
  Object writeReplace()
  {
    return new EnumSerializedForm(this.delegate);
  }
  
  private static class EnumSerializedForm<K extends Enum<K>, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final EnumMap<K, V> delegate;
    
    EnumSerializedForm(EnumMap<K, V> paramEnumMap)
    {
      this.delegate = paramEnumMap;
    }
    
    Object readResolve()
    {
      return new ImmutableEnumMap(this.delegate, null);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableEnumMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */