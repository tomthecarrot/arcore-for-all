package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ByteString
  implements Iterable<Byte>, Serializable
{
  static final int CONCATENATE_BY_COPY_SIZE = 128;
  public static final ByteString EMPTY;
  static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
  static final int MIN_READ_FROM_CHUNK_SIZE = 256;
  private static final ByteArrayCopier byteArrayCopier;
  private int hash = 0;
  
  static
  {
    boolean bool;
    if (!ByteString.class.desiredAssertionStatus()) {
      bool = true;
    }
    for (;;)
    {
      $assertionsDisabled = bool;
      EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
      int i = 1;
      try
      {
        Class.forName("android.content.Context");
        if (i != 0)
        {
          SystemByteArrayCopier localSystemByteArrayCopier = new SystemByteArrayCopier(null);
          byteArrayCopier = localSystemByteArrayCopier;
          return;
          bool = false;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          i = 0;
          continue;
          ArraysByteArrayCopier localArraysByteArrayCopier = new ArraysByteArrayCopier(null);
        }
      }
    }
  }
  
  private static ByteString balancedConcat(Iterator<ByteString> paramIterator, int paramInt)
  {
    assert (paramInt >= 1);
    if (paramInt == 1) {
      return (ByteString)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return balancedConcat(paramIterator, i).concat(balancedConcat(paramIterator, paramInt - i));
  }
  
  static void checkIndex(int paramInt1, int paramInt2)
  {
    if ((paramInt2 - (paramInt1 + 1) | paramInt1) < 0)
    {
      if (paramInt1 < 0) {
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + paramInt1);
      }
      throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt1 + ", " + paramInt2);
    }
  }
  
  static int checkRange(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 < 0) {
        throw new IndexOutOfBoundsException("Beginning index: " + paramInt1 + " < 0");
      }
      if (paramInt2 < paramInt1) {
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
      }
      throw new IndexOutOfBoundsException("End index: " + paramInt2 + " >= " + paramInt3);
    }
    return i;
  }
  
  public static ByteString copyFrom(Iterable<ByteString> paramIterable)
  {
    int i;
    if (!(paramIterable instanceof Collection))
    {
      i = 0;
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        i += 1;
      }
    }
    while (i == 0)
    {
      return EMPTY;
      i = ((Collection)paramIterable).size();
    }
    return balancedConcat(paramIterable.iterator(), i);
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new LiteralByteString(paramString1.getBytes(paramString2));
  }
  
  public static ByteString copyFrom(String paramString, Charset paramCharset)
  {
    return new LiteralByteString(paramString.getBytes(paramCharset));
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer)
  {
    return copyFrom(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new LiteralByteString(arrayOfByte);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new LiteralByteString(byteArrayCopier.copyFrom(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    return new LiteralByteString(paramString.getBytes(Internal.UTF_8));
  }
  
  static CodedBuilder newCodedBuilder(int paramInt)
  {
    return new CodedBuilder(paramInt, null);
  }
  
  public static Output newOutput()
  {
    return new Output(128);
  }
  
  public static Output newOutput(int paramInt)
  {
    return new Output(paramInt);
  }
  
  private static ByteString readChunk(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt)
      {
        j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j != -1) {}
      }
      else
      {
        if (i != 0) {
          break;
        }
        return null;
      }
      i += j;
    }
    return copyFrom(arrayOfByte, 0, i);
  }
  
  public static ByteString readFrom(InputStream paramInputStream)
    throws IOException
  {
    return readFrom(paramInputStream, 256, 8192);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return readFrom(paramInputStream, paramInt, paramInt);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      ByteString localByteString = readChunk(paramInputStream, paramInt1);
      if (localByteString == null) {
        return copyFrom(localArrayList);
      }
      localArrayList.add(localByteString);
      paramInt1 = Math.min(paramInt1 * 2, paramInt2);
    }
  }
  
  static ByteString wrap(byte[] paramArrayOfByte)
  {
    return new LiteralByteString(paramArrayOfByte);
  }
  
  static ByteString wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new BoundedByteString(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract ByteBuffer asReadOnlyByteBuffer();
  
  public abstract List<ByteBuffer> asReadOnlyByteBufferList();
  
  public abstract byte byteAt(int paramInt);
  
  public final ByteString concat(ByteString paramByteString)
  {
    if (Integer.MAX_VALUE - size() < paramByteString.size()) {
      throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + paramByteString.size());
    }
    return RopeByteString.concatenate(this, paramByteString);
  }
  
  public abstract void copyTo(ByteBuffer paramByteBuffer);
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    copyTo(paramArrayOfByte, 0, paramInt, size());
  }
  
  public final void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    checkRange(paramInt1, paramInt1 + paramInt3, size());
    checkRange(paramInt2, paramInt2 + paramInt3, paramArrayOfByte.length);
    if (paramInt3 > 0) {
      copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public final boolean endsWith(ByteString paramByteString)
  {
    return (size() >= paramByteString.size()) && (substring(size() - paramByteString.size()).equals(paramByteString));
  }
  
  public abstract boolean equals(Object paramObject);
  
  protected abstract int getTreeDepth();
  
  public final int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  protected abstract boolean isBalanced();
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isValidUtf8();
  
  public final ByteIterator iterator()
  {
    new ByteIterator()
    {
      private final int limit = ByteString.this.size();
      private int position = 0;
      
      public boolean hasNext()
      {
        return this.position < this.limit;
      }
      
      public Byte next()
      {
        return Byte.valueOf(nextByte());
      }
      
      public byte nextByte()
      {
        try
        {
          ByteString localByteString = ByteString.this;
          int i = this.position;
          this.position = (i + 1);
          byte b = localByteString.byteAt(i);
          return b;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
        }
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public abstract CodedInputStream newCodedInput();
  
  public abstract InputStream newInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  protected final int peekCachedHashCode()
  {
    return this.hash;
  }
  
  public abstract int size();
  
  public final boolean startsWith(ByteString paramByteString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (size() >= paramByteString.size())
    {
      bool1 = bool2;
      if (substring(0, paramByteString.size()).equals(paramByteString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final ByteString substring(int paramInt)
  {
    return substring(paramInt, size());
  }
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return Internal.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public final String toString(String paramString)
    throws UnsupportedEncodingException
  {
    try
    {
      String str = toString(Charset.forName(paramString));
      return str;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      paramString = new UnsupportedEncodingException(paramString);
      paramString.initCause(localUnsupportedCharsetException);
      throw paramString;
    }
  }
  
  public final String toString(Charset paramCharset)
  {
    if (size() == 0) {
      return "";
    }
    return toStringInternal(paramCharset);
  }
  
  protected abstract String toStringInternal(Charset paramCharset);
  
  public final String toStringUtf8()
  {
    return toString(Internal.UTF_8);
  }
  
  abstract void writeTo(ByteOutput paramByteOutput)
    throws IOException;
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
  
  final void writeTo(OutputStream paramOutputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    checkRange(paramInt1, paramInt1 + paramInt2, size());
    if (paramInt2 > 0) {
      writeToInternal(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  abstract void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
    throws IOException;
  
  private static final class ArraysByteArrayCopier
    implements ByteString.ByteArrayCopier
  {
    public byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
    }
  }
  
  private static final class BoundedByteString
    extends ByteString.LiteralByteString
  {
    private static final long serialVersionUID = 1L;
    private final int bytesLength;
    private final int bytesOffset;
    
    BoundedByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.bytesOffset = paramInt1;
      this.bytesLength = paramInt2;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException
    {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    public byte byteAt(int paramInt)
    {
      checkIndex(paramInt, size());
      return this.bytes[(this.bytesOffset + paramInt)];
    }
    
    protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.bytes, getOffsetIntoBytes() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    protected int getOffsetIntoBytes()
    {
      return this.bytesOffset;
    }
    
    public int size()
    {
      return this.bytesLength;
    }
    
    Object writeReplace()
    {
      return ByteString.wrap(toByteArray());
    }
  }
  
  private static abstract interface ByteArrayCopier
  {
    public abstract byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface ByteIterator
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  static final class CodedBuilder
  {
    private final byte[] buffer;
    private final CodedOutputStream output;
    
    private CodedBuilder(int paramInt)
    {
      this.buffer = new byte[paramInt];
      this.output = CodedOutputStream.newInstance(this.buffer);
    }
    
    public ByteString build()
    {
      this.output.checkNoSpaceLeft();
      return new ByteString.LiteralByteString(this.buffer);
    }
    
    public CodedOutputStream getCodedOutput()
    {
      return this.output;
    }
  }
  
  static abstract class LeafByteString
    extends ByteString
  {
    abstract boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2);
    
    protected final int getTreeDepth()
    {
      return 0;
    }
    
    protected final boolean isBalanced()
    {
      return true;
    }
  }
  
  private static class LiteralByteString
    extends ByteString.LeafByteString
  {
    private static final long serialVersionUID = 1L;
    protected final byte[] bytes;
    
    LiteralByteString(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
    
    public final ByteBuffer asReadOnlyByteBuffer()
    {
      return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }
    
    public final List<ByteBuffer> asReadOnlyByteBufferList()
    {
      return Collections.singletonList(asReadOnlyByteBuffer());
    }
    
    public byte byteAt(int paramInt)
    {
      return this.bytes[paramInt];
    }
    
    public final void copyTo(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ByteString)) {
        return false;
      }
      if (size() != ((ByteString)paramObject).size()) {
        return false;
      }
      if (size() == 0) {
        return true;
      }
      if ((paramObject instanceof LiteralByteString))
      {
        LiteralByteString localLiteralByteString = (LiteralByteString)paramObject;
        int i = peekCachedHashCode();
        int j = localLiteralByteString.peekCachedHashCode();
        if ((i != 0) && (j != 0) && (i != j)) {
          return false;
        }
        return equalsRange((LiteralByteString)paramObject, 0, size());
      }
      return paramObject.equals(this);
    }
    
    final boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2)
    {
      if (paramInt2 > paramByteString.size()) {
        throw new IllegalArgumentException("Length too large: " + paramInt2 + size());
      }
      if (paramInt1 + paramInt2 > paramByteString.size()) {
        throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paramByteString.size());
      }
      if ((paramByteString instanceof LiteralByteString))
      {
        paramByteString = (LiteralByteString)paramByteString;
        byte[] arrayOfByte1 = this.bytes;
        byte[] arrayOfByte2 = paramByteString.bytes;
        int j = getOffsetIntoBytes();
        int i = getOffsetIntoBytes();
        paramInt1 = paramByteString.getOffsetIntoBytes() + paramInt1;
        while (i < j + paramInt2)
        {
          if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
            return false;
          }
          i += 1;
          paramInt1 += 1;
        }
        return true;
      }
      return paramByteString.substring(paramInt1, paramInt1 + paramInt2).equals(substring(0, paramInt2));
    }
    
    protected int getOffsetIntoBytes()
    {
      return 0;
    }
    
    public final boolean isValidUtf8()
    {
      int i = getOffsetIntoBytes();
      return Utf8.isValidUtf8(this.bytes, i, size() + i);
    }
    
    public final CodedInputStream newCodedInput()
    {
      return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
    }
    
    public final InputStream newInput()
    {
      return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected final int partialHash(int paramInt1, int paramInt2, int paramInt3)
    {
      return Internal.partialHash(paramInt1, this.bytes, getOffsetIntoBytes() + paramInt2, paramInt3);
    }
    
    protected final int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
    {
      paramInt2 = getOffsetIntoBytes() + paramInt2;
      return Utf8.partialIsValidUtf8(paramInt1, this.bytes, paramInt2, paramInt2 + paramInt3);
    }
    
    public int size()
    {
      return this.bytes.length;
    }
    
    public final ByteString substring(int paramInt1, int paramInt2)
    {
      paramInt2 = checkRange(paramInt1, paramInt2, size());
      if (paramInt2 == 0) {
        return ByteString.EMPTY;
      }
      return new ByteString.BoundedByteString(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
    }
    
    protected final String toStringInternal(Charset paramCharset)
    {
      return new String(this.bytes, getOffsetIntoBytes(), size(), paramCharset);
    }
    
    final void writeTo(ByteOutput paramByteOutput)
      throws IOException
    {
      paramByteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
    }
    
    public final void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(toByteArray());
    }
    
    final void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
      throws IOException
    {
      paramOutputStream.write(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
    }
  }
  
  public static final class Output
    extends OutputStream
  {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private byte[] buffer;
    private int bufferPos;
    private final ArrayList<ByteString> flushedBuffers;
    private int flushedBuffersTotalBytes;
    private final int initialCapacity;
    
    Output(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Buffer size < 0");
      }
      this.initialCapacity = paramInt;
      this.flushedBuffers = new ArrayList();
      this.buffer = new byte[paramInt];
    }
    
    private byte[] copyArray(byte[] paramArrayOfByte, int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt));
      return arrayOfByte;
    }
    
    private void flushFullBuffer(int paramInt)
    {
      this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
      this.flushedBuffersTotalBytes += this.buffer.length;
      this.buffer = new byte[Math.max(this.initialCapacity, Math.max(paramInt, this.flushedBuffersTotalBytes >>> 1))];
      this.bufferPos = 0;
    }
    
    private void flushLastBuffer()
    {
      if (this.bufferPos < this.buffer.length) {
        if (this.bufferPos > 0)
        {
          byte[] arrayOfByte = copyArray(this.buffer, this.bufferPos);
          this.flushedBuffers.add(new ByteString.LiteralByteString(arrayOfByte));
        }
      }
      for (;;)
      {
        this.flushedBuffersTotalBytes += this.bufferPos;
        this.bufferPos = 0;
        return;
        this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
        this.buffer = EMPTY_BYTE_ARRAY;
      }
    }
    
    public void reset()
    {
      try
      {
        this.flushedBuffers.clear();
        this.flushedBuffersTotalBytes = 0;
        this.bufferPos = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public int size()
    {
      try
      {
        int i = this.flushedBuffersTotalBytes;
        int j = this.bufferPos;
        return i + j;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public ByteString toByteString()
    {
      try
      {
        flushLastBuffer();
        ByteString localByteString = ByteString.copyFrom(this.flushedBuffers);
        return localByteString;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public String toString()
    {
      return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
    }
    
    public void write(int paramInt)
    {
      try
      {
        if (this.bufferPos == this.buffer.length) {
          flushFullBuffer(1);
        }
        byte[] arrayOfByte = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        return;
      }
      finally {}
    }
    
    /* Error */
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_3
      //   3: aload_0
      //   4: getfield 42	com/google/protobuf/ByteString$Output:buffer	[B
      //   7: arraylength
      //   8: aload_0
      //   9: getfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   12: isub
      //   13: if_icmpgt +30 -> 43
      //   16: aload_1
      //   17: iload_2
      //   18: aload_0
      //   19: getfield 42	com/google/protobuf/ByteString$Output:buffer	[B
      //   22: aload_0
      //   23: getfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   26: iload_3
      //   27: invokestatic 56	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   35: iload_3
      //   36: iadd
      //   37: putfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   40: aload_0
      //   41: monitorexit
      //   42: return
      //   43: aload_0
      //   44: getfield 42	com/google/protobuf/ByteString$Output:buffer	[B
      //   47: arraylength
      //   48: aload_0
      //   49: getfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   52: isub
      //   53: istore 4
      //   55: aload_1
      //   56: iload_2
      //   57: aload_0
      //   58: getfield 42	com/google/protobuf/ByteString$Output:buffer	[B
      //   61: aload_0
      //   62: getfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   65: iload 4
      //   67: invokestatic 56	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   70: iload_3
      //   71: iload 4
      //   73: isub
      //   74: istore_3
      //   75: aload_0
      //   76: iload_3
      //   77: invokespecial 121	com/google/protobuf/ByteString$Output:flushFullBuffer	(I)V
      //   80: aload_1
      //   81: iload_2
      //   82: iload 4
      //   84: iadd
      //   85: aload_0
      //   86: getfield 42	com/google/protobuf/ByteString$Output:buffer	[B
      //   89: iconst_0
      //   90: iload_3
      //   91: invokestatic 56	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   94: aload_0
      //   95: iload_3
      //   96: putfield 73	com/google/protobuf/ByteString$Output:bufferPos	I
      //   99: goto -59 -> 40
      //   102: astore_1
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_1
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	Output
      //   0	107	1	paramArrayOfByte	byte[]
      //   0	107	2	paramInt1	int
      //   0	107	3	paramInt2	int
      //   53	32	4	i	int
      // Exception table:
      //   from	to	target	type
      //   2	40	102	finally
      //   43	70	102	finally
      //   75	99	102	finally
    }
    
    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      try
      {
        ByteString[] arrayOfByteString = (ByteString[])this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
        byte[] arrayOfByte = this.buffer;
        int j = this.bufferPos;
        int k = arrayOfByteString.length;
        int i = 0;
        while (i < k)
        {
          arrayOfByteString[i].writeTo(paramOutputStream);
          i += 1;
        }
        paramOutputStream.write(copyArray(arrayOfByte, j));
      }
      finally {}
    }
  }
  
  private static final class SystemByteArrayCopier
    implements ByteString.ByteArrayCopier
  {
    public byte[] copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */