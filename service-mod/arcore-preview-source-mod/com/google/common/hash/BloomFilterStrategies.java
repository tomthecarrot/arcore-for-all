package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;

 enum BloomFilterStrategies
  implements BloomFilter.Strategy
{
  MURMUR128_MITZ_32,  MURMUR128_MITZ_64;
  
  private BloomFilterStrategies() {}
  
  static final class BitArray
  {
    long bitCount;
    final long[] data;
    
    BitArray(long paramLong)
    {
      this(new long[Ints.checkedCast(LongMath.divide(paramLong, 64L, RoundingMode.CEILING))]);
    }
    
    BitArray(long[] paramArrayOfLong)
    {
      if (paramArrayOfLong.length > 0) {}
      long l;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "data length is zero!");
        this.data = paramArrayOfLong;
        l = 0L;
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          l += Long.bitCount(paramArrayOfLong[i]);
          i += 1;
        }
      }
      this.bitCount = l;
    }
    
    long bitCount()
    {
      return this.bitCount;
    }
    
    long bitSize()
    {
      return this.data.length * 64L;
    }
    
    BitArray copy()
    {
      return new BitArray((long[])this.data.clone());
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof BitArray))
      {
        paramObject = (BitArray)paramObject;
        return Arrays.equals(this.data, ((BitArray)paramObject).data);
      }
      return false;
    }
    
    boolean get(long paramLong)
    {
      return (this.data[((int)(paramLong >>> 6))] & 1L << (int)paramLong) != 0L;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.data);
    }
    
    void putAll(BitArray paramBitArray)
    {
      if (this.data.length == paramBitArray.data.length) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "BitArrays must be of equal length (%s != %s)", new Object[] { Integer.valueOf(this.data.length), Integer.valueOf(paramBitArray.data.length) });
        this.bitCount = 0L;
        int i = 0;
        while (i < this.data.length)
        {
          long[] arrayOfLong = this.data;
          arrayOfLong[i] |= paramBitArray.data[i];
          this.bitCount += Long.bitCount(this.data[i]);
          i += 1;
        }
      }
    }
    
    boolean set(long paramLong)
    {
      if (!get(paramLong))
      {
        long[] arrayOfLong = this.data;
        int i = (int)(paramLong >>> 6);
        arrayOfLong[i] |= 1L << (int)paramLong;
        this.bitCount += 1L;
        return true;
      }
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/BloomFilterStrategies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */