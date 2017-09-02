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

public class FloorChangeEvent
  extends zza
{
  public static final Parcelable.Creator<FloorChangeEvent> CREATOR = new zzi();
  public static final int TYPE_ELEVATOR = 2;
  public static final int TYPE_ESCALATOR = 3;
  public static final int TYPE_STAIRS = 1;
  private final long zzaeN;
  private final int zzahZ;
  private final int zzbDk;
  private final long zzbDl;
  private final long zzbDm;
  private final float zzbDn;
  private final long zzbjk;
  
  public FloorChangeEvent(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat)
  {
    if (paramInt2 >= 0)
    {
      bool = true;
      zzac.zzb(bool, "confidence must be equal to or greater than 0");
      if (paramInt2 > 100) {
        break label183;
      }
      bool = true;
      label27:
      zzac.zzb(bool, "confidence must be equal to or less than 100");
      if (0L >= paramLong1) {
        break label189;
      }
      bool = true;
      label43:
      zzac.zzb(bool, "startTimeMillis must be greater than 0");
      if (paramLong1 > paramLong2) {
        break label195;
      }
      bool = true;
      label60:
      zzac.zzb(bool, "endTimeMillis must be equal to or greater than startTimeMillis");
      if (0L > paramLong3) {
        break label201;
      }
      bool = true;
      label77:
      zzac.zzb(bool, "startElapsedRealtimeMillis must be equal to or greater than 0");
      if (paramLong3 > paramLong4) {
        break label207;
      }
      bool = true;
      label95:
      zzac.zzb(bool, "endElapsedRealtimeMillis must be equal to or greater than startElapsedRealtimeMillis");
      if (paramLong3 >= paramLong1) {
        break label213;
      }
      bool = true;
      label112:
      zzac.zzb(bool, "startTimeMillis must be greater than startElapsedRealtimeMillis");
      if (paramLong4 >= paramLong2) {
        break label219;
      }
    }
    label183:
    label189:
    label195:
    label201:
    label207:
    label213:
    label219:
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "endTimeMillis must be greater than endElapsedRealtimeMillis");
      this.zzahZ = paramInt1;
      this.zzbDk = paramInt2;
      this.zzaeN = paramLong1;
      this.zzbjk = paramLong2;
      this.zzbDl = paramLong3;
      this.zzbDm = paramLong4;
      this.zzbDn = paramFloat;
      return;
      bool = false;
      break;
      bool = false;
      break label27;
      bool = false;
      break label43;
      bool = false;
      break label60;
      bool = false;
      break label77;
      bool = false;
      break label95;
      bool = false;
      break label112;
    }
  }
  
  public static List<FloorChangeEvent> extractEvents(Intent paramIntent)
  {
    if (!hasEvents(paramIntent)) {
      return Collections.emptyList();
    }
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.internal.EXTRA_FLOOR_CHANGE_RESULT");
    paramIntent = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(zzC((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public static boolean hasEvents(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_FLOOR_CHANGE_RESULT");
  }
  
  public static FloorChangeEvent zzC(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return (FloorChangeEvent)zzd.zza(paramArrayOfByte, CREATOR);
  }
  
  public int getConfidence()
  {
    return this.zzbDk;
  }
  
  public float getElevationChange()
  {
    return this.zzbDn;
  }
  
  public long getEndElapsedRealtimeMillis()
  {
    return this.zzbDm;
  }
  
  public long getEndTimeMillis()
  {
    return this.zzbjk;
  }
  
  public long getStartElapsedRealtimeMillis()
  {
    return this.zzbDl;
  }
  
  public long getStartTimeMillis()
  {
    return this.zzaeN;
  }
  
  public int getType()
  {
    return this.zzahZ;
  }
  
  public String toString()
  {
    return String.format("FloorChangeEvent [type=%d, confidence=%d, elevationChange=%f, startTimeMillis=%d, endTimeMillis=%d, startElapsedRealtimeMillis=%d, endElapsedRealtimeMillis=%d]", new Object[] { Integer.valueOf(this.zzahZ), Integer.valueOf(this.zzbDk), Float.valueOf(this.zzbDn), Long.valueOf(this.zzaeN), Long.valueOf(this.zzbjk), Long.valueOf(this.zzbDl), Long.valueOf(this.zzbDm) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/FloorChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */