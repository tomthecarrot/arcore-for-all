package com.google.android.gms.common.util;

public class zzs
{
  public static long zzdi(String paramString)
  {
    if (paramString.length() > 16) {
      throw new NumberFormatException(String.valueOf(paramString).length() + 46 + "Invalid input: " + paramString + " exceeds " + 16 + " characters");
    }
    if (paramString.length() == 16) {
      return Long.parseLong(paramString.substring(8), 16) | Long.parseLong(paramString.substring(0, 8), 16) << 32;
    }
    return Long.parseLong(paramString, 16);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */