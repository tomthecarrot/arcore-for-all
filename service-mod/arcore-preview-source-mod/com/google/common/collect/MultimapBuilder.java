package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
@GwtCompatible
public abstract class MultimapBuilder<K0, V0>
{
  private static final int DEFAULT_EXPECTED_KEYS = 8;
  
  public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(Class<K0> paramClass)
  {
    Preconditions.checkNotNull(paramClass);
    new MultimapBuilderWithKeys()
    {
      <K extends K0, V> Map<K, Collection<V>> createMap()
      {
        return new EnumMap(this.val$keyClass);
      }
    };
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys()
  {
    return hashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "expectedKeys");
    new MultimapBuilderWithKeys()
    {
      <K, V> Map<K, Collection<V>> createMap()
      {
        return Maps.newHashMapWithExpectedSize(this.val$expectedKeys);
      }
    };
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys()
  {
    return linkedHashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "expectedKeys");
    new MultimapBuilderWithKeys()
    {
      <K, V> Map<K, Collection<V>> createMap()
      {
        return Maps.newLinkedHashMapWithExpectedSize(this.val$expectedKeys);
      }
    };
  }
  
  public static MultimapBuilderWithKeys<Comparable> treeKeys()
  {
    return treeKeys(Ordering.natural());
  }
  
  public static <K0> MultimapBuilderWithKeys<K0> treeKeys(Comparator<K0> paramComparator)
  {
    Preconditions.checkNotNull(paramComparator);
    new MultimapBuilderWithKeys()
    {
      <K extends K0, V> Map<K, Collection<V>> createMap()
      {
        return new TreeMap(this.val$comparator);
      }
    };
  }
  
  public abstract <K extends K0, V extends V0> Multimap<K, V> build();
  
  public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
  {
    Multimap localMultimap = build();
    localMultimap.putAll(paramMultimap);
    return localMultimap;
  }
  
  private static final class ArrayListSupplier<V>
    implements Supplier<List<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    ArrayListSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public List<V> get()
    {
      return new ArrayList(this.expectedValuesPerKey);
    }
  }
  
  private static final class EnumSetSupplier<V extends Enum<V>>
    implements Supplier<Set<V>>, Serializable
  {
    private final Class<V> clazz;
    
    EnumSetSupplier(Class<V> paramClass)
    {
      this.clazz = ((Class)Preconditions.checkNotNull(paramClass));
    }
    
    public Set<V> get()
    {
      return EnumSet.noneOf(this.clazz);
    }
  }
  
  private static final class HashSetSupplier<V>
    implements Supplier<Set<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    HashSetSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public Set<V> get()
    {
      return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  private static final class LinkedHashSetSupplier<V>
    implements Supplier<Set<V>>, Serializable
  {
    private final int expectedValuesPerKey;
    
    LinkedHashSetSupplier(int paramInt)
    {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
    }
    
    public Set<V> get()
    {
      return Sets.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  private static enum LinkedListSupplier
    implements Supplier<List<Object>>
  {
    INSTANCE;
    
    private LinkedListSupplier() {}
    
    public static <V> Supplier<List<V>> instance()
    {
      return INSTANCE;
    }
    
    public List<Object> get()
    {
      return new LinkedList();
    }
  }
  
  public static abstract class ListMultimapBuilder<K0, V0>
    extends MultimapBuilder<K0, V0>
  {
    ListMultimapBuilder()
    {
      super();
    }
    
    public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();
    
    public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (ListMultimap)super.build(paramMultimap);
    }
  }
  
  public static abstract class MultimapBuilderWithKeys<K0>
  {
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues()
    {
      return arrayListValues(2);
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues(final int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      new MultimapBuilder.ListMultimapBuilder()
      {
        public <K extends K0, V> ListMultimap<K, V> build()
        {
          return Multimaps.newListMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.ArrayListSupplier(paramInt));
        }
      };
    }
    
    abstract <K extends K0, V> Map<K, Collection<V>> createMap();
    
    public <V0 extends Enum<V0>> MultimapBuilder.SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> paramClass)
    {
      Preconditions.checkNotNull(paramClass, "valueClass");
      new MultimapBuilder.SetMultimapBuilder()
      {
        public <K extends K0, V extends V0> SetMultimap<K, V> build()
        {
          MultimapBuilder.EnumSetSupplier localEnumSetSupplier = new MultimapBuilder.EnumSetSupplier(paramClass);
          return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), localEnumSetSupplier);
        }
      };
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues()
    {
      return hashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues(final int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      new MultimapBuilder.SetMultimapBuilder()
      {
        public <K extends K0, V> SetMultimap<K, V> build()
        {
          return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.HashSetSupplier(paramInt));
        }
      };
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues()
    {
      return linkedHashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues(final int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedValuesPerKey");
      new MultimapBuilder.SetMultimapBuilder()
      {
        public <K extends K0, V> SetMultimap<K, V> build()
        {
          return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.LinkedHashSetSupplier(paramInt));
        }
      };
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> linkedListValues()
    {
      new MultimapBuilder.ListMultimapBuilder()
      {
        public <K extends K0, V> ListMultimap<K, V> build()
        {
          return Multimaps.newListMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), MultimapBuilder.LinkedListSupplier.instance());
        }
      };
    }
    
    public MultimapBuilder.SortedSetMultimapBuilder<K0, Comparable> treeSetValues()
    {
      return treeSetValues(Ordering.natural());
    }
    
    public <V0> MultimapBuilder.SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> paramComparator)
    {
      Preconditions.checkNotNull(paramComparator, "comparator");
      new MultimapBuilder.SortedSetMultimapBuilder()
      {
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build()
        {
          return Multimaps.newSortedSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.TreeSetSupplier(paramComparator));
        }
      };
    }
  }
  
  public static abstract class SetMultimapBuilder<K0, V0>
    extends MultimapBuilder<K0, V0>
  {
    SetMultimapBuilder()
    {
      super();
    }
    
    public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (SetMultimap)super.build(paramMultimap);
    }
  }
  
  public static abstract class SortedSetMultimapBuilder<K0, V0>
    extends MultimapBuilder.SetMultimapBuilder<K0, V0>
  {
    public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap)
    {
      return (SortedSetMultimap)super.build(paramMultimap);
    }
  }
  
  private static final class TreeSetSupplier<V>
    implements Supplier<SortedSet<V>>, Serializable
  {
    private final Comparator<? super V> comparator;
    
    TreeSetSupplier(Comparator<? super V> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public SortedSet<V> get()
    {
      return new TreeSet(this.comparator);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/MultimapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */