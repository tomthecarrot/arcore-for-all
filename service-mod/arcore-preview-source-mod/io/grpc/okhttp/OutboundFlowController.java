package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;
import okio.Buffer;

class OutboundFlowController
{
  private final OutboundFlowState connectionState = new OutboundFlowState(0);
  private final FrameWriter frameWriter;
  private int initialWindowSize = 65535;
  private final OkHttpClientTransport transport;
  
  OutboundFlowController(OkHttpClientTransport paramOkHttpClientTransport, FrameWriter paramFrameWriter)
  {
    this.transport = ((OkHttpClientTransport)Preconditions.checkNotNull(paramOkHttpClientTransport, "transport"));
    this.frameWriter = ((FrameWriter)Preconditions.checkNotNull(paramFrameWriter, "frameWriter"));
  }
  
  private OutboundFlowState state(OkHttpClientStream paramOkHttpClientStream)
  {
    OutboundFlowState localOutboundFlowState2 = (OutboundFlowState)paramOkHttpClientStream.getOutboundFlowState();
    OutboundFlowState localOutboundFlowState1 = localOutboundFlowState2;
    if (localOutboundFlowState2 == null)
    {
      localOutboundFlowState1 = new OutboundFlowState(paramOkHttpClientStream);
      paramOkHttpClientStream.setOutboundFlowState(localOutboundFlowState1);
    }
    return localOutboundFlowState1;
  }
  
  private void writeStreams()
  {
    Object localObject1 = this.transport.getActiveStreams();
    int n = this.connectionState.window();
    int j = localObject1.length;
    int k;
    int i;
    label48:
    Object localObject2;
    OutboundFlowState localOutboundFlowState;
    int m;
    if ((j > 0) && (n > 0))
    {
      int i1 = (int)Math.ceil(n / j);
      k = 0;
      i = 0;
      if ((k < j) && (n > 0))
      {
        localObject2 = localObject1[k];
        localOutboundFlowState = state((OkHttpClientStream)localObject2);
        int i2 = Math.min(n, Math.min(localOutboundFlowState.unallocatedBytes(), i1));
        m = n;
        if (i2 > 0)
        {
          localOutboundFlowState.allocateBytes(i2);
          m = n - i2;
        }
        if (localOutboundFlowState.unallocatedBytes() <= 0) {
          break label228;
        }
        n = i + 1;
        localObject1[i] = localObject2;
        i = n;
      }
    }
    label228:
    for (;;)
    {
      k += 1;
      n = m;
      break label48;
      j = i;
      break;
      localObject1 = new WriteStatus(null);
      localObject2 = this.transport.getActiveStreams();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localOutboundFlowState = state(localObject2[i]);
        localOutboundFlowState.writeBytes(localOutboundFlowState.allocatedBytes(), (WriteStatus)localObject1);
        localOutboundFlowState.clearAllocatedBytes();
        i += 1;
      }
      if (((WriteStatus)localObject1).hasWritten()) {
        flush();
      }
      return;
    }
  }
  
  void data(boolean paramBoolean1, int paramInt, Buffer paramBuffer, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramBuffer, "source");
    Object localObject = this.transport.getStream(paramInt);
    if (localObject == null) {}
    do
    {
      do
      {
        boolean bool;
        do
        {
          return;
          localObject = state((OkHttpClientStream)localObject);
          paramInt = ((OutboundFlowState)localObject).writableWindow();
          bool = ((OutboundFlowState)localObject).hasFrame();
          paramBuffer = ((OutboundFlowState)localObject).newFrame(paramBuffer, paramBoolean1);
          if ((bool) || (paramInt < paramBuffer.size())) {
            break;
          }
          paramBuffer.write();
        } while (!paramBoolean2);
        flush();
        return;
        paramBuffer.enqueue();
        if ((!bool) && (paramInt > 0)) {
          break;
        }
      } while (!paramBoolean2);
      flush();
      return;
      paramBuffer.split(paramInt).write();
    } while (!paramBoolean2);
    flush();
  }
  
  void flush()
  {
    try
    {
      this.frameWriter.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  void initialOutboundWindowSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid initial window size: " + paramInt);
    }
    int i = paramInt - this.initialWindowSize;
    this.initialWindowSize = paramInt;
    OkHttpClientStream[] arrayOfOkHttpClientStream = this.transport.getActiveStreams();
    int j = arrayOfOkHttpClientStream.length;
    paramInt = 0;
    if (paramInt < j)
    {
      OkHttpClientStream localOkHttpClientStream = arrayOfOkHttpClientStream[paramInt];
      OutboundFlowState localOutboundFlowState = (OutboundFlowState)localOkHttpClientStream.getOutboundFlowState();
      if (localOutboundFlowState == null) {
        localOkHttpClientStream.setOutboundFlowState(new OutboundFlowState(localOkHttpClientStream));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localOutboundFlowState.incrementStreamWindow(i);
      }
    }
    if (i > 0) {
      writeStreams();
    }
  }
  
  void windowUpdate(@Nullable OkHttpClientStream paramOkHttpClientStream, int paramInt)
  {
    if (paramOkHttpClientStream == null)
    {
      this.connectionState.incrementStreamWindow(paramInt);
      writeStreams();
    }
    WriteStatus localWriteStatus;
    do
    {
      return;
      paramOkHttpClientStream = state(paramOkHttpClientStream);
      paramOkHttpClientStream.incrementStreamWindow(paramInt);
      localWriteStatus = new WriteStatus(null);
      paramOkHttpClientStream.writeBytes(paramOkHttpClientStream.writableWindow(), localWriteStatus);
    } while (!localWriteStatus.hasWritten());
    flush();
  }
  
  private final class OutboundFlowState
  {
    int allocatedBytes;
    final Queue<Frame> pendingWriteQueue;
    int queuedBytes;
    OkHttpClientStream stream;
    final int streamId;
    int window = OutboundFlowController.this.initialWindowSize;
    
    OutboundFlowState(int paramInt)
    {
      this.streamId = paramInt;
      this.pendingWriteQueue = new ArrayDeque(2);
    }
    
    OutboundFlowState(OkHttpClientStream paramOkHttpClientStream)
    {
      this(paramOkHttpClientStream.id());
      this.stream = paramOkHttpClientStream;
    }
    
    private Frame peek()
    {
      return (Frame)this.pendingWriteQueue.peek();
    }
    
    void allocateBytes(int paramInt)
    {
      this.allocatedBytes += paramInt;
    }
    
    int allocatedBytes()
    {
      return this.allocatedBytes;
    }
    
    void clearAllocatedBytes()
    {
      this.allocatedBytes = 0;
    }
    
    boolean hasFrame()
    {
      return !this.pendingWriteQueue.isEmpty();
    }
    
    int incrementStreamWindow(int paramInt)
    {
      if ((paramInt > 0) && (Integer.MAX_VALUE - paramInt < this.window)) {
        throw new IllegalArgumentException("Window size overflow for stream: " + this.streamId);
      }
      this.window += paramInt;
      return this.window;
    }
    
    Frame newFrame(Buffer paramBuffer, boolean paramBoolean)
    {
      return new Frame(paramBuffer, paramBoolean);
    }
    
    int streamableBytes()
    {
      return Math.max(0, Math.min(this.window, this.queuedBytes));
    }
    
    int unallocatedBytes()
    {
      return streamableBytes() - this.allocatedBytes;
    }
    
    int window()
    {
      return this.window;
    }
    
    int writableWindow()
    {
      return Math.min(this.window, OutboundFlowController.this.connectionState.window());
    }
    
    int writeBytes(int paramInt, OutboundFlowController.WriteStatus paramWriteStatus)
    {
      int i = 0;
      int j = Math.min(paramInt, writableWindow());
      Frame localFrame;
      if (hasFrame())
      {
        localFrame = peek();
        if (j >= localFrame.size())
        {
          paramWriteStatus.incrementNumWrites();
          i += localFrame.size();
          localFrame.write();
        }
      }
      for (;;)
      {
        j = Math.min(paramInt - i, writableWindow());
        break;
        if (j <= 0) {
          return i;
        }
        localFrame = localFrame.split(j);
        paramWriteStatus.incrementNumWrites();
        i += localFrame.size();
        localFrame.write();
      }
    }
    
    private final class Frame
    {
      final Buffer data;
      final boolean endStream;
      boolean enqueued;
      
      static
      {
        if (!OutboundFlowController.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          return;
        }
      }
      
      Frame(Buffer paramBuffer, boolean paramBoolean)
      {
        this.data = paramBuffer;
        this.endStream = paramBoolean;
      }
      
      void enqueue()
      {
        if (!this.enqueued)
        {
          this.enqueued = true;
          OutboundFlowController.OutboundFlowState.this.pendingWriteQueue.offer(this);
          OutboundFlowController.OutboundFlowState localOutboundFlowState = OutboundFlowController.OutboundFlowState.this;
          localOutboundFlowState.queuedBytes += size();
        }
      }
      
      int size()
      {
        return (int)this.data.size();
      }
      
      Frame split(int paramInt)
      {
        assert (paramInt < size()) : "Attempting to split a frame for the full size.";
        paramInt = Math.min(paramInt, (int)this.data.size());
        Object localObject = new Buffer();
        ((Buffer)localObject).write(this.data, paramInt);
        localObject = new Frame(OutboundFlowController.OutboundFlowState.this, (Buffer)localObject, false);
        if (this.enqueued)
        {
          OutboundFlowController.OutboundFlowState localOutboundFlowState = OutboundFlowController.OutboundFlowState.this;
          localOutboundFlowState.queuedBytes -= paramInt;
        }
        return (Frame)localObject;
      }
      
      void write()
      {
        do
        {
          int i = size();
          int j = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
          if (j == i)
          {
            OutboundFlowController.this.connectionState.incrementStreamWindow(-i);
            OutboundFlowController.OutboundFlowState.this.incrementStreamWindow(-i);
            try
            {
              OutboundFlowController.this.frameWriter.data(this.endStream, OutboundFlowController.OutboundFlowState.this.streamId, this.data, i);
              OutboundFlowController.OutboundFlowState.this.stream.onStreamSentBytes(i);
              if (this.enqueued)
              {
                OutboundFlowController.OutboundFlowState localOutboundFlowState = OutboundFlowController.OutboundFlowState.this;
                localOutboundFlowState.queuedBytes -= i;
                OutboundFlowController.OutboundFlowState.this.pendingWriteQueue.remove(this);
              }
              return;
            }
            catch (IOException localIOException)
            {
              throw new RuntimeException(localIOException);
            }
          }
          split(j).write();
        } while (size() > 0);
      }
    }
  }
  
  private static final class WriteStatus
  {
    int numWrites;
    
    boolean hasWritten()
    {
      return this.numWrites > 0;
    }
    
    void incrementNumWrites()
    {
      this.numWrites += 1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OutboundFlowController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */