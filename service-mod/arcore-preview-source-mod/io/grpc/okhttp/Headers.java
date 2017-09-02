package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

public class Headers
{
  public static final Header CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), "application/grpc");
  public static final Header METHOD_HEADER;
  public static final Header SCHEME_HEADER = new Header(Header.TARGET_SCHEME, "https");
  public static final Header TE_HEADER = new Header("te", "trailers");
  
  static
  {
    METHOD_HEADER = new Header(Header.TARGET_METHOD, "POST");
  }
  
  public static List<Header> createRequestHeaders(Metadata paramMetadata, String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotNull(paramMetadata, "headers");
    Preconditions.checkNotNull(paramString1, "defaultPath");
    Preconditions.checkNotNull(paramString2, "authority");
    ArrayList localArrayList = new ArrayList(paramMetadata.headerCount() + 7);
    localArrayList.add(SCHEME_HEADER);
    localArrayList.add(METHOD_HEADER);
    localArrayList.add(new Header(Header.TARGET_AUTHORITY, paramString2));
    localArrayList.add(new Header(Header.TARGET_PATH, paramString1));
    localArrayList.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), paramString3));
    localArrayList.add(CONTENT_TYPE_HEADER);
    localArrayList.add(TE_HEADER);
    paramMetadata = TransportFrameUtil.toHttp2Headers(paramMetadata);
    int i = 0;
    while (i < paramMetadata.length)
    {
      paramString1 = ByteString.of(paramMetadata[i]);
      if (isApplicationHeader(paramString1.utf8())) {
        localArrayList.add(new Header(paramString1, ByteString.of(paramMetadata[(i + 1)])));
      }
      i += 2;
    }
    return localArrayList;
  }
  
  private static boolean isApplicationHeader(String paramString)
  {
    return (!paramString.startsWith(":")) && (!GrpcUtil.CONTENT_TYPE_KEY.name().equalsIgnoreCase(paramString)) && (!GrpcUtil.USER_AGENT_KEY.name().equalsIgnoreCase(paramString));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */