package com.google.atap.tangoservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;

public class TangoVhs
{
  private static final String TAG = "TangoVhs";
  private ITangoVhs mITangoVhs;
  private Context mParent;
  private ServiceConnection mServiceConnection;
  
  public TangoVhs(Context paramContext)
  {
    this.mParent = paramContext;
  }
  
  public void connect(final Runnable paramRunnable)
  {
    Log.d("TangoVhs", "about to bind as vhs");
    Intent localIntent = new Intent();
    localIntent.setClassName("com.google.tango", "com.google.atap.tango.TangoVirtualHalService");
    this.mServiceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        Log.d("TangoVhs", "connected");
        TangoVhs.access$002(TangoVhs.this, ITangoVhs.Stub.asInterface(paramAnonymousIBinder));
        new Thread(paramRunnable).start();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        TangoVhs.access$002(TangoVhs.this, null);
      }
    };
    this.mParent.bindService(localIntent, this.mServiceConnection, 1);
    Log.d("TangoVhs", "finished bind as vhs");
  }
  
  public void disconnect()
  {
    if (this.mServiceConnection != null)
    {
      this.mParent.unbindService(this.mServiceConnection);
      this.mServiceConnection = null;
    }
  }
  
  public Surface getTrackingSurface()
  {
    try
    {
      Surface localSurface = this.mITangoVhs.getTrackingSurface();
      return localSurface;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void onMetadata(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    try
    {
      this.mITangoVhs.onMetadata(paramLong1, paramLong2, paramLong3, paramLong4);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public int setDatasetPathAndUUID(String paramString1, String paramString2)
  {
    try
    {
      int i = this.mITangoVhs.setDatasetPathAndUUID(paramString1, paramString2);
      return i;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoVhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */