package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@Beta
public final class Funnels
{
  public static OutputStream asOutputStream(PrimitiveSink paramPrimitiveSink)
  {
    return new SinkAsStream(paramPrimitiveSink);
  }
  
  public static Funnel<byte[]> byteArrayFunnel()
  {
    return ByteArrayFunnel.INSTANCE;
  }
  
  public static Funnel<Integer> integerFunnel()
  {
    return IntegerFunnel.INSTANCE;
  }
  
  public static Funnel<Long> longFunnel()
  {
    return LongFunnel.INSTANCE;
  }
  
  public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> paramFunnel)
  {
    return new SequentialFunnel(paramFunnel);
  }
  
  public static Funnel<CharSequence> stringFunnel(Charset paramCharset)
  {
    return new StringCharsetFunnel(paramCharset);
  }
  
  public static Funnel<CharSequence> unencodedCharsFunnel()
  {
    return UnencodedCharsFunnel.INSTANCE;
  }
  
  private static enum ByteArrayFunnel
    implements Funnel<byte[]>
  {
    INSTANCE;
    
    private ByteArrayFunnel() {}
    
    public void funnel(byte[] paramArrayOfByte, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putBytes(paramArrayOfByte);
    }
    
    public String toString()
    {
      return "Funnels.byteArrayFunnel()";
    }
  }
  
  private static enum IntegerFunnel
    implements Funnel<Integer>
  {
    INSTANCE;
    
    private IntegerFunnel() {}
    
    public void funnel(Integer paramInteger, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putInt(paramInteger.intValue());
    }
    
    public String toString()
    {
      return "Funnels.integerFunnel()";
    }
  }
  
  private static enum LongFunnel
    implements Funnel<Long>
  {
    INSTANCE;
    
    private LongFunnel() {}
    
    public void funnel(Long paramLong, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putLong(paramLong.longValue());
    }
    
    public String toString()
    {
      return "Funnels.longFunnel()";
    }
  }
  
  private static class SequentialFunnel<E>
    implements Funnel<Iterable<? extends E>>, Serializable
  {
    private final Funnel<E> elementFunnel;
    
    SequentialFunnel(Funnel<E> paramFunnel)
    {
      this.elementFunnel = ((Funnel)Preconditions.checkNotNull(paramFunnel));
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof SequentialFunnel))
      {
        paramObject = (SequentialFunnel)paramObject;
        return this.elementFunnel.equals(((SequentialFunnel)paramObject).elementFunnel);
      }
      return false;
    }
    
    public void funnel(Iterable<? extends E> paramIterable, PrimitiveSink paramPrimitiveSink)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        this.elementFunnel.funnel(localObject, paramPrimitiveSink);
      }
    }
    
    public int hashCode()
    {
      return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }
    
    public String toString()
    {
      return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
    }
  }
  
  private static class SinkAsStream
    extends OutputStream
  {
    final PrimitiveSink sink;
    
    SinkAsStream(PrimitiveSink paramPrimitiveSink)
    {
      this.sink = ((PrimitiveSink)Preconditions.checkNotNull(paramPrimitiveSink));
    }
    
    public String toString()
    {
      return "Funnels.asOutputStream(" + this.sink + ")";
    }
    
    public void write(int paramInt)
    {
      this.sink.putByte((byte)paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      this.sink.putBytes(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.sink.putBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static class StringCharsetFunnel
    implements Funnel<CharSequence>, Serializable
  {
    private final Charset charset;
    
    StringCharsetFunnel(Charset paramCharset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(paramCharset));
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof StringCharsetFunnel))
      {
        paramObject = (StringCharsetFunnel)paramObject;
        return this.charset.equals(((StringCharsetFunnel)paramObject).charset);
      }
      return false;
    }
    
    public void funnel(CharSequence paramCharSequence, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putString(paramCharSequence, this.charset);
    }
    
    public int hashCode()
    {
      return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }
    
    public String toString()
    {
      return "Funnels.stringFunnel(" + this.charset.name() + ")";
    }
    
    Object writeReplace()
    {
      return new SerializedForm(this.charset);
    }
    
    private static class SerializedForm
      implements Serializable
    {
      private static final long serialVersionUID = 0L;
      private final String charsetCanonicalName;
      
      SerializedForm(Charset paramCharset)
      {
        this.charsetCanonicalName = paramCharset.name();
      }
      
      private Object readResolve()
      {
        return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
      }
    }
  }
  
  private static enum UnencodedCharsFunnel
    implements Funnel<CharSequence>
  {
    INSTANCE;
    
    private UnencodedCharsFunnel() {}
    
    public void funnel(CharSequence paramCharSequence, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putUnencodedChars(paramCharSequence);
    }
    
    public String toString()
    {
      return "Funnels.unencodedCharsFunnel()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/Funnels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */