package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class BitmapCompat
{
  static final BitmapImpl IMPL = new BaseBitmapImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      IMPL = new KitKatBitmapCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new JbMr2BitmapCompatImpl();
      return;
    }
    if (i >= 12)
    {
      IMPL = new HcMr1BitmapCompatImpl();
      return;
    }
  }
  
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    return IMPL.getAllocationByteCount(paramBitmap);
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    return IMPL.hasMipMap(paramBitmap);
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    IMPL.setHasMipMap(paramBitmap, paramBoolean);
  }
  
  static class BaseBitmapImpl
    implements BitmapCompat.BitmapImpl
  {
    public int getAllocationByteCount(Bitmap paramBitmap)
    {
      return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }
    
    public boolean hasMipMap(Bitmap paramBitmap)
    {
      return false;
    }
    
    public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean) {}
  }
  
  static abstract interface BitmapImpl
  {
    public abstract int getAllocationByteCount(Bitmap paramBitmap);
    
    public abstract boolean hasMipMap(Bitmap paramBitmap);
    
    public abstract void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean);
  }
  
  static class HcMr1BitmapCompatImpl
    extends BitmapCompat.BaseBitmapImpl
  {
    public int getAllocationByteCount(Bitmap paramBitmap)
    {
      return BitmapCompatHoneycombMr1.getAllocationByteCount(paramBitmap);
    }
  }
  
  static class JbMr2BitmapCompatImpl
    extends BitmapCompat.HcMr1BitmapCompatImpl
  {
    public boolean hasMipMap(Bitmap paramBitmap)
    {
      return BitmapCompatJellybeanMR2.hasMipMap(paramBitmap);
    }
    
    public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
    {
      BitmapCompatJellybeanMR2.setHasMipMap(paramBitmap, paramBoolean);
    }
  }
  
  static class KitKatBitmapCompatImpl
    extends BitmapCompat.JbMr2BitmapCompatImpl
  {
    public int getAllocationByteCount(Bitmap paramBitmap)
    {
      return BitmapCompatKitKat.getAllocationByteCount(paramBitmap);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/graphics/BitmapCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */