package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final Authenticator authenticator;
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final String uriHost;
  final int uriPort;
  
  public Address(String paramString, int paramInt, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    if (paramString == null) {
      throw new NullPointerException("uriHost == null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    }
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.proxy = paramProxy;
    this.uriHost = paramString;
    this.uriPort = paramInt;
    this.socketFactory = paramSocketFactory;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
    this.authenticator = paramAuthenticator;
    this.protocols = Util.immutableList(paramList);
    this.connectionSpecs = Util.immutableList(paramList1);
    this.proxySelector = paramProxySelector;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (Util.equal(this.proxy, ((Address)paramObject).proxy))
      {
        bool1 = bool2;
        if (this.uriHost.equals(((Address)paramObject).uriHost))
        {
          bool1 = bool2;
          if (this.uriPort == ((Address)paramObject).uriPort)
          {
            bool1 = bool2;
            if (Util.equal(this.sslSocketFactory, ((Address)paramObject).sslSocketFactory))
            {
              bool1 = bool2;
              if (Util.equal(this.hostnameVerifier, ((Address)paramObject).hostnameVerifier))
              {
                bool1 = bool2;
                if (Util.equal(this.certificatePinner, ((Address)paramObject).certificatePinner))
                {
                  bool1 = bool2;
                  if (Util.equal(this.authenticator, ((Address)paramObject).authenticator))
                  {
                    bool1 = bool2;
                    if (Util.equal(this.protocols, ((Address)paramObject).protocols))
                    {
                      bool1 = bool2;
                      if (Util.equal(this.connectionSpecs, ((Address)paramObject).connectionSpecs))
                      {
                        bool1 = bool2;
                        if (Util.equal(this.proxySelector, ((Address)paramObject).proxySelector)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Authenticator getAuthenticator()
  {
    return this.authenticator;
  }
  
  public CertificatePinner getCertificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> getConnectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> getProtocols()
  {
    return this.protocols;
  }
  
  public Proxy getProxy()
  {
    return this.proxy;
  }
  
  public ProxySelector getProxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String getUriHost()
  {
    return this.uriHost;
  }
  
  public int getUriPort()
  {
    return this.uriPort;
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int n;
    int i1;
    int j;
    if (this.proxy != null)
    {
      i = this.proxy.hashCode();
      n = this.uriHost.hashCode();
      i1 = this.uriPort;
      if (this.sslSocketFactory == null) {
        break label166;
      }
      j = this.sslSocketFactory.hashCode();
      label48:
      if (this.hostnameVerifier == null) {
        break label171;
      }
    }
    label166:
    label171:
    for (int k = this.hostnameVerifier.hashCode();; k = 0)
    {
      if (this.certificatePinner != null) {
        m = this.certificatePinner.hashCode();
      }
      return (((((((((i + 527) * 31 + n) * 31 + i1) * 31 + j) * 31 + k) * 31 + m) * 31 + this.authenticator.hashCode()) * 31 + this.protocols.hashCode()) * 31 + this.connectionSpecs.hashCode()) * 31 + this.proxySelector.hashCode();
      i = 0;
      break;
      j = 0;
      break label48;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */