package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

public final class Response
{
  private final ResponseBody body;
  private volatile CacheControl cacheControl;
  private Response cacheResponse;
  private final int code;
  private final Handshake handshake;
  private final Headers headers;
  private final String message;
  private Response networkResponse;
  private final Response priorResponse;
  private final Protocol protocol;
  private final Request request;
  
  private Response(Builder paramBuilder)
  {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
  }
  
  public ResponseBody body()
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
  
  public Response cacheResponse()
  {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges()
  {
    if (this.code == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return OkHeaders.parseChallenges(headers(), str);
      if (this.code != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public int code()
  {
    return this.code;
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public String header(String paramString)
  {
    return header(paramString, null);
  }
  
  public String header(String paramString1, String paramString2)
  {
    paramString1 = this.headers.get(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public boolean isRedirect()
  {
    switch (this.code)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isSuccessful()
  {
    return (this.code >= 200) && (this.code < 300);
  }
  
  public String message()
  {
    return this.message;
  }
  
  public Response networkResponse()
  {
    return this.networkResponse;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public Response priorResponse()
  {
    return this.priorResponse;
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.urlString() + '}';
  }
  
  public static class Builder
  {
    private ResponseBody body;
    private Response cacheResponse;
    private int code = -1;
    private Handshake handshake;
    private Headers.Builder headers;
    private String message;
    private Response networkResponse;
    private Response priorResponse;
    private Protocol protocol;
    private Request request;
    
    public Builder()
    {
      this.headers = new Headers.Builder();
    }
    
    private Builder(Response paramResponse)
    {
      this.request = paramResponse.request;
      this.protocol = paramResponse.protocol;
      this.code = paramResponse.code;
      this.message = paramResponse.message;
      this.handshake = paramResponse.handshake;
      this.headers = paramResponse.headers.newBuilder();
      this.body = paramResponse.body;
      this.networkResponse = paramResponse.networkResponse;
      this.cacheResponse = paramResponse.cacheResponse;
      this.priorResponse = paramResponse.priorResponse;
    }
    
    private void checkPriorResponse(Response paramResponse)
    {
      if (paramResponse.body != null) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
    }
    
    private void checkSupportResponse(String paramString, Response paramResponse)
    {
      if (paramResponse.body != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (paramResponse.networkResponse != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (paramResponse.cacheResponse != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (paramResponse.priorResponse != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }
    
    public Builder body(ResponseBody paramResponseBody)
    {
      this.body = paramResponseBody;
      return this;
    }
    
    public Response build()
    {
      if (this.request == null) {
        throw new IllegalStateException("request == null");
      }
      if (this.protocol == null) {
        throw new IllegalStateException("protocol == null");
      }
      if (this.code < 0) {
        throw new IllegalStateException("code < 0: " + this.code);
      }
      return new Response(this, null);
    }
    
    public Builder cacheResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkSupportResponse("cacheResponse", paramResponse);
      }
      this.cacheResponse = paramResponse;
      return this;
    }
    
    public Builder code(int paramInt)
    {
      this.code = paramInt;
      return this;
    }
    
    public Builder handshake(Handshake paramHandshake)
    {
      this.handshake = paramHandshake;
      return this;
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
    
    public Builder message(String paramString)
    {
      this.message = paramString;
      return this;
    }
    
    public Builder networkResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkSupportResponse("networkResponse", paramResponse);
      }
      this.networkResponse = paramResponse;
      return this;
    }
    
    public Builder priorResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkPriorResponse(paramResponse);
      }
      this.priorResponse = paramResponse;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }
    
    public Builder request(Request paramRequest)
    {
      this.request = paramRequest;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */