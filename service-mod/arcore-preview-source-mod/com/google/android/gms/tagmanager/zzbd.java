package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;

class zzbd
  implements zzbz
{
  private final String mAction;
  private final long zzaff;
  private final int zzafg;
  private double zzafh;
  private long zzafi;
  private final Object zzafj = new Object();
  private final long zzcuX;
  private final Clock zzvi;
  
  public zzbd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString, Clock paramClock)
  {
    this.zzafg = paramInt2;
    this.zzafh = Math.min(paramInt1, paramInt2);
    this.zzaff = paramLong1;
    this.zzcuX = paramLong2;
    this.mAction = paramString;
    this.zzvi = paramClock;
  }
  
  public boolean zzpu()
  {
    synchronized (this.zzafj)
    {
      long l = this.zzvi.currentTimeMillis();
      if (l - this.zzafi < this.zzcuX)
      {
        String str1 = this.mAction;
        Log.w(String.valueOf(str1).length() + 34 + "Excessive " + str1 + " detected; call ignored.");
        return false;
      }
      if (this.zzafh < this.zzafg)
      {
        double d = (l - this.zzafi) / this.zzaff;
        if (d > 0.0D) {
          this.zzafh = Math.min(this.zzafg, d + this.zzafh);
        }
      }
      this.zzafi = l;
      if (this.zzafh >= 1.0D)
      {
        this.zzafh -= 1.0D;
        return true;
      }
    }
    String str2 = this.mAction;
    Log.w(String.valueOf(str2).length() + 34 + "Excessive " + str2 + " detected; call ignored.");
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */