package com.google.android.gms.analytics.internal;

import java.util.Map;

public class zzam
  extends zzr<zzan>
{
  public zzam(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    extends zzc
    implements zzr.zza<zzan>
  {
    private final zzan zzafG = new zzan();
    
    public zza(zzf paramzzf)
    {
      super();
    }
    
    public void zzd(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString))
      {
        this.zzafG.zzafI = paramInt;
        return;
      }
      zzd("int configuration name not recognized", paramString);
    }
    
    public void zze(String paramString, boolean paramBoolean)
    {
      int j = 1;
      int k = 1;
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        paramString = this.zzafG;
        if (paramBoolean) {}
        for (;;)
        {
          paramString.zzafJ = i;
          return;
          i = 0;
        }
      }
      if ("ga_anonymizeIp".equals(paramString))
      {
        paramString = this.zzafG;
        if (paramBoolean) {}
        for (i = j;; i = 0)
        {
          paramString.zzafK = i;
          return;
        }
      }
      if ("ga_reportUncaughtExceptions".equals(paramString))
      {
        paramString = this.zzafG;
        if (paramBoolean) {}
        for (i = k;; i = 0)
        {
          paramString.zzafL = i;
          return;
        }
      }
      zzd("bool configuration name not recognized", paramString);
    }
    
    public void zzp(String paramString1, String paramString2)
    {
      this.zzafG.zzafM.put(paramString1, paramString2);
    }
    
    public zzan zzpO()
    {
      return this.zzafG;
    }
    
    public void zzq(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1))
      {
        this.zzafG.zzabd = paramString2;
        return;
      }
      if ("ga_sampleFrequency".equals(paramString1)) {
        try
        {
          this.zzafG.zzafH = Double.parseDouble(paramString2);
          return;
        }
        catch (NumberFormatException paramString1)
        {
          zzc("Error parsing ga_sampleFrequency value", paramString2, paramString1);
          return;
        }
      }
      zzd("string configuration name not recognized", paramString1);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */