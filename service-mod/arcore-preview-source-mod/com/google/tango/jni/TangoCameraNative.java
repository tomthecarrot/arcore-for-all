package com.google.tango.jni;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import com.google.atap.tangoservice.IOnFrameAvailableListener;
import com.google.atap.tangoservice.IOnImageAvailableListener;
import com.google.atap.tangoservice.ITangoListener;
import com.google.atap.tangoservice.SupportedDevices;
import com.google.atap.tangoservice.Tango.OnFrameAvailableListener;
import com.google.atap.tangoservice.Tango.TangoUpdateCallback;
import com.google.atap.tangoservice.TangoCameraMetadata;
import com.google.atap.tangoservice.TangoImage;
import com.google.atap.tangoservice.TangoVhs;
import com.google.atap.tangoservice.experimental.TangoImageBuffer;
import com.google.tango.loader.IObjectWrapper;
import com.google.tango.loader.ITangoCameraNative.Stub;
import com.google.tango.loader.ObjectWrapper;

public class TangoCameraNative
  extends ITangoCameraNative.Stub
{
  private static final boolean LETANGO = true;
  private static final String TAG = "TangoCameraNative";
  private static Context mContext;
  private static Surface mRenderSurface = null;
  private static SurfaceTexture mRenderSurfaceTex;
  private static ITangoListener mTangoUpdateListener;
  private static TangoVhs mTangoVhs;
  private static int mTexId;
  private static Surface mTrackingSurface = null;
  private volatile boolean mServiceConnected = false;
  private volatile boolean mVhsReady = false;
  
  static
  {
    System.loadLibrary("tango_camera_native_jni");
    mTangoUpdateListener = null;
    mTexId = -1;
    mTangoVhs = null;
    mRenderSurfaceTex = null;
  }
  
  public static native int ConnectOnFrameAvailable(int paramInt, Tango.OnFrameAvailableListener paramOnFrameAvailableListener, boolean paramBoolean);
  
  public static native int ConnectOnImageAvailable(int paramInt, Tango.TangoUpdateCallback paramTangoUpdateCallback, boolean paramBoolean);
  
  public static native int ConnectOnTextureAvailable(int paramInt, boolean paramBoolean);
  
  public static native int ConnectTextureId(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int ConnectVhs(TangoVhs paramTangoVhs, Surface paramSurface);
  
  public static native int DisconnectCamera(int paramInt);
  
  public static native int Initialize(ITangoListener paramITangoListener, SurfaceTexture paramSurfaceTexture, Surface paramSurface, boolean paramBoolean);
  
  public static native int LockCameraBuffer(int paramInt, double[] paramArrayOfDouble, long[] paramArrayOfLong);
  
  public static native int SetDatasetPathAndUUID(String paramString1, String paramString2);
  
  public static native int StartCamerasIfNeeded();
  
  public static native int StopAllCameras();
  
  public static native int UnlockCameraBuffer(int paramInt, long paramLong);
  
  public static native int UpdateTexture(int paramInt, double[] paramArrayOfDouble);
  
  public static native int UpdateTextureExternalOes(int paramInt1, int paramInt2, double[] paramArrayOfDouble);
  
  public static native int UpdateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong);
  
  public static native int onSurfaceTextureAvailable();
  
  /* Error */
  public int connectOnFrameAvailable(int paramInt, final IOnFrameAvailableListener paramIOnFrameAvailableListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 10	com/google/tango/jni/TangoCameraNative$3
    //   5: dup
    //   6: aload_0
    //   7: aload_2
    //   8: invokespecial 111	com/google/tango/jni/TangoCameraNative$3:<init>	(Lcom/google/tango/jni/TangoCameraNative;Lcom/google/atap/tangoservice/IOnFrameAvailableListener;)V
    //   11: astore_2
    //   12: iload_3
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 62	com/google/tango/jni/TangoCameraNative:mVhsReady	Z
    //   20: ifeq +16 -> 36
    //   23: iconst_1
    //   24: istore_3
    //   25: iload_1
    //   26: aload_2
    //   27: iload_3
    //   28: invokestatic 113	com/google/tango/jni/TangoCameraNative:ConnectOnFrameAvailable	(ILcom/google/atap/tangoservice/Tango$OnFrameAvailableListener;Z)I
    //   31: istore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -13 -> 25
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TangoCameraNative
    //   0	46	1	paramInt	int
    //   0	46	2	paramIOnFrameAvailableListener	IOnFrameAvailableListener
    //   0	46	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	41	finally
    //   16	23	41	finally
    //   25	32	41	finally
  }
  
  /* Error */
  public int connectOnImageAvailable(int paramInt, final IOnImageAvailableListener paramIOnImageAvailableListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 12	com/google/tango/jni/TangoCameraNative$4
    //   5: dup
    //   6: aload_0
    //   7: aload_2
    //   8: invokespecial 118	com/google/tango/jni/TangoCameraNative$4:<init>	(Lcom/google/tango/jni/TangoCameraNative;Lcom/google/atap/tangoservice/IOnImageAvailableListener;)V
    //   11: astore_2
    //   12: iload_3
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: getfield 62	com/google/tango/jni/TangoCameraNative:mVhsReady	Z
    //   20: ifeq +16 -> 36
    //   23: iconst_1
    //   24: istore_3
    //   25: iload_1
    //   26: aload_2
    //   27: iload_3
    //   28: invokestatic 120	com/google/tango/jni/TangoCameraNative:ConnectOnImageAvailable	(ILcom/google/atap/tangoservice/Tango$TangoUpdateCallback;Z)I
    //   31: istore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -13 -> 25
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TangoCameraNative
    //   0	46	1	paramInt	int
    //   0	46	2	paramIOnImageAvailableListener	IOnImageAvailableListener
    //   0	46	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	41	finally
    //   16	23	41	finally
    //   25	32	41	finally
  }
  
  /* Error */
  public int connectOnTextureAvailable(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq +22 -> 25
    //   6: aload_0
    //   7: getfield 62	com/google/tango/jni/TangoCameraNative:mVhsReady	Z
    //   10: ifeq +15 -> 25
    //   13: iconst_1
    //   14: istore_2
    //   15: iload_1
    //   16: iload_2
    //   17: invokestatic 123	com/google/tango/jni/TangoCameraNative:ConnectOnTextureAvailable	(IZ)I
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -12 -> 15
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	TangoCameraNative
    //   0	35	1	paramInt	int
    //   0	35	2	paramBoolean	boolean
    //   30	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	30	finally
    //   15	21	30	finally
  }
  
  /* Error */
  public int connectTextureId(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/google/tango/jni/TangoCameraNative:mRenderSurfaceTex	Landroid/graphics/SurfaceTexture;
    //   5: ifnull +44 -> 49
    //   8: getstatic 52	com/google/tango/jni/TangoCameraNative:mRenderSurfaceTex	Landroid/graphics/SurfaceTexture;
    //   11: invokevirtual 129	android/graphics/SurfaceTexture:detachFromGLContext	()V
    //   14: getstatic 52	com/google/tango/jni/TangoCameraNative:mRenderSurfaceTex	Landroid/graphics/SurfaceTexture;
    //   17: iload_2
    //   18: invokevirtual 133	android/graphics/SurfaceTexture:attachToGLContext	(I)V
    //   21: iload_2
    //   22: putstatic 48	com/google/tango/jni/TangoCameraNative:mTexId	I
    //   25: iload_3
    //   26: ifeq +36 -> 62
    //   29: aload_0
    //   30: getfield 62	com/google/tango/jni/TangoCameraNative:mVhsReady	Z
    //   33: ifeq +29 -> 62
    //   36: iconst_1
    //   37: istore_3
    //   38: iload_1
    //   39: iload_2
    //   40: iload_3
    //   41: invokestatic 135	com/google/tango/jni/TangoCameraNative:ConnectTextureId	(IIZ)I
    //   44: istore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_1
    //   48: ireturn
    //   49: ldc 19
    //   51: ldc -119
    //   53: invokestatic 142	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: iconst_m1
    //   58: istore_1
    //   59: goto -14 -> 45
    //   62: iconst_0
    //   63: istore_3
    //   64: goto -26 -> 38
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	TangoCameraNative
    //   0	74	1	paramInt1	int
    //   0	74	2	paramInt2	int
    //   0	74	3	paramBoolean	boolean
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	67	finally
    //   29	36	67	finally
    //   38	45	67	finally
    //   49	57	67	finally
  }
  
  public int disconnectCamera(int paramInt)
  {
    try
    {
      paramInt = DisconnectCamera(paramInt);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int initialize(IObjectWrapper paramIObjectWrapper, ITangoListener paramITangoListener)
  {
    mContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper, Context.class);
    mTangoUpdateListener = paramITangoListener;
    mRenderSurfaceTex = new SurfaceTexture(1337);
    mRenderSurfaceTex.setDefaultBufferSize(1920, 1080);
    mRenderSurface = new Surface(mRenderSurfaceTex);
    mRenderSurfaceTex.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        try
        {
          TangoCameraNative.mTangoUpdateListener.onGraphicBufferAvailable(0);
          return;
        }
        catch (Exception paramAnonymousSurfaceTexture) {}
      }
    });
    int i = Initialize(paramITangoListener, mRenderSurfaceTex, mRenderSurface, SupportedDevices.isSupportedExynosDevice());
    mTangoVhs = new TangoVhs(mContext);
    mTangoVhs.connect(new Runnable()
    {
      public void run()
      {
        Log.i("TangoCameraNative", "Tango VHS Ready");
        synchronized (TangoCameraNative.this)
        {
          if (TangoCameraNative.mTangoVhs == null)
          {
            Log.i("TangoCameraNative", "Disconnect already called on the tango object. Cease setting up.");
            return;
          }
          TangoCameraNative.access$202(TangoCameraNative.mTangoVhs.getTrackingSurface());
          TangoCameraNative.ConnectVhs(TangoCameraNative.mTangoVhs, TangoCameraNative.mTrackingSurface);
          TangoCameraNative.access$302(TangoCameraNative.this, true);
          if (TangoCameraNative.this.mServiceConnected)
          {
            Log.i("TangoCameraNative", "VHS ready after connect called, starting camera.");
            TangoCameraNative.StartCamerasIfNeeded();
          }
          return;
        }
      }
    });
    return i;
  }
  
  public int lockCameraBuffer(int paramInt, double[] paramArrayOfDouble, long[] paramArrayOfLong)
  {
    try
    {
      paramInt = LockCameraBuffer(paramInt, paramArrayOfDouble, paramArrayOfLong);
      return paramInt;
    }
    finally
    {
      paramArrayOfDouble = finally;
      throw paramArrayOfDouble;
    }
  }
  
  /* Error */
  public int setDatasetPathAndUUID(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_2
    //   4: invokestatic 199	com/google/tango/jni/TangoCameraNative:SetDatasetPathAndUUID	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +15 -> 24
    //   12: ldc 19
    //   14: ldc -55
    //   16: invokestatic 142	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: getstatic 50	com/google/tango/jni/TangoCameraNative:mTangoVhs	Lcom/google/atap/tangoservice/TangoVhs;
    //   27: aload_1
    //   28: aload_2
    //   29: invokevirtual 203	com/google/atap/tangoservice/TangoVhs:setDatasetPathAndUUID	(Ljava/lang/String;Ljava/lang/String;)I
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq +14 -> 48
    //   37: ldc 19
    //   39: ldc -51
    //   41: invokestatic 142	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: goto -25 -> 20
    //   48: iconst_0
    //   49: istore_3
    //   50: goto -30 -> 20
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TangoCameraNative
    //   0	58	1	paramString1	String
    //   0	58	2	paramString2	String
    //   7	43	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	8	53	finally
    //   12	20	53	finally
    //   24	33	53	finally
    //   37	45	53	finally
  }
  
  /* Error */
  public int startCamerasIfNeeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 64	com/google/tango/jni/TangoCameraNative:mServiceConnected	Z
    //   7: aload_0
    //   8: getfield 62	com/google/tango/jni/TangoCameraNative:mVhsReady	Z
    //   11: ifne +19 -> 30
    //   14: ldc 19
    //   16: ldc -48
    //   18: invokestatic 211	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: invokestatic 213	com/google/tango/jni/TangoCameraNative:StartCamerasIfNeeded	()I
    //   25: istore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: ldc 19
    //   32: ldc -41
    //   34: invokestatic 211	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: goto -16 -> 22
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TangoCameraNative
    //   25	4	1	i	int
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	41	finally
    //   22	26	41	finally
    //   30	38	41	finally
  }
  
  public int stopAllCameras()
  {
    try
    {
      if (mTangoVhs != null)
      {
        Log.i("TangoCameraNative", "stopAllCameras()");
        mTangoVhs.disconnect();
        mTangoVhs = null;
      }
      int i = StopAllCameras();
      return i;
    }
    finally {}
  }
  
  public int unlockCameraBuffer(int paramInt, long paramLong)
  {
    try
    {
      paramInt = UnlockCameraBuffer(paramInt, paramLong);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int updateTexture(int paramInt, double[] paramArrayOfDouble)
  {
    try
    {
      paramInt = UpdateTexture(paramInt, paramArrayOfDouble);
      return paramInt;
    }
    finally
    {
      paramArrayOfDouble = finally;
      throw paramArrayOfDouble;
    }
  }
  
  public int updateTextureExternalOes(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    try
    {
      paramInt1 = UpdateTextureExternalOes(paramInt1, paramInt2, paramArrayOfDouble);
      return paramInt1;
    }
    finally
    {
      paramArrayOfDouble = finally;
      throw paramArrayOfDouble;
    }
  }
  
  public int updateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      paramInt1 = UpdateTextureExternalOesForBuffer(paramInt1, paramInt2, paramLong);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/jni/TangoCameraNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */