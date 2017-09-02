package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode
{
  private static final char[] hexDigits = "0123456789abcdef".toCharArray();
  
  private static int decode(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    throw new IllegalArgumentException("Illegal hexadecimal character: " + paramChar);
  }
  
  @CheckReturnValue
  public static HashCode fromBytes(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte.length >= 1) {}
    for (;;)
    {
      Preconditions.checkArgument(bool, "A HashCode must contain at least 1 byte.");
      return fromBytesNoCopy((byte[])paramArrayOfByte.clone());
      bool = false;
    }
  }
  
  static HashCode fromBytesNoCopy(byte[] paramArrayOfByte)
  {
    return new BytesHashCode(paramArrayOfByte);
  }
  
  @CheckReturnValue
  public static HashCode fromInt(int paramInt)
  {
    return new IntHashCode(paramInt);
  }
  
  @CheckReturnValue
  public static HashCode fromLong(long paramLong)
  {
    return new LongHashCode(paramLong);
  }
  
  @CheckReturnValue
  public static HashCode fromString(String paramString)
  {
    if (paramString.length() >= 2)
    {
      bool = true;
      Preconditions.checkArgument(bool, "input string (%s) must have at least 2 characters", new Object[] { paramString });
      if (paramString.length() % 2 != 0) {
        break label118;
      }
    }
    byte[] arrayOfByte;
    label118:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "input string (%s) must have an even number of characters", new Object[] { paramString });
      arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < paramString.length())
      {
        int j = decode(paramString.charAt(i));
        int k = decode(paramString.charAt(i + 1));
        arrayOfByte[(i / 2)] = ((byte)((j << 4) + k));
        i += 2;
      }
      bool = false;
      break;
    }
    return fromBytesNoCopy(arrayOfByte);
  }
  
  @CheckReturnValue
  public abstract byte[] asBytes();
  
  @CheckReturnValue
  public abstract int asInt();
  
  @CheckReturnValue
  public abstract long asLong();
  
  @CheckReturnValue
  public abstract int bits();
  
  public final boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof HashCode))
    {
      paramObject = (HashCode)paramObject;
      bool1 = bool2;
      if (bits() == ((HashCode)paramObject).bits())
      {
        bool1 = bool2;
        if (equalsSameBits((HashCode)paramObject)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  abstract boolean equalsSameBits(HashCode paramHashCode);
  
  byte[] getBytesInternal()
  {
    return asBytes();
  }
  
  public final int hashCode()
  {
    int k;
    if (bits() >= 32)
    {
      k = asInt();
      return k;
    }
    byte[] arrayOfByte = getBytesInternal();
    int i = arrayOfByte[0] & 0xFF;
    int j = 1;
    for (;;)
    {
      k = i;
      if (j >= arrayOfByte.length) {
        break;
      }
      i |= (arrayOfByte[j] & 0xFF) << j * 8;
      j += 1;
    }
  }
  
  @CheckReturnValue
  public abstract long padToLong();
  
  public final String toString()
  {
    byte[] arrayOfByte = getBytesInternal();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfByte[i];
      localStringBuilder.append(hexDigits[(k >> 4 & 0xF)]).append(hexDigits[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int writeBytesTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = Ints.min(new int[] { paramInt2, bits() / 8 });
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    writeBytesToImpl(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  abstract void writeBytesToImpl(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static final class BytesHashCode
    extends HashCode
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final byte[] bytes;
    
    BytesHashCode(byte[] paramArrayOfByte)
    {
      this.bytes = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    }
    
    public byte[] asBytes()
    {
      return (byte[])this.bytes.clone();
    }
    
    public int asInt()
    {
      if (this.bytes.length >= 4) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[] { Integer.valueOf(this.bytes.length) });
        return this.bytes[0] & 0xFF | (this.bytes[1] & 0xFF) << 8 | (this.bytes[2] & 0xFF) << 16 | (this.bytes[3] & 0xFF) << 24;
      }
    }
    
    public long asLong()
    {
      if (this.bytes.length >= 8) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", new Object[] { Integer.valueOf(this.bytes.length) });
        return padToLong();
      }
    }
    
    public int bits()
    {
      return this.bytes.length * 8;
    }
    
    boolean equalsSameBits(HashCode paramHashCode)
    {
      if (this.bytes.length != paramHashCode.getBytesInternal().length) {
        return false;
      }
      boolean bool2 = true;
      int i = 0;
      if (i < this.bytes.length)
      {
        if (this.bytes[i] == paramHashCode.getBytesInternal()[i]) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          bool2 &= bool1;
          i += 1;
          break;
        }
      }
      return bool2;
    }
    
    byte[] getBytesInternal()
    {
      return this.bytes;
    }
    
    public long padToLong()
    {
      long l = this.bytes[0] & 0xFF;
      int i = 1;
      while (i < Math.min(this.bytes.length, 8))
      {
        l |= (this.bytes[i] & 0xFF) << i * 8;
        i += 1;
      }
      return l;
    }
    
    void writeBytesToImpl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      System.arraycopy(this.bytes, 0, paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static final class IntHashCode
    extends HashCode
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final int hash;
    
    IntHashCode(int paramInt)
    {
      this.hash = paramInt;
    }
    
    public byte[] asBytes()
    {
      return new byte[] { (byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24) };
    }
    
    public int asInt()
    {
      return this.hash;
    }
    
    public long asLong()
    {
      throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }
    
    public int bits()
    {
      return 32;
    }
    
    boolean equalsSameBits(HashCode paramHashCode)
    {
      return this.hash == paramHashCode.asInt();
    }
    
    public long padToLong()
    {
      return UnsignedInts.toLong(this.hash);
    }
    
    void writeBytesToImpl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < paramInt2)
      {
        paramArrayOfByte[(paramInt1 + i)] = ((byte)(this.hash >> i * 8));
        i += 1;
      }
    }
  }
  
  private static final class LongHashCode
    extends HashCode
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final long hash;
    
    LongHashCode(long paramLong)
    {
      this.hash = paramLong;
    }
    
    public byte[] asBytes()
    {
      return new byte[] { (byte)(int)this.hash, (byte)(int)(this.hash >> 8), (byte)(int)(this.hash >> 16), (byte)(int)(this.hash >> 24), (byte)(int)(this.hash >> 32), (byte)(int)(this.hash >> 40), (byte)(int)(this.hash >> 48), (byte)(int)(this.hash >> 56) };
    }
    
    public int asInt()
    {
      return (int)this.hash;
    }
    
    public long asLong()
    {
      return this.hash;
    }
    
    public int bits()
    {
      return 64;
    }
    
    boolean equalsSameBits(HashCode paramHashCode)
    {
      return this.hash == paramHashCode.asLong();
    }
    
    public long padToLong()
    {
      return this.hash;
    }
    
    void writeBytesToImpl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < paramInt2)
      {
        paramArrayOfByte[(paramInt1 + i)] = ((byte)(int)(this.hash >> i * 8));
        i += 1;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/HashCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */