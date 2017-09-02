package com.google.android.gms.analytics.data;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class EcommerceInfo
  extends zzf<EcommerceInfo>
{
  private final Map<String, List<Product>> zzabA = new HashMap();
  private final List<Promotion> zzabB = new ArrayList();
  private final List<Product> zzabC = new ArrayList();
  private ProductAction zzabz;
  
  public void addImpression(Product paramProduct, String paramString)
  {
    if (paramProduct == null) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.zzabA.containsKey(str)) {
      this.zzabA.put(str, new ArrayList());
    }
    ((List)this.zzabA.get(str)).add(paramProduct);
  }
  
  public void addProduct(Product paramProduct)
  {
    if (paramProduct != null) {
      this.zzabC.add(paramProduct);
    }
  }
  
  public void addPromotion(Promotion paramPromotion)
  {
    if (paramPromotion != null) {
      this.zzabB.add(paramPromotion);
    }
  }
  
  public Map<String, List<Product>> getImpressions()
  {
    return this.zzabA;
  }
  
  public ProductAction getProductAction()
  {
    return this.zzabz;
  }
  
  public List<Product> getProducts()
  {
    return Collections.unmodifiableList(this.zzabC);
  }
  
  public List<Promotion> getPromotions()
  {
    return Collections.unmodifiableList(this.zzabB);
  }
  
  public void mergeTo(EcommerceInfo paramEcommerceInfo)
  {
    paramEcommerceInfo.zzabC.addAll(this.zzabC);
    paramEcommerceInfo.zzabB.addAll(this.zzabB);
    Iterator localIterator = this.zzabA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramEcommerceInfo.addImpression((Product)((Iterator)localObject).next(), str);
      }
    }
    if (this.zzabz != null) {
      paramEcommerceInfo.zzabz = this.zzabz;
    }
  }
  
  public void setProductAction(ProductAction paramProductAction)
  {
    this.zzabz = paramProductAction;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!this.zzabC.isEmpty()) {
      localHashMap.put("products", this.zzabC);
    }
    if (!this.zzabB.isEmpty()) {
      localHashMap.put("promotions", this.zzabB);
    }
    if (!this.zzabA.isEmpty()) {
      localHashMap.put("impressions", this.zzabA);
    }
    localHashMap.put("productAction", this.zzabz);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/EcommerceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */