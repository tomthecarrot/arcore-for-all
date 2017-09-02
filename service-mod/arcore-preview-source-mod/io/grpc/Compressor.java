package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface Compressor
{
  public abstract OutputStream compress(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract String getMessageEncoding();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Compressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */