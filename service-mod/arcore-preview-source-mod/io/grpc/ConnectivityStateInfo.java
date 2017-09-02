package io.grpc;

import com.google.common.base.Preconditions;

public final class ConnectivityStateInfo
{
  private final ConnectivityState state;
  private final Status status;
  
  private ConnectivityStateInfo(ConnectivityState paramConnectivityState, Status paramStatus)
  {
    this.state = ((ConnectivityState)Preconditions.checkNotNull(paramConnectivityState, "state is null"));
    this.status = ((Status)Preconditions.checkNotNull(paramStatus, "status is null"));
  }
  
  public static ConnectivityStateInfo forNonError(ConnectivityState paramConnectivityState)
  {
    if (paramConnectivityState != ConnectivityState.TRANSIENT_FAILURE) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "state is TRANSIENT_ERROR. Use forError() instead");
      return new ConnectivityStateInfo(paramConnectivityState, Status.OK);
    }
  }
  
  public static ConnectivityStateInfo forTransientFailure(Status paramStatus)
  {
    if (!paramStatus.isOk()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The error status must not be OK");
      return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, paramStatus);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectivityStateInfo)) {}
    do
    {
      return false;
      paramObject = (ConnectivityStateInfo)paramObject;
    } while ((!this.state.equals(((ConnectivityStateInfo)paramObject).state)) || (!this.status.equals(((ConnectivityStateInfo)paramObject).status)));
    return true;
  }
  
  public ConnectivityState getState()
  {
    return this.state;
  }
  
  public Status getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    return this.state.hashCode() ^ this.status.hashCode();
  }
  
  public String toString()
  {
    if (this.status.isOk()) {
      return this.state.toString();
    }
    return this.state + "(" + this.status + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ConnectivityStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */