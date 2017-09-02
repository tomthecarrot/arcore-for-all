package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  extends zza
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzs();
  private final boolean zzbEb;
  private final boolean zzbEc;
  private LocationSettingsConfiguration zzbEd;
  private final List<LocationRequest> zzbmB;
  
  LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, LocationSettingsConfiguration paramLocationSettingsConfiguration)
  {
    this.zzbmB = paramList;
    this.zzbEb = paramBoolean1;
    this.zzbEc = paramBoolean2;
    this.zzbEd = paramLocationSettingsConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
  
  public List<LocationRequest> zzGa()
  {
    return Collections.unmodifiableList(this.zzbmB);
  }
  
  public boolean zzKj()
  {
    return this.zzbEb;
  }
  
  public boolean zzKk()
  {
    return this.zzbEc;
  }
  
  @Nullable
  public LocationSettingsConfiguration zzKl()
  {
    return this.zzbEd;
  }
  
  public static final class Builder
  {
    private boolean zzbEb = false;
    private boolean zzbEc = false;
    private LocationSettingsConfiguration zzbEd = null;
    private final ArrayList<LocationRequest> zzbEe = new ArrayList();
    
    public Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      this.zzbEe.addAll(paramCollection);
      return this;
    }
    
    public Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      this.zzbEe.add(paramLocationRequest);
      return this;
    }
    
    public LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(this.zzbEe, this.zzbEb, this.zzbEc, this.zzbEd);
    }
    
    public Builder setAlwaysShow(boolean paramBoolean)
    {
      this.zzbEb = paramBoolean;
      return this;
    }
    
    public Builder setConfiguration(LocationSettingsConfiguration paramLocationSettingsConfiguration)
    {
      this.zzbEd = paramLocationSettingsConfiguration;
      return this;
    }
    
    public Builder setNeedBle(boolean paramBoolean)
    {
      this.zzbEc = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationSettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */