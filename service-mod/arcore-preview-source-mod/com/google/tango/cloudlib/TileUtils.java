package com.google.tango.cloudlib;

import android.location.Location;
import com.google.common.geometry.S1Angle;
import com.google.common.geometry.S2Cap;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Region;
import com.google.common.geometry.S2RegionCoverer;
import com.google.common.geometry.S2RegionCoverer.Builder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TileUtils
{
  private static final double ACCURACY_BUFFER_METERS = 10.0D;
  private static final double DEFAULT_ACCURACY_RADIUS_METERS = 10.0D;
  private static final double EARTH_RADIUS_METERS = 6378137.0D;
  private static final double MAX_ACCURACY_METERS = 32.0D;
  private static final int REGION_COVERER_MAX_CELLS = 200;
  private static final int SEARCH_CELL_COUNT_MULTIPLIER = 4;
  private static final int SEARCH_ZOOM_LEVEL_BOOST = 1;
  private static final String TAG = "TileUtils";
  private static final int TILE_S2_ZOOM_LEVEL = 18;
  
  static long getAdfTileId(S2LatLng paramS2LatLng)
  {
    return S2CellId.fromLatLng(paramS2LatLng).parent(18).id();
  }
  
  static List<Long> getGridOfAdfTileIds(Location paramLocation)
  {
    long l = getAdfTileId(S2LatLng.fromDegrees(paramLocation.getLatitude(), paramLocation.getLongitude()));
    paramLocation = getNeighborAdfTileIds(l);
    paramLocation.add(0, Long.valueOf(l));
    return paramLocation;
  }
  
  static List<Long> getNeighborAdfTileIds(long paramLong)
  {
    Object localObject2 = new S2CellId(paramLong);
    Object localObject1 = new ArrayList(8);
    ((S2CellId)localObject2).getAllNeighbors(18, (List)localObject1);
    localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).add(Long.valueOf(((S2CellId)((Iterator)localObject1).next()).id()));
    }
    return (List<Long>)localObject2;
  }
  
  static double getPaddedAndClampedAccuracy(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      paramDouble = 10.0D;
    }
    for (;;)
    {
      return Math.min(paramDouble + 10.0D, 32.0D);
    }
  }
  
  public static List<Long> getTilesCoveringLocationBubble(S2LatLng paramS2LatLng, double paramDouble)
  {
    Object localObject2 = S2Cap.fromAxisAngle(paramS2LatLng.toPoint(), S1Angle.radians(paramDouble / 6378137.0D));
    S2RegionCoverer localS2RegionCoverer = S2RegionCoverer.builder().setMinLevel(18).setMaxLevel(19).setMaxCells(200).build();
    Object localObject1 = new ArrayList();
    localS2RegionCoverer.getCovering((S2Region)localObject2, (ArrayList)localObject1);
    localObject2 = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Set)localObject2).add(((S2CellId)((Iterator)localObject1).next()).parent(18));
    }
    localObject1 = new ArrayList(((Set)localObject2).size());
    long l = getAdfTileId(paramS2LatLng);
    ((ArrayList)localObject1).add(Long.valueOf(l));
    paramS2LatLng = ((Set)localObject2).iterator();
    while (paramS2LatLng.hasNext())
    {
      localObject2 = (S2CellId)paramS2LatLng.next();
      if (((S2CellId)localObject2).id() != l) {
        ((ArrayList)localObject1).add(Long.valueOf(((S2CellId)localObject2).id()));
      }
    }
    return (List<Long>)localObject1;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/TileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */