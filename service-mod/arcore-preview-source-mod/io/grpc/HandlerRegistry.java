package io.grpc;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class HandlerRegistry
{
  public List<ServerServiceDefinition> getServices()
  {
    return Collections.emptyList();
  }
  
  @Nullable
  public final ServerMethodDefinition<?, ?> lookupMethod(String paramString)
  {
    return lookupMethod(paramString, null);
  }
  
  @Nullable
  public abstract ServerMethodDefinition<?, ?> lookupMethod(String paramString1, @Nullable String paramString2);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/HandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */