package com.google.atap.tangocloudstorage;

public abstract class CloudStorageException
  extends Exception
{
  private final boolean isTransient;
  
  public CloudStorageException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramString, paramThrowable);
    this.isTransient = paramBoolean;
  }
  
  public CloudStorageException(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isTransient = paramBoolean;
  }
  
  public CloudStorageException(Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramThrowable);
    this.isTransient = paramBoolean;
  }
  
  public CloudStorageException(boolean paramBoolean)
  {
    this.isTransient = paramBoolean;
  }
  
  public boolean isTransient()
  {
    return this.isTransient;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/CloudStorageException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */