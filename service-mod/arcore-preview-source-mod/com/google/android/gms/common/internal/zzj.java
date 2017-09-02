package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class zzj
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zzj> CREATOR = new zzk();
  final int version;
  final int zzaRN;
  int zzaRO;
  String zzaRP;
  IBinder zzaRQ;
  Scope[] zzaRR;
  Bundle zzaRS;
  Account zzaRT;
  zzc[] zzaRU;
  
  public zzj(int paramInt)
  {
    this.version = 3;
    this.zzaRO = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzaRN = paramInt;
  }
  
  zzj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, zzc[] paramArrayOfzzc)
  {
    this.version = paramInt1;
    this.zzaRN = paramInt2;
    this.zzaRO = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.zzaRP = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label78;
      }
    }
    for (this.zzaRT = zzdd(paramIBinder);; this.zzaRT = paramAccount)
    {
      this.zzaRR = paramArrayOfScope;
      this.zzaRS = paramBundle;
      this.zzaRU = paramArrayOfzzc;
      return;
      this.zzaRP = paramString;
      break;
      label78:
      this.zzaRQ = paramIBinder;
    }
  }
  
  private Account zzdd(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zza(zzr.zza.zzde(paramIBinder));
    }
    return localAccount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public zzj zza(zzc[] paramArrayOfzzc)
  {
    this.zzaRU = paramArrayOfzzc;
    return this;
  }
  
  public zzj zzb(zzr paramzzr)
  {
    if (paramzzr != null) {
      this.zzaRQ = paramzzr.asBinder();
    }
    return this;
  }
  
  public zzj zzcX(String paramString)
  {
    this.zzaRP = paramString;
    return this;
  }
  
  public zzj zzd(Account paramAccount)
  {
    this.zzaRT = paramAccount;
    return this;
  }
  
  public zzj zzf(Collection<Scope> paramCollection)
  {
    this.zzaRR = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public zzj zzv(Bundle paramBundle)
  {
    this.zzaRS = paramBundle;
    return this;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */