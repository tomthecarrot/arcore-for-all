package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public final class Status
  extends zza
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzh();
  public static final Status zzaLc = new Status(0);
  public static final Status zzaLd = new Status(14);
  public static final Status zzaLe = new Status(8);
  public static final Status zzaLf = new Status(15);
  public static final Status zzaLg = new Status(16);
  public static final Status zzaLh = new Status(17);
  public static final Status zzaLi = new Status(18);
  private final PendingIntent mPendingIntent;
  final int mVersionCode;
  private final int zzaGj;
  private final String zzaJP;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.zzaGj = paramInt2;
    this.zzaJP = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.mVersionCode != ((Status)paramObject).mVersionCode) || (this.zzaGj != ((Status)paramObject).zzaGj) || (!zzaa.equal(this.zzaJP, ((Status)paramObject).zzaJP)) || (!zzaa.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
    return true;
  }
  
  PendingIntent getPendingIntent()
  {
    return this.mPendingIntent;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.zzaGj;
  }
  
  @Nullable
  public String getStatusMessage()
  {
    return this.zzaJP;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzaGj), this.zzaJP, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    return this.zzaGj == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.zzaGj == 14;
  }
  
  public boolean isSuccess()
  {
    return this.zzaGj <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return zzaa.zzB(this).zzh("statusCode", zzxh()).zzh("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzxh()
  {
    if (this.zzaJP != null) {
      return this.zzaJP;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzaGj);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */