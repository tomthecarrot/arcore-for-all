package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.reporting.OptInRequest;
import com.google.android.gms.location.reporting.ReportingState;
import com.google.android.gms.location.reporting.UploadRequest;
import com.google.android.gms.location.reporting.UploadRequestResult;

public abstract interface zzasj
  extends IInterface
{
  public abstract int zza(Account paramAccount, PlaceReport paramPlaceReport)
    throws RemoteException;
  
  public abstract int zza(OptInRequest paramOptInRequest)
    throws RemoteException;
  
  public abstract UploadRequestResult zza(UploadRequest paramUploadRequest)
    throws RemoteException;
  
  public abstract int zzaf(long paramLong)
    throws RemoteException;
  
  public abstract ReportingState zzg(Account paramAccount)
    throws RemoteException;
  
  public abstract int zzh(Account paramAccount)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzasj
  {
    public static zzasj zzfF(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.reporting.internal.IReportingService");
      if ((localIInterface != null) && ((localIInterface instanceof zzasj))) {
        return (zzasj)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.location.reporting.internal.IReportingService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zzg(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label144;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = zzh(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (OptInRequest)OptInRequest.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (UploadRequest)UploadRequest.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label306;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 4: 
        label144:
        label306:
        paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
        paramInt1 = zzaf(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.reporting.internal.IReportingService");
      Account localAccount;
      if (paramParcel1.readInt() != 0)
      {
        localAccount = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label412;
        }
      }
      label412:
      for (paramParcel1 = (PlaceReport)PlaceReport.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        paramInt1 = zza(localAccount, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        localAccount = null;
        break;
      }
    }
    
    private static class zza
      implements zzasj
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
      
      public int zza(Account paramAccount, PlaceReport paramPlaceReport)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.reporting.internal.IReportingService");
            if (paramAccount != null)
            {
              localParcel1.writeInt(1);
              paramAccount.writeToParcel(localParcel1, 0);
              if (paramPlaceReport != null)
              {
                localParcel1.writeInt(1);
                paramPlaceReport.writeToParcel(localParcel1, 0);
                this.zzrj.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
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
        }
      }
      
      /* Error */
      public int zza(OptInRequest paramOptInRequest)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 70	com/google/android/gms/location/reporting/OptInRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/zzasj$zza$zza:zzrj	Landroid/os/IBinder;
        //   34: bipush 6
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 55 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 58	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 62	android/os/Parcel:readInt	()I
        //   56: istore_2
        //   57: aload 4
        //   59: invokevirtual 65	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 65	android/os/Parcel:recycle	()V
        //   66: iload_2
        //   67: ireturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   73: goto -43 -> 30
        //   76: astore_1
        //   77: aload 4
        //   79: invokevirtual 65	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 65	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	zza
        //   0	88	1	paramOptInRequest	OptInRequest
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
      
      public UploadRequestResult zza(UploadRequest paramUploadRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.reporting.internal.IReportingService");
            if (paramUploadRequest != null)
            {
              localParcel1.writeInt(1);
              paramUploadRequest.writeToParcel(localParcel1, 0);
              this.zzrj.transact(3, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramUploadRequest = (UploadRequestResult)UploadRequestResult.CREATOR.createFromParcel(localParcel2);
                return paramUploadRequest;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramUploadRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int zzaf(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.reporting.internal.IReportingService");
          localParcel1.writeLong(paramLong);
          this.zzrj.transact(4, localParcel1, localParcel2, 0);
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
      
      public ReportingState zzg(Account paramAccount)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.reporting.internal.IReportingService");
            if (paramAccount != null)
            {
              localParcel1.writeInt(1);
              paramAccount.writeToParcel(localParcel1, 0);
              this.zzrj.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramAccount = (ReportingState)ReportingState.CREATOR.createFromParcel(localParcel2);
                return paramAccount;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAccount = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public int zzh(Account paramAccount)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 46	android/accounts/Account:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/zzasj$zza$zza:zzrj	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 55 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 58	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 62	android/os/Parcel:readInt	()I
        //   55: istore_2
        //   56: aload 4
        //   58: invokevirtual 65	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 65	android/os/Parcel:recycle	()V
        //   65: iload_2
        //   66: ireturn
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore_1
        //   76: aload 4
        //   78: invokevirtual 65	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 65	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	zza
        //   0	87	1	paramAccount	Account
        //   55	11	2	i	int
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	75	finally
        //   19	30	75	finally
        //   30	56	75	finally
        //   67	72	75	finally
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzasj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */