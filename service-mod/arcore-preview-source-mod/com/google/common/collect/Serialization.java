package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Serialization
{
  static <T> FieldSetter<T> getFieldSetter(Class<T> paramClass, String paramString)
  {
    try
    {
      paramClass = new FieldSetter(paramClass.getDeclaredField(paramString), null);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  static <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMap(paramMap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMap.put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  static <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMultimap(paramMultimap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      Collection localCollection = paramMultimap.get(paramObjectInputStream.readObject());
      int k = paramObjectInputStream.readInt();
      int j = 0;
      while (j < k)
      {
        localCollection.add(paramObjectInputStream.readObject());
        j += 1;
      }
      i += 1;
    }
  }
  
  static <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMultiset(paramMultiset, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMultiset.add(paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
      i += 1;
    }
  }
  
  static int readCount(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    return paramObjectInputStream.readInt();
  }
  
  static <K, V> void writeMap(Map<K, V> paramMap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  static <K, V> void writeMultimap(Multimap<K, V> paramMultimap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMultimap.asMap().size());
    paramMultimap = paramMultimap.asMap().entrySet().iterator();
    while (paramMultimap.hasNext())
    {
      Object localObject = (Map.Entry)paramMultimap.next();
      paramObjectOutputStream.writeObject(((Map.Entry)localObject).getKey());
      paramObjectOutputStream.writeInt(((Collection)((Map.Entry)localObject).getValue()).size());
      localObject = ((Collection)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObjectOutputStream.writeObject(((Iterator)localObject).next());
      }
    }
  }
  
  static <E> void writeMultiset(Multiset<E> paramMultiset, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMultiset.entrySet().size());
    paramMultiset = paramMultiset.entrySet().iterator();
    while (paramMultiset.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)paramMultiset.next();
      paramObjectOutputStream.writeObject(localEntry.getElement());
      paramObjectOutputStream.writeInt(localEntry.getCount());
    }
  }
  
  static final class FieldSetter<T>
  {
    private final Field field;
    
    private FieldSetter(Field paramField)
    {
      this.field = paramField;
      paramField.setAccessible(true);
    }
    
    void set(T paramT, int paramInt)
    {
      try
      {
        this.field.set(paramT, Integer.valueOf(paramInt));
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError(paramT);
      }
    }
    
    void set(T paramT, Object paramObject)
    {
      try
      {
        this.field.set(paramT, paramObject);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError(paramT);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Serialization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */