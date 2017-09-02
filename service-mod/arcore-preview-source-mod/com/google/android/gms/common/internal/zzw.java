package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract interface zzw
  extends IInterface
{
  public abstract boolean zze(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract boolean zzf(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract IObjectWrapper zzzW()
    throws RemoteException;
  
  public abstract IObjectWrapper zzzX()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzw
  {
    public static zzw zzdi(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      if ((localIInterface != null) && ((localIInterface instanceof zzw))) {
        return (zzw)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      IObjectWrapper localIObjectWrapper2 = null;
      IObjectWrapper localIObjectWrapper1 = null;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localIObjectWrapper2 = zzzW();
        paramParcel2.writeNoException();
        paramParcel1 = localIObjectWrapper1;
        if (localIObjectWrapper2 != null) {
          paramParcel1 = localIObjectWrapper2.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localIObjectWrapper1 = zzzX();
        paramParcel2.writeNoException();
        paramParcel1 = localIObjectWrapper2;
        if (localIObjectWrapper1 != null) {
          paramParcel1 = localIObjectWrapper1.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        bool = zze(paramParcel1.readString(), IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      boolean bool = zzf(paramParcel1.readString(), IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class zza
      implements zzw
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
      
      /* Error */
      public boolean zze(String paramString, IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 33
        //   17: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload_2
        //   27: ifnull +63 -> 90
        //   30: aload_2
        //   31: invokeinterface 44 1 0
        //   36: astore_1
        //   37: aload 5
        //   39: aload_1
        //   40: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: aload_0
        //   44: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzrj	Landroid/os/IBinder;
        //   47: iconst_3
        //   48: aload 5
        //   50: aload 6
        //   52: iconst_0
        //   53: invokeinterface 53 5 0
        //   58: pop
        //   59: aload 6
        //   61: invokevirtual 56	android/os/Parcel:readException	()V
        //   64: aload 6
        //   66: invokevirtual 60	android/os/Parcel:readInt	()I
        //   69: istore_3
        //   70: iload_3
        //   71: ifeq +6 -> 77
        //   74: iconst_1
        //   75: istore 4
        //   77: aload 6
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload 5
        //   84: invokevirtual 63	android/os/Parcel:recycle	()V
        //   87: iload 4
        //   89: ireturn
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -55 -> 37
        //   95: astore_1
        //   96: aload 6
        //   98: invokevirtual 63	android/os/Parcel:recycle	()V
        //   101: aload 5
        //   103: invokevirtual 63	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	zza
        //   0	108	1	paramString	String
        //   0	108	2	paramIObjectWrapper	IObjectWrapper
        //   69	2	3	i	int
        //   1	87	4	bool	boolean
        //   6	96	5	localParcel1	Parcel
        //   11	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   30	37	95	finally
        //   37	70	95	finally
      }
      
      /* Error */
      public boolean zzf(String paramString, IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 33
        //   17: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload_2
        //   27: ifnull +63 -> 90
        //   30: aload_2
        //   31: invokeinterface 44 1 0
        //   36: astore_1
        //   37: aload 5
        //   39: aload_1
        //   40: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: aload_0
        //   44: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzrj	Landroid/os/IBinder;
        //   47: iconst_4
        //   48: aload 5
        //   50: aload 6
        //   52: iconst_0
        //   53: invokeinterface 53 5 0
        //   58: pop
        //   59: aload 6
        //   61: invokevirtual 56	android/os/Parcel:readException	()V
        //   64: aload 6
        //   66: invokevirtual 60	android/os/Parcel:readInt	()I
        //   69: istore_3
        //   70: iload_3
        //   71: ifeq +6 -> 77
        //   74: iconst_1
        //   75: istore 4
        //   77: aload 6
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload 5
        //   84: invokevirtual 63	android/os/Parcel:recycle	()V
        //   87: iload 4
        //   89: ireturn
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -55 -> 37
        //   95: astore_1
        //   96: aload 6
        //   98: invokevirtual 63	android/os/Parcel:recycle	()V
        //   101: aload 5
        //   103: invokevirtual 63	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	zza
        //   0	108	1	paramString	String
        //   0	108	2	paramIObjectWrapper	IObjectWrapper
        //   69	2	3	i	int
        //   1	87	4	bool	boolean
        //   6	96	5	localParcel1	Parcel
        //   11	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   30	37	95	finally
        //   37	70	95	finally
      }
      
      public IObjectWrapper zzzW()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzrj.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzdZ(localParcel2.readStrongBinder());
          return localIObjectWrapper;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IObjectWrapper zzzX()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzrj.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzdZ(localParcel2.readStrongBinder());
          return localIObjectWrapper;
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */