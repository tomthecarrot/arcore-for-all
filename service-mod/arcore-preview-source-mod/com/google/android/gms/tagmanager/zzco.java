package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;

class zzco
  implements zzbz
{
  private final long zzaff;
  private final int zzafg;
  private double zzafh;
  private final Object zzafj = new Object();
  private long zzcwp;
  private final Clock zzvi;
  
  public zzco()
  {
    this(60, 2000L);
  }
  
  public zzco(int paramInt, long paramLong)
  {
    this.zzafg = paramInt;
    this.zzafh = this.zzafg;
    this.zzaff = paramLong;
    this.zzvi = zzh.zzAM();
  }
  
  public boolean zzpu()
  {
    synchronized (this.zzafj)
    {
      long l = this.zzvi.currentTimeMillis();
      if (this.zzafh < this.zzafg)
      {
        double d = (l - this.zzcwp) / this.zzaff;
        if (d > 0.0D) {
          this.zzafh = Math.min(this.zzafg, d + this.zzafh);
        }
      }
      this.zzcwp = l;
      if (this.zzafh >= 1.0D)
      {
        this.zzafh -= 1.0D;
        return true;
      }
      Log.w("No more tokens available.");
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */