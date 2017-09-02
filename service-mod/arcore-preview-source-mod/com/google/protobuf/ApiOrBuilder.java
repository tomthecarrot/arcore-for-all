package com.google.protobuf;

import java.util.List;

public abstract interface ApiOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Method getMethods(int paramInt);
  
  public abstract int getMethodsCount();
  
  public abstract List<Method> getMethodsList();
  
  public abstract Mixin getMixins(int paramInt);
  
  public abstract int getMixinsCount();
  
  public abstract List<Mixin> getMixinsList();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract Option getOptions(int paramInt);
  
  public abstract int getOptionsCount();
  
  public abstract List<Option> getOptionsList();
  
  public abstract SourceContext getSourceContext();
  
  public abstract Syntax getSyntax();
  
  public abstract int getSyntaxValue();
  
  public abstract String getVersion();
  
  public abstract ByteString getVersionBytes();
  
  public abstract boolean hasSourceContext();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ApiOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */