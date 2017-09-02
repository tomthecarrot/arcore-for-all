package com.google.common.hash;

import java.nio.charset.Charset;

abstract class AbstractHasher
  implements Hasher
{
  public final Hasher putBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b = 1;; b = 0) {
      return putByte(b);
    }
  }
  
  public final Hasher putDouble(double paramDouble)
  {
    return putLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final Hasher putFloat(float paramFloat)
  {
    return putInt(Float.floatToRawIntBits(paramFloat));
  }
  
  public Hasher putString(CharSequence paramCharSequence, Charset paramCharset)
  {
    return putBytes(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public Hasher putUnencodedChars(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      putChar(paramCharSequence.charAt(i));
      i += 1;
    }
    return this;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/AbstractHasher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */