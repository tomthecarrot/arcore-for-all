package io.grpc.stub;

import com.google.common.base.Preconditions;
import java.util.Iterator;

public final class StreamObservers
{
  public static <V> void copyWithFlowControl(Iterable<V> paramIterable, CallStreamObserver<V> paramCallStreamObserver)
  {
    Preconditions.checkNotNull(paramIterable, "source");
    copyWithFlowControl(paramIterable.iterator(), paramCallStreamObserver);
  }
  
  public static <V> void copyWithFlowControl(final Iterator<V> paramIterator, CallStreamObserver<V> paramCallStreamObserver)
  {
    Preconditions.checkNotNull(paramIterator, "source");
    Preconditions.checkNotNull(paramCallStreamObserver, "target");
    paramCallStreamObserver.setOnReadyHandler(new Runnable()
    {
      public void run()
      {
        while ((StreamObservers.this.isReady()) && (paramIterator.hasNext())) {
          StreamObservers.this.onNext(paramIterator.next());
        }
        if (!paramIterator.hasNext()) {
          StreamObservers.this.onCompleted();
        }
      }
    });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/StreamObservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */