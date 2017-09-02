package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapFieldLite<K, V>
  extends LinkedHashMap<K, V>
{
  private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite(Collections.emptyMap());
  private boolean isMutable = true;
  
  static
  {
    EMPTY_MAP_FIELD.makeImmutable();
  }
  
  private MapFieldLite() {}
  
  private MapFieldLite(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  static <K, V> int calculateHashCodeForMap(Map<K, V> paramMap)
  {
    int i = 0;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      i += (calculateHashCodeForObject(localEntry.getKey()) ^ calculateHashCodeForObject(localEntry.getValue()));
    }
    return i;
  }
  
  private static int calculateHashCodeForObject(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return Internal.hashCode((byte[])paramObject);
    }
    if ((paramObject instanceof Internal.EnumLite)) {
      throw new UnsupportedOperationException();
    }
    return paramObject.hashCode();
  }
  
  private static Object copy(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      localObject = Arrays.copyOf((byte[])paramObject, paramObject.length);
    }
    return localObject;
  }
  
  static <K, V> Map<K, V> copy(Map<K, V> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), copy(localEntry.getValue()));
    }
    return localLinkedHashMap;
  }
  
  public static <K, V> MapFieldLite<K, V> emptyMapField()
  {
    return EMPTY_MAP_FIELD;
  }
  
  private void ensureMutable()
  {
    if (!isMutable()) {
      throw new UnsupportedOperationException();
    }
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {}
    Map.Entry localEntry;
    do
    {
      while (!paramMap1.hasNext())
      {
        return true;
        if (paramMap1.size() != paramMap2.size()) {
          return false;
        }
        paramMap1 = paramMap1.entrySet().iterator();
      }
      localEntry = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(localEntry.getKey())) {
        return false;
      }
    } while (equals(localEntry.getValue(), paramMap2.get(localEntry.getKey())));
    return false;
  }
  
  public void clear()
  {
    ensureMutable();
    clear();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (equals(this, (Map)paramObject));
  }
  
  public int hashCode()
  {
    return calculateHashCodeForMap(this);
  }
  
  public boolean isMutable()
  {
    return this.isMutable;
  }
  
  public void makeImmutable()
  {
    this.isMutable = false;
  }
  
  public void mergeFrom(MapFieldLite<K, V> paramMapFieldLite)
  {
    ensureMutable();
    if (!paramMapFieldLite.isEmpty()) {
      putAll(paramMapFieldLite);
    }
  }
  
  public MapFieldLite<K, V> mutableCopy()
  {
    if (isEmpty()) {
      return new MapFieldLite();
    }
    return new MapFieldLite(this);
  }
  
  public V put(K paramK, V paramV)
  {
    ensureMutable();
    return (V)super.put(paramK, paramV);
  }
  
  public V put(Map.Entry<K, V> paramEntry)
  {
    return (V)put(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureMutable();
    super.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    ensureMutable();
    return (V)super.remove(paramObject);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/MapFieldLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */