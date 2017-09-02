package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

public abstract interface Authenticator
{
  public abstract Request authenticate(Proxy paramProxy, Response paramResponse)
    throws IOException;
  
  public abstract Request authenticateProxy(Proxy paramProxy, Response paramResponse)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */