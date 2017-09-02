package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzcgn
{
  public static final class zza
    extends zzcfz<zza>
  {
    private static volatile zza[] Ho;
    public String Hp;
    
    public zza()
    {
      zzanI();
    }
    
    public static zza[] zzanH()
    {
      if (Ho == null) {}
      synchronized (zzcge.Gh)
      {
        if (Ho == null) {
          Ho = new zza[0];
        }
        return Ho;
      }
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.Hp != null)
      {
        i = j;
        if (!this.Hp.equals("")) {
          i = j + zzcfy.zzv(1, this.Hp);
        }
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.Hp != null) && (!this.Hp.equals(""))) {
        paramzzcfy.zzu(1, this.Hp);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzanI()
    {
      this.Hp = "";
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zza zzbo(zzcfx paramzzcfx)
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
        case 10: 
          this.Hp = paramzzcfx.readString();
        }
      }
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
  {
    public int HA;
    public zzcgn.zza[] HB;
    public String Hp;
    public String Hq;
    public long Hr;
    public String Hs;
    public int Ht;
    public int Hu;
    public String Hv;
    public String Hw;
    public String Hx;
    public String Hy;
    public String Hz;
    
    public zzb()
    {
      zzanJ();
    }
    
    public static zzb zzaw(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zzb)zzcgg.zza(new zzb(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.Hp != null)
      {
        i = j;
        if (!this.Hp.equals("")) {
          i = j + zzcfy.zzv(1, this.Hp);
        }
      }
      j = i;
      if (this.Hq != null)
      {
        j = i;
        if (!this.Hq.equals("")) {
          j = i + zzcfy.zzv(2, this.Hq);
        }
      }
      i = j;
      if (this.Hr != 0L) {
        i = j + zzcfy.zzj(3, this.Hr);
      }
      j = i;
      if (this.Hs != null)
      {
        j = i;
        if (!this.Hs.equals("")) {
          j = i + zzcfy.zzv(4, this.Hs);
        }
      }
      i = j;
      if (this.Ht != 0) {
        i = j + zzcfy.zzac(5, this.Ht);
      }
      j = i;
      if (this.Hu != 0) {
        j = i + zzcfy.zzac(6, this.Hu);
      }
      i = j;
      if (this.Hv != null)
      {
        i = j;
        if (!this.Hv.equals("")) {
          i = j + zzcfy.zzv(7, this.Hv);
        }
      }
      j = i;
      if (this.Hw != null)
      {
        j = i;
        if (!this.Hw.equals("")) {
          j = i + zzcfy.zzv(8, this.Hw);
        }
      }
      i = j;
      if (this.Hx != null)
      {
        i = j;
        if (!this.Hx.equals("")) {
          i = j + zzcfy.zzv(9, this.Hx);
        }
      }
      j = i;
      if (this.Hy != null)
      {
        j = i;
        if (!this.Hy.equals("")) {
          j = i + zzcfy.zzv(10, this.Hy);
        }
      }
      int k = j;
      if (this.Hz != null)
      {
        k = j;
        if (!this.Hz.equals("")) {
          k = j + zzcfy.zzv(11, this.Hz);
        }
      }
      i = k;
      if (this.HA != 0) {
        i = k + zzcfy.zzac(12, this.HA);
      }
      j = i;
      if (this.HB != null)
      {
        j = i;
        if (this.HB.length > 0)
        {
          j = 0;
          while (j < this.HB.length)
          {
            zzcgn.zza localzza = this.HB[j];
            k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(13, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.Hp != null) && (!this.Hp.equals(""))) {
        paramzzcfy.zzu(1, this.Hp);
      }
      if ((this.Hq != null) && (!this.Hq.equals(""))) {
        paramzzcfy.zzu(2, this.Hq);
      }
      if (this.Hr != 0L) {
        paramzzcfy.zzf(3, this.Hr);
      }
      if ((this.Hs != null) && (!this.Hs.equals(""))) {
        paramzzcfy.zzu(4, this.Hs);
      }
      if (this.Ht != 0) {
        paramzzcfy.zzaa(5, this.Ht);
      }
      if (this.Hu != 0) {
        paramzzcfy.zzaa(6, this.Hu);
      }
      if ((this.Hv != null) && (!this.Hv.equals(""))) {
        paramzzcfy.zzu(7, this.Hv);
      }
      if ((this.Hw != null) && (!this.Hw.equals(""))) {
        paramzzcfy.zzu(8, this.Hw);
      }
      if ((this.Hx != null) && (!this.Hx.equals(""))) {
        paramzzcfy.zzu(9, this.Hx);
      }
      if ((this.Hy != null) && (!this.Hy.equals(""))) {
        paramzzcfy.zzu(10, this.Hy);
      }
      if ((this.Hz != null) && (!this.Hz.equals(""))) {
        paramzzcfy.zzu(11, this.Hz);
      }
      if (this.HA != 0) {
        paramzzcfy.zzaa(12, this.HA);
      }
      if ((this.HB != null) && (this.HB.length > 0))
      {
        int i = 0;
        while (i < this.HB.length)
        {
          zzcgn.zza localzza = this.HB[i];
          if (localzza != null) {
            paramzzcfy.zza(13, localzza);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzanJ()
    {
      this.Hp = "";
      this.Hq = "";
      this.Hr = 0L;
      this.Hs = "";
      this.Ht = 0;
      this.Hu = 0;
      this.Hv = "";
      this.Hw = "";
      this.Hx = "";
      this.Hy = "";
      this.Hz = "";
      this.HA = 0;
      this.HB = zzcgn.zza.zzanH();
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzb zzbp(zzcfx paramzzcfx)
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
        case 10: 
          this.Hp = paramzzcfx.readString();
          break;
        case 18: 
          this.Hq = paramzzcfx.readString();
          break;
        case 24: 
          this.Hr = paramzzcfx.zzamL();
          break;
        case 34: 
          this.Hs = paramzzcfx.readString();
          break;
        case 40: 
          this.Ht = paramzzcfx.zzamM();
          break;
        case 48: 
          this.Hu = paramzzcfx.zzamM();
          break;
        case 58: 
          this.Hv = paramzzcfx.readString();
          break;
        case 66: 
          this.Hw = paramzzcfx.readString();
          break;
        case 74: 
          this.Hx = paramzzcfx.readString();
          break;
        case 82: 
          this.Hy = paramzzcfx.readString();
          break;
        case 90: 
          this.Hz = paramzzcfx.readString();
          break;
        case 96: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            this.HA = i;
          }
          break;
        case 106: 
          int j = zzcgj.zzb(paramzzcfx, 106);
          if (this.HB == null) {}
          zzcgn.zza[] arrayOfzza;
          for (i = 0;; i = this.HB.length)
          {
            arrayOfzza = new zzcgn.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.HB, 0, arrayOfzza, 0, i);
              j = i;
            }
            while (j < arrayOfzza.length - 1)
            {
              arrayOfzza[j] = new zzcgn.zza();
              paramzzcfx.zza(arrayOfzza[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfzza[j] = new zzcgn.zza();
          paramzzcfx.zza(arrayOfzza[j]);
          this.HB = arrayOfzza;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */