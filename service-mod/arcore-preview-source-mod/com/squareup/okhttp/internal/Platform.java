package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
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
    //   0: ldc 77
    //   2: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: pop
    //   6: new 85	com/squareup/okhttp/internal/OptionalMethod
    //   9: dup
    //   10: aconst_null
    //   11: ldc 87
    //   13: iconst_1
    //   14: anewarray 79	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: getstatic 93	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   22: aastore
    //   23: invokespecial 96	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   26: astore 9
    //   28: new 85	com/squareup/okhttp/internal/OptionalMethod
    //   31: dup
    //   32: aconst_null
    //   33: ldc 98
    //   35: iconst_1
    //   36: anewarray 79	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 54
    //   43: aastore
    //   44: invokespecial 96	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 8
    //   52: aconst_null
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 4
    //   60: aconst_null
    //   61: astore 6
    //   63: aconst_null
    //   64: astore 5
    //   66: aload_1
    //   67: astore_2
    //   68: aload 8
    //   70: astore_3
    //   71: aload 7
    //   73: astore_0
    //   74: ldc 100
    //   76: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: astore 11
    //   81: aload_1
    //   82: astore_2
    //   83: aload 8
    //   85: astore_3
    //   86: aload 7
    //   88: astore_0
    //   89: aload 11
    //   91: ldc 102
    //   93: iconst_1
    //   94: anewarray 79	java/lang/Class
    //   97: dup
    //   98: iconst_0
    //   99: ldc 104
    //   101: aastore
    //   102: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   105: astore_1
    //   106: aload_1
    //   107: astore_2
    //   108: aload_1
    //   109: astore_3
    //   110: aload 7
    //   112: astore_0
    //   113: aload 11
    //   115: ldc 110
    //   117: iconst_1
    //   118: anewarray 79	java/lang/Class
    //   121: dup
    //   122: iconst_0
    //   123: ldc 104
    //   125: aastore
    //   126: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   129: astore 7
    //   131: aload 7
    //   133: astore_2
    //   134: aload_1
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: ldc 112
    //   140: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   143: pop
    //   144: aload_1
    //   145: astore_3
    //   146: aload_2
    //   147: astore_0
    //   148: new 85	com/squareup/okhttp/internal/OptionalMethod
    //   151: dup
    //   152: ldc 114
    //   154: ldc 116
    //   156: iconst_0
    //   157: anewarray 79	java/lang/Class
    //   160: invokespecial 96	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   163: astore 4
    //   165: new 85	com/squareup/okhttp/internal/OptionalMethod
    //   168: dup
    //   169: aconst_null
    //   170: ldc 118
    //   172: iconst_1
    //   173: anewarray 79	java/lang/Class
    //   176: dup
    //   177: iconst_0
    //   178: ldc 114
    //   180: aastore
    //   181: invokespecial 96	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   184: astore_3
    //   185: aload 4
    //   187: astore_0
    //   188: new 6	com/squareup/okhttp/internal/Platform$Android
    //   191: dup
    //   192: aload 9
    //   194: aload 10
    //   196: aload_1
    //   197: aload_2
    //   198: aload_0
    //   199: aload_3
    //   200: invokespecial 121	com/squareup/okhttp/internal/Platform$Android:<init>	(Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   203: areturn
    //   204: astore_0
    //   205: ldc 123
    //   207: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   210: pop
    //   211: goto -205 -> 6
    //   214: astore_0
    //   215: ldc 125
    //   217: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   220: astore_0
    //   221: new 127	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   228: ldc 125
    //   230: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc -122
    //   235: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   244: astore_1
    //   245: new 127	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   252: ldc 125
    //   254: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc -119
    //   259: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   268: astore_2
    //   269: new 127	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   276: ldc 125
    //   278: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc -117
    //   283: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   292: astore_3
    //   293: new 9	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   296: dup
    //   297: aload_0
    //   298: ldc -115
    //   300: iconst_2
    //   301: anewarray 79	java/lang/Class
    //   304: dup
    //   305: iconst_0
    //   306: ldc -113
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: aload_1
    //   312: aastore
    //   313: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   316: aload_0
    //   317: ldc -112
    //   319: iconst_1
    //   320: anewarray 79	java/lang/Class
    //   323: dup
    //   324: iconst_0
    //   325: ldc -113
    //   327: aastore
    //   328: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   331: aload_0
    //   332: ldc -110
    //   334: iconst_1
    //   335: anewarray 79	java/lang/Class
    //   338: dup
    //   339: iconst_0
    //   340: ldc -113
    //   342: aastore
    //   343: invokevirtual 108	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   346: aload_2
    //   347: aload_3
    //   348: invokespecial 149	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   351: astore_0
    //   352: aload_0
    //   353: areturn
    //   354: astore_0
    //   355: new 2	com/squareup/okhttp/internal/Platform
    //   358: dup
    //   359: invokespecial 150	com/squareup/okhttp/internal/Platform:<init>	()V
    //   362: areturn
    //   363: astore_0
    //   364: goto -9 -> 355
    //   367: astore_0
    //   368: aload_2
    //   369: astore_1
    //   370: aload 4
    //   372: astore_2
    //   373: aload 6
    //   375: astore_0
    //   376: aload 5
    //   378: astore_3
    //   379: goto -191 -> 188
    //   382: astore_1
    //   383: aload_3
    //   384: astore_1
    //   385: aload_0
    //   386: astore_2
    //   387: aload 6
    //   389: astore_0
    //   390: aload 5
    //   392: astore_3
    //   393: goto -205 -> 188
    //   396: astore_0
    //   397: aload 4
    //   399: astore_0
    //   400: aload 5
    //   402: astore_3
    //   403: goto -215 -> 188
    //   406: astore_0
    //   407: aload 6
    //   409: astore_0
    //   410: aload 5
    //   412: astore_3
    //   413: goto -225 -> 188
    //   416: astore_0
    //   417: aload 4
    //   419: astore_0
    //   420: aload 5
    //   422: astore_3
    //   423: goto -235 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   73	126	0	localObject1	Object
    //   204	1	0	localClassNotFoundException1	ClassNotFoundException
    //   214	1	0	localClassNotFoundException2	ClassNotFoundException
    //   220	133	0	localObject2	Object
    //   354	1	0	localClassNotFoundException3	ClassNotFoundException
    //   363	1	0	localNoSuchMethodException1	NoSuchMethodException
    //   367	1	0	localClassNotFoundException4	ClassNotFoundException
    //   375	15	0	localObject3	Object
    //   396	1	0	localNoSuchMethodException2	NoSuchMethodException
    //   399	1	0	localOptionalMethod1	OptionalMethod
    //   406	1	0	localClassNotFoundException5	ClassNotFoundException
    //   409	1	0	localObject4	Object
    //   416	1	0	localClassNotFoundException6	ClassNotFoundException
    //   419	1	0	localOptionalMethod2	OptionalMethod
    //   53	317	1	localObject5	Object
    //   382	1	1	localNoSuchMethodException3	NoSuchMethodException
    //   384	1	1	localObject6	Object
    //   67	320	2	localObject7	Object
    //   70	353	3	localObject8	Object
    //   58	360	4	localOptionalMethod3	OptionalMethod
    //   64	357	5	localObject9	Object
    //   61	347	6	localObject10	Object
    //   55	77	7	localMethod	Method
    //   50	34	8	localObject11	Object
    //   26	167	9	localOptionalMethod4	OptionalMethod
    //   47	148	10	localOptionalMethod5	OptionalMethod
    //   79	35	11	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	6	204	java/lang/ClassNotFoundException
    //   6	49	214	java/lang/ClassNotFoundException
    //   188	204	214	java/lang/ClassNotFoundException
    //   205	211	214	java/lang/ClassNotFoundException
    //   215	352	354	java/lang/ClassNotFoundException
    //   215	352	363	java/lang/NoSuchMethodException
    //   74	81	367	java/lang/ClassNotFoundException
    //   89	106	367	java/lang/ClassNotFoundException
    //   113	131	367	java/lang/ClassNotFoundException
    //   74	81	382	java/lang/NoSuchMethodException
    //   89	106	382	java/lang/NoSuchMethodException
    //   113	131	382	java/lang/NoSuchMethodException
    //   138	144	382	java/lang/NoSuchMethodException
    //   148	165	382	java/lang/NoSuchMethodException
    //   165	185	396	java/lang/NoSuchMethodException
    //   138	144	406	java/lang/ClassNotFoundException
    //   148	165	406	java/lang/ClassNotFoundException
    //   165	185	416	java/lang/ClassNotFoundException
  }
  
  public static Platform get()
  {
    return PLATFORM;
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
    
    public Android(OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
    {
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
      if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
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
      if (this.getAlpnSelectedProtocol == null) {}
      while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
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
    
    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
    {
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
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
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
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$000(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */