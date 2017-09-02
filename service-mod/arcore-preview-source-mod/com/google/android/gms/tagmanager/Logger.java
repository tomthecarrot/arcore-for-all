package com.google.android.gms.tagmanager;

abstract interface Logger
{
  public abstract void d(String paramString);
  
  public abstract void d(String paramString, Throwable paramThrowable);
  
  public abstract void e(String paramString);
  
  public abstract void e(String paramString, Throwable paramThrowable);
  
  public abstract void i(String paramString);
  
  public abstract void i(String paramString, Throwable paramThrowable);
  
  public abstract void setLogLevel(int paramInt);
  
  public abstract void v(String paramString);
  
  public abstract void v(String paramString, Throwable paramThrowable);
  
  public abstract void w(String paramString);
  
  public abstract void w(String paramString, Throwable paramThrowable);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */