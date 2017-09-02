package com.google.android.gms.location.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public class NlpTestingRequest
  extends zza
{
  public static final Parcelable.Creator<NlpTestingRequest> CREATOR = new zzs();
  public static final long TRIGGER_ACTIVE_COLLECTION = 1L;
  public static final long TRIGGER_SENSOR_COLLECTION = 2L;
  public static final long TRIGGER_SMART_COLLECTION = 4L;
  private final long zzbEY;
  
  public NlpTestingRequest(long paramLong)
  {
    this.zzbEY = paramLong;
  }
  
  public static NlpTestingRequest fromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return null;
      paramIntent = paramIntent.getByteArrayExtra("com.google.android.gms.location.internal.EXTRA_NLP_TESTING_REQUEST");
    } while (paramIntent == null);
    return (NlpTestingRequest)zzd.zza(paramIntent, CREATOR);
  }
  
  public long getTriggers()
  {
    return this.zzbEY;
  }
  
  public boolean hasTriggers(long paramLong)
  {
    return (this.zzbEY & paramLong) > 0L;
  }
  
  public Intent toTestingIntent()
  {
    Intent localIntent = new Intent("com.google.android.location.internal.intent.action.NLP_TESTING");
    localIntent.putExtra("com.google.android.gms.location.internal.EXTRA_NLP_TESTING_REQUEST", zzd.zza(this));
    return localIntent;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/NlpTestingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */