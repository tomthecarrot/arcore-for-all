package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Throwables
{
  private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
  @VisibleForTesting
  static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
  @Nullable
  private static final Method getStackTraceDepthMethod;
  @Nullable
  private static final Method getStackTraceElementMethod;
  @Nullable
  private static final Object jla;
  
  static
  {
    Object localObject2 = null;
    jla = getJLA();
    if (jla == null)
    {
      localObject1 = null;
      getStackTraceElementMethod = (Method)localObject1;
      if (jla != null) {
        break label40;
      }
    }
    label40:
    for (Object localObject1 = localObject2;; localObject1 = getSizeMethod())
    {
      getStackTraceDepthMethod = (Method)localObject1;
      return;
      localObject1 = getGetMethod();
      break;
    }
  }
  
  @CheckReturnValue
  @Beta
  public static List<Throwable> getCausalChain(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    ArrayList localArrayList = new ArrayList(4);
    while (paramThrowable != null)
    {
      localArrayList.add(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  @Nullable
  private static Method getGetMethod()
  {
    return getJlaMethod("getStackTraceElement", new Class[] { Throwable.class, Integer.TYPE });
  }
  
  @Nullable
  private static Object getJLA()
  {
    try
    {
      Object localObject = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  @Nullable
  private static Method getJlaMethod(String paramString, Class<?>... paramVarArgs)
    throws ThreadDeath
  {
    try
    {
      paramString = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(paramString, paramVarArgs);
      return paramString;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  @CheckReturnValue
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    for (;;)
    {
      Throwable localThrowable = paramThrowable.getCause();
      if (localThrowable == null) {
        break;
      }
      paramThrowable = localThrowable;
    }
    return paramThrowable;
  }
  
  @Nullable
  private static Method getSizeMethod()
  {
    return getJlaMethod("getStackTraceDepth", new Class[] { Throwable.class });
  }
  
  @CheckReturnValue
  public static String getStackTraceAsString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private static Object invokeAccessibleNonThrowingMethod(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException(paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      throw propagate(paramMethod.getCause());
    }
  }
  
  private static List<StackTraceElement> jlaStackTrace(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    new AbstractList()
    {
      public StackTraceElement get(int paramAnonymousInt)
      {
        return (StackTraceElement)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceElementMethod, Throwables.jla, new Object[] { this.val$t, Integer.valueOf(paramAnonymousInt) });
      }
      
      public int size()
      {
        return ((Integer)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceDepthMethod, Throwables.jla, new Object[] { this.val$t })).intValue();
      }
    };
  }
  
  @CheckReturnValue
  @Beta
  public static List<StackTraceElement> lazyStackTrace(Throwable paramThrowable)
  {
    if (lazyStackTraceIsLazy()) {
      return jlaStackTrace(paramThrowable);
    }
    return Collections.unmodifiableList(Arrays.asList(paramThrowable.getStackTrace()));
  }
  
  @CheckReturnValue
  @Beta
  public static boolean lazyStackTraceIsLazy()
  {
    int j = 1;
    int i;
    if (getStackTraceElementMethod != null)
    {
      i = 1;
      if (getStackTraceDepthMethod == null) {
        break label25;
      }
    }
    for (;;)
    {
      return i & j;
      i = 0;
      break;
      label25:
      j = 0;
    }
  }
  
  public static RuntimeException propagate(Throwable paramThrowable)
  {
    propagateIfPossible((Throwable)Preconditions.checkNotNull(paramThrowable));
    throw new RuntimeException(paramThrowable);
  }
  
  public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    if ((paramThrowable != null) && (paramClass.isInstance(paramThrowable))) {
      throw ((Throwable)paramClass.cast(paramThrowable));
    }
  }
  
  public static void propagateIfPossible(@Nullable Throwable paramThrowable)
  {
    propagateIfInstanceOf(paramThrowable, Error.class);
    propagateIfInstanceOf(paramThrowable, RuntimeException.class);
  }
  
  public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable);
  }
  
  public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1)
    throws Throwable, Throwable
  {
    Preconditions.checkNotNull(paramClass1);
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable, paramClass1);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Throwables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */