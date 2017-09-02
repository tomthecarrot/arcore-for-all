package io.grpc.stub;

public abstract interface StreamObserver<V>
{
  public abstract void onCompleted();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(V paramV);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/StreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */