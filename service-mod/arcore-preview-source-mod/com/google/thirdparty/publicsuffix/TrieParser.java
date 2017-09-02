package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.List;

@GwtCompatible
class TrieParser
{
  private static final Joiner PREFIX_JOINER = Joiner.on("");
  
  private static int doParseTrieToBuilder(List<CharSequence> paramList, CharSequence paramCharSequence, ImmutableMap.Builder<String, PublicSuffixType> paramBuilder)
  {
    int k = paramCharSequence.length();
    int i = 0;
    char c1 = '\000';
    for (;;)
    {
      char c2 = c1;
      if (i < k)
      {
        c1 = paramCharSequence.charAt(i);
        c2 = c1;
        if (c1 != '&')
        {
          c2 = c1;
          if (c1 != '?')
          {
            c2 = c1;
            if (c1 != '!')
            {
              c2 = c1;
              if (c1 != ':')
              {
                if (c1 != ',') {
                  break label259;
                }
                c2 = c1;
              }
            }
          }
        }
      }
      paramList.add(0, reverse(paramCharSequence.subSequence(0, i)));
      if ((c2 == '!') || (c2 == '?') || (c2 == ':') || (c2 == ','))
      {
        String str = PREFIX_JOINER.join(paramList);
        if (str.length() > 0) {
          paramBuilder.put(str, PublicSuffixType.fromCode(c2));
        }
      }
      i += 1;
      int j = i;
      if (c2 != '?')
      {
        j = i;
        if (c2 != ',')
        {
          do
          {
            j = i;
            if (i >= k) {
              break label248;
            }
            j = i + doParseTrieToBuilder(paramList, paramCharSequence.subSequence(i, k), paramBuilder);
            if (paramCharSequence.charAt(j) == '?') {
              break;
            }
            i = j;
          } while (paramCharSequence.charAt(j) != ',');
          j += 1;
        }
      }
      label248:
      paramList.remove(0);
      return j;
      label259:
      i += 1;
    }
  }
  
  static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence paramCharSequence)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j) {
      i += doParseTrieToBuilder(Lists.newLinkedList(), paramCharSequence.subSequence(i, j), localBuilder);
    }
    return localBuilder.build();
  }
  
  private static CharSequence reverse(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    if (j <= 1) {
      return paramCharSequence;
    }
    char[] arrayOfChar = new char[j];
    arrayOfChar[0] = paramCharSequence.charAt(j - 1);
    int i = 1;
    while (i < j)
    {
      arrayOfChar[i] = paramCharSequence.charAt(j - 1 - i);
      if (Character.isSurrogatePair(arrayOfChar[i], arrayOfChar[(i - 1)])) {
        swap(arrayOfChar, i - 1, i);
      }
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static void swap(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1];
    paramArrayOfChar[paramInt1] = paramArrayOfChar[paramInt2];
    paramArrayOfChar[paramInt2] = i;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/thirdparty/publicsuffix/TrieParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */