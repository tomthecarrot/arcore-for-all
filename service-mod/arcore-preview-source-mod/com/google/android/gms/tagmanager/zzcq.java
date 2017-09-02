package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzcq
  extends zzcp
{
  private static zzcq zzcwC;
  private static final Object zzcwq = new Object();
  private boolean connected = true;
  private zzbi zzcwA;
  private boolean zzcwB = false;
  private Context zzcwr;
  private zzap zzcws;
  private volatile zzan zzcwt;
  private int zzcwu = 1800000;
  private boolean zzcwv = true;
  private boolean zzcww = false;
  private boolean zzcwx = true;
  private zzaq zzcwy = new zzaq()
  {
    public void zzby(boolean paramAnonymousBoolean)
    {
      zzcq.this.zzg(paramAnonymousBoolean, zzcq.zzd(zzcq.this));
    }
  };
  private zza zzcwz;
  
  private boolean isPowerSaveMode()
  {
    return (this.zzcwB) || (!this.connected) || (this.zzcwu <= 0);
  }
  
  public static zzcq zzYs()
  {
    if (zzcwC == null) {
      zzcwC = new zzcq();
    }
    return zzcwC;
  }
  
  private void zzYt()
  {
    this.zzcwA = new zzbi(this);
    this.zzcwA.zzck(this.zzcwr);
  }
  
  private void zzYu()
  {
    this.zzcwz = new zzb(null);
    if (this.zzcwu > 0) {
      this.zzcwz.zzC(this.zzcwu);
    }
  }
  
  private void zzog()
  {
    if (isPowerSaveMode())
    {
      this.zzcwz.cancel();
      Log.v("PowerSaveMode initiated.");
      return;
    }
    this.zzcwz.zzC(this.zzcwu);
    Log.v("PowerSaveMode terminated.");
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/google/android/gms/tagmanager/zzcq:zzcww	Z
    //   6: ifne +16 -> 22
    //   9: ldc -126
    //   11: invokestatic 125	com/google/android/gms/tagmanager/Log:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 56	com/google/android/gms/tagmanager/zzcq:zzcwv	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 132	com/google/android/gms/tagmanager/zzcq:zzcwt	Lcom/google/android/gms/tagmanager/zzan;
    //   26: new 8	com/google/android/gms/tagmanager/zzcq$2
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 133	com/google/android/gms/tagmanager/zzcq$2:<init>	(Lcom/google/android/gms/tagmanager/zzcq;)V
    //   34: invokeinterface 139 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	zzcq
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  zzap zzYv()
  {
    try
    {
      if (this.zzcws != null) {
        break label50;
      }
      if (this.zzcwr == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.zzcws = new zzbv(this.zzcwy, this.zzcwr);
    label50:
    if (this.zzcwz == null) {
      zzYu();
    }
    this.zzcww = true;
    if (this.zzcwv)
    {
      dispatch();
      this.zzcwv = false;
    }
    if ((this.zzcwA == null) && (this.zzcwx)) {
      zzYt();
    }
    zzap localzzap = this.zzcws;
    return localzzap;
  }
  
  /* Error */
  void zza(Context paramContext, zzan paramzzan)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/google/android/gms/tagmanager/zzcq:zzcwr	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 165	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 86	com/google/android/gms/tagmanager/zzcq:zzcwr	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 132	com/google/android/gms/tagmanager/zzcq:zzcwt	Lcom/google/android/gms/tagmanager/zzan;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 132	com/google/android/gms/tagmanager/zzcq:zzcwt	Lcom/google/android/gms/tagmanager/zzan;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzcq
    //   0	42	1	paramContext	Context
    //   0	42	2	paramzzan	zzan
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  public void zzbz(boolean paramBoolean)
  {
    try
    {
      zzg(this.zzcwB, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void zzg(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 106	com/google/android/gms/tagmanager/zzcq:isPowerSaveMode	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 69	com/google/android/gms/tagmanager/zzcq:zzcwB	Z
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 60	com/google/android/gms/tagmanager/zzcq:connected	Z
    //   17: aload_0
    //   18: invokespecial 106	com/google/android/gms/tagmanager/zzcq:isPowerSaveMode	()Z
    //   21: istore_1
    //   22: iload_1
    //   23: iload_3
    //   24: if_icmpne +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokespecial 173	com/google/android/gms/tagmanager/zzcq:zzog	()V
    //   34: goto -7 -> 27
    //   37: astore 4
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	zzcq
    //   0	44	1	paramBoolean1	boolean
    //   0	44	2	paramBoolean2	boolean
    //   6	19	3	bool	boolean
    //   37	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	37	finally
    //   30	34	37	finally
  }
  
  public void zznn()
  {
    try
    {
      if (!isPowerSaveMode()) {
        this.zzcwz.zzYx();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface zza
  {
    public abstract void cancel();
    
    public abstract void zzC(long paramLong);
    
    public abstract void zzYx();
  }
  
  private class zzb
    implements zzcq.zza
  {
    private Handler handler = new Handler(zzcq.zza(zzcq.this).getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (zzcq.zzYw().equals(paramAnonymousMessage.obj)))
        {
          zzcq.this.dispatch();
          if (!zzcq.zzb(zzcq.this)) {
            zzcq.zzb.this.zzC(zzcq.zzc(zzcq.this));
          }
        }
        return true;
      }
    });
    
    private zzb() {}
    
    private Message obtainMessage()
    {
      return this.handler.obtainMessage(1, zzcq.zzYw());
    }
    
    public void cancel()
    {
      this.handler.removeMessages(1, zzcq.zzYw());
    }
    
    public void zzC(long paramLong)
    {
      this.handler.removeMessages(1, zzcq.zzYw());
      this.handler.sendMessageDelayed(obtainMessage(), paramLong);
    }
    
    public void zzYx()
    {
      this.handler.removeMessages(1, zzcq.zzYw());
      this.handler.sendMessage(obtainMessage());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */