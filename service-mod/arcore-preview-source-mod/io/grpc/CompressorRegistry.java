package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class CompressorRegistry
{
  private static final CompressorRegistry DEFAULT_INSTANCE = new CompressorRegistry(new Compressor[] { new Codec.Gzip(), Codec.Identity.NONE });
  private final ConcurrentMap<String, Compressor> compressors = new ConcurrentHashMap();
  
  @VisibleForTesting
  CompressorRegistry(Compressor... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Compressor localCompressor = paramVarArgs[i];
      this.compressors.put(localCompressor.getMessageEncoding(), localCompressor);
      i += 1;
    }
  }
  
  public static CompressorRegistry getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static CompressorRegistry newEmptyInstance()
  {
    return new CompressorRegistry(new Compressor[0]);
  }
  
  @Nullable
  public Compressor lookupCompressor(String paramString)
  {
    return (Compressor)this.compressors.get(paramString);
  }
  
  public void register(Compressor paramCompressor)
  {
    String str = paramCompressor.getMessageEncoding();
    if (!str.contains(",")) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Comma is currently not allowed in message encoding");
      this.compressors.put(str, paramCompressor);
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/CompressorRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */