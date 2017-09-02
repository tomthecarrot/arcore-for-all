package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

final class Murmur3_32HashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private static final long serialVersionUID = 0L;
  private final int seed;
  
  Murmur3_32HashFunction(int paramInt)
  {
    this.seed = paramInt;
  }
  
  private static HashCode fmix(int paramInt1, int paramInt2)
  {
    paramInt1 ^= paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return HashCode.fromInt(paramInt1 ^ paramInt1 >>> 16);
  }
  
  private static int mixH1(int paramInt1, int paramInt2)
  {
    return Integer.rotateLeft(paramInt1 ^ paramInt2, 13) * 5 - 430675100;
  }
  
  private static int mixK1(int paramInt)
  {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  public int bits()
  {
    return 32;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Murmur3_32HashFunction))
    {
      paramObject = (Murmur3_32HashFunction)paramObject;
      bool1 = bool2;
      if (this.seed == ((Murmur3_32HashFunction)paramObject).seed) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return getClass().hashCode() ^ this.seed;
  }
  
  public HashCode hashInt(int paramInt)
  {
    paramInt = mixK1(paramInt);
    return fmix(mixH1(this.seed, paramInt), 4);
  }
  
  public HashCode hashLong(long paramLong)
  {
    int j = (int)paramLong;
    int i = (int)(paramLong >>> 32);
    j = mixK1(j);
    return fmix(mixH1(mixH1(this.seed, j), mixK1(i)), 8);
  }
  
  public HashCode hashUnencodedChars(CharSequence paramCharSequence)
  {
    int i = this.seed;
    int j = 1;
    while (j < paramCharSequence.length())
    {
      i = mixH1(i, mixK1(paramCharSequence.charAt(j - 1) | paramCharSequence.charAt(j) << '\020'));
      j += 2;
    }
    j = i;
    if ((paramCharSequence.length() & 0x1) == 1) {
      j = i ^ mixK1(paramCharSequence.charAt(paramCharSequence.length() - 1));
    }
    return fmix(j, paramCharSequence.length() * 2);
  }
  
  public Hasher newHasher()
  {
    return new Murmur3_32Hasher(this.seed);
  }
  
  public String toString()
  {
    return "Hashing.murmur3_32(" + this.seed + ")";
  }
  
  private static final class Murmur3_32Hasher
    extends AbstractStreamingHashFunction.AbstractStreamingHasher
  {
    private static final int CHUNK_SIZE = 4;
    private int h1;
    private int length;
    
    Murmur3_32Hasher(int paramInt)
    {
      super();
      this.h1 = paramInt;
      this.length = 0;
    }
    
    public HashCode makeHash()
    {
      return Murmur3_32HashFunction.fmix(this.h1, this.length);
    }
    
    protected void process(ByteBuffer paramByteBuffer)
    {
      int i = Murmur3_32HashFunction.mixK1(paramByteBuffer.getInt());
      this.h1 = Murmur3_32HashFunction.mixH1(this.h1, i);
      this.length += 4;
    }
    
    protected void processRemaining(ByteBuffer paramByteBuffer)
    {
      this.length += paramByteBuffer.remaining();
      int j = 0;
      int i = 0;
      while (paramByteBuffer.hasRemaining())
      {
        j ^= UnsignedBytes.toInt(paramByteBuffer.get()) << i;
        i += 8;
      }
      this.h1 ^= Murmur3_32HashFunction.mixK1(j);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/Murmur3_32HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */