package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.ConnectionSpec.Builder;
import io.grpc.okhttp.internal.framed.Header;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

class Utils
{
  static final int CONNECTION_STREAM_ID = 0;
  static final int DEFAULT_WINDOW_SIZE = 65535;
  
  public static Metadata convertHeaders(List<Header> paramList)
  {
    return InternalMetadata.newMetadata(convertHeadersToArray(paramList));
  }
  
  private static byte[][] convertHeadersToArray(List<Header> paramList)
  {
    byte[][] arrayOfByte = new byte[paramList.size() * 2][];
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      int j = i + 1;
      arrayOfByte[i] = localHeader.name.toByteArray();
      i = j + 1;
      arrayOfByte[j] = localHeader.value.toByteArray();
    }
    return TransportFrameUtil.toRawSerializedHeaders(arrayOfByte);
  }
  
  static io.grpc.okhttp.internal.ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec paramConnectionSpec)
  {
    Preconditions.checkArgument(paramConnectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
    List localList = paramConnectionSpec.tlsVersions();
    String[] arrayOfString = new String[localList.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((TlsVersion)localList.get(i)).javaName();
      i += 1;
    }
    localList = paramConnectionSpec.cipherSuites();
    io.grpc.okhttp.internal.CipherSuite[] arrayOfCipherSuite = new io.grpc.okhttp.internal.CipherSuite[localList.size()];
    i = 0;
    while (i < arrayOfCipherSuite.length)
    {
      arrayOfCipherSuite[i] = io.grpc.okhttp.internal.CipherSuite.valueOf(((com.squareup.okhttp.CipherSuite)localList.get(i)).name());
      i += 1;
    }
    return new ConnectionSpec.Builder(paramConnectionSpec.isTls()).supportsTlsExtensions(paramConnectionSpec.supportsTlsExtensions()).tlsVersions(arrayOfString).cipherSuites(arrayOfCipherSuite).build();
  }
  
  public static Metadata convertTrailers(List<Header> paramList)
  {
    return InternalMetadata.newMetadata(convertHeadersToArray(paramList));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */