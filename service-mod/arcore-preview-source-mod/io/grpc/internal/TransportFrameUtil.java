package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import java.util.Arrays;
import java.util.logging.Logger;

public final class TransportFrameUtil
{
  private static final byte[] binaryHeaderSuffixBytes = "-bin".getBytes(Charsets.US_ASCII);
  private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());
  
  private static boolean endsWith(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length - paramArrayOfByte2.length;
    if (j < 0) {
      return false;
    }
    int i = j;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label38;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[(i - j)]) {
        break;
      }
      i += 1;
    }
    label38:
    return true;
  }
  
  private static boolean isSpecCompliantAscii(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k < 32) || (k > 126)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static byte[][] toHttp2Headers(Metadata paramMetadata)
  {
    byte[][] arrayOfByte = InternalMetadata.serialize(paramMetadata);
    if (arrayOfByte == null) {
      paramMetadata = new byte[0][];
    }
    int i;
    do
    {
      return paramMetadata;
      i = 0;
      int j = 0;
      if (j < arrayOfByte.length)
      {
        Object localObject = arrayOfByte[j];
        paramMetadata = arrayOfByte[(j + 1)];
        if (endsWith((byte[])localObject, binaryHeaderSuffixBytes))
        {
          arrayOfByte[i] = localObject;
          arrayOfByte[(i + 1)] = BaseEncoding.base64().encode(paramMetadata).getBytes(Charsets.US_ASCII);
          i += 2;
        }
        for (;;)
        {
          j += 2;
          break;
          if (isSpecCompliantAscii(paramMetadata))
          {
            arrayOfByte[i] = localObject;
            arrayOfByte[(i + 1)] = paramMetadata;
            i += 2;
          }
          else
          {
            localObject = new String((byte[])localObject, Charsets.US_ASCII);
            logger.warning("Metadata key=" + (String)localObject + ", value=" + Arrays.toString(paramMetadata) + " contains invalid ASCII characters");
          }
        }
      }
      paramMetadata = arrayOfByte;
    } while (i == arrayOfByte.length);
    return (byte[][])Arrays.copyOfRange(arrayOfByte, 0, i);
  }
  
  public static byte[][] toRawSerializedHeaders(byte[][] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      byte[] arrayOfByte1 = paramArrayOfByte[i];
      byte[] arrayOfByte2 = paramArrayOfByte[(i + 1)];
      paramArrayOfByte[i] = arrayOfByte1;
      if (endsWith(arrayOfByte1, binaryHeaderSuffixBytes)) {
        paramArrayOfByte[(i + 1)] = BaseEncoding.base64().decode(new String(arrayOfByte2, Charsets.US_ASCII));
      }
      i += 2;
    }
    return paramArrayOfByte;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/TransportFrameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */