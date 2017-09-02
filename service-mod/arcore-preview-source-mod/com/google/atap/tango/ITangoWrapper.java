package com.google.atap.tango;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.google.atap.tangoservice.ITango;
import com.google.atap.tangoservice.ITango.Stub;
import com.google.atap.tangoservice.ITangoListener;
import com.google.atap.tangoservice.TangoAreaDescriptionMetaData;
import com.google.atap.tangoservice.TangoCameraIntrinsics;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoCoordinateFramePair;
import com.google.atap.tangoservice.TangoPoseData;
import com.google.atap.tangoservice.experimental.TangoPlaneData;
import com.google.atap.tangoservice.fois.FoiRequest;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

abstract class ITangoWrapper
  extends ITango.Stub
{
  private static final String EXCEPTION_MESSAGE = "TangoService has been destroyed. Please rebind and use the new IBinder instead.";
  private final ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();
  private final ITango mProtectedInterface = new ITango()
  {
    public IBinder asBinder()
    {
      return ITangoWrapper.this;
    }
    
    public int connect(ITangoListener paramAnonymousITangoListener, TangoConfig paramAnonymousTangoConfig)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.connect(paramAnonymousITangoListener, paramAnonymousTangoConfig);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int connectSurface(int paramAnonymousInt, Surface paramAnonymousSurface)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        paramAnonymousInt = ITangoWrapper.this.connectSurface(paramAnonymousInt, paramAnonymousSurface);
        return paramAnonymousInt;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int deleteAreaDescription(String paramAnonymousString)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.deleteAreaDescription(paramAnonymousString);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int deleteDataset(String paramAnonymousString)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.deleteDataset(paramAnonymousString);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int disconnect()
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.disconnect();
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int disconnectSurface(int paramAnonymousInt)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        paramAnonymousInt = ITangoWrapper.this.disconnectSurface(paramAnonymousInt);
        return paramAnonymousInt;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int exportAreaDescriptionFile(String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.exportAreaDescriptionFile(paramAnonymousString1, paramAnonymousString2);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int foiRequest(FoiRequest paramAnonymousFoiRequest)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.foiRequest(paramAnonymousFoiRequest);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getAreaDescriptionUuidList(List<String> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getAreaDescriptionUuidList(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getCameraIntrinsics(int paramAnonymousInt, TangoCameraIntrinsics paramAnonymousTangoCameraIntrinsics)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        paramAnonymousInt = ITangoWrapper.this.getCameraIntrinsics(paramAnonymousInt, paramAnonymousTangoCameraIntrinsics);
        return paramAnonymousInt;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getConfig(int paramAnonymousInt, TangoConfig paramAnonymousTangoConfig)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        paramAnonymousInt = ITangoWrapper.this.getConfig(paramAnonymousInt, paramAnonymousTangoConfig);
        return paramAnonymousInt;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getCurrentDatasetUuid(List<String> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getCurrentDatasetUuid(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getDatasetUuids(List<String> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getDatasetUuids(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getPlaneByUVCoord(int paramAnonymousInt, TangoPoseData paramAnonymousTangoPoseData, double[] paramAnonymousArrayOfDouble, TangoPlaneData paramAnonymousTangoPlaneData)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        paramAnonymousInt = ITangoWrapper.this.getPlaneByUVCoord(paramAnonymousInt, paramAnonymousTangoPoseData, paramAnonymousArrayOfDouble, paramAnonymousTangoPlaneData);
        return paramAnonymousInt;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getPlanes(List<TangoPlaneData> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getPlanes(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getPoseAtTime(double paramAnonymousDouble, TangoCoordinateFramePair paramAnonymousTangoCoordinateFramePair, TangoPoseData paramAnonymousTangoPoseData)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getPoseAtTime(paramAnonymousDouble, paramAnonymousTangoCoordinateFramePair, paramAnonymousTangoPoseData);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int getPoseAtTime2(double paramAnonymousDouble, String paramAnonymousString1, String paramAnonymousString2, TangoPoseData paramAnonymousTangoPoseData)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.getPoseAtTime2(paramAnonymousDouble, paramAnonymousString1, paramAnonymousString2, paramAnonymousTangoPoseData);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int importAreaDescriptionFile(List<String> paramAnonymousList, String paramAnonymousString)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.importAreaDescriptionFile(paramAnonymousList, paramAnonymousString);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int loadAreaDescriptionMetaData(String paramAnonymousString, TangoAreaDescriptionMetaData paramAnonymousTangoAreaDescriptionMetaData)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.loadAreaDescriptionMetaData(paramAnonymousString, paramAnonymousTangoAreaDescriptionMetaData);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int reportApiUsage(TangoConfig paramAnonymousTangoConfig)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.reportApiUsage(paramAnonymousTangoConfig);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int resetMotionTracking()
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.resetMotionTracking();
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int saveAreaDescription(List<String> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.saveAreaDescription(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int saveAreaDescriptionMetaData(String paramAnonymousString, TangoAreaDescriptionMetaData paramAnonymousTangoAreaDescriptionMetaData)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.saveAreaDescriptionMetaData(paramAnonymousString, paramAnonymousTangoAreaDescriptionMetaData);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int setPoseListenerFrames(List<TangoCoordinateFramePair> paramAnonymousList)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.setPoseListenerFrames(paramAnonymousList);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int setRuntimeConfig(TangoConfig paramAnonymousTangoConfig)
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.setRuntimeConfig(paramAnonymousTangoConfig);
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
    
    public int startOnlineCalibrationSolve()
      throws RemoteException
    {
      ITangoWrapper.this.readLockOrThrow();
      try
      {
        int i = ITangoWrapper.this.startOnlineCalibrationSolve();
        return i;
      }
      finally
      {
        ITangoWrapper.this.readUnlock();
      }
    }
  };
  private boolean mValid = true;
  
  public ITangoWrapper()
  {
    attachInterface(this.mProtectedInterface, getInterfaceDescriptor());
  }
  
  private void readLockOrThrow()
    throws RemoteException
  {
    int j = 1;
    if (this.mLock.readLock().tryLock()) {
      if (this.mValid) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i != 0)
      {
        this.mLock.readLock().unlock();
        j = i;
      }
      if (j == 0) {
        break;
      }
      throw new RemoteException("TangoService has been destroyed. Please rebind and use the new IBinder instead.");
    }
  }
  
  private void readUnlock()
  {
    this.mLock.readLock().unlock();
  }
  
  public final void invalidate()
  {
    this.mLock.writeLock().lock();
    this.mValid = false;
    this.mLock.writeLock().unlock();
  }
  
  public final boolean isValid()
  {
    boolean bool = false;
    if (this.mLock.readLock().tryLock())
    {
      bool = this.mValid;
      this.mLock.readLock().unlock();
    }
    return bool;
  }
  
  public final boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    readLockOrThrow();
    try
    {
      boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      return bool;
    }
    finally
    {
      readUnlock();
    }
  }
  
  public boolean pingBinder()
  {
    return isValid();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/ITangoWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */