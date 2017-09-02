package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzc
{
  SharedPreferences zzbBf;
  Context zzqm;
  
  public zzc(Context paramContext)
  {
    this(paramContext, "com.google.android.gms.appid");
  }
  
  public zzc(Context paramContext, String paramString)
  {
    this.zzqm = paramContext;
    this.zzbBf = paramContext.getSharedPreferences(paramString, 0);
    paramContext = String.valueOf(paramString);
    paramString = String.valueOf("-no-backup");
    if (paramString.length() != 0) {}
    for (paramContext = paramContext.concat(paramString);; paramContext = new String(paramContext))
    {
      zzeG(paramContext);
      return;
    }
  }
  
  private void zzeG(String paramString)
  {
    paramString = new File(zzx.getNoBackupFilesDir(this.zzqm), paramString);
    if (paramString.exists()) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((paramString.createNewFile()) && (!isEmpty()))
          {
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.zza(this.zzqm, this);
            return;
          }
        }
        catch (IOException paramString) {}
      }
    } while (!Log.isLoggable("InstanceID/Store", 3));
    paramString = String.valueOf(paramString.getMessage());
    if (paramString.length() != 0) {}
    for (paramString = "Error creating file in no backup dir: ".concat(paramString);; paramString = new String("Error creating file in no backup dir: "))
    {
      Log.d("InstanceID/Store", paramString);
      return;
    }
  }
  
  private String zzf(String paramString1, String paramString2, String paramString3)
  {
    String str = String.valueOf("|T|");
    return String.valueOf(paramString1).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + str + paramString2 + "|" + paramString3;
  }
  
  String get(String paramString)
  {
    try
    {
      paramString = this.zzbBf.getString(paramString, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String get(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.zzbBf;
      String str = String.valueOf("|S|");
      paramString1 = localSharedPreferences.getString(String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean isEmpty()
  {
    return this.zzbBf.getAll().isEmpty();
  }
  
  public void zzJU()
  {
    try
    {
      this.zzbBf.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void zza(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = String.valueOf("|S|");
      paramEditor.putString(String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2, paramString3);
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  public void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = this.zzbBf.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  KeyPair zze(String paramString, long paramLong)
  {
    try
    {
      KeyPair localKeyPair = zza.zzJN();
      SharedPreferences.Editor localEditor = this.zzbBf.edit();
      zza(localEditor, paramString, "|P|", InstanceID.zzB(localKeyPair.getPublic().getEncoded()));
      zza(localEditor, paramString, "|K|", InstanceID.zzB(localKeyPair.getPrivate().getEncoded()));
      zza(localEditor, paramString, "cre", Long.toString(paramLong));
      localEditor.commit();
      return localKeyPair;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zzeH(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.zzbBf.edit();
      Iterator localIterator = this.zzbBf.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
  }
  
  public KeyPair zzeI(String paramString)
  {
    return zzeL(paramString);
  }
  
  void zzeJ(String paramString)
  {
    zzeH(String.valueOf(paramString).concat("|"));
  }
  
  public void zzeK(String paramString)
  {
    zzeH(String.valueOf(paramString).concat("|T|"));
  }
  
  KeyPair zzeL(String paramString)
  {
    Object localObject1 = get(paramString, "|P|");
    Object localObject2 = get(paramString, "|K|");
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    try
    {
      paramString = Base64.decode((String)localObject1, 8);
      localObject1 = Base64.decode((String)localObject2, 8);
      localObject2 = KeyFactory.getInstance("RSA");
      paramString = new KeyPair(((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec(paramString)), ((KeyFactory)localObject2).generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1)));
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      paramString = String.valueOf(paramString);
      Log.w("InstanceID/Store", String.valueOf(paramString).length() + 19 + "Invalid key stored " + paramString);
      InstanceIDListenerService.zza(this.zzqm, this);
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  public String zzg(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString1 = this.zzbBf.getString(paramString1, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzh(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = this.zzbBf.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/iid/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */