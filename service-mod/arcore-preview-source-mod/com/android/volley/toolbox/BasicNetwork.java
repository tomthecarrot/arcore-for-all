package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork
  implements Network
{
  protected static final boolean DEBUG = VolleyLog.DEBUG;
  private static int DEFAULT_POOL_SIZE = 4096;
  private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
  protected final HttpStack mHttpStack;
  protected final ByteArrayPool mPool;
  
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
  }
  
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.mHttpStack = paramHttpStack;
    this.mPool = paramByteArrayPool;
  }
  
  private void addCacheHeaders(Map<String, String> paramMap, Cache.Entry paramEntry)
  {
    if (paramEntry == null) {}
    do
    {
      return;
      if (paramEntry.etag != null) {
        paramMap.put("If-None-Match", paramEntry.etag);
      }
    } while (paramEntry.serverDate <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramEntry.serverDate)));
  }
  
  private static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
    throws VolleyError
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError paramVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramVolleyError;
    }
  }
  
  protected static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private byte[] entityToBytes(HttpEntity paramHttpEntity)
    throws IOException, ServerError
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new ServerError();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.mPool.returnBuf((byte[])localObject1);
      localPoolingByteArrayOutputStream.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.mPool.getBuf(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localPoolingByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localPoolingByteArrayOutputStream.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.mPool.returnBuf(arrayOfByte);
        localPoolingByteArrayOutputStream.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > SLOW_REQUEST_THRESHOLD_MS)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
      return;
    }
  }
  
  protected void logError(String paramString1, String paramString2, long paramLong)
  {
    VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[] { paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2 });
  }
  
  public NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    long l = SystemClock.elapsedRealtime();
    label440:
    NetworkResponse localNetworkResponse2;
    for (;;)
    {
      HttpResponse localHttpResponse2 = null;
      NetworkResponse localNetworkResponse1 = null;
      Map localMap2 = Collections.emptyMap();
      Object localObject2 = localNetworkResponse1;
      HttpResponse localHttpResponse1 = localHttpResponse2;
      Map localMap1 = localMap2;
      try
      {
        localObject3 = new HashMap();
        localObject2 = localNetworkResponse1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        addCacheHeaders((Map)localObject3, paramRequest.getCacheEntry());
        localObject2 = localNetworkResponse1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        localHttpResponse2 = this.mHttpStack.performRequest(paramRequest, (Map)localObject3);
        localObject2 = localNetworkResponse1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        localObject3 = localHttpResponse2.getStatusLine();
        localObject2 = localNetworkResponse1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        i = ((StatusLine)localObject3).getStatusCode();
        localObject2 = localNetworkResponse1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        localMap2 = convertHeaders(localHttpResponse2.getAllHeaders());
        if (i == 304)
        {
          localObject2 = localNetworkResponse1;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          localObject3 = paramRequest.getCacheEntry();
          if (localObject3 == null)
          {
            localObject2 = localNetworkResponse1;
            localHttpResponse1 = localHttpResponse2;
            localMap1 = localMap2;
            return new NetworkResponse(304, null, localMap2, true);
          }
          localObject2 = localNetworkResponse1;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          ((Cache.Entry)localObject3).responseHeaders.putAll(localMap2);
          localObject2 = localNetworkResponse1;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          localNetworkResponse1 = new NetworkResponse(304, ((Cache.Entry)localObject3).data, ((Cache.Entry)localObject3).responseHeaders, true);
          return localNetworkResponse1;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        Object localObject3;
        attemptRetryOnException("socket", paramRequest, new TimeoutError());
        continue;
        localObject2 = localSocketTimeoutException;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        if (localHttpResponse2.getEntity() != null)
        {
          localObject2 = localSocketTimeoutException;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          byte[] arrayOfByte = entityToBytes(localHttpResponse2.getEntity());
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          logSlowRequests(SystemClock.elapsedRealtime() - l, paramRequest, arrayOfByte, (StatusLine)localObject3);
          if (((i >= 200) && (i <= 299)) || (i == 308)) {
            break label440;
          }
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          throw new IOException();
        }
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        for (;;)
        {
          attemptRetryOnException("connection", paramRequest, new TimeoutError());
          break;
          localObject2 = localConnectTimeoutException;
          localHttpResponse1 = localHttpResponse2;
          localMap1 = localMap2;
          localObject1 = new byte[0];
        }
        localObject2 = localObject1;
        localHttpResponse1 = localHttpResponse2;
        localMap1 = localMap2;
        Object localObject1 = new NetworkResponse(i, (byte[])localObject1, localMap2, false);
        return (NetworkResponse)localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        throw new RuntimeException("Bad URL " + paramRequest.getUrl(), localMalformedURLException);
      }
      catch (IOException localIOException)
      {
        int i;
        if (localHttpResponse1 != null)
        {
          i = localHttpResponse1.getStatusLine().getStatusCode();
          VolleyLog.e("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramRequest.getUrl() });
          if (localObject2 == null) {
            break label622;
          }
          localNetworkResponse2 = new NetworkResponse(i, (byte[])localObject2, localMap1, false);
          if ((i == 401) || (i == 403)) {
            attemptRetryOnException("auth", paramRequest, new AuthFailureError(localNetworkResponse2));
          }
        }
        else
        {
          throw new NoConnectionError(localNetworkResponse2);
        }
      }
    }
    throw new ServerError(localNetworkResponse2);
    label622:
    throw new NetworkError(null);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/toolbox/BasicNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */