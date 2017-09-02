package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzak
{
  public static final class zza
    extends zzcfz<zza>
  {
    private static volatile zza[] zzls;
    public String string;
    public int type;
    public zza[] zzlA;
    public int[] zzlB;
    public boolean zzlC;
    public zza[] zzlt;
    public zza[] zzlu;
    public zza[] zzlv;
    public String zzlw;
    public String zzlx;
    public long zzly;
    public boolean zzlz;
    
    public zza()
    {
      zzL();
    }
    
    public static zza[] zzK()
    {
      if (zzls == null) {}
      synchronized (zzcge.Gh)
      {
        if (zzls == null) {
          zzls = new zza[0];
        }
        return zzls;
      }
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int j = super.computeSerializedSize() + zzcfy.zzac(1, this.type);
      int i = j;
      if (this.string != null)
      {
        i = j;
        if (!this.string.equals("")) {
          i = j + zzcfy.zzv(2, this.string);
        }
      }
      j = i;
      zza localzza;
      int k;
      if (this.zzlt != null)
      {
        j = i;
        if (this.zzlt.length > 0)
        {
          j = 0;
          while (j < this.zzlt.length)
          {
            localzza = this.zzlt[j];
            k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(3, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzlu != null)
      {
        i = j;
        if (this.zzlu.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzlu.length)
          {
            localzza = this.zzlu[j];
            k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(4, localzza);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zzlv != null)
      {
        j = i;
        if (this.zzlv.length > 0)
        {
          j = 0;
          while (j < this.zzlv.length)
          {
            localzza = this.zzlv[j];
            k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(5, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzlw != null)
      {
        i = j;
        if (!this.zzlw.equals("")) {
          i = j + zzcfy.zzv(6, this.zzlw);
        }
      }
      j = i;
      if (this.zzlx != null)
      {
        j = i;
        if (!this.zzlx.equals("")) {
          j = i + zzcfy.zzv(7, this.zzlx);
        }
      }
      i = j;
      if (this.zzly != 0L) {
        i = j + zzcfy.zzj(8, this.zzly);
      }
      j = i;
      if (this.zzlC) {
        j = i + zzcfy.zzl(9, this.zzlC);
      }
      i = j;
      if (this.zzlB != null)
      {
        i = j;
        if (this.zzlB.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzlB.length)
          {
            k += zzcfy.zzBB(this.zzlB[i]);
            i += 1;
          }
          i = j + k + this.zzlB.length * 1;
        }
      }
      j = i;
      if (this.zzlA != null)
      {
        j = i;
        if (this.zzlA.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzlA.length) {
              break;
            }
            localzza = this.zzlA[k];
            j = i;
            if (localzza != null) {
              j = i + zzcfy.zzc(11, localzza);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzlz) {
        i = j + zzcfy.zzl(12, this.zzlz);
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
      label54:
      label118:
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
                    } while (!(paramObject instanceof zza));
                    paramObject = (zza)paramObject;
                    bool1 = bool2;
                  } while (this.type != ((zza)paramObject).type);
                  if (this.string != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((zza)paramObject).string != null);
                bool1 = bool2;
              } while (!zzcge.equals(this.zzlt, ((zza)paramObject).zzlt));
              bool1 = bool2;
            } while (!zzcge.equals(this.zzlu, ((zza)paramObject).zzlu));
            bool1 = bool2;
          } while (!zzcge.equals(this.zzlv, ((zza)paramObject).zzlv));
          if (this.zzlw != null) {
            break label260;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzlw != null);
        if (this.zzlx != null) {
          break label276;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzlx != null);
      label260:
      label276:
      while (this.zzlx.equals(((zza)paramObject).zzlx))
      {
        bool1 = bool2;
        if (this.zzly != ((zza)paramObject).zzly) {
          break;
        }
        bool1 = bool2;
        if (this.zzlz != ((zza)paramObject).zzlz) {
          break;
        }
        bool1 = bool2;
        if (!zzcge.equals(this.zzlA, ((zza)paramObject).zzlA)) {
          break;
        }
        bool1 = bool2;
        if (!zzcge.equals(this.zzlB, ((zza)paramObject).zzlB)) {
          break;
        }
        bool1 = bool2;
        if (this.zzlC != ((zza)paramObject).zzlC) {
          break;
        }
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label292;
        }
        if (((zza)paramObject).FZ != null)
        {
          bool1 = bool2;
          if (!((zza)paramObject).FZ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.string.equals(((zza)paramObject).string)) {
          break label54;
        }
        return false;
        if (this.zzlw.equals(((zza)paramObject).zzlw)) {
          break label118;
        }
        return false;
      }
      return false;
      label292:
      return this.FZ.equals(((zza)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int n = 1231;
      int i2 = 0;
      int i3 = getClass().getName().hashCode();
      int i4 = this.type;
      int i;
      int i5;
      int i6;
      int i7;
      int j;
      label71:
      int k;
      label80:
      int i8;
      int m;
      label107:
      int i9;
      int i10;
      if (this.string == null)
      {
        i = 0;
        i5 = zzcge.hashCode(this.zzlt);
        i6 = zzcge.hashCode(this.zzlu);
        i7 = zzcge.hashCode(this.zzlv);
        if (this.zzlw != null) {
          break label250;
        }
        j = 0;
        if (this.zzlx != null) {
          break label261;
        }
        k = 0;
        i8 = (int)(this.zzly ^ this.zzly >>> 32);
        if (!this.zzlz) {
          break label272;
        }
        m = 1231;
        i9 = zzcge.hashCode(this.zzlA);
        i10 = zzcge.hashCode(this.zzlB);
        if (!this.zzlC) {
          break label280;
        }
        label132:
        i1 = i2;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label288;
          }
        }
      }
      label250:
      label261:
      label272:
      label280:
      label288:
      for (int i1 = i2;; i1 = this.FZ.hashCode())
      {
        return ((((m + ((k + (j + ((((i + ((i3 + 527) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31 + n) * 31 + i1;
        i = this.string.hashCode();
        break;
        j = this.zzlw.hashCode();
        break label71;
        k = this.zzlx.hashCode();
        break label80;
        m = 1237;
        break label107;
        n = 1237;
        break label132;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      paramzzcfy.zzaa(1, this.type);
      if ((this.string != null) && (!this.string.equals(""))) {
        paramzzcfy.zzu(2, this.string);
      }
      int i;
      zza localzza;
      if ((this.zzlt != null) && (this.zzlt.length > 0))
      {
        i = 0;
        while (i < this.zzlt.length)
        {
          localzza = this.zzlt[i];
          if (localzza != null) {
            paramzzcfy.zza(3, localzza);
          }
          i += 1;
        }
      }
      if ((this.zzlu != null) && (this.zzlu.length > 0))
      {
        i = 0;
        while (i < this.zzlu.length)
        {
          localzza = this.zzlu[i];
          if (localzza != null) {
            paramzzcfy.zza(4, localzza);
          }
          i += 1;
        }
      }
      if ((this.zzlv != null) && (this.zzlv.length > 0))
      {
        i = 0;
        while (i < this.zzlv.length)
        {
          localzza = this.zzlv[i];
          if (localzza != null) {
            paramzzcfy.zza(5, localzza);
          }
          i += 1;
        }
      }
      if ((this.zzlw != null) && (!this.zzlw.equals(""))) {
        paramzzcfy.zzu(6, this.zzlw);
      }
      if ((this.zzlx != null) && (!this.zzlx.equals(""))) {
        paramzzcfy.zzu(7, this.zzlx);
      }
      if (this.zzly != 0L) {
        paramzzcfy.zzf(8, this.zzly);
      }
      if (this.zzlC) {
        paramzzcfy.zzk(9, this.zzlC);
      }
      if ((this.zzlB != null) && (this.zzlB.length > 0))
      {
        i = 0;
        while (i < this.zzlB.length)
        {
          paramzzcfy.zzaa(10, this.zzlB[i]);
          i += 1;
        }
      }
      if ((this.zzlA != null) && (this.zzlA.length > 0))
      {
        i = j;
        while (i < this.zzlA.length)
        {
          localzza = this.zzlA[i];
          if (localzza != null) {
            paramzzcfy.zza(11, localzza);
          }
          i += 1;
        }
      }
      if (this.zzlz) {
        paramzzcfy.zzk(12, this.zzlz);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzL()
    {
      this.type = 1;
      this.string = "";
      this.zzlt = zzK();
      this.zzlu = zzK();
      this.zzlv = zzK();
      this.zzlw = "";
      this.zzlx = "";
      this.zzly = 0L;
      this.zzlz = false;
      this.zzlA = zzK();
      this.zzlB = zzcgj.Gn;
      this.zzlC = false;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zza zzw(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        Object localObject;
        int k;
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
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
            this.type = i;
          }
          break;
        case 18: 
          this.string = paramzzcfx.readString();
          break;
        case 26: 
          j = zzcgj.zzb(paramzzcfx, 26);
          if (this.zzlt == null) {}
          for (i = 0;; i = this.zzlt.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlt, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzcfx.zza(localObject[j]);
          this.zzlt = ((zza[])localObject);
          break;
        case 34: 
          j = zzcgj.zzb(paramzzcfx, 34);
          if (this.zzlu == null) {}
          for (i = 0;; i = this.zzlu.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlu, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzcfx.zza(localObject[j]);
          this.zzlu = ((zza[])localObject);
          break;
        case 42: 
          j = zzcgj.zzb(paramzzcfx, 42);
          if (this.zzlv == null) {}
          for (i = 0;; i = this.zzlv.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlv, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzcfx.zza(localObject[j]);
          this.zzlv = ((zza[])localObject);
          break;
        case 50: 
          this.zzlw = paramzzcfx.readString();
          break;
        case 58: 
          this.zzlx = paramzzcfx.readString();
          break;
        case 64: 
          this.zzly = paramzzcfx.zzamL();
          break;
        case 72: 
          this.zzlC = paramzzcfx.zzamO();
          break;
        case 80: 
          int m = zzcgj.zzb(paramzzcfx, 80);
          localObject = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              paramzzcfx.zzamI();
            }
            int n = paramzzcfx.zzamM();
            switch (n)
            {
            }
            for (;;)
            {
              j += 1;
              break;
              k = i + 1;
              localObject[i] = n;
              i = k;
            }
          }
          if (i != 0)
          {
            if (this.zzlB == null) {}
            for (j = 0;; j = this.zzlB.length)
            {
              if ((j != 0) || (i != localObject.length)) {
                break label810;
              }
              this.zzlB = ((int[])localObject);
              break;
            }
            int[] arrayOfInt = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.zzlB, 0, arrayOfInt, 0, j);
            }
            System.arraycopy(localObject, 0, arrayOfInt, j, i);
            this.zzlB = arrayOfInt;
          }
          break;
        case 82: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0) {
            switch (paramzzcfx.zzamM())
            {
            default: 
              break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              j += 1;
            }
          }
          if (j != 0)
          {
            paramzzcfx.zzBx(i);
            if (this.zzlB == null) {}
            for (i = 0;; i = this.zzlB.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.zzlB, 0, localObject, 0, i);
                j = i;
              }
              while (paramzzcfx.zzamW() > 0)
              {
                i = paramzzcfx.zzamM();
                switch (i)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                  localObject[j] = i;
                  j += 1;
                }
              }
            }
            this.zzlB = ((int[])localObject);
          }
          paramzzcfx.zzBw(k);
          break;
        case 90: 
          j = zzcgj.zzb(paramzzcfx, 90);
          if (this.zzlA == null) {}
          for (i = 0;; i = this.zzlA.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzlA, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzcfx.zza(localObject[j]);
          this.zzlA = ((zza[])localObject);
          break;
        case 96: 
          label810:
          this.zzlz = paramzzcfx.zzamO();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */