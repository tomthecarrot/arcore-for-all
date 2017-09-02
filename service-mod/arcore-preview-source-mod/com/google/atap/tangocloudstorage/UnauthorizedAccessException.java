package com.google.atap.tangocloudstorage;

public class UnauthorizedAccessException
  extends CloudStorageException
{
  public UnauthorizedAccessException()
  {
    super(false);
  }
  
  public UnauthorizedAccessException(String paramString)
  {
    super(paramString, false);
  }
  
  public UnauthorizedAccessException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, false);
  }
  
  public UnauthorizedAccessException(Throwable paramThrowable)
  {
    super(paramThrowable, false);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/UnauthorizedAccessException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */