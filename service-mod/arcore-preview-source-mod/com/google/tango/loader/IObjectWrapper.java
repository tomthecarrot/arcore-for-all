package com.google.tango.loader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IObjectWrapper
  extends IInterface
{
  public static abstract class Stub
    extends Binder
    implements IObjectWrapper
  {
    private static final String DESCRIPTOR = "com.google.tango.loader.IObjectWrapper";
    
    public Stub()
    {
      attachInterface(this, "com.google.tango.loader.IObjectWrapper");
    }
    
    public static IObjectWrapper asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.tango.loader.IObjectWrapper");
      if ((localIInterface != null) && ((localIInterface instanceof IObjectWrapper))) {
        return (IObjectWrapper)localIInterface;
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
      }
      paramParcel2.writeString("com.google.tango.loader.IObjectWrapper");
      return true;
    }
    
    private static class Proxy
      implements IObjectWrapper
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
        return "com.google.tango.loader.IObjectWrapper";
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/loader/IObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */