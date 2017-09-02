package io.grpc;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EquivalentAddressGroup
{
  private final List<SocketAddress> addrs;
  private final int hashCode;
  
  public EquivalentAddressGroup(SocketAddress paramSocketAddress)
  {
    this.addrs = Collections.singletonList(paramSocketAddress);
    this.hashCode = this.addrs.hashCode();
  }
  
  public EquivalentAddressGroup(List<SocketAddress> paramList)
  {
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "addrs is empty");
      this.addrs = Collections.unmodifiableList(new ArrayList(paramList));
      this.hashCode = this.addrs.hashCode();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EquivalentAddressGroup)) {
      return false;
    }
    paramObject = (EquivalentAddressGroup)paramObject;
    if (this.addrs.size() != ((EquivalentAddressGroup)paramObject).addrs.size()) {
      return false;
    }
    int i = 0;
    while (i < this.addrs.size())
    {
      if (!((SocketAddress)this.addrs.get(i)).equals(((EquivalentAddressGroup)paramObject).addrs.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public List<SocketAddress> getAddresses()
  {
    return this.addrs;
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  public String toString()
  {
    return this.addrs.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/EquivalentAddressGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */