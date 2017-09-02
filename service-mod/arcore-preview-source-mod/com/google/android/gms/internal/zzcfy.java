package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzcfy
{
  private final ByteBuffer FY;
  
  private zzcfy(ByteBuffer paramByteBuffer)
  {
    this.FY = paramByteBuffer;
    this.FY.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzcfy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int zzBB(int paramInt)
  {
    if (paramInt >= 0) {
      return zzBG(paramInt);
    }
    return 10;
  }
  
  public static int zzBC(int paramInt)
  {
    return zzBG(zzBI(paramInt));
  }
  
  public static int zzBE(int paramInt)
  {
    return zzBG(zzcgj.zzaf(paramInt, 0));
  }
  
  public static int zzBG(int paramInt)
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
  
  public static int zzBI(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label444;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label444:
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  public static int zzac(int paramInt1, int paramInt2)
  {
    return zzBE(paramInt1) + zzBB(paramInt2);
  }
  
  public static int zzad(int paramInt1, int paramInt2)
  {
    return zzBE(paramInt1) + zzBC(paramInt2);
  }
  
  public static zzcfy zzas(byte[] paramArrayOfByte)
  {
    return zzd(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzau(byte[] paramArrayOfByte)
  {
    return zzBG(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzBE(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, zzcgg paramzzcgg)
  {
    return zzBE(paramInt) * 2 + zzd(paramzzcgg);
  }
  
  private static int zzb(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m)
        {
          long l = k;
          throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static long zzbB(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int zzbv(long paramLong)
  {
    return zzbz(paramLong);
  }
  
  public static int zzbw(long paramLong)
  {
    return zzbz(paramLong);
  }
  
  public static int zzbx(long paramLong)
  {
    return zzbz(zzbB(paramLong));
  }
  
  public static int zzbz(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static int zzc(int paramInt, zzcgg paramzzcgg)
  {
    return zzBE(paramInt) + zze(paramzzcgg);
  }
  
  public static int zzc(int paramInt, byte[] paramArrayOfByte)
  {
    return zzBE(paramInt) + zzau(paramArrayOfByte);
  }
  
  public static int zzd(int paramInt, float paramFloat)
  {
    return zzBE(paramInt) + 4;
  }
  
  public static int zzd(zzcgg paramzzcgg)
  {
    return paramzzcgg.zzann();
  }
  
  public static zzcfy zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzcfy(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zze(zzcgg paramzzcgg)
  {
    int i = paramzzcgg.zzann();
    return i + zzBG(i);
  }
  
  public static int zzi(int paramInt, long paramLong)
  {
    return zzBE(paramInt) + zzbv(paramLong);
  }
  
  public static int zzj(int paramInt, long paramLong)
  {
    return zzBE(paramInt) + zzbw(paramLong);
  }
  
  public static int zzk(int paramInt, long paramLong)
  {
    return zzBE(paramInt) + 8;
  }
  
  public static int zzl(int paramInt, long paramLong)
  {
    return zzBE(paramInt) + zzbx(paramLong);
  }
  
  public static int zzl(int paramInt, boolean paramBoolean)
  {
    return zzBE(paramInt) + 1;
  }
  
  public static int zzmU(String paramString)
  {
    int i = zzb(paramString);
    return i + zzBG(i);
  }
  
  public static int zzv(int paramInt, String paramString)
  {
    return zzBE(paramInt) + zzmU(paramString);
  }
  
  public void zzBA(int paramInt)
    throws IOException
  {
    zzBF(zzBI(paramInt));
  }
  
  public void zzBD(int paramInt)
    throws IOException
  {
    zzd((byte)paramInt);
  }
  
  public void zzBF(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzBD(paramInt);
        return;
      }
      zzBD(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void zzBH(int paramInt)
    throws IOException
  {
    if (this.FY.remaining() < 4) {
      throw new zza(this.FY.position(), this.FY.limit());
    }
    this.FY.putInt(paramInt);
  }
  
  public void zzBz(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzBF(paramInt);
      return;
    }
    zzby(paramInt);
  }
  
  public void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzae(paramInt, 1);
    zzr(paramDouble);
  }
  
  public void zza(int paramInt, zzcgg paramzzcgg)
    throws IOException
  {
    zzae(paramInt, 2);
    zzc(paramzzcgg);
  }
  
  public void zzaa(int paramInt1, int paramInt2)
    throws IOException
  {
    zzae(paramInt1, 0);
    zzBz(paramInt2);
  }
  
  public void zzab(int paramInt1, int paramInt2)
    throws IOException
  {
    zzae(paramInt1, 0);
    zzBA(paramInt2);
  }
  
  public void zzae(int paramInt1, int paramInt2)
    throws IOException
  {
    zzBF(zzcgj.zzaf(paramInt1, paramInt2));
  }
  
  public int zzamZ()
  {
    return this.FY.remaining();
  }
  
  public void zzana()
  {
    if (zzamZ() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void zzat(byte[] paramArrayOfByte)
    throws IOException
  {
    zzBF(paramArrayOfByte.length);
    zzav(paramArrayOfByte);
  }
  
  public void zzav(byte[] paramArrayOfByte)
    throws IOException
  {
    zze(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void zzb(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzae(paramInt, 2);
    zzat(paramArrayOfByte);
  }
  
  public void zzb(zzcgg paramzzcgg)
    throws IOException
  {
    paramzzcgg.writeTo(this);
  }
  
  public void zzbA(long paramLong)
    throws IOException
  {
    if (this.FY.remaining() < 8) {
      throw new zza(this.FY.position(), this.FY.limit());
    }
    this.FY.putLong(paramLong);
  }
  
  public void zzbr(long paramLong)
    throws IOException
  {
    zzby(paramLong);
  }
  
  public void zzbs(long paramLong)
    throws IOException
  {
    zzby(paramLong);
  }
  
  public void zzbt(long paramLong)
    throws IOException
  {
    zzbA(paramLong);
  }
  
  public void zzbu(long paramLong)
    throws IOException
  {
    zzby(zzbB(paramLong));
  }
  
  public void zzby(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzBD((int)paramLong);
        return;
      }
      zzBD((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void zzc(int paramInt, float paramFloat)
    throws IOException
  {
    zzae(paramInt, 5);
    zzj(paramFloat);
  }
  
  public void zzc(zzcgg paramzzcgg)
    throws IOException
  {
    zzBF(paramzzcgg.zzanm());
    paramzzcgg.writeTo(this);
  }
  
  public void zzcb(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzBD(i);
      return;
    }
  }
  
  public void zzd(byte paramByte)
    throws IOException
  {
    if (!this.FY.hasRemaining()) {
      throw new zza(this.FY.position(), this.FY.limit());
    }
    this.FY.put(paramByte);
  }
  
  public void zze(int paramInt, long paramLong)
    throws IOException
  {
    zzae(paramInt, 0);
    zzbr(paramLong);
  }
  
  public void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.FY.remaining() >= paramInt2)
    {
      this.FY.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zza(this.FY.position(), this.FY.limit());
  }
  
  public void zzf(int paramInt, long paramLong)
    throws IOException
  {
    zzae(paramInt, 0);
    zzbs(paramLong);
  }
  
  public void zzg(int paramInt, long paramLong)
    throws IOException
  {
    zzae(paramInt, 1);
    zzbt(paramLong);
  }
  
  public void zzh(int paramInt, long paramLong)
    throws IOException
  {
    zzae(paramInt, 0);
    zzbu(paramLong);
  }
  
  public void zzj(float paramFloat)
    throws IOException
  {
    zzBH(Float.floatToIntBits(paramFloat));
  }
  
  public void zzk(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzae(paramInt, 0);
    zzcb(paramBoolean);
  }
  
  public void zzmT(String paramString)
    throws IOException
  {
    int i;
    int j;
    try
    {
      i = zzBG(paramString.length());
      if (i != zzBG(paramString.length() * 3)) {
        break label150;
      }
      j = this.FY.position();
      if (this.FY.remaining() < i) {
        throw new zza(i + j, this.FY.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zza localzza = new zza(this.FY.position(), this.FY.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    this.FY.position(j + i);
    zza(paramString, this.FY);
    int k = this.FY.position();
    this.FY.position(j);
    zzBF(k - j - i);
    this.FY.position(k);
    return;
    label150:
    zzBF(zzb(paramString));
    zza(paramString, this.FY);
  }
  
  public void zzr(double paramDouble)
    throws IOException
  {
    zzbA(Double.doubleToLongBits(paramDouble));
  }
  
  public void zzu(int paramInt, String paramString)
    throws IOException
  {
    zzae(paramInt, 2);
    zzmT(paramString);
  }
  
  public static class zza
    extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */