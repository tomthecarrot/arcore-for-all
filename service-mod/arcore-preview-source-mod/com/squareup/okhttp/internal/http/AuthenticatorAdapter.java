package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class AuthenticatorAdapter
  implements com.squareup.okhttp.Authenticator
{
  public static final com.squareup.okhttp.Authenticator INSTANCE = new AuthenticatorAdapter();
  
  private InetAddress getConnectToInetAddress(Proxy paramProxy, HttpUrl paramHttpUrl)
    throws IOException
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT)) {
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    }
    return InetAddress.getByName(paramHttpUrl.host());
  }
  
  public Request authenticate(Proxy paramProxy, Response paramResponse)
    throws IOException
  {
    List localList = paramResponse.challenges();
    paramResponse = paramResponse.request();
    HttpUrl localHttpUrl = paramResponse.httpUrl();
    int i = 0;
    int j = localList.size();
    if (i < j)
    {
      Object localObject = (Challenge)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((Challenge)localObject).getScheme())) {}
      do
      {
        i += 1;
        break;
        localObject = java.net.Authenticator.requestPasswordAuthentication(localHttpUrl.host(), getConnectToInetAddress(paramProxy, localHttpUrl), localHttpUrl.port(), localHttpUrl.scheme(), ((Challenge)localObject).getRealm(), ((Challenge)localObject).getScheme(), localHttpUrl.url(), Authenticator.RequestorType.SERVER);
      } while (localObject == null);
      paramProxy = Credentials.basic(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return paramResponse.newBuilder().header("Authorization", paramProxy).build();
    }
    return null;
  }
  
  public Request authenticateProxy(Proxy paramProxy, Response paramResponse)
    throws IOException
  {
    List localList = paramResponse.challenges();
    paramResponse = paramResponse.request();
    HttpUrl localHttpUrl = paramResponse.httpUrl();
    int i = 0;
    int j = localList.size();
    if (i < j)
    {
      Object localObject = (Challenge)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((Challenge)localObject).getScheme())) {}
      do
      {
        i += 1;
        break;
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramProxy.address();
        localObject = java.net.Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), getConnectToInetAddress(paramProxy, localHttpUrl), localInetSocketAddress.getPort(), localHttpUrl.scheme(), ((Challenge)localObject).getRealm(), ((Challenge)localObject).getScheme(), localHttpUrl.url(), Authenticator.RequestorType.PROXY);
      } while (localObject == null);
      paramProxy = Credentials.basic(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return paramResponse.newBuilder().header("Proxy-Authorization", paramProxy).build();
    }
    return null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/AuthenticatorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */