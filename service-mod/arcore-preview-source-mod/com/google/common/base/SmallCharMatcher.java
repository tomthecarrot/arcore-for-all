package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

@GwtIncompatible("no precomputation is done in GWT")
final class SmallCharMatcher
  extends CharMatcher.NamedFastMatcher
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private static final double DESIRED_LOAD_FACTOR = 0.5D;
  static final int MAX_SIZE = 1023;
  private final boolean containsZero;
  private final long filter;
  private final char[] table;
  
  private SmallCharMatcher(char[] paramArrayOfChar, long paramLong, boolean paramBoolean, String paramString)
  {
    super(paramString);
    this.table = paramArrayOfChar;
    this.filter = paramLong;
    this.containsZero = paramBoolean;
  }
  
  private boolean checkFilter(int paramInt)
  {
    return 1L == (this.filter >> paramInt & 1L);
  }
  
  @VisibleForTesting
  static int chooseTableSize(int paramInt)
  {
    int j;
    if (paramInt == 1)
    {
      j = 2;
      return j;
    }
    int i = Integer.highestOneBit(paramInt - 1) << 1;
    for (;;)
    {
      j = i;
      if (i * 0.5D >= paramInt) {
        break;
      }
      i <<= 1;
    }
  }
  
  static CharMatcher from(BitSet paramBitSet, String paramString)
  {
    long l = 0L;
    int i = paramBitSet.cardinality();
    boolean bool = paramBitSet.get(0);
    char[] arrayOfChar = new char[chooseTableSize(i)];
    int k = arrayOfChar.length - 1;
    i = paramBitSet.nextSetBit(0);
    if (i != -1)
    {
      l |= 1L << i;
      for (int j = smear(i) & k;; j = j + 1 & k) {
        if (arrayOfChar[j] == 0)
        {
          arrayOfChar[j] = ((char)i);
          i = paramBitSet.nextSetBit(i + 1);
          break;
        }
      }
    }
    return new SmallCharMatcher(arrayOfChar, l, bool, paramString);
  }
  
  static int smear(int paramInt)
  {
    return 461845907 * Integer.rotateLeft(-862048943 * paramInt, 15);
  }
  
  public boolean matches(char paramChar)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramChar == 0) {
      bool1 = this.containsZero;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!checkFilter(paramChar));
    int m = this.table.length - 1;
    int j = smear(paramChar) & m;
    int i = j;
    int k;
    do
    {
      bool1 = bool2;
      if (this.table[i] == 0) {
        break;
      }
      if (this.table[i] == paramChar) {
        return true;
      }
      k = i + 1 & m;
      i = k;
    } while (k != j);
    return false;
  }
  
  void setBits(BitSet paramBitSet)
  {
    if (this.containsZero) {
      paramBitSet.set(0);
    }
    char[] arrayOfChar = this.table;
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfChar[i];
      if (k != 0) {
        paramBitSet.set(k);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/SmallCharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */