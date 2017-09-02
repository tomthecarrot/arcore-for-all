package io.grpc;

import com.google.common.base.Supplier;
import java.util.Collection;

public abstract class TransportManager<T>
{
  public abstract T createFailingTransport(Status paramStatus);
  
  public abstract InterimTransport<T> createInterimTransport();
  
  public abstract OobTransportProvider<T> createOobTransportProvider(EquivalentAddressGroup paramEquivalentAddressGroup, String paramString);
  
  public abstract T getTransport(EquivalentAddressGroup paramEquivalentAddressGroup);
  
  public abstract Channel makeChannel(T paramT);
  
  public abstract void updateRetainedTransports(Collection<EquivalentAddressGroup> paramCollection);
  
  public static abstract interface InterimTransport<T>
  {
    public abstract void closeWithError(Status paramStatus);
    
    public abstract void closeWithRealTransports(Supplier<T> paramSupplier);
    
    public abstract T transport();
  }
  
  public static abstract interface OobTransportProvider<T>
  {
    public abstract void close();
    
    public abstract T get();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/TransportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */