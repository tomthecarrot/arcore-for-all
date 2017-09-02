package io.grpc;

import java.io.IOException;

public abstract interface KnownLength
{
  public abstract int available()
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/KnownLength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */