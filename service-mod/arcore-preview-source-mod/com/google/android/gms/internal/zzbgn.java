package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf.zzi;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzr;

public class zzbgn
  extends zzl<zzbgk>
  implements zzbgc
{
  private final zzg zzaMp;
  private Integer zzaRG;
  private final Bundle zzcqB;
  private final boolean zzcqM;
  
  public zzbgn(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramzzg, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzcqM = paramBoolean;
    this.zzaMp = paramzzg;
    this.zzcqB = paramBundle;
    this.zzaRG = paramzzg.zzzM();
  }
  
  public zzbgn(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramzzg, zzbgd paramzzbgd, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramBoolean, paramzzg, zza(paramzzg), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private zzad zzWg()
  {
    Account localAccount = this.zzaMp.zzzu();
    GoogleSignInAccount localGoogleSignInAccount = null;
    if ("<<default account>>".equals(localAccount.name)) {
      localGoogleSignInAccount = zzn.zzaw(getContext()).zzqZ();
    }
    return new zzad(localAccount, this.zzaRG.intValue(), localGoogleSignInAccount);
  }
  
  public static Bundle zza(zzg paramzzg)
  {
    zzbgd localzzbgd = paramzzg.zzzL();
    Integer localInteger = paramzzg.zzzM();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramzzg.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localzzbgd != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localzzbgd.zzVY());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localzzbgd.isIdTokenRequested());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localzzbgd.getServerClientId());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localzzbgd.zzqJ());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localzzbgd.zzqK());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localzzbgd.zzVZ());
      if (localzzbgd.zzWa() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localzzbgd.zzWa().longValue());
      }
      if (localzzbgd.zzWb() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localzzbgd.zzWb().longValue());
      }
    }
    return localBundle;
  }
  
  public void connect()
  {
    zza(new zzf.zzi(this));
  }
  
  public void zzVX()
  {
    try
    {
      ((zzbgk)zzzw()).zzvG(this.zzaRG.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public void zza(zzr paramzzr, boolean paramBoolean)
  {
    try
    {
      ((zzbgk)zzzw()).zza(paramzzr, this.zzaRG.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramzzr)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public void zza(zzbgj paramzzbgj)
  {
    zzac.zzb(paramzzbgj, "Expecting a valid ISignInCallbacks");
    try
    {
      zzad localzzad = zzWg();
      ((zzbgk)zzzw()).zza(new zzbgo(localzzad), paramzzbgj);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramzzbgj.zzb(new zzbgq(8));
        return;
      }
      catch (RemoteException paramzzbgj)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected String zzeJ()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected zzbgk zzin(IBinder paramIBinder)
  {
    return zzbgk.zza.zzim(paramIBinder);
  }
  
  public boolean zzqB()
  {
    return this.zzcqM;
  }
  
  protected Bundle zzql()
  {
    String str = this.zzaMp.zzzI();
    if (!getContext().getPackageName().equals(str)) {
      this.zzcqB.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzaMp.zzzI());
    }
    return this.zzcqB;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */