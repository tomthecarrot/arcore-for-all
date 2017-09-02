package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.zzt;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String zzOI = null;
    private int zzbDq = 0;
    private long zzbDr = Long.MIN_VALUE;
    private short zzbDs = -1;
    private double zzbDt;
    private double zzbDu;
    private float zzbDv;
    private int zzbDw = 0;
    private int zzbDx = -1;
    
    public Geofence build()
    {
      if (this.zzOI == null) {
        throw new IllegalArgumentException("Request ID not set.");
      }
      if (this.zzbDq == 0) {
        throw new IllegalArgumentException("Transitions types not set.");
      }
      if (((this.zzbDq & 0x4) != 0) && (this.zzbDx < 0)) {
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      }
      if (this.zzbDr == Long.MIN_VALUE) {
        throw new IllegalArgumentException("Expiration not set.");
      }
      if (this.zzbDs == -1) {
        throw new IllegalArgumentException("Geofence region not set.");
      }
      if (this.zzbDw < 0) {
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      }
      return new zzt(this.zzOI, this.zzbDq, (short)1, this.zzbDt, this.zzbDu, this.zzbDv, this.zzbDr, this.zzbDw, this.zzbDx);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.zzbDs = 1;
      this.zzbDt = paramDouble1;
      this.zzbDu = paramDouble2;
      this.zzbDv = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.zzbDr = -1L;
        return this;
      }
      this.zzbDr = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.zzbDx = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.zzbDw = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.zzOI = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.zzbDq = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */