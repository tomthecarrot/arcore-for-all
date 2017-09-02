package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final Cache mCache;
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request<?>> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mQueue = paramBlockingQueue;
    this.mNetwork = paramNetwork;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
  }
  
  @TargetApi(14)
  private void addTrafficStatsTag(Request<?> paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
    }
  }
  
  private void parseAndDeliverNetworkError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    this.mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 86	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 24	com/android/volley/NetworkDispatcher:mQueue	Ljava/util/concurrent/BlockingQueue;
    //   9: invokeinterface 92 1 0
    //   14: checkcast 46	com/android/volley/Request
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 94
    //   21: invokevirtual 98	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 102	com/android/volley/Request:isCanceled	()Z
    //   28: ifeq +31 -> 59
    //   31: aload_1
    //   32: ldc 104
    //   34: invokevirtual 107	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   37: goto -32 -> 5
    //   40: astore_2
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokespecial 109	com/android/volley/NetworkDispatcher:parseAndDeliverNetworkError	(Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   47: goto -42 -> 5
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 22	com/android/volley/NetworkDispatcher:mQuit	Z
    //   55: ifeq -50 -> 5
    //   58: return
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 111	com/android/volley/NetworkDispatcher:addTrafficStatsTag	(Lcom/android/volley/Request;)V
    //   64: aload_0
    //   65: getfield 26	com/android/volley/NetworkDispatcher:mNetwork	Lcom/android/volley/Network;
    //   68: aload_1
    //   69: invokeinterface 117 2 0
    //   74: astore_2
    //   75: aload_1
    //   76: ldc 119
    //   78: invokevirtual 98	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: getfield 124	com/android/volley/NetworkResponse:notModified	Z
    //   85: ifeq +58 -> 143
    //   88: aload_1
    //   89: invokevirtual 127	com/android/volley/Request:hasHadResponseDelivered	()Z
    //   92: ifeq +51 -> 143
    //   95: aload_1
    //   96: ldc -127
    //   98: invokevirtual 107	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   101: goto -96 -> 5
    //   104: astore_2
    //   105: aload_2
    //   106: ldc -125
    //   108: iconst_1
    //   109: anewarray 133	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_2
    //   115: invokevirtual 137	java/lang/Exception:toString	()Ljava/lang/String;
    //   118: aastore
    //   119: invokestatic 143	com/android/volley/VolleyLog:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   126: aload_1
    //   127: new 79	com/android/volley/VolleyError
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 146	com/android/volley/VolleyError:<init>	(Ljava/lang/Throwable;)V
    //   135: invokeinterface 69 3 0
    //   140: goto -135 -> 5
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 150	com/android/volley/Request:parseNetworkResponse	(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;
    //   148: astore_2
    //   149: aload_1
    //   150: ldc -104
    //   152: invokevirtual 98	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: invokevirtual 155	com/android/volley/Request:shouldCache	()Z
    //   159: ifeq +33 -> 192
    //   162: aload_2
    //   163: getfield 161	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   166: ifnull +26 -> 192
    //   169: aload_0
    //   170: getfield 28	com/android/volley/NetworkDispatcher:mCache	Lcom/android/volley/Cache;
    //   173: aload_1
    //   174: invokevirtual 164	com/android/volley/Request:getCacheKey	()Ljava/lang/String;
    //   177: aload_2
    //   178: getfield 161	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   181: invokeinterface 170 3 0
    //   186: aload_1
    //   187: ldc -84
    //   189: invokevirtual 98	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: invokevirtual 175	com/android/volley/Request:markDelivered	()V
    //   196: aload_0
    //   197: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   200: aload_1
    //   201: aload_2
    //   202: invokeinterface 179 3 0
    //   207: goto -202 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	NetworkDispatcher
    //   17	26	1	localRequest	Request
    //   50	151	1	localInterruptedException	InterruptedException
    //   40	4	2	localVolleyError	VolleyError
    //   74	8	2	localNetworkResponse	NetworkResponse
    //   104	41	2	localException	Exception
    //   148	54	2	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   18	37	40	com/android/volley/VolleyError
    //   59	101	40	com/android/volley/VolleyError
    //   143	192	40	com/android/volley/VolleyError
    //   192	207	40	com/android/volley/VolleyError
    //   5	18	50	java/lang/InterruptedException
    //   18	37	104	java/lang/Exception
    //   59	101	104	java/lang/Exception
    //   143	192	104	java/lang/Exception
    //   192	207	104	java/lang/Exception
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/NetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */