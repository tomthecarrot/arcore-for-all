package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import java.util.List;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class InternetDomainName
{
  private static final CharMatcher DASH_MATCHER = CharMatcher.anyOf("-_");
  private static final CharMatcher DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
  private static final Joiner DOT_JOINER;
  private static final String DOT_REGEX = "\\.";
  private static final Splitter DOT_SPLITTER = Splitter.on('.');
  private static final int MAX_DOMAIN_PART_LENGTH = 63;
  private static final int MAX_LENGTH = 253;
  private static final int MAX_PARTS = 127;
  private static final int NO_PUBLIC_SUFFIX_FOUND = -1;
  private static final CharMatcher PART_CHAR_MATCHER = CharMatcher.JAVA_LETTER_OR_DIGIT.or(DASH_MATCHER);
  private final String name;
  private final ImmutableList<String> parts;
  private final int publicSuffixIndex;
  
  static
  {
    DOT_JOINER = Joiner.on('.');
  }
  
  InternetDomainName(String paramString)
  {
    String str = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(paramString, '.'));
    paramString = str;
    if (str.endsWith(".")) {
      paramString = str.substring(0, str.length() - 1);
    }
    if (paramString.length() <= 253)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Domain name too long: '%s':", new Object[] { paramString });
      this.name = paramString;
      this.parts = ImmutableList.copyOf(DOT_SPLITTER.split(paramString));
      if (this.parts.size() > 127) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Domain has too many parts: '%s'", new Object[] { paramString });
      Preconditions.checkArgument(validateSyntax(this.parts), "Not a valid domain name: '%s'", new Object[] { paramString });
      this.publicSuffixIndex = findPublicSuffix();
      return;
      bool = false;
      break;
    }
  }
  
  private InternetDomainName ancestor(int paramInt)
  {
    return from(DOT_JOINER.join(this.parts.subList(paramInt, this.parts.size())));
  }
  
  private int findPublicSuffix()
  {
    int j = this.parts.size();
    int i = 0;
    while (i < j)
    {
      String str = DOT_JOINER.join(this.parts.subList(i, j));
      if (PublicSuffixPatterns.EXACT.containsKey(str)) {}
      do
      {
        return i;
        if (PublicSuffixPatterns.EXCLUDED.containsKey(str)) {
          return i + 1;
        }
      } while (matchesWildcardPublicSuffix(str));
      i += 1;
    }
    return -1;
  }
  
  public static InternetDomainName from(String paramString)
  {
    return new InternetDomainName((String)Preconditions.checkNotNull(paramString));
  }
  
  public static boolean isValid(String paramString)
  {
    try
    {
      from(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString) {}
    return false;
  }
  
  private static boolean matchesWildcardPublicSuffix(String paramString)
  {
    paramString = paramString.split("\\.", 2);
    return (paramString.length == 2) && (PublicSuffixPatterns.UNDER.containsKey(paramString[1]));
  }
  
  private static boolean validatePart(String paramString, boolean paramBoolean)
  {
    if ((paramString.length() < 1) || (paramString.length() > 63)) {}
    String str;
    do
    {
      return false;
      str = CharMatcher.ASCII.retainFrom(paramString);
    } while ((!PART_CHAR_MATCHER.matchesAllOf(str)) || (DASH_MATCHER.matches(paramString.charAt(0))) || (DASH_MATCHER.matches(paramString.charAt(paramString.length() - 1))) || ((paramBoolean) && (CharMatcher.DIGIT.matches(paramString.charAt(0)))));
    return true;
  }
  
  private static boolean validateSyntax(List<String> paramList)
  {
    int j = paramList.size() - 1;
    if (!validatePart((String)paramList.get(j), true)) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!validatePart((String)paramList.get(i), false)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public InternetDomainName child(String paramString)
  {
    return from((String)Preconditions.checkNotNull(paramString) + "." + this.name);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InternetDomainName))
    {
      paramObject = (InternetDomainName)paramObject;
      return this.name.equals(((InternetDomainName)paramObject).name);
    }
    return false;
  }
  
  public boolean hasParent()
  {
    return this.parts.size() > 1;
  }
  
  public boolean hasPublicSuffix()
  {
    return this.publicSuffixIndex != -1;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public boolean isPublicSuffix()
  {
    return this.publicSuffixIndex == 0;
  }
  
  public boolean isTopPrivateDomain()
  {
    return this.publicSuffixIndex == 1;
  }
  
  public boolean isUnderPublicSuffix()
  {
    return this.publicSuffixIndex > 0;
  }
  
  public InternetDomainName parent()
  {
    Preconditions.checkState(hasParent(), "Domain '%s' has no parent", new Object[] { this.name });
    return ancestor(1);
  }
  
  public ImmutableList<String> parts()
  {
    return this.parts;
  }
  
  public InternetDomainName publicSuffix()
  {
    if (hasPublicSuffix()) {
      return ancestor(this.publicSuffixIndex);
    }
    return null;
  }
  
  public String toString()
  {
    return this.name;
  }
  
  public InternetDomainName topPrivateDomain()
  {
    if (isTopPrivateDomain()) {
      return this;
    }
    Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", new Object[] { this.name });
    return ancestor(this.publicSuffixIndex - 1);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/net/InternetDomainName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */