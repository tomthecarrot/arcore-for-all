package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzm
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza zzaRX;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaRY = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaRZ = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaSa = new ArrayList();
  private volatile boolean zzaSb = false;
  private final AtomicInteger zzaSc = new AtomicInteger(0);
  private boolean zzaSd = false;
  private final Object zzrU = new Object();
  
  public zzm(Looper paramLooper, zza paramzza)
  {
    this.zzaRX = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.zzrU)
      {
        if ((this.zzaSb) && (this.zzaRX.isConnected()) && (this.zzaRY.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zzaRX.zzwi());
        }
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzC(paramConnectionCallbacks);
    synchronized (this.zzrU)
    {
      boolean bool = this.zzaRY.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzC(paramOnConnectionFailedListener);
    synchronized (this.zzrU)
    {
      boolean bool = this.zzaSa.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzC(paramConnectionCallbacks);
    synchronized (this.zzrU)
    {
      if (this.zzaRY.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.zzaRX.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.zzaRY.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzC(paramOnConnectionFailedListener);
    synchronized (this.zzrU)
    {
      if (this.zzaSa.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 67 + "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.zzaSa.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzC(paramConnectionCallbacks);
    synchronized (this.zzrU)
    {
      if (!this.zzaRY.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(paramConnectionCallbacks).length() + 52 + "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      while (!this.zzaSd) {
        return;
      }
      this.zzaRZ.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzC(paramOnConnectionFailedListener);
    synchronized (this.zzrU)
    {
      if (!this.zzaSa.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 57 + "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzfZ(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    zzac.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzrU)
    {
      this.zzaSd = true;
      Object localObject2 = new ArrayList(this.zzaRY);
      int i = this.zzaSc.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzaSb) && (this.zzaSc.get() == i)) {}
        }
        else
        {
          this.zzaRZ.clear();
          this.zzaSd = false;
          return;
        }
      } while (!this.zzaRY.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzn(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzrU)
      {
        Object localObject2 = new ArrayList(this.zzaSa);
        int i = this.zzaSc.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!this.zzaSb) || (this.zzaSc.get() != i)) {
            return;
          }
          if (this.zzaSa.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzw(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      zzac.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if (this.zzaSd) {
          break label206;
        }
        bool1 = true;
        zzac.zzav(bool1);
        this.mHandler.removeMessages(1);
        this.zzaSd = true;
        if (this.zzaRZ.size() != 0) {
          break label211;
        }
        bool1 = bool2;
        zzac.zzav(bool1);
        Object localObject2 = new ArrayList(this.zzaRY);
        int i = this.zzaSc.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzaSb) && (this.zzaRX.isConnected()) && (this.zzaSc.get() == i)) {}
        }
        else
        {
          this.zzaRZ.clear();
          this.zzaSd = false;
          return;
        }
        if (this.zzaRZ.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206:
      bool1 = false;
      continue;
      label211:
      bool1 = false;
    }
  }
  
  public void zzzR()
  {
    this.zzaSb = false;
    this.zzaSc.incrementAndGet();
  }
  
  public void zzzS()
  {
    this.zzaSb = true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zzwi();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */