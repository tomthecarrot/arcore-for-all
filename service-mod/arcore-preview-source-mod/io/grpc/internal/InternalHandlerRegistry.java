package io.grpc.internal;

import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class InternalHandlerRegistry
{
  private final Map<String, ServerMethodDefinition<?, ?>> methods;
  private final List<ServerServiceDefinition> services;
  
  private InternalHandlerRegistry(List<ServerServiceDefinition> paramList, Map<String, ServerMethodDefinition<?, ?>> paramMap)
  {
    this.services = paramList;
    this.methods = paramMap;
  }
  
  public List<ServerServiceDefinition> getServices()
  {
    return this.services;
  }
  
  @Nullable
  ServerMethodDefinition<?, ?> lookupMethod(String paramString)
  {
    return (ServerMethodDefinition)this.methods.get(paramString);
  }
  
  static class Builder
  {
    private final HashMap<String, ServerServiceDefinition> services = new LinkedHashMap();
    
    Builder addService(ServerServiceDefinition paramServerServiceDefinition)
    {
      this.services.put(paramServerServiceDefinition.getServiceDescriptor().getName(), paramServerServiceDefinition);
      return this;
    }
    
    InternalHandlerRegistry build()
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator1 = this.services.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ServerServiceDefinition)localIterator1.next()).getMethods().iterator();
        while (localIterator2.hasNext())
        {
          ServerMethodDefinition localServerMethodDefinition = (ServerMethodDefinition)localIterator2.next();
          localHashMap.put(localServerMethodDefinition.getMethodDescriptor().getFullMethodName(), localServerMethodDefinition);
        }
      }
      return new InternalHandlerRegistry(Collections.unmodifiableList(new ArrayList(this.services.values())), Collections.unmodifiableMap(localHashMap), null);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/InternalHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */