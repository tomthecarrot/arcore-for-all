package com.google.android.gms.tagmanager;

import android.util.Log;

public class DefaultLogger
  implements Logger
{
  private int zzaeL = 5;
  
  public void d(String paramString)
  {
    if (this.zzaeL <= 3) {
      Log.d("GoogleTagManager", paramString);
    }
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    if (this.zzaeL <= 3) {
      Log.d("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void e(String paramString)
  {
    if (this.zzaeL <= 6) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    if (this.zzaeL <= 6) {
      Log.e("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void i(String paramString)
  {
    if (this.zzaeL <= 4) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void i(String paramString, Throwable paramThrowable)
  {
    if (this.zzaeL <= 4) {
      Log.i("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.zzaeL = paramInt;
  }
  
  public void v(String paramString)
  {
    if (this.zzaeL <= 2) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void v(String paramString, Throwable paramThrowable)
  {
    if (this.zzaeL <= 2) {
      Log.v("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void w(String paramString)
  {
    if (this.zzaeL <= 5) {
      Log.w("GoogleTagManager", paramString);
    }
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    if (this.zzaeL <= 5) {
      Log.w("GoogleTagManager", paramString, paramThrowable);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/DefaultLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */