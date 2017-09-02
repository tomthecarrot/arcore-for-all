package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COLLAPSE = 524288;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_DISMISS = 1048576;
  public static final int ACTION_EXPAND = 262144;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int ACTION_SET_TEXT = 2097152;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  private static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private final Object mInfo;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new AccessibilityNodeInfoApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 22)
    {
      IMPL = new AccessibilityNodeInfoApi22Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new AccessibilityNodeInfoApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityNodeInfoKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  private static String getActionSymbolicName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    }
    return "ACTION_SET_SELECTION";
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return wrapNonNullInstance(IMPL.obtain(paramAccessibilityNodeInfoCompat.mInfo));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(this.mInfo, paramInt);
  }
  
  public void addAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    IMPL.addAction(this.mInfo, paramAccessibilityActionCompat.mAction);
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(this.mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    IMPL.addChild(this.mInfo, paramView, paramInt);
  }
  
  public boolean canOpenPopup()
  {
    return IMPL.canOpenPopup(this.mInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityNodeInfoCompat)paramObject;
        if (this.mInfo != null) {
          break;
        }
      } while (((AccessibilityNodeInfoCompat)paramObject).mInfo == null);
      return false;
    } while (this.mInfo.equals(((AccessibilityNodeInfoCompat)paramObject).mInfo));
    return false;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(this.mInfo, paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat(paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String paramString)
  {
    paramString = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, paramString);
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(new AccessibilityNodeInfoCompat(localIterator.next()));
      }
    }
    paramString = Collections.emptyList();
    return paramString;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return wrapNonNullInstance(IMPL.findFocus(this.mInfo, paramInt));
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, paramInt));
  }
  
  public List<AccessibilityActionCompat> getActionList()
  {
    List localList = IMPL.getActionList(this.mInfo);
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(new AccessibilityActionCompat(localList.get(i), null));
        i += 1;
      }
    }
    Object localObject = Collections.emptyList();
    return (List<AccessibilityActionCompat>)localObject;
  }
  
  public int getActions()
  {
    return IMPL.getActions(this.mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(this.mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(this.mInfo, paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(this.mInfo, paramInt));
  }
  
  public int getChildCount()
  {
    return IMPL.getChildCount(this.mInfo);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName(this.mInfo);
  }
  
  public CollectionInfoCompat getCollectionInfo()
  {
    Object localObject = IMPL.getCollectionInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new CollectionInfoCompat(localObject, null);
  }
  
  public CollectionItemInfoCompat getCollectionItemInfo()
  {
    Object localObject = IMPL.getCollectionItemInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new CollectionItemInfoCompat(localObject, null);
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(this.mInfo);
  }
  
  public int getDrawingOrder()
  {
    return IMPL.getDrawingOrder(this.mInfo);
  }
  
  public CharSequence getError()
  {
    return IMPL.getError(this.mInfo);
  }
  
  public Bundle getExtras()
  {
    return IMPL.getExtras(this.mInfo);
  }
  
  public Object getInfo()
  {
    return this.mInfo;
  }
  
  public int getInputType()
  {
    return IMPL.getInputType(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getLabelFor()
  {
    return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy()
  {
    return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
  }
  
  public int getLiveRegion()
  {
    return IMPL.getLiveRegion(this.mInfo);
  }
  
  public int getMaxTextLength()
  {
    return IMPL.getMaxTextLength(this.mInfo);
  }
  
  public int getMovementGranularities()
  {
    return IMPL.getMovementGranularities(this.mInfo);
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent(this.mInfo));
  }
  
  public RangeInfoCompat getRangeInfo()
  {
    Object localObject = IMPL.getRangeInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new RangeInfoCompat(localObject, null);
  }
  
  @Nullable
  public CharSequence getRoleDescription()
  {
    return IMPL.getRoleDescription(this.mInfo);
  }
  
  public CharSequence getText()
  {
    return IMPL.getText(this.mInfo);
  }
  
  public int getTextSelectionEnd()
  {
    return IMPL.getTextSelectionEnd(this.mInfo);
  }
  
  public int getTextSelectionStart()
  {
    return IMPL.getTextSelectionStart(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter()
  {
    return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
  }
  
  public AccessibilityNodeInfoCompat getTraversalBefore()
  {
    return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
  }
  
  public String getViewIdResourceName()
  {
    return IMPL.getViewIdResourceName(this.mInfo);
  }
  
  public AccessibilityWindowInfoCompat getWindow()
  {
    return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId(this.mInfo);
  }
  
  public int hashCode()
  {
    if (this.mInfo == null) {
      return 0;
    }
    return this.mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return IMPL.isAccessibilityFocused(this.mInfo);
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable(this.mInfo);
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked(this.mInfo);
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable(this.mInfo);
  }
  
  public boolean isContentInvalid()
  {
    return IMPL.isContentInvalid(this.mInfo);
  }
  
  public boolean isDismissable()
  {
    return IMPL.isDismissable(this.mInfo);
  }
  
  public boolean isEditable()
  {
    return IMPL.isEditable(this.mInfo);
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled(this.mInfo);
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable(this.mInfo);
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused(this.mInfo);
  }
  
  public boolean isImportantForAccessibility()
  {
    return IMPL.isImportantForAccessibility(this.mInfo);
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable(this.mInfo);
  }
  
  public boolean isMultiLine()
  {
    return IMPL.isMultiLine(this.mInfo);
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword(this.mInfo);
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable(this.mInfo);
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected(this.mInfo);
  }
  
  public boolean isVisibleToUser()
  {
    return IMPL.isVisibleToUser(this.mInfo);
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(this.mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return IMPL.performAction(this.mInfo, paramInt, paramBundle);
  }
  
  public void recycle()
  {
    IMPL.recycle(this.mInfo);
  }
  
  public boolean refresh()
  {
    return IMPL.refresh(this.mInfo);
  }
  
  public boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    return IMPL.removeAction(this.mInfo, paramAccessibilityActionCompat.mAction);
  }
  
  public boolean removeChild(View paramView)
  {
    return IMPL.removeChild(this.mInfo, paramView);
  }
  
  public boolean removeChild(View paramView, int paramInt)
  {
    return IMPL.removeChild(this.mInfo, paramView, paramInt);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    IMPL.setAccessibilityFocused(this.mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(this.mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(this.mInfo, paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean)
  {
    IMPL.setCanOpenPopup(this.mInfo, paramBoolean);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(this.mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(this.mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(this.mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(this.mInfo, paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject)
  {
    IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat)paramObject).mInfo);
  }
  
  public void setCollectionItemInfo(Object paramObject)
  {
    IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat)paramObject).mInfo);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(this.mInfo, paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean)
  {
    IMPL.setContentInvalid(this.mInfo, paramBoolean);
  }
  
  public void setDismissable(boolean paramBoolean)
  {
    IMPL.setDismissable(this.mInfo, paramBoolean);
  }
  
  public void setDrawingOrder(int paramInt)
  {
    IMPL.setDrawingOrder(this.mInfo, paramInt);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    IMPL.setEditable(this.mInfo, paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(this.mInfo, paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    IMPL.setError(this.mInfo, paramCharSequence);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(this.mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(this.mInfo, paramBoolean);
  }
  
  public void setImportantForAccessibility(boolean paramBoolean)
  {
    IMPL.setImportantForAccessibility(this.mInfo, paramBoolean);
  }
  
  public void setInputType(int paramInt)
  {
    IMPL.setInputType(this.mInfo, paramInt);
  }
  
  public void setLabelFor(View paramView)
  {
    IMPL.setLabelFor(this.mInfo, paramView);
  }
  
  public void setLabelFor(View paramView, int paramInt)
  {
    IMPL.setLabelFor(this.mInfo, paramView, paramInt);
  }
  
  public void setLabeledBy(View paramView)
  {
    IMPL.setLabeledBy(this.mInfo, paramView);
  }
  
  public void setLabeledBy(View paramView, int paramInt)
  {
    IMPL.setLabeledBy(this.mInfo, paramView, paramInt);
  }
  
  public void setLiveRegion(int paramInt)
  {
    IMPL.setLiveRegion(this.mInfo, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(this.mInfo, paramBoolean);
  }
  
  public void setMaxTextLength(int paramInt)
  {
    IMPL.setMaxTextLength(this.mInfo, paramInt);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    IMPL.setMovementGranularities(this.mInfo, paramInt);
  }
  
  public void setMultiLine(boolean paramBoolean)
  {
    IMPL.setMultiLine(this.mInfo, paramBoolean);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(this.mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(this.mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    IMPL.setParent(this.mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(this.mInfo, paramBoolean);
  }
  
  public void setRangeInfo(RangeInfoCompat paramRangeInfoCompat)
  {
    IMPL.setRangeInfo(this.mInfo, paramRangeInfoCompat.mInfo);
  }
  
  public void setRoleDescription(@Nullable CharSequence paramCharSequence)
  {
    IMPL.setRoleDescription(this.mInfo, paramCharSequence);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(this.mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(this.mInfo, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(this.mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(this.mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    IMPL.setText(this.mInfo, paramCharSequence);
  }
  
  public void setTextSelection(int paramInt1, int paramInt2)
  {
    IMPL.setTextSelection(this.mInfo, paramInt1, paramInt2);
  }
  
  public void setTraversalAfter(View paramView)
  {
    IMPL.setTraversalAfter(this.mInfo, paramView);
  }
  
  public void setTraversalAfter(View paramView, int paramInt)
  {
    IMPL.setTraversalAfter(this.mInfo, paramView, paramInt);
  }
  
  public void setTraversalBefore(View paramView)
  {
    IMPL.setTraversalBefore(this.mInfo, paramView);
  }
  
  public void setTraversalBefore(View paramView, int paramInt)
  {
    IMPL.setTraversalBefore(this.mInfo, paramView, paramInt);
  }
  
  public void setViewIdResourceName(String paramString)
  {
    IMPL.setViewIdResourceName(this.mInfo, paramString);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    IMPL.setVisibleToUser(this.mInfo, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    getBoundsInParent(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    getBoundsInScreen(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(getViewIdResourceName());
    localStringBuilder.append("; checkable: ").append(isCheckable());
    localStringBuilder.append("; checked: ").append(isChecked());
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(isPassword());
    localStringBuilder.append("; scrollable: " + isScrollable());
    localStringBuilder.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder.append(getActionSymbolicName(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = j;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class AccessibilityActionCompat
  {
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
    public static final AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
    public static final AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
    private final Object mAction;
    
    static
    {
      ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
      ACTION_SELECT = new AccessibilityActionCompat(4, null);
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
      ACTION_CLICK = new AccessibilityActionCompat(16, null);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
      ACTION_COPY = new AccessibilityActionCompat(16384, null);
      ACTION_PASTE = new AccessibilityActionCompat(32768, null);
      ACTION_CUT = new AccessibilityActionCompat(65536, null);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
      ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
    }
    
    public AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence)
    {
      this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(paramInt, paramCharSequence));
    }
    
    private AccessibilityActionCompat(Object paramObject)
    {
      this.mAction = paramObject;
    }
    
    public int getId()
    {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
    }
    
    public CharSequence getLabel()
    {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
    }
  }
  
  static class AccessibilityNodeInfoApi21Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
  {
    public void addAction(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatApi21.addAction(paramObject1, paramObject2);
    }
    
    public int getAccessibilityActionId(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(paramObject);
    }
    
    public CharSequence getAccessibilityActionLabel(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(paramObject);
    }
    
    public List<Object> getActionList(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getActionList(paramObject);
    }
    
    public CharSequence getError(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getError(paramObject);
    }
    
    public int getMaxTextLength(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getMaxTextLength(paramObject);
    }
    
    public Object getWindow(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getWindow(paramObject);
    }
    
    public boolean isCollectionItemSelected(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(paramObject);
    }
    
    public Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
    {
      return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(paramInt, paramCharSequence);
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
    }
    
    public boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return AccessibilityNodeInfoCompatApi21.removeAction(paramObject1, paramObject2);
    }
    
    public boolean removeChild(Object paramObject, View paramView)
    {
      return AccessibilityNodeInfoCompatApi21.removeChild(paramObject, paramView);
    }
    
    public boolean removeChild(Object paramObject, View paramView, int paramInt)
    {
      return AccessibilityNodeInfoCompatApi21.removeChild(paramObject, paramView, paramInt);
    }
    
    public void setError(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatApi21.setError(paramObject, paramCharSequence);
    }
    
    public void setMaxTextLength(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatApi21.setMaxTextLength(paramObject, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoApi22Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl
  {
    public Object getTraversalAfter(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi22.getTraversalAfter(paramObject);
    }
    
    public Object getTraversalBefore(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi22.getTraversalBefore(paramObject);
    }
    
    public void setTraversalAfter(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(paramObject, paramView);
    }
    
    public void setTraversalAfter(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(paramObject, paramView, paramInt);
    }
    
    public void setTraversalBefore(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(paramObject, paramView);
    }
    
    public void setTraversalBefore(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(paramObject, paramView, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoApi24Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl
  {
    public int getDrawingOrder(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi24.getDrawingOrder(paramObject);
    }
    
    public boolean isImportantForAccessibility(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi24.isImportantForAccessibility(paramObject);
    }
    
    public void setDrawingOrder(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatApi24.setDrawingOrder(paramObject, paramInt);
    }
    
    public void setImportantForAccessibility(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatApi24.setImportantForAccessibility(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoIcsImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    public void addAction(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
    }
    
    public void addChild(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.addChild(paramObject, paramView);
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(paramObject, paramString);
    }
    
    public int getActions(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getActions(paramObject);
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInParent(paramObject, paramRect);
    }
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInScreen(paramObject, paramRect);
    }
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.getChild(paramObject, paramInt);
    }
    
    public int getChildCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getChildCount(paramObject);
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getClassName(paramObject);
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getContentDescription(paramObject);
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getPackageName(paramObject);
    }
    
    public Object getParent(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getParent(paramObject);
    }
    
    public CharSequence getText(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getText(paramObject);
    }
    
    public int getWindowId(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getWindowId(paramObject);
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isCheckable(paramObject);
    }
    
    public boolean isChecked(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isChecked(paramObject);
    }
    
    public boolean isClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isClickable(paramObject);
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isEnabled(paramObject);
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocusable(paramObject);
    }
    
    public boolean isFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocused(paramObject);
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isLongClickable(paramObject);
    }
    
    public boolean isPassword(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isPassword(paramObject);
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isScrollable(paramObject);
    }
    
    public boolean isSelected(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isSelected(paramObject);
    }
    
    public Object obtain()
    {
      return AccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(View paramView)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramView);
    }
    
    public Object obtain(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramObject);
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.performAction(paramObject, paramInt);
    }
    
    public void recycle(Object paramObject)
    {
      AccessibilityNodeInfoCompatIcs.recycle(paramObject);
    }
    
    public void setBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInParent(paramObject, paramRect);
    }
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInScreen(paramObject, paramRect);
    }
    
    public void setCheckable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setCheckable(paramObject, paramBoolean);
    }
    
    public void setChecked(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setChecked(paramObject, paramBoolean);
    }
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
    }
    
    public void setClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setClickable(paramObject, paramBoolean);
    }
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setContentDescription(paramObject, paramCharSequence);
    }
    
    public void setEnabled(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setEnabled(paramObject, paramBoolean);
    }
    
    public void setFocusable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocusable(paramObject, paramBoolean);
    }
    
    public void setFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocused(paramObject, paramBoolean);
    }
    
    public void setLongClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setLongClickable(paramObject, paramBoolean);
    }
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setPackageName(paramObject, paramCharSequence);
    }
    
    public void setParent(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setParent(paramObject, paramView);
    }
    
    public void setPassword(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setPassword(paramObject, paramBoolean);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
    }
    
    public void setSelected(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setSelected(paramObject, paramBoolean);
    }
    
    public void setSource(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setSource(paramObject, paramView);
    }
    
    public void setText(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setText(paramObject, paramCharSequence);
    }
  }
  
  static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void addAction(Object paramObject1, Object paramObject2);
    
    public abstract void addChild(Object paramObject, View paramView);
    
    public abstract void addChild(Object paramObject, View paramView, int paramInt);
    
    public abstract boolean canOpenPopup(Object paramObject);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString);
    
    public abstract List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString);
    
    public abstract Object findFocus(Object paramObject, int paramInt);
    
    public abstract Object focusSearch(Object paramObject, int paramInt);
    
    public abstract int getAccessibilityActionId(Object paramObject);
    
    public abstract CharSequence getAccessibilityActionLabel(Object paramObject);
    
    public abstract List<Object> getActionList(Object paramObject);
    
    public abstract int getActions(Object paramObject);
    
    public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract Object getChild(Object paramObject, int paramInt);
    
    public abstract int getChildCount(Object paramObject);
    
    public abstract CharSequence getClassName(Object paramObject);
    
    public abstract Object getCollectionInfo(Object paramObject);
    
    public abstract int getCollectionInfoColumnCount(Object paramObject);
    
    public abstract int getCollectionInfoRowCount(Object paramObject);
    
    public abstract int getCollectionItemColumnIndex(Object paramObject);
    
    public abstract int getCollectionItemColumnSpan(Object paramObject);
    
    public abstract Object getCollectionItemInfo(Object paramObject);
    
    public abstract int getCollectionItemRowIndex(Object paramObject);
    
    public abstract int getCollectionItemRowSpan(Object paramObject);
    
    public abstract CharSequence getContentDescription(Object paramObject);
    
    public abstract int getDrawingOrder(Object paramObject);
    
    public abstract CharSequence getError(Object paramObject);
    
    public abstract Bundle getExtras(Object paramObject);
    
    public abstract int getInputType(Object paramObject);
    
    public abstract Object getLabelFor(Object paramObject);
    
    public abstract Object getLabeledBy(Object paramObject);
    
    public abstract int getLiveRegion(Object paramObject);
    
    public abstract int getMaxTextLength(Object paramObject);
    
    public abstract int getMovementGranularities(Object paramObject);
    
    public abstract CharSequence getPackageName(Object paramObject);
    
    public abstract Object getParent(Object paramObject);
    
    public abstract Object getRangeInfo(Object paramObject);
    
    public abstract CharSequence getRoleDescription(Object paramObject);
    
    public abstract CharSequence getText(Object paramObject);
    
    public abstract int getTextSelectionEnd(Object paramObject);
    
    public abstract int getTextSelectionStart(Object paramObject);
    
    public abstract Object getTraversalAfter(Object paramObject);
    
    public abstract Object getTraversalBefore(Object paramObject);
    
    public abstract String getViewIdResourceName(Object paramObject);
    
    public abstract Object getWindow(Object paramObject);
    
    public abstract int getWindowId(Object paramObject);
    
    public abstract boolean isAccessibilityFocused(Object paramObject);
    
    public abstract boolean isCheckable(Object paramObject);
    
    public abstract boolean isChecked(Object paramObject);
    
    public abstract boolean isClickable(Object paramObject);
    
    public abstract boolean isCollectionInfoHierarchical(Object paramObject);
    
    public abstract boolean isCollectionItemHeading(Object paramObject);
    
    public abstract boolean isCollectionItemSelected(Object paramObject);
    
    public abstract boolean isContentInvalid(Object paramObject);
    
    public abstract boolean isDismissable(Object paramObject);
    
    public abstract boolean isEditable(Object paramObject);
    
    public abstract boolean isEnabled(Object paramObject);
    
    public abstract boolean isFocusable(Object paramObject);
    
    public abstract boolean isFocused(Object paramObject);
    
    public abstract boolean isImportantForAccessibility(Object paramObject);
    
    public abstract boolean isLongClickable(Object paramObject);
    
    public abstract boolean isMultiLine(Object paramObject);
    
    public abstract boolean isPassword(Object paramObject);
    
    public abstract boolean isScrollable(Object paramObject);
    
    public abstract boolean isSelected(Object paramObject);
    
    public abstract boolean isVisibleToUser(Object paramObject);
    
    public abstract Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence);
    
    public abstract Object obtain();
    
    public abstract Object obtain(View paramView);
    
    public abstract Object obtain(View paramView, int paramInt);
    
    public abstract Object obtain(Object paramObject);
    
    public abstract Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
    
    public abstract Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract boolean performAction(Object paramObject, int paramInt);
    
    public abstract boolean performAction(Object paramObject, int paramInt, Bundle paramBundle);
    
    public abstract void recycle(Object paramObject);
    
    public abstract boolean refresh(Object paramObject);
    
    public abstract boolean removeAction(Object paramObject1, Object paramObject2);
    
    public abstract boolean removeChild(Object paramObject, View paramView);
    
    public abstract boolean removeChild(Object paramObject, View paramView, int paramInt);
    
    public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract void setCanOpenPopup(Object paramObject, boolean paramBoolean);
    
    public abstract void setCheckable(Object paramObject, boolean paramBoolean);
    
    public abstract void setChecked(Object paramObject, boolean paramBoolean);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setCollectionInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setCollectionItemInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setContentInvalid(Object paramObject, boolean paramBoolean);
    
    public abstract void setDismissable(Object paramObject, boolean paramBoolean);
    
    public abstract void setDrawingOrder(Object paramObject, int paramInt);
    
    public abstract void setEditable(Object paramObject, boolean paramBoolean);
    
    public abstract void setEnabled(Object paramObject, boolean paramBoolean);
    
    public abstract void setError(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setFocusable(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setImportantForAccessibility(Object paramObject, boolean paramBoolean);
    
    public abstract void setInputType(Object paramObject, int paramInt);
    
    public abstract void setLabelFor(Object paramObject, View paramView);
    
    public abstract void setLabelFor(Object paramObject, View paramView, int paramInt);
    
    public abstract void setLabeledBy(Object paramObject, View paramView);
    
    public abstract void setLabeledBy(Object paramObject, View paramView, int paramInt);
    
    public abstract void setLiveRegion(Object paramObject, int paramInt);
    
    public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setMaxTextLength(Object paramObject, int paramInt);
    
    public abstract void setMovementGranularities(Object paramObject, int paramInt);
    
    public abstract void setMultiLine(Object paramObject, boolean paramBoolean);
    
    public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setParent(Object paramObject, View paramView);
    
    public abstract void setParent(Object paramObject, View paramView, int paramInt);
    
    public abstract void setPassword(Object paramObject, boolean paramBoolean);
    
    public abstract void setRangeInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setRoleDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setSelected(Object paramObject, boolean paramBoolean);
    
    public abstract void setSource(Object paramObject, View paramView);
    
    public abstract void setSource(Object paramObject, View paramView, int paramInt);
    
    public abstract void setText(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setTextSelection(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract void setTraversalAfter(Object paramObject, View paramView);
    
    public abstract void setTraversalAfter(Object paramObject, View paramView, int paramInt);
    
    public abstract void setTraversalBefore(Object paramObject, View paramView);
    
    public abstract void setTraversalBefore(Object paramObject, View paramView, int paramInt);
    
    public abstract void setViewIdResourceName(Object paramObject, String paramString);
    
    public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {
    public void addChild(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.addChild(paramObject, paramView, paramInt);
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.findFocus(paramObject, paramInt);
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.focusSearch(paramObject, paramInt);
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(paramObject);
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(paramObject);
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(paramObject);
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.obtain(paramView, paramInt);
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return AccessibilityNodeInfoCompatJellyBean.performAction(paramObject, paramInt, paramBundle);
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(paramObject, paramBoolean);
    }
    
    public void setMovementGranularities(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(paramObject, paramInt);
    }
    
    public void setParent(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setParent(paramObject, paramView, paramInt);
    }
    
    public void setSource(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setSource(paramObject, paramView, paramInt);
    }
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr1Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
  {
    public Object getLabelFor(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(paramObject);
    }
    
    public Object getLabeledBy(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(paramObject);
    }
    
    public void setLabelFor(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(paramObject, paramView);
    }
    
    public void setLabelFor(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(paramObject, paramView, paramInt);
    }
    
    public void setLabeledBy(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(paramObject, paramView);
    }
    
    public void setLabeledBy(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(paramObject, paramView, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr2Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr1Impl
  {
    public List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(paramObject, paramString);
    }
    
    public int getTextSelectionEnd(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(paramObject);
    }
    
    public int getTextSelectionStart(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(paramObject);
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(paramObject);
    }
    
    public boolean isEditable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(paramObject);
    }
    
    public boolean refresh(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.refresh(paramObject);
    }
    
    public void setEditable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setEditable(paramObject, paramBoolean);
    }
    
    public void setTextSelection(Object paramObject, int paramInt1, int paramInt2)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(paramObject, paramInt1, paramInt2);
    }
    
    public void setViewIdResourceName(Object paramObject, String paramString)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(paramObject, paramString);
    }
  }
  
  static class AccessibilityNodeInfoKitKatImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl
  {
    public boolean canOpenPopup(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.canOpenPopup(paramObject);
    }
    
    public Object getCollectionInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(paramObject);
    }
    
    public int getCollectionInfoColumnCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(paramObject);
    }
    
    public int getCollectionInfoRowCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(paramObject);
    }
    
    public int getCollectionItemColumnIndex(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(paramObject);
    }
    
    public int getCollectionItemColumnSpan(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(paramObject);
    }
    
    public Object getCollectionItemInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(paramObject);
    }
    
    public int getCollectionItemRowIndex(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(paramObject);
    }
    
    public int getCollectionItemRowSpan(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(paramObject);
    }
    
    public Bundle getExtras(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getExtras(paramObject);
    }
    
    public int getInputType(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getInputType(paramObject);
    }
    
    public int getLiveRegion(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getLiveRegion(paramObject);
    }
    
    public Object getRangeInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getRangeInfo(paramObject);
    }
    
    public CharSequence getRoleDescription(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getRoleDescription(paramObject);
    }
    
    public boolean isCollectionInfoHierarchical(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(paramObject);
    }
    
    public boolean isCollectionItemHeading(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(paramObject);
    }
    
    public boolean isContentInvalid(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isContentInvalid(paramObject);
    }
    
    public boolean isDismissable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isDismissable(paramObject);
    }
    
    public boolean isMultiLine(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isMultiLine(paramObject);
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
    }
    
    public void setCanOpenPopup(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(paramObject, paramBoolean);
    }
    
    public void setCollectionInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setCollectionInfo(paramObject1, paramObject2);
    }
    
    public void setCollectionItemInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(paramObject1, paramObject2);
    }
    
    public void setContentInvalid(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setContentInvalid(paramObject, paramBoolean);
    }
    
    public void setDismissable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setDismissable(paramObject, paramBoolean);
    }
    
    public void setInputType(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatKitKat.setInputType(paramObject, paramInt);
    }
    
    public void setLiveRegion(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatKitKat.setLiveRegion(paramObject, paramInt);
    }
    
    public void setMultiLine(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setMultiLine(paramObject, paramBoolean);
    }
    
    public void setRangeInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setRangeInfo(paramObject1, paramObject2);
    }
    
    public void setRoleDescription(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatKitKat.setRoleDescription(paramObject, paramCharSequence);
    }
  }
  
  static class AccessibilityNodeInfoStubImpl
    implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    public void addAction(Object paramObject, int paramInt) {}
    
    public void addAction(Object paramObject1, Object paramObject2) {}
    
    public void addChild(Object paramObject, View paramView) {}
    
    public void addChild(Object paramObject, View paramView, int paramInt) {}
    
    public boolean canOpenPopup(Object paramObject)
    {
      return false;
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getAccessibilityActionId(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getAccessibilityActionLabel(Object paramObject)
    {
      return null;
    }
    
    public List<Object> getActionList(Object paramObject)
    {
      return null;
    }
    
    public int getActions(Object paramObject)
    {
      return 0;
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getChildCount(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return null;
    }
    
    public Object getCollectionInfo(Object paramObject)
    {
      return null;
    }
    
    public int getCollectionInfoColumnCount(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionInfoRowCount(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemColumnIndex(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemColumnSpan(Object paramObject)
    {
      return 0;
    }
    
    public Object getCollectionItemInfo(Object paramObject)
    {
      return null;
    }
    
    public int getCollectionItemRowIndex(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemRowSpan(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return null;
    }
    
    public int getDrawingOrder(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getError(Object paramObject)
    {
      return null;
    }
    
    public Bundle getExtras(Object paramObject)
    {
      return new Bundle();
    }
    
    public int getInputType(Object paramObject)
    {
      return 0;
    }
    
    public Object getLabelFor(Object paramObject)
    {
      return null;
    }
    
    public Object getLabeledBy(Object paramObject)
    {
      return null;
    }
    
    public int getLiveRegion(Object paramObject)
    {
      return 0;
    }
    
    public int getMaxTextLength(Object paramObject)
    {
      return -1;
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return null;
    }
    
    public Object getParent(Object paramObject)
    {
      return null;
    }
    
    public Object getRangeInfo(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getRoleDescription(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getText(Object paramObject)
    {
      return null;
    }
    
    public int getTextSelectionEnd(Object paramObject)
    {
      return -1;
    }
    
    public int getTextSelectionStart(Object paramObject)
    {
      return -1;
    }
    
    public Object getTraversalAfter(Object paramObject)
    {
      return null;
    }
    
    public Object getTraversalBefore(Object paramObject)
    {
      return null;
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return null;
    }
    
    public Object getWindow(Object paramObject)
    {
      return null;
    }
    
    public int getWindowId(Object paramObject)
    {
      return 0;
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return false;
    }
    
    public boolean isChecked(Object paramObject)
    {
      return false;
    }
    
    public boolean isClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionInfoHierarchical(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionItemHeading(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionItemSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isContentInvalid(Object paramObject)
    {
      return false;
    }
    
    public boolean isDismissable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEditable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isImportantForAccessibility(Object paramObject)
    {
      return true;
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isMultiLine(Object paramObject)
    {
      return false;
    }
    
    public boolean isPassword(Object paramObject)
    {
      return false;
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return false;
    }
    
    public boolean isSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return false;
    }
    
    public Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
    {
      return null;
    }
    
    public Object obtain()
    {
      return null;
    }
    
    public Object obtain(View paramView)
    {
      return null;
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return null;
    }
    
    public Object obtain(Object paramObject)
    {
      return null;
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return null;
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return null;
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void recycle(Object paramObject) {}
    
    public boolean refresh(Object paramObject)
    {
      return false;
    }
    
    public boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    public boolean removeChild(Object paramObject, View paramView)
    {
      return false;
    }
    
    public boolean removeChild(Object paramObject, View paramView, int paramInt)
    {
      return false;
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public void setCanOpenPopup(Object paramObject, boolean paramBoolean) {}
    
    public void setCheckable(Object paramObject, boolean paramBoolean) {}
    
    public void setChecked(Object paramObject, boolean paramBoolean) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setCollectionInfo(Object paramObject1, Object paramObject2) {}
    
    public void setCollectionItemInfo(Object paramObject1, Object paramObject2) {}
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setContentInvalid(Object paramObject, boolean paramBoolean) {}
    
    public void setDismissable(Object paramObject, boolean paramBoolean) {}
    
    public void setDrawingOrder(Object paramObject, int paramInt) {}
    
    public void setEditable(Object paramObject, boolean paramBoolean) {}
    
    public void setEnabled(Object paramObject, boolean paramBoolean) {}
    
    public void setError(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setFocusable(Object paramObject, boolean paramBoolean) {}
    
    public void setFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setImportantForAccessibility(Object paramObject, boolean paramBoolean) {}
    
    public void setInputType(Object paramObject, int paramInt) {}
    
    public void setLabelFor(Object paramObject, View paramView) {}
    
    public void setLabelFor(Object paramObject, View paramView, int paramInt) {}
    
    public void setLabeledBy(Object paramObject, View paramView) {}
    
    public void setLabeledBy(Object paramObject, View paramView, int paramInt) {}
    
    public void setLiveRegion(Object paramObject, int paramInt) {}
    
    public void setLongClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setMaxTextLength(Object paramObject, int paramInt) {}
    
    public void setMovementGranularities(Object paramObject, int paramInt) {}
    
    public void setMultiLine(Object paramObject, boolean paramBoolean) {}
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setParent(Object paramObject, View paramView) {}
    
    public void setParent(Object paramObject, View paramView, int paramInt) {}
    
    public void setPassword(Object paramObject, boolean paramBoolean) {}
    
    public void setRangeInfo(Object paramObject1, Object paramObject2) {}
    
    public void setRoleDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setSelected(Object paramObject, boolean paramBoolean) {}
    
    public void setSource(Object paramObject, View paramView) {}
    
    public void setSource(Object paramObject, View paramView, int paramInt) {}
    
    public void setText(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setTextSelection(Object paramObject, int paramInt1, int paramInt2) {}
    
    public void setTraversalAfter(Object paramObject, View paramView) {}
    
    public void setTraversalAfter(Object paramObject, View paramView, int paramInt) {}
    
    public void setTraversalBefore(Object paramObject, View paramView) {}
    
    public void setTraversalBefore(Object paramObject, View paramView, int paramInt) {}
    
    public void setViewIdResourceName(Object paramObject, String paramString) {}
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
  }
  
  public static class CollectionInfoCompat
  {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    final Object mInfo;
    
    private CollectionInfoCompat(Object paramObject)
    {
      this.mInfo = paramObject;
    }
    
    public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3));
    }
    
    public int getColumnCount()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
    }
    
    public int getRowCount()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
    }
    
    public boolean isHierarchical()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
    }
  }
  
  public static class CollectionItemInfoCompat
  {
    private final Object mInfo;
    
    private CollectionItemInfoCompat(Object paramObject)
    {
      this.mInfo = paramObject;
    }
    
    public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
    
    public int getColumnIndex()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
    }
    
    public int getColumnSpan()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
    }
    
    public int getRowIndex()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
    }
    
    public int getRowSpan()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
    }
    
    public boolean isHeading()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
    }
    
    public boolean isSelected()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
    }
  }
  
  public static class RangeInfoCompat
  {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    private final Object mInfo;
    
    private RangeInfoCompat(Object paramObject)
    {
      this.mInfo = paramObject;
    }
    
    public float getCurrent()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
    }
    
    public float getMax()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
    }
    
    public float getMin()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
    }
    
    public int getType()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/accessibility/AccessibilityNodeInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */