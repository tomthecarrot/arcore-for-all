package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;

class AccessibilityNodeInfoCompatKitKat
{
  private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
  
  public static boolean canOpenPopup(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).canOpenPopup();
  }
  
  static Object getCollectionInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getCollectionInfo();
  }
  
  static Object getCollectionItemInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getCollectionItemInfo();
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getExtras();
  }
  
  public static int getInputType(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getInputType();
  }
  
  static int getLiveRegion(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLiveRegion();
  }
  
  static Object getRangeInfo(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getRangeInfo();
  }
  
  public static CharSequence getRoleDescription(Object paramObject)
  {
    return getExtras(paramObject).getCharSequence("AccessibilityNodeInfo.roleDescription");
  }
  
  public static boolean isContentInvalid(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isContentInvalid();
  }
  
  public static boolean isDismissable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isDismissable();
  }
  
  public static boolean isMultiLine(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isMultiLine();
  }
  
  public static Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean);
  }
  
  public static Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public static void setCanOpenPopup(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setCanOpenPopup(paramBoolean);
  }
  
  public static void setCollectionInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject2);
  }
  
  public static void setCollectionItemInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject2);
  }
  
  public static void setContentInvalid(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setContentInvalid(paramBoolean);
  }
  
  public static void setDismissable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setDismissable(paramBoolean);
  }
  
  public static void setInputType(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setInputType(paramInt);
  }
  
  static void setLiveRegion(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLiveRegion(paramInt);
  }
  
  public static void setMultiLine(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setMultiLine(paramBoolean);
  }
  
  public static void setRangeInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setRangeInfo((AccessibilityNodeInfo.RangeInfo)paramObject2);
  }
  
  public static void setRoleDescription(Object paramObject, CharSequence paramCharSequence)
  {
    getExtras(paramObject).putCharSequence("AccessibilityNodeInfo.roleDescription", paramCharSequence);
  }
  
  static class CollectionInfo
  {
    static int getColumnCount(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).getColumnCount();
    }
    
    static int getRowCount(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).getRowCount();
    }
    
    static boolean isHierarchical(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionInfo)paramObject).isHierarchical();
    }
  }
  
  static class CollectionItemInfo
  {
    static int getColumnIndex(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getColumnIndex();
    }
    
    static int getColumnSpan(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getColumnSpan();
    }
    
    static int getRowIndex(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getRowIndex();
    }
    
    static int getRowSpan(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).getRowSpan();
    }
    
    static boolean isHeading(Object paramObject)
    {
      return ((AccessibilityNodeInfo.CollectionItemInfo)paramObject).isHeading();
    }
  }
  
  static class RangeInfo
  {
    static float getCurrent(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getCurrent();
    }
    
    static float getMax(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getMax();
    }
    
    static float getMin(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getMin();
    }
    
    static int getType(Object paramObject)
    {
      return ((AccessibilityNodeInfo.RangeInfo)paramObject).getType();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */