package com.google.internal.tango.foi.v1beta1;

import com.google.location.visualmapping.common.LinearAlgebra.TransformationProto;
import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface FoiOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getId();
  
  public abstract ByteString getIdBytes();
  
  public abstract ByteString getLocalizationContext();
  
  public abstract FoiRef getParentFoi();
  
  @Deprecated
  public abstract TileInfoProto getTileInfo();
  
  public abstract long getToken();
  
  public abstract LinearAlgebra.TransformationProto getTransformationFromParentFrame();
  
  public abstract boolean hasId();
  
  public abstract boolean hasLocalizationContext();
  
  public abstract boolean hasParentFoi();
  
  @Deprecated
  public abstract boolean hasTileInfo();
  
  public abstract boolean hasToken();
  
  public abstract boolean hasTransformationFromParentFrame();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/FoiOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */