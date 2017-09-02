package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public abstract interface Codec
  extends Compressor, Decompressor
{
  public static final class Gzip
    implements Codec
  {
    public OutputStream compress(OutputStream paramOutputStream)
      throws IOException
    {
      return new GZIPOutputStream(paramOutputStream);
    }
    
    public InputStream decompress(InputStream paramInputStream)
      throws IOException
    {
      return new GZIPInputStream(paramInputStream);
    }
    
    public String getMessageEncoding()
    {
      return "gzip";
    }
  }
  
  public static final class Identity
    implements Codec
  {
    public static final Codec NONE = new Identity();
    
    public OutputStream compress(OutputStream paramOutputStream)
      throws IOException
    {
      return paramOutputStream;
    }
    
    public InputStream decompress(InputStream paramInputStream)
      throws IOException
    {
      return paramInputStream;
    }
    
    public String getMessageEncoding()
    {
      return "identity";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */