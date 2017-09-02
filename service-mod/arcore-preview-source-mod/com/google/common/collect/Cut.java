package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
abstract class Cut<C extends Comparable>
  implements Comparable<Cut<C>>, Serializable
{
  private static final long serialVersionUID = 0L;
  final C endpoint;
  
  Cut(@Nullable C paramC)
  {
    this.endpoint = paramC;
  }
  
  static <C extends Comparable> Cut<C> aboveAll()
  {
    return AboveAll.INSTANCE;
  }
  
  static <C extends Comparable> Cut<C> aboveValue(C paramC)
  {
    return new AboveValue(paramC);
  }
  
  static <C extends Comparable> Cut<C> belowAll()
  {
    return BelowAll.INSTANCE;
  }
  
  static <C extends Comparable> Cut<C> belowValue(C paramC)
  {
    return new BelowValue(paramC);
  }
  
  Cut<C> canonical(DiscreteDomain<C> paramDiscreteDomain)
  {
    return this;
  }
  
  public int compareTo(Cut<C> paramCut)
  {
    int i;
    if (paramCut == belowAll()) {
      i = 1;
    }
    int j;
    do
    {
      return i;
      if (paramCut == aboveAll()) {
        return -1;
      }
      j = Range.compareOrThrow(this.endpoint, paramCut.endpoint);
      i = j;
    } while (j != 0);
    return Booleans.compare(this instanceof AboveValue, paramCut instanceof AboveValue);
  }
  
  abstract void describeAsLowerBound(StringBuilder paramStringBuilder);
  
  abstract void describeAsUpperBound(StringBuilder paramStringBuilder);
  
  C endpoint()
  {
    return this.endpoint;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Cut)) {
      paramObject = (Cut)paramObject;
    }
    try
    {
      int i = compareTo((Cut)paramObject);
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  abstract C greatestValueBelow(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract boolean isLessThan(C paramC);
  
  abstract C leastValueAbove(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract BoundType typeAsLowerBound();
  
  abstract BoundType typeAsUpperBound();
  
  abstract Cut<C> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract Cut<C> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  private static final class AboveAll
    extends Cut<Comparable<?>>
  {
    private static final AboveAll INSTANCE = new AboveAll();
    private static final long serialVersionUID = 0L;
    
    private AboveAll()
    {
      super();
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public int compareTo(Cut<Comparable<?>> paramCut)
    {
      if (paramCut == this) {
        return 0;
      }
      return 1;
    }
    
    void describeAsLowerBound(StringBuilder paramStringBuilder)
    {
      throw new AssertionError();
    }
    
    void describeAsUpperBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("+∞)");
    }
    
    Comparable<?> endpoint()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      return paramDiscreteDomain.maxValue();
    }
    
    boolean isLessThan(Comparable<?> paramComparable)
    {
      return false;
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new AssertionError();
    }
    
    public String toString()
    {
      return "+∞";
    }
    
    BoundType typeAsLowerBound()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    BoundType typeAsUpperBound()
    {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new IllegalStateException();
    }
  }
  
  private static final class AboveValue<C extends Comparable>
    extends Cut<C>
  {
    private static final long serialVersionUID = 0L;
    
    AboveValue(C paramC)
    {
      super();
    }
    
    Cut<C> canonical(DiscreteDomain<C> paramDiscreteDomain)
    {
      paramDiscreteDomain = leastValueAbove(paramDiscreteDomain);
      if (paramDiscreteDomain != null) {
        return belowValue(paramDiscreteDomain);
      }
      return Cut.aboveAll();
    }
    
    void describeAsLowerBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append('(').append(this.endpoint);
    }
    
    void describeAsUpperBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.endpoint).append(']');
    }
    
    C greatestValueBelow(DiscreteDomain<C> paramDiscreteDomain)
    {
      return this.endpoint;
    }
    
    public int hashCode()
    {
      return this.endpoint.hashCode() ^ 0xFFFFFFFF;
    }
    
    boolean isLessThan(C paramC)
    {
      return Range.compareOrThrow(this.endpoint, paramC) < 0;
    }
    
    C leastValueAbove(DiscreteDomain<C> paramDiscreteDomain)
    {
      return paramDiscreteDomain.next(this.endpoint);
    }
    
    public String toString()
    {
      return "/" + this.endpoint + "\\";
    }
    
    BoundType typeAsLowerBound()
    {
      return BoundType.OPEN;
    }
    
    BoundType typeAsUpperBound()
    {
      return BoundType.CLOSED;
    }
    
    Cut<C> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain)
    {
      Object localObject = this;
      switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[paramBoundType.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 1: 
        paramBoundType = paramDiscreteDomain.next(this.endpoint);
        if (paramBoundType != null) {
          break;
        }
      }
      for (paramBoundType = Cut.belowAll();; paramBoundType = belowValue(paramBoundType))
      {
        localObject = paramBoundType;
        return (Cut<C>)localObject;
      }
    }
    
    Cut<C> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain)
    {
      switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[paramBoundType.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 2: 
        paramBoundType = paramDiscreteDomain.next(this.endpoint);
        if (paramBoundType == null) {
          return Cut.aboveAll();
        }
        return belowValue(paramBoundType);
      }
      return this;
    }
  }
  
  private static final class BelowAll
    extends Cut<Comparable<?>>
  {
    private static final BelowAll INSTANCE = new BelowAll();
    private static final long serialVersionUID = 0L;
    
    private BelowAll()
    {
      super();
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      try
      {
        paramDiscreteDomain = Cut.belowValue(paramDiscreteDomain.minValue());
        return paramDiscreteDomain;
      }
      catch (NoSuchElementException paramDiscreteDomain) {}
      return this;
    }
    
    public int compareTo(Cut<Comparable<?>> paramCut)
    {
      if (paramCut == this) {
        return 0;
      }
      return -1;
    }
    
    void describeAsLowerBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("(-∞");
    }
    
    void describeAsUpperBound(StringBuilder paramStringBuilder)
    {
      throw new AssertionError();
    }
    
    Comparable<?> endpoint()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new AssertionError();
    }
    
    boolean isLessThan(Comparable<?> paramComparable)
    {
      return true;
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      return paramDiscreteDomain.minValue();
    }
    
    public String toString()
    {
      return "-∞";
    }
    
    BoundType typeAsLowerBound()
    {
      throw new IllegalStateException();
    }
    
    BoundType typeAsUpperBound()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<Comparable<?>> paramDiscreteDomain)
    {
      throw new AssertionError("this statement should be unreachable");
    }
  }
  
  private static final class BelowValue<C extends Comparable>
    extends Cut<C>
  {
    private static final long serialVersionUID = 0L;
    
    BelowValue(C paramC)
    {
      super();
    }
    
    void describeAsLowerBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append('[').append(this.endpoint);
    }
    
    void describeAsUpperBound(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.endpoint).append(')');
    }
    
    C greatestValueBelow(DiscreteDomain<C> paramDiscreteDomain)
    {
      return paramDiscreteDomain.previous(this.endpoint);
    }
    
    public int hashCode()
    {
      return this.endpoint.hashCode();
    }
    
    boolean isLessThan(C paramC)
    {
      return Range.compareOrThrow(this.endpoint, paramC) <= 0;
    }
    
    C leastValueAbove(DiscreteDomain<C> paramDiscreteDomain)
    {
      return this.endpoint;
    }
    
    public String toString()
    {
      return "\\" + this.endpoint + "/";
    }
    
    BoundType typeAsLowerBound()
    {
      return BoundType.CLOSED;
    }
    
    BoundType typeAsUpperBound()
    {
      return BoundType.OPEN;
    }
    
    Cut<C> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain)
    {
      Object localObject = this;
      switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[paramBoundType.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 2: 
        paramBoundType = paramDiscreteDomain.previous(this.endpoint);
        if (paramBoundType != null) {
          break;
        }
      }
      for (paramBoundType = Cut.belowAll();; paramBoundType = new Cut.AboveValue(paramBoundType))
      {
        localObject = paramBoundType;
        return (Cut<C>)localObject;
      }
    }
    
    Cut<C> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain)
    {
      switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[paramBoundType.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 1: 
        paramBoundType = paramDiscreteDomain.previous(this.endpoint);
        if (paramBoundType == null) {
          return Cut.aboveAll();
        }
        return new Cut.AboveValue(paramBoundType);
      }
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Cut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */