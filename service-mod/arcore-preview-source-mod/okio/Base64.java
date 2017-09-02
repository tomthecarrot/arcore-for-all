package okio;

import java.io.UnsupportedEncodingException;

final class Base64
{
  private static final byte[] MAP = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] URL_MAP = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  
  public static byte[] decode(String paramString)
  {
    int i1 = paramString.length();
    int i;
    byte[] arrayOfByte;
    int m;
    int k;
    int i2;
    label76:
    int i3;
    int j;
    label111:
    int n;
    if (i1 > 0)
    {
      i = paramString.charAt(i1 - 1);
      if ((i == 61) || (i == 10) || (i == 13) || (i == 32) || (i == 9)) {}
    }
    else
    {
      arrayOfByte = new byte[(int)(i1 * 6L / 8L)];
      m = 0;
      k = 0;
      i2 = 0;
      i = 0;
      if (i2 >= i1) {
        break label339;
      }
      i3 = paramString.charAt(i2);
      if ((i3 < 65) || (i3 > 90)) {
        break label199;
      }
      j = i3 - 65;
      k = k << 6 | (byte)j;
      m += 1;
      n = m;
      j = k;
      if (m % 4 != 0) {
        break label449;
      }
      j = i + 1;
      arrayOfByte[i] = ((byte)(k >> 16));
      n = j + 1;
      arrayOfByte[j] = ((byte)(k >> 8));
      i = n + 1;
      arrayOfByte[n] = ((byte)k);
      j = k;
    }
    for (;;)
    {
      i2 += 1;
      k = j;
      break label76;
      i1 -= 1;
      break;
      label199:
      if ((i3 >= 97) && (i3 <= 122))
      {
        j = i3 - 71;
        break label111;
      }
      if ((i3 >= 48) && (i3 <= 57))
      {
        j = i3 + 4;
        break label111;
      }
      if ((i3 == 43) || (i3 == 45))
      {
        j = 62;
        break label111;
      }
      if ((i3 == 47) || (i3 == 95))
      {
        j = 63;
        break label111;
      }
      n = m;
      j = k;
      if (i3 != 10)
      {
        n = m;
        j = k;
        if (i3 != 13)
        {
          n = m;
          j = k;
          if (i3 != 32)
          {
            if (i3 == 9)
            {
              j = k;
              continue;
            }
            paramString = null;
            return paramString;
            label339:
            m %= 4;
            if (m == 1) {
              return null;
            }
            if (m == 2)
            {
              j = i + 1;
              arrayOfByte[i] = ((byte)(k << 12 >> 16));
            }
            for (i = j;; i = j)
            {
              paramString = arrayOfByte;
              if (i == arrayOfByte.length) {
                break;
              }
              paramString = new byte[i];
              System.arraycopy(arrayOfByte, 0, paramString, 0, i);
              return paramString;
              j = i;
              if (m == 3)
              {
                k <<= 6;
                m = i + 1;
                arrayOfByte[i] = ((byte)(k >> 16));
                j = m + 1;
                arrayOfByte[m] = ((byte)(k >> 8));
              }
            }
          }
        }
      }
      label449:
      m = n;
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, MAP);
  }
  
  private static String encode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) * 4 / 3];
    int k = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      int m = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[j] & 0xFF) >> 2)];
      i = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[((paramArrayOfByte1[j] & 0x3) << 4 | (paramArrayOfByte1[(j + 1)] & 0xFF) >> 4)];
      m = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[(j + 1)] & 0xF) << 2 | (paramArrayOfByte1[(j + 2)] & 0xFF) >> 6)];
      i = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[(paramArrayOfByte1[(j + 2)] & 0x3F)];
      j += 3;
    }
    switch (paramArrayOfByte1.length % 3)
    {
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(arrayOfByte, 0, i, "US-ASCII");
        return paramArrayOfByte1;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        throw new AssertionError(paramArrayOfByte1);
      }
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0x3) << 4)];
      j = i + 1;
      arrayOfByte[i] = 61;
      arrayOfByte[j] = 61;
      i = j + 1;
      continue;
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0x3) << 4 | (paramArrayOfByte1[(k + 1)] & 0xFF) >> 4)];
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[(k + 1)] & 0xF) << 2)];
      i = j + 1;
      arrayOfByte[j] = 61;
    }
  }
  
  public static String encodeUrl(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, URL_MAP);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */