package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzbx
{
  private static zzbx zzcvt;
  private volatile String zzcaK;
  private volatile zza zzcvu;
  private volatile String zzcvv;
  private volatile String zzcvw;
  
  zzbx()
  {
    clear();
  }
  
  private String zzB(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static zzbx zzXY()
  {
    try
    {
      if (zzcvt == null) {
        zzcvt = new zzbx();
      }
      zzbx localzzbx = zzcvt;
      return localzzbx;
    }
    finally {}
  }
  
  private String zzjS(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  void clear()
  {
    this.zzcvu = zza.zzcvx;
    this.zzcvv = null;
    this.zzcaK = null;
    this.zzcvw = null;
  }
  
  String getContainerId()
  {
    return this.zzcaK;
  }
  
  boolean zzA(Uri paramUri)
  {
    boolean bool = true;
    String str2;
    try
    {
      str2 = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label177;
      }
      str1 = String.valueOf(str2);
      if (str1.length() == 0) {
        break label149;
      }
      str1 = "Container preview url: ".concat(str1);
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        label122:
        bool = false;
        continue;
        label149:
        String str1 = new String("Container preview url: ");
      }
    }
    finally {}
    Log.v(str1);
    if (str2.matches(".*?&gtm_debug=x$"))
    {
      this.zzcvu = zza.zzcvz;
      this.zzcvw = zzB(paramUri);
      if ((this.zzcvu == zza.zzcvy) || (this.zzcvu == zza.zzcvz))
      {
        paramUri = String.valueOf("/r?");
        str1 = String.valueOf(this.zzcvw);
        if (str1.length() == 0) {
          break label301;
        }
        paramUri = paramUri.concat(str1);
        this.zzcvv = paramUri;
      }
      this.zzcaK = zzjS(this.zzcvw);
    }
    for (;;)
    {
      return bool;
      this.zzcvu = zza.zzcvy;
      break;
      label177:
      if (str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (zzjS(paramUri.getQuery()).equals(this.zzcaK))
        {
          paramUri = String.valueOf(this.zzcaK);
          if (paramUri.length() != 0) {}
          for (paramUri = "Exit preview mode for container: ".concat(paramUri);; paramUri = new String("Exit preview mode for container: "))
          {
            Log.v(paramUri);
            this.zzcvu = zza.zzcvx;
            this.zzcvv = null;
            break;
          }
        }
      }
      else
      {
        paramUri = String.valueOf(str2);
        if (paramUri.length() != 0) {}
        for (paramUri = "Invalid preview uri: ".concat(paramUri);; paramUri = new String("Invalid preview uri: "))
        {
          Log.w(paramUri);
          bool = false;
          break;
        }
        label301:
        paramUri = new String(paramUri);
        break label122;
      }
      bool = false;
    }
  }
  
  zza zzXZ()
  {
    return this.zzcvu;
  }
  
  String zzYa()
  {
    return this.zzcvv;
  }
  
  static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */