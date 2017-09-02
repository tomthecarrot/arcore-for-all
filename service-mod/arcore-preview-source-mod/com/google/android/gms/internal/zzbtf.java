package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzbtf
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri fV = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern fW = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern fX = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean fY = new AtomicBoolean();
  static HashMap<String, String> fZ;
  private static Object ga;
  private static boolean gb;
  static String[] gc = new String[0];
  
  public static int getInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    int i = paramInt;
    if (paramContentResolver != null) {}
    try
    {
      i = Integer.parseInt(paramContentResolver);
      return i;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramInt;
  }
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    long l = paramLong;
    if (paramContentResolver != null) {}
    try
    {
      l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramLong;
  }
  
  @Deprecated
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return zza(paramContentResolver, paramString, null);
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      try
      {
        zza(paramContentResolver);
        localObject2 = ga;
        if (fZ.containsKey(paramString1))
        {
          paramContentResolver = (String)fZ.get(paramString1);
          if (paramContentResolver != null) {
            paramString2 = paramContentResolver;
          }
          return paramString2;
        }
        localObject1 = gc;
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label138;
        }
        if (!paramString1.startsWith(localObject1[i])) {
          break label277;
        }
        if ((!gb) || (fZ.isEmpty()))
        {
          zzc(paramContentResolver, gc);
          if (fZ.containsKey(paramString1))
          {
            paramContentResolver = (String)fZ.get(paramString1);
            if (paramContentResolver != null) {
              paramString2 = paramContentResolver;
            }
            return paramString2;
          }
        }
      }
      finally {}
      return paramString2;
      label138:
      Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
      if (localCursor != null) {}
      try
      {
        if (!localCursor.moveToFirst())
        {
          zza(localObject2, paramString1, null);
          paramContentResolver = paramString2;
          return paramString2;
        }
        localObject1 = localCursor.getString(1);
        paramContentResolver = (ContentResolver)localObject1;
        if (localObject1 != null)
        {
          paramContentResolver = (ContentResolver)localObject1;
          if (((String)localObject1).equals(paramString2)) {
            paramContentResolver = paramString2;
          }
        }
        zza(localObject2, paramString1, paramContentResolver);
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        paramContentResolver = paramString2;
        return paramString2;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      return paramContentResolver;
      label277:
      i += 1;
    }
  }
  
  public static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(fV, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      if (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    if (fZ == null)
    {
      fY.set(false);
      fZ = new HashMap();
      ga = new Object();
      gb = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new ContentObserver(null)
      {
        public void onChange(boolean paramAnonymousBoolean)
        {
          zzbtf.zzacv().set(true);
        }
      });
    }
    while (!fY.getAndSet(false)) {
      return;
    }
    fZ.clear();
    ga = new Object();
    gb = false;
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == ga) {
        fZ.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    if ((paramContentResolver == null) || (paramContentResolver.equals(""))) {
      return paramBoolean;
    }
    if (fW.matcher(paramContentResolver).matches()) {
      return true;
    }
    if (fX.matcher(paramContentResolver).matches()) {
      return false;
    }
    Log.w("Gservices", String.valueOf(paramString).length() + 52 + String.valueOf(paramContentResolver).length() + "attempt to read gservices key " + paramString + " (value \"" + paramContentResolver + "\") as boolean");
    return paramBoolean;
  }
  
  public static void zzb(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        zza(paramContentResolver);
        paramVarArgs = zzn(paramVarArgs);
        if ((!gb) || (fZ.isEmpty()))
        {
          zzc(paramContentResolver, gc);
          return;
        }
      }
      finally {}
      if (paramVarArgs.length != 0) {
        zzc(paramContentResolver, paramVarArgs);
      }
    }
  }
  
  private static void zzc(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    fZ.putAll(zza(paramContentResolver, paramArrayOfString));
    gb = true;
  }
  
  private static String[] zzn(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet((gc.length + paramArrayOfString.length) * 4 / 3 + 1);
    localHashSet.addAll(Arrays.asList(gc));
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localHashSet.add(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      return new String[0];
    }
    gc = (String[])localHashSet.toArray(new String[localHashSet.size()]);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbtf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */