package io.grpc;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class DecompressorRegistry
{
  static final Joiner ACCEPT_ENCODING_JOINER = Joiner.on(',');
  private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);
  private final byte[] advertisedDecompressors;
  private final Map<String, DecompressorInfo> decompressors;
  
  private DecompressorRegistry()
  {
    this.decompressors = new LinkedHashMap(0);
    this.advertisedDecompressors = new byte[0];
  }
  
  private DecompressorRegistry(Decompressor paramDecompressor, boolean paramBoolean, DecompressorRegistry paramDecompressorRegistry)
  {
    String str1 = paramDecompressor.getMessageEncoding();
    if (!str1.contains(",")) {}
    LinkedHashMap localLinkedHashMap;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Comma is currently not allowed in message encoding");
      int j = paramDecompressorRegistry.decompressors.size();
      int i = j;
      if (!paramDecompressorRegistry.decompressors.containsKey(paramDecompressor.getMessageEncoding())) {
        i = j + 1;
      }
      localLinkedHashMap = new LinkedHashMap(i);
      paramDecompressorRegistry = paramDecompressorRegistry.decompressors.values().iterator();
      while (paramDecompressorRegistry.hasNext())
      {
        DecompressorInfo localDecompressorInfo = (DecompressorInfo)paramDecompressorRegistry.next();
        String str2 = localDecompressorInfo.decompressor.getMessageEncoding();
        if (!str2.equals(str1)) {
          localLinkedHashMap.put(str2, new DecompressorInfo(localDecompressorInfo.decompressor, localDecompressorInfo.advertised));
        }
      }
    }
    localLinkedHashMap.put(str1, new DecompressorInfo(paramDecompressor, paramBoolean));
    this.decompressors = Collections.unmodifiableMap(localLinkedHashMap);
    this.advertisedDecompressors = ACCEPT_ENCODING_JOINER.join(getAdvertisedMessageEncodings()).getBytes(Charset.forName("US-ASCII"));
  }
  
  public static DecompressorRegistry emptyInstance()
  {
    return new DecompressorRegistry();
  }
  
  public static DecompressorRegistry getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public Set<String> getAdvertisedMessageEncodings()
  {
    HashSet localHashSet = new HashSet(this.decompressors.size());
    Iterator localIterator = this.decompressors.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((DecompressorInfo)localEntry.getValue()).advertised) {
        localHashSet.add(localEntry.getKey());
      }
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public Set<String> getKnownMessageEncodings()
  {
    return this.decompressors.keySet();
  }
  
  byte[] getRawAdvertisedMessageEncodings()
  {
    return this.advertisedDecompressors;
  }
  
  @Nullable
  public Decompressor lookupDecompressor(String paramString)
  {
    paramString = (DecompressorInfo)this.decompressors.get(paramString);
    if (paramString != null) {
      return paramString.decompressor;
    }
    return null;
  }
  
  public DecompressorRegistry with(Decompressor paramDecompressor, boolean paramBoolean)
  {
    return new DecompressorRegistry(paramDecompressor, paramBoolean, this);
  }
  
  private static final class DecompressorInfo
  {
    final boolean advertised;
    final Decompressor decompressor;
    
    DecompressorInfo(Decompressor paramDecompressor, boolean paramBoolean)
    {
      this.decompressor = ((Decompressor)Preconditions.checkNotNull(paramDecompressor, "decompressor"));
      this.advertised = paramBoolean;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/DecompressorRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */