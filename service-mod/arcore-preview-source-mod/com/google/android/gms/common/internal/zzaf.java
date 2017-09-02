package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf
  extends zza
{
  public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
  final int mVersionCode;
  private boolean zzaNa;
  IBinder zzaRb;
  private ConnectionResult zzaSG;
  private boolean zzaSH;
  
  zzaf(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzaRb = paramIBinder;
    this.zzaSG = paramConnectionResult;
    this.zzaNa = paramBoolean1;
    this.zzaSH = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaf)) {
        return false;
      }
      paramObject = (zzaf)paramObject;
    } while ((this.zzaSG.equals(((zzaf)paramObject).zzaSG)) && (zzAa().equals(((zzaf)paramObject).zzAa())));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
  
  public zzr zzAa()
  {
    return zzr.zza.zzde(this.zzaRb);
  }
  
  public ConnectionResult zzAb()
  {
    return this.zzaSG;
  }
  
  public boolean zzAc()
  {
    return this.zzaNa;
  }
  
  public boolean zzAd()
  {
    return this.zzaSH;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */