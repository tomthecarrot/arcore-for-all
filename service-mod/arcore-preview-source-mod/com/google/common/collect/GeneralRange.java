package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class GeneralRange<T>
  implements Serializable
{
  private final Comparator<? super T> comparator;
  private final boolean hasLowerBound;
  private final boolean hasUpperBound;
  private final BoundType lowerBoundType;
  @Nullable
  private final T lowerEndpoint;
  private transient GeneralRange<T> reverse;
  private final BoundType upperBoundType;
  @Nullable
  private final T upperEndpoint;
  
  private GeneralRange(Comparator<? super T> paramComparator, boolean paramBoolean1, @Nullable T paramT1, BoundType paramBoundType1, boolean paramBoolean2, @Nullable T paramT2, BoundType paramBoundType2)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    this.hasLowerBound = paramBoolean1;
    this.hasUpperBound = paramBoolean2;
    this.lowerEndpoint = paramT1;
    this.lowerBoundType = ((BoundType)Preconditions.checkNotNull(paramBoundType1));
    this.upperEndpoint = paramT2;
    this.upperBoundType = ((BoundType)Preconditions.checkNotNull(paramBoundType2));
    if (paramBoolean1) {
      paramComparator.compare(paramT1, paramT1);
    }
    if (paramBoolean2) {
      paramComparator.compare(paramT2, paramT2);
    }
    int i;
    if ((paramBoolean1) && (paramBoolean2))
    {
      i = paramComparator.compare(paramT1, paramT2);
      if (i > 0) {
        break label172;
      }
      paramBoolean1 = true;
      Preconditions.checkArgument(paramBoolean1, "lowerEndpoint (%s) > upperEndpoint (%s)", new Object[] { paramT1, paramT2 });
      if (i == 0)
      {
        if (paramBoundType1 == BoundType.OPEN) {
          break label177;
        }
        i = 1;
        label155:
        if (paramBoundType2 == BoundType.OPEN) {
          break label183;
        }
      }
    }
    for (;;)
    {
      Preconditions.checkArgument(i | j);
      return;
      label172:
      paramBoolean1 = false;
      break;
      label177:
      i = 0;
      break label155;
      label183:
      j = 0;
    }
  }
  
  static <T> GeneralRange<T> all(Comparator<? super T> paramComparator)
  {
    return new GeneralRange(paramComparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
  }
  
  static <T> GeneralRange<T> downTo(Comparator<? super T> paramComparator, @Nullable T paramT, BoundType paramBoundType)
  {
    return new GeneralRange(paramComparator, true, paramT, paramBoundType, false, null, BoundType.OPEN);
  }
  
  static <T extends Comparable> GeneralRange<T> from(Range<T> paramRange)
  {
    Comparable localComparable1;
    BoundType localBoundType1;
    label24:
    Comparable localComparable2;
    if (paramRange.hasLowerBound())
    {
      localComparable1 = paramRange.lowerEndpoint();
      if (!paramRange.hasLowerBound()) {
        break label78;
      }
      localBoundType1 = paramRange.lowerBoundType();
      if (!paramRange.hasUpperBound()) {
        break label85;
      }
      localComparable2 = paramRange.upperEndpoint();
      label36:
      if (!paramRange.hasUpperBound()) {
        break label90;
      }
    }
    label78:
    label85:
    label90:
    for (BoundType localBoundType2 = paramRange.upperBoundType();; localBoundType2 = BoundType.OPEN)
    {
      return new GeneralRange(Ordering.natural(), paramRange.hasLowerBound(), localComparable1, localBoundType1, paramRange.hasUpperBound(), localComparable2, localBoundType2);
      localComparable1 = null;
      break;
      localBoundType1 = BoundType.OPEN;
      break label24;
      localComparable2 = null;
      break label36;
    }
  }
  
  static <T> GeneralRange<T> range(Comparator<? super T> paramComparator, @Nullable T paramT1, BoundType paramBoundType1, @Nullable T paramT2, BoundType paramBoundType2)
  {
    return new GeneralRange(paramComparator, true, paramT1, paramBoundType1, true, paramT2, paramBoundType2);
  }
  
  static <T> GeneralRange<T> upTo(Comparator<? super T> paramComparator, @Nullable T paramT, BoundType paramBoundType)
  {
    return new GeneralRange(paramComparator, false, null, BoundType.OPEN, true, paramT, paramBoundType);
  }
  
  Comparator<? super T> comparator()
  {
    return this.comparator;
  }
  
  boolean contains(@Nullable T paramT)
  {
    return (!tooLow(paramT)) && (!tooHigh(paramT));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof GeneralRange))
    {
      paramObject = (GeneralRange)paramObject;
      bool1 = bool2;
      if (this.comparator.equals(((GeneralRange)paramObject).comparator))
      {
        bool1 = bool2;
        if (this.hasLowerBound == ((GeneralRange)paramObject).hasLowerBound)
        {
          bool1 = bool2;
          if (this.hasUpperBound == ((GeneralRange)paramObject).hasUpperBound)
          {
            bool1 = bool2;
            if (getLowerBoundType().equals(((GeneralRange)paramObject).getLowerBoundType()))
            {
              bool1 = bool2;
              if (getUpperBoundType().equals(((GeneralRange)paramObject).getUpperBoundType()))
              {
                bool1 = bool2;
                if (Objects.equal(getLowerEndpoint(), ((GeneralRange)paramObject).getLowerEndpoint()))
                {
                  bool1 = bool2;
                  if (Objects.equal(getUpperEndpoint(), ((GeneralRange)paramObject).getUpperEndpoint())) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  BoundType getLowerBoundType()
  {
    return this.lowerBoundType;
  }
  
  T getLowerEndpoint()
  {
    return (T)this.lowerEndpoint;
  }
  
  BoundType getUpperBoundType()
  {
    return this.upperBoundType;
  }
  
  T getUpperEndpoint()
  {
    return (T)this.upperEndpoint;
  }
  
  boolean hasLowerBound()
  {
    return this.hasLowerBound;
  }
  
  boolean hasUpperBound()
  {
    return this.hasUpperBound;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType() });
  }
  
  GeneralRange<T> intersect(GeneralRange<T> paramGeneralRange)
  {
    Preconditions.checkNotNull(paramGeneralRange);
    Preconditions.checkArgument(this.comparator.equals(paramGeneralRange.comparator));
    boolean bool2 = this.hasLowerBound;
    Object localObject3 = getLowerEndpoint();
    Object localObject4 = getLowerBoundType();
    boolean bool1;
    Object localObject1;
    Object localObject2;
    boolean bool3;
    Object localObject5;
    Object localObject6;
    if (!hasLowerBound())
    {
      bool1 = paramGeneralRange.hasLowerBound;
      localObject1 = paramGeneralRange.getLowerEndpoint();
      localObject2 = paramGeneralRange.getLowerBoundType();
      bool3 = this.hasUpperBound;
      localObject5 = getUpperEndpoint();
      localObject6 = getUpperBoundType();
      if (hasUpperBound()) {
        break label337;
      }
      bool2 = paramGeneralRange.hasUpperBound;
      localObject3 = paramGeneralRange.getUpperEndpoint();
      localObject4 = paramGeneralRange.getUpperBoundType();
    }
    for (;;)
    {
      localObject6 = localObject1;
      localObject5 = localObject2;
      paramGeneralRange = (GeneralRange<T>)localObject4;
      if (bool1)
      {
        localObject6 = localObject1;
        localObject5 = localObject2;
        paramGeneralRange = (GeneralRange<T>)localObject4;
        if (bool2)
        {
          i = this.comparator.compare(localObject1, localObject3);
          if (i <= 0)
          {
            localObject6 = localObject1;
            localObject5 = localObject2;
            paramGeneralRange = (GeneralRange<T>)localObject4;
            if (i == 0)
            {
              localObject6 = localObject1;
              localObject5 = localObject2;
              paramGeneralRange = (GeneralRange<T>)localObject4;
              if (localObject2 == BoundType.OPEN)
              {
                localObject6 = localObject1;
                localObject5 = localObject2;
                paramGeneralRange = (GeneralRange<T>)localObject4;
                if (localObject4 != BoundType.OPEN) {}
              }
            }
          }
          else
          {
            localObject6 = localObject3;
            localObject5 = BoundType.OPEN;
            paramGeneralRange = BoundType.CLOSED;
          }
        }
      }
      return new GeneralRange(this.comparator, bool1, localObject6, (BoundType)localObject5, bool2, localObject3, paramGeneralRange);
      bool1 = bool2;
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (!paramGeneralRange.hasLowerBound()) {
        break;
      }
      int i = this.comparator.compare(getLowerEndpoint(), paramGeneralRange.getLowerEndpoint());
      if (i >= 0)
      {
        bool1 = bool2;
        localObject1 = localObject3;
        localObject2 = localObject4;
        if (i != 0) {
          break;
        }
        bool1 = bool2;
        localObject1 = localObject3;
        localObject2 = localObject4;
        if (paramGeneralRange.getLowerBoundType() != BoundType.OPEN) {
          break;
        }
      }
      localObject1 = paramGeneralRange.getLowerEndpoint();
      localObject2 = paramGeneralRange.getLowerBoundType();
      bool1 = bool2;
      break;
      label337:
      bool2 = bool3;
      localObject3 = localObject5;
      localObject4 = localObject6;
      if (paramGeneralRange.hasUpperBound())
      {
        i = this.comparator.compare(getUpperEndpoint(), paramGeneralRange.getUpperEndpoint());
        if (i <= 0)
        {
          bool2 = bool3;
          localObject3 = localObject5;
          localObject4 = localObject6;
          if (i == 0)
          {
            bool2 = bool3;
            localObject3 = localObject5;
            localObject4 = localObject6;
            if (paramGeneralRange.getUpperBoundType() != BoundType.OPEN) {}
          }
        }
        else
        {
          localObject3 = paramGeneralRange.getUpperEndpoint();
          localObject4 = paramGeneralRange.getUpperBoundType();
          bool2 = bool3;
        }
      }
    }
  }
  
  boolean isEmpty()
  {
    return ((hasUpperBound()) && (tooLow(getUpperEndpoint()))) || ((hasLowerBound()) && (tooHigh(getLowerEndpoint())));
  }
  
  GeneralRange<T> reverse()
  {
    GeneralRange localGeneralRange = this.reverse;
    if (localGeneralRange == null)
    {
      localGeneralRange = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
      localGeneralRange.reverse = this;
      this.reverse = localGeneralRange;
      return localGeneralRange;
    }
    return localGeneralRange;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder().append(this.comparator).append(":");
    if (this.lowerBoundType == BoundType.CLOSED)
    {
      c = '[';
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append(c);
      if (!this.hasLowerBound) {
        break label108;
      }
      localObject = this.lowerEndpoint;
      label51:
      localStringBuilder = localStringBuilder.append(localObject).append(',');
      if (!this.hasUpperBound) {
        break label114;
      }
      localObject = this.upperEndpoint;
      label74:
      localObject = localStringBuilder.append(localObject);
      if (this.upperBoundType != BoundType.CLOSED) {
        break label120;
      }
    }
    label108:
    label114:
    label120:
    for (char c = ']';; c = ')')
    {
      return c;
      c = '(';
      break;
      localObject = "-∞";
      break label51;
      localObject = "∞";
      break label74;
    }
  }
  
  boolean tooHigh(@Nullable T paramT)
  {
    int k = 1;
    if (!hasUpperBound()) {
      return false;
    }
    Object localObject = getUpperEndpoint();
    int j = this.comparator.compare(paramT, localObject);
    int i;
    if (j > 0)
    {
      i = 1;
      if (j != 0) {
        break label65;
      }
      j = 1;
      label43:
      if (getUpperBoundType() != BoundType.OPEN) {
        break label70;
      }
    }
    for (;;)
    {
      return i | j & k;
      i = 0;
      break;
      label65:
      j = 0;
      break label43;
      label70:
      k = 0;
    }
  }
  
  boolean tooLow(@Nullable T paramT)
  {
    int k = 1;
    if (!hasLowerBound()) {
      return false;
    }
    Object localObject = getLowerEndpoint();
    int j = this.comparator.compare(paramT, localObject);
    int i;
    if (j < 0)
    {
      i = 1;
      if (j != 0) {
        break label65;
      }
      j = 1;
      label43:
      if (getLowerBoundType() != BoundType.OPEN) {
        break label70;
      }
    }
    for (;;)
    {
      return i | j & k;
      i = 0;
      break;
      label65:
      j = 0;
      break label43;
      label70:
      k = 0;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/GeneralRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */