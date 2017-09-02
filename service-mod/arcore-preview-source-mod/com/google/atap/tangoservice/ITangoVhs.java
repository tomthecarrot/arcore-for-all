package com.google.atap.tangoservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

public abstract interface ITangoVhs
  extends IInterface
{
  public abstract Surface getTrackingSurface()
    throws RemoteException;
  
  public abstract void onMetadata(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    throws RemoteException;
  
  public abstract int setDatasetPathAndUUID(String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITangoVhs
  {
    private static final String DESCRIPTOR = "com.google.atap.tangoservice.ITangoVhs";
    static final int TRANSACTION_getTrackingSurface = 1;
    static final int TRANSACTION_onMetadata = 2;
    static final int TRANSACTION_setDatasetPathAndUUID = 3;
    
    public Stub()
    {
      attachInterface(this, "com.google.atap.tangoservice.ITangoVhs");
    }
    
    public static ITangoVhs asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.atap.tangoservice.ITangoVhs");
      if ((localIInterface != null) && ((localIInterface instanceof ITangoVhs))) {
        return (ITangoVhs)localIInterface;
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
        paramParcel2.writeString("com.google.atap.tangoservice.ITangoVhs");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoVhs");
        paramParcel1 = getTrackingSurface();
        paramParcel2.writeNoException();
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
      case 2: 
        paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoVhs");
        onMetadata(paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.atap.tangoservice.ITangoVhs");
      paramInt1 = setDatasetPathAndUUID(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements ITangoVhs
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
        return "com.google.atap.tangoservice.ITangoVhs";
      }
      
      /* Error */
      public Surface getTrackingSurface()
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
        //   14: aload_0
        //   15: getfield 19	com/google/atap/tangoservice/ITangoVhs$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 46 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 49	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 53	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 59	android/view/Surface:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 65 2 0
        //   48: checkcast 55	android/view/Surface
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 68	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 68	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 68	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 68	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	Proxy
        //   51	13	1	localSurface	Surface
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public void onMetadata(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITangoVhs");
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          localParcel1.writeLong(paramLong3);
          localParcel1.writeLong(paramLong4);
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
      
      public int setDatasetPathAndUUID(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.atap.tangoservice.ITangoVhs");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
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
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/ITangoVhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */