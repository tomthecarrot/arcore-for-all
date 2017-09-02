package com.google.rpc;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface StatusOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract int getCode();
  
  public abstract Any getDetails(int paramInt);
  
  public abstract int getDetailsCount();
  
  public abstract List<Any> getDetailsList();
  
  public abstract String getMessage();
  
  public abstract ByteString getMessageBytes();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/rpc/StatusOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */