package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbge
  extends zza
  implements Result
{
  public static final Parcelable.Creator<zzbge> CREATOR = new zzbgf();
  final int mVersionCode;
  private int zzcqH;
  private Intent zzcqI;
  
  public zzbge()
  {
    this(0, null);
  }
  
  zzbge(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mVersionCode = paramInt1;
    this.zzcqH = paramInt2;
    this.zzcqI = paramIntent;
  }
  
  public zzbge(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }
  
  public Status getStatus()
  {
    if (this.zzcqH == 0) {
      return Status.zzaLc;
    }
    return Status.zzaLg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbgf.zza(this, paramParcel, paramInt);
  }
  
  public int zzWd()
  {
    return this.zzcqH;
  }
  
  public Intent zzWe()
  {
    return this.zzcqI;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */