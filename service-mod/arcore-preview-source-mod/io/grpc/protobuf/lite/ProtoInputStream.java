package io.grpc.protobuf.lite;

import com.google.common.io.ByteStreams;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

class ProtoInputStream
  extends InputStream
  implements Drainable, KnownLength
{
  @Nullable
  private MessageLite message;
  private final Parser<?> parser;
  @Nullable
  private ByteArrayInputStream partial;
  
  public ProtoInputStream(MessageLite paramMessageLite, Parser<?> paramParser)
  {
    this.message = paramMessageLite;
    this.parser = paramParser;
  }
  
  public int available()
    throws IOException
  {
    if (this.message != null) {
      return this.message.getSerializedSize();
    }
    if (this.partial != null) {
      return this.partial.available();
    }
    return 0;
  }
  
  public int drainTo(OutputStream paramOutputStream)
    throws IOException
  {
    int i;
    if (this.message != null)
    {
      i = this.message.getSerializedSize();
      this.message.writeTo(paramOutputStream);
      this.message = null;
      return i;
    }
    if (this.partial != null)
    {
      i = (int)ByteStreams.copy(this.partial, paramOutputStream);
      this.partial = null;
      return i;
    }
    return 0;
  }
  
  MessageLite message()
  {
    if (this.message == null) {
      throw new IllegalStateException("message not available");
    }
    return this.message;
  }
  
  Parser<?> parser()
  {
    return this.parser;
  }
  
  public int read()
    throws IOException
  {
    if (this.message != null)
    {
      this.partial = new ByteArrayInputStream(this.message.toByteArray());
      this.message = null;
    }
    if (this.partial != null) {
      return this.partial.read();
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.message != null)
    {
      int i = this.message.getSerializedSize();
      if (i == 0)
      {
        this.message = null;
        this.partial = null;
        return -1;
      }
      if (paramInt2 >= i)
      {
        paramArrayOfByte = CodedOutputStream.newInstance(paramArrayOfByte, paramInt1, i);
        this.message.writeTo(paramArrayOfByte);
        paramArrayOfByte.flush();
        paramArrayOfByte.checkNoSpaceLeft();
        this.message = null;
        this.partial = null;
        return i;
      }
      this.partial = new ByteArrayInputStream(this.message.toByteArray());
      this.message = null;
    }
    if (this.partial != null) {
      return this.partial.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/protobuf/lite/ProtoInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */