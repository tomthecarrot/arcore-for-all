package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

public class zzabq
  extends zza
{
  public static final Parcelable.Creator<zzabq> CREATOR = new zzabr();
  final int mVersionCode;
  private final zzabs zzaTn;
  
  zzabq(int paramInt, zzabs paramzzabs)
  {
    this.mVersionCode = paramInt;
    this.zzaTn = paramzzabs;
  }
  
  private zzabq(zzabs paramzzabs)
  {
    this.mVersionCode = 1;
    this.zzaTn = paramzzabs;
  }
  
  public static zzabq zza(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter)
  {
    if ((paramFieldConverter instanceof zzabs)) {
      return new zzabq((zzabs)paramFieldConverter);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzabr.zza(this, paramParcel, paramInt);
  }
  
  zzabs zzAl()
  {
    return this.zzaTn;
  }
  
  public FastJsonResponse.FieldConverter<?, ?> zzAm()
  {
    if (this.zzaTn != null) {
      return this.zzaTn;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */