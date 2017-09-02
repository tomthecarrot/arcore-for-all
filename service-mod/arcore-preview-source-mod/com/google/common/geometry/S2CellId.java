package com.google.common.geometry;

import java.util.List;
import java.util.Locale;

public final class S2CellId
  implements Comparable<S2CellId>
{
  public static final int FACE_BITS = 3;
  private static final int INVERT_MASK = 2;
  private static final int LOOKUP_BITS = 4;
  private static final int[] LOOKUP_IJ;
  private static final int[] LOOKUP_POS = new int['Ѐ'];
  public static final int MAX_LEVEL = 30;
  public static final int MAX_SIZE = 1073741824;
  public static final long MAX_UNSIGNED = -1L;
  public static final int NUM_FACES = 6;
  public static final int POS_BITS = 61;
  private static final int SWAP_MASK = 1;
  private static final long WRAP_OFFSET = -4611686018427387904L;
  private static final long[] maxValueDivs = { 0L, 0L, Long.MAX_VALUE, 6148914691236517205L, 4611686018427387903L, 3689348814741910323L, 3074457345618258602L, 2635249153387078802L, 2305843009213693951L, 2049638230412172401L, 1844674407370955161L, 1676976733973595601L, 1537228672809129301L, 1418980313362273201L, 1317624576693539401L, 1229782938247303441L, 1152921504606846975L, 1085102592571150095L, 1024819115206086200L, 970881267037344821L, 922337203685477580L, 878416384462359600L, 838488366986797800L, 802032351030850070L, 768614336404564650L, 737869762948382064L, 709490156681136600L, 683212743470724133L, 658812288346769700L, 636094623231363848L, 614891469123651720L, 595056260442243600L, 576460752303423487L, 558992244657865200L, 542551296285575047L, 527049830677415760L, 512409557603043100L };
  private static final int[] maxValueMods = { 0, 0, 1, 0, 3, 0, 3, 1, 7, 6, 5, 4, 3, 2, 1, 0, 15, 0, 15, 16, 15, 15, 15, 5, 15, 15, 15, 24, 15, 23, 15, 15, 31, 15, 17, 15, 15 };
  private final long id;
  
  static
  {
    LOOKUP_IJ = new int['Ѐ'];
    initLookupCell(0, 0, 0, 0, 0, 0);
    initLookupCell(0, 0, 0, 1, 0, 1);
    initLookupCell(0, 0, 0, 2, 0, 2);
    initLookupCell(0, 0, 0, 3, 0, 3);
  }
  
  public strictfp S2CellId()
  {
    this.id = 0L;
  }
  
  public strictfp S2CellId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public static strictfp S2CellId begin(int paramInt)
  {
    return fromFacePosLevel(0, 0L, 0).childBegin(paramInt);
  }
  
  public static strictfp S2CellId end(int paramInt)
  {
    return fromFacePosLevel(5, 0L, 0).childEnd(paramInt);
  }
  
  private static strictfp S2Point faceSiTiToXYZ(int paramInt1, int paramInt2, int paramInt3)
  {
    return S2Projections.faceUvToXyz(paramInt1, S2Projections.stToUV(paramInt2 * 9.313225746154785E-10D), S2Projections.stToUV(paramInt3 * 9.313225746154785E-10D));
  }
  
  public static strictfp S2CellId fromFaceIJ(int paramInt1, int paramInt2, int paramInt3)
  {
    long[] arrayOfLong = new long[2];
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = (paramInt1 << 28);
    int i = paramInt1 & 0x1;
    paramInt1 = 7;
    while (paramInt1 >= 0)
    {
      i = getBits(arrayOfLong, paramInt2, paramInt3, paramInt1, i);
      paramInt1 -= 1;
    }
    return new S2CellId(((arrayOfLong[1] << 32) + arrayOfLong[0] << 1) + 1L);
  }
  
  public static strictfp S2CellId fromFaceIJSame(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {
      return fromFaceIJ(paramInt1, paramInt2, paramInt3);
    }
    return fromFaceIJWrap(paramInt1, paramInt2, paramInt3);
  }
  
  private static strictfp S2CellId fromFaceIJWrap(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = Math.max(-1, Math.min(1073741824, paramInt2));
    paramInt3 = Math.max(-1, Math.min(1073741824, paramInt3));
    Object localObject = S2Projections.faceUvToXyz(paramInt1, 9.313225746154785E-10D * ((paramInt2 << 1) + 1 - 1073741824), 9.313225746154785E-10D * ((paramInt3 << 1) + 1 - 1073741824));
    paramInt1 = S2Projections.xyzToFace((S2Point)localObject);
    localObject = S2Projections.validFaceXyzToUv(paramInt1, (S2Point)localObject);
    return fromFaceIJ(paramInt1, stToIJ(((R2Vector)localObject).x()), stToIJ(((R2Vector)localObject).y()));
  }
  
  public static strictfp S2CellId fromFacePosLevel(int paramInt1, long paramLong, int paramInt2)
  {
    return new S2CellId((paramInt1 << 61) + (1L | paramLong)).parent(paramInt2);
  }
  
  public static strictfp S2CellId fromLatLng(S2LatLng paramS2LatLng)
  {
    return fromPoint(paramS2LatLng.toPoint());
  }
  
  public static strictfp S2CellId fromPoint(S2Point paramS2Point)
  {
    int i = S2Projections.xyzToFace(paramS2Point);
    paramS2Point = S2Projections.validFaceXyzToUv(i, paramS2Point);
    return fromFaceIJ(i, stToIJ(S2Projections.uvToST(paramS2Point.x())), stToIJ(S2Projections.uvToST(paramS2Point.y())));
  }
  
  public static strictfp S2CellId fromToken(String paramString)
  {
    if (paramString == null) {
      throw new NumberFormatException("Null string in S2CellId.fromToken");
    }
    if (paramString.length() == 0) {
      throw new NumberFormatException("Empty string in S2CellId.fromToken");
    }
    if ((paramString.length() > 16) || ("X".equals(paramString))) {
      return none();
    }
    long l = 0L;
    int i = 0;
    while (i < 16)
    {
      int j = 0;
      if (i < paramString.length())
      {
        int k = Character.digit(paramString.charAt(i), 16);
        if (k == -1) {
          throw new NumberFormatException(paramString);
        }
        j = k;
        if (overflowInParse(l, k)) {
          throw new NumberFormatException("Too large for unsigned long: " + paramString);
        }
      }
      l = 16L * l + j;
      i += 1;
    }
    return new S2CellId(l);
  }
  
  private static strictfp int getBits(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = LOOKUP_POS[(paramInt4 + ((paramInt1 >> paramInt3 * 4 & 0xF) << 6) + ((paramInt2 >> paramInt3 * 4 & 0xF) << 2))];
    paramInt2 = paramInt3 >> 2;
    paramArrayOfLong[paramInt2] |= paramInt1 >> 2 << (paramInt3 & 0x3) * 2 * 4;
    return paramInt1 & 0x3;
  }
  
  private strictfp int getBits1(MutableInteger paramMutableInteger1, MutableInteger paramMutableInteger2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 7) {}
    for (int i = 2;; i = 4)
    {
      int j = (int)(this.id >>> paramInt1 * 2 * 4 + 1);
      paramInt2 = LOOKUP_IJ[(paramInt2 + ((j & (1 << i * 2) - 1) << 2))];
      paramMutableInteger1.setValue(paramMutableInteger1.intValue() + (paramInt2 >> 6 << paramInt1 * 4));
      paramMutableInteger2.setValue(paramMutableInteger2.intValue() + ((paramInt2 >> 2 & 0xF) << paramInt1 * 4));
      return paramInt2 & 0x3;
    }
  }
  
  private static strictfp void initLookupCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 == 4)
    {
      paramInt1 = (paramInt2 << 4) + paramInt3;
      LOOKUP_POS[((paramInt1 << 2) + paramInt4)] = ((paramInt5 << 2) + paramInt6);
      LOOKUP_IJ[((paramInt5 << 2) + paramInt4)] = ((paramInt1 << 2) + paramInt6);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < 4)
      {
        int j = S2.posToIJ(paramInt6, i);
        initLookupCell(paramInt1 + 1, (paramInt2 << 1) + (j >>> 1), (paramInt3 << 1) + (j & 0x1), paramInt4, (paramInt5 << 2) + i, paramInt6 ^ S2.posToOrientation(i));
        i += 1;
      }
    }
  }
  
  public static strictfp long lowestOnBitForLevel(int paramInt)
  {
    return 1L << (30 - paramInt) * 2;
  }
  
  public static strictfp S2CellId none()
  {
    return new S2CellId();
  }
  
  private static strictfp boolean overflowInParse(long paramLong, int paramInt)
  {
    return overflowInParse(paramLong, paramInt, 10);
  }
  
  private static strictfp boolean overflowInParse(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      if (paramLong >= maxValueDivs[paramInt2]) {
        break label29;
      }
      bool1 = false;
    }
    label29:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLong > maxValueDivs[paramInt2]);
      bool1 = bool2;
    } while (paramInt1 > maxValueMods[paramInt2]);
    return false;
  }
  
  public static strictfp S2CellId sentinel()
  {
    return new S2CellId(-1L);
  }
  
  private static strictfp int stToIJ(double paramDouble)
  {
    return (int)Math.max(0L, Math.min(1073741823L, Math.round(5.36870912E8D * paramDouble + 5.368709115E8D)));
  }
  
  public static strictfp boolean unsignedLongGreaterThan(long paramLong1, long paramLong2)
  {
    return paramLong1 - Long.MIN_VALUE > Long.MIN_VALUE + paramLong2;
  }
  
  public static strictfp boolean unsignedLongLessThan(long paramLong1, long paramLong2)
  {
    return paramLong1 - Long.MIN_VALUE < Long.MIN_VALUE + paramLong2;
  }
  
  public strictfp S2CellId childBegin()
  {
    long l = lowestOnBit();
    return new S2CellId(this.id - l + (l >>> 2));
  }
  
  public strictfp S2CellId childBegin(int paramInt)
  {
    return new S2CellId(this.id - lowestOnBit() + lowestOnBitForLevel(paramInt));
  }
  
  public strictfp S2CellId childEnd()
  {
    long l = lowestOnBit();
    return new S2CellId(this.id + l + (l >>> 2));
  }
  
  public strictfp S2CellId childEnd(int paramInt)
  {
    return new S2CellId(this.id + lowestOnBit() + lowestOnBitForLevel(paramInt));
  }
  
  public strictfp int childPosition(int paramInt)
  {
    return (int)(this.id >>> (30 - paramInt) * 2 + 1) & 0x3;
  }
  
  public strictfp int compareTo(S2CellId paramS2CellId)
  {
    if (unsignedLongLessThan(this.id, paramS2CellId.id)) {
      return -1;
    }
    if (unsignedLongGreaterThan(this.id, paramS2CellId.id)) {
      return 1;
    }
    return 0;
  }
  
  public strictfp boolean contains(S2CellId paramS2CellId)
  {
    return (paramS2CellId.greaterOrEquals(rangeMin())) && (paramS2CellId.lessOrEquals(rangeMax()));
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2CellId)) {}
    do
    {
      return false;
      paramObject = (S2CellId)paramObject;
    } while (id() != ((S2CellId)paramObject).id());
    return true;
  }
  
  public strictfp int face()
  {
    return (int)(this.id >>> 61);
  }
  
  public strictfp void getAllNeighbors(int paramInt, List<S2CellId> paramList)
  {
    MutableInteger localMutableInteger1 = new MutableInteger(0);
    MutableInteger localMutableInteger2 = new MutableInteger(0);
    int k = toFaceIJOrientation(localMutableInteger1, localMutableInteger2, null);
    int m = 1 << 30 - level();
    localMutableInteger1.setValue(localMutableInteger1.intValue() & -m);
    localMutableInteger2.setValue(localMutableInteger2.intValue() & -m);
    int n = 1 << 30 - paramInt;
    int j = -n;
    for (;;)
    {
      int i;
      int i1;
      int i2;
      if (j < 0) {
        if (localMutableInteger2.intValue() + j >= 0)
        {
          i = 1;
          i1 = localMutableInteger1.intValue();
          i2 = localMutableInteger2.intValue();
          if ((i == 0) || (localMutableInteger1.intValue() - m < 0)) {
            break label397;
          }
          bool = true;
          label133:
          paramList.add(fromFaceIJSame(k, i1 - n, i2 + j, bool).parent(paramInt));
          i1 = localMutableInteger1.intValue();
          i2 = localMutableInteger2.intValue();
          if ((i == 0) || (localMutableInteger1.intValue() + m >= 1073741824)) {
            break label403;
          }
        }
      }
      label296:
      label391:
      label397:
      label403:
      for (boolean bool = true;; bool = false)
      {
        paramList.add(fromFaceIJSame(k, i1 + m, i2 + j, bool).parent(paramInt));
        if (j < m) {
          break label409;
        }
        return;
        i = 0;
        break;
        if (j >= m)
        {
          if (localMutableInteger2.intValue() + j < 1073741824) {}
          for (i = 1;; i = 0) {
            break;
          }
        }
        i = 1;
        i1 = localMutableInteger1.intValue();
        i2 = localMutableInteger2.intValue();
        if (localMutableInteger2.intValue() - m >= 0)
        {
          bool = true;
          paramList.add(fromFaceIJSame(k, i1 + j, i2 - n, bool).parent(paramInt));
          i1 = localMutableInteger1.intValue();
          i2 = localMutableInteger2.intValue();
          if (localMutableInteger2.intValue() + m >= 1073741824) {
            break label391;
          }
        }
        for (bool = true;; bool = false)
        {
          paramList.add(fromFaceIJSame(k, i1 + j, i2 + m, bool).parent(paramInt));
          break;
          bool = false;
          break label296;
        }
        bool = false;
        break label133;
      }
      label409:
      j += n;
    }
  }
  
  public strictfp void getEdgeNeighbors(S2CellId[] paramArrayOfS2CellId)
  {
    boolean bool2 = true;
    MutableInteger localMutableInteger1 = new MutableInteger(0);
    MutableInteger localMutableInteger2 = new MutableInteger(0);
    int i = level();
    int j = 1 << 30 - i;
    int k = toFaceIJOrientation(localMutableInteger1, localMutableInteger2, null);
    int m = localMutableInteger1.intValue();
    int n = localMutableInteger2.intValue();
    if (localMutableInteger2.intValue() - j >= 0)
    {
      bool1 = true;
      paramArrayOfS2CellId[0] = fromFaceIJSame(k, m, n - j, bool1).parent(i);
      m = localMutableInteger1.intValue();
      n = localMutableInteger2.intValue();
      if (localMutableInteger1.intValue() + j >= 1073741824) {
        break label246;
      }
      bool1 = true;
      label122:
      paramArrayOfS2CellId[1] = fromFaceIJSame(k, m + j, n, bool1).parent(i);
      m = localMutableInteger1.intValue();
      n = localMutableInteger2.intValue();
      if (localMutableInteger2.intValue() + j >= 1073741824) {
        break label252;
      }
      bool1 = true;
      label171:
      paramArrayOfS2CellId[2] = fromFaceIJSame(k, m, n + j, bool1).parent(i);
      m = localMutableInteger1.intValue();
      n = localMutableInteger2.intValue();
      if (localMutableInteger1.intValue() - j < 0) {
        break label258;
      }
    }
    label246:
    label252:
    label258:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArrayOfS2CellId[3] = fromFaceIJSame(k, m - j, n, bool1).parent(i);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label122;
      bool1 = false;
      break label171;
    }
  }
  
  public strictfp void getVertexNeighbors(int paramInt, List<S2CellId> paramList)
  {
    boolean bool3 = true;
    MutableInteger localMutableInteger1 = new MutableInteger(0);
    MutableInteger localMutableInteger2 = new MutableInteger(0);
    int m = toFaceIJOrientation(localMutableInteger1, localMutableInteger2, null);
    int k = 1 << 30 - (paramInt + 1);
    int j = k << 1;
    int i;
    boolean bool2;
    label115:
    int n;
    if ((localMutableInteger1.intValue() & k) != 0)
    {
      i = j;
      if (localMutableInteger1.intValue() + j < 1073741824)
      {
        bool1 = true;
        if ((localMutableInteger2.intValue() & k) == 0) {
          break label297;
        }
        k = j;
        if (localMutableInteger2.intValue() + j >= 1073741824) {
          break label287;
        }
        bool2 = true;
        j = k;
        paramList.add(parent(paramInt));
        paramList.add(fromFaceIJSame(m, localMutableInteger1.intValue() + i, localMutableInteger2.intValue(), bool1).parent(paramInt));
        paramList.add(fromFaceIJSame(m, localMutableInteger1.intValue(), localMutableInteger2.intValue() + j, bool2).parent(paramInt));
        if ((bool1) || (bool2))
        {
          k = localMutableInteger1.intValue();
          n = localMutableInteger2.intValue();
          if ((!bool1) || (!bool2)) {
            break label329;
          }
        }
      }
    }
    label287:
    label297:
    label329:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramList.add(fromFaceIJSame(m, k + i, n + j, bool1).parent(paramInt));
      return;
      bool1 = false;
      break;
      i = -j;
      if (localMutableInteger1.intValue() - j >= 0) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      bool2 = false;
      j = k;
      break label115;
      k = -j;
      if (localMutableInteger2.intValue() - j >= 0) {}
      for (bool2 = true;; bool2 = false)
      {
        j = k;
        break;
      }
    }
  }
  
  public strictfp boolean greaterOrEquals(S2CellId paramS2CellId)
  {
    return (unsignedLongGreaterThan(this.id, paramS2CellId.id)) || (this.id == paramS2CellId.id);
  }
  
  public strictfp boolean greaterThan(S2CellId paramS2CellId)
  {
    return unsignedLongGreaterThan(this.id, paramS2CellId.id);
  }
  
  public strictfp int hashCode()
  {
    return (int)((this.id >>> 32) + this.id);
  }
  
  public strictfp long id()
  {
    return this.id;
  }
  
  public strictfp boolean intersects(S2CellId paramS2CellId)
  {
    return (paramS2CellId.rangeMin().lessOrEquals(rangeMax())) && (paramS2CellId.rangeMax().greaterOrEquals(rangeMin()));
  }
  
  public strictfp boolean isFace()
  {
    boolean bool = false;
    if ((this.id & lowestOnBitForLevel(0) - 1L) == 0L) {
      bool = true;
    }
    return bool;
  }
  
  public strictfp boolean isLeaf()
  {
    return ((int)this.id & 0x1) != 0;
  }
  
  public strictfp boolean isValid()
  {
    return (face() < 6) && ((lowestOnBit() & 0x1555555555555555) != 0L);
  }
  
  public strictfp boolean lessOrEquals(S2CellId paramS2CellId)
  {
    return (unsignedLongLessThan(this.id, paramS2CellId.id)) || (this.id == paramS2CellId.id);
  }
  
  public strictfp boolean lessThan(S2CellId paramS2CellId)
  {
    return unsignedLongLessThan(this.id, paramS2CellId.id);
  }
  
  public strictfp int level()
  {
    if (isLeaf())
    {
      i = 30;
      return i;
    }
    int j = (int)this.id;
    int i = -1;
    if (j != 0) {
      i = -1 + 16;
    }
    for (;;)
    {
      int k = j & -j;
      j = i;
      if ((k & 0x5555) != 0) {
        j = i + 8;
      }
      i = j;
      if ((0x550055 & k) != 0) {
        i = j + 4;
      }
      j = i;
      if ((0x5050505 & k) != 0) {
        j = i + 2;
      }
      i = j;
      if ((0x11111111 & k) == 0) {
        break;
      }
      return j + 1;
      j = (int)(this.id >>> 32);
    }
  }
  
  public strictfp long lowestOnBit()
  {
    return this.id & -this.id;
  }
  
  public strictfp S2CellId next()
  {
    return new S2CellId(this.id + (lowestOnBit() << 1));
  }
  
  public strictfp S2CellId nextWrap()
  {
    S2CellId localS2CellId = next();
    if (unsignedLongLessThan(localS2CellId.id, -4611686018427387904L)) {
      return localS2CellId;
    }
    return new S2CellId(localS2CellId.id + 4611686018427387904L);
  }
  
  public strictfp S2CellId parent()
  {
    long l = lowestOnBit() << 2;
    return new S2CellId(this.id & -l | l);
  }
  
  public strictfp S2CellId parent(int paramInt)
  {
    long l = lowestOnBitForLevel(paramInt);
    return new S2CellId(this.id & -l | l);
  }
  
  public strictfp long pos()
  {
    return this.id & 0x1FFFFFFFFFFFFFFF;
  }
  
  public strictfp S2CellId prev()
  {
    return new S2CellId(this.id - (lowestOnBit() << 1));
  }
  
  public strictfp S2CellId prevWrap()
  {
    S2CellId localS2CellId = prev();
    if (localS2CellId.id < -4611686018427387904L) {
      return localS2CellId;
    }
    return new S2CellId(localS2CellId.id - 4611686018427387904L);
  }
  
  public strictfp S2CellId rangeMax()
  {
    return new S2CellId(this.id + (lowestOnBit() - 1L));
  }
  
  public strictfp S2CellId rangeMin()
  {
    return new S2CellId(this.id - (lowestOnBit() - 1L));
  }
  
  public strictfp int toFaceIJOrientation(MutableInteger paramMutableInteger1, MutableInteger paramMutableInteger2, MutableInteger paramMutableInteger3)
  {
    int k = face();
    int i = k & 0x1;
    int j = 7;
    while (j >= 0)
    {
      i = getBits1(paramMutableInteger1, paramMutableInteger2, j, i);
      j -= 1;
    }
    if (paramMutableInteger3 != null)
    {
      j = i;
      if ((lowestOnBit() & 0x1111111111111110) != 0L) {
        j = i ^ 0x1;
      }
      paramMutableInteger3.setValue(j);
    }
    return k;
  }
  
  public strictfp S2LatLng toLatLng()
  {
    return new S2LatLng(toPointRaw());
  }
  
  public strictfp S2Point toPoint()
  {
    return S2Point.normalize(toPointRaw());
  }
  
  public strictfp S2Point toPointRaw()
  {
    int i = 0;
    MutableInteger localMutableInteger1 = new MutableInteger(0);
    MutableInteger localMutableInteger2 = new MutableInteger(0);
    int j = toFaceIJOrientation(localMutableInteger1, localMutableInteger2, null);
    if (isLeaf()) {
      i = 1;
    }
    for (;;)
    {
      return faceSiTiToXYZ(j, (localMutableInteger1.intValue() << 1) + i - 1073741824, (localMutableInteger2.intValue() << 1) + i - 1073741824);
      if (((localMutableInteger1.intValue() ^ (int)this.id >>> 2) & 0x1) != 0) {
        i = 2;
      }
    }
  }
  
  public strictfp String toString()
  {
    return "(face=" + face() + ", pos=" + Long.toHexString(pos()) + ", level=" + level() + ")";
  }
  
  public strictfp String toToken()
  {
    if (this.id == 0L) {
      return "X";
    }
    String str = Long.toHexString(this.id).toLowerCase(Locale.ENGLISH);
    StringBuilder localStringBuilder = new StringBuilder(16);
    int i = str.length();
    while (i < 16)
    {
      localStringBuilder.append('0');
      i += 1;
    }
    localStringBuilder.append(str);
    i = 16;
    while (i > 0)
    {
      if (localStringBuilder.charAt(i - 1) != '0') {
        return localStringBuilder.substring(0, i);
      }
      i -= 1;
    }
    throw new RuntimeException("Shouldn't make it here");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2CellId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */