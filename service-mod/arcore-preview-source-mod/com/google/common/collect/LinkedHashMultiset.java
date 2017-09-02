package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

@GwtCompatible(emulated=true, serializable=true)
public final class LinkedHashMultiset<E>
  extends AbstractMapBasedMultiset<E>
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  private LinkedHashMultiset()
  {
    super(new LinkedHashMap());
  }
  
  private LinkedHashMultiset(int paramInt)
  {
    super(Maps.newLinkedHashMapWithExpectedSize(paramInt));
  }
  
  public static <E> LinkedHashMultiset<E> create()
  {
    return new LinkedHashMultiset();
  }
  
  public static <E> LinkedHashMultiset<E> create(int paramInt)
  {
    return new LinkedHashMultiset(paramInt);
  }
  
  public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    LinkedHashMultiset localLinkedHashMultiset = create(Multisets.inferDistinctElements(paramIterable));
    Iterables.addAll(localLinkedHashMultiset, paramIterable);
    return localLinkedHashMultiset;
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = Serialization.readCount(paramObjectInputStream);
    setBackingMap(new LinkedHashMap());
    Serialization.populateMultiset(this, paramObjectInputStream, i);
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/LinkedHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */