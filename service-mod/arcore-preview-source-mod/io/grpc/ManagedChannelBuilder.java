package io.grpc;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class ManagedChannelBuilder<T extends ManagedChannelBuilder<T>>
{
  public static ManagedChannelBuilder<?> forAddress(String paramString, int paramInt)
  {
    return ManagedChannelProvider.provider().builderForAddress(paramString, paramInt);
  }
  
  public static ManagedChannelBuilder<?> forTarget(String paramString)
  {
    return ManagedChannelProvider.provider().builderForTarget(paramString);
  }
  
  private T thisT()
  {
    return this;
  }
  
  public abstract ManagedChannel build();
  
  public abstract T compressorRegistry(CompressorRegistry paramCompressorRegistry);
  
  public abstract T decompressorRegistry(DecompressorRegistry paramDecompressorRegistry);
  
  public abstract T directExecutor();
  
  public abstract T executor(Executor paramExecutor);
  
  public abstract T idleTimeout(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract T intercept(List<ClientInterceptor> paramList);
  
  public abstract T intercept(ClientInterceptor... paramVarArgs);
  
  public abstract T loadBalancerFactory(LoadBalancer.Factory paramFactory);
  
  public T maxInboundMessageSize(int paramInt)
  {
    return thisT();
  }
  
  public abstract T nameResolverFactory(NameResolver.Factory paramFactory);
  
  public abstract T overrideAuthority(String paramString);
  
  public abstract T usePlaintext(boolean paramBoolean);
  
  public abstract T userAgent(String paramString);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ManagedChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */