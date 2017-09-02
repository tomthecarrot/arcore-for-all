package com.google.internal.tango.navigation.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface GetDirectionsRequestOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract PathfindingAlgorithm getAlgorithm();
  
  public abstract int getAlgorithmValue();
  
  public abstract Waypoint getGoal();
  
  public abstract ByteString getLocalizationContext();
  
  public abstract Waypoint getStart();
  
  public abstract Waypoint getWaypoints(int paramInt);
  
  public abstract int getWaypointsCount();
  
  public abstract List<Waypoint> getWaypointsList();
  
  public abstract boolean hasGoal();
  
  public abstract boolean hasStart();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/GetDirectionsRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */