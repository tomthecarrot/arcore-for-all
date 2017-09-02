package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.Settings;

class OkHttpSettingsUtil
{
  public static final int INITIAL_WINDOW_SIZE = 7;
  public static final int MAX_CONCURRENT_STREAMS = 4;
  
  public static int get(Settings paramSettings, int paramInt)
  {
    return paramSettings.get(paramInt);
  }
  
  public static boolean isSet(Settings paramSettings, int paramInt)
  {
    return paramSettings.isSet(paramInt);
  }
  
  public static void set(Settings paramSettings, int paramInt1, int paramInt2)
  {
    paramSettings.set(paramInt1, 0, paramInt2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpSettingsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */