package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public abstract class ManagedChannelProvider
{
  private static final ManagedChannelProvider provider = load(getCorrectClassLoader());
  
  @VisibleForTesting
  static ManagedChannelProvider create(Class<?> paramClass)
  {
    try
    {
      ManagedChannelProvider localManagedChannelProvider = (ManagedChannelProvider)paramClass.asSubclass(ManagedChannelProvider.class).getConstructor(new Class[0]).newInstance(new Object[0]);
      return localManagedChannelProvider;
    }
    catch (Throwable localThrowable)
    {
      throw new ServiceConfigurationError("Provider " + paramClass.getName() + " could not be instantiated: " + localThrowable, localThrowable);
    }
  }
  
  @VisibleForTesting
  public static Iterable<ManagedChannelProvider> getCandidatesViaHardCoded(ClassLoader paramClassLoader)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(create(Class.forName("io.grpc.okhttp.OkHttpChannelProvider", true, paramClassLoader)));
      try
      {
        localArrayList.add(create(Class.forName("io.grpc.netty.NettyChannelProvider", true, paramClassLoader)));
        return localArrayList;
      }
      catch (ClassNotFoundException paramClassLoader)
      {
        return localArrayList;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  @VisibleForTesting
  public static Iterable<ManagedChannelProvider> getCandidatesViaServiceLoader(ClassLoader paramClassLoader)
  {
    return ServiceLoader.load(ManagedChannelProvider.class, paramClassLoader);
  }
  
  private static ClassLoader getCorrectClassLoader()
  {
    if (isAndroid()) {
      return ManagedChannelProvider.class.getClassLoader();
    }
    return Thread.currentThread().getContextClassLoader();
  }
  
  protected static boolean isAndroid()
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
  static ManagedChannelProvider load(ClassLoader paramClassLoader)
  {
    if (isAndroid()) {}
    ArrayList localArrayList;
    for (paramClassLoader = getCandidatesViaHardCoded(paramClassLoader);; paramClassLoader = getCandidatesViaServiceLoader(paramClassLoader))
    {
      localArrayList = new ArrayList();
      paramClassLoader = paramClassLoader.iterator();
      while (paramClassLoader.hasNext())
      {
        ManagedChannelProvider localManagedChannelProvider = (ManagedChannelProvider)paramClassLoader.next();
        if (localManagedChannelProvider.isAvailable()) {
          localArrayList.add(localManagedChannelProvider);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    (ManagedChannelProvider)Collections.max(localArrayList, new Comparator()
    {
      public int compare(ManagedChannelProvider paramAnonymousManagedChannelProvider1, ManagedChannelProvider paramAnonymousManagedChannelProvider2)
      {
        return paramAnonymousManagedChannelProvider1.priority() - paramAnonymousManagedChannelProvider2.priority();
      }
    });
  }
  
  public static ManagedChannelProvider provider()
  {
    if (provider == null) {
      throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp or grpc-netty artifact");
    }
    return provider;
  }
  
  protected abstract ManagedChannelBuilder<?> builderForAddress(String paramString, int paramInt);
  
  protected abstract ManagedChannelBuilder<?> builderForTarget(String paramString);
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
  
  public static final class ProviderNotFoundException
    extends RuntimeException
  {
    private static final long serialVersionUID = 1L;
    
    public ProviderNotFoundException(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ManagedChannelProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */