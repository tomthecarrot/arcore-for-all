package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public abstract class NameResolverProvider
  extends NameResolver.Factory
{
  public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;
  private static final NameResolver.Factory factory = new NameResolverFactory(providers);
  private static final List<NameResolverProvider> providers = load(getCorrectClassLoader());
  
  public static NameResolver.Factory asFactory()
  {
    return factory;
  }
  
  @VisibleForTesting
  static NameResolver.Factory asFactory(List<NameResolverProvider> paramList)
  {
    return new NameResolverFactory(paramList);
  }
  
  @VisibleForTesting
  static NameResolverProvider create(Class<?> paramClass)
  {
    try
    {
      NameResolverProvider localNameResolverProvider = (NameResolverProvider)paramClass.asSubclass(NameResolverProvider.class).getConstructor(new Class[0]).newInstance(new Object[0]);
      return localNameResolverProvider;
    }
    catch (Throwable localThrowable)
    {
      throw new ServiceConfigurationError("Provider " + paramClass.getName() + " could not be instantiated: " + localThrowable, localThrowable);
    }
  }
  
  @VisibleForTesting
  public static Iterable<NameResolverProvider> getCandidatesViaHardCoded(ClassLoader paramClassLoader)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(create(Class.forName("io.grpc.internal.DnsNameResolverProvider", true, paramClassLoader)));
      return localArrayList;
    }
    catch (ClassNotFoundException paramClassLoader) {}
    return localArrayList;
  }
  
  @VisibleForTesting
  public static Iterable<NameResolverProvider> getCandidatesViaServiceLoader(ClassLoader paramClassLoader)
  {
    return ServiceLoader.load(NameResolverProvider.class, paramClassLoader);
  }
  
  private static ClassLoader getCorrectClassLoader()
  {
    if (isAndroid()) {
      return NameResolverProvider.class.getClassLoader();
    }
    return Thread.currentThread().getContextClassLoader();
  }
  
  private static boolean isAndroid()
  {
    try
    {
      Class.forName("android.app.Application", false, null);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  @VisibleForTesting
  static List<NameResolverProvider> load(ClassLoader paramClassLoader)
  {
    if (isAndroid()) {}
    ArrayList localArrayList;
    for (paramClassLoader = getCandidatesViaHardCoded(paramClassLoader);; paramClassLoader = getCandidatesViaServiceLoader(paramClassLoader))
    {
      localArrayList = new ArrayList();
      paramClassLoader = paramClassLoader.iterator();
      while (paramClassLoader.hasNext())
      {
        NameResolverProvider localNameResolverProvider = (NameResolverProvider)paramClassLoader.next();
        if (localNameResolverProvider.isAvailable()) {
          localArrayList.add(localNameResolverProvider);
        }
      }
    }
    Collections.sort(localArrayList, Collections.reverseOrder(new Comparator()
    {
      public int compare(NameResolverProvider paramAnonymousNameResolverProvider1, NameResolverProvider paramAnonymousNameResolverProvider2)
      {
        return paramAnonymousNameResolverProvider1.priority() - paramAnonymousNameResolverProvider2.priority();
      }
    }));
    return Collections.unmodifiableList(localArrayList);
  }
  
  public static List<NameResolverProvider> providers()
  {
    return providers;
  }
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
  
  private static class NameResolverFactory
    extends NameResolver.Factory
  {
    private final List<NameResolverProvider> providers;
    
    public NameResolverFactory(List<NameResolverProvider> paramList)
    {
      this.providers = paramList;
    }
    
    private void checkForProviders()
    {
      if (!this.providers.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
        return;
      }
    }
    
    public String getDefaultScheme()
    {
      checkForProviders();
      return ((NameResolverProvider)this.providers.get(0)).getDefaultScheme();
    }
    
    public NameResolver newNameResolver(URI paramURI, Attributes paramAttributes)
    {
      checkForProviders();
      Iterator localIterator = this.providers.iterator();
      while (localIterator.hasNext())
      {
        NameResolver localNameResolver = ((NameResolverProvider)localIterator.next()).newNameResolver(paramURI, paramAttributes);
        if (localNameResolver != null) {
          return localNameResolver;
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/NameResolverProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */