package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.LoadBalancer.PickResult;
import io.grpc.LoadBalancer.PickSubchannelArgs;
import io.grpc.LoadBalancer.SubchannelPicker;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor<**>;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class DelayedClientTransport
  implements ManagedClientTransport
{
  private final ChannelExecutor channelExecutor;
  private final Executor defaultAppExecutor;
  @Nullable
  @GuardedBy("lock")
  private LoadBalancer.SubchannelPicker lastPicker;
  @GuardedBy("lock")
  private long lastPickerVersion;
  private final Object lock = new Object();
  private final LogId lodId = LogId.allocate(getClass().getName());
  @GuardedBy("lock")
  private Collection<PendingStream> pendingStreams = new LinkedHashSet();
  private Runnable reportTransportInUse;
  private Runnable reportTransportNotInUse;
  private Runnable reportTransportShutdown;
  private Runnable reportTransportTerminated;
  @GuardedBy("lock")
  private boolean shutdown;
  
  DelayedClientTransport(Executor paramExecutor, ChannelExecutor paramChannelExecutor)
  {
    this.defaultAppExecutor = paramExecutor;
    this.channelExecutor = paramChannelExecutor;
  }
  
  @GuardedBy("lock")
  private PendingStream createPendingStream(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs, StatsTraceContext paramStatsTraceContext)
  {
    paramPickSubchannelArgs = new PendingStream(paramPickSubchannelArgs, paramStatsTraceContext, null);
    this.pendingStreams.add(paramPickSubchannelArgs);
    if (this.pendingStreams.size() == 1) {
      this.channelExecutor.executeLater(this.reportTransportInUse);
    }
    return paramPickSubchannelArgs;
  }
  
  public LogId getLogId()
  {
    return this.lodId;
  }
  
  @VisibleForTesting
  final int getPendingStreamsCount()
  {
    synchronized (this.lock)
    {
      if (this.pendingStreams == null)
      {
        i = 0;
        return i;
      }
      int i = this.pendingStreams.size();
    }
  }
  
  public final boolean hasPendingStreams()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if ((this.pendingStreams != null) && (!this.pendingStreams.isEmpty()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata)
  {
    return newStream(paramMethodDescriptor, paramMetadata, CallOptions.DEFAULT, StatsTraceContext.NOOP);
  }
  
  public final ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    ??? = null;
    try
    {
      paramMetadata = new PickSubchannelArgsImpl(paramMethodDescriptor, paramMetadata, paramCallOptions);
      long l = -1L;
      Object localObject2 = this.lock;
      paramMethodDescriptor = (MethodDescriptor<?, ?>)???;
      for (;;)
      {
        try
        {
          if (!this.shutdown)
          {
            if (this.lastPicker == null)
            {
              paramMethodDescriptor = createPendingStream(paramMetadata, paramStatsTraceContext);
              return paramMethodDescriptor;
            }
            paramMethodDescriptor = this.lastPicker;
            l = this.lastPickerVersion;
          }
          if (paramMethodDescriptor != null)
          {
            paramMethodDescriptor = GrpcUtil.getTransportFromPickResult(paramMethodDescriptor.pickSubchannel(paramMetadata), paramCallOptions.isWaitForReady());
            if (paramMethodDescriptor != null)
            {
              paramMethodDescriptor = paramMethodDescriptor.newStream(paramMetadata.getMethodDescriptor(), paramMetadata.getHeaders(), paramMetadata.getCallOptions(), paramStatsTraceContext);
              return paramMethodDescriptor;
            }
          }
        }
        finally {}
        synchronized (this.lock)
        {
          if (this.shutdown)
          {
            paramMethodDescriptor = new FailingClientStream(Status.UNAVAILABLE.withDescription("Channel has shutdown (reported by delayed transport)"));
            return paramMethodDescriptor;
          }
          if (l == this.lastPickerVersion)
          {
            paramMethodDescriptor = createPendingStream(paramMetadata, paramStatsTraceContext);
            return paramMethodDescriptor;
          }
          paramMethodDescriptor = this.lastPicker;
          l = this.lastPickerVersion;
        }
      }
    }
    finally
    {
      this.channelExecutor.drain();
    }
  }
  
  public final void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor)
  {
    throw new UnsupportedOperationException("This method is not expected to be called");
  }
  
  final void reprocess(LoadBalancer.SubchannelPicker arg1)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.lock)
    {
      this.lastPicker = ???;
      this.lastPickerVersion += 1L;
      if ((this.pendingStreams == null) || (this.pendingStreams.isEmpty())) {
        return;
      }
      Object localObject3 = new ArrayList(this.pendingStreams);
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        final PendingStream localPendingStream = (PendingStream)((Iterator)localObject3).next();
        ??? = ???.pickSubchannel(localPendingStream.args);
        CallOptions localCallOptions = localPendingStream.args.getCallOptions();
        final ClientTransport localClientTransport = GrpcUtil.getTransportFromPickResult((LoadBalancer.PickResult)???, localCallOptions.isWaitForReady());
        if (localClientTransport != null)
        {
          ??? = this.defaultAppExecutor;
          if (localCallOptions.getExecutor() != null) {
            ??? = localCallOptions.getExecutor();
          }
          ((Executor)???).execute(new Runnable()
          {
            public void run()
            {
              DelayedClientTransport.PendingStream.access$200(localPendingStream, localClientTransport);
            }
          });
          localArrayList.add(localPendingStream);
        }
      }
    }
    synchronized (this.lock)
    {
      if ((this.pendingStreams == null) || (this.pendingStreams.isEmpty())) {
        return;
      }
    }
    this.pendingStreams.removeAll(localArrayList);
    if (this.pendingStreams.isEmpty())
    {
      this.channelExecutor.executeLater(this.reportTransportNotInUse);
      if (!this.shutdown) {
        break label287;
      }
      this.pendingStreams = null;
      this.channelExecutor.executeLater(this.reportTransportTerminated);
    }
    for (;;)
    {
      this.channelExecutor.drain();
      return;
      label287:
      this.pendingStreams = new LinkedHashSet();
    }
  }
  
  public final void shutdown()
  {
    synchronized (this.lock)
    {
      if (this.shutdown) {
        return;
      }
      this.shutdown = true;
      this.channelExecutor.executeLater(this.reportTransportShutdown);
      if ((this.pendingStreams == null) || (this.pendingStreams.isEmpty()))
      {
        this.pendingStreams = null;
        this.channelExecutor.executeLater(this.reportTransportTerminated);
      }
      this.channelExecutor.drain();
      return;
    }
  }
  
  public final void shutdownNow(Status paramStatus)
  {
    shutdown();
    Object localObject1 = null;
    synchronized (this.lock)
    {
      if (this.pendingStreams != null)
      {
        localObject1 = this.pendingStreams;
        this.pendingStreams = null;
      }
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((Collection)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        ((PendingStream)((Iterator)localObject1).next()).cancel(paramStatus);
      }
    }
    this.channelExecutor.executeLater(this.reportTransportTerminated).drain();
  }
  
  public final Runnable start(final ManagedClientTransport.Listener paramListener)
  {
    this.reportTransportInUse = new Runnable()
    {
      public void run()
      {
        paramListener.transportInUse(true);
      }
    };
    this.reportTransportNotInUse = new Runnable()
    {
      public void run()
      {
        paramListener.transportInUse(false);
      }
    };
    this.reportTransportShutdown = new Runnable()
    {
      public void run()
      {
        paramListener.transportShutdown(Status.UNAVAILABLE.withDescription("Channel requested transport to shut down"));
      }
    };
    this.reportTransportTerminated = new Runnable()
    {
      public void run()
      {
        paramListener.transportTerminated();
      }
    };
    return null;
  }
  
  private class PendingStream
    extends DelayedStream
  {
    private final LoadBalancer.PickSubchannelArgs args;
    private final Context context = Context.current();
    private final StatsTraceContext statsTraceCtx;
    
    private PendingStream(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs, StatsTraceContext paramStatsTraceContext)
    {
      this.args = paramPickSubchannelArgs;
      this.statsTraceCtx = paramStatsTraceContext;
    }
    
    private void createRealStream(ClientTransport paramClientTransport)
    {
      Context localContext = this.context.attach();
      try
      {
        paramClientTransport = paramClientTransport.newStream(this.args.getMethodDescriptor(), this.args.getHeaders(), this.args.getCallOptions(), this.statsTraceCtx);
        this.context.detach(localContext);
        setStream(paramClientTransport);
        return;
      }
      finally
      {
        this.context.detach(localContext);
      }
    }
    
    public void cancel(Status arg1)
    {
      super.cancel(???);
      synchronized (DelayedClientTransport.this.lock)
      {
        if (DelayedClientTransport.this.pendingStreams != null)
        {
          boolean bool = DelayedClientTransport.this.pendingStreams.remove(this);
          if ((DelayedClientTransport.this.pendingStreams.isEmpty()) && (bool))
          {
            DelayedClientTransport.this.channelExecutor.executeLater(DelayedClientTransport.this.reportTransportNotInUse);
            if (DelayedClientTransport.this.shutdown)
            {
              DelayedClientTransport.access$402(DelayedClientTransport.this, null);
              DelayedClientTransport.this.channelExecutor.executeLater(DelayedClientTransport.this.reportTransportTerminated);
            }
          }
        }
        DelayedClientTransport.this.channelExecutor.drain();
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/DelayedClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */