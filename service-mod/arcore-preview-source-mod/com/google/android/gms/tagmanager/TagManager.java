package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager zzcwL;
  private final Context mContext;
  private final DataLayer zzctf;
  private final CtfeHost zzcvK;
  private final zza zzcwH;
  private final zzcp zzcwI;
  private final ConcurrentMap<String, zzo> zzcwJ;
  private zzk zzcwK;
  
  TagManager(Context paramContext, zza paramzza, DataLayer paramDataLayer, zzcp paramzzcp)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.zzcwI = paramzzcp;
    this.zzcwH = paramzza;
    this.zzcwJ = new ConcurrentHashMap();
    this.zzctf = paramDataLayer;
    this.zzctf.zza(new DataLayer.zzb()
    {
      public void zzae(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.zza(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.zzctf.zza(new zzd(this.mContext));
    this.zzcvK = new CtfeHost();
    zzYy();
    zzYz();
  }
  
  public static void clearInstance()
  {
    try
    {
      zzcwL = null;
      return;
    }
    finally {}
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (zzcwL != null) {
        break label68;
      }
      if (paramContext == null)
      {
        Log.e("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    zzcwL = new TagManager(paramContext, new zza()new DataLayernew zzu
    {
      public ContainerHolderLoader zza(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, CtfeHost paramAnonymousCtfeHost)
      {
        return new ContainerHolderLoader(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousCtfeHost);
      }
    }, new DataLayer(new zzu(paramContext)), zzcq.zzYs());
    label68:
    paramContext = zzcwL;
    return paramContext;
  }
  
  @TargetApi(14)
  private void zzYy()
  {
    int i = Build.VERSION.SDK_INT;
    this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
    {
      public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
      
      public void onLowMemory() {}
      
      public void onTrimMemory(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 20) {
          TagManager.this.dispatch();
        }
      }
    });
  }
  
  private void zzYz()
  {
    zza.zzcb(this.mContext);
  }
  
  private void zzjX(String paramString)
  {
    Iterator localIterator = this.zzcwJ.values().iterator();
    while (localIterator.hasNext()) {
      ((zzo)localIterator.next()).zzjB(paramString);
    }
  }
  
  public void dispatch()
  {
    this.zzcwI.dispatch();
  }
  
  @TargetApi(14)
  public void enableAutoEventTracking()
  {
    int i = Build.VERSION.SDK_INT;
    if (this.zzcwK == null) {
      this.zzcwK = new zzk(this.zzctf);
    }
    if ((this.mContext instanceof Application))
    {
      this.zzcwK.zzb((Application)this.mContext);
      return;
    }
    Log.w("Auto event tracking not enabled. The context should be, and is not, an  instance of the Application class.");
  }
  
  public DataLayer getDataLayer()
  {
    return this.zzctf;
  }
  
  public PendingResult<ContainerHolder> loadContainer(String paramString1, @RawRes int paramInt, String paramString2)
  {
    paramString1 = this.zzcwH.zza(this.mContext, this, null, paramString1, paramInt, this.zzcvK);
    paramString1.load(paramString2);
    return paramString1;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, @RawRes int paramInt)
  {
    paramString = this.zzcwH.zza(this.mContext, this, null, paramString, paramInt, this.zzcvK);
    paramString.loadDefaultOnly();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.zzcwH.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzcvK);
    paramString.loadDefaultOnly();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, @RawRes int paramInt)
  {
    paramString = this.zzcwH.zza(this.mContext, this, null, paramString, paramInt, this.zzcvK);
    paramString.loadPreferFresh();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.zzcwH.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzcvK);
    paramString.loadPreferFresh();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, @RawRes int paramInt)
  {
    paramString = this.zzcwH.zza(this.mContext, this, null, paramString, paramInt, this.zzcvK);
    paramString.loadPreferNonDefault();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.zzcwH.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.zzcvK);
    paramString.loadPreferNonDefault();
    return paramString;
  }
  
  public void setCtfeServerAddress(String paramString)
  {
    this.zzcvK.setCtfeServerAddress(paramString);
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      Log.setLogLevel(i);
      return;
    }
  }
  
  boolean zzA(Uri paramUri)
  {
    for (;;)
    {
      zzbx localzzbx;
      boolean bool;
      try
      {
        localzzbx = zzbx.zzXY();
        if (!localzzbx.zzA(paramUri)) {
          break label208;
        }
        paramUri = localzzbx.getContainerId();
        int i = 4.zzcwN[localzzbx.zzXZ().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      paramUri = (zzo)this.zzcwJ.get(paramUri);
      if (paramUri != null)
      {
        paramUri.zzjD(null);
        paramUri.refresh();
        continue;
        Iterator localIterator = this.zzcwJ.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          zzo localzzo = (zzo)this.zzcwJ.get(str);
          if (str.equals(paramUri))
          {
            localzzo.zzjD(localzzbx.zzYa());
            localzzo.refresh();
          }
          else if (localzzo.zzXk() != null)
          {
            localzzo.zzjD(null);
            localzzo.refresh();
          }
        }
        continue;
        label208:
        bool = false;
      }
    }
  }
  
  public int zza(zzo paramzzo)
  {
    this.zzcwJ.put(paramzzo.getContainerId(), paramzzo);
    return this.zzcwJ.size();
  }
  
  public boolean zzb(zzo paramzzo)
  {
    return this.zzcwJ.remove(paramzzo.getContainerId()) != null;
  }
  
  public static abstract interface zza
  {
    public abstract ContainerHolderLoader zza(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, CtfeHost paramCtfeHost);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */