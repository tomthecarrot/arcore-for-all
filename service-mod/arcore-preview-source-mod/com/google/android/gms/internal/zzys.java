package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzys
  extends zzzs
  implements DialogInterface.OnCancelListener
{
  protected boolean mStarted;
  protected final GoogleApiAvailability zzaKS;
  protected boolean zzaLD;
  private ConnectionResult zzaLE;
  private int zzaLF = -1;
  private final Handler zzaLG = new Handler(Looper.getMainLooper());
  
  protected zzys(zzzt paramzzzt)
  {
    this(paramzzzt, GoogleApiAvailability.getInstance());
  }
  
  zzys(zzzt paramzzzt, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramzzzt);
    this.zzaKS = paramGoogleApiAvailability;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        zzxp();
        return;
      }
      break;
    case 2: 
      label30:
      j = this.zzaKS.isGooglePlayServicesAvailable(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (this.zzaLE.getErrorCode() != 18) {
        break label30;
      }
      paramInt1 = paramInt2;
      if (j != 18) {
        break label30;
      }
      return;
      paramInt1 = j;
      if (paramInt2 == -1) {
        break label30;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (paramIntent != null) {}
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);; paramInt1 = 13)
      {
        this.zzaLE = new ConnectionResult(paramInt1, null);
        break;
        zza(this.zzaLE, this.zzaLF);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), this.zzaLF);
    zzxp();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.zzaLD = paramBundle.getBoolean("resolving_error", false);
      if (this.zzaLD)
      {
        this.zzaLF = paramBundle.getInt("failed_client_id", -1);
        this.zzaLE = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.zzaLD);
    if (this.zzaLD)
    {
      paramBundle.putInt("failed_client_id", this.zzaLF);
      paramBundle.putInt("failed_status", this.zzaLE.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.zzaLE.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
  }
  
  protected abstract void zza(ConnectionResult paramConnectionResult, int paramInt);
  
  public void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!this.zzaLD)
    {
      this.zzaLD = true;
      this.zzaLF = paramInt;
      this.zzaLE = paramConnectionResult;
      this.zzaLG.post(new zza(null));
    }
  }
  
  protected abstract void zzxj();
  
  protected void zzxp()
  {
    this.zzaLF = -1;
    this.zzaLD = false;
    this.zzaLE = null;
    zzxj();
  }
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    @MainThread
    public void run()
    {
      if (!zzys.this.mStarted) {
        return;
      }
      if (zzys.zza(zzys.this).hasResolution())
      {
        zzys.this.zzaOu.startActivityForResult(GoogleApiActivity.zzb(zzys.this.getActivity(), zzys.zza(zzys.this).getResolution(), zzys.zzb(zzys.this), false), 1);
        return;
      }
      if (zzys.this.zzaKS.isUserResolvableError(zzys.zza(zzys.this).getErrorCode()))
      {
        zzys.this.zzaKS.zza(zzys.this.getActivity(), zzys.this.zzaOu, zzys.zza(zzys.this).getErrorCode(), 2, zzys.this);
        return;
      }
      if (zzys.zza(zzys.this).getErrorCode() == 18)
      {
        final Dialog localDialog = zzys.this.zzaKS.zza(zzys.this.getActivity(), zzys.this);
        zzys.this.zzaKS.zza(zzys.this.getActivity().getApplicationContext(), new zzzn.zza()
        {
          public void zzxq()
          {
            zzys.this.zzxp();
            if (localDialog.isShowing()) {
              localDialog.dismiss();
            }
          }
        });
        return;
      }
      zzys.this.zza(zzys.zza(zzys.this), zzys.zzb(zzys.this));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */