package com.google.internal.tango.navigation.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface DirectionsOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract PathfindingAlgorithm getAlgorithm();
  
  public abstract int getAlgorithmValue();
  
  public abstract Directions.Leg getLegs(int paramInt);
  
  public abstract int getLegsCount();
  
  public abstract List<Directions.Leg> getLegsList();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/DirectionsOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */