package com.google.instrumentation.stats;

final class StringUtil
{
  static final int MAX_LENGTH = 255;
  static final char UNPRINTABLE_CHAR_SUBSTITUTE = '_';
  
  StringUtil()
  {
    throw new AssertionError();
  }
  
  private static boolean isPrintableChar(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar <= '~');
  }
  
  private static boolean isPrintableString(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      if (!isPrintableChar(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static String sanitize(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (paramString.length() > 255) {
      str = paramString.substring(0, 255);
    }
    if (isPrintableString(str)) {
      return str;
    }
    paramString = new StringBuilder(str.length());
    if (i < str.length())
    {
      char c = str.charAt(i);
      if (isPrintableChar(c)) {}
      for (;;)
      {
        paramString.append(c);
        i += 1;
        break;
        c = '_';
      }
    }
    return paramString.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */