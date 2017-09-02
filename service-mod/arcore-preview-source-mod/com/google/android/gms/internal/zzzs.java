package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzzs
{
  protected final zzzt zzaOu;
  
  protected zzzs(zzzt paramzzzt)
  {
    this.zzaOu = paramzzzt;
  }
  
  protected static zzzt zzc(zzzr paramzzzr)
  {
    if (paramzzzr.zzyE()) {
      return zzaam.zzb(paramzzzr.zzyG());
    }
    return zzzu.zzu(paramzzzr.zzyF());
  }
  
  public static zzzt zzt(Activity paramActivity)
  {
    return zzc(new zzzr(paramActivity));
  }
  
  @MainThread
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity()
  {
    return this.zzaOu.zzyI();
  }
  
  @MainThread
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @MainThread
  public void onCreate(Bundle paramBundle) {}
  
  @MainThread
  public void onDestroy() {}
  
  @MainThread
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  @MainThread
  public void onStart() {}
  
  @MainThread
  public void onStop() {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */