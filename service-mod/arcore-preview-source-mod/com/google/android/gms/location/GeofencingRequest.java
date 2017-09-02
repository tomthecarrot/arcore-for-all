package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.internal.zzt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest
  extends zza
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzj();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;
  private final String mTag;
  private final List<zzt> zzbDB;
  private final int zzbDC;
  
  GeofencingRequest(List<zzt> paramList, int paramInt, String paramString)
  {
    this.zzbDB = paramList;
    this.zzbDC = paramInt;
    this.mTag = paramString;
  }
  
  public List<Geofence> getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.zzbDB);
    return localArrayList;
  }
  
  public int getInitialTrigger()
  {
    return this.zzbDC;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public List<zzt> zzKi()
  {
    return this.zzbDB;
  }
  
  public static final class Builder
  {
    private String mTag = "";
    private final List<zzt> zzbDB = new ArrayList();
    private int zzbDC = 5;
    
    public static int zznQ(int paramInt)
    {
      return paramInt & 0x7;
    }
    
    public Builder addGeofence(Geofence paramGeofence)
    {
      zzac.zzb(paramGeofence, "geofence can't be null.");
      zzac.zzb(paramGeofence instanceof zzt, "Geofence must be created using Geofence.Builder.");
      this.zzbDB.add((zzt)paramGeofence);
      return this;
    }
    
    public Builder addGeofences(List<Geofence> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {}
      for (;;)
      {
        return this;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Geofence localGeofence = (Geofence)paramList.next();
          if (localGeofence != null) {
            addGeofence(localGeofence);
          }
        }
      }
    }
    
    public GeofencingRequest build()
    {
      if (!this.zzbDB.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "No geofence has been added to this request.");
        return new GeofencingRequest(this.zzbDB, this.zzbDC, this.mTag);
      }
    }
    
    public Builder setInitialTrigger(int paramInt)
    {
      this.zzbDC = zznQ(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/GeofencingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */