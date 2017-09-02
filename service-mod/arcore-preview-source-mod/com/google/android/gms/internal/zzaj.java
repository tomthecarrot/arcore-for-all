package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzaj
{
  public static final class zza
    extends zzcfz<zza>
  {
    public int level;
    public int zzkm;
    public int zzkn;
    
    public zza()
    {
      zzv();
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.level != 1) {
        i = j + zzcfy.zzac(1, this.level);
      }
      j = i;
      if (this.zzkm != 0) {
        j = i + zzcfy.zzac(2, this.zzkm);
      }
      i = j;
      if (this.zzkn != 0) {
        i = j + zzcfy.zzac(3, this.zzkn);
      }
      return i;
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (this.level != ((zza)paramObject).level);
            bool1 = bool2;
          } while (this.zzkm != ((zza)paramObject).zzkm);
          bool1 = bool2;
        } while (this.zzkn != ((zza)paramObject).zzkn);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label102;
        }
        if (((zza)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).FZ.isEmpty());
      return true;
      label102:
      return this.FZ.equals(((zza)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.level;
      int m = this.zzkm;
      int n = this.zzkn;
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.level != 1) {
        paramzzcfy.zzaa(1, this.level);
      }
      if (this.zzkm != 0) {
        paramzzcfy.zzaa(2, this.zzkm);
      }
      if (this.zzkn != 0) {
        paramzzcfy.zzaa(3, this.zzkn);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzm(zzcfx paramzzcfx)
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
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
            this.level = i;
          }
          break;
        case 16: 
          this.zzkm = paramzzcfx.zzamM();
          break;
        case 24: 
          this.zzkn = paramzzcfx.zzamM();
        }
      }
    }
    
    public zza zzv()
    {
      this.level = 1;
      this.zzkm = 0;
      this.zzkn = 0;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
  {
    private static volatile zzb[] zzko;
    public int name;
    public int[] zzkp;
    public int zzkq;
    public boolean zzkr;
    public boolean zzks;
    
    public zzb()
    {
      zzx();
    }
    
    public static zzb[] zzw()
    {
      if (zzko == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzko == null) {
          zzko = new zzb[0];
        }
        return zzko;
      }
    }
    
    protected int computeSerializedSize()
    {
      int j = 0;
      int k = super.computeSerializedSize();
      int i = k;
      if (this.zzks) {
        i = k + zzcfy.zzl(1, this.zzks);
      }
      k = zzcfy.zzac(2, this.zzkq) + i;
      if ((this.zzkp != null) && (this.zzkp.length > 0))
      {
        i = 0;
        while (i < this.zzkp.length)
        {
          j += zzcfy.zzBB(this.zzkp[i]);
          i += 1;
        }
      }
      for (j = k + j + this.zzkp.length * 1;; j = k)
      {
        i = j;
        if (this.name != 0) {
          i = j + zzcfy.zzac(4, this.name);
        }
        j = i;
        if (this.zzkr) {
          j = i + zzcfy.zzl(6, this.zzkr);
        }
        return j;
      }
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
                } while (!zzcge.equals(this.zzkp, ((zzb)paramObject).zzkp));
                bool1 = bool2;
              } while (this.zzkq != ((zzb)paramObject).zzkq);
              bool1 = bool2;
            } while (this.name != ((zzb)paramObject).name);
            bool1 = bool2;
          } while (this.zzkr != ((zzb)paramObject).zzkr);
          bool1 = bool2;
        } while (this.zzks != ((zzb)paramObject).zzks);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label131;
        }
        if (((zzb)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzb)paramObject).FZ.isEmpty());
      return true;
      label131:
      return this.FZ.equals(((zzb)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = 1231;
      int m = getClass().getName().hashCode();
      int n = zzcge.hashCode(this.zzkp);
      int i1 = this.zzkq;
      int i2 = this.name;
      int i;
      if (this.zzkr)
      {
        i = 1231;
        if (!this.zzks) {
          break label121;
        }
        label55:
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label128;
        }
      }
      label121:
      label128:
      for (int k = 0;; k = this.FZ.hashCode())
      {
        return k + ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j) * 31;
        i = 1237;
        break;
        j = 1237;
        break label55;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzks) {
        paramzzcfy.zzk(1, this.zzks);
      }
      paramzzcfy.zzaa(2, this.zzkq);
      if ((this.zzkp != null) && (this.zzkp.length > 0))
      {
        int i = 0;
        while (i < this.zzkp.length)
        {
          paramzzcfy.zzaa(3, this.zzkp[i]);
          i += 1;
        }
      }
      if (this.name != 0) {
        paramzzcfy.zzaa(4, this.name);
      }
      if (this.zzkr) {
        paramzzcfy.zzk(6, this.zzkr);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzn(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzks = paramzzcfx.zzamO();
          break;
        case 16: 
          this.zzkq = paramzzcfx.zzamM();
          break;
        case 24: 
          j = zzcgj.zzb(paramzzcfx, 24);
          if (this.zzkp == null) {}
          for (i = 0;; i = this.zzkp.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkp, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkp = arrayOfInt;
          break;
        case 26: 
          int k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkp == null) {}
          for (i = 0;; i = this.zzkp.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkp, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkp = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 32: 
          this.name = paramzzcfx.zzamM();
          break;
        case 48: 
          this.zzkr = paramzzcfx.zzamO();
        }
      }
    }
    
    public zzb zzx()
    {
      this.zzkp = zzcgj.Gn;
      this.zzkq = 0;
      this.name = 0;
      this.zzkr = false;
      this.zzks = false;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
  }
  
  public static final class zzc
    extends zzcfz<zzc>
  {
    private static volatile zzc[] zzkt;
    public String zzaA;
    public long zzku;
    public long zzkv;
    public boolean zzkw;
    public long zzkx;
    
    public zzc()
    {
      zzz();
    }
    
    public static zzc[] zzy()
    {
      if (zzkt == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzkt == null) {
          zzkt = new zzc[0];
        }
        return zzkt;
      }
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzaA != null)
      {
        i = j;
        if (!this.zzaA.equals("")) {
          i = j + zzcfy.zzv(1, this.zzaA);
        }
      }
      j = i;
      if (this.zzku != 0L) {
        j = i + zzcfy.zzj(2, this.zzku);
      }
      i = j;
      if (this.zzkv != 2147483647L) {
        i = j + zzcfy.zzj(3, this.zzkv);
      }
      j = i;
      if (this.zzkw) {
        j = i + zzcfy.zzl(4, this.zzkw);
      }
      i = j;
      if (this.zzkx != 0L) {
        i = j + zzcfy.zzj(5, this.zzkx);
      }
      return i;
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        if (this.zzaA != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).zzaA != null);
      while (this.zzaA.equals(((zzc)paramObject).zzaA))
      {
        bool1 = bool2;
        if (this.zzku != ((zzc)paramObject).zzku) {
          break;
        }
        bool1 = bool2;
        if (this.zzkv != ((zzc)paramObject).zzkv) {
          break;
        }
        bool1 = bool2;
        if (this.zzkw != ((zzc)paramObject).zzkw) {
          break;
        }
        bool1 = bool2;
        if (this.zzkx != ((zzc)paramObject).zzkx) {
          break;
        }
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label150;
        }
        if (((zzc)paramObject).FZ != null)
        {
          bool1 = bool2;
          if (!((zzc)paramObject).FZ.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label150:
      return this.FZ.equals(((zzc)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int i1;
      int i2;
      int j;
      label65:
      int i3;
      if (this.zzaA == null)
      {
        i = 0;
        i1 = (int)(this.zzku ^ this.zzku >>> 32);
        i2 = (int)(this.zzkv ^ this.zzkv >>> 32);
        if (!this.zzkw) {
          break label154;
        }
        j = 1231;
        i3 = (int)(this.zzkx ^ this.zzkx >>> 32);
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label161;
          }
        }
      }
      label154:
      label161:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return ((j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + k;
        i = this.zzaA.hashCode();
        break;
        j = 1237;
        break label65;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.zzaA != null) && (!this.zzaA.equals(""))) {
        paramzzcfy.zzu(1, this.zzaA);
      }
      if (this.zzku != 0L) {
        paramzzcfy.zzf(2, this.zzku);
      }
      if (this.zzkv != 2147483647L) {
        paramzzcfy.zzf(3, this.zzkv);
      }
      if (this.zzkw) {
        paramzzcfy.zzk(4, this.zzkw);
      }
      if (this.zzkx != 0L) {
        paramzzcfy.zzf(5, this.zzkx);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzc zzo(zzcfx paramzzcfx)
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
          this.zzaA = paramzzcfx.readString();
          break;
        case 16: 
          this.zzku = paramzzcfx.zzamL();
          break;
        case 24: 
          this.zzkv = paramzzcfx.zzamL();
          break;
        case 32: 
          this.zzkw = paramzzcfx.zzamO();
          break;
        case 40: 
          this.zzkx = paramzzcfx.zzamL();
        }
      }
    }
    
    public zzc zzz()
    {
      this.zzaA = "";
      this.zzku = 0L;
      this.zzkv = 2147483647L;
      this.zzkw = false;
      this.zzkx = 0L;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
  }
  
  public static final class zzd
    extends zzcfz<zzd>
  {
    public zzaj.zzc[] zzkA;
    public zzak.zza[] zzky;
    public zzak.zza[] zzkz;
    
    public zzd()
    {
      zzA();
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int i = super.computeSerializedSize();
      int j = i;
      Object localObject;
      if (this.zzky != null)
      {
        j = i;
        if (this.zzky.length > 0)
        {
          j = 0;
          while (j < this.zzky.length)
          {
            localObject = this.zzky[j];
            k = i;
            if (localObject != null) {
              k = i + zzcfy.zzc(1, (zzcgg)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzkz != null)
      {
        i = j;
        if (this.zzkz.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzkz.length)
          {
            localObject = this.zzkz[j];
            k = i;
            if (localObject != null) {
              k = i + zzcfy.zzc(2, (zzcgg)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (this.zzkA != null)
      {
        k = i;
        if (this.zzkA.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.zzkA.length) {
              break;
            }
            localObject = this.zzkA[j];
            k = i;
            if (localObject != null) {
              k = i + zzcfy.zzc(3, (zzcgg)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zzd));
              paramObject = (zzd)paramObject;
              bool1 = bool2;
            } while (!zzcge.equals(this.zzky, ((zzd)paramObject).zzky));
            bool1 = bool2;
          } while (!zzcge.equals(this.zzkz, ((zzd)paramObject).zzkz));
          bool1 = bool2;
        } while (!zzcge.equals(this.zzkA, ((zzd)paramObject).zzkA));
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label111;
        }
        if (((zzd)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzd)paramObject).FZ.isEmpty());
      return true;
      label111:
      return this.FZ.equals(((zzd)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzcge.hashCode(this.zzky);
      int m = zzcge.hashCode(this.zzkz);
      int n = zzcge.hashCode(this.zzkA);
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzky != null) && (this.zzky.length > 0))
      {
        i = 0;
        while (i < this.zzky.length)
        {
          localObject = this.zzky[i];
          if (localObject != null) {
            paramzzcfy.zza(1, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkz != null) && (this.zzkz.length > 0))
      {
        i = 0;
        while (i < this.zzkz.length)
        {
          localObject = this.zzkz[i];
          if (localObject != null) {
            paramzzcfy.zza(2, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkA != null) && (this.zzkA.length > 0))
      {
        i = j;
        while (i < this.zzkA.length)
        {
          localObject = this.zzkA[i];
          if (localObject != null) {
            paramzzcfy.zza(3, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzd zzA()
    {
      this.zzky = zzak.zza.zzK();
      this.zzkz = zzak.zza.zzK();
      this.zzkA = zzaj.zzc.zzy();
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzd zzp(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzcgj.zzb(paramzzcfx, 10);
          if (this.zzky == null) {}
          for (i = 0;; i = this.zzky.length)
          {
            localObject = new zzak.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzky, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzak.zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzak.zza();
          paramzzcfx.zza(localObject[j]);
          this.zzky = ((zzak.zza[])localObject);
          break;
        case 18: 
          j = zzcgj.zzb(paramzzcfx, 18);
          if (this.zzkz == null) {}
          for (i = 0;; i = this.zzkz.length)
          {
            localObject = new zzak.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkz, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzak.zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzak.zza();
          paramzzcfx.zza(localObject[j]);
          this.zzkz = ((zzak.zza[])localObject);
          break;
        case 26: 
          j = zzcgj.zzb(paramzzcfx, 26);
          if (this.zzkA == null) {}
          for (i = 0;; i = this.zzkA.length)
          {
            localObject = new zzaj.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkA, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zzc();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zzc();
          paramzzcfx.zza(localObject[j]);
          this.zzkA = ((zzaj.zzc[])localObject);
        }
      }
    }
  }
  
  public static final class zze
    extends zzcfz<zze>
  {
    private static volatile zze[] zzkB;
    public int key;
    public int value;
    
    public zze()
    {
      zzC();
    }
    
    public static zze[] zzB()
    {
      if (zzkB == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzkB == null) {
          zzkB = new zze[0];
        }
        return zzkB;
      }
    }
    
    protected int computeSerializedSize()
    {
      return super.computeSerializedSize() + zzcfy.zzac(1, this.key) + zzcfy.zzac(2, this.value);
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
            } while (!(paramObject instanceof zze));
            paramObject = (zze)paramObject;
            bool1 = bool2;
          } while (this.key != ((zze)paramObject).key);
          bool1 = bool2;
        } while (this.value != ((zze)paramObject).value);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label89;
        }
        if (((zze)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zze)paramObject).FZ.isEmpty());
      return true;
      label89:
      return this.FZ.equals(((zze)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.key;
      int m = this.value;
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      paramzzcfy.zzaa(1, this.key);
      paramzzcfy.zzaa(2, this.value);
      super.writeTo(paramzzcfy);
    }
    
    public zze zzC()
    {
      this.key = 0;
      this.value = 0;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zze zzq(zzcfx paramzzcfx)
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
          this.key = paramzzcfx.zzamM();
          break;
        case 16: 
          this.value = paramzzcfx.zzamM();
        }
      }
    }
  }
  
  public static final class zzf
    extends zzcfz<zzf>
  {
    public String version;
    public String[] zzkC;
    public String[] zzkD;
    public zzak.zza[] zzkE;
    public zzaj.zze[] zzkF;
    public zzaj.zzb[] zzkG;
    public zzaj.zzb[] zzkH;
    public zzaj.zzb[] zzkI;
    public zzaj.zzg[] zzkJ;
    public String zzkK;
    public String zzkL;
    public String zzkM;
    public zzaj.zza zzkN;
    public float zzkO;
    public boolean zzkP;
    public String[] zzkQ;
    public int zzkR;
    
    public zzf()
    {
      zzD();
    }
    
    public static zzf zzf(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zzf)zzcgg.zza(new zzf(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int i2 = 0;
      int i1 = super.computeSerializedSize();
      int i;
      int k;
      Object localObject;
      int n;
      int m;
      if ((this.zzkD != null) && (this.zzkD.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.zzkD.length; k = m)
        {
          localObject = this.zzkD[i];
          n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + zzcfy.zzmU((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      for (int j = i1 + j + k * 1;; j = i1)
      {
        i = j;
        if (this.zzkE != null)
        {
          i = j;
          if (this.zzkE.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzkE.length)
            {
              localObject = this.zzkE[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(2, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzkF != null)
        {
          j = i;
          if (this.zzkF.length > 0)
          {
            j = 0;
            while (j < this.zzkF.length)
            {
              localObject = this.zzkF[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(3, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzkG != null)
        {
          i = j;
          if (this.zzkG.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzkG.length)
            {
              localObject = this.zzkG[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(4, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzkH != null)
        {
          j = i;
          if (this.zzkH.length > 0)
          {
            j = 0;
            while (j < this.zzkH.length)
            {
              localObject = this.zzkH[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(5, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzkI != null)
        {
          i = j;
          if (this.zzkI.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzkI.length)
            {
              localObject = this.zzkI[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(6, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzkJ != null)
        {
          j = i;
          if (this.zzkJ.length > 0)
          {
            j = 0;
            while (j < this.zzkJ.length)
            {
              localObject = this.zzkJ[j];
              k = i;
              if (localObject != null) {
                k = i + zzcfy.zzc(7, (zzcgg)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzkK != null)
        {
          i = j;
          if (!this.zzkK.equals("")) {
            i = j + zzcfy.zzv(9, this.zzkK);
          }
        }
        j = i;
        if (this.zzkL != null)
        {
          j = i;
          if (!this.zzkL.equals("")) {
            j = i + zzcfy.zzv(10, this.zzkL);
          }
        }
        i = j;
        if (this.zzkM != null)
        {
          i = j;
          if (!this.zzkM.equals("0")) {
            i = j + zzcfy.zzv(12, this.zzkM);
          }
        }
        j = i;
        if (this.version != null)
        {
          j = i;
          if (!this.version.equals("")) {
            j = i + zzcfy.zzv(13, this.version);
          }
        }
        k = j;
        if (this.zzkN != null) {
          k = j + zzcfy.zzc(14, this.zzkN);
        }
        i = k;
        if (Float.floatToIntBits(this.zzkO) != Float.floatToIntBits(0.0F)) {
          i = k + zzcfy.zzd(15, this.zzkO);
        }
        j = i;
        if (this.zzkQ != null)
        {
          j = i;
          if (this.zzkQ.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.zzkQ.length; m = n)
            {
              localObject = this.zzkQ[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zzcfy.zzmU((String)localObject);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 2;
          }
        }
        k = j;
        if (this.zzkR != 0) {
          k = j + zzcfy.zzac(17, this.zzkR);
        }
        i = k;
        if (this.zzkP) {
          i = k + zzcfy.zzl(18, this.zzkP);
        }
        j = i;
        if (this.zzkC != null)
        {
          j = i;
          if (this.zzkC.length > 0)
          {
            k = 0;
            m = 0;
            j = i2;
            while (j < this.zzkC.length)
            {
              localObject = this.zzkC[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zzcfy.zzmU((String)localObject);
              }
              j += 1;
              k = i1;
              m = n;
            }
            j = i + k + m * 2;
          }
        }
        return j;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label169:
      label185:
      label201:
      label217:
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
                                } while (!(paramObject instanceof zzf));
                                paramObject = (zzf)paramObject;
                                bool1 = bool2;
                              } while (!zzcge.equals(this.zzkC, ((zzf)paramObject).zzkC));
                              bool1 = bool2;
                            } while (!zzcge.equals(this.zzkD, ((zzf)paramObject).zzkD));
                            bool1 = bool2;
                          } while (!zzcge.equals(this.zzkE, ((zzf)paramObject).zzkE));
                          bool1 = bool2;
                        } while (!zzcge.equals(this.zzkF, ((zzf)paramObject).zzkF));
                        bool1 = bool2;
                      } while (!zzcge.equals(this.zzkG, ((zzf)paramObject).zzkG));
                      bool1 = bool2;
                    } while (!zzcge.equals(this.zzkH, ((zzf)paramObject).zzkH));
                    bool1 = bool2;
                  } while (!zzcge.equals(this.zzkI, ((zzf)paramObject).zzkI));
                  bool1 = bool2;
                } while (!zzcge.equals(this.zzkJ, ((zzf)paramObject).zzkJ));
                if (this.zzkK != null) {
                  break;
                }
                bool1 = bool2;
              } while (((zzf)paramObject).zzkK != null);
              if (this.zzkL != null) {
                break label348;
              }
              bool1 = bool2;
            } while (((zzf)paramObject).zzkL != null);
            if (this.zzkM != null) {
              break label364;
            }
            bool1 = bool2;
          } while (((zzf)paramObject).zzkM != null);
          if (this.version != null) {
            break label380;
          }
          bool1 = bool2;
        } while (((zzf)paramObject).version != null);
        if (this.zzkN != null) {
          break label396;
        }
        bool1 = bool2;
      } while (((zzf)paramObject).zzkN != null);
      label348:
      label364:
      label380:
      label396:
      while (this.zzkN.equals(((zzf)paramObject).zzkN))
      {
        bool1 = bool2;
        if (Float.floatToIntBits(this.zzkO) != Float.floatToIntBits(((zzf)paramObject).zzkO)) {
          break;
        }
        bool1 = bool2;
        if (this.zzkP != ((zzf)paramObject).zzkP) {
          break;
        }
        bool1 = bool2;
        if (!zzcge.equals(this.zzkQ, ((zzf)paramObject).zzkQ)) {
          break;
        }
        bool1 = bool2;
        if (this.zzkR != ((zzf)paramObject).zzkR) {
          break;
        }
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label412;
        }
        if (((zzf)paramObject).FZ != null)
        {
          bool1 = bool2;
          if (!((zzf)paramObject).FZ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.zzkK.equals(((zzf)paramObject).zzkK)) {
          break label169;
        }
        return false;
        if (this.zzkL.equals(((zzf)paramObject).zzkL)) {
          break label185;
        }
        return false;
        if (this.zzkM.equals(((zzf)paramObject).zzkM)) {
          break label201;
        }
        return false;
        if (this.version.equals(((zzf)paramObject).version)) {
          break label217;
        }
        return false;
      }
      return false;
      label412:
      return this.FZ.equals(((zzf)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i5 = zzcge.hashCode(this.zzkC);
      int i6 = zzcge.hashCode(this.zzkD);
      int i7 = zzcge.hashCode(this.zzkE);
      int i8 = zzcge.hashCode(this.zzkF);
      int i9 = zzcge.hashCode(this.zzkG);
      int i10 = zzcge.hashCode(this.zzkH);
      int i11 = zzcge.hashCode(this.zzkI);
      int i12 = zzcge.hashCode(this.zzkJ);
      int i;
      int j;
      label105:
      int k;
      label114:
      int m;
      label124:
      int n;
      label134:
      int i13;
      int i1;
      label155:
      int i14;
      int i15;
      if (this.zzkK == null)
      {
        i = 0;
        if (this.zzkL != null) {
          break label318;
        }
        j = 0;
        if (this.zzkM != null) {
          break label329;
        }
        k = 0;
        if (this.version != null) {
          break label340;
        }
        m = 0;
        if (this.zzkN != null) {
          break label352;
        }
        n = 0;
        i13 = Float.floatToIntBits(this.zzkO);
        if (!this.zzkP) {
          break label364;
        }
        i1 = 1231;
        i14 = zzcge.hashCode(this.zzkQ);
        i15 = this.zzkR;
        i2 = i3;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label372;
          }
        }
      }
      label318:
      label329:
      label340:
      label352:
      label364:
      label372:
      for (int i2 = i3;; i2 = this.FZ.hashCode())
      {
        return (((i1 + ((n + (m + (k + (j + (i + (((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i2;
        i = this.zzkK.hashCode();
        break;
        j = this.zzkL.hashCode();
        break label105;
        k = this.zzkM.hashCode();
        break label114;
        m = this.version.hashCode();
        break label124;
        n = this.zzkN.hashCode();
        break label134;
        i1 = 1237;
        break label155;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzkD != null) && (this.zzkD.length > 0))
      {
        i = 0;
        while (i < this.zzkD.length)
        {
          localObject = this.zzkD[i];
          if (localObject != null) {
            paramzzcfy.zzu(1, (String)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkE != null) && (this.zzkE.length > 0))
      {
        i = 0;
        while (i < this.zzkE.length)
        {
          localObject = this.zzkE[i];
          if (localObject != null) {
            paramzzcfy.zza(2, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkF != null) && (this.zzkF.length > 0))
      {
        i = 0;
        while (i < this.zzkF.length)
        {
          localObject = this.zzkF[i];
          if (localObject != null) {
            paramzzcfy.zza(3, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkG != null) && (this.zzkG.length > 0))
      {
        i = 0;
        while (i < this.zzkG.length)
        {
          localObject = this.zzkG[i];
          if (localObject != null) {
            paramzzcfy.zza(4, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkH != null) && (this.zzkH.length > 0))
      {
        i = 0;
        while (i < this.zzkH.length)
        {
          localObject = this.zzkH[i];
          if (localObject != null) {
            paramzzcfy.zza(5, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkI != null) && (this.zzkI.length > 0))
      {
        i = 0;
        while (i < this.zzkI.length)
        {
          localObject = this.zzkI[i];
          if (localObject != null) {
            paramzzcfy.zza(6, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkJ != null) && (this.zzkJ.length > 0))
      {
        i = 0;
        while (i < this.zzkJ.length)
        {
          localObject = this.zzkJ[i];
          if (localObject != null) {
            paramzzcfy.zza(7, (zzcgg)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzkK != null) && (!this.zzkK.equals(""))) {
        paramzzcfy.zzu(9, this.zzkK);
      }
      if ((this.zzkL != null) && (!this.zzkL.equals(""))) {
        paramzzcfy.zzu(10, this.zzkL);
      }
      if ((this.zzkM != null) && (!this.zzkM.equals("0"))) {
        paramzzcfy.zzu(12, this.zzkM);
      }
      if ((this.version != null) && (!this.version.equals(""))) {
        paramzzcfy.zzu(13, this.version);
      }
      if (this.zzkN != null) {
        paramzzcfy.zza(14, this.zzkN);
      }
      if (Float.floatToIntBits(this.zzkO) != Float.floatToIntBits(0.0F)) {
        paramzzcfy.zzc(15, this.zzkO);
      }
      if ((this.zzkQ != null) && (this.zzkQ.length > 0))
      {
        i = 0;
        while (i < this.zzkQ.length)
        {
          localObject = this.zzkQ[i];
          if (localObject != null) {
            paramzzcfy.zzu(16, (String)localObject);
          }
          i += 1;
        }
      }
      if (this.zzkR != 0) {
        paramzzcfy.zzaa(17, this.zzkR);
      }
      if (this.zzkP) {
        paramzzcfy.zzk(18, this.zzkP);
      }
      if ((this.zzkC != null) && (this.zzkC.length > 0))
      {
        i = j;
        while (i < this.zzkC.length)
        {
          localObject = this.zzkC[i];
          if (localObject != null) {
            paramzzcfy.zzu(19, (String)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzf zzD()
    {
      this.zzkC = zzcgj.Gs;
      this.zzkD = zzcgj.Gs;
      this.zzkE = zzak.zza.zzK();
      this.zzkF = zzaj.zze.zzB();
      this.zzkG = zzaj.zzb.zzw();
      this.zzkH = zzaj.zzb.zzw();
      this.zzkI = zzaj.zzb.zzw();
      this.zzkJ = zzaj.zzg.zzE();
      this.zzkK = "";
      this.zzkL = "";
      this.zzkM = "0";
      this.version = "";
      this.zzkN = null;
      this.zzkO = 0.0F;
      this.zzkP = false;
      this.zzkQ = zzcgj.Gs;
      this.zzkR = 0;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzf zzr(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzcgj.zzb(paramzzcfx, 10);
          if (this.zzkD == null) {}
          for (i = 0;; i = this.zzkD.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkD, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.readString();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.readString();
          this.zzkD = ((String[])localObject);
          break;
        case 18: 
          j = zzcgj.zzb(paramzzcfx, 18);
          if (this.zzkE == null) {}
          for (i = 0;; i = this.zzkE.length)
          {
            localObject = new zzak.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkE, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzak.zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzak.zza();
          paramzzcfx.zza(localObject[j]);
          this.zzkE = ((zzak.zza[])localObject);
          break;
        case 26: 
          j = zzcgj.zzb(paramzzcfx, 26);
          if (this.zzkF == null) {}
          for (i = 0;; i = this.zzkF.length)
          {
            localObject = new zzaj.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkF, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zze();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zze();
          paramzzcfx.zza(localObject[j]);
          this.zzkF = ((zzaj.zze[])localObject);
          break;
        case 34: 
          j = zzcgj.zzb(paramzzcfx, 34);
          if (this.zzkG == null) {}
          for (i = 0;; i = this.zzkG.length)
          {
            localObject = new zzaj.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkG, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zzb();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zzb();
          paramzzcfx.zza(localObject[j]);
          this.zzkG = ((zzaj.zzb[])localObject);
          break;
        case 42: 
          j = zzcgj.zzb(paramzzcfx, 42);
          if (this.zzkH == null) {}
          for (i = 0;; i = this.zzkH.length)
          {
            localObject = new zzaj.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkH, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zzb();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zzb();
          paramzzcfx.zza(localObject[j]);
          this.zzkH = ((zzaj.zzb[])localObject);
          break;
        case 50: 
          j = zzcgj.zzb(paramzzcfx, 50);
          if (this.zzkI == null) {}
          for (i = 0;; i = this.zzkI.length)
          {
            localObject = new zzaj.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkI, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zzb();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zzb();
          paramzzcfx.zza(localObject[j]);
          this.zzkI = ((zzaj.zzb[])localObject);
          break;
        case 58: 
          j = zzcgj.zzb(paramzzcfx, 58);
          if (this.zzkJ == null) {}
          for (i = 0;; i = this.zzkJ.length)
          {
            localObject = new zzaj.zzg[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkJ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaj.zzg();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzaj.zzg();
          paramzzcfx.zza(localObject[j]);
          this.zzkJ = ((zzaj.zzg[])localObject);
          break;
        case 74: 
          this.zzkK = paramzzcfx.readString();
          break;
        case 82: 
          this.zzkL = paramzzcfx.readString();
          break;
        case 98: 
          this.zzkM = paramzzcfx.readString();
          break;
        case 106: 
          this.version = paramzzcfx.readString();
          break;
        case 114: 
          if (this.zzkN == null) {
            this.zzkN = new zzaj.zza();
          }
          paramzzcfx.zza(this.zzkN);
          break;
        case 125: 
          this.zzkO = paramzzcfx.readFloat();
          break;
        case 130: 
          j = zzcgj.zzb(paramzzcfx, 130);
          if (this.zzkQ == null) {}
          for (i = 0;; i = this.zzkQ.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkQ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.readString();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.readString();
          this.zzkQ = ((String[])localObject);
          break;
        case 136: 
          this.zzkR = paramzzcfx.zzamM();
          break;
        case 144: 
          this.zzkP = paramzzcfx.zzamO();
          break;
        case 154: 
          j = zzcgj.zzb(paramzzcfx, 154);
          if (this.zzkC == null) {}
          for (i = 0;; i = this.zzkC.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkC, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.readString();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.readString();
          this.zzkC = ((String[])localObject);
        }
      }
    }
  }
  
  public static final class zzg
    extends zzcfz<zzg>
  {
    private static volatile zzg[] zzkS;
    public int[] zzkT;
    public int[] zzkU;
    public int[] zzkV;
    public int[] zzkW;
    public int[] zzkX;
    public int[] zzkY;
    public int[] zzkZ;
    public int[] zzla;
    public int[] zzlb;
    public int[] zzlc;
    
    public zzg()
    {
      zzF();
    }
    
    public static zzg[] zzE()
    {
      if (zzkS == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzkS == null) {
          zzkS = new zzg[0];
        }
        return zzkS;
      }
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int k = super.computeSerializedSize();
      int i;
      if ((this.zzkT != null) && (this.zzkT.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zzkT.length)
        {
          j += zzcfy.zzBB(this.zzkT[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zzkT.length * 1;; j = k)
      {
        i = j;
        if (this.zzkU != null)
        {
          i = j;
          if (this.zzkU.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzkU.length)
            {
              k += zzcfy.zzBB(this.zzkU[i]);
              i += 1;
            }
            i = j + k + this.zzkU.length * 1;
          }
        }
        j = i;
        if (this.zzkV != null)
        {
          j = i;
          if (this.zzkV.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzkV.length)
            {
              k += zzcfy.zzBB(this.zzkV[j]);
              j += 1;
            }
            j = i + k + this.zzkV.length * 1;
          }
        }
        i = j;
        if (this.zzkW != null)
        {
          i = j;
          if (this.zzkW.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzkW.length)
            {
              k += zzcfy.zzBB(this.zzkW[i]);
              i += 1;
            }
            i = j + k + this.zzkW.length * 1;
          }
        }
        j = i;
        if (this.zzkX != null)
        {
          j = i;
          if (this.zzkX.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzkX.length)
            {
              k += zzcfy.zzBB(this.zzkX[j]);
              j += 1;
            }
            j = i + k + this.zzkX.length * 1;
          }
        }
        i = j;
        if (this.zzkY != null)
        {
          i = j;
          if (this.zzkY.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzkY.length)
            {
              k += zzcfy.zzBB(this.zzkY[i]);
              i += 1;
            }
            i = j + k + this.zzkY.length * 1;
          }
        }
        j = i;
        if (this.zzkZ != null)
        {
          j = i;
          if (this.zzkZ.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzkZ.length)
            {
              k += zzcfy.zzBB(this.zzkZ[j]);
              j += 1;
            }
            j = i + k + this.zzkZ.length * 1;
          }
        }
        i = j;
        if (this.zzla != null)
        {
          i = j;
          if (this.zzla.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzla.length)
            {
              k += zzcfy.zzBB(this.zzla[i]);
              i += 1;
            }
            i = j + k + this.zzla.length * 1;
          }
        }
        j = i;
        if (this.zzlb != null)
        {
          j = i;
          if (this.zzlb.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzlb.length)
            {
              k += zzcfy.zzBB(this.zzlb[j]);
              j += 1;
            }
            j = i + k + this.zzlb.length * 1;
          }
        }
        i = j;
        if (this.zzlc != null)
        {
          i = j;
          if (this.zzlc.length > 0)
          {
            k = 0;
            i = m;
            while (i < this.zzlc.length)
            {
              k += zzcfy.zzBB(this.zzlc[i]);
              i += 1;
            }
            i = j + k + this.zzlc.length * 1;
          }
        }
        return i;
      }
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
                            do
                            {
                              return bool1;
                              bool1 = bool2;
                            } while (!(paramObject instanceof zzg));
                            paramObject = (zzg)paramObject;
                            bool1 = bool2;
                          } while (!zzcge.equals(this.zzkT, ((zzg)paramObject).zzkT));
                          bool1 = bool2;
                        } while (!zzcge.equals(this.zzkU, ((zzg)paramObject).zzkU));
                        bool1 = bool2;
                      } while (!zzcge.equals(this.zzkV, ((zzg)paramObject).zzkV));
                      bool1 = bool2;
                    } while (!zzcge.equals(this.zzkW, ((zzg)paramObject).zzkW));
                    bool1 = bool2;
                  } while (!zzcge.equals(this.zzkX, ((zzg)paramObject).zzkX));
                  bool1 = bool2;
                } while (!zzcge.equals(this.zzkY, ((zzg)paramObject).zzkY));
                bool1 = bool2;
              } while (!zzcge.equals(this.zzkZ, ((zzg)paramObject).zzkZ));
              bool1 = bool2;
            } while (!zzcge.equals(this.zzla, ((zzg)paramObject).zzla));
            bool1 = bool2;
          } while (!zzcge.equals(this.zzlb, ((zzg)paramObject).zzlb));
          bool1 = bool2;
        } while (!zzcge.equals(this.zzlc, ((zzg)paramObject).zzlc));
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label223;
        }
        if (((zzg)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzg)paramObject).FZ.isEmpty());
      return true;
      label223:
      return this.FZ.equals(((zzg)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzcge.hashCode(this.zzkT);
      int m = zzcge.hashCode(this.zzkU);
      int n = zzcge.hashCode(this.zzkV);
      int i1 = zzcge.hashCode(this.zzkW);
      int i2 = zzcge.hashCode(this.zzkX);
      int i3 = zzcge.hashCode(this.zzkY);
      int i4 = zzcge.hashCode(this.zzkZ);
      int i5 = zzcge.hashCode(this.zzla);
      int i6 = zzcge.hashCode(this.zzlb);
      int i7 = zzcge.hashCode(this.zzlc);
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + (((((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zzkT != null) && (this.zzkT.length > 0))
      {
        i = 0;
        while (i < this.zzkT.length)
        {
          paramzzcfy.zzaa(1, this.zzkT[i]);
          i += 1;
        }
      }
      if ((this.zzkU != null) && (this.zzkU.length > 0))
      {
        i = 0;
        while (i < this.zzkU.length)
        {
          paramzzcfy.zzaa(2, this.zzkU[i]);
          i += 1;
        }
      }
      if ((this.zzkV != null) && (this.zzkV.length > 0))
      {
        i = 0;
        while (i < this.zzkV.length)
        {
          paramzzcfy.zzaa(3, this.zzkV[i]);
          i += 1;
        }
      }
      if ((this.zzkW != null) && (this.zzkW.length > 0))
      {
        i = 0;
        while (i < this.zzkW.length)
        {
          paramzzcfy.zzaa(4, this.zzkW[i]);
          i += 1;
        }
      }
      if ((this.zzkX != null) && (this.zzkX.length > 0))
      {
        i = 0;
        while (i < this.zzkX.length)
        {
          paramzzcfy.zzaa(5, this.zzkX[i]);
          i += 1;
        }
      }
      if ((this.zzkY != null) && (this.zzkY.length > 0))
      {
        i = 0;
        while (i < this.zzkY.length)
        {
          paramzzcfy.zzaa(6, this.zzkY[i]);
          i += 1;
        }
      }
      if ((this.zzkZ != null) && (this.zzkZ.length > 0))
      {
        i = 0;
        while (i < this.zzkZ.length)
        {
          paramzzcfy.zzaa(7, this.zzkZ[i]);
          i += 1;
        }
      }
      if ((this.zzla != null) && (this.zzla.length > 0))
      {
        i = 0;
        while (i < this.zzla.length)
        {
          paramzzcfy.zzaa(8, this.zzla[i]);
          i += 1;
        }
      }
      if ((this.zzlb != null) && (this.zzlb.length > 0))
      {
        i = 0;
        while (i < this.zzlb.length)
        {
          paramzzcfy.zzaa(9, this.zzlb[i]);
          i += 1;
        }
      }
      if ((this.zzlc != null) && (this.zzlc.length > 0))
      {
        i = j;
        while (i < this.zzlc.length)
        {
          paramzzcfy.zzaa(10, this.zzlc[i]);
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzg zzF()
    {
      this.zzkT = zzcgj.Gn;
      this.zzkU = zzcgj.Gn;
      this.zzkV = zzcgj.Gn;
      this.zzkW = zzcgj.Gn;
      this.zzkX = zzcgj.Gn;
      this.zzkY = zzcgj.Gn;
      this.zzkZ = zzcgj.Gn;
      this.zzla = zzcgj.Gn;
      this.zzlb = zzcgj.Gn;
      this.zzlc = zzcgj.Gn;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzg zzs(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzcgj.zzb(paramzzcfx, 8);
          if (this.zzkT == null) {}
          for (i = 0;; i = this.zzkT.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkT, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkT = arrayOfInt;
          break;
        case 10: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkT == null) {}
          for (i = 0;; i = this.zzkT.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkT, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkT = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 16: 
          j = zzcgj.zzb(paramzzcfx, 16);
          if (this.zzkU == null) {}
          for (i = 0;; i = this.zzkU.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkU, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkU = arrayOfInt;
          break;
        case 18: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkU == null) {}
          for (i = 0;; i = this.zzkU.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkU, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkU = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 24: 
          j = zzcgj.zzb(paramzzcfx, 24);
          if (this.zzkV == null) {}
          for (i = 0;; i = this.zzkV.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkV, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkV = arrayOfInt;
          break;
        case 26: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkV == null) {}
          for (i = 0;; i = this.zzkV.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkV, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkV = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 32: 
          j = zzcgj.zzb(paramzzcfx, 32);
          if (this.zzkW == null) {}
          for (i = 0;; i = this.zzkW.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkW, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkW = arrayOfInt;
          break;
        case 34: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkW == null) {}
          for (i = 0;; i = this.zzkW.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkW, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkW = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 40: 
          j = zzcgj.zzb(paramzzcfx, 40);
          if (this.zzkX == null) {}
          for (i = 0;; i = this.zzkX.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkX, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkX = arrayOfInt;
          break;
        case 42: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkX == null) {}
          for (i = 0;; i = this.zzkX.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkX, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkX = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 48: 
          j = zzcgj.zzb(paramzzcfx, 48);
          if (this.zzkY == null) {}
          for (i = 0;; i = this.zzkY.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkY, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkY = arrayOfInt;
          break;
        case 50: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkY == null) {}
          for (i = 0;; i = this.zzkY.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkY, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkY = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 56: 
          j = zzcgj.zzb(paramzzcfx, 56);
          if (this.zzkZ == null) {}
          for (i = 0;; i = this.zzkZ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkZ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzkZ = arrayOfInt;
          break;
        case 58: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzkZ == null) {}
          for (i = 0;; i = this.zzkZ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzkZ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzkZ = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 64: 
          j = zzcgj.zzb(paramzzcfx, 64);
          if (this.zzla == null) {}
          for (i = 0;; i = this.zzla.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzla, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzla = arrayOfInt;
          break;
        case 66: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzla == null) {}
          for (i = 0;; i = this.zzla.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzla, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzla = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 72: 
          j = zzcgj.zzb(paramzzcfx, 72);
          if (this.zzlb == null) {}
          for (i = 0;; i = this.zzlb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlb, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlb = arrayOfInt;
          break;
        case 74: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlb == null) {}
          for (i = 0;; i = this.zzlb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlb, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlb = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 80: 
          j = zzcgj.zzb(paramzzcfx, 80);
          if (this.zzlc == null) {}
          for (i = 0;; i = this.zzlc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlc, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlc = arrayOfInt;
          break;
        case 82: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlc == null) {}
          for (i = 0;; i = this.zzlc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlc, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlc = arrayOfInt;
          paramzzcfx.zzBw(k);
        }
      }
    }
  }
  
  public static final class zzh
    extends zzcfz<zzh>
  {
    public static final zzcga<zzak.zza, zzh> zzld = zzcga.zza(11, zzh.class, 810L);
    private static final zzh[] zzle = new zzh[0];
    public int[] zzlf;
    public int[] zzlg;
    public int[] zzlh;
    public int zzli;
    public int[] zzlj;
    public int zzlk;
    public int zzll;
    
    public zzh()
    {
      zzG();
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int k = super.computeSerializedSize();
      int i;
      if ((this.zzlf != null) && (this.zzlf.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zzlf.length)
        {
          j += zzcfy.zzBB(this.zzlf[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zzlf.length * 1;; j = k)
      {
        i = j;
        if (this.zzlg != null)
        {
          i = j;
          if (this.zzlg.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzlg.length)
            {
              k += zzcfy.zzBB(this.zzlg[i]);
              i += 1;
            }
            i = j + k + this.zzlg.length * 1;
          }
        }
        j = i;
        if (this.zzlh != null)
        {
          j = i;
          if (this.zzlh.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzlh.length)
            {
              k += zzcfy.zzBB(this.zzlh[j]);
              j += 1;
            }
            j = i + k + this.zzlh.length * 1;
          }
        }
        i = j;
        if (this.zzli != 0) {
          i = j + zzcfy.zzac(4, this.zzli);
        }
        j = i;
        if (this.zzlj != null)
        {
          j = i;
          if (this.zzlj.length > 0)
          {
            k = 0;
            j = m;
            while (j < this.zzlj.length)
            {
              k += zzcfy.zzBB(this.zzlj[j]);
              j += 1;
            }
            j = i + k + this.zzlj.length * 1;
          }
        }
        i = j;
        if (this.zzlk != 0) {
          i = j + zzcfy.zzac(6, this.zzlk);
        }
        j = i;
        if (this.zzll != 0) {
          j = i + zzcfy.zzac(7, this.zzll);
        }
        return j;
      }
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
                      } while (!(paramObject instanceof zzh));
                      paramObject = (zzh)paramObject;
                      bool1 = bool2;
                    } while (!zzcge.equals(this.zzlf, ((zzh)paramObject).zzlf));
                    bool1 = bool2;
                  } while (!zzcge.equals(this.zzlg, ((zzh)paramObject).zzlg));
                  bool1 = bool2;
                } while (!zzcge.equals(this.zzlh, ((zzh)paramObject).zzlh));
                bool1 = bool2;
              } while (this.zzli != ((zzh)paramObject).zzli);
              bool1 = bool2;
            } while (!zzcge.equals(this.zzlj, ((zzh)paramObject).zzlj));
            bool1 = bool2;
          } while (this.zzlk != ((zzh)paramObject).zzlk);
          bool1 = bool2;
        } while (this.zzll != ((zzh)paramObject).zzll);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label166;
        }
        if (((zzh)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzh)paramObject).FZ.isEmpty());
      return true;
      label166:
      return this.FZ.equals(((zzh)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzcge.hashCode(this.zzlf);
      int m = zzcge.hashCode(this.zzlg);
      int n = zzcge.hashCode(this.zzlh);
      int i1 = this.zzli;
      int i2 = zzcge.hashCode(this.zzlj);
      int i3 = this.zzlk;
      int i4 = this.zzll;
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + ((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zzlf != null) && (this.zzlf.length > 0))
      {
        i = 0;
        while (i < this.zzlf.length)
        {
          paramzzcfy.zzaa(1, this.zzlf[i]);
          i += 1;
        }
      }
      if ((this.zzlg != null) && (this.zzlg.length > 0))
      {
        i = 0;
        while (i < this.zzlg.length)
        {
          paramzzcfy.zzaa(2, this.zzlg[i]);
          i += 1;
        }
      }
      if ((this.zzlh != null) && (this.zzlh.length > 0))
      {
        i = 0;
        while (i < this.zzlh.length)
        {
          paramzzcfy.zzaa(3, this.zzlh[i]);
          i += 1;
        }
      }
      if (this.zzli != 0) {
        paramzzcfy.zzaa(4, this.zzli);
      }
      if ((this.zzlj != null) && (this.zzlj.length > 0))
      {
        i = j;
        while (i < this.zzlj.length)
        {
          paramzzcfy.zzaa(5, this.zzlj[i]);
          i += 1;
        }
      }
      if (this.zzlk != 0) {
        paramzzcfy.zzaa(6, this.zzlk);
      }
      if (this.zzll != 0) {
        paramzzcfy.zzaa(7, this.zzll);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzh zzG()
    {
      this.zzlf = zzcgj.Gn;
      this.zzlg = zzcgj.Gn;
      this.zzlh = zzcgj.Gn;
      this.zzli = 0;
      this.zzlj = zzcgj.Gn;
      this.zzlk = 0;
      this.zzll = 0;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzh zzt(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzcgj.zzb(paramzzcfx, 8);
          if (this.zzlf == null) {}
          for (i = 0;; i = this.zzlf.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlf, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlf = arrayOfInt;
          break;
        case 10: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlf == null) {}
          for (i = 0;; i = this.zzlf.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlf, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlf = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 16: 
          j = zzcgj.zzb(paramzzcfx, 16);
          if (this.zzlg == null) {}
          for (i = 0;; i = this.zzlg.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlg, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlg = arrayOfInt;
          break;
        case 18: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlg == null) {}
          for (i = 0;; i = this.zzlg.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlg, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlg = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 24: 
          j = zzcgj.zzb(paramzzcfx, 24);
          if (this.zzlh == null) {}
          for (i = 0;; i = this.zzlh.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlh, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlh = arrayOfInt;
          break;
        case 26: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlh == null) {}
          for (i = 0;; i = this.zzlh.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlh, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlh = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 32: 
          this.zzli = paramzzcfx.zzamM();
          break;
        case 40: 
          j = zzcgj.zzb(paramzzcfx, 40);
          if (this.zzlj == null) {}
          for (i = 0;; i = this.zzlj.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlj, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzlj = arrayOfInt;
          break;
        case 42: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzlj == null) {}
          for (i = 0;; i = this.zzlj.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlj, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzlj = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 48: 
          this.zzlk = paramzzcfx.zzamM();
          break;
        case 56: 
          this.zzll = paramzzcfx.zzamM();
        }
      }
    }
  }
  
  public static final class zzi
    extends zzcfz<zzi>
  {
    private static volatile zzi[] zzlm;
    public String name;
    public zzak.zza zzln;
    public zzaj.zzd zzlo;
    
    public zzi()
    {
      zzI();
    }
    
    public static zzi[] zzH()
    {
      if (zzlm == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzlm == null) {
          zzlm = new zzi[0];
        }
        return zzlm;
      }
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.name != null)
      {
        i = j;
        if (!this.name.equals("")) {
          i = j + zzcfy.zzv(1, this.name);
        }
      }
      j = i;
      if (this.zzln != null) {
        j = i + zzcfy.zzc(2, this.zzln);
      }
      i = j;
      if (this.zzlo != null) {
        i = j + zzcfy.zzc(3, this.zzlo);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label41:
      label57:
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
            } while (!(paramObject instanceof zzi));
            paramObject = (zzi)paramObject;
            if (this.name != null) {
              break;
            }
            bool1 = bool2;
          } while (((zzi)paramObject).name != null);
          if (this.zzln != null) {
            break label127;
          }
          bool1 = bool2;
        } while (((zzi)paramObject).zzln != null);
        if (this.zzlo != null) {
          break label143;
        }
        bool1 = bool2;
      } while (((zzi)paramObject).zzlo != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zzi)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zzi)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.name.equals(((zzi)paramObject).name)) {
            break label41;
          }
          return false;
          label127:
          if (this.zzln.equals(((zzi)paramObject).zzln)) {
            break label57;
          }
          return false;
          label143:
          if (!this.zzlo.equals(((zzi)paramObject).zzlo)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zzi)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzln != null) {
          break label106;
        }
        j = 0;
        if (this.zzlo != null) {
          break label117;
        }
        k = 0;
        label42:
        m = n;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label128;
          }
        }
      }
      label106:
      label117:
      label128:
      for (int m = n;; m = this.FZ.hashCode())
      {
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        j = this.zzln.hashCode();
        break label33;
        k = this.zzlo.hashCode();
        break label42;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.name != null) && (!this.name.equals(""))) {
        paramzzcfy.zzu(1, this.name);
      }
      if (this.zzln != null) {
        paramzzcfy.zza(2, this.zzln);
      }
      if (this.zzlo != null) {
        paramzzcfy.zza(3, this.zzlo);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzi zzI()
    {
      this.name = "";
      this.zzln = null;
      this.zzlo = null;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzi zzu(zzcfx paramzzcfx)
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
          this.name = paramzzcfx.readString();
          break;
        case 18: 
          if (this.zzln == null) {
            this.zzln = new zzak.zza();
          }
          paramzzcfx.zza(this.zzln);
          break;
        case 26: 
          if (this.zzlo == null) {
            this.zzlo = new zzaj.zzd();
          }
          paramzzcfx.zza(this.zzlo);
        }
      }
    }
  }
  
  public static final class zzj
    extends zzcfz<zzj>
  {
    public zzaj.zzi[] zzlp;
    public zzaj.zzf zzlq;
    public String zzlr;
    
    public zzj()
    {
      zzJ();
    }
    
    public static zzj zzg(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zzj)zzcgg.zza(new zzj(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int i = super.computeSerializedSize();
      int j = i;
      if (this.zzlp != null)
      {
        j = i;
        if (this.zzlp.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.zzlp.length) {
              break;
            }
            zzaj.zzi localzzi = this.zzlp[k];
            j = i;
            if (localzzi != null) {
              j = i + zzcfy.zzc(1, localzzi);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzlq != null) {
        i = j + zzcfy.zzc(2, this.zzlq);
      }
      j = i;
      if (this.zzlr != null)
      {
        j = i;
        if (!this.zzlr.equals("")) {
          j = i + zzcfy.zzv(3, this.zzlr);
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
      label57:
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
            } while (!(paramObject instanceof zzj));
            paramObject = (zzj)paramObject;
            bool1 = bool2;
          } while (!zzcge.equals(this.zzlp, ((zzj)paramObject).zzlp));
          if (this.zzlq != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzj)paramObject).zzlq != null);
        if (this.zzlr != null) {
          break label127;
        }
        bool1 = bool2;
      } while (((zzj)paramObject).zzlr != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zzj)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zzj)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzlq.equals(((zzj)paramObject).zzlq)) {
            break label57;
          }
          return false;
          label127:
          if (!this.zzlr.equals(((zzj)paramObject).zzlr)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zzj)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzcge.hashCode(this.zzlp);
      int i;
      int j;
      if (this.zzlq == null)
      {
        i = 0;
        if (this.zzlr != null) {
          break label104;
        }
        j = 0;
        label42:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label115;
          }
        }
      }
      label104:
      label115:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzlq.hashCode();
        break;
        j = this.zzlr.hashCode();
        break label42;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.zzlp != null) && (this.zzlp.length > 0))
      {
        int i = 0;
        while (i < this.zzlp.length)
        {
          zzaj.zzi localzzi = this.zzlp[i];
          if (localzzi != null) {
            paramzzcfy.zza(1, localzzi);
          }
          i += 1;
        }
      }
      if (this.zzlq != null) {
        paramzzcfy.zza(2, this.zzlq);
      }
      if ((this.zzlr != null) && (!this.zzlr.equals(""))) {
        paramzzcfy.zzu(3, this.zzlr);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzj zzJ()
    {
      this.zzlp = zzaj.zzi.zzH();
      this.zzlq = null;
      this.zzlr = "";
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzj zzv(zzcfx paramzzcfx)
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
          int j = zzcgj.zzb(paramzzcfx, 10);
          if (this.zzlp == null) {}
          zzaj.zzi[] arrayOfzzi;
          for (i = 0;; i = this.zzlp.length)
          {
            arrayOfzzi = new zzaj.zzi[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlp, 0, arrayOfzzi, 0, i);
              j = i;
            }
            while (j < arrayOfzzi.length - 1)
            {
              arrayOfzzi[j] = new zzaj.zzi();
              paramzzcfx.zza(arrayOfzzi[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfzzi[j] = new zzaj.zzi();
          paramzzcfx.zza(arrayOfzzi[j]);
          this.zzlp = arrayOfzzi;
          break;
        case 18: 
          if (this.zzlq == null) {
            this.zzlq = new zzaj.zzf();
          }
          paramzzcfx.zza(this.zzlq);
          break;
        case 26: 
          this.zzlr = paramzzcfx.readString();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */