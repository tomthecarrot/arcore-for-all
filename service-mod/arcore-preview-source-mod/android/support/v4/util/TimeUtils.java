package android.support.v4.util;

import java.io.PrintWriter;

public final class TimeUtils
{
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3))) {
      return paramInt2 + 3;
    }
    if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2))) {
      return paramInt2 + 2;
    }
    if ((paramBoolean) || (paramInt1 > 0)) {
      return paramInt2 + 1;
    }
    return 0;
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L)
    {
      paramPrintWriter.print("--");
      return;
    }
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      paramInt = formatDurationLocked(paramLong, paramInt);
      paramPrintWriter.print(new String(sFormatStr, 0, paramInt));
      return;
    }
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt) {
      sFormatStr = new char[paramInt];
    }
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L)
    {
      while (paramInt - 1 < 0) {
        arrayOfChar[0] = ' ';
      }
      arrayOfChar[0] = '0';
      return 1;
    }
    int i;
    int i5;
    int n;
    int i1;
    int i2;
    int m;
    int i3;
    int i4;
    boolean bool;
    if (paramLong > 0L)
    {
      i = 43;
      i5 = (int)(paramLong % 1000L);
      k = (int)Math.floor(paramLong / 1000L);
      n = 0;
      i1 = 0;
      i2 = 0;
      j = k;
      if (k > 86400)
      {
        n = k / 86400;
        j = k - 86400 * n;
      }
      k = j;
      if (j > 3600)
      {
        i1 = j / 3600;
        k = j - i1 * 3600;
      }
      m = k;
      if (k > 60)
      {
        i2 = k / 60;
        m = k - i2 * 60;
      }
      i3 = 0;
      i4 = 0;
      if (paramInt == 0) {
        break label352;
      }
      j = accumField(n, 1, false, 0);
      if (j <= 0) {
        break label328;
      }
      bool = true;
      label201:
      j += accumField(i1, 1, bool, 2);
      if (j <= 0) {
        break label334;
      }
      bool = true;
      label223:
      j += accumField(i2, 1, bool, 2);
      if (j <= 0) {
        break label340;
      }
      bool = true;
      label245:
      k = j + accumField(m, 1, bool, 2);
      if (k <= 0) {
        break label346;
      }
    }
    label328:
    label334:
    label340:
    label346:
    for (int j = 3;; j = 0)
    {
      k += accumField(i5, 2, true, j) + 1;
      j = i4;
      for (;;)
      {
        i3 = j;
        if (k >= paramInt) {
          break;
        }
        arrayOfChar[j] = ' ';
        j += 1;
        k += 1;
      }
      i = 45;
      paramLong = -paramLong;
      break;
      bool = false;
      break label201;
      bool = false;
      break label223;
      bool = false;
      break label245;
    }
    label352:
    arrayOfChar[i3] = i;
    int k = i3 + 1;
    if (paramInt != 0)
    {
      paramInt = 1;
      n = printField(arrayOfChar, n, 'd', k, false, 0);
      if (n == k) {
        break label529;
      }
      bool = true;
      label395:
      if (paramInt == 0) {
        break label535;
      }
      j = 2;
      label402:
      n = printField(arrayOfChar, i1, 'h', n, bool, j);
      if (n == k) {
        break label541;
      }
      bool = true;
      label429:
      if (paramInt == 0) {
        break label547;
      }
      j = 2;
      label436:
      n = printField(arrayOfChar, i2, 'm', n, bool, j);
      if (n == k) {
        break label553;
      }
      bool = true;
      label463:
      if (paramInt == 0) {
        break label559;
      }
      j = 2;
      label470:
      j = printField(arrayOfChar, m, 's', n, bool, j);
      if ((paramInt == 0) || (j == k)) {
        break label565;
      }
    }
    label529:
    label535:
    label541:
    label547:
    label553:
    label559:
    label565:
    for (paramInt = 3;; paramInt = 0)
    {
      paramInt = printField(arrayOfChar, i5, 'm', j, true, paramInt);
      arrayOfChar[paramInt] = 's';
      return paramInt + 1;
      paramInt = 0;
      break;
      bool = false;
      break label395;
      j = 0;
      break label402;
      bool = false;
      break label429;
      j = 0;
      break label436;
      bool = false;
      break label463;
      j = 0;
      break label470;
    }
  }
  
  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      int j;
      if ((!paramBoolean) || (paramInt3 < 3))
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= 99) {}
      }
      else
      {
        i = paramInt1 / 100;
        paramArrayOfChar[paramInt2] = ((char)(i + 48));
        j = paramInt2 + 1;
        i = paramInt1 - i * 100;
      }
      if (((!paramBoolean) || (paramInt3 < 2)) && (i <= 9))
      {
        paramInt3 = i;
        paramInt1 = j;
        if (paramInt2 == j) {}
      }
      else
      {
        paramInt2 = i / 10;
        paramArrayOfChar[j] = ((char)(paramInt2 + 48));
        paramInt1 = j + 1;
        paramInt3 = i - paramInt2 * 10;
      }
      paramArrayOfChar[paramInt1] = ((char)(paramInt3 + 48));
      paramInt1 += 1;
      paramArrayOfChar[paramInt1] = paramChar;
      i = paramInt1 + 1;
    }
    return i;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/util/TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */