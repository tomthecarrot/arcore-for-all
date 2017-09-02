package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import java.util.List;

class AccessibilityNodeInfoCompatApi21
{
  static void addAction(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).addAction((AccessibilityNodeInfo.AccessibilityAction)paramObject2);
  }
  
  static int getAccessibilityActionId(Object paramObject)
  {
    return ((AccessibilityNodeInfo.AccessibilityAction)paramObject).getId();
  }
  
  static CharSequence getAccessibilityActionLabel(Object paramObject)
  {
    return ((AccessibilityNodeInfo.AccessibilityAction)paramObject).getLabel();
  }
  
  static List<Object> getActionList(Object paramObject)
  {
    return (List)((AccessibilityNodeInfo)paramObject).getActionList();
  }
  
  public static CharSequence getError(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getError();
  }
  
  public static int getMaxTextLength(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getMaxTextLength();
  }
  
  public static Object getWindow(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getWindow();
  }
  
  static Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
  {
    return new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
  }
  
  public static Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3);
  }
  
  public static Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }
  
  public static boolean removeAction(Object paramObject1, Object paramObject2)
  {
    return ((AccessibilityNodeInfo)paramObject1).removeAction((AccessibilityNodeInfo.AccessibilityAction)paramObject2);
  }
  
  public static boolean removeChild(Object paramObject, View paramView)
  {
    return ((AccessibilityNodeInfo)paramObject).removeChild(paramView);
  }
  
  public static boolean removeChild(Object paramObject, View paramView, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).removeChild(paramView, paramInt);
  }
  
  public static void setError(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setError(paramCharSequence);
  }
  
  public static void setMaxTextLength(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setMaxTextLength(paramInt);
  }
  
  static class CollectionItemInfo
  {
    public static boolean isSelected(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).isSelected();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */