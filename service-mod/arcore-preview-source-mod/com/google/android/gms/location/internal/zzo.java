package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class zzo
  extends zza
{
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();
  static final List<zzc> zzbEQ = ;
  @Nullable
  String mTag;
  boolean zzbCS = true;
  List<zzc> zzbDe;
  boolean zzbER;
  boolean zzbES;
  LocationRequest zzbmE;
  
  zzo(LocationRequest paramLocationRequest, List<zzc> paramList, @Nullable String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzbmE = paramLocationRequest;
    this.zzbDe = paramList;
    this.mTag = paramString;
    this.zzbER = paramBoolean1;
    this.zzbES = paramBoolean2;
  }
  
  public static zzo zza(@Nullable String paramString, LocationRequest paramLocationRequest)
  {
    return new zzo(paramLocationRequest, zzbEQ, paramString, false, false);
  }
  
  @Deprecated
  public static zzo zzb(LocationRequest paramLocationRequest)
  {
    return zza(null, paramLocationRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzo)) {}
    do
    {
      return false;
      paramObject = (zzo)paramObject;
    } while ((!zzaa.equal(this.zzbmE, ((zzo)paramObject).zzbmE)) || (!zzaa.equal(this.zzbDe, ((zzo)paramObject).zzbDe)) || (!zzaa.equal(this.mTag, ((zzo)paramObject).mTag)) || (this.zzbER != ((zzo)paramObject).zzbER) || (this.zzbES != ((zzo)paramObject).zzbES));
    return true;
  }
  
  public int hashCode()
  {
    return this.zzbmE.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.zzbmE.toString());
    if (this.mTag != null) {
      localStringBuilder.append(" tag=").append(this.mTag);
    }
    localStringBuilder.append(" hideAppOps=").append(this.zzbER);
    localStringBuilder.append(" clients=").append(this.zzbDe);
    localStringBuilder.append(" forceCoarseLocation=").append(this.zzbES);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */