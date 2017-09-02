package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public final class Metadata
{
  public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER;
  public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER;
  public static final String BINARY_HEADER_SUFFIX = "-bin";
  static final AsciiMarshaller<Integer> INTEGER_MARSHALLER;
  private byte[][] namesAndValues;
  private int size;
  
  static
  {
    if (!Metadata.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      BINARY_BYTE_MARSHALLER = new BinaryMarshaller()
      {
        public byte[] parseBytes(byte[] paramAnonymousArrayOfByte)
        {
          return paramAnonymousArrayOfByte;
        }
        
        public byte[] toBytes(byte[] paramAnonymousArrayOfByte)
        {
          return paramAnonymousArrayOfByte;
        }
      };
      ASCII_STRING_MARSHALLER = new AsciiMarshaller()
      {
        public String parseAsciiString(String paramAnonymousString)
        {
          return paramAnonymousString;
        }
        
        public String toAsciiString(String paramAnonymousString)
        {
          return paramAnonymousString;
        }
      };
      INTEGER_MARSHALLER = new AsciiMarshaller()
      {
        public Integer parseAsciiString(String paramAnonymousString)
        {
          return Integer.valueOf(Integer.parseInt(paramAnonymousString));
        }
        
        public String toAsciiString(Integer paramAnonymousInteger)
        {
          return paramAnonymousInteger.toString();
        }
      };
      return;
    }
  }
  
  public Metadata() {}
  
  Metadata(int paramInt, byte[]... paramVarArgs)
  {
    assert ((paramVarArgs.length & 0x1) == 0) : ("Odd number of key-value pairs " + paramVarArgs.length);
    this.size = paramInt;
    this.namesAndValues = paramVarArgs;
  }
  
  Metadata(byte[]... paramVarArgs)
  {
    this(paramVarArgs.length / 2, paramVarArgs);
  }
  
  private boolean bytesEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private int cap()
  {
    if (this.namesAndValues != null) {
      return this.namesAndValues.length;
    }
    return 0;
  }
  
  private void expand(int paramInt)
  {
    byte[][] arrayOfByte = new byte[paramInt][];
    if (!isEmpty()) {
      System.arraycopy(this.namesAndValues, 0, arrayOfByte, 0, len());
    }
    this.namesAndValues = arrayOfByte;
  }
  
  private boolean isEmpty()
  {
    return this.size == 0;
  }
  
  private int len()
  {
    return this.size * 2;
  }
  
  private void maybeExpand()
  {
    if ((len() == 0) || (len() == cap())) {
      expand(Math.max(len() * 2, 8));
    }
  }
  
  private void name(int paramInt, byte[] paramArrayOfByte)
  {
    this.namesAndValues[(paramInt * 2)] = paramArrayOfByte;
  }
  
  private byte[] name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }
  
  private void value(int paramInt, byte[] paramArrayOfByte)
  {
    this.namesAndValues[(paramInt * 2 + 1)] = paramArrayOfByte;
  }
  
  private byte[] value(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2 + 1)];
  }
  
  public boolean containsKey(Key<?> paramKey)
  {
    int i = 0;
    while (i < this.size)
    {
      if (bytesEqual(paramKey.asciiName(), name(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public <T> void discardAll(Key<T> paramKey)
  {
    if (isEmpty()) {
      return;
    }
    int j = 0;
    int i = 0;
    if (i < this.size)
    {
      if (bytesEqual(paramKey.asciiName(), name(i))) {}
      for (;;)
      {
        i += 1;
        break;
        name(j, name(i));
        value(j, value(i));
        j += 1;
      }
    }
    Arrays.fill(this.namesAndValues, j * 2, len(), null);
    this.size = j;
  }
  
  @Nullable
  public <T> T get(Key<T> paramKey)
  {
    int i = this.size - 1;
    while (i >= 0)
    {
      if (bytesEqual(paramKey.asciiName(), name(i))) {
        return (T)paramKey.parseBytes(value(i));
      }
      i -= 1;
    }
    return null;
  }
  
  public <T> Iterable<T> getAll(Key<T> paramKey)
  {
    int i = 0;
    while (i < this.size)
    {
      if (bytesEqual(paramKey.asciiName(), name(i))) {
        return new IterableAt(paramKey, i, null);
      }
      i += 1;
    }
    return null;
  }
  
  public int headerCount()
  {
    return this.size;
  }
  
  public Set<String> keys()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(this.size);
    int i = 0;
    while (i < this.size)
    {
      localHashSet.add(new String(name(i), 0));
      i += 1;
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public void merge(Metadata paramMetadata)
  {
    if (paramMetadata.isEmpty()) {
      return;
    }
    int i = cap();
    int j = len();
    if ((isEmpty()) || (i - j < paramMetadata.len())) {
      expand(len() + paramMetadata.len());
    }
    System.arraycopy(paramMetadata.namesAndValues, 0, this.namesAndValues, len(), paramMetadata.len());
    this.size += paramMetadata.size;
  }
  
  public void merge(Metadata paramMetadata, Set<Key<?>> paramSet)
  {
    Preconditions.checkNotNull(paramMetadata, "other");
    HashMap localHashMap = new HashMap(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Key localKey = (Key)paramSet.next();
      localHashMap.put(ByteBuffer.wrap(localKey.asciiName()), localKey);
    }
    int i = 0;
    while (i < paramMetadata.size)
    {
      if (localHashMap.containsKey(ByteBuffer.wrap(paramMetadata.name(i))))
      {
        maybeExpand();
        name(this.size, paramMetadata.name(i));
        value(this.size, paramMetadata.value(i));
        this.size += 1;
      }
      i += 1;
    }
  }
  
  public <T> void put(Key<T> paramKey, T paramT)
  {
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    maybeExpand();
    name(this.size, paramKey.asciiName());
    value(this.size, paramKey.toBytes(paramT));
    this.size += 1;
  }
  
  public <T> boolean remove(Key<T> paramKey, T paramT)
  {
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    int i = 0;
    if (i < this.size)
    {
      if (!bytesEqual(paramKey.asciiName(), name(i))) {}
      while (!paramT.equals(paramKey.parseBytes(value(i))))
      {
        i += 1;
        break;
      }
      int j = (i + 1) * 2;
      int k = len();
      System.arraycopy(this.namesAndValues, j, this.namesAndValues, i * 2, k - j);
      this.size -= 1;
      name(this.size, null);
      value(this.size, null);
      return true;
    }
    return false;
  }
  
  public <T> Iterable<T> removeAll(Key<T> paramKey)
  {
    if (isEmpty()) {
      return null;
    }
    int j = 0;
    int i = 0;
    LinkedList localLinkedList = null;
    if (i < this.size)
    {
      if (bytesEqual(paramKey.asciiName(), name(i))) {
        if (localLinkedList != null) {
          label45:
          localLinkedList.add(paramKey.parseBytes(value(i)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedList = new LinkedList();
        break label45;
        name(j, name(i));
        value(j, value(i));
        j += 1;
      }
    }
    Arrays.fill(this.namesAndValues, j * 2, len(), null);
    this.size = j;
    return localLinkedList;
  }
  
  @Nullable
  byte[][] serialize()
  {
    if (len() == cap()) {
      return this.namesAndValues;
    }
    byte[][] arrayOfByte = new byte[len()][];
    System.arraycopy(this.namesAndValues, 0, arrayOfByte, 0, len());
    return arrayOfByte;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Metadata(");
    int i = 0;
    if (i < this.size)
    {
      if (i != 0) {
        localStringBuilder.append(',');
      }
      String str = new String(name(i), Charsets.US_ASCII);
      localStringBuilder.append(str).append('=');
      if (str.endsWith("-bin")) {
        localStringBuilder.append(BaseEncoding.base64().encode(value(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(new String(value(i), Charsets.US_ASCII));
      }
    }
    return ')';
  }
  
  private static class AsciiKey<T>
    extends Metadata.Key<T>
  {
    private final Metadata.AsciiMarshaller<T> marshaller;
    
    private AsciiKey(String paramString, Metadata.AsciiMarshaller<T> paramAsciiMarshaller)
    {
      super(null);
      if (!paramString.endsWith("-bin")) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "ASCII header is named %s.  Only binary headers may end with %s", new Object[] { paramString, "-bin" });
        this.marshaller = ((Metadata.AsciiMarshaller)Preconditions.checkNotNull(paramAsciiMarshaller, "marshaller"));
        return;
      }
    }
    
    T parseBytes(byte[] paramArrayOfByte)
    {
      return (T)this.marshaller.parseAsciiString(new String(paramArrayOfByte, Charsets.US_ASCII));
    }
    
    byte[] toBytes(T paramT)
    {
      return this.marshaller.toAsciiString(paramT).getBytes(Charsets.US_ASCII);
    }
  }
  
  public static abstract interface AsciiMarshaller<T>
  {
    public abstract T parseAsciiString(String paramString);
    
    public abstract String toAsciiString(T paramT);
  }
  
  private static class BinaryKey<T>
    extends Metadata.Key<T>
  {
    private final Metadata.BinaryMarshaller<T> marshaller;
    
    private BinaryKey(String paramString, Metadata.BinaryMarshaller<T> paramBinaryMarshaller)
    {
      super(null);
      Preconditions.checkArgument(paramString.endsWith("-bin"), "Binary header is named %s. It must end with %s", new Object[] { paramString, "-bin" });
      if (paramString.length() > "-bin".length()) {}
      for (;;)
      {
        Preconditions.checkArgument(bool, "empty key name");
        this.marshaller = ((Metadata.BinaryMarshaller)Preconditions.checkNotNull(paramBinaryMarshaller, "marshaller is null"));
        return;
        bool = false;
      }
    }
    
    T parseBytes(byte[] paramArrayOfByte)
    {
      return (T)this.marshaller.parseBytes(paramArrayOfByte);
    }
    
    byte[] toBytes(T paramT)
    {
      return this.marshaller.toBytes(paramT);
    }
  }
  
  public static abstract interface BinaryMarshaller<T>
  {
    public abstract T parseBytes(byte[] paramArrayOfByte);
    
    public abstract byte[] toBytes(T paramT);
  }
  
  private final class IterableAt<T>
    implements Iterable<T>
  {
    private final Metadata.Key<T> key;
    private int startIdx;
    
    private IterableAt(int paramInt)
    {
      this.key = paramInt;
      int i;
      this.startIdx = i;
    }
    
    public Iterator<T> iterator()
    {
      new Iterator()
      {
        private boolean hasNext = true;
        private int idx = Metadata.IterableAt.this.startIdx;
        
        public boolean hasNext()
        {
          if (this.hasNext) {
            return true;
          }
          do
          {
            this.idx += 1;
            if (this.idx >= Metadata.this.size) {
              break;
            }
          } while (!Metadata.this.bytesEqual(Metadata.IterableAt.this.key.asciiName(), Metadata.access$300(Metadata.this, this.idx)));
          this.hasNext = true;
          return this.hasNext;
          return false;
        }
        
        public T next()
        {
          if (hasNext())
          {
            this.hasNext = false;
            Metadata.Key localKey = Metadata.IterableAt.this.key;
            Metadata localMetadata = Metadata.this;
            int i = this.idx;
            this.idx = (i + 1);
            return (T)localKey.parseBytes(localMetadata.value(i));
          }
          throw new NoSuchElementException();
        }
        
        public void remove()
        {
          throw new UnsupportedOperationException();
        }
      };
    }
  }
  
  public static abstract class Key<T>
  {
    private static final BitSet VALID_T_CHARS = ;
    private final String name;
    private final byte[] nameBytes;
    private final String originalName;
    
    private Key(String paramString)
    {
      this.originalName = ((String)Preconditions.checkNotNull(paramString, "name"));
      this.name = validateName(this.originalName.toLowerCase(Locale.ROOT)).intern();
      this.nameBytes = this.name.getBytes(Charsets.US_ASCII);
    }
    
    private static BitSet generateValidTChars()
    {
      BitSet localBitSet = new BitSet(127);
      localBitSet.set(45);
      localBitSet.set(95);
      localBitSet.set(46);
      for (int i = 48; i <= 57; i = (char)(i + 1)) {
        localBitSet.set(i);
      }
      for (i = 97; i <= 122; i = (char)(i + 1)) {
        localBitSet.set(i);
      }
      return localBitSet;
    }
    
    public static <T> Key<T> of(String paramString, Metadata.AsciiMarshaller<T> paramAsciiMarshaller)
    {
      return new Metadata.AsciiKey(paramString, paramAsciiMarshaller, null);
    }
    
    public static <T> Key<T> of(String paramString, Metadata.BinaryMarshaller<T> paramBinaryMarshaller)
    {
      return new Metadata.BinaryKey(paramString, paramBinaryMarshaller, null);
    }
    
    static <T> Key<T> of(String paramString, Metadata.TrustedAsciiMarshaller<T> paramTrustedAsciiMarshaller)
    {
      return new Metadata.TrustedAsciiKey(paramString, paramTrustedAsciiMarshaller, null);
    }
    
    private static String validateName(String paramString)
    {
      Preconditions.checkNotNull(paramString, "name");
      boolean bool;
      int i;
      label24:
      char c;
      if (paramString.length() != 0)
      {
        bool = true;
        Preconditions.checkArgument(bool, "token must have at least 1 tchar");
        i = 0;
        if (i >= paramString.length()) {
          return paramString;
        }
        c = paramString.charAt(i);
        if ((c != ':') || (i != 0)) {
          break label60;
        }
      }
      for (;;)
      {
        i += 1;
        break label24;
        bool = false;
        break;
        label60:
        Preconditions.checkArgument(VALID_T_CHARS.get(c), "Invalid character '%s' in key name '%s'", new Object[] { Character.valueOf(c), paramString });
      }
      return paramString;
    }
    
    @VisibleForTesting
    byte[] asciiName()
    {
      return this.nameBytes;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Key)paramObject;
      return this.name.equals(((Key)paramObject).name);
    }
    
    public int hashCode()
    {
      return this.name.hashCode();
    }
    
    public final String name()
    {
      return this.name;
    }
    
    public final String originalName()
    {
      return this.originalName;
    }
    
    abstract T parseBytes(byte[] paramArrayOfByte);
    
    abstract byte[] toBytes(T paramT);
    
    public String toString()
    {
      return "Key{name='" + this.name + "'}";
    }
  }
  
  private static final class TrustedAsciiKey<T>
    extends Metadata.Key<T>
  {
    private final Metadata.TrustedAsciiMarshaller<T> marshaller;
    
    private TrustedAsciiKey(String paramString, Metadata.TrustedAsciiMarshaller<T> paramTrustedAsciiMarshaller)
    {
      super(null);
      if (!paramString.endsWith("-bin")) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "ASCII header is named %s.  Only binary headers may end with %s", new Object[] { paramString, "-bin" });
        this.marshaller = ((Metadata.TrustedAsciiMarshaller)Preconditions.checkNotNull(paramTrustedAsciiMarshaller, "marshaller"));
        return;
      }
    }
    
    T parseBytes(byte[] paramArrayOfByte)
    {
      return (T)this.marshaller.parseAsciiString(paramArrayOfByte);
    }
    
    byte[] toBytes(T paramT)
    {
      return this.marshaller.toAsciiString(paramT);
    }
  }
  
  static abstract interface TrustedAsciiMarshaller<T>
  {
    public abstract T parseAsciiString(byte[] paramArrayOfByte);
    
    public abstract byte[] toAsciiString(T paramT);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */