package com.google.atap.tangoservice;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TangoCameraPreview
  extends GLSurfaceView
{
  private static final String TAG = "TangoCameraPreview";
  private int mCameraId = -1;
  private Context mParent;
  private MainRenderer mRenderer;
  private Tango mTango;
  private int mTextureId = -1;
  private double mTimestamp;
  
  public TangoCameraPreview(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TangoCameraPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mParent = paramContext;
    this.mRenderer = new MainRenderer(this);
    setEGLContextClientVersion(2);
    setRenderer(this.mRenderer);
    setRenderMode(0);
    this.mTimestamp = 0.0D;
  }
  
  public void connectToTangoCamera(Tango paramTango, int paramInt)
  {
    this.mTextureId = this.mRenderer.getTextureId();
    this.mCameraId = paramInt;
    this.mTango = paramTango;
    this.mTango.connectTextureId(this.mCameraId, this.mTextureId);
  }
  
  public void disconnectFromTangoCamera()
  {
    if ((this.mTango != null) && (this.mCameraId != -1))
    {
      this.mTango.disconnectCamera(this.mCameraId);
      if (this.mRenderer != null) {
        this.mRenderer.close();
      }
    }
  }
  
  public double getTimestamp()
  {
    return this.mTimestamp;
  }
  
  public void onFrameAvailable()
  {
    try
    {
      this.mRenderer.onFrameAvailable();
      requestRender();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void updateTexture()
  {
    if (this.mTextureId == -1)
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
      Log.e("TangoCameraPreview", "Error updating texture.", localTangoInvalidException);
    }
  }
  
  private class MainRenderer
    implements GLSurfaceView.Renderer
  {
    private final String fss = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
    private int mProgram;
    private FloatBuffer mTexCoord;
    private int[] mTextures;
    private boolean mUpdateST = false;
    private FloatBuffer mVertex;
    private TangoCameraPreview mView;
    private final String vss = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4(vPosition.x, vPosition.y, 0.0, 1.0);\n}";
    
    MainRenderer(TangoCameraPreview paramTangoCameraPreview)
    {
      this.mView = paramTangoCameraPreview;
      this.mVertex = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mVertex.put(new float[] { 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F });
      this.mVertex.position(0);
      this.mTexCoord = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mTexCoord.put(new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      this.mTexCoord.position(0);
    }
    
    private void deleteTex()
    {
      GLES20.glDeleteTextures(1, this.mTextures, 0);
    }
    
    private void initTex()
    {
      try
      {
        this.mTextures = new int[1];
        GLES20.glGenTextures(1, this.mTextures, 0);
        GLES20.glBindTexture(36197, this.mTextures[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9728);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private int loadShader(String paramString1, String paramString2)
    {
      int j = GLES20.glCreateShader(35633);
      GLES20.glShaderSource(j, paramString1);
      GLES20.glCompileShader(j);
      paramString1 = new int[1];
      GLES20.glGetShaderiv(j, 35713, paramString1, 0);
      int i = j;
      if (paramString1[0] == 0)
      {
        Log.e("Shader", "Could not compile vshader");
        Log.v("Shader", "Could not compile vshader:" + GLES20.glGetShaderInfoLog(j));
        GLES20.glDeleteShader(j);
        i = 0;
      }
      int k = GLES20.glCreateShader(35632);
      GLES20.glShaderSource(k, paramString2);
      GLES20.glCompileShader(k);
      GLES20.glGetShaderiv(k, 35713, paramString1, 0);
      j = k;
      if (paramString1[0] == 0)
      {
        Log.e("Shader", "Could not compile fshader");
        Log.v("Shader", "Could not compile fshader:" + GLES20.glGetShaderInfoLog(k));
        GLES20.glDeleteShader(k);
        j = 0;
      }
      k = GLES20.glCreateProgram();
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      return k;
    }
    
    public void close()
    {
      this.mUpdateST = false;
      deleteTex();
    }
    
    /* Error */
    public int getTextureId()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 82	com/google/atap/tangoservice/TangoCameraPreview$MainRenderer:mTextures	[I
      //   6: astore_2
      //   7: aload_2
      //   8: ifnonnull +9 -> 17
      //   11: iconst_m1
      //   12: istore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: aload_0
      //   18: getfield 82	com/google/atap/tangoservice/TangoCameraPreview$MainRenderer:mTextures	[I
      //   21: iconst_0
      //   22: iaload
      //   23: istore_1
      //   24: goto -11 -> 13
      //   27: astore_2
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_2
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	MainRenderer
      //   12	12	1	i	int
      //   6	2	2	arrayOfInt	int[]
      //   27	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	27	finally
      //   17	24	27	finally
    }
    
    public void onDrawFrame(GL10 paramGL10)
    {
      GLES20.glClear(16384);
      try
      {
        if (this.mUpdateST)
        {
          this.mView.updateTexture();
          this.mUpdateST = false;
        }
        GLES20.glUseProgram(this.mProgram);
        int i = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        int j = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
        int k = GLES20.glGetUniformLocation(this.mProgram, "sTexture");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTextures[0]);
        GLES20.glUniform1i(k, 0);
        GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.mVertex);
        GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.mTexCoord);
        GLES20.glEnableVertexAttribArray(i);
        GLES20.glEnableVertexAttribArray(j);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return;
      }
      finally {}
    }
    
    public void onFrameAvailable()
    {
      try
      {
        this.mUpdateST = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
    }
    
    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      initTex();
      GLES20.glClearColor(1.0F, 1.0F, 0.0F, 1.0F);
      this.mProgram = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4(vPosition.x, vPosition.y, 0.0, 1.0);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoCameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */