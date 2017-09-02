package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class Hashing
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private static int MAX_TABLE_SIZE = 1073741824;
  
  static int closedTableSize(int paramInt, double paramDouble)
  {
    paramInt = Math.max(paramInt, 2);
    int i = Integer.highestOneBit(paramInt);
    if (paramInt > (int)(i * paramDouble))
    {
      paramInt = i << 1;
      if (paramInt > 0) {
        return paramInt;
      }
      return MAX_TABLE_SIZE;
    }
    return i;
  }
  
  static boolean needsResizing(int paramInt1, int paramInt2, double paramDouble)
  {
    return (paramInt1 > paramInt2 * paramDouble) && (paramInt2 < MAX_TABLE_SIZE);
  }
  
  static int smear(int paramInt)
  {
    return 461845907 * Integer.rotateLeft(-862048943 * paramInt, 15);
  }
  
  static int smearedHash(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return smear(i);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */