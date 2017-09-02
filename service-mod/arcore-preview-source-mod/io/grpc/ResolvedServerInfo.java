package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class ResolvedServerInfo
{
  private final SocketAddress address;
  private final Attributes attributes;
  
  public ResolvedServerInfo(SocketAddress paramSocketAddress)
  {
    this(paramSocketAddress, Attributes.EMPTY);
  }
  
  public ResolvedServerInfo(SocketAddress paramSocketAddress, Attributes paramAttributes)
  {
    this.address = ((SocketAddress)Preconditions.checkNotNull(paramSocketAddress));
    this.attributes = ((Attributes)Preconditions.checkNotNull(paramAttributes));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ResolvedServerInfo)paramObject;
    } while ((Objects.equal(this.address, ((ResolvedServerInfo)paramObject).address)) && (Objects.equal(this.attributes, ((ResolvedServerInfo)paramObject).attributes)));
    return false;
  }
  
  public SocketAddress getAddress()
  {
    return this.address;
  }
  
  public Attributes getAttributes()
  {
    return this.attributes;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.address, this.attributes });
  }
  
  public String toString()
  {
    return "[address=" + this.address + ", attrs=" + this.attributes + "]";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ResolvedServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */