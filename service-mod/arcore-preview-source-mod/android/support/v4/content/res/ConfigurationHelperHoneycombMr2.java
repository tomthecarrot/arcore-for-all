package android.support.v4.content.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;

class ConfigurationHelperHoneycombMr2
{
  static int getScreenHeightDp(@NonNull Resources paramResources)
  {
    return paramResources.getConfiguration().screenHeightDp;
  }
  
  static int getScreenWidthDp(@NonNull Resources paramResources)
  {
    return paramResources.getConfiguration().screenWidthDp;
  }
  
  static int getSmallestScreenWidthDp(@NonNull Resources paramResources)
  {
    return paramResources.getConfiguration().smallestScreenWidthDp;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/content/res/ConfigurationHelperHoneycombMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */