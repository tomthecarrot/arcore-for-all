package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

class AccessibilityNodeInfoCompatJellybeanMr2
{
  public static List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
  {
    return (List)((AccessibilityNodeInfo)paramObject).findAccessibilityNodeInfosByViewId(paramString);
  }
  
  public static int getTextSelectionEnd(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getTextSelectionEnd();
  }
  
  public static int getTextSelectionStart(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getTextSelectionStart();
  }
  
  public static String getViewIdResourceName(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getViewIdResourceName();
  }
  
  public static boolean isEditable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isEditable();
  }
  
  public static boolean refresh(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).refresh();
  }
  
  public static void setEditable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setEditable(paramBoolean);
  }
  
  public static void setTextSelection(Object paramObject, int paramInt1, int paramInt2)
  {
    ((AccessibilityNodeInfo)paramObject).setTextSelection(paramInt1, paramInt2);
  }
  
  public static void setViewIdResourceName(Object paramObject, String paramString)
  {
    ((AccessibilityNodeInfo)paramObject).setViewIdResourceName(paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompatJellybeanMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */