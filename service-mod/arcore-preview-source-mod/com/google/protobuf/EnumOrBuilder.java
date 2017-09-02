package com.google.protobuf;

import java.util.List;

public abstract interface EnumOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract EnumValue getEnumvalue(int paramInt);
  
  public abstract int getEnumvalueCount();
  
  public abstract List<EnumValue> getEnumvalueList();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
  
  public abstract SourceContext getSourceContext();
  
  public abstract Syntax getSyntax();
  
  public abstract int getSyntaxValue();
  
  public abstract boolean hasSourceContext();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/EnumOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */