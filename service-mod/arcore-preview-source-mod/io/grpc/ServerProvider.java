package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.Iterator;
import java.util.ServiceLoader;

public abstract class ServerProvider
{
  private static final ServerProvider provider = load(Thread.currentThread().getContextClassLoader());
  
  @VisibleForTesting
  static final ServerProvider load(ClassLoader paramClassLoader)
  {
    Object localObject = ServiceLoader.load(ServerProvider.class, paramClassLoader);
    paramClassLoader = null;
    Iterator localIterator = ((ServiceLoader)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (ServerProvider)localIterator.next();
      if (((ServerProvider)localObject).isAvailable()) {
        if (paramClassLoader == null) {
          paramClassLoader = (ClassLoader)localObject;
        } else if (((ServerProvider)localObject).priority() > paramClassLoader.priority()) {
          paramClassLoader = (ClassLoader)localObject;
        }
      }
    }
    return paramClassLoader;
  }
  
  public static ServerProvider provider()
  {
    if (provider == null) {
      throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty artifact");
    }
    return provider;
  }
  
  protected abstract ServerBuilder<?> builderForPort(int paramInt);
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */