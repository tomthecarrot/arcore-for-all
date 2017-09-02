package com.google.atap.tangocloudstorage;

public class ServerException
  extends CloudStorageException
{
  public ServerException()
  {
    super(true);
  }
  
  public ServerException(String paramString)
  {
    super(paramString, true);
  }
  
  public ServerException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, true);
  }
  
  public ServerException(Throwable paramThrowable)
  {
    super(paramThrowable, true);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/ServerException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */