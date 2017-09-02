package com.google.android.gms.common.util;

import android.util.Base64;

public final class zzc
{
  public static byte[] decode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 0);
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 0);
  }
  
  public static byte[] zzdf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 10);
  }
  
  public static String zzs(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 10);
  }
  
  public static String zzt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */