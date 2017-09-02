package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Escapers
{
  private static final Escaper NULL_ESCAPER = new CharEscaper()
  {
    public String escape(String paramAnonymousString)
    {
      return (String)Preconditions.checkNotNull(paramAnonymousString);
    }
    
    protected char[] escape(char paramAnonymousChar)
    {
      return null;
    }
  };
  
  static UnicodeEscaper asUnicodeEscaper(Escaper paramEscaper)
  {
    Preconditions.checkNotNull(paramEscaper);
    if ((paramEscaper instanceof UnicodeEscaper)) {
      return (UnicodeEscaper)paramEscaper;
    }
    if ((paramEscaper instanceof CharEscaper)) {
      return wrap((CharEscaper)paramEscaper);
    }
    throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + paramEscaper.getClass().getName());
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static String computeReplacement(CharEscaper paramCharEscaper, char paramChar)
  {
    return stringOrNull(paramCharEscaper.escape(paramChar));
  }
  
  public static String computeReplacement(UnicodeEscaper paramUnicodeEscaper, int paramInt)
  {
    return stringOrNull(paramUnicodeEscaper.escape(paramInt));
  }
  
  public static Escaper nullEscaper()
  {
    return NULL_ESCAPER;
  }
  
  private static String stringOrNull(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    return new String(paramArrayOfChar);
  }
  
  private static UnicodeEscaper wrap(CharEscaper paramCharEscaper)
  {
    new UnicodeEscaper()
    {
      protected char[] escape(int paramAnonymousInt)
      {
        if (paramAnonymousInt < 65536)
        {
          localObject = this.val$escaper.escape((char)paramAnonymousInt);
          return (char[])localObject;
        }
        Object localObject = new char[2];
        Character.toChars(paramAnonymousInt, (char[])localObject, 0);
        char[] arrayOfChar3 = this.val$escaper.escape(localObject[0]);
        char[] arrayOfChar2 = this.val$escaper.escape(localObject[1]);
        if ((arrayOfChar3 == null) && (arrayOfChar2 == null)) {
          return null;
        }
        if (arrayOfChar3 != null)
        {
          paramAnonymousInt = arrayOfChar3.length;
          if (arrayOfChar2 == null) {
            break label124;
          }
        }
        char[] arrayOfChar1;
        label124:
        for (int i = arrayOfChar2.length;; i = 1)
        {
          arrayOfChar1 = new char[paramAnonymousInt + i];
          if (arrayOfChar3 == null) {
            break label129;
          }
          i = 0;
          while (i < arrayOfChar3.length)
          {
            arrayOfChar1[i] = arrayOfChar3[i];
            i += 1;
          }
          paramAnonymousInt = 1;
          break;
        }
        label129:
        arrayOfChar1[0] = localObject[0];
        if (arrayOfChar2 != null)
        {
          i = 0;
          for (;;)
          {
            localObject = arrayOfChar1;
            if (i >= arrayOfChar2.length) {
              break;
            }
            arrayOfChar1[(paramAnonymousInt + i)] = arrayOfChar2[i];
            i += 1;
          }
        }
        arrayOfChar1[paramAnonymousInt] = localObject[1];
        return arrayOfChar1;
      }
    };
  }
  
  @Beta
  public static final class Builder
  {
    private final Map<Character, String> replacementMap = new HashMap();
    private char safeMax = 65535;
    private char safeMin = '\000';
    private String unsafeReplacement = null;
    
    public Builder addEscape(char paramChar, String paramString)
    {
      Preconditions.checkNotNull(paramString);
      this.replacementMap.put(Character.valueOf(paramChar), paramString);
      return this;
    }
    
    public Escaper build()
    {
      new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax)
      {
        private final char[] replacementChars;
        
        protected char[] escapeUnsafe(char paramAnonymousChar)
        {
          return this.replacementChars;
        }
      };
    }
    
    public Builder setSafeRange(char paramChar1, char paramChar2)
    {
      this.safeMin = paramChar1;
      this.safeMax = paramChar2;
      return this;
    }
    
    public Builder setUnsafeReplacement(@Nullable String paramString)
    {
      this.unsafeReplacement = paramString;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/Escapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */