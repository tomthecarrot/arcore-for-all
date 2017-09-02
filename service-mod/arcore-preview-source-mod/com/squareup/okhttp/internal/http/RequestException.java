package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException
  extends Exception
{
  public RequestException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/RequestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */