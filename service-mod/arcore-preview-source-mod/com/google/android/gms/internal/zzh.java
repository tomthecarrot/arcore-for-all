package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class zzh
  extends Thread
{
  private final zzb zzi;
  private final zzo zzj;
  private volatile boolean zzk = false;
  private final BlockingQueue<zzl<?>> zzx;
  private final zzg zzy;
  
  public zzh(BlockingQueue<zzl<?>> paramBlockingQueue, zzg paramzzg, zzb paramzzb, zzo paramzzo)
  {
    this.zzx = paramBlockingQueue;
    this.zzy = paramzzg;
    this.zzi = paramzzb;
    this.zzj = paramzzo;
  }
  
  @TargetApi(14)
  private void zzb(zzl<?> paramzzl)
  {
    int i = Build.VERSION.SDK_INT;
    TrafficStats.setThreadStatsTag(paramzzl.zzf());
  }
  
  private void zzb(zzl<?> paramzzl, zzs paramzzs)
  {
    paramzzs = paramzzl.zzb(paramzzs);
    this.zzj.zza(paramzzl, paramzzs);
  }
  
  public void quit()
  {
    this.zzk = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 84	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/google/android/gms/internal/zzh:zzx	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 96 1 0
    //   18: checkcast 46	com/google/android/gms/internal/zzl
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 98
    //   25: invokevirtual 102	com/google/android/gms/internal/zzl:zzc	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial 104	com/google/android/gms/internal/zzh:zzb	(Lcom/google/android/gms/internal/zzl;)V
    //   33: aload_0
    //   34: getfield 26	com/google/android/gms/internal/zzh:zzy	Lcom/google/android/gms/internal/zzg;
    //   37: aload_3
    //   38: invokeinterface 109 2 0
    //   43: astore 4
    //   45: aload_3
    //   46: ldc 111
    //   48: invokevirtual 102	com/google/android/gms/internal/zzl:zzc	(Ljava/lang/String;)V
    //   51: aload 4
    //   53: getfield 116	com/google/android/gms/internal/zzj:zzz	Z
    //   56: ifeq +50 -> 106
    //   59: aload_3
    //   60: invokevirtual 120	com/google/android/gms/internal/zzl:zzs	()Z
    //   63: ifeq +43 -> 106
    //   66: aload_3
    //   67: ldc 122
    //   69: invokevirtual 125	com/google/android/gms/internal/zzl:zzd	(Ljava/lang/String;)V
    //   72: goto -67 -> 5
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
    //   82: lload_1
    //   83: lsub
    //   84: invokevirtual 128	com/google/android/gms/internal/zzs:zza	(J)V
    //   87: aload_0
    //   88: aload_3
    //   89: aload 4
    //   91: invokespecial 130	com/google/android/gms/internal/zzh:zzb	(Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   94: goto -89 -> 5
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 22	com/google/android/gms/internal/zzh:zzk	Z
    //   102: ifeq -97 -> 5
    //   105: return
    //   106: aload_3
    //   107: aload 4
    //   109: invokevirtual 133	com/google/android/gms/internal/zzl:zza	(Lcom/google/android/gms/internal/zzj;)Lcom/google/android/gms/internal/zzn;
    //   112: astore 4
    //   114: aload_3
    //   115: ldc -121
    //   117: invokevirtual 102	com/google/android/gms/internal/zzl:zzc	(Ljava/lang/String;)V
    //   120: aload_3
    //   121: invokevirtual 138	com/google/android/gms/internal/zzl:zzn	()Z
    //   124: ifeq +35 -> 159
    //   127: aload 4
    //   129: getfield 144	com/google/android/gms/internal/zzn:zzae	Lcom/google/android/gms/internal/zzb$zza;
    //   132: ifnull +27 -> 159
    //   135: aload_0
    //   136: getfield 28	com/google/android/gms/internal/zzh:zzi	Lcom/google/android/gms/internal/zzb;
    //   139: aload_3
    //   140: invokevirtual 148	com/google/android/gms/internal/zzl:zzg	()Ljava/lang/String;
    //   143: aload 4
    //   145: getfield 144	com/google/android/gms/internal/zzn:zzae	Lcom/google/android/gms/internal/zzb$zza;
    //   148: invokeinterface 153 3 0
    //   153: aload_3
    //   154: ldc -101
    //   156: invokevirtual 102	com/google/android/gms/internal/zzl:zzc	(Ljava/lang/String;)V
    //   159: aload_3
    //   160: invokevirtual 158	com/google/android/gms/internal/zzl:zzr	()V
    //   163: aload_0
    //   164: getfield 30	com/google/android/gms/internal/zzh:zzj	Lcom/google/android/gms/internal/zzo;
    //   167: aload_3
    //   168: aload 4
    //   170: invokeinterface 161 3 0
    //   175: goto -170 -> 5
    //   178: astore 4
    //   180: aload 4
    //   182: ldc -93
    //   184: iconst_1
    //   185: anewarray 165	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload 4
    //   192: invokevirtual 168	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 173	com/google/android/gms/internal/zzt:zza	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: new 77	com/google/android/gms/internal/zzs
    //   202: dup
    //   203: aload 4
    //   205: invokespecial 176	com/google/android/gms/internal/zzs:<init>	(Ljava/lang/Throwable;)V
    //   208: astore 4
    //   210: aload 4
    //   212: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
    //   215: lload_1
    //   216: lsub
    //   217: invokevirtual 128	com/google/android/gms/internal/zzs:zza	(J)V
    //   220: aload_0
    //   221: getfield 30	com/google/android/gms/internal/zzh:zzj	Lcom/google/android/gms/internal/zzo;
    //   224: aload_3
    //   225: aload 4
    //   227: invokeinterface 67 3 0
    //   232: goto -227 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	zzh
    //   8	208	1	l	long
    //   21	68	3	localzzl	zzl
    //   97	128	3	localInterruptedException	InterruptedException
    //   43	9	4	localzzj	zzj
    //   75	33	4	localzzs1	zzs
    //   112	57	4	localzzn	zzn
    //   178	26	4	localException	Exception
    //   208	18	4	localzzs2	zzs
    // Exception table:
    //   from	to	target	type
    //   22	72	75	com/google/android/gms/internal/zzs
    //   106	159	75	com/google/android/gms/internal/zzs
    //   159	175	75	com/google/android/gms/internal/zzs
    //   9	22	97	java/lang/InterruptedException
    //   22	72	178	java/lang/Exception
    //   106	159	178	java/lang/Exception
    //   159	175	178	java/lang/Exception
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */