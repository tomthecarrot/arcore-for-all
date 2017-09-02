package com.google.atap.tangocloudstorage;

public class FileIOException
  extends CloudStorageException
{
  public FileIOException()
  {
    super(false);
  }
  
  public FileIOException(String paramString)
  {
    super(paramString, false);
  }
  
  public FileIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable, false);
  }
  
  public FileIOException(Throwable paramThrowable)
  {
    super(paramThrowable, false);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/FileIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */