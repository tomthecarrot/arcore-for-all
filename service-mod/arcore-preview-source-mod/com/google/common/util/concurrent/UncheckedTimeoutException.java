package com.google.common.util.concurrent;

import javax.annotation.Nullable;

public class UncheckedTimeoutException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public UncheckedTimeoutException() {}
  
  public UncheckedTimeoutException(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public UncheckedTimeoutException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UncheckedTimeoutException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/UncheckedTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */