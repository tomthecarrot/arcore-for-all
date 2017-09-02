package com.android.volley;

public class Response<T>
{
  public final Cache.Entry cacheEntry;
  public final VolleyError error;
  public boolean intermediate = false;
  public final T result;
  
  private Response(VolleyError paramVolleyError)
  {
    this.result = null;
    this.cacheEntry = null;
    this.error = paramVolleyError;
  }
  
  private Response(T paramT, Cache.Entry paramEntry)
  {
    this.result = paramT;
    this.cacheEntry = paramEntry;
    this.error = null;
  }
  
  public static <T> Response<T> error(VolleyError paramVolleyError)
  {
    return new Response(paramVolleyError);
  }
  
  public static <T> Response<T> success(T paramT, Cache.Entry paramEntry)
  {
    return new Response(paramT, paramEntry);
  }
  
  public boolean isSuccess()
  {
    return this.error == null;
  }
  
  public static abstract interface ErrorListener
  {
    public abstract void onErrorResponse(VolleyError paramVolleyError);
  }
  
  public static abstract interface Listener<T>
  {
    public abstract void onResponse(T paramT);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */