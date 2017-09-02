package com.google.protobuf;

public abstract interface ValueOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract boolean getBoolValue();
  
  public abstract Value.KindCase getKindCase();
  
  public abstract ListValue getListValue();
  
  public abstract NullValue getNullValue();
  
  public abstract int getNullValueValue();
  
  public abstract double getNumberValue();
  
  public abstract String getStringValue();
  
  public abstract ByteString getStringValueBytes();
  
  public abstract Struct getStructValue();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */