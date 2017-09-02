package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (systemSupportsPrint())
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mImpl = new PrintHelperApi24Impl(paramContext);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.mImpl = new PrintHelperApi23Impl(paramContext);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mImpl = new PrintHelperApi20Impl(paramContext);
        return;
      }
      this.mImpl = new PrintHelperKitkatImpl(paramContext);
      return;
    }
    this.mImpl = new PrintHelperStubImpl(null);
  }
  
  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public int getColorMode()
  {
    return this.mImpl.getColorMode();
  }
  
  public int getOrientation()
  {
    return this.mImpl.getOrientation();
  }
  
  public int getScaleMode()
  {
    return this.mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, paramOnPrintFinishCallback);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    this.mImpl.printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    this.mImpl.printBitmap(paramString, paramUri, paramOnPrintFinishCallback);
  }
  
  public void setColorMode(int paramInt)
  {
    this.mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    this.mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mImpl.setScaleMode(paramInt);
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
  
  private static final class PrintHelperApi20Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi20>
  {
    PrintHelperApi20Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperApi23Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi23>
  {
    PrintHelperApi23Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperApi24Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi24>
  {
    PrintHelperApi24Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static class PrintHelperImpl<RealHelper extends PrintHelperKitkat>
    implements PrintHelper.PrintHelperVersionImpl
  {
    private final RealHelper mPrintHelper;
    
    protected PrintHelperImpl(RealHelper paramRealHelper)
    {
      this.mPrintHelper = paramRealHelper;
    }
    
    public int getColorMode()
    {
      return this.mPrintHelper.getColorMode();
    }
    
    public int getOrientation()
    {
      return this.mPrintHelper.getOrientation();
    }
    
    public int getScaleMode()
    {
      return this.mPrintHelper.getScaleMode();
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    {
      PrintHelperKitkat.OnPrintFinishCallback local1 = null;
      if (paramOnPrintFinishCallback != null) {
        local1 = new PrintHelperKitkat.OnPrintFinishCallback()
        {
          public void onFinish()
          {
            paramOnPrintFinishCallback.onFinish();
          }
        };
      }
      this.mPrintHelper.printBitmap(paramString, paramBitmap, local1);
    }
    
    public void printBitmap(String paramString, Uri paramUri, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
      throws FileNotFoundException
    {
      PrintHelperKitkat.OnPrintFinishCallback local2 = null;
      if (paramOnPrintFinishCallback != null) {
        local2 = new PrintHelperKitkat.OnPrintFinishCallback()
        {
          public void onFinish()
          {
            paramOnPrintFinishCallback.onFinish();
          }
        };
      }
      this.mPrintHelper.printBitmap(paramString, paramUri, local2);
    }
    
    public void setColorMode(int paramInt)
    {
      this.mPrintHelper.setColorMode(paramInt);
    }
    
    public void setOrientation(int paramInt)
    {
      this.mPrintHelper.setOrientation(paramInt);
    }
    
    public void setScaleMode(int paramInt)
    {
      this.mPrintHelper.setScaleMode(paramInt);
    }
  }
  
  private static final class PrintHelperKitkatImpl
    extends PrintHelper.PrintHelperImpl<PrintHelperKitkat>
  {
    PrintHelperKitkatImpl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperStubImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    int mColorMode = 2;
    int mOrientation = 1;
    int mScaleMode = 2;
    
    public int getColorMode()
    {
      return this.mColorMode;
    }
    
    public int getOrientation()
    {
      return this.mOrientation;
    }
    
    public int getScaleMode()
    {
      return this.mScaleMode;
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void setColorMode(int paramInt)
    {
      this.mColorMode = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      this.mOrientation = paramInt;
    }
    
    public void setScaleMode(int paramInt)
    {
      this.mScaleMode = paramInt;
    }
  }
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getOrientation();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
    
    public abstract void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
      throws FileNotFoundException;
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/print/PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */