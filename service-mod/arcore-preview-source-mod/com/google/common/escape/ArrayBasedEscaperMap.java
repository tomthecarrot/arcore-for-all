package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap
{
  private static final char[][] EMPTY_REPLACEMENT_ARRAY = (char[][])Array.newInstance(Character.TYPE, new int[] { 0, 0 });
  private final char[][] replacementArray;
  
  private ArrayBasedEscaperMap(char[][] paramArrayOfChar)
  {
    this.replacementArray = paramArrayOfChar;
  }
  
  public static ArrayBasedEscaperMap create(Map<Character, String> paramMap)
  {
    return new ArrayBasedEscaperMap(createReplacementArray(paramMap));
  }
  
  @VisibleForTesting
  static char[][] createReplacementArray(Map<Character, String> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    Object localObject;
    if (paramMap.isEmpty())
    {
      localObject = EMPTY_REPLACEMENT_ARRAY;
      return (char[][])localObject;
    }
    char[][] arrayOfChar = new char[((Character)Collections.max(paramMap.keySet())).charValue() + '\001'][];
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      localObject = arrayOfChar;
      if (!localIterator.hasNext()) {
        break;
      }
      char c = ((Character)localIterator.next()).charValue();
      arrayOfChar[c] = ((String)paramMap.get(Character.valueOf(c))).toCharArray();
    }
  }
  
  char[][] getReplacementArray()
  {
    return this.replacementArray;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/ArrayBasedEscaperMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */