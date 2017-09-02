package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzm.zza;
import com.google.android.gms.location.zzn;
import com.google.android.gms.location.zzn.zza;

public class zzq
  extends zza
{
  public static final Parcelable.Creator<zzq> CREATOR = new zzr();
  PendingIntent mPendingIntent;
  int zzbET;
  zzo zzbEU;
  zzn zzbEV;
  zzm zzbEW;
  zzi zzbEX;
  
  zzq(int paramInt, zzo paramzzo, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.zzbET = paramInt;
    this.zzbEU = paramzzo;
    if (paramIBinder1 == null)
    {
      paramzzo = null;
      this.zzbEV = paramzzo;
      this.mPendingIntent = paramPendingIntent;
      if (paramIBinder2 != null) {
        break label68;
      }
      paramzzo = null;
      label41:
      this.zzbEW = paramzzo;
      if (paramIBinder3 != null) {
        break label77;
      }
    }
    label68:
    label77:
    for (paramzzo = (zzo)localObject;; paramzzo = zzi.zza.zzfu(paramIBinder3))
    {
      this.zzbEX = paramzzo;
      return;
      paramzzo = zzn.zza.zzfs(paramIBinder1);
      break;
      paramzzo = zzm.zza.zzfr(paramIBinder2);
      break label41;
    }
  }
  
  public static zzq zza(zzo paramzzo, PendingIntent paramPendingIntent, @Nullable zzi paramzzi)
  {
    if (paramzzi != null) {}
    for (paramzzi = paramzzi.asBinder();; paramzzi = null) {
      return new zzq(1, paramzzo, null, paramPendingIntent, null, paramzzi);
    }
  }
  
  public static zzq zza(zzo paramzzo, zzm paramzzm, @Nullable zzi paramzzi)
  {
    IBinder localIBinder = paramzzm.asBinder();
    if (paramzzi != null) {}
    for (paramzzm = paramzzi.asBinder();; paramzzm = null) {
      return new zzq(1, paramzzo, null, null, localIBinder, paramzzm);
    }
  }
  
  public static zzq zza(zzo paramzzo, zzn paramzzn, @Nullable zzi paramzzi)
  {
    IBinder localIBinder = paramzzn.asBinder();
    if (paramzzi != null) {}
    for (paramzzn = paramzzi.asBinder();; paramzzn = null) {
      return new zzq(1, paramzzo, localIBinder, null, null, paramzzn);
    }
  }
  
  public static zzq zza(zzm paramzzm, @Nullable zzi paramzzi)
  {
    IBinder localIBinder = paramzzm.asBinder();
    if (paramzzi != null) {}
    for (paramzzm = paramzzi.asBinder();; paramzzm = null) {
      return new zzq(2, null, null, null, localIBinder, paramzzm);
    }
  }
  
  public static zzq zza(zzn paramzzn, @Nullable zzi paramzzi)
  {
    IBinder localIBinder = paramzzn.asBinder();
    if (paramzzi != null) {}
    for (paramzzn = paramzzi.asBinder();; paramzzn = null) {
      return new zzq(2, null, localIBinder, null, null, paramzzn);
    }
  }
  
  public static zzq zzb(PendingIntent paramPendingIntent, @Nullable zzi paramzzi)
  {
    if (paramzzi != null) {}
    for (paramzzi = paramzzi.asBinder();; paramzzi = null) {
      return new zzq(2, null, null, paramPendingIntent, null, paramzzi);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzKs()
  {
    if (this.zzbEV == null) {
      return null;
    }
    return this.zzbEV.asBinder();
  }
  
  IBinder zzKt()
  {
    if (this.zzbEW == null) {
      return null;
    }
    return this.zzbEW.asBinder();
  }
  
  IBinder zzKu()
  {
    if (this.zzbEX == null) {
      return null;
    }
    return this.zzbEX.asBinder();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */