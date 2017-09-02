package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzcgg
{
  protected volatile int Gi = -1;
  
  public static final <T extends zzcgg> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzcgf
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzcgg paramzzcgg, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzcfy.zzd(paramArrayOfByte, paramInt1, paramInt2);
      paramzzcgg.writeTo(paramArrayOfByte);
      paramArrayOfByte.zzana();
      return;
    }
    catch (IOException paramzzcgg)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzcgg);
    }
  }
  
  public static final <T extends zzcgg> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzcgf
  {
    try
    {
      paramArrayOfByte = zzcfx.zzc(paramArrayOfByte, paramInt1, paramInt2);
      paramT.mergeFrom(paramArrayOfByte);
      paramArrayOfByte.zzBs(0);
      return paramT;
    }
    catch (zzcgf paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] zzf(zzcgg paramzzcgg)
  {
    byte[] arrayOfByte = new byte[paramzzcgg.zzann()];
    zza(paramzzcgg, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  protected int computeSerializedSize()
  {
    return 0;
  }
  
  public abstract zzcgg mergeFrom(zzcfx paramzzcfx)
    throws IOException;
  
  public String toString()
  {
    return zzcgh.zzg(this);
  }
  
  public void writeTo(zzcfy paramzzcfy)
    throws IOException
  {}
  
  public zzcgg zzanc()
    throws CloneNotSupportedException
  {
    return (zzcgg)super.clone();
  }
  
  public int zzanm()
  {
    if (this.Gi < 0) {
      zzann();
    }
    return this.Gi;
  }
  
  public int zzann()
  {
    int i = computeSerializedSize();
    this.Gi = i;
    return i;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */