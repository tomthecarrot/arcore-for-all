package com.google.android.gms.tagmanager.resources.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzbpf;
import com.google.android.gms.tagmanager.Log;

public class zzf
  implements Runnable
{
  private final Context mContext;
  private final zzbpf zzcBV;
  private final zze zzcCc;
  private final zza zzcCd;
  private final zzd zzcvH;
  
  public zzf(Context paramContext, zzbpf paramzzbpf, zze paramzze)
  {
    this(paramContext, paramzzbpf, paramzze, new zzd(), new zza());
  }
  
  zzf(Context paramContext, zzbpf paramzzbpf, zze paramzze, zzd paramzzd, zza paramzza)
  {
    zzac.zzC(paramContext);
    zzac.zzC(paramzze);
    this.mContext = paramContext;
    this.zzcBV = paramzzbpf;
    this.zzcCc = paramzze;
    this.zzcvH = paramzzd;
    this.zzcCd = paramzza;
  }
  
  public zzf(Context paramContext, zzbpf paramzzbpf, zze paramzze, String paramString)
  {
    this(paramContext, paramzzbpf, paramzze, new zzd(), new zza());
    this.zzcCd.setCtfeServerAddress(paramString);
  }
  
  public void run()
  {
    zzih();
  }
  
  boolean zzZK()
  {
    if (!zzby("android.permission.INTERNET"))
    {
      Log.e("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
      return false;
    }
    if (!zzby("android.permission.ACCESS_NETWORK_STATE"))
    {
      Log.e("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
      return false;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      Log.w("NetworkLoader: No network connectivity - Offline");
      return false;
    }
    return true;
  }
  
  boolean zzby(String paramString)
  {
    return this.mContext.getPackageManager().checkPermission(paramString, this.mContext.getPackageName()) == 0;
  }
  
  /* Error */
  void zzih()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 121	com/google/android/gms/tagmanager/resources/network/zzf:zzZK	()Z
    //   4: ifne +14 -> 18
    //   7: aload_0
    //   8: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   11: getstatic 127	com/google/android/gms/tagmanager/resources/network/zze$zza:zzcBX	Lcom/google/android/gms/tagmanager/resources/network/zze$zza;
    //   14: invokevirtual 133	com/google/android/gms/tagmanager/resources/network/zze:zza	(Lcom/google/android/gms/tagmanager/resources/network/zze$zza;)V
    //   17: return
    //   18: ldc -121
    //   20: invokestatic 138	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 45	com/google/android/gms/tagmanager/resources/network/zzf:zzcvH	Lcom/google/android/gms/tagmanager/resources/network/zzd;
    //   27: invokevirtual 142	com/google/android/gms/tagmanager/resources/network/zzd:zzaaB	()Lcom/google/android/gms/tagmanager/resources/network/zzc;
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_0
    //   34: getfield 47	com/google/android/gms/tagmanager/resources/network/zzf:zzcCd	Lcom/google/android/gms/tagmanager/resources/network/zza;
    //   37: aload_0
    //   38: getfield 41	com/google/android/gms/tagmanager/resources/network/zzf:zzcBV	Lcom/google/android/gms/internal/zzbpf;
    //   41: invokevirtual 148	com/google/android/gms/internal/zzbpf:zzaan	()Ljava/util/List;
    //   44: invokevirtual 152	com/google/android/gms/tagmanager/resources/network/zza:zzak	(Ljava/util/List;)Ljava/lang/String;
    //   47: astore 4
    //   49: aload_3
    //   50: aload 4
    //   52: invokeinterface 158 2 0
    //   57: astore_1
    //   58: new 160	java/io/ByteArrayOutputStream
    //   61: dup
    //   62: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   65: astore_2
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 167	com/google/android/gms/common/util/IOUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   71: pop2
    //   72: aload_0
    //   73: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   76: aload_2
    //   77: invokevirtual 171	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: invokevirtual 175	com/google/android/gms/tagmanager/resources/network/zze:zzY	([B)V
    //   83: aload_3
    //   84: invokeinterface 178 1 0
    //   89: ldc -76
    //   91: invokestatic 138	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   94: return
    //   95: astore_1
    //   96: aload 4
    //   98: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 190	java/lang/String:length	()I
    //   106: ifeq +31 -> 137
    //   109: ldc -64
    //   111: aload_1
    //   112: invokevirtual 196	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: invokestatic 71	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   124: getstatic 199	com/google/android/gms/tagmanager/resources/network/zze$zza:zzcBZ	Lcom/google/android/gms/tagmanager/resources/network/zze$zza;
    //   127: invokevirtual 133	com/google/android/gms/tagmanager/resources/network/zze:zza	(Lcom/google/android/gms/tagmanager/resources/network/zze$zza;)V
    //   130: aload_3
    //   131: invokeinterface 178 1 0
    //   136: return
    //   137: new 182	java/lang/String
    //   140: dup
    //   141: ldc -64
    //   143: invokespecial 201	java/lang/String:<init>	(Ljava/lang/String;)V
    //   146: astore_1
    //   147: goto -31 -> 116
    //   150: astore_1
    //   151: aload_3
    //   152: invokeinterface 178 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload 4
    //   162: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 190	java/lang/String:length	()I
    //   170: ifeq +29 -> 199
    //   173: ldc -53
    //   175: aload_1
    //   176: invokevirtual 196	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore_1
    //   180: aload_1
    //   181: invokestatic 71	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   188: getstatic 206	com/google/android/gms/tagmanager/resources/network/zze$zza:zzcCa	Lcom/google/android/gms/tagmanager/resources/network/zze$zza;
    //   191: invokevirtual 133	com/google/android/gms/tagmanager/resources/network/zze:zza	(Lcom/google/android/gms/tagmanager/resources/network/zze$zza;)V
    //   194: aload_2
    //   195: astore_1
    //   196: goto -138 -> 58
    //   199: new 182	java/lang/String
    //   202: dup
    //   203: ldc -53
    //   205: invokespecial 201	java/lang/String:<init>	(Ljava/lang/String;)V
    //   208: astore_1
    //   209: goto -29 -> 180
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 209	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   220: astore_2
    //   221: new 211	java/lang/StringBuilder
    //   224: dup
    //   225: aload 4
    //   227: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokevirtual 190	java/lang/String:length	()I
    //   233: bipush 54
    //   235: iadd
    //   236: aload_2
    //   237: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 190	java/lang/String:length	()I
    //   243: iadd
    //   244: invokespecial 214	java/lang/StringBuilder:<init>	(I)V
    //   247: ldc -40
    //   249: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 4
    //   254: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc -34
    //   259: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: aload_1
    //   270: invokestatic 228	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_0
    //   274: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   277: getstatic 231	com/google/android/gms/tagmanager/resources/network/zze$zza:zzcBY	Lcom/google/android/gms/tagmanager/resources/network/zze$zza;
    //   280: invokevirtual 133	com/google/android/gms/tagmanager/resources/network/zze:zza	(Lcom/google/android/gms/tagmanager/resources/network/zze$zza;)V
    //   283: aload_3
    //   284: invokeinterface 178 1 0
    //   289: return
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 209	java/io/IOException:getMessage	()Ljava/lang/String;
    //   295: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   298: astore_2
    //   299: new 211	java/lang/StringBuilder
    //   302: dup
    //   303: aload 4
    //   305: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 190	java/lang/String:length	()I
    //   311: bipush 66
    //   313: iadd
    //   314: aload_2
    //   315: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   318: invokevirtual 190	java/lang/String:length	()I
    //   321: iadd
    //   322: invokespecial 214	java/lang/StringBuilder:<init>	(I)V
    //   325: ldc -23
    //   327: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 4
    //   332: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc -34
    //   337: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_2
    //   341: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: aload_1
    //   348: invokestatic 228	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload_0
    //   352: getfield 43	com/google/android/gms/tagmanager/resources/network/zzf:zzcCc	Lcom/google/android/gms/tagmanager/resources/network/zze;
    //   355: getstatic 199	com/google/android/gms/tagmanager/resources/network/zze$zza:zzcBZ	Lcom/google/android/gms/tagmanager/resources/network/zze$zza;
    //   358: invokevirtual 133	com/google/android/gms/tagmanager/resources/network/zze:zza	(Lcom/google/android/gms/tagmanager/resources/network/zze$zza;)V
    //   361: aload_3
    //   362: invokeinterface 178 1 0
    //   367: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	zzf
    //   57	10	1	localInputStream	java.io.InputStream
    //   95	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   101	46	1	str1	String
    //   150	8	1	localObject1	Object
    //   159	1	1	localServerUnavailableException	ServerUnavailableException
    //   165	44	1	localObject2	Object
    //   212	58	1	localIOException1	java.io.IOException
    //   290	58	1	localIOException2	java.io.IOException
    //   32	309	2	localObject3	Object
    //   30	332	3	localzzc	zzc
    //   47	284	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   49	58	95	java/io/FileNotFoundException
    //   33	49	150	finally
    //   49	58	150	finally
    //   58	83	150	finally
    //   96	116	150	finally
    //   116	130	150	finally
    //   137	147	150	finally
    //   160	180	150	finally
    //   180	194	150	finally
    //   199	209	150	finally
    //   213	283	150	finally
    //   291	361	150	finally
    //   49	58	159	com/google/android/gms/tagmanager/resources/network/ServerUnavailableException
    //   49	58	212	java/io/IOException
    //   58	83	290	java/io/IOException
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/resources/network/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */