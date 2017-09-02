package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class zzn
  extends zzd
{
  private volatile String zzacQ;
  private Future<String> zzaeB;
  
  protected zzn(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private String zzos()
  {
    String str2 = zzot();
    String str1 = str2;
    try
    {
      if (!zzx(zznt().getContext(), str2)) {
        str1 = "0";
      }
      return str1;
    }
    catch (Exception localException)
    {
      zze("Error saving clientId file", localException);
    }
    return "0";
  }
  
  private boolean zzx(Context paramContext, String paramString)
  {
    boolean bool = false;
    zzac.zzdc(paramString);
    zzac.zzcV("ClientId should be saved from worker thread");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    Object localObject1 = localObject6;
    for (;;)
    {
      try
      {
        zza("Storing clientId", paramString);
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        paramContext = paramContext.openFileOutput("gaClientId", 0);
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        paramContext.write(paramString.getBytes());
      }
      catch (FileNotFoundException paramContext)
      {
        localObject1 = localObject2;
        zze("Error creating clientId file", paramContext);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          return false;
        }
        catch (IOException paramContext)
        {
          zze("Failed to close clientId writing stream", paramContext);
          return false;
        }
      }
      catch (IOException paramContext)
      {
        localObject1 = localObject3;
        zze("Error writing to clientId file", paramContext);
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject3).close();
          return false;
        }
        catch (IOException paramContext)
        {
          zze("Failed to close clientId writing stream", paramContext);
          return false;
        }
      }
      finally
      {
        if (localObject1 == null) {
          break label179;
        }
      }
      try
      {
        paramContext.close();
        bool = true;
        return bool;
      }
      catch (IOException paramContext)
      {
        zze("Failed to close clientId writing stream", paramContext);
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label179:
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        zze("Failed to close clientId writing stream", paramString);
      }
    }
  }
  
  protected void onInitialize() {}
  
  /* Error */
  protected String zzat(Context paramContext)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 67	com/google/android/gms/common/internal/zzac:zzcV	(Ljava/lang/String;)V
    //   5: aload_1
    //   6: ldc 73
    //   8: invokevirtual 110	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_3
    //   12: aload_3
    //   13: astore 4
    //   15: bipush 36
    //   17: newarray <illegal type>
    //   19: astore 5
    //   21: aload_3
    //   22: astore 4
    //   24: aload_3
    //   25: aload 5
    //   27: iconst_0
    //   28: bipush 36
    //   30: invokevirtual 116	java/io/FileInputStream:read	([BII)I
    //   33: istore_2
    //   34: aload_3
    //   35: astore 4
    //   37: aload_3
    //   38: invokevirtual 120	java/io/FileInputStream:available	()I
    //   41: ifle +49 -> 90
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: ldc 122
    //   50: invokevirtual 125	com/google/android/gms/analytics/internal/zzn:zzbu	(Ljava/lang/String;)V
    //   53: aload_3
    //   54: astore 4
    //   56: aload_3
    //   57: invokevirtual 126	java/io/FileInputStream:close	()V
    //   60: aload_3
    //   61: astore 4
    //   63: aload_1
    //   64: ldc 73
    //   66: invokevirtual 130	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   69: pop
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 126	java/io/FileInputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aload_0
    //   82: ldc -124
    //   84: aload_1
    //   85: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aconst_null
    //   89: areturn
    //   90: iload_2
    //   91: bipush 14
    //   93: if_icmpge +49 -> 142
    //   96: aload_3
    //   97: astore 4
    //   99: aload_0
    //   100: ldc -122
    //   102: invokevirtual 125	com/google/android/gms/analytics/internal/zzn:zzbu	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: astore 4
    //   108: aload_3
    //   109: invokevirtual 126	java/io/FileInputStream:close	()V
    //   112: aload_3
    //   113: astore 4
    //   115: aload_1
    //   116: ldc 73
    //   118: invokevirtual 130	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   121: pop
    //   122: aload_3
    //   123: ifnull -45 -> 78
    //   126: aload_3
    //   127: invokevirtual 126	java/io/FileInputStream:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: aload_0
    //   134: ldc -124
    //   136: aload_1
    //   137: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   140: aconst_null
    //   141: areturn
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: invokevirtual 126	java/io/FileInputStream:close	()V
    //   149: aload_3
    //   150: astore 4
    //   152: new 81	java/lang/String
    //   155: dup
    //   156: aload 5
    //   158: iconst_0
    //   159: iload_2
    //   160: invokespecial 137	java/lang/String:<init>	([BII)V
    //   163: astore 5
    //   165: aload_3
    //   166: astore 4
    //   168: aload_0
    //   169: ldc -117
    //   171: aload 5
    //   173: invokevirtual 71	com/google/android/gms/analytics/internal/zzn:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 126	java/io/FileInputStream:close	()V
    //   184: aload 5
    //   186: areturn
    //   187: astore_1
    //   188: aload_0
    //   189: ldc -124
    //   191: aload_1
    //   192: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   195: goto -11 -> 184
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull -124 -> 78
    //   205: aload_1
    //   206: invokevirtual 126	java/io/FileInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aload_0
    //   213: ldc -124
    //   215: aload_1
    //   216: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: astore 4
    //   228: aload_0
    //   229: ldc -115
    //   231: aload 5
    //   233: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   236: aload_3
    //   237: astore 4
    //   239: aload_1
    //   240: ldc 73
    //   242: invokevirtual 130	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   245: pop
    //   246: aload_3
    //   247: ifnull -169 -> 78
    //   250: aload_3
    //   251: invokevirtual 126	java/io/FileInputStream:close	()V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_1
    //   257: aload_0
    //   258: ldc -124
    //   260: aload_1
    //   261: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 4
    //   270: aload 4
    //   272: ifnull +8 -> 280
    //   275: aload 4
    //   277: invokevirtual 126	java/io/FileInputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_3
    //   283: aload_0
    //   284: ldc -124
    //   286: aload_3
    //   287: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   290: goto -10 -> 280
    //   293: astore_1
    //   294: goto -24 -> 270
    //   297: astore 5
    //   299: goto -74 -> 225
    //   302: astore_1
    //   303: aload_3
    //   304: astore_1
    //   305: goto -104 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	zzn
    //   0	308	1	paramContext	Context
    //   33	127	2	i	int
    //   11	240	3	localFileInputStream1	java.io.FileInputStream
    //   282	22	3	localIOException1	IOException
    //   13	263	4	localFileInputStream2	java.io.FileInputStream
    //   19	166	5	localObject	Object
    //   221	11	5	localIOException2	IOException
    //   297	1	5	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   126	130	132	java/io/IOException
    //   180	184	187	java/io/IOException
    //   5	12	198	java/io/FileNotFoundException
    //   205	209	211	java/io/IOException
    //   5	12	221	java/io/IOException
    //   250	254	256	java/io/IOException
    //   5	12	266	finally
    //   275	280	282	java/io/IOException
    //   15	21	293	finally
    //   24	34	293	finally
    //   37	44	293	finally
    //   47	53	293	finally
    //   56	60	293	finally
    //   63	70	293	finally
    //   99	105	293	finally
    //   108	112	293	finally
    //   115	122	293	finally
    //   145	149	293	finally
    //   152	165	293	finally
    //   168	176	293	finally
    //   228	236	293	finally
    //   239	246	293	finally
    //   15	21	297	java/io/IOException
    //   24	34	297	java/io/IOException
    //   37	44	297	java/io/IOException
    //   47	53	297	java/io/IOException
    //   56	60	297	java/io/IOException
    //   63	70	297	java/io/IOException
    //   99	105	297	java/io/IOException
    //   108	112	297	java/io/IOException
    //   115	122	297	java/io/IOException
    //   145	149	297	java/io/IOException
    //   152	165	297	java/io/IOException
    //   168	176	297	java/io/IOException
    //   15	21	302	java/io/FileNotFoundException
    //   24	34	302	java/io/FileNotFoundException
    //   37	44	302	java/io/FileNotFoundException
    //   47	53	302	java/io/FileNotFoundException
    //   56	60	302	java/io/FileNotFoundException
    //   63	70	302	java/io/FileNotFoundException
    //   99	105	302	java/io/FileNotFoundException
    //   108	112	302	java/io/FileNotFoundException
    //   115	122	302	java/io/FileNotFoundException
    //   145	149	302	java/io/FileNotFoundException
    //   152	165	302	java/io/FileNotFoundException
    //   168	176	302	java/io/FileNotFoundException
  }
  
  /* Error */
  public String zzop()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	com/google/android/gms/analytics/internal/zzn:zznA	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   10: ifnonnull +22 -> 32
    //   13: aload_0
    //   14: aload_0
    //   15: invokevirtual 33	com/google/android/gms/analytics/internal/zzn:zznt	()Lcom/google/android/gms/analytics/zzh;
    //   18: new 6	com/google/android/gms/analytics/internal/zzn$1
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 154	com/google/android/gms/analytics/internal/zzn$1:<init>	(Lcom/google/android/gms/analytics/internal/zzn;)V
    //   26: invokevirtual 158	com/google/android/gms/analytics/zzh:zzc	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   29: putfield 160	com/google/android/gms/analytics/internal/zzn:zzaeB	Ljava/util/concurrent/Future;
    //   32: aload_0
    //   33: getfield 160	com/google/android/gms/analytics/internal/zzn:zzaeB	Ljava/util/concurrent/Future;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +47 -> 85
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 160	com/google/android/gms/analytics/internal/zzn:zzaeB	Ljava/util/concurrent/Future;
    //   46: invokeinterface 166 1 0
    //   51: checkcast 81	java/lang/String
    //   54: putfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   57: aload_0
    //   58: getfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   61: ifnonnull +9 -> 70
    //   64: aload_0
    //   65: ldc 45
    //   67: putfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   70: aload_0
    //   71: ldc -88
    //   73: aload_0
    //   74: getfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   77: invokevirtual 71	com/google/android/gms/analytics/internal/zzn:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 160	com/google/android/gms/analytics/internal/zzn:zzaeB	Ljava/util/concurrent/Future;
    //   85: aload_0
    //   86: getfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: areturn
    //   94: astore_1
    //   95: aload_0
    //   96: ldc -86
    //   98: aload_1
    //   99: invokevirtual 173	com/google/android/gms/analytics/internal/zzn:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   102: aload_0
    //   103: ldc 45
    //   105: putfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   108: goto -51 -> 57
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: ldc -81
    //   120: aload_1
    //   121: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ldc 45
    //   127: putfield 151	com/google/android/gms/analytics/internal/zzn:zzacQ	Ljava/lang/String;
    //   130: goto -73 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	zzn
    //   36	57	1	localObject1	Object
    //   94	5	1	localInterruptedException	InterruptedException
    //   111	4	1	localObject2	Object
    //   116	5	1	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   41	57	94	java/lang/InterruptedException
    //   6	32	111	finally
    //   32	37	111	finally
    //   41	57	111	finally
    //   57	70	111	finally
    //   70	85	111	finally
    //   85	92	111	finally
    //   95	108	111	finally
    //   112	114	111	finally
    //   117	130	111	finally
    //   41	57	116	java/util/concurrent/ExecutionException
  }
  
  String zzoq()
  {
    try
    {
      this.zzacQ = null;
      this.zzaeB = zznt().zzc(new Callable()
      {
        public String zzcj()
          throws Exception
        {
          return zzn.zza(zzn.this);
        }
      });
      return zzop();
    }
    finally {}
  }
  
  String zzor()
  {
    String str2 = zzat(zznt().getContext());
    String str1 = str2;
    if (str2 == null) {
      str1 = zzos();
    }
    return str1;
  }
  
  protected String zzot()
  {
    return UUID.randomUUID().toString().toLowerCase();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */