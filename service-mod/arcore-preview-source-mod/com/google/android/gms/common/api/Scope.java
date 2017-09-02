package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class Scope
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzg();
  final int mVersionCode;
  private final String zzaLb;
  
  Scope(int paramInt, String paramString)
  {
    zzac.zzi(paramString, "scopeUri must not be null or empty");
    this.mVersionCode = paramInt;
    this.zzaLb = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return this.zzaLb.equals(((Scope)paramObject).zzaLb);
  }
  
  public int hashCode()
  {
    return this.zzaLb.hashCode();
  }
  
  public String toString()
  {
    return this.zzaLb;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzxg()
  {
    return this.zzaLb;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */