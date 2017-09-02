package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzcw
{
  private static final Object zzcwT = null;
  private static Long zzcwU = new Long(0L);
  private static Double zzcwV = new Double(0.0D);
  private static zzcv zzcwW = zzcv.zzaR(0L);
  private static String zzcwX = new String("");
  private static Boolean zzcwY = new Boolean(false);
  private static List<Object> zzcwZ = new ArrayList(0);
  private static Map<Object, Object> zzcxa = new HashMap();
  private static zzak.zza zzcxb = zzab(zzcwX);
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    Log.e("getDouble received non-Number");
    return 0.0D;
  }
  
  public static String zzW(Object paramObject)
  {
    if (paramObject == null) {
      return zzcwX;
    }
    return paramObject.toString();
  }
  
  public static zzcv zzX(Object paramObject)
  {
    if ((paramObject instanceof zzcv)) {
      return (zzcv)paramObject;
    }
    if (zzad(paramObject)) {
      return zzcv.zzaR(zzae(paramObject));
    }
    if (zzac(paramObject)) {
      return zzcv.zza(Double.valueOf(getDouble(paramObject)));
    }
    return zzkb(zzW(paramObject));
  }
  
  public static Long zzY(Object paramObject)
  {
    if (zzad(paramObject)) {
      return Long.valueOf(zzae(paramObject));
    }
    return zzkc(zzW(paramObject));
  }
  
  public static Object zzYF()
  {
    return null;
  }
  
  public static Long zzYG()
  {
    return zzcwU;
  }
  
  public static Double zzYH()
  {
    return zzcwV;
  }
  
  public static Boolean zzYI()
  {
    return zzcwY;
  }
  
  public static zzcv zzYJ()
  {
    return zzcwW;
  }
  
  public static String zzYK()
  {
    return zzcwX;
  }
  
  public static zzak.zza zzYL()
  {
    return zzcxb;
  }
  
  public static Double zzZ(Object paramObject)
  {
    if (zzac(paramObject)) {
      return Double.valueOf(getDouble(paramObject));
    }
    return zzkd(zzW(paramObject));
  }
  
  public static Boolean zzaa(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return zzke(zzW(paramObject));
  }
  
  public static zzak.zza zzab(Object paramObject)
  {
    boolean bool = false;
    zzak.zza localzza1 = new zzak.zza();
    if ((paramObject instanceof zzak.zza)) {
      return (zzak.zza)paramObject;
    }
    if ((paramObject instanceof String))
    {
      localzza1.type = 1;
      localzza1.string = ((String)paramObject);
    }
    for (;;)
    {
      localzza1.zzlC = bool;
      return localzza1;
      Object localObject1;
      Object localObject2;
      if ((paramObject instanceof List))
      {
        localzza1.type = 2;
        localObject1 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        bool = false;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = zzab(((Iterator)localObject1).next());
          if (localObject2 == zzcxb) {
            return zzcxb;
          }
          if ((bool) || (((zzak.zza)localObject2).zzlC)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject2);
            break;
          }
        }
        localzza1.zzlt = ((zzak.zza[])((List)paramObject).toArray(new zzak.zza[0]));
      }
      else if ((paramObject instanceof Map))
      {
        localzza1.type = 3;
        localObject2 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject2).size());
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          zzak.zza localzza2 = zzab(((Map.Entry)localObject3).getKey());
          localObject3 = zzab(((Map.Entry)localObject3).getValue());
          if ((localzza2 == zzcxb) || (localObject3 == zzcxb)) {
            return zzcxb;
          }
          if ((bool) || (localzza2.zzlC) || (((zzak.zza)localObject3).zzlC)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localzza2);
            ((List)localObject1).add(localObject3);
            break;
          }
        }
        localzza1.zzlu = ((zzak.zza[])((List)paramObject).toArray(new zzak.zza[0]));
        localzza1.zzlv = ((zzak.zza[])((List)localObject1).toArray(new zzak.zza[0]));
      }
      else if (zzac(paramObject))
      {
        localzza1.type = 1;
        localzza1.string = paramObject.toString();
      }
      else if (zzad(paramObject))
      {
        localzza1.type = 6;
        localzza1.zzly = zzae(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        localzza1.type = 8;
        localzza1.zzlz = ((Boolean)paramObject).booleanValue();
      }
    }
    if (paramObject == null)
    {
      paramObject = "null";
      paramObject = String.valueOf(paramObject);
      if (((String)paramObject).length() == 0) {
        break label507;
      }
    }
    label507:
    for (paramObject = "Converting to Value from unknown object type: ".concat((String)paramObject);; paramObject = new String("Converting to Value from unknown object type: "))
    {
      Log.e((String)paramObject);
      return zzcxb;
      paramObject = paramObject.getClass().toString();
      break;
    }
  }
  
  private static boolean zzac(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzcv)) && (((zzcv)paramObject).zzYA()));
  }
  
  private static boolean zzad(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzcv)) && (((zzcv)paramObject).zzYB()));
  }
  
  private static long zzae(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    Log.e("getInt64 received non-Number");
    return 0L;
  }
  
  public static String zze(zzak.zza paramzza)
  {
    return zzW(zzj(paramzza));
  }
  
  public static zzcv zzf(zzak.zza paramzza)
  {
    return zzX(zzj(paramzza));
  }
  
  public static Long zzg(zzak.zza paramzza)
  {
    return zzY(zzj(paramzza));
  }
  
  public static Double zzh(zzak.zza paramzza)
  {
    return zzZ(zzj(paramzza));
  }
  
  public static Boolean zzi(zzak.zza paramzza)
  {
    return zzaa(zzj(paramzza));
  }
  
  public static Object zzj(zzak.zza paramzza)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramzza == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    switch (paramzza.type)
    {
    default: 
      i = paramzza.type;
      Log.e(46 + "Failed to convert a value of type: " + i);
      return null;
    case 1: 
      return paramzza.string;
    case 2: 
      localObject1 = new ArrayList(paramzza.zzlt.length);
      paramzza = paramzza.zzlt;
      j = paramzza.length;
      while (i < j)
      {
        localObject2 = zzj(paramzza[i]);
        if (localObject2 == null) {
          return null;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 3: 
      if (paramzza.zzlu.length != paramzza.zzlv.length)
      {
        paramzza = String.valueOf(paramzza.toString());
        if (paramzza.length() != 0) {}
        for (paramzza = "Converting an invalid value to object: ".concat(paramzza);; paramzza = new String("Converting an invalid value to object: "))
        {
          Log.e(paramzza);
          return null;
        }
      }
      localObject1 = new HashMap(paramzza.zzlv.length);
      i = k;
      while (i < paramzza.zzlu.length)
      {
        localObject2 = zzj(paramzza.zzlu[i]);
        Object localObject3 = zzj(paramzza.zzlv[i]);
        if ((localObject2 == null) || (localObject3 == null)) {
          return null;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      Log.e("Trying to convert a macro reference to object");
      return null;
    case 5: 
      Log.e("Trying to convert a function id to object");
      return null;
    case 6: 
      return Long.valueOf(paramzza.zzly);
    case 7: 
      localObject1 = new StringBuffer();
      paramzza = paramzza.zzlA;
      k = paramzza.length;
      i = j;
      while (i < k)
      {
        localObject2 = zze(paramzza[i]);
        if (localObject2 == zzcwX) {
          return null;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramzza.zzlz);
  }
  
  public static zzak.zza zzka(String paramString)
  {
    zzak.zza localzza = new zzak.zza();
    localzza.type = 5;
    localzza.zzlx = paramString;
    return localzza;
  }
  
  private static zzcv zzkb(String paramString)
  {
    try
    {
      zzcv localzzcv = zzcv.zzjZ(paramString);
      return localzzcv;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e(String.valueOf(paramString).length() + 33 + "Failed to convert '" + paramString + "' to a number.");
    }
    return zzcwW;
  }
  
  private static Long zzkc(String paramString)
  {
    paramString = zzkb(paramString);
    if (paramString == zzcwW) {
      return zzcwU;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  private static Double zzkd(String paramString)
  {
    paramString = zzkb(paramString);
    if (paramString == zzcwW) {
      return zzcwV;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  private static Boolean zzke(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return zzcwY;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */