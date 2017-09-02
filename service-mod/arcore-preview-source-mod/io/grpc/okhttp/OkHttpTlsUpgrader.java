package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.OkHostnameVerifier;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class OkHttpTlsUpgrader
{
  @VisibleForTesting
  static final List<Protocol> TLS_PROTOCOLS = Collections.unmodifiableList(Arrays.asList(new Protocol[] { Protocol.GRPC_EXP, Protocol.HTTP_2 }));
  
  public static SSLSocket upgrade(SSLSocketFactory paramSSLSocketFactory, Socket paramSocket, String paramString, int paramInt, ConnectionSpec paramConnectionSpec)
    throws IOException
  {
    Preconditions.checkNotNull(paramSSLSocketFactory, "sslSocketFactory");
    Preconditions.checkNotNull(paramSocket, "socket");
    Preconditions.checkNotNull(paramConnectionSpec, "spec");
    paramSocket = (SSLSocket)paramSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, true);
    paramConnectionSpec.apply(paramSocket, false);
    OkHttpProtocolNegotiator localOkHttpProtocolNegotiator = OkHttpProtocolNegotiator.get();
    if (paramConnectionSpec.supportsTlsExtensions()) {}
    for (paramSSLSocketFactory = TLS_PROTOCOLS;; paramSSLSocketFactory = null)
    {
      paramSSLSocketFactory = localOkHttpProtocolNegotiator.negotiate(paramSocket, paramString, paramSSLSocketFactory);
      Preconditions.checkState(TLS_PROTOCOLS.contains(Protocol.get(paramSSLSocketFactory)), "Only " + TLS_PROTOCOLS + " are supported, but negotiated protocol is %s", new Object[] { paramSSLSocketFactory });
      if (OkHostnameVerifier.INSTANCE.verify(paramString, paramSocket.getSession())) {
        break;
      }
      throw new SSLPeerUnverifiedException("Cannot verify hostname: " + paramString);
    }
    return paramSocket;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpTlsUpgrader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */