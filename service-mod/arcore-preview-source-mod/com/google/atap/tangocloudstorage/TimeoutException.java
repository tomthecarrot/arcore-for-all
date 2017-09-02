package com.google.atap.tangocloudstorage;

public class TimeoutException
  extends CloudStorageException
{
  public TimeoutException()
  {
    super(true);
  }
  
  public TimeoutException(String paramString)
  {
    super(paramString, true);
  }
  
  public TimeoutException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, true);
  }
  
  public TimeoutException(Throwable paramThrowable)
  {
    super(paramThrowable, true);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/TimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */