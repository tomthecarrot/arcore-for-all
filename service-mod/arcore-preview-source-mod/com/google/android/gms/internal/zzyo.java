package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzyo
  extends zzys
{
  private final SparseArray<zza> zzaLr = new SparseArray();
  
  private zzyo(zzzt paramzzzt)
  {
    super(paramzzzt);
    this.zzaOu.zza("AutoManageHelper", this);
  }
  
  public static zzyo zza(zzzr paramzzzr)
  {
    paramzzzr = zzc(paramzzzr);
    zzyo localzzyo = (zzyo)paramzzzr.zza("AutoManageHelper", zzyo.class);
    if (localzzyo != null) {
      return localzzyo;
    }
    return new zzyo(paramzzzr);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this.zzaLr.size())
    {
      ((zza)this.zzaLr.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.zzaLr);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 14 + "onStart " + bool + " " + str);
    if (!this.zzaLD)
    {
      int i = 0;
      while (i < this.zzaLr.size())
      {
        ((zza)this.zzaLr.valueAt(i)).zzaLt.connect();
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this.zzaLr.size())
    {
      ((zza)this.zzaLr.valueAt(i)).zzaLt.disconnect();
      i += 1;
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zzaLr.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzac.zza(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = this.mStarted;
      boolean bool2 = this.zzaLD;
      Log.d("AutoManageHelper", 54 + "starting AutoManage for client " + paramInt + " " + bool1 + " " + bool2);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.zzaLr.put(paramInt, paramOnConnectionFailedListener);
      if ((this.mStarted) && (!this.zzaLD))
      {
        paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
        Log.d("AutoManageHelper", String.valueOf(paramOnConnectionFailedListener).length() + 11 + "connecting " + paramOnConnectionFailedListener);
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (zza)this.zzaLr.get(paramInt);
      } while (localObject == null);
      zzfE(paramInt);
      localObject = ((zza)localObject).zzaLu;
    } while (localObject == null);
    ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
  }
  
  public void zzfE(int paramInt)
  {
    zza localzza = (zza)this.zzaLr.get(paramInt);
    this.zzaLr.remove(paramInt);
    if (localzza != null) {
      localzza.zzxk();
    }
  }
  
  protected void zzxj()
  {
    int i = 0;
    while (i < this.zzaLr.size())
    {
      ((zza)this.zzaLr.valueAt(i)).zzaLt.connect();
      i += 1;
    }
  }
  
  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zzaLs;
    public final GoogleApiClient zzaLt;
    public final GoogleApiClient.OnConnectionFailedListener zzaLu;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.zzaLs = paramInt;
      this.zzaLt = paramGoogleApiClient;
      this.zzaLu = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(this.zzaLs);
      paramPrintWriter.println(":");
      this.zzaLt.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      String str = String.valueOf(paramConnectionResult);
      Log.d("AutoManageHelper", String.valueOf(str).length() + 27 + "beginFailureResolution for " + str);
      zzyo.this.zzb(paramConnectionResult, this.zzaLs);
    }
    
    public void zzxk()
    {
      this.zzaLt.unregisterConnectionFailedListener(this);
      this.zzaLt.disconnect();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */