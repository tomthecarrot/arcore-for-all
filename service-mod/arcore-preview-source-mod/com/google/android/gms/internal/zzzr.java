package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzac;

public class zzzr
{
  private final Object zzaOt;
  
  public zzzr(Activity paramActivity)
  {
    zzac.zzb(paramActivity, "Activity must not be null");
    this.zzaOt = paramActivity;
  }
  
  public boolean zzyE()
  {
    return this.zzaOt instanceof FragmentActivity;
  }
  
  public Activity zzyF()
  {
    return (Activity)this.zzaOt;
  }
  
  public FragmentActivity zzyG()
  {
    return (FragmentActivity)this.zzaOt;
  }
  
  public Object zzyH()
  {
    return this.zzaOt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */