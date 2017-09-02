package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.data.AppInfo;
import com.google.android.gms.analytics.data.CampaignInfo;
import com.google.android.gms.analytics.data.CustomDimensions;
import com.google.android.gms.analytics.data.CustomMetrics;
import com.google.android.gms.analytics.data.CustomParams;
import com.google.android.gms.analytics.data.DeviceInfo;
import com.google.android.gms.analytics.data.EcommerceInfo;
import com.google.android.gms.analytics.data.EventInfo;
import com.google.android.gms.analytics.data.ExceptionInfo;
import com.google.android.gms.analytics.data.HitParams;
import com.google.android.gms.analytics.data.ScreenViewInfo;
import com.google.android.gms.analytics.data.SocialInfo;
import com.google.android.gms.analytics.data.TimingInfo;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzac;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzb
  extends com.google.android.gms.analytics.internal.zzc
  implements zzi
{
  private static DecimalFormat zzabc;
  private final zzf zzaaY;
  private final String zzabd;
  private final Uri zzabe;
  private final boolean zzabf;
  private final boolean zzabg;
  
  public zzb(zzf paramzzf, String paramString)
  {
    this(paramzzf, paramString, true, false);
  }
  
  public zzb(zzf paramzzf, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzf);
    zzac.zzdc(paramString);
    this.zzaaY = paramzzf;
    this.zzabd = paramString;
    this.zzabf = paramBoolean1;
    this.zzabg = paramBoolean2;
    this.zzabe = zzbm(this.zzabd);
  }
  
  private static String zzR(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, zzb(paramDouble));
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramMap.put(paramString, 23 + paramInt1 + "x" + paramInt2);
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  static String zzb(double paramDouble)
  {
    if (zzabc == null) {
      zzabc = new DecimalFormat("0.######");
    }
    return zzabc.format(paramDouble);
  }
  
  private static void zzb(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  static Uri zzbm(String paramString)
  {
    zzac.zzdc(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  public static Map<String, String> zzc(zze paramzze)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (CustomParams)paramzze.zza(CustomParams.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((CustomParams)localObject1).params().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzj(((Map.Entry)localObject2).getValue());
        if (localObject3 != null) {
          localHashMap.put((String)((Map.Entry)localObject2).getKey(), localObject3);
        }
      }
    }
    localObject1 = (HitParams)paramzze.zza(HitParams.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "t", ((HitParams)localObject1).getHitType());
      zzb(localHashMap, "cid", ((HitParams)localObject1).getClientId());
      zzb(localHashMap, "uid", ((HitParams)localObject1).getUserId());
      zzb(localHashMap, "sc", ((HitParams)localObject1).getSessionControl());
      zza(localHashMap, "sf", ((HitParams)localObject1).getSampleRate());
      zza(localHashMap, "ni", ((HitParams)localObject1).isNonInteraction());
      zzb(localHashMap, "adid", ((HitParams)localObject1).getAndroidAdId());
      zza(localHashMap, "ate", ((HitParams)localObject1).isAdTargetingEnabled());
    }
    localObject1 = (ScreenViewInfo)paramzze.zza(ScreenViewInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cd", ((ScreenViewInfo)localObject1).getScreenName());
      zza(localHashMap, "a", ((ScreenViewInfo)localObject1).getScreenId());
      zzb(localHashMap, "dr", ((ScreenViewInfo)localObject1).getReferrerUri());
    }
    localObject1 = (EventInfo)paramzze.zza(EventInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ec", ((EventInfo)localObject1).getCategory());
      zzb(localHashMap, "ea", ((EventInfo)localObject1).getAction());
      zzb(localHashMap, "el", ((EventInfo)localObject1).getLabel());
      zza(localHashMap, "ev", ((EventInfo)localObject1).getValue());
    }
    localObject1 = (CampaignInfo)paramzze.zza(CampaignInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cn", ((CampaignInfo)localObject1).getName());
      zzb(localHashMap, "cs", ((CampaignInfo)localObject1).getSource());
      zzb(localHashMap, "cm", ((CampaignInfo)localObject1).getMedium());
      zzb(localHashMap, "ck", ((CampaignInfo)localObject1).getKeyword());
      zzb(localHashMap, "cc", ((CampaignInfo)localObject1).getContent());
      zzb(localHashMap, "ci", ((CampaignInfo)localObject1).getId());
      zzb(localHashMap, "anid", ((CampaignInfo)localObject1).getAdNetworkId());
      zzb(localHashMap, "gclid", ((CampaignInfo)localObject1).getGclid());
      zzb(localHashMap, "dclid", ((CampaignInfo)localObject1).getDclid());
      zzb(localHashMap, "aclid", ((CampaignInfo)localObject1).getAclid());
    }
    localObject1 = (ExceptionInfo)paramzze.zza(ExceptionInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "exd", ((ExceptionInfo)localObject1).getDescription());
      zza(localHashMap, "exf", ((ExceptionInfo)localObject1).isFatal());
    }
    localObject1 = (SocialInfo)paramzze.zza(SocialInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "sn", ((SocialInfo)localObject1).getNetwork());
      zzb(localHashMap, "sa", ((SocialInfo)localObject1).getAction());
      zzb(localHashMap, "st", ((SocialInfo)localObject1).getTarget());
    }
    localObject1 = (TimingInfo)paramzze.zza(TimingInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "utv", ((TimingInfo)localObject1).getVariableName());
      zza(localHashMap, "utt", ((TimingInfo)localObject1).getTimeInMillis());
      zzb(localHashMap, "utc", ((TimingInfo)localObject1).getCategory());
      zzb(localHashMap, "utl", ((TimingInfo)localObject1).getLabel());
    }
    localObject1 = (CustomDimensions)paramzze.zza(CustomDimensions.class);
    if (localObject1 != null)
    {
      localObject1 = ((CustomDimensions)localObject1).getDimensionsSet().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzas(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, (String)((Map.Entry)localObject2).getValue());
        }
      }
    }
    localObject1 = (CustomMetrics)paramzze.zza(CustomMetrics.class);
    if (localObject1 != null)
    {
      localObject1 = ((CustomMetrics)localObject1).getMetricsSet().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzau(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, zzb(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    localObject1 = (EcommerceInfo)paramzze.zza(EcommerceInfo.class);
    if (localObject1 != null)
    {
      localObject2 = ((EcommerceInfo)localObject1).getProductAction();
      if (localObject2 != null)
      {
        localObject2 = ((ProductAction)localObject2).build().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((String)((Map.Entry)localObject3).getKey()).startsWith("&")) {
            localHashMap.put(((String)((Map.Entry)localObject3).getKey()).substring(1), (String)((Map.Entry)localObject3).getValue());
          } else {
            localHashMap.put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
        }
      }
      localObject2 = ((EcommerceInfo)localObject1).getPromotions().iterator();
      int i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject2).next()).zzbo(zzc.zzaw(i)));
        i += 1;
      }
      localObject2 = ((EcommerceInfo)localObject1).getProducts().iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject2).next()).zzbo(zzc.zzav(i)));
        i += 1;
      }
      localObject2 = ((EcommerceInfo)localObject1).getImpressions().entrySet().iterator();
      i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject1 = (List)((Map.Entry)localObject3).getValue();
        String str1 = zzc.zzax(i);
        Iterator localIterator = ((List)localObject1).iterator();
        int j = 1;
        if (localIterator.hasNext())
        {
          Product localProduct = (Product)localIterator.next();
          localObject1 = String.valueOf(str1);
          String str2 = String.valueOf(zzc.impressionPrefix(j));
          if (str2.length() != 0) {}
          for (localObject1 = ((String)localObject1).concat(str2);; localObject1 = new String((String)localObject1))
          {
            localHashMap.putAll(localProduct.zzbo((String)localObject1));
            j += 1;
            break;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject3).getKey()))
        {
          localObject1 = String.valueOf(str1);
          str1 = String.valueOf("nm");
          if (str1.length() == 0) {
            break label1285;
          }
        }
        label1285:
        for (localObject1 = ((String)localObject1).concat(str1);; localObject1 = new String((String)localObject1))
        {
          localHashMap.put(localObject1, (String)((Map.Entry)localObject3).getKey());
          i += 1;
          break;
        }
      }
    }
    localObject1 = (DeviceInfo)paramzze.zza(DeviceInfo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ul", ((DeviceInfo)localObject1).getLanguage());
      zza(localHashMap, "sd", ((DeviceInfo)localObject1).getScreenColors());
      zza(localHashMap, "sr", ((DeviceInfo)localObject1).getScreenWidth(), ((DeviceInfo)localObject1).getScreenHeight());
      zza(localHashMap, "vp", ((DeviceInfo)localObject1).getViewportWidth(), ((DeviceInfo)localObject1).getViewportHeight());
    }
    paramzze = (AppInfo)paramzze.zza(AppInfo.class);
    if (paramzze != null)
    {
      zzb(localHashMap, "an", paramzze.getAppName());
      zzb(localHashMap, "aid", paramzze.getAppId());
      zzb(localHashMap, "aiid", paramzze.getAppInstallerId());
      zzb(localHashMap, "av", paramzze.getAppVersion());
    }
    return localHashMap;
  }
  
  private static String zzj(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!TextUtils.isEmpty(str));
    return null;
    if ((paramObject instanceof Double))
    {
      paramObject = (Double)paramObject;
      if (((Double)paramObject).doubleValue() != 0.0D) {
        return zzb(((Double)paramObject).doubleValue());
      }
      return null;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject != Boolean.FALSE) {
        return "1";
      }
      return null;
    }
    return String.valueOf(paramObject);
  }
  
  public void zzb(zze paramzze)
  {
    zzac.zzC(paramzze);
    zzac.zzb(paramzze.zzmM(), "Can't deliver not submitted measurement");
    zzac.zzcV("deliver should be called on worker thread");
    Object localObject2 = paramzze.zzmH();
    Object localObject1 = (HitParams)((zze)localObject2).zzb(HitParams.class);
    if (TextUtils.isEmpty(((HitParams)localObject1).getHitType())) {
      zznr().zzg(zzc((zze)localObject2), "Ignoring measurement without type");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(((HitParams)localObject1).getClientId()))
      {
        zznr().zzg(zzc((zze)localObject2), "Ignoring measurement without client id");
        return;
      }
    } while (this.zzaaY.zznE().getAppOptOut());
    double d = ((HitParams)localObject1).getSampleRate();
    if (zzao.zza(d, ((HitParams)localObject1).getClientId()))
    {
      zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
      return;
    }
    localObject2 = zzc((zze)localObject2);
    ((Map)localObject2).put("v", "1");
    ((Map)localObject2).put("_v", com.google.android.gms.analytics.internal.zze.zzadz);
    ((Map)localObject2).put("tid", this.zzabd);
    if (this.zzaaY.zznE().isDryRunEnabled())
    {
      zzc("Dry run is enabled. GoogleAnalytics would have sent", zzR((Map)localObject2));
      return;
    }
    HashMap localHashMap = new HashMap();
    zzao.zzc(localHashMap, "uid", ((HitParams)localObject1).getUserId());
    Object localObject3 = (AppInfo)paramzze.zza(AppInfo.class);
    if (localObject3 != null)
    {
      zzao.zzc(localHashMap, "an", ((AppInfo)localObject3).getAppName());
      zzao.zzc(localHashMap, "aid", ((AppInfo)localObject3).getAppId());
      zzao.zzc(localHashMap, "av", ((AppInfo)localObject3).getAppVersion());
      zzao.zzc(localHashMap, "aiid", ((AppInfo)localObject3).getAppInstallerId());
    }
    localObject3 = ((HitParams)localObject1).getClientId();
    String str = this.zzabd;
    if (!TextUtils.isEmpty(((HitParams)localObject1).getAndroidAdId())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new zzh(0L, (String)localObject3, str, bool, 0L, localHashMap);
      ((Map)localObject2).put("_s", String.valueOf(zzmF().zza((zzh)localObject1)));
      paramzze = new zzab(zznr(), (Map)localObject2, paramzze.zzmK(), true);
      zzmF().zza(paramzze);
      return;
    }
  }
  
  public Uri zzmx()
  {
    return this.zzabe;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */