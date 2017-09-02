package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

final class SipHashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final int c;
  private final int d;
  private final long k0;
  private final long k1;
  
  SipHashFunction(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (paramInt1 > 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "The number of SipRound iterations (c=%s) during Compression must be positive.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt2 <= 0) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The number of SipRound iterations (d=%s) during Finalization must be positive.", new Object[] { Integer.valueOf(paramInt2) });
      this.c = paramInt1;
      this.d = paramInt2;
      this.k0 = paramLong1;
      this.k1 = paramLong2;
      return;
      bool = false;
      break;
    }
  }
  
  public int bits()
  {
    return 64;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof SipHashFunction))
    {
      paramObject = (SipHashFunction)paramObject;
      bool1 = bool2;
      if (this.c == ((SipHashFunction)paramObject).c)
      {
        bool1 = bool2;
        if (this.d == ((SipHashFunction)paramObject).d)
        {
          bool1 = bool2;
          if (this.k0 == ((SipHashFunction)paramObject).k0)
          {
            bool1 = bool2;
            if (this.k1 == ((SipHashFunction)paramObject).k1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (int)(getClass().hashCode() ^ this.c ^ this.d ^ this.k0 ^ this.k1);
  }
  
  public Hasher newHasher()
  {
    return new SipHasher(this.c, this.d, this.k0, this.k1);
  }
  
  public String toString()
  {
    return "Hashing.sipHash" + this.c + "" + this.d + "(" + this.k0 + ", " + this.k1 + ")";
  }
  
  private static final class SipHasher
    extends AbstractStreamingHashFunction.AbstractStreamingHasher
  {
    private static final int CHUNK_SIZE = 8;
    private long b = 0L;
    private final int c;
    private final int d;
    private long finalM = 0L;
    private long v0 = 8317987319222330741L;
    private long v1 = 7237128888997146477L;
    private long v2 = 7816392313619706465L;
    private long v3 = 8387220255154660723L;
    
    SipHasher(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      super();
      this.c = paramInt1;
      this.d = paramInt2;
      this.v0 ^= paramLong1;
      this.v1 ^= paramLong2;
      this.v2 ^= paramLong1;
      this.v3 ^= paramLong2;
    }
    
    private void processM(long paramLong)
    {
      this.v3 ^= paramLong;
      sipRound(this.c);
      this.v0 ^= paramLong;
    }
    
    private void sipRound(int paramInt)
    {
      int i = 0;
      while (i < paramInt)
      {
        this.v0 += this.v1;
        this.v2 += this.v3;
        this.v1 = Long.rotateLeft(this.v1, 13);
        this.v3 = Long.rotateLeft(this.v3, 16);
        this.v1 ^= this.v0;
        this.v3 ^= this.v2;
        this.v0 = Long.rotateLeft(this.v0, 32);
        this.v2 += this.v1;
        this.v0 += this.v3;
        this.v1 = Long.rotateLeft(this.v1, 17);
        this.v3 = Long.rotateLeft(this.v3, 21);
        this.v1 ^= this.v2;
        this.v3 ^= this.v0;
        this.v2 = Long.rotateLeft(this.v2, 32);
        i += 1;
      }
    }
    
    public HashCode makeHash()
    {
      this.finalM ^= this.b << 56;
      processM(this.finalM);
      this.v2 ^= 0xFF;
      sipRound(this.d);
      return HashCode.fromLong(this.v0 ^ this.v1 ^ this.v2 ^ this.v3);
    }
    
    protected void process(ByteBuffer paramByteBuffer)
    {
      this.b += 8L;
      processM(paramByteBuffer.getLong());
    }
    
    protected void processRemaining(ByteBuffer paramByteBuffer)
    {
      this.b += paramByteBuffer.remaining();
      int i = 0;
      while (paramByteBuffer.hasRemaining())
      {
        this.finalM ^= (paramByteBuffer.get() & 0xFF) << i;
        i += 8;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/SipHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */