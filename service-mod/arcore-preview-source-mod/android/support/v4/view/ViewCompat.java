package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.BuildCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  private static final long FAKE_FRAME_TIME = 10L;
  static final ViewCompatImpl IMPL = new BaseViewCompatImpl();
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  public static final int LAYER_TYPE_HARDWARE = 2;
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  public static final int MEASURED_SIZE_MASK = 16777215;
  public static final int MEASURED_STATE_MASK = -16777216;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  public static final int SCROLL_AXIS_HORIZONTAL = 1;
  public static final int SCROLL_AXIS_NONE = 0;
  public static final int SCROLL_AXIS_VERTICAL = 2;
  public static final int SCROLL_INDICATOR_BOTTOM = 2;
  public static final int SCROLL_INDICATOR_END = 32;
  public static final int SCROLL_INDICATOR_LEFT = 4;
  public static final int SCROLL_INDICATOR_RIGHT = 8;
  public static final int SCROLL_INDICATOR_START = 16;
  public static final int SCROLL_INDICATOR_TOP = 1;
  private static final String TAG = "ViewCompat";
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (BuildCompat.isAtLeastN())
    {
      IMPL = new Api24ViewCompatImpl();
      return;
    }
    if (i >= 23)
    {
      IMPL = new MarshmallowViewCompatImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new LollipopViewCompatImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatViewCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new JbMr2ViewCompatImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JbMr1ViewCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JBViewCompatImpl();
      return;
    }
    if (i >= 15)
    {
      IMPL = new ICSMr1ViewCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICSViewCompatImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HCViewCompatImpl();
      return;
    }
    if (i >= 9)
    {
      IMPL = new GBViewCompatImpl();
      return;
    }
    if (i >= 7)
    {
      IMPL = new EclairMr1ViewCompatImpl();
      return;
    }
  }
  
  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    return IMPL.animate(paramView);
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return IMPL.canScrollHorizontally(paramView, paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return IMPL.canScrollVertically(paramView, paramInt);
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return IMPL.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void dispatchFinishTemporaryDetach(View paramView)
  {
    IMPL.dispatchFinishTemporaryDetach(paramView);
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return IMPL.dispatchNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return IMPL.dispatchNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return IMPL.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return IMPL.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public static void dispatchStartTemporaryDetach(View paramView)
  {
    IMPL.dispatchStartTemporaryDetach(paramView);
  }
  
  public static int getAccessibilityLiveRegion(View paramView)
  {
    return IMPL.getAccessibilityLiveRegion(paramView);
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return IMPL.getAccessibilityNodeProvider(paramView);
  }
  
  public static float getAlpha(View paramView)
  {
    return IMPL.getAlpha(paramView);
  }
  
  public static ColorStateList getBackgroundTintList(View paramView)
  {
    return IMPL.getBackgroundTintList(paramView);
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return IMPL.getBackgroundTintMode(paramView);
  }
  
  public static Rect getClipBounds(View paramView)
  {
    return IMPL.getClipBounds(paramView);
  }
  
  public static float getElevation(View paramView)
  {
    return IMPL.getElevation(paramView);
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    return IMPL.getFitsSystemWindows(paramView);
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    return IMPL.getImportantForAccessibility(paramView);
  }
  
  public static int getLabelFor(View paramView)
  {
    return IMPL.getLabelFor(paramView);
  }
  
  public static int getLayerType(View paramView)
  {
    return IMPL.getLayerType(paramView);
  }
  
  public static int getLayoutDirection(View paramView)
  {
    return IMPL.getLayoutDirection(paramView);
  }
  
  @Nullable
  public static Matrix getMatrix(View paramView)
  {
    return IMPL.getMatrix(paramView);
  }
  
  public static int getMeasuredHeightAndState(View paramView)
  {
    return IMPL.getMeasuredHeightAndState(paramView);
  }
  
  public static int getMeasuredState(View paramView)
  {
    return IMPL.getMeasuredState(paramView);
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return IMPL.getMeasuredWidthAndState(paramView);
  }
  
  public static int getMinimumHeight(View paramView)
  {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getMinimumWidth(View paramView)
  {
    return IMPL.getMinimumWidth(paramView);
  }
  
  public static int getOverScrollMode(View paramView)
  {
    return IMPL.getOverScrollMode(paramView);
  }
  
  public static int getPaddingEnd(View paramView)
  {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView)
  {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    return IMPL.getParentForAccessibility(paramView);
  }
  
  public static float getPivotX(View paramView)
  {
    return IMPL.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView)
  {
    return IMPL.getPivotY(paramView);
  }
  
  public static float getRotation(View paramView)
  {
    return IMPL.getRotation(paramView);
  }
  
  public static float getRotationX(View paramView)
  {
    return IMPL.getRotationX(paramView);
  }
  
  public static float getRotationY(View paramView)
  {
    return IMPL.getRotationY(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    return IMPL.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView)
  {
    return IMPL.getScaleY(paramView);
  }
  
  public static int getScrollIndicators(@NonNull View paramView)
  {
    return IMPL.getScrollIndicators(paramView);
  }
  
  public static String getTransitionName(View paramView)
  {
    return IMPL.getTransitionName(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    return IMPL.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    return IMPL.getTranslationY(paramView);
  }
  
  public static float getTranslationZ(View paramView)
  {
    return IMPL.getTranslationZ(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView)
  {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  public static float getX(View paramView)
  {
    return IMPL.getX(paramView);
  }
  
  public static float getY(View paramView)
  {
    return IMPL.getY(paramView);
  }
  
  public static float getZ(View paramView)
  {
    return IMPL.getZ(paramView);
  }
  
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    return IMPL.hasAccessibilityDelegate(paramView);
  }
  
  public static boolean hasNestedScrollingParent(View paramView)
  {
    return IMPL.hasNestedScrollingParent(paramView);
  }
  
  public static boolean hasOnClickListeners(View paramView)
  {
    return IMPL.hasOnClickListeners(paramView);
  }
  
  public static boolean hasOverlappingRendering(View paramView)
  {
    return IMPL.hasOverlappingRendering(paramView);
  }
  
  public static boolean hasTransientState(View paramView)
  {
    return IMPL.hasTransientState(paramView);
  }
  
  public static boolean isAttachedToWindow(View paramView)
  {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  public static boolean isInLayout(View paramView)
  {
    return IMPL.isInLayout(paramView);
  }
  
  public static boolean isLaidOut(View paramView)
  {
    return IMPL.isLaidOut(paramView);
  }
  
  public static boolean isLayoutDirectionResolved(View paramView)
  {
    return IMPL.isLayoutDirectionResolved(paramView);
  }
  
  public static boolean isNestedScrollingEnabled(View paramView)
  {
    return IMPL.isNestedScrollingEnabled(paramView);
  }
  
  public static boolean isOpaque(View paramView)
  {
    return IMPL.isOpaque(paramView);
  }
  
  public static boolean isPaddingRelative(View paramView)
  {
    return IMPL.isPaddingRelative(paramView);
  }
  
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    IMPL.jumpDrawablesToCurrentState(paramView);
  }
  
  public static void offsetLeftAndRight(View paramView, int paramInt)
  {
    IMPL.offsetLeftAndRight(paramView, paramInt);
  }
  
  public static void offsetTopAndBottom(View paramView, int paramInt)
  {
    IMPL.offsetTopAndBottom(paramView, paramInt);
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return IMPL.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    IMPL.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return IMPL.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView)
  {
    IMPL.requestApplyInsets(paramView);
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return IMPL.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    IMPL.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public static void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    IMPL.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  public static void setActivated(View paramView, boolean paramBoolean)
  {
    IMPL.setActivated(paramView, paramBoolean);
  }
  
  public static void setAlpha(View paramView, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    IMPL.setAlpha(paramView, paramFloat);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    IMPL.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    IMPL.setBackgroundTintMode(paramView, paramMode);
  }
  
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    IMPL.setChildrenDrawingOrderEnabled(paramViewGroup, paramBoolean);
  }
  
  public static void setClipBounds(View paramView, Rect paramRect)
  {
    IMPL.setClipBounds(paramView, paramRect);
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    IMPL.setElevation(paramView, paramFloat);
  }
  
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    IMPL.setFitsSystemWindows(paramView, paramBoolean);
  }
  
  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    IMPL.setHasTransientState(paramView, paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    IMPL.setImportantForAccessibility(paramView, paramInt);
  }
  
  public static void setLabelFor(View paramView, @IdRes int paramInt)
  {
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    IMPL.setLayerPaint(paramView, paramPaint);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    IMPL.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    IMPL.setLayoutDirection(paramView, paramInt);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    IMPL.setNestedScrollingEnabled(paramView, paramBoolean);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    IMPL.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    IMPL.setOverScrollMode(paramView, paramInt);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    IMPL.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    IMPL.setPivotY(paramView, paramFloat);
  }
  
  public static void setPointerIcon(@NonNull View paramView, PointerIconCompat paramPointerIconCompat)
  {
    IMPL.setPointerIcon(paramView, paramPointerIconCompat);
  }
  
  public static void setRotation(View paramView, float paramFloat)
  {
    IMPL.setRotation(paramView, paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat)
  {
    IMPL.setRotationX(paramView, paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat)
  {
    IMPL.setRotationY(paramView, paramFloat);
  }
  
  public static void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    IMPL.setSaveFromParentEnabled(paramView, paramBoolean);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    IMPL.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    IMPL.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt)
  {
    IMPL.setScrollIndicators(paramView, paramInt);
  }
  
  public static void setScrollIndicators(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    IMPL.setScrollIndicators(paramView, paramInt1, paramInt2);
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    IMPL.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    IMPL.setTranslationY(paramView, paramFloat);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    IMPL.setTranslationZ(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    IMPL.setX(paramView, paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat)
  {
    IMPL.setY(paramView, paramFloat);
  }
  
  public static void setZ(View paramView, float paramFloat)
  {
    IMPL.setZ(paramView, paramFloat);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt)
  {
    return IMPL.startNestedScroll(paramView, paramInt);
  }
  
  public static void stopNestedScroll(View paramView)
  {
    IMPL.stopNestedScroll(paramView);
  }
  
  static class Api24ViewCompatImpl
    extends ViewCompat.MarshmallowViewCompatImpl
  {
    public void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat)
    {
      ViewCompatApi24.setPointerIcon(paramView, paramPointerIconCompat.getPointerIcon());
    }
  }
  
  static class BaseViewCompatImpl
    implements ViewCompat.ViewCompatImpl
  {
    private Method mDispatchFinishTemporaryDetach;
    private Method mDispatchStartTemporaryDetach;
    private boolean mTempDetachBound;
    WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
    
    private void bindTempDetach()
    {
      try
      {
        this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
        this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        this.mTempDetachBound = true;
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          Log.e("ViewCompat", "Couldn't find method", localNoSuchMethodException);
        }
      }
    }
    
    private boolean canScrollingViewScrollHorizontally(ScrollingView paramScrollingView, int paramInt)
    {
      boolean bool = true;
      int i = paramScrollingView.computeHorizontalScrollOffset();
      int j = paramScrollingView.computeHorizontalScrollRange() - paramScrollingView.computeHorizontalScrollExtent();
      if (j == 0) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if (paramInt >= 0) {
            break;
          }
        } while (i > 0);
        return false;
      } while (i < j - 1);
      return false;
    }
    
    private boolean canScrollingViewScrollVertically(ScrollingView paramScrollingView, int paramInt)
    {
      boolean bool = true;
      int i = paramScrollingView.computeVerticalScrollOffset();
      int j = paramScrollingView.computeVerticalScrollRange() - paramScrollingView.computeVerticalScrollExtent();
      if (j == 0) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if (paramInt >= 0) {
            break;
          }
        } while (i > 0);
        return false;
      } while (i < j - 1);
      return false;
    }
    
    public ViewPropertyAnimatorCompat animate(View paramView)
    {
      return new ViewPropertyAnimatorCompat(paramView);
    }
    
    public boolean canScrollHorizontally(View paramView, int paramInt)
    {
      return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollHorizontally((ScrollingView)paramView, paramInt));
    }
    
    public boolean canScrollVertically(View paramView, int paramInt)
    {
      return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollVertically((ScrollingView)paramView, paramInt));
    }
    
    public int combineMeasuredStates(int paramInt1, int paramInt2)
    {
      return paramInt1 | paramInt2;
    }
    
    public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public void dispatchFinishTemporaryDetach(View paramView)
    {
      if (!this.mTempDetachBound) {
        bindTempDetach();
      }
      if (this.mDispatchFinishTemporaryDetach != null) {
        try
        {
          this.mDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
          return;
        }
        catch (Exception paramView)
        {
          Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", paramView);
          return;
        }
      }
      paramView.onFinishTemporaryDetach();
    }
    
    public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
      }
      return false;
    }
    
    public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
      }
      return false;
    }
    
    public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      }
      return false;
    }
    
    public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
      }
      return false;
    }
    
    public void dispatchStartTemporaryDetach(View paramView)
    {
      if (!this.mTempDetachBound) {
        bindTempDetach();
      }
      if (this.mDispatchStartTemporaryDetach != null) {
        try
        {
          this.mDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
          return;
        }
        catch (Exception paramView)
        {
          Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", paramView);
          return;
        }
      }
      paramView.onStartTemporaryDetach();
    }
    
    public int getAccessibilityLiveRegion(View paramView)
    {
      return 0;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      return null;
    }
    
    public float getAlpha(View paramView)
    {
      return 1.0F;
    }
    
    public ColorStateList getBackgroundTintList(View paramView)
    {
      return ViewCompatBase.getBackgroundTintList(paramView);
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View paramView)
    {
      return ViewCompatBase.getBackgroundTintMode(paramView);
    }
    
    public Rect getClipBounds(View paramView)
    {
      return null;
    }
    
    public float getElevation(View paramView)
    {
      return 0.0F;
    }
    
    public boolean getFitsSystemWindows(View paramView)
    {
      return false;
    }
    
    long getFrameTime()
    {
      return 10L;
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return 0;
    }
    
    public int getLabelFor(View paramView)
    {
      return 0;
    }
    
    public int getLayerType(View paramView)
    {
      return 0;
    }
    
    public int getLayoutDirection(View paramView)
    {
      return 0;
    }
    
    public Matrix getMatrix(View paramView)
    {
      return null;
    }
    
    public int getMeasuredHeightAndState(View paramView)
    {
      return paramView.getMeasuredHeight();
    }
    
    public int getMeasuredState(View paramView)
    {
      return 0;
    }
    
    public int getMeasuredWidthAndState(View paramView)
    {
      return paramView.getMeasuredWidth();
    }
    
    public int getMinimumHeight(View paramView)
    {
      return ViewCompatBase.getMinimumHeight(paramView);
    }
    
    public int getMinimumWidth(View paramView)
    {
      return ViewCompatBase.getMinimumWidth(paramView);
    }
    
    public int getOverScrollMode(View paramView)
    {
      return 2;
    }
    
    public int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public int getPaddingStart(View paramView)
    {
      return paramView.getPaddingLeft();
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return paramView.getParent();
    }
    
    public float getPivotX(View paramView)
    {
      return 0.0F;
    }
    
    public float getPivotY(View paramView)
    {
      return 0.0F;
    }
    
    public float getRotation(View paramView)
    {
      return 0.0F;
    }
    
    public float getRotationX(View paramView)
    {
      return 0.0F;
    }
    
    public float getRotationY(View paramView)
    {
      return 0.0F;
    }
    
    public float getScaleX(View paramView)
    {
      return 0.0F;
    }
    
    public float getScaleY(View paramView)
    {
      return 0.0F;
    }
    
    public int getScrollIndicators(View paramView)
    {
      return 0;
    }
    
    public String getTransitionName(View paramView)
    {
      return null;
    }
    
    public float getTranslationX(View paramView)
    {
      return 0.0F;
    }
    
    public float getTranslationY(View paramView)
    {
      return 0.0F;
    }
    
    public float getTranslationZ(View paramView)
    {
      return 0.0F;
    }
    
    public int getWindowSystemUiVisibility(View paramView)
    {
      return 0;
    }
    
    public float getX(View paramView)
    {
      return 0.0F;
    }
    
    public float getY(View paramView)
    {
      return 0.0F;
    }
    
    public float getZ(View paramView)
    {
      return getTranslationZ(paramView) + getElevation(paramView);
    }
    
    public boolean hasAccessibilityDelegate(View paramView)
    {
      return false;
    }
    
    public boolean hasNestedScrollingParent(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
      }
      return false;
    }
    
    public boolean hasOnClickListeners(View paramView)
    {
      return false;
    }
    
    public boolean hasOverlappingRendering(View paramView)
    {
      return true;
    }
    
    public boolean hasTransientState(View paramView)
    {
      return false;
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return ViewCompatBase.isAttachedToWindow(paramView);
    }
    
    public boolean isImportantForAccessibility(View paramView)
    {
      return true;
    }
    
    public boolean isInLayout(View paramView)
    {
      return false;
    }
    
    public boolean isLaidOut(View paramView)
    {
      return ViewCompatBase.isLaidOut(paramView);
    }
    
    public boolean isLayoutDirectionResolved(View paramView)
    {
      return false;
    }
    
    public boolean isNestedScrollingEnabled(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
      }
      return false;
    }
    
    public boolean isOpaque(View paramView)
    {
      boolean bool2 = false;
      paramView = paramView.getBackground();
      boolean bool1 = bool2;
      if (paramView != null)
      {
        bool1 = bool2;
        if (paramView.getOpacity() == -1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isPaddingRelative(View paramView)
    {
      return false;
    }
    
    public void jumpDrawablesToCurrentState(View paramView) {}
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      ViewCompatBase.offsetLeftAndRight(paramView, paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      ViewCompatBase.offsetTopAndBottom(paramView, paramInt);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return paramWindowInsetsCompat;
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      paramView.invalidate();
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, getFrameTime());
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
    }
    
    public void requestApplyInsets(View paramView) {}
    
    public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSize(paramInt1, paramInt2);
    }
    
    public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
    
    public void setActivated(View paramView, boolean paramBoolean) {}
    
    public void setAlpha(View paramView, float paramFloat) {}
    
    public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
    {
      ViewCompatBase.setBackgroundTintList(paramView, paramColorStateList);
    }
    
    public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
    {
      ViewCompatBase.setBackgroundTintMode(paramView, paramMode);
    }
    
    public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {}
    
    public void setClipBounds(View paramView, Rect paramRect) {}
    
    public void setElevation(View paramView, float paramFloat) {}
    
    public void setFitsSystemWindows(View paramView, boolean paramBoolean) {}
    
    public void setHasTransientState(View paramView, boolean paramBoolean) {}
    
    public void setImportantForAccessibility(View paramView, int paramInt) {}
    
    public void setLabelFor(View paramView, int paramInt) {}
    
    public void setLayerPaint(View paramView, Paint paramPaint) {}
    
    public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
    
    public void setLayoutDirection(View paramView, int paramInt) {}
    
    public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
      }
    }
    
    public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
    
    public void setOverScrollMode(View paramView, int paramInt) {}
    
    public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setPivotX(View paramView, float paramFloat) {}
    
    public void setPivotY(View paramView, float paramFloat) {}
    
    public void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat) {}
    
    public void setRotation(View paramView, float paramFloat) {}
    
    public void setRotationX(View paramView, float paramFloat) {}
    
    public void setRotationY(View paramView, float paramFloat) {}
    
    public void setSaveFromParentEnabled(View paramView, boolean paramBoolean) {}
    
    public void setScaleX(View paramView, float paramFloat) {}
    
    public void setScaleY(View paramView, float paramFloat) {}
    
    public void setScrollIndicators(View paramView, int paramInt) {}
    
    public void setScrollIndicators(View paramView, int paramInt1, int paramInt2) {}
    
    public void setTransitionName(View paramView, String paramString) {}
    
    public void setTranslationX(View paramView, float paramFloat) {}
    
    public void setTranslationY(View paramView, float paramFloat) {}
    
    public void setTranslationZ(View paramView, float paramFloat) {}
    
    public void setX(View paramView, float paramFloat) {}
    
    public void setY(View paramView, float paramFloat) {}
    
    public void setZ(View paramView, float paramFloat) {}
    
    public boolean startNestedScroll(View paramView, int paramInt)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
      }
      return false;
    }
    
    public void stopNestedScroll(View paramView)
    {
      if ((paramView instanceof NestedScrollingChild)) {
        ((NestedScrollingChild)paramView).stopNestedScroll();
      }
    }
  }
  
  static class EclairMr1ViewCompatImpl
    extends ViewCompat.BaseViewCompatImpl
  {
    public boolean isOpaque(View paramView)
    {
      return ViewCompatEclairMr1.isOpaque(paramView);
    }
    
    public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(paramViewGroup, paramBoolean);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusRealDirection {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusRelativeDirection {}
  
  static class GBViewCompatImpl
    extends ViewCompat.EclairMr1ViewCompatImpl
  {
    public int getOverScrollMode(View paramView)
    {
      return ViewCompatGingerbread.getOverScrollMode(paramView);
    }
    
    public void setOverScrollMode(View paramView, int paramInt)
    {
      ViewCompatGingerbread.setOverScrollMode(paramView, paramInt);
    }
  }
  
  static class HCViewCompatImpl
    extends ViewCompat.GBViewCompatImpl
  {
    public int combineMeasuredStates(int paramInt1, int paramInt2)
    {
      return ViewCompatHC.combineMeasuredStates(paramInt1, paramInt2);
    }
    
    public float getAlpha(View paramView)
    {
      return ViewCompatHC.getAlpha(paramView);
    }
    
    long getFrameTime()
    {
      return ViewCompatHC.getFrameTime();
    }
    
    public int getLayerType(View paramView)
    {
      return ViewCompatHC.getLayerType(paramView);
    }
    
    public Matrix getMatrix(View paramView)
    {
      return ViewCompatHC.getMatrix(paramView);
    }
    
    public int getMeasuredHeightAndState(View paramView)
    {
      return ViewCompatHC.getMeasuredHeightAndState(paramView);
    }
    
    public int getMeasuredState(View paramView)
    {
      return ViewCompatHC.getMeasuredState(paramView);
    }
    
    public int getMeasuredWidthAndState(View paramView)
    {
      return ViewCompatHC.getMeasuredWidthAndState(paramView);
    }
    
    public float getPivotX(View paramView)
    {
      return ViewCompatHC.getPivotX(paramView);
    }
    
    public float getPivotY(View paramView)
    {
      return ViewCompatHC.getPivotY(paramView);
    }
    
    public float getRotation(View paramView)
    {
      return ViewCompatHC.getRotation(paramView);
    }
    
    public float getRotationX(View paramView)
    {
      return ViewCompatHC.getRotationX(paramView);
    }
    
    public float getRotationY(View paramView)
    {
      return ViewCompatHC.getRotationY(paramView);
    }
    
    public float getScaleX(View paramView)
    {
      return ViewCompatHC.getScaleX(paramView);
    }
    
    public float getScaleY(View paramView)
    {
      return ViewCompatHC.getScaleY(paramView);
    }
    
    public float getTranslationX(View paramView)
    {
      return ViewCompatHC.getTranslationX(paramView);
    }
    
    public float getTranslationY(View paramView)
    {
      return ViewCompatHC.getTranslationY(paramView);
    }
    
    public float getX(View paramView)
    {
      return ViewCompatHC.getX(paramView);
    }
    
    public float getY(View paramView)
    {
      return ViewCompatHC.getY(paramView);
    }
    
    public void jumpDrawablesToCurrentState(View paramView)
    {
      ViewCompatHC.jumpDrawablesToCurrentState(paramView);
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
    }
    
    public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
    {
      return ViewCompatHC.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
    }
    
    public void setActivated(View paramView, boolean paramBoolean)
    {
      ViewCompatHC.setActivated(paramView, paramBoolean);
    }
    
    public void setAlpha(View paramView, float paramFloat)
    {
      ViewCompatHC.setAlpha(paramView, paramFloat);
    }
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      setLayerType(paramView, getLayerType(paramView), paramPaint);
      paramView.invalidate();
    }
    
    public void setLayerType(View paramView, int paramInt, Paint paramPaint)
    {
      ViewCompatHC.setLayerType(paramView, paramInt, paramPaint);
    }
    
    public void setPivotX(View paramView, float paramFloat)
    {
      ViewCompatHC.setPivotX(paramView, paramFloat);
    }
    
    public void setPivotY(View paramView, float paramFloat)
    {
      ViewCompatHC.setPivotY(paramView, paramFloat);
    }
    
    public void setRotation(View paramView, float paramFloat)
    {
      ViewCompatHC.setRotation(paramView, paramFloat);
    }
    
    public void setRotationX(View paramView, float paramFloat)
    {
      ViewCompatHC.setRotationX(paramView, paramFloat);
    }
    
    public void setRotationY(View paramView, float paramFloat)
    {
      ViewCompatHC.setRotationY(paramView, paramFloat);
    }
    
    public void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
    {
      ViewCompatHC.setSaveFromParentEnabled(paramView, paramBoolean);
    }
    
    public void setScaleX(View paramView, float paramFloat)
    {
      ViewCompatHC.setScaleX(paramView, paramFloat);
    }
    
    public void setScaleY(View paramView, float paramFloat)
    {
      ViewCompatHC.setScaleY(paramView, paramFloat);
    }
    
    public void setTranslationX(View paramView, float paramFloat)
    {
      ViewCompatHC.setTranslationX(paramView, paramFloat);
    }
    
    public void setTranslationY(View paramView, float paramFloat)
    {
      ViewCompatHC.setTranslationY(paramView, paramFloat);
    }
    
    public void setX(View paramView, float paramFloat)
    {
      ViewCompatHC.setX(paramView, paramFloat);
    }
    
    public void setY(View paramView, float paramFloat)
    {
      ViewCompatHC.setY(paramView, paramFloat);
    }
  }
  
  static class ICSMr1ViewCompatImpl
    extends ViewCompat.ICSViewCompatImpl
  {
    public boolean hasOnClickListeners(View paramView)
    {
      return ViewCompatICSMr1.hasOnClickListeners(paramView);
    }
  }
  
  static class ICSViewCompatImpl
    extends ViewCompat.HCViewCompatImpl
  {
    static boolean accessibilityDelegateCheckFailed = false;
    static Field mAccessibilityDelegateField;
    
    public ViewPropertyAnimatorCompat animate(View paramView)
    {
      if (this.mViewPropertyAnimatorCompatMap == null) {
        this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(paramView);
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
      if (localViewPropertyAnimatorCompat2 == null)
      {
        localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
        this.mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat1);
      }
      return localViewPropertyAnimatorCompat1;
    }
    
    public boolean canScrollHorizontally(View paramView, int paramInt)
    {
      return ViewCompatICS.canScrollHorizontally(paramView, paramInt);
    }
    
    public boolean canScrollVertically(View paramView, int paramInt)
    {
      return ViewCompatICS.canScrollVertically(paramView, paramInt);
    }
    
    /* Error */
    public boolean hasAccessibilityDelegate(View paramView)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: getstatic 15	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
      //   5: ifeq +5 -> 10
      //   8: iconst_0
      //   9: ireturn
      //   10: getstatic 56	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
      //   13: ifnonnull +20 -> 33
      //   16: ldc 58
      //   18: ldc 60
      //   20: invokevirtual 66	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   23: putstatic 56	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
      //   26: getstatic 56	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
      //   29: iconst_1
      //   30: invokevirtual 72	java/lang/reflect/Field:setAccessible	(Z)V
      //   33: getstatic 56	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
      //   36: aload_1
      //   37: invokevirtual 73	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   40: astore_1
      //   41: aload_1
      //   42: ifnull +12 -> 54
      //   45: iload_2
      //   46: ireturn
      //   47: astore_1
      //   48: iconst_1
      //   49: putstatic 15	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
      //   52: iconst_0
      //   53: ireturn
      //   54: iconst_0
      //   55: istore_2
      //   56: goto -11 -> 45
      //   59: astore_1
      //   60: iconst_1
      //   61: putstatic 15	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
      //   64: iconst_0
      //   65: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	66	0	this	ICSViewCompatImpl
      //   0	66	1	paramView	View
      //   1	55	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   16	33	47	java/lang/Throwable
      //   33	41	59	java/lang/Throwable
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ViewCompatICS.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      ViewCompatICS.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      ViewCompatICS.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void setAccessibilityDelegate(View paramView, @Nullable AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
    {
      if (paramAccessibilityDelegateCompat == null) {}
      for (paramAccessibilityDelegateCompat = null;; paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge())
      {
        ViewCompatICS.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
        return;
      }
    }
    
    public void setFitsSystemWindows(View paramView, boolean paramBoolean)
    {
      ViewCompatICS.setFitsSystemWindows(paramView, paramBoolean);
    }
  }
  
  static class JBViewCompatImpl
    extends ViewCompat.ICSMr1ViewCompatImpl
  {
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
    {
      paramView = ViewCompatJB.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return new AccessibilityNodeProviderCompat(paramView);
      }
      return null;
    }
    
    public boolean getFitsSystemWindows(View paramView)
    {
      return ViewCompatJB.getFitsSystemWindows(paramView);
    }
    
    public int getImportantForAccessibility(View paramView)
    {
      return ViewCompatJB.getImportantForAccessibility(paramView);
    }
    
    public int getMinimumHeight(View paramView)
    {
      return ViewCompatJB.getMinimumHeight(paramView);
    }
    
    public int getMinimumWidth(View paramView)
    {
      return ViewCompatJB.getMinimumWidth(paramView);
    }
    
    public ViewParent getParentForAccessibility(View paramView)
    {
      return ViewCompatJB.getParentForAccessibility(paramView);
    }
    
    public boolean hasOverlappingRendering(View paramView)
    {
      return ViewCompatJB.hasOverlappingRendering(paramView);
    }
    
    public boolean hasTransientState(View paramView)
    {
      return ViewCompatJB.hasTransientState(paramView);
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return ViewCompatJB.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    
    public void postInvalidateOnAnimation(View paramView)
    {
      ViewCompatJB.postInvalidateOnAnimation(paramView);
    }
    
    public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ViewCompatJB.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void postOnAnimation(View paramView, Runnable paramRunnable)
    {
      ViewCompatJB.postOnAnimation(paramView, paramRunnable);
    }
    
    public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
    {
      ViewCompatJB.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
    }
    
    public void requestApplyInsets(View paramView)
    {
      ViewCompatJB.requestApplyInsets(paramView);
    }
    
    public void setHasTransientState(View paramView, boolean paramBoolean)
    {
      ViewCompatJB.setHasTransientState(paramView, paramBoolean);
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      ViewCompatJB.setImportantForAccessibility(paramView, i);
    }
  }
  
  static class JbMr1ViewCompatImpl
    extends ViewCompat.JBViewCompatImpl
  {
    public int getLabelFor(View paramView)
    {
      return ViewCompatJellybeanMr1.getLabelFor(paramView);
    }
    
    public int getLayoutDirection(View paramView)
    {
      return ViewCompatJellybeanMr1.getLayoutDirection(paramView);
    }
    
    public int getPaddingEnd(View paramView)
    {
      return ViewCompatJellybeanMr1.getPaddingEnd(paramView);
    }
    
    public int getPaddingStart(View paramView)
    {
      return ViewCompatJellybeanMr1.getPaddingStart(paramView);
    }
    
    public int getWindowSystemUiVisibility(View paramView)
    {
      return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(paramView);
    }
    
    public boolean isPaddingRelative(View paramView)
    {
      return ViewCompatJellybeanMr1.isPaddingRelative(paramView);
    }
    
    public void setLabelFor(View paramView, int paramInt)
    {
      ViewCompatJellybeanMr1.setLabelFor(paramView, paramInt);
    }
    
    public void setLayerPaint(View paramView, Paint paramPaint)
    {
      ViewCompatJellybeanMr1.setLayerPaint(paramView, paramPaint);
    }
    
    public void setLayoutDirection(View paramView, int paramInt)
    {
      ViewCompatJellybeanMr1.setLayoutDirection(paramView, paramInt);
    }
    
    public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ViewCompatJellybeanMr1.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  static class JbMr2ViewCompatImpl
    extends ViewCompat.JbMr1ViewCompatImpl
  {
    public Rect getClipBounds(View paramView)
    {
      return ViewCompatJellybeanMr2.getClipBounds(paramView);
    }
    
    public boolean isInLayout(View paramView)
    {
      return ViewCompatJellybeanMr2.isInLayout(paramView);
    }
    
    public void setClipBounds(View paramView, Rect paramRect)
    {
      ViewCompatJellybeanMr2.setClipBounds(paramView, paramRect);
    }
  }
  
  static class KitKatViewCompatImpl
    extends ViewCompat.JbMr2ViewCompatImpl
  {
    public int getAccessibilityLiveRegion(View paramView)
    {
      return ViewCompatKitKat.getAccessibilityLiveRegion(paramView);
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return ViewCompatKitKat.isAttachedToWindow(paramView);
    }
    
    public boolean isLaidOut(View paramView)
    {
      return ViewCompatKitKat.isLaidOut(paramView);
    }
    
    public boolean isLayoutDirectionResolved(View paramView)
    {
      return ViewCompatKitKat.isLayoutDirectionResolved(paramView);
    }
    
    public void setAccessibilityLiveRegion(View paramView, int paramInt)
    {
      ViewCompatKitKat.setAccessibilityLiveRegion(paramView, paramInt);
    }
    
    public void setImportantForAccessibility(View paramView, int paramInt)
    {
      ViewCompatJB.setImportantForAccessibility(paramView, paramInt);
    }
  }
  
  static class LollipopViewCompatImpl
    extends ViewCompat.KitKatViewCompatImpl
  {
    public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return ViewCompatLollipop.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
    }
    
    public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return ViewCompatLollipop.dispatchNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    }
    
    public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
    {
      return ViewCompatLollipop.dispatchNestedPreFling(paramView, paramFloat1, paramFloat2);
    }
    
    public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      return ViewCompatLollipop.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    
    public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      return ViewCompatLollipop.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    
    public ColorStateList getBackgroundTintList(View paramView)
    {
      return ViewCompatLollipop.getBackgroundTintList(paramView);
    }
    
    public PorterDuff.Mode getBackgroundTintMode(View paramView)
    {
      return ViewCompatLollipop.getBackgroundTintMode(paramView);
    }
    
    public float getElevation(View paramView)
    {
      return ViewCompatLollipop.getElevation(paramView);
    }
    
    public String getTransitionName(View paramView)
    {
      return ViewCompatLollipop.getTransitionName(paramView);
    }
    
    public float getTranslationZ(View paramView)
    {
      return ViewCompatLollipop.getTranslationZ(paramView);
    }
    
    public float getZ(View paramView)
    {
      return ViewCompatLollipop.getZ(paramView);
    }
    
    public boolean hasNestedScrollingParent(View paramView)
    {
      return ViewCompatLollipop.hasNestedScrollingParent(paramView);
    }
    
    public boolean isImportantForAccessibility(View paramView)
    {
      return ViewCompatLollipop.isImportantForAccessibility(paramView);
    }
    
    public boolean isNestedScrollingEnabled(View paramView)
    {
      return ViewCompatLollipop.isNestedScrollingEnabled(paramView);
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      ViewCompatLollipop.offsetLeftAndRight(paramView, paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      ViewCompatLollipop.offsetTopAndBottom(paramView, paramInt);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
    {
      return ViewCompatLollipop.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    }
    
    public void requestApplyInsets(View paramView)
    {
      ViewCompatLollipop.requestApplyInsets(paramView);
    }
    
    public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
    {
      ViewCompatLollipop.setBackgroundTintList(paramView, paramColorStateList);
    }
    
    public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
    {
      ViewCompatLollipop.setBackgroundTintMode(paramView, paramMode);
    }
    
    public void setElevation(View paramView, float paramFloat)
    {
      ViewCompatLollipop.setElevation(paramView, paramFloat);
    }
    
    public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
    {
      ViewCompatLollipop.setNestedScrollingEnabled(paramView, paramBoolean);
    }
    
    public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
    {
      ViewCompatLollipop.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
    }
    
    public void setTransitionName(View paramView, String paramString)
    {
      ViewCompatLollipop.setTransitionName(paramView, paramString);
    }
    
    public void setTranslationZ(View paramView, float paramFloat)
    {
      ViewCompatLollipop.setTranslationZ(paramView, paramFloat);
    }
    
    public void setZ(View paramView, float paramFloat)
    {
      ViewCompatLollipop.setZ(paramView, paramFloat);
    }
    
    public boolean startNestedScroll(View paramView, int paramInt)
    {
      return ViewCompatLollipop.startNestedScroll(paramView, paramInt);
    }
    
    public void stopNestedScroll(View paramView)
    {
      ViewCompatLollipop.stopNestedScroll(paramView);
    }
  }
  
  static class MarshmallowViewCompatImpl
    extends ViewCompat.LollipopViewCompatImpl
  {
    public int getScrollIndicators(View paramView)
    {
      return ViewCompatMarshmallow.getScrollIndicators(paramView);
    }
    
    public void offsetLeftAndRight(View paramView, int paramInt)
    {
      ViewCompatMarshmallow.offsetLeftAndRight(paramView, paramInt);
    }
    
    public void offsetTopAndBottom(View paramView, int paramInt)
    {
      ViewCompatMarshmallow.offsetTopAndBottom(paramView, paramInt);
    }
    
    public void setScrollIndicators(View paramView, int paramInt)
    {
      ViewCompatMarshmallow.setScrollIndicators(paramView, paramInt);
    }
    
    public void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
    {
      ViewCompatMarshmallow.setScrollIndicators(paramView, paramInt1, paramInt2);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollIndicators {}
  
  static abstract interface ViewCompatImpl
  {
    public abstract ViewPropertyAnimatorCompat animate(View paramView);
    
    public abstract boolean canScrollHorizontally(View paramView, int paramInt);
    
    public abstract boolean canScrollVertically(View paramView, int paramInt);
    
    public abstract int combineMeasuredStates(int paramInt1, int paramInt2);
    
    public abstract WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
    
    public abstract void dispatchFinishTemporaryDetach(View paramView);
    
    public abstract boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
    
    public abstract boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2);
    
    public abstract boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
    
    public abstract boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
    
    public abstract void dispatchStartTemporaryDetach(View paramView);
    
    public abstract int getAccessibilityLiveRegion(View paramView);
    
    public abstract AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView);
    
    public abstract float getAlpha(View paramView);
    
    public abstract ColorStateList getBackgroundTintList(View paramView);
    
    public abstract PorterDuff.Mode getBackgroundTintMode(View paramView);
    
    public abstract Rect getClipBounds(View paramView);
    
    public abstract float getElevation(View paramView);
    
    public abstract boolean getFitsSystemWindows(View paramView);
    
    public abstract int getImportantForAccessibility(View paramView);
    
    public abstract int getLabelFor(View paramView);
    
    public abstract int getLayerType(View paramView);
    
    public abstract int getLayoutDirection(View paramView);
    
    @Nullable
    public abstract Matrix getMatrix(View paramView);
    
    public abstract int getMeasuredHeightAndState(View paramView);
    
    public abstract int getMeasuredState(View paramView);
    
    public abstract int getMeasuredWidthAndState(View paramView);
    
    public abstract int getMinimumHeight(View paramView);
    
    public abstract int getMinimumWidth(View paramView);
    
    public abstract int getOverScrollMode(View paramView);
    
    public abstract int getPaddingEnd(View paramView);
    
    public abstract int getPaddingStart(View paramView);
    
    public abstract ViewParent getParentForAccessibility(View paramView);
    
    public abstract float getPivotX(View paramView);
    
    public abstract float getPivotY(View paramView);
    
    public abstract float getRotation(View paramView);
    
    public abstract float getRotationX(View paramView);
    
    public abstract float getRotationY(View paramView);
    
    public abstract float getScaleX(View paramView);
    
    public abstract float getScaleY(View paramView);
    
    public abstract int getScrollIndicators(View paramView);
    
    public abstract String getTransitionName(View paramView);
    
    public abstract float getTranslationX(View paramView);
    
    public abstract float getTranslationY(View paramView);
    
    public abstract float getTranslationZ(View paramView);
    
    public abstract int getWindowSystemUiVisibility(View paramView);
    
    public abstract float getX(View paramView);
    
    public abstract float getY(View paramView);
    
    public abstract float getZ(View paramView);
    
    public abstract boolean hasAccessibilityDelegate(View paramView);
    
    public abstract boolean hasNestedScrollingParent(View paramView);
    
    public abstract boolean hasOnClickListeners(View paramView);
    
    public abstract boolean hasOverlappingRendering(View paramView);
    
    public abstract boolean hasTransientState(View paramView);
    
    public abstract boolean isAttachedToWindow(View paramView);
    
    public abstract boolean isImportantForAccessibility(View paramView);
    
    public abstract boolean isInLayout(View paramView);
    
    public abstract boolean isLaidOut(View paramView);
    
    public abstract boolean isLayoutDirectionResolved(View paramView);
    
    public abstract boolean isNestedScrollingEnabled(View paramView);
    
    public abstract boolean isOpaque(View paramView);
    
    public abstract boolean isPaddingRelative(View paramView);
    
    public abstract void jumpDrawablesToCurrentState(View paramView);
    
    public abstract void offsetLeftAndRight(View paramView, int paramInt);
    
    public abstract void offsetTopAndBottom(View paramView, int paramInt);
    
    public abstract WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
    
    public abstract void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
    
    public abstract void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle);
    
    public abstract void postInvalidateOnAnimation(View paramView);
    
    public abstract void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
    
    public abstract void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong);
    
    public abstract void requestApplyInsets(View paramView);
    
    public abstract int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void setAccessibilityDelegate(View paramView, @Nullable AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
    
    public abstract void setAccessibilityLiveRegion(View paramView, int paramInt);
    
    public abstract void setActivated(View paramView, boolean paramBoolean);
    
    public abstract void setAlpha(View paramView, float paramFloat);
    
    public abstract void setBackgroundTintList(View paramView, ColorStateList paramColorStateList);
    
    public abstract void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode);
    
    public abstract void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean);
    
    public abstract void setClipBounds(View paramView, Rect paramRect);
    
    public abstract void setElevation(View paramView, float paramFloat);
    
    public abstract void setFitsSystemWindows(View paramView, boolean paramBoolean);
    
    public abstract void setHasTransientState(View paramView, boolean paramBoolean);
    
    public abstract void setImportantForAccessibility(View paramView, int paramInt);
    
    public abstract void setLabelFor(View paramView, int paramInt);
    
    public abstract void setLayerPaint(View paramView, Paint paramPaint);
    
    public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void setLayoutDirection(View paramView, int paramInt);
    
    public abstract void setNestedScrollingEnabled(View paramView, boolean paramBoolean);
    
    public abstract void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener);
    
    public abstract void setOverScrollMode(View paramView, int paramInt);
    
    public abstract void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void setPivotX(View paramView, float paramFloat);
    
    public abstract void setPivotY(View paramView, float paramFloat);
    
    public abstract void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat);
    
    public abstract void setRotation(View paramView, float paramFloat);
    
    public abstract void setRotationX(View paramView, float paramFloat);
    
    public abstract void setRotationY(View paramView, float paramFloat);
    
    public abstract void setSaveFromParentEnabled(View paramView, boolean paramBoolean);
    
    public abstract void setScaleX(View paramView, float paramFloat);
    
    public abstract void setScaleY(View paramView, float paramFloat);
    
    public abstract void setScrollIndicators(View paramView, int paramInt);
    
    public abstract void setScrollIndicators(View paramView, int paramInt1, int paramInt2);
    
    public abstract void setTransitionName(View paramView, String paramString);
    
    public abstract void setTranslationX(View paramView, float paramFloat);
    
    public abstract void setTranslationY(View paramView, float paramFloat);
    
    public abstract void setTranslationZ(View paramView, float paramFloat);
    
    public abstract void setX(View paramView, float paramFloat);
    
    public abstract void setY(View paramView, float paramFloat);
    
    public abstract void setZ(View paramView, float paramFloat);
    
    public abstract boolean startNestedScroll(View paramView, int paramInt);
    
    public abstract void stopNestedScroll(View paramView);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/ViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */