package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.instrumentation.stats.MeasurementDescriptor;
import com.google.instrumentation.stats.MeasurementMap;
import com.google.instrumentation.stats.MeasurementMap.Builder;
import com.google.instrumentation.stats.RpcConstants;
import com.google.instrumentation.stats.StatsContext;
import com.google.instrumentation.stats.StatsContextFactory;
import com.google.instrumentation.stats.TagValue;
import io.grpc.Metadata;
import io.grpc.Metadata.BinaryMarshaller;
import io.grpc.Metadata.Key;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class StatsTraceContext
{
  private static final double NANOS_PER_MILLI = 1000000.0D;
  public static final StatsTraceContext NOOP = newClientContext("noopservice/noopmethod", NoopStatsContextFactory.INSTANCE, GrpcUtil.STOPWATCH_SUPPLIER);
  private final AtomicBoolean callEnded = new AtomicBoolean(false);
  private volatile long clientPendingNanos = -1L;
  private final Side side;
  private final StatsContext statsCtx;
  private final Metadata.Key<StatsContext> statsHeader;
  private final Stopwatch stopwatch;
  private volatile long uncompressedBytesReceived;
  private volatile long uncompressedBytesSent;
  private volatile long wireBytesReceived;
  private volatile long wireBytesSent;
  
  private StatsTraceContext(Side paramSide, String paramString, StatsContext paramStatsContext, Supplier<Stopwatch> paramSupplier, Metadata.Key<StatsContext> paramKey)
  {
    this.side = paramSide;
    if (paramSide == Side.CLIENT) {}
    for (paramSide = RpcConstants.RPC_CLIENT_METHOD;; paramSide = RpcConstants.RPC_SERVER_METHOD)
    {
      this.statsCtx = paramStatsContext.with(paramSide, TagValue.create(paramString));
      this.stopwatch = ((Stopwatch)paramSupplier.get()).start();
      this.statsHeader = paramKey;
      return;
    }
  }
  
  @VisibleForTesting
  static Metadata.Key<StatsContext> createStatsHeader(StatsContextFactory paramStatsContextFactory)
  {
    Metadata.Key.of("grpc-census-bin", new Metadata.BinaryMarshaller()
    {
      public StatsContext parseBytes(byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          paramAnonymousArrayOfByte = StatsTraceContext.this.deserialize(new ByteArrayInputStream(paramAnonymousArrayOfByte));
          return paramAnonymousArrayOfByte;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          throw new RuntimeException(paramAnonymousArrayOfByte);
        }
      }
      
      public byte[] toBytes(StatsContext paramAnonymousStatsContext)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        try
        {
          paramAnonymousStatsContext.serialize(localByteArrayOutputStream);
          return localByteArrayOutputStream.toByteArray();
        }
        catch (IOException paramAnonymousStatsContext)
        {
          throw new RuntimeException(paramAnonymousStatsContext);
        }
      }
    });
  }
  
  public static StatsTraceContext newClientContext(String paramString, StatsContextFactory paramStatsContextFactory, Supplier<Stopwatch> paramSupplier)
  {
    return new StatsTraceContext(Side.CLIENT, paramString, paramStatsContextFactory.getDefault(), paramSupplier, createStatsHeader(paramStatsContextFactory));
  }
  
  @VisibleForTesting
  static StatsTraceContext newClientContextForTesting(String paramString, StatsContextFactory paramStatsContextFactory, StatsContext paramStatsContext, Supplier<Stopwatch> paramSupplier)
  {
    return new StatsTraceContext(Side.CLIENT, paramString, paramStatsContext, paramSupplier, createStatsHeader(paramStatsContextFactory));
  }
  
  public static StatsTraceContext newServerContext(String paramString, StatsContextFactory paramStatsContextFactory, Metadata paramMetadata, Supplier<Stopwatch> paramSupplier)
  {
    Metadata.Key localKey = createStatsHeader(paramStatsContextFactory);
    StatsContext localStatsContext = (StatsContext)paramMetadata.get(localKey);
    paramMetadata = localStatsContext;
    if (localStatsContext == null) {
      paramMetadata = paramStatsContextFactory.getDefault();
    }
    return new StatsTraceContext(Side.SERVER, paramString, paramMetadata, paramSupplier, localKey);
  }
  
  void callEnded(Status paramStatus)
  {
    if (!this.callEnded.compareAndSet(false, true)) {
      return;
    }
    this.stopwatch.stop();
    Object localObject;
    MeasurementDescriptor localMeasurementDescriptor5;
    MeasurementDescriptor localMeasurementDescriptor4;
    MeasurementDescriptor localMeasurementDescriptor3;
    MeasurementDescriptor localMeasurementDescriptor2;
    if (this.side == Side.CLIENT)
    {
      localObject = RpcConstants.RPC_CLIENT_ROUNDTRIP_LATENCY;
      localMeasurementDescriptor5 = RpcConstants.RPC_CLIENT_REQUEST_BYTES;
      localMeasurementDescriptor4 = RpcConstants.RPC_CLIENT_RESPONSE_BYTES;
      localMeasurementDescriptor3 = RpcConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES;
      localMeasurementDescriptor2 = RpcConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES;
    }
    for (MeasurementDescriptor localMeasurementDescriptor1 = RpcConstants.RPC_CLIENT_ERROR_COUNT;; localMeasurementDescriptor1 = RpcConstants.RPC_SERVER_ERROR_COUNT)
    {
      long l = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
      localObject = MeasurementMap.builder().put((MeasurementDescriptor)localObject, l / 1000000.0D).put(localMeasurementDescriptor5, this.wireBytesSent).put(localMeasurementDescriptor4, this.wireBytesReceived).put(localMeasurementDescriptor3, this.uncompressedBytesSent).put(localMeasurementDescriptor2, this.uncompressedBytesReceived);
      if (!paramStatus.isOk()) {
        ((MeasurementMap.Builder)localObject).put(localMeasurementDescriptor1, 1.0D);
      }
      if ((this.side == Side.CLIENT) && (this.clientPendingNanos >= 0L)) {
        ((MeasurementMap.Builder)localObject).put(RpcConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, (l - this.clientPendingNanos) / 1000000.0D);
      }
      this.statsCtx.with(RpcConstants.RPC_STATUS, TagValue.create(paramStatus.getCode().toString())).record(((MeasurementMap.Builder)localObject).build());
      return;
      localObject = RpcConstants.RPC_SERVER_SERVER_LATENCY;
      localMeasurementDescriptor5 = RpcConstants.RPC_SERVER_RESPONSE_BYTES;
      localMeasurementDescriptor4 = RpcConstants.RPC_SERVER_REQUEST_BYTES;
      localMeasurementDescriptor3 = RpcConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES;
      localMeasurementDescriptor2 = RpcConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES;
    }
  }
  
  public void clientHeadersSent()
  {
    if (this.side == Side.CLIENT) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Must be called on client-side");
      if (this.clientPendingNanos < 0L) {
        this.clientPendingNanos = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
      }
      return;
    }
  }
  
  @VisibleForTesting
  StatsContext getStatsContext()
  {
    return this.statsCtx;
  }
  
  Metadata.Key<StatsContext> getStatsHeader()
  {
    return this.statsHeader;
  }
  
  void propagateToHeaders(Metadata paramMetadata)
  {
    paramMetadata.discardAll(this.statsHeader);
    paramMetadata.put(this.statsHeader, this.statsCtx);
  }
  
  void uncompressedBytesReceived(long paramLong)
  {
    this.uncompressedBytesReceived += paramLong;
  }
  
  void uncompressedBytesSent(long paramLong)
  {
    this.uncompressedBytesSent += paramLong;
  }
  
  void wireBytesReceived(long paramLong)
  {
    this.wireBytesReceived += paramLong;
  }
  
  void wireBytesSent(long paramLong)
  {
    this.wireBytesSent += paramLong;
  }
  
  private static enum Side
  {
    CLIENT,  SERVER;
    
    private Side() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/StatsTraceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */