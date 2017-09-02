package io.grpc.internal;

import com.google.common.base.Preconditions;

final class MoreThrowables
{
  public static void throwIfUnchecked(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/MoreThrowables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */