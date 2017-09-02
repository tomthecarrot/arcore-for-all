package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource
  implements Source
{
  private static final byte FCOMMENT = 4;
  private static final byte FEXTRA = 2;
  private static final byte FHCRC = 1;
  private static final byte FNAME = 3;
  private static final byte SECTION_BODY = 1;
  private static final byte SECTION_DONE = 3;
  private static final byte SECTION_HEADER = 0;
  private static final byte SECTION_TRAILER = 2;
  private final CRC32 crc = new CRC32();
  private final Inflater inflater;
  private final InflaterSource inflaterSource;
  private int section = 0;
  private final BufferedSource source;
  
  public GzipSource(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.inflater = new Inflater(true);
    this.source = Okio.buffer(paramSource);
    this.inflaterSource = new InflaterSource(this.source, this.inflater);
  }
  
  private void checkEqual(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 != paramInt1) {
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
  }
  
  private void consumeHeader()
    throws IOException
  {
    this.source.require(10L);
    int j = this.source.buffer().getByte(3L);
    if ((j >> 1 & 0x1) == 1) {}
    long l;
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        updateCrc(this.source.buffer(), 0L, 10L);
      }
      checkEqual("ID1ID2", 8075, this.source.readShort());
      this.source.skip(8L);
      if ((j >> 2 & 0x1) == 1)
      {
        this.source.require(2L);
        if (i != 0) {
          updateCrc(this.source.buffer(), 0L, 2L);
        }
        int k = this.source.buffer().readShortLe();
        this.source.require(k);
        if (i != 0) {
          updateCrc(this.source.buffer(), 0L, k);
        }
        this.source.skip(k);
      }
      if ((j >> 3 & 0x1) != 1) {
        break label265;
      }
      l = this.source.indexOf((byte)0);
      if (l != -1L) {
        break;
      }
      throw new EOFException();
    }
    if (i != 0) {
      updateCrc(this.source.buffer(), 0L, 1L + l);
    }
    this.source.skip(1L + l);
    label265:
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.source.indexOf((byte)0);
      if (l == -1L) {
        throw new EOFException();
      }
      if (i != 0) {
        updateCrc(this.source.buffer(), 0L, 1L + l);
      }
      this.source.skip(1L + l);
    }
    if (i != 0)
    {
      checkEqual("FHCRC", this.source.readShortLe(), (short)(int)this.crc.getValue());
      this.crc.reset();
    }
  }
  
  private void consumeTrailer()
    throws IOException
  {
    checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
    checkEqual("ISIZE", this.source.readIntLe(), this.inflater.getTotalOut());
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Object localObject;
    long l1;
    long l2;
    for (paramBuffer = paramBuffer.head;; paramBuffer = paramBuffer.next)
    {
      localObject = paramBuffer;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < paramBuffer.limit - paramBuffer.pos) {
        break;
      }
      paramLong1 -= paramBuffer.limit - paramBuffer.pos;
    }
    while (l2 > 0L)
    {
      int i = (int)(((Segment)localObject).pos + l1);
      int j = (int)Math.min(((Segment)localObject).limit - i, l2);
      this.crc.update(((Segment)localObject).data, i, j);
      l2 -= j;
      l1 = 0L;
      localObject = ((Segment)localObject).next;
    }
  }
  
  public void close()
    throws IOException
  {
    this.inflaterSource.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    if (this.section == 0)
    {
      consumeHeader();
      this.section = 1;
    }
    if (this.section == 1)
    {
      long l = paramBuffer.size;
      paramLong = this.inflaterSource.read(paramBuffer, paramLong);
      if (paramLong != -1L)
      {
        updateCrc(paramBuffer, l, paramLong);
        return paramLong;
      }
      this.section = 2;
    }
    if (this.section == 2)
    {
      consumeTrailer();
      this.section = 3;
      if (!this.source.exhausted()) {
        throw new IOException("gzip finished without exhausting source");
      }
    }
    return -1L;
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/GzipSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */