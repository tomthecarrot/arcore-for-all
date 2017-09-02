package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzaf
{
  public static final class zza
    extends zzcfz<zza>
  {
    public String stackTrace = null;
    public String zzaR = null;
    public Long zzaS = null;
    public String zzaT = null;
    public String zzaU = null;
    public Long zzaV = null;
    public Long zzaW = null;
    public String zzaX = null;
    public Long zzaY = null;
    public String zzaZ = null;
    
    public zza()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzaR != null) {
        i = j + zzcfy.zzv(1, this.zzaR);
      }
      j = i;
      if (this.zzaS != null) {
        j = i + zzcfy.zzj(2, this.zzaS.longValue());
      }
      i = j;
      if (this.stackTrace != null) {
        i = j + zzcfy.zzv(3, this.stackTrace);
      }
      j = i;
      if (this.zzaT != null) {
        j = i + zzcfy.zzv(4, this.zzaT);
      }
      i = j;
      if (this.zzaU != null) {
        i = j + zzcfy.zzv(5, this.zzaU);
      }
      j = i;
      if (this.zzaV != null) {
        j = i + zzcfy.zzj(6, this.zzaV.longValue());
      }
      i = j;
      if (this.zzaW != null) {
        i = j + zzcfy.zzj(7, this.zzaW.longValue());
      }
      j = i;
      if (this.zzaX != null) {
        j = i + zzcfy.zzv(8, this.zzaX);
      }
      i = j;
      if (this.zzaY != null) {
        i = j + zzcfy.zzj(9, this.zzaY.longValue());
      }
      j = i;
      if (this.zzaZ != null) {
        j = i + zzcfy.zzv(10, this.zzaZ);
      }
      return j;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzaR != null) {
        paramzzcfy.zzu(1, this.zzaR);
      }
      if (this.zzaS != null) {
        paramzzcfy.zzf(2, this.zzaS.longValue());
      }
      if (this.stackTrace != null) {
        paramzzcfy.zzu(3, this.stackTrace);
      }
      if (this.zzaT != null) {
        paramzzcfy.zzu(4, this.zzaT);
      }
      if (this.zzaU != null) {
        paramzzcfy.zzu(5, this.zzaU);
      }
      if (this.zzaV != null) {
        paramzzcfy.zzf(6, this.zzaV.longValue());
      }
      if (this.zzaW != null) {
        paramzzcfy.zzf(7, this.zzaW.longValue());
      }
      if (this.zzaX != null) {
        paramzzcfy.zzu(8, this.zzaX);
      }
      if (this.zzaY != null) {
        paramzzcfy.zzf(9, this.zzaY.longValue());
      }
      if (this.zzaZ != null) {
        paramzzcfy.zzu(10, this.zzaZ);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zzd(zzcfx paramzzcfx)
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
          this.zzaR = paramzzcfx.readString();
          break;
        case 16: 
          this.zzaS = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 26: 
          this.stackTrace = paramzzcfx.readString();
          break;
        case 34: 
          this.zzaT = paramzzcfx.readString();
          break;
        case 42: 
          this.zzaU = paramzzcfx.readString();
          break;
        case 48: 
          this.zzaV = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 56: 
          this.zzaW = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 66: 
          this.zzaX = paramzzcfx.readString();
          break;
        case 72: 
          this.zzaY = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 82: 
          this.zzaZ = paramzzcfx.readString();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */