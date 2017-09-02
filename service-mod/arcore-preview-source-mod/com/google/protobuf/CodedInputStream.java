package com.google.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream
{
  private static final int BUFFER_SIZE = 4096;
  private static final int DEFAULT_RECURSION_LIMIT = 100;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private final byte[] buffer;
  private final boolean bufferIsImmutable;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int currentLimit = Integer.MAX_VALUE;
  private boolean enableAliasing = false;
  private final InputStream input;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 100;
  private RefillCallback refillCallback = null;
  private int sizeLimit = 67108864;
  private int totalBytesRetired;
  
  private CodedInputStream(InputStream paramInputStream, int paramInt)
  {
    this.buffer = new byte[paramInt];
    this.bufferPos = 0;
    this.totalBytesRetired = 0;
    this.input = paramInputStream;
    this.bufferIsImmutable = false;
  }
  
  private CodedInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
    this.totalBytesRetired = (-paramInt1);
    this.input = null;
    this.bufferIsImmutable = paramBoolean;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream)
  {
    return new CodedInputStream(paramInputStream, 4096);
  }
  
  static CodedInputStream newInstance(InputStream paramInputStream, int paramInt)
  {
    return new CodedInputStream(paramInputStream, paramInt);
  }
  
  public static CodedInputStream newInstance(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray()) {
      return newInstance(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    paramByteBuffer = paramByteBuffer.duplicate();
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return newInstance(arrayOfByte);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newInstance(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  static CodedInputStream newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new CodedInputStream(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
    try
    {
      paramArrayOfByte.pushLimit(paramInt2);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  private byte[] readRawBytesSlowPath(int paramInt)
    throws IOException
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0)
      {
        localObject = Internal.EMPTY_BYTE_ARRAY;
        return (byte[])localObject;
      }
      throw InvalidProtocolBufferException.negativeSize();
    }
    int i = this.totalBytesRetired + this.bufferPos + paramInt;
    if (i > this.sizeLimit) {
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    if (i > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (this.input == null) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    int m = this.bufferPos;
    i = this.bufferSize - this.bufferPos;
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    this.bufferSize = 0;
    int j = paramInt - i;
    if ((j < 4096) || (j <= this.input.available()))
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, m, arrayOfByte, 0, i);
      for (;;)
      {
        localObject = arrayOfByte;
        if (i >= arrayOfByte.length) {
          break;
        }
        j = this.input.read(arrayOfByte, i, paramInt - i);
        if (j == -1) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.totalBytesRetired += j;
        i += j;
      }
    }
    Object localObject = new ArrayList();
    while (j > 0)
    {
      arrayOfByte = new byte[Math.min(j, 4096)];
      int k = 0;
      while (k < arrayOfByte.length)
      {
        int n = this.input.read(arrayOfByte, k, arrayOfByte.length - k);
        if (n == -1) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.totalBytesRetired += n;
        k += n;
      }
      j -= arrayOfByte.length;
      ((List)localObject).add(arrayOfByte);
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.buffer, m, arrayOfByte, 0, i);
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      localObject = arrayOfByte;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (byte[])localIterator.next();
      System.arraycopy(localObject, 0, arrayOfByte, i, localObject.length);
      i += localObject.length;
    }
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    int j;
    if ((paramInt & 0x80) == 0)
    {
      j = paramInt;
      return j;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label78;
      }
      int k = paramInputStream.read();
      if (k == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      i |= (k & 0x7F) << paramInt;
      j = i;
      if ((k & 0x80) == 0) {
        break;
      }
      paramInt += 7;
    }
    label78:
    do
    {
      j += 7;
      if (j >= 64) {
        break;
      }
      paramInt = paramInputStream.read();
      if (paramInt == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    } while ((paramInt & 0x80) != 0);
    return i;
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  static int readRawVarint32(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    return readRawVarint32(i, paramInputStream);
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.totalBytesRetired + this.bufferSize;
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private void refillBuffer(int paramInt)
    throws IOException
  {
    if (!tryRefillBuffer(paramInt)) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
  }
  
  private void skipRawBytesSlowPath(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    int i = this.bufferSize - this.bufferPos;
    this.bufferPos = this.bufferSize;
    refillBuffer(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bufferPos = this.bufferSize;
      refillBuffer(1);
    }
    this.bufferPos = (paramInt - i);
  }
  
  private void skipRawVarint()
    throws IOException
  {
    if (this.bufferSize - this.bufferPos >= 10)
    {
      byte[] arrayOfByte = this.buffer;
      int j = this.bufferPos;
      int i = 0;
      while (i < 10)
      {
        int k = j + 1;
        if (arrayOfByte[j] >= 0)
        {
          this.bufferPos = k;
          return;
        }
        i += 1;
        j = k;
      }
    }
    skipRawVarintSlowPath();
  }
  
  private void skipRawVarintSlowPath()
    throws IOException
  {
    int i = 0;
    while (i < 10)
    {
      if (readRawByte() >= 0) {
        return;
      }
      i += 1;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  private boolean tryRefillBuffer(int paramInt)
    throws IOException
  {
    if (this.bufferPos + paramInt <= this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when " + paramInt + " bytes were already available in buffer");
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit) {}
    int i;
    do
    {
      do
      {
        return false;
        if (this.refillCallback != null) {
          this.refillCallback.onRefill();
        }
      } while (this.input == null);
      i = this.bufferPos;
      if (i > 0)
      {
        if (this.bufferSize > i) {
          System.arraycopy(this.buffer, i, this.buffer, 0, this.bufferSize - i);
        }
        this.totalBytesRetired += i;
        this.bufferSize -= i;
        this.bufferPos = 0;
      }
      i = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
      if ((i == 0) || (i < -1) || (i > this.buffer.length)) {
        throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + i + "\nThe InputStream implementation is buggy.");
      }
    } while (i <= 0);
    this.bufferSize += i;
    if (this.totalBytesRetired + paramInt - this.sizeLimit > 0) {
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    recomputeBufferSizeAfterLimit();
    if (this.bufferSize >= paramInt) {
      return true;
    }
    return tryRefillBuffer(paramInt);
  }
  
  public void checkLastTagWas(int paramInt)
    throws InvalidProtocolBufferException
  {
    if (this.lastTag != paramInt) {
      throw InvalidProtocolBufferException.invalidEndTag();
    }
  }
  
  public void enableAliasing(boolean paramBoolean)
  {
    this.enableAliasing = paramBoolean;
  }
  
  public int getBytesUntilLimit()
  {
    if (this.currentLimit == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.totalBytesRetired;
    int j = this.bufferPos;
    return this.currentLimit - (i + j);
  }
  
  public int getLastTag()
  {
    return this.lastTag;
  }
  
  public int getTotalBytesRead()
  {
    return this.totalBytesRetired + this.bufferPos;
  }
  
  public boolean isAtEnd()
    throws IOException
  {
    return (this.bufferPos == this.bufferSize) && (!tryRefillBuffer(1));
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
    throws InvalidProtocolBufferException
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    paramInt += this.totalBytesRetired + this.bufferPos;
    int i = this.currentLimit;
    if (paramInt > i) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }
  
  public boolean readBool()
    throws IOException
  {
    return readRawVarint64() != 0L;
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + i);
      this.bufferPos += i;
      return arrayOfByte;
    }
    return readRawBytesSlowPath(i);
  }
  
  public ByteBuffer readByteBuffer()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      if ((this.input == null) && (!this.bufferIsImmutable) && (this.enableAliasing)) {}
      for (ByteBuffer localByteBuffer = ByteBuffer.wrap(this.buffer, this.bufferPos, i).slice();; localByteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + i)))
      {
        this.bufferPos += i;
        return localByteBuffer;
      }
    }
    if (i == 0) {
      return Internal.EMPTY_BYTE_BUFFER;
    }
    return ByteBuffer.wrap(readRawBytesSlowPath(i));
  }
  
  public ByteString readBytes()
    throws IOException
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      if ((this.bufferIsImmutable) && (this.enableAliasing)) {}
      for (ByteString localByteString = ByteString.wrap(this.buffer, this.bufferPos, i);; localByteString = ByteString.copyFrom(this.buffer, this.bufferPos, i))
      {
        this.bufferPos += i;
        return localByteString;
      }
    }
    if (i == 0) {
      return ByteString.EMPTY;
    }
    return ByteString.wrap(readRawBytesSlowPath(i));
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public int readFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public long readFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public <T extends MessageLite> T readGroup(int paramInt, Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(WireFormat.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
    return paramParser;
  }
  
  public void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(WireFormat.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
  }
  
  public int readInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public long readInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
    return paramParser;
  }
  
  public void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    int i = readRawVarint32();
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
  }
  
  public byte readRawByte()
    throws IOException
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt)
    throws IOException
  {
    int i = this.bufferPos;
    if ((paramInt <= this.bufferSize - i) && (paramInt > 0))
    {
      this.bufferPos = (i + paramInt);
      return Arrays.copyOfRange(this.buffer, i, i + paramInt);
    }
    return readRawBytesSlowPath(paramInt);
  }
  
  public int readRawLittleEndian32()
    throws IOException
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      refillBuffer(4);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 4);
    return arrayOfByte[i] & 0xFF | (arrayOfByte[(i + 1)] & 0xFF) << 8 | (arrayOfByte[(i + 2)] & 0xFF) << 16 | (arrayOfByte[(i + 3)] & 0xFF) << 24;
  }
  
  public long readRawLittleEndian64()
    throws IOException
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      refillBuffer(8);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 8);
    return arrayOfByte[i] & 0xFF | (arrayOfByte[(i + 1)] & 0xFF) << 8 | (arrayOfByte[(i + 2)] & 0xFF) << 16 | (arrayOfByte[(i + 3)] & 0xFF) << 24 | (arrayOfByte[(i + 4)] & 0xFF) << 32 | (arrayOfByte[(i + 5)] & 0xFF) << 40 | (arrayOfByte[(i + 6)] & 0xFF) << 48 | (arrayOfByte[(i + 7)] & 0xFF) << 56;
  }
  
  public int readRawVarint32()
    throws IOException
  {
    int i = this.bufferPos;
    if (this.bufferSize == i) {}
    byte[] arrayOfByte;
    int j;
    int k;
    do
    {
      return (int)readRawVarint64SlowPath();
      arrayOfByte = this.buffer;
      j = i + 1;
      k = arrayOfByte[i];
      if (k >= 0)
      {
        this.bufferPos = j;
        return k;
      }
    } while (this.bufferSize - j < 9);
    i = j + 1;
    k ^= arrayOfByte[j] << 7;
    if (k < 0) {
      j = k ^ 0xFFFFFF80;
    }
    for (;;)
    {
      this.bufferPos = i;
      return j;
      j = i + 1;
      k ^= arrayOfByte[i] << 14;
      if (k >= 0)
      {
        k ^= 0x3F80;
        i = j;
        j = k;
      }
      else
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 21;
        if (k < 0)
        {
          j = k ^ 0xFFE03F80;
        }
        else
        {
          int m = i + 1;
          j = arrayOfByte[i];
          k = k ^ j << 28 ^ 0xFE03F80;
          i = m;
          if (j < 0)
          {
            int n = m + 1;
            i = n;
            j = k;
            if (arrayOfByte[m] >= 0) {
              continue;
            }
            m = n + 1;
            i = m;
            if (arrayOfByte[n] < 0)
            {
              n = m + 1;
              i = n;
              j = k;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                i = m + 1;
                j = k;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                break;
              }
            }
          }
          j = k;
        }
      }
    }
  }
  
  public long readRawVarint64()
    throws IOException
  {
    int i = this.bufferPos;
    if (this.bufferSize == i) {}
    byte[] arrayOfByte;
    int j;
    int k;
    do
    {
      return readRawVarint64SlowPath();
      arrayOfByte = this.buffer;
      j = i + 1;
      k = arrayOfByte[i];
      if (k >= 0)
      {
        this.bufferPos = j;
        return k;
      }
    } while (this.bufferSize - j < 9);
    i = j + 1;
    k ^= arrayOfByte[j] << 7;
    long l;
    if (k < 0) {
      l = k ^ 0xFFFFFF80;
    }
    for (;;)
    {
      this.bufferPos = i;
      return l;
      j = i + 1;
      k ^= arrayOfByte[i] << 14;
      if (k >= 0)
      {
        l = k ^ 0x3F80;
        i = j;
      }
      else
      {
        i = j + 1;
        j = k ^ arrayOfByte[j] << 21;
        if (j < 0)
        {
          l = 0xFFE03F80 ^ j;
        }
        else
        {
          l = j;
          j = i + 1;
          l ^= arrayOfByte[i] << 28;
          if (l >= 0L)
          {
            l ^= 0xFE03F80;
            i = j;
          }
          else
          {
            i = j + 1;
            l ^= arrayOfByte[j] << 35;
            if (l < 0L)
            {
              l ^= 0xFFFFFFF80FE03F80;
            }
            else
            {
              j = i + 1;
              l ^= arrayOfByte[i] << 42;
              if (l >= 0L)
              {
                l ^= 0x3F80FE03F80;
                i = j;
              }
              else
              {
                i = j + 1;
                l ^= arrayOfByte[j] << 49;
                if (l < 0L)
                {
                  l ^= 0xFFFE03F80FE03F80;
                }
                else
                {
                  j = i + 1;
                  l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80FE03F80;
                  if (l < 0L)
                  {
                    i = j + 1;
                    if (arrayOfByte[j] >= 0L) {
                      continue;
                    }
                    break;
                  }
                  i = j;
                }
              }
            }
          }
        }
      }
    }
  }
  
  long readRawVarint64SlowPath()
    throws IOException
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public int readSFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
    throws IOException
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
    throws IOException
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString()
    throws IOException
  {
    int i = readRawVarint32();
    String str;
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      str = new String(this.buffer, this.bufferPos, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i <= this.bufferSize)
    {
      refillBuffer(i);
      str = new String(this.buffer, this.bufferPos, i, Internal.UTF_8);
      this.bufferPos += i;
      return str;
    }
    return new String(readRawBytesSlowPath(i), Internal.UTF_8);
  }
  
  public String readStringRequireUtf8()
    throws IOException
  {
    int j = readRawVarint32();
    int i = this.bufferPos;
    byte[] arrayOfByte;
    if ((j <= this.bufferSize - i) && (j > 0))
    {
      arrayOfByte = this.buffer;
      this.bufferPos = (i + j);
    }
    while (!Utf8.isValidUtf8(arrayOfByte, i, i + j))
    {
      throw InvalidProtocolBufferException.invalidUtf8();
      if (j == 0) {
        return "";
      }
      if (j <= this.bufferSize)
      {
        refillBuffer(j);
        arrayOfByte = this.buffer;
        i = 0;
        this.bufferPos = (0 + j);
      }
      else
      {
        arrayOfByte = readRawBytesSlowPath(j);
        i = 0;
      }
    }
    return new String(arrayOfByte, i, j, Internal.UTF_8);
  }
  
  public int readTag()
    throws IOException
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
      throw InvalidProtocolBufferException.invalidTag();
    }
    return this.lastTag;
  }
  
  public int readUInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  @Deprecated
  public void readUnknownGroup(int paramInt, MessageLite.Builder paramBuilder)
    throws IOException
  {
    readGroup(paramInt, paramBuilder, null);
  }
  
  public void resetSizeCounter()
  {
    this.totalBytesRetired = (-this.bufferPos);
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + paramInt);
    }
    int i = this.recursionLimit;
    this.recursionLimit = paramInt;
    return i;
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size limit cannot be negative: " + paramInt);
    }
    int i = this.sizeLimit;
    this.sizeLimit = paramInt;
    return i;
  }
  
  public boolean skipField(int paramInt)
    throws IOException
  {
    switch (WireFormat.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.invalidWireType();
    case 0: 
      skipRawVarint();
      return true;
    case 1: 
      skipRawBytes(8);
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    skipRawBytes(4);
    return true;
  }
  
  public boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    long l;
    switch (WireFormat.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferException.invalidWireType();
    case 0: 
      l = readInt64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeUInt64NoTag(l);
      return true;
    case 1: 
      l = readRawLittleEndian64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeFixed64NoTag(l);
      return true;
    case 2: 
      ByteString localByteString = readBytes();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeBytesNoTag(localByteString);
      return true;
    case 3: 
      paramCodedOutputStream.writeRawVarint32(paramInt);
      skipMessage(paramCodedOutputStream);
      paramInt = WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4);
      checkLastTagWas(paramInt);
      paramCodedOutputStream.writeRawVarint32(paramInt);
      return true;
    case 4: 
      return false;
    }
    int i = readRawLittleEndian32();
    paramCodedOutputStream.writeRawVarint32(paramInt);
    paramCodedOutputStream.writeFixed32NoTag(i);
    return true;
  }
  
  public void skipMessage()
    throws IOException
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public void skipMessage(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i, paramCodedOutputStream)));
  }
  
  public void skipRawBytes(int paramInt)
    throws IOException
  {
    if ((paramInt <= this.bufferSize - this.bufferPos) && (paramInt >= 0))
    {
      this.bufferPos += paramInt;
      return;
    }
    skipRawBytesSlowPath(paramInt);
  }
  
  private static abstract interface RefillCallback
  {
    public abstract void onRefill();
  }
  
  private class SkippedDataSink
    implements CodedInputStream.RefillCallback
  {
    private ByteArrayOutputStream byteArrayStream;
    private int lastPos = CodedInputStream.this.bufferPos;
    
    private SkippedDataSink() {}
    
    ByteBuffer getSkippedData()
    {
      if (this.byteArrayStream == null) {
        return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      }
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
      return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
    
    public void onRefill()
    {
      if (this.byteArrayStream == null) {
        this.byteArrayStream = new ByteArrayOutputStream();
      }
      this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
      this.lastPos = 0;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/CodedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */