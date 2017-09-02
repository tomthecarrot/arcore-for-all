package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CacheStrategy
{
  public final Response cacheResponse;
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    switch (paramResponse.code())
    {
    }
    do
    {
      return false;
    } while (((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) || (paramResponse.cacheControl().noStore()) || (paramRequest.cacheControl().noStore()));
    return true;
  }
  
  public static class Factory
  {
    private int ageSeconds = -1;
    final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    final long nowMillis;
    private long receivedResponseMillis;
    final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;
    
    public Factory(long paramLong, Request paramRequest, Response paramResponse)
    {
      this.nowMillis = paramLong;
      this.request = paramRequest;
      this.cacheResponse = paramResponse;
      if (paramResponse != null)
      {
        paramRequest = paramResponse.headers();
        int i = 0;
        int j = paramRequest.size();
        if (i < j)
        {
          paramResponse = paramRequest.name(i);
          String str = paramRequest.value(i);
          if ("Date".equalsIgnoreCase(paramResponse))
          {
            this.servedDate = HttpDate.parse(str);
            this.servedDateString = str;
          }
          for (;;)
          {
            i += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramResponse))
            {
              this.expires = HttpDate.parse(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramResponse))
            {
              this.lastModified = HttpDate.parse(str);
              this.lastModifiedString = str;
            }
            else if ("ETag".equalsIgnoreCase(paramResponse))
            {
              this.etag = str;
            }
            else if ("Age".equalsIgnoreCase(paramResponse))
            {
              this.ageSeconds = HeaderParser.parseSeconds(str, -1);
            }
            else if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(paramResponse))
            {
              this.sentRequestMillis = Long.parseLong(str);
            }
            else if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(paramResponse))
            {
              this.receivedResponseMillis = Long.parseLong(str);
            }
          }
        }
      }
    }
    
    private long cacheResponseAge()
    {
      long l = 0L;
      if (this.servedDate != null) {
        l = Math.max(0L, this.receivedResponseMillis - this.servedDate.getTime());
      }
      if (this.ageSeconds != -1) {
        l = Math.max(l, TimeUnit.SECONDS.toMillis(this.ageSeconds));
      }
      for (;;)
      {
        return l + (this.receivedResponseMillis - this.sentRequestMillis) + (this.nowMillis - this.receivedResponseMillis);
      }
    }
    
    private long computeFreshnessLifetime()
    {
      long l2 = 0L;
      CacheControl localCacheControl = this.cacheResponse.cacheControl();
      if (localCacheControl.maxAgeSeconds() != -1) {
        l1 = TimeUnit.SECONDS.toMillis(localCacheControl.maxAgeSeconds());
      }
      label83:
      do
      {
        do
        {
          return l1;
          if (this.expires != null)
          {
            if (this.servedDate != null)
            {
              l1 = this.servedDate.getTime();
              l1 = this.expires.getTime() - l1;
              if (l1 <= 0L) {
                break label83;
              }
            }
            for (;;)
            {
              return l1;
              l1 = this.receivedResponseMillis;
              break;
              l1 = 0L;
            }
          }
          l1 = l2;
        } while (this.lastModified == null);
        l1 = l2;
      } while (this.cacheResponse.request().httpUrl().query() != null);
      if (this.servedDate != null) {}
      for (long l1 = this.servedDate.getTime();; l1 = this.sentRequestMillis)
      {
        long l3 = l1 - this.lastModified.getTime();
        l1 = l2;
        if (l3 <= 0L) {
          break;
        }
        return l3 / 10L;
      }
    }
    
    private CacheStrategy getCandidate()
    {
      if (this.cacheResponse == null) {
        return new CacheStrategy(this.request, null, null);
      }
      if ((this.request.isHttps()) && (this.cacheResponse.handshake() == null)) {
        return new CacheStrategy(this.request, null, null);
      }
      if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
        return new CacheStrategy(this.request, null, null);
      }
      Object localObject = this.request.cacheControl();
      if ((((CacheControl)localObject).noCache()) || (hasConditions(this.request))) {
        return new CacheStrategy(this.request, null, null);
      }
      long l5 = cacheResponseAge();
      long l2 = computeFreshnessLifetime();
      long l1 = l2;
      if (((CacheControl)localObject).maxAgeSeconds() != -1) {
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((CacheControl)localObject).maxAgeSeconds()));
      }
      l2 = 0L;
      if (((CacheControl)localObject).minFreshSeconds() != -1) {
        l2 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject).minFreshSeconds());
      }
      long l4 = 0L;
      CacheControl localCacheControl = this.cacheResponse.cacheControl();
      long l3 = l4;
      if (!localCacheControl.mustRevalidate())
      {
        l3 = l4;
        if (((CacheControl)localObject).maxStaleSeconds() != -1) {
          l3 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject).maxStaleSeconds());
        }
      }
      if ((!localCacheControl.noCache()) && (l5 + l2 < l1 + l3))
      {
        localObject = this.cacheResponse.newBuilder();
        if (l5 + l2 >= l1) {
          ((Response.Builder)localObject).addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if ((l5 > 86400000L) && (isFreshnessLifetimeHeuristic())) {
          ((Response.Builder)localObject).addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return new CacheStrategy(null, ((Response.Builder)localObject).build(), null);
      }
      localObject = this.request.newBuilder();
      if (this.etag != null) {
        ((Request.Builder)localObject).header("If-None-Match", this.etag);
      }
      for (;;)
      {
        localObject = ((Request.Builder)localObject).build();
        if (!hasConditions((Request)localObject)) {
          break;
        }
        return new CacheStrategy((Request)localObject, this.cacheResponse, null);
        if (this.lastModified != null) {
          ((Request.Builder)localObject).header("If-Modified-Since", this.lastModifiedString);
        } else if (this.servedDate != null) {
          ((Request.Builder)localObject).header("If-Modified-Since", this.servedDateString);
        }
      }
      return new CacheStrategy((Request)localObject, null, null);
    }
    
    private static boolean hasConditions(Request paramRequest)
    {
      return (paramRequest.header("If-Modified-Since") != null) || (paramRequest.header("If-None-Match") != null);
    }
    
    private boolean isFreshnessLifetimeHeuristic()
    {
      return (this.cacheResponse.cacheControl().maxAgeSeconds() == -1) && (this.expires == null);
    }
    
    public CacheStrategy get()
    {
      CacheStrategy localCacheStrategy2 = getCandidate();
      CacheStrategy localCacheStrategy1 = localCacheStrategy2;
      if (localCacheStrategy2.networkRequest != null)
      {
        localCacheStrategy1 = localCacheStrategy2;
        if (this.request.cacheControl().onlyIfCached()) {
          localCacheStrategy1 = new CacheStrategy(null, null, null);
        }
      }
      return localCacheStrategy1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/CacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */