package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzf<T extends IInterface>
{
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final GoogleApiAvailabilityLight zzaMu;
  private int zzaRf;
  private long zzaRg;
  private long zzaRh;
  private int zzaRi;
  private long zzaRj;
  private final zzn zzaRk;
  private final Object zzaRl = new Object();
  private zzv zzaRm;
  protected zzf zzaRn;
  private T zzaRo;
  private final ArrayList<zze<?>> zzaRp = new ArrayList();
  private zzh zzaRq;
  private int zzaRr = 1;
  private final zzb zzaRs;
  private final zzc zzaRt;
  private final int zzaRu;
  private final String zzaRv;
  protected AtomicInteger zzaRw = new AtomicInteger(0);
  private final Looper zzrD;
  private final Object zzrU = new Object();
  
  protected zzf(Context paramContext, Looper paramLooper, int paramInt, zzb paramzzb, zzc paramzzc, String paramString)
  {
    this(paramContext, paramLooper, zzn.zzbb(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, (zzb)zzac.zzC(paramzzb), (zzc)zzac.zzC(paramzzc), paramString);
  }
  
  protected zzf(Context paramContext, Looper paramLooper, zzn paramzzn, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, zzb paramzzb, zzc paramzzc, String paramString)
  {
    this.mContext = ((Context)zzac.zzb(paramContext, "Context must not be null"));
    this.zzrD = ((Looper)zzac.zzb(paramLooper, "Looper must not be null"));
    this.zzaRk = ((zzn)zzac.zzb(paramzzn, "Supervisor must not be null"));
    this.zzaMu = ((GoogleApiAvailabilityLight)zzac.zzb(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.mHandler = new zzd(paramLooper);
    this.zzaRu = paramInt;
    this.zzaRs = paramzzb;
    this.zzaRt = paramzzc;
    this.zzaRv = paramString;
  }
  
  private void zza(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label116;
      }
      j = 1;
      label17:
      if (i != j) {
        break label122;
      }
    }
    for (;;)
    {
      zzac.zzaw(bool);
      for (;;)
      {
        synchronized (this.zzrU)
        {
          this.zzaRr = paramInt;
          this.zzaRo = paramT;
          switch (paramInt)
          {
          case 2: 
            return;
            zzzq();
          }
        }
        zza(paramT);
        continue;
        zzzr();
      }
      i = 0;
      break;
      label116:
      j = 0;
      break label17;
      label122:
      bool = false;
    }
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.zzrU)
    {
      if (this.zzaRr != paramInt1) {
        return false;
      }
      zza(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzzq()
  {
    String str1;
    String str2;
    if (this.zzaRq != null)
    {
      str1 = String.valueOf(zzeJ());
      str2 = String.valueOf(zzzo());
      Log.e("GmsClient", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "Calling connect() while still connected, missing disconnect() for " + str1 + " on " + str2);
      this.zzaRk.zzb(zzeJ(), zzzo(), this.zzaRq, zzzp());
      this.zzaRw.incrementAndGet();
    }
    this.zzaRq = new zzh(this.zzaRw.get());
    if (!this.zzaRk.zza(zzeJ(), zzzo(), this.zzaRq, zzzp()))
    {
      str1 = String.valueOf(zzeJ());
      str2 = String.valueOf(zzzo());
      Log.e("GmsClient", String.valueOf(str1).length() + 34 + String.valueOf(str2).length() + "unable to connect to service: " + str1 + " on " + str2);
      zza(16, null, this.zzaRw.get());
    }
  }
  
  private void zzzr()
  {
    if (this.zzaRq != null)
    {
      this.zzaRk.zzb(zzeJ(), zzzo(), this.zzaRq, zzzp());
      this.zzaRq = null;
    }
  }
  
  public void disconnect()
  {
    this.zzaRw.incrementAndGet();
    synchronized (this.zzaRp)
    {
      int j = this.zzaRp.size();
      int i = 0;
      while (i < j)
      {
        ((zze)this.zzaRp.get(i)).zzzC();
        i += 1;
      }
      this.zzaRp.clear();
    }
    synchronized (this.zzaRl)
    {
      this.zzaRm = null;
      zza(1, null);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg4)
  {
    int i;
    synchronized (this.zzrU)
    {
      i = this.zzaRr;
      paramFileDescriptor = this.zzaRo;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.zzaRl)
      {
        localObject = this.zzaRm;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramFileDescriptor != null) {
            break label529;
          }
          paramPrintWriter.append("null");
          paramPrintWriter.append(" mServiceBroker=");
          if (localObject != null) {
            break label562;
          }
          paramPrintWriter.println("null");
          paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          if (this.zzaRh > 0L)
          {
            ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.zzaRh;
            localObject = String.valueOf(paramFileDescriptor.format(new Date(this.zzaRh)));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
          }
          if (this.zzaRg > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.zzaRf)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.zzaRf));
            ??? = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.zzaRg;
            localObject = String.valueOf(paramFileDescriptor.format(new Date(this.zzaRg)));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
            if (this.zzaRj > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzaRi));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.zzaRj;
              paramFileDescriptor = String.valueOf(paramFileDescriptor.format(new Date(this.zzaRj)));
              paramString.println(String.valueOf(paramFileDescriptor).length() + 21 + l + " " + paramFileDescriptor);
            }
            return;
            paramString = finally;
            throw paramString;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label529:
      paramPrintWriter.append(zzeK()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
      continue;
      label562:
      paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((zzv)localObject).asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zzrD;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if (this.zzaRr == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if (this.zzaRr == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  @CallSuper
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzaRi = paramConnectionResult.getErrorCode();
    this.zzaRj = System.currentTimeMillis();
  }
  
  @CallSuper
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzaRf = paramInt;
    this.zzaRg = System.currentTimeMillis();
  }
  
  protected void zza(int paramInt1, @Nullable Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new zzk(paramInt1, paramBundle)));
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzj(paramInt1, paramIBinder, paramBundle)));
  }
  
  @CallSuper
  protected void zza(@NonNull T paramT)
  {
    this.zzaRh = System.currentTimeMillis();
  }
  
  @Deprecated
  public final void zza(zze<?> paramzze)
  {
    synchronized (this.zzaRp)
    {
      this.zzaRp.add(paramzze);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.zzaRw.get(), -1, paramzze));
      return;
    }
  }
  
  public void zza(@NonNull zzf paramzzf)
  {
    this.zzaRn = ((zzf)zzac.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }
  
  public void zza(@NonNull zzf paramzzf, int paramInt, @Nullable PendingIntent paramPendingIntent)
  {
    this.zzaRn = ((zzf)zzac.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzaRw.get(), paramInt, paramPendingIntent));
  }
  
  /* Error */
  @android.support.annotation.WorkerThread
  public void zza(zzr arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 470	com/google/android/gms/common/internal/zzf:zzql	()Landroid/os/Bundle;
    //   4: astore_3
    //   5: new 472	com/google/android/gms/common/internal/zzj
    //   8: dup
    //   9: aload_0
    //   10: getfield 166	com/google/android/gms/common/internal/zzf:zzaRu	I
    //   13: invokespecial 473	com/google/android/gms/common/internal/zzj:<init>	(I)V
    //   16: aload_0
    //   17: getfield 145	com/google/android/gms/common/internal/zzf:mContext	Landroid/content/Context;
    //   20: invokevirtual 476	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 480	com/google/android/gms/common/internal/zzj:zzcX	(Ljava/lang/String;)Lcom/google/android/gms/common/internal/zzj;
    //   26: aload_3
    //   27: invokevirtual 484	com/google/android/gms/common/internal/zzj:zzv	(Landroid/os/Bundle;)Lcom/google/android/gms/common/internal/zzj;
    //   30: astore_3
    //   31: aload_2
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 487	com/google/android/gms/common/internal/zzj:zzf	(Ljava/util/Collection;)Lcom/google/android/gms/common/internal/zzj;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 490	com/google/android/gms/common/internal/zzf:zzqB	()Z
    //   45: ifeq +67 -> 112
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 493	com/google/android/gms/common/internal/zzf:zzzu	()Landroid/accounts/Account;
    //   53: invokevirtual 496	com/google/android/gms/common/internal/zzj:zzd	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/zzj;
    //   56: aload_1
    //   57: invokevirtual 499	com/google/android/gms/common/internal/zzj:zzb	(Lcom/google/android/gms/common/internal/zzr;)Lcom/google/android/gms/common/internal/zzj;
    //   60: pop
    //   61: aload_3
    //   62: aload_0
    //   63: invokevirtual 503	com/google/android/gms/common/internal/zzf:zzzt	()[Lcom/google/android/gms/common/zzc;
    //   66: invokevirtual 506	com/google/android/gms/common/internal/zzj:zza	([Lcom/google/android/gms/common/zzc;)Lcom/google/android/gms/common/internal/zzj;
    //   69: pop
    //   70: aload_0
    //   71: getfield 122	com/google/android/gms/common/internal/zzf:zzaRl	Ljava/lang/Object;
    //   74: astore_1
    //   75: aload_1
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 175	com/google/android/gms/common/internal/zzf:zzaRm	Lcom/google/android/gms/common/internal/zzv;
    //   81: ifnull +50 -> 131
    //   84: aload_0
    //   85: getfield 175	com/google/android/gms/common/internal/zzf:zzaRm	Lcom/google/android/gms/common/internal/zzv;
    //   88: new 25	com/google/android/gms/common/internal/zzf$zzg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 136	com/google/android/gms/common/internal/zzf:zzaRw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: invokevirtual 256	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   100: invokespecial 507	com/google/android/gms/common/internal/zzf$zzg:<init>	(Lcom/google/android/gms/common/internal/zzf;I)V
    //   103: aload_3
    //   104: invokeinterface 510 3 0
    //   109: aload_1
    //   110: monitorexit
    //   111: return
    //   112: aload_0
    //   113: invokevirtual 513	com/google/android/gms/common/internal/zzf:zzzx	()Z
    //   116: ifeq -55 -> 61
    //   119: aload_3
    //   120: aload_0
    //   121: invokevirtual 515	com/google/android/gms/common/internal/zzf:getAccount	()Landroid/accounts/Account;
    //   124: invokevirtual 496	com/google/android/gms/common/internal/zzj:zzd	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/zzj;
    //   127: pop
    //   128: goto -67 -> 61
    //   131: ldc -36
    //   133: ldc_w 517
    //   136: invokestatic 520	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: goto -31 -> 109
    //   143: astore_2
    //   144: aload_1
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: astore_1
    //   149: ldc -36
    //   151: ldc_w 522
    //   154: aload_1
    //   155: invokestatic 525	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: aload_0
    //   160: iconst_1
    //   161: invokevirtual 528	com/google/android/gms/common/internal/zzf:zzfW	(I)V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: ldc -36
    //   171: ldc_w 522
    //   174: aload_1
    //   175: invokestatic 525	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   178: pop
    //   179: aload_0
    //   180: bipush 8
    //   182: aconst_null
    //   183: aconst_null
    //   184: aload_0
    //   185: getfield 136	com/google/android/gms/common/internal/zzf:zzaRw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   188: invokevirtual 256	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   191: invokevirtual 530	com/google/android/gms/common/internal/zzf:zza	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
    //   194: return
    //   195: astore_1
    //   196: goto -27 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	zzf
    //   0	199	2	paramSet	Set<Scope>
    //   4	116	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	109	143	finally
    //   109	111	143	finally
    //   131	140	143	finally
    //   144	146	143	finally
    //   70	77	148	android/os/DeadObjectException
    //   146	148	148	android/os/DeadObjectException
    //   70	77	165	java/lang/SecurityException
    //   146	148	165	java/lang/SecurityException
    //   70	77	168	android/os/RemoteException
    //   146	148	168	android/os/RemoteException
    //   70	77	195	java/lang/RuntimeException
    //   146	148	195	java/lang/RuntimeException
  }
  
  @NonNull
  protected abstract String zzeJ();
  
  @NonNull
  protected abstract String zzeK();
  
  public void zzfW(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzaRw.get(), paramInt));
  }
  
  @Nullable
  protected abstract T zzh(IBinder paramIBinder);
  
  public boolean zzqB()
  {
    return false;
  }
  
  public boolean zzqP()
  {
    return false;
  }
  
  public Intent zzqQ()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected Bundle zzql()
  {
    return new Bundle();
  }
  
  public boolean zzwT()
  {
    return true;
  }
  
  @Nullable
  public IBinder zzwU()
  {
    synchronized (this.zzaRl)
    {
      if (this.zzaRm == null) {
        return null;
      }
      IBinder localIBinder = this.zzaRm.asBinder();
      return localIBinder;
    }
  }
  
  public Bundle zzwi()
  {
    return null;
  }
  
  protected String zzzo()
  {
    return "com.google.android.gms";
  }
  
  @Nullable
  protected final String zzzp()
  {
    if (this.zzaRv == null) {
      return this.mContext.getClass().getName();
    }
    return this.zzaRv;
  }
  
  public void zzzs()
  {
    int i = this.zzaMu.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      zza(1, null);
      zza(new zzi(), i, null);
      return;
    }
    zza(new zzi());
  }
  
  public zzc[] zzzt()
  {
    return new zzc[0];
  }
  
  public final Account zzzu()
  {
    if (getAccount() != null) {
      return getAccount();
    }
    return new Account("<<default account>>", "com.google");
  }
  
  protected final void zzzv()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzzw()
    throws DeadObjectException
  {
    synchronized (this.zzrU)
    {
      if (this.zzaRr == 4) {
        throw new DeadObjectException();
      }
    }
    zzzv();
    if (this.zzaRo != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = this.zzaRo;
      return localIInterface;
    }
  }
  
  public boolean zzzx()
  {
    return false;
  }
  
  protected Set<Scope> zzzy()
  {
    return Collections.EMPTY_SET;
  }
  
  private abstract class zza
    extends zzf.zze<Boolean>
  {
    public final int statusCode;
    public final Bundle zzaRx;
    
    @BinderThread
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.zzaRx = paramBundle;
    }
    
    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        zzf.zza(zzf.this, 1, null);
      }
      do
      {
        return;
        switch (this.statusCode)
        {
        default: 
          zzf.zza(zzf.this, 1, null);
          paramBoolean = (Boolean)localObject;
          if (this.zzaRx != null) {
            paramBoolean = (PendingIntent)this.zzaRx.getParcelable("pendingIntent");
          }
          zzm(new ConnectionResult(this.statusCode, paramBoolean));
          return;
        }
      } while (zzzz());
      zzf.zza(zzf.this, 1, null);
      zzm(new ConnectionResult(8, null));
      return;
      zzf.zza(zzf.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void zzm(ConnectionResult paramConnectionResult);
    
    protected void zzzA() {}
    
    protected abstract boolean zzzz();
  }
  
  public static abstract interface zzb
  {
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface zzc
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
  
  final class zzd
    extends Handler
  {
    public zzd(Looper paramLooper)
    {
      super();
    }
    
    private void zza(Message paramMessage)
    {
      paramMessage = (zzf.zze)paramMessage.obj;
      paramMessage.zzzA();
      paramMessage.unregister();
    }
    
    private boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5);
    }
    
    public void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      if (zzf.this.zzaRw.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!zzf.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        if ((paramMessage.obj instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)paramMessage.obj;
        }
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        zzf.this.zzaRn.zzg(paramMessage);
        zzf.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 4)
      {
        zzf.zza(zzf.this, 4, null);
        if (zzf.zzb(zzf.this) != null) {
          zzf.zzb(zzf.this).onConnectionSuspended(paramMessage.arg2);
        }
        zzf.this.onConnectionSuspended(paramMessage.arg2);
        zzf.zza(zzf.this, 4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!zzf.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzf.zze)paramMessage.obj).zzzB();
        return;
      }
      int i = paramMessage.what;
      Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
    }
  }
  
  protected abstract class zze<TListener>
  {
    private TListener mListener;
    private boolean zzaRz;
    
    public zze()
    {
      Object localObject;
      this.mListener = localObject;
      this.zzaRz = false;
    }
    
    public void unregister()
    {
      zzzC();
      synchronized (zzf.zzc(zzf.this))
      {
        zzf.zzc(zzf.this).remove(this);
        return;
      }
    }
    
    protected abstract void zzA(TListener paramTListener);
    
    protected abstract void zzzA();
    
    public void zzzB()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = this.mListener;
          if (this.zzaRz)
          {
            String str = String.valueOf(this);
            Log.w("GmsClient", String.valueOf(str).length() + 47 + "Callback proxy " + str + " being reused. This is not safe.");
          }
          if (localObject1 != null) {}
          zzzA();
        }
        finally
        {
          try
          {
            zzA(localObject1);
          }
          catch (RuntimeException localRuntimeException)
          {
            zzzA();
            throw localRuntimeException;
          }
          try
          {
            this.zzaRz = true;
            unregister();
            return;
          }
          finally {}
          localObject2 = finally;
        }
      }
    }
    
    public void zzzC()
    {
      try
      {
        this.mListener = null;
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface zzf
  {
    public abstract void zzg(@NonNull ConnectionResult paramConnectionResult);
  }
  
  public static final class zzg
    extends zzu.zza
  {
    private zzf zzaRA;
    private final int zzaRB;
    
    public zzg(@NonNull zzf paramzzf, int paramInt)
    {
      this.zzaRA = paramzzf;
      this.zzaRB = paramInt;
    }
    
    private void zzzD()
    {
      this.zzaRA = null;
    }
    
    @BinderThread
    public void zza(int paramInt, @Nullable Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
    
    @BinderThread
    public void zza(int paramInt, @NonNull IBinder paramIBinder, @Nullable Bundle paramBundle)
    {
      zzac.zzb(this.zzaRA, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzaRA.zza(paramInt, paramIBinder, paramBundle, this.zzaRB);
      zzzD();
    }
  }
  
  public final class zzh
    implements ServiceConnection
  {
    private final int zzaRB;
    
    public zzh(int paramInt)
    {
      this.zzaRB = paramInt;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        zzf.this.zza(8, null, this.zzaRB);
        return;
      }
      synchronized (zzf.zza(zzf.this))
      {
        zzf.zza(zzf.this, zzv.zza.zzdh(paramIBinder));
        zzf.this.zza(0, null, this.zzaRB);
        return;
      }
    }
    
    public void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (zzf.zza(zzf.this))
      {
        zzf.zza(zzf.this, null);
        zzf.this.mHandler.sendMessage(zzf.this.mHandler.obtainMessage(4, this.zzaRB, 1));
        return;
      }
    }
  }
  
  protected class zzi
    implements zzf.zzf
  {
    public zzi() {}
    
    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zzf.this.zza(null, zzf.this.zzzy());
      }
      while (zzf.zzd(zzf.this) == null) {
        return;
      }
      zzf.zzd(zzf.this).onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class zzj
    extends zzf.zza
  {
    public final IBinder zzaRC;
    
    @BinderThread
    public zzj(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.zzaRC = paramIBinder;
    }
    
    protected void zzm(ConnectionResult paramConnectionResult)
    {
      if (zzf.zzd(zzf.this) != null) {
        zzf.zzd(zzf.this).onConnectionFailed(paramConnectionResult);
      }
      zzf.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzzz()
    {
      do
      {
        try
        {
          String str1 = this.zzaRC.getInterfaceDescriptor();
          if (!zzf.this.zzeK().equals(str1))
          {
            String str2 = String.valueOf(zzf.this.zzeK());
            Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zzf.this.zzh(this.zzaRC);
      } while ((localObject == null) || (!zzf.zza(zzf.this, 2, 3, (IInterface)localObject)));
      Object localObject = zzf.this.zzwi();
      if (zzf.zzb(zzf.this) != null) {
        zzf.zzb(zzf.this).onConnected((Bundle)localObject);
      }
      return true;
    }
  }
  
  protected final class zzk
    extends zzf.zza
  {
    @BinderThread
    public zzk(int paramInt, @Nullable Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected void zzm(ConnectionResult paramConnectionResult)
    {
      zzf.this.zzaRn.zzg(paramConnectionResult);
      zzf.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzzz()
    {
      zzf.this.zzaRn.zzg(ConnectionResult.zzaJO);
      return true;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */