package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class ConfigurationHelper
{
  private static final ConfigurationHelperImpl IMPL = new DonutImpl(null);
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
    {
      IMPL = new JellybeanMr1Impl(null);
      return;
    }
    if (i >= 13)
    {
      IMPL = new HoneycombMr2Impl(null);
      return;
    }
  }
  
  public static int getDensityDpi(@NonNull Resources paramResources)
  {
    return IMPL.getDensityDpi(paramResources);
  }
  
  public static int getScreenHeightDp(@NonNull Resources paramResources)
  {
    return IMPL.getScreenHeightDp(paramResources);
  }
  
  public static int getScreenWidthDp(@NonNull Resources paramResources)
  {
    return IMPL.getScreenWidthDp(paramResources);
  }
  
  public static int getSmallestScreenWidthDp(@NonNull Resources paramResources)
  {
    return IMPL.getSmallestScreenWidthDp(paramResources);
  }
  
  private static abstract interface ConfigurationHelperImpl
  {
    public abstract int getDensityDpi(@NonNull Resources paramResources);
    
    public abstract int getScreenHeightDp(@NonNull Resources paramResources);
    
    public abstract int getScreenWidthDp(@NonNull Resources paramResources);
    
    public abstract int getSmallestScreenWidthDp(@NonNull Resources paramResources);
  }
  
  private static class DonutImpl
    implements ConfigurationHelper.ConfigurationHelperImpl
  {
    public int getDensityDpi(@NonNull Resources paramResources)
    {
      return ConfigurationHelperDonut.getDensityDpi(paramResources);
    }
    
    public int getScreenHeightDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperDonut.getScreenHeightDp(paramResources);
    }
    
    public int getScreenWidthDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperDonut.getScreenWidthDp(paramResources);
    }
    
    public int getSmallestScreenWidthDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperDonut.getSmallestScreenWidthDp(paramResources);
    }
  }
  
  private static class HoneycombMr2Impl
    extends ConfigurationHelper.DonutImpl
  {
    private HoneycombMr2Impl()
    {
      super();
    }
    
    public int getScreenHeightDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperHoneycombMr2.getScreenHeightDp(paramResources);
    }
    
    public int getScreenWidthDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperHoneycombMr2.getScreenWidthDp(paramResources);
    }
    
    public int getSmallestScreenWidthDp(@NonNull Resources paramResources)
    {
      return ConfigurationHelperHoneycombMr2.getSmallestScreenWidthDp(paramResources);
    }
  }
  
  private static class JellybeanMr1Impl
    extends ConfigurationHelper.HoneycombMr2Impl
  {
    private JellybeanMr1Impl()
    {
      super();
    }
    
    public int getDensityDpi(@NonNull Resources paramResources)
    {
      return ConfigurationHelperJellybeanMr1.getDensityDpi(paramResources);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/content/res/ConfigurationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */