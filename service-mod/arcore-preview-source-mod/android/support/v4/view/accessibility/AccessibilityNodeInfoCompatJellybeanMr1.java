package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatJellybeanMr1
{
  public static Object getLabelFor(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLabelFor();
  }
  
  public static Object getLabeledBy(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLabeledBy();
  }
  
  public static void setLabelFor(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView);
  }
  
  public static void setLabelFor(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView, paramInt);
  }
  
  public static void setLabeledBy(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setLabeledBy(paramView);
  }
  
  public static void setLabeledBy(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLabeledBy(paramView, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompatJellybeanMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */