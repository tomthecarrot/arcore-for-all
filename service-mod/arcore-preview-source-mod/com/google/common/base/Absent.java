package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Absent<T>
  extends Optional<T>
{
  static final Absent<Object> INSTANCE = new Absent();
  private static final long serialVersionUID = 0L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  static <T> Optional<T> withType()
  {
    return INSTANCE;
  }
  
  public Set<T> asSet()
  {
    return Collections.emptySet();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return paramObject == this;
  }
  
  public T get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  public int hashCode()
  {
    return 2040732332;
  }
  
  public boolean isPresent()
  {
    return false;
  }
  
  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    return (Optional)Preconditions.checkNotNull(paramOptional);
  }
  
  public T or(Supplier<? extends T> paramSupplier)
  {
    return (T)Preconditions.checkNotNull(paramSupplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
  }
  
  public T or(T paramT)
  {
    return (T)Preconditions.checkNotNull(paramT, "use Optional.orNull() instead of Optional.or(null)");
  }
  
  @Nullable
  public T orNull()
  {
    return null;
  }
  
  public String toString()
  {
    return "Optional.absent()";
  }
  
  public <V> Optional<V> transform(Function<? super T, V> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return Optional.absent();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Absent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */