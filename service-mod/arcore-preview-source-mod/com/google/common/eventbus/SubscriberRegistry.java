package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken.TypeSet;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

final class SubscriberRegistry
{
  private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader()
  {
    public ImmutableSet<Class<?>> load(Class<?> paramAnonymousClass)
    {
      return ImmutableSet.copyOf(TypeToken.of(paramAnonymousClass).getTypes().rawTypes());
    }
  });
  private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader()
  {
    public ImmutableList<Method> load(Class<?> paramAnonymousClass)
      throws Exception
    {
      return SubscriberRegistry.getAnnotatedMethodsNotCached(paramAnonymousClass);
    }
  });
  @Weak
  private final EventBus bus;
  private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = Maps.newConcurrentMap();
  
  SubscriberRegistry(EventBus paramEventBus)
  {
    this.bus = ((EventBus)Preconditions.checkNotNull(paramEventBus));
  }
  
  private Multimap<Class<?>, Subscriber> findAllSubscribers(Object paramObject)
  {
    HashMultimap localHashMultimap = HashMultimap.create();
    Iterator localIterator = getAnnotatedMethods(paramObject.getClass()).iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      localHashMultimap.put(localMethod.getParameterTypes()[0], Subscriber.create(this.bus, paramObject, localMethod));
    }
    return localHashMultimap;
  }
  
  @VisibleForTesting
  static ImmutableSet<Class<?>> flattenHierarchy(Class<?> paramClass)
  {
    try
    {
      paramClass = (ImmutableSet)flattenHierarchyCache.getUnchecked(paramClass);
      return paramClass;
    }
    catch (UncheckedExecutionException paramClass)
    {
      throw Throwables.propagate(paramClass.getCause());
    }
  }
  
  private static ImmutableList<Method> getAnnotatedMethods(Class<?> paramClass)
  {
    return (ImmutableList)subscriberMethodsCache.getUnchecked(paramClass);
  }
  
  private static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> paramClass)
  {
    Object localObject1 = TypeToken.of(paramClass).getTypes().rawTypes();
    paramClass = Maps.newHashMap();
    localObject1 = ((Set)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Method[] arrayOfMethod = ((Class)((Iterator)localObject1).next()).getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      label56:
      Method localMethod;
      Object localObject2;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if ((localMethod.isAnnotationPresent(Subscribe.class)) && (!localMethod.isSynthetic()))
        {
          localObject2 = localMethod.getParameterTypes();
          if (localObject2.length != 1) {
            break label165;
          }
        }
      }
      label165:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", new Object[] { localMethod, Integer.valueOf(localObject2.length) });
        localObject2 = new MethodIdentifier(localMethod);
        if (!paramClass.containsKey(localObject2)) {
          paramClass.put(localObject2, localMethod);
        }
        i += 1;
        break label56;
        break;
      }
    }
    return ImmutableList.copyOf(paramClass.values());
  }
  
  Iterator<Subscriber> getSubscribers(Object paramObject)
  {
    Object localObject1 = flattenHierarchy(paramObject.getClass());
    paramObject = Lists.newArrayListWithCapacity(((ImmutableSet)localObject1).size());
    localObject1 = ((ImmutableSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Class)((Iterator)localObject1).next();
      localObject2 = (CopyOnWriteArraySet)this.subscribers.get(localObject2);
      if (localObject2 != null) {
        ((List)paramObject).add(((CopyOnWriteArraySet)localObject2).iterator());
      }
    }
    return Iterators.concat(((List)paramObject).iterator());
  }
  
  @VisibleForTesting
  Set<Subscriber> getSubscribersForTesting(Class<?> paramClass)
  {
    return (Set)MoreObjects.firstNonNull(this.subscribers.get(paramClass), ImmutableSet.of());
  }
  
  void register(Object paramObject)
  {
    Iterator localIterator = findAllSubscribers(paramObject).asMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramObject = (Map.Entry)localIterator.next();
      Class localClass = (Class)((Map.Entry)paramObject).getKey();
      Collection localCollection = (Collection)((Map.Entry)paramObject).getValue();
      CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.subscribers.get(localClass);
      paramObject = localCopyOnWriteArraySet;
      if (localCopyOnWriteArraySet == null)
      {
        paramObject = new CopyOnWriteArraySet();
        paramObject = (CopyOnWriteArraySet)MoreObjects.firstNonNull(this.subscribers.putIfAbsent(localClass, paramObject), paramObject);
      }
      ((CopyOnWriteArraySet)paramObject).addAll(localCollection);
    }
  }
  
  void unregister(Object paramObject)
  {
    Iterator localIterator = findAllSubscribers(paramObject).asMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (Class)((Map.Entry)localObject2).getKey();
      localObject2 = (Collection)((Map.Entry)localObject2).getValue();
      localObject1 = (CopyOnWriteArraySet)this.subscribers.get(localObject1);
      if ((localObject1 == null) || (!((CopyOnWriteArraySet)localObject1).removeAll((Collection)localObject2))) {
        throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + paramObject + " registered?");
      }
    }
  }
  
  private static final class MethodIdentifier
  {
    private final String name;
    private final List<Class<?>> parameterTypes;
    
    MethodIdentifier(Method paramMethod)
    {
      this.name = paramMethod.getName();
      this.parameterTypes = Arrays.asList(paramMethod.getParameterTypes());
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof MethodIdentifier))
      {
        paramObject = (MethodIdentifier)paramObject;
        bool1 = bool2;
        if (this.name.equals(((MethodIdentifier)paramObject).name))
        {
          bool1 = bool2;
          if (this.parameterTypes.equals(((MethodIdentifier)paramObject).parameterTypes)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.name, this.parameterTypes });
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/SubscriberRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */