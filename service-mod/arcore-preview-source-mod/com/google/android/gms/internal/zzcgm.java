package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzcgm
{
  public static final class zza
    extends zzcfz<zza>
  {
    private static volatile zza[] Hd;
    public long He;
    public long Hf;
    
    public zza()
    {
      zzanD();
    }
    
    public static zza[] zzanC()
    {
      if (Hd == null) {}
      synchronized (zzcge.Gh)
      {
        if (Hd == null) {
          Hd = new zza[0];
        }
        return Hd;
      }
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.He != 0L) {
        i = j + zzcfy.zzj(1, this.He);
      }
      j = i;
      if (this.Hf != 0L) {
        j = i + zzcfy.zzj(2, this.Hf);
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
          } while (this.He != ((zza)paramObject).He);
          bool1 = bool2;
        } while (this.Hf != ((zza)paramObject).Hf);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label91;
        }
        if (((zza)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).FZ.isEmpty());
      return true;
      label91:
      return this.FZ.equals(((zza)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = (int)(this.He ^ this.He >>> 32);
      int m = (int)(this.Hf ^ this.Hf >>> 32);
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.He != 0L) {
        paramzzcfy.zzf(1, this.He);
      }
      if (this.Hf != 0L) {
        paramzzcfy.zzf(2, this.Hf);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzanD()
    {
      this.He = 0L;
      this.Hf = 0L;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zza zzbl(zzcfx paramzzcfx)
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
          this.He = paramzzcfx.zzamL();
          break;
        case 16: 
          this.Hf = paramzzcfx.zzamL();
        }
      }
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
  {
    private static volatile zzb[] Hg;
    public long Hh;
    public zzcgm.zza[] Hi;
    public String name;
    
    public zzb()
    {
      zzanF();
    }
    
    public static zzb[] zzanE()
    {
      if (Hg == null) {}
      synchronized (zzcge.Gh)
      {
        if (Hg == null) {
          Hg = new zzb[0];
        }
        return Hg;
      }
    }
    
    protected int computeSerializedSize()
    {
      int i = super.computeSerializedSize();
      int j = i;
      if (this.Hh != 0L) {
        j = i + zzcfy.zzk(1, this.Hh);
      }
      i = j;
      if (this.name != null)
      {
        i = j;
        if (!this.name.equals("")) {
          i = j + zzcfy.zzv(2, this.name);
        }
      }
      j = i;
      if (this.Hi != null)
      {
        j = i;
        if (this.Hi.length > 0)
        {
          j = 0;
          while (j < this.Hi.length)
          {
            zzcgm.zza localzza = this.Hi[j];
            int k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(3, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
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
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          bool1 = bool2;
        } while (this.Hh != ((zzb)paramObject).Hh);
        if (this.name != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).name != null);
      while (this.name.equals(((zzb)paramObject).name))
      {
        bool1 = bool2;
        if (!zzcge.equals(this.Hi, ((zzb)paramObject).Hi)) {
          break;
        }
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label125;
        }
        if (((zzb)paramObject).FZ != null)
        {
          bool1 = bool2;
          if (!((zzb)paramObject).FZ.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label125:
      return this.FZ.equals(((zzb)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int n = (int)(this.Hh ^ this.Hh >>> 32);
      int i;
      int i1;
      if (this.name == null)
      {
        i = 0;
        i1 = zzcge.hashCode(this.Hi);
        j = k;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label108;
          }
        }
      }
      label108:
      for (int j = k;; j = this.FZ.hashCode())
      {
        return ((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + j;
        i = this.name.hashCode();
        break;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.Hh != 0L) {
        paramzzcfy.zzg(1, this.Hh);
      }
      if ((this.name != null) && (!this.name.equals(""))) {
        paramzzcfy.zzu(2, this.name);
      }
      if ((this.Hi != null) && (this.Hi.length > 0))
      {
        int i = 0;
        while (i < this.Hi.length)
        {
          zzcgm.zza localzza = this.Hi[i];
          if (localzza != null) {
            paramzzcfy.zza(3, localzza);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzanF()
    {
      this.Hh = 0L;
      this.name = "";
      this.Hi = zzcgm.zza.zzanC();
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzb zzbm(zzcfx paramzzcfx)
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
        case 9: 
          this.Hh = paramzzcfx.zzamN();
          break;
        case 18: 
          this.name = paramzzcfx.readString();
          break;
        case 26: 
          int j = zzcgj.zzb(paramzzcfx, 26);
          if (this.Hi == null) {}
          zzcgm.zza[] arrayOfzza;
          for (i = 0;; i = this.Hi.length)
          {
            arrayOfzza = new zzcgm.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Hi, 0, arrayOfzza, 0, i);
              j = i;
            }
            while (j < arrayOfzza.length - 1)
            {
              arrayOfzza[j] = new zzcgm.zza();
              paramzzcfx.zza(arrayOfzza[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfzza[j] = new zzcgm.zza();
          paramzzcfx.zza(arrayOfzza[j]);
          this.Hi = arrayOfzza;
        }
      }
    }
  }
  
  public static final class zzc
    extends zzcfz<zzc>
  {
    public long Hj;
    public zzcgm.zzb[] Hk;
    public byte[] Hl;
    public String Hm;
    public String Hn;
    public long zzcHt;
    
    public zzc()
    {
      zzanG();
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.Hj != 0L) {
        i = j + zzcfy.zzj(1, this.Hj);
      }
      j = i;
      if (this.Hk != null)
      {
        j = i;
        if (this.Hk.length > 0)
        {
          j = 0;
          while (j < this.Hk.length)
          {
            zzcgm.zzb localzzb = this.Hk[j];
            int k = i;
            if (localzzb != null) {
              k = i + zzcfy.zzc(2, localzzb);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(this.Hl, zzcgj.Gu)) {
        i = j + zzcfy.zzc(3, this.Hl);
      }
      j = i;
      if (this.zzcHt != 0L) {
        j = i + zzcfy.zzj(4, this.zzcHt);
      }
      i = j;
      if (this.Hm != null)
      {
        i = j;
        if (!this.Hm.equals("")) {
          i = j + zzcfy.zzv(5, this.Hm);
        }
      }
      j = i;
      if (this.Hn != null)
      {
        j = i;
        if (!this.Hn.equals("")) {
          j = i + zzcfy.zzv(6, this.Hn);
        }
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
      label101:
      do
      {
        do
        {
          do
          {
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
                  } while (!(paramObject instanceof zzc));
                  paramObject = (zzc)paramObject;
                  bool1 = bool2;
                } while (this.Hj != ((zzc)paramObject).Hj);
                bool1 = bool2;
              } while (this.zzcHt != ((zzc)paramObject).zzcHt);
              bool1 = bool2;
            } while (!zzcge.equals(this.Hk, ((zzc)paramObject).Hk));
            bool1 = bool2;
          } while (!Arrays.equals(this.Hl, ((zzc)paramObject).Hl));
          if (this.Hm != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzc)paramObject).Hm != null);
        if (this.Hn != null) {
          break label171;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).Hn != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zzc)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zzc)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.Hm.equals(((zzc)paramObject).Hm)) {
            break label101;
          }
          return false;
          label171:
          if (!this.Hn.equals(((zzc)paramObject).Hn)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zzc)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = (int)(this.Hj ^ this.Hj >>> 32);
      int i2 = (int)(this.zzcHt ^ this.zzcHt >>> 32);
      int i3 = zzcge.hashCode(this.Hk);
      int i4 = Arrays.hashCode(this.Hl);
      int i;
      int j;
      if (this.Hm == null)
      {
        i = 0;
        if (this.Hn != null) {
          break label161;
        }
        j = 0;
        label81:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label172;
          }
        }
      }
      label161:
      label172:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + (i + (((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31) * 31 + k;
        i = this.Hm.hashCode();
        break;
        j = this.Hn.hashCode();
        break label81;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.Hj != 0L) {
        paramzzcfy.zzf(1, this.Hj);
      }
      if ((this.Hk != null) && (this.Hk.length > 0))
      {
        int i = 0;
        while (i < this.Hk.length)
        {
          zzcgm.zzb localzzb = this.Hk[i];
          if (localzzb != null) {
            paramzzcfy.zza(2, localzzb);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(this.Hl, zzcgj.Gu)) {
        paramzzcfy.zzb(3, this.Hl);
      }
      if (this.zzcHt != 0L) {
        paramzzcfy.zzf(4, this.zzcHt);
      }
      if ((this.Hm != null) && (!this.Hm.equals(""))) {
        paramzzcfy.zzu(5, this.Hm);
      }
      if ((this.Hn != null) && (!this.Hn.equals(""))) {
        paramzzcfy.zzu(6, this.Hn);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzc zzanG()
    {
      this.Hj = 0L;
      this.zzcHt = 0L;
      this.Hk = zzcgm.zzb.zzanE();
      this.Hl = zzcgj.Gu;
      this.Hm = "";
      this.Hn = "";
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzc zzbn(zzcfx paramzzcfx)
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
          this.Hj = paramzzcfx.zzamL();
          break;
        case 18: 
          int j = zzcgj.zzb(paramzzcfx, 18);
          if (this.Hk == null) {}
          zzcgm.zzb[] arrayOfzzb;
          for (i = 0;; i = this.Hk.length)
          {
            arrayOfzzb = new zzcgm.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Hk, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzcgm.zzb();
              paramzzcfx.zza(arrayOfzzb[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzcgm.zzb();
          paramzzcfx.zza(arrayOfzzb[j]);
          this.Hk = arrayOfzzb;
          break;
        case 26: 
          this.Hl = paramzzcfx.readBytes();
          break;
        case 32: 
          this.zzcHt = paramzzcfx.zzamL();
          break;
        case 42: 
          this.Hm = paramzzcfx.readString();
          break;
        case 50: 
          this.Hn = paramzzcfx.readString();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */