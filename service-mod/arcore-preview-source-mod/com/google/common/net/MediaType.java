package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap.Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
public final class MediaType
{
  public static final MediaType ANY_APPLICATION_TYPE;
  public static final MediaType ANY_AUDIO_TYPE;
  public static final MediaType ANY_IMAGE_TYPE;
  public static final MediaType ANY_TEXT_TYPE;
  public static final MediaType ANY_TYPE;
  public static final MediaType ANY_VIDEO_TYPE;
  public static final MediaType APPLE_MOBILE_CONFIG;
  public static final MediaType APPLE_PASSBOOK;
  public static final MediaType APPLICATION_BINARY;
  private static final String APPLICATION_TYPE = "application";
  public static final MediaType APPLICATION_XML_UTF_8;
  public static final MediaType ATOM_UTF_8;
  private static final String AUDIO_TYPE = "audio";
  public static final MediaType BMP;
  public static final MediaType BZIP2;
  public static final MediaType CACHE_MANIFEST_UTF_8;
  private static final String CHARSET_ATTRIBUTE = "charset";
  public static final MediaType CRW;
  public static final MediaType CSS_UTF_8;
  public static final MediaType CSV_UTF_8;
  public static final MediaType DART_UTF_8;
  public static final MediaType EOT;
  public static final MediaType EPUB;
  public static final MediaType FORM_DATA;
  public static final MediaType GIF;
  public static final MediaType GZIP;
  public static final MediaType HTML_UTF_8;
  public static final MediaType ICO;
  private static final String IMAGE_TYPE = "image";
  public static final MediaType I_CALENDAR_UTF_8;
  public static final MediaType JAVASCRIPT_UTF_8;
  public static final MediaType JPEG;
  public static final MediaType JSON_UTF_8;
  public static final MediaType KEY_ARCHIVE;
  public static final MediaType KML;
  public static final MediaType KMZ;
  private static final Map<MediaType, MediaType> KNOWN_TYPES;
  private static final CharMatcher LINEAR_WHITE_SPACE;
  public static final MediaType MANIFEST_JSON_UTF_8;
  public static final MediaType MBOX;
  public static final MediaType MICROSOFT_EXCEL;
  public static final MediaType MICROSOFT_POWERPOINT;
  public static final MediaType MICROSOFT_WORD;
  public static final MediaType MP4_AUDIO;
  public static final MediaType MP4_VIDEO;
  public static final MediaType MPEG_AUDIO;
  public static final MediaType MPEG_VIDEO;
  public static final MediaType OCTET_STREAM;
  public static final MediaType OGG_AUDIO;
  public static final MediaType OGG_CONTAINER;
  public static final MediaType OGG_VIDEO;
  public static final MediaType OOXML_DOCUMENT;
  public static final MediaType OOXML_PRESENTATION;
  public static final MediaType OOXML_SHEET;
  public static final MediaType OPENDOCUMENT_GRAPHICS;
  public static final MediaType OPENDOCUMENT_PRESENTATION;
  public static final MediaType OPENDOCUMENT_SPREADSHEET;
  public static final MediaType OPENDOCUMENT_TEXT;
  private static final Joiner.MapJoiner PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
  public static final MediaType PDF;
  public static final MediaType PLAIN_TEXT_UTF_8;
  public static final MediaType PNG;
  public static final MediaType POSTSCRIPT;
  public static final MediaType PROTOBUF;
  public static final MediaType PSD;
  public static final MediaType QUICKTIME;
  private static final CharMatcher QUOTED_TEXT_MATCHER;
  public static final MediaType RDF_XML_UTF_8;
  public static final MediaType RTF_UTF_8;
  public static final MediaType SFNT;
  public static final MediaType SHOCKWAVE_FLASH;
  public static final MediaType SKETCHUP;
  public static final MediaType SVG_UTF_8;
  public static final MediaType TAR;
  public static final MediaType TEXT_JAVASCRIPT_UTF_8;
  private static final String TEXT_TYPE = "text";
  public static final MediaType TIFF;
  private static final CharMatcher TOKEN_MATCHER;
  public static final MediaType TSV_UTF_8;
  private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));
  public static final MediaType VCARD_UTF_8;
  private static final String VIDEO_TYPE = "video";
  public static final MediaType WEBM_AUDIO;
  public static final MediaType WEBM_VIDEO;
  public static final MediaType WEBP;
  private static final String WILDCARD = "*";
  public static final MediaType WML_UTF_8;
  public static final MediaType WMV;
  public static final MediaType WOFF;
  public static final MediaType XHTML_UTF_8;
  public static final MediaType XML_UTF_8;
  public static final MediaType XRD_UTF_8;
  public static final MediaType ZIP;
  private int hashCode;
  private final ImmutableListMultimap<String, String> parameters;
  private final String subtype;
  private String toString;
  private final String type;
  
  static
  {
    TOKEN_MATCHER = CharMatcher.ASCII.and(CharMatcher.JAVA_ISO_CONTROL.negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    QUOTED_TEXT_MATCHER = CharMatcher.ASCII.and(CharMatcher.noneOf("\"\\\r"));
    LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    KNOWN_TYPES = Maps.newHashMap();
    ANY_TYPE = createConstant("*", "*");
    ANY_TEXT_TYPE = createConstant("text", "*");
    ANY_IMAGE_TYPE = createConstant("image", "*");
    ANY_AUDIO_TYPE = createConstant("audio", "*");
    ANY_VIDEO_TYPE = createConstant("video", "*");
    ANY_APPLICATION_TYPE = createConstant("application", "*");
    CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
    CSS_UTF_8 = createConstantUtf8("text", "css");
    CSV_UTF_8 = createConstantUtf8("text", "csv");
    HTML_UTF_8 = createConstantUtf8("text", "html");
    I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
    PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
    TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
    TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
    VCARD_UTF_8 = createConstantUtf8("text", "vcard");
    WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
    XML_UTF_8 = createConstantUtf8("text", "xml");
    BMP = createConstant("image", "bmp");
    CRW = createConstant("image", "x-canon-crw");
    GIF = createConstant("image", "gif");
    ICO = createConstant("image", "vnd.microsoft.icon");
    JPEG = createConstant("image", "jpeg");
    PNG = createConstant("image", "png");
    PSD = createConstant("image", "vnd.adobe.photoshop");
    SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
    TIFF = createConstant("image", "tiff");
    WEBP = createConstant("image", "webp");
    MP4_AUDIO = createConstant("audio", "mp4");
    MPEG_AUDIO = createConstant("audio", "mpeg");
    OGG_AUDIO = createConstant("audio", "ogg");
    WEBM_AUDIO = createConstant("audio", "webm");
    MP4_VIDEO = createConstant("video", "mp4");
    MPEG_VIDEO = createConstant("video", "mpeg");
    OGG_VIDEO = createConstant("video", "ogg");
    QUICKTIME = createConstant("video", "quicktime");
    WEBM_VIDEO = createConstant("video", "webm");
    WMV = createConstant("video", "x-ms-wmv");
    APPLICATION_XML_UTF_8 = createConstantUtf8("application", "xml");
    ATOM_UTF_8 = createConstantUtf8("application", "atom+xml");
    BZIP2 = createConstant("application", "x-bzip2");
    DART_UTF_8 = createConstantUtf8("application", "dart");
    APPLE_PASSBOOK = createConstant("application", "vnd.apple.pkpass");
    EOT = createConstant("application", "vnd.ms-fontobject");
    EPUB = createConstant("application", "epub+zip");
    FORM_DATA = createConstant("application", "x-www-form-urlencoded");
    KEY_ARCHIVE = createConstant("application", "pkcs12");
    APPLICATION_BINARY = createConstant("application", "binary");
    GZIP = createConstant("application", "x-gzip");
    JAVASCRIPT_UTF_8 = createConstantUtf8("application", "javascript");
    JSON_UTF_8 = createConstantUtf8("application", "json");
    MANIFEST_JSON_UTF_8 = createConstantUtf8("application", "manifest+json");
    KML = createConstant("application", "vnd.google-earth.kml+xml");
    KMZ = createConstant("application", "vnd.google-earth.kmz");
    MBOX = createConstant("application", "mbox");
    APPLE_MOBILE_CONFIG = createConstant("application", "x-apple-aspen-config");
    MICROSOFT_EXCEL = createConstant("application", "vnd.ms-excel");
    MICROSOFT_POWERPOINT = createConstant("application", "vnd.ms-powerpoint");
    MICROSOFT_WORD = createConstant("application", "msword");
    OCTET_STREAM = createConstant("application", "octet-stream");
    OGG_CONTAINER = createConstant("application", "ogg");
    OOXML_DOCUMENT = createConstant("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    OOXML_PRESENTATION = createConstant("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    OOXML_SHEET = createConstant("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    OPENDOCUMENT_GRAPHICS = createConstant("application", "vnd.oasis.opendocument.graphics");
    OPENDOCUMENT_PRESENTATION = createConstant("application", "vnd.oasis.opendocument.presentation");
    OPENDOCUMENT_SPREADSHEET = createConstant("application", "vnd.oasis.opendocument.spreadsheet");
    OPENDOCUMENT_TEXT = createConstant("application", "vnd.oasis.opendocument.text");
    PDF = createConstant("application", "pdf");
    POSTSCRIPT = createConstant("application", "postscript");
    PROTOBUF = createConstant("application", "protobuf");
    RDF_XML_UTF_8 = createConstantUtf8("application", "rdf+xml");
    RTF_UTF_8 = createConstantUtf8("application", "rtf");
    SFNT = createConstant("application", "font-sfnt");
    SHOCKWAVE_FLASH = createConstant("application", "x-shockwave-flash");
    SKETCHUP = createConstant("application", "vnd.sketchup.skp");
    TAR = createConstant("application", "x-tar");
    WOFF = createConstant("application", "font-woff");
    XHTML_UTF_8 = createConstantUtf8("application", "xhtml+xml");
    XRD_UTF_8 = createConstantUtf8("application", "xrd+xml");
    ZIP = createConstant("application", "zip");
  }
  
  private MediaType(String paramString1, String paramString2, ImmutableListMultimap<String, String> paramImmutableListMultimap)
  {
    this.type = paramString1;
    this.subtype = paramString2;
    this.parameters = paramImmutableListMultimap;
  }
  
  private static MediaType addKnownType(MediaType paramMediaType)
  {
    KNOWN_TYPES.put(paramMediaType, paramMediaType);
    return paramMediaType;
  }
  
  private String computeToString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.type).append('/').append(this.subtype);
    if (!this.parameters.isEmpty())
    {
      localStringBuilder.append("; ");
      ListMultimap localListMultimap = Multimaps.transformValues(this.parameters, new Function()
      {
        public String apply(String paramAnonymousString)
        {
          if (MediaType.TOKEN_MATCHER.matchesAllOf(paramAnonymousString)) {
            return paramAnonymousString;
          }
          return MediaType.escapeAndQuote(paramAnonymousString);
        }
      });
      PARAMETER_JOINER.appendTo(localStringBuilder, localListMultimap.entries());
    }
    return localStringBuilder.toString();
  }
  
  public static MediaType create(String paramString1, String paramString2)
  {
    return create(paramString1, paramString2, ImmutableListMultimap.of());
  }
  
  private static MediaType create(String paramString1, String paramString2, Multimap<String, String> paramMultimap)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    Preconditions.checkNotNull(paramMultimap);
    paramString1 = normalizeToken(paramString1);
    paramString2 = normalizeToken(paramString2);
    if ((!"*".equals(paramString1)) || ("*".equals(paramString2))) {}
    ImmutableListMultimap.Builder localBuilder;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "A wildcard type cannot be used with a non-wildcard subtype");
      localBuilder = ImmutableListMultimap.builder();
      paramMultimap = paramMultimap.entries().iterator();
      while (paramMultimap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMultimap.next();
        String str = normalizeToken((String)localEntry.getKey());
        localBuilder.put(str, normalizeParameterValue(str, (String)localEntry.getValue()));
      }
    }
    paramString1 = new MediaType(paramString1, paramString2, localBuilder.build());
    return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(paramString1), paramString1);
  }
  
  static MediaType createApplicationType(String paramString)
  {
    return create("application", paramString);
  }
  
  static MediaType createAudioType(String paramString)
  {
    return create("audio", paramString);
  }
  
  private static MediaType createConstant(String paramString1, String paramString2)
  {
    return addKnownType(new MediaType(paramString1, paramString2, ImmutableListMultimap.of()));
  }
  
  private static MediaType createConstantUtf8(String paramString1, String paramString2)
  {
    return addKnownType(new MediaType(paramString1, paramString2, UTF_8_CONSTANT_PARAMETERS));
  }
  
  static MediaType createImageType(String paramString)
  {
    return create("image", paramString);
  }
  
  static MediaType createTextType(String paramString)
  {
    return create("text", paramString);
  }
  
  static MediaType createVideoType(String paramString)
  {
    return create("video", paramString);
  }
  
  private static String escapeAndQuote(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 16).append('"');
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((c == '\r') || (c == '\\') || (c == '"')) {
        localStringBuilder.append('\\');
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return '"';
  }
  
  private static String normalizeParameterValue(String paramString1, String paramString2)
  {
    String str = paramString2;
    if ("charset".equals(paramString1)) {
      str = Ascii.toLowerCase(paramString2);
    }
    return str;
  }
  
  private static String normalizeToken(String paramString)
  {
    Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(paramString));
    return Ascii.toLowerCase(paramString);
  }
  
  private Map<String, ImmutableMultiset<String>> parametersAsMap()
  {
    Maps.transformValues(this.parameters.asMap(), new Function()
    {
      public ImmutableMultiset<String> apply(Collection<String> paramAnonymousCollection)
      {
        return ImmutableMultiset.copyOf(paramAnonymousCollection);
      }
    });
  }
  
  public static MediaType parse(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    Tokenizer localTokenizer = new Tokenizer(paramString);
    String str1;
    String str2;
    ImmutableListMultimap.Builder localBuilder;
    String str3;
    for (;;)
    {
      try
      {
        str1 = localTokenizer.consumeToken(TOKEN_MATCHER);
        localTokenizer.consumeCharacter('/');
        str2 = localTokenizer.consumeToken(TOKEN_MATCHER);
        localBuilder = ImmutableListMultimap.builder();
        if (!localTokenizer.hasMore()) {
          break label231;
        }
        localTokenizer.consumeCharacter(';');
        localTokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
        str3 = localTokenizer.consumeToken(TOKEN_MATCHER);
        localTokenizer.consumeCharacter('=');
        if ('"' != localTokenizer.previewChar()) {
          break label220;
        }
        localTokenizer.consumeCharacter('"');
        StringBuilder localStringBuilder = new StringBuilder();
        if ('"' == localTokenizer.previewChar()) {
          break;
        }
        if ('\\' == localTokenizer.previewChar())
        {
          localTokenizer.consumeCharacter('\\');
          localStringBuilder.append(localTokenizer.consumeCharacter(CharMatcher.ASCII));
        }
        else
        {
          localIllegalStateException.append(localTokenizer.consumeToken(QUOTED_TEXT_MATCHER));
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        throw new IllegalArgumentException("Could not parse '" + paramString + "'", localIllegalStateException);
      }
    }
    Object localObject = localIllegalStateException.toString();
    localTokenizer.consumeCharacter('"');
    for (;;)
    {
      localBuilder.put(str3, localObject);
      break;
      label220:
      localObject = localTokenizer.consumeToken(TOKEN_MATCHER);
    }
    label231:
    localObject = create(str1, str2, localBuilder.build());
    return (MediaType)localObject;
  }
  
  public Optional<Charset> charset()
  {
    ImmutableSet localImmutableSet = ImmutableSet.copyOf(this.parameters.get("charset"));
    switch (localImmutableSet.size())
    {
    default: 
      throw new IllegalStateException("Multiple charset values defined: " + localImmutableSet);
    case 0: 
      return Optional.absent();
    }
    return Optional.of(Charset.forName((String)Iterables.getOnlyElement(localImmutableSet)));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof MediaType)) {
        break;
      }
      paramObject = (MediaType)paramObject;
    } while ((this.type.equals(((MediaType)paramObject).type)) && (this.subtype.equals(((MediaType)paramObject).subtype)) && (parametersAsMap().equals(((MediaType)paramObject).parametersAsMap())));
    return false;
    return false;
  }
  
  public boolean hasWildcard()
  {
    return ("*".equals(this.type)) || ("*".equals(this.subtype));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = Objects.hashCode(new Object[] { this.type, this.subtype, parametersAsMap() });
      this.hashCode = i;
    }
    return i;
  }
  
  public boolean is(MediaType paramMediaType)
  {
    return ((paramMediaType.type.equals("*")) || (paramMediaType.type.equals(this.type))) && ((paramMediaType.subtype.equals("*")) || (paramMediaType.subtype.equals(this.subtype))) && (this.parameters.entries().containsAll(paramMediaType.parameters.entries()));
  }
  
  public ImmutableListMultimap<String, String> parameters()
  {
    return this.parameters;
  }
  
  public String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    String str2 = this.toString;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = computeToString();
      this.toString = str1;
    }
    return str1;
  }
  
  public String type()
  {
    return this.type;
  }
  
  public MediaType withCharset(Charset paramCharset)
  {
    Preconditions.checkNotNull(paramCharset);
    return withParameter("charset", paramCharset.name());
  }
  
  public MediaType withParameter(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    paramString1 = normalizeToken(paramString1);
    ImmutableListMultimap.Builder localBuilder = ImmutableListMultimap.builder();
    Iterator localIterator = this.parameters.entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!paramString1.equals(str)) {
        localBuilder.put(str, localEntry.getValue());
      }
    }
    localBuilder.put(paramString1, normalizeParameterValue(paramString1, paramString2));
    paramString1 = new MediaType(this.type, this.subtype, localBuilder.build());
    return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(paramString1), paramString1);
  }
  
  public MediaType withParameters(Multimap<String, String> paramMultimap)
  {
    return create(this.type, this.subtype, paramMultimap);
  }
  
  public MediaType withoutParameters()
  {
    if (this.parameters.isEmpty()) {
      return this;
    }
    return create(this.type, this.subtype);
  }
  
  private static final class Tokenizer
  {
    final String input;
    int position = 0;
    
    Tokenizer(String paramString)
    {
      this.input = paramString;
    }
    
    char consumeCharacter(char paramChar)
    {
      Preconditions.checkState(hasMore());
      if (previewChar() == paramChar) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        this.position += 1;
        return paramChar;
      }
    }
    
    char consumeCharacter(CharMatcher paramCharMatcher)
    {
      Preconditions.checkState(hasMore());
      char c = previewChar();
      Preconditions.checkState(paramCharMatcher.matches(c));
      this.position += 1;
      return c;
    }
    
    String consumeToken(CharMatcher paramCharMatcher)
    {
      int i = this.position;
      paramCharMatcher = consumeTokenIfPresent(paramCharMatcher);
      if (this.position != i) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        return paramCharMatcher;
      }
    }
    
    String consumeTokenIfPresent(CharMatcher paramCharMatcher)
    {
      Preconditions.checkState(hasMore());
      int i = this.position;
      this.position = paramCharMatcher.negate().indexIn(this.input, i);
      if (hasMore()) {
        return this.input.substring(i, this.position);
      }
      return this.input.substring(i);
    }
    
    boolean hasMore()
    {
      return (this.position >= 0) && (this.position < this.input.length());
    }
    
    char previewChar()
    {
      Preconditions.checkState(hasMore());
      return this.input.charAt(this.position);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/net/MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */