package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClientInterceptors
{
  private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall()
  {
    public void cancel(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
    
    public void halfClose() {}
    
    public boolean isReady()
    {
      return false;
    }
    
    public void request(int paramAnonymousInt) {}
    
    public void sendMessage(Object paramAnonymousObject) {}
    
    public void start(ClientCall.Listener<Object> paramAnonymousListener, Metadata paramAnonymousMetadata) {}
  };
  
  public static Channel intercept(Channel paramChannel, List<? extends ClientInterceptor> paramList)
  {
    Preconditions.checkNotNull(paramChannel, "channel");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramChannel = new InterceptorChannel(paramChannel, (ClientInterceptor)paramList.next(), null);
    }
    return paramChannel;
  }
  
  public static Channel intercept(Channel paramChannel, ClientInterceptor... paramVarArgs)
  {
    return intercept(paramChannel, Arrays.asList(paramVarArgs));
  }
  
  public static Channel interceptForward(Channel paramChannel, List<? extends ClientInterceptor> paramList)
  {
    paramList = new ArrayList(paramList);
    Collections.reverse(paramList);
    return intercept(paramChannel, paramList);
  }
  
  public static Channel interceptForward(Channel paramChannel, ClientInterceptor... paramVarArgs)
  {
    return interceptForward(paramChannel, Arrays.asList(paramVarArgs));
  }
  
  public static abstract class CheckedForwardingClientCall<ReqT, RespT>
    extends ForwardingClientCall<ReqT, RespT>
  {
    private ClientCall<ReqT, RespT> delegate;
    
    protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> paramClientCall)
    {
      this.delegate = paramClientCall;
    }
    
    protected abstract void checkedStart(ClientCall.Listener<RespT> paramListener, Metadata paramMetadata)
      throws Exception;
    
    protected final ClientCall<ReqT, RespT> delegate()
    {
      return this.delegate;
    }
    
    public final void start(ClientCall.Listener<RespT> paramListener, Metadata paramMetadata)
    {
      try
      {
        checkedStart(paramListener, paramMetadata);
        return;
      }
      catch (Exception paramMetadata)
      {
        this.delegate = ClientInterceptors.NOOP_CALL;
        paramListener.onClose(Status.fromThrowable(paramMetadata), new Metadata());
      }
    }
  }
  
  private static class InterceptorChannel
    extends Channel
  {
    private final Channel channel;
    private final ClientInterceptor interceptor;
    
    private InterceptorChannel(Channel paramChannel, ClientInterceptor paramClientInterceptor)
    {
      this.channel = paramChannel;
      this.interceptor = ((ClientInterceptor)Preconditions.checkNotNull(paramClientInterceptor, "interceptor"));
    }
    
    public String authority()
    {
      return this.channel.authority();
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions)
    {
      return this.interceptor.interceptCall(paramMethodDescriptor, paramCallOptions, this.channel);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ClientInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */