package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.NameResolver.Factory;
import io.grpc.NameResolver.Listener;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class DnsNameResolver
  extends NameResolver
{
  private final String authority;
  @GuardedBy("this")
  private ExecutorService executor;
  private final SharedResourceHolder.Resource<ExecutorService> executorResource;
  private final String host;
  @GuardedBy("this")
  private NameResolver.Listener listener;
  private final int port;
  private final Runnable resolutionRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   4: astore_3
      //   5: aload_3
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   11: invokestatic 25	io/grpc/internal/DnsNameResolver:access$000	(Lio/grpc/internal/DnsNameResolver;)Ljava/util/concurrent/ScheduledFuture;
      //   14: ifnull +26 -> 40
      //   17: aload_0
      //   18: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   21: invokestatic 25	io/grpc/internal/DnsNameResolver:access$000	(Lio/grpc/internal/DnsNameResolver;)Ljava/util/concurrent/ScheduledFuture;
      //   24: iconst_0
      //   25: invokeinterface 31 2 0
      //   30: pop
      //   31: aload_0
      //   32: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   35: aconst_null
      //   36: invokestatic 35	io/grpc/internal/DnsNameResolver:access$002	(Lio/grpc/internal/DnsNameResolver;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   39: pop
      //   40: aload_0
      //   41: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   44: invokestatic 39	io/grpc/internal/DnsNameResolver:access$100	(Lio/grpc/internal/DnsNameResolver;)Z
      //   47: ifeq +6 -> 53
      //   50: aload_3
      //   51: monitorexit
      //   52: return
      //   53: aload_0
      //   54: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   57: invokestatic 43	io/grpc/internal/DnsNameResolver:access$200	(Lio/grpc/internal/DnsNameResolver;)Lio/grpc/NameResolver$Listener;
      //   60: astore_2
      //   61: aload_0
      //   62: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   65: iconst_1
      //   66: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   69: pop
      //   70: aload_3
      //   71: monitorexit
      //   72: ldc 49
      //   74: invokestatic 55	java/lang/System:getenv	(Ljava/lang/String;)Ljava/lang/String;
      //   77: ifnull +80 -> 157
      //   80: aload_2
      //   81: invokestatic 61	io/grpc/ResolvedServerInfoGroup:builder	()Lio/grpc/ResolvedServerInfoGroup$Builder;
      //   84: new 63	io/grpc/ResolvedServerInfo
      //   87: dup
      //   88: aload_0
      //   89: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   92: invokestatic 67	io/grpc/internal/DnsNameResolver:access$400	(Lio/grpc/internal/DnsNameResolver;)Ljava/lang/String;
      //   95: aload_0
      //   96: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   99: invokestatic 71	io/grpc/internal/DnsNameResolver:access$500	(Lio/grpc/internal/DnsNameResolver;)I
      //   102: invokestatic 77	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
      //   105: getstatic 83	io/grpc/Attributes:EMPTY	Lio/grpc/Attributes;
      //   108: invokespecial 86	io/grpc/ResolvedServerInfo:<init>	(Ljava/net/SocketAddress;Lio/grpc/Attributes;)V
      //   111: invokevirtual 92	io/grpc/ResolvedServerInfoGroup$Builder:add	(Lio/grpc/ResolvedServerInfo;)Lio/grpc/ResolvedServerInfoGroup$Builder;
      //   114: invokevirtual 96	io/grpc/ResolvedServerInfoGroup$Builder:build	()Lio/grpc/ResolvedServerInfoGroup;
      //   117: invokestatic 102	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
      //   120: getstatic 83	io/grpc/Attributes:EMPTY	Lio/grpc/Attributes;
      //   123: invokeinterface 108 3 0
      //   128: aload_0
      //   129: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   132: astore_2
      //   133: aload_2
      //   134: monitorenter
      //   135: aload_0
      //   136: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   139: iconst_0
      //   140: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   143: pop
      //   144: aload_2
      //   145: monitorexit
      //   146: return
      //   147: astore_3
      //   148: aload_2
      //   149: monitorexit
      //   150: aload_3
      //   151: athrow
      //   152: astore_2
      //   153: aload_3
      //   154: monitorexit
      //   155: aload_2
      //   156: athrow
      //   157: aload_0
      //   158: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   161: aload_0
      //   162: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   165: invokestatic 67	io/grpc/internal/DnsNameResolver:access$400	(Lio/grpc/internal/DnsNameResolver;)Ljava/lang/String;
      //   168: invokevirtual 112	io/grpc/internal/DnsNameResolver:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
      //   171: astore_3
      //   172: invokestatic 61	io/grpc/ResolvedServerInfoGroup:builder	()Lio/grpc/ResolvedServerInfoGroup$Builder;
      //   175: astore 4
      //   177: iconst_0
      //   178: istore_1
      //   179: iload_1
      //   180: aload_3
      //   181: arraylength
      //   182: if_icmpge +192 -> 374
      //   185: aload 4
      //   187: new 63	io/grpc/ResolvedServerInfo
      //   190: dup
      //   191: new 73	java/net/InetSocketAddress
      //   194: dup
      //   195: aload_3
      //   196: iload_1
      //   197: aaload
      //   198: aload_0
      //   199: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   202: invokestatic 71	io/grpc/internal/DnsNameResolver:access$500	(Lio/grpc/internal/DnsNameResolver;)I
      //   205: invokespecial 115	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
      //   208: getstatic 83	io/grpc/Attributes:EMPTY	Lio/grpc/Attributes;
      //   211: invokespecial 86	io/grpc/ResolvedServerInfo:<init>	(Ljava/net/SocketAddress;Lio/grpc/Attributes;)V
      //   214: invokevirtual 92	io/grpc/ResolvedServerInfoGroup$Builder:add	(Lio/grpc/ResolvedServerInfo;)Lio/grpc/ResolvedServerInfoGroup$Builder;
      //   217: pop
      //   218: iload_1
      //   219: iconst_1
      //   220: iadd
      //   221: istore_1
      //   222: goto -43 -> 179
      //   225: astore 4
      //   227: aload_0
      //   228: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   231: astore_3
      //   232: aload_3
      //   233: monitorenter
      //   234: aload_0
      //   235: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   238: invokestatic 39	io/grpc/internal/DnsNameResolver:access$100	(Lio/grpc/internal/DnsNameResolver;)Z
      //   241: ifeq +29 -> 270
      //   244: aload_3
      //   245: monitorexit
      //   246: aload_0
      //   247: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   250: astore_2
      //   251: aload_2
      //   252: monitorenter
      //   253: aload_0
      //   254: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   257: iconst_0
      //   258: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   261: pop
      //   262: aload_2
      //   263: monitorexit
      //   264: return
      //   265: astore_3
      //   266: aload_2
      //   267: monitorexit
      //   268: aload_3
      //   269: athrow
      //   270: aload_0
      //   271: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   274: aload_0
      //   275: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   278: invokestatic 119	io/grpc/internal/DnsNameResolver:access$700	(Lio/grpc/internal/DnsNameResolver;)Ljava/util/concurrent/ScheduledExecutorService;
      //   281: new 121	io/grpc/internal/LogExceptionRunnable
      //   284: dup
      //   285: aload_0
      //   286: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   289: invokestatic 125	io/grpc/internal/DnsNameResolver:access$600	(Lio/grpc/internal/DnsNameResolver;)Ljava/lang/Runnable;
      //   292: invokespecial 128	io/grpc/internal/LogExceptionRunnable:<init>	(Ljava/lang/Runnable;)V
      //   295: lconst_1
      //   296: getstatic 134	java/util/concurrent/TimeUnit:MINUTES	Ljava/util/concurrent/TimeUnit;
      //   299: invokeinterface 140 5 0
      //   304: invokestatic 35	io/grpc/internal/DnsNameResolver:access$002	(Lio/grpc/internal/DnsNameResolver;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   307: pop
      //   308: aload_3
      //   309: monitorexit
      //   310: aload_2
      //   311: getstatic 146	io/grpc/Status:UNAVAILABLE	Lio/grpc/Status;
      //   314: aload 4
      //   316: invokevirtual 150	io/grpc/Status:withCause	(Ljava/lang/Throwable;)Lio/grpc/Status;
      //   319: invokeinterface 154 2 0
      //   324: aload_0
      //   325: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   328: astore_2
      //   329: aload_2
      //   330: monitorenter
      //   331: aload_0
      //   332: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   335: iconst_0
      //   336: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   339: pop
      //   340: aload_2
      //   341: monitorexit
      //   342: return
      //   343: astore_3
      //   344: aload_2
      //   345: monitorexit
      //   346: aload_3
      //   347: athrow
      //   348: astore_2
      //   349: aload_3
      //   350: monitorexit
      //   351: aload_2
      //   352: athrow
      //   353: astore_3
      //   354: aload_0
      //   355: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   358: astore_2
      //   359: aload_2
      //   360: monitorenter
      //   361: aload_0
      //   362: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   365: iconst_0
      //   366: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   369: pop
      //   370: aload_2
      //   371: monitorexit
      //   372: aload_3
      //   373: athrow
      //   374: aload_2
      //   375: aload 4
      //   377: invokevirtual 96	io/grpc/ResolvedServerInfoGroup$Builder:build	()Lio/grpc/ResolvedServerInfoGroup;
      //   380: invokestatic 102	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
      //   383: getstatic 83	io/grpc/Attributes:EMPTY	Lio/grpc/Attributes;
      //   386: invokeinterface 108 3 0
      //   391: aload_0
      //   392: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   395: astore_2
      //   396: aload_2
      //   397: monitorenter
      //   398: aload_0
      //   399: getfield 14	io/grpc/internal/DnsNameResolver$1:this$0	Lio/grpc/internal/DnsNameResolver;
      //   402: iconst_0
      //   403: invokestatic 47	io/grpc/internal/DnsNameResolver:access$302	(Lio/grpc/internal/DnsNameResolver;Z)Z
      //   406: pop
      //   407: aload_2
      //   408: monitorexit
      //   409: return
      //   410: astore_3
      //   411: aload_2
      //   412: monitorexit
      //   413: aload_3
      //   414: athrow
      //   415: astore_3
      //   416: aload_2
      //   417: monitorexit
      //   418: aload_3
      //   419: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	420	0	this	1
      //   178	44	1	i	int
      //   152	4	2	localObject2	Object
      //   348	4	2	localObject3	Object
      //   4	67	3	localDnsNameResolver3	DnsNameResolver
      //   147	7	3	localObject4	Object
      //   265	44	3	localObject6	Object
      //   343	7	3	localObject7	Object
      //   353	20	3	localObject8	Object
      //   410	4	3	localObject9	Object
      //   415	4	3	localObject10	Object
      //   175	11	4	localBuilder	io.grpc.ResolvedServerInfoGroup.Builder
      //   225	151	4	localUnknownHostException	UnknownHostException
      // Exception table:
      //   from	to	target	type
      //   135	146	147	finally
      //   148	150	147	finally
      //   7	40	152	finally
      //   40	52	152	finally
      //   53	72	152	finally
      //   153	155	152	finally
      //   157	172	225	java/net/UnknownHostException
      //   253	264	265	finally
      //   266	268	265	finally
      //   331	342	343	finally
      //   344	346	343	finally
      //   234	246	348	finally
      //   270	310	348	finally
      //   349	351	348	finally
      //   72	128	353	finally
      //   157	172	353	finally
      //   172	177	353	finally
      //   179	218	353	finally
      //   227	234	353	finally
      //   310	324	353	finally
      //   351	353	353	finally
      //   374	391	353	finally
      //   398	409	410	finally
      //   411	413	410	finally
      //   361	372	415	finally
      //   416	418	415	finally
    }
  };
  private final Runnable resolutionRunnableOnExecutor = new Runnable()
  {
    public void run()
    {
      synchronized (DnsNameResolver.this)
      {
        if (!DnsNameResolver.this.shutdown) {
          DnsNameResolver.this.executor.execute(DnsNameResolver.this.resolutionRunnable);
        }
        return;
      }
    }
  };
  @GuardedBy("this")
  private ScheduledFuture<?> resolutionTask;
  @GuardedBy("this")
  private boolean resolving;
  @GuardedBy("this")
  private boolean shutdown;
  @GuardedBy("this")
  private ScheduledExecutorService timerService;
  private final SharedResourceHolder.Resource<ScheduledExecutorService> timerServiceResource;
  
  DnsNameResolver(@Nullable String paramString1, String paramString2, Attributes paramAttributes, SharedResourceHolder.Resource<ScheduledExecutorService> paramResource, SharedResourceHolder.Resource<ExecutorService> paramResource1)
  {
    this.timerServiceResource = paramResource;
    this.executorResource = paramResource1;
    paramString1 = URI.create("//" + paramString2);
    this.authority = ((String)Preconditions.checkNotNull(paramString1.getAuthority(), "nameUri (%s) doesn't have an authority", new Object[] { paramString1 }));
    this.host = ((String)Preconditions.checkNotNull(paramString1.getHost(), "host"));
    if (paramString1.getPort() == -1)
    {
      paramString1 = (Integer)paramAttributes.get(NameResolver.Factory.PARAMS_DEFAULT_PORT);
      if (paramString1 != null)
      {
        this.port = paramString1.intValue();
        return;
      }
      throw new IllegalArgumentException("name '" + paramString2 + "' doesn't contain a port, and default port is not set in params");
    }
    this.port = paramString1.getPort();
  }
  
  @GuardedBy("this")
  private void resolve()
  {
    if ((this.resolving) || (this.shutdown)) {
      return;
    }
    this.executor.execute(this.resolutionRunnable);
  }
  
  @VisibleForTesting
  InetAddress[] getAllByName(String paramString)
    throws UnknownHostException
  {
    return InetAddress.getAllByName(paramString);
  }
  
  final int getPort()
  {
    return this.port;
  }
  
  public final String getServiceAuthority()
  {
    return this.authority;
  }
  
  /* Error */
  public final void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	io/grpc/internal/DnsNameResolver:listener	Lio/grpc/NameResolver$Listener;
    //   6: ifnull +18 -> 24
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: ldc -66
    //   14: invokestatic 194	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
    //   17: aload_0
    //   18: invokespecial 196	io/grpc/internal/DnsNameResolver:resolve	()V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -15 -> 11
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	DnsNameResolver
    //   10	16	1	bool	boolean
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	29	finally
    //   11	21	29	finally
  }
  
  /* Error */
  public final void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	io/grpc/internal/DnsNameResolver:shutdown	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 145	io/grpc/internal/DnsNameResolver:shutdown	Z
    //   19: aload_0
    //   20: getfield 139	io/grpc/internal/DnsNameResolver:resolutionTask	Ljava/util/concurrent/ScheduledFuture;
    //   23: ifnull +14 -> 37
    //   26: aload_0
    //   27: getfield 139	io/grpc/internal/DnsNameResolver:resolutionTask	Ljava/util/concurrent/ScheduledFuture;
    //   30: iconst_0
    //   31: invokeinterface 202 2 0
    //   36: pop
    //   37: aload_0
    //   38: getfield 163	io/grpc/internal/DnsNameResolver:timerService	Ljava/util/concurrent/ScheduledExecutorService;
    //   41: ifnull +21 -> 62
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 52	io/grpc/internal/DnsNameResolver:timerServiceResource	Lio/grpc/internal/SharedResourceHolder$Resource;
    //   49: aload_0
    //   50: getfield 163	io/grpc/internal/DnsNameResolver:timerService	Ljava/util/concurrent/ScheduledExecutorService;
    //   53: invokestatic 208	io/grpc/internal/SharedResourceHolder:release	(Lio/grpc/internal/SharedResourceHolder$Resource;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 210	java/util/concurrent/ScheduledExecutorService
    //   59: putfield 163	io/grpc/internal/DnsNameResolver:timerService	Ljava/util/concurrent/ScheduledExecutorService;
    //   62: aload_0
    //   63: getfield 168	io/grpc/internal/DnsNameResolver:executor	Ljava/util/concurrent/ExecutorService;
    //   66: ifnull -55 -> 11
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 54	io/grpc/internal/DnsNameResolver:executorResource	Lio/grpc/internal/SharedResourceHolder$Resource;
    //   74: aload_0
    //   75: getfield 168	io/grpc/internal/DnsNameResolver:executor	Ljava/util/concurrent/ExecutorService;
    //   78: invokestatic 208	io/grpc/internal/SharedResourceHolder:release	(Lio/grpc/internal/SharedResourceHolder$Resource;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 171	java/util/concurrent/ExecutorService
    //   84: putfield 168	io/grpc/internal/DnsNameResolver:executor	Ljava/util/concurrent/ExecutorService;
    //   87: goto -76 -> 11
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	DnsNameResolver
    //   6	2	1	bool	boolean
    //   90	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	90	finally
    //   14	37	90	finally
    //   37	62	90	finally
    //   62	87	90	finally
  }
  
  /* Error */
  public final void start(NameResolver.Listener paramListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	io/grpc/internal/DnsNameResolver:listener	Lio/grpc/NameResolver$Listener;
    //   6: ifnonnull +59 -> 65
    //   9: iconst_1
    //   10: istore_2
    //   11: iload_2
    //   12: ldc -42
    //   14: invokestatic 194	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 52	io/grpc/internal/DnsNameResolver:timerServiceResource	Lio/grpc/internal/SharedResourceHolder$Resource;
    //   22: invokestatic 217	io/grpc/internal/SharedResourceHolder:get	(Lio/grpc/internal/SharedResourceHolder$Resource;)Ljava/lang/Object;
    //   25: checkcast 210	java/util/concurrent/ScheduledExecutorService
    //   28: putfield 163	io/grpc/internal/DnsNameResolver:timerService	Ljava/util/concurrent/ScheduledExecutorService;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 54	io/grpc/internal/DnsNameResolver:executorResource	Lio/grpc/internal/SharedResourceHolder$Resource;
    //   36: invokestatic 217	io/grpc/internal/SharedResourceHolder:get	(Lio/grpc/internal/SharedResourceHolder$Resource;)Ljava/lang/Object;
    //   39: checkcast 171	java/util/concurrent/ExecutorService
    //   42: putfield 168	io/grpc/internal/DnsNameResolver:executor	Ljava/util/concurrent/ExecutorService;
    //   45: aload_0
    //   46: aload_1
    //   47: ldc -38
    //   49: invokestatic 97	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 220	io/grpc/NameResolver$Listener
    //   55: putfield 149	io/grpc/internal/DnsNameResolver:listener	Lio/grpc/NameResolver$Listener;
    //   58: aload_0
    //   59: invokespecial 196	io/grpc/internal/DnsNameResolver:resolve	()V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: iconst_0
    //   66: istore_2
    //   67: goto -56 -> 11
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	DnsNameResolver
    //   0	75	1	paramListener	NameResolver.Listener
    //   10	57	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	70	finally
    //   11	62	70	finally
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/DnsNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */