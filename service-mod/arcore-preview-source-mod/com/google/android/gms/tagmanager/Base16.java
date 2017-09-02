package com.google.android.gms.tagmanager;

public class Base16
{
  public static byte[] decode(String paramString)
  {
    int j = paramString.length();
    if (j % 2 != 0) {
      throw new IllegalArgumentException("purported base16 string has odd number of characters");
    }
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      int k = Character.digit(paramString.charAt(i), 16);
      int m = Character.digit(paramString.charAt(i + 1), 16);
      if ((k == -1) || (m == -1)) {
        throw new IllegalArgumentException("purported base16 string has illegal char");
      }
      arrayOfByte[(i / 2)] = ((byte)((k << 4) + m));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k & 0xF0) == 0) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(k & 0xFF));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/Base16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */