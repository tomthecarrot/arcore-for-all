package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class ResolvedServerInfoGroup
{
  private final Attributes attributes;
  private final List<ResolvedServerInfo> resolvedServerInfoList;
  
  private ResolvedServerInfoGroup(List<ResolvedServerInfo> paramList, Attributes paramAttributes)
  {
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "empty server list");
      this.resolvedServerInfoList = Collections.unmodifiableList(new ArrayList(paramList));
      this.attributes = ((Attributes)Preconditions.checkNotNull(paramAttributes, "attributes"));
      return;
    }
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(Attributes paramAttributes)
  {
    return new Builder(paramAttributes);
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
      paramObject = (ResolvedServerInfoGroup)paramObject;
    } while ((Objects.equal(this.resolvedServerInfoList, ((ResolvedServerInfoGroup)paramObject).resolvedServerInfoList)) && (Objects.equal(this.attributes, ((ResolvedServerInfoGroup)paramObject).attributes)));
    return false;
  }
  
  public Attributes getAttributes()
  {
    return this.attributes;
  }
  
  public List<ResolvedServerInfo> getResolvedServerInfoList()
  {
    return this.resolvedServerInfoList;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.resolvedServerInfoList, this.attributes });
  }
  
  public EquivalentAddressGroup toEquivalentAddressGroup()
  {
    ArrayList localArrayList = new ArrayList(this.resolvedServerInfoList.size());
    Iterator localIterator = this.resolvedServerInfoList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ResolvedServerInfo)localIterator.next()).getAddress());
    }
    return new EquivalentAddressGroup(localArrayList);
  }
  
  public String toString()
  {
    return "[servers=" + this.resolvedServerInfoList + ", attrs=" + this.attributes + "]";
  }
  
  public static final class Builder
  {
    private final Attributes attributes;
    private final List<ResolvedServerInfo> group = new ArrayList();
    
    public Builder()
    {
      this(Attributes.EMPTY);
    }
    
    public Builder(Attributes paramAttributes)
    {
      this.attributes = paramAttributes;
    }
    
    public Builder add(ResolvedServerInfo paramResolvedServerInfo)
    {
      this.group.add(paramResolvedServerInfo);
      return this;
    }
    
    public Builder addAll(Collection<ResolvedServerInfo> paramCollection)
    {
      this.group.addAll(paramCollection);
      return this;
    }
    
    public ResolvedServerInfoGroup build()
    {
      return new ResolvedServerInfoGroup(this.group, this.attributes, null);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ResolvedServerInfoGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */