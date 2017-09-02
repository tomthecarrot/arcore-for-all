package com.google.protobuf;

import java.util.List;

public abstract interface FieldMaskOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getPaths(int paramInt);
  
  public abstract ByteString getPathsBytes(int paramInt);
  
  public abstract int getPathsCount();
  
  public abstract List<String> getPathsList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FieldMaskOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */