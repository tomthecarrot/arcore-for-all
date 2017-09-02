package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public abstract class AbstractClientStream2
  extends AbstractStream2
  implements ClientStream, MessageFramer.Sink
{
  private static final Logger log = Logger.getLogger(AbstractClientStream2.class.getName());
  private volatile boolean cancelled;
  private final MessageFramer framer;
  private boolean outboundClosed;
  
  protected AbstractClientStream2(WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext)
  {
    this.framer = new MessageFramer(this, paramWritableBufferAllocator, paramStatsTraceContext);
  }
  
  protected abstract Sink abstractClientStreamSink();
  
  public final void cancel(Status paramStatus)
  {
    if (!paramStatus.isOk()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Should not cancel with OK status");
      this.cancelled = true;
      abstractClientStreamSink().cancel(paramStatus);
      return;
    }
  }
  
  public final void deliverFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramWritableBuffer != null) || (paramBoolean1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "null frame before EOS");
      abstractClientStreamSink().writeFrame(paramWritableBuffer, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  protected final MessageFramer framer()
  {
    return this.framer;
  }
  
  public final void halfClose()
  {
    if (!this.outboundClosed)
    {
      this.outboundClosed = true;
      endOfMessages();
    }
  }
  
  public final boolean isReady()
  {
    return (super.isReady()) && (!this.cancelled);
  }
  
  public final void request(int paramInt)
  {
    abstractClientStreamSink().request(paramInt);
  }
  
  public void setMaxInboundMessageSize(int paramInt)
  {
    transportState().setMaxInboundMessageSize(paramInt);
  }
  
  public void setMaxOutboundMessageSize(int paramInt)
  {
    this.framer.setMaxOutboundMessageSize(paramInt);
  }
  
  public void start(ClientStreamListener paramClientStreamListener)
  {
    transportState().setListener(paramClientStreamListener);
  }
  
  protected abstract TransportState transportState();
  
  protected static abstract interface Sink
  {
    public abstract void cancel(Status paramStatus);
    
    public abstract void request(int paramInt);
    
    public abstract void writeFrame(@Nullable WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  protected static abstract class TransportState
    extends AbstractStream2.TransportState
  {
    private Runnable deliveryStalledTask;
    private boolean headersReceived;
    private ClientStreamListener listener;
    private boolean listenerClosed;
    private boolean statusReported;
    
    protected TransportState(int paramInt, StatsTraceContext paramStatsTraceContext)
    {
      super(paramStatsTraceContext);
    }
    
    private void closeListener(Status paramStatus, Metadata paramMetadata)
    {
      if (!this.listenerClosed)
      {
        this.listenerClosed = true;
        closeDeframer();
        listener().closed(paramStatus, paramMetadata);
      }
    }
    
    public final void deliveryStalled()
    {
      if (this.deliveryStalledTask != null)
      {
        this.deliveryStalledTask.run();
        this.deliveryStalledTask = null;
      }
    }
    
    public final void endOfStream()
    {
      deliveryStalled();
    }
    
    protected void inboundDataReceived(ReadableBuffer paramReadableBuffer)
    {
      Preconditions.checkNotNull(paramReadableBuffer, "frame");
      int j = 1;
      int i = j;
      try
      {
        if (this.statusReported)
        {
          i = j;
          AbstractClientStream2.log.log(Level.INFO, "Received data on closed stream");
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
            if (this.headersReceived) {
              break;
            }
            i = j;
            transportReportStatus(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
          } while (1 == 0);
          paramReadableBuffer.close();
          return;
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
    
    protected void inboundHeadersReceived(Metadata paramMetadata)
    {
      if (!this.statusReported) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Received headers on closed stream");
        this.headersReceived = true;
        listener().headersRead(paramMetadata);
        return;
      }
    }
    
    protected void inboundTrailersReceived(Metadata paramMetadata, Status paramStatus)
    {
      Preconditions.checkNotNull(paramStatus, "status");
      Preconditions.checkNotNull(paramMetadata, "trailers");
      if (this.statusReported)
      {
        AbstractClientStream2.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[] { paramStatus, paramMetadata });
        return;
      }
      transportReportStatus(paramStatus, false, paramMetadata);
    }
    
    protected final ClientStreamListener listener()
    {
      return this.listener;
    }
    
    @VisibleForTesting
    public final void setListener(ClientStreamListener paramClientStreamListener)
    {
      if (this.listener == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Already called setListener");
        this.listener = ((ClientStreamListener)Preconditions.checkNotNull(paramClientStreamListener, "listener"));
        return;
      }
    }
    
    public final void transportReportStatus(final Status paramStatus, boolean paramBoolean, final Metadata paramMetadata)
    {
      Preconditions.checkNotNull(paramStatus, "status");
      Preconditions.checkNotNull(paramMetadata, "trailers");
      if ((this.statusReported) && (!paramBoolean)) {
        return;
      }
      this.statusReported = true;
      onStreamDeallocated();
      if ((paramBoolean) || (isDeframerStalled()))
      {
        this.deliveryStalledTask = null;
        closeListener(paramStatus, paramMetadata);
        return;
      }
      this.deliveryStalledTask = new Runnable()
      {
        public void run()
        {
          AbstractClientStream2.TransportState.this.closeListener(paramStatus, paramMetadata);
        }
      };
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractClientStream2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */