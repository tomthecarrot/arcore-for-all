package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import io.grpc.Codec.Identity;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractStream
  implements Stream
{
  public static final int ABSENT_ID = -1;
  public static final int DEFAULT_ONREADY_THRESHOLD = 32768;
  @GuardedBy("onReadyLock")
  private boolean allocated;
  private final MessageDeframer deframer;
  private final MessageFramer framer;
  private Phase inboundPhase = Phase.HEADERS;
  private int numSentBytesQueued;
  private final Object onReadyLock = new Object();
  private int onReadyThreshold = 32768;
  private Phase outboundPhase = Phase.HEADERS;
  
  @VisibleForTesting
  AbstractStream(MessageFramer paramMessageFramer, MessageDeframer paramMessageDeframer)
  {
    this.framer = paramMessageFramer;
    this.deframer = paramMessageDeframer;
  }
  
  AbstractStream(WritableBufferAllocator paramWritableBufferAllocator, int paramInt, StatsTraceContext paramStatsTraceContext)
  {
    this.framer = new MessageFramer(new FramerSink(), paramWritableBufferAllocator, paramStatsTraceContext);
    this.deframer = new MessageDeframer(new DeframerListener(), Codec.Identity.NONE, paramInt, paramStatsTraceContext, getClass().getName());
  }
  
  public boolean canReceive()
  {
    return inboundPhase() != Phase.STATUS;
  }
  
  public boolean canSend()
  {
    return outboundPhase() != Phase.STATUS;
  }
  
  protected final void closeDeframer()
  {
    this.deframer.close();
  }
  
  final void closeFramer()
  {
    if (!this.framer.isClosed()) {
      this.framer.close();
    }
  }
  
  protected final void deframe(ReadableBuffer paramReadableBuffer, boolean paramBoolean)
  {
    try
    {
      this.deframer.deframe(paramReadableBuffer, paramBoolean);
      return;
    }
    catch (Throwable paramReadableBuffer)
    {
      deframeFailed(paramReadableBuffer);
    }
  }
  
  protected abstract void deframeFailed(Throwable paramThrowable);
  
  public void dispose()
  {
    this.framer.dispose();
  }
  
  public final void flush()
  {
    if (!this.framer.isClosed()) {
      this.framer.flush();
    }
  }
  
  public int getOnReadyThreshold()
  {
    synchronized (this.onReadyLock)
    {
      int i = this.onReadyThreshold;
      return i;
    }
  }
  
  public abstract int id();
  
  protected abstract void inboundDeliveryPaused();
  
  final Phase inboundPhase()
  {
    return this.inboundPhase;
  }
  
  final Phase inboundPhase(Phase paramPhase)
  {
    Phase localPhase = this.inboundPhase;
    this.inboundPhase = verifyNextPhase(this.inboundPhase, paramPhase);
    return localPhase;
  }
  
  protected abstract void internalSendFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2);
  
  @VisibleForTesting
  public boolean isClosed()
  {
    return (inboundPhase() == Phase.STATUS) && (outboundPhase() == Phase.STATUS);
  }
  
  protected final boolean isDeframerStalled()
  {
    return this.deframer.isStalled();
  }
  
  public boolean isReady()
  {
    boolean bool2 = false;
    if ((listener() != null) && (outboundPhase() != Phase.STATUS))
    {
      Object localObject1 = this.onReadyLock;
      boolean bool1 = bool2;
      try
      {
        if (this.allocated)
        {
          bool1 = bool2;
          if (this.numSentBytesQueued < this.onReadyThreshold) {
            bool1 = true;
          }
        }
        return bool1;
      }
      finally {}
    }
    return false;
  }
  
  protected abstract StreamListener listener();
  
  @VisibleForTesting
  final void notifyIfReady()
  {
    synchronized (this.onReadyLock)
    {
      boolean bool = isReady();
      if (bool) {
        listener().onReady();
      }
      return;
    }
  }
  
  protected final void onSendingBytes(int paramInt)
  {
    synchronized (this.onReadyLock)
    {
      this.numSentBytesQueued += paramInt;
      return;
    }
  }
  
  protected final void onSentBytes(int paramInt)
  {
    int j = 1;
    for (;;)
    {
      int i;
      synchronized (this.onReadyLock)
      {
        if (this.numSentBytesQueued < this.onReadyThreshold)
        {
          i = 1;
          this.numSentBytesQueued -= paramInt;
          if (this.numSentBytesQueued < this.onReadyThreshold)
          {
            paramInt = 1;
            break label85;
            if (paramInt != 0) {
              notifyIfReady();
            }
          }
        }
        else
        {
          i = 0;
          continue;
        }
        paramInt = 0;
        break label85;
        paramInt = 0;
      }
      label85:
      if ((i == 0) && (paramInt != 0)) {
        paramInt = j;
      }
    }
  }
  
  protected final void onStreamAllocated()
  {
    boolean bool2 = true;
    boolean bool1;
    if (listener() != null) {
      bool1 = true;
    }
    for (;;)
    {
      Preconditions.checkState(bool1);
      synchronized (this.onReadyLock)
      {
        if (!this.allocated)
        {
          bool1 = bool2;
          Preconditions.checkState(bool1, "Already allocated");
          this.allocated = true;
          notifyIfReady();
          return;
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
    }
  }
  
  final Phase outboundPhase()
  {
    return this.outboundPhase;
  }
  
  final Phase outboundPhase(Phase paramPhase)
  {
    Phase localPhase = this.outboundPhase;
    this.outboundPhase = verifyNextPhase(this.outboundPhase, paramPhase);
    return localPhase;
  }
  
  protected abstract void receiveMessage(InputStream paramInputStream);
  
  protected abstract void remoteEndClosed();
  
  protected final void requestMessagesFromDeframer(int paramInt)
  {
    try
    {
      this.deframer.request(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      deframeFailed(localThrowable);
    }
  }
  
  protected abstract void returnProcessedBytes(int paramInt);
  
  public final void setCompressor(Compressor paramCompressor)
  {
    this.framer.setCompressor((Compressor)Preconditions.checkNotNull(paramCompressor, "compressor"));
  }
  
  public final void setDecompressor(Decompressor paramDecompressor)
  {
    this.deframer.setDecompressor((Decompressor)Preconditions.checkNotNull(paramDecompressor, "decompressor"));
  }
  
  protected final void setMaxInboundMessageSizeProtected(int paramInt)
  {
    this.deframer.setMaxInboundMessageSize(paramInt);
  }
  
  protected final void setMaxOutboundMessageSizeProtected(int paramInt)
  {
    this.framer.setMaxOutboundMessageSize(paramInt);
  }
  
  public final void setMessageCompression(boolean paramBoolean)
  {
    this.framer.setMessageCompression(paramBoolean);
  }
  
  public String toString()
  {
    return toStringHelper().toString();
  }
  
  protected MoreObjects.ToStringHelper toStringHelper()
  {
    return MoreObjects.toStringHelper(this).add("id", id()).add("inboundPhase", inboundPhase().name()).add("outboundPhase", outboundPhase().name());
  }
  
  @VisibleForTesting
  Phase verifyNextPhase(Phase paramPhase1, Phase paramPhase2)
  {
    if (paramPhase2.ordinal() < paramPhase1.ordinal()) {
      throw new IllegalStateException(String.format("Cannot transition phase from %s to %s", new Object[] { paramPhase1, paramPhase2 }));
    }
    return paramPhase2;
  }
  
  public void writeMessage(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream, "message");
    outboundPhase(Phase.MESSAGE);
    if (!this.framer.isClosed()) {
      this.framer.writePayload(paramInputStream);
    }
  }
  
  @VisibleForTesting
  class DeframerListener
    implements MessageDeframer.Listener
  {
    DeframerListener() {}
    
    public void bytesRead(int paramInt)
    {
      AbstractStream.this.returnProcessedBytes(paramInt);
    }
    
    public void deliveryStalled()
    {
      AbstractStream.this.inboundDeliveryPaused();
    }
    
    public void endOfStream()
    {
      AbstractStream.this.remoteEndClosed();
    }
    
    public void messageRead(InputStream paramInputStream)
    {
      AbstractStream.this.receiveMessage(paramInputStream);
    }
  }
  
  @VisibleForTesting
  class FramerSink
    implements MessageFramer.Sink
  {
    FramerSink() {}
    
    public void deliverFrame(WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2)
    {
      AbstractStream.this.internalSendFrame(paramWritableBuffer, paramBoolean1, paramBoolean2);
    }
  }
  
  protected static enum Phase
  {
    HEADERS,  MESSAGE,  STATUS;
    
    private Phase() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */