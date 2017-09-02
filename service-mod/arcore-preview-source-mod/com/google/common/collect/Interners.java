package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

@Beta
public final class Interners
{
  public static <E> Function<E, E> asFunction(Interner<E> paramInterner)
  {
    return new InternerFunction((Interner)Preconditions.checkNotNull(paramInterner));
  }
  
  public static <E> Interner<E> newStrongInterner()
  {
    new Interner()
    {
      public E intern(E paramAnonymousE)
      {
        Object localObject = this.val$map.putIfAbsent(Preconditions.checkNotNull(paramAnonymousE), paramAnonymousE);
        if (localObject == null) {
          return paramAnonymousE;
        }
        return (E)localObject;
      }
    };
  }
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public static <E> Interner<E> newWeakInterner()
  {
    return new WeakInterner(null);
  }
  
  private static class InternerFunction<E>
    implements Function<E, E>
  {
    private final Interner<E> interner;
    
    public InternerFunction(Interner<E> paramInterner)
    {
      this.interner = paramInterner;
    }
    
    public E apply(E paramE)
    {
      return (E)this.interner.intern(paramE);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof InternerFunction))
      {
        paramObject = (InternerFunction)paramObject;
        return this.interner.equals(((InternerFunction)paramObject).interner);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.interner.hashCode();
    }
  }
  
  private static class WeakInterner<E>
    implements Interner<E>
  {
    private final MapMakerInternalMap<E, Dummy> map = new MapMaker().weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
    
    public E intern(E paramE)
    {
      do
      {
        Object localObject = this.map.getEntry(paramE);
        if (localObject != null)
        {
          localObject = ((MapMakerInternalMap.ReferenceEntry)localObject).getKey();
          if (localObject != null) {
            return (E)localObject;
          }
        }
      } while ((Dummy)this.map.putIfAbsent(paramE, Dummy.VALUE) != null);
      return paramE;
    }
    
    private static enum Dummy
    {
      VALUE;
      
      private Dummy() {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Interners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */