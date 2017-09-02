package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class ArrayBasedUnicodeEscaper
  extends UnicodeEscaper
{
  private final char[][] replacements;
  private final int replacementsLength;
  private final int safeMax;
  private final char safeMaxChar;
  private final int safeMin;
  private final char safeMinChar;
  
  protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap paramArrayBasedEscaperMap, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    Preconditions.checkNotNull(paramArrayBasedEscaperMap);
    this.replacements = paramArrayBasedEscaperMap.getReplacementArray();
    this.replacementsLength = this.replacements.length;
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt2 < paramInt1)
    {
      i = -1;
      j = Integer.MAX_VALUE;
    }
    this.safeMin = j;
    this.safeMax = i;
    if (j >= 55296)
    {
      this.safeMinChar = 65535;
      this.safeMaxChar = '\000';
      return;
    }
    this.safeMinChar = ((char)j);
    this.safeMaxChar = ((char)Math.min(i, 55295));
  }
  
  protected ArrayBasedUnicodeEscaper(Map<Character, String> paramMap, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    this(ArrayBasedEscaperMap.create(paramMap), paramInt1, paramInt2, paramString);
  }
  
  public final String escape(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if (((j < this.replacementsLength) && (this.replacements[j] != null)) || (j > this.safeMaxChar) || (j < this.safeMinChar)) {
          str = escapeSlow(paramString, i);
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  protected final char[] escape(int paramInt)
  {
    if (paramInt < this.replacementsLength)
    {
      char[] arrayOfChar = this.replacements[paramInt];
      if (arrayOfChar != null) {
        return arrayOfChar;
      }
    }
    if ((paramInt >= this.safeMin) && (paramInt <= this.safeMax)) {
      return null;
    }
    return escapeUnsafe(paramInt);
  }
  
  protected abstract char[] escapeUnsafe(int paramInt);
  
  protected final int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if (((i >= this.replacementsLength) || (this.replacements[i] == null)) && (i <= this.safeMaxChar) && (i >= this.safeMinChar)) {}
      }
      else
      {
        return paramInt1;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/ArrayBasedUnicodeEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */