package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzd
  extends zza
{
  public static final Parcelable.Creator<zzd> CREATOR = new zze();
  private final int zzbDb;
  private final int zzbjl;
  
  zzd(int paramInt1, int paramInt2)
  {
    this.zzbjl = paramInt1;
    this.zzbDb = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
    } while ((this.zzbjl == ((zzd)paramObject).zzbjl) && (this.zzbDb == ((zzd)paramObject).zzbDb));
    return false;
  }
  
  public int getActivityType()
  {
    return this.zzbjl;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzbjl), Integer.valueOf(this.zzbDb) });
  }
  
  public String toString()
  {
    int i = this.zzbjl;
    int j = this.zzbDb;
    return 75 + "ActivityTransition [mActivityType=" + i + ", mTransitionType=" + j + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public int zzKf()
  {
    return this.zzbDb;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */