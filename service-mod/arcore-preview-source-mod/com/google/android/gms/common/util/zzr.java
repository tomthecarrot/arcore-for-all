package com.google.android.gms.common.util;

public class zzr
{
  public static int zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 + (paramInt2 & 0xFFFFFFFC);
    int i = paramInt3;
    paramInt3 = paramInt1;
    paramInt1 = i;
    while (paramInt3 < j)
    {
      i = (paramArrayOfByte[paramInt3] & 0xFF | (paramArrayOfByte[(paramInt3 + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt3 + 2)] & 0xFF) << 16 | paramArrayOfByte[(paramInt3 + 3)] << 24) * -862048943;
      paramInt1 = (i >>> 17 | i << 15) * 461845907 ^ paramInt1;
      paramInt1 = -430675100 + (paramInt1 >>> 19 | paramInt1 << 13) * 5;
      paramInt3 += 4;
    }
    i = 0;
    paramInt3 = 0;
    switch (paramInt2 & 0x3)
    {
    }
    for (;;)
    {
      paramInt1 ^= paramInt2;
      paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
      paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
      return paramInt1 ^ paramInt1 >>> 16;
      paramInt3 = (paramArrayOfByte[(j + 2)] & 0xFF) << 16;
      i = paramInt3 | (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
      paramInt3 = (i | paramArrayOfByte[j] & 0xFF) * -862048943;
      paramInt1 = (paramInt3 >>> 17 | paramInt3 << 15) * 461845907 ^ paramInt1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */