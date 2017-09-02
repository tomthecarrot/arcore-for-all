package com.google.android.gms.tagmanager;

import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataBuilders
{
  protected static class DataBuilder<T extends DataBuilder<T>>
  {
    List<Promotion> zzabB = new ArrayList();
    List<Product> zzabC = new ArrayList();
    private Map<String, Object> zzaby = new HashMap();
    ProductAction zzabz;
    Map<String, List<Product>> zzctO = new HashMap();
    
    public T addImpression(Product paramProduct, String paramString)
    {
      if (paramProduct == null)
      {
        Log.w("product should be non-null");
        return getThis();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if (!this.zzctO.containsKey(str)) {
        this.zzctO.put(str, new ArrayList());
      }
      ((List)this.zzctO.get(str)).add(paramProduct);
      return getThis();
    }
    
    public T addProduct(Product paramProduct)
    {
      if (paramProduct == null)
      {
        Log.w("product should be non-null");
        return getThis();
      }
      this.zzabC.add(paramProduct);
      return getThis();
    }
    
    public T addPromotion(Promotion paramPromotion)
    {
      if (paramPromotion == null)
      {
        Log.w("promotion should be non-null");
        return getThis();
      }
      this.zzabB.add(paramPromotion);
      return getThis();
    }
    
    public Map<String, Object> build()
    {
      HashMap localHashMap = new HashMap(this.zzaby);
      if (this.zzabz != null) {
        localHashMap.putAll(this.zzabz.build());
      }
      Object localObject = this.zzabB.iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject).next()).zzbo(DataFields.promotionPrefix(i)));
        i += 1;
      }
      localObject = this.zzabC.iterator();
      i = 1;
      while (((Iterator)localObject).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject).next()).zzbo(DataFields.productPrefix(i)));
        i += 1;
      }
      Iterator localIterator1 = this.zzctO.entrySet().iterator();
      i = 1;
      if (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localObject = (List)localEntry.getValue();
        String str1 = DataFields.impressionListPrefix(i);
        Iterator localIterator2 = ((List)localObject).iterator();
        int j = 1;
        if (localIterator2.hasNext())
        {
          Product localProduct = (Product)localIterator2.next();
          localObject = String.valueOf(str1);
          String str2 = String.valueOf(DataFields.impressionPrefix(j));
          if (str2.length() != 0) {}
          for (localObject = ((String)localObject).concat(str2);; localObject = new String((String)localObject))
          {
            localHashMap.putAll(localProduct.zzbo((String)localObject));
            j += 1;
            break;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localEntry.getKey()))
        {
          localObject = String.valueOf(str1);
          str1 = String.valueOf("nm");
          if (str1.length() == 0) {
            break label344;
          }
        }
        label344:
        for (localObject = ((String)localObject).concat(str1);; localObject = new String((String)localObject))
        {
          localHashMap.put(localObject, localEntry.getKey());
          i += 1;
          break;
        }
      }
      return localHashMap;
    }
    
    protected Object get(String paramString)
    {
      return this.zzaby.get(paramString);
    }
    
    protected T getThis()
    {
      return this;
    }
    
    public final T set(String paramString, Object paramObject)
    {
      if (paramString != null) {
        this.zzaby.put(paramString, paramObject);
      }
      for (;;)
      {
        return getThis();
        Log.w("DataBuilder.set() called with a null paramName.");
      }
    }
    
    public final T setAll(Map<String, Object> paramMap)
    {
      if (paramMap == null) {
        return getThis();
      }
      this.zzaby.putAll(paramMap);
      return getThis();
    }
    
    public T setCampaignParamsFromUrl(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return getThis();
      }
      HashMap localHashMap = new HashMap();
      Object localObject = new UrlQuerySanitizer();
      ((UrlQuerySanitizer)localObject).setAllowUnregisteredParamaters(true);
      ((UrlQuerySanitizer)localObject).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      ((UrlQuerySanitizer)localObject).parseUrl(paramString);
      paramString = ((UrlQuerySanitizer)localObject).getParameterList();
      if (paramString.size() == 0) {
        return getThis();
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (UrlQuerySanitizer.ParameterValuePair)paramString.next();
        localHashMap.put(((UrlQuerySanitizer.ParameterValuePair)localObject).mParameter, ((UrlQuerySanitizer.ParameterValuePair)localObject).mValue);
      }
      set("gtm.campaign_content", localHashMap.get("utm_content"));
      set("gtm.campaign_medium", localHashMap.get("utm_medium"));
      set("gtm.campaign_name", localHashMap.get("utm_campaign"));
      set("gtm.campaign_source", localHashMap.get("utm_source"));
      set("gtm.campaign_keyword", localHashMap.get("utm_term"));
      set("gtm.campaign_id", localHashMap.get("utm_id"));
      set("gtm.gclid", localHashMap.get("gclid"));
      set("gtm.dclid", localHashMap.get("dclid"));
      set("gtm.gmob_t", localHashMap.get("gmob_t"));
      return getThis();
    }
    
    public T setNewSession()
    {
      set("gtm.session_control", "start");
      return getThis();
    }
    
    public T setNonInteraction(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (String str = "1";; str = "0")
      {
        set("gtm.non_interaction", str);
        return getThis();
      }
    }
    
    public T setProductAction(ProductAction paramProductAction)
    {
      this.zzabz = paramProductAction;
      return getThis();
    }
    
    public T setPromotionAction(String paramString)
    {
      this.zzaby.put("gtm.promotion_action", paramString);
      return getThis();
    }
    
    public final T setScreenName(String paramString)
    {
      this.zzaby.put("gtm.activity_screen_name", paramString);
      return getThis();
    }
  }
  
  public static class EventBuilder
    extends DataBuilders.DataBuilder<EventBuilder>
  {
    public EventBuilder()
    {
      set("event", "gtm.event");
    }
    
    public EventBuilder(String paramString1, String paramString2)
    {
      this();
      setCategory(paramString1);
      setAction(paramString2);
    }
    
    public EventBuilder setAction(String paramString)
    {
      set("gtm.event_action", paramString);
      return this;
    }
    
    public EventBuilder setCategory(String paramString)
    {
      set("gtm.event_category", paramString);
      return this;
    }
    
    public EventBuilder setLabel(String paramString)
    {
      set("gtm.event_label", paramString);
      return this;
    }
    
    public EventBuilder setValue(long paramLong)
    {
      set("gtm.event_value", Long.toString(paramLong));
      return this;
    }
  }
  
  public static class ExceptionBuilder
    extends DataBuilders.DataBuilder<ExceptionBuilder>
  {
    public ExceptionBuilder()
    {
      set("event", "gtm.exception");
    }
    
    public ExceptionBuilder setDescription(String paramString)
    {
      set("gtm.exception_description", paramString);
      return this;
    }
    
    public ExceptionBuilder setFatal(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (String str = "1";; str = "0")
      {
        set("gtm.exception_fatal", str);
        return this;
      }
    }
  }
  
  public static class ScreenViewBuilder
    extends DataBuilders.DataBuilder<ScreenViewBuilder>
  {
    public ScreenViewBuilder()
    {
      set("event", "gtm.screen_view");
    }
    
    public ScreenViewBuilder(String paramString)
    {
      this();
      setScreenName(paramString);
    }
  }
  
  public static class SocialBuilder
    extends DataBuilders.DataBuilder<SocialBuilder>
  {
    public SocialBuilder()
    {
      set("event", "gtm.social");
    }
    
    public SocialBuilder setAction(String paramString)
    {
      set("gtm.social_action", paramString);
      return this;
    }
    
    public SocialBuilder setNetwork(String paramString)
    {
      set("gtm.social_network", paramString);
      return this;
    }
    
    public SocialBuilder setTarget(String paramString)
    {
      set("gtm.social_target", paramString);
      return this;
    }
  }
  
  public static class TimingBuilder
    extends DataBuilders.DataBuilder<TimingBuilder>
  {
    public TimingBuilder()
    {
      set("event", "gtm.timing");
    }
    
    public TimingBuilder(String paramString1, String paramString2, long paramLong)
    {
      this();
      setVariable(paramString2);
      setValue(paramLong);
      setCategory(paramString1);
    }
    
    public TimingBuilder setCategory(String paramString)
    {
      set("gtm.timing_category", paramString);
      return this;
    }
    
    public TimingBuilder setLabel(String paramString)
    {
      set("gtm.timing_label", paramString);
      return this;
    }
    
    public TimingBuilder setValue(long paramLong)
    {
      set("gtm.timing_value", Long.toString(paramLong));
      return this;
    }
    
    public TimingBuilder setVariable(String paramString)
    {
      set("gtm.timing_variable", paramString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/DataBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */