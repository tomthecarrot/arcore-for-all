package com.google.internal.tango.navigation.v1;

import com.google.location.visualmapping.common.LinearAlgebra.Vector3Proto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface WaypointOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract LinearAlgebra.Vector3Proto getEcefP();
  
  public abstract String getFoiId();
  
  public abstract ByteString getFoiIdBytes();
  
  public abstract Waypoint.PositionCase getPositionCase();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/WaypointOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */