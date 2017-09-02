package com.google.android.gms.common.util;

public class zzm
{
  private static final char[] zzaUU = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] zzaUV = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String zzb(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int j = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(j * 2);
    int i = 0;
    for (;;)
    {
      if ((i >= j) || ((paramBoolean) && (i == j - 1) && ((paramArrayOfByte[i] & 0xFF) == 0))) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(zzaUU[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(zzaUU[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
  }
  
  public static String zzu(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, false);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */