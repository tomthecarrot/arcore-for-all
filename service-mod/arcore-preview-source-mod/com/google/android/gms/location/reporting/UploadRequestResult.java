package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public final class UploadRequestResult
  extends zza
{
  public static final int CALLER_NOT_AUTHORIZED = 4;
  public static final Parcelable.Creator<UploadRequestResult> CREATOR = new zze();
  public static final int DURATION_TOO_LONG = 2;
  @Deprecated
  public static final int EXPIRATION_TOO_LATE = 2;
  public static final long FAILURE_REQUEST_ID = -1L;
  public static final int ID_NOT_FOUND = 100;
  public static final int INVALID_REQUEST = 5;
  public static final int REPORTING_NOT_ACTIVE = 3;
  public static final int SUCCESS = 0;
  public static final int TOO_MANY_REQUESTS = 6;
  private final int mResultCode;
  private final long zzaGe;
  
  public UploadRequestResult(int paramInt, long paramLong)
  {
    this.mResultCode = paramInt;
    this.zzaGe = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UploadRequestResult)) {}
    do
    {
      return false;
      paramObject = (UploadRequestResult)paramObject;
    } while ((this.zzaGe != ((UploadRequestResult)paramObject).zzaGe) || (this.mResultCode != ((UploadRequestResult)paramObject).mResultCode));
    return true;
  }
  
  public long getRequestId()
  {
    return this.zzaGe;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.mResultCode), Long.valueOf(this.zzaGe) });
  }
  
  public String toString()
  {
    int i = this.mResultCode;
    long l = this.zzaGe;
    return 66 + "Result{, mResultCode=" + i + ", mRequestId=" + l + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/UploadRequestResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */