package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public final class RemovalNotification<K, V>
  implements Map.Entry<K, V>
{
  private static final long serialVersionUID = 0L;
  private final RemovalCause cause;
  @Nullable
  private final K key;
  @Nullable
  private final V value;
  
  private RemovalNotification(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause)
  {
    this.key = paramK;
    this.value = paramV;
    this.cause = ((RemovalCause)Preconditions.checkNotNull(paramRemovalCause));
  }
  
  public static <K, V> RemovalNotification<K, V> create(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause)
  {
    return new RemovalNotification(paramK, paramV, paramRemovalCause);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (Objects.equal(getKey(), ((Map.Entry)paramObject).getKey()))
      {
        bool1 = bool2;
        if (Objects.equal(getValue(), ((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public RemovalCause getCause()
  {
    return this.cause;
  }
  
  @Nullable
  public K getKey()
  {
    return (K)this.key;
  }
  
  @Nullable
  public V getValue()
  {
    return (V)this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label36;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label36:
      j = localObject2.hashCode();
    }
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
  
  public boolean wasEvicted()
  {
    return this.cause.wasEvicted();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/RemovalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */