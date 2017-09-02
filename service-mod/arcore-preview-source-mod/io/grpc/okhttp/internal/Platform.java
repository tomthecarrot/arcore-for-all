package io.grpc.okhttp.internal;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

public class Platform
{
  private static final String[] ANDROID_SECURITY_PROVIDERS = { "com.google.android.gms.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider" };
  private static final Platform PLATFORM = findPlatform();
  public static final Logger logger = Logger.getLogger(Platform.class.getName());
  private final Provider sslProvider;
  
  public Platform(Provider paramProvider)
  {
    this.sslProvider = paramProvider;
  }
  
  public static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  /* Error */
  private static Platform findPlatform()
  {
    // Byte code:
    //   0: getstatic 115	io/grpc/internal/GrpcUtil:IS_RESTRICTED_APPENGINE	Z
    //   3: ifeq +180 -> 183
    //   6: invokestatic 119	io/grpc/okhttp/internal/Platform:getAppEngineProvider	()Ljava/security/Provider;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +179 -> 190
    //   14: new 121	io/grpc/okhttp/internal/OptionalMethod
    //   17: dup
    //   18: aconst_null
    //   19: ldc 123
    //   21: iconst_1
    //   22: anewarray 25	java/lang/Class
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 129	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokespecial 132	io/grpc/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   34: astore 6
    //   36: new 121	io/grpc/okhttp/internal/OptionalMethod
    //   39: dup
    //   40: aconst_null
    //   41: ldc -122
    //   43: iconst_1
    //   44: anewarray 25	java/lang/Class
    //   47: dup
    //   48: iconst_0
    //   49: ldc 39
    //   51: aastore
    //   52: invokespecial 132	io/grpc/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 5
    //   60: aconst_null
    //   61: astore_2
    //   62: aconst_null
    //   63: astore 4
    //   65: new 121	io/grpc/okhttp/internal/OptionalMethod
    //   68: dup
    //   69: ldc -120
    //   71: ldc -118
    //   73: iconst_0
    //   74: anewarray 25	java/lang/Class
    //   77: invokespecial 132	io/grpc/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   80: astore 8
    //   82: new 121	io/grpc/okhttp/internal/OptionalMethod
    //   85: dup
    //   86: aconst_null
    //   87: ldc -116
    //   89: iconst_1
    //   90: anewarray 25	java/lang/Class
    //   93: dup
    //   94: iconst_0
    //   95: ldc -120
    //   97: aastore
    //   98: invokespecial 132	io/grpc/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   101: astore 9
    //   103: aload_2
    //   104: astore_0
    //   105: aload 5
    //   107: astore_1
    //   108: ldc -114
    //   110: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   113: astore 10
    //   115: aload_2
    //   116: astore_0
    //   117: aload 5
    //   119: astore_1
    //   120: aload 10
    //   122: ldc -108
    //   124: iconst_1
    //   125: anewarray 25	java/lang/Class
    //   128: dup
    //   129: iconst_0
    //   130: ldc -106
    //   132: aastore
    //   133: invokevirtual 154	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   136: astore_2
    //   137: aload_2
    //   138: astore_0
    //   139: aload_2
    //   140: astore_1
    //   141: aload 10
    //   143: ldc -100
    //   145: iconst_1
    //   146: anewarray 25	java/lang/Class
    //   149: dup
    //   150: iconst_0
    //   151: ldc -106
    //   153: aastore
    //   154: invokevirtual 154	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   157: astore 5
    //   159: aload 5
    //   161: astore_1
    //   162: aload_2
    //   163: astore_0
    //   164: new 6	io/grpc/okhttp/internal/Platform$Android
    //   167: dup
    //   168: aload 6
    //   170: aload 7
    //   172: aload_0
    //   173: aload_1
    //   174: aload 8
    //   176: aload 9
    //   178: aload_3
    //   179: invokespecial 159	io/grpc/okhttp/internal/Platform$Android:<init>	(Lio/grpc/okhttp/internal/OptionalMethod;Lio/grpc/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lio/grpc/okhttp/internal/OptionalMethod;Lio/grpc/okhttp/internal/OptionalMethod;Ljava/security/Provider;)V
    //   182: areturn
    //   183: invokestatic 162	io/grpc/okhttp/internal/Platform:getAndroidSecurityProvider	()Ljava/security/Provider;
    //   186: astore_3
    //   187: goto -177 -> 10
    //   190: invokestatic 168	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   193: invokevirtual 171	javax/net/ssl/SSLContext:getProvider	()Ljava/security/Provider;
    //   196: astore_0
    //   197: ldc -83
    //   199: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   202: astore_1
    //   203: new 175	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   210: ldc -83
    //   212: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -74
    //   217: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   226: astore_2
    //   227: new 175	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   234: ldc -83
    //   236: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc -71
    //   241: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   250: astore_3
    //   251: new 175	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   258: ldc -83
    //   260: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc -69
    //   265: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 146	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   274: astore 4
    //   276: new 9	io/grpc/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   279: dup
    //   280: aload_1
    //   281: ldc -67
    //   283: iconst_2
    //   284: anewarray 25	java/lang/Class
    //   287: dup
    //   288: iconst_0
    //   289: ldc -65
    //   291: aastore
    //   292: dup
    //   293: iconst_1
    //   294: aload_2
    //   295: aastore
    //   296: invokevirtual 154	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   299: aload_1
    //   300: ldc -64
    //   302: iconst_1
    //   303: anewarray 25	java/lang/Class
    //   306: dup
    //   307: iconst_0
    //   308: ldc -65
    //   310: aastore
    //   311: invokevirtual 154	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   314: aload_1
    //   315: ldc -62
    //   317: iconst_1
    //   318: anewarray 25	java/lang/Class
    //   321: dup
    //   322: iconst_0
    //   323: ldc -65
    //   325: aastore
    //   326: invokevirtual 154	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   329: aload_3
    //   330: aload 4
    //   332: aload_0
    //   333: invokespecial 197	io/grpc/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;Ljava/security/Provider;)V
    //   336: astore_1
    //   337: aload_1
    //   338: areturn
    //   339: astore_0
    //   340: new 199	java/lang/RuntimeException
    //   343: dup
    //   344: aload_0
    //   345: invokespecial 202	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   348: athrow
    //   349: astore_1
    //   350: new 2	io/grpc/okhttp/internal/Platform
    //   353: dup
    //   354: aload_0
    //   355: invokespecial 204	io/grpc/okhttp/internal/Platform:<init>	(Ljava/security/Provider;)V
    //   358: areturn
    //   359: astore_1
    //   360: goto -10 -> 350
    //   363: astore_1
    //   364: aload 4
    //   366: astore_1
    //   367: goto -203 -> 164
    //   370: astore_0
    //   371: aload_1
    //   372: astore_0
    //   373: aload 4
    //   375: astore_1
    //   376: goto -212 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   104	229	0	localObject1	Object
    //   339	16	0	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   370	1	0	localClassNotFoundException1	ClassNotFoundException
    //   372	1	0	localObject2	Object
    //   107	231	1	localObject3	Object
    //   349	1	1	localNoSuchMethodException1	NoSuchMethodException
    //   359	1	1	localClassNotFoundException2	ClassNotFoundException
    //   363	1	1	localNoSuchMethodException2	NoSuchMethodException
    //   366	10	1	localClass1	Class
    //   61	234	2	localObject4	Object
    //   9	321	3	localObject5	Object
    //   63	311	4	localClass2	Class
    //   58	102	5	localMethod	Method
    //   34	135	6	localOptionalMethod1	OptionalMethod
    //   55	116	7	localOptionalMethod2	OptionalMethod
    //   80	95	8	localOptionalMethod3	OptionalMethod
    //   101	76	9	localOptionalMethod4	OptionalMethod
    //   113	29	10	localClass3	Class
    // Exception table:
    //   from	to	target	type
    //   190	197	339	java/security/NoSuchAlgorithmException
    //   197	337	349	java/lang/NoSuchMethodException
    //   197	337	359	java/lang/ClassNotFoundException
    //   108	115	363	java/lang/NoSuchMethodException
    //   120	137	363	java/lang/NoSuchMethodException
    //   141	159	363	java/lang/NoSuchMethodException
    //   108	115	370	java/lang/ClassNotFoundException
    //   120	137	370	java/lang/ClassNotFoundException
    //   141	159	370	java/lang/ClassNotFoundException
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  private static Provider getAndroidSecurityProvider()
  {
    String[] arrayOfString = ANDROID_SECURITY_PROVIDERS;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      Provider[] arrayOfProvider = Security.getProviders();
      int m = arrayOfProvider.length;
      int j = 0;
      while (j < m)
      {
        Provider localProvider = arrayOfProvider[j];
        if (str.equals(localProvider.getClass().getName()))
        {
          logger.log(Level.FINE, "Found registered provider {0}", str);
          return localProvider;
        }
        j += 1;
      }
      i += 1;
    }
    logger.log(Level.WARNING, "Unable to find Conscrypt");
    return null;
  }
  
  private static Provider getAppEngineProvider()
  {
    try
    {
      Provider localProvider = (Provider)Class.forName("org.conscrypt.OpenSSLProvider").getConstructor(new Class[0]).newInstance(new Object[0]);
      return localProvider;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("Unable to load conscrypt security provider", localThrowable);
    }
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public Provider getProvider()
  {
    return this.sslProvider;
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  private static class Android
    extends Platform
  {
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;
    
    public Android(OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4, Provider paramProvider)
    {
      super();
      this.setUseSessionTickets = paramOptionalMethod1;
      this.setHostname = paramOptionalMethod2;
      this.trafficStatsTagSocket = paramMethod1;
      this.trafficStatsUntagSocket = paramMethod2;
      this.getAlpnSelectedProtocol = paramOptionalMethod3;
      this.setAlpnProtocols = paramOptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      if (paramString != null)
      {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
      if (this.setAlpnProtocols.isSupported(paramSSLSocket))
      {
        paramString = concatLengthPrefixed(paramList);
        this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {}
      do
      {
        return null;
        paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      } while (paramSSLSocket == null);
      return new String(paramSSLSocket, Util.UTF_8);
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
  }
  
  private static class JdkWithJettyBootPlatform
    extends Platform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2, Provider paramProvider)
    {
      super();
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.removeMethod = paramMethod3;
      this.clientProviderClass = paramClass1;
      this.serverProviderClass = paramClass2;
    }
    
    public void afterHandshake(SSLSocket paramSSLSocket)
    {
      try
      {
        this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket) {}
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int i = 0;
      int j = paramList.size();
      Object localObject;
      if (i < j)
      {
        localObject = (Protocol)paramList.get(i);
        if (localObject == Protocol.HTTP_1_0) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((Protocol)localObject).toString());
        }
      }
      try
      {
        paramList = Platform.class.getClassLoader();
        localObject = this.clientProviderClass;
        Class localClass = this.serverProviderClass;
        paramString = new Platform.JettyNegoProvider(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$000(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      return null;
    }
  }
  
  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int i = 0;
        int j = ((List)paramObject).size();
        while (i < j)
        {
          if (this.protocols.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            this.selected = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/internal/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */