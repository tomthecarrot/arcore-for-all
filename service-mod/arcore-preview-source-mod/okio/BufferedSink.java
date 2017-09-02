package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract interface BufferedSink
  extends Sink
{
  public abstract Buffer buffer();
  
  public abstract BufferedSink emit()
    throws IOException;
  
  public abstract BufferedSink emitCompleteSegments()
    throws IOException;
  
  public abstract OutputStream outputStream();
  
  public abstract BufferedSink write(ByteString paramByteString)
    throws IOException;
  
  public abstract BufferedSink write(Source paramSource, long paramLong)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long writeAll(Source paramSource)
    throws IOException;
  
  public abstract BufferedSink writeByte(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeDecimalLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeHexadecimalUnsignedLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeInt(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeIntLe(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeLongLe(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeShort(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeShortLe(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException;
  
  public abstract BufferedSink writeString(String paramString, Charset paramCharset)
    throws IOException;
  
  public abstract BufferedSink writeUtf8(String paramString)
    throws IOException;
  
  public abstract BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract BufferedSink writeUtf8CodePoint(int paramInt)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/BufferedSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */