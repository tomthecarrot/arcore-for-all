package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzc();
  Bundle extras;
  List<DetectedActivity> zzbCX;
  long zzbCY;
  long zzbCZ;
  int zzbDa;
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, paramInt, paramBundle);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = true;
      zzac.zzb(bool1, "Must have at least 1 detected activity");
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label89;
      }
    }
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, "Must set times");
      this.zzbCX = paramList;
      this.zzbCY = paramLong1;
      this.zzbCZ = paramLong2;
      this.zzbDa = paramInt;
      this.extras = paramBundle;
      return;
      bool1 = false;
      break;
    }
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    this(paramList, paramLong1, paramLong2, 0, paramBundle);
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    ActivityRecognitionResult localActivityRecognitionResult = zzG(paramIntent);
    if (localActivityRecognitionResult != null) {
      return localActivityRecognitionResult;
    }
    paramIntent = zzI(paramIntent);
    if ((paramIntent == null) || (paramIntent.isEmpty())) {
      return null;
    }
    return (ActivityRecognitionResult)paramIntent.get(paramIntent.size() - 1);
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramIntent == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (zzF(paramIntent));
      paramIntent = zzI(paramIntent);
      if (paramIntent == null) {
        break;
      }
      bool1 = bool2;
    } while (!paramIntent.isEmpty());
    return false;
  }
  
  private static boolean zzF(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  private static ActivityRecognitionResult zzG(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    paramIntent = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    if ((paramIntent instanceof byte[])) {
      return (ActivityRecognitionResult)zzd.zza((byte[])paramIntent, CREATOR);
    }
    if ((paramIntent instanceof ActivityRecognitionResult)) {
      return (ActivityRecognitionResult)paramIntent;
    }
    return null;
  }
  
  public static boolean zzH(@Nullable Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST");
  }
  
  @Nullable
  public static List<ActivityRecognitionResult> zzI(Intent paramIntent)
  {
    if (!zzH(paramIntent)) {
      return null;
    }
    return zzd.zzb(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
  }
  
  private static boolean zzd(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return true;
    }
    if (((paramBundle1 == null) && (paramBundle2 != null)) || ((paramBundle1 != null) && (paramBundle2 == null))) {
      return false;
    }
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle2.containsKey(str)) {
        return false;
      }
      if (paramBundle1.get(str) == null)
      {
        if (paramBundle2.get(str) != null) {
          return false;
        }
      }
      else if ((paramBundle1.get(str) instanceof Bundle))
      {
        if (!zzd(paramBundle1.getBundle(str), paramBundle2.getBundle(str))) {
          return false;
        }
      }
      else if (!paramBundle1.get(str).equals(paramBundle2.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
    } while ((this.zzbCY == ((ActivityRecognitionResult)paramObject).zzbCY) && (this.zzbCZ == ((ActivityRecognitionResult)paramObject).zzbCZ) && (this.zzbDa == ((ActivityRecognitionResult)paramObject).zzbDa) && (zzaa.equal(this.zzbCX, ((ActivityRecognitionResult)paramObject).zzbCX)) && (zzd(this.extras, ((ActivityRecognitionResult)paramObject).extras)));
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.zzbCX.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.zzbCZ;
  }
  
  @Nullable
  public Bundle getExtras()
  {
    if (this.extras == null) {
      return null;
    }
    return (Bundle)this.extras.clone();
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.zzbCX.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return this.zzbCX;
  }
  
  public long getTime()
  {
    return this.zzbCY;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Long.valueOf(this.zzbCY), Long.valueOf(this.zzbCZ), Integer.valueOf(this.zzbDa), this.zzbCX, this.extras });
  }
  
  public String toString()
  {
    String str = String.valueOf(this.zzbCX);
    long l1 = this.zzbCY;
    long l2 = this.zzbCZ;
    return String.valueOf(str).length() + 124 + "ActivityRecognitionResult [probableActivities=" + str + ", timeMillis=" + l1 + ", elapsedRealtimeMillis=" + l2 + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static class ExtrasUtils
  {
    public static final String BUNDLE_KEY_VEHICLE_PERSONAL_CONFIDENCE = "vehicle_personal_confidence";
    public static final int CONFIDENCE_UNDEFINED = -1;
    
    public static int getConfidence(@Nullable Bundle paramBundle, String paramString)
    {
      return getConfidence(paramBundle, paramString, -1);
    }
    
    public static int getConfidence(@Nullable Bundle paramBundle, String paramString, int paramInt)
    {
      if (paramBundle == null) {
        return paramInt;
      }
      return paramBundle.getInt("vehicle_personal_confidence", paramInt);
    }
    
    public static boolean isValidConfidence(int paramInt)
    {
      return (paramInt <= 100) && (paramInt >= 0);
    }
    
    public static Bundle putConfidenceInExtrasBundle(@Nullable Bundle paramBundle, String paramString, int paramInt)
    {
      zzac.zzaw(isValidConfidence(paramInt));
      zzac.zzaw(paramString.equals("vehicle_personal_confidence"));
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt(paramString, paramInt);
      return localBundle;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */