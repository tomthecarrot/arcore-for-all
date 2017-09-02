package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public class zzx
{
  @TargetApi(21)
  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (zzt.zzAZ()) {
      return paramContext.getNoBackupFilesDir();
    }
    return zze(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
  
  /* Error */
  private static File zze(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 47	java/io/File:exists	()Z
    //   9: ifne +23 -> 32
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 50	java/io/File:mkdirs	()Z
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 47	java/io/File:exists	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: astore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 54	java/io/File:getPath	()Ljava/lang/String;
    //   41: invokestatic 60	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 64	java/lang/String:length	()I
    //   49: ifeq +22 -> 71
    //   52: ldc 66
    //   54: aload_0
    //   55: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_0
    //   59: ldc 72
    //   61: aload_0
    //   62: invokestatic 78	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: aconst_null
    //   67: astore_2
    //   68: goto -36 -> 32
    //   71: new 56	java/lang/String
    //   74: dup
    //   75: ldc 66
    //   77: invokespecial 81	java/lang/String:<init>	(Ljava/lang/String;)V
    //   80: astore_0
    //   81: goto -22 -> 59
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	File
    //   25	2	1	bool	boolean
    //   4	64	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	12	84	finally
    //   14	26	84	finally
    //   37	59	84	finally
    //   59	66	84	finally
    //   71	81	84	finally
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */