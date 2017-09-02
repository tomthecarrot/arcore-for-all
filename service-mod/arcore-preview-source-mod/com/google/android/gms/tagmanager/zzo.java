package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;

class zzo
  implements ContainerHolder
{
  private Status zzaiT;
  private boolean zzavM;
  private Container zzctn;
  private Container zzcto;
  private zzb zzctp;
  private zza zzctq;
  private TagManager zzctr;
  private final Looper zzrD;
  
  public zzo(Status paramStatus)
  {
    this.zzaiT = paramStatus;
    this.zzrD = null;
  }
  
  public zzo(TagManager paramTagManager, Looper paramLooper, Container paramContainer, zza paramzza)
  {
    this.zzctr = paramTagManager;
    if (paramLooper != null) {}
    for (;;)
    {
      this.zzrD = paramLooper;
      this.zzctn = paramContainer;
      this.zzctq = paramzza;
      this.zzaiT = Status.zzaLc;
      paramTagManager.zza(this);
      return;
      paramLooper = Looper.getMainLooper();
    }
  }
  
  private void zzXl()
  {
    if (this.zzctp != null) {
      this.zzctp.zzjE(this.zzcto.zzXi());
    }
  }
  
  /* Error */
  public Container getContainer()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 79	com/google/android/gms/tagmanager/zzo:zzavM	Z
    //   8: ifeq +12 -> 20
    //   11: ldc 81
    //   13: invokestatic 86	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 65	com/google/android/gms/tagmanager/zzo:zzcto	Lcom/google/android/gms/tagmanager/Container;
    //   24: ifnull +16 -> 40
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 65	com/google/android/gms/tagmanager/zzo:zzcto	Lcom/google/android/gms/tagmanager/Container;
    //   32: putfield 42	com/google/android/gms/tagmanager/zzo:zzctn	Lcom/google/android/gms/tagmanager/Container;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 65	com/google/android/gms/tagmanager/zzo:zzcto	Lcom/google/android/gms/tagmanager/Container;
    //   40: aload_0
    //   41: getfield 42	com/google/android/gms/tagmanager/zzo:zzctn	Lcom/google/android/gms/tagmanager/Container;
    //   44: astore_1
    //   45: goto -29 -> 16
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	zzo
    //   1	44	1	localContainer	Container
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	48	finally
    //   20	40	48	finally
    //   40	45	48	finally
  }
  
  String getContainerId()
  {
    if (this.zzavM)
    {
      Log.e("getContainerId called on a released ContainerHolder.");
      return "";
    }
    return this.zzctn.getContainerId();
  }
  
  public Status getStatus()
  {
    return this.zzaiT;
  }
  
  /* Error */
  public void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/google/android/gms/tagmanager/zzo:zzavM	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 98
    //   11: invokestatic 86	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 44	com/google/android/gms/tagmanager/zzo:zzctq	Lcom/google/android/gms/tagmanager/zzo$zza;
    //   21: invokeinterface 101 1 0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	zzo
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/google/android/gms/tagmanager/zzo:zzavM	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 104
    //   11: invokestatic 86	com/google/android/gms/tagmanager/Log:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 79	com/google/android/gms/tagmanager/zzo:zzavM	Z
    //   22: aload_0
    //   23: getfield 40	com/google/android/gms/tagmanager/zzo:zzctr	Lcom/google/android/gms/tagmanager/TagManager;
    //   26: aload_0
    //   27: invokevirtual 107	com/google/android/gms/tagmanager/TagManager:zzb	(Lcom/google/android/gms/tagmanager/zzo;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 42	com/google/android/gms/tagmanager/zzo:zzctn	Lcom/google/android/gms/tagmanager/Container;
    //   35: invokevirtual 109	com/google/android/gms/tagmanager/Container:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 42	com/google/android/gms/tagmanager/zzo:zzctn	Lcom/google/android/gms/tagmanager/Container;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 65	com/google/android/gms/tagmanager/zzo:zzcto	Lcom/google/android/gms/tagmanager/Container;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 44	com/google/android/gms/tagmanager/zzo:zzctq	Lcom/google/android/gms/tagmanager/zzo$zza;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 63	com/google/android/gms/tagmanager/zzo:zzctp	Lcom/google/android/gms/tagmanager/zzo$zzb;
    //   58: goto -44 -> 14
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	zzo
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   17	58	61	finally
  }
  
  public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener)
  {
    for (;;)
    {
      try
      {
        if (this.zzavM)
        {
          Log.e("ContainerHolder is released.");
          return;
        }
        if (paramContainerAvailableListener == null)
        {
          this.zzctp = null;
          continue;
        }
        this.zzctp = new zzb(paramContainerAvailableListener, this.zzrD);
      }
      finally {}
      if (this.zzcto != null) {
        zzXl();
      }
    }
  }
  
  String zzXk()
  {
    if (this.zzavM)
    {
      Log.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return "";
    }
    return this.zzctq.zzXk();
  }
  
  public void zza(Container paramContainer)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.zzavM;
        if (bool) {
          return;
        }
        if (paramContainer == null)
        {
          Log.e("Unexpected null container.");
          continue;
        }
        this.zzcto = paramContainer;
      }
      finally {}
      zzXl();
    }
  }
  
  /* Error */
  public void zzjB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/google/android/gms/tagmanager/zzo:zzavM	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 42	com/google/android/gms/tagmanager/zzo:zzctn	Lcom/google/android/gms/tagmanager/Container;
    //   18: aload_1
    //   19: invokevirtual 127	com/google/android/gms/tagmanager/Container:zzjB	(Ljava/lang/String;)V
    //   22: goto -11 -> 11
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	zzo
    //   0	30	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  void zzjD(String paramString)
  {
    if (this.zzavM)
    {
      Log.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return;
    }
    this.zzctq.zzjD(paramString);
  }
  
  public static abstract interface zza
  {
    public abstract String zzXk();
    
    public abstract void zzXm();
    
    public abstract void zzjD(String paramString);
  }
  
  private class zzb
    extends Handler
  {
    private final ContainerHolder.ContainerAvailableListener zzcts;
    
    public zzb(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener, Looper paramLooper)
    {
      super();
      this.zzcts = paramContainerAvailableListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("Don't know how to handle this message.");
        return;
      }
      zzjF((String)paramMessage.obj);
    }
    
    public void zzjE(String paramString)
    {
      sendMessage(obtainMessage(1, paramString));
    }
    
    protected void zzjF(String paramString)
    {
      this.zzcts.onContainerAvailable(zzo.this, paramString);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */