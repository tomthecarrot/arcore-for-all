package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzboz
{
  public static final class zza
    extends zzcfz<zza>
  {
    public long timeStamp;
    public zzaj.zzj zzcBs;
    public zzaj.zzf zzlq;
    
    public zza()
    {
      zzaal();
    }
    
    public static zza zzab(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zza)zzcgg.zza(new zza(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize() + zzcfy.zzj(1, this.timeStamp);
      int i = j;
      if (this.zzlq != null) {
        i = j + zzcfy.zzc(2, this.zzlq);
      }
      j = i;
      if (this.zzcBs != null) {
        j = i + zzcfy.zzc(3, this.zzcBs);
      }
      return j;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label55:
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (this.timeStamp != ((zza)paramObject).timeStamp);
          if (this.zzlq != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzlq != null);
        if (this.zzcBs != null) {
          break label125;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzcBs != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zza)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zza)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzlq.equals(((zza)paramObject).zzlq)) {
            break label55;
          }
          return false;
          label125:
          if (!this.zzcBs.equals(((zza)paramObject).zzcBs)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zza)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = (int)(this.timeStamp ^ this.timeStamp >>> 32);
      int i;
      int j;
      if (this.zzlq == null)
      {
        i = 0;
        if (this.zzcBs != null) {
          break label110;
        }
        j = 0;
        label48:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label121;
          }
        }
      }
      label110:
      label121:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzlq.hashCode();
        break;
        j = this.zzcBs.hashCode();
        break label48;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      paramzzcfy.zzf(1, this.timeStamp);
      if (this.zzlq != null) {
        paramzzcfy.zza(2, this.zzlq);
      }
      if (this.zzcBs != null) {
        paramzzcfy.zza(3, this.zzcBs);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzZ(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.timeStamp = paramzzcfx.zzamL();
          break;
        case 18: 
          if (this.zzlq == null) {
            this.zzlq = new zzaj.zzf();
          }
          paramzzcfx.zza(this.zzlq);
          break;
        case 26: 
          if (this.zzcBs == null) {
            this.zzcBs = new zzaj.zzj();
          }
          paramzzcfx.zza(this.zzcBs);
        }
      }
    }
    
    public zza zzaal()
    {
      this.timeStamp = 0L;
      this.zzlq = null;
      this.zzcBs = null;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzboz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */