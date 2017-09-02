package com.google.instrumentation.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;

public final class Provider
{
  @Nullable
  public static <T> T newInstance(String paramString, @Nullable T paramT)
  {
    try
    {
      paramString = Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramString;
    }
    catch (NoSuchMethodException paramString)
    {
      return paramT;
    }
    catch (InvocationTargetException paramString)
    {
      return paramT;
    }
    catch (InstantiationException paramString)
    {
      return paramT;
    }
    catch (IllegalAccessException paramString)
    {
      return paramT;
    }
    catch (ClassNotFoundException paramString) {}
    return paramT;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/common/Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */