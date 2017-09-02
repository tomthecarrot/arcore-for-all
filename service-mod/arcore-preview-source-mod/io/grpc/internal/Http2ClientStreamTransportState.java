package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.InternalMetadata.TrustedAsciiMarshaller;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.Status;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class Http2ClientStreamTransportState
  extends AbstractClientStream2.TransportState
{
  private static final Metadata.Key<Integer> HTTP2_STATUS = InternalMetadata.keyOf(":status", HTTP_STATUS_MARSHALLER);
  private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER = new InternalMetadata.TrustedAsciiMarshaller()
  {
    public Integer parseAsciiString(byte[] paramAnonymousArrayOfByte)
    {
      if (paramAnonymousArrayOfByte.length >= 3) {
        return Integer.valueOf((paramAnonymousArrayOfByte[0] - 48) * 100 + (paramAnonymousArrayOfByte[1] - 48) * 10 + (paramAnonymousArrayOfByte[2] - 48));
      }
      throw new NumberFormatException("Malformed status code " + new String(paramAnonymousArrayOfByte, InternalMetadata.US_ASCII));
    }
    
    public byte[] toAsciiString(Integer paramAnonymousInteger)
    {
      throw new UnsupportedOperationException();
    }
  };
  private Charset errorCharset = Charsets.UTF_8;
  private boolean headersReceived;
  private Status transportError;
  private Metadata transportErrorMetadata;
  
  protected Http2ClientStreamTransportState(int paramInt, StatsTraceContext paramStatsTraceContext)
  {
    super(paramInt, paramStatsTraceContext);
  }
  
  private static Charset extractCharset(Metadata paramMetadata)
  {
    paramMetadata = (String)paramMetadata.get(GrpcUtil.CONTENT_TYPE_KEY);
    if (paramMetadata != null)
    {
      paramMetadata = paramMetadata.split("charset=");
      try
      {
        paramMetadata = Charset.forName(paramMetadata[(paramMetadata.length - 1)].trim());
        return paramMetadata;
      }
      catch (Exception paramMetadata) {}
    }
    return Charsets.UTF_8;
  }
  
  private Status statusFromTrailers(Metadata paramMetadata)
  {
    Status localStatus = (Status)paramMetadata.get(Status.CODE_KEY);
    if (localStatus != null) {
      return localStatus.withDescription((String)paramMetadata.get(Status.MESSAGE_KEY));
    }
    if (this.headersReceived) {
      return Status.UNKNOWN.withDescription("missing GRPC status in response");
    }
    paramMetadata = (Integer)paramMetadata.get(HTTP2_STATUS);
    if (paramMetadata != null) {}
    for (paramMetadata = GrpcUtil.httpStatusToGrpcStatus(paramMetadata.intValue());; paramMetadata = Status.INTERNAL.withDescription("missing HTTP status code")) {
      return paramMetadata.augmentDescription("missing GRPC status, inferred error from HTTP status code");
    }
  }
  
  private static void stripTransportDetails(Metadata paramMetadata)
  {
    paramMetadata.discardAll(HTTP2_STATUS);
    paramMetadata.discardAll(Status.CODE_KEY);
    paramMetadata.discardAll(Status.MESSAGE_KEY);
  }
  
  @Nullable
  private Status validateInitialMetadata(Metadata paramMetadata)
  {
    Integer localInteger = (Integer)paramMetadata.get(HTTP2_STATUS);
    if (localInteger == null) {
      return Status.INTERNAL.withDescription("Missing HTTP status code");
    }
    paramMetadata = (String)paramMetadata.get(GrpcUtil.CONTENT_TYPE_KEY);
    if (!GrpcUtil.isGrpcContentType(paramMetadata)) {
      return GrpcUtil.httpStatusToGrpcStatus(localInteger.intValue()).augmentDescription("invalid content-type: " + paramMetadata);
    }
    return null;
  }
  
  protected abstract void http2ProcessingFailed(Status paramStatus, Metadata paramMetadata);
  
  protected void transportDataReceived(ReadableBuffer paramReadableBuffer, boolean paramBoolean)
  {
    if (this.transportError != null)
    {
      this.transportError = this.transportError.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(paramReadableBuffer, this.errorCharset));
      paramReadableBuffer.close();
      if ((this.transportError.getDescription().length() > 1000) || (paramBoolean)) {
        http2ProcessingFailed(this.transportError, this.transportErrorMetadata);
      }
    }
    do
    {
      return;
      inboundDataReceived(paramReadableBuffer);
    } while (!paramBoolean);
    this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on DATA frame from server.");
    this.transportErrorMetadata = new Metadata();
    transportReportStatus(this.transportError, false, this.transportErrorMetadata);
  }
  
  protected void transportHeadersReceived(Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramMetadata, "headers");
    if (this.transportError != null) {
      this.transportError = this.transportError.augmentDescription("headers: " + paramMetadata);
    }
    for (;;)
    {
      return;
      try
      {
        if (this.headersReceived)
        {
          this.transportError = Status.INTERNAL.withDescription("Received headers twice");
          return;
        }
        Object localObject1 = (Integer)paramMetadata.get(HTTP2_STATUS);
        if ((localObject1 != null) && (((Integer)localObject1).intValue() >= 100))
        {
          int i = ((Integer)localObject1).intValue();
          if (i < 200) {
            return;
          }
        }
        this.headersReceived = true;
        this.transportError = validateInitialMetadata(paramMetadata);
        localObject1 = this.transportError;
        if (localObject1 != null) {
          return;
        }
        stripTransportDetails(paramMetadata);
        inboundHeadersReceived(paramMetadata);
        return;
      }
      finally
      {
        if (this.transportError != null)
        {
          this.transportError = this.transportError.augmentDescription("headers: " + paramMetadata);
          this.transportErrorMetadata = paramMetadata;
          this.errorCharset = extractCharset(paramMetadata);
        }
      }
    }
  }
  
  protected void transportTrailersReceived(Metadata paramMetadata)
  {
    Preconditions.checkNotNull(paramMetadata, "trailers");
    if ((this.transportError == null) && (!this.headersReceived))
    {
      this.transportError = validateInitialMetadata(paramMetadata);
      if (this.transportError != null) {
        this.transportErrorMetadata = paramMetadata;
      }
    }
    if (this.transportError != null)
    {
      this.transportError = this.transportError.augmentDescription("trailers: " + paramMetadata);
      http2ProcessingFailed(this.transportError, this.transportErrorMetadata);
      return;
    }
    Status localStatus = statusFromTrailers(paramMetadata);
    stripTransportDetails(paramMetadata);
    inboundTrailersReceived(paramMetadata, localStatus);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/Http2ClientStreamTransportState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */