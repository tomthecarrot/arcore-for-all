package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzyn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzb
  extends Exception
{
  private final ArrayMap<zzyn<?>, ConnectionResult> zzaKq;
  
  public zzb(ArrayMap<zzyn<?>, ConnectionResult> paramArrayMap)
  {
    this.zzaKq = paramArrayMap;
  }
  
  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.zzaKq.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (zzyn)((Iterator)localObject1).next();
      Object localObject2 = (ConnectionResult)this.zzaKq.get(localObject3);
      if (((ConnectionResult)localObject2).isSuccess()) {
        i = 0;
      }
      localObject3 = String.valueOf(((zzyn)localObject3).zzxi());
      localObject2 = String.valueOf(localObject2);
      localArrayList.add(String.valueOf(localObject3).length() + 2 + String.valueOf(localObject2).length() + (String)localObject3 + ": " + (String)localObject2);
    }
    localObject1 = new StringBuilder();
    if (i != 0) {
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(TextUtils.join("; ", localArrayList));
      return ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
  }
  
  public ConnectionResult zza(zzd<? extends Api.ApiOptions> paramzzd)
  {
    paramzzd = paramzzd.getApiKey();
    if (this.zzaKq.get(paramzzd) != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "The given API was not part of the availability request.");
      return (ConnectionResult)this.zzaKq.get(paramzzd);
    }
  }
  
  public ArrayMap<zzyn<?>, ConnectionResult> zzwV()
  {
    return this.zzaKq;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */