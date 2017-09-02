package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher
  extends Thread
{
  private static final boolean DEBUG = VolleyLog.DEBUG;
  private final Cache mCache;
  private final BlockingQueue<Request<?>> mCacheQueue;
  private final ResponseDelivery mDelivery;
  private final BlockingQueue<Request<?>> mNetworkQueue;
  private volatile boolean mQuit = false;
  
  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mCacheQueue = paramBlockingQueue1;
    this.mNetworkQueue = paramBlockingQueue2;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      VolleyLog.v("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.mCache.initialize();
    for (;;)
    {
      try
      {
        Request localRequest = (Request)this.mCacheQueue.take();
        localRequest.addMarker("cache-queue-take");
        if (!localRequest.isCanceled()) {
          break label73;
        }
        localRequest.finish("cache-discard-canceled");
        continue;
        if (!this.mQuit) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label73:
      Cache.Entry localEntry = this.mCache.get(localInterruptedException.getCacheKey());
      if (localEntry == null)
      {
        localInterruptedException.addMarker("cache-miss");
        this.mNetworkQueue.put(localInterruptedException);
      }
      else if (localEntry.isExpired())
      {
        localInterruptedException.addMarker("cache-hit-expired");
        localInterruptedException.setCacheEntry(localEntry);
        this.mNetworkQueue.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.addMarker("cache-hit");
        Response localResponse = localInterruptedException.parseNetworkResponse(new NetworkResponse(localEntry.data, localEntry.responseHeaders));
        localInterruptedException.addMarker("cache-hit-parsed");
        if (!localEntry.refreshNeeded())
        {
          this.mDelivery.postResponse(localInterruptedException, localResponse);
        }
        else
        {
          localInterruptedException.addMarker("cache-hit-refresh-needed");
          localInterruptedException.setCacheEntry(localEntry);
          localResponse.intermediate = true;
          this.mDelivery.postResponse(localInterruptedException, localResponse, new Runnable()
          {
            public void run()
            {
              try
              {
                CacheDispatcher.this.mNetworkQueue.put(localInterruptedException);
                return;
              }
              catch (InterruptedException localInterruptedException) {}
            }
          });
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/CacheDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */