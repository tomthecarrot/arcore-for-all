package com.google.protobuf;

import java.io.IOException;

public class LazyFieldLite
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  private ByteString delayedBytes;
  private ExtensionRegistryLite extensionRegistry;
  private volatile ByteString memoizedBytes;
  protected volatile MessageLite value;
  
  public LazyFieldLite() {}
  
  public LazyFieldLite(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.extensionRegistry = paramExtensionRegistryLite;
    this.delayedBytes = paramByteString;
  }
  
  private static void checkArguments(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    if (paramExtensionRegistryLite == null) {
      throw new NullPointerException("found null ExtensionRegistry");
    }
    if (paramByteString == null) {
      throw new NullPointerException("found null ByteString");
    }
  }
  
  public static LazyFieldLite fromValue(MessageLite paramMessageLite)
  {
    LazyFieldLite localLazyFieldLite = new LazyFieldLite();
    localLazyFieldLite.setValue(paramMessageLite);
    return localLazyFieldLite;
  }
  
  private static MessageLite mergeValueAndBytes(MessageLite paramMessageLite, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramByteString = paramMessageLite.toBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite).build();
      return paramByteString;
    }
    catch (InvalidProtocolBufferException paramByteString) {}
    return paramMessageLite;
  }
  
  public void clear()
  {
    this.delayedBytes = null;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public boolean containsDefaultInstance()
  {
    return (this.memoizedBytes == ByteString.EMPTY) || ((this.value == null) && ((this.delayedBytes == null) || (this.delayedBytes == ByteString.EMPTY)));
  }
  
  protected void ensureInitialized(MessageLite paramMessageLite)
  {
    if (this.value != null) {
      return;
    }
    try
    {
      if (this.value != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.delayedBytes != null) {
        this.value = ((MessageLite)paramMessageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry));
      }
      for (this.memoizedBytes = this.delayedBytes;; this.memoizedBytes = ByteString.EMPTY)
      {
        return;
        this.value = paramMessageLite;
      }
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      for (;;)
      {
        this.value = paramMessageLite;
        this.memoizedBytes = ByteString.EMPTY;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LazyFieldLite)) {
      return false;
    }
    paramObject = (LazyFieldLite)paramObject;
    MessageLite localMessageLite1 = this.value;
    MessageLite localMessageLite2 = ((LazyFieldLite)paramObject).value;
    if ((localMessageLite1 == null) && (localMessageLite2 == null)) {
      return toByteString().equals(((LazyFieldLite)paramObject).toByteString());
    }
    if ((localMessageLite1 != null) && (localMessageLite2 != null)) {
      return localMessageLite1.equals(localMessageLite2);
    }
    if (localMessageLite1 != null) {
      return localMessageLite1.equals(((LazyFieldLite)paramObject).getValue(localMessageLite1.getDefaultInstanceForType()));
    }
    return getValue(localMessageLite2.getDefaultInstanceForType()).equals(localMessageLite2);
  }
  
  public int getSerializedSize()
  {
    if (this.memoizedBytes != null) {
      return this.memoizedBytes.size();
    }
    if (this.delayedBytes != null) {
      return this.delayedBytes.size();
    }
    if (this.value != null) {
      return this.value.getSerializedSize();
    }
    return 0;
  }
  
  public MessageLite getValue(MessageLite paramMessageLite)
  {
    ensureInitialized(paramMessageLite);
    return this.value;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public void merge(LazyFieldLite paramLazyFieldLite)
  {
    if (paramLazyFieldLite.containsDefaultInstance()) {
      return;
    }
    if (containsDefaultInstance())
    {
      set(paramLazyFieldLite);
      return;
    }
    if (this.extensionRegistry == null) {
      this.extensionRegistry = paramLazyFieldLite.extensionRegistry;
    }
    if ((this.delayedBytes != null) && (paramLazyFieldLite.delayedBytes != null))
    {
      this.delayedBytes = this.delayedBytes.concat(paramLazyFieldLite.delayedBytes);
      return;
    }
    if ((this.value == null) && (paramLazyFieldLite.value != null))
    {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
      return;
    }
    if ((this.value != null) && (paramLazyFieldLite.value == null))
    {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.delayedBytes, paramLazyFieldLite.extensionRegistry));
      return;
    }
    if (paramLazyFieldLite.extensionRegistry != null)
    {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), paramLazyFieldLite.extensionRegistry));
      return;
    }
    if (this.extensionRegistry != null)
    {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, toByteString(), this.extensionRegistry));
      return;
    }
    setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), EMPTY_REGISTRY));
  }
  
  public void mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (containsDefaultInstance())
    {
      setByteString(paramCodedInputStream.readBytes(), paramExtensionRegistryLite);
      return;
    }
    if (this.extensionRegistry == null) {
      this.extensionRegistry = paramExtensionRegistryLite;
    }
    if (this.delayedBytes != null)
    {
      setByteString(this.delayedBytes.concat(paramCodedInputStream.readBytes()), this.extensionRegistry);
      return;
    }
    try
    {
      setValue(this.value.toBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).build());
      return;
    }
    catch (InvalidProtocolBufferException paramCodedInputStream) {}
  }
  
  public void set(LazyFieldLite paramLazyFieldLite)
  {
    this.delayedBytes = paramLazyFieldLite.delayedBytes;
    this.value = paramLazyFieldLite.value;
    this.memoizedBytes = paramLazyFieldLite.memoizedBytes;
    if (paramLazyFieldLite.extensionRegistry != null) {
      this.extensionRegistry = paramLazyFieldLite.extensionRegistry;
    }
  }
  
  public void setByteString(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.delayedBytes = paramByteString;
    this.extensionRegistry = paramExtensionRegistryLite;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public MessageLite setValue(MessageLite paramMessageLite)
  {
    MessageLite localMessageLite = this.value;
    this.delayedBytes = null;
    this.memoizedBytes = null;
    this.value = paramMessageLite;
    return localMessageLite;
  }
  
  public ByteString toByteString()
  {
    if (this.memoizedBytes != null) {
      return this.memoizedBytes;
    }
    if (this.delayedBytes != null) {
      return this.delayedBytes;
    }
    try
    {
      if (this.memoizedBytes != null)
      {
        ByteString localByteString1 = this.memoizedBytes;
        return localByteString1;
      }
    }
    finally {}
    if (this.value == null) {}
    for (this.memoizedBytes = ByteString.EMPTY;; this.memoizedBytes = this.value.toByteString())
    {
      ByteString localByteString2 = this.memoizedBytes;
      return localByteString2;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/LazyFieldLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */