package com.google.tango.cloudlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.common.geometry.S2CellId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  private static final String KEY_API_KEY = "com.google.tango.API_KEY";
  private static final String TAG = "TangoCloudLib.Utils";
  
  public static long asId(String paramString)
  {
    return S2CellId.fromToken(paramString).id();
  }
  
  public static String asToken(Long paramLong)
  {
    return new S2CellId(paramLong.longValue()).toToken();
  }
  
  public static List<String> asTokens(Iterable<Long> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(asToken((Long)paramIterable.next()));
    }
    return localArrayList;
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramBoolean) {}
    for (Object localObject = "0x";; localObject = "")
    {
      localObject = new StringBuilder((String)localObject);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        ((StringBuilder)localObject).append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
        i += 1;
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getApiKey(Context paramContext)
  {
    return getApiKey(paramContext, paramContext.getPackageName());
  }
  
  public static String getApiKey(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 128).metaData.getString("com.google.tango.API_KEY");
      if (paramContext != null)
      {
        boolean bool = paramContext.equals("");
        if (!bool) {
          return paramContext;
        }
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("TangoCloudLib.Utils", paramContext);
      throw new RuntimeException("Failed to extract API key.");
    }
  }
  
  public static String getCertFingerprint(Context paramContext)
  {
    return getCertFingerprint(paramContext, paramContext.getPackageName());
  }
  
  /* Error */
  public static String getCertFingerprint(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc -98
    //   2: invokestatic 164	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: aload_0
    //   7: invokevirtual 119	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: aload_1
    //   11: bipush 64
    //   13: invokevirtual 168	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: astore_0
    //   17: aload_0
    //   18: getfield 174	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   21: ifnull +68 -> 89
    //   24: aload_0
    //   25: getfield 174	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   28: arraylength
    //   29: ifle +60 -> 89
    //   32: aload_3
    //   33: aload_0
    //   34: getfield 174	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   37: iconst_0
    //   38: aaload
    //   39: invokevirtual 180	android/content/pm/Signature:toByteArray	()[B
    //   42: invokevirtual 184	java/security/MessageDigest:digest	([B)[B
    //   45: iconst_0
    //   46: invokestatic 186	com/google/tango/cloudlib/Utils:bytesToHex	([BZ)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +28 -> 79
    //   54: aload_0
    //   55: ldc 100
    //   57: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +17 -> 79
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: new 148	java/lang/RuntimeException
    //   71: dup
    //   72: ldc -68
    //   74: aload_0
    //   75: invokespecial 191	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: ldc 11
    //   84: aload_0
    //   85: invokestatic 146	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   88: pop
    //   89: new 148	java/lang/RuntimeException
    //   92: dup
    //   93: ldc -63
    //   95: invokespecial 151	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   0	99	1	paramString	String
    //   60	2	2	bool	boolean
    //   5	28	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   0	6	67	java/security/NoSuchAlgorithmException
    //   6	50	81	android/content/pm/PackageManager$NameNotFoundException
    //   54	61	81	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    return Arrays.asList(paramVarArgs);
  }
  
  static void verboseDebugLog(String paramString1, String paramString2) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */