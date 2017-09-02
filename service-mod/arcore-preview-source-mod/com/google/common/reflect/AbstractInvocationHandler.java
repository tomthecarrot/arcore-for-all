package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractInvocationHandler
  implements InvocationHandler
{
  private static final Object[] NO_ARGS = new Object[0];
  
  private static boolean isProxyOfSameInterfaces(Object paramObject, Class<?> paramClass)
  {
    return (paramClass.isInstance(paramObject)) || ((Proxy.isProxyClass(paramObject.getClass())) && (Arrays.equals(paramObject.getClass().getInterfaces(), paramClass.getInterfaces())));
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  protected abstract Object handleInvocation(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable;
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject)
    throws Throwable
  {
    boolean bool = true;
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = NO_ARGS;
    }
    if ((arrayOfObject.length == 0) && (paramMethod.getName().equals("hashCode"))) {
      return Integer.valueOf(hashCode());
    }
    if ((arrayOfObject.length == 1) && (paramMethod.getName().equals("equals")) && (paramMethod.getParameterTypes()[0] == Object.class))
    {
      paramMethod = arrayOfObject[0];
      if (paramMethod == null) {
        return Boolean.valueOf(false);
      }
      if (paramObject == paramMethod) {
        return Boolean.valueOf(true);
      }
      if ((isProxyOfSameInterfaces(paramMethod, paramObject.getClass())) && (equals(Proxy.getInvocationHandler(paramMethod)))) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    if ((arrayOfObject.length == 0) && (paramMethod.getName().equals("toString"))) {
      return toString();
    }
    return handleInvocation(paramObject, paramMethod, arrayOfObject);
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/AbstractInvocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */