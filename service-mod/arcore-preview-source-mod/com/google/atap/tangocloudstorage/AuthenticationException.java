package com.google.atap.tangocloudstorage;

public class AuthenticationException
  extends CloudStorageException
{
  public AuthenticationException()
  {
    super(false);
  }
  
  public AuthenticationException(String paramString)
  {
    super(paramString, false);
  }
  
  public AuthenticationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, false);
  }
  
  public AuthenticationException(Throwable paramThrowable)
  {
    super(paramThrowable, false);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/AuthenticationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */