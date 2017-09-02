package io.grpc.internal;

import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractClientStream
  extends AbstractStream
  implements ClientStream
{
  private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
  private volatile boolean cancelled;
  private Runnable closeListenerTask;
  private ClientStreamListener listener;
  private boolean listenerClosed;
  private Status status;
  private Metadata trailers;
  
  protected AbstractClientStream(WritableBufferAllocator paramWritableBufferAllocator, int paramInt, StatsTraceContext paramStatsTraceContext)
  {
    super(paramWritableBufferAllocator, paramInt, paramStatsTraceContext);
  }
  
  private void closeListener(Status paramStatus, Metadata paramMetadata)
  {
    if (this.listener != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "stream not started");
      if (!this.listenerClosed)
      {
        this.listenerClosed = true;
        closeDeframer();
        this.listener.closed(paramStatus, paramMetadata);
      }
      return;
    }
  }
  
  private Runnable newCloseListenerTask(final Status paramStatus, final Metadata paramMetadata)
  {
    new Runnable()
    {
      public void run()
      {
        AbstractClientStream.this.closeListener(paramStatus, paramMetadata);
      }
    };
  }
  
  private void runCloseListenerTask()
  {
    if (this.closeListenerTask != null)
    {
      this.closeListenerTask.run();
      this.closeListenerTask = null;
    }
  }
  
  public final void cancel(Status paramStatus)
  {
    if (!paramStatus.isOk()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Should not cancel with OK status");
      this.cancelled = true;
      sendCancel(paramStatus);
      dispose();
      return;
    }
  }
  
  protected final void deframeFailed(Throwable paramThrowable)
  {
    cancel(Status.INTERNAL.withDescription("Exception deframing message").withCause(paramThrowable));
  }
  
  public final void halfClose()
  {
    if (outboundPhase(AbstractStream.Phase.STATUS) != AbstractStream.Phase.STATUS) {
      closeFramer();
    }
  }
  
  protected void inboundDataReceived(ReadableBuffer paramReadableBuffer)
  {
    Preconditions.checkNotNull(paramReadableBuffer, "frame");
    int j = 1;
    int i = j;
    try
    {
      AbstractStream.Phase localPhase1 = inboundPhase();
      i = j;
      AbstractStream.Phase localPhase2 = AbstractStream.Phase.STATUS;
      if (localPhase1 == localPhase2) {
        if (1 != 0) {
          paramReadableBuffer.close();
        }
      }
      do
      {
        do
        {
          return;
          i = j;
          if (inboundPhase() != AbstractStream.Phase.HEADERS) {
            break;
          }
          i = j;
          inboundTransportError(Status.INTERNAL.withDescription("headers not received before payload"), new Metadata());
        } while (1 == 0);
        paramReadableBuffer.close();
        return;
        i = j;
        inboundPhase(AbstractStream.Phase.MESSAGE);
        i = 0;
        deframe(paramReadableBuffer, false);
      } while (0 == 0);
      paramReadableBuffer.close();
      return;
    }
    finally
    {
      if (i != 0) {
        paramReadableBuffer.close();
      }
    }
  }
  
  protected void inboundDeliveryPaused()
  {
    runCloseListenerTask();
  }
  
  protected void inboundHeadersReceived(Metadata paramMetadata)
  {
    if (this.listener != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "stream not started");
      if (inboundPhase() == AbstractStream.Phase.STATUS) {
        log.log(Level.INFO, "Received headers on closed stream {0} {1}", new Object[] { Integer.valueOf(id()), paramMetadata });
      }
      inboundPhase(AbstractStream.Phase.MESSAGE);
      this.listener.headersRead(paramMetadata);
      return;
    }
  }
  
  protected void inboundTrailersReceived(Metadata paramMetadata, Status paramStatus)
  {
    Preconditions.checkNotNull(paramMetadata, "trailers");
    if (inboundPhase() == AbstractStream.Phase.STATUS) {
      log.log(Level.INFO, "Received trailers on closed stream {0}\n {1}\n {2}", new Object[] { Integer.valueOf(id()), paramStatus, paramMetadata });
    }
    this.status = paramStatus;
    this.trailers = paramMetadata;
    deframe(ReadableBuffers.empty(), true);
  }
  
  protected void inboundTransportError(Status paramStatus, Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramMetadata, "metadata");
    if (inboundPhase() == AbstractStream.Phase.STATUS)
    {
      log.log(Level.INFO, "Received transport error on closed stream {0} {1}", new Object[] { Integer.valueOf(id()), paramStatus });
      return;
    }
    transportReportStatus(paramStatus, false, paramMetadata);
  }
  
  protected final void internalSendFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramWritableBuffer != null) || (paramBoolean1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "null frame before EOS");
      sendFrame(paramWritableBuffer, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public boolean isClosed()
  {
    return (super.isClosed()) || (this.listenerClosed);
  }
  
  public final boolean isReady()
  {
    return (!this.cancelled) && (super.isReady());
  }
  
  protected final ClientStreamListener listener()
  {
    return this.listener;
  }
  
  protected void receiveMessage(InputStream paramInputStream)
  {
    if (!this.listenerClosed) {
      if (this.listener == null) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "stream not started");
      this.listener.messageRead(paramInputStream);
      return;
    }
  }
  
  protected void remoteEndClosed()
  {
    transportReportStatus(this.status, true, this.trailers);
  }
  
  protected abstract void sendCancel(Status paramStatus);
  
  protected abstract void sendFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2);
  
  public void setMaxInboundMessageSize(int paramInt)
  {
    setMaxInboundMessageSizeProtected(paramInt);
  }
  
  public void setMaxOutboundMessageSize(int paramInt)
  {
    setMaxOutboundMessageSizeProtected(paramInt);
  }
  
  public void start(ClientStreamListener paramClientStreamListener)
  {
    if (this.listener == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "stream already started");
      this.listener = ((ClientStreamListener)Preconditions.checkNotNull(paramClientStreamListener, "listener"));
      return;
    }
  }
  
  protected MoreObjects.ToStringHelper toStringHelper()
  {
    MoreObjects.ToStringHelper localToStringHelper = super.toStringHelper();
    if (this.status != null) {
      localToStringHelper.add("status", this.status);
    }
    return localToStringHelper;
  }
  
  public void transportReportStatus(Status paramStatus, boolean paramBoolean, Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramStatus, "newStatus");
    if ((this.closeListenerTask != null) && (!paramBoolean)) {}
    for (int i = 1; (this.listenerClosed) || (i != 0); i = 0) {
      return;
    }
    inboundPhase(AbstractStream.Phase.STATUS);
    this.status = paramStatus;
    this.closeListenerTask = null;
    boolean bool = isDeframerStalled();
    if ((paramBoolean) || (bool))
    {
      closeListener(paramStatus, paramMetadata);
      return;
    }
    this.closeListenerTask = newCloseListenerTask(paramStatus, paramMetadata);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */