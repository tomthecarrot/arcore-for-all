package io.grpc;

import java.io.IOException;
import java.io.InputStream;

public abstract interface Decompressor
{
  public abstract InputStream decompress(InputStream paramInputStream)
    throws IOException;
  
  public abstract String getMessageEncoding();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Decompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */