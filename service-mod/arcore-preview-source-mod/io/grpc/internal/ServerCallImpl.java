package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import io.grpc.Attributes;
import io.grpc.Codec.Identity;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context.CancellableContext;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class ServerCallImpl<ReqT, RespT>
  extends ServerCall<ReqT, RespT>
{
  private volatile boolean cancelled;
  private boolean closeCalled;
  private Compressor compressor;
  private final CompressorRegistry compressorRegistry;
  private final Context.CancellableContext context;
  private final DecompressorRegistry decompressorRegistry;
  private final byte[] messageAcceptEncoding;
  private final MethodDescriptor<ReqT, RespT> method;
  private boolean sendHeadersCalled;
  private final StatsTraceContext statsTraceCtx;
  private final ServerStream stream;
  
  ServerCallImpl(ServerStream paramServerStream, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, Metadata paramMetadata, Context.CancellableContext paramCancellableContext, StatsTraceContext paramStatsTraceContext, DecompressorRegistry paramDecompressorRegistry, CompressorRegistry paramCompressorRegistry)
  {
    this.stream = paramServerStream;
    this.method = paramMethodDescriptor;
    this.context = paramCancellableContext;
    this.messageAcceptEncoding = ((byte[])paramMetadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY));
    this.decompressorRegistry = paramDecompressorRegistry;
    this.compressorRegistry = paramCompressorRegistry;
    this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
    if (paramMetadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY))
    {
      paramMethodDescriptor = (String)paramMetadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
      paramMetadata = paramDecompressorRegistry.lookupDecompressor(paramMethodDescriptor);
      if (paramMetadata == null) {
        throw Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", new Object[] { paramMethodDescriptor })).asRuntimeException();
      }
      paramServerStream.setDecompressor(paramMetadata);
    }
  }
  
  public void close(Status paramStatus, Metadata paramMetadata)
  {
    if (!this.closeCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "call already closed");
      this.closeCalled = true;
      this.stream.close(paramStatus, paramMetadata);
      return;
    }
  }
  
  public Attributes getAttributes()
  {
    return this.stream.getAttributes();
  }
  
  public MethodDescriptor<ReqT, RespT> getMethodDescriptor()
  {
    return this.method;
  }
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public boolean isReady()
  {
    return this.stream.isReady();
  }
  
  ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> paramListener)
  {
    return new ServerStreamListenerImpl(this, paramListener, this.context, this.statsTraceCtx);
  }
  
  public void request(int paramInt)
  {
    this.stream.request(paramInt);
  }
  
  public void sendHeaders(Metadata paramMetadata)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.sendHeadersCalled)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "sendHeaders has already been called");
      bool1 = bool2;
      if (!this.closeCalled) {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "call is closed");
      paramMetadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
      if (this.compressor != null) {
        break label136;
      }
      this.compressor = Codec.Identity.NONE;
    }
    for (;;)
    {
      paramMetadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
      this.stream.setCompressor(this.compressor);
      paramMetadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
      byte[] arrayOfByte = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
      if (arrayOfByte.length != 0) {
        paramMetadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, arrayOfByte);
      }
      this.sendHeadersCalled = true;
      this.stream.writeHeaders(paramMetadata);
      return;
      bool1 = false;
      break;
      label136:
      if (this.messageAcceptEncoding != null)
      {
        if (!GrpcUtil.ACCEPT_ENCODING_SPLITTER.splitToList(new String(this.messageAcceptEncoding, GrpcUtil.US_ASCII)).contains(this.compressor.getMessageEncoding())) {
          this.compressor = Codec.Identity.NONE;
        }
      }
      else {
        this.compressor = Codec.Identity.NONE;
      }
    }
  }
  
  public void sendMessage(RespT paramRespT)
  {
    Preconditions.checkState(this.sendHeadersCalled, "sendHeaders has not been called");
    if (!this.closeCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "call is closed");
      try
      {
        paramRespT = this.method.streamResponse(paramRespT);
        this.stream.writeMessage(paramRespT);
        this.stream.flush();
        return;
      }
      catch (RuntimeException paramRespT)
      {
        close(Status.fromThrowable(paramRespT), new Metadata());
        throw paramRespT;
      }
      catch (Throwable paramRespT)
      {
        close(Status.fromThrowable(paramRespT), new Metadata());
        throw new RuntimeException(paramRespT);
      }
    }
  }
  
  public void setCompression(String paramString)
  {
    if (!this.sendHeadersCalled)
    {
      bool = true;
      Preconditions.checkState(bool, "sendHeaders has been called");
      this.compressor = this.compressorRegistry.lookupCompressor(paramString);
      if (this.compressor == null) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Unable to find compressor by name %s", new Object[] { paramString });
      return;
      bool = false;
      break;
    }
  }
  
  public void setMessageCompression(boolean paramBoolean)
  {
    this.stream.setMessageCompression(paramBoolean);
  }
  
  @VisibleForTesting
  static final class ServerStreamListenerImpl<ReqT>
    implements ServerStreamListener
  {
    private final ServerCallImpl<ReqT, ?> call;
    private final Context.CancellableContext context;
    private final ServerCall.Listener<ReqT> listener;
    private boolean messageReceived;
    private final StatsTraceContext statsTraceCtx;
    
    public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> paramServerCallImpl, ServerCall.Listener<ReqT> paramListener, Context.CancellableContext paramCancellableContext, StatsTraceContext paramStatsTraceContext)
    {
      this.call = ((ServerCallImpl)Preconditions.checkNotNull(paramServerCallImpl, "call"));
      this.listener = ((ServerCall.Listener)Preconditions.checkNotNull(paramListener, "listener must not be null"));
      this.context = ((Context.CancellableContext)Preconditions.checkNotNull(paramCancellableContext, "context"));
      this.statsTraceCtx = ((StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx"));
    }
    
    /* Error */
    public void closed(Status paramStatus)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 53	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:statsTraceCtx	Lio/grpc/internal/StatsTraceContext;
      //   4: aload_1
      //   5: invokevirtual 61	io/grpc/internal/StatsTraceContext:callEnded	(Lio/grpc/Status;)V
      //   8: aload_1
      //   9: invokevirtual 67	io/grpc/Status:isOk	()Z
      //   12: ifeq +20 -> 32
      //   15: aload_0
      //   16: getfield 43	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:listener	Lio/grpc/ServerCall$Listener;
      //   19: invokevirtual 70	io/grpc/ServerCall$Listener:onComplete	()V
      //   22: aload_0
      //   23: getfield 48	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:context	Lio/grpc/Context$CancellableContext;
      //   26: aconst_null
      //   27: invokevirtual 74	io/grpc/Context$CancellableContext:cancel	(Ljava/lang/Throwable;)Z
      //   30: pop
      //   31: return
      //   32: aload_0
      //   33: getfield 37	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:call	Lio/grpc/internal/ServerCallImpl;
      //   36: iconst_1
      //   37: invokestatic 78	io/grpc/internal/ServerCallImpl:access$002	(Lio/grpc/internal/ServerCallImpl;Z)Z
      //   40: pop
      //   41: aload_0
      //   42: getfield 43	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:listener	Lio/grpc/ServerCall$Listener;
      //   45: invokevirtual 81	io/grpc/ServerCall$Listener:onCancel	()V
      //   48: goto -26 -> 22
      //   51: astore_1
      //   52: aload_0
      //   53: getfield 48	io/grpc/internal/ServerCallImpl$ServerStreamListenerImpl:context	Lio/grpc/Context$CancellableContext;
      //   56: aconst_null
      //   57: invokevirtual 74	io/grpc/Context$CancellableContext:cancel	(Ljava/lang/Throwable;)Z
      //   60: pop
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	ServerStreamListenerImpl
      //   0	63	1	paramStatus	Status
      // Exception table:
      //   from	to	target	type
      //   0	22	51	finally
      //   32	48	51	finally
    }
    
    public void halfClosed()
    {
      if (this.call.cancelled) {
        return;
      }
      this.listener.onHalfClose();
    }
    
    public void messageRead(InputStream paramInputStream)
    {
      try
      {
        boolean bool = this.call.cancelled;
        if (bool)
        {
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            throw new RuntimeException(paramInputStream);
          }
          finally
          {
            if (0 != 0)
            {
              MoreThrowables.throwIfUnchecked(null);
              throw new RuntimeException(null);
            }
          }
        }
        else if ((this.messageReceived) && (this.call.method.getType() == MethodDescriptor.MethodType.UNARY))
        {
          this.call.stream.close(Status.INTERNAL.withDescription("More than one request messages for unary call or server streaming call"), new Metadata());
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            throw new RuntimeException(paramInputStream);
          }
          finally
          {
            if (0 != 0)
            {
              MoreThrowables.throwIfUnchecked(null);
              throw new RuntimeException(null);
            }
          }
        }
        else
        {
          this.messageReceived = true;
          this.listener.onMessage(this.call.method.parseRequest(paramInputStream));
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          throw new RuntimeException(paramInputStream);
        }
        finally
        {
          if (localThrowable != null)
          {
            MoreThrowables.throwIfUnchecked(localThrowable);
            throw new RuntimeException(localThrowable);
          }
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          throw new RuntimeException(paramInputStream);
        }
        finally
        {
          if (0 != 0)
          {
            MoreThrowables.throwIfUnchecked(null);
            throw new RuntimeException(null);
          }
        }
      }
    }
    
    public void onReady()
    {
      if (this.call.cancelled) {
        return;
      }
      this.listener.onReady();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerCallImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */