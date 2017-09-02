package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.net.Socket;
import java.security.Security;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class OkHttpProtocolNegotiator
{
  private static final Platform DEFAULT_PLATFORM = ;
  private static OkHttpProtocolNegotiator NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());
  private final Platform platform;
  
  @VisibleForTesting
  OkHttpProtocolNegotiator(Platform paramPlatform)
  {
    this.platform = ((Platform)Preconditions.checkNotNull(paramPlatform, "platform"));
  }
  
  @VisibleForTesting
  static OkHttpProtocolNegotiator createNegotiator(ClassLoader paramClassLoader)
  {
    int i = 1;
    try
    {
      paramClassLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
      if (i != 0) {
        return new AndroidNegotiator(DEFAULT_PLATFORM, AndroidNegotiator.DEFAULT_TLS_EXTENSION_TYPE);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          paramClassLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        catch (ClassNotFoundException paramClassLoader)
        {
          i = 0;
        }
      }
    }
    return new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
  }
  
  public static OkHttpProtocolNegotiator get()
  {
    return NEGOTIATOR;
  }
  
  protected void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    this.platform.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return this.platform.getSelectedProtocol(paramSSLSocket);
  }
  
  public String negotiate(SSLSocket paramSSLSocket, String paramString, @Nullable List<Protocol> paramList)
    throws IOException
  {
    if (paramList != null) {
      configureTlsExtensions(paramSSLSocket, paramString, paramList);
    }
    try
    {
      paramSSLSocket.startHandshake();
      paramString = getSelectedProtocol(paramSSLSocket);
      if (paramString == null) {
        throw new RuntimeException("protocol negotiation failed");
      }
    }
    finally
    {
      this.platform.afterHandshake(paramSSLSocket);
    }
    this.platform.afterHandshake(paramSSLSocket);
    return paramString;
  }
  
  @VisibleForTesting
  static final class AndroidNegotiator
    extends OkHttpProtocolNegotiator
  {
    private static final TlsExtensionType DEFAULT_TLS_EXTENSION_TYPE = pickTlsExtensionType(AndroidNegotiator.class.getClassLoader());
    private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL;
    private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL;
    private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS;
    private static final OptionalMethod<Socket> SET_HOSTNAME;
    private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS;
    private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS = new OptionalMethod(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
    private final TlsExtensionType tlsExtensionType;
    
    static
    {
      SET_HOSTNAME = new OptionalMethod(null, "setHostname", new Class[] { String.class });
      GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      SET_ALPN_PROTOCOLS = new OptionalMethod(null, "setAlpnProtocols", new Class[] { byte[].class });
      GET_NPN_SELECTED_PROTOCOL = new OptionalMethod(byte[].class, "getNpnSelectedProtocol", new Class[0]);
      SET_NPN_PROTOCOLS = new OptionalMethod(null, "setNpnProtocols", new Class[] { byte[].class });
    }
    
    AndroidNegotiator(Platform paramPlatform, TlsExtensionType paramTlsExtensionType)
    {
      super();
      this.tlsExtensionType = ((TlsExtensionType)Preconditions.checkNotNull(paramTlsExtensionType, "Unable to pick a TLS extension"));
    }
    
    @VisibleForTesting
    static TlsExtensionType pickTlsExtensionType(ClassLoader paramClassLoader)
    {
      if (Security.getProvider("GmsCore_OpenSSL") != null) {
        return TlsExtensionType.ALPN_AND_NPN;
      }
      try
      {
        paramClassLoader.loadClass("android.net.Network");
        TlsExtensionType localTlsExtensionType = TlsExtensionType.ALPN_AND_NPN;
        return localTlsExtensionType;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          paramClassLoader.loadClass("android.app.ActivityOptions");
          paramClassLoader = TlsExtensionType.NPN;
          return paramClassLoader;
        }
        catch (ClassNotFoundException paramClassLoader) {}
      }
      return null;
    }
    
    protected void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      if (paramString != null)
      {
        SET_USE_SESSION_TICKETS.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        SET_HOSTNAME.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
      paramString = new Object[1];
      paramString[0] = Platform.concatLengthPrefixed(paramList);
      if (this.tlsExtensionType == TlsExtensionType.ALPN_AND_NPN) {
        SET_ALPN_PROTOCOLS.invokeWithoutCheckedException(paramSSLSocket, paramString);
      }
      if (this.tlsExtensionType != null)
      {
        SET_NPN_PROTOCOLS.invokeWithoutCheckedException(paramSSLSocket, paramString);
        return;
      }
      throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.tlsExtensionType == TlsExtensionType.ALPN_AND_NPN) {
        try
        {
          Object localObject = (byte[])GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
          if (localObject != null)
          {
            localObject = new String((byte[])localObject, Util.UTF_8);
            return (String)localObject;
          }
        }
        catch (Exception localException) {}
      }
      if (this.tlsExtensionType != null) {
        try
        {
          paramSSLSocket = (byte[])GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
          if (paramSSLSocket != null)
          {
            paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);
            return paramSSLSocket;
          }
        }
        catch (Exception paramSSLSocket) {}
      }
      return null;
    }
    
    public String negotiate(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
      throws IOException
    {
      String str2 = getSelectedProtocol(paramSSLSocket);
      String str1 = str2;
      if (str2 == null) {
        str1 = super.negotiate(paramSSLSocket, paramString, paramList);
      }
      return str1;
    }
    
    static enum TlsExtensionType
    {
      ALPN_AND_NPN,  NPN;
      
      private TlsExtensionType() {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */