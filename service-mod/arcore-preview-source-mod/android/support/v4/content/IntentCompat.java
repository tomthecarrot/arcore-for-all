package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class IntentCompat
{
  public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
  public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
  public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
  public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
  public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
  public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
  private static final IntentCompatImpl IMPL = new IntentCompatImplBase();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      IMPL = new IntentCompatImplIcsMr1();
      return;
    }
    if (i >= 11)
    {
      IMPL = new IntentCompatImplHC();
      return;
    }
  }
  
  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return IMPL.makeMainActivity(paramComponentName);
  }
  
  public static Intent makeMainSelectorActivity(String paramString1, String paramString2)
  {
    return IMPL.makeMainSelectorActivity(paramString1, paramString2);
  }
  
  public static Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    return IMPL.makeRestartActivityTask(paramComponentName);
  }
  
  static abstract interface IntentCompatImpl
  {
    public abstract Intent makeMainActivity(ComponentName paramComponentName);
    
    public abstract Intent makeMainSelectorActivity(String paramString1, String paramString2);
    
    public abstract Intent makeRestartActivityTask(ComponentName paramComponentName);
  }
  
  static class IntentCompatImplBase
    implements IntentCompat.IntentCompatImpl
  {
    public Intent makeMainActivity(ComponentName paramComponentName)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setComponent(paramComponentName);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      return localIntent;
    }
    
    public Intent makeMainSelectorActivity(String paramString1, String paramString2)
    {
      paramString1 = new Intent(paramString1);
      paramString1.addCategory(paramString2);
      return paramString1;
    }
    
    public Intent makeRestartActivityTask(ComponentName paramComponentName)
    {
      paramComponentName = makeMainActivity(paramComponentName);
      paramComponentName.addFlags(268468224);
      return paramComponentName;
    }
  }
  
  static class IntentCompatImplHC
    extends IntentCompat.IntentCompatImplBase
  {
    public Intent makeMainActivity(ComponentName paramComponentName)
    {
      return IntentCompatHoneycomb.makeMainActivity(paramComponentName);
    }
    
    public Intent makeRestartActivityTask(ComponentName paramComponentName)
    {
      return IntentCompatHoneycomb.makeRestartActivityTask(paramComponentName);
    }
  }
  
  static class IntentCompatImplIcsMr1
    extends IntentCompat.IntentCompatImplHC
  {
    public Intent makeMainSelectorActivity(String paramString1, String paramString2)
    {
      return IntentCompatIcsMr1.makeMainSelectorActivity(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/content/IntentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */