package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

public final class zzc
{
  public static String impressionListPrefix(int paramInt)
  {
    return zzc("&il", paramInt);
  }
  
  public static String impressionPrefix(int paramInt)
  {
    return zzc("pi", paramInt);
  }
  
  public static String productPrefix(int paramInt)
  {
    return zzc("&pr", paramInt);
  }
  
  public static String promotionPrefix(int paramInt)
  {
    return zzc("&promo", paramInt);
  }
  
  public static String zzar(int paramInt)
  {
    return zzc("&cd", paramInt);
  }
  
  public static String zzas(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzat(int paramInt)
  {
    return zzc("&cm", paramInt);
  }
  
  public static String zzau(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  public static String zzav(int paramInt)
  {
    return zzc("pr", paramInt);
  }
  
  public static String zzaw(int paramInt)
  {
    return zzc("promo", paramInt);
  }
  
  public static String zzax(int paramInt)
  {
    return zzc("il", paramInt);
  }
  
  public static String zzay(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzaz(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  private static String zzc(String paramString, int paramInt)
  {
    if (paramInt < 1)
    {
      zzae.zzf("index out of range for prefix", paramString);
      return "";
    }
    return String.valueOf(paramString).length() + 11 + paramString + paramInt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */