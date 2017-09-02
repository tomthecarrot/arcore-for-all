package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpConnection
{
  private static final int ON_IDLE_CLOSE = 2;
  private static final int ON_IDLE_HOLD = 0;
  private static final int ON_IDLE_POOL = 1;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  private final Connection connection;
  private int onIdle = 0;
  private final ConnectionPool pool;
  private final BufferedSink sink;
  private final Socket socket;
  private final BufferedSource source;
  private int state = 0;
  
  public HttpConnection(ConnectionPool paramConnectionPool, Connection paramConnection, Socket paramSocket)
    throws IOException
  {
    this.pool = paramConnectionPool;
    this.connection = paramConnection;
    this.socket = paramSocket;
    this.source = Okio.buffer(Okio.source(paramSocket));
    this.sink = Okio.buffer(Okio.sink(paramSocket));
  }
  
  private void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  public long bufferSize()
  {
    return this.source.buffer().size();
  }
  
  public void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    Internal.instance.closeIfOwnedBy(this.connection, paramObject);
  }
  
  public void closeOnIdle()
    throws IOException
  {
    this.onIdle = 2;
    if (this.state == 0)
    {
      this.state = 6;
      this.connection.getSocket().close();
    }
  }
  
  public void flush()
    throws IOException
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    return this.state == 6;
  }
  
  public boolean isReadable()
  {
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        boolean bool = this.source.exhausted();
        return !bool;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
  }
  
  public Sink newChunkedSink()
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new ChunkedSink(null);
  }
  
  public Source newChunkedSource(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new ChunkedSource(paramHttpEngine);
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new FixedLengthSink(paramLong, null);
  }
  
  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new FixedLengthSource(paramLong);
  }
  
  public Source newUnknownLengthSource()
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new UnknownLengthSource(null);
  }
  
  public void poolOnIdle()
  {
    this.onIdle = 1;
    if (this.state == 0)
    {
      this.onIdle = 0;
      Internal.instance.recycle(this.pool, this.connection);
    }
  }
  
  public BufferedSink rawSink()
  {
    return this.sink;
  }
  
  public BufferedSource rawSource()
  {
    return this.source;
  }
  
  public void readHeaders(Headers.Builder paramBuilder)
    throws IOException
  {
    for (;;)
    {
      String str = this.source.readUtf8LineStrict();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLenient(paramBuilder, str);
    }
  }
  
  public Response.Builder readResponse()
    throws IOException
  {
    if ((this.state != 1) && (this.state != 3)) {
      throw new IllegalStateException("state: " + this.state);
    }
    try
    {
      StatusLine localStatusLine;
      do
      {
        localStatusLine = StatusLine.parse(this.source.readUtf8LineStrict());
        localObject = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message);
        Headers.Builder localBuilder = new Headers.Builder();
        readHeaders(localBuilder);
        localBuilder.add(OkHeaders.SELECTED_PROTOCOL, localStatusLine.protocol.toString());
        ((Response.Builder)localObject).headers(localBuilder.build());
      } while (localStatusLine.code == 100);
      this.state = 4;
      return (Response.Builder)localObject;
    }
    catch (EOFException localEOFException)
    {
      Object localObject = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + ")");
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
  }
  
  public void setTimeouts(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
    }
    if (paramInt2 != 0) {
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
    }
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state != 0) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    this.sink.writeUtf8("\r\n");
    this.state = 1;
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 3;
    paramRetryableSink.writeToSocket(this.sink);
  }
  
  private abstract class AbstractSource
    implements Source
  {
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(HttpConnection.this.source.timeout());
    
    private AbstractSource() {}
    
    protected final void endOfInput(boolean paramBoolean)
      throws IOException
    {
      if (HttpConnection.this.state != 5) {
        throw new IllegalStateException("state: " + HttpConnection.this.state);
      }
      HttpConnection.this.detachTimeout(this.timeout);
      HttpConnection.access$502(HttpConnection.this, 0);
      if ((paramBoolean) && (HttpConnection.this.onIdle == 1))
      {
        HttpConnection.access$702(HttpConnection.this, 0);
        Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
      }
      while (HttpConnection.this.onIdle != 2) {
        return;
      }
      HttpConnection.access$502(HttpConnection.this, 6);
      HttpConnection.this.connection.getSocket().close();
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    protected final void unexpectedEndOfInput()
    {
      Util.closeQuietly(HttpConnection.this.connection.getSocket());
      HttpConnection.access$502(HttpConnection.this, 6);
    }
  }
  
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(HttpConnection.this.sink.timeout());
    
    private ChunkedSink() {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 47	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 47	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   19: aload_0
      //   20: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   23: invokestatic 28	com/squareup/okhttp/internal/http/HttpConnection:access$300	(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lokio/BufferedSink;
      //   26: ldc 49
      //   28: invokeinterface 53 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   38: aload_0
      //   39: getfield 38	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:timeout	Lokio/ForwardingTimeout;
      //   42: invokestatic 57	com/squareup/okhttp/internal/http/HttpConnection:access$400	(Lcom/squareup/okhttp/internal/http/HttpConnection;Lokio/ForwardingTimeout;)V
      //   45: aload_0
      //   46: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   49: iconst_3
      //   50: invokestatic 61	com/squareup/okhttp/internal/http/HttpConnection:access$502	(Lcom/squareup/okhttp/internal/http/HttpConnection;I)I
      //   53: pop
      //   54: goto -43 -> 11
      //   57: astore_2
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_2
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   57	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	57	finally
      //   14	54	57	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 47	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 19	com/squareup/okhttp/internal/http/HttpConnection$ChunkedSink:this$0	Lcom/squareup/okhttp/internal/http/HttpConnection;
      //   18: invokestatic 28	com/squareup/okhttp/internal/http/HttpConnection:access$300	(Lcom/squareup/okhttp/internal/http/HttpConnection;)Lokio/BufferedSink;
      //   21: invokeinterface 65 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      HttpConnection.this.sink.writeHexadecimalUnsignedLong(paramLong);
      HttpConnection.this.sink.writeUtf8("\r\n");
      HttpConnection.this.sink.write(paramBuffer, paramLong);
      HttpConnection.this.sink.writeUtf8("\r\n");
    }
  }
  
  private class ChunkedSource
    extends HttpConnection.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpEngine httpEngine;
    
    ChunkedSource(HttpEngine paramHttpEngine)
      throws IOException
    {
      super(null);
      this.httpEngine = paramHttpEngine;
    }
    
    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1L) {
        HttpConnection.this.source.readUtf8LineStrict();
      }
      try
      {
        this.bytesRemainingInChunk = HttpConnection.this.source.readHexadecimalUnsignedLong();
        String str = HttpConnection.this.source.readUtf8LineStrict().trim();
        if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.bytesRemainingInChunk == 0L)
      {
        this.hasMoreChunks = false;
        Headers.Builder localBuilder = new Headers.Builder();
        HttpConnection.this.readHeaders(localBuilder);
        this.httpEngine.receiveHeaders(localBuilder.build());
        endOfInput(true);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (!this.hasMoreChunks) {
        return -1L;
      }
      if ((this.bytesRemainingInChunk == 0L) || (this.bytesRemainingInChunk == -1L))
      {
        readChunkSize();
        if (!this.hasMoreChunks) {
          return -1L;
        }
      }
      paramLong = HttpConnection.this.source.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
      if (paramLong == -1L)
      {
        unexpectedEndOfInput();
        throw new ProtocolException("unexpected end of stream");
      }
      this.bytesRemainingInChunk -= paramLong;
      return paramLong;
    }
  }
  
  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(HttpConnection.this.sink.timeout());
    
    private FixedLengthSink(long paramLong)
    {
      this.bytesRemaining = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      if (this.bytesRemaining > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      HttpConnection.this.detachTimeout(this.timeout);
      HttpConnection.access$502(HttpConnection.this, 3);
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      HttpConnection.this.sink.flush();
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong > this.bytesRemaining) {
        throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
      }
      HttpConnection.this.sink.write(paramBuffer, paramLong);
      this.bytesRemaining -= paramLong;
    }
  }
  
  private class FixedLengthSource
    extends HttpConnection.AbstractSource
  {
    private long bytesRemaining;
    
    public FixedLengthSource(long paramLong)
      throws IOException
    {
      super(null);
      this.bytesRemaining = paramLong;
      if (this.bytesRemaining == 0L) {
        endOfInput(true);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.bytesRemaining == 0L) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = HttpConnection.this.source.read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
        if (l == -1L)
        {
          unexpectedEndOfInput();
          throw new ProtocolException("unexpected end of stream");
        }
        this.bytesRemaining -= l;
        paramLong = l;
      } while (this.bytesRemaining != 0L);
      endOfInput(true);
      return l;
    }
  }
  
  private class UnknownLengthSource
    extends HttpConnection.AbstractSource
  {
    private boolean inputExhausted;
    
    private UnknownLengthSource()
    {
      super(null);
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if (!this.inputExhausted) {
        unexpectedEndOfInput();
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.inputExhausted) {
        paramLong = -1L;
      }
      long l;
      do
      {
        return paramLong;
        l = HttpConnection.this.source.read(paramBuffer, paramLong);
        paramLong = l;
      } while (l != -1L);
      this.inputExhausted = true;
      endOfInput(false);
      return -1L;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */