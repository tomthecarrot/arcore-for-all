package com.google.android.gms.common.util;

public final class zzn
{
  public static String zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      return null;
    }
    int i = 57;
    if (paramBoolean) {
      i = 75;
    }
    StringBuilder localStringBuilder = new StringBuilder(i * ((paramInt2 + 16 - 1) / 16));
    int k = paramInt2;
    int m = 0;
    int j = 0;
    if (k > 0)
    {
      if (j == 0) {
        if (paramInt2 < 65536)
        {
          localStringBuilder.append(String.format("%04X:", new Object[] { Integer.valueOf(paramInt1) }));
          i = paramInt1;
        }
      }
      int n;
      for (;;)
      {
        localStringBuilder.append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[paramInt1] & 0xFF) }));
        k -= 1;
        m = j + 1;
        if ((!paramBoolean) || ((m != 16) && (k != 0))) {
          break label340;
        }
        n = 16 - m;
        if (n <= 0) {
          break;
        }
        j = 0;
        while (j < n)
        {
          localStringBuilder.append("   ");
          j += 1;
        }
        localStringBuilder.append(String.format("%08X:", new Object[] { Integer.valueOf(paramInt1) }));
        i = paramInt1;
        continue;
        i = m;
        if (j == 8)
        {
          localStringBuilder.append(" -");
          i = m;
        }
      }
      if (n >= 8) {
        localStringBuilder.append("  ");
      }
      localStringBuilder.append("  ");
      j = 0;
      if (j < m)
      {
        char c = (char)paramArrayOfByte[(i + j)];
        if ((c >= ' ') && (c <= '~')) {}
        for (;;)
        {
          localStringBuilder.append(c);
          j += 1;
          break;
          c = '.';
        }
      }
      label340:
      if ((m != 16) && (k != 0)) {
        break label380;
      }
      localStringBuilder.append('\n');
    }
    label380:
    for (j = 0;; j = m)
    {
      paramInt1 += 1;
      m = i;
      break;
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */