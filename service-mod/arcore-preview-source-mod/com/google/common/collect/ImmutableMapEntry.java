package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible("unnecessary")
class ImmutableMapEntry<K, V>
  extends ImmutableEntry<K, V>
{
  ImmutableMapEntry(ImmutableMapEntry<K, V> paramImmutableMapEntry)
  {
    super(paramImmutableMapEntry.getKey(), paramImmutableMapEntry.getValue());
  }
  
  ImmutableMapEntry(K paramK, V paramV)
  {
    super(paramK, paramV);
    CollectPreconditions.checkEntryNotNull(paramK, paramV);
  }
  
  static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int paramInt)
  {
    return new ImmutableMapEntry[paramInt];
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInKeyBucket()
  {
    return null;
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInValueBucket()
  {
    return null;
  }
  
  boolean isReusable()
  {
    return true;
  }
  
  static final class NonTerminalImmutableBiMapEntry<K, V>
    extends ImmutableMapEntry.NonTerminalImmutableMapEntry<K, V>
  {
    private final transient ImmutableMapEntry<K, V> nextInValueBucket;
    
    NonTerminalImmutableBiMapEntry(K paramK, V paramV, ImmutableMapEntry<K, V> paramImmutableMapEntry1, ImmutableMapEntry<K, V> paramImmutableMapEntry2)
    {
      super(paramV, paramImmutableMapEntry1);
      this.nextInValueBucket = paramImmutableMapEntry2;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInValueBucket()
    {
      return this.nextInValueBucket;
    }
  }
  
  static class NonTerminalImmutableMapEntry<K, V>
    extends ImmutableMapEntry<K, V>
  {
    private final transient ImmutableMapEntry<K, V> nextInKeyBucket;
    
    NonTerminalImmutableMapEntry(K paramK, V paramV, ImmutableMapEntry<K, V> paramImmutableMapEntry)
    {
      super(paramV);
      this.nextInKeyBucket = paramImmutableMapEntry;
    }
    
    @Nullable
    final ImmutableMapEntry<K, V> getNextInKeyBucket()
    {
      return this.nextInKeyBucket;
    }
    
    final boolean isReusable()
    {
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */