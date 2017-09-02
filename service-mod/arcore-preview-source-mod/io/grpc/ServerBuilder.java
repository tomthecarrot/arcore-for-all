package io.grpc;

import java.io.File;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class ServerBuilder<T extends ServerBuilder<T>>
{
  public static ServerBuilder<?> forPort(int paramInt)
  {
    return ServerProvider.provider().builderForPort(paramInt);
  }
  
  public abstract T addService(BindableService paramBindableService);
  
  public abstract T addService(ServerServiceDefinition paramServerServiceDefinition);
  
  public T addTransportFilter(ServerTransportFilter paramServerTransportFilter)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract Server build();
  
  public abstract T compressorRegistry(@Nullable CompressorRegistry paramCompressorRegistry);
  
  public abstract T decompressorRegistry(@Nullable DecompressorRegistry paramDecompressorRegistry);
  
  public abstract T directExecutor();
  
  public abstract T executor(@Nullable Executor paramExecutor);
  
  public abstract T fallbackHandlerRegistry(@Nullable HandlerRegistry paramHandlerRegistry);
  
  public abstract T useTransportSecurity(File paramFile1, File paramFile2);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */