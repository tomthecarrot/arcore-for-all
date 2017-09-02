package com.google.protobuf;

import java.util.List;

public abstract interface EnumValueOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract int getNumber();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/EnumValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */