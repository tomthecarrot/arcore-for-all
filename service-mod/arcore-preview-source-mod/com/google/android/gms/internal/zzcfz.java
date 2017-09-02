package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzcfz<M extends zzcfz<M>>
  extends zzcgg
{
  protected zzcgc FZ;
  
  private void zza(int paramInt, zzcgi paramzzcgi)
  {
    zzcgd localzzcgd1 = null;
    if (this.FZ == null) {
      this.FZ = new zzcgc();
    }
    for (;;)
    {
      zzcgd localzzcgd2 = localzzcgd1;
      if (localzzcgd1 == null)
      {
        localzzcgd2 = new zzcgd();
        this.FZ.zza(paramInt, localzzcgd2);
      }
      localzzcgd2.zza(paramzzcgi);
      return;
      localzzcgd1 = this.FZ.zzBJ(paramInt);
    }
  }
  
  protected int computeSerializedSize()
  {
    int j = 0;
    if (this.FZ != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.FZ.size()) {
          break;
        }
        i += this.FZ.zzBK(j).computeSerializedSize();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void writeTo(zzcfy paramzzcfy)
    throws IOException
  {
    if (this.FZ == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.FZ.size())
      {
        this.FZ.zzBK(i).writeTo(paramzzcfy);
        i += 1;
      }
    }
  }
  
  public final <T> T zza(zzcga<M, T> paramzzcga)
  {
    if (this.FZ == null) {}
    zzcgd localzzcgd;
    do
    {
      return null;
      localzzcgd = this.FZ.zzBJ(zzcgj.zzBO(paramzzcga.tag));
    } while (localzzcgd == null);
    return (T)localzzcgd.zzb(paramzzcga);
  }
  
  protected final boolean zza(zzcfx paramzzcfx, int paramInt)
    throws IOException
  {
    int i = paramzzcfx.getPosition();
    if (!paramzzcfx.zzBt(paramInt)) {
      return false;
    }
    zza(zzcgj.zzBO(paramInt), new zzcgi(paramInt, paramzzcfx.zzZ(i, paramzzcfx.getPosition() - i)));
    return true;
  }
  
  public M zzanb()
    throws CloneNotSupportedException
  {
    zzcfz localzzcfz = (zzcfz)super.zzanc();
    zzcge.zza(this, localzzcfz);
    return localzzcfz;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */