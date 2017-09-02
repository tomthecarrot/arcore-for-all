package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public final class ServiceDescriptor
{
  private final Collection<MethodDescriptor<?, ?>> methods;
  private final String name;
  private final Object schemaDescriptor;
  
  private ServiceDescriptor(Builder paramBuilder)
  {
    this.name = paramBuilder.name;
    validateMethodNames(this.name, paramBuilder.methods);
    this.methods = Collections.unmodifiableList(new ArrayList(paramBuilder.methods));
    this.schemaDescriptor = paramBuilder.schemaDescriptor;
  }
  
  public ServiceDescriptor(String paramString, Collection<MethodDescriptor<?, ?>> paramCollection)
  {
    this(newBuilder(paramString).addAllMethods((Collection)Preconditions.checkNotNull(paramCollection, "methods")));
  }
  
  public ServiceDescriptor(String paramString, MethodDescriptor<?, ?>... paramVarArgs)
  {
    this(paramString, Arrays.asList(paramVarArgs));
  }
  
  public static Builder newBuilder(String paramString)
  {
    return new Builder(paramString, null);
  }
  
  static void validateMethodNames(String paramString, Collection<MethodDescriptor<?, ?>> paramCollection)
  {
    HashSet localHashSet = new HashSet(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      MethodDescriptor localMethodDescriptor = (MethodDescriptor)paramCollection.next();
      Preconditions.checkNotNull(localMethodDescriptor, "method");
      String str = MethodDescriptor.extractFullServiceName(localMethodDescriptor.getFullMethodName());
      Preconditions.checkArgument(paramString.equals(str), "service names %s != %s", new Object[] { str, paramString });
      Preconditions.checkArgument(localHashSet.add(localMethodDescriptor.getFullMethodName()), "duplicate name %s", new Object[] { localMethodDescriptor.getFullMethodName() });
    }
  }
  
  public Collection<MethodDescriptor<?, ?>> getMethods()
  {
    return this.methods;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  @Nullable
  public Object getSchemaDescriptor()
  {
    return this.schemaDescriptor;
  }
  
  public static final class Builder
  {
    private List<MethodDescriptor<?, ?>> methods = new ArrayList();
    private String name;
    private Object schemaDescriptor;
    
    private Builder(String paramString)
    {
      setName(paramString);
    }
    
    private Builder addAllMethods(Collection<MethodDescriptor<?, ?>> paramCollection)
    {
      this.methods.addAll(paramCollection);
      return this;
    }
    
    public Builder addMethod(MethodDescriptor<?, ?> paramMethodDescriptor)
    {
      this.methods.add(Preconditions.checkNotNull(paramMethodDescriptor, "method"));
      return this;
    }
    
    public ServiceDescriptor build()
    {
      return new ServiceDescriptor(this, null);
    }
    
    public Builder setName(String paramString)
    {
      this.name = ((String)Preconditions.checkNotNull(paramString, "name"));
      return this;
    }
    
    public Builder setSchemaDescriptor(@Nullable Object paramObject)
    {
      this.schemaDescriptor = paramObject;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServiceDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */