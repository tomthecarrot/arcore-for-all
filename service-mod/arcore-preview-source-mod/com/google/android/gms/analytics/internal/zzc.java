package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

public class zzc
{
  private final zzf zzadx;
  
  protected zzc(zzf paramzzf)
  {
    zzac.zzC(paramzzf);
    this.zzadx = paramzzf;
  }
  
  private void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    if (this.zzadx != null) {
      localObject = this.zzadx.zznD();
    }
    if (localObject != null) {
      ((zzaf)localObject).zza(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
    do
    {
      return;
      localObject = (String)G.loggingTag.get();
    } while (!Log.isLoggable((String)localObject, paramInt));
    Log.println(paramInt, (String)localObject, zzc(paramString, paramObject1, paramObject2, paramObject3));
  }
  
  protected static String zzc(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzl(paramObject1);
    paramObject2 = zzl(paramObject2);
    paramObject3 = zzl(paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzl(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject == Boolean.TRUE) {}
      for (paramObject = "true";; paramObject = "false") {
        return (String)paramObject;
      }
    }
    if ((paramObject instanceof Throwable)) {
      return ((Throwable)paramObject).toString();
    }
    return paramObject.toString();
  }
  
  protected Context getContext()
  {
    return this.zzadx.getContext();
  }
  
  public void zza(String paramString, Object paramObject)
  {
    zza(2, paramString, paramObject, null, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(2, paramString, paramObject1, paramObject2, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(3, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzb(String paramString, Object paramObject)
  {
    zza(3, paramString, paramObject, null, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(3, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(5, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzbr(String paramString)
  {
    zza(2, paramString, null, null, null);
  }
  
  public void zzbs(String paramString)
  {
    zza(3, paramString, null, null, null);
  }
  
  public void zzbt(String paramString)
  {
    zza(4, paramString, null, null, null);
  }
  
  public void zzbu(String paramString)
  {
    zza(5, paramString, null, null, null);
  }
  
  public void zzbv(String paramString)
  {
    zza(6, paramString, null, null, null);
  }
  
  public void zzc(String paramString, Object paramObject)
  {
    zza(4, paramString, paramObject, null, null);
  }
  
  public void zzc(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(5, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzd(String paramString, Object paramObject)
  {
    zza(5, paramString, paramObject, null, null);
  }
  
  public void zzd(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(6, paramString, paramObject1, paramObject2, null);
  }
  
  public void zze(String paramString, Object paramObject)
  {
    zza(6, paramString, paramObject, null, null);
  }
  
  public boolean zzkN()
  {
    return Log.isLoggable((String)G.loggingTag.get(), 2);
  }
  
  public GoogleAnalytics zzmA()
  {
    return this.zzadx.zznE();
  }
  
  protected zzb zzmF()
  {
    return this.zzadx.zzmF();
  }
  
  protected zzap zzmG()
  {
    return this.zzadx.zzmG();
  }
  
  protected void zzmW()
  {
    this.zzadx.zzmW();
  }
  
  public zzf zznp()
  {
    return this.zzadx;
  }
  
  protected Clock zznq()
  {
    return this.zzadx.zznq();
  }
  
  protected zzaf zznr()
  {
    return this.zzadx.zznr();
  }
  
  protected zzs zzns()
  {
    return this.zzadx.zzns();
  }
  
  protected zzh zznt()
  {
    return this.zzadx.zznt();
  }
  
  protected zzw zznu()
  {
    return this.zzadx.zznu();
  }
  
  protected zzai zznv()
  {
    return this.zzadx.zznv();
  }
  
  protected zzn zznw()
  {
    return this.zzadx.zznH();
  }
  
  protected zza zznx()
  {
    return this.zzadx.zznG();
  }
  
  protected zzk zzny()
  {
    return this.zzadx.zzny();
  }
  
  protected zzv zznz()
  {
    return this.zzadx.zznz();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */