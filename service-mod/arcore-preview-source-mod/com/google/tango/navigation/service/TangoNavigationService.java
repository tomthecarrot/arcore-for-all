package com.google.tango.navigation.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.tango.cloudlib.CloudNavigationGraphManager;
import com.google.tango.cloudlib.CloudNavigationGraphManager.Callbacks;
import com.google.tango.cloudlib.Utils;
import java.math.BigInteger;
import java.util.HashMap;

public class TangoNavigationService
  extends Service
{
  private static final int CLIENT_ID_LENGTH;
  private static final int CONNECT_OPCODE;
  public static final String DEFAULT_CLOUD_NAV_GRAPH_DIR_PATH = "/data/data/com.google.tango/files/cloud/navgraphs/";
  private static final int DISCONNECT_OPCODE;
  private static final int START_PUBLIC_NAVIGATION_OPCODE;
  private static final int STOP_PUBLIC_NAVIGATION_OPCODE;
  private static final String TAG = "TangoNavigationService.java";
  private static final HashMap<BigInteger, ClientState> clients;
  private static final Object clientsLock;
  private Binder mBinder = new Binder()
  {
    public boolean onTransact(int paramAnonymousInt1, Parcel arg2, Parcel arg3, int paramAnonymousInt2)
    {
      TangoNavigationService.ClientState localClientState;
      if (paramAnonymousInt1 == TangoNavigationService.CONNECT_OPCODE)
      {
        IBinder localIBinder = ???.readStrongBinder();
        paramAnonymousInt1 = ???.readInt();
        int i = ???.readInt();
        ??? = TangoNavigationService.access$400();
        if (!TangoNavigationService.onConnectNative(???, paramAnonymousInt1, i, ???, paramAnonymousInt2)) {
          return true;
        }
        try
        {
          localClientState = new TangoNavigationService.ClientState(???, localIBinder);
          synchronized (TangoNavigationService.clientsLock)
          {
            localIBinder.linkToDeath(localClientState, 0);
            TangoNavigationService.clients.put(new BigInteger(???), localClientState);
            return true;
          }
          if (paramAnonymousInt1 != TangoNavigationService.DISCONNECT_OPCODE) {
            break label225;
          }
        }
        catch (RemoteException ???)
        {
          Log.w("TangoNavigationService.java", "Client died immediately upon connecting.", ???);
          TangoNavigationService.onDisconnectNative(???);
          return false;
        }
      }
      else
      {
        ??? = ???.createByteArray();
        if (???.length != TangoNavigationService.CLIENT_ID_LENGTH) {
          return false;
        }
        BigInteger localBigInteger = new BigInteger(???);
        synchronized (TangoNavigationService.clientsLock)
        {
          localClientState = (TangoNavigationService.ClientState)TangoNavigationService.clients.get(localBigInteger);
          if (localClientState == null)
          {
            Log.w("TangoNavigationService.java", "Unknown client requested disconnect.");
            return false;
          }
        }
        if (!localClientState.binder.unlinkToDeath(localClientState, 0)) {
          return true;
        }
        TangoNavigationService.clients.remove(localBigInteger);
        return TangoNavigationService.onDisconnectNative(???);
      }
      label225:
      if (paramAnonymousInt1 == TangoNavigationService.START_PUBLIC_NAVIGATION_OPCODE)
      {
        TangoNavigationService.this.mCloudNavigationGraphManager.start();
        return TangoNavigationService.onTransactNative(paramAnonymousInt1, ???, ???, paramAnonymousInt2);
      }
      if (paramAnonymousInt1 == TangoNavigationService.STOP_PUBLIC_NAVIGATION_OPCODE)
      {
        TangoNavigationService.this.mCloudNavigationGraphManager.stop();
        return TangoNavigationService.onTransactNative(paramAnonymousInt1, ???, ???, paramAnonymousInt2);
      }
      return TangoNavigationService.onTransactNative(paramAnonymousInt1, ???, ???, paramAnonymousInt2);
    }
  };
  private CloudNavigationGraphManager.Callbacks mCloudNavigationCallbacks = new CloudNavigationGraphManager.Callbacks()
  {
    public void onCloudEvent(int paramAnonymousInt1, int paramAnonymousInt2) {}
    
    public void onDebugEvent(String paramAnonymousString1, String paramAnonymousString2) {}
    
    public void onNavigationGraphAvailable(String paramAnonymousString)
    {
      Log.d("TangoNavigationService.java", "onNavigationGraphAvailable " + paramAnonymousString);
      TangoNavigationService.updatePublicNavigationGraphNative(paramAnonymousString);
    }
  };
  private CloudNavigationGraphManager mCloudNavigationGraphManager = null;
  
  static
  {
    System.loadLibrary("tango_navigation_service");
    CONNECT_OPCODE = getConnectOpcodeNative();
    DISCONNECT_OPCODE = getDisconnectOpcodeNative();
    CLIENT_ID_LENGTH = getClientIdLengthNative();
    START_PUBLIC_NAVIGATION_OPCODE = getStartPublicNavigationOpcodeNative();
    STOP_PUBLIC_NAVIGATION_OPCODE = getStopPublicNavigationOpcodeNative();
    clientsLock = new Object();
    clients = new HashMap();
    initNative();
  }
  
  private static native byte[] generateClientUuidNative();
  
  private static native int getClientIdLengthNative();
  
  private static native int getConnectOpcodeNative();
  
  private static native int getDisconnectOpcodeNative();
  
  private static native int getStartPublicNavigationOpcodeNative();
  
  private static native int getStopPublicNavigationOpcodeNative();
  
  private static native void initNative();
  
  private static native boolean onConnectNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Parcel paramParcel, int paramInt3);
  
  private static native boolean onDisconnectNative(byte[] paramArrayOfByte);
  
  private static native boolean onTransactNative(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2);
  
  static native void updatePublicNavigationGraphNative(String paramString);
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = getApplicationContext();
    this.mCloudNavigationGraphManager = new CloudNavigationGraphManager(paramIntent, "/data/data/com.google.tango/files/cloud/navgraphs/", Utils.getApiKey(paramIntent), this.mCloudNavigationCallbacks);
    return this.mBinder;
  }
  
  private static class ClientState
    implements IBinder.DeathRecipient
  {
    public final IBinder binder;
    public final byte[] clientUuid;
    
    public ClientState(byte[] paramArrayOfByte, IBinder paramIBinder)
    {
      this.clientUuid = paramArrayOfByte;
      this.binder = paramIBinder;
    }
    
    public void binderDied()
    {
      Log.w("TangoNavigationService.java", "Client binder died.");
      synchronized (TangoNavigationService.clientsLock)
      {
        TangoNavigationService.clients.remove(new BigInteger(this.clientUuid));
        TangoNavigationService.onDisconnectNative(this.clientUuid);
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/navigation/service/TangoNavigationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */