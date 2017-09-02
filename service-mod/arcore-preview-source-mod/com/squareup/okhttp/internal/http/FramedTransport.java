package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Timeout;

public final class FramedTransport
  implements Transport
{
  private static final List<ByteString> HTTP_2_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] { ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("te"), ByteString.encodeUtf8("transfer-encoding"), ByteString.encodeUtf8("encoding"), ByteString.encodeUtf8("upgrade") });
  private static final List<ByteString> SPDY_3_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] { ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("transfer-encoding") });
  private final FramedConnection framedConnection;
  private final HttpEngine httpEngine;
  private FramedStream stream;
  
  public FramedTransport(HttpEngine paramHttpEngine, FramedConnection paramFramedConnection)
  {
    this.httpEngine = paramHttpEngine;
    this.framedConnection = paramFramedConnection;
  }
  
  private static boolean isProhibitedHeader(Protocol paramProtocol, ByteString paramByteString)
  {
    if (paramProtocol == Protocol.SPDY_3) {
      return SPDY_3_PROHIBITED_HEADERS.contains(paramByteString);
    }
    if (paramProtocol == Protocol.HTTP_2) {
      return HTTP_2_PROHIBITED_HEADERS.contains(paramByteString);
    }
    throw new AssertionError(paramProtocol);
  }
  
  private static String joinOnNull(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static Response.Builder readNameValueBlock(List<Header> paramList, Protocol paramProtocol)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = "HTTP/1.1";
    Headers.Builder localBuilder = new Headers.Builder();
    localBuilder.set(OkHeaders.SELECTED_PROTOCOL, paramProtocol.toString());
    int i = 0;
    int n = paramList.size();
    while (i < n)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      String str2 = ((Header)paramList.get(i)).value.utf8();
      int j = 0;
      if (j < str2.length())
      {
        int m = str2.indexOf(0, j);
        int k = m;
        if (m == -1) {
          k = str2.length();
        }
        String str1 = str2.substring(j, k);
        Object localObject3;
        Object localObject4;
        if (localByteString.equals(Header.RESPONSE_STATUS))
        {
          localObject3 = str1;
          localObject4 = localObject1;
        }
        for (;;)
        {
          j = k + 1;
          localObject2 = localObject3;
          localObject1 = localObject4;
          break;
          if (localByteString.equals(Header.VERSION))
          {
            localObject4 = str1;
            localObject3 = localObject2;
          }
          else
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (!isProhibitedHeader(paramProtocol, localByteString))
            {
              localBuilder.add(localByteString.utf8(), str1);
              localObject3 = localObject2;
              localObject4 = localObject1;
            }
          }
        }
      }
      i += 1;
    }
    if (localObject2 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = StatusLine.parse((String)localObject1 + " " + (String)localObject2);
    return new Response.Builder().protocol(paramProtocol).code(paramList.code).message(paramList.message).headers(localBuilder.build());
  }
  
  public static List<Header> writeNameValueBlock(Request paramRequest, Protocol paramProtocol, String paramString)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 10);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.httpUrl())));
    String str = Util.hostHeader(paramRequest.httpUrl());
    int i;
    if (Protocol.SPDY_3 == paramProtocol)
    {
      localArrayList.add(new Header(Header.VERSION, paramString));
      localArrayList.add(new Header(Header.TARGET_HOST, str));
      localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.httpUrl().scheme()));
      paramRequest = new LinkedHashSet();
      i = 0;
      int k = localHeaders.size();
      label167:
      if (i >= k) {
        break label431;
      }
      paramString = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      str = localHeaders.value(i);
      if (!isProhibitedHeader(paramProtocol, paramString)) {
        break label250;
      }
    }
    label250:
    label429:
    for (;;)
    {
      i += 1;
      break label167;
      if (Protocol.HTTP_2 == paramProtocol)
      {
        localArrayList.add(new Header(Header.TARGET_AUTHORITY, str));
        break;
      }
      throw new AssertionError();
      if ((!paramString.equals(Header.TARGET_METHOD)) && (!paramString.equals(Header.TARGET_PATH)) && (!paramString.equals(Header.TARGET_SCHEME)) && (!paramString.equals(Header.TARGET_AUTHORITY)) && (!paramString.equals(Header.TARGET_HOST)) && (!paramString.equals(Header.VERSION))) {
        if (paramRequest.add(paramString))
        {
          localArrayList.add(new Header(paramString, str));
        }
        else
        {
          int j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label429;
            }
            if (((Header)localArrayList.get(j)).name.equals(paramString))
            {
              localArrayList.set(j, new Header(paramString, joinOnNull(((Header)localArrayList.get(j)).value.utf8(), str)));
              break;
            }
            j += 1;
          }
        }
      }
    }
    label431:
    return localArrayList;
  }
  
  public boolean canReuseConnection()
  {
    return true;
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException
  {
    return this.stream.getSink();
  }
  
  public void disconnect(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.stream != null) {
      this.stream.close(ErrorCode.CANCEL);
    }
  }
  
  public void finishRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(this.stream.getSource()));
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return readNameValueBlock(this.stream.getResponseHeaders(), this.framedConnection.getProtocol());
  }
  
  public void releaseConnectionOnIdle() {}
  
  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    paramRetryableSink.writeToSocket(this.stream.getSink());
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null) {
      return;
    }
    this.httpEngine.writingRequestHeaders();
    boolean bool = this.httpEngine.permitsRequestBody();
    String str = RequestLine.version(this.httpEngine.getConnection().getProtocol());
    this.stream = this.framedConnection.newStream(writeNameValueBlock(paramRequest, this.framedConnection.getProtocol(), str), bool, true);
    this.stream.readTimeout().timeout(this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/http/FramedTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */