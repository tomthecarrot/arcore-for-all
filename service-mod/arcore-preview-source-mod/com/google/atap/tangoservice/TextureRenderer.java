package com.google.atap.tangoservice;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class TextureRenderer
  extends Thread
{
  static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  static final int EGL_OPENGL_ES2_BIT = 4;
  private static final String LOG_TAG = "TextureRenderer";
  private final String fss = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
  private volatile boolean mDone;
  private EGL10 mEgl;
  private EGLConfig mEglConfig;
  private EGLContext mEglContext;
  private EGLDisplay mEglDisplay;
  private EGLSurface mEglSurface;
  private int mProgram;
  private SurfaceTexture mSTexture;
  private FloatBuffer mTexCoord;
  private int[] mTextures;
  private final Object mUpdateLock = new Object();
  private volatile boolean mUpdateViewPort;
  private FloatBuffer mVertex;
  private TangoTextureCameraPreview mView;
  private volatile int mViewPortHeight = 0;
  private volatile int mViewPortWidth = 0;
  private final String vss = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4(vPosition.x, vPosition.y, 0.0, 1.0);\n}";
  
  TextureRenderer(TangoTextureCameraPreview paramTangoTextureCameraPreview)
  {
    this.mView = paramTangoTextureCameraPreview;
    this.mVertex = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertex.put(new float[] { 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F });
    this.mVertex.position(0);
    this.mTexCoord = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTexCoord.put(new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    this.mTexCoord.position(0);
  }
  
  private void checkCurrent()
  {
    if (((!this.mEglContext.equals(this.mEgl.eglGetCurrentContext())) || (!this.mEglSurface.equals(this.mEgl.eglGetCurrentSurface(12377)))) && (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))) {
      throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
  }
  
  private void checkEglError()
  {
    int i = this.mEgl.eglGetError();
    if (i != 12288) {
      Log.w("TextureRenderer", "EGL error = 0x" + Integer.toHexString(i));
    }
  }
  
  private void checkGlError()
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.w("TextureRenderer", "GL error = 0x" + Integer.toHexString(i));
    }
  }
  
  private EGLConfig chooseEglConfig()
  {
    int[] arrayOfInt1 = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = getConfig();
    if (!this.mEgl.eglChooseConfig(this.mEglDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
      throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    if (arrayOfInt1[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
  }
  
  private void destroyGL()
  {
    this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
    this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
    GLES20.glDeleteTextures(1, this.mTextures, 0);
  }
  
  private void drawQuad()
  {
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
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initGL()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    int[] arrayOfInt = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt)) {
      throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    this.mEglConfig = chooseEglConfig();
    if (this.mEglConfig == null) {
      throw new RuntimeException("eglConfig not initialized ");
    }
    this.mEglContext = createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
    this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.mSTexture, null);
    if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
    {
      i = this.mEgl.eglGetError();
      if (i == 12299) {
        Log.e("TextureRenderer", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW ");
      }
    }
    while (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
    {
      int i;
      return;
      throw new RuntimeException("createWindowSurface failed " + GLUtils.getEGLErrorString(i));
    }
    throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
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
  
  EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  public void destroy()
  {
    synchronized (this.mUpdateLock)
    {
      this.mDone = true;
      this.mUpdateLock.notify();
      return;
    }
  }
  
  /* Error */
  public int getTextureId()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 207	com/google/atap/tangoservice/TextureRenderer:mTextures	[I
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
    //   18: getfield 207	com/google/atap/tangoservice/TextureRenderer:mTextures	[I
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
    //   0	32	0	this	TextureRenderer
    //   12	12	1	i	int
    //   6	2	2	arrayOfInt	int[]
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   17	24	27	finally
  }
  
  public int initTexture()
  {
    try
    {
      this.mTextures = new int[1];
      GLES20.glGenTextures(1, this.mTextures, 0);
      checkGlError();
      int i = this.mTextures[0];
      GLES20.glBindTexture(36197, i);
      checkGlError();
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      GLES20.glTexParameteri(36197, 10241, 9728);
      GLES20.glTexParameteri(36197, 10240, 9728);
      checkEglError();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onFrameAvailable()
  {
    synchronized (this.mUpdateLock)
    {
      this.mUpdateLock.notify();
      return;
    }
  }
  
  public void run()
  {
    initGL();
    this.mProgram = loadShader("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4(vPosition.x, vPosition.y, 0.0, 1.0);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    checkGlError();
    initTexture();
    synchronized (this.mUpdateLock)
    {
      boolean bool = this.mDone;
      if (bool) {}
    }
    destroyGL();
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.mSTexture = paramSurfaceTexture;
  }
  
  public void setViewport(int paramInt1, int paramInt2)
  {
    synchronized (this.mUpdateLock)
    {
      this.mUpdateViewPort = true;
      this.mViewPortWidth = paramInt1;
      this.mViewPortHeight = paramInt2;
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TextureRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */