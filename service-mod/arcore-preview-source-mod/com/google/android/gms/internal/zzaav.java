package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public abstract class zzaav<T>
{
  private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static zza zzaPy;
  private static int zzaPz;
  private static final Object zzuq = new Object();
  protected final String zzBp;
  protected final T zzBq;
  private T zzaeU = null;
  
  static
  {
    zzaPy = null;
    zzaPz = 0;
  }
  
  protected zzaav(String paramString, T paramT)
  {
    this.zzBp = paramString;
    this.zzBq = paramT;
  }
  
  public static void init(Context paramContext)
  {
    synchronized (zzuq)
    {
      if (zzaPy == null) {
        zzaPy = new zzd(paramContext.getContentResolver());
      }
      int i = zzaPz;
      if (i == 0) {}
      try
      {
        zzaPz = paramContext.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          Log.e("GservicesValue", paramContext.toString());
        }
      }
    }
  }
  
  public static zzaav<String> zzI(String paramString1, String paramString2)
  {
    new zzaav(paramString1, paramString2)
    {
      protected String zzcP(String paramAnonymousString)
      {
        return zzaav.zzyY().getString(this.zzBp, (String)this.zzBq);
      }
    };
  }
  
  public static zzaav<Float> zza(String paramString, Float paramFloat)
  {
    new zzaav(paramString, paramFloat)
    {
      protected Float zzcO(String paramAnonymousString)
      {
        return zzaav.zzyY().zzb(this.zzBp, (Float)this.zzBq);
      }
    };
  }
  
  public static zzaav<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzaav(paramString, paramInteger)
    {
      protected Integer zzcN(String paramAnonymousString)
      {
        return zzaav.zzyY().zzb(this.zzBp, (Integer)this.zzBq);
      }
    };
  }
  
  public static zzaav<Long> zza(String paramString, Long paramLong)
  {
    new zzaav(paramString, paramLong)
    {
      protected Long zzcM(String paramAnonymousString)
      {
        return zzaav.zzyY().getLong(this.zzBp, (Long)this.zzBq);
      }
    };
  }
  
  public static zzaav<Boolean> zzk(String paramString, boolean paramBoolean)
  {
    new zzaav(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzcL(String paramAnonymousString)
      {
        return zzaav.zzyY().zza(this.zzBp, (Boolean)this.zzBq);
      }
    };
  }
  
  public static void zzyV()
  {
    synchronized (zzuq)
    {
      zzaPy = new zzb(null);
      return;
    }
  }
  
  private static boolean zzyW()
  {
    for (;;)
    {
      synchronized (zzuq)
      {
        if (!(zzaPy instanceof zzb))
        {
          if (!(zzaPy instanceof zzc)) {
            break label41;
          }
          break label36;
          return bool;
        }
      }
      label36:
      boolean bool = true;
      continue;
      label41:
      bool = false;
    }
  }
  
  public static void zzyX()
  {
    synchronized (zzuq)
    {
      if (!zzyW()) {
        break label58;
      }
      Iterator localIterator = zzb.zzyZ().iterator();
      if (localIterator.hasNext()) {
        ((zzaav)localIterator.next()).resetOverride();
      }
    }
    zzb.zzyZ().clear();
    label58:
  }
  
  public final T get()
  {
    if (this.zzaeU != null) {
      return (T)this.zzaeU;
    }
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      Object localObject1 = zzcK(this.zzBp);
      return (T)localObject1;
    }
    catch (SecurityException localSecurityException)
    {
      long l = Binder.clearCallingIdentity();
      try
      {
        Object localObject2 = zzcK(this.zzBp);
        Binder.restoreCallingIdentity(l);
        return (T)localObject2;
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  @Deprecated
  public final T getBinderSafe()
  {
    return (T)get();
  }
  
  public void override(T arg1)
  {
    if (!(zzaPy instanceof zzb)) {
      Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    }
    this.zzaeU = ???;
    synchronized (zzuq)
    {
      if (zzyW()) {
        zzb.zzyZ().add(this);
      }
      return;
    }
  }
  
  public void resetOverride()
  {
    this.zzaeU = null;
  }
  
  protected abstract T zzcK(String paramString);
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Float zzb(String paramString, Float paramFloat);
    
    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
  
  private static class zzb
    implements zzaav.zza
  {
    private static final Collection<zzaav<?>> zzaPA = new HashSet();
    
    public Long getLong(String paramString, Long paramLong)
    {
      return paramLong;
    }
    
    public String getString(String paramString1, String paramString2)
    {
      return paramString2;
    }
    
    public Boolean zza(String paramString, Boolean paramBoolean)
    {
      return paramBoolean;
    }
    
    public Float zzb(String paramString, Float paramFloat)
    {
      return paramFloat;
    }
    
    public Integer zzb(String paramString, Integer paramInteger)
    {
      return paramInteger;
    }
  }
  
  @Deprecated
  private static class zzc
    implements zzaav.zza
  {
    private final Map<String, ?> values;
    
    private <T> T zzg(String paramString, T paramT)
    {
      if (this.values.containsKey(paramString)) {
        paramT = this.values.get(paramString);
      }
      return paramT;
    }
    
    public Long getLong(String paramString, Long paramLong)
    {
      return (Long)zzg(paramString, paramLong);
    }
    
    public String getString(String paramString1, String paramString2)
    {
      return (String)zzg(paramString1, paramString2);
    }
    
    public Boolean zza(String paramString, Boolean paramBoolean)
    {
      return (Boolean)zzg(paramString, paramBoolean);
    }
    
    public Float zzb(String paramString, Float paramFloat)
    {
      return (Float)zzg(paramString, paramFloat);
    }
    
    public Integer zzb(String paramString, Integer paramInteger)
    {
      return (Integer)zzg(paramString, paramInteger);
    }
  }
  
  private static class zzd
    implements zzaav.zza
  {
    private final ContentResolver mContentResolver;
    
    public zzd(ContentResolver paramContentResolver)
    {
      this.mContentResolver = paramContentResolver;
    }
    
    public Long getLong(String paramString, Long paramLong)
    {
      return Long.valueOf(zzbtf.getLong(this.mContentResolver, paramString, paramLong.longValue()));
    }
    
    public String getString(String paramString1, String paramString2)
    {
      return zzbtf.zza(this.mContentResolver, paramString1, paramString2);
    }
    
    public Boolean zza(String paramString, Boolean paramBoolean)
    {
      return Boolean.valueOf(zzbtf.zza(this.mContentResolver, paramString, paramBoolean.booleanValue()));
    }
    
    public Float zzb(String paramString, Float paramFloat)
    {
      String str = zzbtf.zza(this.mContentResolver, paramString, null);
      paramString = paramFloat;
      if (str != null) {}
      try
      {
        float f = Float.parseFloat(str);
        paramString = Float.valueOf(f);
        return paramString;
      }
      catch (NumberFormatException paramString) {}
      return paramFloat;
    }
    
    public Integer zzb(String paramString, Integer paramInteger)
    {
      return Integer.valueOf(zzbtf.getInt(this.mContentResolver, paramString, paramInteger.intValue()));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */