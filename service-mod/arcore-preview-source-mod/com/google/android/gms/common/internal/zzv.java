package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzv
  extends IInterface
{
  public abstract void zza(zzu paramzzu, zzj paramzzj)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzv
  {
    public static zzv zzdh(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((localIInterface != null) && ((localIInterface instanceof zzv))) {
        return (zzv)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 > 16777215) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      zzu localzzu = zzu.zza.zzdg(paramParcel1.readStrongBinder());
      if (paramInt1 == 46) {
        if (paramParcel1.readInt() == 0) {
          break label684;
        }
      }
      label312:
      label679:
      label684:
      for (paramParcel1 = (zzj)zzj.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(localzzu, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        if (paramInt1 == 47) {
          if (paramParcel1.readInt() == 0) {
            break label679;
          }
        }
        for (paramParcel1 = (zzan)zzan.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(localzzu, paramParcel1);
          break;
          paramInt2 = paramParcel1.readInt();
          if (paramInt1 != 4) {}
          for (String str4 = paramParcel1.readString();; str4 = null)
          {
            String str1;
            String str2;
            IBinder localIBinder;
            String[] arrayOfString;
            String str3;
            switch (paramInt1)
            {
            case 3: 
            case 4: 
            case 21: 
            case 22: 
            case 24: 
            case 26: 
            case 28: 
            case 29: 
            case 31: 
            case 32: 
            case 33: 
            case 35: 
            case 36: 
            case 39: 
            case 40: 
            case 42: 
            default: 
              str1 = null;
              str2 = null;
              localIBinder = null;
              paramParcel1 = null;
              arrayOfString = null;
              str3 = null;
            }
            for (;;)
            {
              zza(paramInt1, localzzu, paramInt2, str4, str3, arrayOfString, paramParcel1, localIBinder, str2, str1);
              break;
              localIBinder = paramParcel1.readStrongBinder();
              if (paramParcel1.readInt() != 0)
              {
                paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                str1 = null;
                str2 = null;
                arrayOfString = null;
                str3 = null;
                continue;
                str2 = paramParcel1.readString();
                arrayOfString = paramParcel1.createStringArray();
                str3 = paramParcel1.readString();
                if (paramParcel1.readInt() != 0)
                {
                  paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                  str1 = null;
                  localIBinder = null;
                  continue;
                  str3 = paramParcel1.readString();
                  arrayOfString = paramParcel1.createStringArray();
                  str2 = paramParcel1.readString();
                  localIBinder = paramParcel1.readStrongBinder();
                  str1 = paramParcel1.readString();
                  if (paramParcel1.readInt() != 0)
                  {
                    paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                    continue;
                    arrayOfString = paramParcel1.createStringArray();
                    str3 = paramParcel1.readString();
                    if (paramParcel1.readInt() != 0)
                    {
                      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      continue;
                      str3 = paramParcel1.readString();
                      arrayOfString = paramParcel1.createStringArray();
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      paramParcel1 = null;
                      continue;
                      str3 = paramParcel1.readString();
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      paramParcel1 = null;
                      arrayOfString = null;
                      continue;
                      if (paramParcel1.readInt() == 0) {
                        break label312;
                      }
                      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      arrayOfString = null;
                      str3 = null;
                      continue;
                    }
                    str1 = null;
                    str2 = null;
                    localIBinder = null;
                    paramParcel1 = null;
                    continue;
                  }
                  paramParcel1 = null;
                  continue;
                }
                str1 = null;
                localIBinder = null;
                paramParcel1 = null;
                continue;
              }
              str1 = null;
              str2 = null;
              paramParcel1 = null;
              arrayOfString = null;
              str3 = null;
            }
          }
        }
      }
    }
    
    protected void zza(int paramInt1, zzu paramzzu, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle, IBinder paramIBinder, String paramString3, String paramString4)
      throws RemoteException
    {
      throw new UnsupportedOperationException();
    }
    
    protected void zza(zzu paramzzu, zzan paramzzan)
      throws RemoteException
    {
      throw new UnsupportedOperationException();
    }
    
    private static class zza
      implements zzv
    {
      private final IBinder zzrj;
      
      zza(IBinder paramIBinder)
      {
        this.zzrj = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzrj;
      }
      
      /* Error */
      public void zza(zzu paramzzu, zzj paramzzj)
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
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/common/internal/zzj:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/common/internal/zzv$zza$zza:zzrj	Landroid/os/IBinder;
        //   50: bipush 46
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramzzu	zzu
        //   0	102	2	paramzzj	zzj
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */