package com.google.android.gms.tagmanager;

public final class Log
{
  static Logger zzcvd = new DefaultLogger();
  static int zzcve;
  
  public static void d(String paramString)
  {
    zzcvd.d(paramString);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    zzcvd.d(paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    zzcvd.e(paramString);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    zzcvd.e(paramString, paramThrowable);
  }
  
  public static int getLogLevel()
  {
    return zzcve;
  }
  
  public static Logger getLogger()
  {
    return zzcvd;
  }
  
  public static void i(String paramString)
  {
    zzcvd.i(paramString);
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    zzcvd.i(paramString, paramThrowable);
  }
  
  public static void setLogLevel(int paramInt)
  {
    zzcve = paramInt;
    zzcvd.setLogLevel(paramInt);
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzcvd = paramLogger;
    zzcvd.setLogLevel(zzcve);
  }
  
  public static void v(String paramString)
  {
    zzcvd.v(paramString);
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    zzcvd.v(paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    zzcvd.w(paramString);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    zzcvd.w(paramString, paramThrowable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */