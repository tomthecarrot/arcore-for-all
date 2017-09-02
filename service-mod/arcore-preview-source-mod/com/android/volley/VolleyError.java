package com.android.volley;

public class VolleyError
  extends Exception
{
  public final NetworkResponse networkResponse;
  
  public VolleyError()
  {
    this.networkResponse = null;
  }
  
  public VolleyError(NetworkResponse paramNetworkResponse)
  {
    this.networkResponse = paramNetworkResponse;
  }
  
  public VolleyError(String paramString)
  {
    super(paramString);
    this.networkResponse = null;
  }
  
  public VolleyError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.networkResponse = null;
  }
  
  public VolleyError(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.networkResponse = null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/VolleyError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */