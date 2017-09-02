package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool
{
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  private static final ConnectionPool systemDefault;
  private final LinkedList<Connection> connections = new LinkedList();
  private final Runnable connectionsCleanupRunnable = new Runnable()
  {
    public void run()
    {
      ConnectionPool.this.runCleanupUntilPoolIsEmpty();
    }
  };
  private Executor executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {}
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      systemDefault = new ConnectionPool(0, l);
      return;
    }
    if (str3 != null)
    {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
    systemDefault = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = (paramLong * 1000L * 1000L);
  }
  
  private void addConnection(Connection paramConnection)
  {
    boolean bool = this.connections.isEmpty();
    this.connections.addFirst(paramConnection);
    if (bool)
    {
      this.executor.execute(this.connectionsCleanupRunnable);
      return;
    }
    notifyAll();
  }
  
  public static ConnectionPool getDefault()
  {
    return systemDefault;
  }
  
  private void runCleanupUntilPoolIsEmpty()
  {
    while (performCleanup()) {}
  }
  
  public void evictAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      this.connections.clear();
      notifyAll();
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        Util.closeQuietly(((Connection)localArrayList.get(i)).getSocket());
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public Connection get(Address paramAddress)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   9: aload_0
    //   10: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   13: invokevirtual 166	java/util/LinkedList:size	()I
    //   16: invokevirtual 170	java/util/LinkedList:listIterator	(I)Ljava/util/ListIterator;
    //   19: astore 5
    //   21: aload 4
    //   23: astore_3
    //   24: aload 5
    //   26: invokeinterface 175 1 0
    //   31: ifeq +77 -> 108
    //   34: aload 5
    //   36: invokeinterface 179 1 0
    //   41: checkcast 154	com/squareup/okhttp/Connection
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 183	com/squareup/okhttp/Connection:getRoute	()Lcom/squareup/okhttp/Route;
    //   49: invokevirtual 189	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   52: aload_1
    //   53: invokevirtual 195	com/squareup/okhttp/Address:equals	(Ljava/lang/Object;)Z
    //   56: ifeq -35 -> 21
    //   59: aload_3
    //   60: invokevirtual 198	com/squareup/okhttp/Connection:isAlive	()Z
    //   63: ifeq -42 -> 21
    //   66: invokestatic 202	java/lang/System:nanoTime	()J
    //   69: aload_3
    //   70: invokevirtual 205	com/squareup/okhttp/Connection:getIdleStartTimeNs	()J
    //   73: lsub
    //   74: aload_0
    //   75: getfield 105	com/squareup/okhttp/ConnectionPool:keepAliveDurationNs	J
    //   78: lcmp
    //   79: ifge -58 -> 21
    //   82: aload 5
    //   84: invokeinterface 208 1 0
    //   89: aload_3
    //   90: invokevirtual 211	com/squareup/okhttp/Connection:isFramed	()Z
    //   93: istore_2
    //   94: iload_2
    //   95: ifne +13 -> 108
    //   98: invokestatic 216	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   101: aload_3
    //   102: invokevirtual 158	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   105: invokevirtual 219	com/squareup/okhttp/internal/Platform:tagSocket	(Ljava/net/Socket;)V
    //   108: aload_3
    //   109: ifnull +18 -> 127
    //   112: aload_3
    //   113: invokevirtual 211	com/squareup/okhttp/Connection:isFramed	()Z
    //   116: ifeq +11 -> 127
    //   119: aload_0
    //   120: getfield 68	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   123: aload_3
    //   124: invokevirtual 119	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_3
    //   130: areturn
    //   131: astore 6
    //   133: aload_3
    //   134: invokevirtual 158	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   137: invokestatic 162	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   140: invokestatic 216	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   143: new 221	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   150: ldc -32
    //   152: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 6
    //   157: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 239	com/squareup/okhttp/internal/Platform:logW	(Ljava/lang/String;)V
    //   166: goto -145 -> 21
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	ConnectionPool
    //   0	174	1	paramAddress	Address
    //   93	2	2	bool	boolean
    //   23	111	3	localObject1	Object
    //   3	19	4	localObject2	Object
    //   19	64	5	localListIterator	ListIterator
    //   131	25	6	localSocketException	SocketException
    // Exception table:
    //   from	to	target	type
    //   98	108	131	java/net/SocketException
    //   5	21	169	finally
    //   24	94	169	finally
    //   98	108	169	finally
    //   112	127	169	finally
    //   133	166	169	finally
  }
  
  public int getConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  List<Connection> getConnections()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getHttpConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      int j = getMultiplexedConnectionCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMultiplexedConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Connection)localIterator.next()).isFramed();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  @Deprecated
  public int getSpdyConnectionCount()
  {
    try
    {
      int i = getMultiplexedConnectionCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean performCleanup()
  {
    long l2;
    long l1;
    Connection localConnection;
    for (;;)
    {
      long l3;
      try
      {
        if (this.connections.isEmpty()) {
          return false;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        l2 = System.nanoTime();
        l1 = this.keepAliveDurationNs;
        localListIterator = this.connections.listIterator(this.connections.size());
        if (!localListIterator.hasPrevious()) {
          break;
        }
        localConnection = (Connection)localListIterator.previous();
        l3 = localConnection.getIdleStartTimeNs() + this.keepAliveDurationNs - l2;
        if ((l3 <= 0L) || (!localConnection.isAlive()))
        {
          localListIterator.remove();
          localArrayList.add(localConnection);
          continue;
        }
        if (!localConnection.isIdle()) {
          continue;
        }
      }
      finally {}
      i += 1;
      l1 = Math.min(l1, l3);
    }
    ListIterator localListIterator = this.connections.listIterator(this.connections.size());
    while ((localListIterator.hasPrevious()) && (i > this.maxIdleConnections))
    {
      localConnection = (Connection)localListIterator.previous();
      if (localConnection.isIdle())
      {
        ((List)localObject).add(localConnection);
        localListIterator.remove();
        i -= 1;
      }
    }
    boolean bool = ((List)localObject).isEmpty();
    if (bool) {}
    try
    {
      l2 = l1 / 1000000L;
      wait(l2, (int)(l1 - 1000000L * l2));
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      int j;
      for (;;) {}
    }
    int i = 0;
    j = ((List)localObject).size();
    while (i < j)
    {
      Util.closeQuietly(((Connection)((List)localObject).get(i)).getSocket());
      i += 1;
    }
    return true;
  }
  
  void recycle(Connection paramConnection)
  {
    if (paramConnection.isFramed()) {}
    while (!paramConnection.clearOwner()) {
      return;
    }
    if (!paramConnection.isAlive())
    {
      Util.closeQuietly(paramConnection.getSocket());
      return;
    }
    try
    {
      Platform.get().untagSocket(paramConnection.getSocket());
      try
      {
        addConnection(paramConnection);
        paramConnection.incrementRecycleCount();
        paramConnection.resetIdleStartTime();
        return;
      }
      finally {}
      return;
    }
    catch (SocketException localSocketException)
    {
      Platform.get().logW("Unable to untagSocket(): " + localSocketException);
      Util.closeQuietly(paramConnection.getSocket());
    }
  }
  
  void replaceCleanupExecutorForTests(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  void share(Connection paramConnection)
  {
    if (!paramConnection.isFramed()) {
      throw new IllegalArgumentException();
    }
    if (!paramConnection.isAlive()) {
      return;
    }
    try
    {
      addConnection(paramConnection);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */