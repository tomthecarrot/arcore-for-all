package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ServerServiceDefinition
{
  private final Map<String, ServerMethodDefinition<?, ?>> methods;
  private final ServiceDescriptor serviceDescriptor;
  
  private ServerServiceDefinition(ServiceDescriptor paramServiceDescriptor, Map<String, ServerMethodDefinition<?, ?>> paramMap)
  {
    this.serviceDescriptor = ((ServiceDescriptor)Preconditions.checkNotNull(paramServiceDescriptor, "serviceDescriptor"));
    this.methods = Collections.unmodifiableMap(new HashMap(paramMap));
  }
  
  public static Builder builder(ServiceDescriptor paramServiceDescriptor)
  {
    return new Builder(paramServiceDescriptor, null);
  }
  
  public static Builder builder(String paramString)
  {
    return new Builder(paramString, null);
  }
  
  public ServerMethodDefinition<?, ?> getMethod(String paramString)
  {
    return (ServerMethodDefinition)this.methods.get(paramString);
  }
  
  public Collection<ServerMethodDefinition<?, ?>> getMethods()
  {
    return this.methods.values();
  }
  
  public ServiceDescriptor getServiceDescriptor()
  {
    return this.serviceDescriptor;
  }
  
  public static final class Builder
  {
    private final Map<String, ServerMethodDefinition<?, ?>> methods = new HashMap();
    private final ServiceDescriptor serviceDescriptor;
    private final String serviceName;
    
    private Builder(ServiceDescriptor paramServiceDescriptor)
    {
      this.serviceDescriptor = ((ServiceDescriptor)Preconditions.checkNotNull(paramServiceDescriptor, "serviceDescriptor"));
      this.serviceName = paramServiceDescriptor.getName();
    }
    
    private Builder(String paramString)
    {
      this.serviceName = ((String)Preconditions.checkNotNull(paramString, "serviceName"));
      this.serviceDescriptor = null;
    }
    
    public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler)
    {
      return addMethod(ServerMethodDefinition.create((MethodDescriptor)Preconditions.checkNotNull(paramMethodDescriptor, "method must not be null"), (ServerCallHandler)Preconditions.checkNotNull(paramServerCallHandler, "handler must not be null")));
    }
    
    public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> paramServerMethodDefinition)
    {
      Object localObject = paramServerMethodDefinition.getMethodDescriptor();
      Preconditions.checkArgument(this.serviceName.equals(MethodDescriptor.extractFullServiceName(((MethodDescriptor)localObject).getFullMethodName())), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", new Object[] { this.serviceName, ((MethodDescriptor)localObject).getFullMethodName() });
      localObject = ((MethodDescriptor)localObject).getFullMethodName();
      if (!this.methods.containsKey(localObject)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Method by same name already registered: %s", new Object[] { localObject });
        this.methods.put(localObject, paramServerMethodDefinition);
        return this;
      }
    }
    
    public ServerServiceDefinition build()
    {
      Object localObject2 = this.serviceDescriptor;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(this.methods.size());
        localObject2 = this.methods.values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((ServerMethodDefinition)((Iterator)localObject2).next()).getMethodDescriptor());
        }
        localObject1 = new ServiceDescriptor(this.serviceName, (Collection)localObject1);
      }
      localObject2 = new HashMap(this.methods);
      Iterator localIterator = ((ServiceDescriptor)localObject1).getMethods().iterator();
      while (localIterator.hasNext())
      {
        MethodDescriptor localMethodDescriptor = (MethodDescriptor)localIterator.next();
        ServerMethodDefinition localServerMethodDefinition = (ServerMethodDefinition)((Map)localObject2).remove(localMethodDescriptor.getFullMethodName());
        if (localServerMethodDefinition == null) {
          throw new IllegalStateException("No method bound for descriptor entry " + localMethodDescriptor.getFullMethodName());
        }
        if (localServerMethodDefinition.getMethodDescriptor() != localMethodDescriptor) {
          throw new IllegalStateException("Bound method for " + localMethodDescriptor.getFullMethodName() + " not same instance as method in service descriptor");
        }
      }
      if (((Map)localObject2).size() > 0) {
        throw new IllegalStateException("No entry in descriptor matching bound method " + ((ServerMethodDefinition)((Map)localObject2).values().iterator().next()).getMethodDescriptor().getFullMethodName());
      }
      return new ServerServiceDefinition((ServiceDescriptor)localObject1, this.methods, null);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerServiceDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */