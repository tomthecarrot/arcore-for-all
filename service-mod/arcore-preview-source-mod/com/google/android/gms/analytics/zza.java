package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.data.HitParams;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.List;
import java.util.ListIterator;

public class zza
  extends zzg<zza>
{
  private final zzf zzaaY;
  private boolean zzaaZ;
  
  public zza(zzf paramzzf)
  {
    super(paramzzf.zznt(), paramzzf.zznq());
    this.zzaaY = paramzzf;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzaaZ = paramBoolean;
  }
  
  protected void zza(zze paramzze)
  {
    paramzze = (HitParams)paramzze.zzb(HitParams.class);
    if (TextUtils.isEmpty(paramzze.getClientId())) {
      paramzze.setClientId(this.zzaaY.zznH().zzop());
    }
    if ((this.zzaaZ) && (TextUtils.isEmpty(paramzze.getAndroidAdId())))
    {
      com.google.android.gms.analytics.internal.zza localzza = this.zzaaY.zznG();
      paramzze.setAndroidAdId(localzza.zznf());
      paramzze.setAdTargetingEnabled(localzza.isAdTargetingEnabled());
    }
  }
  
  public void zzbk(String paramString)
  {
    zzac.zzdc(paramString);
    zzbl(paramString);
    zzmT().add(new zzb(this.zzaaY, paramString));
  }
  
  public void zzbl(String paramString)
  {
    paramString = zzb.zzbm(paramString);
    ListIterator localListIterator = zzmT().listIterator();
    while (localListIterator.hasNext()) {
      if (paramString.equals(((zzi)localListIterator.next()).zzmx())) {
        localListIterator.remove();
      }
    }
  }
  
  zzf zzmt()
  {
    return this.zzaaY;
  }
  
  public zze zzmu()
  {
    zze localzze = zzmS().zzmH();
    localzze.zza(this.zzaaY.zzny().zznX());
    localzze.zza(this.zzaaY.zznz().zzpa());
    zzd(localzze);
    return localzze;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */