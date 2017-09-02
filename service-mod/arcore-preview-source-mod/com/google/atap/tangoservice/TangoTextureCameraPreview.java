package com.google.atap.tangoservice;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

public class TangoTextureCameraPreview
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final String TAG = "TangoTextureCameraPreview";
  private int mCameraId;
  private TextureRenderer mRenderer;
  private Tango mTango;
  private int mTextureId = -1;
  private double mTimestamp;
  
  public TangoTextureCameraPreview(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TangoTextureCameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setSurfaceTextureListener(this);
    this.mTimestamp = 0.0D;
  }
  
  public void connectToTangoCamera(Tango paramTango, int paramInt)
  {
    if (this.mRenderer != null) {
      this.mTextureId = this.mRenderer.getTextureId();
    }
    for (;;)
    {
      this.mCameraId = paramInt;
      this.mTango = paramTango;
      this.mTango.connectTextureId(this.mCameraId, this.mTextureId);
      return;
      Log.e("TangoTextureCameraPreview", "Renderer not available.");
    }
  }
  
  public double getTimestamp()
  {
    return this.mTimestamp;
  }
  
  /* Error */
  public void onFrameAvailable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/google/atap/tangoservice/TangoTextureCameraPreview:mRenderer	Lcom/google/atap/tangoservice/TextureRenderer;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 42	com/google/atap/tangoservice/TangoTextureCameraPreview:mRenderer	Lcom/google/atap/tangoservice/TextureRenderer;
    //   13: invokevirtual 72	com/google/atap/tangoservice/TextureRenderer:onFrameAvailable	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: ldc 10
    //   21: ldc 60
    //   23: invokestatic 66	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   26: pop
    //   27: goto -11 -> 16
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	TangoTextureCameraPreview
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	30	finally
    //   19	27	30	finally
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mRenderer == null) {
      this.mRenderer = new TextureRenderer(this);
    }
    this.mRenderer.setSurfaceTexture(paramSurfaceTexture);
    this.mRenderer.start();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mRenderer.destroy();
    this.mRenderer = null;
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mRenderer.setViewport(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void updateTexture()
  {
    if (this.mTango == null) {
      return;
    }
    if ((this.mTextureId == -1) && (this.mRenderer != null))
    {
      this.mTextureId = this.mRenderer.getTextureId();
      this.mTango.connectTextureId(this.mCameraId, this.mTextureId);
    }
    try
    {
      this.mTimestamp = this.mTango.updateTexture(this.mCameraId);
      return;
    }
    catch (TangoInvalidException localTangoInvalidException)
    {
      Log.e("TangoTextureCameraPreview", "Error while updating texture.", localTangoInvalidException);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoTextureCameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */