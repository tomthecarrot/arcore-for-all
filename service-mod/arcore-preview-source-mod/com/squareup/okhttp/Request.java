package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public final class Request
{
  private final RequestBody body;
  private volatile CacheControl cacheControl;
  private final Headers headers;
  private volatile URI javaNetUri;
  private volatile URL javaNetUrl;
  private final String method;
  private final Object tag;
  private final HttpUrl url;
  
  private Request(Builder paramBuilder)
  {
    this.url = paramBuilder.url;
    this.method = paramBuilder.method;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    if (paramBuilder.tag != null) {}
    for (paramBuilder = paramBuilder.tag;; paramBuilder = this)
    {
      this.tag = paramBuilder;
      return;
    }
  }
  
  public RequestBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public HttpUrl httpUrl()
  {
    return this.url;
  }
  
  public boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public String method()
  {
    return this.method;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public Object tag()
  {
    return this.tag;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.method).append(", url=").append(this.url).append(", tag=");
    if (this.tag != this) {}
    for (Object localObject = this.tag;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public URI uri()
    throws IOException
  {
    try
    {
      URI localURI = this.javaNetUri;
      if (localURI != null) {
        return localURI;
      }
      localURI = this.url.uri();
      this.javaNetUri = localURI;
      return localURI;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IOException(localIllegalStateException.getMessage());
    }
  }
  
  public URL url()
  {
    URL localURL = this.javaNetUrl;
    if (localURL != null) {
      return localURL;
    }
    localURL = this.url.url();
    this.javaNetUrl = localURL;
    return localURL;
  }
  
  public String urlString()
  {
    return this.url.toString();
  }
  
  public static class Builder
  {
    private RequestBody body;
    private Headers.Builder headers;
    private String method;
    private Object tag;
    private HttpUrl url;
    
    public Builder()
    {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }
    
    private Builder(Request paramRequest)
    {
      this.url = paramRequest.url;
      this.method = paramRequest.method;
      this.body = paramRequest.body;
      this.tag = paramRequest.tag;
      this.headers = paramRequest.headers.newBuilder();
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }
    
    public Request build()
    {
      if (this.url == null) {
        throw new IllegalStateException("url == null");
      }
      return new Request(this, null);
    }
    
    public Builder cacheControl(CacheControl paramCacheControl)
    {
      paramCacheControl = paramCacheControl.toString();
      if (paramCacheControl.isEmpty()) {
        return removeHeader("Cache-Control");
      }
      return header("Cache-Control", paramCacheControl);
    }
    
    public Builder delete()
    {
      return delete(RequestBody.create(null, new byte[0]));
    }
    
    public Builder delete(RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }
    
    public Builder get()
    {
      return method("GET", null);
    }
    
    public Builder head()
    {
      return method("HEAD", null);
    }
    
    public Builder header(String paramString1, String paramString2)
    {
      this.headers.set(paramString1, paramString2);
      return this;
    }
    
    public Builder headers(Headers paramHeaders)
    {
      this.headers = paramHeaders.newBuilder();
      return this;
    }
    
    public Builder method(String paramString, RequestBody paramRequestBody)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.method = paramString;
      this.body = paramRequestBody;
      return this;
    }
    
    public Builder patch(RequestBody paramRequestBody)
    {
      return method("PATCH", paramRequestBody);
    }
    
    public Builder post(RequestBody paramRequestBody)
    {
      return method("POST", paramRequestBody);
    }
    
    public Builder put(RequestBody paramRequestBody)
    {
      return method("PUT", paramRequestBody);
    }
    
    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }
    
    public Builder tag(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    public Builder url(HttpUrl paramHttpUrl)
    {
      if (paramHttpUrl == null) {
        throw new IllegalArgumentException("url == null");
      }
      this.url = paramHttpUrl;
      return this;
    }
    
    public Builder url(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = HttpUrl.parse(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return url(paramString);
    }
    
    public Builder url(URL paramURL)
    {
      if (paramURL == null) {
        throw new IllegalArgumentException("url == null");
      }
      HttpUrl localHttpUrl = HttpUrl.get(paramURL);
      if (localHttpUrl == null) {
        throw new IllegalArgumentException("unexpected url: " + paramURL);
      }
      return url(localHttpUrl);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */