package io.grpc;

import javax.annotation.Nullable;

public class StatusException
  extends Exception
{
  private static final long serialVersionUID = -660954903976144640L;
  private final Status status;
  private final Metadata trailers;
  
  public StatusException(Status paramStatus)
  {
    this(paramStatus, null);
  }
  
  public StatusException(Status paramStatus, @Nullable Metadata paramMetadata)
  {
    super(Status.formatThrowableMessage(paramStatus), paramStatus.getCause());
    this.status = paramStatus;
    this.trailers = paramMetadata;
  }
  
  public final Status getStatus()
  {
    return this.status;
  }
  
  public final Metadata getTrailers()
  {
    return this.trailers;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/StatusException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */