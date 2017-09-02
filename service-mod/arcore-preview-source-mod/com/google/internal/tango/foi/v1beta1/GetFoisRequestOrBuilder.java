package com.google.internal.tango.foi.v1beta1;

import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface GetFoisRequestOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getFoiIds(int paramInt);
  
  public abstract ByteString getFoiIdsBytes(int paramInt);
  
  public abstract int getFoiIdsCount();
  
  public abstract List<String> getFoiIdsList();
  
  public abstract ByteString getLocalizationContext(int paramInt);
  
  public abstract int getLocalizationContextCount();
  
  public abstract List<ByteString> getLocalizationContextList();
  
  @Deprecated
  public abstract TileInfoProto getTileInfo(int paramInt);
  
  @Deprecated
  public abstract int getTileInfoCount();
  
  @Deprecated
  public abstract List<TileInfoProto> getTileInfoList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/GetFoisRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */