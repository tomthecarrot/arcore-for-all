package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzw
  implements HitSender
{
  private static final Object zzcsU = new Object();
  private static zzw zzcuj;
  private zzbz zzctv;
  private String zzcuk;
  private String zzcul;
  private zzan zzcum;
  
  private zzw(Context paramContext)
  {
    this(zzao.zzcj(paramContext), new zzco());
  }
  
  zzw(zzan paramzzan, zzbz paramzzbz)
  {
    this.zzcum = paramzzan;
    this.zzctv = paramzzbz;
  }
  
  public static HitSender zzcc(Context paramContext)
  {
    synchronized (zzcsU)
    {
      if (zzcuj == null) {
        zzcuj = new zzw(paramContext);
      }
      paramContext = zzcuj;
      return paramContext;
    }
  }
  
  public boolean sendHit(String paramString)
  {
    if (!this.zzctv.zzpu())
    {
      Log.w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str1 = paramString;
    if (this.zzcuk != null)
    {
      str1 = paramString;
      if (this.zzcul == null) {}
    }
    try
    {
      str1 = this.zzcuk;
      String str2 = this.zzcul;
      paramString = String.valueOf(URLEncoder.encode(paramString, "UTF-8"));
      str1 = String.valueOf(str1).length() + 2 + String.valueOf(str2).length() + String.valueOf(paramString).length() + str1 + "?" + str2 + "=" + paramString;
      paramString = String.valueOf(str1);
      if (paramString.length() != 0) {}
      for (paramString = "Sending wrapped url hit: ".concat(paramString);; paramString = new String("Sending wrapped url hit: "))
      {
        Log.v(paramString);
        this.zzcum.zzjP(str1);
        return true;
      }
      return false;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.w("Error wrapping URL for testing.", paramString);
    }
  }
  
  public void setUrlWrapModeForTesting(String paramString1, String paramString2)
  {
    this.zzcuk = paramString1;
    this.zzcul = paramString2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */