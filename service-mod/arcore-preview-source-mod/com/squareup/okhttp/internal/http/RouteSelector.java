package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector
{
  private final Address address;
  private final OkHttpClient client;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private InetSocketAddress lastInetSocketAddress;
  private Proxy lastProxy;
  private final Network network;
  private int nextInetSocketAddressIndex;
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  private final HttpUrl url;
  
  private RouteSelector(Address paramAddress, HttpUrl paramHttpUrl, OkHttpClient paramOkHttpClient)
  {
    this.address = paramAddress;
    this.url = paramHttpUrl;
    this.client = paramOkHttpClient;
    this.routeDatabase = Internal.instance.routeDatabase(paramOkHttpClient);
    this.network = Internal.instance.network(paramOkHttpClient);
    resetNextProxy(paramHttpUrl, paramAddress.getProxy());
  }
  
  public static RouteSelector get(Address paramAddress, Request paramRequest, OkHttpClient paramOkHttpClient)
    throws IOException
  {
    return new RouteSelector(paramAddress, paramRequest.httpUrl(), paramOkHttpClient);
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextInetSocketAddress()
  {
    return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
  }
  
  private boolean hasNextPostponed()
  {
    return !this.postponedRoutes.isEmpty();
  }
  
  private boolean hasNextProxy()
  {
    return this.nextProxyIndex < this.proxies.size();
  }
  
  private InetSocketAddress nextInetSocketAddress()
    throws IOException
  {
    if (!hasNextInetSocketAddress()) {
      throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }
    List localList = this.inetSocketAddresses;
    int i = this.nextInetSocketAddressIndex;
    this.nextInetSocketAddressIndex = (i + 1);
    return (InetSocketAddress)localList.get(i);
  }
  
  private Route nextPostponed()
  {
    return (Route)this.postponedRoutes.remove(0);
  }
  
  private Proxy nextProxy()
    throws IOException
  {
    if (!hasNextProxy()) {
      throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }
    Object localObject = this.proxies;
    int i = this.nextProxyIndex;
    this.nextProxyIndex = (i + 1);
    localObject = (Proxy)((List)localObject).get(i);
    resetNextInetSocketAddress((Proxy)localObject);
    return (Proxy)localObject;
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws IOException
  {
    this.inetSocketAddresses = new ArrayList();
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      paramProxy = this.address.getUriHost();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i = this.address.getUriPort(); (i < 1) || (i > 65535); i = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + paramProxy + ":" + i + "; port is out of range");
      paramProxy = paramProxy.address();
      if (!(paramProxy instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + paramProxy.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)paramProxy;
      paramProxy = getHostString(localInetSocketAddress);
    }
    paramProxy = this.network.resolveInetAddresses(paramProxy);
    int k = paramProxy.length;
    int j = 0;
    while (j < k)
    {
      localInetSocketAddress = paramProxy[j];
      this.inetSocketAddresses.add(new InetSocketAddress(localInetSocketAddress, i));
      j += 1;
    }
    this.nextInetSocketAddressIndex = 0;
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.proxies = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.nextProxyIndex = 0;
      return;
      this.proxies = new ArrayList();
      paramHttpUrl = this.client.getProxySelector().select(paramHttpUrl.uri());
      if (paramHttpUrl != null) {
        this.proxies.addAll(paramHttpUrl);
      }
      this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.proxies.add(Proxy.NO_PROXY);
    }
  }
  
  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.getProxy().type() != Proxy.Type.DIRECT) && (this.address.getProxySelector() != null)) {
      this.address.getProxySelector().connectFailed(this.url.uri(), paramRoute.getProxy().address(), paramIOException);
    }
    this.routeDatabase.failed(paramRoute);
  }
  
  public boolean hasNext()
  {
    return (hasNextInetSocketAddress()) || (hasNextProxy()) || (hasNextPostponed());
  }
  
  public Route next()
    throws IOException
  {
    Object localObject;
    if (!hasNextInetSocketAddress()) {
      if (!hasNextProxy())
      {
        if (!hasNextPostponed()) {
          throw new NoSuchElementException();
        }
        localObject = nextPostponed();
      }
    }
    Route localRoute;
    do
    {
      return (Route)localObject;
      this.lastProxy = nextProxy();
      this.lastInetSocketAddress = nextInetSocketAddress();
      localRoute = new Route(this.address, this.lastProxy, this.lastInetSocketAddress);
      localObject = localRoute;
    } while (!this.routeDatabase.shouldPostpone(localRoute));
    this.postponedRoutes.add(localRoute);
    return next();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/RouteSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */