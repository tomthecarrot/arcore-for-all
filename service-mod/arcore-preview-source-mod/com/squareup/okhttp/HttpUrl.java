package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import okio.Buffer;

public final class HttpUrl
{
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  static final String FRAGMENT_ENCODE_SET = "";
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
  static final String QUERY_ENCODE_SET = " \"'<>#";
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  private final String fragment;
  private final String host;
  private final String password;
  private final List<String> pathSegments;
  private final int port;
  private final List<String> queryNamesAndValues;
  private final String scheme;
  private final String url;
  private final String username;
  
  private HttpUrl(Builder paramBuilder)
  {
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername);
    this.password = percentDecode(paramBuilder.encodedPassword);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments);
    if (paramBuilder.encodedQueryNamesAndValues != null) {}
    for (Object localObject1 = percentDecode(paramBuilder.encodedQueryNamesAndValues);; localObject1 = null)
    {
      this.queryNamesAndValues = ((List)localObject1);
      localObject1 = localObject2;
      if (paramBuilder.encodedFragment != null) {
        localObject1 = percentDecode(paramBuilder.encodedFragment);
      }
      this.fragment = ((String)localObject1);
      this.url = paramBuilder.toString();
      return;
    }
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j < 32) || (j >= 127) || (paramString2.indexOf(j) != -1) || ((j == 37) && (!paramBoolean1)) || ((paramBoolean2) && (j == 43)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString1, paramInt1, i);
        canonicalize(localBuffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2);
        return localBuffer.readUtf8();
      }
      i += Character.charCount(j);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2);
  }
  
  static void canonicalize(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (paramInt1 < paramInt2)
    {
      int i = paramString1.codePointAt(paramInt1);
      Object localObject3;
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (i != 9)
        {
          localObject3 = localObject1;
          if (i != 10)
          {
            localObject3 = localObject1;
            if (i != 12)
            {
              if (i != 13) {
                break label79;
              }
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(i);
        localObject1 = localObject3;
        break;
        label79:
        Object localObject2;
        if ((paramBoolean2) && (i == 43))
        {
          if (paramBoolean1) {}
          for (localObject2 = "%20";; localObject2 = "%2B")
          {
            paramBuffer.writeUtf8((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((i < 32) || (i >= 127) || (paramString2.indexOf(i) != -1) || ((i == 37) && (!paramBoolean1)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Buffer();
          }
          ((Buffer)localObject2).writeUtf8CodePoint(i);
          for (;;)
          {
            localObject3 = localObject2;
            if (((Buffer)localObject2).exhausted()) {
              break;
            }
            int j = ((Buffer)localObject2).readByte() & 0xFF;
            paramBuffer.writeByte(37);
            paramBuffer.writeByte(HEX_DIGITS[(j >> 4 & 0xF)]);
            paramBuffer.writeByte(HEX_DIGITS[(j & 0xF)]);
          }
        }
        paramBuffer.writeUtf8CodePoint(i);
        localObject3 = localObject1;
      }
    }
  }
  
  static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int defaultPort(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  private static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static HttpUrl get(URI paramURI)
  {
    return parse(paramURI.toString());
  }
  
  public static HttpUrl get(URL paramURL)
  {
    return parse(paramURL.toString());
  }
  
  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      String str1 = (String)paramList.get(i);
      String str2 = (String)paramList.get(i + 1);
      if (i > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i += 2;
    }
  }
  
  public static HttpUrl parse(String paramString)
  {
    return new Builder().parse(null, paramString);
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
  }
  
  static String percentDecode(String paramString)
  {
    return percentDecode(paramString, 0, paramString.length());
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (paramString.charAt(i) == '%')
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString, paramInt1, i);
        percentDecode(localBuffer, paramString, i, paramInt2);
        return localBuffer.readUtf8();
      }
      i += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  private List<String> percentDecode(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = percentDecode(paramList);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void percentDecode(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int i = paramString.codePointAt(paramInt1);
      if ((i == 37) && (paramInt1 + 2 < paramInt2))
      {
        int j = decodeHexDigit(paramString.charAt(paramInt1 + 1));
        int k = decodeHexDigit(paramString.charAt(paramInt1 + 2));
        if ((j != -1) && (k != -1))
        {
          paramBuffer.writeByte((j << 4) + k);
          paramInt1 += 2;
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(i);
        break;
        paramBuffer.writeUtf8CodePoint(i);
      }
    }
  }
  
  static List<String> queryStringToNamesAndValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i <= paramString.length())
    {
      int k = paramString.indexOf('&', i);
      int j = k;
      if (k == -1) {
        j = paramString.length();
      }
      k = paramString.indexOf('=', i);
      if ((k == -1) || (k > j))
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
      for (;;)
      {
        i = j + 1;
        break;
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
    }
    return localArrayList;
  }
  
  public String encodedFragment()
  {
    if (this.fragment == null) {
      return null;
    }
    int i = this.url.indexOf('#');
    return this.url.substring(i + 1);
  }
  
  public String encodedPassword()
  {
    if (this.password.isEmpty()) {
      return "";
    }
    int i = this.url.indexOf(':', this.scheme.length() + 3);
    int j = this.url.indexOf('@');
    return this.url.substring(i + 1, j);
  }
  
  public String encodedPath()
  {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    int j = delimiterOffset(this.url, i, this.url.length(), "?#");
    return this.url.substring(i, j);
  }
  
  public List<String> encodedPathSegments()
  {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    int j = delimiterOffset(this.url, i, this.url.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = delimiterOffset(this.url, k, j, "/");
      localArrayList.add(this.url.substring(k, i));
    }
    return localArrayList;
  }
  
  public String encodedQuery()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    int i = this.url.indexOf('?') + 1;
    int j = delimiterOffset(this.url, i + 1, this.url.length(), "#");
    return this.url.substring(i, j);
  }
  
  public String encodedUsername()
  {
    if (this.username.isEmpty()) {
      return "";
    }
    int i = this.scheme.length() + 3;
    int j = delimiterOffset(this.url, i, this.url.length(), ":@");
    return this.url.substring(i, j);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (((HttpUrl)paramObject).url.equals(this.url));
  }
  
  public String fragment()
  {
    return this.fragment;
  }
  
  public int hashCode()
  {
    return this.url.hashCode();
  }
  
  public String host()
  {
    return this.host;
  }
  
  public boolean isHttps()
  {
    return this.scheme.equals("https");
  }
  
  public Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    localBuilder.scheme = this.scheme;
    localBuilder.encodedUsername = encodedUsername();
    localBuilder.encodedPassword = encodedPassword();
    localBuilder.host = this.host;
    if (this.port == defaultPort(this.scheme)) {}
    for (localBuilder.port = -1;; localBuilder.port = this.port)
    {
      localBuilder.encodedPathSegments.clear();
      localBuilder.encodedPathSegments.addAll(encodedPathSegments());
      localBuilder.encodedQuery(encodedQuery());
      localBuilder.encodedFragment = encodedFragment();
      return localBuilder;
    }
  }
  
  public String password()
  {
    return this.password;
  }
  
  public List<String> pathSegments()
  {
    return this.pathSegments;
  }
  
  public int pathSize()
  {
    return this.pathSegments.size();
  }
  
  public int port()
  {
    return this.port;
  }
  
  public String query()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    namesAndValuesToQueryString(localStringBuilder, this.queryNamesAndValues);
    return localStringBuilder.toString();
  }
  
  public String queryParameter(String paramString)
  {
    if (this.queryNamesAndValues == null) {}
    for (;;)
    {
      return null;
      int i = 0;
      int j = this.queryNamesAndValues.size();
      while (i < j)
      {
        if (paramString.equals(this.queryNamesAndValues.get(i))) {
          return (String)this.queryNamesAndValues.get(i + 1);
        }
        i += 2;
      }
    }
  }
  
  public String queryParameterName(int paramInt)
  {
    return (String)this.queryNamesAndValues.get(paramInt * 2);
  }
  
  public Set<String> queryParameterNames()
  {
    if (this.queryNamesAndValues == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      localLinkedHashSet.add(this.queryNamesAndValues.get(i));
      i += 2;
    }
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public String queryParameterValue(int paramInt)
  {
    return (String)this.queryNamesAndValues.get(paramInt * 2 + 1);
  }
  
  public List<String> queryParameterValues(String paramString)
  {
    if (this.queryNamesAndValues == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      if (paramString.equals(this.queryNamesAndValues.get(i))) {
        localArrayList.add(this.queryNamesAndValues.get(i + 1));
      }
      i += 2;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int querySize()
  {
    if (this.queryNamesAndValues != null) {
      return this.queryNamesAndValues.size() / 2;
    }
    return 0;
  }
  
  public HttpUrl resolve(String paramString)
  {
    return new Builder().parse(this, paramString);
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    return this.url;
  }
  
  public URI uri()
  {
    try
    {
      URI localURI = new URI(this.url);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalStateException("not valid as a java.net.URI: " + this.url);
    }
  }
  
  public URL url()
  {
    try
    {
      URL localURL = new URL(this.url);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public String username()
  {
    return this.username;
  }
  
  public static final class Builder
  {
    String encodedFragment;
    String encodedPassword = "";
    final List<String> encodedPathSegments = new ArrayList();
    List<String> encodedQueryNamesAndValues;
    String encodedUsername = "";
    String host;
    int port = -1;
    String scheme;
    
    public Builder()
    {
      this.encodedPathSegments.add("");
    }
    
    private static String canonicalizeHost(String paramString, int paramInt1, int paramInt2)
    {
      paramString = HttpUrl.percentDecode(paramString, paramInt1, paramInt2);
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        paramString = decodeIpv6(paramString, 1, paramString.length() - 1);
        if (paramString == null) {
          paramString = null;
        }
      }
      String str;
      do
      {
        return paramString;
        paramString = paramString.getAddress();
        if (paramString.length == 16) {
          return inet6AddressToAscii(paramString);
        }
        throw new AssertionError();
        str = domainToAscii(paramString);
        if (str == null) {
          return null;
        }
        paramInt1 = str.length();
        paramString = str;
      } while (HttpUrl.delimiterOffset(str, 0, paramInt1, "\000\t\n\r #%/:?@[\\]") == paramInt1);
      return null;
    }
    
    private static boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
    {
      int j = paramInt3;
      int i = paramInt1;
      if (i < paramInt2) {
        if (j != paramArrayOfByte.length) {}
      }
      label20:
      while (j != paramInt3 + 4)
      {
        do
        {
          return false;
          paramInt1 = i;
          if (j == paramInt3) {
            break;
          }
        } while (paramString.charAt(i) != '.');
        paramInt1 = i + 1;
        int k = 0;
        i = paramInt1;
        for (;;)
        {
          int m;
          if (i < paramInt2)
          {
            m = paramString.charAt(i);
            if ((m >= 48) && (m <= 57)) {}
          }
          else
          {
            if (i - paramInt1 == 0) {
              break label20;
            }
            paramArrayOfByte[j] = ((byte)k);
            j += 1;
            break;
          }
          if ((k == 0) && (paramInt1 != i)) {
            break label20;
          }
          k = k * 10 + m - 48;
          if (k > 255) {
            break label20;
          }
          i += 1;
        }
      }
      return true;
    }
    
    private static InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[16];
      int i = 0;
      int j = -1;
      int i1 = -1;
      int m;
      for (int k = paramInt1;; k = paramInt1)
      {
        paramInt1 = i;
        m = j;
        if (k < paramInt2)
        {
          if (i == arrayOfByte.length) {
            return null;
          }
          if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
          {
            if (j != -1) {
              return null;
            }
            k += 2;
            i += 2;
            j = i;
            n = i;
            m = j;
            paramInt1 = k;
            if (k != paramInt2) {
              break label156;
            }
            m = j;
            paramInt1 = i;
          }
        }
        else
        {
          if (paramInt1 == arrayOfByte.length) {
            break label349;
          }
          if (m != -1) {
            break;
          }
          return null;
        }
        int n = i;
        m = j;
        paramInt1 = k;
        if (i != 0)
        {
          if (paramString.regionMatches(k, ":", 0, 1))
          {
            paramInt1 = k + 1;
            m = j;
            n = i;
          }
        }
        else
        {
          label156:
          i = 0;
          k = paramInt1;
        }
        for (;;)
        {
          if (paramInt1 < paramInt2)
          {
            j = HttpUrl.decodeHexDigit(paramString.charAt(paramInt1));
            if (j != -1) {}
          }
          else
          {
            j = paramInt1 - k;
            if ((j != 0) && (j <= 4)) {
              break label258;
            }
            return null;
            if (paramString.regionMatches(k, ".", 0, 1))
            {
              if (!decodeIpv4Suffix(paramString, i1, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              paramInt1 = i + 2;
              m = j;
              break;
            }
            return null;
          }
          i = (i << 4) + j;
          paramInt1 += 1;
        }
        label258:
        i1 = n + 1;
        arrayOfByte[n] = ((byte)(i >>> 8 & 0xFF));
        j = i1 + 1;
        arrayOfByte[i1] = ((byte)(i & 0xFF));
        i = j;
        j = m;
        i1 = k;
      }
      System.arraycopy(arrayOfByte, m, arrayOfByte, arrayOfByte.length - (paramInt1 - m), paramInt1 - m);
      Arrays.fill(arrayOfByte, m, arrayOfByte.length - paramInt1 + m, (byte)0);
      try
      {
        label349:
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        throw new AssertionError();
      }
    }
    
    private static String domainToAscii(String paramString)
    {
      try
      {
        paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
        boolean bool = paramString.isEmpty();
        if (bool) {
          paramString = null;
        }
        return paramString;
      }
      catch (IllegalArgumentException paramString) {}
      return null;
    }
    
    private static String inet6AddressToAscii(byte[] paramArrayOfByte)
    {
      int m = -1;
      int k = 0;
      int i = 0;
      int j;
      while (i < paramArrayOfByte.length)
      {
        int n;
        for (j = i;; j = n + 2)
        {
          n = j;
          if ((n >= 16) || (paramArrayOfByte[n] != 0) || (paramArrayOfByte[(n + 1)] != 0)) {
            break;
          }
        }
        int i1 = n - i;
        j = k;
        if (i1 > k)
        {
          j = i1;
          m = i;
        }
        i = n + 2;
        k = j;
      }
      Buffer localBuffer = new Buffer();
      i = 0;
      while (i < paramArrayOfByte.length) {
        if (i == m)
        {
          localBuffer.writeByte(58);
          j = i + k;
          i = j;
          if (j == 16)
          {
            localBuffer.writeByte(58);
            i = j;
          }
        }
        else
        {
          if (i > 0) {
            localBuffer.writeByte(58);
          }
          localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
          i += 2;
        }
      }
      return localBuffer.readUtf8();
    }
    
    private boolean isDot(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }
    
    private boolean isDotDot(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }
    
    private static int parsePort(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(HttpUrl.canonicalize(paramString, paramInt1, paramInt2, "", false, false));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    private void pop()
    {
      if ((((String)this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).isEmpty()) && (!this.encodedPathSegments.isEmpty()))
      {
        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
        return;
      }
      this.encodedPathSegments.add("");
    }
    
    private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
    {
      int i;
      int j;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt1;
      }
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i = paramInt1;
      case '[': 
        for (;;)
        {
          paramInt1 = i + 1;
          break;
          do
          {
            paramInt1 = i + 1;
            i = paramInt1;
            if (paramInt1 >= paramInt2) {
              break;
            }
            i = paramInt1;
          } while (paramString.charAt(paramInt1) != ']');
          i = paramInt1;
        }
        j = paramInt2;
      }
      return j;
    }
    
    private void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = HttpUrl.canonicalize(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false);
      if (isDot(paramString)) {}
      for (;;)
      {
        return;
        if (isDotDot(paramString))
        {
          pop();
          return;
        }
        if (((String)this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).isEmpty()) {
          this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, paramString);
        }
        while (paramBoolean1)
        {
          this.encodedPathSegments.add("");
          return;
          this.encodedPathSegments.add(paramString);
        }
      }
    }
    
    private void removeAllCanonicalQueryParameters(String paramString)
    {
      int i = this.encodedQueryNamesAndValues.size() - 2;
      for (;;)
      {
        if (i >= 0)
        {
          if (paramString.equals(this.encodedQueryNamesAndValues.get(i)))
          {
            this.encodedQueryNamesAndValues.remove(i + 1);
            this.encodedQueryNamesAndValues.remove(i);
            if (this.encodedQueryNamesAndValues.isEmpty()) {
              this.encodedQueryNamesAndValues = null;
            }
          }
        }
        else {
          return;
        }
        i -= 2;
      }
    }
    
    private void resolvePath(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      if ((i == 47) || (i == 92))
      {
        this.encodedPathSegments.clear();
        this.encodedPathSegments.add("");
        paramInt1 += 1;
        label52:
        if (paramInt1 >= paramInt2) {
          break label127;
        }
        i = HttpUrl.delimiterOffset(paramString, paramInt1, paramInt2, "/\\");
        if (i >= paramInt2) {
          break label129;
        }
      }
      label127:
      label129:
      for (boolean bool = true;; bool = false)
      {
        push(paramString, paramInt1, i, bool, true);
        paramInt1 = i;
        if (!bool) {
          break label52;
        }
        paramInt1 = i + 1;
        break label52;
        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
        break label52;
        break;
      }
    }
    
    private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {
        paramInt1 = -1;
      }
      int i;
      do
      {
        return paramInt1;
        i = paramString.charAt(paramInt1);
        if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90))) {
          return -1;
        }
        paramInt1 += 1;
        for (;;)
        {
          if (paramInt1 >= paramInt2) {
            break label115;
          }
          i = paramString.charAt(paramInt1);
          if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && (i != 43) && (i != 45) && (i != 46)) {
            break;
          }
          paramInt1 += 1;
        }
      } while (i == 58);
      return -1;
      label115:
      return -1;
    }
    
    private int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        switch (paramString.charAt(paramInt1))
        {
        default: 
          return paramInt1;
        }
        paramInt1 += 1;
      }
      return paramInt2;
    }
    
    private int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
    {
      paramInt2 -= 1;
      for (;;)
      {
        int i = paramInt1;
        if (paramInt2 >= paramInt1) {}
        switch (paramString.charAt(paramInt2))
        {
        default: 
          i = paramInt2 + 1;
          return i;
        }
        paramInt2 -= 1;
      }
    }
    
    private static int slashCount(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      return i;
    }
    
    public Builder addEncodedPathSegment(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedPathSegment == null");
      }
      push(paramString, 0, paramString.length(), false, true);
      return this;
    }
    
    public Builder addEncodedQueryParameter(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("encodedName == null");
      }
      if (this.encodedQueryNamesAndValues == null) {
        this.encodedQueryNamesAndValues = new ArrayList();
      }
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", true, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null) {}
      for (paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", true, true);; paramString1 = null)
      {
        localList.add(paramString1);
        return this;
      }
    }
    
    public Builder addPathSegment(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("pathSegment == null");
      }
      push(paramString, 0, paramString.length(), false, false);
      return this;
    }
    
    public Builder addQueryParameter(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (this.encodedQueryNamesAndValues == null) {
        this.encodedQueryNamesAndValues = new ArrayList();
      }
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", false, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null) {}
      for (paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", false, true);; paramString1 = null)
      {
        localList.add(paramString1);
        return this;
      }
    }
    
    public HttpUrl build()
    {
      if (this.scheme == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.host == null) {
        throw new IllegalStateException("host == null");
      }
      return new HttpUrl(this, null);
    }
    
    int effectivePort()
    {
      if (this.port != -1) {
        return this.port;
      }
      return HttpUrl.defaultPort(this.scheme);
    }
    
    public Builder encodedFragment(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedFragment == null");
      }
      this.encodedFragment = HttpUrl.canonicalize(paramString, "", true, false);
      return this;
    }
    
    public Builder encodedPassword(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedPassword == null");
      }
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false);
      return this;
    }
    
    public Builder encodedPath(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedPath == null");
      }
      if (!paramString.startsWith("/")) {
        throw new IllegalArgumentException("unexpected encodedPath: " + paramString);
      }
      resolvePath(paramString, 0, paramString.length());
      return this;
    }
    
    public Builder encodedQuery(String paramString)
    {
      if (paramString != null) {}
      for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", true, true));; paramString = null)
      {
        this.encodedQueryNamesAndValues = paramString;
        return this;
      }
    }
    
    public Builder encodedUsername(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedUsername == null");
      }
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false);
      return this;
    }
    
    public Builder fragment(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("fragment == null");
      }
      this.encodedFragment = HttpUrl.canonicalize(paramString, "", false, false);
      return this;
    }
    
    public Builder host(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("host == null");
      }
      String str = canonicalizeHost(paramString, 0, paramString.length());
      if (str == null) {
        throw new IllegalArgumentException("unexpected host: " + paramString);
      }
      this.host = str;
      return this;
    }
    
    HttpUrl parse(HttpUrl paramHttpUrl, String paramString)
    {
      int i = skipLeadingAsciiWhitespace(paramString, 0, paramString.length());
      int i1 = skipTrailingAsciiWhitespace(paramString, i, paramString.length());
      label65:
      int k;
      int n;
      if (schemeDelimiterOffset(paramString, i, i1) != -1) {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.scheme = "https";
          i += "https:".length();
          k = 0;
          j = 0;
          m = slashCount(paramString, i, i1);
          if ((m < 2) && (paramHttpUrl != null) && (paramHttpUrl.scheme.equals(this.scheme))) {
            break label626;
          }
          m = i + m;
          i = j;
          j = m;
          n = HttpUrl.delimiterOffset(paramString, j, i1, "@/\\?#");
          if (n == i1) {
            break label310;
          }
        }
      }
      label310:
      for (int m = paramString.charAt(n);; m = -1) {
        switch (m)
        {
        default: 
          break;
        case -1: 
        case 35: 
        case 47: 
        case 63: 
        case 92: 
          i = portColonOffset(paramString, j, n);
          if (i + 1 >= n) {
            break label475;
          }
          this.host = canonicalizeHost(paramString, j, i);
          this.port = parsePort(paramString, i + 1, n);
          if (this.port != -1) {
            break label497;
          }
          return null;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.scheme = "http";
            i += "http:".length();
            break label65;
          }
          return null;
          if (paramHttpUrl != null)
          {
            this.scheme = paramHttpUrl.scheme;
            break label65;
          }
          return null;
        }
      }
      if (i == 0)
      {
        m = HttpUrl.delimiterOffset(paramString, j, n, ":");
        String str = HttpUrl.canonicalize(paramString, j, m, " \"':;<=>@[]^`{}|/\\?#", true, false);
        paramHttpUrl = str;
        if (k != 0) {
          paramHttpUrl = this.encodedUsername + "%40" + str;
        }
        this.encodedUsername = paramHttpUrl;
        if (m != n)
        {
          i = 1;
          this.encodedPassword = HttpUrl.canonicalize(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false);
        }
        k = 1;
      }
      for (;;)
      {
        j = n + 1;
        break;
        this.encodedPassword = (this.encodedPassword + "%40" + HttpUrl.canonicalize(paramString, j, n, " \"':;<=>@[]^`{}|/\\?#", true, false));
      }
      label475:
      this.host = canonicalizeHost(paramString, j, i);
      this.port = HttpUrl.defaultPort(this.scheme);
      label497:
      if (this.host == null) {
        return null;
      }
      int j = n;
      for (;;)
      {
        i = HttpUrl.delimiterOffset(paramString, j, i1, "?#");
        resolvePath(paramString, j, i);
        j = i;
        if (i < i1)
        {
          j = i;
          if (paramString.charAt(i) == '?')
          {
            j = HttpUrl.delimiterOffset(paramString, i, i1, "#");
            this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, i + 1, j, " \"'<>#", true, true));
          }
        }
        if ((j < i1) && (paramString.charAt(j) == '#')) {
          this.encodedFragment = HttpUrl.canonicalize(paramString, j + 1, i1, "", true, false);
        }
        return build();
        label626:
        this.encodedUsername = paramHttpUrl.encodedUsername();
        this.encodedPassword = paramHttpUrl.encodedPassword();
        this.host = paramHttpUrl.host;
        this.port = paramHttpUrl.port;
        this.encodedPathSegments.clear();
        this.encodedPathSegments.addAll(paramHttpUrl.encodedPathSegments());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {}
        }
        else
        {
          encodedQuery(paramHttpUrl.encodedQuery());
          j = i;
        }
      }
    }
    
    public Builder password(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("password == null");
      }
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false);
      return this;
    }
    
    public Builder port(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > 65535)) {
        throw new IllegalArgumentException("unexpected port: " + paramInt);
      }
      this.port = paramInt;
      return this;
    }
    
    public Builder query(String paramString)
    {
      if (paramString != null) {}
      for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", false, true));; paramString = null)
      {
        this.encodedQueryNamesAndValues = paramString;
        return this;
      }
    }
    
    public Builder removeAllEncodedQueryParameters(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedName == null");
      }
      if (this.encodedQueryNamesAndValues == null) {
        return this;
      }
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", true, true));
      return this;
    }
    
    public Builder removeAllQueryParameters(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (this.encodedQueryNamesAndValues == null) {
        return this;
      }
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", false, true));
      return this;
    }
    
    public Builder removePathSegment(int paramInt)
    {
      this.encodedPathSegments.remove(paramInt);
      if (this.encodedPathSegments.isEmpty()) {
        this.encodedPathSegments.add("");
      }
      return this;
    }
    
    public Builder scheme(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("scheme == null");
      }
      if (paramString.equalsIgnoreCase("http"))
      {
        this.scheme = "http";
        return this;
      }
      if (paramString.equalsIgnoreCase("https"))
      {
        this.scheme = "https";
        return this;
      }
      throw new IllegalArgumentException("unexpected scheme: " + paramString);
    }
    
    public Builder setEncodedPathSegment(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("encodedPathSegment == null");
      }
      String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false);
      this.encodedPathSegments.set(paramInt, str);
      if ((isDot(str)) || (isDotDot(str))) {
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      }
      return this;
    }
    
    public Builder setEncodedQueryParameter(String paramString1, String paramString2)
    {
      removeAllEncodedQueryParameters(paramString1);
      addEncodedQueryParameter(paramString1, paramString2);
      return this;
    }
    
    public Builder setPathSegment(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("pathSegment == null");
      }
      String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false);
      if ((isDot(str)) || (isDotDot(str))) {
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      }
      this.encodedPathSegments.set(paramInt, str);
      return this;
    }
    
    public Builder setQueryParameter(String paramString1, String paramString2)
    {
      removeAllQueryParameters(paramString1);
      addQueryParameter(paramString1, paramString2);
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.scheme);
      localStringBuilder.append("://");
      if ((!this.encodedUsername.isEmpty()) || (!this.encodedPassword.isEmpty()))
      {
        localStringBuilder.append(this.encodedUsername);
        if (!this.encodedPassword.isEmpty())
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.encodedPassword);
        }
        localStringBuilder.append('@');
      }
      if (this.host.indexOf(':') != -1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.host);
        localStringBuilder.append(']');
      }
      for (;;)
      {
        int i = effectivePort();
        if (i != HttpUrl.defaultPort(this.scheme))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        HttpUrl.pathSegmentsToString(localStringBuilder, this.encodedPathSegments);
        if (this.encodedQueryNamesAndValues != null)
        {
          localStringBuilder.append('?');
          HttpUrl.namesAndValuesToQueryString(localStringBuilder, this.encodedQueryNamesAndValues);
        }
        if (this.encodedFragment != null)
        {
          localStringBuilder.append('#');
          localStringBuilder.append(this.encodedFragment);
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.host);
      }
    }
    
    public Builder username(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("username == null");
      }
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/HttpUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */