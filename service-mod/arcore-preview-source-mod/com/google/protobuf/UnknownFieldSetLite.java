package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite
{
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  private static final int MIN_CAPACITY = 8;
  private int count;
  private boolean isMutable;
  private int memoizedSerializedSize = -1;
  private Object[] objects;
  private int[] tags;
  
  private UnknownFieldSetLite()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.tags = paramArrayOfInt;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  private void ensureCapacity()
  {
    if (this.count == this.tags.length) {
      if (this.count >= 4) {
        break label55;
      }
    }
    label55:
    for (int i = 8;; i = this.count >> 1)
    {
      i = this.count + i;
      this.tags = Arrays.copyOf(this.tags, i);
      this.objects = Arrays.copyOf(this.objects, i);
      return;
    }
  }
  
  public static UnknownFieldSetLite getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    int i;
    do
    {
      i = paramCodedInputStream.readTag();
    } while ((i != 0) && (mergeFieldFrom(i, paramCodedInputStream)));
    return this;
  }
  
  static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2)
  {
    int i = paramUnknownFieldSetLite1.count + paramUnknownFieldSetLite2.count;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.tags, i);
    System.arraycopy(paramUnknownFieldSetLite2.tags, 0, arrayOfInt, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.objects, i);
    System.arraycopy(paramUnknownFieldSetLite2.objects, 0, arrayOfObject, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  static UnknownFieldSetLite newInstance()
  {
    return new UnknownFieldSetLite();
  }
  
  private void storeField(int paramInt, Object paramObject)
  {
    ensureCapacity();
    this.tags[this.count] = paramInt;
    this.objects[this.count] = paramObject;
    this.count += 1;
  }
  
  void checkMutable()
  {
    if (!this.isMutable) {
      throw new UnsupportedOperationException();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof UnknownFieldSetLite)) {
        return false;
      }
      paramObject = (UnknownFieldSetLite)paramObject;
    } while ((this.count == ((UnknownFieldSetLite)paramObject).count) && (Arrays.equals(this.tags, ((UnknownFieldSetLite)paramObject).tags)) && (Arrays.deepEquals(this.objects, ((UnknownFieldSetLite)paramObject).objects)));
    return false;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    if (j < this.count)
    {
      int k = this.tags[j];
      int m = WireFormat.getTagFieldNumber(k);
      switch (WireFormat.getTagWireType(k))
      {
      case 4: 
      default: 
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
      case 0: 
        i += CodedOutputStream.computeUInt64Size(m, ((Long)this.objects[j]).longValue());
      }
      for (;;)
      {
        j += 1;
        break;
        i += CodedOutputStream.computeFixed32Size(m, ((Integer)this.objects[j]).intValue());
        continue;
        i += CodedOutputStream.computeFixed64Size(m, ((Long)this.objects[j]).longValue());
        continue;
        i += CodedOutputStream.computeBytesSize(m, (ByteString)this.objects[j]);
        continue;
        k = CodedOutputStream.computeTagSize(m);
        i += ((UnknownFieldSetLite)this.objects[j]).getSerializedSize() + k * 2;
      }
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int hashCode()
  {
    return ((this.count + 527) * 31 + Arrays.hashCode(this.tags)) * 31 + Arrays.deepHashCode(this.objects);
  }
  
  public void makeImmutable()
  {
    this.isMutable = false;
  }
  
  boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream)
    throws IOException
  {
    checkMutable();
    int i = WireFormat.getTagFieldNumber(paramInt);
    switch (WireFormat.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.invalidWireType();
    case 0: 
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
      return true;
    case 5: 
      storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
      return true;
    case 1: 
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
      return true;
    case 2: 
      storeField(paramInt, paramCodedInputStream.readBytes());
      return true;
    case 3: 
      UnknownFieldSetLite localUnknownFieldSetLite = new UnknownFieldSetLite();
      localUnknownFieldSetLite.mergeFrom(paramCodedInputStream);
      paramCodedInputStream.checkLastTagWas(WireFormat.makeTag(i, 4));
      storeField(paramInt, localUnknownFieldSetLite);
      return true;
    }
    return false;
  }
  
  UnknownFieldSetLite mergeLengthDelimitedField(int paramInt, ByteString paramByteString)
  {
    checkMutable();
    if (paramInt == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
    return this;
  }
  
  UnknownFieldSetLite mergeVarintField(int paramInt1, int paramInt2)
  {
    checkMutable();
    if (paramInt1 == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    storeField(WireFormat.makeTag(paramInt1, 0), Long.valueOf(paramInt2));
    return this;
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.count)
    {
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i])), this.objects[i]);
      i += 1;
    }
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    if (i < this.count)
    {
      int j = this.tags[i];
      int k = WireFormat.getTagFieldNumber(j);
      switch (WireFormat.getTagWireType(j))
      {
      case 4: 
      default: 
        throw InvalidProtocolBufferException.invalidWireType();
      case 0: 
        paramCodedOutputStream.writeUInt64(k, ((Long)this.objects[i]).longValue());
      }
      for (;;)
      {
        i += 1;
        break;
        paramCodedOutputStream.writeFixed32(k, ((Integer)this.objects[i]).intValue());
        continue;
        paramCodedOutputStream.writeFixed64(k, ((Long)this.objects[i]).longValue());
        continue;
        paramCodedOutputStream.writeBytes(k, (ByteString)this.objects[i]);
        continue;
        paramCodedOutputStream.writeTag(k, 3);
        ((UnknownFieldSetLite)this.objects[i]).writeTo(paramCodedOutputStream);
        paramCodedOutputStream.writeTag(k, 4);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/UnknownFieldSetLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */