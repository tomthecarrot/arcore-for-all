package io.grpc;

import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

public final class Grpc
{
  public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.of("remote-addr");
  public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.of("ssl-session");
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Grpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */