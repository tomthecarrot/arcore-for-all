package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@GwtCompatible(emulated=true, serializable=true)
public final class ArrayListMultimap<K, V>
  extends AbstractListMultimap<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 3;
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  @VisibleForTesting
  transient int expectedValuesPerKey;
  
  private ArrayListMultimap()
  {
    super(new HashMap());
    this.expectedValuesPerKey = 3;
  }
  
  private ArrayListMultimap(int paramInt1, int paramInt2)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt1));
    CollectPreconditions.checkNonnegative(paramInt2, "expectedValuesPerKey");
    this.expectedValuesPerKey = paramInt2;
  }
  
  private ArrayListMultimap(Multimap<? extends K, ? extends V> paramMultimap) {}
  
  public static <K, V> ArrayListMultimap<K, V> create()
  {
    return new ArrayListMultimap();
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new ArrayListMultimap(paramInt1, paramInt2);
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap)
  {
    return new ArrayListMultimap(paramMultimap);
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.expectedValuesPerKey = 3;
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
  
  List<V> createCollection()
  {
    return new ArrayList(this.expectedValuesPerKey);
  }
  
  public void trimToSize()
  {
    Iterator localIterator = backingMap().values().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localIterator.next()).trimToSize();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ArrayListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */