package com.google.protobuf;

public abstract interface AnyOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getTypeUrl();
  
  public abstract ByteString getTypeUrlBytes();
  
  public abstract ByteString getValue();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/AnyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */