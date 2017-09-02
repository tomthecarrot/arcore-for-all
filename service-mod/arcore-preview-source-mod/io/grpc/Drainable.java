package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface Drainable
{
  public abstract int drainTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Drainable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */