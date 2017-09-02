package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class ViewCompatJB
{
  public static Object getAccessibilityNodeProvider(View paramView)
  {
    return paramView.getAccessibilityNodeProvider();
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public static int getMinimumHeight(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public static int getMinimumWidth(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  public static boolean hasOverlappingRendering(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    paramView.setHasTransientState(paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/ViewCompatJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */