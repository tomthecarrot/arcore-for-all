package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzn
{
  private static final Lock zzane = new ReentrantLock();
  private static zzn zzanf;
  private final Lock zzang = new ReentrantLock();
  private final SharedPreferences zzanh;
  
  zzn(Context paramContext)
  {
    this.zzanh = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  private String zzF(String paramString1, String paramString2)
  {
    String str = String.valueOf(":");
    return String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2;
  }
  
  public static zzn zzaw(Context paramContext)
  {
    zzac.zzC(paramContext);
    zzane.lock();
    try
    {
      if (zzanf == null) {
        zzanf = new zzn(paramContext.getApplicationContext());
      }
      paramContext = zzanf;
      return paramContext;
    }
    finally
    {
      zzane.unlock();
    }
  }
  
  protected void zzE(String paramString1, String paramString2)
  {
    this.zzang.lock();
    try
    {
      this.zzanh.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zzang.unlock();
    }
  }
  
  void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzC(paramGoogleSignInAccount);
    zzac.zzC(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzqD();
    zzE(zzF("googleSignInAccount", str), paramGoogleSignInAccount.zzqF());
    zzE(zzF("googleSignInOptions", str), paramGoogleSignInOptions.zzqE());
  }
  
  public void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzC(paramGoogleSignInAccount);
    zzac.zzC(paramGoogleSignInOptions);
    zzE("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzqD());
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  GoogleSignInAccount zzcb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcd(zzF("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.zzbX(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  GoogleSignInOptions zzcc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcd(zzF("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.zzbZ(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  protected String zzcd(String paramString)
  {
    this.zzang.lock();
    try
    {
      paramString = this.zzanh.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzang.unlock();
    }
  }
  
  void zzce(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    zzcf(zzF("googleSignInAccount", paramString));
    zzcf(zzF("googleSignInOptions", paramString));
  }
  
  protected void zzcf(String paramString)
  {
    this.zzang.lock();
    try
    {
      this.zzanh.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zzang.unlock();
    }
  }
  
  public GoogleSignInAccount zzqZ()
  {
    return zzcb(zzcd("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions zzra()
  {
    return zzcc(zzcd("defaultGoogleSignInAccount"));
  }
  
  public void zzrb()
  {
    String str = zzcd("defaultGoogleSignInAccount");
    zzcf("defaultGoogleSignInAccount");
    zzce(str);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/auth/api/signin/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */