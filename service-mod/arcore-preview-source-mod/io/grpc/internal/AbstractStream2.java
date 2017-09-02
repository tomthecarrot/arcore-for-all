package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Codec.Identity;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractStream2
  implements Stream
{
  protected final void endOfMessages()
  {
    framer().close();
  }
  
  public final void flush()
  {
    if (!framer().isClosed()) {
      framer().flush();
    }
  }
  
  protected abstract MessageFramer framer();
  
  public boolean isReady()
  {
    if (framer().isClosed()) {
      return false;
    }
    return transportState().isReady();
  }
  
  protected final void onSendingBytes(int paramInt)
  {
    transportState().onSendingBytes(paramInt);
  }
  
  public final void setCompressor(Compressor paramCompressor)
  {
    framer().setCompressor((Compressor)Preconditions.checkNotNull(paramCompressor, "compressor"));
  }
  
  public final void setDecompressor(Decompressor paramDecompressor)
  {
    transportState().setDecompressor((Decompressor)Preconditions.checkNotNull(paramDecompressor, "decompressor"));
  }
  
  public final void setMessageCompression(boolean paramBoolean)
  {
    framer().setMessageCompression(paramBoolean);
  }
  
  protected abstract TransportState transportState();
  
  public final void writeMessage(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream, "message");
    if (!framer().isClosed()) {
      framer().writePayload(paramInputStream);
    }
  }
  
  public static abstract class TransportState
    implements MessageDeframer.Listener
  {
    private static final int DEFAULT_ONREADY_THRESHOLD = 32768;
    @GuardedBy("onReadyLock")
    private boolean allocated;
    @GuardedBy("onReadyLock")
    private boolean deallocated;
    private final MessageDeframer deframer;
    @GuardedBy("onReadyLock")
    private int numSentBytesQueued;
    private final Object onReadyLock = new Object();
    private final StatsTraceContext statsTraceCtx;
    
    protected TransportState(int paramInt, StatsTraceContext paramStatsTraceContext)
    {
      this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
      this.deframer = new MessageDeframer(this, Codec.Identity.NONE, paramInt, paramStatsTraceContext, getClass().getName());
    }
    
    private boolean isReady()
    {
      for (;;)
      {
        synchronized (this.onReadyLock)
        {
          if ((this.allocated) && (this.numSentBytesQueued < 32768) && (!this.deallocated))
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
    
    private void notifyIfReady()
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
    
    private void onSendingBytes(int paramInt)
    {
      synchronized (this.onReadyLock)
      {
        this.numSentBytesQueued += paramInt;
        return;
      }
    }
    
    private void setDecompressor(Decompressor paramDecompressor)
    {
      if (this.deframer.isClosed()) {
        return;
      }
      this.deframer.setDecompressor(paramDecompressor);
    }
    
    protected final void closeDeframer()
    {
      this.deframer.close();
    }
    
    protected final void deframe(ReadableBuffer paramReadableBuffer, boolean paramBoolean)
    {
      if (this.deframer.isClosed())
      {
        paramReadableBuffer.close();
        return;
      }
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
    
    public final StatsTraceContext getStatsTraceContext()
    {
      return this.statsTraceCtx;
    }
    
    protected final boolean isDeframerStalled()
    {
      return this.deframer.isStalled();
    }
    
    protected abstract StreamListener listener();
    
    public void messageRead(InputStream paramInputStream)
    {
      listener().messageRead(paramInputStream);
    }
    
    public final void onSentBytes(int paramInt)
    {
      int j = 1;
      for (;;)
      {
        int i;
        synchronized (this.onReadyLock)
        {
          Preconditions.checkState(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
          if (this.numSentBytesQueued < 32768)
          {
            i = 1;
            this.numSentBytesQueued -= paramInt;
            if (this.numSentBytesQueued < 32768)
            {
              paramInt = 1;
              break label90;
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
          break label90;
          paramInt = 0;
        }
        label90:
        if ((i == 0) && (paramInt != 0)) {
          paramInt = j;
        }
      }
    }
    
    protected void onStreamAllocated()
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
    
    protected final void onStreamDeallocated()
    {
      synchronized (this.onReadyLock)
      {
        this.deallocated = true;
        return;
      }
    }
    
    public final void requestMessagesFromDeframer(int paramInt)
    {
      if (this.deframer.isClosed()) {
        return;
      }
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
    
    final void setMaxInboundMessageSize(int paramInt)
    {
      this.deframer.setMaxInboundMessageSize(paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractStream2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */