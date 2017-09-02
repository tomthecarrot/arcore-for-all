package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream
  extends ByteOutput
{
  private static final long ARRAY_BASE_OFFSET = UnsafeUtil.getArrayBaseOffset();
  public static final int DEFAULT_BUFFER_SIZE = 4096;
  private static final int FIXED_32_SIZE = 4;
  private static final int FIXED_64_SIZE = 8;
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  @Deprecated
  public static final int LITTLE_ENDIAN_32_SIZE = 4;
  private static final int MAX_VARINT_SIZE = 10;
  private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
  
  static
  {
    HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
  }
  
  public static int computeBoolSize(int paramInt, boolean paramBoolean)
  {
    return computeTagSize(paramInt) + computeBoolSizeNoTag(paramBoolean);
  }
  
  public static int computeBoolSizeNoTag(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int computeByteArraySize(int paramInt, byte[] paramArrayOfByte)
  {
    return computeTagSize(paramInt) + computeByteArraySizeNoTag(paramArrayOfByte);
  }
  
  public static int computeByteArraySizeNoTag(byte[] paramArrayOfByte)
  {
    return computeLengthDelimitedFieldSize(paramArrayOfByte.length);
  }
  
  public static int computeByteBufferSize(int paramInt, ByteBuffer paramByteBuffer)
  {
    return computeTagSize(paramInt) + computeByteBufferSizeNoTag(paramByteBuffer);
  }
  
  public static int computeByteBufferSizeNoTag(ByteBuffer paramByteBuffer)
  {
    return computeLengthDelimitedFieldSize(paramByteBuffer.capacity());
  }
  
  public static int computeBytesSize(int paramInt, ByteString paramByteString)
  {
    return computeTagSize(paramInt) + computeBytesSizeNoTag(paramByteString);
  }
  
  public static int computeBytesSizeNoTag(ByteString paramByteString)
  {
    return computeLengthDelimitedFieldSize(paramByteString.size());
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return computeTagSize(paramInt) + computeDoubleSizeNoTag(paramDouble);
  }
  
  public static int computeDoubleSizeNoTag(double paramDouble)
  {
    return 8;
  }
  
  public static int computeEnumSize(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeEnumSizeNoTag(paramInt2);
  }
  
  public static int computeEnumSizeNoTag(int paramInt)
  {
    return computeInt32SizeNoTag(paramInt);
  }
  
  public static int computeFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeFixed64SizeNoTag(paramLong);
  }
  
  public static int computeFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return computeTagSize(paramInt) + computeFloatSizeNoTag(paramFloat);
  }
  
  public static int computeFloatSizeNoTag(float paramFloat)
  {
    return 4;
  }
  
  @Deprecated
  public static int computeGroupSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(paramInt) * 2 + computeGroupSizeNoTag(paramMessageLite);
  }
  
  @Deprecated
  public static int computeGroupSizeNoTag(MessageLite paramMessageLite)
  {
    return paramMessageLite.getSerializedSize();
  }
  
  public static int computeInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeInt32SizeNoTag(paramInt2);
  }
  
  public static int computeInt32SizeNoTag(int paramInt)
  {
    if (paramInt >= 0) {
      return computeUInt32SizeNoTag(paramInt);
    }
    return 10;
  }
  
  public static int computeInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeInt64SizeNoTag(paramLong);
  }
  
  public static int computeInt64SizeNoTag(long paramLong)
  {
    return computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeLazyFieldMessageSetExtensionSize(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeLazyFieldSize(3, paramLazyFieldLite);
  }
  
  public static int computeLazyFieldSize(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return computeTagSize(paramInt) + computeLazyFieldSizeNoTag(paramLazyFieldLite);
  }
  
  public static int computeLazyFieldSizeNoTag(LazyFieldLite paramLazyFieldLite)
  {
    return computeLengthDelimitedFieldSize(paramLazyFieldLite.getSerializedSize());
  }
  
  static int computeLengthDelimitedFieldSize(int paramInt)
  {
    return computeUInt32SizeNoTag(paramInt) + paramInt;
  }
  
  public static int computeMessageSetExtensionSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeMessageSize(3, paramMessageLite);
  }
  
  public static int computeMessageSize(int paramInt, MessageLite paramMessageLite)
  {
    return computeTagSize(paramInt) + computeMessageSizeNoTag(paramMessageLite);
  }
  
  public static int computeMessageSizeNoTag(MessageLite paramMessageLite)
  {
    return computeLengthDelimitedFieldSize(paramMessageLite.getSerializedSize());
  }
  
  static int computePreferredBufferSize(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 4096) {
      i = 4096;
    }
    return i;
  }
  
  public static int computeRawMessageSetExtensionSize(int paramInt, ByteString paramByteString)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, paramInt) + computeBytesSize(3, paramByteString);
  }
  
  @Deprecated
  public static int computeRawVarint32Size(int paramInt)
  {
    return computeUInt32SizeNoTag(paramInt);
  }
  
  @Deprecated
  public static int computeRawVarint64Size(long paramLong)
  {
    return computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSFixed32SizeNoTag(paramInt2);
  }
  
  public static int computeSFixed32SizeNoTag(int paramInt)
  {
    return 4;
  }
  
  public static int computeSFixed64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSFixed64SizeNoTag(paramLong);
  }
  
  public static int computeSFixed64SizeNoTag(long paramLong)
  {
    return 8;
  }
  
  public static int computeSInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeSInt32SizeNoTag(paramInt2);
  }
  
  public static int computeSInt32SizeNoTag(int paramInt)
  {
    return computeUInt32SizeNoTag(encodeZigZag32(paramInt));
  }
  
  public static int computeSInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeSInt64SizeNoTag(paramLong);
  }
  
  public static int computeSInt64SizeNoTag(long paramLong)
  {
    return computeUInt64SizeNoTag(encodeZigZag64(paramLong));
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
  }
  
  public static int computeStringSizeNoTag(String paramString)
  {
    try
    {
      i = Utf8.encodedLength(paramString);
      return computeLengthDelimitedFieldSize(i);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      for (;;)
      {
        int i = paramString.getBytes(Internal.UTF_8).length;
      }
    }
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeUInt32SizeNoTag(WireFormat.makeTag(paramInt, 0));
  }
  
  public static int computeUInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeUInt32SizeNoTag(paramInt2);
  }
  
  public static int computeUInt32SizeNoTag(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong)
  {
    return computeTagSize(paramInt) + computeUInt64SizeNoTag(paramLong);
  }
  
  public static int computeUInt64SizeNoTag(long paramLong)
  {
    int j;
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      j = 1;
    }
    int i;
    do
    {
      return j;
      if (paramLong < 0L) {
        return 10;
      }
      j = 2;
      long l = paramLong;
      if ((0xFFFFFFF800000000 & paramLong) != 0L)
      {
        j = 2 + 4;
        l = paramLong >>> 28;
      }
      i = j;
      paramLong = l;
      if ((0xFFFFFFFFFFE00000 & l) != 0L)
      {
        i = j + 2;
        paramLong = l >>> 14;
      }
      j = i;
    } while ((0xFFFFFFFFFFFFC000 & paramLong) == 0L);
    return i + 1;
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  static CodedOutputStream newInstance(ByteOutput paramByteOutput, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("bufferSize must be positive");
    }
    return new ByteOutputEncoder(paramByteOutput, paramInt);
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream)
  {
    return newInstance(paramOutputStream, 4096);
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream, int paramInt)
  {
    return new OutputStreamEncoder(paramOutputStream, paramInt);
  }
  
  public static CodedOutputStream newInstance(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return new NioHeapEncoder(paramByteBuffer);
    }
    return new NioEncoder(paramByteBuffer);
  }
  
  @Deprecated
  public static CodedOutputStream newInstance(ByteBuffer paramByteBuffer, int paramInt)
  {
    return newInstance(paramByteBuffer);
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedOutputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ArrayEncoder(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void checkNoSpaceLeft()
  {
    if (spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public abstract void flush()
    throws IOException;
  
  public abstract int getTotalBytesWritten();
  
  final void inefficientWriteStringNoTag(String paramString, Utf8.UnpairedSurrogateException paramUnpairedSurrogateException)
    throws IOException
  {
    logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramUnpairedSurrogateException);
    paramString = paramString.getBytes(Internal.UTF_8);
    try
    {
      writeUInt32NoTag(paramString.length);
      writeLazy(paramString, 0, paramString.length);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new OutOfSpaceException(paramString);
    }
    catch (OutOfSpaceException paramString)
    {
      throw paramString;
    }
  }
  
  public abstract int spaceLeft();
  
  public abstract void write(byte paramByte)
    throws IOException;
  
  public abstract void write(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeBool(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public final void writeBoolNoTag(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      write((byte)i);
      return;
    }
  }
  
  public abstract void writeByteArray(int paramInt, byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException;
  
  public final void writeByteArrayNoTag(byte[] paramArrayOfByte)
    throws IOException
  {
    writeByteArrayNoTag(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  abstract void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void writeBytes(int paramInt, ByteString paramByteString)
    throws IOException;
  
  public abstract void writeBytesNoTag(ByteString paramByteString)
    throws IOException;
  
  public final void writeDouble(int paramInt, double paramDouble)
    throws IOException
  {
    writeFixed64(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void writeDoubleNoTag(double paramDouble)
    throws IOException
  {
    writeFixed64NoTag(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void writeEnum(int paramInt1, int paramInt2)
    throws IOException
  {
    writeInt32(paramInt1, paramInt2);
  }
  
  public final void writeEnumNoTag(int paramInt)
    throws IOException
  {
    writeInt32NoTag(paramInt);
  }
  
  public abstract void writeFixed32(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeFixed32NoTag(int paramInt)
    throws IOException;
  
  public abstract void writeFixed64(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void writeFixed64NoTag(long paramLong)
    throws IOException;
  
  public final void writeFloat(int paramInt, float paramFloat)
    throws IOException
  {
    writeFixed32(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void writeFloatNoTag(float paramFloat)
    throws IOException
  {
    writeFixed32NoTag(Float.floatToRawIntBits(paramFloat));
  }
  
  @Deprecated
  public final void writeGroup(int paramInt, MessageLite paramMessageLite)
    throws IOException
  {
    writeTag(paramInt, 3);
    writeGroupNoTag(paramMessageLite);
    writeTag(paramInt, 4);
  }
  
  @Deprecated
  public final void writeGroupNoTag(MessageLite paramMessageLite)
    throws IOException
  {
    paramMessageLite.writeTo(this);
  }
  
  public abstract void writeInt32(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeInt32NoTag(int paramInt)
    throws IOException;
  
  public final void writeInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeUInt64(paramInt, paramLong);
  }
  
  public final void writeInt64NoTag(long paramLong)
    throws IOException
  {
    writeUInt64NoTag(paramLong);
  }
  
  public abstract void writeLazy(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeMessage(int paramInt, MessageLite paramMessageLite)
    throws IOException;
  
  public abstract void writeMessageNoTag(MessageLite paramMessageLite)
    throws IOException;
  
  public abstract void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
    throws IOException;
  
  public final void writeRawByte(byte paramByte)
    throws IOException
  {
    write(paramByte);
  }
  
  public final void writeRawByte(int paramInt)
    throws IOException
  {
    write((byte)paramInt);
  }
  
  public final void writeRawBytes(ByteString paramByteString)
    throws IOException
  {
    paramByteString.writeTo(this);
  }
  
  public abstract void writeRawBytes(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public final void writeRawBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void writeRawBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @Deprecated
  public final void writeRawLittleEndian32(int paramInt)
    throws IOException
  {
    writeFixed32NoTag(paramInt);
  }
  
  @Deprecated
  public final void writeRawLittleEndian64(long paramLong)
    throws IOException
  {
    writeFixed64NoTag(paramLong);
  }
  
  public abstract void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
    throws IOException;
  
  @Deprecated
  public final void writeRawVarint32(int paramInt)
    throws IOException
  {
    writeUInt32NoTag(paramInt);
  }
  
  @Deprecated
  public final void writeRawVarint64(long paramLong)
    throws IOException
  {
    writeUInt64NoTag(paramLong);
  }
  
  public final void writeSFixed32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeFixed32(paramInt1, paramInt2);
  }
  
  public final void writeSFixed32NoTag(int paramInt)
    throws IOException
  {
    writeFixed32NoTag(paramInt);
  }
  
  public final void writeSFixed64(int paramInt, long paramLong)
    throws IOException
  {
    writeFixed64(paramInt, paramLong);
  }
  
  public final void writeSFixed64NoTag(long paramLong)
    throws IOException
  {
    writeFixed64NoTag(paramLong);
  }
  
  public final void writeSInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeUInt32(paramInt1, encodeZigZag32(paramInt2));
  }
  
  public final void writeSInt32NoTag(int paramInt)
    throws IOException
  {
    writeUInt32NoTag(encodeZigZag32(paramInt));
  }
  
  public final void writeSInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeUInt64(paramInt, encodeZigZag64(paramLong));
  }
  
  public final void writeSInt64NoTag(long paramLong)
    throws IOException
  {
    writeUInt64NoTag(encodeZigZag64(paramLong));
  }
  
  public abstract void writeString(int paramInt, String paramString)
    throws IOException;
  
  public abstract void writeStringNoTag(String paramString)
    throws IOException;
  
  public abstract void writeTag(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeUInt32(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeUInt32NoTag(int paramInt)
    throws IOException;
  
  public abstract void writeUInt64(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void writeUInt64NoTag(long paramLong)
    throws IOException;
  
  private static abstract class AbstractBufferedEncoder
    extends CodedOutputStream
  {
    final byte[] buffer;
    final int limit;
    int position;
    int totalBytesWritten;
    
    AbstractBufferedEncoder(int paramInt)
    {
      super();
      if (paramInt < 0) {
        throw new IllegalArgumentException("bufferSize must be >= 0");
      }
      this.buffer = new byte[Math.max(paramInt, 20)];
      this.limit = this.buffer.length;
    }
    
    final void buffer(byte paramByte)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = paramByte;
      this.totalBytesWritten += 1;
    }
    
    final void bufferFixed32NoTag(int paramInt)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
      this.totalBytesWritten += 4;
    }
    
    final void bufferFixed64NoTag(long paramLong)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
      this.totalBytesWritten += 8;
    }
    
    final void bufferInt32NoTag(int paramInt)
    {
      if (paramInt >= 0)
      {
        bufferUInt32NoTag(paramInt);
        return;
      }
      bufferUInt64NoTag(paramInt);
    }
    
    final void bufferTag(int paramInt1, int paramInt2)
    {
      bufferUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    final void bufferUInt32NoTag(int paramInt)
    {
      int i = paramInt;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
        for (l1 = l2;; l1 += 1L)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            UnsafeUtil.putByte(this.buffer, l1, (byte)paramInt);
            paramInt = (int)(l1 + 1L - l2);
            this.position += paramInt;
            this.totalBytesWritten += paramInt;
            return;
          }
          UnsafeUtil.putByte(this.buffer, l1, (byte)(paramInt & 0x7F | 0x80));
          paramInt >>>= 7;
        }
      }
      while ((i & 0xFFFFFF80) != 0)
      {
        long l2;
        long l1;
        arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        this.totalBytesWritten += 1;
        i >>>= 7;
      }
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)i);
      this.totalBytesWritten += 1;
    }
    
    final void bufferUInt64NoTag(long paramLong)
    {
      long l1 = paramLong;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
        for (l1 = l2;; l1 += 1L)
        {
          if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
          {
            UnsafeUtil.putByte(this.buffer, l1, (byte)(int)paramLong);
            i = (int)(l1 + 1L - l2);
            this.position += i;
            this.totalBytesWritten += i;
            return;
          }
          UnsafeUtil.putByte(this.buffer, l1, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
      while ((0xFFFFFFFFFFFFFF80 & l1) != 0L)
      {
        long l2;
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l1 & 0x7F | 0x80));
        this.totalBytesWritten += 1;
        l1 >>>= 7;
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)(int)l1);
      this.totalBytesWritten += 1;
    }
    
    public final int getTotalBytesWritten()
    {
      return this.totalBytesWritten;
    }
    
    public final int spaceLeft()
    {
      throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
  }
  
  private static class ArrayEncoder
    extends CodedOutputStream
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    ArrayEncoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer");
      }
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - (paramInt1 + paramInt2)) < 0) {
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      this.buffer = paramArrayOfByte;
      this.offset = paramInt1;
      this.position = paramInt1;
      this.limit = (paramInt1 + paramInt2);
    }
    
    public void flush() {}
    
    public final int getTotalBytesWritten()
    {
      return this.position - this.offset;
    }
    
    public final int spaceLeft()
    {
      return this.limit - this.position;
    }
    
    public final void write(byte paramByte)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void write(ByteBuffer paramByteBuffer)
      throws IOException
    {
      int i = paramByteBuffer.remaining();
      try
      {
        paramByteBuffer.get(this.buffer, this.position, i);
        this.position += i;
        return;
      }
      catch (IndexOutOfBoundsException paramByteBuffer)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i) }), paramByteBuffer);
      }
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void writeBool(int paramInt, boolean paramBoolean)
      throws IOException
    {
      int i = 0;
      writeTag(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      write((byte)paramInt);
    }
    
    public final void writeByteArray(int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public final void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
      throws IOException
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public final void writeBytes(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public final void writeBytesNoTag(ByteString paramByteString)
      throws IOException
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public final void writeFixed32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 5);
      writeFixed32NoTag(paramInt2);
    }
    
    public final void writeFixed32NoTag(int paramInt)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void writeFixed64(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 1);
      writeFixed64NoTag(paramLong);
    }
    
    public final void writeFixed64NoTag(long paramLong)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)paramLong & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 16) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      writeInt32NoTag(paramInt2);
    }
    
    public final void writeInt32NoTag(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public final void writeLazy(ByteBuffer paramByteBuffer)
      throws IOException
    {
      write(paramByteBuffer);
    }
    
    public final void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeMessage(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public final void writeMessageNoTag(MessageLite paramMessageLite)
      throws IOException
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public final void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public final void writeRawBytes(ByteBuffer paramByteBuffer)
      throws IOException
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public final void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public final void writeString(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public final void writeStringNoTag(String paramString)
      throws IOException
    {
      int i = this.position;
      try
      {
        int k = computeUInt32SizeNoTag(paramString.length() * 3);
        int j = computeUInt32SizeNoTag(paramString.length());
        if (j == k)
        {
          this.position = (i + j);
          k = Utf8.encode(paramString, this.buffer, this.position, spaceLeft());
          this.position = i;
          writeUInt32NoTag(k - i - j);
          this.position = k;
          return;
        }
        writeUInt32NoTag(Utf8.encodedLength(paramString));
        this.position = Utf8.encode(paramString, this.buffer, this.position, spaceLeft());
        return;
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.position = i;
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
    }
    
    public final void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public final void writeUInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      writeUInt32NoTag(paramInt2);
    }
    
    public final void writeUInt32NoTag(int paramInt)
      throws IOException
    {
      int i = paramInt;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        i = paramInt;
        if (spaceLeft() >= 10) {
          for (long l = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;; l += 1L)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              UnsafeUtil.putByte(this.buffer, l, (byte)paramInt);
              this.position += 1;
              return;
            }
            UnsafeUtil.putByte(this.buffer, l, (byte)(paramInt & 0x7F | 0x80));
            this.position += 1;
            paramInt >>>= 7;
          }
        }
      }
      try
      {
        do
        {
          arrayOfByte = this.buffer;
          paramInt = this.position;
          this.position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
          i >>>= 7;
        } while ((i & 0xFFFFFF80) != 0);
        byte[] arrayOfByte = this.buffer;
        paramInt = this.position;
        this.position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void writeUInt64(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 0);
      writeUInt64NoTag(paramLong);
    }
    
    public final void writeUInt64NoTag(long paramLong)
      throws IOException
    {
      long l1 = paramLong;
      if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS)
      {
        l1 = paramLong;
        if (spaceLeft() >= 10)
        {
          long l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
          l1 = paramLong;
          for (paramLong = l2;; paramLong += 1L)
          {
            if ((0xFFFFFFFFFFFFFF80 & l1) == 0L)
            {
              UnsafeUtil.putByte(this.buffer, paramLong, (byte)(int)l1);
              this.position += 1;
              return;
            }
            UnsafeUtil.putByte(this.buffer, paramLong, (byte)((int)l1 & 0x7F | 0x80));
            this.position += 1;
            l1 >>>= 7;
          }
        }
      }
      try
      {
        do
        {
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)((int)l1 & 0x7F | 0x80));
          l1 >>>= 7;
        } while ((0xFFFFFFFFFFFFFF80 & l1) != 0L);
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)(int)l1);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
  }
  
  private static final class ByteOutputEncoder
    extends CodedOutputStream.AbstractBufferedEncoder
  {
    private final ByteOutput out;
    
    ByteOutputEncoder(ByteOutput paramByteOutput, int paramInt)
    {
      super();
      if (paramByteOutput == null) {
        throw new NullPointerException("out");
      }
      this.out = paramByteOutput;
    }
    
    private void doFlush()
      throws IOException
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
    }
    
    private void flushIfNotAvailable(int paramInt)
      throws IOException
    {
      if (this.limit - this.position < paramInt) {
        doFlush();
      }
    }
    
    public void flush()
      throws IOException
    {
      if (this.position > 0) {
        doFlush();
      }
    }
    
    public void write(byte paramByte)
      throws IOException
    {
      if (this.position == this.limit) {
        doFlush();
      }
      buffer(paramByte);
    }
    
    public void write(ByteBuffer paramByteBuffer)
      throws IOException
    {
      flush();
      int i = paramByteBuffer.remaining();
      this.out.write(paramByteBuffer);
      this.totalBytesWritten += i;
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      flush();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      this.totalBytesWritten += paramInt2;
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
      throws IOException
    {
      int i = 0;
      flushIfNotAvailable(11);
      bufferTag(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      buffer((byte)paramInt);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
      throws IOException
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
      throws IOException
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(14);
      bufferTag(paramInt1, 5);
      bufferFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
      throws IOException
    {
      flushIfNotAvailable(4);
      bufferFixed32NoTag(paramInt);
    }
    
    public void writeFixed64(int paramInt, long paramLong)
      throws IOException
    {
      flushIfNotAvailable(18);
      bufferTag(paramInt, 1);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
      throws IOException
    {
      flushIfNotAvailable(8);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
      throws IOException
    {
      flush();
      int i = paramByteBuffer.remaining();
      this.out.writeLazy(paramByteBuffer);
      this.totalBytesWritten += i;
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      flush();
      this.out.writeLazy(paramArrayOfByte, paramInt1, paramInt2);
      this.totalBytesWritten += paramInt2;
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
      throws IOException
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
      throws IOException
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public void writeStringNoTag(String paramString)
      throws IOException
    {
      int i = paramString.length() * 3;
      int j = computeUInt32SizeNoTag(i);
      if (j + i > this.limit)
      {
        byte[] arrayOfByte = new byte[i];
        i = Utf8.encode(paramString, arrayOfByte, 0, i);
        writeUInt32NoTag(i);
        writeLazy(arrayOfByte, 0, i);
        return;
      }
      if (j + i > this.limit - this.position) {
        doFlush();
      }
      i = this.position;
      try
      {
        int k = computeUInt32SizeNoTag(paramString.length());
        if (k == j)
        {
          this.position = (i + k);
          j = Utf8.encode(paramString, this.buffer, this.position, this.limit - this.position);
          this.position = i;
          k = j - i - k;
          bufferUInt32NoTag(k);
          this.position = j;
          this.totalBytesWritten += k;
          return;
        }
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.totalBytesWritten -= this.position - i;
        this.position = i;
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
        return;
        j = Utf8.encodedLength(paramString);
        bufferUInt32NoTag(j);
        this.position = Utf8.encode(paramString, this.buffer, this.position, j);
        this.totalBytesWritten += j;
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
    }
    
    public void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
      throws IOException
    {
      flushIfNotAvailable(10);
      bufferUInt32NoTag(paramInt);
    }
    
    public void writeUInt64(int paramInt, long paramLong)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt, 0);
      bufferUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
      throws IOException
    {
      flushIfNotAvailable(10);
      bufferUInt64NoTag(paramLong);
    }
  }
  
  private static final class NioEncoder
    extends CodedOutputStream
  {
    private final ByteBuffer buffer;
    private final int initialPosition;
    private final ByteBuffer originalBuffer;
    
    NioEncoder(ByteBuffer paramByteBuffer)
    {
      super();
      this.originalBuffer = paramByteBuffer;
      this.buffer = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.initialPosition = paramByteBuffer.position();
    }
    
    private void encode(String paramString)
      throws IOException
    {
      try
      {
        Utf8.encodeUtf8(paramString, this.buffer);
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
    }
    
    public void flush()
    {
      this.originalBuffer.position(this.buffer.position());
    }
    
    public int getTotalBytesWritten()
    {
      return this.buffer.position() - this.initialPosition;
    }
    
    public int spaceLeft()
    {
      return this.buffer.remaining();
    }
    
    public void write(byte paramByte)
      throws IOException
    {
      try
      {
        this.buffer.put(paramByte);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void write(ByteBuffer paramByteBuffer)
      throws IOException
    {
      try
      {
        this.buffer.put(paramByteBuffer);
        return;
      }
      catch (BufferOverflowException paramByteBuffer)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramByteBuffer);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.buffer.put(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
      }
      catch (BufferOverflowException paramArrayOfByte)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramArrayOfByte);
      }
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
      throws IOException
    {
      int i = 0;
      writeTag(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      write((byte)paramInt);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
      throws IOException
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
      throws IOException
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 5);
      writeFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
      throws IOException
    {
      try
      {
        this.buffer.putInt(paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void writeFixed64(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 1);
      writeFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
      throws IOException
    {
      try
      {
        this.buffer.putLong(paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
      }
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      writeInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
      throws IOException
    {
      write(paramByteBuffer);
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
      throws IOException
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
      throws IOException
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    public void writeStringNoTag(String paramString)
      throws IOException
    {
      int i = this.buffer.position();
      try
      {
        int j = computeUInt32SizeNoTag(paramString.length() * 3);
        int k = computeUInt32SizeNoTag(paramString.length());
        if (k == j)
        {
          j = this.buffer.position() + k;
          this.buffer.position(j);
          encode(paramString);
          k = this.buffer.position();
          this.buffer.position(i);
          writeUInt32NoTag(k - j);
          this.buffer.position(k);
          return;
        }
        writeUInt32NoTag(Utf8.encodedLength(paramString));
        encode(paramString);
        return;
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
      {
        this.buffer.position(i);
        inefficientWriteStringNoTag(paramString, localUnpairedSurrogateException);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        throw new CodedOutputStream.OutOfSpaceException(paramString);
      }
    }
    
    public void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      writeUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
      throws IOException
    {
      for (;;)
      {
        if ((paramInt & 0xFFFFFF80) == 0) {}
        try
        {
          this.buffer.put((byte)paramInt);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
        }
        this.buffer.put((byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      }
    }
    
    public void writeUInt64(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 0);
      writeUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
      throws IOException
    {
      for (;;)
      {
        if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {}
        try
        {
          this.buffer.put((byte)(int)paramLong);
          return;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new CodedOutputStream.OutOfSpaceException(localBufferOverflowException);
        }
        this.buffer.put((byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7;
      }
    }
  }
  
  private static final class NioHeapEncoder
    extends CodedOutputStream.ArrayEncoder
  {
    private final ByteBuffer byteBuffer;
    private int initialPosition;
    
    NioHeapEncoder(ByteBuffer paramByteBuffer)
    {
      super(paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      this.byteBuffer = paramByteBuffer;
      this.initialPosition = paramByteBuffer.position();
    }
    
    public void flush()
    {
      this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
    }
  }
  
  public static class OutOfSpaceException
    extends IOException
  {
    private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
    private static final long serialVersionUID = -6947486886997889499L;
    
    OutOfSpaceException()
    {
      super();
    }
    
    OutOfSpaceException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    OutOfSpaceException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  private static final class OutputStreamEncoder
    extends CodedOutputStream.AbstractBufferedEncoder
  {
    private final OutputStream out;
    
    OutputStreamEncoder(OutputStream paramOutputStream, int paramInt)
    {
      super();
      if (paramOutputStream == null) {
        throw new NullPointerException("out");
      }
      this.out = paramOutputStream;
    }
    
    private void doFlush()
      throws IOException
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
    }
    
    private void flushIfNotAvailable(int paramInt)
      throws IOException
    {
      if (this.limit - this.position < paramInt) {
        doFlush();
      }
    }
    
    public void flush()
      throws IOException
    {
      if (this.position > 0) {
        doFlush();
      }
    }
    
    public void write(byte paramByte)
      throws IOException
    {
      if (this.position == this.limit) {
        doFlush();
      }
      buffer(paramByte);
    }
    
    public void write(ByteBuffer paramByteBuffer)
      throws IOException
    {
      int i = paramByteBuffer.remaining();
      if (this.limit - this.position >= i)
      {
        paramByteBuffer.get(this.buffer, this.position, i);
        this.position += i;
        this.totalBytesWritten += i;
        return;
      }
      int j = this.limit - this.position;
      paramByteBuffer.get(this.buffer, this.position, j);
      i -= j;
      this.position = this.limit;
      this.totalBytesWritten += j;
      doFlush();
      while (i > this.limit)
      {
        paramByteBuffer.get(this.buffer, 0, this.limit);
        this.out.write(this.buffer, 0, this.limit);
        i -= this.limit;
        this.totalBytesWritten += this.limit;
      }
      paramByteBuffer.get(this.buffer, 0, i);
      this.position = i;
      this.totalBytesWritten += i;
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.limit - this.position >= paramInt2)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position += paramInt2;
        this.totalBytesWritten += paramInt2;
        return;
      }
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, i);
      paramInt1 += i;
      paramInt2 -= i;
      this.position = this.limit;
      this.totalBytesWritten += i;
      doFlush();
      if (paramInt2 <= this.limit)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, 0, paramInt2);
        this.position = paramInt2;
      }
      for (;;)
      {
        this.totalBytesWritten += paramInt2;
        return;
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    
    public void writeBool(int paramInt, boolean paramBoolean)
      throws IOException
    {
      int i = 0;
      flushIfNotAvailable(11);
      bufferTag(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      buffer((byte)paramInt);
    }
    
    public void writeByteArray(int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      writeByteArray(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void writeByteArray(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
      throws IOException
    {
      writeTag(paramInt1, 2);
      writeByteArrayNoTag(paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public void writeByteArrayNoTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(paramInt2);
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByteBuffer(int paramInt, ByteBuffer paramByteBuffer)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeUInt32NoTag(paramByteBuffer.capacity());
      writeRawBytes(paramByteBuffer);
    }
    
    public void writeBytes(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeBytesNoTag(paramByteString);
    }
    
    public void writeBytesNoTag(ByteString paramByteString)
      throws IOException
    {
      writeUInt32NoTag(paramByteString.size());
      paramByteString.writeTo(this);
    }
    
    public void writeFixed32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(14);
      bufferTag(paramInt1, 5);
      bufferFixed32NoTag(paramInt2);
    }
    
    public void writeFixed32NoTag(int paramInt)
      throws IOException
    {
      flushIfNotAvailable(4);
      bufferFixed32NoTag(paramInt);
    }
    
    public void writeFixed64(int paramInt, long paramLong)
      throws IOException
    {
      flushIfNotAvailable(18);
      bufferTag(paramInt, 1);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeFixed64NoTag(long paramLong)
      throws IOException
    {
      flushIfNotAvailable(8);
      bufferFixed64NoTag(paramLong);
    }
    
    public void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferInt32NoTag(paramInt2);
    }
    
    public void writeInt32NoTag(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        writeUInt32NoTag(paramInt);
        return;
      }
      writeUInt64NoTag(paramInt);
    }
    
    public void writeLazy(ByteBuffer paramByteBuffer)
      throws IOException
    {
      write(paramByteBuffer);
    }
    
    public void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeMessage(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeMessageNoTag(paramMessageLite);
    }
    
    public void writeMessageNoTag(MessageLite paramMessageLite)
      throws IOException
    {
      writeUInt32NoTag(paramMessageLite.getSerializedSize());
      paramMessageLite.writeTo(this);
    }
    
    public void writeMessageSetExtension(int paramInt, MessageLite paramMessageLite)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeMessage(3, paramMessageLite);
      writeTag(1, 4);
    }
    
    public void writeRawBytes(ByteBuffer paramByteBuffer)
      throws IOException
    {
      if (paramByteBuffer.hasArray())
      {
        write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.capacity());
        return;
      }
      paramByteBuffer = paramByteBuffer.duplicate();
      paramByteBuffer.clear();
      write(paramByteBuffer);
    }
    
    public void writeRawMessageSetExtension(int paramInt, ByteString paramByteString)
      throws IOException
    {
      writeTag(1, 3);
      writeUInt32(2, paramInt);
      writeBytes(3, paramByteString);
      writeTag(1, 4);
    }
    
    public void writeString(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      writeStringNoTag(paramString);
    }
    
    /* Error */
    public void writeStringNoTag(String paramString)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 197	java/lang/String:length	()I
      //   4: iconst_3
      //   5: imul
      //   6: istore_3
      //   7: iload_3
      //   8: invokestatic 201	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:computeUInt32SizeNoTag	(I)I
      //   11: istore_2
      //   12: iload_2
      //   13: iload_3
      //   14: iadd
      //   15: aload_0
      //   16: getfield 46	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:limit	I
      //   19: if_icmple +31 -> 50
      //   22: iload_3
      //   23: newarray <illegal type>
      //   25: astore 6
      //   27: aload_1
      //   28: aload 6
      //   30: iconst_0
      //   31: iload_3
      //   32: invokestatic 207	com/google/protobuf/Utf8:encode	(Ljava/lang/CharSequence;[BII)I
      //   35: istore_2
      //   36: aload_0
      //   37: iload_2
      //   38: invokevirtual 94	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:writeUInt32NoTag	(I)V
      //   41: aload_0
      //   42: aload 6
      //   44: iconst_0
      //   45: iload_2
      //   46: invokevirtual 209	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:writeLazy	([BII)V
      //   49: return
      //   50: iload_2
      //   51: iload_3
      //   52: iadd
      //   53: aload_0
      //   54: getfield 46	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:limit	I
      //   57: aload_0
      //   58: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   61: isub
      //   62: if_icmple +7 -> 69
      //   65: aload_0
      //   66: invokespecial 48	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:doFlush	()V
      //   69: aload_1
      //   70: invokevirtual 197	java/lang/String:length	()I
      //   73: invokestatic 201	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:computeUInt32SizeNoTag	(I)I
      //   76: istore 4
      //   78: aload_0
      //   79: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   82: istore_3
      //   83: iload 4
      //   85: iload_2
      //   86: if_icmpne +104 -> 190
      //   89: aload_0
      //   90: iload_3
      //   91: iload 4
      //   93: iadd
      //   94: putfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   97: aload_1
      //   98: aload_0
      //   99: getfield 31	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:buffer	[B
      //   102: aload_0
      //   103: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   106: aload_0
      //   107: getfield 46	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:limit	I
      //   110: aload_0
      //   111: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   114: isub
      //   115: invokestatic 207	com/google/protobuf/Utf8:encode	(Ljava/lang/CharSequence;[BII)I
      //   118: istore 5
      //   120: aload_0
      //   121: iload_3
      //   122: putfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   125: iload 5
      //   127: iload_3
      //   128: isub
      //   129: iload 4
      //   131: isub
      //   132: istore_2
      //   133: aload_0
      //   134: iload_2
      //   135: invokevirtual 212	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:bufferUInt32NoTag	(I)V
      //   138: aload_0
      //   139: iload 5
      //   141: putfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   144: aload_0
      //   145: aload_0
      //   146: getfield 66	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:totalBytesWritten	I
      //   149: iload_2
      //   150: iadd
      //   151: putfield 66	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:totalBytesWritten	I
      //   154: return
      //   155: astore 6
      //   157: aload_0
      //   158: aload_0
      //   159: getfield 66	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:totalBytesWritten	I
      //   162: aload_0
      //   163: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   166: iload_3
      //   167: isub
      //   168: isub
      //   169: putfield 66	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:totalBytesWritten	I
      //   172: aload_0
      //   173: iload_3
      //   174: putfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   177: aload 6
      //   179: athrow
      //   180: astore 6
      //   182: aload_0
      //   183: aload_1
      //   184: aload 6
      //   186: invokevirtual 216	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:inefficientWriteStringNoTag	(Ljava/lang/String;Lcom/google/protobuf/Utf8$UnpairedSurrogateException;)V
      //   189: return
      //   190: aload_1
      //   191: invokestatic 220	com/google/protobuf/Utf8:encodedLength	(Ljava/lang/CharSequence;)I
      //   194: istore_2
      //   195: aload_0
      //   196: iload_2
      //   197: invokevirtual 212	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:bufferUInt32NoTag	(I)V
      //   200: aload_0
      //   201: aload_1
      //   202: aload_0
      //   203: getfield 31	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:buffer	[B
      //   206: aload_0
      //   207: getfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   210: iload_2
      //   211: invokestatic 207	com/google/protobuf/Utf8:encode	(Ljava/lang/CharSequence;[BII)I
      //   214: putfield 35	com/google/protobuf/CodedOutputStream$OutputStreamEncoder:position	I
      //   217: goto -73 -> 144
      //   220: astore 6
      //   222: new 222	com/google/protobuf/CodedOutputStream$OutOfSpaceException
      //   225: dup
      //   226: aload 6
      //   228: invokespecial 225	com/google/protobuf/CodedOutputStream$OutOfSpaceException:<init>	(Ljava/lang/Throwable;)V
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	OutputStreamEncoder
      //   0	232	1	paramString	String
      //   11	200	2	i	int
      //   6	168	3	j	int
      //   76	56	4	k	int
      //   118	22	5	m	int
      //   25	18	6	arrayOfByte	byte[]
      //   155	23	6	localUnpairedSurrogateException1	Utf8.UnpairedSurrogateException
      //   180	5	6	localUnpairedSurrogateException2	Utf8.UnpairedSurrogateException
      //   220	7	6	localArrayIndexOutOfBoundsException	ArrayIndexOutOfBoundsException
      // Exception table:
      //   from	to	target	type
      //   89	125	155	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   133	144	155	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   144	154	155	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   190	217	155	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   0	49	180	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   50	69	180	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   69	83	180	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   157	180	180	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   222	232	180	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   89	125	220	java/lang/ArrayIndexOutOfBoundsException
      //   133	144	220	java/lang/ArrayIndexOutOfBoundsException
      //   144	154	220	java/lang/ArrayIndexOutOfBoundsException
      //   190	217	220	java/lang/ArrayIndexOutOfBoundsException
    }
    
    public void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      writeUInt32NoTag(WireFormat.makeTag(paramInt1, paramInt2));
    }
    
    public void writeUInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt1, 0);
      bufferUInt32NoTag(paramInt2);
    }
    
    public void writeUInt32NoTag(int paramInt)
      throws IOException
    {
      flushIfNotAvailable(10);
      bufferUInt32NoTag(paramInt);
    }
    
    public void writeUInt64(int paramInt, long paramLong)
      throws IOException
    {
      flushIfNotAvailable(20);
      bufferTag(paramInt, 0);
      bufferUInt64NoTag(paramLong);
    }
    
    public void writeUInt64NoTag(long paramLong)
      throws IOException
    {
      flushIfNotAvailable(10);
      bufferUInt64NoTag(paramLong);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/CodedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */