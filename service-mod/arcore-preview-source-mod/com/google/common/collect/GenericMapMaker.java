package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Deprecated
@Beta
@GwtCompatible(emulated=true)
abstract class GenericMapMaker<K0, V0>
{
  @GwtIncompatible("To be supported")
  MapMaker.RemovalListener<K0, V0> removalListener;
  
  public abstract GenericMapMaker<K0, V0> concurrencyLevel(int paramInt);
  
  @GwtIncompatible("To be supported")
  abstract GenericMapMaker<K0, V0> expireAfterAccess(long paramLong, TimeUnit paramTimeUnit);
  
  abstract GenericMapMaker<K0, V0> expireAfterWrite(long paramLong, TimeUnit paramTimeUnit);
  
  @GwtIncompatible("To be supported")
  <K extends K0, V extends V0> MapMaker.RemovalListener<K, V> getRemovalListener()
  {
    return (MapMaker.RemovalListener)MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
  }
  
  public abstract GenericMapMaker<K0, V0> initialCapacity(int paramInt);
  
  @GwtIncompatible("To be supported")
  abstract GenericMapMaker<K0, V0> keyEquivalence(Equivalence<Object> paramEquivalence);
  
  @Deprecated
  abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> paramFunction);
  
  @GwtIncompatible("MapMakerInternalMap")
  abstract <K, V> MapMakerInternalMap<K, V> makeCustomMap();
  
  public abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeMap();
  
  abstract GenericMapMaker<K0, V0> maximumSize(int paramInt);
  
  @Deprecated
  @GwtIncompatible("java.lang.ref.SoftReference")
  abstract GenericMapMaker<K0, V0> softValues();
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public abstract GenericMapMaker<K0, V0> weakKeys();
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public abstract GenericMapMaker<K0, V0> weakValues();
  
  @GwtIncompatible("To be supported")
  static enum NullListener
    implements MapMaker.RemovalListener<Object, Object>
  {
    INSTANCE;
    
    private NullListener() {}
    
    public void onRemoval(MapMaker.RemovalNotification<Object, Object> paramRemovalNotification) {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/GenericMapMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */