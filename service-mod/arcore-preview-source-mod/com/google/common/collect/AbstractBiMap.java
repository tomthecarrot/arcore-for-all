package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private transient Map<K, V> delegate;
  private transient Set<Map.Entry<K, V>> entrySet;
  transient AbstractBiMap<V, K> inverse;
  private transient Set<K> keySet;
  private transient Set<V> valueSet;
  
  private AbstractBiMap(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.delegate = paramMap;
    this.inverse = paramAbstractBiMap;
  }
  
  AbstractBiMap(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean)
  {
    checkKey(paramK);
    checkValue(paramV);
    boolean bool = containsKey(paramK);
    if ((bool) && (Objects.equal(paramV, get(paramK)))) {
      return paramV;
    }
    if (paramBoolean)
    {
      inverse().remove(paramV);
      Object localObject = this.delegate.put(paramK, paramV);
      updateInverseMap(paramK, bool, localObject, paramV);
      return (V)localObject;
    }
    if (!containsValue(paramV)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Preconditions.checkArgument(paramBoolean, "value already present: %s", new Object[] { paramV });
      break;
    }
  }
  
  private V removeFromBothMaps(Object paramObject)
  {
    paramObject = this.delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return (V)paramObject;
  }
  
  private void removeFromInverseMap(V paramV)
  {
    this.inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2)
  {
    if (paramBoolean) {
      removeFromInverseMap(paramV1);
    }
    this.inverse.delegate.put(paramV2, paramK);
  }
  
  K checkKey(@Nullable K paramK)
  {
    return paramK;
  }
  
  V checkValue(@Nullable V paramV)
  {
    return paramV;
  }
  
  public void clear()
  {
    this.delegate.clear();
    this.inverse.delegate.clear();
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return this.inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new EntrySet(null);
      this.entrySet = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public V forcePut(@Nullable K paramK, @Nullable V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, true);
  }
  
  public BiMap<V, K> inverse()
  {
    return this.inverse;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new KeySet(null);
      this.keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  public V put(@Nullable K paramK, @Nullable V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public V remove(@Nullable Object paramObject)
  {
    if (containsKey(paramObject)) {
      return (V)removeFromBothMaps(paramObject);
    }
    return null;
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    boolean bool2 = true;
    if (this.delegate == null)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (this.inverse != null) {
        break label84;
      }
      bool1 = true;
      label25:
      Preconditions.checkState(bool1);
      Preconditions.checkArgument(paramMap.isEmpty());
      Preconditions.checkArgument(paramMap1.isEmpty());
      if (paramMap == paramMap1) {
        break label89;
      }
    }
    label84:
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.delegate = paramMap;
      this.inverse = new Inverse(paramMap1, this, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  void setInverse(AbstractBiMap<V, K> paramAbstractBiMap)
  {
    this.inverse = paramAbstractBiMap;
  }
  
  public Set<V> values()
  {
    Set localSet = this.valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ValueSet(null);
      this.valueSet = ((Set)localObject);
    }
    return (Set<V>)localObject;
  }
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.this.delegate.entrySet();
    
    private EntrySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<Map.Entry<K, V>> delegate()
    {
      return this.esDelegate;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      new Iterator()
      {
        Map.Entry<K, V> entry;
        
        public boolean hasNext()
        {
          return this.val$iterator.hasNext();
        }
        
        public Map.Entry<K, V> next()
        {
          this.entry = ((Map.Entry)this.val$iterator.next());
          new ForwardingMapEntry()
          {
            protected Map.Entry<K, V> delegate()
            {
              return this.val$finalEntry;
            }
            
            public V setValue(V paramAnonymous2V)
            {
              Preconditions.checkState(AbstractBiMap.EntrySet.this.contains(this), "entry no longer in map");
              if (Objects.equal(paramAnonymous2V, getValue())) {
                return paramAnonymous2V;
              }
              if (!AbstractBiMap.this.containsValue(paramAnonymous2V)) {}
              for (boolean bool = true;; bool = false)
              {
                Preconditions.checkArgument(bool, "value already present: %s", new Object[] { paramAnonymous2V });
                Object localObject = this.val$finalEntry.setValue(paramAnonymous2V);
                Preconditions.checkState(Objects.equal(paramAnonymous2V, AbstractBiMap.this.get(getKey())), "entry no longer in map");
                AbstractBiMap.this.updateInverseMap(getKey(), true, localObject, paramAnonymous2V);
                return (V)localObject;
              }
            }
          };
        }
        
        public void remove()
        {
          if (this.entry != null) {}
          for (boolean bool = true;; bool = false)
          {
            CollectPreconditions.checkRemove(bool);
            Object localObject = this.entry.getValue();
            this.val$iterator.remove();
            AbstractBiMap.this.removeFromInverseMap(localObject);
            return;
          }
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      if (!this.esDelegate.contains(paramObject)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      AbstractBiMap.this.inverse.delegate.remove(((Map.Entry)paramObject).getValue());
      this.esDelegate.remove(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  private static class Inverse<K, V>
    extends AbstractBiMap<K, V>
  {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    private Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
    {
      super(paramAbstractBiMap, null);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      setInverse((AbstractBiMap)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible("java.io.ObjectOuputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(inverse());
    }
    
    K checkKey(K paramK)
    {
      return (K)this.inverse.checkValue(paramK);
    }
    
    V checkValue(V paramV)
    {
      return (V)this.inverse.checkKey(paramV);
    }
    
    @GwtIncompatible("Not needed in the emulated source.")
    Object readResolve()
    {
      return inverse().inverse();
    }
  }
  
  private class KeySet
    extends ForwardingSet<K>
  {
    private KeySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    protected Set<K> delegate()
    {
      return AbstractBiMap.this.delegate.keySet();
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (!contains(paramObject)) {
        return false;
      }
      AbstractBiMap.this.removeFromBothMaps(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
  }
  
  private class ValueSet
    extends ForwardingSet<V>
  {
    final Set<V> valuesDelegate = AbstractBiMap.this.inverse.keySet();
    
    private ValueSet() {}
    
    protected Set<V> delegate()
    {
      return this.valuesDelegate;
    }
    
    public Iterator<V> iterator()
    {
      return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */