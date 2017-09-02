package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzl<T>
  implements Comparable<zzl<T>>
{
  private final zzt.zza zzB;
  private final int zzC;
  private final String zzD;
  private final int zzE;
  private final zzn.zza zzF;
  private Integer zzG;
  private zzm zzH;
  private boolean zzI;
  private boolean zzJ;
  private boolean zzK;
  private boolean zzL;
  private zzp zzM;
  private zzb.zza zzN;
  
  public zzl(int paramInt, String paramString, zzn.zza paramzza)
  {
    if (zzt.zza.zzai) {}
    for (zzt.zza localzza = new zzt.zza();; localzza = null)
    {
      this.zzB = localzza;
      this.zzI = true;
      this.zzJ = false;
      this.zzK = false;
      this.zzL = false;
      this.zzN = null;
      this.zzC = paramInt;
      this.zzD = paramString;
      this.zzF = paramzza;
      zza(new zze());
      this.zzE = zzb(paramString);
      return;
    }
  }
  
  private static int zzb(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public Map<String, String> getHeaders()
    throws zza
  {
    return Collections.emptyMap();
  }
  
  public int getMethod()
  {
    return this.zzC;
  }
  
  public String getUrl()
  {
    return this.zzD;
  }
  
  public String toString()
  {
    String str = "0x" + Integer.toHexString(zzf());
    return "[ ] " + getUrl() + " " + str + " " + zzo() + " " + this.zzG;
  }
  
  public final zzl<?> zza(int paramInt)
  {
    this.zzG = Integer.valueOf(paramInt);
    return this;
  }
  
  public zzl<?> zza(zzb.zza paramzza)
  {
    this.zzN = paramzza;
    return this;
  }
  
  public zzl<?> zza(zzm paramzzm)
  {
    this.zzH = paramzzm;
    return this;
  }
  
  public zzl<?> zza(zzp paramzzp)
  {
    this.zzM = paramzzp;
    return this;
  }
  
  protected abstract zzn<T> zza(zzj paramzzj);
  
  protected abstract void zza(T paramT);
  
  protected zzs zzb(zzs paramzzs)
  {
    return paramzzs;
  }
  
  public int zzc(zzl<T> paramzzl)
  {
    zza localzza1 = zzo();
    zza localzza2 = paramzzl.zzo();
    if (localzza1 == localzza2) {
      return this.zzG.intValue() - paramzzl.zzG.intValue();
    }
    return localzza2.ordinal() - localzza1.ordinal();
  }
  
  public void zzc(zzs paramzzs)
  {
    if (this.zzF != null) {
      this.zzF.zze(paramzzs);
    }
  }
  
  public void zzc(String paramString)
  {
    if (zzt.zza.zzai) {
      this.zzB.zza(paramString, Thread.currentThread().getId());
    }
  }
  
  void zzd(final String paramString)
  {
    if (this.zzH != null) {
      this.zzH.zzf(this);
    }
    final long l;
    if (zzt.zza.zzai)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            zzl.zzd(zzl.this).zza(paramString, l);
            zzl.zzd(zzl.this).zzd(toString());
          }
        });
      }
    }
    else
    {
      return;
    }
    this.zzB.zza(paramString, l);
    this.zzB.zzd(toString());
  }
  
  public int zzf()
  {
    return this.zzE;
  }
  
  public String zzg()
  {
    return getUrl();
  }
  
  public zzb.zza zzh()
  {
    return this.zzN;
  }
  
  @Deprecated
  public String zzi()
  {
    return zzl();
  }
  
  @Deprecated
  public byte[] zzj()
    throws zza
  {
    return null;
  }
  
  protected String zzk()
  {
    return "UTF-8";
  }
  
  public String zzl()
  {
    return "application/x-www-form-urlencoded; charset=" + zzk();
  }
  
  public byte[] zzm()
    throws zza
  {
    return null;
  }
  
  public final boolean zzn()
  {
    return this.zzI;
  }
  
  public zza zzo()
  {
    return zza.zzS;
  }
  
  public final int zzp()
  {
    return this.zzM.zzc();
  }
  
  public zzp zzq()
  {
    return this.zzM;
  }
  
  public void zzr()
  {
    this.zzK = true;
  }
  
  public boolean zzs()
  {
    return this.zzK;
  }
  
  public static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */