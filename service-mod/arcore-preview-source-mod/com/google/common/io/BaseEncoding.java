package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public abstract class BaseEncoding
{
  private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
  private static final BaseEncoding BASE32;
  private static final BaseEncoding BASE32_HEX;
  private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
  private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
  
  static
  {
    BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
  }
  
  public static BaseEncoding base16()
  {
    return BASE16;
  }
  
  public static BaseEncoding base32()
  {
    return BASE32;
  }
  
  public static BaseEncoding base32Hex()
  {
    return BASE32_HEX;
  }
  
  public static BaseEncoding base64()
  {
    return BASE64;
  }
  
  public static BaseEncoding base64Url()
  {
    return BASE64_URL;
  }
  
  private static byte[] extract(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  @GwtIncompatible("Reader")
  static Reader ignoringReader(Reader paramReader, final CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramReader);
    Preconditions.checkNotNull(paramCharMatcher);
    new Reader()
    {
      public void close()
        throws IOException
      {
        this.val$delegate.close();
      }
      
      public int read()
        throws IOException
      {
        int i;
        do
        {
          i = this.val$delegate.read();
        } while ((i != -1) && (paramCharMatcher.matches((char)i)));
        return i;
      }
      
      public int read(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  static Appendable separatingAppendable(final Appendable paramAppendable, final String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramAppendable);
    Preconditions.checkNotNull(paramString);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      new Appendable()
      {
        int charsUntilSeparator = this.val$afterEveryChars;
        
        public Appendable append(char paramAnonymousChar)
          throws IOException
        {
          if (this.charsUntilSeparator == 0)
          {
            paramAppendable.append(paramString);
            this.charsUntilSeparator = this.val$afterEveryChars;
          }
          paramAppendable.append(paramAnonymousChar);
          this.charsUntilSeparator -= 1;
          return this;
        }
        
        public Appendable append(CharSequence paramAnonymousCharSequence)
          throws IOException
        {
          throw new UnsupportedOperationException();
        }
        
        public Appendable append(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          throw new UnsupportedOperationException();
        }
      };
    }
  }
  
  @GwtIncompatible("Writer")
  static Writer separatingWriter(final Writer paramWriter, String paramString, int paramInt)
  {
    new Writer()
    {
      public void close()
        throws IOException
      {
        paramWriter.close();
      }
      
      public void flush()
        throws IOException
      {
        paramWriter.flush();
      }
      
      public void write(int paramAnonymousInt)
        throws IOException
      {
        this.val$seperatingAppendable.append((char)paramAnonymousInt);
      }
      
      public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public final byte[] decode(CharSequence paramCharSequence)
  {
    try
    {
      paramCharSequence = decodeChecked(paramCharSequence);
      return paramCharSequence;
    }
    catch (DecodingException paramCharSequence)
    {
      throw new IllegalArgumentException(paramCharSequence);
    }
  }
  
  final byte[] decodeChecked(CharSequence paramCharSequence)
    throws BaseEncoding.DecodingException
  {
    paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
    byte[] arrayOfByte = new byte[maxDecodedSize(paramCharSequence.length())];
    return extract(arrayOfByte, decodeTo(arrayOfByte, paramCharSequence));
  }
  
  abstract int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
    throws BaseEncoding.DecodingException;
  
  @GwtIncompatible("ByteSource,CharSource")
  public final ByteSource decodingSource(final CharSource paramCharSource)
  {
    Preconditions.checkNotNull(paramCharSource);
    new ByteSource()
    {
      public InputStream openStream()
        throws IOException
      {
        return BaseEncoding.this.decodingStream(paramCharSource.openStream());
      }
    };
  }
  
  @GwtIncompatible("Reader,InputStream")
  public abstract InputStream decodingStream(Reader paramReader);
  
  public String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final String encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    StringBuilder localStringBuilder = new StringBuilder(maxEncodedSize(paramInt2));
    try
    {
      encodeTo(localStringBuilder, paramArrayOfByte, paramInt1, paramInt2);
      return localStringBuilder.toString();
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  abstract void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  @GwtIncompatible("ByteSink,CharSink")
  public final ByteSink encodingSink(final CharSink paramCharSink)
  {
    Preconditions.checkNotNull(paramCharSink);
    new ByteSink()
    {
      public OutputStream openStream()
        throws IOException
      {
        return BaseEncoding.this.encodingStream(paramCharSink.openStream());
      }
    };
  }
  
  @GwtIncompatible("Writer,OutputStream")
  public abstract OutputStream encodingStream(Writer paramWriter);
  
  @CheckReturnValue
  public abstract BaseEncoding lowerCase();
  
  abstract int maxDecodedSize(int paramInt);
  
  abstract int maxEncodedSize(int paramInt);
  
  @CheckReturnValue
  public abstract BaseEncoding omitPadding();
  
  abstract CharMatcher padding();
  
  @CheckReturnValue
  public abstract BaseEncoding upperCase();
  
  @CheckReturnValue
  public abstract BaseEncoding withPadChar(char paramChar);
  
  @CheckReturnValue
  public abstract BaseEncoding withSeparator(String paramString, int paramInt);
  
  private static final class Alphabet
    extends CharMatcher
  {
    final int bitsPerChar;
    final int bytesPerChunk;
    private final char[] chars;
    final int charsPerChunk;
    private final byte[] decodabet;
    final int mask;
    private final String name;
    private final boolean[] validPadding;
    
    Alphabet(String paramString, char[] paramArrayOfChar)
    {
      this.name = ((String)Preconditions.checkNotNull(paramString));
      this.chars = ((char[])Preconditions.checkNotNull(paramArrayOfChar));
      for (;;)
      {
        try
        {
          this.bitsPerChar = IntMath.log2(paramArrayOfChar.length, RoundingMode.UNNECESSARY);
          i = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
          this.charsPerChunk = (8 / i);
          this.bytesPerChunk = (this.bitsPerChar / i);
          this.mask = (paramArrayOfChar.length - 1);
          paramString = new byte[''];
          Arrays.fill(paramString, (byte)-1);
          i = 0;
          if (i >= paramArrayOfChar.length) {
            break;
          }
          char c = paramArrayOfChar[i];
          Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", new Object[] { Character.valueOf(c) });
          boolean bool;
          if (paramString[c] == -1)
          {
            bool = true;
            Preconditions.checkArgument(bool, "Duplicate character: %s", new Object[] { Character.valueOf(c) });
            paramString[c] = ((byte)i);
            i += 1;
          }
          else
          {
            bool = false;
          }
        }
        catch (ArithmeticException paramString)
        {
          throw new IllegalArgumentException("Illegal alphabet length " + paramArrayOfChar.length, paramString);
        }
      }
      this.decodabet = paramString;
      paramString = new boolean[this.charsPerChunk];
      int i = 0;
      while (i < this.bytesPerChunk)
      {
        paramString[IntMath.divide(i * 8, this.bitsPerChar, RoundingMode.CEILING)] = 1;
        i += 1;
      }
      this.validPadding = paramString;
    }
    
    private boolean hasLowerCase()
    {
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        if (Ascii.isLowerCase(arrayOfChar[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private boolean hasUpperCase()
    {
      char[] arrayOfChar = this.chars;
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        if (Ascii.isUpperCase(arrayOfChar[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    int decode(char paramChar)
      throws BaseEncoding.DecodingException
    {
      if ((paramChar > '') || (this.decodabet[paramChar] == -1))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Unrecognized character: ");
        if (CharMatcher.INVISIBLE.matches(paramChar)) {}
        for (Object localObject = "0x" + Integer.toHexString(paramChar);; localObject = Character.valueOf(paramChar)) {
          throw new BaseEncoding.DecodingException(localObject);
        }
      }
      return this.decodabet[paramChar];
    }
    
    char encode(int paramInt)
    {
      return this.chars[paramInt];
    }
    
    boolean isValidPaddingStartPosition(int paramInt)
    {
      return this.validPadding[(paramInt % this.charsPerChunk)];
    }
    
    Alphabet lowerCase()
    {
      if (!hasUpperCase()) {
        return this;
      }
      if (!hasLowerCase()) {}
      char[] arrayOfChar;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot call lowerCase() on a mixed-case alphabet");
        arrayOfChar = new char[this.chars.length];
        int i = 0;
        while (i < this.chars.length)
        {
          arrayOfChar[i] = Ascii.toLowerCase(this.chars[i]);
          i += 1;
        }
      }
      return new Alphabet(this.name + ".lowerCase()", arrayOfChar);
    }
    
    public boolean matches(char paramChar)
    {
      return (CharMatcher.ASCII.matches(paramChar)) && (this.decodabet[paramChar] != -1);
    }
    
    public String toString()
    {
      return this.name;
    }
    
    Alphabet upperCase()
    {
      if (!hasLowerCase()) {
        return this;
      }
      if (!hasUpperCase()) {}
      char[] arrayOfChar;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot call upperCase() on a mixed-case alphabet");
        arrayOfChar = new char[this.chars.length];
        int i = 0;
        while (i < this.chars.length)
        {
          arrayOfChar[i] = Ascii.toUpperCase(this.chars[i]);
          i += 1;
        }
      }
      return new Alphabet(this.name + ".upperCase()", arrayOfChar);
    }
  }
  
  static final class Base16Encoding
    extends BaseEncoding.StandardBaseEncoding
  {
    final char[] encoding = new char['Ȁ'];
    
    private Base16Encoding(BaseEncoding.Alphabet paramAlphabet)
    {
      super(null);
      if (paramAlphabet.chars.length == 16) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        int i = 0;
        while (i < 256)
        {
          this.encoding[i] = paramAlphabet.encode(i >>> 4);
          this.encoding[(i | 0x100)] = paramAlphabet.encode(i & 0xF);
          i += 1;
        }
      }
    }
    
    Base16Encoding(String paramString1, String paramString2)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()));
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      if (paramCharSequence.length() % 2 == 1) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int i = 0;
      int j = 0;
      while (j < paramCharSequence.length())
      {
        paramArrayOfByte[i] = ((byte)(this.alphabet.decode(paramCharSequence.charAt(j)) << 4 | this.alphabet.decode(paramCharSequence.charAt(j + 1))));
        j += 2;
        i += 1;
      }
      return i;
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = 0;
      while (i < paramInt2)
      {
        int j = paramArrayOfByte[(paramInt1 + i)] & 0xFF;
        paramAppendable.append(this.encoding[j]);
        paramAppendable.append(this.encoding[(j | 0x100)]);
        i += 1;
      }
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new Base16Encoding(paramAlphabet);
    }
  }
  
  static final class Base64Encoding
    extends BaseEncoding.StandardBaseEncoding
  {
    private Base64Encoding(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      super(paramCharacter);
      if (paramAlphabet.chars.length == 64) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    Base64Encoding(String paramString1, String paramString2, @Nullable Character paramCharacter)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()), paramCharacter);
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(paramCharSequence.length())) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int i = 0;
      int j = 0;
      label293:
      for (;;)
      {
        if (j < paramCharSequence.length())
        {
          BaseEncoding.Alphabet localAlphabet = this.alphabet;
          int m = j + 1;
          j = localAlphabet.decode(paramCharSequence.charAt(j));
          localAlphabet = this.alphabet;
          int k = m + 1;
          int n = j << 18 | localAlphabet.decode(paramCharSequence.charAt(m)) << 12;
          m = i + 1;
          paramArrayOfByte[i] = ((byte)(n >>> 16));
          i = m;
          j = k;
          if (k < paramCharSequence.length())
          {
            localAlphabet = this.alphabet;
            j = k + 1;
            n |= localAlphabet.decode(paramCharSequence.charAt(k)) << 6;
            i = m + 1;
            paramArrayOfByte[m] = ((byte)(n >>> 8 & 0xFF));
            if (j >= paramCharSequence.length()) {
              break label293;
            }
            localAlphabet = this.alphabet;
            k = j + 1;
            j = localAlphabet.decode(paramCharSequence.charAt(j));
            m = i + 1;
            paramArrayOfByte[i] = ((byte)((n | j) & 0xFF));
            j = k;
            i = m;
          }
        }
        else
        {
          return i;
        }
      }
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = paramInt2;
      int j = paramInt1;
      while (i >= 3)
      {
        int k = j + 1;
        int m = paramArrayOfByte[j];
        j = k + 1;
        k = (m & 0xFF) << 16 | (paramArrayOfByte[k] & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF;
        paramAppendable.append(this.alphabet.encode(k >>> 18));
        paramAppendable.append(this.alphabet.encode(k >>> 12 & 0x3F));
        paramAppendable.append(this.alphabet.encode(k >>> 6 & 0x3F));
        paramAppendable.append(this.alphabet.encode(k & 0x3F));
        i -= 3;
        j += 1;
      }
      if (j < paramInt1 + paramInt2) {
        encodeChunkTo(paramAppendable, paramArrayOfByte, j, paramInt1 + paramInt2 - j);
      }
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new Base64Encoding(paramAlphabet, paramCharacter);
    }
  }
  
  public static final class DecodingException
    extends IOException
  {
    DecodingException(String paramString)
    {
      super();
    }
    
    DecodingException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  static final class SeparatedBaseEncoding
    extends BaseEncoding
  {
    private final int afterEveryChars;
    private final BaseEncoding delegate;
    private final String separator;
    private final CharMatcher separatorChars;
    
    SeparatedBaseEncoding(BaseEncoding paramBaseEncoding, String paramString, int paramInt)
    {
      this.delegate = ((BaseEncoding)Preconditions.checkNotNull(paramBaseEncoding));
      this.separator = ((String)Preconditions.checkNotNull(paramString));
      this.afterEveryChars = paramInt;
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Cannot add a separator after every %s chars", new Object[] { Integer.valueOf(paramInt) });
        this.separatorChars = CharMatcher.anyOf(paramString).precomputed();
        return;
      }
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      return this.delegate.decodeTo(paramArrayOfByte, this.separatorChars.removeFrom(paramCharSequence));
    }
    
    @GwtIncompatible("Reader,InputStream")
    public InputStream decodingStream(Reader paramReader)
    {
      return this.delegate.decodingStream(ignoringReader(paramReader, this.separatorChars));
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.delegate.encodeTo(separatingAppendable(paramAppendable, this.separator, this.afterEveryChars), paramArrayOfByte, paramInt1, paramInt2);
    }
    
    @GwtIncompatible("Writer,OutputStream")
    public OutputStream encodingStream(Writer paramWriter)
    {
      return this.delegate.encodingStream(separatingWriter(paramWriter, this.separator, this.afterEveryChars));
    }
    
    public BaseEncoding lowerCase()
    {
      return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    int maxDecodedSize(int paramInt)
    {
      return this.delegate.maxDecodedSize(paramInt);
    }
    
    int maxEncodedSize(int paramInt)
    {
      paramInt = this.delegate.maxEncodedSize(paramInt);
      return this.separator.length() * IntMath.divide(Math.max(0, paramInt - 1), this.afterEveryChars, RoundingMode.FLOOR) + paramInt;
    }
    
    public BaseEncoding omitPadding()
    {
      return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
    }
    
    CharMatcher padding()
    {
      return this.delegate.padding();
    }
    
    public String toString()
    {
      return this.delegate.toString() + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
    }
    
    public BaseEncoding upperCase()
    {
      return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withPadChar(char paramChar)
    {
      return this.delegate.withPadChar(paramChar).withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withSeparator(String paramString, int paramInt)
    {
      throw new UnsupportedOperationException("Already have a separator");
    }
  }
  
  static class StandardBaseEncoding
    extends BaseEncoding
  {
    final BaseEncoding.Alphabet alphabet;
    private transient BaseEncoding lowerCase;
    @Nullable
    final Character paddingChar;
    private transient BaseEncoding upperCase;
    
    StandardBaseEncoding(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      this.alphabet = ((BaseEncoding.Alphabet)Preconditions.checkNotNull(paramAlphabet));
      if ((paramCharacter == null) || (!paramAlphabet.matches(paramCharacter.charValue()))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Padding character %s was already in alphabet", new Object[] { paramCharacter });
        this.paddingChar = paramCharacter;
        return;
      }
    }
    
    StandardBaseEncoding(String paramString1, String paramString2, @Nullable Character paramCharacter)
    {
      this(new BaseEncoding.Alphabet(paramString1, paramString2.toCharArray()), paramCharacter);
    }
    
    int decodeTo(byte[] paramArrayOfByte, CharSequence paramCharSequence)
      throws BaseEncoding.DecodingException
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(paramCharSequence.length())) {
        throw new BaseEncoding.DecodingException("Invalid input length " + paramCharSequence.length());
      }
      int i = 0;
      int j = 0;
      while (j < paramCharSequence.length())
      {
        long l1 = 0L;
        int k = 0;
        int m = 0;
        while (m < this.alphabet.charsPerChunk)
        {
          long l2 = l1 << this.alphabet.bitsPerChar;
          n = k;
          l1 = l2;
          if (j + m < paramCharSequence.length())
          {
            l1 = l2 | this.alphabet.decode(paramCharSequence.charAt(j + k));
            n = k + 1;
          }
          m += 1;
          k = n;
        }
        int n = this.alphabet.bytesPerChunk;
        int i1 = this.alphabet.bitsPerChar;
        m = (this.alphabet.bytesPerChunk - 1) * 8;
        while (m >= n * 8 - i1 * k)
        {
          paramArrayOfByte[i] = ((byte)(int)(l1 >>> m & 0xFF));
          m -= 8;
          i += 1;
        }
        j += this.alphabet.charsPerChunk;
      }
      return i;
    }
    
    @GwtIncompatible("Reader,InputStream")
    public InputStream decodingStream(final Reader paramReader)
    {
      Preconditions.checkNotNull(paramReader);
      new InputStream()
      {
        int bitBuffer = 0;
        int bitBufferLength = 0;
        boolean hitPadding = false;
        final CharMatcher paddingMatcher = BaseEncoding.StandardBaseEncoding.this.padding();
        int readChars = 0;
        
        public void close()
          throws IOException
        {
          paramReader.close();
        }
        
        public int read()
          throws IOException
        {
          int j = -1;
          do
          {
            char c;
            for (;;)
            {
              i = paramReader.read();
              if (i == -1)
              {
                i = j;
                if (this.hitPadding) {
                  return i;
                }
                i = j;
                if (BaseEncoding.StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                  return i;
                }
                throw new BaseEncoding.DecodingException("Invalid input length " + this.readChars);
              }
              this.readChars += 1;
              c = (char)i;
              if (!this.paddingMatcher.matches(c)) {
                break;
              }
              if ((!this.hitPadding) && ((this.readChars == 1) || (!BaseEncoding.StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1)))) {
                throw new BaseEncoding.DecodingException("Padding cannot start at index " + this.readChars);
              }
              this.hitPadding = true;
            }
            if (this.hitPadding) {
              throw new BaseEncoding.DecodingException("Expected padding character but found '" + c + "' at index " + this.readChars);
            }
            this.bitBuffer <<= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
            this.bitBuffer |= BaseEncoding.StandardBaseEncoding.this.alphabet.decode(c);
            this.bitBufferLength += BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
          } while (this.bitBufferLength < 8);
          this.bitBufferLength -= 8;
          int i = this.bitBuffer >> this.bitBufferLength & 0xFF;
          return i;
        }
      };
    }
    
    void encodeChunkTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      if (paramInt2 <= this.alphabet.bytesPerChunk) {}
      long l;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        l = 0L;
        i = 0;
        while (i < paramInt2)
        {
          l = (l | paramArrayOfByte[(paramInt1 + i)] & 0xFF) << 8;
          i += 1;
        }
      }
      int i = this.alphabet.bitsPerChar;
      paramInt1 = 0;
      while (paramInt1 < paramInt2 * 8)
      {
        int j = (int)(l >>> (paramInt2 + 1) * 8 - i - paramInt1);
        int k = this.alphabet.mask;
        paramAppendable.append(this.alphabet.encode(j & k));
        paramInt1 += this.alphabet.bitsPerChar;
      }
      if (this.paddingChar != null) {
        while (paramInt1 < this.alphabet.bytesPerChunk * 8)
        {
          paramAppendable.append(this.paddingChar.charValue());
          paramInt1 += this.alphabet.bitsPerChar;
        }
      }
    }
    
    void encodeTo(Appendable paramAppendable, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Preconditions.checkNotNull(paramAppendable);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      int i = 0;
      while (i < paramInt2)
      {
        encodeChunkTo(paramAppendable, paramArrayOfByte, paramInt1 + i, Math.min(this.alphabet.bytesPerChunk, paramInt2 - i));
        i += this.alphabet.bytesPerChunk;
      }
    }
    
    @GwtIncompatible("Writer,OutputStream")
    public OutputStream encodingStream(final Writer paramWriter)
    {
      Preconditions.checkNotNull(paramWriter);
      new OutputStream()
      {
        int bitBuffer = 0;
        int bitBufferLength = 0;
        int writtenChars = 0;
        
        public void close()
          throws IOException
        {
          if (this.bitBufferLength > 0)
          {
            int i = this.bitBuffer;
            int j = BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
            int k = this.bitBufferLength;
            int m = BaseEncoding.StandardBaseEncoding.this.alphabet.mask;
            paramWriter.write(BaseEncoding.StandardBaseEncoding.this.alphabet.encode(i << j - k & m));
            this.writtenChars += 1;
            if (BaseEncoding.StandardBaseEncoding.this.paddingChar != null) {
              while (this.writtenChars % BaseEncoding.StandardBaseEncoding.this.alphabet.charsPerChunk != 0)
              {
                paramWriter.write(BaseEncoding.StandardBaseEncoding.this.paddingChar.charValue());
                this.writtenChars += 1;
              }
            }
          }
          paramWriter.close();
        }
        
        public void flush()
          throws IOException
        {
          paramWriter.flush();
        }
        
        public void write(int paramAnonymousInt)
          throws IOException
        {
          this.bitBuffer <<= 8;
          this.bitBuffer |= paramAnonymousInt & 0xFF;
          for (this.bitBufferLength += 8; this.bitBufferLength >= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar; this.bitBufferLength -= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar)
          {
            paramAnonymousInt = this.bitBuffer;
            int i = this.bitBufferLength;
            int j = BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
            int k = BaseEncoding.StandardBaseEncoding.this.alphabet.mask;
            paramWriter.write(BaseEncoding.StandardBaseEncoding.this.alphabet.encode(paramAnonymousInt >> i - j & k));
            this.writtenChars += 1;
          }
        }
      };
    }
    
    public BaseEncoding lowerCase()
    {
      BaseEncoding localBaseEncoding = this.lowerCase;
      Object localObject = localBaseEncoding;
      if (localBaseEncoding == null)
      {
        localObject = this.alphabet.lowerCase();
        if (localObject != this.alphabet) {
          break label36;
        }
      }
      label36:
      for (localObject = this;; localObject = newInstance((BaseEncoding.Alphabet)localObject, this.paddingChar))
      {
        this.lowerCase = ((BaseEncoding)localObject);
        return (BaseEncoding)localObject;
      }
    }
    
    int maxDecodedSize(int paramInt)
    {
      return (int)((this.alphabet.bitsPerChar * paramInt + 7L) / 8L);
    }
    
    int maxEncodedSize(int paramInt)
    {
      return this.alphabet.charsPerChunk * IntMath.divide(paramInt, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet paramAlphabet, @Nullable Character paramCharacter)
    {
      return new StandardBaseEncoding(paramAlphabet, paramCharacter);
    }
    
    public BaseEncoding omitPadding()
    {
      if (this.paddingChar == null) {
        return this;
      }
      return newInstance(this.alphabet, null);
    }
    
    CharMatcher padding()
    {
      if (this.paddingChar == null) {
        return CharMatcher.NONE;
      }
      return CharMatcher.is(this.paddingChar.charValue());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("BaseEncoding.");
      localStringBuilder.append(this.alphabet.toString());
      if (8 % this.alphabet.bitsPerChar != 0)
      {
        if (this.paddingChar != null) {
          break label54;
        }
        localStringBuilder.append(".omitPadding()");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label54:
        localStringBuilder.append(".withPadChar(").append(this.paddingChar).append(')');
      }
    }
    
    public BaseEncoding upperCase()
    {
      BaseEncoding localBaseEncoding = this.upperCase;
      Object localObject = localBaseEncoding;
      if (localBaseEncoding == null)
      {
        localObject = this.alphabet.upperCase();
        if (localObject != this.alphabet) {
          break label36;
        }
      }
      label36:
      for (localObject = this;; localObject = newInstance((BaseEncoding.Alphabet)localObject, this.paddingChar))
      {
        this.upperCase = ((BaseEncoding)localObject);
        return (BaseEncoding)localObject;
      }
    }
    
    public BaseEncoding withPadChar(char paramChar)
    {
      if ((8 % this.alphabet.bitsPerChar == 0) || ((this.paddingChar != null) && (this.paddingChar.charValue() == paramChar))) {
        return this;
      }
      return newInstance(this.alphabet, Character.valueOf(paramChar));
    }
    
    public BaseEncoding withSeparator(String paramString, int paramInt)
    {
      Preconditions.checkArgument(padding().or(this.alphabet).matchesNoneOf(paramString), "Separator (%s) cannot contain alphabet or padding characters", new Object[] { paramString });
      return new BaseEncoding.SeparatedBaseEncoding(this, paramString, paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/BaseEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */