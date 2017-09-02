package com.google.tango.cloudlib;

import android.content.ContentResolver;

public final class GServicesSettings
{
  static
  {
    System.loadLibrary("tango_cloud_lib_shared");
  }
  
  public static native boolean getCloudAdfEnabled(ContentResolver paramContentResolver);
  
  public static native boolean getCloudLocalizationEnabled(ContentResolver paramContentResolver);
  
  public static native boolean getCloudNavigationEnabled(ContentResolver paramContentResolver);
  
  public static native String getFoiEndpoint(ContentResolver paramContentResolver);
  
  public static native int getLocalizationGrpcChannelMaxMessageSize(ContentResolver paramContentResolver);
  
  public static native String getLocalizationOnePlatformEndpoint(ContentResolver paramContentResolver);
  
  public static native int getMaxBubbleCoveringTiles(ContentResolver paramContentResolver);
  
  public static native String getNavigationEndpoint(ContentResolver paramContentResolver);
  
  public static native int getNavigationGrpcChannelMaxMessageSize(ContentResolver paramContentResolver);
  
  public static native int getTileExpirationSecs(ContentResolver paramContentResolver);
  
  public static native boolean getTileLoadingEnabled(ContentResolver paramContentResolver);
  
  public static native int getTilePrefetchIntervalSecs(ContentResolver paramContentResolver);
  
  public static native boolean getUserDataCollectionEnabled(ContentResolver paramContentResolver);
  
  public static native String getVisualMapStoreEndpoint(ContentResolver paramContentResolver);
  
  public static native int getVisualMapStoreGrpcChannelMaxMessageSize(ContentResolver paramContentResolver);
  
  public static native String getVpsManagementEndpoint(ContentResolver paramContentResolver);
  
  public static native int getVpsManagementGrpcChannelMaxMessageSize(ContentResolver paramContentResolver);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/GServicesSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */