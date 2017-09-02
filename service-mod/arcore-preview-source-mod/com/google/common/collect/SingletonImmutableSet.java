package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible(emulated=true, serializable=true)
final class SingletonImmutableSet<E>
  extends ImmutableSet<E>
{
  private transient int cachedHashCode;
  final transient E element;
  
  SingletonImmutableSet(E paramE)
  {
    this.element = Preconditions.checkNotNull(paramE);
  }
  
  SingletonImmutableSet(E paramE, int paramInt)
  {
    this.element = paramE;
    this.cachedHashCode = paramInt;
  }
  
  public boolean contains(Object paramObject)
  {
    return this.element.equals(paramObject);
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[paramInt] = this.element;
    return paramInt + 1;
  }
  
  public final int hashCode()
  {
    int j = this.cachedHashCode;
    int i = j;
    if (j == 0)
    {
      i = this.element.hashCode();
      this.cachedHashCode = i;
    }
    return i;
  }
  
  boolean isHashCodeFast()
  {
    return this.cachedHashCode != 0;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.singletonIterator(this.element);
  }
  
  public int size()
  {
    return 1;
  }
  
  public String toString()
  {
    String str = this.element.toString();
    return str.length() + 2 + '[' + str + ']';
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/SingletonImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */