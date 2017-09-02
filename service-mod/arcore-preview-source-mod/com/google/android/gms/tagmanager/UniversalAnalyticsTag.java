package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversalAnalyticsTag
  extends TrackingTag
{
  private static final String ID = zzah.zzeL.toString();
  private static final String zzcxc = zzai.zzfr.toString();
  private static final String zzcxd = zzai.zzfC.toString();
  private static final String zzcxe = zzai.zzhb.toString();
  private static final String zzcxf = zzai.zzgU.toString();
  private static final String zzcxg = zzai.zzgT.toString();
  private static final String zzcxh = zzai.zzfB.toString();
  private static final String zzcxi = zzai.zzjJ.toString();
  private static final String zzcxj = zzai.zzjM.toString();
  private static final String zzcxk = zzai.zzjO.toString();
  private static final List<String> zzcxl = Arrays.asList(new String[] { "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund" });
  private static final Pattern zzcxm = Pattern.compile("dimension(\\d+)");
  private static final Pattern zzcxn = Pattern.compile("metric(\\d+)");
  private static Map<String, String> zzcxo;
  private static Map<String, String> zzcxp;
  private final DataLayer zzctf;
  private final Set<String> zzcxq;
  private final TrackerProvider zzcxr;
  
  public UniversalAnalyticsTag(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new TrackerProvider(paramContext));
  }
  
  UniversalAnalyticsTag(Context paramContext, DataLayer paramDataLayer, TrackerProvider paramTrackerProvider)
  {
    super(ID, new String[0]);
    this.zzctf = paramDataLayer;
    this.zzcxr = paramTrackerProvider;
    this.zzcxq = new HashSet();
    this.zzcxq.add("");
    this.zzcxq.add("0");
    this.zzcxq.add("false");
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  private void zza(Tracker paramTracker, Map<String, zzak.zza> paramMap)
  {
    String str = zzkf("transactionId");
    if (str == null) {
      Log.e("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = zzk((zzak.zza)paramMap.get(zzcxh));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = zzao(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          zze((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), zzkf((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        Log.e("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = zzkg("transactionProducts");
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            Log.e("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = zzk((zzak.zza)paramMap.get(zzcxh));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = zzap(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            zze((Map)localObject3, (String)localEntry.getValue(), (String)((Map)localObject2).get(localEntry.getKey()));
          }
          localLinkedList.add(localObject3);
        }
      }
      paramMap = localLinkedList.iterator();
      while (paramMap.hasNext()) {
        paramTracker.send((Map)paramMap.next());
      }
    }
  }
  
  private Double zzaf(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return (Double)paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(((NumberFormatException)paramObject).getMessage());
        if (((String)paramObject).length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Double: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
        throw new RuntimeException((String)paramObject);
      }
    }
    if ((paramObject instanceof Integer)) {
      return Double.valueOf(((Integer)paramObject).doubleValue());
    }
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (((String)paramObject).length() != 0) {}
    for (paramObject = "Cannot convert the object to Double: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
      throw new RuntimeException((String)paramObject);
    }
  }
  
  private Integer zzag(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      try
      {
        paramObject = Integer.valueOf((String)paramObject);
        return (Integer)paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(((NumberFormatException)paramObject).getMessage());
        if (((String)paramObject).length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Integer: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
        throw new RuntimeException((String)paramObject);
      }
    }
    if ((paramObject instanceof Double)) {
      return Integer.valueOf(((Double)paramObject).intValue());
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (((String)paramObject).length() != 0) {}
    for (paramObject = "Cannot convert the object to Integer: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
      throw new RuntimeException((String)paramObject);
    }
  }
  
  private Promotion zzam(Map<String, String> paramMap)
  {
    Promotion localPromotion = new Promotion();
    String str = (String)paramMap.get("id");
    if (str != null) {
      localPromotion.setId(String.valueOf(str));
    }
    str = (String)paramMap.get("name");
    if (str != null) {
      localPromotion.setName(String.valueOf(str));
    }
    str = (String)paramMap.get("creative");
    if (str != null) {
      localPromotion.setCreative(String.valueOf(str));
    }
    paramMap = (String)paramMap.get("position");
    if (paramMap != null) {
      localPromotion.setPosition(String.valueOf(paramMap));
    }
    return localPromotion;
  }
  
  private Product zzan(Map<String, Object> paramMap)
  {
    Product localProduct = new Product();
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      localProduct.setId(String.valueOf(localObject));
    }
    localObject = paramMap.get("name");
    if (localObject != null) {
      localProduct.setName(String.valueOf(localObject));
    }
    localObject = paramMap.get("brand");
    if (localObject != null) {
      localProduct.setBrand(String.valueOf(localObject));
    }
    localObject = paramMap.get("category");
    if (localObject != null) {
      localProduct.setCategory(String.valueOf(localObject));
    }
    localObject = paramMap.get("variant");
    if (localObject != null) {
      localProduct.setVariant(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      localProduct.setCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("position");
    if (localObject != null) {
      localProduct.setPosition(zzag(localObject).intValue());
    }
    localObject = paramMap.get("price");
    if (localObject != null) {
      localProduct.setPrice(zzaf(localObject).doubleValue());
    }
    localObject = paramMap.get("quantity");
    if (localObject != null) {
      localProduct.setQuantity(zzag(localObject).intValue());
    }
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label455;
      }
      localObject = (String)localIterator.next();
      Matcher localMatcher1 = zzcxm.matcher((CharSequence)localObject);
      int i;
      if (localMatcher1.matches())
      {
        try
        {
          i = Integer.parseInt(localMatcher1.group(1));
          localProduct.setCustomDimension(i, String.valueOf(paramMap.get(localObject)));
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localObject = String.valueOf(localObject);
          if (((String)localObject).length() == 0) {}
        }
        for (localObject = "illegal number in custom dimension value: ".concat((String)localObject);; localObject = new String("illegal number in custom dimension value: "))
        {
          Log.w((String)localObject);
          break;
        }
      }
      else
      {
        Matcher localMatcher2 = zzcxn.matcher((CharSequence)localObject);
        if (localMatcher2.matches()) {
          try
          {
            i = Integer.parseInt(localMatcher2.group(1));
            localProduct.setCustomMetric(i, zzag(paramMap.get(localObject)).intValue());
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localObject = String.valueOf(localObject);
            if (((String)localObject).length() == 0) {}
          }
        }
      }
    }
    for (localObject = "illegal number in custom metric value: ".concat((String)localObject);; localObject = new String("illegal number in custom metric value: "))
    {
      Log.w((String)localObject);
      break;
    }
    label455:
    return localProduct;
  }
  
  private Map<String, String> zzao(Map<String, zzak.zza> paramMap)
  {
    paramMap = (zzak.zza)paramMap.get(zzcxj);
    if (paramMap != null) {
      return zzc(paramMap);
    }
    if (zzcxo == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      zzcxo = paramMap;
    }
    return zzcxo;
  }
  
  private Map<String, String> zzap(Map<String, zzak.zza> paramMap)
  {
    paramMap = (zzak.zza)paramMap.get(zzcxk);
    if (paramMap != null) {
      return zzc(paramMap);
    }
    if (zzcxp == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      zzcxp = paramMap;
    }
    return zzcxp;
  }
  
  private void zzb(Tracker paramTracker, Map<String, zzak.zza> paramMap)
  {
    HitBuilders.ScreenViewBuilder localScreenViewBuilder = new HitBuilders.ScreenViewBuilder();
    Object localObject1 = zzk((zzak.zza)paramMap.get(zzcxh));
    localScreenViewBuilder.setAll((Map)localObject1);
    if (zzi(paramMap, zzcxf))
    {
      paramMap = this.zzctf.get("ecommerce");
      if (!(paramMap instanceof Map)) {
        break label800;
      }
      paramMap = (Map)paramMap;
    }
    for (;;)
    {
      Object localObject4;
      label158:
      Object localObject2;
      if (paramMap != null)
      {
        localObject4 = (String)((Map)localObject1).get("&cu");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = (String)paramMap.get("currencyCode");
        }
        if (localObject1 != null) {
          localScreenViewBuilder.set("&cu", (String)localObject1);
        }
        localObject1 = paramMap.get("impressions");
        if ((localObject1 instanceof List))
        {
          localObject4 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label292;
            }
            localObject1 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addImpression(zzan((Map)localObject1), (String)((Map)localObject1).get("list"));
            }
            catch (RuntimeException localRuntimeException1)
            {
              localObject2 = String.valueOf(localRuntimeException1.getMessage());
              if (((String)localObject2).length() == 0) {}
            }
          }
          for (localObject2 = "Failed to extract a product from DataLayer. ".concat((String)localObject2);; localObject2 = new String("Failed to extract a product from DataLayer. "))
          {
            Log.e((String)localObject2);
            break label158;
            paramMap = zzcw.zzj((zzak.zza)paramMap.get(zzcxg));
            if (!(paramMap instanceof Map)) {
              break label795;
            }
            paramMap = (Map)paramMap;
            break;
          }
        }
        label292:
        if (paramMap.containsKey("promoClick")) {
          localObject2 = (List)((Map)paramMap.get("promoClick")).get("promotions");
        }
      }
      for (;;)
      {
        label343:
        label473:
        int i;
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label473;
            }
            localObject2 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addPromotion(zzam((Map)localObject2));
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject3 = String.valueOf(localRuntimeException2.getMessage());
              if (((String)localObject3).length() == 0) {}
            }
          }
          for (localObject3 = "Failed to extract a promotion from DataLayer. ".concat((String)localObject3);; localObject3 = new String("Failed to extract a promotion from DataLayer. "))
          {
            Log.e((String)localObject3);
            break label343;
            if (!paramMap.containsKey("promoView")) {
              break label789;
            }
            localObject3 = (List)((Map)paramMap.get("promoView")).get("promotions");
            break;
          }
          if (paramMap.containsKey("promoClick"))
          {
            localScreenViewBuilder.set("&promoa", "click");
            i = 0;
            if (i == 0) {
              break label721;
            }
            localObject4 = zzcxl.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject3 = (String)((Iterator)localObject4).next();
            } while (!paramMap.containsKey(localObject3));
            localObject4 = (Map)paramMap.get(localObject3);
            paramMap = (List)((Map)localObject4).get("products");
            if (paramMap == null) {
              break label681;
            }
            Iterator localIterator = paramMap.iterator();
            for (;;)
            {
              label584:
              if (!localIterator.hasNext()) {
                break label681;
              }
              paramMap = (Map)localIterator.next();
              try
              {
                localScreenViewBuilder.addProduct(zzan(paramMap));
              }
              catch (RuntimeException paramMap)
              {
                paramMap = String.valueOf(paramMap.getMessage());
                if (paramMap.length() == 0) {}
              }
            }
          }
        }
        for (paramMap = "Failed to extract a product from DataLayer. ".concat(paramMap);; paramMap = new String("Failed to extract a product from DataLayer. "))
        {
          Log.e(paramMap);
          break label584;
          localScreenViewBuilder.set("&promoa", "view");
          i = 1;
          break;
        }
        try
        {
          label681:
          if (((Map)localObject4).containsKey("actionField")) {}
          for (paramMap = zzh((String)localObject3, (Map)((Map)localObject4).get("actionField"));; paramMap = new ProductAction((String)localObject3))
          {
            localScreenViewBuilder.setProductAction(paramMap);
            label721:
            paramTracker.send(localScreenViewBuilder.build());
            return;
          }
          paramMap = "Failed to extract a product action from DataLayer. ".concat(paramMap);
        }
        catch (RuntimeException paramMap)
        {
          paramMap = String.valueOf(paramMap.getMessage());
          if (paramMap.length() == 0) {}
        }
        for (;;)
        {
          Log.e(paramMap);
          break;
          paramMap = new String("Failed to extract a product action from DataLayer. ");
        }
        label789:
        Object localObject3 = null;
      }
      label795:
      paramMap = null;
      continue;
      label800:
      paramMap = null;
    }
  }
  
  private Map<String, String> zzc(zzak.zza paramzza)
  {
    paramzza = zzcw.zzj(paramzza);
    if (!(paramzza instanceof Map)) {
      return null;
    }
    Object localObject = (Map)paramzza;
    paramzza = new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramzza.put(localEntry.getKey().toString(), localEntry.getValue().toString());
    }
    return paramzza;
  }
  
  private void zze(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private ProductAction zzh(String paramString, Map<String, Object> paramMap)
  {
    paramString = new ProductAction(paramString);
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      paramString.setTransactionId(String.valueOf(localObject));
    }
    localObject = paramMap.get("affiliation");
    if (localObject != null) {
      paramString.setTransactionAffiliation(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      paramString.setTransactionCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("list");
    if (localObject != null) {
      paramString.setProductActionList(String.valueOf(localObject));
    }
    localObject = paramMap.get("option");
    if (localObject != null) {
      paramString.setCheckoutOptions(String.valueOf(localObject));
    }
    localObject = paramMap.get("revenue");
    if (localObject != null) {
      paramString.setTransactionRevenue(zzaf(localObject).doubleValue());
    }
    localObject = paramMap.get("tax");
    if (localObject != null) {
      paramString.setTransactionTax(zzaf(localObject).doubleValue());
    }
    localObject = paramMap.get("shipping");
    if (localObject != null) {
      paramString.setTransactionShipping(zzaf(localObject).doubleValue());
    }
    paramMap = paramMap.get("step");
    if (paramMap != null) {
      paramString.setCheckoutStep(zzag(paramMap).intValue());
    }
    return paramString;
  }
  
  private boolean zzi(Map<String, zzak.zza> paramMap, String paramString)
  {
    paramMap = (zzak.zza)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return zzcw.zzi(paramMap).booleanValue();
  }
  
  private Map<String, String> zzk(zzak.zza paramzza)
  {
    if (paramzza == null) {
      return new HashMap();
    }
    paramzza = zzc(paramzza);
    if (paramzza == null) {
      return new HashMap();
    }
    String str = (String)paramzza.get("&aip");
    if ((str != null) && (this.zzcxq.contains(str.toLowerCase()))) {
      paramzza.remove("&aip");
    }
    return paramzza;
  }
  
  private String zzkf(String paramString)
  {
    paramString = this.zzctf.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  private List<Map<String, String>> zzkg(String paramString)
  {
    paramString = this.zzctf.get(paramString);
    if (paramString == null) {
      return null;
    }
    if (!(paramString instanceof List)) {
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    Iterator localIterator = ((List)paramString).iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Map)) {
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
    }
    return (List)paramString;
  }
  
  public void evaluateTrackingTag(Map<String, zzak.zza> paramMap)
  {
    Tracker localTracker = this.zzcxr.getTracker("_GTM_DEFAULT_TRACKER_");
    localTracker.enableAdvertisingIdCollection(zzi(paramMap, "collect_adid"));
    if (zzi(paramMap, zzcxe))
    {
      zzb(localTracker, paramMap);
      return;
    }
    if (zzi(paramMap, zzcxd))
    {
      localTracker.send(zzk((zzak.zza)paramMap.get(zzcxh)));
      return;
    }
    if (zzi(paramMap, zzcxi))
    {
      zza(localTracker, paramMap);
      return;
    }
    Log.w("Ignoring unknown tag.");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/UniversalAnalyticsTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */