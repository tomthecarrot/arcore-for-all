package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.List;

public class zzv
  extends zza
{
  public static final Parcelable.Creator<zzv> CREATOR = new zzw();
  private final PendingIntent mPendingIntent;
  private final String mTag;
  private final List<String> zzbEm;
  
  zzv(@Nullable List<String> paramList, @Nullable PendingIntent paramPendingIntent, String paramString)
  {
    if (paramList == null) {}
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      this.zzbEm = paramList;
      this.mPendingIntent = paramPendingIntent;
      this.mTag = paramString;
      return;
    }
  }
  
  public static zzv zzP(List<String> paramList)
  {
    zzac.zzb(paramList, "geofence can't be null.");
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Geofences must contains at least one id.");
      return new zzv(paramList, null, "");
    }
  }
  
  public static zzv zzb(PendingIntent paramPendingIntent)
  {
    zzac.zzb(paramPendingIntent, "PendingIntent can not be null.");
    return new zzv(null, paramPendingIntent, "");
  }
  
  public PendingIntent getPendingIntent()
  {
    return this.mPendingIntent;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzKm()
  {
    return this.zzbEm;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */