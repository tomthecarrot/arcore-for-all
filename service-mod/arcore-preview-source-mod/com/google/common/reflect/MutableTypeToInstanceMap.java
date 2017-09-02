package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class MutableTypeToInstanceMap<B>
  extends ForwardingMap<TypeToken<? extends B>, B>
  implements TypeToInstanceMap<B>
{
  private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();
  
  @Nullable
  private <T extends B> T trustedGet(TypeToken<T> paramTypeToken)
  {
    return (T)this.backingMap.get(paramTypeToken);
  }
  
  @Nullable
  private <T extends B> T trustedPut(TypeToken<T> paramTypeToken, @Nullable T paramT)
  {
    return (T)this.backingMap.put(paramTypeToken, paramT);
  }
  
  protected Map<TypeToken<? extends B>, B> delegate()
  {
    return this.backingMap;
  }
  
  public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet()
  {
    return UnmodifiableEntry.transformEntries(super.entrySet());
  }
  
  @Nullable
  public <T extends B> T getInstance(TypeToken<T> paramTypeToken)
  {
    return (T)trustedGet(paramTypeToken.rejectTypeVariables());
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return (T)trustedGet(TypeToken.of(paramClass));
  }
  
  public B put(TypeToken<? extends B> paramTypeToken, B paramB)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  @Nullable
  public <T extends B> T putInstance(TypeToken<T> paramTypeToken, @Nullable T paramT)
  {
    return (T)trustedPut(paramTypeToken.rejectTypeVariables(), paramT);
  }
  
  @Nullable
  public <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT)
  {
    return (T)trustedPut(TypeToken.of(paramClass), paramT);
  }
  
  private static final class UnmodifiableEntry<K, V>
    extends ForwardingMapEntry<K, V>
  {
    private final Map.Entry<K, V> delegate;
    
    private UnmodifiableEntry(Map.Entry<K, V> paramEntry)
    {
      this.delegate = ((Map.Entry)Preconditions.checkNotNull(paramEntry));
    }
    
    private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> paramIterator)
    {
      Iterators.transform(paramIterator, new Function()
      {
        public Map.Entry<K, V> apply(Map.Entry<K, V> paramAnonymousEntry)
        {
          return new MutableTypeToInstanceMap.UnmodifiableEntry(paramAnonymousEntry, null);
        }
      });
    }
    
    static <K, V> Set<Map.Entry<K, V>> transformEntries(Set<Map.Entry<K, V>> paramSet)
    {
      new ForwardingSet()
      {
        protected Set<Map.Entry<K, V>> delegate()
        {
          return this.val$entries;
        }
        
        public Iterator<Map.Entry<K, V>> iterator()
        {
          return MutableTypeToInstanceMap.UnmodifiableEntry.transformEntries(super.iterator());
        }
        
        public Object[] toArray()
        {
          return standardToArray();
        }
        
        public <T> T[] toArray(T[] paramAnonymousArrayOfT)
        {
          return standardToArray(paramAnonymousArrayOfT);
        }
      };
    }
    
    protected Map.Entry<K, V> delegate()
    {
      return this.delegate;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/MutableTypeToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */