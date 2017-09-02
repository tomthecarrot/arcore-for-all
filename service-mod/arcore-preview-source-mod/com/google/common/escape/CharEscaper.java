package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class CharEscaper
  extends Escaper
{
  private static final int DEST_PAD_MULTIPLIER = 2;
  
  private static char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public String escape(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (escape(paramString.charAt(i)) != null) {
          str = escapeSlow(paramString, i);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  protected abstract char[] escape(char paramChar);
  
  protected final String escapeSlow(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = Platform.charBufferFromThreadLocal();
    int i = localObject1.length;
    int j = 0;
    int m = 0;
    int k = paramInt;
    paramInt = j;
    if (k < n)
    {
      char[] arrayOfChar = escape(paramString.charAt(k));
      if (arrayOfChar == null) {}
      for (;;)
      {
        k += 1;
        break;
        int i1 = arrayOfChar.length;
        int i2 = k - m;
        int i3 = paramInt + i2 + i1;
        localObject2 = localObject1;
        j = i;
        if (i < i3)
        {
          j = i3 + (n - k) * 2;
          localObject2 = growBuffer((char[])localObject1, paramInt, j);
        }
        i = paramInt;
        if (i2 > 0)
        {
          paramString.getChars(m, k, (char[])localObject2, paramInt);
          i = paramInt + i2;
        }
        paramInt = i;
        if (i1 > 0)
        {
          System.arraycopy(arrayOfChar, 0, localObject2, i, i1);
          paramInt = i + i1;
        }
        m = k + 1;
        localObject1 = localObject2;
        i = j;
      }
    }
    k = n - m;
    Object localObject2 = localObject1;
    j = paramInt;
    if (k > 0)
    {
      j = paramInt + k;
      localObject2 = localObject1;
      if (i < j) {
        localObject2 = growBuffer((char[])localObject1, paramInt, j);
      }
      paramString.getChars(m, n, (char[])localObject2, paramInt);
    }
    return new String((char[])localObject2, 0, j);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/CharEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */