package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzw
  implements zzb
{
  private final Map<String, zza> zzav = new LinkedHashMap(16, 0.75F, true);
  private long zzaw = 0L;
  private final File zzax;
  private final int zzay;
  
  public zzw(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public zzw(File paramFile, int paramInt)
  {
    this.zzax = paramFile;
    this.zzay = paramInt;
  }
  
  private void removeEntry(String paramString)
  {
    zza localzza = (zza)this.zzav.get(paramString);
    if (localzza != null)
    {
      this.zzaw -= localzza.zzaz;
      this.zzav.remove(paramString);
    }
  }
  
  private static int zza(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static void zza(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void zza(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void zza(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    zza(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void zza(String paramString, zza paramzza)
  {
    if (!this.zzav.containsKey(paramString)) {}
    zza localzza;
    long l;
    for (this.zzaw += paramzza.zzaz;; this.zzaw = (paramzza.zzaz - localzza.zzaz + l))
    {
      this.zzav.put(paramString, paramzza);
      return;
      localzza = (zza)this.zzav.get(paramString);
      l = this.zzaw;
    }
  }
  
  static void zza(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramMap != null)
    {
      zza(paramOutputStream, paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        zza(paramOutputStream, (String)localEntry.getKey());
        zza(paramOutputStream, (String)localEntry.getValue());
      }
    }
    zza(paramOutputStream, 0);
  }
  
  private static byte[] zza(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static int zzb(InputStream paramInputStream)
    throws IOException
  {
    return zza(paramInputStream) << 0 | 0x0 | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }
  
  static long zzc(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (zza(paramInputStream) & 0xFF) << 0 | (zza(paramInputStream) & 0xFF) << 8 | (zza(paramInputStream) & 0xFF) << 16 | (zza(paramInputStream) & 0xFF) << 24 | (zza(paramInputStream) & 0xFF) << 32 | (zza(paramInputStream) & 0xFF) << 40 | (zza(paramInputStream) & 0xFF) << 48 | (zza(paramInputStream) & 0xFF) << 56;
  }
  
  private void zzc(int paramInt)
  {
    if (this.zzaw + paramInt < this.zzay) {}
    label119:
    label229:
    label233:
    for (;;)
    {
      return;
      if (zzt.DEBUG) {
        zzt.zza("Pruning old cache entries.", new Object[0]);
      }
      long l1 = this.zzaw;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.zzav.entrySet().iterator();
      int i = 0;
      zza localzza;
      if (localIterator.hasNext())
      {
        localzza = (zza)((Map.Entry)localIterator.next()).getValue();
        if (zzf(localzza.zzaA).delete())
        {
          this.zzaw -= localzza.zzaz;
          localIterator.remove();
          i += 1;
          if ((float)(this.zzaw + paramInt) >= this.zzay * 0.9F) {
            break label229;
          }
        }
      }
      for (;;)
      {
        if (!zzt.DEBUG) {
          break label233;
        }
        zzt.zza("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(this.zzaw - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        return;
        zzt.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { localzza.zzaA, zze(localzza.zzaA) });
        break label119;
        break;
      }
    }
  }
  
  static String zzd(InputStream paramInputStream)
    throws IOException
  {
    return new String(zza(paramInputStream, (int)zzc(paramInputStream)), "UTF-8");
  }
  
  private String zze(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  static Map<String, String> zze(InputStream paramInputStream)
    throws IOException
  {
    int j = zzb(paramInputStream);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j))
    {
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put(zzd(paramInputStream).intern(), zzd(paramInputStream).intern());
        i += 1;
      }
    }
    return (Map<String, String>)localObject;
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/google/android/gms/internal/zzw:zzax	Ljava/io/File;
    //   6: invokevirtual 276	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 45	com/google/android/gms/internal/zzw:zzax	Ljava/io/File;
    //   16: invokevirtual 279	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 281
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 45	com/google/android/gms/internal/zzw:zzax	Ljava/io/File;
    //   35: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 286	com/google/android/gms/internal/zzt:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 45	com/google/android/gms/internal/zzw:zzax	Ljava/io/File;
    //   49: invokevirtual 290	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull -14 -> 42
    //   59: aload 5
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 5
    //   72: iload_1
    //   73: aaload
    //   74: astore 6
    //   76: aconst_null
    //   77: astore_3
    //   78: new 292	java/io/BufferedInputStream
    //   81: dup
    //   82: new 294	java/io/FileInputStream
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: invokestatic 302	com/google/android/gms/internal/zzw$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzw$zza;
    //   104: astore 7
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: aload 6
    //   113: invokevirtual 304	java/io/File:length	()J
    //   116: putfield 58	com/google/android/gms/internal/zzw$zza:zzaz	J
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: aload 7
    //   125: getfield 196	com/google/android/gms/internal/zzw$zza:zzaA	Ljava/lang/String;
    //   128: aload 7
    //   130: invokespecial 306	com/google/android/gms/internal/zzw:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzw$zza;)V
    //   133: aload 4
    //   135: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: goto -77 -> 65
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 6
    //   151: ifnull +12 -> 163
    //   154: aload 4
    //   156: astore_3
    //   157: aload 6
    //   159: invokevirtual 205	java/io/File:delete	()Z
    //   162: pop
    //   163: aload 4
    //   165: ifnull -27 -> 138
    //   168: aload 4
    //   170: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   173: goto -35 -> 138
    //   176: astore_3
    //   177: goto -39 -> 138
    //   180: astore 5
    //   182: aload_3
    //   183: astore 4
    //   185: aload 5
    //   187: astore_3
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   198: aload_3
    //   199: athrow
    //   200: astore_3
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_3
    //   204: athrow
    //   205: astore_3
    //   206: goto -68 -> 138
    //   209: astore 4
    //   211: goto -13 -> 198
    //   214: astore 5
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: astore_3
    //   222: goto -34 -> 188
    //   225: astore_3
    //   226: goto -77 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zzw
    //   64	78	1	i	int
    //   62	6	2	j	int
    //   77	45	3	localObject1	Object
    //   145	1	3	localIOException1	IOException
    //   156	1	3	localObject2	Object
    //   176	7	3	localIOException2	IOException
    //   187	12	3	localObject3	Object
    //   200	4	3	localObject4	Object
    //   205	12	3	localIOException3	IOException
    //   221	1	3	localObject5	Object
    //   225	1	3	localIOException4	IOException
    //   94	100	4	localObject6	Object
    //   209	1	4	localIOException5	IOException
    //   217	1	4	localIOException6	IOException
    //   52	19	5	arrayOfFile	File[]
    //   180	6	5	localObject7	Object
    //   214	6	5	localObject8	Object
    //   74	84	6	localFile	File
    //   104	25	7	localzza	zza
    // Exception table:
    //   from	to	target	type
    //   78	96	145	java/io/IOException
    //   168	173	176	java/io/IOException
    //   78	96	180	finally
    //   2	42	200	finally
    //   45	54	200	finally
    //   59	63	200	finally
    //   133	138	200	finally
    //   168	173	200	finally
    //   193	198	200	finally
    //   198	200	200	finally
    //   133	138	205	java/io/IOException
    //   193	198	209	java/io/IOException
    //   99	106	214	finally
    //   109	119	214	finally
    //   122	133	214	finally
    //   157	163	214	finally
    //   99	106	225	java/io/IOException
    //   109	119	225	java/io/IOException
    //   122	133	225	java/io/IOException
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = zzf(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        zzt.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, zze(paramString) });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public zzb.zza zza(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/google/android/gms/internal/zzw:zzav	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 55 2 0
    //   12: checkcast 10	com/google/android/gms/internal/zzw$zza
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 200	com/google/android/gms/internal/zzw:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 5
    //   35: new 13	com/google/android/gms/internal/zzw$zzb
    //   38: dup
    //   39: new 292	java/io/BufferedInputStream
    //   42: dup
    //   43: new 294	java/io/FileInputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: aconst_null
    //   56: invokespecial 315	com/google/android/gms/internal/zzw$zzb:<init>	(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzw$1;)V
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: invokestatic 302	com/google/android/gms/internal/zzw$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzw$zza;
    //   66: pop
    //   67: aload_3
    //   68: astore_2
    //   69: aload 4
    //   71: aload_3
    //   72: aload 5
    //   74: invokevirtual 304	java/io/File:length	()J
    //   77: aload_3
    //   78: invokestatic 318	com/google/android/gms/internal/zzw$zzb:zza	(Lcom/google/android/gms/internal/zzw$zzb;)I
    //   81: i2l
    //   82: lsub
    //   83: l2i
    //   84: invokestatic 235	com/google/android/gms/internal/zzw:zza	(Ljava/io/InputStream;I)[B
    //   87: invokevirtual 321	com/google/android/gms/internal/zzw$zza:zzb	([B)Lcom/google/android/gms/internal/zzb$zza;
    //   90: astore 4
    //   92: aload 4
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   99: goto -75 -> 24
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -81 -> 24
    //   108: astore 4
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: astore_2
    //   114: ldc_w 324
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload 5
    //   125: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 4
    //   133: invokevirtual 325	java/io/IOException:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 229	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_3
    //   141: astore_2
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 327	com/google/android/gms/internal/zzw:remove	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -133 -> 24
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -139 -> 24
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   177: aload_1
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_1
    //   187: goto -163 -> 24
    //   190: astore_1
    //   191: goto -22 -> 169
    //   194: astore 4
    //   196: goto -84 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	zzw
    //   0	199	1	paramString	String
    //   61	113	2	localzzb1	zzb
    //   59	93	3	localzzb2	zzb
    //   15	78	4	localObject	Object
    //   108	24	4	localIOException1	IOException
    //   194	1	4	localIOException2	IOException
    //   33	91	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   95	99	102	java/io/IOException
    //   35	60	108	java/io/IOException
    //   151	155	160	java/io/IOException
    //   35	60	166	finally
    //   2	17	179	finally
    //   28	35	179	finally
    //   95	99	179	finally
    //   151	155	179	finally
    //   173	177	179	finally
    //   177	179	179	finally
    //   173	177	184	java/io/IOException
    //   62	67	190	finally
    //   69	92	190	finally
    //   114	140	190	finally
    //   142	147	190	finally
    //   62	67	194	java/io/IOException
    //   69	92	194	java/io/IOException
  }
  
  /* Error */
  public void zza(String paramString, zzb.zza paramzza)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 334	com/google/android/gms/internal/zzb$zza:data	[B
    //   7: arraylength
    //   8: invokespecial 336	com/google/android/gms/internal/zzw:zzc	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 200	com/google/android/gms/internal/zzw:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 338	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 340	java/io/FileOutputStream
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 341	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 344	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 4
    //   34: new 10	com/google/android/gms/internal/zzw$zza
    //   37: dup
    //   38: aload_1
    //   39: aload_2
    //   40: invokespecial 346	com/google/android/gms/internal/zzw$zza:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/zzb$zza;)V
    //   43: astore 5
    //   45: aload 5
    //   47: aload 4
    //   49: invokevirtual 349	com/google/android/gms/internal/zzw$zza:zza	(Ljava/io/OutputStream;)Z
    //   52: ifne +61 -> 113
    //   55: aload 4
    //   57: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   60: ldc_w 352
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_3
    //   70: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 229	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: new 64	java/io/IOException
    //   80: dup
    //   81: invokespecial 353	java/io/IOException:<init>	()V
    //   84: athrow
    //   85: astore_1
    //   86: aload_3
    //   87: invokevirtual 205	java/io/File:delete	()Z
    //   90: ifne +20 -> 110
    //   93: ldc_w 355
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 229	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload 4
    //   115: aload_2
    //   116: getfield 334	com/google/android/gms/internal/zzb$zza:data	[B
    //   119: invokevirtual 358	java/io/BufferedOutputStream:write	([B)V
    //   122: aload 4
    //   124: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   127: aload_0
    //   128: aload_1
    //   129: aload 5
    //   131: invokespecial 306	com/google/android/gms/internal/zzw:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzw$zza;)V
    //   134: goto -24 -> 110
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	zzw
    //   0	142	1	paramString	String
    //   0	142	2	paramzza	zzb.zza
    //   16	87	3	localFile	File
    //   32	91	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   43	87	5	localzza	zza
    // Exception table:
    //   from	to	target	type
    //   17	85	85	java/io/IOException
    //   113	134	85	java/io/IOException
    //   2	17	137	finally
    //   17	85	137	finally
    //   86	110	137	finally
    //   113	134	137	finally
  }
  
  public File zzf(String paramString)
  {
    return new File(this.zzax, zze(paramString));
  }
  
  static class zza
  {
    public String zza;
    public String zzaA;
    public long zzaz;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf;
    
    private zza() {}
    
    public zza(String paramString, zzb.zza paramzza)
    {
      this.zzaA = paramString;
      this.zzaz = paramzza.data.length;
      this.zza = paramzza.zza;
      this.zzb = paramzza.zzb;
      this.zzc = paramzza.zzc;
      this.zzd = paramzza.zzd;
      this.zze = paramzza.zze;
      this.zzf = paramzza.zzf;
    }
    
    public static zza zzf(InputStream paramInputStream)
      throws IOException
    {
      zza localzza = new zza();
      if (zzw.zzb(paramInputStream) != 538247942) {
        throw new IOException();
      }
      localzza.zzaA = zzw.zzd(paramInputStream);
      localzza.zza = zzw.zzd(paramInputStream);
      if (localzza.zza.equals("")) {
        localzza.zza = null;
      }
      localzza.zzb = zzw.zzc(paramInputStream);
      localzza.zzc = zzw.zzc(paramInputStream);
      localzza.zzd = zzw.zzc(paramInputStream);
      localzza.zze = zzw.zzc(paramInputStream);
      localzza.zzf = zzw.zze(paramInputStream);
      return localzza;
    }
    
    public boolean zza(OutputStream paramOutputStream)
    {
      try
      {
        zzw.zza(paramOutputStream, 538247942);
        zzw.zza(paramOutputStream, this.zzaA);
        if (this.zza == null) {}
        for (String str = "";; str = this.zza)
        {
          zzw.zza(paramOutputStream, str);
          zzw.zza(paramOutputStream, this.zzb);
          zzw.zza(paramOutputStream, this.zzc);
          zzw.zza(paramOutputStream, this.zzd);
          zzw.zza(paramOutputStream, this.zze);
          zzw.zza(this.zzf, paramOutputStream);
          paramOutputStream.flush();
          return true;
        }
        return false;
      }
      catch (IOException paramOutputStream)
      {
        zzt.zzb("%s", new Object[] { paramOutputStream.toString() });
      }
    }
    
    public zzb.zza zzb(byte[] paramArrayOfByte)
    {
      zzb.zza localzza = new zzb.zza();
      localzza.data = paramArrayOfByte;
      localzza.zza = this.zza;
      localzza.zzb = this.zzb;
      localzza.zzc = this.zzc;
      localzza.zzd = this.zzd;
      localzza.zze = this.zze;
      localzza.zzf = this.zzf;
      return localzza;
    }
  }
  
  private static class zzb
    extends FilterInputStream
  {
    private int zzaB = 0;
    
    private zzb(InputStream paramInputStream)
    {
      super();
    }
    
    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        this.zzaB += 1;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.zzaB += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */