package com.google.tango.loader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.atap.tangoservice.IOnFrameAvailableListener;
import com.google.atap.tangoservice.IOnFrameAvailableListener.Stub;
import com.google.atap.tangoservice.IOnImageAvailableListener;
import com.google.atap.tangoservice.IOnImageAvailableListener.Stub;
import com.google.atap.tangoservice.ITangoListener;
import com.google.atap.tangoservice.ITangoListener.Stub;

public abstract interface ITangoCameraNative
  extends IInterface
{
  public abstract int connectOnFrameAvailable(int paramInt, IOnFrameAvailableListener paramIOnFrameAvailableListener, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int connectOnImageAvailable(int paramInt, IOnImageAvailableListener paramIOnImageAvailableListener, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int connectOnTextureAvailable(int paramInt, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int connectTextureId(int paramInt1, int paramInt2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int disconnectCamera(int paramInt)
    throws RemoteException;
  
  public abstract int initialize(IObjectWrapper paramIObjectWrapper, ITangoListener paramITangoListener)
    throws RemoteException;
  
  public abstract int lockCameraBuffer(int paramInt, double[] paramArrayOfDouble, long[] paramArrayOfLong)
    throws RemoteException;
  
  public abstract int setDatasetPathAndUUID(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract int startCamerasIfNeeded()
    throws RemoteException;
  
  public abstract int stopAllCameras()
    throws RemoteException;
  
  public abstract int unlockCameraBuffer(int paramInt, long paramLong)
    throws RemoteException;
  
  public abstract int updateTexture(int paramInt, double[] paramArrayOfDouble)
    throws RemoteException;
  
  public abstract int updateTextureExternalOes(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
    throws RemoteException;
  
  public abstract int updateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITangoCameraNative
  {
    private static final String DESCRIPTOR = "com.google.tango.loader.ITangoCameraNative";
    static final int TRANSACTION_connectOnFrameAvailable = 5;
    static final int TRANSACTION_connectOnImageAvailable = 14;
    static final int TRANSACTION_connectOnTextureAvailable = 9;
    static final int TRANSACTION_connectTextureId = 3;
    static final int TRANSACTION_disconnectCamera = 7;
    static final int TRANSACTION_initialize = 2;
    static final int TRANSACTION_lockCameraBuffer = 11;
    static final int TRANSACTION_setDatasetPathAndUUID = 15;
    static final int TRANSACTION_startCamerasIfNeeded = 6;
    static final int TRANSACTION_stopAllCameras = 8;
    static final int TRANSACTION_unlockCameraBuffer = 12;
    static final int TRANSACTION_updateTexture = 4;
    static final int TRANSACTION_updateTextureExternalOes = 10;
    static final int TRANSACTION_updateTextureExternalOesForBuffer = 13;
    
    public Stub()
    {
      attachInterface(this, "com.google.tango.loader.ITangoCameraNative");
    }
    
    public static ITangoCameraNative asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.tango.loader.ITangoCameraNative");
      if ((localIInterface != null) && ((localIInterface instanceof ITangoCameraNative))) {
        return (ITangoCameraNative)localIInterface;
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
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool1 = false;
      Object localObject;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.tango.loader.ITangoCameraNative");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = initialize(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), ITangoListener.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramInt1 = connectTextureId(paramInt1, paramInt2, bool1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramInt2 < 0) {}
        for (paramParcel1 = null;; paramParcel1 = new double[paramInt2])
        {
          paramInt1 = updateTexture(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          paramParcel2.writeDoubleArray(paramParcel1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        localObject = IOnFrameAvailableListener.Stub.asInterface(paramParcel1.readStrongBinder());
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramInt1 = connectOnFrameAvailable(paramInt1, (IOnFrameAvailableListener)localObject, bool1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = startCamerasIfNeeded();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = disconnectCamera(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = stopAllCameras();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          paramInt1 = connectOnTextureAvailable(paramInt1, bool1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 10: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        int i = paramParcel1.readInt();
        if (i < 0) {}
        for (paramParcel1 = null;; paramParcel1 = new double[i])
        {
          paramInt1 = updateTextureExternalOes(paramInt1, paramInt2, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          paramParcel2.writeDoubleArray(paramParcel1);
          return true;
        }
      case 11: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramInt2 < 0)
        {
          localObject = null;
          paramInt2 = paramParcel1.readInt();
          if (paramInt2 >= 0) {
            break label609;
          }
        }
        for (paramParcel1 = null;; paramParcel1 = new long[paramInt2])
        {
          paramInt1 = lockCameraBuffer(paramInt1, (double[])localObject, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          paramParcel2.writeDoubleArray((double[])localObject);
          paramParcel2.writeLongArray(paramParcel1);
          return true;
          localObject = new double[paramInt2];
          break;
        }
      case 12: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = unlockCameraBuffer(paramParcel1.readInt(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = updateTextureExternalOesForBuffer(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        label609:
        paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
        paramInt1 = paramParcel1.readInt();
        localObject = IOnImageAvailableListener.Stub.asInterface(paramParcel1.readStrongBinder());
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramInt1 = connectOnImageAvailable(paramInt1, (IOnImageAvailableListener)localObject, bool1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.tango.loader.ITangoCameraNative");
      paramInt1 = setDatasetPathAndUUID(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements ITangoCameraNative
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
      public int connectOnFrameAvailable(int paramInt, IOnFrameAvailableListener paramIOnFrameAvailableListener, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 34
        //   17: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: iload_1
        //   23: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   26: aload_2
        //   27: ifnull +70 -> 97
        //   30: aload_2
        //   31: invokeinterface 46 1 0
        //   36: astore_2
        //   37: aload 5
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: iload 4
        //   45: istore_1
        //   46: iload_3
        //   47: ifeq +5 -> 52
        //   50: iconst_1
        //   51: istore_1
        //   52: aload 5
        //   54: iload_1
        //   55: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   58: aload_0
        //   59: getfield 19	com/google/tango/loader/ITangoCameraNative$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   62: iconst_5
        //   63: aload 5
        //   65: aload 6
        //   67: iconst_0
        //   68: invokeinterface 55 5 0
        //   73: pop
        //   74: aload 6
        //   76: invokevirtual 58	android/os/Parcel:readException	()V
        //   79: aload 6
        //   81: invokevirtual 62	android/os/Parcel:readInt	()I
        //   84: istore_1
        //   85: aload 6
        //   87: invokevirtual 65	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: invokevirtual 65	android/os/Parcel:recycle	()V
        //   95: iload_1
        //   96: ireturn
        //   97: aconst_null
        //   98: astore_2
        //   99: goto -62 -> 37
        //   102: astore_2
        //   103: aload 6
        //   105: invokevirtual 65	android/os/Parcel:recycle	()V
        //   108: aload 5
        //   110: invokevirtual 65	android/os/Parcel:recycle	()V
        //   113: aload_2
        //   114: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	115	0	this	Proxy
        //   0	115	1	paramInt	int
        //   0	115	2	paramIOnFrameAvailableListener	IOnFrameAvailableListener
        //   0	115	3	paramBoolean	boolean
        //   1	43	4	i	int
        //   6	103	5	localParcel1	Parcel
        //   11	93	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	102	finally
        //   30	37	102	finally
        //   37	43	102	finally
        //   52	85	102	finally
      }
      
      /* Error */
      public int connectOnImageAvailable(int paramInt, IOnImageAvailableListener paramIOnImageAvailableListener, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 34
        //   17: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: iload_1
        //   23: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   26: aload_2
        //   27: ifnull +71 -> 98
        //   30: aload_2
        //   31: invokeinterface 71 1 0
        //   36: astore_2
        //   37: aload 5
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: iload 4
        //   45: istore_1
        //   46: iload_3
        //   47: ifeq +5 -> 52
        //   50: iconst_1
        //   51: istore_1
        //   52: aload 5
        //   54: iload_1
        //   55: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   58: aload_0
        //   59: getfield 19	com/google/tango/loader/ITangoCameraNative$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   62: bipush 14
        //   64: aload 5
        //   66: aload 6
        //   68: iconst_0
        //   69: invokeinterface 55 5 0
        //   74: pop
        //   75: aload 6
        //   77: invokevirtual 58	android/os/Parcel:readException	()V
        //   80: aload 6
        //   82: invokevirtual 62	android/os/Parcel:readInt	()I
        //   85: istore_1
        //   86: aload 6
        //   88: invokevirtual 65	android/os/Parcel:recycle	()V
        //   91: aload 5
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: iload_1
        //   97: ireturn
        //   98: aconst_null
        //   99: astore_2
        //   100: goto -63 -> 37
        //   103: astore_2
        //   104: aload 6
        //   106: invokevirtual 65	android/os/Parcel:recycle	()V
        //   109: aload 5
        //   111: invokevirtual 65	android/os/Parcel:recycle	()V
        //   114: aload_2
        //   115: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	Proxy
        //   0	116	1	paramInt	int
        //   0	116	2	paramIOnImageAvailableListener	IOnImageAvailableListener
        //   0	116	3	paramBoolean	boolean
        //   1	43	4	i	int
        //   6	104	5	localParcel1	Parcel
        //   11	94	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	103	finally
        //   30	37	103	finally
        //   37	43	103	finally
        //   52	86	103	finally
      }
      
      public int connectOnTextureAvailable(int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          localParcel1.writeInt(paramInt);
          paramInt = i;
          if (paramBoolean) {
            paramInt = 1;
          }
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      
      public int connectTextureId(int paramInt1, int paramInt2, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          paramInt1 = i;
          if (paramBoolean) {
            paramInt1 = 1;
          }
          localParcel1.writeInt(paramInt1);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int disconnectCamera(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
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
      
      public String getInterfaceDescriptor()
      {
        return "com.google.tango.loader.ITangoCameraNative";
      }
      
      /* Error */
      public int initialize(IObjectWrapper paramIObjectWrapper, ITangoListener paramITangoListener)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 34
        //   17: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +75 -> 96
        //   24: aload_1
        //   25: invokeinterface 84 1 0
        //   30: astore_1
        //   31: aload 5
        //   33: aload_1
        //   34: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   37: aload 4
        //   39: astore_1
        //   40: aload_2
        //   41: ifnull +10 -> 51
        //   44: aload_2
        //   45: invokeinterface 87 1 0
        //   50: astore_1
        //   51: aload 5
        //   53: aload_1
        //   54: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   57: aload_0
        //   58: getfield 19	com/google/tango/loader/ITangoCameraNative$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   61: iconst_2
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 55 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 58	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 62	android/os/Parcel:readInt	()I
        //   83: istore_3
        //   84: aload 6
        //   86: invokevirtual 65	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: invokevirtual 65	android/os/Parcel:recycle	()V
        //   94: iload_3
        //   95: ireturn
        //   96: aconst_null
        //   97: astore_1
        //   98: goto -67 -> 31
        //   101: astore_1
        //   102: aload 6
        //   104: invokevirtual 65	android/os/Parcel:recycle	()V
        //   107: aload 5
        //   109: invokevirtual 65	android/os/Parcel:recycle	()V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIObjectWrapper	IObjectWrapper
        //   0	114	2	paramITangoListener	ITangoListener
        //   83	12	3	i	int
        //   1	37	4	localObject	Object
        //   6	102	5	localParcel1	Parcel
        //   11	92	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	101	finally
        //   24	31	101	finally
        //   31	37	101	finally
        //   44	51	101	finally
        //   51	84	101	finally
      }
      
      public int lockCameraBuffer(int paramInt, double[] paramArrayOfDouble, long[] paramArrayOfLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
            localParcel1.writeInt(paramInt);
            if (paramArrayOfDouble == null)
            {
              localParcel1.writeInt(-1);
              if (paramArrayOfLong == null)
              {
                localParcel1.writeInt(-1);
                this.mRemote.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramInt = localParcel2.readInt();
                localParcel2.readDoubleArray(paramArrayOfDouble);
                localParcel2.readLongArray(paramArrayOfLong);
                return paramInt;
              }
            }
            else
            {
              localParcel1.writeInt(paramArrayOfDouble.length);
              continue;
            }
            localParcel1.writeInt(paramArrayOfLong.length);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int setDatasetPathAndUUID(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
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
      
      public int startCamerasIfNeeded()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
      
      public int stopAllCameras()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
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
      
      public int unlockCameraBuffer(int paramInt, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          localParcel1.writeInt(paramInt);
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public int updateTexture(int paramInt, double[] paramArrayOfDouble)
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
        //   17: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnonnull +51 -> 72
        //   24: aload_3
        //   25: iconst_m1
        //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   29: aload_0
        //   30: getfield 19	com/google/tango/loader/ITangoCameraNative$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_4
        //   34: aload_3
        //   35: aload 4
        //   37: iconst_0
        //   38: invokeinterface 55 5 0
        //   43: pop
        //   44: aload 4
        //   46: invokevirtual 58	android/os/Parcel:readException	()V
        //   49: aload 4
        //   51: invokevirtual 62	android/os/Parcel:readInt	()I
        //   54: istore_1
        //   55: aload 4
        //   57: aload_2
        //   58: invokevirtual 93	android/os/Parcel:readDoubleArray	([D)V
        //   61: aload 4
        //   63: invokevirtual 65	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 65	android/os/Parcel:recycle	()V
        //   70: iload_1
        //   71: ireturn
        //   72: aload_3
        //   73: aload_2
        //   74: arraylength
        //   75: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   78: goto -49 -> 29
        //   81: astore_2
        //   82: aload 4
        //   84: invokevirtual 65	android/os/Parcel:recycle	()V
        //   87: aload_3
        //   88: invokevirtual 65	android/os/Parcel:recycle	()V
        //   91: aload_2
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramInt	int
        //   0	93	2	paramArrayOfDouble	double[]
        //   3	85	3	localParcel1	Parcel
        //   7	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	81	finally
        //   24	29	81	finally
        //   29	61	81	finally
        //   72	78	81	finally
      }
      
      /* Error */
      public int updateTextureExternalOes(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
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
        //   19: iload_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload 4
        //   25: iload_2
        //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnonnull +55 -> 85
        //   33: aload 4
        //   35: iconst_m1
        //   36: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   39: aload_0
        //   40: getfield 19	com/google/tango/loader/ITangoCameraNative$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   43: bipush 10
        //   45: aload 4
        //   47: aload 5
        //   49: iconst_0
        //   50: invokeinterface 55 5 0
        //   55: pop
        //   56: aload 5
        //   58: invokevirtual 58	android/os/Parcel:readException	()V
        //   61: aload 5
        //   63: invokevirtual 62	android/os/Parcel:readInt	()I
        //   66: istore_1
        //   67: aload 5
        //   69: aload_3
        //   70: invokevirtual 93	android/os/Parcel:readDoubleArray	([D)V
        //   73: aload 5
        //   75: invokevirtual 65	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 65	android/os/Parcel:recycle	()V
        //   83: iload_1
        //   84: ireturn
        //   85: aload 4
        //   87: aload_3
        //   88: arraylength
        //   89: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   92: goto -53 -> 39
        //   95: astore_3
        //   96: aload 5
        //   98: invokevirtual 65	android/os/Parcel:recycle	()V
        //   101: aload 4
        //   103: invokevirtual 65	android/os/Parcel:recycle	()V
        //   106: aload_3
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	Proxy
        //   0	108	1	paramInt1	int
        //   0	108	2	paramInt2	int
        //   0	108	3	paramArrayOfDouble	double[]
        //   3	99	4	localParcel1	Parcel
        //   8	89	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	95	finally
        //   33	39	95	finally
        //   39	73	95	finally
        //   85	92	95	finally
      }
      
      public int updateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.tango.loader.ITangoCameraNative");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/loader/ITangoCameraNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */