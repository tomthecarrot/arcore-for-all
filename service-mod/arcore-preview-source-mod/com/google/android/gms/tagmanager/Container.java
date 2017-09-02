package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbph;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzbph.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final Context mContext;
  private final String zzcaK;
  private final DataLayer zzctf;
  private zzcl zzcth;
  private Map<String, FunctionCallMacroCallback> zzcti = new HashMap();
  private Map<String, FunctionCallTagCallback> zzctj = new HashMap();
  private volatile long zzctk;
  private volatile String zzctl = "";
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzaj.zzj paramzzj)
  {
    this.mContext = paramContext;
    this.zzctf = paramDataLayer;
    this.zzcaK = paramString;
    this.zzctk = paramLong;
    zza(paramzzj.zzlq);
    if (paramzzj.zzlp != null) {
      zza(paramzzj.zzlp);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzbph.zzc paramzzc)
  {
    this.mContext = paramContext;
    this.zzctf = paramDataLayer;
    this.zzcaK = paramString;
    this.zzctk = paramLong;
    zza(paramzzc);
  }
  
  private zzcl zzXj()
  {
    try
    {
      zzcl localzzcl = this.zzcth;
      return localzzcl;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void zza(zzaj.zzf paramzzf)
  {
    if (paramzzf == null) {
      throw new NullPointerException();
    }
    try
    {
      zzbph.zzc localzzc = zzbph.zzb(paramzzf);
      zza(localzzc);
      return;
    }
    catch (zzbph.zzg localzzg)
    {
      paramzzf = String.valueOf(paramzzf);
      String str = String.valueOf(localzzg.toString());
      Log.e(String.valueOf(paramzzf).length() + 46 + String.valueOf(str).length() + "Not loading resource: " + paramzzf + " because it is invalid: " + str);
    }
  }
  
  private void zza(zzbph.zzc paramzzc)
  {
    this.zzctl = paramzzc.getVersion();
    zzae localzzae = zzjC(this.zzctl);
    zza(new zzcl(this.mContext, paramzzc, this.zzctf, new zza(null), new zzb(null), localzzae));
    if (getBoolean("_gtm.loadEventEnabled")) {
      this.zzctf.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", this.zzcaK }));
    }
  }
  
  private void zza(zzcl paramzzcl)
  {
    try
    {
      this.zzcth = paramzzcl;
      return;
    }
    finally
    {
      paramzzcl = finally;
      throw paramzzcl;
    }
  }
  
  private void zza(zzaj.zzi[] paramArrayOfzzi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfzzi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfzzi[i]);
      i += 1;
    }
    zzXj().zzai(localArrayList);
  }
  
  public boolean getBoolean(String paramString)
  {
    zzcl localzzcl = zzXj();
    if (localzzcl == null)
    {
      Log.e("getBoolean called for closed container.");
      return zzcw.zzYI().booleanValue();
    }
    try
    {
      boolean bool = zzcw.zzi((zzak.zza)localzzcl.zzjV(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      Log.e(String.valueOf(paramString).length() + 66 + "Calling getBoolean() threw an exception: " + paramString + " Returning default value.");
    }
    return zzcw.zzYI().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.zzcaK;
  }
  
  public double getDouble(String paramString)
  {
    zzcl localzzcl = zzXj();
    if (localzzcl == null)
    {
      Log.e("getDouble called for closed container.");
      return zzcw.zzYH().doubleValue();
    }
    try
    {
      double d = zzcw.zzh((zzak.zza)localzzcl.zzjV(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      Log.e(String.valueOf(paramString).length() + 65 + "Calling getDouble() threw an exception: " + paramString + " Returning default value.");
    }
    return zzcw.zzYH().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.zzctk;
  }
  
  public long getLong(String paramString)
  {
    zzcl localzzcl = zzXj();
    if (localzzcl == null)
    {
      Log.e("getLong called for closed container.");
      return zzcw.zzYG().longValue();
    }
    try
    {
      long l = zzcw.zzg((zzak.zza)localzzcl.zzjV(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      Log.e(String.valueOf(paramString).length() + 63 + "Calling getLong() threw an exception: " + paramString + " Returning default value.");
    }
    return zzcw.zzYG().longValue();
  }
  
  public String getString(String paramString)
  {
    zzcl localzzcl = zzXj();
    if (localzzcl == null)
    {
      Log.e("getString called for closed container.");
      return zzcw.zzYK();
    }
    try
    {
      paramString = zzcw.zze((zzak.zza)localzzcl.zzjV(paramString).getObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      Log.e(String.valueOf(paramString).length() + 65 + "Calling getString() threw an exception: " + paramString + " Returning default value.");
    }
    return zzcw.zzYK();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.zzcti)
    {
      this.zzcti.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.zzctj)
    {
      this.zzctj.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.zzcth = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.zzcti)
    {
      this.zzcti.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.zzctj)
    {
      this.zzctj.remove(paramString);
      return;
    }
  }
  
  public String zzXi()
  {
    return this.zzctl;
  }
  
  public FunctionCallTagCallback zzjA(String paramString)
  {
    synchronized (this.zzctj)
    {
      paramString = (FunctionCallTagCallback)this.zzctj.get(paramString);
      return paramString;
    }
  }
  
  public void zzjB(String paramString)
  {
    zzXj().zzjB(paramString);
  }
  
  zzae zzjC(String paramString)
  {
    zzbx.zzXY().zzXZ().equals(zzbx.zza.zzcvz);
    return new zzbl();
  }
  
  FunctionCallMacroCallback zzjz(String paramString)
  {
    synchronized (this.zzcti)
    {
      paramString = (FunctionCallMacroCallback)this.zzcti.get(paramString);
      return paramString;
    }
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class zza
    implements zzr.zza
  {
    private zza() {}
    
    public Object zze(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.zzjz(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  private class zzb
    implements zzr.zza
  {
    private zzb() {}
    
    public Object zze(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.zzjA(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return zzcw.zzYK();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */