package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzcgl
{
  public static final class zza
    extends zzcfz<zza>
    implements Cloneable
  {
    public long[] GA;
    public long[] GB;
    public String[] Gx;
    public String[] Gy;
    public int[] Gz;
    
    public zza()
    {
      zzanp();
    }
    
    protected int computeSerializedSize()
    {
      int i2 = 0;
      int i1 = super.computeSerializedSize();
      int j;
      int k;
      String str;
      int n;
      int m;
      if ((this.Gx != null) && (this.Gx.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.Gx.length; k = m)
        {
          str = this.Gx[i];
          n = j;
          m = k;
          if (str != null)
          {
            m = k + 1;
            n = j + zzcfy.zzmU(str);
          }
          i += 1;
          j = n;
        }
      }
      for (int i = i1 + j + k * 1;; i = i1)
      {
        j = i;
        if (this.Gy != null)
        {
          j = i;
          if (this.Gy.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.Gy.length; m = n)
            {
              str = this.Gy[j];
              i1 = k;
              n = m;
              if (str != null)
              {
                n = m + 1;
                i1 = k + zzcfy.zzmU(str);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 1;
          }
        }
        i = j;
        if (this.Gz != null)
        {
          i = j;
          if (this.Gz.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.Gz.length)
            {
              k += zzcfy.zzBB(this.Gz[i]);
              i += 1;
            }
            i = j + k + this.Gz.length * 1;
          }
        }
        j = i;
        if (this.GA != null)
        {
          j = i;
          if (this.GA.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.GA.length)
            {
              k += zzcfy.zzbw(this.GA[j]);
              j += 1;
            }
            j = i + k + this.GA.length * 1;
          }
        }
        i = j;
        if (this.GB != null)
        {
          i = j;
          if (this.GB.length > 0)
          {
            k = 0;
            i = i2;
            while (i < this.GB.length)
            {
              k += zzcfy.zzbw(this.GB[i]);
              i += 1;
            }
            i = j + k + this.GB.length * 1;
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
                    return bool1;
                    bool1 = bool2;
                  } while (!(paramObject instanceof zza));
                  paramObject = (zza)paramObject;
                  bool1 = bool2;
                } while (!zzcge.equals(this.Gx, ((zza)paramObject).Gx));
                bool1 = bool2;
              } while (!zzcge.equals(this.Gy, ((zza)paramObject).Gy));
              bool1 = bool2;
            } while (!zzcge.equals(this.Gz, ((zza)paramObject).Gz));
            bool1 = bool2;
          } while (!zzcge.equals(this.GA, ((zza)paramObject).GA));
          bool1 = bool2;
        } while (!zzcge.equals(this.GB, ((zza)paramObject).GB));
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label143;
        }
        if (((zza)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).FZ.isEmpty());
      return true;
      label143:
      return this.FZ.equals(((zza)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzcge.hashCode(this.Gx);
      int m = zzcge.hashCode(this.Gy);
      int n = zzcge.hashCode(this.Gz);
      int i1 = zzcge.hashCode(this.GA);
      int i2 = zzcge.hashCode(this.GB);
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + ((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      int i;
      String str;
      if ((this.Gx != null) && (this.Gx.length > 0))
      {
        i = 0;
        while (i < this.Gx.length)
        {
          str = this.Gx[i];
          if (str != null) {
            paramzzcfy.zzu(1, str);
          }
          i += 1;
        }
      }
      if ((this.Gy != null) && (this.Gy.length > 0))
      {
        i = 0;
        while (i < this.Gy.length)
        {
          str = this.Gy[i];
          if (str != null) {
            paramzzcfy.zzu(2, str);
          }
          i += 1;
        }
      }
      if ((this.Gz != null) && (this.Gz.length > 0))
      {
        i = 0;
        while (i < this.Gz.length)
        {
          paramzzcfy.zzaa(3, this.Gz[i]);
          i += 1;
        }
      }
      if ((this.GA != null) && (this.GA.length > 0))
      {
        i = 0;
        while (i < this.GA.length)
        {
          paramzzcfy.zzf(4, this.GA[i]);
          i += 1;
        }
      }
      if ((this.GB != null) && (this.GB.length > 0))
      {
        i = j;
        while (i < this.GB.length)
        {
          paramzzcfy.zzf(5, this.GB[i]);
          i += 1;
        }
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzanp()
    {
      this.Gx = zzcgj.Gs;
      this.Gy = zzcgj.Gs;
      this.Gz = zzcgj.Gn;
      this.GA = zzcgj.Go;
      this.GB = zzcgj.Go;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zza zzanq()
    {
      try
      {
        zza localzza = (zza)super.zzanb();
        if ((this.Gx != null) && (this.Gx.length > 0)) {
          localzza.Gx = ((String[])this.Gx.clone());
        }
        if ((this.Gy != null) && (this.Gy.length > 0)) {
          localzza.Gy = ((String[])this.Gy.clone());
        }
        if ((this.Gz != null) && (this.Gz.length > 0)) {
          localzza.Gz = ((int[])this.Gz.clone());
        }
        if ((this.GA != null) && (this.GA.length > 0)) {
          localzza.GA = ((long[])this.GA.clone());
        }
        if ((this.GB != null) && (this.GB.length > 0)) {
          localzza.GB = ((long[])this.GB.clone());
        }
        return localzza;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    public zza zzbf(zzcfx paramzzcfx)
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
        case 10: 
          j = zzcgj.zzb(paramzzcfx, 10);
          if (this.Gx == null) {}
          for (i = 0;; i = this.Gx.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Gx, 0, localObject, 0, i);
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
          this.Gx = ((String[])localObject);
          break;
        case 18: 
          j = zzcgj.zzb(paramzzcfx, 18);
          if (this.Gy == null) {}
          for (i = 0;; i = this.Gy.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Gy, 0, localObject, 0, i);
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
          this.Gy = ((String[])localObject);
          break;
        case 24: 
          j = zzcgj.zzb(paramzzcfx, 24);
          if (this.Gz == null) {}
          for (i = 0;; i = this.Gz.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Gz, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.zzamM();
          this.Gz = ((int[])localObject);
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
          if (this.Gz == null) {}
          for (i = 0;; i = this.Gz.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Gz, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.Gz = ((int[])localObject);
          paramzzcfx.zzBw(k);
          break;
        case 32: 
          j = zzcgj.zzb(paramzzcfx, 32);
          if (this.GA == null) {}
          for (i = 0;; i = this.GA.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GA, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.zzamL();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.zzamL();
          this.GA = ((long[])localObject);
          break;
        case 34: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamL();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.GA == null) {}
          for (i = 0;; i = this.GA.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GA, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzcfx.zzamL();
              j += 1;
            }
          }
          this.GA = ((long[])localObject);
          paramzzcfx.zzBw(k);
          break;
        case 40: 
          j = zzcgj.zzb(paramzzcfx, 40);
          if (this.GB == null) {}
          for (i = 0;; i = this.GB.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GB, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.zzamL();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.zzamL();
          this.GB = ((long[])localObject);
          break;
        case 42: 
          k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamL();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.GB == null) {}
          for (i = 0;; i = this.GB.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GB, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzcfx.zzamL();
              j += 1;
            }
          }
          this.GB = ((long[])localObject);
          paramzzcfx.zzBw(k);
        }
      }
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
    implements Cloneable
  {
    public int GC;
    public String GD;
    public String version;
    
    public zzb()
    {
      zzanr();
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.GC != 0) {
        i = j + zzcfy.zzac(1, this.GC);
      }
      j = i;
      if (this.GD != null)
      {
        j = i;
        if (!this.GD.equals("")) {
          j = i + zzcfy.zzv(2, this.GD);
        }
      }
      i = j;
      if (this.version != null)
      {
        i = j;
        if (!this.version.equals("")) {
          i = j + zzcfy.zzv(3, this.version);
        }
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
          } while (this.GC != ((zzb)paramObject).GC);
          if (this.GD != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzb)paramObject).GD != null);
        if (this.version != null) {
          break label124;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).version != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zzb)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zzb)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.GD.equals(((zzb)paramObject).GD)) {
            break label54;
          }
          return false;
          label124:
          if (!this.version.equals(((zzb)paramObject).version)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zzb)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = this.GC;
      int i;
      int j;
      if (this.GD == null)
      {
        i = 0;
        if (this.version != null) {
          break label101;
        }
        j = 0;
        label39:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label112;
          }
        }
      }
      label101:
      label112:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.GD.hashCode();
        break;
        j = this.version.hashCode();
        break label39;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.GC != 0) {
        paramzzcfy.zzaa(1, this.GC);
      }
      if ((this.GD != null) && (!this.GD.equals(""))) {
        paramzzcfy.zzu(2, this.GD);
      }
      if ((this.version != null) && (!this.version.equals(""))) {
        paramzzcfy.zzu(3, this.version);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzanr()
    {
      this.GC = 0;
      this.GD = "";
      this.version = "";
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzb zzans()
    {
      try
      {
        zzb localzzb = (zzb)super.zzanb();
        return localzzb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    public zzb zzbg(zzcfx paramzzcfx)
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
          this.GC = paramzzcfx.zzamM();
          break;
        case 18: 
          this.GD = paramzzcfx.readString();
          break;
        case 26: 
          this.version = paramzzcfx.readString();
        }
      }
    }
  }
  
  public static final class zzc
    extends zzcfz<zzc>
    implements Cloneable
  {
    public byte[] GE;
    public String GF;
    public byte[][] GG;
    public boolean GH;
    
    public zzc()
    {
      zzant();
    }
    
    protected int computeSerializedSize()
    {
      int n = 0;
      int j = super.computeSerializedSize();
      int i = j;
      if (!Arrays.equals(this.GE, zzcgj.Gu)) {
        i = j + zzcfy.zzc(1, this.GE);
      }
      j = i;
      if (this.GG != null)
      {
        j = i;
        if (this.GG.length > 0)
        {
          int k = 0;
          int m = 0;
          j = n;
          while (j < this.GG.length)
          {
            byte[] arrayOfByte = this.GG[j];
            int i1 = k;
            n = m;
            if (arrayOfByte != null)
            {
              n = m + 1;
              i1 = k + zzcfy.zzau(arrayOfByte);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (this.GH) {
        i = j + zzcfy.zzl(3, this.GH);
      }
      j = i;
      if (this.GF != null)
      {
        j = i;
        if (!this.GF.equals("")) {
          j = i + zzcfy.zzv(4, this.GF);
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
          } while (!(paramObject instanceof zzc));
          paramObject = (zzc)paramObject;
          bool1 = bool2;
        } while (!Arrays.equals(this.GE, ((zzc)paramObject).GE));
        if (this.GF != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).GF != null);
      while (this.GF.equals(((zzc)paramObject).GF))
      {
        bool1 = bool2;
        if (!zzcge.zza(this.GG, ((zzc)paramObject).GG)) {
          break;
        }
        bool1 = bool2;
        if (this.GH != ((zzc)paramObject).GH) {
          break;
        }
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label140;
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
      label140:
      return this.FZ.equals(((zzc)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = Arrays.hashCode(this.GE);
      int i;
      int i2;
      int j;
      if (this.GF == null)
      {
        i = 0;
        i2 = zzcge.zzd(this.GG);
        if (!this.GH) {
          break label121;
        }
        j = 1231;
        label53:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label128;
          }
        }
      }
      label121:
      label128:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + ((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31) * 31 + k;
        i = this.GF.hashCode();
        break;
        j = 1237;
        break label53;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (!Arrays.equals(this.GE, zzcgj.Gu)) {
        paramzzcfy.zzb(1, this.GE);
      }
      if ((this.GG != null) && (this.GG.length > 0))
      {
        int i = 0;
        while (i < this.GG.length)
        {
          byte[] arrayOfByte = this.GG[i];
          if (arrayOfByte != null) {
            paramzzcfy.zzb(2, arrayOfByte);
          }
          i += 1;
        }
      }
      if (this.GH) {
        paramzzcfy.zzk(3, this.GH);
      }
      if ((this.GF != null) && (!this.GF.equals(""))) {
        paramzzcfy.zzu(4, this.GF);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzc zzant()
    {
      this.GE = zzcgj.Gu;
      this.GF = "";
      this.GG = zzcgj.Gt;
      this.GH = false;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzc zzanu()
    {
      try
      {
        zzc localzzc = (zzc)super.zzanb();
        if ((this.GG != null) && (this.GG.length > 0)) {
          localzzc.GG = ((byte[][])this.GG.clone());
        }
        return localzzc;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    public zzc zzbh(zzcfx paramzzcfx)
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
          this.GE = paramzzcfx.readBytes();
          break;
        case 18: 
          int j = zzcgj.zzb(paramzzcfx, 18);
          if (this.GG == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = this.GG.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GG, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramzzcfx.readBytes();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfByte[j] = paramzzcfx.readBytes();
          this.GG = arrayOfByte;
          break;
        case 24: 
          this.GH = paramzzcfx.zzamO();
          break;
        case 34: 
          this.GF = paramzzcfx.readString();
        }
      }
    }
  }
  
  public static final class zzd
    extends zzcfz<zzd>
    implements Cloneable
  {
    public long GI;
    public long GJ;
    public long GK;
    public zzcgl.zze[] GL;
    public byte[] GM;
    public zzcgl.zzb GN;
    public byte[] GO;
    public String GP;
    public String GQ;
    public zzcgl.zza GR;
    public String GS;
    public long GT;
    public zzcgl.zzc GU;
    public byte[] GV;
    public String GW;
    public int GX;
    public int[] GY;
    public long GZ;
    public zzcgl.zzf Ha;
    public int eventCode;
    public boolean pj;
    public String tag;
    public int zzrh;
    
    public zzd()
    {
      zzanv();
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int i = super.computeSerializedSize();
      int j = i;
      if (this.GI != 0L) {
        j = i + zzcfy.zzj(1, this.GI);
      }
      i = j;
      if (this.tag != null)
      {
        i = j;
        if (!this.tag.equals("")) {
          i = j + zzcfy.zzv(2, this.tag);
        }
      }
      j = i;
      int k;
      if (this.GL != null)
      {
        j = i;
        if (this.GL.length > 0)
        {
          j = 0;
          while (j < this.GL.length)
          {
            zzcgl.zze localzze = this.GL[j];
            k = i;
            if (localzze != null) {
              k = i + zzcfy.zzc(3, localzze);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(this.GM, zzcgj.Gu)) {
        i = j + zzcfy.zzc(4, this.GM);
      }
      j = i;
      if (!Arrays.equals(this.GO, zzcgj.Gu)) {
        j = i + zzcfy.zzc(6, this.GO);
      }
      i = j;
      if (this.GR != null) {
        i = j + zzcfy.zzc(7, this.GR);
      }
      j = i;
      if (this.GP != null)
      {
        j = i;
        if (!this.GP.equals("")) {
          j = i + zzcfy.zzv(8, this.GP);
        }
      }
      i = j;
      if (this.GN != null) {
        i = j + zzcfy.zzc(9, this.GN);
      }
      j = i;
      if (this.pj) {
        j = i + zzcfy.zzl(10, this.pj);
      }
      i = j;
      if (this.eventCode != 0) {
        i = j + zzcfy.zzac(11, this.eventCode);
      }
      j = i;
      if (this.zzrh != 0) {
        j = i + zzcfy.zzac(12, this.zzrh);
      }
      i = j;
      if (this.GQ != null)
      {
        i = j;
        if (!this.GQ.equals("")) {
          i = j + zzcfy.zzv(13, this.GQ);
        }
      }
      j = i;
      if (this.GS != null)
      {
        j = i;
        if (!this.GS.equals("")) {
          j = i + zzcfy.zzv(14, this.GS);
        }
      }
      i = j;
      if (this.GT != 180000L) {
        i = j + zzcfy.zzl(15, this.GT);
      }
      j = i;
      if (this.GU != null) {
        j = i + zzcfy.zzc(16, this.GU);
      }
      i = j;
      if (this.GJ != 0L) {
        i = j + zzcfy.zzj(17, this.GJ);
      }
      j = i;
      if (!Arrays.equals(this.GV, zzcgj.Gu)) {
        j = i + zzcfy.zzc(18, this.GV);
      }
      i = j;
      if (this.GX != 0) {
        i = j + zzcfy.zzac(19, this.GX);
      }
      j = i;
      if (this.GY != null)
      {
        j = i;
        if (this.GY.length > 0)
        {
          k = 0;
          j = m;
          while (j < this.GY.length)
          {
            k += zzcfy.zzBB(this.GY[j]);
            j += 1;
          }
          j = i + k + this.GY.length * 2;
        }
      }
      i = j;
      if (this.GK != 0L) {
        i = j + zzcfy.zzj(21, this.GK);
      }
      j = i;
      if (this.GZ != 0L) {
        j = i + zzcfy.zzj(22, this.GZ);
      }
      i = j;
      if (this.Ha != null) {
        i = j + zzcfy.zzc(23, this.Ha);
      }
      j = i;
      if (this.GW != null)
      {
        j = i;
        if (!this.GW.equals("")) {
          j = i + zzcfy.zzv(24, this.GW);
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
      label83:
      label170:
      label202:
      label218:
      label234:
      label250:
      label280:
      label312:
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
                                                    } while (!(paramObject instanceof zzd));
                                                    paramObject = (zzd)paramObject;
                                                    bool1 = bool2;
                                                  } while (this.GI != ((zzd)paramObject).GI);
                                                  bool1 = bool2;
                                                } while (this.GJ != ((zzd)paramObject).GJ);
                                                bool1 = bool2;
                                              } while (this.GK != ((zzd)paramObject).GK);
                                              if (this.tag != null) {
                                                break;
                                              }
                                              bool1 = bool2;
                                            } while (((zzd)paramObject).tag != null);
                                            bool1 = bool2;
                                          } while (this.eventCode != ((zzd)paramObject).eventCode);
                                          bool1 = bool2;
                                        } while (this.zzrh != ((zzd)paramObject).zzrh);
                                        bool1 = bool2;
                                      } while (this.pj != ((zzd)paramObject).pj);
                                      bool1 = bool2;
                                    } while (!zzcge.equals(this.GL, ((zzd)paramObject).GL));
                                    bool1 = bool2;
                                  } while (!Arrays.equals(this.GM, ((zzd)paramObject).GM));
                                  if (this.GN != null) {
                                    break label425;
                                  }
                                  bool1 = bool2;
                                } while (((zzd)paramObject).GN != null);
                                bool1 = bool2;
                              } while (!Arrays.equals(this.GO, ((zzd)paramObject).GO));
                              if (this.GP != null) {
                                break label441;
                              }
                              bool1 = bool2;
                            } while (((zzd)paramObject).GP != null);
                            if (this.GQ != null) {
                              break label457;
                            }
                            bool1 = bool2;
                          } while (((zzd)paramObject).GQ != null);
                          if (this.GR != null) {
                            break label473;
                          }
                          bool1 = bool2;
                        } while (((zzd)paramObject).GR != null);
                        if (this.GS != null) {
                          break label489;
                        }
                        bool1 = bool2;
                      } while (((zzd)paramObject).GS != null);
                      bool1 = bool2;
                    } while (this.GT != ((zzd)paramObject).GT);
                    if (this.GU != null) {
                      break label505;
                    }
                    bool1 = bool2;
                  } while (((zzd)paramObject).GU != null);
                  bool1 = bool2;
                } while (!Arrays.equals(this.GV, ((zzd)paramObject).GV));
                if (this.GW != null) {
                  break label521;
                }
                bool1 = bool2;
              } while (((zzd)paramObject).GW != null);
              bool1 = bool2;
            } while (this.GX != ((zzd)paramObject).GX);
            bool1 = bool2;
          } while (!zzcge.equals(this.GY, ((zzd)paramObject).GY));
          bool1 = bool2;
        } while (this.GZ != ((zzd)paramObject).GZ);
        if (this.Ha != null) {
          break label537;
        }
        bool1 = bool2;
      } while (((zzd)paramObject).Ha != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zzd)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zzd)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.tag.equals(((zzd)paramObject).tag)) {
            break label83;
          }
          return false;
          label425:
          if (this.GN.equals(((zzd)paramObject).GN)) {
            break label170;
          }
          return false;
          label441:
          if (this.GP.equals(((zzd)paramObject).GP)) {
            break label202;
          }
          return false;
          label457:
          if (this.GQ.equals(((zzd)paramObject).GQ)) {
            break label218;
          }
          return false;
          label473:
          if (this.GR.equals(((zzd)paramObject).GR)) {
            break label234;
          }
          return false;
          label489:
          if (this.GS.equals(((zzd)paramObject).GS)) {
            break label250;
          }
          return false;
          label505:
          if (this.GU.equals(((zzd)paramObject).GU)) {
            break label280;
          }
          return false;
          label521:
          if (this.GW.equals(((zzd)paramObject).GW)) {
            break label312;
          }
          return false;
          label537:
          if (!this.Ha.equals(((zzd)paramObject).Ha)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zzd)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int i7 = 0;
      int i8 = getClass().getName().hashCode();
      int i9 = (int)(this.GI ^ this.GI >>> 32);
      int i10 = (int)(this.GJ ^ this.GJ >>> 32);
      int i11 = (int)(this.GK ^ this.GK >>> 32);
      int i;
      int i12;
      int i13;
      int j;
      label92:
      int i14;
      int i15;
      int k;
      label119:
      int i16;
      int m;
      label138:
      int n;
      label148:
      int i1;
      label158:
      int i2;
      label168:
      int i17;
      int i3;
      label193:
      int i18;
      int i4;
      label212:
      int i19;
      int i20;
      int i21;
      int i5;
      if (this.tag == null)
      {
        i = 0;
        i12 = this.eventCode;
        i13 = this.zzrh;
        if (!this.pj) {
          break label436;
        }
        j = 1231;
        i14 = zzcge.hashCode(this.GL);
        i15 = Arrays.hashCode(this.GM);
        if (this.GN != null) {
          break label443;
        }
        k = 0;
        i16 = Arrays.hashCode(this.GO);
        if (this.GP != null) {
          break label454;
        }
        m = 0;
        if (this.GQ != null) {
          break label466;
        }
        n = 0;
        if (this.GR != null) {
          break label478;
        }
        i1 = 0;
        if (this.GS != null) {
          break label490;
        }
        i2 = 0;
        i17 = (int)(this.GT ^ this.GT >>> 32);
        if (this.GU != null) {
          break label502;
        }
        i3 = 0;
        i18 = Arrays.hashCode(this.GV);
        if (this.GW != null) {
          break label514;
        }
        i4 = 0;
        i19 = this.GX;
        i20 = zzcge.hashCode(this.GY);
        i21 = (int)(this.GZ ^ this.GZ >>> 32);
        if (this.Ha != null) {
          break label526;
        }
        i5 = 0;
        label252:
        i6 = i7;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label538;
          }
        }
      }
      label436:
      label443:
      label454:
      label466:
      label478:
      label490:
      label502:
      label514:
      label526:
      label538:
      for (int i6 = i7;; i6 = this.FZ.hashCode())
      {
        return (i5 + ((((i4 + ((i3 + ((i2 + (i1 + (n + (m + ((k + (((j + (((i + ((((i8 + 527) * 31 + i9) * 31 + i10) * 31 + i11) * 31) * 31 + i12) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31) * 31 + i16) * 31) * 31) * 31) * 31) * 31 + i17) * 31) * 31 + i18) * 31) * 31 + i19) * 31 + i20) * 31 + i21) * 31) * 31 + i6;
        i = this.tag.hashCode();
        break;
        j = 1237;
        break label92;
        k = this.GN.hashCode();
        break label119;
        m = this.GP.hashCode();
        break label138;
        n = this.GQ.hashCode();
        break label148;
        i1 = this.GR.hashCode();
        break label158;
        i2 = this.GS.hashCode();
        break label168;
        i3 = this.GU.hashCode();
        break label193;
        i4 = this.GW.hashCode();
        break label212;
        i5 = this.Ha.hashCode();
        break label252;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      int j = 0;
      if (this.GI != 0L) {
        paramzzcfy.zzf(1, this.GI);
      }
      if ((this.tag != null) && (!this.tag.equals(""))) {
        paramzzcfy.zzu(2, this.tag);
      }
      int i;
      if ((this.GL != null) && (this.GL.length > 0))
      {
        i = 0;
        while (i < this.GL.length)
        {
          zzcgl.zze localzze = this.GL[i];
          if (localzze != null) {
            paramzzcfy.zza(3, localzze);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(this.GM, zzcgj.Gu)) {
        paramzzcfy.zzb(4, this.GM);
      }
      if (!Arrays.equals(this.GO, zzcgj.Gu)) {
        paramzzcfy.zzb(6, this.GO);
      }
      if (this.GR != null) {
        paramzzcfy.zza(7, this.GR);
      }
      if ((this.GP != null) && (!this.GP.equals(""))) {
        paramzzcfy.zzu(8, this.GP);
      }
      if (this.GN != null) {
        paramzzcfy.zza(9, this.GN);
      }
      if (this.pj) {
        paramzzcfy.zzk(10, this.pj);
      }
      if (this.eventCode != 0) {
        paramzzcfy.zzaa(11, this.eventCode);
      }
      if (this.zzrh != 0) {
        paramzzcfy.zzaa(12, this.zzrh);
      }
      if ((this.GQ != null) && (!this.GQ.equals(""))) {
        paramzzcfy.zzu(13, this.GQ);
      }
      if ((this.GS != null) && (!this.GS.equals(""))) {
        paramzzcfy.zzu(14, this.GS);
      }
      if (this.GT != 180000L) {
        paramzzcfy.zzh(15, this.GT);
      }
      if (this.GU != null) {
        paramzzcfy.zza(16, this.GU);
      }
      if (this.GJ != 0L) {
        paramzzcfy.zzf(17, this.GJ);
      }
      if (!Arrays.equals(this.GV, zzcgj.Gu)) {
        paramzzcfy.zzb(18, this.GV);
      }
      if (this.GX != 0) {
        paramzzcfy.zzaa(19, this.GX);
      }
      if ((this.GY != null) && (this.GY.length > 0))
      {
        i = j;
        while (i < this.GY.length)
        {
          paramzzcfy.zzaa(20, this.GY[i]);
          i += 1;
        }
      }
      if (this.GK != 0L) {
        paramzzcfy.zzf(21, this.GK);
      }
      if (this.GZ != 0L) {
        paramzzcfy.zzf(22, this.GZ);
      }
      if (this.Ha != null) {
        paramzzcfy.zza(23, this.Ha);
      }
      if ((this.GW != null) && (!this.GW.equals(""))) {
        paramzzcfy.zzu(24, this.GW);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzd zzanv()
    {
      this.GI = 0L;
      this.GJ = 0L;
      this.GK = 0L;
      this.tag = "";
      this.eventCode = 0;
      this.zzrh = 0;
      this.pj = false;
      this.GL = zzcgl.zze.zzanx();
      this.GM = zzcgj.Gu;
      this.GN = null;
      this.GO = zzcgj.Gu;
      this.GP = "";
      this.GQ = "";
      this.GR = null;
      this.GS = "";
      this.GT = 180000L;
      this.GU = null;
      this.GV = zzcgj.Gu;
      this.GW = "";
      this.GX = 0;
      this.GY = zzcgj.Gn;
      this.GZ = 0L;
      this.Ha = null;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzd zzanw()
    {
      try
      {
        zzd localzzd = (zzd)super.zzanb();
        if ((this.GL != null) && (this.GL.length > 0))
        {
          localzzd.GL = new zzcgl.zze[this.GL.length];
          int i = 0;
          while (i < this.GL.length)
          {
            if (this.GL[i] != null) {
              localzzd.GL[i] = ((zzcgl.zze)this.GL[i].clone());
            }
            i += 1;
          }
        }
        if (this.GN == null) {
          break label111;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
      localCloneNotSupportedException.GN = ((zzcgl.zzb)this.GN.clone());
      label111:
      if (this.GR != null) {
        localCloneNotSupportedException.GR = ((zzcgl.zza)this.GR.clone());
      }
      if (this.GU != null) {
        localCloneNotSupportedException.GU = ((zzcgl.zzc)this.GU.clone());
      }
      if ((this.GY != null) && (this.GY.length > 0)) {
        localCloneNotSupportedException.GY = ((int[])this.GY.clone());
      }
      if (this.Ha != null) {
        localCloneNotSupportedException.Ha = ((zzcgl.zzf)this.Ha.clone());
      }
      return localCloneNotSupportedException;
    }
    
    public zzd zzbi(zzcfx paramzzcfx)
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
        case 8: 
          this.GI = paramzzcfx.zzamL();
          break;
        case 18: 
          this.tag = paramzzcfx.readString();
          break;
        case 26: 
          j = zzcgj.zzb(paramzzcfx, 26);
          if (this.GL == null) {}
          for (i = 0;; i = this.GL.length)
          {
            localObject = new zzcgl.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GL, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzcgl.zze();
              paramzzcfx.zza(localObject[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = new zzcgl.zze();
          paramzzcfx.zza(localObject[j]);
          this.GL = ((zzcgl.zze[])localObject);
          break;
        case 34: 
          this.GM = paramzzcfx.readBytes();
          break;
        case 50: 
          this.GO = paramzzcfx.readBytes();
          break;
        case 58: 
          if (this.GR == null) {
            this.GR = new zzcgl.zza();
          }
          paramzzcfx.zza(this.GR);
          break;
        case 66: 
          this.GP = paramzzcfx.readString();
          break;
        case 74: 
          if (this.GN == null) {
            this.GN = new zzcgl.zzb();
          }
          paramzzcfx.zza(this.GN);
          break;
        case 80: 
          this.pj = paramzzcfx.zzamO();
          break;
        case 88: 
          this.eventCode = paramzzcfx.zzamM();
          break;
        case 96: 
          this.zzrh = paramzzcfx.zzamM();
          break;
        case 106: 
          this.GQ = paramzzcfx.readString();
          break;
        case 114: 
          this.GS = paramzzcfx.readString();
          break;
        case 120: 
          this.GT = paramzzcfx.zzamQ();
          break;
        case 130: 
          if (this.GU == null) {
            this.GU = new zzcgl.zzc();
          }
          paramzzcfx.zza(this.GU);
          break;
        case 136: 
          this.GJ = paramzzcfx.zzamL();
          break;
        case 146: 
          this.GV = paramzzcfx.readBytes();
          break;
        case 152: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            this.GX = i;
          }
          break;
        case 160: 
          j = zzcgj.zzb(paramzzcfx, 160);
          if (this.GY == null) {}
          for (i = 0;; i = this.GY.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GY, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          localObject[j] = paramzzcfx.zzamM();
          this.GY = ((int[])localObject);
          break;
        case 162: 
          int k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.GY == null) {}
          for (i = 0;; i = this.GY.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.GY, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.GY = ((int[])localObject);
          paramzzcfx.zzBw(k);
          break;
        case 168: 
          this.GK = paramzzcfx.zzamL();
          break;
        case 176: 
          this.GZ = paramzzcfx.zzamL();
          break;
        case 186: 
          if (this.Ha == null) {
            this.Ha = new zzcgl.zzf();
          }
          paramzzcfx.zza(this.Ha);
          break;
        case 194: 
          this.GW = paramzzcfx.readString();
        }
      }
    }
  }
  
  public static final class zze
    extends zzcfz<zze>
    implements Cloneable
  {
    private static volatile zze[] Hb;
    public String value;
    public String zzaA;
    
    public zze()
    {
      zzany();
    }
    
    public static zze[] zzanx()
    {
      if (Hb == null) {}
      synchronized (zzcge.Gh)
      {
        if (Hb == null) {
          Hb = new zze[0];
        }
        return Hb;
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
      if (this.value != null)
      {
        j = i;
        if (!this.value.equals("")) {
          j = i + zzcfy.zzv(2, this.value);
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
      label41:
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
          if (this.zzaA != null) {
            break;
          }
          bool1 = bool2;
        } while (((zze)paramObject).zzaA != null);
        if (this.value != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zze)paramObject).value != null);
      for (;;)
      {
        if ((this.FZ == null) || (this.FZ.isEmpty()))
        {
          if (((zze)paramObject).FZ != null)
          {
            bool1 = bool2;
            if (!((zze)paramObject).FZ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzaA.equals(((zze)paramObject).zzaA)) {
            break label41;
          }
          return false;
          label111:
          if (!this.value.equals(((zze)paramObject).value)) {
            return false;
          }
        }
      }
      return this.FZ.equals(((zze)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (this.zzaA == null)
      {
        i = 0;
        if (this.value != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (this.FZ != null) {
          if (!this.FZ.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = this.FZ.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.zzaA.hashCode();
        break;
        j = this.value.hashCode();
        break label33;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.zzaA != null) && (!this.zzaA.equals(""))) {
        paramzzcfy.zzu(1, this.zzaA);
      }
      if ((this.value != null) && (!this.value.equals(""))) {
        paramzzcfy.zzu(2, this.value);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zze zzany()
    {
      this.zzaA = "";
      this.value = "";
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zze zzanz()
    {
      try
      {
        zze localzze = (zze)super.zzanb();
        return localzze;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    public zze zzbj(zzcfx paramzzcfx)
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
        case 18: 
          this.value = paramzzcfx.readString();
        }
      }
    }
  }
  
  public static final class zzf
    extends zzcfz<zzf>
    implements Cloneable
  {
    public int Hc;
    public int networkType;
    
    public zzf()
    {
      zzanA();
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.networkType != -1) {
        i = j + zzcfy.zzac(1, this.networkType);
      }
      j = i;
      if (this.Hc != 0) {
        j = i + zzcfy.zzac(2, this.Hc);
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
            } while (!(paramObject instanceof zzf));
            paramObject = (zzf)paramObject;
            bool1 = bool2;
          } while (this.networkType != ((zzf)paramObject).networkType);
          bool1 = bool2;
        } while (this.Hc != ((zzf)paramObject).Hc);
        if ((this.FZ != null) && (!this.FZ.isEmpty())) {
          break label89;
        }
        if (((zzf)paramObject).FZ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzf)paramObject).FZ.isEmpty());
      return true;
      label89:
      return this.FZ.equals(((zzf)paramObject).FZ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.networkType;
      int m = this.Hc;
      if ((this.FZ == null) || (this.FZ.isEmpty())) {}
      for (int i = 0;; i = this.FZ.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.networkType != -1) {
        paramzzcfy.zzaa(1, this.networkType);
      }
      if (this.Hc != 0) {
        paramzzcfy.zzaa(2, this.Hc);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzf zzanA()
    {
      this.networkType = -1;
      this.Hc = 0;
      this.FZ = null;
      this.Gi = -1;
      return this;
    }
    
    public zzf zzanB()
    {
      try
      {
        zzf localzzf = (zzf)super.zzanb();
        return localzzf;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    public zzf zzbk(zzcfx paramzzcfx)
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
          case -1: 
          case 0: 
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
            this.networkType = i;
          }
          break;
        case 16: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
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
          case 100: 
            this.Hc = i;
          }
          break;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */