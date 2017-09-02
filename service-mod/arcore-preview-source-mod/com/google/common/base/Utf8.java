package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class Utf8
{
  @CheckReturnValue
  public static int encodedLength(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = n;
    int j = 0;
    int k;
    int i;
    for (;;)
    {
      k = j;
      i = m;
      if (j >= n) {
        break;
      }
      k = j;
      i = m;
      if (paramCharSequence.charAt(j) >= '') {
        break;
      }
      j += 1;
    }
    for (;;)
    {
      j = i;
      if (k >= n) {
        break label98;
      }
      j = paramCharSequence.charAt(k);
      if (j >= 2048) {
        break;
      }
      i += (127 - j >>> 31);
      k += 1;
    }
    j = i + encodedLengthGeneral(paramCharSequence, k);
    label98:
    if (j < n) {
      throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (j + 4294967296L));
    }
    return j;
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) == n) {
              throw new IllegalArgumentException(unpairedSurrogateMsg(paramInt));
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  @CheckReturnValue
  public static boolean isWellFormed(byte[] paramArrayOfByte)
  {
    return isWellFormed(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @CheckReturnValue
  public static boolean isWellFormed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 + paramInt2;
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, paramArrayOfByte.length);
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] < 0) {
        return isWellFormedSlowPath(paramArrayOfByte, paramInt1, paramInt2);
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean isWellFormedSlowPath(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      if (paramInt1 >= paramInt2) {
        bool1 = true;
      }
      label11:
      int j;
      int k;
      int i;
      label75:
      label132:
      label148:
      do
      {
        do
        {
          do
          {
            return bool1;
            j = paramInt1 + 1;
            k = paramArrayOfByte[paramInt1];
            if (k >= 0) {
              break label256;
            }
            if (k >= -32) {
              break;
            }
            bool1 = bool2;
          } while (j == paramInt2);
          bool1 = bool2;
        } while (k < -62);
        i = j + 1;
        paramInt1 = i;
        if (paramArrayOfByte[j] <= -65) {
          break label253;
        }
        paramInt1 = i;
        do
        {
          do
          {
            do
            {
              return false;
              if (k >= -16) {
                break label167;
              }
              bool1 = bool2;
              if (j + 1 >= paramInt2) {
                break;
              }
              i = j + 1;
              j = paramArrayOfByte[j];
              paramInt1 = i;
            } while (j > -65);
            if (k != -32) {
              break label132;
            }
            paramInt1 = i;
          } while (j < -96);
          if (k != -19) {
            break label148;
          }
          paramInt1 = i;
        } while (-96 <= j);
        paramInt1 = i + 1;
        bool1 = bool2;
      } while (paramArrayOfByte[i] > -65);
      label167:
      label253:
      for (;;)
      {
        break;
        bool1 = bool2;
        if (j + 2 >= paramInt2) {
          break label11;
        }
        i = j + 1;
        j = paramArrayOfByte[j];
        paramInt1 = i;
        if (j > -65) {
          break label75;
        }
        paramInt1 = i;
        if ((k << 28) + (j + 112) >> 30 != 0) {
          break label75;
        }
        j = i + 1;
        bool1 = bool2;
        if (paramArrayOfByte[i] > -65) {
          break label11;
        }
        i = j + 1;
        paramInt1 = i;
        if (paramArrayOfByte[j] > -65) {
          break label75;
        }
        paramInt1 = i;
      }
      label256:
      paramInt1 = j;
    }
  }
  
  private static String unpairedSurrogateMsg(int paramInt)
  {
    return "Unpaired surrogate at index " + paramInt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */