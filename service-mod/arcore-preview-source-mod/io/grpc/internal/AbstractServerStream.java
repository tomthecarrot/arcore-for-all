package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import javax.annotation.Nullable;

public abstract class AbstractServerStream
  extends AbstractStream2
  implements ServerStream, MessageFramer.Sink
{
  private final MessageFramer framer;
  private boolean headersSent;
  private boolean outboundClosed;
  private final StatsTraceContext statsTraceCtx;
  
  protected AbstractServerStream(WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext)
  {
    this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
    this.framer = new MessageFramer(this, paramWritableBufferAllocator, paramStatsTraceContext);
  }
  
  private void addStatusToTrailers(Metadata paramMetadata, Status paramStatus)
  {
    paramMetadata.discardAll(Status.CODE_KEY);
    paramMetadata.discardAll(Status.MESSAGE_KEY);
    paramMetadata.put(Status.CODE_KEY, paramStatus);
    if (paramStatus.getDescription() != null) {
      paramMetadata.put(Status.MESSAGE_KEY, paramStatus.getDescription());
    }
  }
  
  protected abstract Sink abstractServerStreamSink();
  
  public final void cancel(Status paramStatus)
  {
    abstractServerStreamSink().cancel(paramStatus);
  }
  
  public final void close(Status paramStatus, Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramStatus, "status");
    Preconditions.checkNotNull(paramMetadata, "trailers");
    if (!this.outboundClosed)
    {
      this.outboundClosed = true;
      endOfMessages();
      addStatusToTrailers(paramMetadata, paramStatus);
      abstractServerStreamSink().writeTrailers(paramMetadata, this.headersSent);
    }
  }
  
  public final void deliverFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2)
  {
    Sink localSink = abstractServerStreamSink();
    if (paramBoolean1) {
      paramBoolean2 = false;
    }
    localSink.writeFrame(paramWritableBuffer, paramBoolean2);
  }
  
  protected final MessageFramer framer()
  {
    return this.framer;
  }
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  public String getAuthority()
  {
    return null;
  }
  
  public final boolean isReady()
  {
    return super.isReady();
  }
  
  public final void request(int paramInt)
  {
    abstractServerStreamSink().request(paramInt);
  }
  
  public final void setListener(ServerStreamListener paramServerStreamListener)
  {
    transportState().setListener(paramServerStreamListener);
  }
  
  public StatsTraceContext statsTraceContext()
  {
    return this.statsTraceCtx;
  }
  
  protected abstract TransportState transportState();
  
  public final void writeHeaders(Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramMetadata, "headers");
    this.headersSent = true;
    abstractServerStreamSink().writeHeaders(paramMetadata);
  }
  
  protected static abstract interface Sink
  {
    public abstract void cancel(Status paramStatus);
    
    public abstract void request(int paramInt);
    
    public abstract void writeFrame(@Nullable WritableBuffer paramWritableBuffer, boolean paramBoolean);
    
    public abstract void writeHeaders(Metadata paramMetadata);
    
    public abstract void writeTrailers(Metadata paramMetadata, boolean paramBoolean);
  }
  
  protected static abstract class TransportState
    extends AbstractStream2.TransportState
  {
    private ServerStreamListener listener;
    private boolean listenerClosed;
    
    protected TransportState(int paramInt, StatsTraceContext paramStatsTraceContext)
    {
      super(paramStatsTraceContext);
    }
    
    private void closeListener(Status paramStatus)
    {
      if (!this.listenerClosed)
      {
        this.listenerClosed = true;
        onStreamDeallocated();
        closeDeframer();
        listener().closed(paramStatus);
      }
    }
    
    public void complete()
    {
      closeListener(Status.OK);
    }
    
    public void deliveryStalled() {}
    
    public void endOfStream()
    {
      closeDeframer();
      listener().halfClosed();
    }
    
    public void inboundDataReceived(ReadableBuffer paramReadableBuffer, boolean paramBoolean)
    {
      deframe(paramReadableBuffer, paramBoolean);
    }
    
    protected ServerStreamListener listener()
    {
      return this.listener;
    }
    
    public final void onStreamAllocated()
    {
      super.onStreamAllocated();
    }
    
    public final void setListener(ServerStreamListener paramServerStreamListener)
    {
      if (this.listener == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "setListener should be called only once");
        this.listener = ((ServerStreamListener)Preconditions.checkNotNull(paramServerStreamListener, "listener"));
        return;
      }
    }
    
    public final void transportReportStatus(Status paramStatus)
    {
      if (!paramStatus.isOk()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "status must not be OK");
        closeListener(paramStatus);
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractServerStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */