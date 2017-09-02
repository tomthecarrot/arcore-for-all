package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc = new CRC32();
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final BufferedSink sink;
  
  public GzipSink(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.deflater = new Deflater(-1, true);
    this.sink = Okio.buffer(paramSink);
    this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
    writeHeader();
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong)
  {
    for (paramBuffer = paramBuffer.head; paramLong > 0L; paramBuffer = paramBuffer.next)
    {
      int i = (int)Math.min(paramLong, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong -= i;
    }
  }
  
  private void writeFooter()
    throws IOException
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe(this.deflater.getTotalIn());
  }
  
  private void writeHeader()
  {
    Buffer localBuffer = this.sink.buffer();
    localBuffer.writeShort(8075);
    localBuffer.writeByte(8);
    localBuffer.writeByte(0);
    localBuffer.writeInt(0);
    localBuffer.writeByte(0);
    localBuffer.writeByte(0);
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        this.deflaterSink.finishDeflate();
        writeFooter();
        try
        {
          this.deflater.end();
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            label41:
            localObject1 = localThrowable1;
            if (localThrowable1 == null) {
              localObject1 = localThrowable2;
            }
          }
        }
        try
        {
          this.sink.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          Object localObject3 = localObject1;
          if (localObject1 != null) {
            break label41;
          }
          localObject3 = localThrowable3;
          break label41;
        }
        this.closed = true;
        if (localObject2 == null) {
          continue;
        }
        Util.sneakyRethrow((Throwable)localObject2);
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
    }
  }
  
  public void flush()
    throws IOException
  {
    this.deflaterSink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return;
    }
    updateCrc(paramBuffer, paramLong);
    this.deflaterSink.write(paramBuffer, paramLong);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/GzipSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */