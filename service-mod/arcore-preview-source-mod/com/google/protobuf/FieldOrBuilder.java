package com.google.protobuf;

import java.util.List;

public abstract interface FieldOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Field.Cardinality getCardinality();
  
  public abstract int getCardinalityValue();
  
  public abstract String getDefaultValue();
  
  public abstract ByteString getDefaultValueBytes();
  
  public abstract String getJsonName();
  
  public abstract ByteString getJsonNameBytes();
  
  public abstract Field.Kind getKind();
  
  public abstract int getKindValue();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract int getNumber();
  
  public abstract int getOneofIndex();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
  
  public abstract boolean getPacked();
  
  public abstract String getTypeUrl();
  
  public abstract ByteString getTypeUrlBytes();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FieldOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */