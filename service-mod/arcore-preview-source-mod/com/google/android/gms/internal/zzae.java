package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzae
{
  public static final class zza
    extends zzcfz<zza>
  {
    public zzae.zzb zzaJ;
    public zzae.zzc zzaK;
    
    public zza()
    {
      this.Gi = -1;
    }
    
    public static zza zzc(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zza)zzcgg.zza(new zza(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzaJ != null) {
        i = j + zzcfy.zzc(1, this.zzaJ);
      }
      j = i;
      if (this.zzaK != null) {
        j = i + zzcfy.zzc(2, this.zzaK);
      }
      return j;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzaJ != null) {
        paramzzcfy.zza(1, this.zzaJ);
      }
      if (this.zzaK != null) {
        paramzzcfy.zza(2, this.zzaK);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zza(zzcfx paramzzcfx)
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
          if (this.zzaJ == null) {
            this.zzaJ = new zzae.zzb();
          }
          paramzzcfx.zza(this.zzaJ);
          break;
        case 18: 
          if (this.zzaK == null) {
            this.zzaK = new zzae.zzc();
          }
          paramzzcfx.zza(this.zzaK);
        }
      }
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
  {
    public Integer zzaL = null;
    
    public zzb()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzaL != null) {
        i = j + zzcfy.zzac(27, this.zzaL.intValue());
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzaL != null) {
        paramzzcfy.zzaa(27, this.zzaL.intValue());
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzb(zzcfx paramzzcfx)
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
        case 216: 
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
            this.zzaL = Integer.valueOf(i);
          }
          break;
        }
      }
    }
  }
  
  public static final class zzc
    extends zzcfz<zzc>
  {
    public String zzaM = null;
    public String zzaN = null;
    public String zzaO = null;
    public String zzaP = null;
    public String zzaQ = null;
    
    public zzc()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzaM != null) {
        i = j + zzcfy.zzv(1, this.zzaM);
      }
      j = i;
      if (this.zzaN != null) {
        j = i + zzcfy.zzv(2, this.zzaN);
      }
      i = j;
      if (this.zzaO != null) {
        i = j + zzcfy.zzv(3, this.zzaO);
      }
      j = i;
      if (this.zzaP != null) {
        j = i + zzcfy.zzv(4, this.zzaP);
      }
      i = j;
      if (this.zzaQ != null) {
        i = j + zzcfy.zzv(5, this.zzaQ);
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzaM != null) {
        paramzzcfy.zzu(1, this.zzaM);
      }
      if (this.zzaN != null) {
        paramzzcfy.zzu(2, this.zzaN);
      }
      if (this.zzaO != null) {
        paramzzcfy.zzu(3, this.zzaO);
      }
      if (this.zzaP != null) {
        paramzzcfy.zzu(4, this.zzaP);
      }
      if (this.zzaQ != null) {
        paramzzcfy.zzu(5, this.zzaQ);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzc zzc(zzcfx paramzzcfx)
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
          this.zzaM = paramzzcfx.readString();
          break;
        case 18: 
          this.zzaN = paramzzcfx.readString();
          break;
        case 26: 
          this.zzaO = paramzzcfx.readString();
          break;
        case 34: 
          this.zzaP = paramzzcfx.readString();
          break;
        case 42: 
          this.zzaQ = paramzzcfx.readString();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */