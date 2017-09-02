package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.tagmanager.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzbpj
{
  public static final Integer zzcBP = Integer.valueOf(0);
  public static final Integer zzcBQ = Integer.valueOf(1);
  private final Context mContext;
  private final ExecutorService zzbOE;
  
  public zzbpj(Context paramContext)
  {
    this(paramContext, Executors.newSingleThreadExecutor());
  }
  
  zzbpj(Context paramContext, ExecutorService paramExecutorService)
  {
    this.mContext = paramContext;
    this.zzbOE = paramExecutorService;
  }
  
  private byte[] zzk(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      try
      {
        IOUtils.copyStream(paramInputStream, localByteArrayOutputStream);
      }
      catch (IOException localIOException)
      {
        Log.w("Failed to read the resource from disk");
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          Log.w("Error closing stream for reading resource from disk");
          return null;
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject);
        }
        catch (IOException paramInputStream)
        {
          Log.w("Error closing stream for reading resource from disk");
        }
      }
      try
      {
        paramInputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (IOException paramInputStream)
      {
        Log.w("Error closing stream for reading resource from disk");
        return null;
      }
    }
    return null;
  }
  
  private String zzkA(String paramString)
  {
    String str = String.valueOf("resource_");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  public void zza(final String paramString, final Integer paramInteger, final zzbpd paramzzbpd, final zzbpi paramzzbpi)
  {
    this.zzbOE.execute(new Runnable()
    {
      public void run()
      {
        zzbpj.this.zzb(paramString, paramInteger, paramzzbpd, paramzzbpi);
      }
    });
  }
  
  void zzb(String paramString, Integer paramInteger, zzbpd paramzzbpd, zzbpi paramzzbpi)
  {
    Log.v("DiskLoader: Starting to load resource from Disk.");
    try
    {
      Object localObject = paramzzbpd.zzac(zzk(new FileInputStream(zzkz(paramString))));
      if (localObject != null)
      {
        String str = String.valueOf(zzkA(paramString));
        if (str.length() != 0) {}
        for (str = "Saved resource loaded: ".concat(str);; str = new String("Saved resource loaded: "))
        {
          Log.v(str);
          paramzzbpi.zza(Status.zzaLc, localObject, zzcBQ, zzky(paramString));
          return;
        }
      }
      try
      {
        paramString = this.mContext.getResources().openRawResource(paramInteger.intValue());
        if (paramString == null) {
          break label331;
        }
        paramzzbpd = paramzzbpd.zzac(zzk(paramString));
        if (paramzzbpd == null) {
          break label331;
        }
        paramString = String.valueOf(this.mContext.getResources().getResourceEntryName(paramInteger.intValue()));
        if (paramString.length() == 0) {
          break label345;
        }
        paramString = "Default resource loaded: ".concat(paramString);
      }
      catch (Resources.NotFoundException paramString)
      {
        for (;;)
        {
          paramString = String.valueOf(paramInteger);
          Log.e(String.valueOf(paramString).length() + 32 + "Default resource not found. ID: " + paramString);
          paramzzbpi.zza(Status.zzaLe, null, null, 0L);
          return;
          paramString = new String("Default resource loaded: ");
        }
      }
      catch (zzbph.zzg paramString)
      {
        for (;;)
        {
          paramString = String.valueOf(paramInteger);
          Log.e(String.valueOf(paramString).length() + 40 + "Default resource resource is corrupted: " + paramString);
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramString = String.valueOf(zzkA(paramString));
      if (paramString.length() != 0) {}
      for (paramString = "Saved resource not found: ".concat(paramString);; paramString = new String("Saved resource not found: "))
      {
        Log.e(paramString);
        if (paramInteger != null) {
          break;
        }
        paramzzbpi.zza(Status.zzaLe, null, null, 0L);
        return;
      }
    }
    catch (zzbph.zzg localzzg)
    {
      paramString = String.valueOf(zzkA(paramString));
      if (paramString.length() != 0) {}
      for (paramString = "Saved resource is corrupted: ".concat(paramString);; paramString = new String("Saved resource is corrupted: "))
      {
        Log.e(paramString);
        break;
      }
    }
    Log.v(paramString);
    paramzzbpi.zza(Status.zzaLc, paramzzbpd, zzcBP, 0L);
  }
  
  public void zzh(final String paramString, final byte[] paramArrayOfByte)
  {
    this.zzbOE.execute(new Runnable()
    {
      public void run()
      {
        zzbpj.this.zzi(paramString, paramArrayOfByte);
      }
    });
  }
  
  /* Error */
  void zzi(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 124	com/google/android/gms/internal/zzbpj:zzkz	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 4
    //   7: new 210	java/io/FileOutputStream
    //   10: dup
    //   11: aload 4
    //   13: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_2
    //   19: invokevirtual 215	java/io/FileOutputStream:write	([B)V
    //   22: aload_3
    //   23: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   26: new 187	java/lang/StringBuilder
    //   29: dup
    //   30: aload_1
    //   31: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 90	java/lang/String:length	()I
    //   37: bipush 24
    //   39: iadd
    //   40: invokespecial 190	java/lang/StringBuilder:<init>	(I)V
    //   43: ldc -38
    //   45: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -36
    //   54: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 118	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   63: return
    //   64: astore_1
    //   65: ldc -34
    //   67: invokestatic 159	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   70: return
    //   71: astore_1
    //   72: ldc -32
    //   74: invokestatic 159	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   77: return
    //   78: astore_2
    //   79: ldc -30
    //   81: invokestatic 159	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: invokevirtual 232	java/io/File:delete	()Z
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   94: new 187	java/lang/StringBuilder
    //   97: dup
    //   98: aload_1
    //   99: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokevirtual 90	java/lang/String:length	()I
    //   105: bipush 24
    //   107: iadd
    //   108: invokespecial 190	java/lang/StringBuilder:<init>	(I)V
    //   111: ldc -38
    //   113: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc -36
    //   122: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 118	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   131: return
    //   132: astore_1
    //   133: ldc -32
    //   135: invokestatic 159	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   138: return
    //   139: astore_2
    //   140: aload_3
    //   141: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   144: new 187	java/lang/StringBuilder
    //   147: dup
    //   148: aload_1
    //   149: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokevirtual 90	java/lang/String:length	()I
    //   155: bipush 24
    //   157: iadd
    //   158: invokespecial 190	java/lang/StringBuilder:<init>	(I)V
    //   161: ldc -38
    //   163: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc -36
    //   172: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 118	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: ldc -32
    //   186: invokestatic 159	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   189: goto -8 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	zzbpj
    //   0	192	1	paramString	String
    //   0	192	2	paramArrayOfByte	byte[]
    //   16	125	3	localFileOutputStream	java.io.FileOutputStream
    //   5	80	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   7	17	64	java/io/FileNotFoundException
    //   22	63	71	java/io/IOException
    //   17	22	78	java/io/IOException
    //   90	131	132	java/io/IOException
    //   17	22	139	finally
    //   79	90	139	finally
    //   140	181	183	java/io/IOException
  }
  
  public long zzky(String paramString)
  {
    paramString = zzkz(paramString);
    if (paramString.exists()) {
      return paramString.lastModified();
    }
    return 0L;
  }
  
  File zzkz(String paramString)
  {
    return new File(this.mContext.getDir("google_tagmanager", 0), zzkA(paramString));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */