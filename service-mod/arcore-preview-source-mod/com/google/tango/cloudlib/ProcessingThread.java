package com.google.tango.cloudlib;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

class ProcessingThread
  extends HandlerThread
{
  private String loggingTag;
  private Handler mHandler;
  
  public ProcessingThread(String paramString)
  {
    super(paramString);
    this.loggingTag = paramString;
  }
  
  public void clearTasks()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onLooperPrepared()
  {
    this.mHandler = new Handler(getLooper());
  }
  
  public void post(Runnable paramRunnable)
  {
    if (this.mHandler == null)
    {
      Log.e(this.loggingTag, "Handler thread not ready! Skipping task.");
      return;
    }
    this.mHandler.post(paramRunnable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/ProcessingThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */