package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzabk
  extends IInterface
{
  public abstract void zzgh(int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzabk
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }
    
    public static zzabk zzdn(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzabk))) {
        return (zzabk)localIInterface;
      }
      return new zza(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
      zzgh(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzabk
    {
      private IBinder zzrj;
      
      zza(IBinder paramIBinder)
      {
        this.zzrj = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzrj;
      }
      
      public void zzgh(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
          localParcel1.writeInt(paramInt);
          this.zzrj.transact(1, localParcel1, localParcel2, 0);
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */