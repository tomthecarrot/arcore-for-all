package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

class NameValueBlockReader
{
  private int compressedLimit;
  private final InflaterSource inflaterSource = new InflaterSource(new ForwardingSource(paramBufferedSource)new Inflater
  {
    public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
      throws IOException
    {
      if (NameValueBlockReader.this.compressedLimit == 0) {
        return -1L;
      }
      paramAnonymousLong = super.read(paramAnonymousBuffer, Math.min(paramAnonymousLong, NameValueBlockReader.this.compressedLimit));
      if (paramAnonymousLong == -1L) {
        return -1L;
      }
      NameValueBlockReader.access$002(NameValueBlockReader.this, (int)(NameValueBlockReader.this.compressedLimit - paramAnonymousLong));
      return paramAnonymousLong;
    }
  }, new Inflater()
  {
    public int inflate(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      throws DataFormatException
    {
      int j = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (needsDictionary())
        {
          setDictionary(Spdy3.DICTIONARY);
          i = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
      }
      return i;
    }
  });
  private final BufferedSource source = Okio.buffer(this.inflaterSource);
  
  public NameValueBlockReader(BufferedSource paramBufferedSource) {}
  
  private void doneReading()
    throws IOException
  {
    if (this.compressedLimit > 0)
    {
      this.inflaterSource.refill();
      if (this.compressedLimit != 0) {
        throw new IOException("compressedLimit > 0: " + this.compressedLimit);
      }
    }
  }
  
  private ByteString readByteString()
    throws IOException
  {
    int i = this.source.readInt();
    return this.source.readByteString(i);
  }
  
  public void close()
    throws IOException
  {
    this.source.close();
  }
  
  public List<Header> readNameValueBlock(int paramInt)
    throws IOException
  {
    this.compressedLimit += paramInt;
    int i = this.source.readInt();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      ByteString localByteString1 = readByteString().toAsciiLowercase();
      ByteString localByteString2 = readByteString();
      if (localByteString1.size() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new Header(localByteString1, localByteString2));
      paramInt += 1;
    }
    doneReading();
    return localArrayList;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/framed/NameValueBlockReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */