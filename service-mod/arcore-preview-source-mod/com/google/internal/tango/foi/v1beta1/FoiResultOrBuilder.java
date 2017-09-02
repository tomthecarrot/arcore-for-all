package com.google.internal.tango.foi.v1beta1;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.rpc.Status;

public abstract interface FoiResultOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Foi getFoi();
  
  public abstract Status getStatus();
  
  public abstract boolean hasFoi();
  
  public abstract boolean hasStatus();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/FoiResultOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */