package com.google.protobuf;

final class TextFormatEscaper
{
  static String escapeBytes(ByteString paramByteString)
  {
    escapeBytes(new ByteSequence()
    {
      public byte byteAt(int paramAnonymousInt)
      {
        return this.val$input.byteAt(paramAnonymousInt);
      }
      
      public int size()
      {
        return this.val$input.size();
      }
    });
  }
  
  static String escapeBytes(ByteSequence paramByteSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramByteSequence.size());
    int i = 0;
    if (i < paramByteSequence.size())
    {
      int j = paramByteSequence.byteAt(i);
      switch (j)
      {
      default: 
        if ((j >= 32) && (j <= 126)) {
          localStringBuilder.append((char)j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("\\a");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\v");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\'");
        continue;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append('\\');
        localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
        localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
        localStringBuilder.append((char)((j & 0x7) + 48));
      }
    }
    return localStringBuilder.toString();
  }
  
  static String escapeBytes(byte[] paramArrayOfByte)
  {
    escapeBytes(new ByteSequence()
    {
      public byte byteAt(int paramAnonymousInt)
      {
        return this.val$input[paramAnonymousInt];
      }
      
      public int size()
      {
        return this.val$input.length;
      }
    });
  }
  
  static String escapeDoubleQuotesAndBackslashes(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
  
  static String escapeText(String paramString)
  {
    return escapeBytes(ByteString.copyFromUtf8(paramString));
  }
  
  private static abstract interface ByteSequence
  {
    public abstract byte byteAt(int paramInt);
    
    public abstract int size();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/TextFormatEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */