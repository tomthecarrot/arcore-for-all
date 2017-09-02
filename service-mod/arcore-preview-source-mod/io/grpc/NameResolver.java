package io.grpc;

import java.net.URI;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class NameResolver
{
  public abstract String getServiceAuthority();
  
  public void refresh() {}
  
  public abstract void shutdown();
  
  public abstract void start(Listener paramListener);
  
  public static abstract class Factory
  {
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.of("params-default-port");
    
    public abstract String getDefaultScheme();
    
    @Nullable
    public abstract NameResolver newNameResolver(URI paramURI, Attributes paramAttributes);
  }
  
  @ThreadSafe
  public static abstract interface Listener
  {
    public abstract void onError(Status paramStatus);
    
    public abstract void onUpdate(List<ResolvedServerInfoGroup> paramList, Attributes paramAttributes);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/NameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */