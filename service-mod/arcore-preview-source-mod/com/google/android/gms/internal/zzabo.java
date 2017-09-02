package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class zzabo
  extends SSLSocketFactory
{
  private static final TrustManager[] zzaSQ = { new X509TrustManager()
  {
    public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  } };
  final Context mContext;
  SSLSocketFactory zzaSR = null;
  SSLSocketFactory zzaSS = null;
  TrustManager[] zzaST = null;
  KeyManager[] zzaSU = null;
  byte[] zzaSV = null;
  byte[] zzaSW = null;
  PrivateKey zzaSX = null;
  final int zzaSY;
  final boolean zzaSZ;
  final boolean zzaTa;
  final String zzaTb;
  
  private zzabo(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzaSY = paramInt;
    this.zzaSZ = paramBoolean1;
    this.zzaTa = paramBoolean2;
    this.zzaTb = paramString;
  }
  
  /* Error */
  private SSLSocketFactory zzAi()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/google/android/gms/internal/zzabo:zzaTa	Z
    //   6: ifne +49 -> 55
    //   9: aload_0
    //   10: getfield 42	com/google/android/gms/internal/zzabo:zzaSR	Ljavax/net/ssl/SSLSocketFactory;
    //   13: ifnonnull +33 -> 46
    //   16: ldc 74
    //   18: ldc 76
    //   20: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 88	com/google/android/gms/internal/zzabp:zzAj	()Lcom/google/android/gms/internal/zzabp;
    //   28: aload_0
    //   29: getfield 62	com/google/android/gms/internal/zzabo:mContext	Landroid/content/Context;
    //   32: aconst_null
    //   33: getstatic 37	com/google/android/gms/internal/zzabo:zzaSQ	[Ljavax/net/ssl/TrustManager;
    //   36: aload_0
    //   37: getfield 66	com/google/android/gms/internal/zzabo:zzaSZ	Z
    //   40: invokevirtual 92	com/google/android/gms/internal/zzabp:zza	(Landroid/content/Context;[Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Z)Ljavax/net/ssl/SSLSocketFactory;
    //   43: putfield 42	com/google/android/gms/internal/zzabo:zzaSR	Ljavax/net/ssl/SSLSocketFactory;
    //   46: aload_0
    //   47: getfield 42	com/google/android/gms/internal/zzabo:zzaSR	Ljavax/net/ssl/SSLSocketFactory;
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload_0
    //   56: getfield 70	com/google/android/gms/internal/zzabo:zzaTb	Ljava/lang/String;
    //   59: ifnull +38 -> 97
    //   62: aload_0
    //   63: getfield 44	com/google/android/gms/internal/zzabo:zzaSS	Ljavax/net/ssl/SSLSocketFactory;
    //   66: ifnonnull +23 -> 89
    //   69: aload_0
    //   70: invokestatic 88	com/google/android/gms/internal/zzabp:zzAj	()Lcom/google/android/gms/internal/zzabp;
    //   73: aload_0
    //   74: getfield 62	com/google/android/gms/internal/zzabo:mContext	Landroid/content/Context;
    //   77: aconst_null
    //   78: aconst_null
    //   79: aload_0
    //   80: getfield 70	com/google/android/gms/internal/zzabo:zzaTb	Ljava/lang/String;
    //   83: invokevirtual 95	com/google/android/gms/internal/zzabp:zza	(Landroid/content/Context;[Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;
    //   86: putfield 44	com/google/android/gms/internal/zzabo:zzaSS	Ljavax/net/ssl/SSLSocketFactory;
    //   89: aload_0
    //   90: getfield 44	com/google/android/gms/internal/zzabo:zzaSS	Ljavax/net/ssl/SSLSocketFactory;
    //   93: astore_1
    //   94: goto -43 -> 51
    //   97: aload_0
    //   98: getfield 44	com/google/android/gms/internal/zzabo:zzaSS	Ljavax/net/ssl/SSLSocketFactory;
    //   101: ifnonnull -12 -> 89
    //   104: aload_0
    //   105: invokestatic 88	com/google/android/gms/internal/zzabp:zzAj	()Lcom/google/android/gms/internal/zzabp;
    //   108: aload_0
    //   109: getfield 62	com/google/android/gms/internal/zzabo:mContext	Landroid/content/Context;
    //   112: aconst_null
    //   113: aconst_null
    //   114: aload_0
    //   115: getfield 66	com/google/android/gms/internal/zzabo:zzaSZ	Z
    //   118: invokevirtual 92	com/google/android/gms/internal/zzabp:zza	(Landroid/content/Context;[Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Z)Ljavax/net/ssl/SSLSocketFactory;
    //   121: putfield 44	com/google/android/gms/internal/zzabo:zzaSS	Ljavax/net/ssl/SSLSocketFactory;
    //   124: goto -35 -> 89
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	zzabo
    //   50	44	1	localSSLSocketFactory	SSLSocketFactory
    //   127	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	127	finally
    //   46	51	127	finally
    //   55	89	127	finally
    //   89	94	127	finally
    //   97	124	127	finally
  }
  
  public static SSLSocketFactory zza(int paramInt, Context paramContext)
  {
    return new zzabo(paramContext, paramInt, true, true, null);
  }
  
  public static void zza(Socket paramSocket, String paramString)
    throws IOException
  {
    if (!(paramSocket instanceof SSLSocket)) {
      throw new IllegalArgumentException("Attempt to verify non-SSL socket");
    }
    paramSocket = (SSLSocket)paramSocket;
    paramSocket.startHandshake();
    paramSocket = paramSocket.getSession();
    if (paramSocket == null) {
      throw new SSLException("Cannot verify SSL socket without session");
    }
    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSocket))
    {
      paramSocket = String.valueOf(paramString);
      if (paramSocket.length() != 0) {}
      for (paramSocket = "Cannot verify hostname: ".concat(paramSocket);; paramSocket = new String("Cannot verify hostname: ")) {
        throw new SSLPeerUnverifiedException(paramSocket);
      }
    }
  }
  
  public Socket createSocket()
    throws IOException
  {
    Socket localSocket = zzAi().createSocket();
    zza(localSocket, null);
    zzb(localSocket, null);
    zza(localSocket, this.zzaSY);
    zza(localSocket, null);
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    Socket localSocket = zzAi().createSocket(paramString, paramInt);
    zza(localSocket, null);
    zzb(localSocket, null);
    zza(localSocket, this.zzaSY);
    zza(localSocket, null);
    if (this.zzaTa) {
      zza(localSocket, paramString);
    }
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    paramInetAddress = zzAi().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    zza(paramInetAddress, null);
    zzb(paramInetAddress, null);
    zza(paramInetAddress, this.zzaSY);
    zza(paramInetAddress, null);
    if (this.zzaTa) {
      zza(paramInetAddress, paramString);
    }
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    paramInetAddress = zzAi().createSocket(paramInetAddress, paramInt);
    zza(paramInetAddress, null);
    zzb(paramInetAddress, null);
    zza(paramInetAddress, this.zzaSY);
    zza(paramInetAddress, null);
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    paramInetAddress1 = zzAi().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    zza(paramInetAddress1, null);
    zzb(paramInetAddress1, null);
    zza(paramInetAddress1, this.zzaSY);
    zza(paramInetAddress1, null);
    return paramInetAddress1;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    paramSocket = zzAi().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    zza(paramSocket, null);
    zzb(paramSocket, null);
    zza(paramSocket, this.zzaSY);
    zza(paramSocket, null);
    if (this.zzaTa) {
      zza(paramSocket, paramString);
    }
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return zzAi().getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return zzAi().getSupportedCipherSuites();
  }
  
  void zza(Socket paramSocket, int paramInt)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setHandshakeTimeout", new Class[] { Integer.TYPE }).invoke(paramSocket, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new RuntimeException(String.valueOf(paramSocket).length() + 46 + "Failed to invoke setSocketHandshakeTimeout on " + paramSocket, localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new IllegalArgumentException(String.valueOf(paramSocket).length() + 45 + paramSocket + " does not implement setSocketHandshakeTimeout", localIllegalAccessException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  void zza(Socket paramSocket, PrivateKey paramPrivateKey)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setChannelIdPrivateKey", new Class[] { PrivateKey.class }).invoke(paramSocket, new Object[] { paramPrivateKey });
      return;
    }
    catch (InvocationTargetException paramPrivateKey)
    {
      Throwable localThrowable = paramPrivateKey.getCause();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new RuntimeException(String.valueOf(paramSocket).length() + 43 + "Failed to invoke setChannelIdPrivateKey on " + paramSocket, paramPrivateKey);
    }
    catch (IllegalAccessException paramPrivateKey)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new IllegalArgumentException(String.valueOf(paramSocket).length() + 42 + paramSocket + " does not implement setChannelIdPrivateKey", paramPrivateKey);
    }
    catch (NoSuchMethodException paramPrivateKey)
    {
      for (;;) {}
    }
  }
  
  void zza(Socket paramSocket, byte[] paramArrayOfByte)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setNpnProtocols", new Class[] { byte[].class }).invoke(paramSocket, new Object[] { paramArrayOfByte });
      return;
    }
    catch (InvocationTargetException paramArrayOfByte)
    {
      Throwable localThrowable = paramArrayOfByte.getCause();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new RuntimeException(String.valueOf(paramSocket).length() + 36 + "Failed to invoke setNpnProtocols on " + paramSocket, paramArrayOfByte);
    }
    catch (IllegalAccessException paramArrayOfByte)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new IllegalArgumentException(String.valueOf(paramSocket).length() + 35 + paramSocket + " does not implement setNpnProtocols", paramArrayOfByte);
    }
    catch (NoSuchMethodException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  void zzb(Socket paramSocket, byte[] paramArrayOfByte)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.getClass().getMethod("setAlpnProtocols", new Class[] { byte[].class }).invoke(paramSocket, new Object[] { paramArrayOfByte });
      return;
    }
    catch (InvocationTargetException paramArrayOfByte)
    {
      Throwable localThrowable = paramArrayOfByte.getCause();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new RuntimeException(String.valueOf(paramSocket).length() + 37 + "Failed to invoke setAlpnProtocols on " + paramSocket, paramArrayOfByte);
    }
    catch (IllegalAccessException paramArrayOfByte)
    {
      paramSocket = String.valueOf(paramSocket.getClass());
      throw new IllegalArgumentException(String.valueOf(paramSocket).length() + 36 + paramSocket + " does not implement setAlpnProtocols", paramArrayOfByte);
    }
    catch (NoSuchMethodException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */