package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Iterator;
import java.util.Set;

public abstract class zzl<T extends IInterface>
  extends zzf<T>
  implements Api.zze, zzm.zza
{
  private final zzg zzaMp;
  private final Account zzagc;
  private final Set<Scope> zzamH;
  
  protected zzl(Context paramContext, Looper paramLooper, int paramInt, zzg paramzzg)
  {
    this(paramContext, paramLooper, zzn.zzbb(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzg, null, null);
  }
  
  protected zzl(Context paramContext, Looper paramLooper, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzn.zzbb(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzg, (GoogleApiClient.ConnectionCallbacks)zzac.zzC(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzac.zzC(paramOnConnectionFailedListener));
  }
  
  protected zzl(Context paramContext, Looper paramLooper, zzn paramzzn, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramzzn, paramGoogleApiAvailability, paramInt, zza(paramConnectionCallbacks), zza(paramOnConnectionFailedListener), paramzzg.zzzJ());
    this.zzaMp = paramzzg;
    this.zzagc = paramzzg.getAccount();
    this.zzamH = zzb(paramzzg.zzzG());
  }
  
  @Nullable
  private static zzf.zzb zza(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null) {
      return null;
    }
    new zzf.zzb()
    {
      public void onConnected(@Nullable Bundle paramAnonymousBundle)
      {
        zzl.this.onConnected(paramAnonymousBundle);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        zzl.this.onConnectionSuspended(paramAnonymousInt);
      }
    };
  }
  
  @Nullable
  private static zzf.zzc zza(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null) {
      return null;
    }
    new zzf.zzc()
    {
      public void onConnectionFailed(@NonNull ConnectionResult paramAnonymousConnectionResult)
      {
        zzl.this.onConnectionFailed(paramAnonymousConnectionResult);
      }
    };
  }
  
  private Set<Scope> zzb(@NonNull Set<Scope> paramSet)
  {
    Set localSet = zzc(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return this.zzagc;
  }
  
  @NonNull
  protected Set<Scope> zzc(@NonNull Set<Scope> paramSet)
  {
    return paramSet;
  }
  
  protected final zzg zzzQ()
  {
    return this.zzaMp;
  }
  
  public zzc[] zzzt()
  {
    return new zzc[0];
  }
  
  protected final Set<Scope> zzzy()
  {
    return this.zzamH;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */