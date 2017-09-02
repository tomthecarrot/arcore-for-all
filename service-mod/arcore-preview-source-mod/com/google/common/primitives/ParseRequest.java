package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
final class ParseRequest
{
  final int radix;
  final String rawValue;
  
  private ParseRequest(String paramString, int paramInt)
  {
    this.rawValue = paramString;
    this.radix = paramInt;
  }
  
  static ParseRequest fromString(String paramString)
  {
    if (paramString.length() == 0) {
      throw new NumberFormatException("empty string");
    }
    int i = paramString.charAt(0);
    if ((paramString.startsWith("0x")) || (paramString.startsWith("0X")))
    {
      paramString = paramString.substring(2);
      i = 16;
    }
    for (;;)
    {
      return new ParseRequest(paramString, i);
      if (i == 35)
      {
        paramString = paramString.substring(1);
        i = 16;
      }
      else if ((i == 48) && (paramString.length() > 1))
      {
        paramString = paramString.substring(1);
        i = 8;
      }
      else
      {
        i = 10;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/ParseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */