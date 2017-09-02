package com.google.protobuf;

import java.util.List;

public abstract interface ProtocolStringList
  extends List<String>
{
  public abstract List<ByteString> asByteStringList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ProtocolStringList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */