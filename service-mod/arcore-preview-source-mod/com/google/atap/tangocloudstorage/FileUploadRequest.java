package com.google.atap.tangocloudstorage;

public class FileUploadRequest
{
  public final String destBucket;
  public final String destFileName;
  public final String idToken;
  private boolean isCancellationRequested = false;
  public final String sourceFileName;
  
  public FileUploadRequest(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public FileUploadRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sourceFileName = paramString1;
    this.destBucket = paramString2;
    this.destFileName = paramString3;
    this.idToken = paramString4;
  }
  
  public void cancel()
  {
    this.isCancellationRequested = true;
  }
  
  void throwIfCancellationRequested()
    throws InterruptedException
  {
    if (this.isCancellationRequested) {
      throw new InterruptedException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/FileUploadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */