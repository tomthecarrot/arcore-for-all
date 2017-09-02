package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat
{
  public static final class EditorCompat
  {
    private static EditorCompat sInstance;
    private final Helper mHelper;
    
    private EditorCompat()
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.mHelper = new EditorHelperApi9Impl(null);
        return;
      }
      this.mHelper = new EditorHelperBaseImpl(null);
    }
    
    public static EditorCompat getInstance()
    {
      if (sInstance == null) {
        sInstance = new EditorCompat();
      }
      return sInstance;
    }
    
    public void apply(@NonNull SharedPreferences.Editor paramEditor)
    {
      this.mHelper.apply(paramEditor);
    }
    
    private static class EditorHelperApi9Impl
      implements SharedPreferencesCompat.EditorCompat.Helper
    {
      public void apply(@NonNull SharedPreferences.Editor paramEditor)
      {
        EditorCompatGingerbread.apply(paramEditor);
      }
    }
    
    private static class EditorHelperBaseImpl
      implements SharedPreferencesCompat.EditorCompat.Helper
    {
      public void apply(@NonNull SharedPreferences.Editor paramEditor)
      {
        paramEditor.commit();
      }
    }
    
    private static abstract interface Helper
    {
      public abstract void apply(@NonNull SharedPreferences.Editor paramEditor);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/content/SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */