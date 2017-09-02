package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzzy
  extends zzys
{
  private TaskCompletionSource<Void> zzamh = new TaskCompletionSource();
  
  private zzzy(zzzt paramzzzt)
  {
    super(paramzzzt);
    this.zzaOu.zza("GmsAvailabilityHelper", this);
  }
  
  public static zzzy zzv(Activity paramActivity)
  {
    paramActivity = zzt(paramActivity);
    zzzy localzzzy = (zzzy)paramActivity.zza("GmsAvailabilityHelper", zzzy.class);
    if (localzzzy != null)
    {
      if (localzzzy.zzamh.getTask().isComplete()) {
        localzzzy.zzamh = new TaskCompletionSource();
      }
      return localzzzy;
    }
    return new zzzy(paramActivity);
  }
  
  public Task<Void> getTask()
  {
    return this.zzamh.getTask();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.zzamh.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zzamh.setException(zzb.zzl(paramConnectionResult));
  }
  
  public void zzk(ConnectionResult paramConnectionResult)
  {
    zzb(paramConnectionResult, 0);
  }
  
  protected void zzxj()
  {
    int i = this.zzaKS.isGooglePlayServicesAvailable(this.zzaOu.zzyI());
    if (i == 0)
    {
      this.zzamh.setResult(null);
      return;
    }
    zzk(new ConnectionResult(i, null));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */