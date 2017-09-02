package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.util.concurrent.SettableFuture;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.HttpUrl.Builder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.internal.ClientTransport.PingCallback;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.GrpcUtil.Http2Error;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.LogId;
import io.grpc.internal.ManagedClientTransport.Listener;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameReader.Handler;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

class OkHttpClientTransport
  implements ConnectionClientTransport
{
  private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];
  private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = ;
  private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
  private final InetSocketAddress address;
  private ClientFrameHandler clientFrameHandler;
  SettableFuture<Void> connectedFuture;
  Runnable connectingCallback;
  private final ConnectionSpec connectionSpec;
  private int connectionUnacknowledgedBytesRead;
  private final String defaultAuthority;
  private boolean enableKeepAlive;
  private final Executor executor;
  private AsyncFrameWriter frameWriter;
  @GuardedBy("lock")
  private boolean goAwaySent;
  @GuardedBy("lock")
  private Status goAwayStatus;
  @GuardedBy("lock")
  private boolean inUse;
  private long keepAliveDelayNanos;
  private KeepAliveManager keepAliveManager;
  private long keepAliveTimeoutNanos;
  private ManagedClientTransport.Listener listener;
  private final Object lock = new Object();
  private final LogId logId = LogId.allocate(getClass().getName());
  @GuardedBy("lock")
  private int maxConcurrentStreams = 0;
  private final int maxMessageSize;
  @GuardedBy("lock")
  private int nextStreamId;
  private OutboundFlowController outboundFlow;
  @GuardedBy("lock")
  private LinkedList<OkHttpClientStream> pendingStreams = new LinkedList();
  @GuardedBy("lock")
  private Http2Ping ping;
  @Nullable
  private final InetSocketAddress proxyAddress;
  @Nullable
  private final String proxyPassword;
  @Nullable
  private final String proxyUsername;
  private final Random random = new Random();
  private ScheduledExecutorService scheduler;
  private final SerializingExecutor serializingExecutor;
  private Socket socket;
  private SSLSocketFactory sslSocketFactory;
  @GuardedBy("lock")
  private boolean stopped;
  @GuardedBy("lock")
  private final Map<Integer, OkHttpClientStream> streams = new HashMap();
  private FrameReader testFrameReader;
  private FrameWriter testFrameWriter;
  private final Ticker ticker;
  private final String userAgent;
  
  @VisibleForTesting
  OkHttpClientTransport(String paramString, Executor paramExecutor, FrameReader paramFrameReader, FrameWriter paramFrameWriter, int paramInt1, Socket paramSocket, Ticker paramTicker, @Nullable Runnable paramRunnable, SettableFuture<Void> paramSettableFuture, int paramInt2)
  {
    this.address = null;
    this.maxMessageSize = paramInt2;
    this.defaultAuthority = "notarealauthority:80";
    this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", paramString);
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor, "executor"));
    this.serializingExecutor = new SerializingExecutor(paramExecutor);
    this.testFrameReader = ((FrameReader)Preconditions.checkNotNull(paramFrameReader, "frameReader"));
    this.testFrameWriter = ((FrameWriter)Preconditions.checkNotNull(paramFrameWriter, "testFrameWriter"));
    this.socket = ((Socket)Preconditions.checkNotNull(paramSocket, "socket"));
    this.nextStreamId = paramInt1;
    this.ticker = paramTicker;
    this.connectionSpec = null;
    this.connectingCallback = paramRunnable;
    this.connectedFuture = ((SettableFuture)Preconditions.checkNotNull(paramSettableFuture, "connectedFuture"));
    this.proxyAddress = null;
    this.proxyUsername = null;
    this.proxyPassword = null;
  }
  
  OkHttpClientTransport(InetSocketAddress paramInetSocketAddress1, String paramString1, @Nullable String paramString2, Executor paramExecutor, @Nullable SSLSocketFactory paramSSLSocketFactory, ConnectionSpec paramConnectionSpec, int paramInt, @Nullable InetSocketAddress paramInetSocketAddress2, @Nullable String paramString3, @Nullable String paramString4)
  {
    this.address = ((InetSocketAddress)Preconditions.checkNotNull(paramInetSocketAddress1, "address"));
    this.defaultAuthority = paramString1;
    this.maxMessageSize = paramInt;
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor, "executor"));
    this.serializingExecutor = new SerializingExecutor(paramExecutor);
    this.nextStreamId = 3;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.connectionSpec = ((ConnectionSpec)Preconditions.checkNotNull(paramConnectionSpec, "connectionSpec"));
    this.ticker = Ticker.systemTicker();
    this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", paramString2);
    this.proxyAddress = paramInetSocketAddress2;
    this.proxyUsername = paramString3;
    this.proxyPassword = paramString4;
  }
  
  private static Map<ErrorCode, Status> buildErrorCodeToStatusMap()
  {
    EnumMap localEnumMap = new EnumMap(ErrorCode.class);
    localEnumMap.put(ErrorCode.NO_ERROR, Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
    localEnumMap.put(ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("Protocol error"));
    localEnumMap.put(ErrorCode.INTERNAL_ERROR, Status.INTERNAL.withDescription("Internal error"));
    localEnumMap.put(ErrorCode.FLOW_CONTROL_ERROR, Status.INTERNAL.withDescription("Flow control error"));
    localEnumMap.put(ErrorCode.STREAM_CLOSED, Status.INTERNAL.withDescription("Stream closed"));
    localEnumMap.put(ErrorCode.FRAME_TOO_LARGE, Status.INTERNAL.withDescription("Frame too large"));
    localEnumMap.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
    localEnumMap.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
    localEnumMap.put(ErrorCode.COMPRESSION_ERROR, Status.INTERNAL.withDescription("Compression error"));
    localEnumMap.put(ErrorCode.CONNECT_ERROR, Status.INTERNAL.withDescription("Connect error"));
    localEnumMap.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
    localEnumMap.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
    return Collections.unmodifiableMap(localEnumMap);
  }
  
  private Request createHttpProxyRequest(InetSocketAddress paramInetSocketAddress, String paramString1, String paramString2)
  {
    paramInetSocketAddress = new HttpUrl.Builder().scheme("https").host(paramInetSocketAddress.getHostName()).port(paramInetSocketAddress.getPort()).build();
    paramInetSocketAddress = new Request.Builder().url(paramInetSocketAddress).header("Host", paramInetSocketAddress.host() + ":" + paramInetSocketAddress.port()).header("User-Agent", this.userAgent);
    if ((paramString1 != null) && (paramString2 != null)) {
      paramInetSocketAddress.header("Proxy-Authorization", Credentials.basic(paramString1, paramString2));
    }
    return paramInetSocketAddress.build();
  }
  
  /* Error */
  private Socket createHttpProxySocket(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, String paramString1, String paramString2)
    throws IOException, StatusException
  {
    // Byte code:
    //   0: new 205	java/net/Socket
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 519	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   8: aload_2
    //   9: invokevirtual 461	java/net/InetSocketAddress:getPort	()I
    //   12: invokespecial 522	java/net/Socket:<init>	(Ljava/net/InetAddress;I)V
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_1
    //   18: invokevirtual 526	java/net/Socket:setTcpNoDelay	(Z)V
    //   21: aload_2
    //   22: invokestatic 532	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   25: astore 7
    //   27: aload_2
    //   28: invokestatic 536	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   31: invokestatic 540	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   34: astore 8
    //   36: aload_0
    //   37: aload_1
    //   38: aload_3
    //   39: aload 4
    //   41: invokespecial 542	io/grpc/okhttp/OkHttpClientTransport:createHttpProxyRequest	(Ljava/net/InetSocketAddress;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request;
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 547	com/squareup/okhttp/Request:httpUrl	()Lcom/squareup/okhttp/HttpUrl;
    //   49: astore_3
    //   50: aload 8
    //   52: ldc_w 549
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_3
    //   62: invokevirtual 485	com/squareup/okhttp/HttpUrl:host	()Ljava/lang/String;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_3
    //   69: invokevirtual 493	com/squareup/okhttp/HttpUrl:port	()I
    //   72: invokestatic 555	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokestatic 561	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokeinterface 567 2 0
    //   84: ldc_w 569
    //   87: invokeinterface 567 2 0
    //   92: pop
    //   93: iconst_0
    //   94: istore 5
    //   96: aload_1
    //   97: invokevirtual 573	com/squareup/okhttp/Request:headers	()Lcom/squareup/okhttp/Headers;
    //   100: invokevirtual 578	com/squareup/okhttp/Headers:size	()I
    //   103: istore 6
    //   105: iload 5
    //   107: iload 6
    //   109: if_icmpge +59 -> 168
    //   112: aload 8
    //   114: aload_1
    //   115: invokevirtual 573	com/squareup/okhttp/Request:headers	()Lcom/squareup/okhttp/Headers;
    //   118: iload 5
    //   120: invokevirtual 582	com/squareup/okhttp/Headers:name	(I)Ljava/lang/String;
    //   123: invokeinterface 567 2 0
    //   128: ldc_w 584
    //   131: invokeinterface 567 2 0
    //   136: aload_1
    //   137: invokevirtual 573	com/squareup/okhttp/Request:headers	()Lcom/squareup/okhttp/Headers;
    //   140: iload 5
    //   142: invokevirtual 586	com/squareup/okhttp/Headers:value	(I)Ljava/lang/String;
    //   145: invokeinterface 567 2 0
    //   150: ldc_w 569
    //   153: invokeinterface 567 2 0
    //   158: pop
    //   159: iload 5
    //   161: iconst_1
    //   162: iadd
    //   163: istore 5
    //   165: goto -60 -> 105
    //   168: aload 8
    //   170: ldc_w 569
    //   173: invokeinterface 567 2 0
    //   178: pop
    //   179: aload 8
    //   181: invokeinterface 589 1 0
    //   186: aload 7
    //   188: invokestatic 593	io/grpc/okhttp/OkHttpClientTransport:readUtf8LineStrictUnbuffered	(Lokio/Source;)Ljava/lang/String;
    //   191: invokestatic 599	com/squareup/okhttp/internal/http/StatusLine:parse	(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/StatusLine;
    //   194: astore_1
    //   195: aload 7
    //   197: invokestatic 593	io/grpc/okhttp/OkHttpClientTransport:readUtf8LineStrictUnbuffered	(Lokio/Source;)Ljava/lang/String;
    //   200: ldc_w 601
    //   203: invokevirtual 605	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifeq -11 -> 195
    //   209: aload_1
    //   210: getfield 608	com/squareup/okhttp/internal/http/StatusLine:code	I
    //   213: sipush 200
    //   216: if_icmplt +13 -> 229
    //   219: aload_1
    //   220: getfield 608	com/squareup/okhttp/internal/http/StatusLine:code	I
    //   223: sipush 300
    //   226: if_icmplt +133 -> 359
    //   229: new 610	okio/Buffer
    //   232: dup
    //   233: invokespecial 611	okio/Buffer:<init>	()V
    //   236: astore_3
    //   237: aload_2
    //   238: invokevirtual 614	java/net/Socket:shutdownOutput	()V
    //   241: aload 7
    //   243: aload_3
    //   244: ldc2_w 615
    //   247: invokeinterface 622 4 0
    //   252: pop2
    //   253: aload_2
    //   254: invokevirtual 625	java/net/Socket:close	()V
    //   257: ldc_w 627
    //   260: iconst_3
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_1
    //   267: getfield 608	com/squareup/okhttp/internal/http/StatusLine:code	I
    //   270: invokestatic 555	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: aload_1
    //   277: getfield 630	com/squareup/okhttp/internal/http/StatusLine:message	Ljava/lang/String;
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: aload_3
    //   284: invokevirtual 633	okio/Buffer:readUtf8	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 561	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   291: astore_1
    //   292: getstatic 397	io/grpc/Status:UNAVAILABLE	Lio/grpc/Status;
    //   295: aload_1
    //   296: invokevirtual 361	io/grpc/Status:withDescription	(Ljava/lang/String;)Lio/grpc/Status;
    //   299: invokevirtual 637	io/grpc/Status:asException	()Lio/grpc/StatusException;
    //   302: athrow
    //   303: astore_1
    //   304: getstatic 397	io/grpc/Status:UNAVAILABLE	Lio/grpc/Status;
    //   307: ldc_w 639
    //   310: invokevirtual 361	io/grpc/Status:withDescription	(Ljava/lang/String;)Lio/grpc/Status;
    //   313: aload_1
    //   314: invokevirtual 643	io/grpc/Status:withCause	(Ljava/lang/Throwable;)Lio/grpc/Status;
    //   317: invokevirtual 637	io/grpc/Status:asException	()Lio/grpc/StatusException;
    //   320: athrow
    //   321: astore 4
    //   323: aload_3
    //   324: new 480	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 645
    //   334: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 4
    //   339: invokevirtual 646	java/io/IOException:toString	()Ljava/lang/String;
    //   342: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 649	okio/Buffer:writeUtf8	(Ljava/lang/String;)Lokio/Buffer;
    //   351: pop
    //   352: goto -99 -> 253
    //   355: astore_2
    //   356: goto -99 -> 257
    //   359: aload_2
    //   360: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	OkHttpClientTransport
    //   0	361	1	paramInetSocketAddress1	InetSocketAddress
    //   0	361	2	paramInetSocketAddress2	InetSocketAddress
    //   0	361	3	paramString1	String
    //   0	361	4	paramString2	String
    //   94	70	5	i	int
    //   103	7	6	j	int
    //   25	217	7	localSource	Source
    //   34	146	8	localBufferedSink	okio.BufferedSink
    // Exception table:
    //   from	to	target	type
    //   0	93	303	java/io/IOException
    //   96	105	303	java/io/IOException
    //   112	159	303	java/io/IOException
    //   168	195	303	java/io/IOException
    //   195	229	303	java/io/IOException
    //   229	237	303	java/io/IOException
    //   257	303	303	java/io/IOException
    //   323	352	303	java/io/IOException
    //   237	253	321	java/io/IOException
    //   253	257	355	java/io/IOException
  }
  
  private Throwable getPingFailure()
  {
    synchronized (this.lock)
    {
      if (this.goAwayStatus != null)
      {
        localStatusException = this.goAwayStatus.asException();
        return localStatusException;
      }
      StatusException localStatusException = Status.UNAVAILABLE.withDescription("Connection closed").asException();
      return localStatusException;
    }
  }
  
  private boolean isForTest()
  {
    return this.address == null;
  }
  
  @GuardedBy("lock")
  private void maybeClearInUse()
  {
    if ((this.inUse) && (this.pendingStreams.isEmpty()) && (this.streams.isEmpty()))
    {
      this.inUse = false;
      this.listener.transportInUse(false);
      if (this.keepAliveManager != null) {
        this.keepAliveManager.onTransportIdle();
      }
    }
  }
  
  private void onError(ErrorCode paramErrorCode, String paramString)
  {
    startGoAway(0, paramErrorCode, toGrpcStatus(paramErrorCode).augmentDescription(paramString));
  }
  
  private static String readUtf8LineStrictUnbuffered(Source paramSource)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    do
    {
      if (paramSource.read(localBuffer, 1L) == -1L) {
        throw new EOFException("\\n not found: " + localBuffer.readByteString().hex());
      }
    } while (localBuffer.getByte(localBuffer.size() - 1L) != 10);
    return localBuffer.readUtf8LineStrict();
  }
  
  @GuardedBy("lock")
  private void setInUse()
  {
    if (!this.inUse)
    {
      this.inUse = true;
      this.listener.transportInUse(true);
      if (this.keepAliveManager != null) {
        this.keepAliveManager.onTransportActive();
      }
    }
  }
  
  private void startGoAway(int paramInt, ErrorCode paramErrorCode, Status paramStatus)
  {
    synchronized (this.lock)
    {
      if (this.goAwayStatus == null)
      {
        this.goAwayStatus = paramStatus;
        this.listener.transportShutdown(paramStatus);
      }
      if ((paramErrorCode != null) && (!this.goAwaySent))
      {
        this.goAwaySent = true;
        this.frameWriter.goAway(0, paramErrorCode, new byte[0]);
      }
      paramErrorCode = this.streams.entrySet().iterator();
      while (paramErrorCode.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramErrorCode.next();
        if (((Integer)localEntry.getKey()).intValue() > paramInt)
        {
          paramErrorCode.remove();
          ((OkHttpClientStream)localEntry.getValue()).transportReportStatus(paramStatus, false, new Metadata());
        }
      }
    }
    paramErrorCode = this.pendingStreams.iterator();
    while (paramErrorCode.hasNext()) {
      ((OkHttpClientStream)paramErrorCode.next()).transportReportStatus(paramStatus, true, new Metadata());
    }
    this.pendingStreams.clear();
    maybeClearInUse();
    stopIfNecessary();
  }
  
  @GuardedBy("lock")
  private boolean startPendingStreams()
  {
    for (boolean bool = false; (!this.pendingStreams.isEmpty()) && (this.streams.size() < this.maxConcurrentStreams); bool = true) {
      startStream((OkHttpClientStream)this.pendingStreams.poll());
    }
    return bool;
  }
  
  @GuardedBy("lock")
  private void startStream(OkHttpClientStream paramOkHttpClientStream)
  {
    if (paramOkHttpClientStream.id() == -1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "StreamId already assigned");
      this.streams.put(Integer.valueOf(this.nextStreamId), paramOkHttpClientStream);
      setInUse();
      paramOkHttpClientStream.start(this.nextStreamId);
      paramOkHttpClientStream.allocated();
      if ((paramOkHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY) && (paramOkHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING)) {
        this.frameWriter.flush();
      }
      if (this.nextStreamId < 2147483645) {
        break;
      }
      this.nextStreamId = Integer.MAX_VALUE;
      startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
      return;
    }
    this.nextStreamId += 2;
  }
  
  @VisibleForTesting
  static Status toGrpcStatus(ErrorCode paramErrorCode)
  {
    Status localStatus = (Status)ERROR_CODE_TO_STATUS.get(paramErrorCode);
    if (localStatus != null) {
      return localStatus;
    }
    return Status.UNKNOWN.withDescription("Unknown http2 error code: " + paramErrorCode.httpCode);
  }
  
  void enableKeepAlive(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.enableKeepAlive = paramBoolean;
    this.keepAliveDelayNanos = paramLong1;
    this.keepAliveTimeoutNanos = paramLong2;
  }
  
  void finishStream(int paramInt, @Nullable Status paramStatus, @Nullable ErrorCode paramErrorCode)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        OkHttpClientStream localOkHttpClientStream = (OkHttpClientStream)this.streams.remove(Integer.valueOf(paramInt));
        if (localOkHttpClientStream != null)
        {
          if (paramErrorCode != null) {
            this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL);
          }
          if (paramStatus != null)
          {
            if (paramStatus.getCode() == Status.Code.CANCELLED) {
              break label114;
            }
            if (paramStatus.getCode() != Status.Code.DEADLINE_EXCEEDED) {
              break label120;
            }
            break label114;
            localOkHttpClientStream.transportReportStatus(paramStatus, bool, new Metadata());
          }
          if (!startPendingStreams())
          {
            stopIfNecessary();
            maybeClearInUse();
          }
        }
        return;
      }
      label114:
      boolean bool = true;
      continue;
      label120:
      bool = false;
    }
  }
  
  OkHttpClientStream[] getActiveStreams()
  {
    synchronized (this.lock)
    {
      OkHttpClientStream[] arrayOfOkHttpClientStream = (OkHttpClientStream[])this.streams.values().toArray(EMPTY_STREAM_ARRAY);
      return arrayOfOkHttpClientStream;
    }
  }
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  @VisibleForTesting
  ClientFrameHandler getHandler()
  {
    return this.clientFrameHandler;
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  @VisibleForTesting
  String getOverridenHost()
  {
    URI localURI = GrpcUtil.authorityToUri(this.defaultAuthority);
    if (localURI.getHost() != null) {
      return localURI.getHost();
    }
    return this.defaultAuthority;
  }
  
  @VisibleForTesting
  int getOverridenPort()
  {
    URI localURI = GrpcUtil.authorityToUri(this.defaultAuthority);
    if (localURI.getPort() != -1) {
      return localURI.getPort();
    }
    return this.address.getPort();
  }
  
  @VisibleForTesting
  int getPendingStreamSize()
  {
    synchronized (this.lock)
    {
      int i = this.pendingStreams.size();
      return i;
    }
  }
  
  OkHttpClientStream getStream(int paramInt)
  {
    synchronized (this.lock)
    {
      OkHttpClientStream localOkHttpClientStream = (OkHttpClientStream)this.streams.get(Integer.valueOf(paramInt));
      return localOkHttpClientStream;
    }
  }
  
  boolean mayHaveCreatedStream(int paramInt)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.lock)
      {
        if ((paramInt < this.nextStreamId) && ((paramInt & 0x1) == 1)) {
          return bool;
        }
      }
    }
  }
  
  public OkHttpClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata)
  {
    return newStream(paramMethodDescriptor, paramMetadata, CallOptions.DEFAULT, StatsTraceContext.NOOP);
  }
  
  public OkHttpClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    Preconditions.checkNotNull(paramMethodDescriptor, "method");
    Preconditions.checkNotNull(paramMetadata, "headers");
    Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx");
    return new OkHttpClientStream(paramMethodDescriptor, paramMetadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.defaultAuthority, this.userAgent, paramStatsTraceContext);
  }
  
  void onException(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable, "failureCause");
    paramThrowable = Status.UNAVAILABLE.withCause(paramThrowable);
    startGoAway(0, ErrorCode.INTERNAL_ERROR, paramThrowable);
  }
  
  public void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor)
  {
    if (this.frameWriter != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      long l = 0L;
      synchronized (this.lock)
      {
        if (this.stopped)
        {
          Http2Ping.notifyFailed(paramPingCallback, paramExecutor, getPingFailure());
          return;
        }
        if (this.ping != null)
        {
          localHttp2Ping = this.ping;
          i = 0;
          if (i != 0) {
            this.frameWriter.ping(false, (int)(l >>> 32), (int)l);
          }
          localHttp2Ping.addCallback(paramPingCallback, paramExecutor);
          return;
        }
        l = this.random.nextLong();
        Http2Ping localHttp2Ping = new Http2Ping(l, Stopwatch.createStarted(this.ticker));
        this.ping = localHttp2Ping;
        int i = 1;
      }
    }
  }
  
  @GuardedBy("lock")
  void removePendingStream(OkHttpClientStream paramOkHttpClientStream)
  {
    this.pendingStreams.remove(paramOkHttpClientStream);
    maybeClearInUse();
  }
  
  public void shutdown()
  {
    synchronized (this.lock)
    {
      if (this.goAwayStatus != null) {
        return;
      }
      this.goAwayStatus = Status.UNAVAILABLE.withDescription("Transport stopped");
      this.listener.transportShutdown(this.goAwayStatus);
      stopIfNecessary();
      if (this.keepAliveManager != null)
      {
        this.keepAliveManager.onTransportShutdown();
        this.scheduler = ((ScheduledExecutorService)SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler));
      }
      return;
    }
  }
  
  public void shutdownNow(Status paramStatus)
  {
    shutdown();
    synchronized (this.lock)
    {
      localIterator = this.streams.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localIterator.remove();
        ((OkHttpClientStream)localEntry.getValue()).transportReportStatus(paramStatus, false, new Metadata());
      }
    }
    Iterator localIterator = this.pendingStreams.iterator();
    while (localIterator.hasNext()) {
      ((OkHttpClientStream)localIterator.next()).transportReportStatus(paramStatus, true, new Metadata());
    }
    this.pendingStreams.clear();
    maybeClearInUse();
    stopIfNecessary();
  }
  
  public Runnable start(ManagedClientTransport.Listener paramListener)
  {
    this.listener = ((ManagedClientTransport.Listener)Preconditions.checkNotNull(paramListener, "listener"));
    if (this.enableKeepAlive)
    {
      this.scheduler = ((ScheduledExecutorService)SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE));
      this.keepAliveManager = new KeepAliveManager(this, this.scheduler, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos);
    }
    this.frameWriter = new AsyncFrameWriter(this, this.serializingExecutor);
    this.outboundFlow = new OutboundFlowController(this, this.frameWriter);
    this.serializingExecutor.execute(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   4: invokestatic 32	io/grpc/okhttp/OkHttpClientTransport:access$000	(Lio/grpc/okhttp/OkHttpClientTransport;)Z
        //   7: ifeq +142 -> 149
        //   10: aload_0
        //   11: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   14: getfield 36	io/grpc/okhttp/OkHttpClientTransport:connectingCallback	Ljava/lang/Runnable;
        //   17: ifnull +15 -> 32
        //   20: aload_0
        //   21: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   24: getfield 36	io/grpc/okhttp/OkHttpClientTransport:connectingCallback	Ljava/lang/Runnable;
        //   27: invokeinterface 38 1 0
        //   32: aload_0
        //   33: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   36: new 40	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler
        //   39: dup
        //   40: aload_0
        //   41: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   44: aload_0
        //   45: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   48: invokestatic 44	io/grpc/okhttp/OkHttpClientTransport:access$200	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/internal/framed/FrameReader;
        //   51: invokespecial 47	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler:<init>	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/FrameReader;)V
        //   54: invokestatic 51	io/grpc/okhttp/OkHttpClientTransport:access$102	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   57: pop
        //   58: aload_0
        //   59: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   62: invokestatic 55	io/grpc/okhttp/OkHttpClientTransport:access$300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/concurrent/Executor;
        //   65: aload_0
        //   66: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   69: invokestatic 59	io/grpc/okhttp/OkHttpClientTransport:access$100	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   72: invokeinterface 65 2 0
        //   77: aload_0
        //   78: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   81: invokestatic 69	io/grpc/okhttp/OkHttpClientTransport:access$400	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/Object;
        //   84: astore_1
        //   85: aload_1
        //   86: monitorenter
        //   87: aload_0
        //   88: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   91: ldc 70
        //   93: invokestatic 74	io/grpc/okhttp/OkHttpClientTransport:access$502	(Lio/grpc/okhttp/OkHttpClientTransport;I)I
        //   96: pop
        //   97: aload_0
        //   98: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   101: invokestatic 77	io/grpc/okhttp/OkHttpClientTransport:access$600	(Lio/grpc/okhttp/OkHttpClientTransport;)Z
        //   104: pop
        //   105: aload_1
        //   106: monitorexit
        //   107: aload_0
        //   108: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   111: invokestatic 81	io/grpc/okhttp/OkHttpClientTransport:access$900	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/AsyncFrameWriter;
        //   114: aload_0
        //   115: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   118: invokestatic 85	io/grpc/okhttp/OkHttpClientTransport:access$700	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/internal/framed/FrameWriter;
        //   121: aload_0
        //   122: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   125: invokestatic 89	io/grpc/okhttp/OkHttpClientTransport:access$800	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/Socket;
        //   128: invokevirtual 95	io/grpc/okhttp/AsyncFrameWriter:becomeConnected	(Lio/grpc/okhttp/internal/framed/FrameWriter;Ljava/net/Socket;)V
        //   131: aload_0
        //   132: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   135: getfield 99	io/grpc/okhttp/OkHttpClientTransport:connectedFuture	Lcom/google/common/util/concurrent/SettableFuture;
        //   138: aconst_null
        //   139: invokevirtual 105	com/google/common/util/concurrent/SettableFuture:set	(Ljava/lang/Object;)Z
        //   142: pop
        //   143: return
        //   144: astore_2
        //   145: aload_1
        //   146: monitorexit
        //   147: aload_2
        //   148: athrow
        //   149: new 13	io/grpc/okhttp/OkHttpClientTransport$1$1
        //   152: dup
        //   153: aload_0
        //   154: invokespecial 108	io/grpc/okhttp/OkHttpClientTransport$1$1:<init>	(Lio/grpc/okhttp/OkHttpClientTransport$1;)V
        //   157: invokestatic 114	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
        //   160: astore 4
        //   162: new 116	io/grpc/okhttp/internal/framed/Http2
        //   165: dup
        //   166: invokespecial 117	io/grpc/okhttp/internal/framed/Http2:<init>	()V
        //   169: astore 7
        //   171: aload 4
        //   173: astore_2
        //   174: aload 4
        //   176: astore_3
        //   177: aload 4
        //   179: astore_1
        //   180: aload_0
        //   181: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   184: invokestatic 121	io/grpc/okhttp/OkHttpClientTransport:access$1000	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/InetSocketAddress;
        //   187: ifnonnull +308 -> 495
        //   190: aload 4
        //   192: astore_2
        //   193: aload 4
        //   195: astore_3
        //   196: aload 4
        //   198: astore_1
        //   199: new 123	java/net/Socket
        //   202: dup
        //   203: aload_0
        //   204: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   207: invokestatic 126	io/grpc/okhttp/OkHttpClientTransport:access$1100	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/InetSocketAddress;
        //   210: invokevirtual 132	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
        //   213: aload_0
        //   214: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   217: invokestatic 126	io/grpc/okhttp/OkHttpClientTransport:access$1100	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/InetSocketAddress;
        //   220: invokevirtual 136	java/net/InetSocketAddress:getPort	()I
        //   223: invokespecial 139	java/net/Socket:<init>	(Ljava/net/InetAddress;I)V
        //   226: astore 5
        //   228: aload 5
        //   230: astore 6
        //   232: aload 4
        //   234: astore_2
        //   235: aload 4
        //   237: astore_3
        //   238: aload 4
        //   240: astore_1
        //   241: aload_0
        //   242: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   245: invokestatic 143	io/grpc/okhttp/OkHttpClientTransport:access$1500	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljavax/net/ssl/SSLSocketFactory;
        //   248: ifnull +47 -> 295
        //   251: aload 4
        //   253: astore_2
        //   254: aload 4
        //   256: astore_3
        //   257: aload 4
        //   259: astore_1
        //   260: aload_0
        //   261: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   264: invokestatic 143	io/grpc/okhttp/OkHttpClientTransport:access$1500	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljavax/net/ssl/SSLSocketFactory;
        //   267: aload 5
        //   269: aload_0
        //   270: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   273: invokevirtual 147	io/grpc/okhttp/OkHttpClientTransport:getOverridenHost	()Ljava/lang/String;
        //   276: aload_0
        //   277: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   280: invokevirtual 150	io/grpc/okhttp/OkHttpClientTransport:getOverridenPort	()I
        //   283: aload_0
        //   284: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   287: invokestatic 154	io/grpc/okhttp/OkHttpClientTransport:access$1600	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/internal/ConnectionSpec;
        //   290: invokestatic 160	io/grpc/okhttp/OkHttpTlsUpgrader:upgrade	(Ljavax/net/ssl/SSLSocketFactory;Ljava/net/Socket;Ljava/lang/String;ILio/grpc/okhttp/internal/ConnectionSpec;)Ljavax/net/ssl/SSLSocket;
        //   293: astore 6
        //   295: aload 4
        //   297: astore_2
        //   298: aload 4
        //   300: astore_3
        //   301: aload 4
        //   303: astore_1
        //   304: aload 6
        //   306: iconst_1
        //   307: invokevirtual 164	java/net/Socket:setTcpNoDelay	(Z)V
        //   310: aload 4
        //   312: astore_2
        //   313: aload 4
        //   315: astore_3
        //   316: aload 4
        //   318: astore_1
        //   319: aload 6
        //   321: invokestatic 168	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
        //   324: invokestatic 114	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
        //   327: astore 4
        //   329: aload 4
        //   331: astore_2
        //   332: aload 4
        //   334: astore_3
        //   335: aload 4
        //   337: astore_1
        //   338: aload 6
        //   340: invokestatic 172	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
        //   343: invokestatic 175	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
        //   346: astore 5
        //   348: aload_0
        //   349: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   352: new 40	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler
        //   355: dup
        //   356: aload_0
        //   357: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   360: aload 7
        //   362: aload 4
        //   364: iconst_1
        //   365: invokeinterface 181 3 0
        //   370: invokespecial 47	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler:<init>	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/FrameReader;)V
        //   373: invokestatic 51	io/grpc/okhttp/OkHttpClientTransport:access$102	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   376: pop
        //   377: aload_0
        //   378: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   381: invokestatic 55	io/grpc/okhttp/OkHttpClientTransport:access$300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/concurrent/Executor;
        //   384: aload_0
        //   385: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   388: invokestatic 59	io/grpc/okhttp/OkHttpClientTransport:access$100	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   391: invokeinterface 65 2 0
        //   396: aload_0
        //   397: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   400: invokestatic 69	io/grpc/okhttp/OkHttpClientTransport:access$400	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/Object;
        //   403: astore_1
        //   404: aload_1
        //   405: monitorenter
        //   406: aload_0
        //   407: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   410: aload 6
        //   412: invokestatic 185	io/grpc/okhttp/OkHttpClientTransport:access$802	(Lio/grpc/okhttp/OkHttpClientTransport;Ljava/net/Socket;)Ljava/net/Socket;
        //   415: pop
        //   416: aload_0
        //   417: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   420: ldc 70
        //   422: invokestatic 74	io/grpc/okhttp/OkHttpClientTransport:access$502	(Lio/grpc/okhttp/OkHttpClientTransport;I)I
        //   425: pop
        //   426: aload_0
        //   427: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   430: invokestatic 77	io/grpc/okhttp/OkHttpClientTransport:access$600	(Lio/grpc/okhttp/OkHttpClientTransport;)Z
        //   433: pop
        //   434: aload_1
        //   435: monitorexit
        //   436: aload 7
        //   438: aload 5
        //   440: iconst_1
        //   441: invokeinterface 189 3 0
        //   446: astore_1
        //   447: aload_0
        //   448: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   451: invokestatic 81	io/grpc/okhttp/OkHttpClientTransport:access$900	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/AsyncFrameWriter;
        //   454: aload_1
        //   455: aload_0
        //   456: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   459: invokestatic 89	io/grpc/okhttp/OkHttpClientTransport:access$800	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/Socket;
        //   462: invokevirtual 95	io/grpc/okhttp/AsyncFrameWriter:becomeConnected	(Lio/grpc/okhttp/internal/framed/FrameWriter;Ljava/net/Socket;)V
        //   465: aload_1
        //   466: invokeinterface 194 1 0
        //   471: aload_1
        //   472: new 196	io/grpc/okhttp/internal/framed/Settings
        //   475: dup
        //   476: invokespecial 197	io/grpc/okhttp/internal/framed/Settings:<init>	()V
        //   479: invokeinterface 201 2 0
        //   484: return
        //   485: astore_1
        //   486: aload_0
        //   487: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   490: aload_1
        //   491: invokevirtual 205	io/grpc/okhttp/OkHttpClientTransport:onException	(Ljava/lang/Throwable;)V
        //   494: return
        //   495: aload 4
        //   497: astore_2
        //   498: aload 4
        //   500: astore_3
        //   501: aload 4
        //   503: astore_1
        //   504: aload_0
        //   505: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   508: aload_0
        //   509: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   512: invokestatic 126	io/grpc/okhttp/OkHttpClientTransport:access$1100	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/InetSocketAddress;
        //   515: aload_0
        //   516: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   519: invokestatic 121	io/grpc/okhttp/OkHttpClientTransport:access$1000	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/net/InetSocketAddress;
        //   522: aload_0
        //   523: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   526: invokestatic 209	io/grpc/okhttp/OkHttpClientTransport:access$1200	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/String;
        //   529: aload_0
        //   530: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   533: invokestatic 212	io/grpc/okhttp/OkHttpClientTransport:access$1300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/String;
        //   536: invokestatic 216	io/grpc/okhttp/OkHttpClientTransport:access$1400	(Lio/grpc/okhttp/OkHttpClientTransport;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;Ljava/lang/String;Ljava/lang/String;)Ljava/net/Socket;
        //   539: astore 5
        //   541: goto -313 -> 228
        //   544: astore_3
        //   545: aload_2
        //   546: astore_1
        //   547: aload_0
        //   548: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   551: iconst_0
        //   552: getstatic 222	io/grpc/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lio/grpc/okhttp/internal/framed/ErrorCode;
        //   555: aload_3
        //   556: invokevirtual 226	io/grpc/StatusException:getStatus	()Lio/grpc/Status;
        //   559: invokestatic 230	io/grpc/okhttp/OkHttpClientTransport:access$1700	(Lio/grpc/okhttp/OkHttpClientTransport;ILio/grpc/okhttp/internal/framed/ErrorCode;Lio/grpc/Status;)V
        //   562: aload_0
        //   563: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   566: new 40	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler
        //   569: dup
        //   570: aload_0
        //   571: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   574: aload 7
        //   576: aload_2
        //   577: iconst_1
        //   578: invokeinterface 181 3 0
        //   583: invokespecial 47	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler:<init>	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/FrameReader;)V
        //   586: invokestatic 51	io/grpc/okhttp/OkHttpClientTransport:access$102	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   589: pop
        //   590: aload_0
        //   591: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   594: invokestatic 55	io/grpc/okhttp/OkHttpClientTransport:access$300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/concurrent/Executor;
        //   597: aload_0
        //   598: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   601: invokestatic 59	io/grpc/okhttp/OkHttpClientTransport:access$100	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   604: invokeinterface 65 2 0
        //   609: return
        //   610: astore_2
        //   611: aload_3
        //   612: astore_1
        //   613: aload_0
        //   614: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   617: aload_2
        //   618: invokevirtual 205	io/grpc/okhttp/OkHttpClientTransport:onException	(Ljava/lang/Throwable;)V
        //   621: aload_0
        //   622: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   625: new 40	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler
        //   628: dup
        //   629: aload_0
        //   630: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   633: aload 7
        //   635: aload_3
        //   636: iconst_1
        //   637: invokeinterface 181 3 0
        //   642: invokespecial 47	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler:<init>	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/FrameReader;)V
        //   645: invokestatic 51	io/grpc/okhttp/OkHttpClientTransport:access$102	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   648: pop
        //   649: aload_0
        //   650: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   653: invokestatic 55	io/grpc/okhttp/OkHttpClientTransport:access$300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/concurrent/Executor;
        //   656: aload_0
        //   657: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   660: invokestatic 59	io/grpc/okhttp/OkHttpClientTransport:access$100	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   663: invokeinterface 65 2 0
        //   668: return
        //   669: astore_2
        //   670: aload_0
        //   671: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   674: new 40	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler
        //   677: dup
        //   678: aload_0
        //   679: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   682: aload 7
        //   684: aload_1
        //   685: iconst_1
        //   686: invokeinterface 181 3 0
        //   691: invokespecial 47	io/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler:<init>	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/FrameReader;)V
        //   694: invokestatic 51	io/grpc/okhttp/OkHttpClientTransport:access$102	(Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   697: pop
        //   698: aload_0
        //   699: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   702: invokestatic 55	io/grpc/okhttp/OkHttpClientTransport:access$300	(Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/concurrent/Executor;
        //   705: aload_0
        //   706: getfield 19	io/grpc/okhttp/OkHttpClientTransport$1:this$0	Lio/grpc/okhttp/OkHttpClientTransport;
        //   709: invokestatic 59	io/grpc/okhttp/OkHttpClientTransport:access$100	(Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OkHttpClientTransport$ClientFrameHandler;
        //   712: invokeinterface 65 2 0
        //   717: aload_2
        //   718: athrow
        //   719: astore_2
        //   720: aload_1
        //   721: monitorexit
        //   722: aload_2
        //   723: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	724	0	this	1
        //   485	6	1	localException1	Exception
        //   503	218	1	localObject2	Object
        //   144	4	2	localObject3	Object
        //   173	404	2	localObject4	Object
        //   610	8	2	localException2	Exception
        //   669	49	2	localObject5	Object
        //   719	4	2	localObject6	Object
        //   176	325	3	localBufferedSource1	BufferedSource
        //   544	92	3	localStatusException	StatusException
        //   160	342	4	localBufferedSource2	BufferedSource
        //   226	314	5	localObject7	Object
        //   230	181	6	localObject8	Object
        //   169	514	7	localHttp2	io.grpc.okhttp.internal.framed.Http2
        // Exception table:
        //   from	to	target	type
        //   87	107	144	finally
        //   145	147	144	finally
        //   465	484	485	java/lang/Exception
        //   180	190	544	io/grpc/StatusException
        //   199	228	544	io/grpc/StatusException
        //   241	251	544	io/grpc/StatusException
        //   260	295	544	io/grpc/StatusException
        //   304	310	544	io/grpc/StatusException
        //   319	329	544	io/grpc/StatusException
        //   338	348	544	io/grpc/StatusException
        //   504	541	544	io/grpc/StatusException
        //   180	190	610	java/lang/Exception
        //   199	228	610	java/lang/Exception
        //   241	251	610	java/lang/Exception
        //   260	295	610	java/lang/Exception
        //   304	310	610	java/lang/Exception
        //   319	329	610	java/lang/Exception
        //   338	348	610	java/lang/Exception
        //   504	541	610	java/lang/Exception
        //   180	190	669	finally
        //   199	228	669	finally
        //   241	251	669	finally
        //   260	295	669	finally
        //   304	310	669	finally
        //   319	329	669	finally
        //   338	348	669	finally
        //   504	541	669	finally
        //   547	562	669	finally
        //   613	621	669	finally
        //   406	436	719	finally
        //   720	722	719	finally
      }
    });
    return null;
  }
  
  @GuardedBy("lock")
  void stopIfNecessary()
  {
    if ((this.goAwayStatus == null) || (!this.streams.isEmpty()) || (!this.pendingStreams.isEmpty())) {}
    while (this.stopped) {
      return;
    }
    this.stopped = true;
    if (this.ping != null)
    {
      this.ping.failed(getPingFailure());
      this.ping = null;
    }
    if (!this.goAwaySent)
    {
      this.goAwaySent = true;
      this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
    }
    this.frameWriter.close();
  }
  
  @GuardedBy("lock")
  void streamReadyToStart(OkHttpClientStream paramOkHttpClientStream)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.goAwayStatus != null)
        {
          paramOkHttpClientStream.transportReportStatus(this.goAwayStatus, true, new Metadata());
          return;
        }
        if (this.streams.size() >= this.maxConcurrentStreams)
        {
          this.pendingStreams.add(paramOkHttpClientStream);
          setInUse();
        }
      }
      startStream(paramOkHttpClientStream);
    }
  }
  
  public String toString()
  {
    return getLogId() + "(" + this.address + ")";
  }
  
  @VisibleForTesting
  class ClientFrameHandler
    implements FrameReader.Handler, Runnable
  {
    boolean firstSettings = true;
    FrameReader frameReader;
    
    ClientFrameHandler(FrameReader paramFrameReader)
    {
      this.frameReader = paramFrameReader;
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource arg3, int paramInt2)
      throws IOException
    {
      OkHttpClientStream localOkHttpClientStream = OkHttpClientTransport.this.getStream(paramInt1);
      if (localOkHttpClientStream == null) {
        if (OkHttpClientTransport.this.mayHaveCreatedStream(paramInt1))
        {
          OkHttpClientTransport.this.frameWriter.rstStream(paramInt1, ErrorCode.INVALID_STREAM);
          ???.skip(paramInt2);
        }
      }
      for (;;)
      {
        OkHttpClientTransport.access$2202(OkHttpClientTransport.this, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead + paramInt2);
        if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= 32767)
        {
          OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
          OkHttpClientTransport.access$2202(OkHttpClientTransport.this, 0);
        }
        return;
        OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + paramInt1);
        return;
        ???.require(paramInt2);
        Buffer localBuffer = new Buffer();
        localBuffer.write(???.buffer(), paramInt2);
        synchronized (OkHttpClientTransport.this.lock)
        {
          localOkHttpClientStream.transportDataReceived(localBuffer, paramBoolean);
        }
      }
    }
    
    public void goAway(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString)
    {
      Status localStatus = GrpcUtil.Http2Error.statusForCode(paramErrorCode.httpCode).augmentDescription("Received Goaway");
      paramErrorCode = localStatus;
      if (paramByteString != null)
      {
        paramErrorCode = localStatus;
        if (paramByteString.size() > 0) {
          paramErrorCode = localStatus.augmentDescription(paramByteString.utf8());
        }
      }
      OkHttpClientTransport.this.startGoAway(paramInt, null, paramErrorCode);
    }
    
    public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList, HeadersMode arg6)
    {
      paramInt2 = 0;
      synchronized (OkHttpClientTransport.this.lock)
      {
        OkHttpClientStream localOkHttpClientStream = (OkHttpClientStream)OkHttpClientTransport.this.streams.get(Integer.valueOf(paramInt1));
        if (localOkHttpClientStream == null)
        {
          if (OkHttpClientTransport.this.mayHaveCreatedStream(paramInt1)) {
            OkHttpClientTransport.this.frameWriter.rstStream(paramInt1, ErrorCode.INVALID_STREAM);
          }
          for (;;)
          {
            if (paramInt2 != 0) {
              OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + paramInt1);
            }
            return;
            paramInt2 = 1;
          }
        }
        localOkHttpClientStream.transportHeadersReceived(paramList, paramBoolean2);
      }
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (!paramBoolean)
      {
        OkHttpClientTransport.this.frameWriter.ping(true, paramInt1, paramInt2);
        return;
      }
      Http2Ping localHttp2Ping = null;
      long l = paramInt1 << 32 | paramInt2 & 0xFFFFFFFF;
      for (;;)
      {
        synchronized (OkHttpClientTransport.this.lock)
        {
          if (OkHttpClientTransport.this.ping != null)
          {
            if (OkHttpClientTransport.this.ping.payload() == l)
            {
              localHttp2Ping = OkHttpClientTransport.this.ping;
              OkHttpClientTransport.access$2502(OkHttpClientTransport.this, null);
              if (localHttp2Ping == null) {
                break;
              }
              localHttp2Ping.complete();
              return;
            }
            OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", new Object[] { Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(l) }));
          }
        }
        OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
      }
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      OkHttpClientTransport.this.frameWriter.rstStream(paramInt1, ErrorCode.PROTOCOL_ERROR);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      OkHttpClientTransport.this.finishStream(paramInt, OkHttpClientTransport.toGrpcStatus(paramErrorCode).augmentDescription("Rst Stream"), null);
    }
    
    public void run()
    {
      str = Thread.currentThread().getName();
      if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
        Thread.currentThread().setName("OkHttpClientTransport");
      }
      try
      {
        while (this.frameReader.nextFrame(this)) {
          if (OkHttpClientTransport.this.keepAliveManager != null) {
            OkHttpClientTransport.this.keepAliveManager.onDataReceived();
          }
        }
        try
        {
          this.frameReader.close();
          OkHttpClientTransport.this.listener.transportTerminated();
          if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
            Thread.currentThread().setName(str);
          }
          throw ((Throwable)localObject);
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", localIOException3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.UNAVAILABLE.withCause(localThrowable));
        try
        {
          this.frameReader.close();
          OkHttpClientTransport.this.listener.transportTerminated();
          if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
            Thread.currentThread().setName(str);
          }
          for (;;)
          {
            return;
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withDescription("End of stream or IOException"));
            try
            {
              this.frameReader.close();
              OkHttpClientTransport.this.listener.transportTerminated();
              if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                continue;
              }
              Thread.currentThread().setName(str);
              return;
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", localIOException1);
              }
            }
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", localIOException2);
          }
        }
      }
      finally {}
    }
    
    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      synchronized (OkHttpClientTransport.this.lock)
      {
        int i;
        if (OkHttpSettingsUtil.isSet(paramSettings, 4))
        {
          i = OkHttpSettingsUtil.get(paramSettings, 4);
          OkHttpClientTransport.access$502(OkHttpClientTransport.this, i);
        }
        if (OkHttpSettingsUtil.isSet(paramSettings, 7))
        {
          i = OkHttpSettingsUtil.get(paramSettings, 7);
          OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(i);
        }
        if (this.firstSettings)
        {
          OkHttpClientTransport.this.listener.transportReady();
          this.firstSettings = false;
        }
        OkHttpClientTransport.this.startPendingStreams();
        OkHttpClientTransport.this.frameWriter.ackSettings(paramSettings);
        return;
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramLong == 0L)
      {
        if (paramInt == 0)
        {
          OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
          return;
        }
        OkHttpClientTransport.this.finishStream(paramInt, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ErrorCode.PROTOCOL_ERROR);
        return;
      }
      int i = 0;
      Object localObject1 = OkHttpClientTransport.this.lock;
      if (paramInt == 0) {
        try
        {
          OkHttpClientTransport.this.outboundFlow.windowUpdate(null, (int)paramLong);
          return;
        }
        finally {}
      }
      OkHttpClientStream localOkHttpClientStream = (OkHttpClientStream)OkHttpClientTransport.this.streams.get(Integer.valueOf(paramInt));
      if (localOkHttpClientStream != null) {
        OkHttpClientTransport.this.outboundFlow.windowUpdate(localOkHttpClientStream, (int)paramLong);
      }
      for (;;)
      {
        if (i == 0) {
          break;
        }
        OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + paramInt);
        return;
        boolean bool = OkHttpClientTransport.this.mayHaveCreatedStream(paramInt);
        if (!bool) {
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */