package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new ResponseBody()
  {
    public long contentLength()
    {
      return 0L;
    }
    
    public MediaType contentType()
    {
      return null;
    }
    
    public BufferedSource source()
    {
      return new Buffer();
    }
  };
  public static final int MAX_FOLLOW_UPS = 20;
  private Address address;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private Connection connection;
  private final boolean forWebSocket;
  private Request networkRequest;
  private final Response priorResponse;
  private Sink requestBodyOut;
  private Route route;
  private RouteSelector routeSelector;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  private boolean transparentGzip;
  private Transport transport;
  private final Request userRequest;
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Connection paramConnection, RouteSelector paramRouteSelector, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    this.connection = paramConnection;
    this.routeSelector = paramRouteSelector;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
    if (paramConnection != null)
    {
      Internal.instance.setOwner(paramConnection, this);
      this.route = paramConnection.getRoute();
      return;
    }
    this.route = null;
  }
  
  private Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null) {}
    Sink localSink;
    do
    {
      return paramResponse;
      localSink = paramCacheRequest.body();
    } while (localSink == null);
    paramCacheRequest = new Source()
    {
      boolean cacheRequestClosed;
      
      public void close()
        throws IOException
      {
        if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        this.val$source.close();
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        try
        {
          paramAnonymousLong = this.val$source.read(paramAnonymousBuffer, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.cacheRequestClosed)
            {
              this.cacheRequestClosed = true;
              this.val$cacheBody.close();
            }
            return -1L;
          }
        }
        catch (IOException paramAnonymousBuffer)
        {
          if (!this.cacheRequestClosed)
          {
            this.cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw paramAnonymousBuffer;
        }
        paramAnonymousBuffer.copyTo(this.val$cacheBody.buffer(), paramAnonymousBuffer.size() - paramAnonymousLong, paramAnonymousLong);
        this.val$cacheBody.emitCompleteSegments();
        return paramAnonymousLong;
      }
      
      public Timeout timeout()
      {
        return this.val$source.timeout();
      }
    };
    return paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    if (i < j)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!OkHeaders.isEndToEnd(str1)) || (paramHeaders2.get(str1) == null)) {
          localBuilder.add(str1, str2);
        }
      }
    }
    i = 0;
    j = paramHeaders2.size();
    if (i < j)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ("Content-Length".equalsIgnoreCase(paramHeaders1)) {}
      for (;;)
      {
        i += 1;
        break;
        if (OkHeaders.isEndToEnd(paramHeaders1)) {
          localBuilder.add(paramHeaders1, paramHeaders2.value(i));
        }
      }
    }
    return localBuilder.build();
  }
  
  private void connect()
    throws RequestException, RouteException
  {
    if (this.connection != null) {
      throw new IllegalStateException();
    }
    if (this.routeSelector == null) {
      this.address = createAddress(this.client, this.networkRequest);
    }
    try
    {
      this.routeSelector = RouteSelector.get(this.address, this.networkRequest, this.client);
      this.connection = createNextConnection();
      Internal.instance.connectAndSetOwner(this.client, this.connection, this, this.networkRequest);
      this.route = this.connection.getRoute();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RequestException(localIOException);
    }
  }
  
  private void connectFailed(RouteSelector paramRouteSelector, IOException paramIOException)
  {
    if (Internal.instance.recycleCount(this.connection) > 0) {
      return;
    }
    paramRouteSelector.connectFailed(this.connection.getRoute(), paramIOException);
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    SSLSocketFactory localSSLSocketFactory = null;
    HostnameVerifier localHostnameVerifier = null;
    CertificatePinner localCertificatePinner = null;
    if (paramRequest.isHttps())
    {
      localSSLSocketFactory = paramOkHttpClient.getSslSocketFactory();
      localHostnameVerifier = paramOkHttpClient.getHostnameVerifier();
      localCertificatePinner = paramOkHttpClient.getCertificatePinner();
    }
    return new Address(paramRequest.httpUrl().host(), paramRequest.httpUrl().port(), paramOkHttpClient.getSocketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, paramOkHttpClient.getAuthenticator(), paramOkHttpClient.getProxy(), paramOkHttpClient.getProtocols(), paramOkHttpClient.getConnectionSpecs(), paramOkHttpClient.getProxySelector());
  }
  
  private Connection createNextConnection()
    throws RouteException
  {
    Object localObject = this.client.getConnectionPool();
    for (;;)
    {
      Connection localConnection = ((ConnectionPool)localObject).get(this.address);
      if (localConnection == null) {
        break;
      }
      if ((this.networkRequest.method().equals("GET")) || (Internal.instance.isReadable(localConnection))) {
        return localConnection;
      }
      Util.closeQuietly(localConnection.getSocket());
    }
    try
    {
      localObject = new Connection((ConnectionPool)localObject, this.routeSelector.next());
      return (Connection)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RouteException(localIOException);
    }
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((OkHeaders.contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }
  
  private boolean isRecoverable(RouteException paramRouteException)
  {
    if (!this.client.getRetryOnConnectionFailure()) {}
    do
    {
      return false;
      paramRouteException = paramRouteException.getLastConnectException();
    } while (((paramRouteException instanceof ProtocolException)) || ((paramRouteException instanceof InterruptedIOException)) || (((paramRouteException instanceof SSLHandshakeException)) && ((paramRouteException.getCause() instanceof CertificateException))) || ((paramRouteException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean isRecoverable(IOException paramIOException)
  {
    if (!this.client.getRetryOnConnectionFailure()) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException))) {
      return false;
    }
    return true;
  }
  
  private void maybeCache()
    throws IOException
  {
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache == null) {}
    do
    {
      return;
      if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
        break;
      }
    } while (!HttpMethod.invalidatesCache(this.networkRequest.method()));
    try
    {
      localInternalCache.remove(this.networkRequest);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.storeRequest = localIOException.put(stripBody(this.userResponse));
  }
  
  private Request networkRequest(Request paramRequest)
    throws IOException
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null) {
      localBuilder.header("Host", Util.hostHeader(paramRequest.httpUrl()));
    }
    if (((this.connection == null) || (this.connection.getProtocol() != Protocol.HTTP_1_0)) && (paramRequest.header("Connection") == null)) {
      localBuilder.header("Connection", "Keep-Alive");
    }
    if (paramRequest.header("Accept-Encoding") == null)
    {
      this.transparentGzip = true;
      localBuilder.header("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.toMultimap(localBuilder.build().headers(), null);
      OkHeaders.addCookies(localBuilder, localCookieHandler.get(paramRequest.uri(), localMap));
    }
    if (paramRequest.header("User-Agent") == null) {
      localBuilder.header("User-Agent", Version.userAgent());
    }
    return localBuilder.build();
  }
  
  private Response readNetworkResponse()
    throws IOException
  {
    this.transport.finishRequest();
    Response localResponse2 = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
    Response localResponse1 = localResponse2;
    if (!this.forWebSocket) {
      localResponse1 = localResponse2.newBuilder().body(this.transport.openResponseBody(localResponse2)).build();
    }
    Internal.instance.setProtocol(this.connection, localResponse1.protocol());
    return localResponse1;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  private Response unzip(Response paramResponse)
    throws IOException
  {
    if ((!this.transparentGzip) || (!"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")))) {}
    while (paramResponse.body() == null) {
      return paramResponse;
    }
    GzipSource localGzipSource = new GzipSource(paramResponse.body().source());
    Headers localHeaders = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
    return paramResponse.newBuilder().headers(localHeaders).body(new RealResponseBody(localHeaders, Okio.buffer(localGzipSource))).build();
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304) {}
    do
    {
      return true;
      paramResponse1 = paramResponse1.headers().getDate("Last-Modified");
      if (paramResponse1 == null) {
        break;
      }
      paramResponse2 = paramResponse2.headers().getDate("Last-Modified");
    } while ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime()));
    return false;
  }
  
  public Connection close()
  {
    if (this.bufferedRequestBody != null) {
      Util.closeQuietly(this.bufferedRequestBody);
    }
    while (this.userResponse == null)
    {
      if (this.connection != null) {
        Util.closeQuietly(this.connection.getSocket());
      }
      this.connection = null;
      return null;
      if (this.requestBodyOut != null) {
        Util.closeQuietly(this.requestBodyOut);
      }
    }
    Util.closeQuietly(this.userResponse.body());
    if ((this.transport != null) && (this.connection != null) && (!this.transport.canReuseConnection()))
    {
      Util.closeQuietly(this.connection.getSocket());
      this.connection = null;
      return null;
    }
    if ((this.connection != null) && (!Internal.instance.clearOwner(this.connection))) {
      this.connection = null;
    }
    Connection localConnection = this.connection;
    this.connection = null;
    return localConnection;
  }
  
  public void disconnect()
  {
    try
    {
      if (this.transport != null)
      {
        this.transport.disconnect(this);
        return;
      }
      Connection localConnection = this.connection;
      if (localConnection != null)
      {
        Internal.instance.closeIfOwnedBy(localConnection, this);
        return;
      }
    }
    catch (IOException localIOException) {}
  }
  
  public Request followUpRequest()
    throws IOException
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    Object localObject;
    if (getRoute() != null)
    {
      localObject = getRoute().getProxy();
      switch (this.userResponse.code())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          localObject = this.client.getProxy();
          break;
          if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
          }
          return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, (Proxy)localObject);
        } while (((!this.userRequest.method().equals("GET")) && (!this.userRequest.method().equals("HEAD"))) || (!this.client.getFollowRedirects()));
        localObject = this.userResponse.header("Location");
      } while (localObject == null);
      localObject = this.userRequest.httpUrl().resolve((String)localObject);
    } while ((localObject == null) || ((!((HttpUrl)localObject).scheme().equals(this.userRequest.httpUrl().scheme())) && (!this.client.getFollowSslRedirects())));
    Request.Builder localBuilder = this.userRequest.newBuilder();
    if (HttpMethod.permitsRequestBody(this.userRequest.method()))
    {
      localBuilder.method("GET", null);
      localBuilder.removeHeader("Transfer-Encoding");
      localBuilder.removeHeader("Content-Length");
      localBuilder.removeHeader("Content-Type");
    }
    if (!sameConnection((HttpUrl)localObject)) {
      localBuilder.removeHeader("Authorization");
    }
    return localBuilder.url((HttpUrl)localObject).build();
  }
  
  public BufferedSink getBufferedRequestBody()
  {
    Object localObject = this.bufferedRequestBody;
    if (localObject != null) {
      return (BufferedSink)localObject;
    }
    localObject = getRequestBody();
    if (localObject != null)
    {
      localObject = Okio.buffer((Sink)localObject);
      this.bufferedRequestBody = ((BufferedSink)localObject);
    }
    for (;;)
    {
      return (BufferedSink)localObject;
      localObject = null;
    }
  }
  
  public Connection getConnection()
  {
    return this.connection;
  }
  
  public Request getRequest()
  {
    return this.userRequest;
  }
  
  public Sink getRequestBody()
  {
    if (this.cacheStrategy == null) {
      throw new IllegalStateException();
    }
    return this.requestBodyOut;
  }
  
  public Response getResponse()
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    return this.userResponse;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public boolean hasResponse()
  {
    return this.userResponse != null;
  }
  
  boolean permitsRequestBody()
  {
    return HttpMethod.permitsRequestBody(this.userRequest.method());
  }
  
  public void readResponse()
    throws IOException
  {
    if (this.userResponse != null) {}
    label418:
    label430:
    label440:
    do
    {
      do
      {
        return;
        if ((this.networkRequest == null) && (this.cacheResponse == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (this.networkRequest == null);
      if (this.forWebSocket) {
        this.transport.writeRequestHeaders(this.networkRequest);
      }
      for (Object localObject = readNetworkResponse();; localObject = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest))
      {
        receiveHeaders(((Response)localObject).headers());
        if (this.cacheResponse == null) {
          break label440;
        }
        if (!validate(this.cacheResponse, (Response)localObject)) {
          break label430;
        }
        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), ((Response)localObject).headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
        ((Response)localObject).body().close();
        releaseConnection();
        localObject = Internal.instance.internalCache(this.client);
        ((InternalCache)localObject).trackConditionalCacheHit();
        ((InternalCache)localObject).update(this.cacheResponse, stripBody(this.userResponse));
        this.userResponse = unzip(this.userResponse);
        return;
        if (this.callerWritesRequestBody) {
          break;
        }
      }
      if ((this.bufferedRequestBody != null) && (this.bufferedRequestBody.buffer().size() > 0L)) {
        this.bufferedRequestBody.emit();
      }
      if (this.sentRequestMillis == -1L)
      {
        if ((OkHeaders.contentLength(this.networkRequest) == -1L) && ((this.requestBodyOut instanceof RetryableSink)))
        {
          long l = ((RetryableSink)this.requestBodyOut).contentLength();
          this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
        }
        this.transport.writeRequestHeaders(this.networkRequest);
      }
      if (this.requestBodyOut != null)
      {
        if (this.bufferedRequestBody == null) {
          break label418;
        }
        this.bufferedRequestBody.close();
      }
      for (;;)
      {
        if ((this.requestBodyOut instanceof RetryableSink)) {
          this.transport.writeRequestBody((RetryableSink)this.requestBodyOut);
        }
        localObject = readNetworkResponse();
        break;
        this.requestBodyOut.close();
      }
      Util.closeQuietly(this.cacheResponse.body());
      this.userResponse = ((Response)localObject).newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
    } while (!hasBody(this.userResponse));
    maybeCache();
    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
  }
  
  public void receiveHeaders(Headers paramHeaders)
    throws IOException
  {
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null));
    }
  }
  
  public HttpEngine recover(RouteException paramRouteException)
  {
    if ((this.routeSelector != null) && (this.connection != null)) {
      connectFailed(this.routeSelector, paramRouteException.getLastConnectException());
    }
    if (((this.routeSelector == null) && (this.connection == null)) || ((this.routeSelector != null) && (!this.routeSelector.hasNext())) || (!isRecoverable(paramRouteException))) {
      return null;
    }
    paramRouteException = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, paramRouteException, this.routeSelector, (RetryableSink)this.requestBodyOut, this.priorResponse);
  }
  
  public HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, this.requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    if ((this.routeSelector != null) && (this.connection != null)) {
      connectFailed(this.routeSelector, paramIOException);
    }
    if ((paramSink == null) || ((paramSink instanceof RetryableSink))) {}
    for (int i = 1; ((this.routeSelector == null) && (this.connection == null)) || ((this.routeSelector != null) && (!this.routeSelector.hasNext())) || (!isRecoverable(paramIOException)) || (i == 0); i = 0) {
      return null;
    }
    paramIOException = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, paramIOException, this.routeSelector, (RetryableSink)paramSink, this.priorResponse);
  }
  
  public void releaseConnection()
    throws IOException
  {
    if ((this.transport != null) && (this.connection != null)) {
      this.transport.releaseConnectionOnIdle();
    }
    this.connection = null;
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl)
  {
    HttpUrl localHttpUrl = this.userRequest.httpUrl();
    return (localHttpUrl.host().equals(paramHttpUrl.host())) && (localHttpUrl.port() == paramHttpUrl.port()) && (localHttpUrl.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void sendRequest()
    throws RequestException, RouteException, IOException
  {
    if (this.cacheStrategy != null) {
      return;
    }
    if (this.transport != null) {
      throw new IllegalStateException();
    }
    Request localRequest = networkRequest(this.userRequest);
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache != null) {}
    long l;
    for (Response localResponse = localInternalCache.get(localRequest);; localResponse = null)
    {
      this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).get();
      this.networkRequest = this.cacheStrategy.networkRequest;
      this.cacheResponse = this.cacheStrategy.cacheResponse;
      if (localInternalCache != null) {
        localInternalCache.trackResponse(this.cacheStrategy);
      }
      if ((localResponse != null) && (this.cacheResponse == null)) {
        Util.closeQuietly(localResponse.body());
      }
      if (this.networkRequest == null) {
        break label306;
      }
      if (this.connection == null) {
        connect();
      }
      this.transport = Internal.instance.newTransport(this.connection, this);
      if ((!this.callerWritesRequestBody) || (!permitsRequestBody()) || (this.requestBodyOut != null)) {
        break;
      }
      l = OkHeaders.contentLength(localRequest);
      if (!this.bufferRequestBody) {
        break label274;
      }
      if (l <= 2147483647L) {
        break label227;
      }
      throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    label227:
    if (l != -1L)
    {
      this.transport.writeRequestHeaders(this.networkRequest);
      this.requestBodyOut = new RetryableSink((int)l);
      return;
    }
    this.requestBodyOut = new RetryableSink();
    return;
    label274:
    this.transport.writeRequestHeaders(this.networkRequest);
    this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, l);
    return;
    label306:
    if (this.connection != null)
    {
      Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
      this.connection = null;
    }
    if (this.cacheResponse != null) {}
    for (this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();; this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build())
    {
      this.userResponse = unzip(this.userResponse);
      return;
    }
  }
  
  public void writingRequestHeaders()
  {
    if (this.sentRequestMillis != -1L) {
      throw new IllegalStateException();
    }
    this.sentRequestMillis = System.currentTimeMillis();
  }
  
  class NetworkInterceptorChain
    implements Interceptor.Chain
  {
    private int calls;
    private final int index;
    private final Request request;
    
    NetworkInterceptorChain(int paramInt, Request paramRequest)
    {
      this.index = paramInt;
      this.request = paramRequest;
    }
    
    public Connection connection()
    {
      return HttpEngine.this.connection;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      this.calls += 1;
      Object localObject1;
      Object localObject2;
      if (this.index > 0)
      {
        localObject1 = (Interceptor)HttpEngine.this.client.networkInterceptors().get(this.index - 1);
        localObject2 = connection().getRoute().getAddress();
        if ((!paramRequest.httpUrl().host().equals(((Address)localObject2).getUriHost())) || (paramRequest.httpUrl().port() != ((Address)localObject2).getUriPort())) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
        }
        if (this.calls > 1) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
        }
      }
      if (this.index < HttpEngine.this.client.networkInterceptors().size())
      {
        localObject1 = new NetworkInterceptorChain(HttpEngine.this, this.index + 1, paramRequest);
        localObject2 = (Interceptor)HttpEngine.this.client.networkInterceptors().get(this.index);
        paramRequest = ((Interceptor)localObject2).intercept((Interceptor.Chain)localObject1);
        if (((NetworkInterceptorChain)localObject1).calls != 1) {
          throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
        }
      }
      else
      {
        HttpEngine.this.transport.writeRequestHeaders(paramRequest);
        HttpEngine.access$202(HttpEngine.this, paramRequest);
        if ((HttpEngine.this.permitsRequestBody()) && (paramRequest.body() != null))
        {
          localObject1 = Okio.buffer(HttpEngine.this.transport.createRequestBody(paramRequest, paramRequest.body().contentLength()));
          paramRequest.body().writeTo((BufferedSink)localObject1);
          ((BufferedSink)localObject1).close();
        }
        paramRequest = HttpEngine.this.readNetworkResponse();
        int i = paramRequest.code();
        if (((i == 204) || (i == 205)) && (paramRequest.body().contentLength() > 0L)) {
          throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramRequest.body().contentLength());
        }
      }
      return paramRequest;
    }
    
    public Request request()
    {
      return this.request;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/HttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */