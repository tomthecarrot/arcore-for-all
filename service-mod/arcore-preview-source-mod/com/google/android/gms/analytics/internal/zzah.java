package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

class zzah
  extends zzd
{
  private static final byte[] zzafs = "\n".getBytes();
  private final String zzIp = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzao.zza(Locale.getDefault()), Build.MODEL, Build.ID);
  private final zzal zzafr;
  
  zzah(zzf paramzzf)
  {
    super(paramzzf);
    this.zzafr = new zzal(paramzzf.zznq());
  }
  
  /* Error */
  private int zza(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: invokestatic 88	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_2
    //   18: invokestatic 88	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_0
    //   23: ldc 90
    //   25: aload_2
    //   26: arraylength
    //   27: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aload_1
    //   31: invokevirtual 100	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   34: aload_0
    //   35: invokevirtual 104	com/google/android/gms/analytics/internal/zzah:zzkN	()Z
    //   38: ifeq +17 -> 55
    //   41: aload_0
    //   42: ldc 106
    //   44: new 19	java/lang/String
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 109	java/lang/String:<init>	([B)V
    //   52: invokevirtual 112	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   55: aload_0
    //   56: invokevirtual 116	com/google/android/gms/analytics/internal/zzah:getContext	()Landroid/content/Context;
    //   59: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   62: pop
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 126	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   68: astore_1
    //   69: aload_1
    //   70: astore 5
    //   72: aload 7
    //   74: astore_1
    //   75: aload 5
    //   77: astore 4
    //   79: aload 8
    //   81: astore 6
    //   83: aload 5
    //   85: iconst_1
    //   86: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   89: aload 7
    //   91: astore_1
    //   92: aload 5
    //   94: astore 4
    //   96: aload 8
    //   98: astore 6
    //   100: aload 5
    //   102: aload_2
    //   103: arraylength
    //   104: invokevirtual 136	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   107: aload 7
    //   109: astore_1
    //   110: aload 5
    //   112: astore 4
    //   114: aload 8
    //   116: astore 6
    //   118: aload 5
    //   120: invokevirtual 139	java/net/HttpURLConnection:connect	()V
    //   123: aload 7
    //   125: astore_1
    //   126: aload 5
    //   128: astore 4
    //   130: aload 8
    //   132: astore 6
    //   134: aload 5
    //   136: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   139: astore 7
    //   141: aload 7
    //   143: astore_1
    //   144: aload 5
    //   146: astore 4
    //   148: aload 7
    //   150: astore 6
    //   152: aload 7
    //   154: aload_2
    //   155: invokevirtual 148	java/io/OutputStream:write	([B)V
    //   158: aload 7
    //   160: astore_1
    //   161: aload 5
    //   163: astore 4
    //   165: aload 7
    //   167: astore 6
    //   169: aload_0
    //   170: aload 5
    //   172: invokespecial 151	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/net/HttpURLConnection;)V
    //   175: aload 7
    //   177: astore_1
    //   178: aload 5
    //   180: astore 4
    //   182: aload 7
    //   184: astore 6
    //   186: aload 5
    //   188: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   191: istore_3
    //   192: iload_3
    //   193: sipush 200
    //   196: if_icmpne +21 -> 217
    //   199: aload 7
    //   201: astore_1
    //   202: aload 5
    //   204: astore 4
    //   206: aload 7
    //   208: astore 6
    //   210: aload_0
    //   211: invokevirtual 159	com/google/android/gms/analytics/internal/zzah:zzmF	()Lcom/google/android/gms/analytics/internal/zzb;
    //   214: invokevirtual 164	com/google/android/gms/analytics/internal/zzb:zzno	()V
    //   217: aload 7
    //   219: astore_1
    //   220: aload 5
    //   222: astore 4
    //   224: aload 7
    //   226: astore 6
    //   228: aload_0
    //   229: ldc -90
    //   231: iload_3
    //   232: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokevirtual 168	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   238: aload 7
    //   240: ifnull +8 -> 248
    //   243: aload 7
    //   245: invokevirtual 171	java/io/OutputStream:close	()V
    //   248: aload 5
    //   250: ifnull +8 -> 258
    //   253: aload 5
    //   255: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   258: iload_3
    //   259: ireturn
    //   260: astore_1
    //   261: aload_0
    //   262: ldc -80
    //   264: aload_1
    //   265: invokevirtual 179	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   268: goto -20 -> 248
    //   271: astore_2
    //   272: aconst_null
    //   273: astore 5
    //   275: aload 6
    //   277: astore_1
    //   278: aload 5
    //   280: astore 4
    //   282: aload_0
    //   283: ldc -75
    //   285: aload_2
    //   286: invokevirtual 184	com/google/android/gms/analytics/internal/zzah:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   289: aload 6
    //   291: ifnull +8 -> 299
    //   294: aload 6
    //   296: invokevirtual 171	java/io/OutputStream:close	()V
    //   299: aload 5
    //   301: ifnull +8 -> 309
    //   304: aload 5
    //   306: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   309: iconst_0
    //   310: ireturn
    //   311: astore_1
    //   312: aload_0
    //   313: ldc -80
    //   315: aload_1
    //   316: invokevirtual 179	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   319: goto -20 -> 299
    //   322: astore_2
    //   323: aconst_null
    //   324: astore 4
    //   326: aload 5
    //   328: astore_1
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 171	java/io/OutputStream:close	()V
    //   337: aload 4
    //   339: ifnull +8 -> 347
    //   342: aload 4
    //   344: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   347: aload_2
    //   348: athrow
    //   349: astore_1
    //   350: aload_0
    //   351: ldc -80
    //   353: aload_1
    //   354: invokevirtual 179	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   357: goto -20 -> 337
    //   360: astore_2
    //   361: goto -32 -> 329
    //   364: astore_2
    //   365: goto -90 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	zzah
    //   0	368	1	paramURL	URL
    //   0	368	2	paramArrayOfByte	byte[]
    //   191	68	3	i	int
    //   77	266	4	localURL1	URL
    //   1	326	5	localURL2	URL
    //   10	285	6	localObject1	Object
    //   4	240	7	localOutputStream	java.io.OutputStream
    //   7	124	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   243	248	260	java/io/IOException
    //   55	69	271	java/io/IOException
    //   294	299	311	java/io/IOException
    //   55	69	322	finally
    //   333	337	349	java/io/IOException
    //   83	89	360	finally
    //   100	107	360	finally
    //   118	123	360	finally
    //   134	141	360	finally
    //   152	158	360	finally
    //   169	175	360	finally
    //   186	192	360	finally
    //   210	217	360	finally
    //   228	238	360	finally
    //   282	289	360	finally
    //   83	89	364	java/io/IOException
    //   100	107	364	java/io/IOException
    //   118	123	364	java/io/IOException
    //   134	141	364	java/io/IOException
    //   152	158	364	java/io/IOException
    //   169	175	364	java/io/IOException
    //   186	192	364	java/io/IOException
    //   210	217	364	java/io/IOException
    //   228	238	364	java/io/IOException
  }
  
  private static String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append('&');
    }
    paramStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
    paramStringBuilder.append('=');
    paramStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
  }
  
  private int zzb(URL paramURL)
  {
    zzac.zzC(paramURL);
    zzb("GET request", paramURL);
    Object localObject = null;
    URL localURL = null;
    try
    {
      paramURL = zzc(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      paramURL.connect();
      localURL = paramURL;
      localObject = paramURL;
      zzb(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      int i = paramURL.getResponseCode();
      if (i == 200)
      {
        localURL = paramURL;
        localObject = paramURL;
        zzmF().zzno();
      }
      localURL = paramURL;
      localObject = paramURL;
      zzb("GET status", Integer.valueOf(i));
      if (paramURL != null) {
        paramURL.disconnect();
      }
      return i;
    }
    catch (IOException paramURL)
    {
      localObject = localURL;
      zzd("Network GET connection error", paramURL);
      if (localURL != null) {
        localURL.disconnect();
      }
      return 0;
    }
    finally
    {
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
    }
  }
  
  /* Error */
  private int zzb(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 88	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 88	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 116	com/google/android/gms/analytics/internal/zzah:getContext	()Landroid/content/Context;
    //   20: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: pop
    //   24: aload_2
    //   25: invokestatic 227	com/google/android/gms/analytics/internal/zzah:zzk	([B)[B
    //   28: astore 6
    //   30: aload_0
    //   31: ldc -27
    //   33: aload 6
    //   35: arraylength
    //   36: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: ldc2_w 230
    //   42: aload 6
    //   44: arraylength
    //   45: i2l
    //   46: lmul
    //   47: aload_2
    //   48: arraylength
    //   49: i2l
    //   50: ldiv
    //   51: invokestatic 236	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: aload_1
    //   55: invokevirtual 239	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   58: aload 6
    //   60: arraylength
    //   61: aload_2
    //   62: arraylength
    //   63: if_icmple +20 -> 83
    //   66: aload_0
    //   67: ldc -15
    //   69: aload 6
    //   71: arraylength
    //   72: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aload_2
    //   76: arraylength
    //   77: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokevirtual 243	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   83: aload_0
    //   84: invokevirtual 104	com/google/android/gms/analytics/internal/zzah:zzkN	()Z
    //   87: ifeq +36 -> 123
    //   90: new 19	java/lang/String
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 109	java/lang/String:<init>	([B)V
    //   98: invokestatic 246	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 247	java/lang/String:length	()I
    //   106: ifeq +107 -> 213
    //   109: ldc 17
    //   111: aload_2
    //   112: invokevirtual 251	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: ldc -3
    //   119: aload_2
    //   120: invokevirtual 112	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 126	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   128: astore_1
    //   129: aload_1
    //   130: iconst_1
    //   131: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   134: aload_1
    //   135: ldc -1
    //   137: ldc_w 257
    //   140: invokevirtual 261	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_1
    //   144: aload 6
    //   146: arraylength
    //   147: invokevirtual 136	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   150: aload_1
    //   151: invokevirtual 139	java/net/HttpURLConnection:connect	()V
    //   154: aload_1
    //   155: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   158: astore_2
    //   159: aload_2
    //   160: aload 6
    //   162: invokevirtual 148	java/io/OutputStream:write	([B)V
    //   165: aload_2
    //   166: invokevirtual 171	java/io/OutputStream:close	()V
    //   169: aload_0
    //   170: aload_1
    //   171: invokespecial 151	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/net/HttpURLConnection;)V
    //   174: aload_1
    //   175: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   178: istore_3
    //   179: iload_3
    //   180: sipush 200
    //   183: if_icmpne +10 -> 193
    //   186: aload_0
    //   187: invokevirtual 159	com/google/android/gms/analytics/internal/zzah:zzmF	()Lcom/google/android/gms/analytics/internal/zzb;
    //   190: invokevirtual 164	com/google/android/gms/analytics/internal/zzb:zzno	()V
    //   193: aload_0
    //   194: ldc -90
    //   196: iload_3
    //   197: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokevirtual 168	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   211: iload_3
    //   212: ireturn
    //   213: new 19	java/lang/String
    //   216: dup
    //   217: ldc 17
    //   219: invokespecial 264	java/lang/String:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: goto -107 -> 116
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_0
    //   230: ldc_w 266
    //   233: aload_2
    //   234: invokevirtual 184	com/google/android/gms/analytics/internal/zzah:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 171	java/io/OutputStream:close	()V
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   255: iconst_0
    //   256: ireturn
    //   257: astore_2
    //   258: aload_0
    //   259: ldc_w 268
    //   262: aload_2
    //   263: invokevirtual 179	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   266: goto -19 -> 247
    //   269: astore_2
    //   270: aconst_null
    //   271: astore_1
    //   272: aload 5
    //   274: astore 4
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 171	java/io/OutputStream:close	()V
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   294: aload_2
    //   295: athrow
    //   296: astore 4
    //   298: aload_0
    //   299: ldc_w 268
    //   302: aload 4
    //   304: invokevirtual 179	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   307: goto -21 -> 286
    //   310: astore_2
    //   311: aload 5
    //   313: astore 4
    //   315: goto -39 -> 276
    //   318: astore 5
    //   320: aload_2
    //   321: astore 4
    //   323: aload 5
    //   325: astore_2
    //   326: goto -50 -> 276
    //   329: astore_2
    //   330: goto -54 -> 276
    //   333: astore_2
    //   334: goto -105 -> 229
    //   337: astore 5
    //   339: aload_2
    //   340: astore 4
    //   342: aload 5
    //   344: astore_2
    //   345: goto -116 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	zzah
    //   0	348	1	paramURL	URL
    //   0	348	2	paramArrayOfByte	byte[]
    //   178	34	3	i	int
    //   4	278	4	localObject1	Object
    //   296	7	4	localIOException1	IOException
    //   313	28	4	localObject2	Object
    //   1	311	5	localObject3	Object
    //   318	6	5	localObject4	Object
    //   337	6	5	localIOException2	IOException
    //   28	133	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	83	226	java/io/IOException
    //   83	116	226	java/io/IOException
    //   116	123	226	java/io/IOException
    //   123	129	226	java/io/IOException
    //   213	223	226	java/io/IOException
    //   242	247	257	java/io/IOException
    //   16	83	269	finally
    //   83	116	269	finally
    //   116	123	269	finally
    //   123	129	269	finally
    //   213	223	269	finally
    //   281	286	296	java/io/IOException
    //   129	159	310	finally
    //   169	179	310	finally
    //   186	193	310	finally
    //   193	203	310	finally
    //   159	169	318	finally
    //   229	237	329	finally
    //   129	159	333	java/io/IOException
    //   169	179	333	java/io/IOException
    //   186	193	333	java/io/IOException
    //   193	203	333	java/io/IOException
    //   159	169	337	java/io/IOException
  }
  
  private URL zzb(zzab paramzzab, String paramString)
  {
    String str;
    if (paramzzab.zzpr())
    {
      paramzzab = String.valueOf(zzns().zzoI());
      str = String.valueOf(zzns().zzoK());
    }
    for (paramzzab = String.valueOf(paramzzab).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString).length() + paramzzab + str + "?" + paramString;; paramzzab = String.valueOf(paramzzab).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString).length() + paramzzab + str + "?" + paramString)
    {
      try
      {
        paramzzab = new URL(paramzzab);
        return paramzzab;
      }
      catch (MalformedURLException paramzzab)
      {
        zze("Error trying to parse the hardcoded host url", paramzzab);
      }
      paramzzab = String.valueOf(zzns().zzoJ());
      str = String.valueOf(zzns().zzoK());
    }
    return null;
  }
  
  private void zzb(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    localHttpURLConnection = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localHttpURLConnection = paramHttpURLConnection;
      byte[] arrayOfByte = new byte['Ѐ'];
      int i;
      do
      {
        localHttpURLConnection = paramHttpURLConnection;
        i = paramHttpURLConnection.read(arrayOfByte);
      } while (i > 0);
      if (paramHttpURLConnection != null) {}
      try
      {
        paramHttpURLConnection.close();
        return;
      }
      catch (IOException paramHttpURLConnection)
      {
        zze("Error closing http connection input stream", paramHttpURLConnection);
        return;
      }
      try
      {
        localHttpURLConnection.close();
        throw paramHttpURLConnection;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          zze("Error closing http connection input stream", localIOException);
        }
      }
    }
    finally
    {
      if (localHttpURLConnection == null) {}
    }
  }
  
  private boolean zzg(zzab paramzzab)
  {
    zzac.zzC(paramzzab);
    boolean bool;
    Object localObject;
    if (!paramzzab.zzpr())
    {
      bool = true;
      localObject = zza(paramzzab, bool);
      if (localObject != null) {
        break label43;
      }
      zznr().zza(paramzzab, "Error formatting hit for upload");
    }
    label43:
    label90:
    do
    {
      do
      {
        return true;
        bool = false;
        break;
        if (((String)localObject).length() > zzns().zzox()) {
          break label90;
        }
        paramzzab = zzb(paramzzab, (String)localObject);
        if (paramzzab == null)
        {
          zzbv("Failed to build collect GET endpoint url");
          return false;
        }
      } while (zzb(paramzzab) == 200);
      return false;
      localObject = zza(paramzzab, false);
      if (localObject == null)
      {
        zznr().zza(paramzzab, "Error formatting hit for POST upload");
        return true;
      }
      localObject = ((String)localObject).getBytes();
      if (localObject.length > zzns().zzoz())
      {
        zznr().zza(paramzzab, "Hit payload exceeds size limit");
        return true;
      }
      paramzzab = zzh(paramzzab);
      if (paramzzab == null)
      {
        zzbv("Failed to build collect POST endpoint url");
        return false;
      }
    } while (zza(paramzzab, (byte[])localObject) == 200);
    return false;
  }
  
  private URL zzh(zzab paramzzab)
  {
    String str;
    if (paramzzab.zzpr())
    {
      paramzzab = String.valueOf(zzns().zzoI());
      str = String.valueOf(zzns().zzoK());
      if (str.length() != 0) {}
      for (paramzzab = paramzzab.concat(str);; paramzzab = new String(paramzzab)) {
        try
        {
          paramzzab = new URL(paramzzab);
          return paramzzab;
        }
        catch (MalformedURLException paramzzab)
        {
          zze("Error trying to parse the hardcoded host url", paramzzab);
        }
      }
    }
    else
    {
      paramzzab = String.valueOf(zzns().zzoJ());
      str = String.valueOf(zzns().zzoK());
      if (str.length() != 0) {}
      for (paramzzab = paramzzab.concat(str);; paramzzab = new String(paramzzab)) {
        break;
      }
    }
    return null;
  }
  
  private String zzi(zzab paramzzab)
  {
    return String.valueOf(paramzzab.zzpo());
  }
  
  private static byte[] zzk(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.close();
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private URL zzpz()
  {
    Object localObject = String.valueOf(zzns().zzoI());
    String str = String.valueOf(zzns().zzoL());
    if (str.length() != 0) {}
    for (localObject = ((String)localObject).concat(str);; localObject = new String((String)localObject)) {
      try
      {
        localObject = new URL((String)localObject);
        return (URL)localObject;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        zze("Error trying to parse the hardcoded host url", localMalformedURLException);
      }
    }
    return null;
  }
  
  public boolean isNetworkConnected()
  {
    zzmW();
    zznA();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected()))
      {
        zzbr("No network connectivity");
        return false;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return true;
  }
  
  protected void onInitialize()
  {
    zza("Network initialized. User agent", this.zzIp);
  }
  
  String zza(zzab paramzzab, boolean paramBoolean)
  {
    zzac.zzC(paramzzab);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramzzab.zzfN().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if ((!"ht".equals(str)) && (!"qt".equals(str)) && (!"AppUID".equals(str)) && (!"z".equals(str)) && (!"_gmsv".equals(str))) {
          zza(localStringBuilder, str, (String)localEntry.getValue());
        }
      }
      zza(localStringBuilder, "ht", String.valueOf(paramzzab.zzpp()));
    }
    catch (UnsupportedEncodingException paramzzab)
    {
      zze("Failed to encode name or value", paramzzab);
      return null;
    }
    zza(localStringBuilder, "qt", String.valueOf(zznq().currentTimeMillis() - paramzzab.zzpp()));
    long l;
    if (paramBoolean)
    {
      l = paramzzab.zzps();
      if (l == 0L) {
        break label229;
      }
    }
    label229:
    for (paramzzab = String.valueOf(l);; paramzzab = zzi(paramzzab))
    {
      zza(localStringBuilder, "z", paramzzab);
      return localStringBuilder.toString();
    }
  }
  
  List<Long> zza(List<zzab> paramList, boolean paramBoolean)
  {
    boolean bool;
    zza localzza;
    ArrayList localArrayList;
    if (!paramList.isEmpty())
    {
      bool = true;
      zzac.zzaw(bool);
      zza("Uploading batched hits. compression, count", Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()));
      localzza = new zza();
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      zzab localzzab;
      if (paramList.hasNext())
      {
        localzzab = (zzab)paramList.next();
        if (localzza.zzj(localzzab)) {}
      }
      else
      {
        if (localzza.zzpB() != 0) {
          break label129;
        }
        return localArrayList;
        bool = false;
        break;
      }
      localArrayList.add(Long.valueOf(localzzab.zzpo()));
    }
    label129:
    paramList = zzpz();
    if (paramList == null)
    {
      zzbv("Failed to build batching endpoint url");
      return Collections.emptyList();
    }
    if (paramBoolean) {}
    for (int i = zzb(paramList, localzza.getPayload()); 200 == i; i = zza(paramList, localzza.getPayload()))
    {
      zza("Batched upload completed. Hits batched", Integer.valueOf(localzza.zzpB()));
      return localArrayList;
    }
    zza("Network error uploading hits. status code", Integer.valueOf(i));
    if (zzns().zzoO().contains(Integer.valueOf(i)))
    {
      zzbu("Server instructed the client to stop batching");
      this.zzafr.start();
    }
    return Collections.emptyList();
  }
  
  HttpURLConnection zzc(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection)) {
      throw new IOException("Failed to obtain http connection");
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout(zzns().zzoV());
    paramURL.setReadTimeout(zzns().zzoW());
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setRequestProperty("User-Agent", this.zzIp);
    paramURL.setDoInput(true);
    return paramURL;
  }
  
  public List<Long> zzt(List<zzab> paramList)
  {
    boolean bool = true;
    zzmW();
    zznA();
    zzac.zzC(paramList);
    int j;
    if ((zzns().zzoO().isEmpty()) || (!this.zzafr.zzE(zzns().zzoH() * 1000L)))
    {
      bool = false;
      j = 0;
      if (j != 0) {
        return zza(paramList, bool);
      }
    }
    else
    {
      if (zzns().zzoM() != zzm.zzaeu) {}
      for (int i = 1;; i = 0)
      {
        j = i;
        if (zzns().zzoN() == zzp.zzaeF) {
          break;
        }
        bool = false;
        j = i;
        break;
      }
    }
    return zzu(paramList);
  }
  
  List<Long> zzu(List<zzab> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    do
    {
      zzab localzzab;
      if (paramList.hasNext())
      {
        localzzab = (zzab)paramList.next();
        if (zzg(localzzab)) {}
      }
      else
      {
        return localArrayList;
      }
      localArrayList.add(Long.valueOf(localzzab.zzpo()));
    } while (localArrayList.size() < zzns().zzoF());
    return localArrayList;
  }
  
  private class zza
  {
    private int zzaft;
    private ByteArrayOutputStream zzafu = new ByteArrayOutputStream();
    
    public zza() {}
    
    public byte[] getPayload()
    {
      return this.zzafu.toByteArray();
    }
    
    public boolean zzj(zzab paramzzab)
    {
      zzac.zzC(paramzzab);
      if (this.zzaft + 1 > zzah.this.zzns().zzoG()) {
        return false;
      }
      Object localObject = zzah.this.zza(paramzzab, false);
      if (localObject == null)
      {
        zzah.this.zznr().zza(paramzzab, "Error formatting hit");
        return true;
      }
      localObject = ((String)localObject).getBytes();
      int j = localObject.length;
      if (j > zzah.this.zzns().zzoy())
      {
        zzah.this.zznr().zza(paramzzab, "Hit size exceeds the maximum size limit");
        return true;
      }
      int i = j;
      if (this.zzafu.size() > 0) {
        i = j + 1;
      }
      if (i + this.zzafu.size() > zzah.this.zzns().zzoA()) {
        return false;
      }
      try
      {
        if (this.zzafu.size() > 0) {
          this.zzafu.write(zzah.zzpA());
        }
        this.zzafu.write((byte[])localObject);
        this.zzaft += 1;
        return true;
      }
      catch (IOException paramzzab)
      {
        zzah.this.zze("Failed to write payload when batching hits", paramzzab);
      }
      return true;
    }
    
    public int zzpB()
    {
      return this.zzaft;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */