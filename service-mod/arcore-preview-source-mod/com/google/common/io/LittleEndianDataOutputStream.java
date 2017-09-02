package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public class LittleEndianDataOutputStream
  extends FilterOutputStream
  implements DataOutput
{
  public LittleEndianDataOutputStream(OutputStream paramOutputStream)
  {
    super(new DataOutputStream((OutputStream)Preconditions.checkNotNull(paramOutputStream)));
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    ((DataOutputStream)this.out).writeBoolean(paramBoolean);
  }
  
  public void writeByte(int paramInt)
    throws IOException
  {
    ((DataOutputStream)this.out).writeByte(paramInt);
  }
  
  @Deprecated
  public void writeBytes(String paramString)
    throws IOException
  {
    ((DataOutputStream)this.out).writeBytes(paramString);
  }
  
  public void writeChar(int paramInt)
    throws IOException
  {
    writeShort(paramInt);
  }
  
  public void writeChars(String paramString)
    throws IOException
  {
    int i = 0;
    while (i < paramString.length())
    {
      writeChar(paramString.charAt(i));
      i += 1;
    }
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    writeInt(Float.floatToIntBits(paramFloat));
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.out.write(paramInt & 0xFF);
    this.out.write(paramInt >> 8 & 0xFF);
    this.out.write(paramInt >> 16 & 0xFF);
    this.out.write(paramInt >> 24 & 0xFF);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = Longs.toByteArray(Long.reverseBytes(paramLong));
    write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void writeShort(int paramInt)
    throws IOException
  {
    this.out.write(paramInt & 0xFF);
    this.out.write(paramInt >> 8 & 0xFF);
  }
  
  public void writeUTF(String paramString)
    throws IOException
  {
    ((DataOutputStream)this.out).writeUTF(paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/LittleEndianDataOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */