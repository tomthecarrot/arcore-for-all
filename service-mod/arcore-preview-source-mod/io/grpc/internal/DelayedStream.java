package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

class DelayedStream
  implements ClientStream
{
  @GuardedBy("this")
  private DelayedStreamListener delayedListener;
  @GuardedBy("this")
  private Status error;
  private ClientStreamListener listener;
  private volatile boolean passThrough;
  @GuardedBy("this")
  private List<Runnable> pendingCalls = new ArrayList();
  private ClientStream realStream;
  
  static
  {
    if (!DelayedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private void delayOrExecute(Runnable paramRunnable)
  {
    try
    {
      if (!this.passThrough)
      {
        this.pendingCalls.add(paramRunnable);
        return;
      }
      paramRunnable.run();
      return;
    }
    finally {}
  }
  
  private void drainPendingCalls()
  {
    assert (this.realStream != null);
    assert (!this.passThrough);
    Object localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject3 = localObject1;
      try
      {
        if (this.pendingCalls.isEmpty())
        {
          this.pendingCalls = null;
          this.passThrough = true;
          localObject1 = this.delayedListener;
          if (localObject1 != null) {
            ((DelayedStreamListener)localObject1).drainPendingCallbacks();
          }
          return;
        }
        localObject1 = this.pendingCalls;
        this.pendingCalls = ((List)localObject3);
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Runnable)((Iterator)localObject3).next()).run();
        }
        ((List)localObject2).clear();
      }
      finally {}
    }
  }
  
  public void cancel(final Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "reason");
    int i = 1;
    ClientStreamListener localClientStreamListener = null;
    try
    {
      if (this.realStream == null)
      {
        this.realStream = NoopClientStream.INSTANCE;
        i = 0;
        localClientStreamListener = this.listener;
        this.error = paramStatus;
      }
      if (i != 0)
      {
        delayOrExecute(new Runnable()
        {
          public void run()
          {
            DelayedStream.this.realStream.cancel(paramStatus);
          }
        });
        return;
      }
    }
    finally {}
    if (localClientStreamListener != null) {
      localClientStreamListener.closed(paramStatus, new Metadata());
    }
    drainPendingCalls();
  }
  
  public void flush()
  {
    if (this.passThrough)
    {
      this.realStream.flush();
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.flush();
      }
    });
  }
  
  public Attributes getAttributes()
  {
    Preconditions.checkState(this.passThrough, "Called getAttributes before attributes are ready");
    return this.realStream.getAttributes();
  }
  
  @VisibleForTesting
  ClientStream getRealStream()
  {
    return this.realStream;
  }
  
  public void halfClose()
  {
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.halfClose();
      }
    });
  }
  
  public boolean isReady()
  {
    if (this.passThrough) {
      return this.realStream.isReady();
    }
    return false;
  }
  
  public void request(final int paramInt)
  {
    if (this.passThrough)
    {
      this.realStream.request(paramInt);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.request(paramInt);
      }
    });
  }
  
  public void setAuthority(final String paramString)
  {
    if (this.listener == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "May only be called before start");
      Preconditions.checkNotNull(paramString, "authority");
      delayOrExecute(new Runnable()
      {
        public void run()
        {
          DelayedStream.this.realStream.setAuthority(paramString);
        }
      });
      return;
    }
  }
  
  public void setCompressor(final Compressor paramCompressor)
  {
    Preconditions.checkNotNull(paramCompressor, "compressor");
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.setCompressor(paramCompressor);
      }
    });
  }
  
  /* Error */
  public void setDecompressor(io.grpc.Decompressor paramDecompressor)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -46
    //   3: invokestatic 132	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: getfield 79	io/grpc/internal/DelayedStream:realStream	Lio/grpc/internal/ClientStream;
    //   15: ifnull +27 -> 42
    //   18: iconst_1
    //   19: istore_2
    //   20: iload_2
    //   21: ldc -44
    //   23: invokestatic 172	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 79	io/grpc/internal/DelayedStream:realStream	Lio/grpc/internal/ClientStream;
    //   30: aload_1
    //   31: invokeinterface 214 2 0
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -24 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	DelayedStream
    //   0	47	1	paramDecompressor	io.grpc.Decompressor
    //   19	25	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	11	37	finally
    //   38	40	37	finally
  }
  
  public void setMaxInboundMessageSize(final int paramInt)
  {
    if (this.passThrough)
    {
      this.realStream.setMaxInboundMessageSize(paramInt);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.setMaxInboundMessageSize(paramInt);
      }
    });
  }
  
  public void setMaxOutboundMessageSize(final int paramInt)
  {
    if (this.passThrough)
    {
      this.realStream.setMaxOutboundMessageSize(paramInt);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.setMaxOutboundMessageSize(paramInt);
      }
    });
  }
  
  public void setMessageCompression(final boolean paramBoolean)
  {
    if (this.passThrough)
    {
      this.realStream.setMessageCompression(paramBoolean);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.setMessageCompression(paramBoolean);
      }
    });
  }
  
  final void setStream(ClientStream paramClientStream)
  {
    try
    {
      if (this.realStream != null) {
        return;
      }
      this.realStream = ((ClientStream)Preconditions.checkNotNull(paramClientStream, "stream"));
      drainPendingCalls();
      return;
    }
    finally {}
  }
  
  public void start(ClientStreamListener paramClientStreamListener)
  {
    if (this.listener == null) {}
    final Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "already started");
      try
      {
        this.listener = ((ClientStreamListener)Preconditions.checkNotNull(paramClientStreamListener, "listener"));
        Status localStatus = this.error;
        bool = this.passThrough;
        localObject = paramClientStreamListener;
        if (!bool)
        {
          localObject = new DelayedStreamListener(paramClientStreamListener);
          this.delayedListener = ((DelayedStreamListener)localObject);
        }
        if (localStatus == null) {
          break;
        }
        ((ClientStreamListener)localObject).closed(localStatus, new Metadata());
        return;
      }
      finally {}
    }
    if (bool)
    {
      this.realStream.start((ClientStreamListener)localObject);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.start(localObject);
      }
    });
  }
  
  public void writeMessage(final InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream, "message");
    if (this.passThrough)
    {
      this.realStream.writeMessage(paramInputStream);
      return;
    }
    delayOrExecute(new Runnable()
    {
      public void run()
      {
        DelayedStream.this.realStream.writeMessage(paramInputStream);
      }
    });
  }
  
  private static class DelayedStreamListener
    implements ClientStreamListener
  {
    private volatile boolean passThrough;
    @GuardedBy("this")
    private List<Runnable> pendingCallbacks = new ArrayList();
    private final ClientStreamListener realListener;
    
    static
    {
      if (!DelayedStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public DelayedStreamListener(ClientStreamListener paramClientStreamListener)
    {
      this.realListener = paramClientStreamListener;
    }
    
    private void delayOrExecute(Runnable paramRunnable)
    {
      try
      {
        if (!this.passThrough)
        {
          this.pendingCallbacks.add(paramRunnable);
          return;
        }
        paramRunnable.run();
        return;
      }
      finally {}
    }
    
    public void closed(final Status paramStatus, final Metadata paramMetadata)
    {
      delayOrExecute(new Runnable()
      {
        public void run()
        {
          DelayedStream.DelayedStreamListener.this.realListener.closed(paramStatus, paramMetadata);
        }
      });
    }
    
    public void drainPendingCallbacks()
    {
      assert (!this.passThrough);
      Object localObject1 = new ArrayList();
      for (;;)
      {
        Object localObject3 = localObject1;
        try
        {
          if (this.pendingCallbacks.isEmpty())
          {
            this.pendingCallbacks = null;
            this.passThrough = true;
            return;
          }
          localObject1 = this.pendingCallbacks;
          this.pendingCallbacks = ((List)localObject3);
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Runnable)((Iterator)localObject3).next()).run();
          }
          ((List)localObject2).clear();
        }
        finally {}
      }
    }
    
    public void headersRead(final Metadata paramMetadata)
    {
      delayOrExecute(new Runnable()
      {
        public void run()
        {
          DelayedStream.DelayedStreamListener.this.realListener.headersRead(paramMetadata);
        }
      });
    }
    
    public void messageRead(final InputStream paramInputStream)
    {
      if (this.passThrough)
      {
        this.realListener.messageRead(paramInputStream);
        return;
      }
      delayOrExecute(new Runnable()
      {
        public void run()
        {
          DelayedStream.DelayedStreamListener.this.realListener.messageRead(paramInputStream);
        }
      });
    }
    
    public void onReady()
    {
      if (this.passThrough)
      {
        this.realListener.onReady();
        return;
      }
      delayOrExecute(new Runnable()
      {
        public void run()
        {
          DelayedStream.DelayedStreamListener.this.realListener.onReady();
        }
      });
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/DelayedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */