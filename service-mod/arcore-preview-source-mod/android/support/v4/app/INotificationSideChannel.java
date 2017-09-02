package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface INotificationSideChannel
  extends IInterface
{
  public abstract void cancel(String paramString1, int paramInt, String paramString2)
    throws RemoteException;
  
  public abstract void cancelAll(String paramString)
    throws RemoteException;
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements INotificationSideChannel
  {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.app.INotificationSideChannel");
    }
    
    public static INotificationSideChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
      if ((localIInterface != null) && ((localIInterface instanceof INotificationSideChannel))) {
        return (INotificationSideChannel)localIInterface;
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
        paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
        return true;
      case 1: 
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        paramParcel2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          notify(paramParcel2, paramInt1, str, paramParcel1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      cancelAll(paramParcel1.readString());
      return true;
    }
    
    private static class Proxy
      implements INotificationSideChannel
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
      
      public void cancel(String paramString1, int paramInt, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void cancelAll(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "android.support.v4.app.INotificationSideChannel";
      }
      
      /* Error */
      public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: aload 5
        //   7: ldc 34
        //   9: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 5
        //   14: aload_1
        //   15: invokevirtual 41	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload 5
        //   20: iload_2
        //   21: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   24: aload 5
        //   26: aload_3
        //   27: invokevirtual 41	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload 4
        //   32: ifnull +38 -> 70
        //   35: aload 5
        //   37: iconst_1
        //   38: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   41: aload 4
        //   43: aload 5
        //   45: iconst_0
        //   46: invokevirtual 66	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
        //   49: aload_0
        //   50: getfield 19	android/support/v4/app/INotificationSideChannel$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   53: iconst_1
        //   54: aload 5
        //   56: aconst_null
        //   57: iconst_1
        //   58: invokeinterface 51 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 54	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 5
        //   72: iconst_0
        //   73: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   76: goto -27 -> 49
        //   79: astore_1
        //   80: aload 5
        //   82: invokevirtual 54	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	Proxy
        //   0	87	1	paramString1	String
        //   0	87	2	paramInt	int
        //   0	87	3	paramString2	String
        //   0	87	4	paramNotification	Notification
        //   3	78	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	30	79	finally
        //   35	49	79	finally
        //   49	64	79	finally
        //   70	76	79	finally
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/app/INotificationSideChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */