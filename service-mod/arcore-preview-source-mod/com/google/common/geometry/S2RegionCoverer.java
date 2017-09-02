package com.google.common.geometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public final class S2RegionCoverer
{
  public static final int DEFAULT_MAX_CELLS = 8;
  private static final S2Cell[] FACE_CELLS = new S2Cell[6];
  private PriorityQueue<QueueEntry> candidateQueue;
  private int candidatesCreatedCounter;
  private boolean interiorCovering;
  private int levelMod;
  private int maxCells;
  private int maxLevel;
  private int minLevel;
  S2Region region;
  ArrayList<S2CellId> result;
  
  static
  {
    int i = 0;
    while (i < 6)
    {
      FACE_CELLS[i] = S2Cell.fromFacePosLevel(i, 0, 0);
      i += 1;
    }
  }
  
  public strictfp S2RegionCoverer()
  {
    this.minLevel = 0;
    this.maxLevel = 30;
    this.levelMod = 1;
    this.maxCells = 8;
    this.region = null;
    this.result = new ArrayList();
    this.candidateQueue = new PriorityQueue(10, new QueueEntriesComparator());
  }
  
  private strictfp S2RegionCoverer(Builder paramBuilder)
  {
    this.minLevel = paramBuilder.getMinLevel();
    this.maxLevel = paramBuilder.getMaxLevel();
    this.levelMod = paramBuilder.getLevelMod();
    this.maxCells = paramBuilder.getMaxCells();
    this.region = null;
    this.result = new ArrayList();
    this.candidateQueue = new PriorityQueue(10, new QueueEntriesComparator());
  }
  
  private strictfp void addCandidate(Candidate paramCandidate)
  {
    if (paramCandidate == null) {
      return;
    }
    if (paramCandidate.isTerminal)
    {
      this.result.add(paramCandidate.cell.id());
      return;
    }
    if (paramCandidate.cell.level() < this.minLevel) {}
    for (int i = 1;; i = this.levelMod)
    {
      i = expandChildren(paramCandidate, paramCandidate.cell, i);
      if (paramCandidate.numChildren == 0) {
        break;
      }
      if ((this.interiorCovering) || (i != 1 << maxChildrenShift()) || (paramCandidate.cell.level() < this.minLevel)) {
        break label113;
      }
      Candidate.access$402(paramCandidate, true);
      addCandidate(paramCandidate);
      return;
    }
    label113:
    i = -(((paramCandidate.cell.level() << maxChildrenShift()) + paramCandidate.numChildren << maxChildrenShift()) + i);
    this.candidateQueue.add(new QueueEntry(i, paramCandidate));
  }
  
  public static strictfp Builder builder()
  {
    return new Builder(null);
  }
  
  private strictfp int expandChildren(Candidate paramCandidate, S2Cell paramS2Cell, int paramInt)
  {
    int k = paramInt - 1;
    S2Cell[] arrayOfS2Cell = new S2Cell[4];
    paramInt = 0;
    while (paramInt < 4)
    {
      arrayOfS2Cell[paramInt] = new S2Cell();
      paramInt += 1;
    }
    paramS2Cell.subdivide(arrayOfS2Cell);
    int j = 0;
    int i = 0;
    if (i < 4)
    {
      if (k > 0)
      {
        paramInt = j;
        if (this.region.mayIntersect(arrayOfS2Cell[i])) {
          paramInt = j + expandChildren(paramCandidate, arrayOfS2Cell[i], k);
        }
      }
      for (;;)
      {
        i += 1;
        j = paramInt;
        break;
        paramS2Cell = newCandidate(arrayOfS2Cell[i]);
        paramInt = j;
        if (paramS2Cell != null)
        {
          paramCandidate.children[Candidate.access$608(paramCandidate)] = paramS2Cell;
          paramInt = j;
          if (paramS2Cell.isTerminal) {
            paramInt = j + 1;
          }
        }
      }
    }
    return j;
  }
  
  private static strictfp void floodFill(S2Region paramS2Region, S2CellId paramS2CellId, ArrayList<S2CellId> paramArrayList)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    paramArrayList.clear();
    localHashSet.add(paramS2CellId);
    localArrayList.add(paramS2CellId);
    while (!localArrayList.isEmpty())
    {
      S2CellId localS2CellId = (S2CellId)localArrayList.get(localArrayList.size() - 1);
      localArrayList.remove(localArrayList.size() - 1);
      if (paramS2Region.mayIntersect(new S2Cell(localS2CellId)))
      {
        paramArrayList.add(localS2CellId);
        paramS2CellId = new S2CellId[4];
        localS2CellId.getEdgeNeighbors(paramS2CellId);
        int i = 0;
        while (i < 4)
        {
          localS2CellId = paramS2CellId[i];
          localHashSet.contains(localS2CellId);
          if (!localHashSet.contains(localS2CellId))
          {
            localArrayList.add(localS2CellId);
            localHashSet.add(localS2CellId);
          }
          i += 1;
        }
      }
    }
  }
  
  private strictfp void getCoveringInternal(S2Region paramS2Region)
  {
    boolean bool;
    if ((this.candidateQueue.isEmpty()) && (this.result.isEmpty()))
    {
      bool = true;
      Preconditions.checkState(bool);
      this.region = paramS2Region;
      this.candidatesCreatedCounter = 0;
      getInitialCandidates();
    }
    for (;;)
    {
      label42:
      if ((this.candidateQueue.isEmpty()) || ((this.interiorCovering) && (this.result.size() >= this.maxCells))) {
        break label206;
      }
      paramS2Region = ((QueueEntry)this.candidateQueue.poll()).candidate;
      int j;
      if ((paramS2Region.cell.level() >= this.minLevel) && (paramS2Region.numChildren != 1))
      {
        j = this.result.size();
        if (!this.interiorCovering) {
          break label174;
        }
      }
      label174:
      for (int i = 0;; i = this.candidateQueue.size())
      {
        if (i + j + paramS2Region.numChildren > this.maxCells) {
          break label185;
        }
        i = 0;
        while (i < paramS2Region.numChildren)
        {
          addCandidate(paramS2Region.children[i]);
          i += 1;
        }
        break label42;
        bool = false;
        break;
      }
      label185:
      if (!this.interiorCovering)
      {
        Candidate.access$402(paramS2Region, true);
        addCandidate(paramS2Region);
      }
    }
    label206:
    this.candidateQueue.clear();
    this.region = null;
  }
  
  private strictfp void getInitialCandidates()
  {
    if (this.maxCells >= 4)
    {
      S2Cap localS2Cap = this.region.getCapBound();
      int j = Math.min(S2Projections.MIN_WIDTH.getMaxLevel(2.0D * localS2Cap.angle().radians()), Math.min(maxLevel(), 29));
      i = j;
      if (levelMod() > 1)
      {
        i = j;
        if (j > minLevel()) {
          i = j - (j - minLevel()) % levelMod();
        }
      }
      if (i > 0)
      {
        ArrayList localArrayList = new ArrayList(4);
        S2CellId.fromPoint(localS2Cap.axis()).getVertexNeighbors(i, localArrayList);
        i = 0;
        while (i < localArrayList.size())
        {
          addCandidate(newCandidate(new S2Cell((S2CellId)localArrayList.get(i))));
          i += 1;
        }
      }
    }
    int i = 0;
    while (i < 6)
    {
      addCandidate(newCandidate(FACE_CELLS[i]));
      i += 1;
    }
  }
  
  public static strictfp void getSimpleCovering(S2Region paramS2Region, S2Point paramS2Point, int paramInt, ArrayList<S2CellId> paramArrayList)
  {
    floodFill(paramS2Region, S2CellId.fromPoint(paramS2Point).parent(paramInt), paramArrayList);
  }
  
  private strictfp int maxChildrenShift()
  {
    return this.levelMod * 2;
  }
  
  private strictfp Candidate newCandidate(S2Cell paramS2Cell)
  {
    if (!this.region.mayIntersect(paramS2Cell)) {
      return null;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramS2Cell.level() >= this.minLevel)
    {
      if (!this.interiorCovering) {
        break label127;
      }
      if (!this.region.contains(paramS2Cell)) {
        break label107;
      }
      bool1 = true;
    }
    for (;;)
    {
      Candidate localCandidate = new Candidate();
      Candidate.access$302(localCandidate, paramS2Cell);
      Candidate.access$402(localCandidate, bool1);
      if (!bool1) {
        Candidate.access$502(localCandidate, new Candidate[1 << maxChildrenShift()]);
      }
      this.candidatesCreatedCounter += 1;
      return localCandidate;
      label107:
      bool1 = bool2;
      if (paramS2Cell.level() + this.levelMod > this.maxLevel)
      {
        return null;
        label127:
        if (paramS2Cell.level() + this.levelMod <= this.maxLevel)
        {
          bool1 = bool2;
          if (!this.region.contains(paramS2Cell)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public strictfp S2CellUnion getCovering(S2Region paramS2Region)
  {
    S2CellUnion localS2CellUnion = new S2CellUnion();
    getCovering(paramS2Region, localS2CellUnion);
    return localS2CellUnion;
  }
  
  public strictfp void getCovering(S2Region paramS2Region, S2CellUnion paramS2CellUnion)
  {
    this.interiorCovering = false;
    getCoveringInternal(paramS2Region);
    paramS2CellUnion.initSwap(this.result);
  }
  
  public strictfp void getCovering(S2Region paramS2Region, ArrayList<S2CellId> paramArrayList)
  {
    getCovering(paramS2Region).denormalize(minLevel(), levelMod(), paramArrayList);
  }
  
  public strictfp S2CellUnion getInteriorCovering(S2Region paramS2Region)
  {
    S2CellUnion localS2CellUnion = new S2CellUnion();
    getInteriorCovering(paramS2Region, localS2CellUnion);
    return localS2CellUnion;
  }
  
  public strictfp void getInteriorCovering(S2Region paramS2Region, S2CellUnion paramS2CellUnion)
  {
    this.interiorCovering = true;
    getCoveringInternal(paramS2Region);
    paramS2CellUnion.initSwap(this.result);
  }
  
  public strictfp void getInteriorCovering(S2Region paramS2Region, ArrayList<S2CellId> paramArrayList)
  {
    getInteriorCovering(paramS2Region).denormalize(minLevel(), levelMod(), paramArrayList);
  }
  
  public strictfp int levelMod()
  {
    return this.levelMod;
  }
  
  public strictfp int maxCells()
  {
    return this.maxCells;
  }
  
  public strictfp int maxLevel()
  {
    return this.maxLevel;
  }
  
  public strictfp int minLevel()
  {
    return this.minLevel;
  }
  
  public strictfp void setLevelMod(int paramInt)
  {
    this.levelMod = Math.max(1, Math.min(3, paramInt));
  }
  
  public strictfp void setMaxCells(int paramInt)
  {
    this.maxCells = paramInt;
  }
  
  public strictfp void setMaxLevel(int paramInt)
  {
    this.maxLevel = Math.max(0, Math.min(30, paramInt));
  }
  
  public strictfp void setMinLevel(int paramInt)
  {
    this.minLevel = Math.max(0, Math.min(30, paramInt));
  }
  
  public static final class Builder
  {
    private static final int DEFAULT_MAX_CELLS = 8;
    private int levelMod = 1;
    private int maxCells = 8;
    private int maxLevel = 30;
    private int minLevel = 0;
    
    public strictfp S2RegionCoverer build()
    {
      return new S2RegionCoverer(this, null);
    }
    
    public strictfp int getLevelMod()
    {
      return this.levelMod;
    }
    
    public strictfp int getMaxCells()
    {
      return this.maxCells;
    }
    
    public strictfp int getMaxLevel()
    {
      return this.maxLevel;
    }
    
    public strictfp int getMinLevel()
    {
      return this.minLevel;
    }
    
    public strictfp Builder setLevelMod(int paramInt)
    {
      this.levelMod = Math.max(1, Math.min(3, paramInt));
      return this;
    }
    
    public strictfp Builder setMaxCells(int paramInt)
    {
      this.maxCells = paramInt;
      return this;
    }
    
    public strictfp Builder setMaxLevel(int paramInt)
    {
      this.maxLevel = Math.max(0, Math.min(30, paramInt));
      return this;
    }
    
    public strictfp Builder setMinLevel(int paramInt)
    {
      this.minLevel = Math.max(0, Math.min(30, paramInt));
      return this;
    }
  }
  
  static class Candidate
  {
    private S2Cell cell;
    private Candidate[] children;
    private boolean isTerminal;
    private int numChildren;
  }
  
  static class QueueEntriesComparator
    implements Comparator<S2RegionCoverer.QueueEntry>
  {
    public strictfp int compare(S2RegionCoverer.QueueEntry paramQueueEntry1, S2RegionCoverer.QueueEntry paramQueueEntry2)
    {
      if (S2RegionCoverer.QueueEntry.access$000(paramQueueEntry1) < S2RegionCoverer.QueueEntry.access$000(paramQueueEntry2)) {
        return 1;
      }
      if (S2RegionCoverer.QueueEntry.access$000(paramQueueEntry1) > S2RegionCoverer.QueueEntry.access$000(paramQueueEntry2)) {
        return -1;
      }
      return 0;
    }
  }
  
  static class QueueEntry
  {
    private S2RegionCoverer.Candidate candidate;
    private int id;
    
    public strictfp QueueEntry(int paramInt, S2RegionCoverer.Candidate paramCandidate)
    {
      this.id = paramInt;
      this.candidate = paramCandidate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2RegionCoverer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */