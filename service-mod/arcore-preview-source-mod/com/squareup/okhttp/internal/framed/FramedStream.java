package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream
{
  long bytesLeftInWriteWindow;
  private final FramedConnection connection;
  private ErrorCode errorCode = null;
  private final int id;
  private final StreamTimeout readTimeout = new StreamTimeout();
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final FramedDataSink sink;
  private final FramedDataSource source;
  long unacknowledgedBytesRead = 0L;
  private final StreamTimeout writeTimeout = new StreamTimeout();
  
  static
  {
    if (!FramedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramFramedConnection == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.id = paramInt;
    this.connection = paramFramedConnection;
    this.bytesLeftInWriteWindow = paramFramedConnection.peerSettings.getInitialWindowSize(65536);
    this.source = new FramedDataSource(paramFramedConnection.okHttpSettings.getInitialWindowSize(65536), null);
    this.sink = new FramedDataSink();
    FramedDataSource.access$102(this.source, paramBoolean2);
    FramedDataSink.access$202(this.sink, paramBoolean1);
    this.requestHeaders = paramList;
  }
  
  private void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished) {
            break label112;
          }
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0) {
              break label95;
            }
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.connection.removeStream(this.id);
      return;
      label112:
      int i = 1;
    }
  }
  
  private void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed) {
      throw new IOException("stream closed");
    }
    if (this.sink.finished) {
      throw new IOException("stream finished");
    }
    if (this.errorCode != null) {
      throw new IOException("stream was reset: " + this.errorCode);
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
    }
    finally {}
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }
  
  private void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InterruptedIOException();
    }
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public FramedConnection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  /* Error */
  public List<Header> getResponseHeaders()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/squareup/okhttp/internal/framed/FramedStream:readTimeout	Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   6: invokevirtual 236	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 238	com/squareup/okhttp/internal/framed/FramedStream:responseHeaders	Ljava/util/List;
    //   13: ifnonnull +32 -> 45
    //   16: aload_0
    //   17: getfield 63	com/squareup/okhttp/internal/framed/FramedStream:errorCode	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   20: ifnonnull +25 -> 45
    //   23: aload_0
    //   24: invokespecial 140	com/squareup/okhttp/internal/framed/FramedStream:waitForIo	()V
    //   27: goto -18 -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 59	com/squareup/okhttp/internal/framed/FramedStream:readTimeout	Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   35: invokevirtual 241	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield 59	com/squareup/okhttp/internal/framed/FramedStream:readTimeout	Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   49: invokevirtual 241	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   52: aload_0
    //   53: getfield 238	com/squareup/okhttp/internal/framed/FramedStream:responseHeaders	Ljava/util/List;
    //   56: ifnull +12 -> 68
    //   59: aload_0
    //   60: getfield 238	com/squareup/okhttp/internal/framed/FramedStream:responseHeaders	Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 117	java/io/IOException
    //   71: dup
    //   72: new 186	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   79: ldc -67
    //   81: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 63	com/squareup/okhttp/internal/framed/FramedStream:errorCode	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   88: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 182	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	FramedStream
    //   30	9	1	localObject1	Object
    //   40	4	1	localObject2	Object
    //   63	4	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   9	27	30	finally
    //   2	9	40	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	98	40	finally
  }
  
  public Sink getSink()
  {
    try
    {
      if ((this.responseHeaders == null) && (!isLocallyInitiated())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.sink;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.connection.client == i; i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 63	com/squareup/okhttp/internal/framed/FramedStream:errorCode	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 99	com/squareup/okhttp/internal/framed/FramedStream:source	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   21: invokestatic 153	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:access$100	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 99	com/squareup/okhttp/internal/framed/FramedStream:source	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;
    //   31: invokestatic 156	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:access$300	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSource;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 102	com/squareup/okhttp/internal/framed/FramedStream:sink	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   41: invokestatic 160	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:access$200	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 102	com/squareup/okhttp/internal/framed/FramedStream:sink	Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;
    //   51: invokestatic 163	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:access$400	(Lcom/squareup/okhttp/internal/framed/FramedStream$FramedDataSink;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 238	com/squareup/okhttp/internal/framed/FramedStream:responseHeaders	Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FramedStream
    //   1	67	1	bool	boolean
    //   8	55	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      FramedDataSource.access$102(this.source, true);
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList, HeadersMode paramHeadersMode)
  {
    assert (!Thread.holdsLock(this));
    Object localObject = null;
    boolean bool = true;
    label97:
    do
    {
      for (;;)
      {
        try
        {
          if (this.responseHeaders == null)
          {
            if (paramHeadersMode.failIfHeadersAbsent())
            {
              paramList = ErrorCode.PROTOCOL_ERROR;
              if (paramList == null) {
                break;
              }
              closeLater(paramList);
              return;
            }
            this.responseHeaders = paramList;
            bool = isOpen();
            notifyAll();
            paramList = (List<Header>)localObject;
            continue;
          }
          if (!paramHeadersMode.failIfHeadersPresent()) {
            break label97;
          }
        }
        finally {}
        paramList = ErrorCode.STREAM_IN_USE;
        continue;
        paramHeadersMode = new ArrayList();
        paramHeadersMode.addAll(this.responseHeaders);
        paramHeadersMode.addAll(paramList);
        this.responseHeaders = paramHeadersMode;
        paramList = (List<Header>)localObject;
      }
    } while (bool);
    this.connection.removeStream(this.id);
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void reply(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    boolean bool = false;
    if (paramList == null) {
      try
      {
        throw new NullPointerException("responseHeaders == null");
      }
      finally {}
    }
    if (this.responseHeaders != null) {
      throw new IllegalStateException("reply already sent");
    }
    this.responseHeaders = paramList;
    if (!paramBoolean)
    {
      FramedDataSink.access$202(this.sink, true);
      bool = true;
    }
    this.connection.writeSynReply(this.id, bool, paramList);
    if (bool) {
      this.connection.flush();
    }
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class FramedDataSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer = new Buffer();
    
    static
    {
      if (!FramedStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    FramedDataSink() {}
    
    /* Error */
    private void emitDataFrame(boolean paramBoolean)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   13: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   16: invokevirtual 65	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   19: aload_0
      //   20: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   23: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   26: lconst_0
      //   27: lcmp
      //   28: ifgt +60 -> 88
      //   31: aload_0
      //   32: getfield 47	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:finished	Z
      //   35: ifne +53 -> 88
      //   38: aload_0
      //   39: getfield 52	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:closed	Z
      //   42: ifne +46 -> 88
      //   45: aload_0
      //   46: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   49: invokestatic 72	com/squareup/okhttp/internal/framed/FramedStream:access$800	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   52: ifnonnull +36 -> 88
      //   55: aload_0
      //   56: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   59: invokestatic 75	com/squareup/okhttp/internal/framed/FramedStream:access$900	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   62: goto -43 -> 19
      //   65: astore 6
      //   67: aload_0
      //   68: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   71: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   74: invokevirtual 78	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   77: aload 6
      //   79: athrow
      //   80: astore 6
      //   82: aload 5
      //   84: monitorexit
      //   85: aload 6
      //   87: athrow
      //   88: aload_0
      //   89: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   92: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   95: invokevirtual 78	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   98: aload_0
      //   99: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   102: invokestatic 81	com/squareup/okhttp/internal/framed/FramedStream:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   105: aload_0
      //   106: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   109: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   112: aload_0
      //   113: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   116: invokevirtual 85	okio/Buffer:size	()J
      //   119: invokestatic 91	java/lang/Math:min	(JJ)J
      //   122: lstore_3
      //   123: aload_0
      //   124: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   127: astore 6
      //   129: aload 6
      //   131: aload 6
      //   133: getfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   136: lload_3
      //   137: lsub
      //   138: putfield 68	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
      //   141: aload 5
      //   143: monitorexit
      //   144: aload_0
      //   145: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   148: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   151: invokevirtual 65	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   154: aload_0
      //   155: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   158: invokestatic 95	com/squareup/okhttp/internal/framed/FramedStream:access$500	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   161: astore 5
      //   163: aload_0
      //   164: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   167: invokestatic 99	com/squareup/okhttp/internal/framed/FramedStream:access$600	(Lcom/squareup/okhttp/internal/framed/FramedStream;)I
      //   170: istore_2
      //   171: iload_1
      //   172: ifeq +40 -> 212
      //   175: lload_3
      //   176: aload_0
      //   177: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   180: invokevirtual 85	okio/Buffer:size	()J
      //   183: lcmp
      //   184: ifne +28 -> 212
      //   187: iconst_1
      //   188: istore_1
      //   189: aload 5
      //   191: iload_2
      //   192: iload_1
      //   193: aload_0
      //   194: getfield 43	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
      //   197: lload_3
      //   198: invokevirtual 105	com/squareup/okhttp/internal/framed/FramedConnection:writeData	(IZLokio/Buffer;J)V
      //   201: aload_0
      //   202: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   205: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   208: invokevirtual 78	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   211: return
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -25 -> 189
      //   217: astore 5
      //   219: aload_0
      //   220: getfield 36	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   223: invokestatic 60	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   226: invokevirtual 78	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   229: aload 5
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	FramedDataSink
      //   0	232	1	paramBoolean	boolean
      //   170	22	2	i	int
      //   122	76	3	l	long
      //   4	186	5	localObject1	Object
      //   217	13	5	localObject2	Object
      //   65	13	6	localObject3	Object
      //   80	6	6	localObject4	Object
      //   127	5	6	localFramedStream	FramedStream
      // Exception table:
      //   from	to	target	type
      //   19	62	65	finally
      //   9	19	80	finally
      //   67	80	80	finally
      //   82	85	80	finally
      //   88	144	80	finally
      //   154	171	217	finally
      //   175	187	217	finally
      //   189	201	217	finally
    }
    
    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      synchronized (FramedStream.this)
      {
        if (this.closed) {
          return;
        }
        if (FramedStream.this.sink.finished) {
          break label113;
        }
        if (this.sendBuffer.size() > 0L)
        {
          if (this.sendBuffer.size() <= 0L) {
            break label113;
          }
          emitDataFrame(true);
        }
      }
      FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0L);
      label113:
      synchronized (FramedStream.this)
      {
        this.closed = true;
        FramedStream.this.connection.flush();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      }
    }
    
    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      synchronized (FramedStream.this)
      {
        FramedStream.this.checkOutNotClosed();
        if (this.sendBuffer.size() > 0L)
        {
          emitDataFrame(false);
          FramedStream.this.connection.flush();
        }
      }
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.writeTimeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      assert (!Thread.holdsLock(FramedStream.this));
      this.sendBuffer.write(paramBuffer, paramLong);
      while (this.sendBuffer.size() >= 16384L) {
        emitDataFrame(false);
      }
    }
  }
  
  private final class FramedDataSource
    implements Source
  {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    static
    {
      if (!FramedStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    private FramedDataSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    private void checkNotClosed()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("stream closed");
      }
      if (FramedStream.this.errorCode != null) {
        throw new IOException("stream was reset: " + FramedStream.this.errorCode);
      }
    }
    
    /* Error */
    private void waitUntilReadable()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   4: invokestatic 92	com/squareup/okhttp/internal/framed/FramedStream:access$700	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   7: invokevirtual 97	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
      //   10: aload_0
      //   11: getfield 44	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:readBuffer	Lokio/Buffer;
      //   14: invokevirtual 101	okio/Buffer:size	()J
      //   17: lconst_0
      //   18: lcmp
      //   19: ifne +50 -> 69
      //   22: aload_0
      //   23: getfield 53	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:finished	Z
      //   26: ifne +43 -> 69
      //   29: aload_0
      //   30: getfield 58	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:closed	Z
      //   33: ifne +36 -> 69
      //   36: aload_0
      //   37: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   40: invokestatic 70	com/squareup/okhttp/internal/framed/FramedStream:access$800	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   43: ifnonnull +26 -> 69
      //   46: aload_0
      //   47: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   50: invokestatic 105	com/squareup/okhttp/internal/framed/FramedStream:access$900	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
      //   53: goto -43 -> 10
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   61: invokestatic 92	com/squareup/okhttp/internal/framed/FramedStream:access$700	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   64: invokevirtual 108	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   67: aload_1
      //   68: athrow
      //   69: aload_0
      //   70: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSource:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   73: invokestatic 92	com/squareup/okhttp/internal/framed/FramedStream:access$700	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
      //   76: invokevirtual 108	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	FramedDataSource
      //   56	12	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   10	53	56	finally
    }
    
    public void close()
      throws IOException
    {
      synchronized (FramedStream.this)
      {
        this.closed = true;
        this.readBuffer.clear();
        FramedStream.this.notifyAll();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (FramedStream.this)
      {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.size() == 0L) {
          return -1L;
        }
        paramLong = this.readBuffer.read(???, Math.min(paramLong, this.readBuffer.size()));
        ??? = FramedStream.this;
        ???.unacknowledgedBytesRead += paramLong;
        if (FramedStream.this.unacknowledgedBytesRead >= FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
        {
          FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
          FramedStream.this.unacknowledgedBytesRead = 0L;
        }
        synchronized (FramedStream.this.connection)
        {
          ??? = FramedStream.this.connection;
          ((FramedConnection)???).unacknowledgedBytesRead += paramLong;
          if (FramedStream.this.connection.unacknowledgedBytesRead >= FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)
          {
            FramedStream.this.connection.writeWindowUpdateLater(0, FramedStream.this.connection.unacknowledgedBytesRead);
            FramedStream.this.connection.unacknowledgedBytesRead = 0L;
          }
          return paramLong;
        }
      }
    }
    
    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!$assertionsDisabled)
      {
        l = paramLong;
        if (Thread.holdsLock(FramedStream.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (FramedStream.this)
        {
          if (this.readBuffer.size() == 0L)
          {
            i = 1;
            this.readBuffer.writeAll(this.receiveBuffer);
            if (i != 0) {
              FramedStream.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (FramedStream.this)
            {
              bool = this.finished;
              if (this.readBuffer.size() + l > this.maxByteCount)
              {
                i = 1;
                if (i != 0)
                {
                  paramBufferedSource.skip(l);
                  FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramBufferedSource.skip(l);
              return;
            }
            paramLong = paramBufferedSource.read(this.receiveBuffer, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.readTimeout;
    }
  }
  
  class StreamTimeout
    extends AsyncTimeout
  {
    StreamTimeout() {}
    
    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (exit()) {
        throw newTimeoutException(null);
      }
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void timedOut()
    {
      FramedStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/framed/FramedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */