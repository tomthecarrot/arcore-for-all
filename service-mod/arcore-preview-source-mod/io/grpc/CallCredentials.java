package io.grpc;

import java.util.concurrent.Executor;

public abstract interface CallCredentials
{
  public static final Attributes.Key<String> ATTR_AUTHORITY = Attributes.Key.of("io.grpc.CallCredentials.authority");
  public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.of("io.grpc.CallCredentials.securityLevel");
  
  public abstract void applyRequestMetadata(MethodDescriptor<?, ?> paramMethodDescriptor, Attributes paramAttributes, Executor paramExecutor, MetadataApplier paramMetadataApplier);
  
  public static abstract interface MetadataApplier
  {
    public abstract void apply(Metadata paramMetadata);
    
    public abstract void fail(Status paramStatus);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/CallCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */