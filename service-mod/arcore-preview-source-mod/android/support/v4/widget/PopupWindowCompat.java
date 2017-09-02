package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;

public final class PopupWindowCompat
{
  static final PopupWindowImpl IMPL = new BasePopupWindowImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new Api23PopupWindowImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new Api21PopupWindowImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatPopupWindowImpl();
      return;
    }
    if (i >= 9)
    {
      IMPL = new GingerbreadPopupWindowImpl();
      return;
    }
  }
  
  public static boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    return IMPL.getOverlapAnchor(paramPopupWindow);
  }
  
  public static int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    return IMPL.getWindowLayoutType(paramPopupWindow);
  }
  
  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    IMPL.setOverlapAnchor(paramPopupWindow, paramBoolean);
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    IMPL.setWindowLayoutType(paramPopupWindow, paramInt);
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  static class Api21PopupWindowImpl
    extends PopupWindowCompat.KitKatPopupWindowImpl
  {
    public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
    {
      return PopupWindowCompatApi21.getOverlapAnchor(paramPopupWindow);
    }
    
    public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      PopupWindowCompatApi21.setOverlapAnchor(paramPopupWindow, paramBoolean);
    }
  }
  
  static class Api23PopupWindowImpl
    extends PopupWindowCompat.Api21PopupWindowImpl
  {
    public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
    {
      return PopupWindowCompatApi23.getOverlapAnchor(paramPopupWindow);
    }
    
    public int getWindowLayoutType(PopupWindow paramPopupWindow)
    {
      return PopupWindowCompatApi23.getWindowLayoutType(paramPopupWindow);
    }
    
    public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      PopupWindowCompatApi23.setOverlapAnchor(paramPopupWindow, paramBoolean);
    }
    
    public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
    {
      PopupWindowCompatApi23.setWindowLayoutType(paramPopupWindow, paramInt);
    }
  }
  
  static class BasePopupWindowImpl
    implements PopupWindowCompat.PopupWindowImpl
  {
    public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
    {
      return false;
    }
    
    public int getWindowLayoutType(PopupWindow paramPopupWindow)
    {
      return 0;
    }
    
    public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {}
    
    public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {}
    
    public void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5) {
        i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
      }
      paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
    }
  }
  
  static class GingerbreadPopupWindowImpl
    extends PopupWindowCompat.BasePopupWindowImpl
  {
    public int getWindowLayoutType(PopupWindow paramPopupWindow)
    {
      return PopupWindowCompatGingerbread.getWindowLayoutType(paramPopupWindow);
    }
    
    public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
    {
      PopupWindowCompatGingerbread.setWindowLayoutType(paramPopupWindow, paramInt);
    }
  }
  
  static class KitKatPopupWindowImpl
    extends PopupWindowCompat.GingerbreadPopupWindowImpl
  {
    public void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      PopupWindowCompatKitKat.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static abstract interface PopupWindowImpl
  {
    public abstract boolean getOverlapAnchor(PopupWindow paramPopupWindow);
    
    public abstract int getWindowLayoutType(PopupWindow paramPopupWindow);
    
    public abstract void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean);
    
    public abstract void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt);
    
    public abstract void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/widget/PopupWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */