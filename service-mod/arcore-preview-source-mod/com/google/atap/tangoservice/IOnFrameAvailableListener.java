package com.google.atap.tangoservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.tango.loader.IObjectWrapper;
import com.google.tango.loader.IObjectWrapper.Stub;

public abstract interface IOnFrameAvailableListener
  extends IInterface
{
  public abstract void onFrameAvailable(int paramInt1, int paramInt2, int paramInt3, long paramLong1, double paramDouble, int paramInt4, IObjectWrapper paramIObjectWrapper, int paramInt5, long paramLong2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOnFrameAvailableListener
  {
    private static final String DESCRIPTOR = "com.google.atap.tangoservice.IOnFrameAvailableListener";
    static final int TRANSACTION_onFrameAvailable = 1;
    
    public Stub()
    {
      attachInterface(this, "com.google.atap.tangoservice.IOnFrameAvailableListener");
    }
    
    public static IOnFrameAvailableListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.atap.tangoservice.IOnFrameAvailableListener");
      if ((localIInterface != null) && ((localIInterface instanceof IOnFrameAvailableListener))) {
        return (IOnFrameAvailableListener)localIInterface;
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
        paramParcel2.writeString("com.google.atap.tangoservice.IOnFrameAvailableListener");
        return true;
      }
      paramParcel1.enforceInterface("com.google.atap.tangoservice.IOnFrameAvailableListener");
      onFrameAvailable(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readDouble(), paramParcel1.readInt(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IOnFrameAvailableListener
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
        return "com.google.atap.tangoservice.IOnFrameAvailableListener";
      }
      
      /* Error */
      public void onFrameAvailable(int paramInt1, int paramInt2, int paramInt3, long paramLong1, double paramDouble, int paramInt4, IObjectWrapper paramIObjectWrapper, int paramInt5, long paramLong2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 13
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 14
        //   10: aload 13
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 13
        //   19: iload_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload 13
        //   25: iload_2
        //   26: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   29: aload 13
        //   31: iload_3
        //   32: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   35: aload 13
        //   37: lload 4
        //   39: invokevirtual 48	android/os/Parcel:writeLong	(J)V
        //   42: aload 13
        //   44: dload 6
        //   46: invokevirtual 52	android/os/Parcel:writeDouble	(D)V
        //   49: aload 13
        //   51: iload 8
        //   53: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   56: aload 9
        //   58: ifnull +65 -> 123
        //   61: aload 9
        //   63: invokeinterface 56 1 0
        //   68: astore 9
        //   70: aload 13
        //   72: aload 9
        //   74: invokevirtual 59	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   77: aload 13
        //   79: iload 10
        //   81: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   84: aload 13
        //   86: lload 11
        //   88: invokevirtual 48	android/os/Parcel:writeLong	(J)V
        //   91: aload_0
        //   92: getfield 19	com/google/atap/tangoservice/IOnFrameAvailableListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   95: iconst_1
        //   96: aload 13
        //   98: aload 14
        //   100: iconst_0
        //   101: invokeinterface 65 5 0
        //   106: pop
        //   107: aload 14
        //   109: invokevirtual 68	android/os/Parcel:readException	()V
        //   112: aload 14
        //   114: invokevirtual 71	android/os/Parcel:recycle	()V
        //   117: aload 13
        //   119: invokevirtual 71	android/os/Parcel:recycle	()V
        //   122: return
        //   123: aconst_null
        //   124: astore 9
        //   126: goto -56 -> 70
        //   129: astore 9
        //   131: aload 14
        //   133: invokevirtual 71	android/os/Parcel:recycle	()V
        //   136: aload 13
        //   138: invokevirtual 71	android/os/Parcel:recycle	()V
        //   141: aload 9
        //   143: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	144	0	this	Proxy
        //   0	144	1	paramInt1	int
        //   0	144	2	paramInt2	int
        //   0	144	3	paramInt3	int
        //   0	144	4	paramLong1	long
        //   0	144	6	paramDouble	double
        //   0	144	8	paramInt4	int
        //   0	144	9	paramIObjectWrapper	IObjectWrapper
        //   0	144	10	paramInt5	int
        //   0	144	11	paramLong2	long
        //   3	134	13	localParcel1	Parcel
        //   8	124	14	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	56	129	finally
        //   61	70	129	finally
        //   70	112	129	finally
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/IOnFrameAvailableListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */