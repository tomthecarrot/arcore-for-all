package io.grpc;

import java.nio.charset.Charset;

public final class InternalMetadata
{
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  
  public static <T> Metadata.Key<T> keyOf(String paramString, TrustedAsciiMarshaller<T> paramTrustedAsciiMarshaller)
  {
    return Metadata.Key.of(paramString, paramTrustedAsciiMarshaller);
  }
  
  public static Metadata newMetadata(int paramInt, byte[]... paramVarArgs)
  {
    return new Metadata(paramInt, paramVarArgs);
  }
  
  public static Metadata newMetadata(byte[]... paramVarArgs)
  {
    return new Metadata(paramVarArgs);
  }
  
  public static byte[][] serialize(Metadata paramMetadata)
  {
    return paramMetadata.serialize();
  }
  
  public static abstract interface TrustedAsciiMarshaller<T>
    extends Metadata.TrustedAsciiMarshaller<T>
  {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/InternalMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */