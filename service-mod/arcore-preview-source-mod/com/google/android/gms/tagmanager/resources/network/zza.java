package com.google.android.gms.tagmanager.resources.network;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbpa;
import com.google.android.gms.tagmanager.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class zza
{
  private String zzctL = "https://www.google-analytics.com";
  
  private String zzkh(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {}
    }
    for (paramString = "Cannot encode the string: ".concat(paramString);; paramString = new String("Cannot encode the string: "))
    {
      Log.e(paramString);
      return "";
    }
  }
  
  public void setCtfeServerAddress(String paramString)
  {
    this.zzctL = paramString;
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "The Ctfe server endpoint was changed to: ".concat(paramString);; paramString = new String("The Ctfe server endpoint was changed to: "))
    {
      Log.i(paramString);
      return;
    }
  }
  
  public String zzak(List<zzbpa> paramList)
  {
    String str1 = this.zzctL;
    String str2 = String.valueOf("/gtm/android?");
    paramList = String.valueOf(zzal(paramList));
    return String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(paramList).length() + str1 + str2 + paramList;
  }
  
  String zzal(List<zzbpa> paramList)
  {
    boolean bool = true;
    if (paramList.size() <= 1) {}
    for (;;)
    {
      zzac.zzaw(bool);
      if (!paramList.isEmpty()) {
        break;
      }
      return "";
      bool = false;
    }
    zzbpa localzzbpa = (zzbpa)paramList.get(0);
    StringBuilder localStringBuilder;
    if (!localzzbpa.zzZA().trim().equals(""))
    {
      paramList = localzzbpa.zzZA().trim();
      localStringBuilder = new StringBuilder();
      if (localzzbpa.zzZw() == null) {
        break label162;
      }
      localStringBuilder.append(localzzbpa.zzZw());
    }
    for (;;)
    {
      localStringBuilder.append("=").append(zzkh(localzzbpa.getContainerId())).append("&").append("pv").append("=").append(zzkh(paramList));
      if (localzzbpa.zzZy()) {
        localStringBuilder.append("&gtm_debug=x");
      }
      return localStringBuilder.toString();
      paramList = "-1";
      break;
      label162:
      localStringBuilder.append("id");
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/resources/network/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */