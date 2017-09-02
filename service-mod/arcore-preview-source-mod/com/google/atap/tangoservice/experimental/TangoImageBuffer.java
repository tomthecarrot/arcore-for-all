package com.google.atap.tangoservice.experimental;

import java.nio.ByteBuffer;

public class TangoImageBuffer
{
  public static final int DEPTH16 = 1144402265;
  public static final int RGBA_8888 = 1;
  public static final int RGB_888 = 3;
  public static final int YCRCB_420_SP = 17;
  public static final int YV12 = 842094169;
  public ByteBuffer data;
  public long exposureDurationNs;
  public int format;
  public long frameNumber;
  public int height;
  public int stride;
  public double timestamp;
  public int width;
  
  public TangoImageBuffer() {}
  
  public TangoImageBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, double paramDouble, int paramInt4, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.stride = paramInt3;
    this.frameNumber = paramLong;
    this.timestamp = paramDouble;
    this.format = paramInt4;
    this.data = paramByteBuffer;
    this.exposureDurationNs = 0L;
  }
  
  public TangoImageBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong1, double paramDouble, int paramInt4, ByteBuffer paramByteBuffer, long paramLong2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.stride = paramInt3;
    this.frameNumber = paramLong1;
    this.timestamp = paramDouble;
    this.format = paramInt4;
    this.data = paramByteBuffer;
    this.exposureDurationNs = paramLong2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/experimental/TangoImageBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */