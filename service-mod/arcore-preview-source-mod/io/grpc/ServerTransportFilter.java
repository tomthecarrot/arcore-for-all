package io.grpc;

public abstract class ServerTransportFilter
{
  public Attributes transportReady(Attributes paramAttributes)
  {
    return paramAttributes;
  }
  
  public void transportTerminated(Attributes paramAttributes) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerTransportFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */