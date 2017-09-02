package io.grpc.inprocess;

import io.grpc.internal.InternalServer;
import io.grpc.internal.ServerListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class InProcessServer
  implements InternalServer
{
  private static final ConcurrentMap<String, InProcessServer> registry = new ConcurrentHashMap();
  private ServerListener listener;
  private final String name;
  private boolean shutdown;
  
  InProcessServer(String paramString)
  {
    this.name = paramString;
  }
  
  static InProcessServer findServer(String paramString)
  {
    return (InProcessServer)registry.get(paramString);
  }
  
  public int getPort()
  {
    return -1;
  }
  
  /* Error */
  io.grpc.internal.ServerTransportListener register(InProcessTransport paramInProcessTransport)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	io/grpc/inprocess/InProcessServer:shutdown	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 46	io/grpc/inprocess/InProcessServer:listener	Lio/grpc/internal/ServerListener;
    //   21: aload_1
    //   22: invokeinterface 52 2 0
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	InProcessServer
    //   0	36	1	paramInProcessTransport	InProcessTransport
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  public void shutdown()
  {
    if (!registry.remove(this.name, this)) {
      throw new AssertionError();
    }
    try
    {
      this.shutdown = true;
      this.listener.serverShutdown();
      return;
    }
    finally {}
  }
  
  public void start(ServerListener paramServerListener)
    throws IOException
  {
    this.listener = paramServerListener;
    if (registry.putIfAbsent(this.name, this) != null) {
      throw new IOException("name already registered: " + this.name);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/inprocess/InProcessServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */