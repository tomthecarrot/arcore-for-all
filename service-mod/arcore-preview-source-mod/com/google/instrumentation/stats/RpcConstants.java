package com.google.instrumentation.stats;

import java.util.Arrays;
import java.util.List;

public final class RpcConstants
{
  private static final List<Double> RPC_BYTES_BUCKET_BOUNDARIES;
  public static final MeasurementDescriptor RPC_CLIENT_ERROR_COUNT;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_CLIENT_ERROR_COUNT_VIEW;
  public static final TagKey RPC_CLIENT_METHOD;
  public static final MeasurementDescriptor RPC_CLIENT_REQUEST_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_CLIENT_REQUEST_BYTES_VIEW;
  public static final MeasurementDescriptor RPC_CLIENT_RESPONSE_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_CLIENT_RESPONSE_BYTES_VIEW;
  public static final MeasurementDescriptor RPC_CLIENT_ROUNDTRIP_LATENCY;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW;
  public static final MeasurementDescriptor RPC_CLIENT_SERVER_ELAPSED_TIME;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW;
  public static final MeasurementDescriptor RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES;
  public static final MeasurementDescriptor RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES;
  private static final List<Double> RPC_MILLIS_BUCKET_BOUNDARIES;
  public static final MeasurementDescriptor RPC_SERVER_ERROR_COUNT;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_ERROR_COUNT_VIEW;
  public static final TagKey RPC_SERVER_METHOD;
  public static final MeasurementDescriptor RPC_SERVER_REQUEST_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_REQUEST_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc server request_bytes", "Request MB", RPC_SERVER_REQUEST_BYTES, DistributionAggregationDescriptor.create(RPC_BYTES_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
  public static final MeasurementDescriptor RPC_SERVER_RESPONSE_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_RESPONSE_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("/rpc/server/response_bytes", "Response MB", RPC_SERVER_RESPONSE_BYTES, DistributionAggregationDescriptor.create(RPC_BYTES_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
  public static final MeasurementDescriptor RPC_SERVER_SERVER_ELAPSED_TIME;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_SERVER_ELAPSED_TIME_VIEW;
  public static final MeasurementDescriptor RPC_SERVER_SERVER_LATENCY;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_SERVER_LATENCY_VIEW;
  public static final MeasurementDescriptor RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("/rpc/server/uncompressed_request_bytes", "Uncompressed Request MB", RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, DistributionAggregationDescriptor.create(), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
  public static final MeasurementDescriptor RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES;
  public static final ViewDescriptor.DistributionViewDescriptor RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("/rpc/server/uncompressed_response_bytes", "Uncompressed Request MB", RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, DistributionAggregationDescriptor.create(), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
  public static final TagKey RPC_STATUS = TagKey.create("OpStatus");
  private static final List<MeasurementDescriptor.BasicUnit> bytes;
  private static final List<MeasurementDescriptor.BasicUnit> scalar;
  private static final List<MeasurementDescriptor.BasicUnit> seconds;
  
  static
  {
    RPC_CLIENT_METHOD = TagKey.create("method");
    RPC_SERVER_METHOD = TagKey.create("method");
    bytes = Arrays.asList(new MeasurementDescriptor.BasicUnit[] { MeasurementDescriptor.BasicUnit.BYTES });
    scalar = Arrays.asList(new MeasurementDescriptor.BasicUnit[] { MeasurementDescriptor.BasicUnit.SCALAR });
    seconds = Arrays.asList(new MeasurementDescriptor.BasicUnit[] { MeasurementDescriptor.BasicUnit.SECONDS });
    RPC_CLIENT_ERROR_COUNT = MeasurementDescriptor.create("/rpc/client/error_count", "RPC Errors", MeasurementDescriptor.MeasurementUnit.create(0, scalar));
    RPC_CLIENT_REQUEST_BYTES = MeasurementDescriptor.create("/rpc/client/request_bytes", "Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_CLIENT_RESPONSE_BYTES = MeasurementDescriptor.create("/rpc/client/response_bytes", "Response MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_CLIENT_ROUNDTRIP_LATENCY = MeasurementDescriptor.create("/rpc/client/roundtrip_latency", "RPC roundtrip latency us", MeasurementDescriptor.MeasurementUnit.create(-6, seconds));
    RPC_CLIENT_SERVER_ELAPSED_TIME = MeasurementDescriptor.create("/rpc/client/server_elapsed_time", "Server elapsed time in msecs", MeasurementDescriptor.MeasurementUnit.create(-3, seconds));
    RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES = MeasurementDescriptor.create("/rpc/client/uncompressed_request_bytes", "Uncompressed Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES = MeasurementDescriptor.create("/rpc/client/uncompressed_response_bytes", "Uncompressed Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_SERVER_ERROR_COUNT = MeasurementDescriptor.create("/rpc/server/error_count", "RPC Errors", MeasurementDescriptor.MeasurementUnit.create(0, scalar));
    RPC_SERVER_REQUEST_BYTES = MeasurementDescriptor.create("/rpc/server/request_bytes", "Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_SERVER_RESPONSE_BYTES = MeasurementDescriptor.create("/rpc/server/response_bytes", "Response MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_SERVER_SERVER_ELAPSED_TIME = MeasurementDescriptor.create("/rpc/server/server_elapsed_time", "Server elapsed time in msecs", MeasurementDescriptor.MeasurementUnit.create(-3, seconds));
    RPC_SERVER_SERVER_LATENCY = MeasurementDescriptor.create("/rpc/server/server_latency", "Latency in msecs", MeasurementDescriptor.MeasurementUnit.create(-3, seconds));
    RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES = MeasurementDescriptor.create("/rpc/server/uncompressed_request_bytes", "Uncompressed Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES = MeasurementDescriptor.create("/rpc/server/uncompressed_response_bytes", "Uncompressed Request MB", MeasurementDescriptor.MeasurementUnit.create(6, bytes));
    RPC_BYTES_BUCKET_BOUNDARIES = Arrays.asList(new Double[] { Double.valueOf(0.0D), Double.valueOf(1024.0D), Double.valueOf(2048.0D), Double.valueOf(4096.0D), Double.valueOf(16384.0D), Double.valueOf(65536.0D), Double.valueOf(262144.0D), Double.valueOf(1048576.0D), Double.valueOf(4194304.0D), Double.valueOf(1.6777216E7D), Double.valueOf(6.7108864E7D), Double.valueOf(2.68435456E8D), Double.valueOf(1.073741824E9D), Double.valueOf(4.294967296E9D) });
    RPC_MILLIS_BUCKET_BOUNDARIES = Arrays.asList(new Double[] { Double.valueOf(0.0D), Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(3.0D), Double.valueOf(4.0D), Double.valueOf(5.0D), Double.valueOf(6.0D), Double.valueOf(8.0D), Double.valueOf(10.0D), Double.valueOf(13.0D), Double.valueOf(16.0D), Double.valueOf(20.0D), Double.valueOf(25.0D), Double.valueOf(30.0D), Double.valueOf(40.0D), Double.valueOf(50.0D), Double.valueOf(65.0D), Double.valueOf(80.0D), Double.valueOf(100.0D), Double.valueOf(130.0D), Double.valueOf(160.0D), Double.valueOf(200.0D), Double.valueOf(250.0D), Double.valueOf(300.0D), Double.valueOf(400.0D), Double.valueOf(500.0D), Double.valueOf(650.0D), Double.valueOf(800.0D), Double.valueOf(1000.0D), Double.valueOf(2000.0D), Double.valueOf(5000.0D), Double.valueOf(10000.0D), Double.valueOf(20000.0D), Double.valueOf(50000.0D), Double.valueOf(100000.0D) });
    RPC_CLIENT_ERROR_COUNT_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc client error count", "RPC Errors", RPC_CLIENT_ERROR_COUNT, DistributionAggregationDescriptor.create(), Arrays.asList(new TagKey[] { RPC_STATUS, RPC_CLIENT_METHOD }));
    RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc client roundtrip latency", "Latency in msecs", RPC_CLIENT_ROUNDTRIP_LATENCY, DistributionAggregationDescriptor.create(RPC_MILLIS_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_CLIENT_METHOD }));
    RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc client server_elapsed_time", "Server elapsed time in msecs", RPC_CLIENT_SERVER_ELAPSED_TIME, DistributionAggregationDescriptor.create(RPC_MILLIS_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_CLIENT_METHOD }));
    RPC_CLIENT_REQUEST_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc client request_bytes", "Request MB", RPC_CLIENT_REQUEST_BYTES, DistributionAggregationDescriptor.create(RPC_BYTES_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_CLIENT_METHOD }));
    RPC_CLIENT_RESPONSE_BYTES_VIEW = ViewDescriptor.DistributionViewDescriptor.create("/rpc/client/response_bytes", "Response MB", RPC_CLIENT_RESPONSE_BYTES, DistributionAggregationDescriptor.create(RPC_BYTES_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_CLIENT_METHOD }));
    RPC_SERVER_ERROR_COUNT_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc server error count", "RPC Errors", RPC_SERVER_ERROR_COUNT, DistributionAggregationDescriptor.create(), Arrays.asList(new TagKey[] { RPC_STATUS, RPC_SERVER_METHOD }));
    RPC_SERVER_SERVER_LATENCY_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc server latency", "Latency in msecs", RPC_SERVER_SERVER_LATENCY, DistributionAggregationDescriptor.create(RPC_MILLIS_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
    RPC_SERVER_SERVER_ELAPSED_TIME_VIEW = ViewDescriptor.DistributionViewDescriptor.create("rpc server elapsed_time", "Server elapsed time in msecs", RPC_SERVER_SERVER_ELAPSED_TIME, DistributionAggregationDescriptor.create(RPC_MILLIS_BUCKET_BOUNDARIES), Arrays.asList(new TagKey[] { RPC_SERVER_METHOD }));
  }
  
  RpcConstants()
  {
    throw new AssertionError();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/RpcConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */