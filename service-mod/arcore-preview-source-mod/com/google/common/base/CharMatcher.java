package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(emulated=true)
public abstract class CharMatcher
  implements Predicate<Character>
{
  public static final CharMatcher ANY = any();
  public static final CharMatcher ASCII;
  public static final CharMatcher BREAKING_WHITESPACE;
  public static final CharMatcher DIGIT;
  private static final int DISTINCT_CHARS = 65536;
  public static final CharMatcher INVISIBLE;
  public static final CharMatcher JAVA_DIGIT;
  public static final CharMatcher JAVA_ISO_CONTROL;
  public static final CharMatcher JAVA_LETTER;
  public static final CharMatcher JAVA_LETTER_OR_DIGIT;
  public static final CharMatcher JAVA_LOWER_CASE;
  public static final CharMatcher JAVA_UPPER_CASE;
  public static final CharMatcher NONE = none();
  public static final CharMatcher SINGLE_WIDTH;
  public static final CharMatcher WHITESPACE = ;
  
  static
  {
    BREAKING_WHITESPACE = breakingWhitespace();
    ASCII = ascii();
    DIGIT = digit();
    JAVA_DIGIT = javaDigit();
    JAVA_LETTER = javaLetter();
    JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
    JAVA_UPPER_CASE = javaUpperCase();
    JAVA_LOWER_CASE = javaLowerCase();
    JAVA_ISO_CONTROL = javaIsoControl();
    INVISIBLE = invisible();
    SINGLE_WIDTH = singleWidth();
  }
  
  public static CharMatcher any()
  {
    return Any.INSTANCE;
  }
  
  public static CharMatcher anyOf(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      return new AnyOf(paramCharSequence);
    case 0: 
      return none();
    case 1: 
      return is(paramCharSequence.charAt(0));
    }
    return isEither(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
  }
  
  public static CharMatcher ascii()
  {
    return Ascii.INSTANCE;
  }
  
  public static CharMatcher breakingWhitespace()
  {
    return BreakingWhitespace.INSTANCE;
  }
  
  public static CharMatcher digit()
  {
    return Digit.INSTANCE;
  }
  
  private String finishCollapseFrom(CharSequence paramCharSequence, int paramInt1, int paramInt2, char paramChar, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (matches(c))
      {
        paramBoolean = bool;
        if (!bool) {
          paramStringBuilder.append(paramChar);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramInt1 += 1;
        bool = paramBoolean;
        break;
        paramStringBuilder.append(c);
      }
    }
    return paramStringBuilder.toString();
  }
  
  public static CharMatcher forPredicate(Predicate<? super Character> paramPredicate)
  {
    if ((paramPredicate instanceof CharMatcher)) {
      return (CharMatcher)paramPredicate;
    }
    return new ForPredicate(paramPredicate);
  }
  
  public static CharMatcher inRange(char paramChar1, char paramChar2)
  {
    return new InRange(paramChar1, paramChar2);
  }
  
  public static CharMatcher invisible()
  {
    return Invisible.INSTANCE;
  }
  
  public static CharMatcher is(char paramChar)
  {
    return new Is(paramChar);
  }
  
  private static IsEither isEither(char paramChar1, char paramChar2)
  {
    return new IsEither(paramChar1, paramChar2);
  }
  
  public static CharMatcher isNot(char paramChar)
  {
    return new IsNot(paramChar);
  }
  
  @GwtIncompatible("SmallCharMatcher")
  private static boolean isSmall(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= 1023) && (paramInt2 > paramInt1 * 4 * 16);
  }
  
  public static CharMatcher javaDigit()
  {
    return JavaDigit.INSTANCE;
  }
  
  public static CharMatcher javaIsoControl()
  {
    return JavaIsoControl.INSTANCE;
  }
  
  public static CharMatcher javaLetter()
  {
    return JavaLetter.INSTANCE;
  }
  
  public static CharMatcher javaLetterOrDigit()
  {
    return JavaLetterOrDigit.INSTANCE;
  }
  
  public static CharMatcher javaLowerCase()
  {
    return JavaLowerCase.INSTANCE;
  }
  
  public static CharMatcher javaUpperCase()
  {
    return JavaUpperCase.INSTANCE;
  }
  
  public static CharMatcher none()
  {
    return None.INSTANCE;
  }
  
  public static CharMatcher noneOf(CharSequence paramCharSequence)
  {
    return anyOf(paramCharSequence).negate();
  }
  
  @GwtIncompatible("java.util.BitSet")
  private static CharMatcher precomputedPositive(int paramInt, BitSet paramBitSet, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (isSmall(paramInt, paramBitSet.length())) {
        return SmallCharMatcher.from(paramBitSet, paramString);
      }
      break;
    case 0: 
      return none();
    case 1: 
      return is((char)paramBitSet.nextSetBit(0));
    case 2: 
      char c = (char)paramBitSet.nextSetBit(0);
      return isEither(c, (char)paramBitSet.nextSetBit(c + '\001'));
    }
    return new BitSetMatcher(paramBitSet, paramString, null);
  }
  
  private static String showCharacter(char paramChar)
  {
    char[] arrayOfChar = new char[6];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 92;
    char[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 117;
    char[] tmp18_12 = tmp12_6;
    tmp18_12[2] = 0;
    char[] tmp24_18 = tmp18_12;
    tmp24_18[3] = 0;
    char[] tmp30_24 = tmp24_18;
    tmp30_24[4] = 0;
    char[] tmp36_30 = tmp30_24;
    tmp36_30[5] = 0;
    tmp36_30;
    char c = '\000';
    int i = paramChar;
    paramChar = c;
    while (paramChar < '\004')
    {
      arrayOfChar[('\005' - paramChar)] = "0123456789ABCDEF".charAt(i & 0xF);
      i = (char)(i >> 4);
      paramChar += '\001';
    }
    return String.copyValueOf(arrayOfChar);
  }
  
  public static CharMatcher singleWidth()
  {
    return SingleWidth.INSTANCE;
  }
  
  public static CharMatcher whitespace()
  {
    return Whitespace.INSTANCE;
  }
  
  public CharMatcher and(CharMatcher paramCharMatcher)
  {
    return new And(this, paramCharMatcher);
  }
  
  @Deprecated
  public boolean apply(Character paramCharacter)
  {
    return matches(paramCharacter.charValue());
  }
  
  @CheckReturnValue
  public String collapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      char c = paramCharSequence.charAt(i);
      int j = i;
      if (matches(c))
      {
        if ((c == paramChar) && ((i == k - 1) || (!matches(paramCharSequence.charAt(i + 1))))) {
          j = i + 1;
        }
      }
      else
      {
        i = j + 1;
        continue;
      }
      return finishCollapseFrom(paramCharSequence, i + 1, k, paramChar, new StringBuilder(k).append(paramCharSequence.subSequence(0, i)).append(paramChar), true);
    }
    return paramCharSequence.toString();
  }
  
  public int countIn(CharSequence paramCharSequence)
  {
    int j = 0;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int k = j;
      if (matches(paramCharSequence.charAt(i))) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int indexIn(CharSequence paramCharSequence)
  {
    return indexIn(paramCharSequence, 0);
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, i);
    while (paramInt < i)
    {
      if (matches(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public int lastIndexIn(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (matches(paramCharSequence.charAt(i))) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public abstract boolean matches(char paramChar);
  
  public boolean matchesAllOf(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!matches(paramCharSequence.charAt(i))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public boolean matchesAnyOf(CharSequence paramCharSequence)
  {
    return !matchesNoneOf(paramCharSequence);
  }
  
  public boolean matchesNoneOf(CharSequence paramCharSequence)
  {
    return indexIn(paramCharSequence) == -1;
  }
  
  public CharMatcher negate()
  {
    return new Negated(this);
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    return new Or(this, paramCharMatcher);
  }
  
  public CharMatcher precomputed()
  {
    return Platform.precomputeCharMatcher(this);
  }
  
  @GwtIncompatible("java.util.BitSet")
  CharMatcher precomputedInternal()
  {
    BitSet localBitSet = new BitSet();
    setBits(localBitSet);
    int i = localBitSet.cardinality();
    if (i * 2 <= 65536) {
      return precomputedPositive(i, localBitSet, toString());
    }
    localBitSet.flip(0, 65536);
    final String str2 = toString();
    if (str2.endsWith(".negate()")) {}
    for (String str1 = str2.substring(0, str2.length() - ".negate()".length());; str1 = str2 + ".negate()") {
      new NegatedFastMatcher(precomputedPositive(65536 - i, localBitSet, str1))
      {
        public String toString()
        {
          return str2;
        }
      };
    }
  }
  
  @CheckReturnValue
  public String removeFrom(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    int j = 1;
    i += 1;
    for (;;)
    {
      if (i == paramCharSequence.length) {
        return new String(paramCharSequence, 0, i - j);
      }
      if (matches(paramCharSequence[i]))
      {
        j += 1;
        break;
      }
      paramCharSequence[(i - j)] = paramCharSequence[i];
      i += 1;
    }
  }
  
  @CheckReturnValue
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    paramCharSequence[i] = paramChar;
    i += 1;
    while (i < paramCharSequence.length)
    {
      if (matches(paramCharSequence[i])) {
        paramCharSequence[i] = paramChar;
      }
      i += 1;
    }
    return new String(paramCharSequence);
  }
  
  @CheckReturnValue
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence2.length();
    if (i == 0) {
      paramCharSequence1 = removeFrom(paramCharSequence1);
    }
    String str;
    do
    {
      return paramCharSequence1;
      if (i == 1) {
        return replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0));
      }
      str = paramCharSequence1.toString();
      i = indexIn(str);
      paramCharSequence1 = str;
    } while (i == -1);
    int n = str.length();
    paramCharSequence1 = new StringBuilder(n * 3 / 2 + 16);
    int j = 0;
    int k;
    int m;
    do
    {
      paramCharSequence1.append(str, j, i);
      paramCharSequence1.append(paramCharSequence2);
      k = i + 1;
      m = indexIn(str, k);
      j = k;
      i = m;
    } while (m != -1);
    paramCharSequence1.append(str, k, n);
    return paramCharSequence1.toString();
  }
  
  @CheckReturnValue
  public String retainFrom(CharSequence paramCharSequence)
  {
    return negate().removeFrom(paramCharSequence);
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet paramBitSet)
  {
    int i = 65535;
    while (i >= 0)
    {
      if (matches((char)i)) {
        paramBitSet.set(i);
      }
      i -= 1;
    }
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  @CheckReturnValue
  public String trimAndCollapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    int m = paramCharSequence.length();
    int i = 0;
    int k = m - 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = k;
      if (!matches(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    while ((j > i) && (matches(paramCharSequence.charAt(j)))) {
      j -= 1;
    }
    if ((i == 0) && (j == m - 1)) {
      return collapseFrom(paramCharSequence, paramChar);
    }
    return finishCollapseFrom(paramCharSequence, i, j + 1, paramChar, new StringBuilder(j + 1 - i), false);
  }
  
  @CheckReturnValue
  public String trimFrom(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    if ((i >= j) || (!matches(paramCharSequence.charAt(i)))) {
      j -= 1;
    }
    for (;;)
    {
      if ((j <= i) || (!matches(paramCharSequence.charAt(j))))
      {
        return paramCharSequence.subSequence(i, j + 1).toString();
        i += 1;
        break;
      }
      j -= 1;
    }
  }
  
  @CheckReturnValue
  public String trimLeadingFrom(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!matches(paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(i, j).toString();
      }
      i += 1;
    }
    return "";
  }
  
  @CheckReturnValue
  public String trimTrailingFrom(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!matches(paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(0, i + 1).toString();
      }
      i -= 1;
    }
    return "";
  }
  
  private static final class And
    extends CharMatcher
  {
    final CharMatcher first;
    final CharMatcher second;
    
    And(CharMatcher paramCharMatcher1, CharMatcher paramCharMatcher2)
    {
      this.first = ((CharMatcher)Preconditions.checkNotNull(paramCharMatcher1));
      this.second = ((CharMatcher)Preconditions.checkNotNull(paramCharMatcher2));
    }
    
    public boolean matches(char paramChar)
    {
      return (this.first.matches(paramChar)) && (this.second.matches(paramChar));
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      BitSet localBitSet1 = new BitSet();
      this.first.setBits(localBitSet1);
      BitSet localBitSet2 = new BitSet();
      this.second.setBits(localBitSet2);
      localBitSet1.and(localBitSet2);
      paramBitSet.or(localBitSet1);
    }
    
    public String toString()
    {
      return "CharMatcher.and(" + this.first + ", " + this.second + ")";
    }
  }
  
  private static final class Any
    extends CharMatcher.NamedFastMatcher
  {
    static final Any INSTANCE = new Any();
    
    private Any()
    {
      super();
    }
    
    public CharMatcher and(CharMatcher paramCharMatcher)
    {
      return (CharMatcher)Preconditions.checkNotNull(paramCharMatcher);
    }
    
    public String collapseFrom(CharSequence paramCharSequence, char paramChar)
    {
      if (paramCharSequence.length() == 0) {
        return "";
      }
      return String.valueOf(paramChar);
    }
    
    public int countIn(CharSequence paramCharSequence)
    {
      return paramCharSequence.length();
    }
    
    public int indexIn(CharSequence paramCharSequence)
    {
      if (paramCharSequence.length() == 0) {
        return -1;
      }
      return 0;
    }
    
    public int indexIn(CharSequence paramCharSequence, int paramInt)
    {
      int j = paramCharSequence.length();
      Preconditions.checkPositionIndex(paramInt, j);
      int i = paramInt;
      if (paramInt == j) {
        i = -1;
      }
      return i;
    }
    
    public int lastIndexIn(CharSequence paramCharSequence)
    {
      return paramCharSequence.length() - 1;
    }
    
    public boolean matches(char paramChar)
    {
      return true;
    }
    
    public boolean matchesAllOf(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return true;
    }
    
    public boolean matchesNoneOf(CharSequence paramCharSequence)
    {
      return paramCharSequence.length() == 0;
    }
    
    public CharMatcher negate()
    {
      return none();
    }
    
    public CharMatcher or(CharMatcher paramCharMatcher)
    {
      Preconditions.checkNotNull(paramCharMatcher);
      return this;
    }
    
    public String removeFrom(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return "";
    }
    
    public String replaceFrom(CharSequence paramCharSequence, char paramChar)
    {
      paramCharSequence = new char[paramCharSequence.length()];
      Arrays.fill(paramCharSequence, paramChar);
      return new String(paramCharSequence);
    }
    
    public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramCharSequence1.length() * paramCharSequence2.length());
      int i = 0;
      while (i < paramCharSequence1.length())
      {
        localStringBuilder.append(paramCharSequence2);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public String trimFrom(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return "";
    }
  }
  
  private static final class AnyOf
    extends CharMatcher
  {
    private final char[] chars;
    
    public AnyOf(CharSequence paramCharSequence)
    {
      this.chars = paramCharSequence.toString().toCharArray();
      Arrays.sort(this.chars);
    }
    
    public boolean matches(char paramChar)
    {
      return Arrays.binarySearch(this.chars, paramChar) >= 0;
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        paramBitSet.set(arrayOfChar[i]);
        i += 1;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(CharMatcher.showCharacter(arrayOfChar[i]));
        i += 1;
      }
      localStringBuilder.append("\")");
      return localStringBuilder.toString();
    }
  }
  
  private static final class Ascii
    extends CharMatcher.NamedFastMatcher
  {
    static final Ascii INSTANCE = new Ascii();
    
    Ascii()
    {
      super();
    }
    
    public boolean matches(char paramChar)
    {
      return paramChar <= '';
    }
  }
  
  @GwtIncompatible("java.util.BitSet")
  private static final class BitSetMatcher
    extends CharMatcher.NamedFastMatcher
  {
    private final BitSet table;
    
    private BitSetMatcher(BitSet paramBitSet, String paramString)
    {
      super();
      paramString = paramBitSet;
      if (paramBitSet.length() + 64 < paramBitSet.size()) {
        paramString = (BitSet)paramBitSet.clone();
      }
      this.table = paramString;
    }
    
    public boolean matches(char paramChar)
    {
      return this.table.get(paramChar);
    }
    
    void setBits(BitSet paramBitSet)
    {
      paramBitSet.or(this.table);
    }
  }
  
  private static final class BreakingWhitespace
    extends CharMatcher
  {
    static final CharMatcher INSTANCE = new BreakingWhitespace();
    
    public boolean matches(char paramChar)
    {
      switch (paramChar)
      {
      default: 
        if ((paramChar < ' ') || (paramChar > ' ')) {
          break;
        }
      case '\t': 
      case '\n': 
      case '\013': 
      case '\f': 
      case '\r': 
      case ' ': 
      case '': 
      case ' ': 
      case ' ': 
      case ' ': 
      case ' ': 
      case '　': 
        return true;
      case ' ': 
        return false;
      }
      return false;
    }
    
    public String toString()
    {
      return "CharMatcher.breakingWhitespace()";
    }
  }
  
  private static final class Digit
    extends CharMatcher.RangesMatcher
  {
    static final Digit INSTANCE = new Digit();
    private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
    
    private Digit()
    {
      super(zeroes(), nines());
    }
    
    private static char[] nines()
    {
      char[] arrayOfChar = new char["0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length()];
      int i = 0;
      while (i < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length())
      {
        arrayOfChar[i] = ((char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + '\t'));
        i += 1;
      }
      return arrayOfChar;
    }
    
    private static char[] zeroes()
    {
      return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    }
  }
  
  static abstract class FastMatcher
    extends CharMatcher
  {
    public CharMatcher negate()
    {
      return new CharMatcher.NegatedFastMatcher(this);
    }
    
    public final CharMatcher precomputed()
    {
      return this;
    }
  }
  
  private static final class ForPredicate
    extends CharMatcher
  {
    private final Predicate<? super Character> predicate;
    
    ForPredicate(Predicate<? super Character> paramPredicate)
    {
      this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
    }
    
    public boolean apply(Character paramCharacter)
    {
      return this.predicate.apply(Preconditions.checkNotNull(paramCharacter));
    }
    
    public boolean matches(char paramChar)
    {
      return this.predicate.apply(Character.valueOf(paramChar));
    }
    
    public String toString()
    {
      return "CharMatcher.forPredicate(" + this.predicate + ")";
    }
  }
  
  private static final class InRange
    extends CharMatcher.FastMatcher
  {
    private final char endInclusive;
    private final char startInclusive;
    
    InRange(char paramChar1, char paramChar2)
    {
      if (paramChar2 >= paramChar1) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.startInclusive = paramChar1;
        this.endInclusive = paramChar2;
        return;
      }
    }
    
    public boolean matches(char paramChar)
    {
      return (this.startInclusive <= paramChar) && (paramChar <= this.endInclusive);
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      paramBitSet.set(this.startInclusive, this.endInclusive + '\001');
    }
    
    public String toString()
    {
      return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.startInclusive) + "', '" + CharMatcher.showCharacter(this.endInclusive) + "')";
    }
  }
  
  private static final class Invisible
    extends CharMatcher.RangesMatcher
  {
    static final Invisible INSTANCE = new Invisible();
    private static final String RANGE_ENDS = "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻";
    private static final String RANGE_STARTS = "\000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺";
    
    private Invisible()
    {
      super("\000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺".toCharArray(), "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻".toCharArray());
    }
  }
  
  private static final class Is
    extends CharMatcher.FastMatcher
  {
    private final char match;
    
    Is(char paramChar)
    {
      this.match = paramChar;
    }
    
    public CharMatcher and(CharMatcher paramCharMatcher)
    {
      if (paramCharMatcher.matches(this.match)) {
        return this;
      }
      return none();
    }
    
    public boolean matches(char paramChar)
    {
      return paramChar == this.match;
    }
    
    public CharMatcher negate()
    {
      return isNot(this.match);
    }
    
    public CharMatcher or(CharMatcher paramCharMatcher)
    {
      if (paramCharMatcher.matches(this.match)) {
        return paramCharMatcher;
      }
      return super.or(paramCharMatcher);
    }
    
    public String replaceFrom(CharSequence paramCharSequence, char paramChar)
    {
      return paramCharSequence.toString().replace(this.match, paramChar);
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      paramBitSet.set(this.match);
    }
    
    public String toString()
    {
      return "CharMatcher.is('" + CharMatcher.showCharacter(this.match) + "')";
    }
  }
  
  private static final class IsEither
    extends CharMatcher.FastMatcher
  {
    private final char match1;
    private final char match2;
    
    IsEither(char paramChar1, char paramChar2)
    {
      this.match1 = paramChar1;
      this.match2 = paramChar2;
    }
    
    public boolean matches(char paramChar)
    {
      return (paramChar == this.match1) || (paramChar == this.match2);
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      paramBitSet.set(this.match1);
      paramBitSet.set(this.match2);
    }
    
    public String toString()
    {
      return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
    }
  }
  
  private static final class IsNot
    extends CharMatcher.FastMatcher
  {
    private final char match;
    
    IsNot(char paramChar)
    {
      this.match = paramChar;
    }
    
    public CharMatcher and(CharMatcher paramCharMatcher)
    {
      CharMatcher localCharMatcher = paramCharMatcher;
      if (paramCharMatcher.matches(this.match)) {
        localCharMatcher = super.and(paramCharMatcher);
      }
      return localCharMatcher;
    }
    
    public boolean matches(char paramChar)
    {
      return paramChar != this.match;
    }
    
    public CharMatcher negate()
    {
      return is(this.match);
    }
    
    public CharMatcher or(CharMatcher paramCharMatcher)
    {
      Object localObject = this;
      if (paramCharMatcher.matches(this.match)) {
        localObject = any();
      }
      return (CharMatcher)localObject;
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      paramBitSet.set(0, this.match);
      paramBitSet.set(this.match + '\001', 65536);
    }
    
    public String toString()
    {
      return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.match) + "')";
    }
  }
  
  private static final class JavaDigit
    extends CharMatcher
  {
    static final JavaDigit INSTANCE = new JavaDigit();
    
    public boolean matches(char paramChar)
    {
      return Character.isDigit(paramChar);
    }
    
    public String toString()
    {
      return "CharMatcher.javaDigit()";
    }
  }
  
  private static final class JavaIsoControl
    extends CharMatcher.NamedFastMatcher
  {
    static final JavaIsoControl INSTANCE = new JavaIsoControl();
    
    private JavaIsoControl()
    {
      super();
    }
    
    public boolean matches(char paramChar)
    {
      return (paramChar <= '\037') || ((paramChar >= '') && (paramChar <= ''));
    }
  }
  
  private static final class JavaLetter
    extends CharMatcher
  {
    static final JavaLetter INSTANCE = new JavaLetter();
    
    public boolean matches(char paramChar)
    {
      return Character.isLetter(paramChar);
    }
    
    public String toString()
    {
      return "CharMatcher.javaLetter()";
    }
  }
  
  private static final class JavaLetterOrDigit
    extends CharMatcher
  {
    static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();
    
    public boolean matches(char paramChar)
    {
      return Character.isLetterOrDigit(paramChar);
    }
    
    public String toString()
    {
      return "CharMatcher.javaLetterOrDigit()";
    }
  }
  
  private static final class JavaLowerCase
    extends CharMatcher
  {
    static final JavaLowerCase INSTANCE = new JavaLowerCase();
    
    public boolean matches(char paramChar)
    {
      return Character.isLowerCase(paramChar);
    }
    
    public String toString()
    {
      return "CharMatcher.javaLowerCase()";
    }
  }
  
  private static final class JavaUpperCase
    extends CharMatcher
  {
    static final JavaUpperCase INSTANCE = new JavaUpperCase();
    
    public boolean matches(char paramChar)
    {
      return Character.isUpperCase(paramChar);
    }
    
    public String toString()
    {
      return "CharMatcher.javaUpperCase()";
    }
  }
  
  static abstract class NamedFastMatcher
    extends CharMatcher.FastMatcher
  {
    private final String description;
    
    NamedFastMatcher(String paramString)
    {
      this.description = ((String)Preconditions.checkNotNull(paramString));
    }
    
    public final String toString()
    {
      return this.description;
    }
  }
  
  private static class Negated
    extends CharMatcher
  {
    final CharMatcher original;
    
    Negated(CharMatcher paramCharMatcher)
    {
      this.original = ((CharMatcher)Preconditions.checkNotNull(paramCharMatcher));
    }
    
    public int countIn(CharSequence paramCharSequence)
    {
      return paramCharSequence.length() - this.original.countIn(paramCharSequence);
    }
    
    public boolean matches(char paramChar)
    {
      return !this.original.matches(paramChar);
    }
    
    public boolean matchesAllOf(CharSequence paramCharSequence)
    {
      return this.original.matchesNoneOf(paramCharSequence);
    }
    
    public boolean matchesNoneOf(CharSequence paramCharSequence)
    {
      return this.original.matchesAllOf(paramCharSequence);
    }
    
    public CharMatcher negate()
    {
      return this.original;
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      BitSet localBitSet = new BitSet();
      this.original.setBits(localBitSet);
      localBitSet.flip(0, 65536);
      paramBitSet.or(localBitSet);
    }
    
    public String toString()
    {
      return this.original + ".negate()";
    }
  }
  
  static class NegatedFastMatcher
    extends CharMatcher.Negated
  {
    NegatedFastMatcher(CharMatcher paramCharMatcher)
    {
      super();
    }
    
    public final CharMatcher precomputed()
    {
      return this;
    }
  }
  
  private static final class None
    extends CharMatcher.NamedFastMatcher
  {
    static final None INSTANCE = new None();
    
    private None()
    {
      super();
    }
    
    public CharMatcher and(CharMatcher paramCharMatcher)
    {
      Preconditions.checkNotNull(paramCharMatcher);
      return this;
    }
    
    public String collapseFrom(CharSequence paramCharSequence, char paramChar)
    {
      return paramCharSequence.toString();
    }
    
    public int countIn(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return 0;
    }
    
    public int indexIn(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return -1;
    }
    
    public int indexIn(CharSequence paramCharSequence, int paramInt)
    {
      Preconditions.checkPositionIndex(paramInt, paramCharSequence.length());
      return -1;
    }
    
    public int lastIndexIn(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return -1;
    }
    
    public boolean matches(char paramChar)
    {
      return false;
    }
    
    public boolean matchesAllOf(CharSequence paramCharSequence)
    {
      return paramCharSequence.length() == 0;
    }
    
    public boolean matchesNoneOf(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return true;
    }
    
    public CharMatcher negate()
    {
      return any();
    }
    
    public CharMatcher or(CharMatcher paramCharMatcher)
    {
      return (CharMatcher)Preconditions.checkNotNull(paramCharMatcher);
    }
    
    public String removeFrom(CharSequence paramCharSequence)
    {
      return paramCharSequence.toString();
    }
    
    public String replaceFrom(CharSequence paramCharSequence, char paramChar)
    {
      return paramCharSequence.toString();
    }
    
    public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      Preconditions.checkNotNull(paramCharSequence2);
      return paramCharSequence1.toString();
    }
    
    public String trimFrom(CharSequence paramCharSequence)
    {
      return paramCharSequence.toString();
    }
    
    public String trimLeadingFrom(CharSequence paramCharSequence)
    {
      return paramCharSequence.toString();
    }
    
    public String trimTrailingFrom(CharSequence paramCharSequence)
    {
      return paramCharSequence.toString();
    }
  }
  
  private static final class Or
    extends CharMatcher
  {
    final CharMatcher first;
    final CharMatcher second;
    
    Or(CharMatcher paramCharMatcher1, CharMatcher paramCharMatcher2)
    {
      this.first = ((CharMatcher)Preconditions.checkNotNull(paramCharMatcher1));
      this.second = ((CharMatcher)Preconditions.checkNotNull(paramCharMatcher2));
    }
    
    public boolean matches(char paramChar)
    {
      return (this.first.matches(paramChar)) || (this.second.matches(paramChar));
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      this.first.setBits(paramBitSet);
      this.second.setBits(paramBitSet);
    }
    
    public String toString()
    {
      return "CharMatcher.or(" + this.first + ", " + this.second + ")";
    }
  }
  
  private static class RangesMatcher
    extends CharMatcher
  {
    private final String description;
    private final char[] rangeEnds;
    private final char[] rangeStarts;
    
    RangesMatcher(String paramString, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
    {
      this.description = paramString;
      this.rangeStarts = paramArrayOfChar1;
      this.rangeEnds = paramArrayOfChar2;
      int i;
      if (paramArrayOfChar1.length == paramArrayOfChar2.length)
      {
        bool = true;
        Preconditions.checkArgument(bool);
        i = 0;
        label37:
        if (i >= paramArrayOfChar1.length) {
          return;
        }
        if (paramArrayOfChar1[i] > paramArrayOfChar2[i]) {
          break label108;
        }
        bool = true;
        label58:
        Preconditions.checkArgument(bool);
        if (i + 1 < paramArrayOfChar1.length) {
          if (paramArrayOfChar2[i] >= paramArrayOfChar1[(i + 1)]) {
            break label114;
          }
        }
      }
      label108:
      label114:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        i += 1;
        break label37;
        bool = false;
        break;
        bool = false;
        break label58;
      }
    }
    
    public boolean matches(char paramChar)
    {
      int i = Arrays.binarySearch(this.rangeStarts, paramChar);
      if (i >= 0) {}
      do
      {
        return true;
        i = (i ^ 0xFFFFFFFF) - 1;
      } while ((i >= 0) && (paramChar <= this.rangeEnds[i]));
      return false;
    }
    
    public String toString()
    {
      return this.description;
    }
  }
  
  private static final class SingleWidth
    extends CharMatcher.RangesMatcher
  {
    static final SingleWidth INSTANCE = new SingleWidth();
    
    private SingleWidth()
    {
      super("\000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
    }
  }
  
  @VisibleForTesting
  static final class Whitespace
    extends CharMatcher.NamedFastMatcher
  {
    static final Whitespace INSTANCE = new Whitespace();
    static final int MULTIPLIER = 1682554634;
    static final int SHIFT = Integer.numberOfLeadingZeros(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".length() - 1);
    static final String TABLE = " 　\r   　 \013　   　 \t     \f 　 　　 \n 　";
    
    Whitespace()
    {
      super();
    }
    
    public boolean matches(char paramChar)
    {
      return " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * paramChar >>> SHIFT) == paramChar;
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(BitSet paramBitSet)
    {
      int i = 0;
      while (i < " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".length())
      {
        paramBitSet.set(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(i));
        i += 1;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/CharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */