package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzt
  implements Logger
{
  private boolean zzabw;
  private int zzaeL = 2;
  
  public void error(Exception paramException) {}
  
  public void error(String paramString) {}
  
  public int getLogLevel()
  {
    return this.zzaeL;
  }
  
  public void info(String paramString) {}
  
  public void setLogLevel(int paramInt)
  {
    this.zzaeL = paramInt;
    if (!this.zzabw)
    {
      String str1 = (String)G.loggingTag.get();
      String str2 = (String)G.loggingTag.get();
      Log.i(str1, String.valueOf(str2).length() + 91 + "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + str2 + " DEBUG");
      this.zzabw = true;
    }
  }
  
  public void verbose(String paramString) {}
  
  public void warn(String paramString) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */