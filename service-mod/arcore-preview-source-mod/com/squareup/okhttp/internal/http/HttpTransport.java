package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import java.io.IOException;
import java.net.Proxy;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class HttpTransport
  implements Transport
{
  private final HttpConnection httpConnection;
  private final HttpEngine httpEngine;
  
  public HttpTransport(HttpEngine paramHttpEngine, HttpConnection paramHttpConnection)
  {
    this.httpEngine = paramHttpEngine;
    this.httpConnection = paramHttpConnection;
  }
  
  private Source getTransferStream(Response paramResponse)
    throws IOException
  {
    if (!HttpEngine.hasBody(paramResponse)) {
      return this.httpConnection.newFixedLengthSource(0L);
    }
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) {
      return this.httpConnection.newChunkedSource(this.httpEngine);
    }
    long l = OkHeaders.contentLength(paramResponse);
    if (l != -1L) {
      return this.httpConnection.newFixedLengthSource(l);
    }
    return this.httpConnection.newUnknownLengthSource();
  }
  
  public boolean canReuseConnection()
  {
    if ("close".equalsIgnoreCase(this.httpEngine.getRequest().header("Connection"))) {}
    while (("close".equalsIgnoreCase(this.httpEngine.getResponse().header("Connection"))) || (this.httpConnection.isClosed())) {
      return false;
    }
    return true;
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding"))) {
      return this.httpConnection.newChunkedSink();
    }
    if (paramLong != -1L) {
      return this.httpConnection.newFixedLengthSink(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public void disconnect(HttpEngine paramHttpEngine)
    throws IOException
  {
    this.httpConnection.closeIfOwnedBy(paramHttpEngine);
  }
  
  public void finishRequest()
    throws IOException
  {
    this.httpConnection.flush();
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    Source localSource = getTransferStream(paramResponse);
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(localSource));
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return this.httpConnection.readResponse();
  }
  
  public void releaseConnectionOnIdle()
    throws IOException
  {
    if (canReuseConnection())
    {
      this.httpConnection.poolOnIdle();
      return;
    }
    this.httpConnection.closeOnIdle();
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    this.httpConnection.writeRequestBody(paramRetryableSink);
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    this.httpEngine.writingRequestHeaders();
    String str = RequestLine.get(paramRequest, this.httpEngine.getConnection().getRoute().getProxy().type(), this.httpEngine.getConnection().getProtocol());
    this.httpConnection.writeRequest(paramRequest.headers(), str);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/HttpTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */