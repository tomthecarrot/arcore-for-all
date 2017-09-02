package io.grpc.stub;

public abstract interface ClientResponseObserver<ReqT, RespT>
  extends StreamObserver<RespT>
{
  public abstract void beforeStart(ClientCallStreamObserver<ReqT> paramClientCallStreamObserver);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/ClientResponseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */