package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzu
  implements zzg
{
  protected static final boolean DEBUG = zzt.DEBUG;
  private static int zzam = 3000;
  private static int zzan = 4096;
  protected final zzz zzao;
  protected final zzv zzap;
  
  public zzu(zzz paramzzz)
  {
    this(paramzzz, new zzv(zzan));
  }
  
  public zzu(zzz paramzzz, zzv paramzzv)
  {
    this.zzao = paramzzz;
    this.zzap = paramzzv;
  }
  
  protected static Map<String, String> zza(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private void zza(long paramLong, zzl<?> paramzzl, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > zzam)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      zzt.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramzzl, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramzzl.zzq().zzd()) });
      return;
    }
  }
  
  private static void zza(String paramString, zzl<?> paramzzl, zzs paramzzs)
    throws zzs
  {
    zzp localzzp = paramzzl.zzq();
    int i = paramzzl.zzp();
    try
    {
      localzzp.zza(paramzzs);
      paramzzl.zzc(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (zzs paramzzs)
    {
      paramzzl.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramzzs;
    }
  }
  
  private void zza(Map<String, String> paramMap, zzb.zza paramzza)
  {
    if (paramzza == null) {}
    do
    {
      return;
      if (paramzza.zza != null) {
        paramMap.put("If-None-Match", paramzza.zza);
      }
    } while (paramzza.zzc <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramzza.zzc)));
  }
  
  private byte[] zza(HttpEntity paramHttpEntity)
    throws IOException, zzq
  {
    zzab localzzab = new zzab(this.zzap, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new zzq();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.zzap.zza((byte[])localObject1);
      localzzab.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.zzap.zzb(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localzzab.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localzzab.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.zzap.zza(arrayOfByte);
        localzzab.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          zzt.zza("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        zzt.zza("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public zzj zza(zzl<?> paramzzl)
    throws zzs
  {
    // Byte code:
    //   0: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: invokestatic 228	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 7
    //   12: new 230	java/util/HashMap
    //   15: dup
    //   16: invokespecial 231	java/util/HashMap:<init>	()V
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 235	com/google/android/gms/internal/zzl:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   28: invokespecial 237	com/google/android/gms/internal/zzu:zza	(Ljava/util/Map;Lcom/google/android/gms/internal/zzb$zza;)V
    //   31: aload_0
    //   32: getfield 41	com/google/android/gms/internal/zzu:zzao	Lcom/google/android/gms/internal/zzz;
    //   35: aload_1
    //   36: aload 5
    //   38: invokeinterface 242 3 0
    //   43: astore 6
    //   45: aload 7
    //   47: astore 5
    //   49: aload 6
    //   51: invokeinterface 248 1 0
    //   56: astore 8
    //   58: aload 7
    //   60: astore 5
    //   62: aload 8
    //   64: invokeinterface 93 1 0
    //   69: istore_2
    //   70: aload 7
    //   72: astore 5
    //   74: aload 6
    //   76: invokeinterface 252 1 0
    //   81: invokestatic 254	com/google/android/gms/internal/zzu:zza	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   84: astore 9
    //   86: iload_2
    //   87: sipush 304
    //   90: if_icmpne +89 -> 179
    //   93: aload 9
    //   95: astore 5
    //   97: aload_1
    //   98: invokevirtual 235	com/google/android/gms/internal/zzl:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnonnull +27 -> 132
    //   108: aload 9
    //   110: astore 5
    //   112: new 256	com/google/android/gms/internal/zzj
    //   115: dup
    //   116: sipush 304
    //   119: aconst_null
    //   120: aload 9
    //   122: iconst_1
    //   123: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   126: lload_3
    //   127: lsub
    //   128: invokespecial 259	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   131: areturn
    //   132: aload 9
    //   134: astore 5
    //   136: aload 7
    //   138: getfield 263	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   141: aload 9
    //   143: invokeinterface 267 2 0
    //   148: aload 9
    //   150: astore 5
    //   152: new 256	com/google/android/gms/internal/zzj
    //   155: dup
    //   156: sipush 304
    //   159: aload 7
    //   161: getfield 271	com/google/android/gms/internal/zzb$zza:data	[B
    //   164: aload 7
    //   166: getfield 263	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   169: iconst_1
    //   170: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   173: lload_3
    //   174: lsub
    //   175: invokespecial 259	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   178: areturn
    //   179: aload 9
    //   181: astore 5
    //   183: aload 6
    //   185: invokeinterface 275 1 0
    //   190: ifnull +79 -> 269
    //   193: aload 9
    //   195: astore 5
    //   197: aload_0
    //   198: aload 6
    //   200: invokeinterface 275 1 0
    //   205: invokespecial 277	com/google/android/gms/internal/zzu:zza	(Lorg/apache/http/HttpEntity;)[B
    //   208: astore 7
    //   210: aload 7
    //   212: astore 5
    //   214: aload_0
    //   215: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   218: lload_3
    //   219: lsub
    //   220: aload_1
    //   221: aload 5
    //   223: aload 8
    //   225: invokespecial 279	com/google/android/gms/internal/zzu:zza	(JLcom/google/android/gms/internal/zzl;[BLorg/apache/http/StatusLine;)V
    //   228: iload_2
    //   229: sipush 200
    //   232: if_icmplt +10 -> 242
    //   235: iload_2
    //   236: sipush 299
    //   239: if_icmple +46 -> 285
    //   242: new 162	java/io/IOException
    //   245: dup
    //   246: invokespecial 280	java/io/IOException:<init>	()V
    //   249: athrow
    //   250: astore 5
    //   252: ldc_w 282
    //   255: aload_1
    //   256: new 284	com/google/android/gms/internal/zzr
    //   259: dup
    //   260: invokespecial 285	com/google/android/gms/internal/zzr:<init>	()V
    //   263: invokestatic 287	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   266: goto -262 -> 4
    //   269: aload 9
    //   271: astore 5
    //   273: iconst_0
    //   274: newarray <illegal type>
    //   276: astore 7
    //   278: aload 7
    //   280: astore 5
    //   282: goto -68 -> 214
    //   285: new 256	com/google/android/gms/internal/zzj
    //   288: dup
    //   289: iload_2
    //   290: aload 5
    //   292: aload 9
    //   294: iconst_0
    //   295: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   298: lload_3
    //   299: lsub
    //   300: invokespecial 259	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   303: astore 7
    //   305: aload 7
    //   307: areturn
    //   308: astore 5
    //   310: ldc_w 289
    //   313: aload_1
    //   314: new 284	com/google/android/gms/internal/zzr
    //   317: dup
    //   318: invokespecial 285	com/google/android/gms/internal/zzr:<init>	()V
    //   321: invokestatic 287	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   324: goto -320 -> 4
    //   327: astore 5
    //   329: new 291	java/lang/RuntimeException
    //   332: dup
    //   333: new 293	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 294	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 296
    //   343: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_1
    //   347: invokevirtual 303	com/google/android/gms/internal/zzl:getUrl	()Ljava/lang/String;
    //   350: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 5
    //   358: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   361: athrow
    //   362: astore 6
    //   364: aconst_null
    //   365: astore 8
    //   367: aload 7
    //   369: astore 5
    //   371: aload 9
    //   373: astore 7
    //   375: aload 7
    //   377: ifnull +98 -> 475
    //   380: aload 7
    //   382: invokeinterface 248 1 0
    //   387: invokeinterface 93 1 0
    //   392: istore_2
    //   393: ldc_w 311
    //   396: iconst_2
    //   397: anewarray 4	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: iload_2
    //   403: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: aload_1
    //   410: invokevirtual 303	com/google/android/gms/internal/zzl:getUrl	()Ljava/lang/String;
    //   413: aastore
    //   414: invokestatic 313	com/google/android/gms/internal/zzt:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aload 8
    //   419: ifnull +124 -> 543
    //   422: new 256	com/google/android/gms/internal/zzj
    //   425: dup
    //   426: iload_2
    //   427: aload 8
    //   429: aload 5
    //   431: iconst_0
    //   432: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   435: lload_3
    //   436: lsub
    //   437: invokespecial 259	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   440: astore 5
    //   442: iload_2
    //   443: sipush 401
    //   446: if_icmpeq +10 -> 456
    //   449: iload_2
    //   450: sipush 403
    //   453: if_icmpne +32 -> 485
    //   456: ldc_w 315
    //   459: aload_1
    //   460: new 317	com/google/android/gms/internal/zza
    //   463: dup
    //   464: aload 5
    //   466: invokespecial 320	com/google/android/gms/internal/zza:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   469: invokestatic 287	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   472: goto -468 -> 4
    //   475: new 322	com/google/android/gms/internal/zzk
    //   478: dup
    //   479: aload 6
    //   481: invokespecial 325	com/google/android/gms/internal/zzk:<init>	(Ljava/lang/Throwable;)V
    //   484: athrow
    //   485: iload_2
    //   486: sipush 400
    //   489: if_icmplt +20 -> 509
    //   492: iload_2
    //   493: sipush 499
    //   496: if_icmpgt +13 -> 509
    //   499: new 327	com/google/android/gms/internal/zzd
    //   502: dup
    //   503: aload 5
    //   505: invokespecial 328	com/google/android/gms/internal/zzd:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   508: athrow
    //   509: iload_2
    //   510: sipush 500
    //   513: if_icmplt +20 -> 533
    //   516: iload_2
    //   517: sipush 599
    //   520: if_icmpgt +13 -> 533
    //   523: new 164	com/google/android/gms/internal/zzq
    //   526: dup
    //   527: aload 5
    //   529: invokespecial 329	com/google/android/gms/internal/zzq:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   532: athrow
    //   533: new 164	com/google/android/gms/internal/zzq
    //   536: dup
    //   537: aload 5
    //   539: invokespecial 329	com/google/android/gms/internal/zzq:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   542: athrow
    //   543: ldc_w 331
    //   546: aload_1
    //   547: new 333	com/google/android/gms/internal/zzi
    //   550: dup
    //   551: invokespecial 334	com/google/android/gms/internal/zzi:<init>	()V
    //   554: invokestatic 287	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   557: goto -553 -> 4
    //   560: astore 9
    //   562: aconst_null
    //   563: astore 8
    //   565: aload 6
    //   567: astore 7
    //   569: aload 9
    //   571: astore 6
    //   573: goto -198 -> 375
    //   576: astore 8
    //   578: aload 6
    //   580: astore 7
    //   582: aload 8
    //   584: astore 6
    //   586: aload 5
    //   588: astore 8
    //   590: aload 9
    //   592: astore 5
    //   594: goto -219 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	zzu
    //   0	597	1	paramzzl	zzl<?>
    //   69	452	2	i	int
    //   3	433	3	l	long
    //   19	203	5	localObject1	Object
    //   250	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   271	20	5	localObject2	Object
    //   308	1	5	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   327	30	5	localMalformedURLException	java.net.MalformedURLException
    //   369	224	5	localObject3	Object
    //   43	156	6	localHttpResponse	org.apache.http.HttpResponse
    //   362	204	6	localIOException1	IOException
    //   571	14	6	localObject4	Object
    //   10	571	7	localObject5	Object
    //   56	508	8	localStatusLine	StatusLine
    //   576	7	8	localIOException2	IOException
    //   588	1	8	localObject6	Object
    //   5	367	9	localMap	Map
    //   560	31	9	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   12	45	250	java/net/SocketTimeoutException
    //   49	58	250	java/net/SocketTimeoutException
    //   62	70	250	java/net/SocketTimeoutException
    //   74	86	250	java/net/SocketTimeoutException
    //   97	103	250	java/net/SocketTimeoutException
    //   112	132	250	java/net/SocketTimeoutException
    //   136	148	250	java/net/SocketTimeoutException
    //   152	179	250	java/net/SocketTimeoutException
    //   183	193	250	java/net/SocketTimeoutException
    //   197	210	250	java/net/SocketTimeoutException
    //   214	228	250	java/net/SocketTimeoutException
    //   242	250	250	java/net/SocketTimeoutException
    //   273	278	250	java/net/SocketTimeoutException
    //   285	305	250	java/net/SocketTimeoutException
    //   12	45	308	org/apache/http/conn/ConnectTimeoutException
    //   49	58	308	org/apache/http/conn/ConnectTimeoutException
    //   62	70	308	org/apache/http/conn/ConnectTimeoutException
    //   74	86	308	org/apache/http/conn/ConnectTimeoutException
    //   97	103	308	org/apache/http/conn/ConnectTimeoutException
    //   112	132	308	org/apache/http/conn/ConnectTimeoutException
    //   136	148	308	org/apache/http/conn/ConnectTimeoutException
    //   152	179	308	org/apache/http/conn/ConnectTimeoutException
    //   183	193	308	org/apache/http/conn/ConnectTimeoutException
    //   197	210	308	org/apache/http/conn/ConnectTimeoutException
    //   214	228	308	org/apache/http/conn/ConnectTimeoutException
    //   242	250	308	org/apache/http/conn/ConnectTimeoutException
    //   273	278	308	org/apache/http/conn/ConnectTimeoutException
    //   285	305	308	org/apache/http/conn/ConnectTimeoutException
    //   12	45	327	java/net/MalformedURLException
    //   49	58	327	java/net/MalformedURLException
    //   62	70	327	java/net/MalformedURLException
    //   74	86	327	java/net/MalformedURLException
    //   97	103	327	java/net/MalformedURLException
    //   112	132	327	java/net/MalformedURLException
    //   136	148	327	java/net/MalformedURLException
    //   152	179	327	java/net/MalformedURLException
    //   183	193	327	java/net/MalformedURLException
    //   197	210	327	java/net/MalformedURLException
    //   214	228	327	java/net/MalformedURLException
    //   242	250	327	java/net/MalformedURLException
    //   273	278	327	java/net/MalformedURLException
    //   285	305	327	java/net/MalformedURLException
    //   12	45	362	java/io/IOException
    //   49	58	560	java/io/IOException
    //   62	70	560	java/io/IOException
    //   74	86	560	java/io/IOException
    //   97	103	560	java/io/IOException
    //   112	132	560	java/io/IOException
    //   136	148	560	java/io/IOException
    //   152	179	560	java/io/IOException
    //   183	193	560	java/io/IOException
    //   197	210	560	java/io/IOException
    //   273	278	560	java/io/IOException
    //   214	228	576	java/io/IOException
    //   242	250	576	java/io/IOException
    //   285	305	576	java/io/IOException
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */