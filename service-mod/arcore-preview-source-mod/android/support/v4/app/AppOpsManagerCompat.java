package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class AppOpsManagerCompat
{
  private static final AppOpsManagerImpl IMPL = new AppOpsManagerImpl(null);
  public static final int MODE_ALLOWED = 0;
  public static final int MODE_DEFAULT = 3;
  public static final int MODE_IGNORED = 1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new AppOpsManager23(null);
      return;
    }
  }
  
  public static int noteOp(@NonNull Context paramContext, @NonNull String paramString1, int paramInt, @NonNull String paramString2)
  {
    return IMPL.noteOp(paramContext, paramString1, paramInt, paramString2);
  }
  
  public static int noteProxyOp(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    return IMPL.noteProxyOp(paramContext, paramString1, paramString2);
  }
  
  public static String permissionToOp(@NonNull String paramString)
  {
    return IMPL.permissionToOp(paramString);
  }
  
  private static class AppOpsManager23
    extends AppOpsManagerCompat.AppOpsManagerImpl
  {
    private AppOpsManager23()
    {
      super();
    }
    
    public int noteOp(Context paramContext, String paramString1, int paramInt, String paramString2)
    {
      return AppOpsManagerCompat23.noteOp(paramContext, paramString1, paramInt, paramString2);
    }
    
    public int noteProxyOp(Context paramContext, String paramString1, String paramString2)
    {
      return AppOpsManagerCompat23.noteProxyOp(paramContext, paramString1, paramString2);
    }
    
    public String permissionToOp(String paramString)
    {
      return AppOpsManagerCompat23.permissionToOp(paramString);
    }
  }
  
  private static class AppOpsManagerImpl
  {
    public int noteOp(Context paramContext, String paramString1, int paramInt, String paramString2)
    {
      return 1;
    }
    
    public int noteProxyOp(Context paramContext, String paramString1, String paramString2)
    {
      return 1;
    }
    
    public String permissionToOp(String paramString)
    {
      return null;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/app/AppOpsManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */