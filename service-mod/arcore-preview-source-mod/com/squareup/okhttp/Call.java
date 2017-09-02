package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

public class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
    throws IOException
  {
    return new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean).proceed(this.originalRequest);
  }
  
  private String toLoggableString()
  {
    if (this.canceled) {}
    for (String str = "canceled call";; str = "call")
    {
      HttpUrl localHttpUrl = this.originalRequest.httpUrl().resolve("/...");
      return str + " to " + localHttpUrl;
    }
  }
  
  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null) {
      this.engine.disconnect();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    this.client.getDispatcher().enqueue(new AsyncCall(paramCallback, paramBoolean, null));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    try
    {
      this.client.getDispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain(false);
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.client.getDispatcher().finished(this);
    }
    this.client.getDispatcher().finished(this);
    return localResponse2;
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean)
    throws IOException
  {
    Object localObject2 = paramRequest.body();
    Object localObject1 = paramRequest;
    int i;
    if (localObject2 != null)
    {
      paramRequest = paramRequest.newBuilder();
      localObject1 = ((RequestBody)localObject2).contentType();
      if (localObject1 != null) {
        paramRequest.header("Content-Type", ((MediaType)localObject1).toString());
      }
      long l = ((RequestBody)localObject2).contentLength();
      if (l != -1L)
      {
        paramRequest.header("Content-Length", Long.toString(l));
        paramRequest.removeHeader("Transfer-Encoding");
        localObject1 = paramRequest.build();
      }
    }
    else
    {
      this.engine = new HttpEngine(this.client, (Request)localObject1, false, false, paramBoolean, null, null, null, null);
      i = 0;
    }
    for (;;)
    {
      if (this.canceled)
      {
        this.engine.releaseConnection();
        throw new IOException("Canceled");
        paramRequest.header("Transfer-Encoding", "chunked");
        paramRequest.removeHeader("Content-Length");
        break;
      }
      try
      {
        this.engine.sendRequest();
        this.engine.readResponse();
        paramRequest = this.engine.getResponse();
        localObject1 = this.engine.followUpRequest();
        if (localObject1 == null)
        {
          if (!paramBoolean) {
            this.engine.releaseConnection();
          }
          return paramRequest;
        }
      }
      catch (RequestException paramRequest)
      {
        throw paramRequest.getCause();
      }
      catch (RouteException paramRequest)
      {
        localObject1 = this.engine.recover(paramRequest);
        if (localObject1 != null)
        {
          this.engine = ((HttpEngine)localObject1);
          continue;
        }
        throw paramRequest.getLastConnectException();
      }
      catch (IOException paramRequest)
      {
        localObject1 = this.engine.recover(paramRequest, null);
        if (localObject1 != null)
        {
          this.engine = ((HttpEngine)localObject1);
          continue;
        }
        throw paramRequest;
      }
      i += 1;
      if (i > 20) {
        throw new ProtocolException("Too many follow-up requests: " + i);
      }
      if (!this.engine.sameConnection(((Request)localObject1).httpUrl())) {
        this.engine.releaseConnection();
      }
      localObject2 = this.engine.close();
      this.engine = new HttpEngine(this.client, (Request)localObject1, false, false, paramBoolean, (Connection)localObject2, null, null, paramRequest);
    }
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  Object tag()
  {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain
    implements Interceptor.Chain
  {
    private final boolean forWebSocket;
    private final int index;
    private final Request request;
    
    ApplicationInterceptorChain(int paramInt, Request paramRequest, boolean paramBoolean)
    {
      this.index = paramInt;
      this.request = paramRequest;
      this.forWebSocket = paramBoolean;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      if (this.index < Call.this.client.interceptors().size())
      {
        paramRequest = new ApplicationInterceptorChain(Call.this, this.index + 1, paramRequest, this.forWebSocket);
        return ((Interceptor)Call.this.client.interceptors().get(this.index)).intercept(paramRequest);
      }
      return Call.this.getResponse(paramRequest, this.forWebSocket);
    }
    
    public Request request()
    {
      return this.request;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final boolean forWebSocket;
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback, boolean paramBoolean)
    {
      super(new Object[] { Call.this.originalRequest.urlString() });
      this.responseCallback = paramCallback;
      this.forWebSocket = paramBoolean;
    }
    
    void cancel()
    {
      Call.this.cancel();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iload_2
      //   3: istore_1
      //   4: aload_0
      //   5: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   8: aload_0
      //   9: getfield 38	com/squareup/okhttp/Call$AsyncCall:forWebSocket	Z
      //   12: invokestatic 53	com/squareup/okhttp/Call:access$100	(Lcom/squareup/okhttp/Call;Z)Lcom/squareup/okhttp/Response;
      //   15: astore_3
      //   16: iload_2
      //   17: istore_1
      //   18: aload_0
      //   19: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   22: getfield 56	com/squareup/okhttp/Call:canceled	Z
      //   25: ifeq +45 -> 70
      //   28: iconst_1
      //   29: istore_1
      //   30: aload_0
      //   31: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   34: aload_0
      //   35: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   38: getfield 25	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
      //   41: new 49	java/io/IOException
      //   44: dup
      //   45: ldc 58
      //   47: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   50: invokeinterface 67 3 0
      //   55: aload_0
      //   56: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   59: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   62: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   65: aload_0
      //   66: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   69: return
      //   70: iconst_1
      //   71: istore_1
      //   72: aload_0
      //   73: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   76: aload_3
      //   77: invokeinterface 87 2 0
      //   82: goto -27 -> 55
      //   85: astore_3
      //   86: iload_1
      //   87: ifeq +53 -> 140
      //   90: getstatic 93	com/squareup/okhttp/internal/Internal:logger	Ljava/util/logging/Logger;
      //   93: getstatic 99	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   96: new 101	java/lang/StringBuilder
      //   99: dup
      //   100: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   103: ldc 105
      //   105: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   108: aload_0
      //   109: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   112: invokestatic 113	com/squareup/okhttp/Call:access$200	(Lcom/squareup/okhttp/Call;)Ljava/lang/String;
      //   115: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   121: aload_3
      //   122: invokevirtual 122	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   125: aload_0
      //   126: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   129: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   132: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   135: aload_0
      //   136: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   139: return
      //   140: aload_0
      //   141: getfield 36	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
      //   144: aload_0
      //   145: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   148: getfield 126	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   151: invokevirtual 132	com/squareup/okhttp/internal/http/HttpEngine:getRequest	()Lcom/squareup/okhttp/Request;
      //   154: aload_3
      //   155: invokeinterface 67 3 0
      //   160: goto -35 -> 125
      //   163: astore_3
      //   164: aload_0
      //   165: getfield 17	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
      //   168: invokestatic 71	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   171: invokevirtual 77	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
      //   174: aload_0
      //   175: invokevirtual 83	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   178: aload_3
      //   179: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	180	0	this	AsyncCall
      //   3	84	1	i	int
      //   1	16	2	j	int
      //   15	62	3	localResponse	Response
      //   85	70	3	localIOException	IOException
      //   163	16	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	16	85	java/io/IOException
      //   18	28	85	java/io/IOException
      //   30	55	85	java/io/IOException
      //   72	82	85	java/io/IOException
      //   4	16	163	finally
      //   18	28	163	finally
      //   30	55	163	finally
      //   72	82	163	finally
      //   90	125	163	finally
      //   140	160	163	finally
    }
    
    Call get()
    {
      return Call.this;
    }
    
    String host()
    {
      return Call.this.originalRequest.httpUrl().host();
    }
    
    Request request()
    {
      return Call.this.originalRequest;
    }
    
    Object tag()
    {
      return Call.this.originalRequest.tag();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */