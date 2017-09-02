package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
class RegularImmutableMultiset<E>
  extends ImmutableMultiset<E>
{
  static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset(ImmutableList.of());
  private transient ImmutableSet<E> elementSet;
  private final transient Multisets.ImmutableEntry<E>[] entries;
  private final transient int hashCode;
  private final transient Multisets.ImmutableEntry<E>[] hashTable;
  private final transient int size;
  
  RegularImmutableMultiset(Collection<? extends Multiset.Entry<? extends E>> paramCollection)
  {
    int i = paramCollection.size();
    Multisets.ImmutableEntry[] arrayOfImmutableEntry1 = new Multisets.ImmutableEntry[i];
    if (i == 0)
    {
      this.entries = arrayOfImmutableEntry1;
      this.hashTable = null;
      this.size = 0;
      this.hashCode = 0;
      this.elementSet = ImmutableSet.of();
      return;
    }
    int m = Hashing.closedTableSize(i, 1.0D);
    Multisets.ImmutableEntry[] arrayOfImmutableEntry2 = new Multisets.ImmutableEntry[m];
    i = 0;
    int j = 0;
    long l = 0L;
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      paramCollection = (Multiset.Entry)localIterator.next();
      Object localObject = Preconditions.checkNotNull(paramCollection.getElement());
      int n = paramCollection.getCount();
      int i2 = localObject.hashCode();
      int i1 = Hashing.smear(i2) & m - 1;
      Multisets.ImmutableEntry localImmutableEntry = arrayOfImmutableEntry2[i1];
      int k;
      if (localImmutableEntry == null) {
        if (((paramCollection instanceof Multisets.ImmutableEntry)) && (!(paramCollection instanceof NonTerminalEntry)))
        {
          k = 1;
          label167:
          if (k == 0) {
            break label217;
          }
          paramCollection = (Multisets.ImmutableEntry)paramCollection;
        }
      }
      for (;;)
      {
        j += (i2 ^ n);
        arrayOfImmutableEntry1[i] = paramCollection;
        arrayOfImmutableEntry2[i1] = paramCollection;
        l += n;
        i += 1;
        break;
        k = 0;
        break label167;
        label217:
        paramCollection = new Multisets.ImmutableEntry(localObject, n);
        continue;
        paramCollection = new NonTerminalEntry(localObject, n, localImmutableEntry);
      }
    }
    this.entries = arrayOfImmutableEntry1;
    this.hashTable = arrayOfImmutableEntry2;
    this.size = Ints.saturatedCast(l);
    this.hashCode = j;
  }
  
  public int count(@Nullable Object paramObject)
  {
    Object localObject = this.hashTable;
    if ((paramObject == null) || (localObject == null)) {}
    for (;;)
    {
      return 0;
      for (localObject = localObject[(Hashing.smearedHash(paramObject) & localObject.length - 1)]; localObject != null; localObject = ((Multisets.ImmutableEntry)localObject).nextInBucket()) {
        if (Objects.equal(paramObject, ((Multisets.ImmutableEntry)localObject).getElement())) {
          return ((Multisets.ImmutableEntry)localObject).getCount();
        }
      }
    }
  }
  
  public ImmutableSet<E> elementSet()
  {
    ImmutableSet localImmutableSet = this.elementSet;
    Object localObject = localImmutableSet;
    if (localImmutableSet == null)
    {
      localObject = new ElementSet(null);
      this.elementSet = ((ImmutableSet)localObject);
    }
    return (ImmutableSet<E>)localObject;
  }
  
  Multiset.Entry<E> getEntry(int paramInt)
  {
    return this.entries[paramInt];
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.size;
  }
  
  private final class ElementSet
    extends ImmutableSet.Indexed<E>
  {
    private ElementSet() {}
    
    public boolean contains(@Nullable Object paramObject)
    {
      return RegularImmutableMultiset.this.contains(paramObject);
    }
    
    E get(int paramInt)
    {
      return (E)RegularImmutableMultiset.this.entries[paramInt].getElement();
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return RegularImmutableMultiset.this.entries.length;
    }
  }
  
  private static final class NonTerminalEntry<E>
    extends Multisets.ImmutableEntry<E>
  {
    private final Multisets.ImmutableEntry<E> nextInBucket;
    
    NonTerminalEntry(E paramE, int paramInt, Multisets.ImmutableEntry<E> paramImmutableEntry)
    {
      super(paramInt);
      this.nextInBucket = paramImmutableEntry;
    }
    
    public Multisets.ImmutableEntry<E> nextInBucket()
    {
      return this.nextInBucket;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */