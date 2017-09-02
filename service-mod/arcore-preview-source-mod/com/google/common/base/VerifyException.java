package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public class VerifyException
  extends RuntimeException
{
  public VerifyException() {}
  
  public VerifyException(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public VerifyException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public VerifyException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/VerifyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */