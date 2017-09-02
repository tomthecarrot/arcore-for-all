package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Empty
  extends GeneratedMessageLite<Empty, Builder>
  implements EmptyOrBuilder
{
  private static final Empty DEFAULT_INSTANCE = new Empty();
  private static volatile Parser<Empty> PARSER;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static Empty getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Empty paramEmpty)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramEmpty);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Empty parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Empty)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Empty> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 99	com/google/protobuf/Empty$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 105	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+102->110, 7:+214->222, 8:+218->226
    //   56: new 107	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 108	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Empty
    //   67: dup
    //   68: invokespecial 22	com/google/protobuf/Empty:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 24	com/google/protobuf/Empty:DEFAULT_INSTANCE	Lcom/google/protobuf/Empty;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/Empty$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 111	com/google/protobuf/Empty$Builder:<init>	(Lcom/google/protobuf/Empty$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 113	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/Empty
    //   98: astore_1
    //   99: aload_0
    //   100: astore_1
    //   101: aload_2
    //   102: getstatic 119	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   105: if_acmpne -33 -> 72
    //   108: aload_0
    //   109: areturn
    //   110: aload_2
    //   111: checkcast 121	com/google/protobuf/CodedInputStream
    //   114: astore_1
    //   115: aload_3
    //   116: checkcast 123	com/google/protobuf/ExtensionRegistryLite
    //   119: astore_2
    //   120: iconst_0
    //   121: istore 4
    //   123: iload 4
    //   125: ifne +97 -> 222
    //   128: aload_1
    //   129: invokevirtual 126	com/google/protobuf/CodedInputStream:readTag	()I
    //   132: istore 5
    //   134: iload 5
    //   136: tableswitch	default:+131->267, 0:+39->175
    //   156: aload_1
    //   157: iload 5
    //   159: invokevirtual 130	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   162: istore 6
    //   164: iload 6
    //   166: ifne -43 -> 123
    //   169: iconst_1
    //   170: istore 4
    //   172: goto -49 -> 123
    //   175: iconst_1
    //   176: istore 4
    //   178: goto -55 -> 123
    //   181: astore_1
    //   182: new 132	java/lang/RuntimeException
    //   185: dup
    //   186: aload_1
    //   187: aload_0
    //   188: invokevirtual 136	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   191: invokespecial 139	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: new 132	java/lang/RuntimeException
    //   202: dup
    //   203: new 59	com/google/protobuf/InvalidProtocolBufferException
    //   206: dup
    //   207: aload_1
    //   208: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
    //   211: invokespecial 146	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 136	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   218: invokespecial 139	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   221: athrow
    //   222: getstatic 24	com/google/protobuf/Empty:DEFAULT_INSTANCE	Lcom/google/protobuf/Empty;
    //   225: areturn
    //   226: getstatic 148	com/google/protobuf/Empty:PARSER	Lcom/google/protobuf/Parser;
    //   229: ifnonnull +28 -> 257
    //   232: ldc 2
    //   234: monitorenter
    //   235: getstatic 148	com/google/protobuf/Empty:PARSER	Lcom/google/protobuf/Parser;
    //   238: ifnonnull +16 -> 254
    //   241: new 150	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   244: dup
    //   245: getstatic 24	com/google/protobuf/Empty:DEFAULT_INSTANCE	Lcom/google/protobuf/Empty;
    //   248: invokespecial 153	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   251: putstatic 148	com/google/protobuf/Empty:PARSER	Lcom/google/protobuf/Parser;
    //   254: ldc 2
    //   256: monitorexit
    //   257: getstatic 148	com/google/protobuf/Empty:PARSER	Lcom/google/protobuf/Parser;
    //   260: areturn
    //   261: astore_1
    //   262: ldc 2
    //   264: monitorexit
    //   265: aload_1
    //   266: athrow
    //   267: goto -111 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	Empty
    //   0	270	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	270	2	paramObject1	Object
    //   0	270	3	paramObject2	Object
    //   121	56	4	i	int
    //   132	26	5	j	int
    //   162	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   128	134	181	com/google/protobuf/InvalidProtocolBufferException
    //   156	164	181	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	195	finally
    //   156	164	195	finally
    //   182	195	195	finally
    //   199	222	195	finally
    //   128	134	198	java/io/IOException
    //   156	164	198	java/io/IOException
    //   235	254	261	finally
    //   254	257	261	finally
    //   262	265	261	finally
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    this.memoizedSerializedSize = 0;
    return 0;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {}
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Empty, Builder>
    implements EmptyOrBuilder
  {
    private Builder()
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Empty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */