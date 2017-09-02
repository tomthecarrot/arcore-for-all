package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import io.grpc.Codec.Identity;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class MessageFramer
{
  private static final byte COMPRESSED = 1;
  private static final int HEADER_LENGTH = 5;
  private static final int NO_MAX_OUTBOUND_MESSAGE_SIZE = -1;
  private static final byte UNCOMPRESSED = 0;
  private WritableBuffer buffer;
  private final WritableBufferAllocator bufferAllocator;
  private boolean closed;
  private Compressor compressor = Codec.Identity.NONE;
  private final byte[] headerScratch = new byte[5];
  private int maxOutboundMessageSize = -1;
  private boolean messageCompression = true;
  private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter(null);
  private final Sink sink;
  private final StatsTraceContext statsTraceCtx;
  
  public MessageFramer(Sink paramSink, WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext)
  {
    this.sink = ((Sink)Preconditions.checkNotNull(paramSink, "sink"));
    this.bufferAllocator = ((WritableBufferAllocator)Preconditions.checkNotNull(paramWritableBufferAllocator, "bufferAllocator"));
    this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
  }
  
  private void commitToSink(boolean paramBoolean1, boolean paramBoolean2)
  {
    WritableBuffer localWritableBuffer = this.buffer;
    this.buffer = null;
    this.sink.deliverFrame(localWritableBuffer, paramBoolean1, paramBoolean2);
  }
  
  private int getKnownLength(InputStream paramInputStream)
    throws IOException
  {
    if (((paramInputStream instanceof KnownLength)) || ((paramInputStream instanceof ByteArrayInputStream))) {
      return paramInputStream.available();
    }
    return -1;
  }
  
  private void releaseBuffer()
  {
    if (this.buffer != null)
    {
      this.buffer.release();
      this.buffer = null;
    }
  }
  
  private void verifyNotClosed()
  {
    if (isClosed()) {
      throw new IllegalStateException("Framer already closed");
    }
  }
  
  private void writeBufferChain(BufferChainOutputStream paramBufferChainOutputStream, boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(this.headerScratch);
    if (paramBoolean) {}
    int j;
    WritableBuffer localWritableBuffer;
    for (byte b = 1;; b = 0)
    {
      localByteBuffer.put(b);
      j = paramBufferChainOutputStream.readableBytes();
      localByteBuffer.putInt(j);
      localWritableBuffer = this.bufferAllocator.allocate(5);
      localWritableBuffer.write(this.headerScratch, 0, localByteBuffer.position());
      if (j != 0) {
        break;
      }
      this.buffer = localWritableBuffer;
      return;
    }
    this.sink.deliverFrame(localWritableBuffer, false, false);
    paramBufferChainOutputStream = paramBufferChainOutputStream.bufferList;
    int i = 0;
    while (i < paramBufferChainOutputStream.size() - 1)
    {
      this.sink.deliverFrame((WritableBuffer)paramBufferChainOutputStream.get(i), false, false);
      i += 1;
    }
    this.buffer = ((WritableBuffer)paramBufferChainOutputStream.get(paramBufferChainOutputStream.size() - 1));
    this.statsTraceCtx.wireBytesSent(j);
  }
  
  private int writeCompressed(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    BufferChainOutputStream localBufferChainOutputStream = new BufferChainOutputStream(null);
    OutputStream localOutputStream = this.compressor.compress(localBufferChainOutputStream);
    try
    {
      paramInt = writeToOutputStream(paramInputStream, localOutputStream);
      localOutputStream.close();
      if ((this.maxOutboundMessageSize >= 0) && (paramInt > this.maxOutboundMessageSize)) {
        throw Status.CANCELLED.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
      }
    }
    finally
    {
      localOutputStream.close();
    }
    writeBufferChain(localBufferChainOutputStream, true);
    return paramInt;
  }
  
  private int writeKnownLengthUncompressed(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if ((this.maxOutboundMessageSize >= 0) && (paramInt > this.maxOutboundMessageSize)) {
      throw Status.CANCELLED.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(this.headerScratch);
    localByteBuffer.put((byte)0);
    localByteBuffer.putInt(paramInt);
    if (this.buffer == null) {
      this.buffer = this.bufferAllocator.allocate(localByteBuffer.position() + paramInt);
    }
    writeRaw(this.headerScratch, 0, localByteBuffer.position());
    return writeToOutputStream(paramInputStream, this.outputStreamAdapter);
  }
  
  private void writeRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      if ((this.buffer != null) && (this.buffer.writableBytes() == 0)) {
        commitToSink(false, false);
      }
      if (this.buffer == null) {
        this.buffer = this.bufferAllocator.allocate(paramInt2);
      }
      int i = Math.min(paramInt2, this.buffer.writableBytes());
      this.buffer.write(paramArrayOfByte, paramInt1, i);
      paramInt1 += i;
      paramInt2 -= i;
    }
  }
  
  private static int writeToOutputStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramInputStream instanceof Drainable)) {
      return ((Drainable)paramInputStream).drainTo(paramOutputStream);
    }
    long l = ByteStreams.copy(paramInputStream, paramOutputStream);
    if (l <= 2147483647L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Message size overflow: %s", new Object[] { Long.valueOf(l) });
      return (int)l;
    }
  }
  
  private int writeUncompressed(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInt != -1)
    {
      this.statsTraceCtx.wireBytesSent(paramInt);
      return writeKnownLengthUncompressed(paramInputStream, paramInt);
    }
    BufferChainOutputStream localBufferChainOutputStream = new BufferChainOutputStream(null);
    paramInt = writeToOutputStream(paramInputStream, localBufferChainOutputStream);
    if ((this.maxOutboundMessageSize >= 0) && (paramInt > this.maxOutboundMessageSize)) {
      throw Status.INTERNAL.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
    }
    writeBufferChain(localBufferChainOutputStream, false);
    return paramInt;
  }
  
  public void close()
  {
    if (!isClosed())
    {
      this.closed = true;
      if ((this.buffer != null) && (this.buffer.readableBytes() == 0)) {
        releaseBuffer();
      }
      commitToSink(true, true);
    }
  }
  
  public void dispose()
  {
    this.closed = true;
    releaseBuffer();
  }
  
  public void flush()
  {
    if ((this.buffer != null) && (this.buffer.readableBytes() > 0)) {
      commitToSink(false, true);
    }
  }
  
  public boolean isClosed()
  {
    return this.closed;
  }
  
  MessageFramer setCompressor(Compressor paramCompressor)
  {
    this.compressor = ((Compressor)Preconditions.checkNotNull(paramCompressor, "Can't pass an empty compressor"));
    return this;
  }
  
  void setMaxOutboundMessageSize(int paramInt)
  {
    if (this.maxOutboundMessageSize == -1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "max size already set");
      this.maxOutboundMessageSize = paramInt;
      return;
    }
  }
  
  MessageFramer setMessageCompression(boolean paramBoolean)
  {
    this.messageCompression = paramBoolean;
    return this;
  }
  
  public void writePayload(InputStream paramInputStream)
  {
    verifyNotClosed();
    int i;
    if ((this.messageCompression) && (this.compressor != Codec.Identity.NONE)) {
      i = 1;
    }
    try
    {
      int j = getKnownLength(paramInputStream);
      if ((j != 0) && (i != 0)) {}
      for (i = writeCompressed(paramInputStream, j);; i = writeUncompressed(paramInputStream, j))
      {
        if ((j == -1) || (i == j)) {
          break label141;
        }
        paramInputStream = String.format("Message length inaccurate %s != %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        throw Status.INTERNAL.withDescription(paramInputStream).asRuntimeException();
        i = 0;
        break;
      }
      this.statsTraceCtx.uncompressedBytesSent(i);
    }
    catch (IOException paramInputStream)
    {
      throw Status.INTERNAL.withDescription("Failed to frame message").withCause(paramInputStream).asRuntimeException();
    }
    catch (RuntimeException paramInputStream)
    {
      throw Status.INTERNAL.withDescription("Failed to frame message").withCause(paramInputStream).asRuntimeException();
    }
    label141:
  }
  
  private final class BufferChainOutputStream
    extends OutputStream
  {
    private final List<WritableBuffer> bufferList = new ArrayList();
    private WritableBuffer current;
    
    private BufferChainOutputStream() {}
    
    private int readableBytes()
    {
      int i = 0;
      Iterator localIterator = this.bufferList.iterator();
      while (localIterator.hasNext()) {
        i += ((WritableBuffer)localIterator.next()).readableBytes();
      }
      return i;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if ((this.current != null) && (this.current.writableBytes() > 0))
      {
        this.current.write((byte)paramInt);
        return;
      }
      write(new byte[] { (byte)paramInt }, 0, 1);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      int j = paramInt2;
      if (this.current == null)
      {
        this.current = MessageFramer.this.bufferAllocator.allocate(paramInt2);
        this.bufferList.add(this.current);
        j = paramInt2;
        i = paramInt1;
      }
      while (j > 0)
      {
        paramInt1 = Math.min(j, this.current.writableBytes());
        if (paramInt1 == 0)
        {
          paramInt1 = Math.max(j, this.current.readableBytes() * 2);
          this.current = MessageFramer.this.bufferAllocator.allocate(paramInt1);
          this.bufferList.add(this.current);
        }
        else
        {
          this.current.write(paramArrayOfByte, i, paramInt1);
          i += paramInt1;
          j -= paramInt1;
        }
      }
    }
  }
  
  private class OutputStreamAdapter
    extends OutputStream
  {
    private OutputStreamAdapter() {}
    
    public void write(int paramInt)
    {
      write(new byte[] { (byte)paramInt }, 0, 1);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      MessageFramer.this.writeRaw(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static abstract interface Sink
  {
    public abstract void deliverFrame(@Nullable WritableBuffer paramWritableBuffer, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/MessageFramer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */