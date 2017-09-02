package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat
{
  public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
  public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
  public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
  public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
  private static final AccessibilityEventVersionImpl IMPL = new AccessibilityEventStubImpl();
  public static final int TYPES_ALL_MASK = -1;
  public static final int TYPE_ANNOUNCEMENT = 16384;
  public static final int TYPE_GESTURE_DETECTION_END = 524288;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
  public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
  public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
  public static final int TYPE_VIEW_HOVER_ENTER = 128;
  public static final int TYPE_VIEW_HOVER_EXIT = 256;
  public static final int TYPE_VIEW_SCROLLED = 4096;
  public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
  public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
  public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityEventKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityEventIcsImpl();
      return;
    }
  }
  
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    IMPL.appendRecord(paramAccessibilityEvent, paramAccessibilityRecordCompat.getImpl());
  }
  
  public static AccessibilityRecordCompat asRecord(AccessibilityEvent paramAccessibilityEvent)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent);
  }
  
  public static int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.getContentChangeTypes(paramAccessibilityEvent);
  }
  
  public static AccessibilityRecordCompat getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return new AccessibilityRecordCompat(IMPL.getRecord(paramAccessibilityEvent, paramInt));
  }
  
  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.getRecordCount(paramAccessibilityEvent);
  }
  
  public static void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    IMPL.setContentChangeTypes(paramAccessibilityEvent, paramInt);
  }
  
  static class AccessibilityEventIcsImpl
    extends AccessibilityEventCompat.AccessibilityEventStubImpl
  {
    public void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject)
    {
      AccessibilityEventCompatIcs.appendRecord(paramAccessibilityEvent, paramObject);
    }
    
    public Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      return AccessibilityEventCompatIcs.getRecord(paramAccessibilityEvent, paramInt);
    }
    
    public int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
    {
      return AccessibilityEventCompatIcs.getRecordCount(paramAccessibilityEvent);
    }
  }
  
  static class AccessibilityEventKitKatImpl
    extends AccessibilityEventCompat.AccessibilityEventIcsImpl
  {
    public int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
    {
      return AccessibilityEventCompatKitKat.getContentChangeTypes(paramAccessibilityEvent);
    }
    
    public void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      AccessibilityEventCompatKitKat.setContentChangeTypes(paramAccessibilityEvent, paramInt);
    }
  }
  
  static class AccessibilityEventStubImpl
    implements AccessibilityEventCompat.AccessibilityEventVersionImpl
  {
    public void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject) {}
    
    public int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
    {
      return 0;
    }
    
    public Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      return null;
    }
    
    public int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
    {
      return 0;
    }
    
    public void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt) {}
  }
  
  static abstract interface AccessibilityEventVersionImpl
  {
    public abstract void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject);
    
    public abstract int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt);
    
    public abstract int getRecordCount(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityEventCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */