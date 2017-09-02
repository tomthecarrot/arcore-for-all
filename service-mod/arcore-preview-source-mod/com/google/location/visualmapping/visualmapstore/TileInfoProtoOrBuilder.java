package com.google.location.visualmapping.visualmapstore;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface TileInfoProtoOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getNamespace();
  
  public abstract ByteString getNamespaceBytes();
  
  public abstract S2CellId.S2CellIdProto getS2CellId();
  
  public abstract long getVersion();
  
  public abstract boolean hasNamespace();
  
  public abstract boolean hasS2CellId();
  
  public abstract boolean hasVersion();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/visualmapstore/TileInfoProtoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */