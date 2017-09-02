package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestureEvent
  extends zza
{
  public static final Parcelable.Creator<GestureEvent> CREATOR = new zzk();
  public static final String EXTRA_GESTURE_DETECTED = "com.google.android.location.internal.EXTRA_GESTURE_RESULT";
  private final int zzahZ;
  private final long zzbDD;
  private final long zzbDE;
  private final int zzbDF;
  private final boolean zzbDG;
  private final boolean zzbDH;
  
  public GestureEvent(int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzahZ = paramInt1;
    this.zzbDD = paramLong1;
    this.zzbDE = paramLong2;
    this.zzbDF = paramInt2;
    this.zzbDG = paramBoolean1;
    this.zzbDH = paramBoolean2;
  }
  
  public static GestureEvent create(int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new GestureEvent(paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public static List<GestureEvent> extractEvents(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.internal.EXTRA_GESTURE_RESULT");
    if (localObject == null) {
      return null;
    }
    paramIntent = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(zzD((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public static GestureEvent zzD(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return (GestureEvent)zzd.zza(paramArrayOfByte, CREATOR);
  }
  
  public int getCount()
  {
    return this.zzbDF;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.zzbDE;
  }
  
  public long getTimeMillis()
  {
    return this.zzbDD;
  }
  
  public int getType()
  {
    return this.zzahZ;
  }
  
  public boolean isEnd()
  {
    return this.zzbDH;
  }
  
  public boolean isStart()
  {
    return this.zzbDG;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/GestureEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */