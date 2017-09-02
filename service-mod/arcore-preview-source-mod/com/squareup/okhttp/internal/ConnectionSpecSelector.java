package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    int i = this.nextModeIndex;
    while (i < this.connectionSpecs.size())
    {
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    Object localObject2 = null;
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = (ConnectionSpec)this.connectionSpecs.get(i);
        if (((ConnectionSpec)localObject1).isCompatible(paramSSLSocket)) {
          this.nextModeIndex = (i + 1);
        }
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
      }
      i += 1;
    }
    this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
    Internal.instance.apply((ConnectionSpec)localObject1, paramSSLSocket, this.isFallback);
    return (ConnectionSpec)localObject1;
  }
  
  public boolean connectionFailed(IOException paramIOException)
  {
    boolean bool = true;
    this.isFallback = true;
    if ((paramIOException instanceof ProtocolException)) {}
    while (((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException))) {
      return false;
    }
    if ((((paramIOException instanceof SSLHandshakeException)) || ((paramIOException instanceof SSLProtocolException))) && (this.isFallbackPossible)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/ConnectionSpecSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */