package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Verify
{
  public static void verify(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new VerifyException();
    }
  }
  
  public static void verify(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new VerifyException(Preconditions.format(paramString, paramVarArgs));
    }
  }
  
  public static <T> T verifyNotNull(@Nullable T paramT)
  {
    return (T)verifyNotNull(paramT, "expected a non-null reference", new Object[0]);
  }
  
  public static <T> T verifyNotNull(@Nullable T paramT, @Nullable String paramString, @Nullable Object... paramVarArgs)
  {
    if (paramT != null) {}
    for (boolean bool = true;; bool = false)
    {
      verify(bool, paramString, paramVarArgs);
      return paramT;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Verify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */