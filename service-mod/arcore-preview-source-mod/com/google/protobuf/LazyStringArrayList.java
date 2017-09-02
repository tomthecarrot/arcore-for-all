package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractProtobufList<String>
  implements LazyStringList, RandomAccess
{
  public static final LazyStringList EMPTY = EMPTY_LIST;
  private static final LazyStringArrayList EMPTY_LIST = new LazyStringArrayList();
  private final List<Object> list;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  public LazyStringArrayList()
  {
    this(10);
  }
  
  public LazyStringArrayList(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList)
  {
    this.list = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  private LazyStringArrayList(ArrayList<Object> paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  public LazyStringArrayList(List<String> paramList)
  {
    this(new ArrayList(paramList));
  }
  
  private void add(int paramInt, ByteString paramByteString)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramByteString);
    this.modCount += 1;
  }
  
  private void add(int paramInt, byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramArrayOfByte);
    this.modCount += 1;
  }
  
  private static byte[] asByteArray(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return Internal.toByteArray((String)paramObject);
    }
    return ((ByteString)paramObject).toByteArray();
  }
  
  private static ByteString asByteString(Object paramObject)
  {
    if ((paramObject instanceof ByteString)) {
      return (ByteString)paramObject;
    }
    if ((paramObject instanceof String)) {
      return ByteString.copyFromUtf8((String)paramObject);
    }
    return ByteString.copyFrom((byte[])paramObject);
  }
  
  private static String asString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof ByteString)) {
      return ((ByteString)paramObject).toStringUtf8();
    }
    return Internal.toStringUtf8((byte[])paramObject);
  }
  
  static LazyStringArrayList emptyList()
  {
    return EMPTY_LIST;
  }
  
  private Object setAndReturn(int paramInt, ByteString paramByteString)
  {
    ensureIsMutable();
    return this.list.set(paramInt, paramByteString);
  }
  
  private Object setAndReturn(int paramInt, byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    return this.list.set(paramInt, paramArrayOfByte);
  }
  
  public void add(int paramInt, String paramString)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public void add(ByteString paramByteString)
  {
    ensureIsMutable();
    this.list.add(paramByteString);
    this.modCount += 1;
  }
  
  public void add(byte[] paramArrayOfByte)
  {
    ensureIsMutable();
    this.list.add(paramArrayOfByte);
    this.modCount += 1;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    ensureIsMutable();
    if ((paramCollection instanceof LazyStringList)) {
      paramCollection = ((LazyStringList)paramCollection).getUnderlyingElements();
    }
    for (;;)
    {
      boolean bool = this.list.addAll(paramInt, paramCollection);
      this.modCount += 1;
      return bool;
    }
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public boolean addAllByteArray(Collection<byte[]> paramCollection)
  {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAllByteString(Collection<? extends ByteString> paramCollection)
  {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount += 1;
    return bool;
  }
  
  public List<byte[]> asByteArrayList()
  {
    return new ByteArrayListView(this);
  }
  
  public List<ByteString> asByteStringList()
  {
    return new ByteStringListView(this);
  }
  
  public void clear()
  {
    ensureIsMutable();
    this.list.clear();
    this.modCount += 1;
  }
  
  public String get(int paramInt)
  {
    Object localObject1 = this.list.get(paramInt);
    if ((localObject1 instanceof String)) {
      localObject1 = (String)localObject1;
    }
    Object localObject2;
    String str;
    do
    {
      do
      {
        return (String)localObject1;
        if (!(localObject1 instanceof ByteString)) {
          break;
        }
        localObject2 = (ByteString)localObject1;
        str = ((ByteString)localObject2).toStringUtf8();
        localObject1 = str;
      } while (!((ByteString)localObject2).isValidUtf8());
      this.list.set(paramInt, str);
      return str;
      localObject2 = (byte[])localObject1;
      str = Internal.toStringUtf8((byte[])localObject2);
      localObject1 = str;
    } while (!Internal.isValidUtf8((byte[])localObject2));
    this.list.set(paramInt, str);
    return str;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    byte[] arrayOfByte = asByteArray(localObject);
    if (arrayOfByte != localObject) {
      this.list.set(paramInt, arrayOfByte);
    }
    return arrayOfByte;
  }
  
  public ByteString getByteString(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    ByteString localByteString = asByteString(localObject);
    if (localByteString != localObject) {
      this.list.set(paramInt, localByteString);
    }
    return localByteString;
  }
  
  public Object getRaw(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public List<?> getUnderlyingElements()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public LazyStringList getUnmodifiableView()
  {
    Object localObject = this;
    if (isModifiable()) {
      localObject = new UnmodifiableLazyStringList(this);
    }
    return (LazyStringList)localObject;
  }
  
  public void mergeFrom(LazyStringList paramLazyStringList)
  {
    ensureIsMutable();
    paramLazyStringList = paramLazyStringList.getUnderlyingElements().iterator();
    while (paramLazyStringList.hasNext())
    {
      Object localObject = paramLazyStringList.next();
      if ((localObject instanceof byte[]))
      {
        localObject = (byte[])localObject;
        this.list.add(Arrays.copyOf((byte[])localObject, localObject.length));
      }
      else
      {
        this.list.add(localObject);
      }
    }
  }
  
  public LazyStringArrayList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < size()) {
      throw new IllegalArgumentException();
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    localArrayList.addAll(this.list);
    return new LazyStringArrayList(localArrayList);
  }
  
  public String remove(int paramInt)
  {
    ensureIsMutable();
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return asString(localObject);
  }
  
  public String set(int paramInt, String paramString)
  {
    ensureIsMutable();
    return asString(this.list.set(paramInt, paramString));
  }
  
  public void set(int paramInt, ByteString paramByteString)
  {
    setAndReturn(paramInt, paramByteString);
  }
  
  public void set(int paramInt, byte[] paramArrayOfByte)
  {
    setAndReturn(paramInt, paramArrayOfByte);
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  private static class ByteArrayListView
    extends AbstractList<byte[]>
    implements RandomAccess
  {
    private final LazyStringArrayList list;
    
    ByteArrayListView(LazyStringArrayList paramLazyStringArrayList)
    {
      this.list = paramLazyStringArrayList;
    }
    
    public void add(int paramInt, byte[] paramArrayOfByte)
    {
      this.list.add(paramInt, paramArrayOfByte);
      this.modCount += 1;
    }
    
    public byte[] get(int paramInt)
    {
      return this.list.getByteArray(paramInt);
    }
    
    public byte[] remove(int paramInt)
    {
      String str = this.list.remove(paramInt);
      this.modCount += 1;
      return LazyStringArrayList.asByteArray(str);
    }
    
    public byte[] set(int paramInt, byte[] paramArrayOfByte)
    {
      paramArrayOfByte = this.list.setAndReturn(paramInt, paramArrayOfByte);
      this.modCount += 1;
      return LazyStringArrayList.asByteArray(paramArrayOfByte);
    }
    
    public int size()
    {
      return this.list.size();
    }
  }
  
  private static class ByteStringListView
    extends AbstractList<ByteString>
    implements RandomAccess
  {
    private final LazyStringArrayList list;
    
    ByteStringListView(LazyStringArrayList paramLazyStringArrayList)
    {
      this.list = paramLazyStringArrayList;
    }
    
    public void add(int paramInt, ByteString paramByteString)
    {
      this.list.add(paramInt, paramByteString);
      this.modCount += 1;
    }
    
    public ByteString get(int paramInt)
    {
      return this.list.getByteString(paramInt);
    }
    
    public ByteString remove(int paramInt)
    {
      String str = this.list.remove(paramInt);
      this.modCount += 1;
      return LazyStringArrayList.asByteString(str);
    }
    
    public ByteString set(int paramInt, ByteString paramByteString)
    {
      paramByteString = this.list.setAndReturn(paramInt, paramByteString);
      this.modCount += 1;
      return LazyStringArrayList.asByteString(paramByteString);
    }
    
    public int size()
    {
      return this.list.size();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/LazyStringArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */