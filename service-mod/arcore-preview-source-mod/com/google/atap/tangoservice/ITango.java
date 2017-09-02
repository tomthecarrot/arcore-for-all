package com.google.atap.tangoservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.view.Surface;
import com.google.atap.tangoservice.experimental.TangoPlaneData;
import com.google.atap.tangoservice.fois.FoiRequest;
import java.util.ArrayList;
import java.util.List;

public abstract interface ITango
  extends IInterface
{
  public abstract int connect(ITangoListener paramITangoListener, TangoConfig paramTangoConfig)
    throws RemoteException;
  
  public abstract int connectSurface(int paramInt, Surface paramSurface)
    throws RemoteException;
  
  public abstract int deleteAreaDescription(String paramString)
    throws RemoteException;
  
  public abstract int deleteDataset(String paramString)
    throws RemoteException;
  
  public abstract int disconnect()
    throws RemoteException;
  
  public abstract int disconnectSurface(int paramInt)
    throws RemoteException;
  
  public abstract int exportAreaDescriptionFile(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract int foiRequest(FoiRequest paramFoiRequest)
    throws RemoteException;
  
  public abstract int getAreaDescriptionUuidList(List<String> paramList)
    throws RemoteException;
  
  public abstract int getCameraIntrinsics(int paramInt, TangoCameraIntrinsics paramTangoCameraIntrinsics)
    throws RemoteException;
  
  public abstract int getConfig(int paramInt, TangoConfig paramTangoConfig)
    throws RemoteException;
  
  public abstract int getCurrentDatasetUuid(List<String> paramList)
    throws RemoteException;
  
  public abstract int getDatasetUuids(List<String> paramList)
    throws RemoteException;
  
  public abstract int getPlaneByUVCoord(int paramInt, TangoPoseData paramTangoPoseData, double[] paramArrayOfDouble, TangoPlaneData paramTangoPlaneData)
    throws RemoteException;
  
  public abstract int getPlanes(List<TangoPlaneData> paramList)
    throws RemoteException;
  
  public abstract int getPoseAtTime(double paramDouble, TangoCoordinateFramePair paramTangoCoordinateFramePair, TangoPoseData paramTangoPoseData)
    throws RemoteException;
  
  public abstract int getPoseAtTime2(double paramDouble, String paramString1, String paramString2, TangoPoseData paramTangoPoseData)
    throws RemoteException;
  
  public abstract int importAreaDescriptionFile(List<String> paramList, String paramString)
    throws RemoteException;
  
  public abstract int loadAreaDescriptionMetaData(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
    throws RemoteException;
  
  public abstract int reportApiUsage(TangoConfig paramTangoConfig)
    throws RemoteException;
  
  public abstract int resetMotionTracking()
    throws RemoteException;
  
  public abstract int saveAreaDescription(List<String> paramList)
    throws RemoteException;
  
  public abstract int saveAreaDescriptionMetaData(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
    throws RemoteException;
  
  public abstract int setPoseListenerFrames(List<TangoCoordinateFramePair> paramList)
    throws RemoteException;
  
  public abstract int setRuntimeConfig(TangoConfig paramTangoConfig)
    throws RemoteException;
  
  public abstract int startOnlineCalibrationSolve()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITango
  {
    private static final String DESCRIPTOR = "com.google.atap.tangoservice.ITango";
    static final int TRANSACTION_connect = 1;
    static final int TRANSACTION_connectSurface = 6;
    static final int TRANSACTION_deleteAreaDescription = 15;
    static final int TRANSACTION_deleteDataset = 20;
    static final int TRANSACTION_disconnect = 3;
    static final int TRANSACTION_disconnectSurface = 7;
    static final int TRANSACTION_exportAreaDescriptionFile = 14;
    static final int TRANSACTION_foiRequest = 22;
    static final int TRANSACTION_getAreaDescriptionUuidList = 10;
    static final int TRANSACTION_getCameraIntrinsics = 16;
    static final int TRANSACTION_getConfig = 5;
    static final int TRANSACTION_getCurrentDatasetUuid = 21;
    static final int TRANSACTION_getDatasetUuids = 19;
    static final int TRANSACTION_getPlaneByUVCoord = 24;
    static final int TRANSACTION_getPlanes = 25;
    static final int TRANSACTION_getPoseAtTime = 4;
    static final int TRANSACTION_getPoseAtTime2 = 23;
    static final int TRANSACTION_importAreaDescriptionFile = 13;
    static final int TRANSACTION_loadAreaDescriptionMetaData = 11;
    static final int TRANSACTION_reportApiUsage = 18;
    static final int TRANSACTION_resetMotionTracking = 8;
    static final int TRANSACTION_saveAreaDescription = 9;
    static final int TRANSACTION_saveAreaDescriptionMetaData = 12;
    static final int TRANSACTION_setPoseListenerFrames = 2;
    static final int TRANSACTION_setRuntimeConfig = 17;
    static final int TRANSACTION_startOnlineCalibrationSolve = 26;
    
    public Stub()
    {
      attachInterface(this, "com.google.atap.tangoservice.ITango");
    }
    
    public static ITango asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.atap.tangoservice.ITango");
      if ((localIInterface != null) && ((localIInterface instanceof ITango))) {
        return (ITango)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject1;
      double d;
      label440:
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.atap.tangoservice.ITango");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        localObject1 = ITangoListener.Stub.asInterface(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoConfig)TangoConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = connect((ITangoListener)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = setPoseListenerFrames(paramParcel1.createTypedArrayList(TangoCoordinateFramePair.CREATOR));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = disconnect();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        d = paramParcel1.readDouble();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (TangoCoordinateFramePair)TangoCoordinateFramePair.CREATOR.createFromParcel(paramParcel1);
          localObject1 = new TangoPoseData();
          paramInt1 = getPoseAtTime(d, paramParcel1, (TangoPoseData)localObject1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          if (localObject1 == null) {
            break label440;
          }
          paramParcel2.writeInt(1);
          ((TangoPoseData)localObject1).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = paramParcel1.readInt();
        paramParcel1 = new TangoConfig();
        paramInt1 = getConfig(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Surface)Surface.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = connectSurface(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 7: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = disconnectSurface(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = resetMotionTracking();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = new ArrayList();
        paramInt1 = saveAreaDescription(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = new ArrayList();
        paramInt1 = getAreaDescriptionUuidList(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = paramParcel1.readString();
        localObject1 = new TangoAreaDescriptionMetaData();
        paramInt1 = loadAreaDescriptionMetaData(paramParcel1, (TangoAreaDescriptionMetaData)localObject1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        if (localObject1 != null)
        {
          paramParcel2.writeInt(1);
          ((TangoAreaDescriptionMetaData)localObject1).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 12: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoAreaDescriptionMetaData)TangoAreaDescriptionMetaData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = saveAreaDescriptionMetaData((String)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 13: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        localObject1 = new ArrayList();
        paramInt1 = importAreaDescriptionFile((List)localObject1, paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList((List)localObject1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = exportAreaDescriptionFile(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = deleteAreaDescription(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = paramParcel1.readInt();
        paramParcel1 = new TangoCameraIntrinsics();
        paramInt1 = getCameraIntrinsics(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 17: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoConfig)TangoConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = setRuntimeConfig(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 18: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoConfig)TangoConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = reportApiUsage(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 19: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = new ArrayList();
        paramInt1 = getDatasetUuids(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = deleteDataset(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = new ArrayList();
        paramInt1 = getCurrentDatasetUuid(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (FoiRequest)FoiRequest.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = foiRequest(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 23: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        d = paramParcel1.readDouble();
        localObject1 = paramParcel1.readString();
        paramParcel1 = paramParcel1.readString();
        localObject2 = new TangoPoseData();
        paramInt1 = getPoseAtTime2(d, (String)localObject1, paramParcel1, (TangoPoseData)localObject2);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        if (localObject2 != null)
        {
          paramParcel2.writeInt(1);
          ((TangoPoseData)localObject2).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 24: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (TangoPoseData)TangoPoseData.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = paramParcel1.createDoubleArray();
          localObject2 = new TangoPlaneData();
          paramInt1 = getPlaneByUVCoord(paramInt1, (TangoPoseData)localObject1, paramParcel1, (TangoPlaneData)localObject2);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          if (localObject2 == null) {
            break label1374;
          }
          paramParcel2.writeInt(1);
          ((TangoPlaneData)localObject2).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          localObject1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 25: 
        label1374:
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
        paramParcel1 = new ArrayList();
        paramInt1 = getPlanes(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeTypedList(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.atap.tangoservice.ITango");
      paramInt1 = startOnlineCalibrationSolve();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements ITango
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public int connect(ITangoListener paramITangoListener, TangoConfig paramTangoConfig)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +72 -> 90
        //   21: aload_1
        //   22: invokeinterface 42 1 0
        //   27: astore_1
        //   28: aload 4
        //   30: aload_1
        //   31: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload_2
        //   35: ifnull +60 -> 95
        //   38: aload 4
        //   40: iconst_1
        //   41: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   44: aload_2
        //   45: aload 4
        //   47: iconst_0
        //   48: invokevirtual 55	com/google/atap/tangoservice/TangoConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   51: aload_0
        //   52: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   55: iconst_1
        //   56: aload 4
        //   58: aload 5
        //   60: iconst_0
        //   61: invokeinterface 61 5 0
        //   66: pop
        //   67: aload 5
        //   69: invokevirtual 64	android/os/Parcel:readException	()V
        //   72: aload 5
        //   74: invokevirtual 68	android/os/Parcel:readInt	()I
        //   77: istore_3
        //   78: aload 5
        //   80: invokevirtual 71	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 71	android/os/Parcel:recycle	()V
        //   88: iload_3
        //   89: ireturn
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -64 -> 28
        //   95: aload 4
        //   97: iconst_0
        //   98: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   101: goto -50 -> 51
        //   104: astore_1
        //   105: aload 5
        //   107: invokevirtual 71	android/os/Parcel:recycle	()V
        //   110: aload 4
        //   112: invokevirtual 71	android/os/Parcel:recycle	()V
        //   115: aload_1
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	Proxy
        //   0	117	1	paramITangoListener	ITangoListener
        //   0	117	2	paramTangoConfig	TangoConfig
        //   77	12	3	i	int
        //   3	108	4	localParcel1	Parcel
        //   8	98	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	104	finally
        //   21	28	104	finally
        //   28	34	104	finally
        //   38	51	104	finally
        //   51	78	104	finally
        //   95	101	104	finally
      }
      
      /* Error */
      public int connectSurface(int paramInt, Surface paramSurface)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +52 -> 73
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 77	android/view/Surface:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   39: bipush 6
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 61 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 64	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 68	android/os/Parcel:readInt	()I
        //   61: istore_1
        //   62: aload 4
        //   64: invokevirtual 71	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 71	android/os/Parcel:recycle	()V
        //   71: iload_1
        //   72: ireturn
        //   73: aload_3
        //   74: iconst_0
        //   75: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   78: goto -43 -> 35
        //   81: astore_2
        //   82: aload 4
        //   84: invokevirtual 71	android/os/Parcel:recycle	()V
        //   87: aload_3
        //   88: invokevirtual 71	android/os/Parcel:recycle	()V
        //   91: aload_2
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramInt	int
        //   0	93	2	paramSurface	Surface
        //   3	85	3	localParcel1	Parcel
        //   7	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	81	finally
        //   24	35	81	finally
        //   35	62	81	finally
        //   73	78	81	finally
      }
      
      public int deleteAreaDescription(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeString(paramString);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int deleteDataset(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeString(paramString);
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int disconnect()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int disconnectSurface(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int exportAreaDescriptionFile(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public int foiRequest(FoiRequest paramFoiRequest)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 93	com/google/atap/tangoservice/fois/FoiRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 22
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 61 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 64	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 68	android/os/Parcel:readInt	()I
        //   56: istore_2
        //   57: aload 4
        //   59: invokevirtual 71	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 71	android/os/Parcel:recycle	()V
        //   66: iload_2
        //   67: ireturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   73: goto -43 -> 30
        //   76: astore_1
        //   77: aload 4
        //   79: invokevirtual 71	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 71	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	Proxy
        //   0	88	1	paramFoiRequest	FoiRequest
        //   56	11	2	i	int
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	76	finally
        //   19	30	76	finally
        //   30	57	76	finally
        //   68	73	76	finally
      }
      
      public int getAreaDescriptionUuidList(List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readStringList(paramList);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getCameraIntrinsics(int paramInt, TangoCameraIntrinsics paramTangoCameraIntrinsics)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (localParcel2.readInt() != 0) {
            paramTangoCameraIntrinsics.readFromParcel(localParcel2);
          }
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getConfig(int paramInt, TangoConfig paramTangoConfig)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (localParcel2.readInt() != 0) {
            paramTangoConfig.readFromParcel(localParcel2);
          }
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getCurrentDatasetUuid(List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readStringList(paramList);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getDatasetUuids(List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readStringList(paramList);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.google.atap.tangoservice.ITango";
      }
      
      /* Error */
      public int getPlaneByUVCoord(int paramInt, TangoPoseData paramTangoPoseData, double[] paramArrayOfDouble, TangoPlaneData paramTangoPlaneData)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: iload_1
        //   20: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   23: aload_2
        //   24: ifnull +77 -> 101
        //   27: aload 5
        //   29: iconst_1
        //   30: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 5
        //   36: iconst_0
        //   37: invokevirtual 121	com/google/atap/tangoservice/TangoPoseData:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload 5
        //   42: aload_3
        //   43: invokevirtual 125	android/os/Parcel:writeDoubleArray	([D)V
        //   46: aload_0
        //   47: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   50: bipush 24
        //   52: aload 5
        //   54: aload 6
        //   56: iconst_0
        //   57: invokeinterface 61 5 0
        //   62: pop
        //   63: aload 6
        //   65: invokevirtual 64	android/os/Parcel:readException	()V
        //   68: aload 6
        //   70: invokevirtual 68	android/os/Parcel:readInt	()I
        //   73: istore_1
        //   74: aload 6
        //   76: invokevirtual 68	android/os/Parcel:readInt	()I
        //   79: ifeq +10 -> 89
        //   82: aload 4
        //   84: aload 6
        //   86: invokevirtual 128	com/google/atap/tangoservice/experimental/TangoPlaneData:readFromParcel	(Landroid/os/Parcel;)V
        //   89: aload 6
        //   91: invokevirtual 71	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 71	android/os/Parcel:recycle	()V
        //   99: iload_1
        //   100: ireturn
        //   101: aload 5
        //   103: iconst_0
        //   104: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   107: goto -67 -> 40
        //   110: astore_2
        //   111: aload 6
        //   113: invokevirtual 71	android/os/Parcel:recycle	()V
        //   116: aload 5
        //   118: invokevirtual 71	android/os/Parcel:recycle	()V
        //   121: aload_2
        //   122: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	this	Proxy
        //   0	123	1	paramInt	int
        //   0	123	2	paramTangoPoseData	TangoPoseData
        //   0	123	3	paramArrayOfDouble	double[]
        //   0	123	4	paramTangoPlaneData	TangoPlaneData
        //   3	114	5	localParcel1	Parcel
        //   8	104	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	110	finally
        //   27	40	110	finally
        //   40	89	110	finally
        //   101	107	110	finally
      }
      
      public int getPlanes(List<TangoPlaneData> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readTypedList(paramList, TangoPlaneData.CREATOR);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public int getPoseAtTime(double paramDouble, TangoCoordinateFramePair paramTangoCoordinateFramePair, TangoPoseData paramTangoPoseData)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: dload_1
        //   20: invokevirtual 144	android/os/Parcel:writeDouble	(D)V
        //   23: aload_3
        //   24: ifnull +72 -> 96
        //   27: aload 6
        //   29: iconst_1
        //   30: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   33: aload_3
        //   34: aload 6
        //   36: iconst_0
        //   37: invokevirtual 147	com/google/atap/tangoservice/TangoCoordinateFramePair:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: iconst_4
        //   45: aload 6
        //   47: aload 7
        //   49: iconst_0
        //   50: invokeinterface 61 5 0
        //   55: pop
        //   56: aload 7
        //   58: invokevirtual 64	android/os/Parcel:readException	()V
        //   61: aload 7
        //   63: invokevirtual 68	android/os/Parcel:readInt	()I
        //   66: istore 5
        //   68: aload 7
        //   70: invokevirtual 68	android/os/Parcel:readInt	()I
        //   73: ifeq +10 -> 83
        //   76: aload 4
        //   78: aload 7
        //   80: invokevirtual 148	com/google/atap/tangoservice/TangoPoseData:readFromParcel	(Landroid/os/Parcel;)V
        //   83: aload 7
        //   85: invokevirtual 71	android/os/Parcel:recycle	()V
        //   88: aload 6
        //   90: invokevirtual 71	android/os/Parcel:recycle	()V
        //   93: iload 5
        //   95: ireturn
        //   96: aload 6
        //   98: iconst_0
        //   99: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   102: goto -62 -> 40
        //   105: astore_3
        //   106: aload 7
        //   108: invokevirtual 71	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: invokevirtual 71	android/os/Parcel:recycle	()V
        //   116: aload_3
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	Proxy
        //   0	118	1	paramDouble	double
        //   0	118	3	paramTangoCoordinateFramePair	TangoCoordinateFramePair
        //   0	118	4	paramTangoPoseData	TangoPoseData
        //   66	28	5	i	int
        //   3	109	6	localParcel1	Parcel
        //   8	99	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	105	finally
        //   27	40	105	finally
        //   40	83	105	finally
        //   96	102	105	finally
      }
      
      public int getPoseAtTime2(double paramDouble, String paramString1, String paramString2, TangoPoseData paramTangoPoseData)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeDouble(paramDouble);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (localParcel2.readInt() != 0) {
            paramTangoPoseData.readFromParcel(localParcel2);
          }
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int importAreaDescriptionFile(List<String> paramList, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeString(paramString);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readStringList(paramList);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int loadAreaDescriptionMetaData(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeString(paramString);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (localParcel2.readInt() != 0) {
            paramTangoAreaDescriptionMetaData.readFromParcel(localParcel2);
          }
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public int reportApiUsage(TangoConfig paramTangoConfig)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 55	com/google/atap/tangoservice/TangoConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 18
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 61 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 64	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 68	android/os/Parcel:readInt	()I
        //   56: istore_2
        //   57: aload 4
        //   59: invokevirtual 71	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 71	android/os/Parcel:recycle	()V
        //   66: iload_2
        //   67: ireturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   73: goto -43 -> 30
        //   76: astore_1
        //   77: aload 4
        //   79: invokevirtual 71	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 71	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	Proxy
        //   0	88	1	paramTangoConfig	TangoConfig
        //   56	11	2	i	int
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	76	finally
        //   19	30	76	finally
        //   30	57	76	finally
        //   68	73	76	finally
      }
      
      public int resetMotionTracking()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int saveAreaDescription(List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.readStringList(paramList);
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public int saveAreaDescriptionMetaData(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 82	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnull +56 -> 80
        //   27: aload 4
        //   29: iconst_1
        //   30: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 4
        //   36: iconst_0
        //   37: invokevirtual 164	com/google/atap/tangoservice/TangoAreaDescriptionMetaData:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: bipush 12
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 61 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 64	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 68	android/os/Parcel:readInt	()I
        //   67: istore_3
        //   68: aload 5
        //   70: invokevirtual 71	android/os/Parcel:recycle	()V
        //   73: aload 4
        //   75: invokevirtual 71	android/os/Parcel:recycle	()V
        //   78: iload_3
        //   79: ireturn
        //   80: aload 4
        //   82: iconst_0
        //   83: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   86: goto -46 -> 40
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 71	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 71	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	Proxy
        //   0	102	1	paramString	String
        //   0	102	2	paramTangoAreaDescriptionMetaData	TangoAreaDescriptionMetaData
        //   67	12	3	i	int
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	89	finally
        //   27	40	89	finally
        //   40	68	89	finally
        //   80	86	89	finally
      }
      
      public int setPoseListenerFrames(List<TangoCoordinateFramePair> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          localParcel1.writeTypedList(paramList);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public int setRuntimeConfig(TangoConfig paramTangoConfig)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 55	com/google/atap/tangoservice/TangoConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 19	com/google/atap/tangoservice/ITango$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 17
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 61 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 64	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 68	android/os/Parcel:readInt	()I
        //   56: istore_2
        //   57: aload 4
        //   59: invokevirtual 71	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 71	android/os/Parcel:recycle	()V
        //   66: iload_2
        //   67: ireturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   73: goto -43 -> 30
        //   76: astore_1
        //   77: aload 4
        //   79: invokevirtual 71	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 71	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	Proxy
        //   0	88	1	paramTangoConfig	TangoConfig
        //   56	11	2	i	int
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	76	finally
        //   19	30	76	finally
        //   30	57	76	finally
        //   68	73	76	finally
      }
      
      public int startOnlineCalibrationSolve()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITango");
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/ITango.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */