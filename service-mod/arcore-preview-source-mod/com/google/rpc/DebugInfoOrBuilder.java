package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface DebugInfoOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getDetail();
  
  public abstract ByteString getDetailBytes();
  
  public abstract String getStackEntries(int paramInt);
  
  public abstract ByteString getStackEntriesBytes(int paramInt);
  
  public abstract int getStackEntriesCount();
  
  public abstract List<String> getStackEntriesList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/rpc/DebugInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */