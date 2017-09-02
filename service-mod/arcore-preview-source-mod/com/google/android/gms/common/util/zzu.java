package com.google.android.gms.common.util;

import android.os.Process;

public class zzu
{
  private static String zzaVb = null;
  private static final int zzaVc = Process.myPid();
  
  public static String zzBc()
  {
    if (zzaVb == null) {
      zzaVb = zzgx(zzaVc);
    }
    return zzaVb;
  }
  
  /* Error */
  static String zzgx(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifgt +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 35	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   9: astore_2
    //   10: new 37	java/io/BufferedReader
    //   13: dup
    //   14: new 39	java/io/FileReader
    //   17: dup
    //   18: new 41	java/lang/StringBuilder
    //   21: dup
    //   22: bipush 25
    //   24: invokespecial 45	java/lang/StringBuilder:<init>	(I)V
    //   27: ldc 47
    //   29: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_0
    //   33: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc 56
    //   38: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 62	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_2
    //   52: invokestatic 69	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   55: aload_1
    //   56: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: invokevirtual 77	java/lang/String:trim	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_1
    //   64: invokestatic 83	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: aload_2
    //   71: invokestatic 69	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 83	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_1
    //   89: astore_2
    //   90: aload_3
    //   91: invokestatic 83	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload_1
    //   98: astore_3
    //   99: goto -9 -> 90
    //   102: astore_2
    //   103: goto -24 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramInt	int
    //   50	14	1	localBufferedReader	java.io.BufferedReader
    //   69	6	1	localObject1	Object
    //   76	1	1	localIOException1	java.io.IOException
    //   78	2	1	localCloseable	java.io.Closeable
    //   85	13	1	localObject2	Object
    //   9	86	2	localObject3	Object
    //   96	1	2	localObject4	Object
    //   102	1	2	localIOException2	java.io.IOException
    //   87	12	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	51	69	finally
    //   6	10	76	java/io/IOException
    //   70	76	76	java/io/IOException
    //   6	10	85	finally
    //   70	76	85	finally
    //   51	63	96	finally
    //   51	63	102	java/io/IOException
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */