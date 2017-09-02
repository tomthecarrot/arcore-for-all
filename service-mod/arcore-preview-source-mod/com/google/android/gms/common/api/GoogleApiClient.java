package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzaah;
import com.google.android.gms.internal.zzaaq;
import com.google.android.gms.internal.zzbgb;
import com.google.android.gms.internal.zzbgc;
import com.google.android.gms.internal.zzbgd;
import com.google.android.gms.internal.zzyo;
import com.google.android.gms.internal.zzyr.zza;
import com.google.android.gms.internal.zzyu;
import com.google.android.gms.internal.zzzh;
import com.google.android.gms.internal.zzzr;
import com.google.android.gms.internal.zzzw;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> zzaKH = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zzaKH)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zzaKH.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
  }
  
  public static Set<GoogleApiClient> zzwZ()
  {
    synchronized (zzaKH)
    {
      Set localSet2 = zzaKH;
      return localSet2;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @NonNull
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(@NonNull Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(ResultStore paramResultStore)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(zzaaq paramzzaaq)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(zzaah paramzzaah)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzaaq paramzzaaq)
  {
    throw new UnsupportedOperationException();
  }
  
  public <L> zzzw<L> zzu(@NonNull L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzxa()
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private final Context mContext;
    private final Set<Scope> zzaKI = new HashSet();
    private final Set<Scope> zzaKJ = new HashSet();
    private int zzaKK;
    private View zzaKL;
    private String zzaKM;
    private final Map<Api<?>, zzg.zza> zzaKN = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> zzaKO = new ArrayMap();
    private zzzr zzaKP;
    private int zzaKQ = -1;
    private GoogleApiClient.OnConnectionFailedListener zzaKR;
    private GoogleApiAvailability zzaKS = GoogleApiAvailability.getInstance();
    private Api.zza<? extends zzbgc, zzbgd> zzaKT = zzbgb.zzaiG;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaKU = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaKV = new ArrayList();
    private boolean zzaKW = false;
    private Account zzagc;
    private String zzaiS;
    private Looper zzrD;
    
    public Builder(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.zzrD = paramContext.getMainLooper();
      this.zzaiS = paramContext.getPackageName();
      this.zzaKM = paramContext.getClass().getName();
    }
    
    public Builder(@NonNull Context paramContext, @NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      zzac.zzb(paramConnectionCallbacks, "Must provide a connected listener");
      this.zzaKU.add(paramConnectionCallbacks);
      zzac.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zzaKV.add(paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zze, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return paramzza.zza(paramContext, paramLooper, paramzzg, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
    
    private Builder zza(@NonNull zzzr paramzzzr, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "clientId must be non-negative");
        this.zzaKQ = paramInt;
        this.zzaKR = paramOnConnectionFailedListener;
        this.zzaKP = paramzzzr;
        return this;
      }
    }
    
    private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      paramO = new HashSet(paramApi.zzwQ().zzs(paramO));
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramO.add(paramVarArgs[i]);
        i += 1;
      }
      this.zzaKN.put(paramApi, new zzg.zza(paramO));
    }
    
    private void zzh(GoogleApiClient paramGoogleApiClient)
    {
      zzyo.zza(this.zzaKP).zza(this.zzaKQ, paramGoogleApiClient, this.zzaKR);
    }
    
    private GoogleApiClient zzxd()
    {
      zzg localzzg = zzxc();
      Object localObject1 = null;
      Map localMap = localzzg.zzzH();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zzaKO.keySet().iterator();
      int i = 0;
      Api localApi;
      Object localObject2;
      boolean bool;
      label109:
      Object localObject3;
      if (localIterator.hasNext())
      {
        localApi = (Api)localIterator.next();
        localObject2 = this.zzaKO.get(localApi);
        if (localMap.get(localApi) != null)
        {
          bool = true;
          localArrayMap1.put(localApi, Boolean.valueOf(bool));
          localObject3 = new zzyu(localApi, bool);
          localArrayList.add(localObject3);
          Api.zza localzza = localApi.zzwR();
          localObject3 = zza(localzza, localObject2, this.mContext, this.zzrD, localzzg, (GoogleApiClient.ConnectionCallbacks)localObject3, (GoogleApiClient.OnConnectionFailedListener)localObject3);
          localArrayMap2.put(localApi.zzwS(), localObject3);
          if (localzza.getPriority() != 1) {
            break label498;
          }
          if (localObject2 == null) {
            break label297;
          }
          i = 1;
        }
      }
      label297:
      label305:
      label493:
      label498:
      for (;;)
      {
        if (((Api.zze)localObject3).zzqP())
        {
          localObject2 = localApi;
          if (localObject1 == null) {
            break label305;
          }
          localObject2 = String.valueOf(localApi.getName());
          localObject1 = String.valueOf(((Api)localObject1).getName());
          throw new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length() + (String)localObject2 + " cannot be used with " + (String)localObject1);
          bool = false;
          break label109;
          i = 0;
          continue;
        }
        localObject2 = localObject1;
        localObject1 = localObject2;
        break;
        if (localObject1 != null)
        {
          if (i != 0)
          {
            localObject1 = String.valueOf(((Api)localObject1).getName());
            throw new IllegalStateException(String.valueOf(localObject1).length() + 82 + "With using " + (String)localObject1 + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          }
          if (this.zzagc != null) {
            break label493;
          }
        }
        for (bool = true;; bool = false)
        {
          zzac.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)localObject1).getName() });
          zzac.zza(this.zzaKI.equals(this.zzaKJ), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)localObject1).getName() });
          i = zzzh.zza(localArrayMap2.values(), true);
          return new zzzh(this.mContext, new ReentrantLock(), this.zzrD, localzzg, this.zzaKS, this.zzaKT, localArrayMap1, this.zzaKU, this.zzaKV, localArrayMap2, this.zzaKQ, i, localArrayList, false);
        }
      }
    }
    
    public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzac.zzb(paramApi, "Api must not be null");
      this.zzaKO.put(paramApi, null);
      paramApi = paramApi.zzwQ().zzs(null);
      this.zzaKJ.addAll(paramApi);
      this.zzaKI.addAll(paramApi);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> paramApi, @NonNull O paramO)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzac.zzb(paramO, "Null options are not permitted for this Api");
      this.zzaKO.put(paramApi, paramO);
      paramApi = paramApi.zzwQ().zzs(paramO);
      this.zzaKJ.addAll(paramApi);
      this.zzaKI.addAll(paramApi);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> paramApi, @NonNull O paramO, Scope... paramVarArgs)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzac.zzb(paramO, "Null options are not permitted for this Api");
      this.zzaKO.put(paramApi, paramO);
      zza(paramApi, paramO, paramVarArgs);
      return this;
    }
    
    public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      zzac.zzb(paramApi, "Api must not be null");
      this.zzaKO.put(paramApi, null);
      zza(paramApi, null, paramVarArgs);
      return this;
    }
    
    public Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzac.zzb(paramConnectionCallbacks, "Listener must not be null");
      this.zzaKU.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzac.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      this.zzaKV.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(@NonNull Scope paramScope)
    {
      zzac.zzb(paramScope, "Scope must not be null");
      this.zzaKI.add(paramScope);
      return this;
    }
    
    public GoogleApiClient build()
    {
      boolean bool;
      if (!this.zzaKO.isEmpty()) {
        bool = true;
      }
      for (;;)
      {
        zzac.zzb(bool, "must call addApi() to add at least one API");
        GoogleApiClient localGoogleApiClient = zzxd();
        synchronized (GoogleApiClient.zzxb())
        {
          GoogleApiClient.zzxb().add(localGoogleApiClient);
          if (this.zzaKQ >= 0) {
            zzh(localGoogleApiClient);
          }
          return localGoogleApiClient;
          bool = false;
        }
      }
    }
    
    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return zza(new zzzr(paramFragmentActivity), paramInt, paramOnConnectionFailedListener);
    }
    
    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    public Builder setAccount(Account paramAccount)
    {
      this.zzagc = paramAccount;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      if (paramString == null) {}
      for (paramString = null;; paramString = new Account(paramString, "com.google"))
      {
        this.zzagc = paramString;
        return this;
      }
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      this.zzaKK = paramInt;
      return this;
    }
    
    public Builder setHandler(@NonNull Handler paramHandler)
    {
      zzac.zzb(paramHandler, "Handler must not be null");
      this.zzrD = paramHandler.getLooper();
      return this;
    }
    
    public Builder setViewForPopups(@NonNull View paramView)
    {
      zzac.zzb(paramView, "View must not be null");
      this.zzaKL = paramView;
      return this;
    }
    
    public Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
    
    public zzg zzxc()
    {
      zzbgd localzzbgd = zzbgd.zzcqC;
      if (this.zzaKO.containsKey(zzbgb.API)) {
        localzzbgd = (zzbgd)this.zzaKO.get(zzbgb.API);
      }
      return new zzg(this.zzagc, this.zzaKI, this.zzaKN, this.zzaKK, this.zzaKL, this.zzaiS, this.zzaKM, localzzbgd);
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */