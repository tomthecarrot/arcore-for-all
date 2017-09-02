package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ByteSource
{
  public static ByteSource concat(Iterable<? extends ByteSource> paramIterable)
  {
    return new ConcatenatedByteSource(paramIterable);
  }
  
  public static ByteSource concat(Iterator<? extends ByteSource> paramIterator)
  {
    return concat(ImmutableList.copyOf(paramIterator));
  }
  
  public static ByteSource concat(ByteSource... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  private long countByReading(InputStream paramInputStream)
    throws IOException
  {
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramInputStream.read(ByteStreams.skipBuffer);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  private long countBySkipping(InputStream paramInputStream)
    throws IOException
  {
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = ByteStreams.skipUpTo(paramInputStream, 2147483647L);
      if (l2 <= 0L) {
        break;
      }
    }
    return l1;
  }
  
  public static ByteSource empty()
  {
    return EmptyByteSource.INSTANCE;
  }
  
  public static ByteSource wrap(byte[] paramArrayOfByte)
  {
    return new ByteArrayByteSource(paramArrayOfByte);
  }
  
  public CharSource asCharSource(Charset paramCharset)
  {
    return new AsCharSource(paramCharset, null);
  }
  
  public boolean contentEquals(ByteSource paramByteSource)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteSource);
    byte[] arrayOfByte1 = new byte[' '];
    byte[] arrayOfByte2 = new byte[' '];
    Closer localCloser = Closer.create();
    try
    {
      InputStream localInputStream = (InputStream)localCloser.register(openStream());
      paramByteSource = (InputStream)localCloser.register(paramByteSource.openStream());
      int i;
      do
      {
        i = ByteStreams.read(localInputStream, arrayOfByte1, 0, 8192);
        if (i == ByteStreams.read(paramByteSource, arrayOfByte2, 0, 8192))
        {
          boolean bool = Arrays.equals(arrayOfByte1, arrayOfByte2);
          if (bool) {}
        }
        else
        {
          return false;
        }
      } while (i == 8192);
      return true;
    }
    catch (Throwable paramByteSource)
    {
      throw localCloser.rethrow(paramByteSource);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public long copyTo(ByteSink paramByteSink)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteSink);
    Closer localCloser = Closer.create();
    try
    {
      long l = ByteStreams.copy((InputStream)localCloser.register(openStream()), (OutputStream)localCloser.register(paramByteSink.openStream()));
      return l;
    }
    catch (Throwable paramByteSink)
    {
      throw localCloser.rethrow(paramByteSink);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public long copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramOutputStream);
    Closer localCloser = Closer.create();
    try
    {
      long l = ByteStreams.copy((InputStream)localCloser.register(openStream()), paramOutputStream);
      return l;
    }
    catch (Throwable paramOutputStream)
    {
      throw localCloser.rethrow(paramOutputStream);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public HashCode hash(HashFunction paramHashFunction)
    throws IOException
  {
    paramHashFunction = paramHashFunction.newHasher();
    copyTo(Funnels.asOutputStream(paramHashFunction));
    return paramHashFunction.hash();
  }
  
  /* Error */
  public boolean isEmpty()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 170	com/google/common/io/ByteSource:sizeIfKnown	()Lcom/google/common/base/Optional;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 175	com/google/common/base/Optional:isPresent	()Z
    //   9: ifeq +20 -> 29
    //   12: aload_3
    //   13: invokevirtual 179	com/google/common/base/Optional:get	()Ljava/lang/Object;
    //   16: checkcast 181	java/lang/Long
    //   19: invokevirtual 185	java/lang/Long:longValue	()J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +5 -> 29
    //   27: iconst_1
    //   28: ireturn
    //   29: invokestatic 105	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   32: astore_3
    //   33: aload_3
    //   34: aload_0
    //   35: invokevirtual 109	com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   38: invokevirtual 113	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   41: checkcast 59	java/io/InputStream
    //   44: invokevirtual 188	java/io/InputStream:read	()I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpne +11 -> 61
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_3
    //   56: invokevirtual 125	com/google/common/io/Closer:close	()V
    //   59: iload_2
    //   60: ireturn
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -8 -> 55
    //   66: astore 4
    //   68: aload_3
    //   69: aload 4
    //   71: invokevirtual 129	com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   74: athrow
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 125	com/google/common/io/Closer:close	()V
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ByteSource
    //   47	4	1	i	int
    //   54	9	2	bool	boolean
    //   4	74	3	localObject1	Object
    //   66	4	4	localThrowable	Throwable
    //   75	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	48	66	java/lang/Throwable
    //   33	48	75	finally
    //   68	75	75	finally
  }
  
  public InputStream openBufferedStream()
    throws IOException
  {
    InputStream localInputStream = openStream();
    if ((localInputStream instanceof BufferedInputStream)) {
      return (BufferedInputStream)localInputStream;
    }
    return new BufferedInputStream(localInputStream);
  }
  
  public abstract InputStream openStream()
    throws IOException;
  
  @Beta
  public <T> T read(ByteProcessor<T> paramByteProcessor)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteProcessor);
    Closer localCloser = Closer.create();
    try
    {
      paramByteProcessor = ByteStreams.readBytes((InputStream)localCloser.register(openStream()), paramByteProcessor);
      return paramByteProcessor;
    }
    catch (Throwable paramByteProcessor)
    {
      throw localCloser.rethrow(paramByteProcessor);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public byte[] read()
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      byte[] arrayOfByte = ByteStreams.toByteArray((InputStream)localCloser.register(openStream()));
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      throw localCloser.rethrow(localThrowable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public long size()
    throws IOException
  {
    localObject1 = sizeIfKnown();
    if (((Optional)localObject1).isPresent()) {
      return ((Long)((Optional)localObject1).get()).longValue();
    }
    localObject1 = Closer.create();
    try
    {
      l = countBySkipping((InputStream)((Closer)localObject1).register(openStream()));
      ((Closer)localObject1).close();
      return l;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      ((Closer)localObject1).close();
      localObject1 = Closer.create();
    }
    finally
    {
      try
      {
        long l = countByReading((InputStream)((Closer)localObject1).register(openStream()));
        return l;
      }
      catch (Throwable localThrowable)
      {
        throw ((Closer)localObject1).rethrow(localThrowable);
      }
      finally
      {
        ((Closer)localObject1).close();
      }
      localObject2 = finally;
      ((Closer)localObject1).close();
      throw ((Throwable)localObject2);
    }
  }
  
  @Beta
  public Optional<Long> sizeIfKnown()
  {
    return Optional.absent();
  }
  
  public ByteSource slice(long paramLong1, long paramLong2)
  {
    return new SlicedByteSource(paramLong1, paramLong2);
  }
  
  private final class AsCharSource
    extends CharSource
  {
    private final Charset charset;
    
    private AsCharSource(Charset paramCharset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(paramCharset));
    }
    
    public Reader openStream()
      throws IOException
    {
      return new InputStreamReader(ByteSource.this.openStream(), this.charset);
    }
    
    public String toString()
    {
      return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
    }
  }
  
  private static class ByteArrayByteSource
    extends ByteSource
  {
    final byte[] bytes;
    final int length;
    final int offset;
    
    ByteArrayByteSource(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayByteSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.bytes = paramArrayOfByte;
      this.offset = paramInt1;
      this.length = paramInt2;
    }
    
    public long copyTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.bytes, this.offset, this.length);
      return this.length;
    }
    
    public HashCode hash(HashFunction paramHashFunction)
      throws IOException
    {
      return paramHashFunction.hashBytes(this.bytes, this.offset, this.length);
    }
    
    public boolean isEmpty()
    {
      return this.length == 0;
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return openStream();
    }
    
    public InputStream openStream()
    {
      return new ByteArrayInputStream(this.bytes, this.offset, this.length);
    }
    
    public <T> T read(ByteProcessor<T> paramByteProcessor)
      throws IOException
    {
      paramByteProcessor.processBytes(this.bytes, this.offset, this.length);
      return (T)paramByteProcessor.getResult();
    }
    
    public byte[] read()
    {
      return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
    }
    
    public long size()
    {
      return this.length;
    }
    
    public Optional<Long> sizeIfKnown()
    {
      return Optional.of(Long.valueOf(this.length));
    }
    
    public ByteSource slice(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= 0L)
      {
        bool = true;
        Preconditions.checkArgument(bool, "offset (%s) may not be negative", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 < 0L) {
          break label111;
        }
      }
      label111:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "length (%s) may not be negative", new Object[] { Long.valueOf(paramLong2) });
        paramLong1 = Math.min(paramLong1, this.length);
        paramLong2 = Math.min(paramLong2, this.length - paramLong1);
        int i = this.offset;
        int j = (int)paramLong1;
        return new ByteArrayByteSource(this.bytes, i + j, (int)paramLong2);
        bool = false;
        break;
      }
    }
    
    public String toString()
    {
      return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
    }
  }
  
  private static final class ConcatenatedByteSource
    extends ByteSource
  {
    final Iterable<? extends ByteSource> sources;
    
    ConcatenatedByteSource(Iterable<? extends ByteSource> paramIterable)
    {
      this.sources = ((Iterable)Preconditions.checkNotNull(paramIterable));
    }
    
    public boolean isEmpty()
      throws IOException
    {
      Iterator localIterator = this.sources.iterator();
      while (localIterator.hasNext()) {
        if (!((ByteSource)localIterator.next()).isEmpty()) {
          return false;
        }
      }
      return true;
    }
    
    public InputStream openStream()
      throws IOException
    {
      return new MultiInputStream(this.sources.iterator());
    }
    
    public long size()
      throws IOException
    {
      long l = 0L;
      Iterator localIterator = this.sources.iterator();
      while (localIterator.hasNext()) {
        l += ((ByteSource)localIterator.next()).size();
      }
      return l;
    }
    
    public Optional<Long> sizeIfKnown()
    {
      long l = 0L;
      Iterator localIterator = this.sources.iterator();
      while (localIterator.hasNext())
      {
        Optional localOptional = ((ByteSource)localIterator.next()).sizeIfKnown();
        if (!localOptional.isPresent()) {
          return Optional.absent();
        }
        l += ((Long)localOptional.get()).longValue();
      }
      return Optional.of(Long.valueOf(l));
    }
    
    public String toString()
    {
      return "ByteSource.concat(" + this.sources + ")";
    }
  }
  
  private static final class EmptyByteSource
    extends ByteSource.ByteArrayByteSource
  {
    static final EmptyByteSource INSTANCE = new EmptyByteSource();
    
    EmptyByteSource()
    {
      super();
    }
    
    public CharSource asCharSource(Charset paramCharset)
    {
      Preconditions.checkNotNull(paramCharset);
      return CharSource.empty();
    }
    
    public byte[] read()
    {
      return this.bytes;
    }
    
    public String toString()
    {
      return "ByteSource.empty()";
    }
  }
  
  private final class SlicedByteSource
    extends ByteSource
  {
    final long length;
    final long offset;
    
    SlicedByteSource(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= 0L)
      {
        bool = true;
        Preconditions.checkArgument(bool, "offset (%s) may not be negative", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 < 0L) {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "length (%s) may not be negative", new Object[] { Long.valueOf(paramLong2) });
        this.offset = paramLong1;
        this.length = paramLong2;
        return;
        bool = false;
        break;
      }
    }
    
    private InputStream sliceStream(InputStream paramInputStream)
      throws IOException
    {
      if (this.offset > 0L) {
        try
        {
          long l = ByteStreams.skipUpTo(paramInputStream, this.offset);
          if (l < this.offset)
          {
            paramInputStream.close();
            return new ByteArrayInputStream(new byte[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          Closer localCloser = Closer.create();
          localCloser.register(paramInputStream);
          try
          {
            throw localCloser.rethrow(localThrowable);
          }
          finally
          {
            localCloser.close();
          }
        }
      }
      return ByteStreams.limit(paramInputStream, this.length);
    }
    
    public boolean isEmpty()
      throws IOException
    {
      return (this.length == 0L) || (super.isEmpty());
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openBufferedStream());
    }
    
    public InputStream openStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openStream());
    }
    
    public Optional<Long> sizeIfKnown()
    {
      Optional localOptional = ByteSource.this.sizeIfKnown();
      if (localOptional.isPresent())
      {
        long l1 = ((Long)localOptional.get()).longValue();
        long l2 = Math.min(this.offset, l1);
        return Optional.of(Long.valueOf(Math.min(this.length, l1 - l2)));
      }
      return Optional.absent();
    }
    
    public ByteSource slice(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= 0L)
      {
        bool = true;
        Preconditions.checkArgument(bool, "offset (%s) may not be negative", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 < 0L) {
          break label88;
        }
      }
      label88:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "length (%s) may not be negative", new Object[] { Long.valueOf(paramLong2) });
        long l = this.length;
        return ByteSource.this.slice(this.offset + paramLong1, Math.min(paramLong2, l - paramLong1));
        bool = false;
        break;
      }
    }
    
    public String toString()
    {
      return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/ByteSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */