package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat
{
  @Deprecated
  public static boolean isUserRunningAndLocked(Context paramContext)
  {
    return !isUserUnlocked(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRunningAndUnlocked(Context paramContext)
  {
    return isUserUnlocked(paramContext);
  }
  
  public static boolean isUserUnlocked(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {
      return UserManagerCompatApi24.isUserUnlocked(paramContext);
    }
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/os/UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */