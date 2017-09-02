package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class Ascii
{
  public static final byte ACK = 6;
  public static final byte BEL = 7;
  public static final byte BS = 8;
  public static final byte CAN = 24;
  public static final byte CR = 13;
  public static final byte DC1 = 17;
  public static final byte DC2 = 18;
  public static final byte DC3 = 19;
  public static final byte DC4 = 20;
  public static final byte DEL = 127;
  public static final byte DLE = 16;
  public static final byte EM = 25;
  public static final byte ENQ = 5;
  public static final byte EOT = 4;
  public static final byte ESC = 27;
  public static final byte ETB = 23;
  public static final byte ETX = 3;
  public static final byte FF = 12;
  public static final byte FS = 28;
  public static final byte GS = 29;
  public static final byte HT = 9;
  public static final byte LF = 10;
  public static final char MAX = '';
  public static final char MIN = '\000';
  public static final byte NAK = 21;
  public static final byte NL = 10;
  public static final byte NUL = 0;
  public static final byte RS = 30;
  public static final byte SI = 15;
  public static final byte SO = 14;
  public static final byte SOH = 1;
  public static final byte SP = 32;
  public static final byte SPACE = 32;
  public static final byte STX = 2;
  public static final byte SUB = 26;
  public static final byte SYN = 22;
  public static final byte US = 31;
  public static final byte VT = 11;
  public static final byte XOFF = 19;
  public static final byte XON = 17;
  
  @Beta
  public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int j = paramCharSequence1.length();
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if (j != paramCharSequence2.length()) {
      return false;
    }
    int i = 0;
    label31:
    char c1;
    char c2;
    if (i < j)
    {
      c1 = paramCharSequence1.charAt(i);
      c2 = paramCharSequence2.charAt(i);
      if (c1 != c2) {
        break label70;
      }
    }
    label70:
    int k;
    do
    {
      i += 1;
      break label31;
      break;
      k = getAlphaIndex(c1);
    } while ((k < 26) && (k == getAlphaIndex(c2)));
    return false;
  }
  
  private static int getAlphaIndex(char paramChar)
  {
    return (char)((paramChar | 0x20) - 'a');
  }
  
  public static boolean isLowerCase(char paramChar)
  {
    return (paramChar >= 'a') && (paramChar <= 'z');
  }
  
  public static boolean isUpperCase(char paramChar)
  {
    return (paramChar >= 'A') && (paramChar <= 'Z');
  }
  
  public static char toLowerCase(char paramChar)
  {
    char c = paramChar;
    if (isUpperCase(paramChar)) {
      c = (char)(paramChar ^ 0x20);
    }
    return c;
  }
  
  public static String toLowerCase(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof String)) {
      return toLowerCase((String)paramCharSequence);
    }
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(toLowerCase(paramCharSequence.charAt(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String toLowerCase(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (isUpperCase(paramString.charAt(i)))
        {
          paramString = paramString.toCharArray();
          while (i < j)
          {
            char c = paramString[i];
            if (isUpperCase(c)) {
              paramString[i] = ((char)(c ^ 0x20));
            }
            i += 1;
          }
          str = String.valueOf(paramString);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  public static char toUpperCase(char paramChar)
  {
    char c = paramChar;
    if (isLowerCase(paramChar)) {
      c = (char)(paramChar & 0x5F);
    }
    return c;
  }
  
  public static String toUpperCase(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof String)) {
      return toUpperCase((String)paramCharSequence);
    }
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(toUpperCase(paramCharSequence.charAt(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String toUpperCase(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (isLowerCase(paramString.charAt(i)))
        {
          paramString = paramString.toCharArray();
          while (i < j)
          {
            char c = paramString[i];
            if (isLowerCase(c)) {
              paramString[i] = ((char)(c & 0x5F));
            }
            i += 1;
          }
          str = String.valueOf(paramString);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  @Beta
  public static String truncate(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    Preconditions.checkNotNull(paramCharSequence);
    int i = paramInt - paramString.length();
    if (i >= 0) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "maxLength (%s) must be >= length of the truncation indicator (%s)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length()) });
      localObject = paramCharSequence;
      if (paramCharSequence.length() > paramInt) {
        break;
      }
      localObject = paramCharSequence.toString();
      if (((String)localObject).length() > paramInt) {
        break;
      }
      return (String)localObject;
    }
    return paramString;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Ascii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */