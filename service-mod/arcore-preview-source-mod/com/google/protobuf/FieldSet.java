package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>>
{
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  private final SmallSortedMap<FieldDescriptorType, Object> fields;
  private boolean hasLazyField = false;
  private boolean isImmutable;
  
  private FieldSet()
  {
    this.fields = SmallSortedMap.newFieldMap(16);
  }
  
  private FieldSet(boolean paramBoolean)
  {
    this.fields = SmallSortedMap.newFieldMap(0);
    makeImmutable();
  }
  
  private void cloneFieldEntry(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof LazyField))
    {
      paramMap.put(localFieldDescriptorLite, ((LazyField)paramEntry).getValue());
      return;
    }
    paramMap.put(localFieldDescriptorLite, paramEntry);
  }
  
  private Object cloneIfMutable(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  static int computeElementSize(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    int i = CodedOutputStream.computeTagSize(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramInt = i * 2;
    }
    return computeElementSizeNoTag(paramFieldType, paramObject) + paramInt;
  }
  
  static int computeElementSizeNoTag(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (paramFieldType)
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case ???: 
      return CodedOutputStream.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
    case ???: 
      return CodedOutputStream.computeFloatSizeNoTag(((Float)paramObject).floatValue());
    case ???: 
      return CodedOutputStream.computeInt64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeUInt64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeFixed64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramObject).booleanValue());
    case ???: 
      return CodedOutputStream.computeGroupSizeNoTag((MessageLite)paramObject);
    case ???: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
      }
      return CodedOutputStream.computeByteArraySizeNoTag((byte[])paramObject);
    case ???: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
      }
      return CodedOutputStream.computeStringSizeNoTag((String)paramObject);
    case ???: 
      return CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      return CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramObject).intValue());
    case ???: 
      return CodedOutputStream.computeSInt64SizeNoTag(((Long)paramObject).longValue());
    case ???: 
      if ((paramObject instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)paramObject);
      }
      return CodedOutputStream.computeMessageSizeNoTag((MessageLite)paramObject);
    }
    if ((paramObject instanceof Internal.EnumLite)) {
      return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)paramObject).getNumber());
    }
    return CodedOutputStream.computeEnumSizeNoTag(((Integer)paramObject).intValue());
  }
  
  public static int computeFieldSize(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int k = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      int j;
      if (paramFieldDescriptorLite.isPacked())
      {
        i = 0;
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        j = CodedOutputStream.computeTagSize(k) + i + CodedOutputStream.computeRawVarint32Size(i);
        return j;
      }
      int i = 0;
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      for (;;)
      {
        j = i;
        if (!paramFieldDescriptorLite.hasNext()) {
          break;
        }
        i += computeElementSize(localFieldType, k, paramFieldDescriptorLite.next());
      }
    }
    return computeElementSize(localFieldType, k, paramObject);
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet()
  {
    return DEFAULT_INSTANCE;
  }
  
  private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.isRepeated()) && (!localFieldDescriptorLite.isPacked()))
    {
      if ((localObject instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (LazyField)localObject);
      }
      return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (MessageLite)localObject);
    }
    return computeFieldSize(localFieldDescriptorLite, localObject);
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.getWireType();
  }
  
  private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      if (localFieldDescriptorLite.isRepeated())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((MessageLite)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof MessageLite))
      {
        if (!((MessageLite)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof LazyField)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private void mergeFromField(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldDescriptorLite localFieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof LazyField)) {
      paramEntry = ((LazyField)localObject1).getValue();
    }
    if (localFieldDescriptorLite.isRepeated())
    {
      Object localObject2 = getField(localFieldDescriptorLite);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(cloneIfMutable(localObject2));
      }
      this.fields.put(localFieldDescriptorLite, localObject1);
      return;
    }
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      localObject1 = getField(localFieldDescriptorLite);
      if (localObject1 == null)
      {
        this.fields.put(localFieldDescriptorLite, cloneIfMutable(paramEntry));
        return;
      }
      paramEntry = localFieldDescriptorLite.internalMergeFrom(((MessageLite)localObject1).toBuilder(), (MessageLite)paramEntry).build();
      this.fields.put(localFieldDescriptorLite, paramEntry);
      return;
    }
    this.fields.put(localFieldDescriptorLite, cloneIfMutable(paramEntry));
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet()
  {
    return new FieldSet();
  }
  
  public static Object readPrimitiveField(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      return WireFormat.readPrimitiveField(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.STRICT);
    }
    return WireFormat.readPrimitiveField(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.LOOSE);
  }
  
  private static void verifyType(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    boolean bool = false;
    switch (1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramFieldType.getJavaType().ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof ByteString)) || ((paramObject instanceof byte[]))) {}
      for (bool = true;; bool = false) {
        break;
      }
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Internal.EnumLite))) {}
      for (bool = true;; bool = false) {
        break;
      }
      if (((paramObject instanceof MessageLite)) || ((paramObject instanceof LazyField))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
  }
  
  static void writeElement(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramFieldType == WireFormat.FieldType.GROUP)
    {
      paramCodedOutputStream.writeGroup(paramInt, (MessageLite)paramObject);
      return;
    }
    paramCodedOutputStream.writeTag(paramInt, getWireFormatForFieldType(paramFieldType, false));
    writeElementNoTag(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  static void writeElementNoTag(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
    throws IOException
  {
    switch (paramFieldType)
    {
    default: 
      return;
    case ???: 
      paramCodedOutputStream.writeDoubleNoTag(((Double)paramObject).doubleValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFloatNoTag(((Float)paramObject).floatValue());
      return;
    case ???: 
      paramCodedOutputStream.writeInt64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeUInt64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFixed64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeBoolNoTag(((Boolean)paramObject).booleanValue());
      return;
    case ???: 
      paramCodedOutputStream.writeGroupNoTag((MessageLite)paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeMessageNoTag((MessageLite)paramObject);
      return;
    case ???: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.writeStringNoTag((String)paramObject);
      return;
    case ???: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.writeByteArrayNoTag((byte[])paramObject);
      return;
    case ???: 
      paramCodedOutputStream.writeUInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSFixed64NoTag(((Long)paramObject).longValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSInt32NoTag(((Integer)paramObject).intValue());
      return;
    case ???: 
      paramCodedOutputStream.writeSInt64NoTag(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Internal.EnumLite))
    {
      paramCodedOutputStream.writeEnumNoTag(((Internal.EnumLite)paramObject).getNumber());
      return;
    }
    paramCodedOutputStream.writeEnumNoTag(((Integer)paramObject).intValue());
  }
  
  public static void writeField(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      paramObject = (List)paramObject;
      if (paramFieldDescriptorLite.isPacked())
      {
        paramCodedOutputStream.writeTag(i, 2);
        i = 0;
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        paramCodedOutputStream.writeRawVarint32(i);
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          writeElementNoTag(paramCodedOutputStream, localFieldType, paramFieldDescriptorLite.next());
        }
      }
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      while (paramFieldDescriptorLite.hasNext()) {
        writeElement(paramCodedOutputStream, localFieldType, i, paramFieldDescriptorLite.next());
      }
    }
    if ((paramObject instanceof LazyField))
    {
      writeElement(paramCodedOutputStream, localFieldType, i, ((LazyField)paramObject).getValue());
      return;
    }
    writeElement(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> paramEntry, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    Object localObject1 = (FieldDescriptorLite)paramEntry.getKey();
    if ((((FieldDescriptorLite)localObject1).getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!((FieldDescriptorLite)localObject1).isRepeated()) && (!((FieldDescriptorLite)localObject1).isPacked()))
    {
      Object localObject2 = paramEntry.getValue();
      localObject1 = localObject2;
      if ((localObject2 instanceof LazyField)) {
        localObject1 = ((LazyField)localObject2).getValue();
      }
      paramCodedOutputStream.writeMessageSetExtension(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (MessageLite)localObject1);
      return;
    }
    writeField((FieldDescriptorLite)localObject1, paramEntry.getValue(), paramCodedOutputStream);
  }
  
  public void addRepeatedField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    Object localObject = getField(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.fields.put(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (FieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public void clear()
  {
    this.fields.clear();
    this.hasLazyField = false;
  }
  
  public void clearField(FieldDescriptorType paramFieldDescriptorType)
  {
    this.fields.remove(paramFieldDescriptorType);
    if (this.fields.isEmpty()) {
      this.hasLazyField = false;
    }
  }
  
  public FieldSet<FieldDescriptorType> clone()
  {
    FieldSet localFieldSet = newFieldSet();
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(i);
      localFieldSet.setField((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localFieldSet.setField((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    localFieldSet.hasLazyField = this.hasLazyField;
    return localFieldSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FieldSet)) {
      return false;
    }
    paramObject = (FieldSet)paramObject;
    return this.fields.equals(((FieldSet)paramObject).fields);
  }
  
  public Map<FieldDescriptorType, Object> getAllFields()
  {
    if (this.hasLazyField)
    {
      localObject = SmallSortedMap.newFieldMap(16);
      int i = 0;
      while (i < this.fields.getNumArrayEntries())
      {
        cloneFieldEntry((Map)localObject, this.fields.getArrayEntryAt(i));
        i += 1;
      }
      Iterator localIterator = this.fields.getOverflowEntries().iterator();
      while (localIterator.hasNext()) {
        cloneFieldEntry((Map)localObject, (Map.Entry)localIterator.next());
      }
      if (this.fields.isImmutable()) {
        ((SmallSortedMap)localObject).makeImmutable();
      }
      return (Map<FieldDescriptorType, Object>)localObject;
    }
    if (this.fields.isImmutable()) {}
    for (Object localObject = this.fields;; localObject = Collections.unmodifiableMap(this.fields)) {
      return (Map<FieldDescriptorType, Object>)localObject;
    }
  }
  
  public Object getField(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.fields.get(paramFieldDescriptorType);
    paramFieldDescriptorType = (FieldDescriptorType)localObject;
    if ((localObject instanceof LazyField)) {
      paramFieldDescriptorType = ((LazyField)localObject).getValue();
    }
    return paramFieldDescriptorType;
  }
  
  public int getMessageSetSerializedSize()
  {
    int i = 0;
    int j = 0;
    while (j < this.fields.getNumArrayEntries())
    {
      i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(j));
      j += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      i += getMessageSetSerializedSize((Map.Entry)localIterator.next());
    }
    return i;
  }
  
  public Object getRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = getField(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      throw new IndexOutOfBoundsException();
    }
    return ((List)paramFieldDescriptorType).get(paramInt);
  }
  
  public int getRepeatedFieldCount(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = getField(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      return 0;
    }
    return ((List)paramFieldDescriptorType).size();
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    int j = 0;
    while (j < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(j);
      i += computeFieldSize((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += computeFieldSize((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public boolean hasField(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return this.fields.get(paramFieldDescriptorType) != null;
  }
  
  public int hashCode()
  {
    return this.fields.hashCode();
  }
  
  public boolean isImmutable()
  {
    return this.isImmutable;
  }
  
  public boolean isInitialized()
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      if (!isInitialized(this.fields.getArrayEntryAt(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      if (!isInitialized((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.hasLazyField) {
      return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    }
    return this.fields.entrySet().iterator();
  }
  
  public void makeImmutable()
  {
    if (this.isImmutable) {
      return;
    }
    this.fields.makeImmutable();
    this.isImmutable = true;
  }
  
  public void mergeFrom(FieldSet<FieldDescriptorType> paramFieldSet)
  {
    int i = 0;
    while (i < paramFieldSet.fields.getNumArrayEntries())
    {
      mergeFromField(paramFieldSet.fields.getArrayEntryAt(i));
      i += 1;
    }
    paramFieldSet = paramFieldSet.fields.getOverflowEntries().iterator();
    while (paramFieldSet.hasNext()) {
      mergeFromField((Map.Entry)paramFieldSet.next());
    }
  }
  
  public void setField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        verifyType(paramFieldDescriptorType.getLiteType(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof LazyField)) {
        this.hasLazyField = true;
      }
      this.fields.put(paramFieldDescriptorType, paramObject);
      return;
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    }
  }
  
  public void setRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt, Object paramObject)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    Object localObject = getField(paramFieldDescriptorType);
    if (localObject == null) {
      throw new IndexOutOfBoundsException();
    }
    verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    ((List)localObject).set(paramInt, paramObject);
  }
  
  public void writeMessageSetTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      writeMessageSetTo(this.fields.getArrayEntryAt(i), paramCodedOutputStream);
      i += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      writeMessageSetTo((Map.Entry)localIterator.next(), paramCodedOutputStream);
    }
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(i);
      writeField((FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue(), paramCodedOutputStream);
      i += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      writeField((FieldDescriptorLite)localEntry.getKey(), localEntry.getValue(), paramCodedOutputStream);
    }
  }
  
  public static abstract interface FieldDescriptorLite<T extends FieldDescriptorLite<T>>
    extends Comparable<T>
  {
    public abstract Internal.EnumLiteMap<?> getEnumType();
    
    public abstract WireFormat.JavaType getLiteJavaType();
    
    public abstract WireFormat.FieldType getLiteType();
    
    public abstract int getNumber();
    
    public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
    
    public abstract boolean isPacked();
    
    public abstract boolean isRepeated();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FieldSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */