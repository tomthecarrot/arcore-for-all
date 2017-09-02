package com.google.location.visualmapping.client.visualmapstore;

import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.location.visualmapping.visualmapstore.VisualMapWire.TileReadProto;

public abstract interface ReadTilesResponseListener
{
  public abstract void onCompleted();
  
  public abstract void onFinishTilesUpdate(long paramLong);
  
  public abstract void onTileToDelete(long paramLong, TileInfoProto paramTileInfoProto);
  
  public abstract void onTileToRefresh(long paramLong, TileInfoProto paramTileInfoProto);
  
  public abstract void onTileToSet(long paramLong, VisualMapWire.TileReadProto paramTileReadProto);
  
  public abstract void onTilesUnavailable(long paramLong);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/visualmapstore/ReadTilesResponseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */