package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler zzabn;
  private final Tracker zzabo;
  private ExceptionParser zzabp;
  private GoogleAnalytics zzabq;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.zzabn = paramUncaughtExceptionHandler;
    this.zzabo = paramTracker;
    this.zzabp = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    if (paramUncaughtExceptionHandler == null)
    {
      paramTracker = "null";
      paramTracker = String.valueOf(paramTracker);
      if (paramTracker.length() == 0) {
        break label111;
      }
    }
    label111:
    for (paramTracker = "ExceptionReporter created, original handler is ".concat(paramTracker);; paramTracker = new String("ExceptionReporter created, original handler is "))
    {
      zzae.v(paramTracker);
      return;
      paramTracker = paramUncaughtExceptionHandler.getClass().getName();
      break;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.zzabp;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.zzabp = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = "UncaughtException";
    if (this.zzabp != null)
    {
      if (paramThread != null)
      {
        localObject = paramThread.getName();
        localObject = this.zzabp.getDescription((String)localObject, paramThrowable);
      }
    }
    else
    {
      str = String.valueOf(localObject);
      if (str.length() == 0) {
        break label126;
      }
    }
    label126:
    for (String str = "Reporting uncaught exception: ".concat(str);; str = new String("Reporting uncaught exception: "))
    {
      zzae.v(str);
      this.zzabo.send(new HitBuilders.ExceptionBuilder().setDescription((String)localObject).setFatal(true).build());
      localObject = zzmA();
      ((GoogleAnalytics)localObject).dispatchLocalHits();
      ((GoogleAnalytics)localObject).zzmE();
      if (this.zzabn != null)
      {
        zzae.v("Passing exception to the original handler");
        this.zzabn.uncaughtException(paramThread, paramThrowable);
      }
      return;
      localObject = null;
      break;
    }
  }
  
  GoogleAnalytics zzmA()
  {
    if (this.zzabq == null) {
      this.zzabq = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.zzabq;
  }
  
  Thread.UncaughtExceptionHandler zzmB()
  {
    return this.zzabn;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */