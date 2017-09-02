package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends TrackingTag
{
  private static final String ID = zzah.zzew.toString();
  private static final String URL = zzai.zzjV.toString();
  private static final String zzcta = zzai.zzfu.toString();
  private static final String zzctb = zzai.zzjU.toString();
  static final String zzctc;
  private static final Set<String> zzctd = new HashSet();
  private final Context mContext;
  private final zza zzcte;
  
  static
  {
    String str = ID;
    zzctc = String.valueOf(str).length() + 17 + "gtm_" + str + "_unrepeatable";
  }
  
  public zzj(Context paramContext)
  {
    this(paramContext, new zza()
    {
      public HitSender zzXg()
      {
        return zzw.zzcc(zzj.this);
      }
    });
  }
  
  zzj(Context paramContext, zza paramzza)
  {
    super(ID, new String[] { URL });
    this.zzcte = paramzza;
    this.mContext = paramContext;
  }
  
  private boolean zzjw(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = zzjy(paramString);
        if (bool2) {
          return bool1;
        }
        if (zzjx(paramString)) {
          zzctd.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void evaluateTrackingTag(Map<String, zzak.zza> paramMap)
  {
    if (paramMap.get(zzctb) != null) {}
    for (String str = zzcw.zze((zzak.zza)paramMap.get(zzctb)); (str != null) && (zzjw(str)); str = null) {
      return;
    }
    Uri.Builder localBuilder = Uri.parse(zzcw.zze((zzak.zza)paramMap.get(URL))).buildUpon();
    paramMap = (zzak.zza)paramMap.get(zzcta);
    if (paramMap != null)
    {
      paramMap = zzcw.zzj(paramMap);
      if (!(paramMap instanceof List))
      {
        paramMap = String.valueOf(localBuilder.build().toString());
        if (paramMap.length() != 0) {}
        for (paramMap = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params not a list: not sending partial hit: "))
        {
          Log.e(paramMap);
          return;
        }
      }
      paramMap = ((List)paramMap).iterator();
      while (paramMap.hasNext())
      {
        Object localObject = paramMap.next();
        if (!(localObject instanceof Map))
        {
          paramMap = String.valueOf(localBuilder.build().toString());
          if (paramMap.length() != 0) {}
          for (paramMap = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: "))
          {
            Log.e(paramMap);
            return;
          }
        }
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
        }
      }
    }
    paramMap = localBuilder.build().toString();
    this.zzcte.zzXg().sendHit(paramMap);
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {}
    for (paramMap = "ArbitraryPixel: url = ".concat(paramMap);; paramMap = new String("ArbitraryPixel: url = "))
    {
      Log.v(paramMap);
      if (str == null) {
        break;
      }
      try
      {
        zzctd.add(str);
        zzcr.zze(this.mContext, zzctc, str, "true");
        return;
      }
      finally {}
    }
  }
  
  boolean zzjx(String paramString)
  {
    return this.mContext.getSharedPreferences(zzctc, 0).contains(paramString);
  }
  
  boolean zzjy(String paramString)
  {
    return zzctd.contains(paramString);
  }
  
  public static abstract interface zza
  {
    public abstract HitSender zzXg();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */