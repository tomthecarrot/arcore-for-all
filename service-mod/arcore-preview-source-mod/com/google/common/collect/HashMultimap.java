package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

@GwtCompatible(emulated=true, serializable=true)
public final class HashMultimap<K, V>
  extends AbstractSetMultimap<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 2;
  @GwtIncompatible("Not needed in emulated source")
  private static final long serialVersionUID = 0L;
  @VisibleForTesting
  transient int expectedValuesPerKey = 2;
  
  private HashMultimap()
  {
    super(new HashMap());
  }
  
  private HashMultimap(int paramInt1, int paramInt2)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt1));
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.expectedValuesPerKey = paramInt2;
      return;
    }
  }
  
  private HashMultimap(Multimap<? extends K, ? extends V> paramMultimap)
  {
    super(Maps.newHashMapWithExpectedSize(paramMultimap.keySet().size()));
    putAll(paramMultimap);
  }
  
  public static <K, V> HashMultimap<K, V> create()
  {
    return new HashMultimap();
  }
  
  public static <K, V> HashMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new HashMultimap(paramInt1, paramInt2);
  }
  
  public static <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap)
  {
    return new HashMultimap(paramMultimap);
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.expectedValuesPerKey = 2;
    int i = Serialization.readCount(paramObjectInputStream);
    setMap(Maps.newHashMap());
    Serialization.populateMultimap(this, paramObjectInputStream, i);
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  Set<V> createCollection()
  {
    return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/HashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */