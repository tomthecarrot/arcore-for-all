package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import java.util.UUID;

public class zzai
  extends zzd
{
  private SharedPreferences zzafw;
  private long zzafx;
  private long zzafy = -1L;
  private final zza zzafz = new zza("monitoring", zzns().zzoY(), null);
  
  protected zzai(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  protected void onInitialize()
  {
    this.zzafw = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public void zzbD(String paramString)
  {
    zzmW();
    zznA();
    SharedPreferences.Editor localEditor = this.zzafw.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    }
    for (;;)
    {
      if (!localEditor.commit()) {
        zzbu("Failed to commit campaign data");
      }
      return;
      localEditor.putString("installation_campaign", paramString);
    }
  }
  
  public long zzpC()
  {
    zzmW();
    zznA();
    long l;
    if (this.zzafx == 0L)
    {
      l = this.zzafw.getLong("first_run", 0L);
      if (l == 0L) {
        break label46;
      }
    }
    for (this.zzafx = l;; this.zzafx = l)
    {
      return this.zzafx;
      label46:
      l = zznq().currentTimeMillis();
      SharedPreferences.Editor localEditor = this.zzafw.edit();
      localEditor.putLong("first_run", l);
      if (!localEditor.commit()) {
        zzbu("Failed to commit first run time");
      }
    }
  }
  
  public zzal zzpD()
  {
    return new zzal(zznq(), zzpC());
  }
  
  public long zzpE()
  {
    zzmW();
    zznA();
    if (this.zzafy == -1L) {
      this.zzafy = this.zzafw.getLong("last_dispatch", 0L);
    }
    return this.zzafy;
  }
  
  public void zzpF()
  {
    zzmW();
    zznA();
    long l = zznq().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zzafw.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    this.zzafy = l;
  }
  
  public String zzpG()
  {
    zzmW();
    zznA();
    String str = this.zzafw.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str;
  }
  
  public zza zzpH()
  {
    return this.zzafz;
  }
  
  public final class zza
  {
    private final String mName;
    private final long zzafA;
    
    private zza(String paramString, long paramLong)
    {
      zzac.zzdc(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzaw(bool);
        this.mName = paramString;
        this.zzafA = paramLong;
        return;
      }
    }
    
    private long getStartTimeMillis()
    {
      return zzai.zza(zzai.this).getLong(zzpL(), 0L);
    }
    
    private void zzpI()
    {
      long l = zzai.this.zznq().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzai.zza(zzai.this).edit();
      localEditor.remove(zzpM());
      localEditor.remove(zzpN());
      localEditor.putLong(zzpL(), l);
      localEditor.commit();
    }
    
    private long zzpJ()
    {
      long l = getStartTimeMillis();
      if (l == 0L) {
        return 0L;
      }
      return Math.abs(l - zzai.this.zznq().currentTimeMillis());
    }
    
    private String zzpL()
    {
      return String.valueOf(this.mName).concat(":start");
    }
    
    private String zzpM()
    {
      return String.valueOf(this.mName).concat(":count");
    }
    
    public void zzbE(String paramString)
    {
      if (getStartTimeMillis() == 0L) {
        zzpI();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      for (;;)
      {
        try
        {
          long l = zzai.zza(zzai.this).getLong(zzpM(), 0L);
          if (l <= 0L)
          {
            paramString = zzai.zza(zzai.this).edit();
            paramString.putString(zzpN(), str);
            paramString.putLong(zzpM(), 1L);
            paramString.apply();
            return;
          }
          if ((UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + 1L))
          {
            i = 1;
            paramString = zzai.zza(zzai.this).edit();
            if (i != 0) {
              paramString.putString(zzpN(), str);
            }
            paramString.putLong(zzpM(), l + 1L);
            paramString.apply();
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public Pair<String, Long> zzpK()
    {
      long l = zzpJ();
      if (l < this.zzafA) {}
      String str;
      do
      {
        return null;
        if (l > this.zzafA * 2L)
        {
          zzpI();
          return null;
        }
        str = zzai.zza(zzai.this).getString(zzpN(), null);
        l = zzai.zza(zzai.this).getLong(zzpM(), 0L);
        zzpI();
      } while ((str == null) || (l <= 0L));
      return new Pair(str, Long.valueOf(l));
    }
    
    protected String zzpN()
    {
      return String.valueOf(this.mName).concat(":value");
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */