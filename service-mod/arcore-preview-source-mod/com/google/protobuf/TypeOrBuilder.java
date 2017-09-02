package com.google.protobuf;

import java.util.List;

public abstract interface TypeOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Field getFields(int paramInt);
  
  public abstract int getFieldsCount();
  
  public abstract List<Field> getFieldsList();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract String getOneofs(int paramInt);
  
  public abstract ByteString getOneofsBytes(int paramInt);
  
  public abstract int getOneofsCount();
  
  public abstract List<String> getOneofsList();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
  
  public abstract SourceContext getSourceContext();
  
  public abstract Syntax getSyntax();
  
  public abstract int getSyntaxValue();
  
  public abstract boolean hasSourceContext();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/TypeOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */