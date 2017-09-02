package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcfx
{
  private int FP;
  private int FQ;
  private int FR;
  private int FS;
  private int FT;
  private int FU = Integer.MAX_VALUE;
  private int FV;
  private int FW = 64;
  private int FX = 67108864;
  private final byte[] buffer;
  
  private zzcfx(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.FP = paramInt1;
    this.FQ = (paramInt1 + paramInt2);
    this.FS = paramInt1;
  }
  
  public static int zzBu(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private void zzamV()
  {
    this.FQ += this.FR;
    int i = this.FQ;
    if (i > this.FU)
    {
      this.FR = (i - this.FU);
      this.FQ -= this.FR;
      return;
    }
    this.FR = 0;
  }
  
  public static zzcfx zzar(byte[] paramArrayOfByte)
  {
    return zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static long zzbq(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static zzcfx zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzcfx(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int getPosition()
  {
    return this.FS - this.FP;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = zzamR();
    if (i < 0) {
      throw zzcgf.zzang();
    }
    if (i == 0) {
      return zzcgj.Gu;
    }
    if (i > this.FQ - this.FS) {
      throw zzcgf.zzanf();
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, this.FS, arrayOfByte, 0, i);
    this.FS = (i + this.FS);
    return arrayOfByte;
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzamU());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzamT());
  }
  
  public String readString()
    throws IOException
  {
    int i = zzamR();
    if (i < 0) {
      throw zzcgf.zzang();
    }
    if (i > this.FQ - this.FS) {
      throw zzcgf.zzanf();
    }
    String str = new String(this.buffer, this.FS, i, zzcge.UTF_8);
    this.FS = (i + this.FS);
    return str;
  }
  
  public void zzBs(int paramInt)
    throws zzcgf
  {
    if (this.FT != paramInt) {
      throw zzcgf.zzanj();
    }
  }
  
  public boolean zzBt(int paramInt)
    throws IOException
  {
    switch (zzcgj.zzBN(paramInt))
    {
    default: 
      throw zzcgf.zzank();
    case 0: 
      zzamM();
      return true;
    case 1: 
      zzamU();
      return true;
    case 2: 
      zzBy(zzamR());
      return true;
    case 3: 
      zzamJ();
      zzBs(zzcgj.zzaf(zzcgj.zzBO(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzamT();
    return true;
  }
  
  public int zzBv(int paramInt)
    throws zzcgf
  {
    if (paramInt < 0) {
      throw zzcgf.zzang();
    }
    paramInt = this.FS + paramInt;
    int i = this.FU;
    if (paramInt > i) {
      throw zzcgf.zzanf();
    }
    this.FU = paramInt;
    zzamV();
    return i;
  }
  
  public void zzBw(int paramInt)
  {
    this.FU = paramInt;
    zzamV();
  }
  
  public void zzBx(int paramInt)
  {
    if (paramInt > this.FS - this.FP)
    {
      int i = this.FS;
      int j = this.FP;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    this.FS = (this.FP + paramInt);
  }
  
  public void zzBy(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzcgf.zzang();
    }
    if (this.FS + paramInt > this.FU)
    {
      zzBy(this.FU - this.FS);
      throw zzcgf.zzanf();
    }
    if (paramInt <= this.FQ - this.FS)
    {
      this.FS += paramInt;
      return;
    }
    throw zzcgf.zzanf();
  }
  
  public byte[] zzZ(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzcgj.Gu;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.FP;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public void zza(zzcgg paramzzcgg)
    throws IOException
  {
    int i = zzamR();
    if (this.FV >= this.FW) {
      throw zzcgf.zzanl();
    }
    i = zzBv(i);
    this.FV += 1;
    paramzzcgg.mergeFrom(this);
    zzBs(0);
    this.FV -= 1;
    zzBw(i);
  }
  
  public void zza(zzcgg paramzzcgg, int paramInt)
    throws IOException
  {
    if (this.FV >= this.FW) {
      throw zzcgf.zzanl();
    }
    this.FV += 1;
    paramzzcgg.mergeFrom(this);
    zzBs(zzcgj.zzaf(paramInt, 4));
    this.FV -= 1;
  }
  
  public int zzamI()
    throws IOException
  {
    if (zzamX())
    {
      this.FT = 0;
      return 0;
    }
    this.FT = zzamR();
    if (this.FT == 0) {
      throw zzcgf.zzani();
    }
    return this.FT;
  }
  
  public void zzamJ()
    throws IOException
  {
    int i;
    do
    {
      i = zzamI();
    } while ((i != 0) && (zzBt(i)));
  }
  
  public long zzamK()
    throws IOException
  {
    return zzamS();
  }
  
  public long zzamL()
    throws IOException
  {
    return zzamS();
  }
  
  public int zzamM()
    throws IOException
  {
    return zzamR();
  }
  
  public long zzamN()
    throws IOException
  {
    return zzamU();
  }
  
  public boolean zzamO()
    throws IOException
  {
    return zzamR() != 0;
  }
  
  public int zzamP()
    throws IOException
  {
    return zzBu(zzamR());
  }
  
  public long zzamQ()
    throws IOException
  {
    return zzbq(zzamS());
  }
  
  public int zzamR()
    throws IOException
  {
    int i = zzamY();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzamY();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzamY();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzamY();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzamY();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzamY() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzcgf.zzanh();
  }
  
  public long zzamS()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzamY();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzcgf.zzanh();
  }
  
  public int zzamT()
    throws IOException
  {
    return zzamY() & 0xFF | (zzamY() & 0xFF) << 8 | (zzamY() & 0xFF) << 16 | (zzamY() & 0xFF) << 24;
  }
  
  public long zzamU()
    throws IOException
  {
    int i = zzamY();
    int j = zzamY();
    int k = zzamY();
    int m = zzamY();
    int n = zzamY();
    int i1 = zzamY();
    int i2 = zzamY();
    int i3 = zzamY();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int zzamW()
  {
    if (this.FU == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.FS;
    return this.FU - i;
  }
  
  public boolean zzamX()
  {
    return this.FS == this.FQ;
  }
  
  public byte zzamY()
    throws IOException
  {
    if (this.FS == this.FQ) {
      throw zzcgf.zzanf();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.FS;
    this.FS = (i + 1);
    return arrayOfByte[i];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */