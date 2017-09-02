package com.google.android.gms.analytics.internal;

public class zzz
  extends zzr<zzaa>
{
  public zzz(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    implements zzr.zza<zzaa>
  {
    private final zzf zzadx;
    private final zzaa zzaeV;
    
    public zza(zzf paramzzf)
    {
      this.zzadx = paramzzf;
      this.zzaeV = new zzaa();
    }
    
    public void zzd(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString))
      {
        this.zzaeV.zzaeX = paramInt;
        return;
      }
      this.zzadx.zznr().zzd("Int xml configuration name not recognized", paramString);
    }
    
    public void zze(String paramString, boolean paramBoolean)
    {
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.zzaeV;
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          paramString.zzaeY = i;
          return;
        }
      }
      this.zzadx.zznr().zzd("Bool xml configuration name not recognized", paramString);
    }
    
    public void zzp(String paramString1, String paramString2) {}
    
    public zzaa zzpe()
    {
      return this.zzaeV;
    }
    
    public void zzq(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1))
      {
        this.zzaeV.zzacB = paramString2;
        return;
      }
      if ("ga_appVersion".equals(paramString1))
      {
        this.zzaeV.zzacC = paramString2;
        return;
      }
      if ("ga_logLevel".equals(paramString1))
      {
        this.zzaeV.zzaeW = paramString2;
        return;
      }
      this.zzadx.zznr().zzd("String xml configuration name not recognized", paramString1);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */