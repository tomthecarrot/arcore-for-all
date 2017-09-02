package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SleepSegmentEvent
  extends zza
{
  public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new zzx();
  public static final int STATUS_MISSING_DATA = 1;
  public static final int STATUS_SUCCESSFUL = 0;
  private final int zzJD;
  private final long zzaeN;
  private final long zzbjk;
  
  public SleepSegmentEvent(long paramLong1, long paramLong2, int paramInt)
  {
    if (0L < paramLong1)
    {
      bool1 = true;
      zzac.zzb(bool1, "startTimeMillis must be greater than 0.");
      if (0L >= paramLong2) {
        break label79;
      }
      bool1 = true;
      label32:
      zzac.zzb(bool1, "endTimeMillis must be greater than 0.");
      if (paramLong1 > paramLong2) {
        break label85;
      }
    }
    label79:
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, "endTimeMillis must be greater than or equal to startTimeMillis");
      this.zzaeN = paramLong1;
      this.zzbjk = paramLong2;
      this.zzJD = paramInt;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
    }
  }
  
  public static List<SleepSegmentEvent> extractEvents(Intent paramIntent)
  {
    if (!hasEvents(paramIntent)) {
      return Collections.emptyList();
    }
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
    paramIntent = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(zzE((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public static boolean hasEvents(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
  }
  
  public static SleepSegmentEvent zzE(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return (SleepSegmentEvent)zzd.zza(paramArrayOfByte, CREATOR);
  }
  
  public long getEndTimeMillis()
  {
    return this.zzbjk;
  }
  
  public long getStartTimeMillis()
  {
    return this.zzaeN;
  }
  
  public int getStatus()
  {
    return this.zzJD;
  }
  
  public String toString()
  {
    return String.format("startTimeMillis=%d, endTimeMillis=%d, mStatus=%d]", new Object[] { Long.valueOf(this.zzaeN), Long.valueOf(this.zzbjk), Integer.valueOf(this.zzJD) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzx.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/SleepSegmentEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */