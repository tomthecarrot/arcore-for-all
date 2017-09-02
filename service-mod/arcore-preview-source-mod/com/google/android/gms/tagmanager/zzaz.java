package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbph.zza;
import com.google.android.gms.internal.zzbph.zzb;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzbph.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz
{
  private static zzak.zza zzU(Object paramObject)
    throws JSONException
  {
    return zzcw.zzab(zzV(paramObject));
  }
  
  static Object zzV(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = ((JSONObject)paramObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, zzV(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
  
  public static zzbph.zzc zzjQ(String paramString)
    throws JSONException
  {
    paramString = zzU(new JSONObject(paramString));
    zzbph.zzd localzzd = zzbph.zzc.zzaau();
    int i = 0;
    while (i < paramString.zzlu.length)
    {
      localzzd.zzc(zzbph.zza.zzaas().zzb(zzai.zzhH.toString(), paramString.zzlu[i]).zzb(zzai.zzhv.toString(), zzcw.zzka(zzn.getFunctionId())).zzb(zzn.zzXh(), paramString.zzlv[i]).zzaat());
      i += 1;
    }
    return localzzd.zzaaw();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */