package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract interface zzabn
  extends IInterface
{
  public abstract IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString)
    throws RemoteException;
  
  public abstract IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzabn
  {
    public static zzabn zzdp(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzabn))) {
        return (zzabn)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      IObjectWrapper localIObjectWrapper1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.net.ISocketFactoryCreator");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
        localIObjectWrapper1 = IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder());
        localIObjectWrapper2 = IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder());
        IObjectWrapper localIObjectWrapper3 = IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder());
        boolean bool;
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          paramParcel1 = zza(localIObjectWrapper1, localIObjectWrapper2, localIObjectWrapper3, bool);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label142;
          }
        }
        label142:
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          bool = false;
          break;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
      IObjectWrapper localIObjectWrapper2 = zza(IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder()), IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder()), IObjectWrapper.zza.zzdZ(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel1 = localIObjectWrapper1;
      if (localIObjectWrapper2 != null) {
        paramParcel1 = localIObjectWrapper2.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    
    private static class zza
      implements zzabn
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
      public IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +102 -> 123
        //   24: aload_1
        //   25: invokeinterface 40 1 0
        //   30: astore_1
        //   31: aload 6
        //   33: aload_1
        //   34: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   37: aload_2
        //   38: ifnull +90 -> 128
        //   41: aload_2
        //   42: invokeinterface 40 1 0
        //   47: astore_1
        //   48: aload 6
        //   50: aload_1
        //   51: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload 5
        //   56: astore_1
        //   57: aload_3
        //   58: ifnull +10 -> 68
        //   61: aload_3
        //   62: invokeinterface 40 1 0
        //   67: astore_1
        //   68: aload 6
        //   70: aload_1
        //   71: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   74: aload 6
        //   76: aload 4
        //   78: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   81: aload_0
        //   82: getfield 18	com/google/android/gms/internal/zzabn$zza$zza:zzrj	Landroid/os/IBinder;
        //   85: iconst_2
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 52 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 55	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   107: invokestatic 64	com/google/android/gms/dynamic/IObjectWrapper$zza:zzdZ	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   110: astore_1
        //   111: aload 7
        //   113: invokevirtual 67	android/os/Parcel:recycle	()V
        //   116: aload 6
        //   118: invokevirtual 67	android/os/Parcel:recycle	()V
        //   121: aload_1
        //   122: areturn
        //   123: aconst_null
        //   124: astore_1
        //   125: goto -94 -> 31
        //   128: aconst_null
        //   129: astore_1
        //   130: goto -82 -> 48
        //   133: astore_1
        //   134: aload 7
        //   136: invokevirtual 67	android/os/Parcel:recycle	()V
        //   139: aload 6
        //   141: invokevirtual 67	android/os/Parcel:recycle	()V
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	zza
        //   0	146	1	paramIObjectWrapper1	IObjectWrapper
        //   0	146	2	paramIObjectWrapper2	IObjectWrapper
        //   0	146	3	paramIObjectWrapper3	IObjectWrapper
        //   0	146	4	paramString	String
        //   1	54	5	localObject	Object
        //   6	134	6	localParcel1	Parcel
        //   11	124	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	133	finally
        //   24	31	133	finally
        //   31	37	133	finally
        //   41	48	133	finally
        //   48	54	133	finally
        //   61	68	133	finally
        //   68	111	133	finally
      }
      
      /* Error */
      public IObjectWrapper zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: aconst_null
        //   4: astore 6
        //   6: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 7
        //   11: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 8
        //   16: aload 7
        //   18: ldc 32
        //   20: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   23: aload_1
        //   24: ifnull +107 -> 131
        //   27: aload_1
        //   28: invokeinterface 40 1 0
        //   33: astore_1
        //   34: aload 7
        //   36: aload_1
        //   37: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload_2
        //   41: ifnull +95 -> 136
        //   44: aload_2
        //   45: invokeinterface 40 1 0
        //   50: astore_1
        //   51: aload 7
        //   53: aload_1
        //   54: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   57: aload 6
        //   59: astore_1
        //   60: aload_3
        //   61: ifnull +10 -> 71
        //   64: aload_3
        //   65: invokeinterface 40 1 0
        //   70: astore_1
        //   71: aload 7
        //   73: aload_1
        //   74: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   77: iload 4
        //   79: ifeq +62 -> 141
        //   82: aload 7
        //   84: iload 5
        //   86: invokevirtual 73	android/os/Parcel:writeInt	(I)V
        //   89: aload_0
        //   90: getfield 18	com/google/android/gms/internal/zzabn$zza$zza:zzrj	Landroid/os/IBinder;
        //   93: iconst_1
        //   94: aload 7
        //   96: aload 8
        //   98: iconst_0
        //   99: invokeinterface 52 5 0
        //   104: pop
        //   105: aload 8
        //   107: invokevirtual 55	android/os/Parcel:readException	()V
        //   110: aload 8
        //   112: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   115: invokestatic 64	com/google/android/gms/dynamic/IObjectWrapper$zza:zzdZ	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //   118: astore_1
        //   119: aload 8
        //   121: invokevirtual 67	android/os/Parcel:recycle	()V
        //   124: aload 7
        //   126: invokevirtual 67	android/os/Parcel:recycle	()V
        //   129: aload_1
        //   130: areturn
        //   131: aconst_null
        //   132: astore_1
        //   133: goto -99 -> 34
        //   136: aconst_null
        //   137: astore_1
        //   138: goto -87 -> 51
        //   141: iconst_0
        //   142: istore 5
        //   144: goto -62 -> 82
        //   147: astore_1
        //   148: aload 8
        //   150: invokevirtual 67	android/os/Parcel:recycle	()V
        //   153: aload 7
        //   155: invokevirtual 67	android/os/Parcel:recycle	()V
        //   158: aload_1
        //   159: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	160	0	this	zza
        //   0	160	1	paramIObjectWrapper1	IObjectWrapper
        //   0	160	2	paramIObjectWrapper2	IObjectWrapper
        //   0	160	3	paramIObjectWrapper3	IObjectWrapper
        //   0	160	4	paramBoolean	boolean
        //   1	142	5	i	int
        //   4	54	6	localObject	Object
        //   9	145	7	localParcel1	Parcel
        //   14	135	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   16	23	147	finally
        //   27	34	147	finally
        //   34	40	147	finally
        //   44	51	147	finally
        //   51	57	147	finally
        //   64	71	147	finally
        //   71	77	147	finally
        //   82	119	147	finally
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */