package io.grpc.util;

import io.grpc.BindableService;
import io.grpc.HandlerRegistry;
import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class MutableHandlerRegistry
  extends HandlerRegistry
{
  private final ConcurrentMap<String, ServerServiceDefinition> services = new ConcurrentHashMap();
  
  @Nullable
  public ServerServiceDefinition addService(BindableService paramBindableService)
  {
    return addService(paramBindableService.bindService());
  }
  
  @Nullable
  public ServerServiceDefinition addService(ServerServiceDefinition paramServerServiceDefinition)
  {
    return (ServerServiceDefinition)this.services.put(paramServerServiceDefinition.getServiceDescriptor().getName(), paramServerServiceDefinition);
  }
  
  public List<ServerServiceDefinition> getServices()
  {
    return Collections.unmodifiableList(new ArrayList(this.services.values()));
  }
  
  @Nullable
  public ServerMethodDefinition<?, ?> lookupMethod(String paramString1, @Nullable String paramString2)
  {
    paramString2 = MethodDescriptor.extractFullServiceName(paramString1);
    if (paramString2 == null) {}
    do
    {
      return null;
      paramString2 = (ServerServiceDefinition)this.services.get(paramString2);
    } while (paramString2 == null);
    return paramString2.getMethod(paramString1);
  }
  
  public boolean removeService(ServerServiceDefinition paramServerServiceDefinition)
  {
    return this.services.remove(paramServerServiceDefinition.getServiceDescriptor().getName(), paramServerServiceDefinition);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/util/MutableHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */