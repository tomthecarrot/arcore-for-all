package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBuilder
{
  public static final MediaType ALTERNATIVE;
  private static final byte[] COLONSPACE = { 58, 32 };
  private static final byte[] CRLF = { 13, 10 };
  private static final byte[] DASHDASH = { 45, 45 };
  public static final MediaType DIGEST;
  public static final MediaType FORM;
  public static final MediaType MIXED = MediaType.parse("multipart/mixed");
  public static final MediaType PARALLEL;
  private final ByteString boundary;
  private final List<RequestBody> partBodies = new ArrayList();
  private final List<Headers> partHeaders = new ArrayList();
  private MediaType type = MIXED;
  
  static
  {
    ALTERNATIVE = MediaType.parse("multipart/alternative");
    DIGEST = MediaType.parse("multipart/digest");
    PARALLEL = MediaType.parse("multipart/parallel");
    FORM = MediaType.parse("multipart/form-data");
  }
  
  public MultipartBuilder()
  {
    this(UUID.randomUUID().toString());
  }
  
  public MultipartBuilder(String paramString)
  {
    this.boundary = ByteString.encodeUtf8(paramString);
  }
  
  private static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        paramStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("%0A");
        continue;
        paramStringBuilder.append("%0D");
        continue;
        paramStringBuilder.append("%22");
      }
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public MultipartBuilder addFormDataPart(String paramString1, String paramString2)
  {
    return addFormDataPart(paramString1, null, RequestBody.create(null, paramString2));
  }
  
  public MultipartBuilder addFormDataPart(String paramString1, String paramString2, RequestBody paramRequestBody)
  {
    if (paramString1 == null) {
      throw new NullPointerException("name == null");
    }
    StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
    appendQuotedString(localStringBuilder, paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("; filename=");
      appendQuotedString(localStringBuilder, paramString2);
    }
    return addPart(Headers.of(new String[] { "Content-Disposition", localStringBuilder.toString() }), paramRequestBody);
  }
  
  public MultipartBuilder addPart(Headers paramHeaders, RequestBody paramRequestBody)
  {
    if (paramRequestBody == null) {
      throw new NullPointerException("body == null");
    }
    if ((paramHeaders != null) && (paramHeaders.get("Content-Type") != null)) {
      throw new IllegalArgumentException("Unexpected header: Content-Type");
    }
    if ((paramHeaders != null) && (paramHeaders.get("Content-Length") != null)) {
      throw new IllegalArgumentException("Unexpected header: Content-Length");
    }
    this.partHeaders.add(paramHeaders);
    this.partBodies.add(paramRequestBody);
    return this;
  }
  
  public MultipartBuilder addPart(RequestBody paramRequestBody)
  {
    return addPart(null, paramRequestBody);
  }
  
  public RequestBody build()
  {
    if (this.partHeaders.isEmpty()) {
      throw new IllegalStateException("Multipart body must have at least one part.");
    }
    return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
  }
  
  public MultipartBuilder type(MediaType paramMediaType)
  {
    if (paramMediaType == null) {
      throw new NullPointerException("type == null");
    }
    if (!paramMediaType.type().equals("multipart")) {
      throw new IllegalArgumentException("multipart != " + paramMediaType);
    }
    this.type = paramMediaType;
    return this;
  }
  
  private static final class MultipartRequestBody
    extends RequestBody
  {
    private final ByteString boundary;
    private long contentLength = -1L;
    private final MediaType contentType;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    
    public MultipartRequestBody(MediaType paramMediaType, ByteString paramByteString, List<Headers> paramList, List<RequestBody> paramList1)
    {
      if (paramMediaType == null) {
        throw new NullPointerException("type == null");
      }
      this.boundary = paramByteString;
      this.contentType = MediaType.parse(paramMediaType + "; boundary=" + paramByteString.utf8());
      this.partHeaders = Util.immutableList(paramList);
      this.partBodies = Util.immutableList(paramList1);
    }
    
    private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
      throws IOException
    {
      long l1 = 0L;
      Buffer localBuffer = null;
      if (paramBoolean)
      {
        localBuffer = new Buffer();
        paramBufferedSink = localBuffer;
      }
      int i = 0;
      int k = this.partHeaders.size();
      if (i < k)
      {
        Object localObject = (Headers)this.partHeaders.get(i);
        RequestBody localRequestBody = (RequestBody)this.partBodies.get(i);
        paramBufferedSink.write(MultipartBuilder.DASHDASH);
        paramBufferedSink.write(this.boundary);
        paramBufferedSink.write(MultipartBuilder.CRLF);
        if (localObject != null)
        {
          int j = 0;
          int m = ((Headers)localObject).size();
          while (j < m)
          {
            paramBufferedSink.writeUtf8(((Headers)localObject).name(j)).write(MultipartBuilder.COLONSPACE).writeUtf8(((Headers)localObject).value(j)).write(MultipartBuilder.CRLF);
            j += 1;
          }
        }
        localObject = localRequestBody.contentType();
        if (localObject != null) {
          paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject).toString()).write(MultipartBuilder.CRLF);
        }
        l2 = localRequestBody.contentLength();
        if (l2 != -1L)
        {
          paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(MultipartBuilder.CRLF);
          label254:
          paramBufferedSink.write(MultipartBuilder.CRLF);
          if (!paramBoolean) {
            break label305;
          }
          l1 += l2;
        }
        for (;;)
        {
          paramBufferedSink.write(MultipartBuilder.CRLF);
          i += 1;
          break;
          if (!paramBoolean) {
            break label254;
          }
          localBuffer.clear();
          return -1L;
          label305:
          ((RequestBody)this.partBodies.get(i)).writeTo(paramBufferedSink);
        }
      }
      paramBufferedSink.write(MultipartBuilder.DASHDASH);
      paramBufferedSink.write(this.boundary);
      paramBufferedSink.write(MultipartBuilder.DASHDASH);
      paramBufferedSink.write(MultipartBuilder.CRLF);
      long l2 = l1;
      if (paramBoolean)
      {
        l2 = l1 + localBuffer.size();
        localBuffer.clear();
      }
      return l2;
    }
    
    public long contentLength()
      throws IOException
    {
      long l = this.contentLength;
      if (l != -1L) {
        return l;
      }
      l = writeOrCountBytes(null, true);
      this.contentLength = l;
      return l;
    }
    
    public MediaType contentType()
    {
      return this.contentType;
    }
    
    public void writeTo(BufferedSink paramBufferedSink)
      throws IOException
    {
      writeOrCountBytes(paramBufferedSink, false);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/MultipartBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */