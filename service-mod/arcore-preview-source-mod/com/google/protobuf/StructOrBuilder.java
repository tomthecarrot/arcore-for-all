package com.google.protobuf;

import java.util.Map;

public abstract interface StructOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract boolean containsFields(String paramString);
  
  @Deprecated
  public abstract Map<String, Value> getFields();
  
  public abstract int getFieldsCount();
  
  public abstract Map<String, Value> getFieldsMap();
  
  public abstract Value getFieldsOrDefault(String paramString, Value paramValue);
  
  public abstract Value getFieldsOrThrow(String paramString);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/StructOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */