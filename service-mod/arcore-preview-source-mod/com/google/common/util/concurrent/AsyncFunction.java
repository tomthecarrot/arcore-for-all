package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface AsyncFunction<I, O>
{
  public abstract ListenableFuture<O> apply(@Nullable I paramI)
    throws Exception;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AsyncFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */