package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;

public class zzyu
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> zzaHI;
  private final boolean zzaLY;
  private zzyv zzaLZ;
  
  public zzyu(Api<?> paramApi, boolean paramBoolean)
  {
    this.zzaHI = paramApi;
    this.zzaLY = paramBoolean;
  }
  
  private void zzxx()
  {
    zzac.zzb(this.zzaLZ, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public void onConnected(@Nullable Bundle paramBundle)
  {
    zzxx();
    this.zzaLZ.onConnected(paramBundle);
  }
  
  public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    zzxx();
    this.zzaLZ.zza(paramConnectionResult, this.zzaHI, this.zzaLY);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzxx();
    this.zzaLZ.onConnectionSuspended(paramInt);
  }
  
  public void zza(zzyv paramzzyv)
  {
    this.zzaLZ = paramzzyv;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */