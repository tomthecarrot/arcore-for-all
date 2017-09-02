package com.google.location.visualmapping.client.grpc;

import android.content.Context;

public class Utils
{
  public static String bytesToHex(byte[] paramArrayOfByte, boolean paramBoolean)
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
  
  public static String getCertFingerprint(Context paramContext)
  {
    return getCertFingerprint(paramContext, paramContext.getPackageName());
  }
  
  /* Error */
  public static String getCertFingerprint(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 64	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: aload_0
    //   7: invokevirtual 68	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: aload_1
    //   11: bipush 64
    //   13: invokevirtual 74	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: astore_0
    //   17: aload_0
    //   18: getfield 80	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   21: ifnull +51 -> 72
    //   24: aload_0
    //   25: getfield 80	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   28: arraylength
    //   29: ifle +43 -> 72
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 80	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   37: iconst_0
    //   38: aaload
    //   39: invokevirtual 86	android/content/pm/Signature:toByteArray	()[B
    //   42: invokevirtual 90	java/security/MessageDigest:digest	([B)[B
    //   45: iconst_0
    //   46: invokestatic 92	com/google/location/visualmapping/client/grpc/Utils:bytesToHex	([BZ)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: new 94	java/lang/RuntimeException
    //   56: dup
    //   57: ldc 96
    //   59: aload_0
    //   60: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: ldc 101
    //   67: aload_0
    //   68: invokestatic 107	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   71: pop
    //   72: new 94	java/lang/RuntimeException
    //   75: dup
    //   76: ldc 109
    //   78: invokespecial 110	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   5	28	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   0	6	52	java/security/NoSuchAlgorithmException
    //   6	50	64	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/grpc/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */