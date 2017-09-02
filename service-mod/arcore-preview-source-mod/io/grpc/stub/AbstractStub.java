package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.CallOptions.Key;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractStub<S extends AbstractStub<S>>
{
  private final CallOptions callOptions;
  private final Channel channel;
  
  protected AbstractStub(Channel paramChannel)
  {
    this(paramChannel, CallOptions.DEFAULT);
  }
  
  protected AbstractStub(Channel paramChannel, CallOptions paramCallOptions)
  {
    this.channel = ((Channel)Preconditions.checkNotNull(paramChannel, "channel"));
    this.callOptions = ((CallOptions)Preconditions.checkNotNull(paramCallOptions, "callOptions"));
  }
  
  protected abstract S build(Channel paramChannel, CallOptions paramCallOptions);
  
  public final CallOptions getCallOptions()
  {
    return this.callOptions;
  }
  
  public final Channel getChannel()
  {
    return this.channel;
  }
  
  public final S withCallCredentials(CallCredentials paramCallCredentials)
  {
    return build(this.channel, this.callOptions.withCallCredentials(paramCallCredentials));
  }
  
  public final S withChannel(Channel paramChannel)
  {
    return build(paramChannel, this.callOptions);
  }
  
  public final S withCompression(String paramString)
  {
    return build(this.channel, this.callOptions.withCompression(paramString));
  }
  
  public final S withDeadline(@Nullable Deadline paramDeadline)
  {
    return build(this.channel, this.callOptions.withDeadline(paramDeadline));
  }
  
  public final S withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit)
  {
    return build(this.channel, this.callOptions.withDeadlineAfter(paramLong, paramTimeUnit));
  }
  
  public final S withInterceptors(ClientInterceptor... paramVarArgs)
  {
    return build(ClientInterceptors.intercept(this.channel, paramVarArgs), this.callOptions);
  }
  
  public final S withMaxInboundMessageSize(int paramInt)
  {
    return build(this.channel, this.callOptions.withMaxInboundMessageSize(paramInt));
  }
  
  public final S withMaxOutboundMessageSize(int paramInt)
  {
    return build(this.channel, this.callOptions.withMaxOutboundMessageSize(paramInt));
  }
  
  public final <T> S withOption(CallOptions.Key<T> paramKey, T paramT)
  {
    return build(this.channel, this.callOptions.withOption(paramKey, paramT));
  }
  
  public final S withWaitForReady()
  {
    return build(this.channel, this.callOptions.withWaitForReady());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/AbstractStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */