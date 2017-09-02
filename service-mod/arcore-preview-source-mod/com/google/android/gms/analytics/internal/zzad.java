package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.util.Clock;

public class zzad
{
  private final String mAction;
  private final long zzaff;
  private final int zzafg;
  private double zzafh;
  private long zzafi;
  private final Object zzafj = new Object();
  private final Clock zzvi;
  
  public zzad(int paramInt, long paramLong, String paramString, Clock paramClock)
  {
    this.zzafg = paramInt;
    this.zzafh = this.zzafg;
    this.zzaff = paramLong;
    this.mAction = paramString;
    this.zzvi = paramClock;
  }
  
  public zzad(String paramString, Clock paramClock)
  {
    this(60, 2000L, paramString, paramClock);
  }
  
  public boolean zzpu()
  {
    synchronized (this.zzafj)
    {
      long l = this.zzvi.currentTimeMillis();
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
      String str = this.mAction;
      zzae.w(String.valueOf(str).length() + 34 + "Excessive " + str + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */