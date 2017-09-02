package io.grpc.okhttp;

import io.grpc.ManagedChannelProvider;
import io.grpc.internal.GrpcUtil;

public final class OkHttpChannelProvider
  extends ManagedChannelProvider
{
  public OkHttpChannelBuilder builderForAddress(String paramString, int paramInt)
  {
    return OkHttpChannelBuilder.forAddress(paramString, paramInt);
  }
  
  public OkHttpChannelBuilder builderForTarget(String paramString)
  {
    return OkHttpChannelBuilder.forTarget(paramString);
  }
  
  public boolean isAvailable()
  {
    return true;
  }
  
  public int priority()
  {
    if ((GrpcUtil.IS_RESTRICTED_APPENGINE) || (isAndroid())) {
      return 8;
    }
    return 3;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpChannelProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */