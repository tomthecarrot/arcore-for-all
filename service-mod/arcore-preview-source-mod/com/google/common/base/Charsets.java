package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated=true)
public final class Charsets
{
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset ISO_8859_1;
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16 = Charset.forName("UTF-16");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16BE;
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16LE;
  public static final Charset UTF_8;
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    UTF_8 = Charset.forName("UTF-8");
    UTF_16BE = Charset.forName("UTF-16BE");
    UTF_16LE = Charset.forName("UTF-16LE");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Charsets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */