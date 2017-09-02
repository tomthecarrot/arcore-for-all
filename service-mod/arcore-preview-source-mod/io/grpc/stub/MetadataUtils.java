package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientCall.Listener;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

public final class MetadataUtils
{
  public static <T extends AbstractStub<T>> T attachHeaders(T paramT, Metadata paramMetadata)
  {
    return paramT.withInterceptors(new ClientInterceptor[] { newAttachHeadersInterceptor(paramMetadata) });
  }
  
  public static <T extends AbstractStub<T>> T captureMetadata(T paramT, AtomicReference<Metadata> paramAtomicReference1, AtomicReference<Metadata> paramAtomicReference2)
  {
    return paramT.withInterceptors(new ClientInterceptor[] { newCaptureMetadataInterceptor(paramAtomicReference1, paramAtomicReference2) });
  }
  
  public static ClientInterceptor newAttachHeadersInterceptor(Metadata paramMetadata)
  {
    new ClientInterceptor()
    {
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramAnonymousMethodDescriptor, CallOptions paramAnonymousCallOptions, Channel paramAnonymousChannel)
      {
        new ForwardingClientCall.SimpleForwardingClientCall(paramAnonymousChannel.newCall(paramAnonymousMethodDescriptor, paramAnonymousCallOptions))
        {
          public void start(ClientCall.Listener<RespT> paramAnonymous2Listener, Metadata paramAnonymous2Metadata)
          {
            paramAnonymous2Metadata.merge(MetadataUtils.this);
            super.start(paramAnonymous2Listener, paramAnonymous2Metadata);
          }
        };
      }
    };
  }
  
  public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> paramAtomicReference1, final AtomicReference<Metadata> paramAtomicReference2)
  {
    new ClientInterceptor()
    {
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramAnonymousMethodDescriptor, CallOptions paramAnonymousCallOptions, Channel paramAnonymousChannel)
      {
        new ForwardingClientCall.SimpleForwardingClientCall(paramAnonymousChannel.newCall(paramAnonymousMethodDescriptor, paramAnonymousCallOptions))
        {
          public void start(ClientCall.Listener<RespT> paramAnonymous2Listener, Metadata paramAnonymous2Metadata)
          {
            MetadataUtils.this.set(null);
            MetadataUtils.2.this.val$trailersCapture.set(null);
            super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener(paramAnonymous2Listener)
            {
              public void onClose(Status paramAnonymous3Status, Metadata paramAnonymous3Metadata)
              {
                MetadataUtils.2.this.val$trailersCapture.set(paramAnonymous3Metadata);
                super.onClose(paramAnonymous3Status, paramAnonymous3Metadata);
              }
              
              public void onHeaders(Metadata paramAnonymous3Metadata)
              {
                MetadataUtils.this.set(paramAnonymous3Metadata);
                super.onHeaders(paramAnonymous3Metadata);
              }
            }, paramAnonymous2Metadata);
          }
        };
      }
    };
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/MetadataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */