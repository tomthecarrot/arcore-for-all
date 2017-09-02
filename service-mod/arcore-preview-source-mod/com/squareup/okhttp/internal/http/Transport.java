package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Sink;

public abstract interface Transport
{
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
  
  public abstract boolean canReuseConnection();
  
  public abstract Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException;
  
  public abstract void disconnect(HttpEngine paramHttpEngine)
    throws IOException;
  
  public abstract void finishRequest()
    throws IOException;
  
  public abstract ResponseBody openResponseBody(Response paramResponse)
    throws IOException;
  
  public abstract Response.Builder readResponseHeaders()
    throws IOException;
  
  public abstract void releaseConnectionOnIdle()
    throws IOException;
  
  public abstract void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException;
  
  public abstract void writeRequestHeaders(Request paramRequest)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/Transport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */