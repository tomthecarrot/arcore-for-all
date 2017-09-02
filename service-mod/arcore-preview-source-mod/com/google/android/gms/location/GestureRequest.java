package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest
  extends zza
{
  public static final Parcelable.Creator<GestureRequest> CREATOR = new zzl();
  public static final int TYPE_BICEP_CURL_COUNTER = 14;
  public static final int TYPE_BICEP_CURL_SEGMENT_DETECTOR = 15;
  public static final int TYPE_CHINUP_COUNTER = 8;
  public static final int TYPE_CHINUP_SEGMENT_DETECTOR = 9;
  public static final int TYPE_DROP_CONTENT_DETECTOR = 18;
  public static final int TYPE_JUMPING_JACK_COUNTER = 10;
  public static final int TYPE_JUMPING_JACK_SEGMENT_DETECTOR = 11;
  public static final int TYPE_LUNGE_COUNTER = 16;
  public static final int TYPE_LUNGE_SEGMENT_DETECTOR = 17;
  public static final int TYPE_PUSHUP_COUNTER = 4;
  public static final int TYPE_PUSHUP_SEGMENT_DETECTOR = 5;
  public static final int TYPE_RECEIVE_CONTENT_DETECTOR = 19;
  public static final int TYPE_SITUP_COUNTER = 2;
  public static final int TYPE_SITUP_SEGMENT_DETECTOR = 3;
  public static final int TYPE_SQUAT_COUNTER = 6;
  public static final int TYPE_SQUAT_SEGMENT_DETECTOR = 7;
  public static final int TYPE_STANDING_CALF_RAISE_COUNTER = 12;
  public static final int TYPE_STANDING_CALF_RAISE_SEGMENT_DETECTOR = 13;
  public static final int TYPE_SWIPE_DETECTOR = 1;
  private static final List<Integer> zzbDI = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19) }));
  private static final List<Integer> zzbDJ = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(1) }));
  private static final List<Integer> zzbDK = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(18), Integer.valueOf(19) }));
  private static final List<Integer> zzbDL = Collections.unmodifiableList(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9), Integer.valueOf(11), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(17) }));
  private final List<Integer> zzbDM;
  
  public GestureRequest(List<Integer> paramList)
  {
    this.zzbDM = paramList;
  }
  
  public static GestureRequest create(List<Integer> paramList)
  {
    return new GestureRequest(paramList);
  }
  
  public List<Integer> getGestureTypes()
  {
    return this.zzbDM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/GestureRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */