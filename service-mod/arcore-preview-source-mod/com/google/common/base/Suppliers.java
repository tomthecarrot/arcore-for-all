package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Suppliers
{
  public static <F, T> Supplier<T> compose(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
  {
    Preconditions.checkNotNull(paramFunction);
    Preconditions.checkNotNull(paramSupplier);
    return new SupplierComposition(paramFunction, paramSupplier);
  }
  
  public static <T> Supplier<T> memoize(Supplier<T> paramSupplier)
  {
    if ((paramSupplier instanceof MemoizingSupplier)) {
      return paramSupplier;
    }
    return new MemoizingSupplier((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
  {
    return new ExpiringMemoizingSupplier(paramSupplier, paramLong, paramTimeUnit);
  }
  
  public static <T> Supplier<T> ofInstance(@Nullable T paramT)
  {
    return new SupplierOfInstance(paramT);
  }
  
  @Beta
  public static <T> Function<Supplier<T>, T> supplierFunction()
  {
    return SupplierFunctionImpl.INSTANCE;
  }
  
  public static <T> Supplier<T> synchronizedSupplier(Supplier<T> paramSupplier)
  {
    return new ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  @VisibleForTesting
  static class ExpiringMemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    final long durationNanos;
    volatile transient long expirationNanos;
    volatile transient T value;
    
    ExpiringMemoizingSupplier(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
    {
      this.delegate = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      this.durationNanos = paramTimeUnit.toNanos(paramLong);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    public T get()
    {
      long l1 = this.expirationNanos;
      long l2 = Platform.systemNanoTime();
      if ((l1 == 0L) || (l2 - l1 >= 0L)) {}
      for (;;)
      {
        try
        {
          if (l1 == this.expirationNanos)
          {
            Object localObject1 = this.delegate.get();
            this.value = localObject1;
            l1 = l2 + this.durationNanos;
            if (l1 == 0L)
            {
              l1 = 1L;
              this.expirationNanos = l1;
              return (T)localObject1;
            }
          }
          else
          {
            return (T)this.value;
          }
        }
        finally {}
      }
    }
    
    public String toString()
    {
      return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
    }
  }
  
  @VisibleForTesting
  static class MemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    volatile transient boolean initialized;
    transient T value;
    
    MemoizingSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public T get()
    {
      if (!this.initialized) {}
      try
      {
        if (!this.initialized)
        {
          Object localObject1 = this.delegate.get();
          this.value = localObject1;
          this.initialized = true;
          return (T)localObject1;
        }
        return (T)this.value;
      }
      finally {}
    }
    
    public String toString()
    {
      return "Suppliers.memoize(" + this.delegate + ")";
    }
  }
  
  private static class SupplierComposition<F, T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Function<? super F, T> function;
    final Supplier<F> supplier;
    
    SupplierComposition(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
    {
      this.function = paramFunction;
      this.supplier = paramSupplier;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof SupplierComposition))
      {
        paramObject = (SupplierComposition)paramObject;
        bool1 = bool2;
        if (this.function.equals(((SupplierComposition)paramObject).function))
        {
          bool1 = bool2;
          if (this.supplier.equals(((SupplierComposition)paramObject).supplier)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public T get()
    {
      return (T)this.function.apply(this.supplier.get());
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.function, this.supplier });
    }
    
    public String toString()
    {
      return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
    }
  }
  
  private static abstract interface SupplierFunction<T>
    extends Function<Supplier<T>, T>
  {}
  
  private static enum SupplierFunctionImpl
    implements Suppliers.SupplierFunction<Object>
  {
    INSTANCE;
    
    private SupplierFunctionImpl() {}
    
    public Object apply(Supplier<Object> paramSupplier)
    {
      return paramSupplier.get();
    }
    
    public String toString()
    {
      return "Suppliers.supplierFunction()";
    }
  }
  
  private static class SupplierOfInstance<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final T instance;
    
    SupplierOfInstance(@Nullable T paramT)
    {
      this.instance = paramT;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof SupplierOfInstance))
      {
        paramObject = (SupplierOfInstance)paramObject;
        return Objects.equal(this.instance, ((SupplierOfInstance)paramObject).instance);
      }
      return false;
    }
    
    public T get()
    {
      return (T)this.instance;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.instance });
    }
    
    public String toString()
    {
      return "Suppliers.ofInstance(" + this.instance + ")";
    }
  }
  
  private static class ThreadSafeSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    
    ThreadSafeSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public T get()
    {
      synchronized (this.delegate)
      {
        Object localObject1 = this.delegate.get();
        return (T)localObject1;
      }
    }
    
    public String toString()
    {
      return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */