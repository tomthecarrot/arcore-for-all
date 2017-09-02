package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Attributes.Builder;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport.PingCallback;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.LogId;
import io.grpc.internal.ManagedClientTransport.Listener;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class InProcessTransport
  implements ServerTransport, ConnectionClientTransport
{
  private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
  private final String authority;
  private ManagedClientTransport.Listener clientTransportListener;
  private final LogId logId = LogId.allocate(getClass().getName());
  private final String name;
  private Attributes serverStreamAttributes;
  private ServerTransportListener serverTransportListener;
  @GuardedBy("this")
  private boolean shutdown;
  @GuardedBy("this")
  private Status shutdownStatus;
  @GuardedBy("this")
  private Set<InProcessStream> streams = new HashSet();
  @GuardedBy("this")
  private boolean terminated;
  
  public InProcessTransport(String paramString)
  {
    this(paramString, null);
  }
  
  public InProcessTransport(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.authority = paramString2;
  }
  
  /* Error */
  private void notifyShutdown(Status paramStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	io/grpc/inprocess/InProcessTransport:shutdown	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 114	io/grpc/inprocess/InProcessTransport:shutdown	Z
    //   19: aload_0
    //   20: getfield 137	io/grpc/inprocess/InProcessTransport:clientTransportListener	Lio/grpc/internal/ManagedClientTransport$Listener;
    //   23: aload_1
    //   24: invokeinterface 142 2 0
    //   29: goto -18 -> 11
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	InProcessTransport
    //   0	37	1	paramStatus	Status
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
  
  /* Error */
  private void notifyTerminated()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	io/grpc/inprocess/InProcessTransport:terminated	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 144	io/grpc/inprocess/InProcessTransport:terminated	Z
    //   19: aload_0
    //   20: getfield 137	io/grpc/inprocess/InProcessTransport:clientTransportListener	Lio/grpc/internal/ManagedClientTransport$Listener;
    //   23: invokeinterface 147 1 0
    //   28: aload_0
    //   29: getfield 133	io/grpc/inprocess/InProcessTransport:serverTransportListener	Lio/grpc/internal/ServerTransportListener;
    //   32: ifnull -21 -> 11
    //   35: aload_0
    //   36: getfield 133	io/grpc/inprocess/InProcessTransport:serverTransportListener	Lio/grpc/internal/ServerTransportListener;
    //   39: invokeinterface 150 1 0
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	InProcessTransport
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	44	47	finally
  }
  
  private static Status stripCause(Status paramStatus)
  {
    if (paramStatus == null) {
      return null;
    }
    return Status.fromCodeValue(paramStatus.getCode().value()).withDescription(paramStatus.getDescription());
  }
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata)
  {
    try
    {
      paramMethodDescriptor = newStream(paramMethodDescriptor, paramMetadata, CallOptions.DEFAULT, StatsTraceContext.NOOP);
      return paramMethodDescriptor;
    }
    finally
    {
      paramMethodDescriptor = finally;
      throw paramMethodDescriptor;
    }
  }
  
  /* Error */
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   6: ifnull +20 -> 26
    //   9: new 14	io/grpc/inprocess/InProcessTransport$3
    //   12: dup
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   18: invokespecial 204	io/grpc/inprocess/InProcessTransport$3:<init>	(Lio/grpc/inprocess/InProcessTransport;Lio/grpc/Status;)V
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: new 20	io/grpc/inprocess/InProcessTransport$InProcessStream
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 133	io/grpc/inprocess/InProcessTransport:serverTransportListener	Lio/grpc/internal/ServerTransportListener;
    //   37: aload_1
    //   38: invokevirtual 209	io/grpc/MethodDescriptor:getFullMethodName	()Ljava/lang/String;
    //   41: aload_2
    //   42: invokeinterface 213 3 0
    //   47: aload_0
    //   48: getfield 97	io/grpc/inprocess/InProcessTransport:authority	Ljava/lang/String;
    //   51: aconst_null
    //   52: invokespecial 216	io/grpc/inprocess/InProcessTransport$InProcessStream:<init>	(Lio/grpc/inprocess/InProcessTransport;Lio/grpc/MethodDescriptor;Lio/grpc/Metadata;Lio/grpc/internal/StatsTraceContext;Ljava/lang/String;Lio/grpc/inprocess/InProcessTransport$1;)V
    //   55: invokestatic 220	io/grpc/inprocess/InProcessTransport$InProcessStream:access$700	(Lio/grpc/inprocess/InProcessTransport$InProcessStream;)Lio/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream;
    //   58: astore_1
    //   59: goto -37 -> 22
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	InProcessTransport
    //   0	67	1	paramMethodDescriptor	MethodDescriptor<?, ?>
    //   0	67	2	paramMetadata	Metadata
    //   0	67	3	paramCallOptions	CallOptions
    //   0	67	4	paramStatsTraceContext	StatsTraceContext
    // Exception table:
    //   from	to	target	type
    //   2	22	62	finally
    //   26	59	62	finally
  }
  
  /* Error */
  public void ping(final ClientTransport.PingCallback paramPingCallback, java.util.concurrent.Executor paramExecutor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	io/grpc/inprocess/InProcessTransport:terminated	Z
    //   6: ifeq +25 -> 31
    //   9: aload_2
    //   10: new 16	io/grpc/inprocess/InProcessTransport$4
    //   13: dup
    //   14: aload_0
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   20: invokespecial 226	io/grpc/inprocess/InProcessTransport$4:<init>	(Lio/grpc/inprocess/InProcessTransport;Lio/grpc/internal/ClientTransport$PingCallback;Lio/grpc/Status;)V
    //   23: invokeinterface 232 2 0
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_2
    //   32: new 18	io/grpc/inprocess/InProcessTransport$5
    //   35: dup
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 235	io/grpc/inprocess/InProcessTransport$5:<init>	(Lio/grpc/inprocess/InProcessTransport;Lio/grpc/internal/ClientTransport$PingCallback;)V
    //   41: invokeinterface 232 2 0
    //   46: goto -18 -> 28
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	InProcessTransport
    //   0	54	1	paramPingCallback	ClientTransport.PingCallback
    //   0	54	2	paramExecutor	java.util.concurrent.Executor
    // Exception table:
    //   from	to	target	type
    //   2	28	49	finally
    //   31	46	49	finally
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 114	io/grpc/inprocess/InProcessTransport:shutdown	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getstatic 238	io/grpc/Status:UNAVAILABLE	Lio/grpc/Status;
    //   18: ldc -16
    //   20: invokevirtual 172	io/grpc/Status:withDescription	(Ljava/lang/String;)Lio/grpc/Status;
    //   23: putfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   31: invokespecial 103	io/grpc/inprocess/InProcessTransport:notifyShutdown	(Lio/grpc/Status;)V
    //   34: aload_0
    //   35: getfield 93	io/grpc/inprocess/InProcessTransport:streams	Ljava/util/Set;
    //   38: invokeinterface 246 1 0
    //   43: ifeq -32 -> 11
    //   46: aload_0
    //   47: invokespecial 108	io/grpc/inprocess/InProcessTransport:notifyTerminated	()V
    //   50: goto -39 -> 11
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	InProcessTransport
    //   6	2	1	bool	boolean
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   14	50	53	finally
  }
  
  public void shutdownNow(Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "reason");
    try
    {
      shutdown();
      if (this.terminated) {
        return;
      }
      Object localObject = new ArrayList(this.streams);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((InProcessStream)((Iterator)localObject).next()).clientStream.cancel(paramStatus);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  @javax.annotation.CheckReturnValue
  public Runnable start(ManagedClientTransport.Listener paramListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 137	io/grpc/inprocess/InProcessTransport:clientTransportListener	Lio/grpc/internal/ManagedClientTransport$Listener;
    //   7: aload_0
    //   8: getfield 95	io/grpc/inprocess/InProcessTransport:name	Ljava/lang/String;
    //   11: invokestatic 289	io/grpc/inprocess/InProcessServer:findServer	(Ljava/lang/String;)Lio/grpc/inprocess/InProcessServer;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_0
    //   20: aload_1
    //   21: aload_0
    //   22: invokevirtual 292	io/grpc/inprocess/InProcessServer:register	(Lio/grpc/inprocess/InProcessTransport;)Lio/grpc/internal/ServerTransportListener;
    //   25: putfield 133	io/grpc/inprocess/InProcessTransport:serverTransportListener	Lio/grpc/internal/ServerTransportListener;
    //   28: aload_0
    //   29: getfield 133	io/grpc/inprocess/InProcessTransport:serverTransportListener	Lio/grpc/internal/ServerTransportListener;
    //   32: ifnonnull +53 -> 85
    //   35: aload_0
    //   36: getstatic 238	io/grpc/Status:UNAVAILABLE	Lio/grpc/Status;
    //   39: new 294	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 297
    //   49: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 95	io/grpc/inprocess/InProcessTransport:name	Ljava/lang/String;
    //   56: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 172	io/grpc/Status:withDescription	(Ljava/lang/String;)Lio/grpc/Status;
    //   65: putfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   68: new 10	io/grpc/inprocess/InProcessTransport$1
    //   71: dup
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 202	io/grpc/inprocess/InProcessTransport:shutdownStatus	Lio/grpc/Status;
    //   77: invokespecial 305	io/grpc/inprocess/InProcessTransport$1:<init>	(Lio/grpc/inprocess/InProcessTransport;Lio/grpc/Status;)V
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: areturn
    //   85: new 12	io/grpc/inprocess/InProcessTransport$2
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 307	io/grpc/inprocess/InProcessTransport$2:<init>	(Lio/grpc/inprocess/InProcessTransport;)V
    //   93: astore_1
    //   94: goto -13 -> 81
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	InProcessTransport
    //   0	102	1	paramListener	ManagedClientTransport.Listener
    // Exception table:
    //   from	to	target	type
    //   2	15	97	finally
    //   19	28	97	finally
    //   28	81	97	finally
    //   85	94	97	finally
  }
  
  public String toString()
  {
    return getLogId() + "(" + this.name + ")";
  }
  
  private class InProcessStream
  {
    private volatile String authority;
    private final InProcessClientStream clientStream = new InProcessClientStream(null);
    private final Metadata headers;
    private final MethodDescriptor<?, ?> method;
    private final StatsTraceContext serverStatsTraceContext;
    private final InProcessServerStream serverStream = new InProcessServerStream(null);
    
    private InProcessStream(Metadata paramMetadata, StatsTraceContext paramStatsTraceContext, String paramString)
    {
      this.method = ((MethodDescriptor)Preconditions.checkNotNull(paramMetadata, "method"));
      this.headers = ((Metadata)Preconditions.checkNotNull(paramStatsTraceContext, "headers"));
      this.serverStatsTraceContext = ((StatsTraceContext)Preconditions.checkNotNull(paramString, "serverStatsTraceContext"));
      String str;
      this.authority = str;
    }
    
    private void streamClosed()
    {
      synchronized (InProcessTransport.this)
      {
        boolean bool = InProcessTransport.this.streams.remove(this);
        if ((InProcessTransport.this.streams.isEmpty()) && (bool))
        {
          InProcessTransport.this.clientTransportListener.transportInUse(false);
          if (InProcessTransport.this.shutdown) {
            InProcessTransport.this.notifyTerminated();
          }
        }
        return;
      }
    }
    
    private class InProcessClientStream
      implements ClientStream
    {
      @GuardedBy("this")
      private boolean closed;
      @GuardedBy("this")
      private boolean serverNotifyHalfClose;
      @GuardedBy("this")
      private ArrayDeque<InputStream> serverReceiveQueue = new ArrayDeque();
      @GuardedBy("this")
      private int serverRequested;
      @GuardedBy("this")
      private ServerStreamListener serverStreamListener;
      
      private InProcessClientStream() {}
      
      private boolean internalCancel(Status paramStatus)
      {
        boolean bool1 = true;
        for (;;)
        {
          try
          {
            boolean bool2 = this.closed;
            if (bool2)
            {
              bool1 = false;
              return bool1;
            }
            this.closed = true;
            InputStream localInputStream = (InputStream)this.serverReceiveQueue.poll();
            if (localInputStream != null) {
              try
              {
                localInputStream.close();
              }
              catch (Throwable localThrowable)
              {
                InProcessTransport.log.log(Level.WARNING, "Exception closing stream", localThrowable);
              }
            } else {
              this.serverStreamListener.closed(paramStatus);
            }
          }
          finally {}
        }
      }
      
      private void serverClosed(Status paramStatus)
      {
        internalCancel(paramStatus);
      }
      
      private boolean serverRequested(int paramInt)
      {
        boolean bool1 = false;
        int i;
        for (;;)
        {
          try
          {
            boolean bool2 = this.closed;
            if (bool2) {
              return bool1;
            }
            if (this.serverRequested > 0)
            {
              i = 1;
              this.serverRequested += paramInt;
              if ((this.serverRequested <= 0) || (this.serverReceiveQueue.isEmpty())) {
                break;
              }
              this.serverRequested -= 1;
              this.serverStreamListener.messageRead((InputStream)this.serverReceiveQueue.poll());
              continue;
            }
            i = 0;
          }
          finally {}
        }
        if ((this.serverReceiveQueue.isEmpty()) && (this.serverNotifyHalfClose))
        {
          this.serverNotifyHalfClose = false;
          this.serverStreamListener.halfClosed();
        }
        paramInt = this.serverRequested;
        if (paramInt > 0)
        {
          paramInt = 1;
          label141:
          if ((i != 0) || (paramInt == 0)) {
            break label159;
          }
        }
        label159:
        for (bool1 = true;; bool1 = false)
        {
          break;
          paramInt = 0;
          break label141;
        }
      }
      
      private void setListener(ServerStreamListener paramServerStreamListener)
      {
        try
        {
          this.serverStreamListener = paramServerStreamListener;
          return;
        }
        finally
        {
          paramServerStreamListener = finally;
          throw paramServerStreamListener;
        }
      }
      
      public void cancel(Status paramStatus)
      {
        if (!internalCancel(InProcessTransport.stripCause(paramStatus))) {
          return;
        }
        InProcessTransport.InProcessStream.InProcessServerStream.access$2200(InProcessTransport.InProcessStream.this.serverStream, paramStatus);
        InProcessTransport.InProcessStream.this.streamClosed();
      }
      
      public void flush() {}
      
      public Attributes getAttributes()
      {
        return Attributes.EMPTY;
      }
      
      public void halfClose()
      {
        for (;;)
        {
          try
          {
            boolean bool = this.closed;
            if (bool) {
              return;
            }
            if (this.serverReceiveQueue.isEmpty()) {
              this.serverStreamListener.halfClosed();
            } else {
              this.serverNotifyHalfClose = true;
            }
          }
          finally {}
        }
      }
      
      /* Error */
      public boolean isReady()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: aload_0
        //   3: monitorenter
        //   4: aload_0
        //   5: getfield 66	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream:closed	Z
        //   8: istore_3
        //   9: iload_3
        //   10: ifeq +7 -> 17
        //   13: aload_0
        //   14: monitorexit
        //   15: iload_2
        //   16: ireturn
        //   17: aload_0
        //   18: getfield 103	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream:serverRequested	I
        //   21: istore_1
        //   22: iload_1
        //   23: ifle -10 -> 13
        //   26: iconst_1
        //   27: istore_2
        //   28: goto -15 -> 13
        //   31: astore 4
        //   33: aload_0
        //   34: monitorexit
        //   35: aload 4
        //   37: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	38	0	this	InProcessClientStream
        //   21	2	1	i	int
        //   1	27	2	bool1	boolean
        //   8	2	3	bool2	boolean
        //   31	5	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	9	31	finally
        //   17	22	31	finally
      }
      
      public void request(int paramInt)
      {
        if (InProcessTransport.InProcessStream.InProcessServerStream.access$2100(InProcessTransport.InProcessStream.this.serverStream, paramInt)) {
          try
          {
            if (!this.closed) {
              this.serverStreamListener.onReady();
            }
            return;
          }
          finally {}
        }
      }
      
      public void setAuthority(String paramString)
      {
        InProcessTransport.InProcessStream.access$1802(InProcessTransport.InProcessStream.this, paramString);
      }
      
      public void setCompressor(Compressor paramCompressor) {}
      
      public void setDecompressor(Decompressor paramDecompressor) {}
      
      public void setMaxInboundMessageSize(int paramInt) {}
      
      public void setMaxOutboundMessageSize(int paramInt) {}
      
      public void setMessageCompression(boolean paramBoolean) {}
      
      public void start(ClientStreamListener arg1)
      {
        InProcessTransport.InProcessStream.InProcessServerStream.access$2300(InProcessTransport.InProcessStream.this.serverStream, ???);
        synchronized (InProcessTransport.this)
        {
          InProcessTransport.this.streams.add(InProcessTransport.InProcessStream.this);
          if (InProcessTransport.this.streams.size() == 1) {
            InProcessTransport.this.clientTransportListener.transportInUse(true);
          }
          InProcessTransport.this.serverTransportListener.streamCreated(InProcessTransport.InProcessStream.this.serverStream, InProcessTransport.InProcessStream.this.method.getFullMethodName(), InProcessTransport.InProcessStream.this.headers);
          return;
        }
      }
      
      public void writeMessage(InputStream paramInputStream)
      {
        for (;;)
        {
          try
          {
            boolean bool = this.closed;
            if (bool) {
              return;
            }
            if (this.serverRequested > 0)
            {
              this.serverRequested -= 1;
              this.serverStreamListener.messageRead(paramInputStream);
            }
            else
            {
              this.serverReceiveQueue.add(paramInputStream);
            }
          }
          finally {}
        }
      }
    }
    
    private class InProcessServerStream
      implements ServerStream
    {
      @GuardedBy("this")
      private Status clientNotifyStatus;
      @GuardedBy("this")
      private Metadata clientNotifyTrailers;
      @GuardedBy("this")
      private ArrayDeque<InputStream> clientReceiveQueue = new ArrayDeque();
      @GuardedBy("this")
      private int clientRequested;
      @GuardedBy("this")
      private ClientStreamListener clientStreamListener;
      @GuardedBy("this")
      private boolean closed;
      
      private InProcessServerStream() {}
      
      private void clientCancelled(Status paramStatus)
      {
        internalCancel(paramStatus);
      }
      
      private boolean clientRequested(int paramInt)
      {
        boolean bool1 = false;
        int i;
        do
        {
          for (;;)
          {
            try
            {
              boolean bool2 = this.closed;
              if (bool2) {
                return bool1;
              }
              if (this.clientRequested > 0)
              {
                i = 1;
                this.clientRequested += paramInt;
                if ((this.clientRequested <= 0) || (this.clientReceiveQueue.isEmpty())) {
                  break;
                }
                this.clientRequested -= 1;
                this.clientStreamListener.messageRead((InputStream)this.clientReceiveQueue.poll());
                continue;
              }
              i = 0;
            }
            finally {}
          }
        } while (this.closed);
        if ((this.clientReceiveQueue.isEmpty()) && (this.clientNotifyStatus != null))
        {
          this.closed = true;
          this.clientStreamListener.closed(this.clientNotifyStatus, this.clientNotifyTrailers);
        }
        paramInt = this.clientRequested;
        if (paramInt > 0)
        {
          paramInt = 1;
          label156:
          if ((i != 0) || (paramInt == 0)) {
            break label174;
          }
        }
        label174:
        for (bool1 = true;; bool1 = false)
        {
          break;
          paramInt = 0;
          break label156;
        }
      }
      
      private boolean internalCancel(Status paramStatus)
      {
        boolean bool1 = true;
        for (;;)
        {
          try
          {
            boolean bool2 = this.closed;
            if (bool2)
            {
              bool1 = false;
              return bool1;
            }
            this.closed = true;
            InputStream localInputStream = (InputStream)this.clientReceiveQueue.poll();
            if (localInputStream != null) {
              try
              {
                localInputStream.close();
              }
              catch (Throwable localThrowable)
              {
                InProcessTransport.log.log(Level.WARNING, "Exception closing stream", localThrowable);
              }
            } else {
              this.clientStreamListener.closed(paramStatus, new Metadata());
            }
          }
          finally {}
        }
      }
      
      private void setListener(ClientStreamListener paramClientStreamListener)
      {
        try
        {
          this.clientStreamListener = paramClientStreamListener;
          return;
        }
        finally
        {
          paramClientStreamListener = finally;
          throw paramClientStreamListener;
        }
      }
      
      public void cancel(Status paramStatus)
      {
        if (!internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
          return;
        }
        InProcessTransport.InProcessStream.this.clientStream.serverClosed(paramStatus);
        InProcessTransport.InProcessStream.this.streamClosed();
      }
      
      /* Error */
      public void close(Status paramStatus, Metadata paramMetadata)
      {
        // Byte code:
        //   0: aload_1
        //   1: invokestatic 151	io/grpc/inprocess/InProcessTransport:access$1400	(Lio/grpc/Status;)Lio/grpc/Status;
        //   4: astore_1
        //   5: aload_0
        //   6: monitorenter
        //   7: aload_0
        //   8: getfield 69	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:closed	Z
        //   11: ifeq +6 -> 17
        //   14: aload_0
        //   15: monitorexit
        //   16: return
        //   17: aload_0
        //   18: getfield 42	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientReceiveQueue	Ljava/util/ArrayDeque;
        //   21: invokevirtual 75	java/util/ArrayDeque:isEmpty	()Z
        //   24: ifeq +42 -> 66
        //   27: aload_0
        //   28: iconst_1
        //   29: putfield 69	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:closed	Z
        //   32: aload_0
        //   33: getfield 77	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientStreamListener	Lio/grpc/internal/ClientStreamListener;
        //   36: aload_1
        //   37: aload_2
        //   38: invokeinterface 96 3 0
        //   43: aload_0
        //   44: monitorexit
        //   45: aload_0
        //   46: getfield 34	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:this$1	Lio/grpc/inprocess/InProcessTransport$InProcessStream;
        //   49: invokestatic 138	io/grpc/inprocess/InProcessTransport$InProcessStream:access$700	(Lio/grpc/inprocess/InProcessTransport$InProcessStream;)Lio/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream;
        //   52: getstatic 154	io/grpc/Status:OK	Lio/grpc/Status;
        //   55: invokestatic 144	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream:access$1500	(Lio/grpc/inprocess/InProcessTransport$InProcessStream$InProcessClientStream;Lio/grpc/Status;)V
        //   58: aload_0
        //   59: getfield 34	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:this$1	Lio/grpc/inprocess/InProcessTransport$InProcessStream;
        //   62: invokestatic 147	io/grpc/inprocess/InProcessTransport$InProcessStream:access$1600	(Lio/grpc/inprocess/InProcessTransport$InProcessStream;)V
        //   65: return
        //   66: aload_0
        //   67: aload_1
        //   68: putfield 91	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientNotifyStatus	Lio/grpc/Status;
        //   71: aload_0
        //   72: aload_2
        //   73: putfield 93	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientNotifyTrailers	Lio/grpc/Metadata;
        //   76: goto -33 -> 43
        //   79: astore_1
        //   80: aload_0
        //   81: monitorexit
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	InProcessServerStream
        //   0	84	1	paramStatus	Status
        //   0	84	2	paramMetadata	Metadata
        // Exception table:
        //   from	to	target	type
        //   7	16	79	finally
        //   17	43	79	finally
        //   43	45	79	finally
        //   66	76	79	finally
        //   80	82	79	finally
      }
      
      public void flush() {}
      
      public Attributes getAttributes()
      {
        return InProcessTransport.this.serverStreamAttributes;
      }
      
      public String getAuthority()
      {
        return InProcessTransport.InProcessStream.this.authority;
      }
      
      /* Error */
      public boolean isReady()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: aload_0
        //   3: monitorenter
        //   4: aload_0
        //   5: getfield 69	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:closed	Z
        //   8: istore_3
        //   9: iload_3
        //   10: ifeq +7 -> 17
        //   13: aload_0
        //   14: monitorexit
        //   15: iload_2
        //   16: ireturn
        //   17: aload_0
        //   18: getfield 71	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientRequested	I
        //   21: istore_1
        //   22: iload_1
        //   23: ifle -10 -> 13
        //   26: iconst_1
        //   27: istore_2
        //   28: goto -15 -> 13
        //   31: astore 4
        //   33: aload_0
        //   34: monitorexit
        //   35: aload 4
        //   37: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	38	0	this	InProcessServerStream
        //   21	2	1	i	int
        //   1	27	2	bool1	boolean
        //   8	2	3	bool2	boolean
        //   31	5	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	9	31	finally
        //   17	22	31	finally
      }
      
      public void request(int paramInt)
      {
        if (InProcessTransport.InProcessStream.this.clientStream.serverRequested(paramInt)) {
          try
          {
            if (!this.closed) {
              this.clientStreamListener.onReady();
            }
            return;
          }
          finally {}
        }
      }
      
      public void setCompressor(Compressor paramCompressor) {}
      
      public void setDecompressor(Decompressor paramDecompressor) {}
      
      public void setListener(ServerStreamListener paramServerStreamListener)
      {
        InProcessTransport.InProcessStream.this.clientStream.setListener(paramServerStreamListener);
      }
      
      public void setMessageCompression(boolean paramBoolean) {}
      
      public StatsTraceContext statsTraceContext()
      {
        return InProcessTransport.InProcessStream.this.serverStatsTraceContext;
      }
      
      /* Error */
      public void writeHeaders(Metadata paramMetadata)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 69	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:closed	Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifeq +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: aload_0
        //   15: getfield 77	io/grpc/inprocess/InProcessTransport$InProcessStream$InProcessServerStream:clientStreamListener	Lio/grpc/internal/ClientStreamListener;
        //   18: aload_1
        //   19: invokeinterface 203 2 0
        //   24: goto -13 -> 11
        //   27: astore_1
        //   28: aload_0
        //   29: monitorexit
        //   30: aload_1
        //   31: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	32	0	this	InProcessServerStream
        //   0	32	1	paramMetadata	Metadata
        //   6	2	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	27	finally
        //   14	24	27	finally
      }
      
      public void writeMessage(InputStream paramInputStream)
      {
        for (;;)
        {
          try
          {
            boolean bool = this.closed;
            if (bool) {
              return;
            }
            if (this.clientRequested > 0)
            {
              this.clientRequested -= 1;
              this.clientStreamListener.messageRead(paramInputStream);
            }
            else
            {
              this.clientReceiveQueue.add(paramInputStream);
            }
          }
          finally {}
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/inprocess/InProcessTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */