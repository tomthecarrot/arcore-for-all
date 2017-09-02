package com.google.protobuf;

import java.io.IOException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class MapEntryLite<K, V>
{
  private static final int KEY_FIELD_NUMBER = 1;
  private static final int VALUE_FIELD_NUMBER = 2;
  private final K key;
  private final Metadata<K, V> metadata;
  private final V value;
  
  private MapEntryLite(Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    this.metadata = paramMetadata;
    this.key = paramK;
    this.value = paramV;
  }
  
  private MapEntryLite(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    this.metadata = new Metadata(paramFieldType1, paramK, paramFieldType2, paramV);
    this.key = paramK;
    this.value = paramV;
  }
  
  static <K, V> int computeSerializedSize(Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    return FieldSet.computeElementSize(paramMetadata.keyType, 1, paramK) + FieldSet.computeElementSize(paramMetadata.valueType, 2, paramV);
  }
  
  public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    return new MapEntryLite(paramFieldType1, paramK, paramFieldType2, paramV);
  }
  
  static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream paramCodedInputStream, Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    Object localObject2 = paramMetadata.defaultKey;
    Object localObject1 = paramMetadata.defaultValue;
    int i = paramCodedInputStream.readTag();
    if (i == 0) {}
    for (;;)
    {
      return new AbstractMap.SimpleImmutableEntry(localObject2, localObject1);
      if (i == WireFormat.makeTag(1, paramMetadata.keyType.getWireType()))
      {
        localObject2 = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.keyType, localObject2);
        break;
      }
      if (i == WireFormat.makeTag(2, paramMetadata.valueType.getWireType()))
      {
        localObject1 = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.valueType, localObject1);
        break;
      }
      if (paramCodedInputStream.skipField(i)) {
        break;
      }
    }
  }
  
  static <T> T parseField(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, WireFormat.FieldType paramFieldType, T paramT)
    throws IOException
  {
    switch (paramFieldType)
    {
    default: 
      return (T)FieldSet.readPrimitiveField(paramCodedInputStream, paramFieldType, true);
    case ???: 
      paramFieldType = ((MessageLite)paramT).toBuilder();
      paramCodedInputStream.readMessage(paramFieldType, paramExtensionRegistryLite);
      return paramFieldType.buildPartial();
    case ???: 
      return Integer.valueOf(paramCodedInputStream.readEnum());
    }
    throw new RuntimeException("Groups are not allowed in maps.");
  }
  
  static <K, V> void writeTo(CodedOutputStream paramCodedOutputStream, Metadata<K, V> paramMetadata, K paramK, V paramV)
    throws IOException
  {
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.keyType, 1, paramK);
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.valueType, 2, paramV);
  }
  
  public int computeMessageSize(int paramInt, K paramK, V paramV)
  {
    return CodedOutputStream.computeTagSize(paramInt) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, paramK, paramV));
  }
  
  public K getKey()
  {
    return (K)this.key;
  }
  
  public V getValue()
  {
    return (V)this.value;
  }
  
  public Map.Entry<K, V> parseEntry(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return parseEntry(paramByteString.newCodedInput(), this.metadata, paramExtensionRegistryLite);
  }
  
  public void parseInto(MapFieldLite<K, V> paramMapFieldLite, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
    Object localObject2 = this.metadata.defaultKey;
    Object localObject1 = this.metadata.defaultValue;
    int j = paramCodedInputStream.readTag();
    if (j == 0) {}
    for (;;)
    {
      paramCodedInputStream.checkLastTagWas(0);
      paramCodedInputStream.popLimit(i);
      paramMapFieldLite.put(localObject2, localObject1);
      return;
      if (j == WireFormat.makeTag(1, this.metadata.keyType.getWireType()))
      {
        localObject2 = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.keyType, localObject2);
        break;
      }
      if (j == WireFormat.makeTag(2, this.metadata.valueType.getWireType()))
      {
        localObject1 = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.valueType, localObject1);
        break;
      }
      if (paramCodedInputStream.skipField(j)) {
        break;
      }
    }
  }
  
  public void serializeTo(CodedOutputStream paramCodedOutputStream, int paramInt, K paramK, V paramV)
    throws IOException
  {
    paramCodedOutputStream.writeTag(paramInt, 2);
    paramCodedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, paramK, paramV));
    writeTo(paramCodedOutputStream, this.metadata, paramK, paramV);
  }
  
  static class Metadata<K, V>
  {
    public final K defaultKey;
    public final V defaultValue;
    public final WireFormat.FieldType keyType;
    public final WireFormat.FieldType valueType;
    
    public Metadata(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
    {
      this.keyType = paramFieldType1;
      this.defaultKey = paramK;
      this.valueType = paramFieldType2;
      this.defaultValue = paramV;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/MapEntryLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */