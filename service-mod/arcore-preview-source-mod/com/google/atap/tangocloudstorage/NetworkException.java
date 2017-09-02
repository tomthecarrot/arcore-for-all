package com.google.atap.tangocloudstorage;

public class NetworkException
  extends CloudStorageException
{
  public NetworkException()
  {
    super(true);
  }
  
  public NetworkException(String paramString)
  {
    super(paramString, true);
  }
  
  public NetworkException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, true);
  }
  
  public NetworkException(Throwable paramThrowable)
  {
    super(paramThrowable, true);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/NetworkException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */