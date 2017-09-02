package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class EnumHashBiMap<K extends Enum<K>, V>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("only needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private transient Class<K> keyType;
  
  private EnumHashBiMap(Class<K> paramClass)
  {
    super(WellBehavedMap.wrap(new EnumMap(paramClass)), Maps.newHashMapWithExpectedSize(((Enum[])paramClass.getEnumConstants()).length));
    this.keyType = paramClass;
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> paramClass)
  {
    return new EnumHashBiMap(paramClass);
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> paramMap)
  {
    EnumHashBiMap localEnumHashBiMap = create(EnumBiMap.inferKeyType(paramMap));
    localEnumHashBiMap.putAll(paramMap);
    return localEnumHashBiMap;
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyType = ((Class)paramObjectInputStream.readObject());
    setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), new HashMap(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
    Serialization.populateMap(this, paramObjectInputStream);
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.keyType);
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  K checkKey(K paramK)
  {
    return (Enum)Preconditions.checkNotNull(paramK);
  }
  
  public V forcePut(K paramK, @Nullable V paramV)
  {
    return (V)super.forcePut(paramK, paramV);
  }
  
  public Class<K> keyType()
  {
    return this.keyType;
  }
  
  public V put(K paramK, @Nullable V paramV)
  {
    return (V)super.put(paramK, paramV);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/EnumHashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */