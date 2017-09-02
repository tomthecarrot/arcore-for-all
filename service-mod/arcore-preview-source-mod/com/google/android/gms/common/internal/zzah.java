package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah
  extends zza
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();
  final int mVersionCode;
  @Deprecated
  private final Scope[] zzaRc;
  private final int zzaSI;
  private final int zzaSJ;
  
  zzah(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    this.mVersionCode = paramInt1;
    this.zzaSI = paramInt2;
    this.zzaSJ = paramInt3;
    this.zzaRc = paramArrayOfScope;
  }
  
  public zzah(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzai.zza(this, paramParcel, paramInt);
  }
  
  public int zzAe()
  {
    return this.zzaSI;
  }
  
  public int zzAf()
  {
    return this.zzaSJ;
  }
  
  @Deprecated
  public Scope[] zzAg()
  {
    return this.zzaRc;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */