package com.google.location.visualmapping.client;

import io.grpc.StatusRuntimeException;

public abstract interface GrpcErrorListener
{
  public abstract void onError(StatusRuntimeException paramStatusRuntimeException);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/GrpcErrorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */