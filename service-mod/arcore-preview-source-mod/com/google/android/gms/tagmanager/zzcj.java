package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzboz.zza;
import com.google.android.gms.internal.zzbph;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzbph.zzg;
import com.google.android.gms.internal.zzcgf;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcj
  implements ContainerHolderLoader.zzf
{
  private final Context mContext;
  private final ExecutorService zzbOE;
  private final String zzcaK;
  private zzbe<zzboz.zza> zzcvJ;
  
  zzcj(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.zzcaK = paramString;
    this.zzbOE = Executors.newSingleThreadExecutor();
  }
  
  private zzbph.zzc zzX(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = zzbph.zzb(zzaj.zzf.zzf(paramArrayOfByte));
      if (paramArrayOfByte != null) {
        Log.v("The container was successfully loaded from the resource (using binary file)");
      }
      return paramArrayOfByte;
    }
    catch (zzcgf paramArrayOfByte)
    {
      Log.e("The resource file is corrupted. The container cannot be extracted from the binary file");
      return null;
    }
    catch (zzbph.zzg paramArrayOfByte)
    {
      Log.w("The resource file is invalid. The container from the binary file is invalid");
    }
    return null;
  }
  
  private zzbph.zzc zza(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      paramByteArrayOutputStream = zzaz.zzjQ(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      Log.d("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
      return null;
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      Log.w("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
    }
    return null;
  }
  
  private void zzd(zzboz.zza paramzza)
    throws IllegalArgumentException
  {
    if ((paramzza.zzlq == null) && (paramzza.zzcBs == null)) {
      throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
    }
  }
  
  public void release()
  {
    try
    {
      this.zzbOE.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzXp()
  {
    this.zzbOE.execute(new Runnable()
    {
      public void run()
      {
        zzcj.this.zzYg();
      }
    });
  }
  
  /* Error */
  void zzYg()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   4: ifnonnull +13 -> 17
    //   7: new 142	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -112
    //   13: invokespecial 145	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc -109
    //   19: invokestatic 63	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   22: invokestatic 153	com/google/android/gms/tagmanager/zzbx:zzXY	()Lcom/google/android/gms/tagmanager/zzbx;
    //   25: invokevirtual 157	com/google/android/gms/tagmanager/zzbx:zzXZ	()Lcom/google/android/gms/tagmanager/zzbx$zza;
    //   28: getstatic 163	com/google/android/gms/tagmanager/zzbx$zza:zzcvy	Lcom/google/android/gms/tagmanager/zzbx$zza;
    //   31: if_acmpeq +15 -> 46
    //   34: invokestatic 153	com/google/android/gms/tagmanager/zzbx:zzXY	()Lcom/google/android/gms/tagmanager/zzbx;
    //   37: invokevirtual 157	com/google/android/gms/tagmanager/zzbx:zzXZ	()Lcom/google/android/gms/tagmanager/zzbx$zza;
    //   40: getstatic 166	com/google/android/gms/tagmanager/zzbx$zza:zzcvz	Lcom/google/android/gms/tagmanager/zzbx$zza;
    //   43: if_acmpne +32 -> 75
    //   46: aload_0
    //   47: getfield 28	com/google/android/gms/tagmanager/zzcj:zzcaK	Ljava/lang/String;
    //   50: invokestatic 153	com/google/android/gms/tagmanager/zzbx:zzXY	()Lcom/google/android/gms/tagmanager/zzbx;
    //   53: invokevirtual 170	com/google/android/gms/tagmanager/zzbx:getContainerId	()Ljava/lang/String;
    //   56: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +16 -> 75
    //   62: aload_0
    //   63: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   66: getstatic 182	com/google/android/gms/tagmanager/zzbe$zza:zzcuY	Lcom/google/android/gms/tagmanager/zzbe$zza;
    //   69: invokeinterface 187 2 0
    //   74: return
    //   75: new 189	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 193	com/google/android/gms/tagmanager/zzcj:zzYh	()Ljava/io/File;
    //   83: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: new 83	java/io/ByteArrayOutputStream
    //   90: dup
    //   91: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   94: astore_2
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic 200	com/google/android/gms/internal/zzbph:zzb	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   100: aload_2
    //   101: invokevirtual 204	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   104: invokestatic 208	com/google/android/gms/internal/zzboz$zza:zzab	([B)Lcom/google/android/gms/internal/zzboz$zza;
    //   107: astore_2
    //   108: aload_0
    //   109: aload_2
    //   110: invokespecial 210	com/google/android/gms/tagmanager/zzcj:zzd	(Lcom/google/android/gms/internal/zzboz$zza;)V
    //   113: aload_0
    //   114: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   117: aload_2
    //   118: invokeinterface 214 2 0
    //   123: aload_1
    //   124: invokevirtual 217	java/io/FileInputStream:close	()V
    //   127: ldc -37
    //   129: invokestatic 63	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   132: return
    //   133: astore_1
    //   134: ldc -35
    //   136: invokestatic 98	com/google/android/gms/tagmanager/Log:d	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   143: getstatic 182	com/google/android/gms/tagmanager/zzbe$zza:zzcuY	Lcom/google/android/gms/tagmanager/zzbe$zza;
    //   146: invokeinterface 187 2 0
    //   151: return
    //   152: astore_1
    //   153: ldc -33
    //   155: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   158: goto -31 -> 127
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   166: getstatic 226	com/google/android/gms/tagmanager/zzbe$zza:zzcuZ	Lcom/google/android/gms/tagmanager/zzbe$zza;
    //   169: invokeinterface 187 2 0
    //   174: ldc -28
    //   176: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   179: aload_1
    //   180: invokevirtual 217	java/io/FileInputStream:close	()V
    //   183: goto -56 -> 127
    //   186: astore_1
    //   187: ldc -33
    //   189: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   192: goto -65 -> 127
    //   195: astore_2
    //   196: aload_0
    //   197: getfield 140	com/google/android/gms/tagmanager/zzcj:zzcvJ	Lcom/google/android/gms/tagmanager/zzbe;
    //   200: getstatic 226	com/google/android/gms/tagmanager/zzbe$zza:zzcuZ	Lcom/google/android/gms/tagmanager/zzbe$zza;
    //   203: invokeinterface 187 2 0
    //   208: ldc -26
    //   210: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 217	java/io/FileInputStream:close	()V
    //   217: goto -90 -> 127
    //   220: astore_1
    //   221: ldc -33
    //   223: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   226: goto -99 -> 127
    //   229: astore_2
    //   230: aload_1
    //   231: invokevirtual 217	java/io/FileInputStream:close	()V
    //   234: aload_2
    //   235: athrow
    //   236: astore_1
    //   237: ldc -33
    //   239: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   242: goto -8 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	zzcj
    //   86	38	1	localFileInputStream	java.io.FileInputStream
    //   133	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   152	28	1	localIOException1	java.io.IOException
    //   186	28	1	localIOException2	java.io.IOException
    //   220	11	1	localIOException3	java.io.IOException
    //   236	1	1	localIOException4	java.io.IOException
    //   94	24	2	localObject1	Object
    //   161	1	2	localIOException5	java.io.IOException
    //   195	1	2	localIllegalArgumentException	IllegalArgumentException
    //   229	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	87	133	java/io/FileNotFoundException
    //   123	127	152	java/io/IOException
    //   87	123	161	java/io/IOException
    //   179	183	186	java/io/IOException
    //   87	123	195	java/lang/IllegalArgumentException
    //   213	217	220	java/io/IOException
    //   87	123	229	finally
    //   162	179	229	finally
    //   196	213	229	finally
    //   230	234	236	java/io/IOException
  }
  
  File zzYh()
  {
    String str1 = String.valueOf("resource_");
    String str2 = String.valueOf(this.zzcaK);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1)) {
      return new File(this.mContext.getDir("google_tagmanager", 0), str1);
    }
  }
  
  public void zza(zzbe<zzboz.zza> paramzzbe)
  {
    this.zzcvJ = paramzzbe;
  }
  
  public void zzb(final zzboz.zza paramzza)
  {
    this.zzbOE.execute(new Runnable()
    {
      public void run()
      {
        zzcj.this.zzc(paramzza);
      }
    });
  }
  
  /* Error */
  boolean zzc(zzboz.zza paramzza)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 193	com/google/android/gms/tagmanager/zzcj:zzYh	()Ljava/io/File;
    //   4: astore_3
    //   5: new 267	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 273	com/google/android/gms/internal/zzcgg:zzf	(Lcom/google/android/gms/internal/zzcgg;)[B
    //   19: invokevirtual 277	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   26: iconst_1
    //   27: ireturn
    //   28: astore_1
    //   29: ldc_w 280
    //   32: invokestatic 68	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: astore_1
    //   38: ldc_w 282
    //   41: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   44: goto -18 -> 26
    //   47: astore_1
    //   48: ldc_w 284
    //   51: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   54: aload_3
    //   55: invokevirtual 288	java/io/File:delete	()Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_1
    //   66: ldc_w 282
    //   69: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: ldc_w 282
    //   85: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   88: goto -9 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	zzcj
    //   0	91	1	paramzza	zzboz.zza
    //   13	63	2	localFileOutputStream	java.io.FileOutputStream
    //   81	1	2	localIOException	java.io.IOException
    //   4	51	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	14	28	java/io/FileNotFoundException
    //   22	26	37	java/io/IOException
    //   14	22	47	java/io/IOException
    //   59	63	65	java/io/IOException
    //   14	22	74	finally
    //   48	59	74	finally
    //   75	79	81	java/io/IOException
  }
  
  /* Error */
  public zzbph.zzc zzwl(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/google/android/gms/tagmanager/zzcj:mContext	Landroid/content/Context;
    //   4: invokevirtual 296	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 302	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 26	com/google/android/gms/tagmanager/zzcj:mContext	Landroid/content/Context;
    //   16: invokevirtual 296	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: iload_1
    //   20: invokevirtual 306	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   23: invokestatic 236	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_3
    //   27: new 308	java/lang/StringBuilder
    //   30: dup
    //   31: aload_3
    //   32: invokestatic 236	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokevirtual 240	java/lang/String:length	()I
    //   38: bipush 66
    //   40: iadd
    //   41: invokespecial 311	java/lang/StringBuilder:<init>	(I)V
    //   44: ldc_w 313
    //   47: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload_1
    //   51: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 322
    //   57: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 324
    //   67: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 63	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   76: new 83	java/io/ByteArrayOutputStream
    //   79: dup
    //   80: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   83: astore_3
    //   84: aload_2
    //   85: aload_3
    //   86: invokestatic 200	com/google/android/gms/internal/zzbph:zzb	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   89: aload_0
    //   90: aload_3
    //   91: invokespecial 328	com/google/android/gms/tagmanager/zzcj:zza	(Ljava/io/ByteArrayOutputStream;)Lcom/google/android/gms/internal/zzbph$zzc;
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +39 -> 135
    //   99: ldc_w 330
    //   102: invokestatic 63	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_2
    //   108: new 308	java/lang/StringBuilder
    //   111: dup
    //   112: bipush 98
    //   114: invokespecial 311	java/lang/StringBuilder:<init>	(I)V
    //   117: ldc_w 332
    //   120: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload_1
    //   124: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload_0
    //   136: aload_3
    //   137: invokevirtual 204	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   140: invokespecial 334	com/google/android/gms/tagmanager/zzcj:zzX	([B)Lcom/google/android/gms/internal/zzbph$zzc;
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 26	com/google/android/gms/tagmanager/zzcj:mContext	Landroid/content/Context;
    //   151: invokevirtual 296	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   154: iload_1
    //   155: invokevirtual 306	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   158: invokestatic 236	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   161: astore_2
    //   162: new 308	java/lang/StringBuilder
    //   165: dup
    //   166: aload_2
    //   167: invokestatic 236	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokevirtual 240	java/lang/String:length	()I
    //   173: bipush 67
    //   175: iadd
    //   176: invokespecial 311	java/lang/StringBuilder:<init>	(I)V
    //   179: ldc_w 336
    //   182: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_1
    //   186: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc_w 322
    //   192: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 324
    //   202: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 73	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   211: aconst_null
    //   212: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	zzcj
    //   0	213	1	paramInt	int
    //   11	95	2	localObject1	Object
    //   107	1	2	localNotFoundException	android.content.res.Resources.NotFoundException
    //   143	2	2	localzzc	zzbph.zzc
    //   146	1	2	localIOException	java.io.IOException
    //   161	35	2	str	String
    //   26	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	107	android/content/res/Resources$NotFoundException
    //   76	95	146	java/io/IOException
    //   99	105	146	java/io/IOException
    //   135	144	146	java/io/IOException
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */