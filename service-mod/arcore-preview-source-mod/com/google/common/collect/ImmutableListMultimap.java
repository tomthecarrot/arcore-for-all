package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableListMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements ListMultimap<K, V>
{
  @GwtIncompatible("Not needed in emulated source")
  private static final long serialVersionUID = 0L;
  private transient ImmutableListMultimap<V, K> inverse;
  
  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt)
  {
    super(paramImmutableMap, paramInt);
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap)
  {
    if (paramMultimap.isEmpty()) {
      localObject1 = of();
    }
    Object localObject2;
    do
    {
      return (ImmutableListMultimap<K, V>)localObject1;
      if (!(paramMultimap instanceof ImmutableListMultimap)) {
        break;
      }
      localObject2 = (ImmutableListMultimap)paramMultimap;
      localObject1 = localObject2;
    } while (!((ImmutableListMultimap)localObject2).isPartialView());
    Object localObject1 = new ImmutableMap.Builder(paramMultimap.asMap().size());
    int i = 0;
    paramMultimap = paramMultimap.asMap().entrySet().iterator();
    while (paramMultimap.hasNext())
    {
      localObject2 = (Map.Entry)paramMultimap.next();
      ImmutableList localImmutableList = ImmutableList.copyOf((Collection)((Map.Entry)localObject2).getValue());
      if (!localImmutableList.isEmpty())
      {
        ((ImmutableMap.Builder)localObject1).put(((Map.Entry)localObject2).getKey(), localImmutableList);
        i += localImmutableList.size();
      }
    }
    return new ImmutableListMultimap(((ImmutableMap.Builder)localObject1).build(), i);
  }
  
  @Beta
  public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return new Builder().putAll(paramIterable).build();
  }
  
  private ImmutableListMultimap<V, K> invert()
  {
    Object localObject = builder();
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Builder)localObject).put(localEntry.getValue(), localEntry.getKey());
    }
    localObject = ((Builder)localObject).build();
    ((ImmutableListMultimap)localObject).inverse = this;
    return (ImmutableListMultimap<V, K>)localObject;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of()
  {
    return EmptyImmutableListMultimap.INSTANCE;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK, V paramV)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK, paramV);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    localBuilder.put(paramK4, paramV4);
    return localBuilder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    Builder localBuilder = builder();
    localBuilder.put(paramK1, paramV1);
    localBuilder.put(paramK2, paramV2);
    localBuilder.put(paramK3, paramV3);
    localBuilder.put(paramK4, paramV4);
    localBuilder.put(paramK5, paramV5);
    return localBuilder.build();
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int m = paramObjectInputStream.readInt();
    if (m < 0) {
      throw new InvalidObjectException("Invalid key count " + m);
    }
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      Object localObject = paramObjectInputStream.readObject();
      int n = paramObjectInputStream.readInt();
      if (n <= 0) {
        throw new InvalidObjectException("Invalid value count " + n);
      }
      ImmutableList.Builder localBuilder1 = ImmutableList.builder();
      int k = 0;
      while (k < n)
      {
        localBuilder1.add(paramObjectInputStream.readObject());
        k += 1;
      }
      localBuilder.put(localObject, localBuilder1.build());
      j += n;
      i += 1;
    }
    try
    {
      paramObjectInputStream = localBuilder.build();
      ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, paramObjectInputStream);
      ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, j);
      return;
    }
    catch (IllegalArgumentException paramObjectInputStream)
    {
      throw ((InvalidObjectException)new InvalidObjectException(paramObjectInputStream.getMessage()).initCause(paramObjectInputStream));
    }
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public ImmutableList<V> get(@Nullable K paramK)
  {
    ImmutableList localImmutableList = (ImmutableList)this.map.get(paramK);
    paramK = localImmutableList;
    if (localImmutableList == null) {
      paramK = ImmutableList.of();
    }
    return paramK;
  }
  
  public ImmutableListMultimap<V, K> inverse()
  {
    ImmutableListMultimap localImmutableListMultimap2 = this.inverse;
    ImmutableListMultimap localImmutableListMultimap1 = localImmutableListMultimap2;
    if (localImmutableListMultimap2 == null)
    {
      localImmutableListMultimap1 = invert();
      this.inverse = localImmutableListMultimap1;
    }
    return localImmutableListMultimap1;
  }
  
  @Deprecated
  public ImmutableList<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public ImmutableList<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V>
  {
    public ImmutableListMultimap<K, V> build()
    {
      return (ImmutableListMultimap)super.build();
    }
    
    public Builder<K, V> orderKeysBy(Comparator<? super K> paramComparator)
    {
      super.orderKeysBy(paramComparator);
      return this;
    }
    
    public Builder<K, V> orderValuesBy(Comparator<? super V> paramComparator)
    {
      super.orderValuesBy(paramComparator);
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
    
    public Builder<K, V> putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      super.putAll(paramMultimap);
      return this;
    }
    
    @Beta
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.putAll(paramIterable);
      return this;
    }
    
    public Builder<K, V> putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      super.putAll(paramK, paramIterable);
      return this;
    }
    
    public Builder<K, V> putAll(K paramK, V... paramVarArgs)
    {
      super.putAll(paramK, paramVarArgs);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */