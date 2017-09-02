package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2ClientStream;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;

class OkHttpClientStream
  extends Http2ClientStream
{
  private static final Buffer EMPTY_BUFFER = new Buffer();
  private static final int WINDOW_UPDATE_THRESHOLD = 32767;
  private String authority;
  @GuardedBy("lock")
  private boolean cancelSent = false;
  private final AsyncFrameWriter frameWriter;
  private Metadata headers;
  private volatile int id = -1;
  private final Object lock;
  private final MethodDescriptor<?, ?> method;
  private final OutboundFlowController outboundFlow;
  private Object outboundFlowState;
  @GuardedBy("lock")
  private Queue<PendingData> pendingData = new ArrayDeque();
  @GuardedBy("lock")
  private int processedWindow = 65535;
  @GuardedBy("lock")
  private List<Header> requestHeaders;
  private final StatsTraceContext statsTraceCtx;
  private final OkHttpClientTransport transport;
  private final String userAgent;
  @GuardedBy("lock")
  private int window = 65535;
  
  OkHttpClientStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, AsyncFrameWriter paramAsyncFrameWriter, OkHttpClientTransport paramOkHttpClientTransport, OutboundFlowController paramOutboundFlowController, Object paramObject, int paramInt, String paramString1, String paramString2, StatsTraceContext paramStatsTraceContext)
  {
    super(new OkHttpWritableBufferAllocator(), paramInt, paramStatsTraceContext);
    this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
    this.method = paramMethodDescriptor;
    this.headers = paramMetadata;
    this.frameWriter = paramAsyncFrameWriter;
    this.transport = paramOkHttpClientTransport;
    this.outboundFlow = paramOutboundFlowController;
    this.lock = paramObject;
    this.authority = paramString1;
    this.userAgent = paramString2;
  }
  
  public void allocated()
  {
    onStreamAllocated();
  }
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  Object getOutboundFlowState()
  {
    return this.outboundFlowState;
  }
  
  public MethodDescriptor.MethodType getType()
  {
    return this.method.getType();
  }
  
  public int id()
  {
    return this.id;
  }
  
  void onStreamSentBytes(int paramInt)
  {
    onSentBytes(paramInt);
  }
  
  public void remoteEndClosed()
  {
    super.remoteEndClosed();
    if (canSend()) {
      this.frameWriter.rstStream(id(), ErrorCode.CANCEL);
    }
    this.transport.finishStream(id(), null, null);
  }
  
  public void request(int paramInt)
  {
    synchronized (this.lock)
    {
      requestMessagesFromDeframer(paramInt);
      return;
    }
  }
  
  protected void returnProcessedBytes(int paramInt)
  {
    synchronized (this.lock)
    {
      this.processedWindow -= paramInt;
      if (this.processedWindow <= 32767)
      {
        paramInt = 65535 - this.processedWindow;
        this.window += paramInt;
        this.processedWindow += paramInt;
        this.frameWriter.windowUpdate(id(), paramInt);
      }
      return;
    }
  }
  
  protected void sendCancel(Status paramStatus)
  {
    synchronized (this.lock)
    {
      if (this.cancelSent) {
        return;
      }
      this.cancelSent = true;
      if (this.pendingData == null) {
        break label105;
      }
      this.transport.removePendingStream(this);
      this.requestHeaders = null;
      Iterator localIterator = this.pendingData.iterator();
      if (localIterator.hasNext()) {
        ((PendingData)localIterator.next()).buffer.clear();
      }
    }
    this.pendingData = null;
    transportReportStatus(paramStatus, true, new Metadata());
    for (;;)
    {
      return;
      label105:
      this.transport.finishStream(id(), paramStatus, ErrorCode.CANCEL);
    }
  }
  
  protected void sendFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWritableBuffer == null) {
      paramWritableBuffer = EMPTY_BUFFER;
    }
    synchronized (this.lock)
    {
      while (this.cancelSent)
      {
        return;
        ??? = ((OkHttpWritableBuffer)paramWritableBuffer).buffer();
        int i = (int)((Buffer)???).size();
        paramWritableBuffer = (WritableBuffer)???;
        if (i > 0)
        {
          onSendingBytes(i);
          paramWritableBuffer = (WritableBuffer)???;
        }
      }
      if (this.pendingData != null)
      {
        this.pendingData.add(new PendingData(paramWritableBuffer, paramBoolean1, paramBoolean2));
        return;
      }
    }
    if (id() != -1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "streamId should be set");
      this.outboundFlow.data(paramBoolean1, id(), paramWritableBuffer, paramBoolean2);
      break;
    }
  }
  
  public void setAuthority(String paramString)
  {
    if (listener() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "must be call before start");
      this.authority = ((String)Preconditions.checkNotNull(paramString, "authority"));
      return;
    }
  }
  
  void setOutboundFlowState(Object paramObject)
  {
    this.outboundFlowState = paramObject;
  }
  
  @GuardedBy("lock")
  public void start(int paramInt)
  {
    if (this.id == -1) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "the stream has been started with id %s", new Object[] { Integer.valueOf(this.id) });
      this.id = paramInt;
      if (this.pendingData == null) {
        return;
      }
      this.frameWriter.synStream(false, false, paramInt, 0, this.requestHeaders);
      this.statsTraceCtx.clientHeadersSent();
      this.requestHeaders = null;
      i = 0;
      while (!this.pendingData.isEmpty())
      {
        PendingData localPendingData = (PendingData)this.pendingData.poll();
        this.outboundFlow.data(localPendingData.endOfStream, paramInt, localPendingData.buffer, false);
        if (localPendingData.flush) {
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.outboundFlow.flush();
    }
    this.pendingData = null;
  }
  
  public void start(ClientStreamListener arg1)
  {
    super.start(???);
    ??? = "/" + this.method.getFullMethodName();
    this.headers.discardAll(GrpcUtil.USER_AGENT_KEY);
    List localList = Headers.createRequestHeaders(this.headers, ???, this.authority, this.userAgent);
    this.headers = null;
    synchronized (this.lock)
    {
      this.requestHeaders = localList;
      this.transport.streamReadyToStart(this);
      return;
    }
  }
  
  @GuardedBy("lock")
  public void transportDataReceived(Buffer paramBuffer, boolean paramBoolean)
  {
    long l = paramBuffer.size();
    this.window = ((int)(this.window - l));
    if (this.window < 0)
    {
      this.frameWriter.rstStream(id(), ErrorCode.FLOW_CONTROL_ERROR);
      this.transport.finishStream(id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), null);
      return;
    }
    super.transportDataReceived(new OkHttpReadableBuffer(paramBuffer), paramBoolean);
  }
  
  @GuardedBy("lock")
  public void transportHeadersReceived(List<Header> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      transportTrailersReceived(Utils.convertTrailers(paramList));
      return;
    }
    transportHeadersReceived(Utils.convertHeaders(paramList));
  }
  
  private static class PendingData
  {
    Buffer buffer;
    boolean endOfStream;
    boolean flush;
    
    PendingData(Buffer paramBuffer, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.buffer = paramBuffer;
      this.endOfStream = paramBoolean1;
      this.flush = paramBoolean2;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */