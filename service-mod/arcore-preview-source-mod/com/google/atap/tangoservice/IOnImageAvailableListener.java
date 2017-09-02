package com.google.atap.tangoservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.tango.loader.IObjectWrapper;
import com.google.tango.loader.IObjectWrapper.Stub;

public abstract interface IOnImageAvailableListener
  extends IInterface
{
  public abstract void onImageAvailable(int paramInt, TangoImage paramTangoImage, TangoCameraMetadata paramTangoCameraMetadata, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, IObjectWrapper paramIObjectWrapper4)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOnImageAvailableListener
  {
    private static final String DESCRIPTOR = "com.google.atap.tangoservice.IOnImageAvailableListener";
    static final int TRANSACTION_onImageAvailable = 1;
    
    public Stub()
    {
      attachInterface(this, "com.google.atap.tangoservice.IOnImageAvailableListener");
    }
    
    public static IOnImageAvailableListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.atap.tangoservice.IOnImageAvailableListener");
      if ((localIInterface != null) && ((localIInterface instanceof IOnImageAvailableListener))) {
        return (IOnImageAvailableListener)localIInterface;
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
        paramParcel2.writeString("com.google.atap.tangoservice.IOnImageAvailableListener");
        return true;
      }
      paramParcel1.enforceInterface("com.google.atap.tangoservice.IOnImageAvailableListener");
      paramInt1 = paramParcel1.readInt();
      TangoImage localTangoImage;
      if (paramParcel1.readInt() != 0)
      {
        localTangoImage = (TangoImage)TangoImage.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label148;
        }
      }
      label148:
      for (TangoCameraMetadata localTangoCameraMetadata = (TangoCameraMetadata)TangoCameraMetadata.CREATOR.createFromParcel(paramParcel1);; localTangoCameraMetadata = null)
      {
        onImageAvailable(paramInt1, localTangoImage, localTangoCameraMetadata, IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localTangoImage = null;
        break;
      }
    }
    
    private static class Proxy
      implements IOnImageAvailableListener
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
        return "com.google.atap.tangoservice.IOnImageAvailableListener";
      }
      
      public void onImageAvailable(int paramInt, TangoImage paramTangoImage, TangoCameraMetadata paramTangoCameraMetadata, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, IObjectWrapper paramIObjectWrapper4)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.atap.tangoservice.IOnImageAvailableListener");
            localParcel1.writeInt(paramInt);
            if (paramTangoImage != null)
            {
              localParcel1.writeInt(1);
              paramTangoImage.writeToParcel(localParcel1, 0);
              if (paramTangoCameraMetadata != null)
              {
                localParcel1.writeInt(1);
                paramTangoCameraMetadata.writeToParcel(localParcel1, 0);
                if (paramIObjectWrapper1 == null) {
                  break label202;
                }
                paramTangoImage = paramIObjectWrapper1.asBinder();
                localParcel1.writeStrongBinder(paramTangoImage);
                if (paramIObjectWrapper2 == null) {
                  break label207;
                }
                paramTangoImage = paramIObjectWrapper2.asBinder();
                localParcel1.writeStrongBinder(paramTangoImage);
                if (paramIObjectWrapper3 == null) {
                  break label212;
                }
                paramTangoImage = paramIObjectWrapper3.asBinder();
                localParcel1.writeStrongBinder(paramTangoImage);
                paramTangoImage = (TangoImage)localObject;
                if (paramIObjectWrapper4 != null) {
                  paramTangoImage = paramIObjectWrapper4.asBinder();
                }
                localParcel1.writeStrongBinder(paramTangoImage);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label202:
          paramTangoImage = null;
          continue;
          label207:
          paramTangoImage = null;
          continue;
          label212:
          paramTangoImage = null;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/IOnImageAvailableListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */