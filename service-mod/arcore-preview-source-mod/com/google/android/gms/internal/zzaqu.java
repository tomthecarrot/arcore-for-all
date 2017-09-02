package com.google.android.gms.internal;

public class zzaqu
{
  private zzaqv zzbnq = null;
  private boolean zzus = false;
  
  /* Error */
  public void initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/google/android/gms/internal/zzaqu:zzus	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: aload_1
    //   14: getstatic 29	com/google/android/gms/dynamite/DynamiteModule:zzbiA	Lcom/google/android/gms/dynamite/DynamiteModule$zzb;
    //   17: ldc 31
    //   19: invokestatic 35	com/google/android/gms/dynamite/DynamiteModule:zza	(Landroid/content/Context;Lcom/google/android/gms/dynamite/DynamiteModule$zzb;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   22: ldc 37
    //   24: invokevirtual 41	com/google/android/gms/dynamite/DynamiteModule:zzdM	(Ljava/lang/String;)Landroid/os/IBinder;
    //   27: invokestatic 47	com/google/android/gms/internal/zzaqv$zza:asInterface	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzaqv;
    //   30: putfield 16	com/google/android/gms/internal/zzaqu:zzbnq	Lcom/google/android/gms/internal/zzaqv;
    //   33: aload_0
    //   34: getfield 16	com/google/android/gms/internal/zzaqu:zzbnq	Lcom/google/android/gms/internal/zzaqv;
    //   37: aload_1
    //   38: invokestatic 53	com/google/android/gms/dynamic/zzd:zzJ	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   41: invokeinterface 59 2 0
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 14	com/google/android/gms/internal/zzaqu:zzus	Z
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc 61
    //   62: ldc 63
    //   64: aload_1
    //   65: invokestatic 69	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: goto -18 -> 51
    //   72: astore_1
    //   73: goto -13 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zzaqu
    //   0	76	1	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   2	11	54	finally
    //   12	51	54	finally
    //   51	53	54	finally
    //   55	57	54	finally
    //   60	69	54	finally
    //   12	51	59	android/os/RemoteException
    //   12	51	72	com/google/android/gms/dynamite/DynamiteModule$zza
  }
  
  public <T> T zzb(zzaqs<T> paramzzaqs)
  {
    try
    {
      if (!this.zzus)
      {
        paramzzaqs = paramzzaqs.getDefault();
        return paramzzaqs;
      }
      return (T)paramzzaqs.zza(this.zzbnq);
    }
    finally {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */