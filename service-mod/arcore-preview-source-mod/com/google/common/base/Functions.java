package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Functions
{
  public static <A, B, C> Function<A, C> compose(Function<B, C> paramFunction, Function<A, ? extends B> paramFunction1)
  {
    return new FunctionComposition(paramFunction, paramFunction1);
  }
  
  public static <E> Function<Object, E> constant(@Nullable E paramE)
  {
    return new ConstantFunction(paramE);
  }
  
  public static <K, V> Function<K, V> forMap(Map<K, V> paramMap)
  {
    return new FunctionForMapNoDefault(paramMap);
  }
  
  public static <K, V> Function<K, V> forMap(Map<K, ? extends V> paramMap, @Nullable V paramV)
  {
    return new ForMapWithDefault(paramMap, paramV);
  }
  
  public static <T> Function<T, Boolean> forPredicate(Predicate<T> paramPredicate)
  {
    return new PredicateFunction(paramPredicate, null);
  }
  
  @Beta
  public static <T> Function<Object, T> forSupplier(Supplier<T> paramSupplier)
  {
    return new SupplierFunction(paramSupplier, null);
  }
  
  public static <E> Function<E, E> identity()
  {
    return IdentityFunction.INSTANCE;
  }
  
  public static Function<Object, String> toStringFunction()
  {
    return ToStringFunction.INSTANCE;
  }
  
  private static class ConstantFunction<E>
    implements Function<Object, E>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final E value;
    
    public ConstantFunction(@Nullable E paramE)
    {
      this.value = paramE;
    }
    
    public E apply(@Nullable Object paramObject)
    {
      return (E)this.value;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof ConstantFunction))
      {
        paramObject = (ConstantFunction)paramObject;
        return Objects.equal(this.value, ((ConstantFunction)paramObject).value);
      }
      return false;
    }
    
    public int hashCode()
    {
      if (this.value == null) {
        return 0;
      }
      return this.value.hashCode();
    }
    
    public String toString()
    {
      return "Functions.constant(" + this.value + ")";
    }
  }
  
  private static class ForMapWithDefault<K, V>
    implements Function<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final V defaultValue;
    final Map<K, ? extends V> map;
    
    ForMapWithDefault(Map<K, ? extends V> paramMap, @Nullable V paramV)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
      this.defaultValue = paramV;
    }
    
    public V apply(@Nullable K paramK)
    {
      Object localObject = this.map.get(paramK);
      if ((localObject != null) || (this.map.containsKey(paramK))) {
        return (V)localObject;
      }
      return (V)this.defaultValue;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof ForMapWithDefault))
      {
        paramObject = (ForMapWithDefault)paramObject;
        bool1 = bool2;
        if (this.map.equals(((ForMapWithDefault)paramObject).map))
        {
          bool1 = bool2;
          if (Objects.equal(this.defaultValue, ((ForMapWithDefault)paramObject).defaultValue)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.map, this.defaultValue });
    }
    
    public String toString()
    {
      return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
    }
  }
  
  private static class FunctionComposition<A, B, C>
    implements Function<A, C>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Function<A, ? extends B> f;
    private final Function<B, C> g;
    
    public FunctionComposition(Function<B, C> paramFunction, Function<A, ? extends B> paramFunction1)
    {
      this.g = ((Function)Preconditions.checkNotNull(paramFunction));
      this.f = ((Function)Preconditions.checkNotNull(paramFunction1));
    }
    
    public C apply(@Nullable A paramA)
    {
      return (C)this.g.apply(this.f.apply(paramA));
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof FunctionComposition))
      {
        paramObject = (FunctionComposition)paramObject;
        bool1 = bool2;
        if (this.f.equals(((FunctionComposition)paramObject).f))
        {
          bool1 = bool2;
          if (this.g.equals(((FunctionComposition)paramObject).g)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return this.f.hashCode() ^ this.g.hashCode();
    }
    
    public String toString()
    {
      return this.g + "(" + this.f + ")";
    }
  }
  
  private static class FunctionForMapNoDefault<K, V>
    implements Function<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Map<K, V> map;
    
    FunctionForMapNoDefault(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }
    
    public V apply(@Nullable K paramK)
    {
      Object localObject = this.map.get(paramK);
      if ((localObject != null) || (this.map.containsKey(paramK))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Key '%s' not present in map", new Object[] { paramK });
        return (V)localObject;
      }
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof FunctionForMapNoDefault))
      {
        paramObject = (FunctionForMapNoDefault)paramObject;
        return this.map.equals(((FunctionForMapNoDefault)paramObject).map);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.map.hashCode();
    }
    
    public String toString()
    {
      return "Functions.forMap(" + this.map + ")";
    }
  }
  
  private static enum IdentityFunction
    implements Function<Object, Object>
  {
    INSTANCE;
    
    private IdentityFunction() {}
    
    @Nullable
    public Object apply(@Nullable Object paramObject)
    {
      return paramObject;
    }
    
    public String toString()
    {
      return "Functions.identity()";
    }
  }
  
  private static class PredicateFunction<T>
    implements Function<T, Boolean>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Predicate<T> predicate;
    
    private PredicateFunction(Predicate<T> paramPredicate)
    {
      this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
    }
    
    public Boolean apply(@Nullable T paramT)
    {
      return Boolean.valueOf(this.predicate.apply(paramT));
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof PredicateFunction))
      {
        paramObject = (PredicateFunction)paramObject;
        return this.predicate.equals(((PredicateFunction)paramObject).predicate);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.predicate.hashCode();
    }
    
    public String toString()
    {
      return "Functions.forPredicate(" + this.predicate + ")";
    }
  }
  
  private static class SupplierFunction<T>
    implements Function<Object, T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Supplier<T> supplier;
    
    private SupplierFunction(Supplier<T> paramSupplier)
    {
      this.supplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    public T apply(@Nullable Object paramObject)
    {
      return (T)this.supplier.get();
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof SupplierFunction))
      {
        paramObject = (SupplierFunction)paramObject;
        return this.supplier.equals(((SupplierFunction)paramObject).supplier);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.supplier.hashCode();
    }
    
    public String toString()
    {
      return "Functions.forSupplier(" + this.supplier + ")";
    }
  }
  
  private static enum ToStringFunction
    implements Function<Object, String>
  {
    INSTANCE;
    
    private ToStringFunction() {}
    
    public String apply(Object paramObject)
    {
      Preconditions.checkNotNull(paramObject);
      return paramObject.toString();
    }
    
    public String toString()
    {
      return "Functions.toStringFunction()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */