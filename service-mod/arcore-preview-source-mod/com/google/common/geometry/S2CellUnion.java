package com.google.common.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class S2CellUnion
  implements S2Region, Iterable<S2CellId>
{
  private ArrayList<S2CellId> cellIds = new ArrayList();
  
  private strictfp int indexedBinarySearch(List<S2CellId> paramList, S2CellId paramS2CellId, int paramInt)
  {
    int i = paramList.size() - 1;
    while (paramInt <= i)
    {
      int j = paramInt + i >> 1;
      int k = ((S2CellId)paramList.get(j)).compareTo(paramS2CellId);
      if (k < 0)
      {
        paramInt = j + 1;
      }
      else
      {
        i = j;
        if (k <= 0) {
          break label75;
        }
        i = j - 1;
      }
    }
    i = paramInt;
    label75:
    return i;
  }
  
  public strictfp double approxArea()
  {
    double d = 0.0D;
    Iterator localIterator = this.cellIds.iterator();
    while (localIterator.hasNext()) {
      d += new S2Cell((S2CellId)localIterator.next()).approxArea();
    }
    return d;
  }
  
  public strictfp double averageBasedArea()
  {
    return S2Cell.averageArea(30) * leafCellsCovered();
  }
  
  public strictfp S2CellId cellId(int paramInt)
  {
    return (S2CellId)this.cellIds.get(paramInt);
  }
  
  public strictfp ArrayList<S2CellId> cellIds()
  {
    return this.cellIds;
  }
  
  public strictfp S2Region clone()
  {
    S2CellUnion localS2CellUnion = new S2CellUnion();
    localS2CellUnion.initRawCellIds(new ArrayList(this.cellIds));
    return localS2CellUnion;
  }
  
  public strictfp boolean contains(S2Cell paramS2Cell)
  {
    return contains(paramS2Cell.id());
  }
  
  public strictfp boolean contains(S2CellId paramS2CellId)
  {
    int j = Collections.binarySearch(this.cellIds, paramS2CellId);
    int i = j;
    if (j < 0) {
      i = -j - 1;
    }
    if ((i < this.cellIds.size()) && (((S2CellId)this.cellIds.get(i)).rangeMin().lessOrEquals(paramS2CellId))) {
      return true;
    }
    if ((i != 0) && (((S2CellId)this.cellIds.get(i - 1)).rangeMax().greaterOrEquals(paramS2CellId))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public strictfp boolean contains(S2CellUnion paramS2CellUnion)
  {
    paramS2CellUnion = paramS2CellUnion.iterator();
    while (paramS2CellUnion.hasNext()) {
      if (!contains((S2CellId)paramS2CellUnion.next())) {
        return false;
      }
    }
    return true;
  }
  
  public strictfp boolean contains(S2Point paramS2Point)
  {
    return contains(S2CellId.fromPoint(paramS2Point));
  }
  
  public strictfp void denormalize(int paramInt1, int paramInt2, ArrayList<S2CellId> paramArrayList)
  {
    paramArrayList.clear();
    paramArrayList.ensureCapacity(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      S2CellId localS2CellId1 = (S2CellId)localIterator.next();
      int k = localS2CellId1.level();
      int j = Math.max(paramInt1, k);
      int i = j;
      if (paramInt2 > 1) {
        i = Math.min(30, j + (30 - (j - paramInt1)) % paramInt2);
      }
      if (i == k)
      {
        paramArrayList.add(localS2CellId1);
      }
      else
      {
        S2CellId localS2CellId2 = localS2CellId1.childEnd(i);
        for (localS2CellId1 = localS2CellId1.childBegin(i); !localS2CellId1.equals(localS2CellId2); localS2CellId1 = localS2CellId1.next()) {
          paramArrayList.add(localS2CellId1);
        }
      }
    }
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2CellUnion)) {
      return false;
    }
    paramObject = (S2CellUnion)paramObject;
    return this.cellIds.equals(((S2CellUnion)paramObject).cellIds);
  }
  
  public strictfp double exactArea()
  {
    double d = 0.0D;
    Iterator localIterator = this.cellIds.iterator();
    while (localIterator.hasNext()) {
      d += new S2Cell((S2CellId)localIterator.next()).exactArea();
    }
    return d;
  }
  
  public strictfp void expand(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long l = S2CellId.lowestOnBitForLevel(paramInt);
    int i = size() - 1;
    int j;
    do
    {
      S2CellId localS2CellId2 = cellId(i);
      j = i;
      S2CellId localS2CellId1 = localS2CellId2;
      if (localS2CellId2.lowestOnBit() < l)
      {
        localS2CellId2 = localS2CellId2.parent(paramInt);
        for (;;)
        {
          j = i;
          localS2CellId1 = localS2CellId2;
          if (i <= 0) {
            break;
          }
          j = i;
          localS2CellId1 = localS2CellId2;
          if (!localS2CellId2.contains(cellId(i - 1))) {
            break;
          }
          i -= 1;
        }
      }
      localArrayList.add(localS2CellId1);
      localS2CellId1.getAllNeighbors(paramInt, localArrayList);
      j -= 1;
      i = j;
    } while (j >= 0);
    initSwap(localArrayList);
  }
  
  public strictfp void expand(S1Angle paramS1Angle, int paramInt)
  {
    int i = 30;
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      i = Math.min(i, ((S2CellId)localIterator.next()).level());
    }
    int j = S2Projections.MIN_WIDTH.getMaxLevel(paramS1Angle.radians());
    if ((j == 0) && (paramS1Angle.radians() > S2Projections.MIN_WIDTH.getValue(0))) {
      expand(0);
    }
    expand(Math.min(i + paramInt, j));
  }
  
  public strictfp S2Cap getCapBound()
  {
    if (this.cellIds.isEmpty())
    {
      localObject2 = S2Cap.empty();
      return (S2Cap)localObject2;
    }
    Object localObject1 = new S2Point(0.0D, 0.0D, 0.0D);
    Object localObject2 = iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (S2CellId)((Iterator)localObject2).next();
      double d = S2Cell.averageArea(((S2CellId)localObject3).level());
      localObject1 = S2Point.add((S2Point)localObject1, S2Point.mul(((S2CellId)localObject3).toPoint(), d));
    }
    if (((S2Point)localObject1).equals(new S2Point(0.0D, 0.0D, 0.0D))) {}
    for (localObject1 = new S2Point(1.0D, 0.0D, 0.0D);; localObject1 = S2Point.normalize((S2Point)localObject1))
    {
      localObject1 = S2Cap.fromAxisHeight((S2Point)localObject1, 0.0D);
      localObject3 = iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((S2Cap)localObject1).addCap(new S2Cell((S2CellId)((Iterator)localObject3).next()).getCapBound());
      }
    }
  }
  
  public strictfp void getIntersection(S2CellUnion paramS2CellUnion, S2CellId paramS2CellId)
  {
    this.cellIds.clear();
    if (paramS2CellUnion.contains(paramS2CellId)) {
      this.cellIds.add(paramS2CellId);
    }
    for (;;)
    {
      return;
      int j = Collections.binarySearch(paramS2CellUnion.cellIds, paramS2CellId.rangeMin());
      int i = j;
      if (j < 0) {
        i = -j - 1;
      }
      paramS2CellId = paramS2CellId.rangeMax();
      j = paramS2CellUnion.cellIds.size();
      while ((i < j) && (((S2CellId)paramS2CellUnion.cellIds.get(i)).lessOrEquals(paramS2CellId)))
      {
        this.cellIds.add(paramS2CellUnion.cellIds.get(i));
        i += 1;
      }
    }
  }
  
  public strictfp void getIntersection(S2CellUnion paramS2CellUnion1, S2CellUnion paramS2CellUnion2)
  {
    this.cellIds.clear();
    int j = 0;
    int i = 0;
    while ((j < paramS2CellUnion1.cellIds.size()) && (i < paramS2CellUnion2.cellIds.size()))
    {
      S2CellId localS2CellId1 = paramS2CellUnion1.cellId(j).rangeMin();
      S2CellId localS2CellId2 = paramS2CellUnion2.cellId(i).rangeMin();
      int k;
      if (localS2CellId1.greaterThan(localS2CellId2))
      {
        if (paramS2CellUnion1.cellId(j).lessOrEquals(paramS2CellUnion2.cellId(i).rangeMax()))
        {
          this.cellIds.add(paramS2CellUnion1.cellId(j));
          j += 1;
        }
        else
        {
          k = indexedBinarySearch(paramS2CellUnion2.cellIds, localS2CellId1, i + 1);
          i = k;
          if (paramS2CellUnion1.cellId(j).lessOrEquals(paramS2CellUnion2.cellId(k - 1).rangeMax())) {
            i = k - 1;
          }
        }
      }
      else if (localS2CellId2.greaterThan(localS2CellId1))
      {
        if (paramS2CellUnion2.cellId(i).lessOrEquals(paramS2CellUnion1.cellId(j).rangeMax()))
        {
          this.cellIds.add(paramS2CellUnion2.cellId(i));
          i += 1;
        }
        else
        {
          k = indexedBinarySearch(paramS2CellUnion1.cellIds, localS2CellId2, j + 1);
          j = k;
          if (paramS2CellUnion2.cellId(i).lessOrEquals(paramS2CellUnion1.cellId(k - 1).rangeMax())) {
            j = k - 1;
          }
        }
      }
      else if (paramS2CellUnion1.cellId(j).lessThan(paramS2CellUnion2.cellId(i)))
      {
        this.cellIds.add(paramS2CellUnion1.cellId(j));
        j += 1;
      }
      else
      {
        this.cellIds.add(paramS2CellUnion2.cellId(i));
        i += 1;
      }
    }
  }
  
  public strictfp S2LatLngRect getRectBound()
  {
    S2LatLngRect localS2LatLngRect = S2LatLngRect.empty();
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localS2LatLngRect = localS2LatLngRect.union(new S2Cell((S2CellId)localIterator.next()).getRectBound());
    }
    return localS2LatLngRect;
  }
  
  public strictfp void getUnion(S2CellUnion paramS2CellUnion1, S2CellUnion paramS2CellUnion2)
  {
    this.cellIds.clear();
    this.cellIds.ensureCapacity(paramS2CellUnion1.size() + paramS2CellUnion2.size());
    this.cellIds.addAll(paramS2CellUnion1.cellIds);
    this.cellIds.addAll(paramS2CellUnion2.cellIds);
    normalize();
  }
  
  public strictfp int hashCode()
  {
    int i = 17;
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      i = i * 37 + ((S2CellId)localIterator.next()).hashCode();
    }
    return i;
  }
  
  public strictfp void initFromCellIds(ArrayList<S2CellId> paramArrayList)
  {
    initRawCellIds(paramArrayList);
    normalize();
  }
  
  public strictfp void initFromIds(ArrayList<Long> paramArrayList)
  {
    initRawIds(paramArrayList);
    normalize();
  }
  
  public strictfp void initRawCellIds(ArrayList<S2CellId> paramArrayList)
  {
    this.cellIds = paramArrayList;
  }
  
  public strictfp void initRawIds(ArrayList<Long> paramArrayList)
  {
    this.cellIds = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Long localLong = (Long)paramArrayList.next();
      this.cellIds.add(new S2CellId(localLong.longValue()));
    }
  }
  
  public strictfp void initRawSwap(ArrayList<S2CellId> paramArrayList)
  {
    this.cellIds = new ArrayList(paramArrayList);
    paramArrayList.clear();
  }
  
  public strictfp void initSwap(ArrayList<S2CellId> paramArrayList)
  {
    initRawSwap(paramArrayList);
    normalize();
  }
  
  public strictfp boolean intersects(S2CellId paramS2CellId)
  {
    int j = Collections.binarySearch(this.cellIds, paramS2CellId);
    int i = j;
    if (j < 0) {
      i = -j - 1;
    }
    if ((i < this.cellIds.size()) && (((S2CellId)this.cellIds.get(i)).rangeMin().lessOrEquals(paramS2CellId.rangeMax()))) {
      return true;
    }
    if ((i != 0) && (((S2CellId)this.cellIds.get(i - 1)).rangeMax().greaterOrEquals(paramS2CellId.rangeMin()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public strictfp boolean intersects(S2CellUnion paramS2CellUnion)
  {
    paramS2CellUnion = paramS2CellUnion.iterator();
    while (paramS2CellUnion.hasNext()) {
      if (intersects((S2CellId)paramS2CellUnion.next())) {
        return true;
      }
    }
    return false;
  }
  
  public strictfp Iterator<S2CellId> iterator()
  {
    return this.cellIds.iterator();
  }
  
  public strictfp long leafCellsCovered()
  {
    long l = 0L;
    Iterator localIterator = this.cellIds.iterator();
    while (localIterator.hasNext()) {
      l += (1L << (30 - ((S2CellId)localIterator.next()).level() << 1));
    }
    return l;
  }
  
  public strictfp boolean mayIntersect(S2Cell paramS2Cell)
  {
    return intersects(paramS2Cell.id());
  }
  
  public strictfp boolean normalize()
  {
    ArrayList localArrayList = new ArrayList(this.cellIds.size());
    localArrayList.ensureCapacity(this.cellIds.size());
    Collections.sort(this.cellIds);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      S2CellId localS2CellId2 = (S2CellId)localIterator.next();
      int i = localArrayList.size();
      if ((localArrayList.isEmpty()) || (!((S2CellId)localArrayList.get(i - 1)).contains(localS2CellId2)))
      {
        for (;;)
        {
          localS2CellId1 = localS2CellId2;
          if (localArrayList.isEmpty()) {
            break;
          }
          localS2CellId1 = localS2CellId2;
          if (!localS2CellId2.contains((S2CellId)localArrayList.get(localArrayList.size() - 1))) {
            break;
          }
          localArrayList.remove(localArrayList.size() - 1);
        }
        label151:
        localArrayList.remove(i - 1);
        localArrayList.remove(i - 2);
        localArrayList.remove(i - 3);
        S2CellId localS2CellId1 = localS2CellId1.parent();
        if (localArrayList.size() >= 3)
        {
          i = localArrayList.size();
          if ((((S2CellId)localArrayList.get(i - 3)).id() ^ ((S2CellId)localArrayList.get(i - 2)).id() ^ ((S2CellId)localArrayList.get(i - 1)).id()) == localS2CellId1.id()) {
            break label264;
          }
        }
        for (;;)
        {
          localArrayList.add(localS2CellId1);
          break;
          label264:
          long l1 = localS2CellId1.lowestOnBit() << 1;
          l1 = (l1 << 1) + l1 ^ 0xFFFFFFFFFFFFFFFF;
          long l2 = localS2CellId1.id() & l1;
          if (((((S2CellId)localArrayList.get(i - 3)).id() & l1) == l2) && ((((S2CellId)localArrayList.get(i - 2)).id() & l1) == l2) && ((((S2CellId)localArrayList.get(i - 1)).id() & l1) == l2)) {
            if (!localS2CellId1.isFace()) {
              break label151;
            }
          }
        }
      }
    }
    if (localArrayList.size() < size())
    {
      initRawSwap(localArrayList);
      return true;
    }
    return false;
  }
  
  public strictfp void pack()
  {
    this.cellIds.trimToSize();
  }
  
  public strictfp int size()
  {
    return this.cellIds.size();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2CellUnion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */