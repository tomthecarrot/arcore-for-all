package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class Converter<A, B>
  implements Function<A, B>
{
  private final boolean handleNullAutomatically;
  private transient Converter<B, A> reverse;
  
  protected Converter()
  {
    this(true);
  }
  
  Converter(boolean paramBoolean)
  {
    this.handleNullAutomatically = paramBoolean;
  }
  
  public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> paramFunction, Function<? super B, ? extends A> paramFunction1)
  {
    return new FunctionBasedConverter(paramFunction, paramFunction1, null);
  }
  
  public static <T> Converter<T, T> identity()
  {
    return IdentityConverter.INSTANCE;
  }
  
  public final <C> Converter<A, C> andThen(Converter<B, C> paramConverter)
  {
    return doAndThen(paramConverter);
  }
  
  @Deprecated
  @Nullable
  public final B apply(@Nullable A paramA)
  {
    return (B)convert(paramA);
  }
  
  @Nullable
  public final B convert(@Nullable A paramA)
  {
    return (B)correctedDoForward(paramA);
  }
  
  public Iterable<B> convertAll(final Iterable<? extends A> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable, "fromIterable");
    new Iterable()
    {
      public Iterator<B> iterator()
      {
        new Iterator()
        {
          private final Iterator<? extends A> fromIterator = Converter.1.this.val$fromIterable.iterator();
          
          public boolean hasNext()
          {
            return this.fromIterator.hasNext();
          }
          
          public B next()
          {
            return (B)Converter.this.convert(this.fromIterator.next());
          }
          
          public void remove()
          {
            this.fromIterator.remove();
          }
        };
      }
    };
  }
  
  @Nullable
  A correctedDoBackward(@Nullable B paramB)
  {
    if (this.handleNullAutomatically)
    {
      if (paramB == null) {
        return null;
      }
      return (A)Preconditions.checkNotNull(doBackward(paramB));
    }
    return (A)doBackward(paramB);
  }
  
  @Nullable
  B correctedDoForward(@Nullable A paramA)
  {
    if (this.handleNullAutomatically)
    {
      if (paramA == null) {
        return null;
      }
      return (B)Preconditions.checkNotNull(doForward(paramA));
    }
    return (B)doForward(paramA);
  }
  
  <C> Converter<A, C> doAndThen(Converter<B, C> paramConverter)
  {
    return new ConverterComposition(this, (Converter)Preconditions.checkNotNull(paramConverter));
  }
  
  protected abstract A doBackward(B paramB);
  
  protected abstract B doForward(A paramA);
  
  public boolean equals(@Nullable Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Converter<B, A> reverse()
  {
    Converter localConverter = this.reverse;
    Object localObject = localConverter;
    if (localConverter == null)
    {
      localObject = new ReverseConverter(this);
      this.reverse = ((Converter)localObject);
    }
    return (Converter<B, A>)localObject;
  }
  
  private static final class ConverterComposition<A, B, C>
    extends Converter<A, C>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Converter<A, B> first;
    final Converter<B, C> second;
    
    ConverterComposition(Converter<A, B> paramConverter, Converter<B, C> paramConverter1)
    {
      this.first = paramConverter;
      this.second = paramConverter1;
    }
    
    @Nullable
    A correctedDoBackward(@Nullable C paramC)
    {
      return (A)this.first.correctedDoBackward(this.second.correctedDoBackward(paramC));
    }
    
    @Nullable
    C correctedDoForward(@Nullable A paramA)
    {
      return (C)this.second.correctedDoForward(this.first.correctedDoForward(paramA));
    }
    
    protected A doBackward(C paramC)
    {
      throw new AssertionError();
    }
    
    protected C doForward(A paramA)
    {
      throw new AssertionError();
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof ConverterComposition))
      {
        paramObject = (ConverterComposition)paramObject;
        bool1 = bool2;
        if (this.first.equals(((ConverterComposition)paramObject).first))
        {
          bool1 = bool2;
          if (this.second.equals(((ConverterComposition)paramObject).second)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return this.first.hashCode() * 31 + this.second.hashCode();
    }
    
    public String toString()
    {
      return this.first + ".andThen(" + this.second + ")";
    }
  }
  
  private static final class FunctionBasedConverter<A, B>
    extends Converter<A, B>
    implements Serializable
  {
    private final Function<? super B, ? extends A> backwardFunction;
    private final Function<? super A, ? extends B> forwardFunction;
    
    private FunctionBasedConverter(Function<? super A, ? extends B> paramFunction, Function<? super B, ? extends A> paramFunction1)
    {
      this.forwardFunction = ((Function)Preconditions.checkNotNull(paramFunction));
      this.backwardFunction = ((Function)Preconditions.checkNotNull(paramFunction1));
    }
    
    protected A doBackward(B paramB)
    {
      return (A)this.backwardFunction.apply(paramB);
    }
    
    protected B doForward(A paramA)
    {
      return (B)this.forwardFunction.apply(paramA);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof FunctionBasedConverter))
      {
        paramObject = (FunctionBasedConverter)paramObject;
        bool1 = bool2;
        if (this.forwardFunction.equals(((FunctionBasedConverter)paramObject).forwardFunction))
        {
          bool1 = bool2;
          if (this.backwardFunction.equals(((FunctionBasedConverter)paramObject).backwardFunction)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
    }
    
    public String toString()
    {
      return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
    }
  }
  
  private static final class IdentityConverter<T>
    extends Converter<T, T>
    implements Serializable
  {
    static final IdentityConverter INSTANCE = new IdentityConverter();
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    <S> Converter<T, S> doAndThen(Converter<T, S> paramConverter)
    {
      return (Converter)Preconditions.checkNotNull(paramConverter, "otherConverter");
    }
    
    protected T doBackward(T paramT)
    {
      return paramT;
    }
    
    protected T doForward(T paramT)
    {
      return paramT;
    }
    
    public IdentityConverter<T> reverse()
    {
      return this;
    }
    
    public String toString()
    {
      return "Converter.identity()";
    }
  }
  
  private static final class ReverseConverter<A, B>
    extends Converter<B, A>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Converter<A, B> original;
    
    ReverseConverter(Converter<A, B> paramConverter)
    {
      this.original = paramConverter;
    }
    
    @Nullable
    B correctedDoBackward(@Nullable A paramA)
    {
      return (B)this.original.correctedDoForward(paramA);
    }
    
    @Nullable
    A correctedDoForward(@Nullable B paramB)
    {
      return (A)this.original.correctedDoBackward(paramB);
    }
    
    protected B doBackward(A paramA)
    {
      throw new AssertionError();
    }
    
    protected A doForward(B paramB)
    {
      throw new AssertionError();
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof ReverseConverter))
      {
        paramObject = (ReverseConverter)paramObject;
        return this.original.equals(((ReverseConverter)paramObject).original);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.original.hashCode() ^ 0xFFFFFFFF;
    }
    
    public Converter<A, B> reverse()
    {
      return this.original;
    }
    
    public String toString()
    {
      return this.original + ".reverse()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */