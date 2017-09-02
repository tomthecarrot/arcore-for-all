package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(Buffer paramBuffer, int paramInt)
  {
    super(null);
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramInt);
    int j = 0;
    int i = 0;
    for (Segment localSegment = paramBuffer.head; j < paramInt; localSegment = localSegment.next)
    {
      if (localSegment.limit == localSegment.pos) {
        throw new AssertionError("s.limit == s.pos");
      }
      j += localSegment.limit - localSegment.pos;
      i += 1;
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    j = 0;
    i = 0;
    for (paramBuffer = paramBuffer.head; j < paramInt; paramBuffer = paramBuffer.next)
    {
      this.segments[i] = paramBuffer.data;
      j += paramBuffer.limit - paramBuffer.pos;
      this.directory[i] = j;
      this.directory[(this.segments.length + i)] = paramBuffer.pos;
      paramBuffer.shared = true;
      i += 1;
    }
  }
  
  private int segment(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private ByteString toByteString()
  {
    return new ByteString(toByteArray());
  }
  
  private Object writeReplace()
  {
    return toByteString();
  }
  
  public String base64()
  {
    return toByteString().base64();
  }
  
  public String base64Url()
  {
    return toByteString().base64Url();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ByteString)) && (((ByteString)paramObject).size() == size()) && (rangeEquals(0, (ByteString)paramObject, 0, size()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte getByte(int paramInt)
  {
    Util.checkOffsetAndCount(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = segment(paramInt);
    if (j == 0) {}
    for (int i = 0;; i = this.directory[(j - 1)])
    {
      int k = this.directory[(this.segments.length + j)];
      return this.segments[j][(paramInt - i + k)];
    }
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    int k = 1;
    int j = 0;
    i = 0;
    int i2 = this.segments.length;
    while (i < i2)
    {
      byte[] arrayOfByte = this.segments[i];
      int n = this.directory[(i2 + i)];
      int i1 = this.directory[i];
      int m = n;
      while (m < n + (i1 - j))
      {
        k = k * 31 + arrayOfByte[m];
        m += 1;
      }
      j = i1;
      i += 1;
    }
    this.hashCode = k;
    return k;
  }
  
  public String hex()
  {
    return toByteString().hex();
  }
  
  public ByteString md5()
  {
    return toByteString().md5();
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    if (paramInt1 > size() - paramInt3) {
      return false;
    }
    int j = segment(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label26:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, j + (this.directory[paramInt1] - j) - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!paramByteString.rangeEquals(paramInt2, this.segments[paramInt1], i - j + m, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label26;
      }
    }
    return true;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > size() - paramInt3) || (paramInt2 > paramArrayOfByte.length - paramInt3)) {
      return false;
    }
    int j = segment(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label35:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, j + (this.directory[paramInt1] - j) - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!Util.arrayRangeEquals(this.segments[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label35;
      }
    }
    return true;
  }
  
  public ByteString sha256()
  {
    return toByteString().sha256();
  }
  
  public int size()
  {
    return this.directory[(this.segments.length - 1)];
  }
  
  public ByteString substring(int paramInt)
  {
    return toByteString().substring(paramInt);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    return toByteString().substring(paramInt1, paramInt2);
  }
  
  public ByteString toAsciiLowercase()
  {
    return toByteString().toAsciiLowercase();
  }
  
  public ByteString toAsciiUppercase()
  {
    return toByteString().toAsciiUppercase();
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.directory[(this.segments.length - 1)]];
    int j = 0;
    int i = 0;
    int m = this.segments.length;
    while (i < m)
    {
      int n = this.directory[(m + i)];
      int k = this.directory[i];
      System.arraycopy(this.segments[i], n, arrayOfByte, j, k - j);
      j = k;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public String toString()
  {
    return toByteString().toString();
  }
  
  public String utf8()
  {
    return toByteString().utf8();
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    int j = 0;
    int i = 0;
    int m = this.segments.length;
    while (i < m)
    {
      int n = this.directory[(m + i)];
      int k = this.directory[i];
      paramOutputStream.write(this.segments[i], n, k - j);
      j = k;
      i += 1;
    }
  }
  
  void write(Buffer paramBuffer)
  {
    int j = 0;
    int i = 0;
    int m = this.segments.length;
    if (i < m)
    {
      int n = this.directory[(m + i)];
      int k = this.directory[i];
      Segment localSegment = new Segment(this.segments[i], n, n + k - j);
      if (paramBuffer.head == null)
      {
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        paramBuffer.head = localSegment;
      }
      for (;;)
      {
        j = k;
        i += 1;
        break;
        paramBuffer.head.prev.push(localSegment);
      }
    }
    paramBuffer.size += j;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/SegmentedByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */