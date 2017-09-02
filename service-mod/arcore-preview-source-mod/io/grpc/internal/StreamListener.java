package io.grpc.internal;

import java.io.InputStream;

public abstract interface StreamListener
{
  public abstract void messageRead(InputStream paramInputStream);
  
  public abstract void onReady();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/StreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */