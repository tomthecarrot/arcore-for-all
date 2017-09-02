package io.grpc;

import com.google.common.base.Preconditions;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ServerInterceptors
{
  public static ServerServiceDefinition intercept(BindableService paramBindableService, List<? extends ServerInterceptor> paramList)
  {
    Preconditions.checkNotNull(paramBindableService, "bindableService");
    return intercept(paramBindableService.bindService(), paramList);
  }
  
  public static ServerServiceDefinition intercept(BindableService paramBindableService, ServerInterceptor... paramVarArgs)
  {
    Preconditions.checkNotNull(paramBindableService, "bindableService");
    return intercept(paramBindableService.bindService(), Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition intercept(ServerServiceDefinition paramServerServiceDefinition, List<? extends ServerInterceptor> paramList)
  {
    Preconditions.checkNotNull(paramServerServiceDefinition, "serviceDef");
    if (paramList.isEmpty()) {
      return paramServerServiceDefinition;
    }
    ServerServiceDefinition.Builder localBuilder = ServerServiceDefinition.builder(paramServerServiceDefinition.getServiceDescriptor());
    paramServerServiceDefinition = paramServerServiceDefinition.getMethods().iterator();
    while (paramServerServiceDefinition.hasNext()) {
      wrapAndAddMethod(localBuilder, (ServerMethodDefinition)paramServerServiceDefinition.next(), paramList);
    }
    return localBuilder.build();
  }
  
  public static ServerServiceDefinition intercept(ServerServiceDefinition paramServerServiceDefinition, ServerInterceptor... paramVarArgs)
  {
    return intercept(paramServerServiceDefinition, Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition interceptForward(BindableService paramBindableService, List<? extends ServerInterceptor> paramList)
  {
    return interceptForward(paramBindableService.bindService(), paramList);
  }
  
  public static ServerServiceDefinition interceptForward(BindableService paramBindableService, ServerInterceptor... paramVarArgs)
  {
    return interceptForward(paramBindableService.bindService(), Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition interceptForward(ServerServiceDefinition paramServerServiceDefinition, List<? extends ServerInterceptor> paramList)
  {
    paramList = new ArrayList(paramList);
    Collections.reverse(paramList);
    return intercept(paramServerServiceDefinition, paramList);
  }
  
  public static ServerServiceDefinition interceptForward(ServerServiceDefinition paramServerServiceDefinition, ServerInterceptor... paramVarArgs)
  {
    return interceptForward(paramServerServiceDefinition, Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition paramServerServiceDefinition)
  {
    useMarshalledMessages(paramServerServiceDefinition, new MethodDescriptor.Marshaller()
    {
      public InputStream parse(InputStream paramAnonymousInputStream)
      {
        if (paramAnonymousInputStream.markSupported()) {
          return paramAnonymousInputStream;
        }
        return new BufferedInputStream(paramAnonymousInputStream);
      }
      
      public InputStream stream(InputStream paramAnonymousInputStream)
      {
        return paramAnonymousInputStream;
      }
    });
  }
  
  public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition paramServerServiceDefinition, MethodDescriptor.Marshaller<T> paramMarshaller)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramServerServiceDefinition.getMethods().iterator();
    while (localIterator.hasNext())
    {
      ServerMethodDefinition localServerMethodDefinition = (ServerMethodDefinition)localIterator.next();
      MethodDescriptor localMethodDescriptor = localServerMethodDefinition.getMethodDescriptor().toBuilder(paramMarshaller, paramMarshaller).build();
      localArrayList2.add(localMethodDescriptor);
      localArrayList1.add(wrapMethod(localServerMethodDefinition, localMethodDescriptor));
    }
    paramServerServiceDefinition = ServerServiceDefinition.builder(new ServiceDescriptor(paramServerServiceDefinition.getServiceDescriptor().getName(), localArrayList2));
    paramMarshaller = localArrayList1.iterator();
    while (paramMarshaller.hasNext()) {
      paramServerServiceDefinition.addMethod((ServerMethodDefinition)paramMarshaller.next());
    }
    return paramServerServiceDefinition.build();
  }
  
  private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder paramBuilder, ServerMethodDefinition<ReqT, RespT> paramServerMethodDefinition, List<? extends ServerInterceptor> paramList)
  {
    ServerCallHandler localServerCallHandler = paramServerMethodDefinition.getServerCallHandler();
    Iterator localIterator = paramList.iterator();
    for (paramList = localServerCallHandler; localIterator.hasNext(); paramList = InterceptCallHandler.create((ServerInterceptor)localIterator.next(), paramList)) {}
    paramBuilder.addMethod(paramServerMethodDefinition.withServerCallHandler(paramList));
  }
  
  private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> paramServerCallHandler, MethodDescriptor<OReqT, ORespT> paramMethodDescriptor, final MethodDescriptor<WReqT, WRespT> paramMethodDescriptor1)
  {
    new ServerCallHandler()
    {
      public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> paramAnonymousServerCall, Metadata paramAnonymousMetadata)
      {
        paramAnonymousServerCall = new PartialForwardingServerCall()
        {
          protected ServerCall<WReqT, WRespT> delegate()
          {
            return paramAnonymousServerCall;
          }
          
          public MethodDescriptor<OReqT, ORespT> getMethodDescriptor()
          {
            return ServerInterceptors.this;
          }
          
          public void sendMessage(ORespT paramAnonymous2ORespT)
          {
            paramAnonymous2ORespT = ServerInterceptors.this.streamResponse(paramAnonymous2ORespT);
            paramAnonymous2ORespT = ServerInterceptors.2.this.val$wrappedMethod.parseResponse(paramAnonymous2ORespT);
            delegate().sendMessage(paramAnonymous2ORespT);
          }
        };
        new PartialForwardingServerCallListener()
        {
          protected ServerCall.Listener<OReqT> delegate()
          {
            return this.val$originalListener;
          }
          
          public void onMessage(WReqT paramAnonymous2WReqT)
          {
            paramAnonymous2WReqT = ServerInterceptors.2.this.val$wrappedMethod.streamRequest(paramAnonymous2WReqT);
            paramAnonymous2WReqT = ServerInterceptors.this.parseRequest(paramAnonymous2WReqT);
            delegate().onMessage(paramAnonymous2WReqT);
          }
        };
      }
    };
  }
  
  private static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> paramServerMethodDefinition, MethodDescriptor<WReqT, WRespT> paramMethodDescriptor)
  {
    return ServerMethodDefinition.create(paramMethodDescriptor, wrapHandler(paramServerMethodDefinition.getServerCallHandler(), paramServerMethodDefinition.getMethodDescriptor(), paramMethodDescriptor));
  }
  
  private static class InterceptCallHandler<ReqT, RespT>
    implements ServerCallHandler<ReqT, RespT>
  {
    private final ServerCallHandler<ReqT, RespT> callHandler;
    private final ServerInterceptor interceptor;
    
    private InterceptCallHandler(ServerInterceptor paramServerInterceptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler)
    {
      this.interceptor = ((ServerInterceptor)Preconditions.checkNotNull(paramServerInterceptor, "interceptor"));
      this.callHandler = paramServerCallHandler;
    }
    
    public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor paramServerInterceptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler)
    {
      return new InterceptCallHandler(paramServerInterceptor, paramServerCallHandler);
    }
    
    public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata)
    {
      return this.interceptor.interceptCall(paramServerCall, paramMetadata, this.callHandler);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */