package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabz;
import com.google.android.gms.internal.zzaca;

public class GoogleSignatureVerifier
{
  private static GoogleSignatureVerifier zzaKi;
  private final Context mContext;
  private final zzabz zzaKj;
  
  private GoogleSignatureVerifier(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzaKj = zzaca.zzbp(this.mContext);
  }
  
  public static GoogleSignatureVerifier getInstance(Context paramContext)
  {
    zzac.zzC(paramContext);
    try
    {
      if (zzaKi == null)
      {
        zze.init(paramContext);
        zzaKi = new GoogleSignatureVerifier(paramContext);
      }
      return zzaKi;
    }
    finally {}
  }
  
  public static void resetForTests()
  {
    try
    {
      zzaKi = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isPackageGoogleSigned(PackageInfo paramPackageInfo)
  {
    boolean bool1 = false;
    if (paramPackageInfo == null) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
          return zzb(paramPackageInfo, true);
        }
        bool2 = zzb(paramPackageInfo, false);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!zzb(paramPackageInfo, true));
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool2;
  }
  
  @Deprecated
  public boolean isPackageGoogleSigned(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    return isPackageGoogleSigned(paramPackageInfo);
  }
  
  @Deprecated
  public boolean isPackageGoogleSigned(PackageManager paramPackageManager, String paramString)
  {
    return isPackageGoogleSigned(paramString);
  }
  
  public boolean isPackageGoogleSigned(String paramString)
  {
    try
    {
      boolean bool = isPackageGoogleSigned(this.zzaKj.getPackageInfo(paramString, 64));
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public boolean isUidGoogleSigned(int paramInt)
  {
    String[] arrayOfString = this.zzaKj.getPackagesForUid(paramInt);
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {}
    for (;;)
    {
      return false;
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (isPackageGoogleSigned(arrayOfString[paramInt])) {
          return true;
        }
        paramInt += 1;
      }
    }
  }
  
  @Deprecated
  public boolean isUidGoogleSigned(PackageManager paramPackageManager, int paramInt)
  {
    return isUidGoogleSigned(paramInt);
  }
  
  @Deprecated
  public void verifyPackageIsGoogleSigned(PackageManager paramPackageManager, String paramString)
    throws SecurityException
  {
    verifyPackageIsGoogleSigned(paramString);
  }
  
  public void verifyPackageIsGoogleSigned(String paramString)
    throws SecurityException
  {
    if (!isPackageGoogleSigned(paramString))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Signature check failed for ".concat(paramString);; paramString = new String("Signature check failed for ")) {
        throw new SecurityException(paramString);
      }
    }
  }
  
  public void verifyUidIsGoogleSigned(int paramInt)
    throws SecurityException
  {
    if (!isUidGoogleSigned(paramInt)) {
      throw new SecurityException("Uid is not Google Signed");
    }
  }
  
  @Deprecated
  public void verifyUidIsGoogleSigned(PackageManager paramPackageManager, int paramInt)
    throws SecurityException
  {
    verifyUidIsGoogleSigned(paramInt);
  }
  
  zze.zza zza(PackageInfo paramPackageInfo, zze.zza... paramVarArgs)
  {
    int i = 0;
    if (paramPackageInfo.signatures == null) {
      return null;
    }
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = new zze.zzb(paramPackageInfo.signatures[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public boolean zza(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {}
    do
    {
      return false;
      if (zza(paramPackageInfo, false)) {
        return true;
      }
    } while (!zza(paramPackageInfo, true));
    if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
      return true;
    }
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return false;
  }
  
  public boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean) {}
      for (paramPackageInfo = zza(paramPackageInfo, zze.zzd.zzaKb); paramPackageInfo != null; paramPackageInfo = zza(paramPackageInfo, new zze.zza[] { zze.zzd.zzaKb[0] })) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public boolean zza(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    return zza(paramPackageInfo);
  }
  
  boolean zzb(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return bool2;
    }
    zze.zzb localzzb = new zze.zzb(paramPackageInfo.signatures[0].toByteArray());
    paramPackageInfo = paramPackageInfo.packageName;
    if (paramBoolean) {}
    for (boolean bool1 = zze.zzb(paramPackageInfo, localzzb);; bool1 = zze.zza(paramPackageInfo, localzzb))
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      Log.d("GoogleSignatureVerifier", 27 + "Cert not in list. atk=" + paramBoolean);
      return bool1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/GoogleSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */