package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;

@GwtCompatible(emulated=true)
class RegularImmutableAsList<E>
  extends ImmutableAsList<E>
{
  @Weak
  private final ImmutableCollection<E> delegate;
  private final ImmutableList<? extends E> delegateList;
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, ImmutableList<? extends E> paramImmutableList)
  {
    this.delegate = paramImmutableCollection;
    this.delegateList = paramImmutableList;
  }
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, Object[] paramArrayOfObject)
  {
    this(paramImmutableCollection, ImmutableList.asImmutableList(paramArrayOfObject));
  }
  
  @GwtIncompatible("not present in emulated superclass")
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    return this.delegateList.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableCollection<E> delegateCollection()
  {
    return this.delegate;
  }
  
  ImmutableList<? extends E> delegateList()
  {
    return this.delegateList;
  }
  
  public E get(int paramInt)
  {
    return (E)this.delegateList.get(paramInt);
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return this.delegateList.listIterator(paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */