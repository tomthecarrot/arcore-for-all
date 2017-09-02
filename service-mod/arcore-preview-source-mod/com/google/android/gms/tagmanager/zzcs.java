package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

class zzcs
  implements zzz
{
  private final Context mContext;
  private final String zzIp;
  private final zzb zzcwF;
  private final zza zzcwG;
  
  zzcs(Context paramContext, zza paramzza)
  {
    this(new zzb()
    {
      public HttpURLConnection zzd(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    }, paramContext, paramzza);
  }
  
  zzcs(zzb paramzzb, Context paramContext, zza paramzza)
  {
    this.zzcwF = paramzzb;
    this.mContext = paramContext.getApplicationContext();
    this.zzcwG = paramzza;
    this.zzIp = zza("GoogleTagManager", "4.00", Build.VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
  }
  
  static String zzc(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while ((paramLocale.getLanguage() == null) || (paramLocale.getLanguage().length() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
  }
  
  public boolean zzXA()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      Log.v("...no network connectivity");
      return false;
    }
    return true;
  }
  
  String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  public void zzah(List<zzam> paramList)
  {
    int n = Math.min(paramList.size(), 40);
    j = 1;
    int m = 0;
    zzam localzzam;
    Object localObject1;
    if (m < n)
    {
      localzzam = (zzam)paramList.get(m);
      localObject1 = zzd(localzzam);
      if (localObject1 == null)
      {
        Log.w("No destination: discarding hit.");
        this.zzcwG.zzb(localzzam);
        i = j;
      }
    }
    for (;;)
    {
      m += 1;
      j = i;
      break;
      int k = j;
      try
      {
        localHttpURLConnection = this.zzcwF.zzd((URL)localObject1);
        i = j;
        if (j == 0) {}
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          label186:
          label226:
          String str;
          i = k;
        }
      }
      try
      {
        zzbi.zzcl(this.mContext);
        i = 0;
        j = i;
        localHttpURLConnection.setRequestProperty("User-Agent", this.zzIp);
        j = i;
        k = localHttpURLConnection.getResponseCode();
        j = i;
        localObject1 = localHttpURLConnection.getInputStream();
        if (k != 200) {}
        try
        {
          Log.w(25 + "Bad response: " + k);
          this.zzcwG.zzc(localzzam);
          if (localObject1 != null)
          {
            k = i;
            ((InputStream)localObject1).close();
          }
          k = i;
          localHttpURLConnection.disconnect();
          continue;
        }
        finally {}
        this.zzcwG.zza(localzzam);
        break label186;
      }
      finally
      {
        Object localObject2 = null;
        i = j;
        break label226;
      }
    }
    if (localObject1 != null) {}
    try
    {
      ((InputStream)localObject1).close();
      localHttpURLConnection.disconnect();
      throw ((Throwable)localObject3);
    }
    catch (IOException localIOException1) {}
    str = String.valueOf(localIOException1.getClass().getSimpleName());
    if (str.length() != 0) {}
    for (str = "Exception sending hit: ".concat(str);; str = new String("Exception sending hit: "))
    {
      Log.w(str);
      Log.w(localIOException1.getMessage());
      this.zzcwG.zzc(localzzam);
      break;
    }
  }
  
  URL zzd(zzam paramzzam)
  {
    paramzzam = paramzzam.zzXJ();
    try
    {
      paramzzam = new URL(paramzzam);
      return paramzzam;
    }
    catch (MalformedURLException paramzzam)
    {
      Log.e("Error trying to parse the GTM url.");
    }
    return null;
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzam paramzzam);
    
    public abstract void zzb(zzam paramzzam);
    
    public abstract void zzc(zzam paramzzam);
  }
  
  static abstract interface zzb
  {
    public abstract HttpURLConnection zzd(URL paramURL)
      throws IOException;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */