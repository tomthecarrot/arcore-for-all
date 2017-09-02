package com.google.atap.tangoservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.atap.tangoservice.fois.FoiResponse;

public abstract interface ITangoListener
  extends IInterface
{
  public abstract void onFoiResponse(FoiResponse paramFoiResponse)
    throws RemoteException;
  
  public abstract void onGraphicBufferAvailable(int paramInt)
    throws RemoteException;
  
  public abstract void onOnlineCalibrationStatus(int paramInt)
    throws RemoteException;
  
  public abstract void onPointCloudAvailable(TangoPointCloudData paramTangoPointCloudData)
    throws RemoteException;
  
  public abstract void onPoseAvailable(TangoPoseData paramTangoPoseData)
    throws RemoteException;
  
  public abstract void onTangoEvent(TangoEvent paramTangoEvent)
    throws RemoteException;
  
  public abstract void onXyzIjAvailable()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITangoListener
  {
    private static final String DESCRIPTOR = "com.google.atap.tangoservice.ITangoListener";
    static final int TRANSACTION_onFoiResponse = 6;
    static final int TRANSACTION_onGraphicBufferAvailable = 4;
    static final int TRANSACTION_onOnlineCalibrationStatus = 7;
    static final int TRANSACTION_onPointCloudAvailable = 5;
    static final int TRANSACTION_onPoseAvailable = 1;
    static final int TRANSACTION_onTangoEvent = 3;
    static final int TRANSACTION_onXyzIjAvailable = 2;
    
    public Stub()
    {
      attachInterface(this, "com.google.atap.tangoservice.ITangoListener");
    }
    
    public static ITangoListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.atap.tangoservice.ITangoListener");
      if ((localIInterface != null) && ((localIInterface instanceof ITangoListener))) {
        return (ITangoListener)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.atap.tangoservice.ITangoListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoPoseData)TangoPoseData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onPoseAvailable(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        onXyzIjAvailable();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoEvent)TangoEvent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onTangoEvent(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        onGraphicBufferAvailable(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (TangoPointCloudData)TangoPointCloudData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onPointCloudAvailable(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (FoiResponse)FoiResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onFoiResponse(paramParcel1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoListener");
      onOnlineCalibrationStatus(paramParcel1.readInt());
      return true;
    }
    
    private static class Proxy
      implements ITangoListener
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
      
      public String getInterfaceDescriptor()
      {
        return "com.google.atap.tangoservice.ITangoListener";
      }
      
      /* Error */
      public void onFoiResponse(FoiResponse paramFoiResponse)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 26
        //   7: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 50	com/google/atap/tangoservice/fois/FoiResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 19	com/google/atap/tangoservice/ITangoListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   29: bipush 6
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 56 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 59	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 59	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	Proxy
        //   0	60	1	paramFoiResponse	FoiResponse
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      public void onGraphicBufferAvailable(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITangoListener");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onOnlineCalibrationStatus(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.atap.tangoservice.ITangoListener");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(7, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void onPointCloudAvailable(TangoPointCloudData paramTangoPointCloudData)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 70	com/google/atap/tangoservice/TangoPointCloudData:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/google/atap/tangoservice/ITangoListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_5
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 56 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 64	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 59	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 59	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 59	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 59	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramTangoPointCloudData	TangoPointCloudData
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public void onPoseAvailable(TangoPoseData paramTangoPoseData)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 75	com/google/atap/tangoservice/TangoPoseData:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/google/atap/tangoservice/ITangoListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 56 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 64	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 59	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 59	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 59	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 59	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramTangoPoseData	TangoPoseData
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public void onTangoEvent(TangoEvent paramTangoEvent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 80	com/google/atap/tangoservice/TangoEvent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/google/atap/tangoservice/ITangoListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_3
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 56 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 64	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 59	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 59	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 59	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 59	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramTangoEvent	TangoEvent
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void onXyzIjAvailable()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITangoListener");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/ITangoListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */