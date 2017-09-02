package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class SourceContext
  extends GeneratedMessageLite<SourceContext, Builder>
  implements SourceContextOrBuilder
{
  private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
  public static final int FILE_NAME_FIELD_NUMBER = 1;
  private static volatile Parser<SourceContext> PARSER;
  private String fileName_ = "";
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFileName()
  {
    this.fileName_ = getDefaultInstance().getFileName();
  }
  
  public static SourceContext getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceContext paramSourceContext)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSourceContext);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (SourceContext)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceContext> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFileName(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.fileName_ = paramString;
  }
  
  private void setFileNameBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.fileName_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 142	com/google/protobuf/SourceContext$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 148	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+164->172, 7:+283->291, 8:+287->295
    //   56: new 150	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 151	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/SourceContext
    //   67: dup
    //   68: invokespecial 27	com/google/protobuf/SourceContext:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 29	com/google/protobuf/SourceContext:DEFAULT_INSTANCE	Lcom/google/protobuf/SourceContext;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/SourceContext$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 154	com/google/protobuf/SourceContext$Builder:<init>	(Lcom/google/protobuf/SourceContext$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 156	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/SourceContext
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   103: invokevirtual 162	java/lang/String:isEmpty	()Z
    //   106: ifne +54 -> 160
    //   109: iconst_1
    //   110: istore 6
    //   112: aload_0
    //   113: getfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   116: astore_3
    //   117: aload_1
    //   118: getfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   121: invokevirtual 162	java/lang/String:isEmpty	()Z
    //   124: ifne +42 -> 166
    //   127: iconst_1
    //   128: istore 7
    //   130: aload_0
    //   131: aload_2
    //   132: iload 6
    //   134: aload_3
    //   135: iload 7
    //   137: aload_1
    //   138: getfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   141: invokeinterface 166 5 0
    //   146: putfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   149: aload_0
    //   150: astore_1
    //   151: aload_2
    //   152: getstatic 172	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   155: if_acmpne -83 -> 72
    //   158: aload_0
    //   159: areturn
    //   160: iconst_0
    //   161: istore 6
    //   163: goto -51 -> 112
    //   166: iconst_0
    //   167: istore 7
    //   169: goto -39 -> 130
    //   172: aload_2
    //   173: checkcast 174	com/google/protobuf/CodedInputStream
    //   176: astore_1
    //   177: aload_3
    //   178: checkcast 176	com/google/protobuf/ExtensionRegistryLite
    //   181: astore_2
    //   182: iconst_0
    //   183: istore 4
    //   185: iload 4
    //   187: ifne +104 -> 291
    //   190: aload_1
    //   191: invokevirtual 179	com/google/protobuf/CodedInputStream:readTag	()I
    //   194: istore 5
    //   196: iload 5
    //   198: lookupswitch	default:+138->336, 0:+141->339, 10:+41->239
    //   224: aload_1
    //   225: iload 5
    //   227: invokevirtual 183	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   230: ifne -45 -> 185
    //   233: iconst_1
    //   234: istore 4
    //   236: goto -51 -> 185
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 186	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   244: putfield 38	com/google/protobuf/SourceContext:fileName_	Ljava/lang/String;
    //   247: goto -62 -> 185
    //   250: astore_1
    //   251: new 188	java/lang/RuntimeException
    //   254: dup
    //   255: aload_1
    //   256: aload_0
    //   257: invokevirtual 192	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   260: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   263: athrow
    //   264: astore_1
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: new 188	java/lang/RuntimeException
    //   271: dup
    //   272: new 91	com/google/protobuf/InvalidProtocolBufferException
    //   275: dup
    //   276: aload_1
    //   277: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokespecial 200	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 192	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   287: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   290: athrow
    //   291: getstatic 29	com/google/protobuf/SourceContext:DEFAULT_INSTANCE	Lcom/google/protobuf/SourceContext;
    //   294: areturn
    //   295: getstatic 202	com/google/protobuf/SourceContext:PARSER	Lcom/google/protobuf/Parser;
    //   298: ifnonnull +28 -> 326
    //   301: ldc 2
    //   303: monitorenter
    //   304: getstatic 202	com/google/protobuf/SourceContext:PARSER	Lcom/google/protobuf/Parser;
    //   307: ifnonnull +16 -> 323
    //   310: new 204	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   313: dup
    //   314: getstatic 29	com/google/protobuf/SourceContext:DEFAULT_INSTANCE	Lcom/google/protobuf/SourceContext;
    //   317: invokespecial 207	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   320: putstatic 202	com/google/protobuf/SourceContext:PARSER	Lcom/google/protobuf/Parser;
    //   323: ldc 2
    //   325: monitorexit
    //   326: getstatic 202	com/google/protobuf/SourceContext:PARSER	Lcom/google/protobuf/Parser;
    //   329: areturn
    //   330: astore_1
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload_1
    //   335: athrow
    //   336: goto -112 -> 224
    //   339: iconst_1
    //   340: istore 4
    //   342: goto -157 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	SourceContext
    //   0	345	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	345	2	paramObject1	Object
    //   0	345	3	paramObject2	Object
    //   183	158	4	i	int
    //   194	32	5	j	int
    //   110	52	6	bool1	boolean
    //   128	40	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   190	196	250	com/google/protobuf/InvalidProtocolBufferException
    //   224	233	250	com/google/protobuf/InvalidProtocolBufferException
    //   239	247	250	com/google/protobuf/InvalidProtocolBufferException
    //   190	196	264	finally
    //   224	233	264	finally
    //   239	247	264	finally
    //   251	264	264	finally
    //   268	291	264	finally
    //   190	196	267	java/io/IOException
    //   224	233	267	java/io/IOException
    //   239	247	267	java/io/IOException
    //   304	323	330	finally
    //   323	326	330	finally
    //   331	334	330	finally
  }
  
  public String getFileName()
  {
    return this.fileName_;
  }
  
  public ByteString getFileNameBytes()
  {
    return ByteString.copyFromUtf8(this.fileName_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (!this.fileName_.isEmpty()) {
      i = 0 + CodedOutputStream.computeStringSize(1, getFileName());
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.fileName_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getFileName());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<SourceContext, Builder>
    implements SourceContextOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearFileName()
    {
      copyOnWrite();
      ((SourceContext)this.instance).clearFileName();
      return this;
    }
    
    public String getFileName()
    {
      return ((SourceContext)this.instance).getFileName();
    }
    
    public ByteString getFileNameBytes()
    {
      return ((SourceContext)this.instance).getFileNameBytes();
    }
    
    public Builder setFileName(String paramString)
    {
      copyOnWrite();
      ((SourceContext)this.instance).setFileName(paramString);
      return this;
    }
    
    public Builder setFileNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((SourceContext)this.instance).setFileNameBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/SourceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */