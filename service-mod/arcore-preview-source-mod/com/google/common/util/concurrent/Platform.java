package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Platform
{
  static boolean isInstanceOfThrowableClass(@Nullable Throwable paramThrowable, Class<? extends Throwable> paramClass)
  {
    return paramClass.isInstance(paramThrowable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */