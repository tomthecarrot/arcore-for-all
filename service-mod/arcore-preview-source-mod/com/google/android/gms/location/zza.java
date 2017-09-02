package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import android.support.annotation.Nullable;

public class zza
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zza> CREATOR = new zzb();
  @Nullable
  private String mTag;
  @Nullable
  private String zzakE;
  private long zzbCR;
  private boolean zzbCS;
  @Nullable
  private WorkSource zzbCT;
  @Nullable
  private int[] zzbCU;
  @Nullable
  private boolean zzbCV;
  private final long zzbCW;
  
  zza(long paramLong1, boolean paramBoolean1, @Nullable WorkSource paramWorkSource, @Nullable String paramString1, @Nullable int[] paramArrayOfInt, boolean paramBoolean2, @Nullable String paramString2, long paramLong2)
  {
    this.zzbCR = paramLong1;
    this.zzbCS = paramBoolean1;
    this.zzbCT = paramWorkSource;
    this.mTag = paramString1;
    this.zzbCU = paramArrayOfInt;
    this.zzbCV = paramBoolean2;
    this.zzakE = paramString2;
    this.zzbCW = paramLong2;
  }
  
  @Nullable
  public String getAccountName()
  {
    return this.zzakE;
  }
  
  public long getIntervalMillis()
  {
    return this.zzbCR;
  }
  
  @Nullable
  public String getTag()
  {
    return this.mTag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzKa()
  {
    return this.zzbCS;
  }
  
  @Nullable
  public WorkSource zzKb()
  {
    return this.zzbCT;
  }
  
  @Nullable
  public int[] zzKc()
  {
    return this.zzbCU;
  }
  
  public boolean zzKd()
  {
    return this.zzbCV;
  }
  
  public long zzKe()
  {
    return this.zzbCW;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */