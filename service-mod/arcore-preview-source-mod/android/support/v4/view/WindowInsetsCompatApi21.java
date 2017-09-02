package android.support.v4.view;

import android.graphics.Rect;
import android.view.WindowInsets;

class WindowInsetsCompatApi21
  extends WindowInsetsCompat
{
  private final WindowInsets mSource;
  
  WindowInsetsCompatApi21(WindowInsets paramWindowInsets)
  {
    this.mSource = paramWindowInsets;
  }
  
  public WindowInsetsCompat consumeStableInsets()
  {
    return new WindowInsetsCompatApi21(this.mSource.consumeStableInsets());
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    return new WindowInsetsCompatApi21(this.mSource.consumeSystemWindowInsets());
  }
  
  public int getStableInsetBottom()
  {
    return this.mSource.getStableInsetBottom();
  }
  
  public int getStableInsetLeft()
  {
    return this.mSource.getStableInsetLeft();
  }
  
  public int getStableInsetRight()
  {
    return this.mSource.getStableInsetRight();
  }
  
  public int getStableInsetTop()
  {
    return this.mSource.getStableInsetTop();
  }
  
  public int getSystemWindowInsetBottom()
  {
    return this.mSource.getSystemWindowInsetBottom();
  }
  
  public int getSystemWindowInsetLeft()
  {
    return this.mSource.getSystemWindowInsetLeft();
  }
  
  public int getSystemWindowInsetRight()
  {
    return this.mSource.getSystemWindowInsetRight();
  }
  
  public int getSystemWindowInsetTop()
  {
    return this.mSource.getSystemWindowInsetTop();
  }
  
  public boolean hasInsets()
  {
    return this.mSource.hasInsets();
  }
  
  public boolean hasStableInsets()
  {
    return this.mSource.hasStableInsets();
  }
  
  public boolean hasSystemWindowInsets()
  {
    return this.mSource.hasSystemWindowInsets();
  }
  
  public boolean isConsumed()
  {
    return this.mSource.isConsumed();
  }
  
  public boolean isRound()
  {
    return this.mSource.isRound();
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect)
  {
    return new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(paramRect));
  }
  
  WindowInsets unwrap()
  {
    return this.mSource;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/WindowInsetsCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */