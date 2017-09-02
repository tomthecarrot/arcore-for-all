package com.google.protobuf;

import java.util.List;

public abstract interface MethodOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
  
  public abstract boolean getRequestStreaming();
  
  public abstract String getRequestTypeUrl();
  
  public abstract ByteString getRequestTypeUrlBytes();
  
  public abstract boolean getResponseStreaming();
  
  public abstract String getResponseTypeUrl();
  
  public abstract ByteString getResponseTypeUrlBytes();
  
  public abstract Syntax getSyntax();
  
  public abstract int getSyntaxValue();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/MethodOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */