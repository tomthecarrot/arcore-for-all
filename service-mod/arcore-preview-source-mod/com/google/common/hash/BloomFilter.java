package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter<T>
  implements Predicate<T>, Serializable
{
  private final BloomFilterStrategies.BitArray bits;
  private final Funnel<? super T> funnel;
  private final int numHashFunctions;
  private final Strategy strategy;
  
  private BloomFilter(BloomFilterStrategies.BitArray paramBitArray, int paramInt, Funnel<? super T> paramFunnel, Strategy paramStrategy)
  {
    if (paramInt > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "numHashFunctions (%s) must be > 0", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt > 255) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "numHashFunctions (%s) must be <= 255", new Object[] { Integer.valueOf(paramInt) });
      this.bits = ((BloomFilterStrategies.BitArray)Preconditions.checkNotNull(paramBitArray));
      this.numHashFunctions = paramInt;
      this.funnel = ((Funnel)Preconditions.checkNotNull(paramFunnel));
      this.strategy = ((Strategy)Preconditions.checkNotNull(paramStrategy));
      return;
      bool = false;
      break;
    }
  }
  
  @CheckReturnValue
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt)
  {
    return create(paramFunnel, paramInt);
  }
  
  @CheckReturnValue
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt, double paramDouble)
  {
    return create(paramFunnel, paramInt, paramDouble);
  }
  
  @CheckReturnValue
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong)
  {
    return create(paramFunnel, paramLong, 0.03D);
  }
  
  @CheckReturnValue
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble)
  {
    return create(paramFunnel, paramLong, paramDouble, BloomFilterStrategies.MURMUR128_MITZ_64);
  }
  
  @VisibleForTesting
  static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble, Strategy paramStrategy)
  {
    Preconditions.checkNotNull(paramFunnel);
    if (paramLong >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Expected insertions (%s) must be >= 0", new Object[] { Long.valueOf(paramLong) });
      if (paramDouble <= 0.0D) {
        break label148;
      }
      bool = true;
      label41:
      Preconditions.checkArgument(bool, "False positive probability (%s) must be > 0.0", new Object[] { Double.valueOf(paramDouble) });
      if (paramDouble >= 1.0D) {
        break label154;
      }
    }
    label148:
    label154:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "False positive probability (%s) must be < 1.0", new Object[] { Double.valueOf(paramDouble) });
      Preconditions.checkNotNull(paramStrategy);
      long l = paramLong;
      if (paramLong == 0L) {
        l = 1L;
      }
      paramLong = optimalNumOfBits(l, paramDouble);
      int i = optimalNumOfHashFunctions(l, paramLong);
      try
      {
        paramFunnel = new BloomFilter(new BloomFilterStrategies.BitArray(paramLong), i, paramFunnel, paramStrategy);
        return paramFunnel;
      }
      catch (IllegalArgumentException paramFunnel)
      {
        throw new IllegalArgumentException("Could not create BloomFilter of " + paramLong + " bits", paramFunnel);
      }
      bool = false;
      break;
      bool = false;
      break label41;
    }
  }
  
  @VisibleForTesting
  static long optimalNumOfBits(long paramLong, double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == 0.0D) {
      d = Double.MIN_VALUE;
    }
    return (-paramLong * Math.log(d) / (Math.log(2.0D) * Math.log(2.0D)));
  }
  
  @VisibleForTesting
  static int optimalNumOfHashFunctions(long paramLong1, long paramLong2)
  {
    return Math.max(1, (int)Math.round(paramLong2 / paramLong1 * Math.log(2.0D)));
  }
  
  @CheckReturnValue
  public static <T> BloomFilter<T> readFrom(InputStream paramInputStream, Funnel<T> paramFunnel)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream, "InputStream");
    Preconditions.checkNotNull(paramFunnel, "Funnel");
    int n = -1;
    int i1 = -1;
    int m = -1;
    int i = m;
    int j = i1;
    int k = n;
    try
    {
      paramInputStream = new DataInputStream(paramInputStream);
      i = m;
      j = i1;
      k = n;
      n = paramInputStream.readByte();
      i = m;
      j = i1;
      k = n;
      i1 = UnsignedBytes.toInt(paramInputStream.readByte());
      i = m;
      j = i1;
      k = n;
      int i2 = paramInputStream.readInt();
      i = i2;
      j = i1;
      k = n;
      BloomFilterStrategies localBloomFilterStrategies = BloomFilterStrategies.values()[n];
      i = i2;
      j = i1;
      k = n;
      long[] arrayOfLong = new long[i2];
      m = 0;
      for (;;)
      {
        i = i2;
        j = i1;
        k = n;
        if (m >= arrayOfLong.length) {
          break;
        }
        i = i2;
        j = i1;
        k = n;
        arrayOfLong[m] = paramInputStream.readLong();
        m += 1;
      }
      i = i2;
      j = i1;
      k = n;
      paramInputStream = new BloomFilter(new BloomFilterStrategies.BitArray(arrayOfLong), i1, paramFunnel, localBloomFilterStrategies);
      return paramInputStream;
    }
    catch (RuntimeException paramInputStream)
    {
      paramFunnel = new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + k + " numHashFunctions: " + j + " dataLength: " + i);
      paramFunnel.initCause(paramInputStream);
      throw paramFunnel;
    }
  }
  
  private Object writeReplace()
  {
    return new SerialForm(this);
  }
  
  @Deprecated
  @CheckReturnValue
  public boolean apply(T paramT)
  {
    return mightContain(paramT);
  }
  
  @VisibleForTesting
  long bitSize()
  {
    return this.bits.bitSize();
  }
  
  @CheckReturnValue
  public BloomFilter<T> copy()
  {
    return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BloomFilter)) {
        break;
      }
      paramObject = (BloomFilter)paramObject;
    } while ((this.numHashFunctions == ((BloomFilter)paramObject).numHashFunctions) && (this.funnel.equals(((BloomFilter)paramObject).funnel)) && (this.bits.equals(((BloomFilter)paramObject).bits)) && (this.strategy.equals(((BloomFilter)paramObject).strategy)));
    return false;
    return false;
  }
  
  @CheckReturnValue
  public double expectedFpp()
  {
    return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits });
  }
  
  @CheckReturnValue
  public boolean isCompatible(BloomFilter<T> paramBloomFilter)
  {
    Preconditions.checkNotNull(paramBloomFilter);
    return (this != paramBloomFilter) && (this.numHashFunctions == paramBloomFilter.numHashFunctions) && (bitSize() == paramBloomFilter.bitSize()) && (this.strategy.equals(paramBloomFilter.strategy)) && (this.funnel.equals(paramBloomFilter.funnel));
  }
  
  @CheckReturnValue
  public boolean mightContain(T paramT)
  {
    return this.strategy.mightContain(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  public boolean put(T paramT)
  {
    return this.strategy.put(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  public void putAll(BloomFilter<T> paramBloomFilter)
  {
    Preconditions.checkNotNull(paramBloomFilter);
    if (this != paramBloomFilter)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Cannot combine a BloomFilter with itself.");
      if (this.numHashFunctions != paramBloomFilter.numHashFunctions) {
        break label195;
      }
      bool = true;
      label32:
      Preconditions.checkArgument(bool, "BloomFilters must have the same number of hash functions (%s != %s)", new Object[] { Integer.valueOf(this.numHashFunctions), Integer.valueOf(paramBloomFilter.numHashFunctions) });
      if (bitSize() != paramBloomFilter.bitSize()) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "BloomFilters must have the same size underlying bit arrays (%s != %s)", new Object[] { Long.valueOf(bitSize()), Long.valueOf(paramBloomFilter.bitSize()) });
      Preconditions.checkArgument(this.strategy.equals(paramBloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", new Object[] { this.strategy, paramBloomFilter.strategy });
      Preconditions.checkArgument(this.funnel.equals(paramBloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", new Object[] { this.funnel, paramBloomFilter.funnel });
      this.bits.putAll(paramBloomFilter.bits);
      return;
      bool = false;
      break;
      bool = false;
      break label32;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
    paramOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
    paramOutputStream.writeInt(this.bits.data.length);
    long[] arrayOfLong = this.bits.data;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramOutputStream.writeLong(arrayOfLong[i]);
      i += 1;
    }
  }
  
  private static class SerialForm<T>
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    final long[] data;
    final Funnel<? super T> funnel;
    final int numHashFunctions;
    final BloomFilter.Strategy strategy;
    
    SerialForm(BloomFilter<T> paramBloomFilter)
    {
      this.data = paramBloomFilter.bits.data;
      this.numHashFunctions = paramBloomFilter.numHashFunctions;
      this.funnel = paramBloomFilter.funnel;
      this.strategy = paramBloomFilter.strategy;
    }
    
    Object readResolve()
    {
      return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
    }
  }
  
  static abstract interface Strategy
    extends Serializable
  {
    public abstract <T> boolean mightContain(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
    
    public abstract int ordinal();
    
    public abstract <T> boolean put(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/BloomFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */