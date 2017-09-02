package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class Attributes
{
  public static final Attributes EMPTY = new Attributes();
  private final HashMap<Key<?>, Object> data = new HashMap();
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public static Builder newBuilder(Attributes paramAttributes)
  {
    return newBuilder().setAll(paramAttributes);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (Attributes)paramObject;
    return Objects.equal(this.data, ((Attributes)paramObject).data);
  }
  
  @Nullable
  public <T> T get(Key<T> paramKey)
  {
    return (T)this.data.get(paramKey);
  }
  
  public int hashCode()
  {
    return this.data.hashCode();
  }
  
  public Set<Key<?>> keys()
  {
    return Collections.unmodifiableSet(this.data.keySet());
  }
  
  public String toString()
  {
    return this.data.toString();
  }
  
  public static final class Builder
  {
    private Attributes product = new Attributes(null);
    
    public Attributes build()
    {
      if (this.product != null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Already built");
        Attributes localAttributes = this.product;
        this.product = null;
        return localAttributes;
      }
    }
    
    public <T> Builder set(Attributes.Key<T> paramKey, T paramT)
    {
      this.product.data.put(paramKey, paramT);
      return this;
    }
    
    public <T> Builder setAll(Attributes paramAttributes)
    {
      this.product.data.putAll(paramAttributes.data);
      return this;
    }
  }
  
  public static final class Key<T>
  {
    private final String name;
    
    private Key(String paramString)
    {
      this.name = paramString;
    }
    
    public static <T> Key<T> of(String paramString)
    {
      return new Key(paramString);
    }
    
    public String toString()
    {
      return this.name;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */