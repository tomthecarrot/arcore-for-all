package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class InstanceID
{
  public static final String ERROR_BACKOFF = "RETRY_LATER";
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String ERROR_TIMEOUT = "TIMEOUT";
  public static final String OPTION_SUBTYPE = "subtype";
  static Map<String, InstanceID> zzbAC = new HashMap();
  private static zzc zzbAD;
  private static Rpc zzbAE;
  static String zzbAI;
  Context mContext;
  KeyPair zzbAF;
  String zzbAG = "";
  long zzbAH;
  
  protected InstanceID(Context paramContext, String paramString, Bundle paramBundle)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzbAG = paramString;
  }
  
  public static InstanceID getInstance(Context paramContext)
  {
    return getInstance(paramContext, null);
  }
  
  public static InstanceID getInstance(Context paramContext, Bundle paramBundle)
  {
    String str;
    if (paramBundle == null) {
      str = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (zzbAD == null)
        {
          zzbAD = new zzc(localContext);
          zzbAE = new Rpc(localContext);
        }
        zzbAI = Integer.toString(zzbD(localContext));
        InstanceID localInstanceID = (InstanceID)zzbAC.get(str);
        paramContext = localInstanceID;
        if (localInstanceID == null)
        {
          paramContext = new InstanceID(localContext, str, paramBundle);
          zzbAC.put(str, paramContext);
        }
        return paramContext;
      }
      finally {}
      str = paramBundle.getString("subtype");
      while (str != null) {
        break;
      }
      str = "";
    }
  }
  
  static String zzB(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  static String zza(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
    }
    return null;
  }
  
  static int zzbD(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      Log.w("InstanceID", String.valueOf(paramContext).length() + 38 + "Never happens: can't find own package " + paramContext);
    }
    return 0;
  }
  
  static String zzbE(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      Log.w("InstanceID", String.valueOf(paramContext).length() + 38 + "Never happens: can't find own package " + paramContext);
    }
    return null;
  }
  
  public void deleteInstanceID()
    throws IOException
  {
    deleteToken("*", "*", null);
    zzJP();
  }
  
  public void deleteToken(String paramString1, String paramString2)
    throws IOException
  {
    deleteToken(paramString1, paramString2, null);
  }
  
  public void deleteToken(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    zzbAD.zzh(this.zzbAG, paramString1, paramString2);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("sender", paramString1);
    if (paramString2 != null) {
      localBundle.putString("scope", paramString2);
    }
    localBundle.putString("subscription", paramString1);
    localBundle.putString("delete", "1");
    localBundle.putString("X-delete", "1");
    if ("".equals(this.zzbAG))
    {
      paramString2 = paramString1;
      localBundle.putString("subtype", paramString2);
      if (!"".equals(this.zzbAG)) {
        break label166;
      }
    }
    for (;;)
    {
      localBundle.putString("X-subtype", paramString1);
      paramString1 = zzbAE.zza(localBundle, zzJO());
      zzbAE.zzC(paramString1);
      return;
      paramString2 = this.zzbAG;
      break;
      label166:
      paramString1 = this.zzbAG;
    }
  }
  
  public long getCreationTime()
  {
    if (this.zzbAH == 0L)
    {
      String str = zzbAD.get(this.zzbAG, "cre");
      if (str != null) {
        this.zzbAH = Long.parseLong(str);
      }
    }
    return this.zzbAH;
  }
  
  public String getId()
  {
    return zza(zzJO());
  }
  
  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    return getToken(paramString1, paramString2, null);
  }
  
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    int j = 0;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    int i = 1;
    if (zzJS()) {}
    for (Object localObject = null; localObject != null; localObject = zzbAD.zzg(this.zzbAG, paramString1, paramString2)) {
      return (String)localObject;
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    if (((Bundle)localObject).getString("ttl") != null) {
      i = 0;
    }
    if ("jwt".equals(((Bundle)localObject).getString("type"))) {
      i = j;
    }
    for (;;)
    {
      paramBundle = zzb(paramString1, paramString2, (Bundle)localObject);
      localObject = paramBundle;
      if (paramBundle == null) {
        break;
      }
      localObject = paramBundle;
      if (i == 0) {
        break;
      }
      zzbAD.zza(this.zzbAG, paramString1, paramString2, paramBundle, zzbAI);
      return paramBundle;
    }
  }
  
  KeyPair zzJO()
  {
    if (this.zzbAF == null) {
      this.zzbAF = zzbAD.zzeI(this.zzbAG);
    }
    if (this.zzbAF == null)
    {
      this.zzbAH = System.currentTimeMillis();
      this.zzbAF = zzbAD.zze(this.zzbAG, this.zzbAH);
    }
    return this.zzbAF;
  }
  
  public void zzJP()
  {
    this.zzbAH = 0L;
    zzbAD.zzeJ(this.zzbAG);
    this.zzbAF = null;
  }
  
  public zzc zzJQ()
  {
    return zzbAD;
  }
  
  public Rpc zzJR()
  {
    return zzbAE;
  }
  
  boolean zzJS()
  {
    String str = zzbAD.get("appVersion");
    if ((str == null) || (!str.equals(zzbAI))) {}
    long l;
    do
    {
      do
      {
        return true;
        str = zzbAD.get("lastToken");
      } while (str == null);
      l = Long.parseLong(str);
    } while (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 604800L);
    return false;
  }
  
  public String zzb(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (paramString2 != null) {
      paramBundle.putString("scope", paramString2);
    }
    paramBundle.putString("sender", paramString1);
    if ("".equals(this.zzbAG)) {}
    for (paramString2 = paramString1;; paramString2 = this.zzbAG)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      paramString1 = zzbAE.zza(paramBundle, zzJO());
      return zzbAE.zzC(paramString1);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/iid/InstanceID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */