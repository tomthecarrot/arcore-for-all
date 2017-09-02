package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.Log;
import com.google.android.gms.tagmanager.zzcw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbpb
{
  static zzak.zza zza(int paramInt, JSONArray paramJSONArray, zzak.zza[] paramArrayOfzza, Set<Integer> paramSet)
    throws zzbph.zzg, JSONException
  {
    int j = 0;
    int i = 0;
    if (paramSet.contains(Integer.valueOf(paramInt)))
    {
      localObject1 = String.valueOf(paramSet);
      zzkw(String.valueOf(localObject1).length() + 89 + "Value cycle detected. Current value reference: " + paramInt + ".  Previous value references: " + (String)localObject1 + ".");
    }
    Object localObject2 = zza(paramJSONArray, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null) {
      return paramArrayOfzza[paramInt];
    }
    paramSet.add(Integer.valueOf(paramInt));
    Object localObject1 = new zzak.zza();
    if ((localObject2 instanceof JSONArray))
    {
      localObject2 = (JSONArray)localObject2;
      ((zzak.zza)localObject1).type = 2;
      ((zzak.zza)localObject1).zzlC = true;
      ((zzak.zza)localObject1).zzlt = new zzak.zza[((JSONArray)localObject2).length()];
      while (i < ((zzak.zza)localObject1).zzlt.length)
      {
        ((zzak.zza)localObject1).zzlt[i] = zza(((JSONArray)localObject2).getInt(i), paramJSONArray, paramArrayOfzza, paramSet);
        i += 1;
      }
    }
    Object localObject3;
    if ((localObject2 instanceof JSONObject))
    {
      localObject2 = (JSONObject)localObject2;
      localObject3 = ((JSONObject)localObject2).optJSONArray("escaping");
      if (localObject3 != null)
      {
        ((zzak.zza)localObject1).zzlB = new int[((JSONArray)localObject3).length()];
        i = 0;
        while (i < ((zzak.zza)localObject1).zzlB.length)
        {
          ((zzak.zza)localObject1).zzlB[i] = ((JSONArray)localObject3).getInt(i);
          i += 1;
        }
      }
      if (((JSONObject)localObject2).has("function_id"))
      {
        ((zzak.zza)localObject1).type = 5;
        ((zzak.zza)localObject1).zzlx = ((JSONObject)localObject2).getString("function_id");
      }
    }
    for (;;)
    {
      paramArrayOfzza[paramInt] = localObject1;
      paramSet.remove(Integer.valueOf(paramInt));
      return (zzak.zza)localObject1;
      if (((JSONObject)localObject2).has("macro_reference"))
      {
        ((zzak.zza)localObject1).type = 4;
        ((zzak.zza)localObject1).zzlC = true;
        ((zzak.zza)localObject1).zzlw = zzcw.zze(zza(((JSONObject)localObject2).getInt("macro_reference"), paramJSONArray, paramArrayOfzza, paramSet));
      }
      else if (((JSONObject)localObject2).has("template_token"))
      {
        ((zzak.zza)localObject1).type = 7;
        ((zzak.zza)localObject1).zzlC = true;
        localObject2 = ((JSONObject)localObject2).getJSONArray("template_token");
        ((zzak.zza)localObject1).zzlA = new zzak.zza[((JSONArray)localObject2).length()];
        i = j;
        while (i < ((zzak.zza)localObject1).zzlA.length)
        {
          ((zzak.zza)localObject1).zzlA[i] = zza(((JSONArray)localObject2).getInt(i), paramJSONArray, paramArrayOfzza, paramSet);
          i += 1;
        }
      }
      else
      {
        ((zzak.zza)localObject1).type = 3;
        ((zzak.zza)localObject1).zzlC = true;
        i = ((JSONObject)localObject2).length();
        ((zzak.zza)localObject1).zzlu = new zzak.zza[i];
        ((zzak.zza)localObject1).zzlv = new zzak.zza[i];
        localObject3 = ((JSONObject)localObject2).keys();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          ((zzak.zza)localObject1).zzlu[i] = zza(new Integer(str).intValue(), paramJSONArray, paramArrayOfzza, paramSet);
          ((zzak.zza)localObject1).zzlv[i] = zza(((JSONObject)localObject2).getInt(str), paramJSONArray, paramArrayOfzza, paramSet);
          i += 1;
        }
        continue;
        if ((localObject2 instanceof String))
        {
          ((zzak.zza)localObject1).string = ((String)localObject2);
          ((zzak.zza)localObject1).type = 1;
        }
        else if ((localObject2 instanceof Boolean))
        {
          ((zzak.zza)localObject1).zzlz = ((Boolean)localObject2).booleanValue();
          ((zzak.zza)localObject1).type = 8;
        }
        else if ((localObject2 instanceof Integer))
        {
          ((zzak.zza)localObject1).zzly = ((Integer)localObject2).intValue();
          ((zzak.zza)localObject1).type = 6;
        }
        else
        {
          paramJSONArray = String.valueOf(localObject2);
          zzkw(String.valueOf(paramJSONArray).length() + 20 + "Invalid value type: " + paramJSONArray);
        }
      }
    }
  }
  
  static zzbph.zza zza(JSONObject paramJSONObject, JSONArray paramJSONArray1, JSONArray paramJSONArray2, zzak.zza[] paramArrayOfzza, int paramInt)
    throws zzbph.zzg, JSONException
  {
    zzbph.zzb localzzb = zzbph.zza.zzaas();
    paramJSONObject = paramJSONObject.getJSONArray("property");
    paramInt = 0;
    if (paramInt < paramJSONObject.length())
    {
      Object localObject = (JSONObject)zza(paramJSONArray1, paramJSONObject.getInt(paramInt), "properties");
      String str = (String)zza(paramJSONArray2, ((JSONObject)localObject).getInt("key"), "key");
      localObject = (zzak.zza)zza(paramArrayOfzza, ((JSONObject)localObject).getInt("value"), "value");
      if (zzai.zziO.toString().equals(str)) {
        localzzb.zzo((zzak.zza)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localzzb.zzb(str, (zzak.zza)localObject);
      }
    }
    return localzzb.zzaat();
  }
  
  static zzbph.zze zza(JSONObject paramJSONObject, List<zzbph.zza> paramList1, List<zzbph.zza> paramList2, List<zzbph.zza> paramList3, zzak.zza[] paramArrayOfzza)
    throws JSONException
  {
    zzbph.zzf localzzf = zzbph.zze.zzaax();
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("positive_predicate");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("negative_predicate");
    JSONArray localJSONArray3 = paramJSONObject.optJSONArray("add_tag");
    JSONArray localJSONArray4 = paramJSONObject.optJSONArray("remove_tag");
    JSONArray localJSONArray5 = paramJSONObject.optJSONArray("add_tag_rule_name");
    JSONArray localJSONArray6 = paramJSONObject.optJSONArray("remove_tag_rule_name");
    JSONArray localJSONArray7 = paramJSONObject.optJSONArray("add_macro");
    JSONArray localJSONArray8 = paramJSONObject.optJSONArray("remove_macro");
    JSONArray localJSONArray9 = paramJSONObject.optJSONArray("add_macro_rule_name");
    paramJSONObject = paramJSONObject.optJSONArray("remove_macro_rule_name");
    int i;
    if (localJSONArray1 != null)
    {
      i = 0;
      while (i < localJSONArray1.length())
      {
        localzzf.zzd((zzbph.zza)paramList3.get(localJSONArray1.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray2 != null)
    {
      i = 0;
      while (i < localJSONArray2.length())
      {
        localzzf.zze((zzbph.zza)paramList3.get(localJSONArray2.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray3 != null)
    {
      i = 0;
      while (i < localJSONArray3.length())
      {
        localzzf.zzf((zzbph.zza)paramList1.get(localJSONArray3.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray4 != null)
    {
      i = 0;
      while (i < localJSONArray4.length())
      {
        localzzf.zzg((zzbph.zza)paramList1.get(localJSONArray4.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray5 != null)
    {
      i = 0;
      while (i < localJSONArray5.length())
      {
        localzzf.zzkL(paramArrayOfzza[localJSONArray5.getInt(i)].string);
        i += 1;
      }
    }
    if (localJSONArray6 != null)
    {
      i = 0;
      while (i < localJSONArray6.length())
      {
        localzzf.zzkM(paramArrayOfzza[localJSONArray6.getInt(i)].string);
        i += 1;
      }
    }
    if (localJSONArray7 != null)
    {
      i = 0;
      while (i < localJSONArray7.length())
      {
        localzzf.zzh((zzbph.zza)paramList2.get(localJSONArray7.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray8 != null)
    {
      i = 0;
      while (i < localJSONArray8.length())
      {
        localzzf.zzi((zzbph.zza)paramList2.get(localJSONArray8.getInt(i)));
        i += 1;
      }
    }
    if (localJSONArray9 != null)
    {
      i = 0;
      while (i < localJSONArray9.length())
      {
        localzzf.zzkN(paramArrayOfzza[localJSONArray9.getInt(i)].string);
        i += 1;
      }
    }
    if (paramJSONObject != null)
    {
      i = 0;
      while (i < paramJSONObject.length())
      {
        localzzf.zzkO(paramArrayOfzza[paramJSONObject.getInt(i)].string);
        i += 1;
      }
    }
    return localzzf.zzaaA();
  }
  
  private static <T> T zza(JSONArray paramJSONArray, int paramInt, String paramString)
    throws zzbph.zzg
  {
    if ((paramInt >= 0) && (paramInt < paramJSONArray.length())) {
      try
      {
        paramJSONArray = paramJSONArray.get(paramInt);
        return paramJSONArray;
      }
      catch (JSONException paramJSONArray) {}
    }
    zzkw(String.valueOf(paramString).length() + 45 + "Index out of bounds detected: " + paramInt + " in " + paramString);
    return null;
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
    throws zzbph.zzg
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzkw(String.valueOf(paramString).length() + 45 + "Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  static List<zzbph.zza> zza(JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONArray paramJSONArray3, zzak.zza[] paramArrayOfzza)
    throws JSONException, zzbph.zzg
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray1.length())
    {
      localArrayList.add(zza(paramJSONArray1.getJSONObject(i), paramJSONArray2, paramJSONArray3, paramArrayOfzza, i));
      i += 1;
    }
    return localArrayList;
  }
  
  static zzbph.zzc zzjQ(String paramString)
    throws JSONException, zzbph.zzg
  {
    paramString = new JSONObject(paramString);
    Object localObject1 = paramString.get("resource");
    zzak.zza[] arrayOfzza;
    Object localObject3;
    List localList1;
    List localList2;
    if ((localObject1 instanceof JSONObject))
    {
      localObject2 = (JSONObject)localObject1;
      localObject1 = zzbph.zzc.zzaau();
      arrayOfzza = zzu((JSONObject)localObject2);
      localObject3 = ((JSONObject)localObject2).getJSONArray("properties");
      Object localObject4 = ((JSONObject)localObject2).getJSONArray("key");
      localList1 = zza(((JSONObject)localObject2).getJSONArray("tags"), (JSONArray)localObject3, (JSONArray)localObject4, arrayOfzza);
      localList2 = zza(((JSONObject)localObject2).getJSONArray("predicates"), (JSONArray)localObject3, (JSONArray)localObject4, arrayOfzza);
      localObject3 = zza(((JSONObject)localObject2).getJSONArray("macros"), (JSONArray)localObject3, (JSONArray)localObject4, arrayOfzza);
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((zzbph.zzd)localObject1).zzc((zzbph.zza)((Iterator)localObject4).next());
      }
    }
    throw new zzbph.zzg("Resource map not found");
    Object localObject2 = ((JSONObject)localObject2).getJSONArray("rules");
    int i = 0;
    while (i < ((JSONArray)localObject2).length())
    {
      ((zzbph.zzd)localObject1).zzb(zza(((JSONArray)localObject2).getJSONObject(i), localList1, (List)localObject3, localList2, arrayOfzza));
      i += 1;
    }
    ((zzbph.zzd)localObject1).zzkK("1");
    ((zzbph.zzd)localObject1).zzwA(1);
    paramString.optJSONArray("runtime");
    return ((zzbph.zzd)localObject1).zzaaw();
  }
  
  private static void zzkw(String paramString)
    throws zzbph.zzg
  {
    Log.e(paramString);
    throw new zzbph.zzg(paramString);
  }
  
  static zzak.zza[] zzu(JSONObject paramJSONObject)
    throws JSONException, zzbph.zzg
  {
    paramJSONObject = paramJSONObject.opt("values");
    zzak.zza[] arrayOfzza;
    if ((paramJSONObject instanceof JSONArray))
    {
      paramJSONObject = (JSONArray)paramJSONObject;
      arrayOfzza = new zzak.zza[paramJSONObject.length()];
      int i = 0;
      while (i < arrayOfzza.length)
      {
        zza(i, paramJSONObject, arrayOfzza, new HashSet(0));
        i += 1;
      }
    }
    throw new zzbph.zzg("Missing Values list");
    return arrayOfzza;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */