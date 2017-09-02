package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Any
  extends GeneratedMessageLite<Any, Builder>
  implements AnyOrBuilder
{
  private static final Any DEFAULT_INSTANCE = new Any();
  private static volatile Parser<Any> PARSER;
  public static final int TYPE_URL_FIELD_NUMBER = 1;
  public static final int VALUE_FIELD_NUMBER = 2;
  private String typeUrl_ = "";
  private ByteString value_ = ByteString.EMPTY;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearTypeUrl()
  {
    this.typeUrl_ = getDefaultInstance().getTypeUrl();
  }
  
  private void clearValue()
  {
    this.value_ = getDefaultInstance().getValue();
  }
  
  public static Any getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Any paramAny)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAny);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Any)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Any)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Any parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Any parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Any parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Any)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Any> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setTypeUrl(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.typeUrl_ = paramString;
  }
  
  private void setTypeUrlBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.typeUrl_ = paramByteString.toStringUtf8();
  }
  
  private void setValue(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.value_ = paramByteString;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 163	com/google/protobuf/Any$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 169	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+226->234, 7:+366->374, 8:+370->378
    //   56: new 171	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 172	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Any
    //   67: dup
    //   68: invokespecial 31	com/google/protobuf/Any:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 33	com/google/protobuf/Any:DEFAULT_INSTANCE	Lcom/google/protobuf/Any;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/Any$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 175	com/google/protobuf/Any$Builder:<init>	(Lcom/google/protobuf/Any$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 177	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/Any
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   103: invokevirtual 183	java/lang/String:isEmpty	()Z
    //   106: ifne +104 -> 210
    //   109: iconst_1
    //   110: istore 6
    //   112: aload_0
    //   113: getfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   116: astore_3
    //   117: aload_1
    //   118: getfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   121: invokevirtual 183	java/lang/String:isEmpty	()Z
    //   124: ifne +92 -> 216
    //   127: iconst_1
    //   128: istore 7
    //   130: aload_0
    //   131: aload_2
    //   132: iload 6
    //   134: aload_3
    //   135: iload 7
    //   137: aload_1
    //   138: getfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   141: invokeinterface 187 5 0
    //   146: putfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   153: getstatic 47	com/google/protobuf/ByteString:EMPTY	Lcom/google/protobuf/ByteString;
    //   156: if_acmpeq +66 -> 222
    //   159: iconst_1
    //   160: istore 6
    //   162: aload_0
    //   163: getfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   166: astore_3
    //   167: aload_1
    //   168: getfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   171: getstatic 47	com/google/protobuf/ByteString:EMPTY	Lcom/google/protobuf/ByteString;
    //   174: if_acmpeq +54 -> 228
    //   177: iconst_1
    //   178: istore 7
    //   180: aload_0
    //   181: aload_2
    //   182: iload 6
    //   184: aload_3
    //   185: iload 7
    //   187: aload_1
    //   188: getfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   191: invokeinterface 191 5 0
    //   196: putfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   199: aload_0
    //   200: astore_1
    //   201: aload_2
    //   202: getstatic 197	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   205: if_acmpne -133 -> 72
    //   208: aload_0
    //   209: areturn
    //   210: iconst_0
    //   211: istore 6
    //   213: goto -101 -> 112
    //   216: iconst_0
    //   217: istore 7
    //   219: goto -89 -> 130
    //   222: iconst_0
    //   223: istore 6
    //   225: goto -63 -> 162
    //   228: iconst_0
    //   229: istore 7
    //   231: goto -51 -> 180
    //   234: aload_2
    //   235: checkcast 199	com/google/protobuf/CodedInputStream
    //   238: astore_1
    //   239: aload_3
    //   240: checkcast 201	com/google/protobuf/ExtensionRegistryLite
    //   243: astore_2
    //   244: iconst_0
    //   245: istore 4
    //   247: iload 4
    //   249: ifne +125 -> 374
    //   252: aload_1
    //   253: invokevirtual 204	com/google/protobuf/CodedInputStream:readTag	()I
    //   256: istore 5
    //   258: iload 5
    //   260: lookupswitch	default:+159->419, 0:+162->422, 10:+51->311, 18:+79->339
    //   296: aload_1
    //   297: iload 5
    //   299: invokevirtual 208	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   302: ifne -55 -> 247
    //   305: iconst_1
    //   306: istore 4
    //   308: goto -61 -> 247
    //   311: aload_0
    //   312: aload_1
    //   313: invokevirtual 211	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   316: putfield 42	com/google/protobuf/Any:typeUrl_	Ljava/lang/String;
    //   319: goto -72 -> 247
    //   322: astore_1
    //   323: new 213	java/lang/RuntimeException
    //   326: dup
    //   327: aload_1
    //   328: aload_0
    //   329: invokevirtual 217	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   332: invokespecial 220	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   335: athrow
    //   336: astore_1
    //   337: aload_1
    //   338: athrow
    //   339: aload_0
    //   340: aload_1
    //   341: invokevirtual 223	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
    //   344: putfield 49	com/google/protobuf/Any:value_	Lcom/google/protobuf/ByteString;
    //   347: goto -100 -> 247
    //   350: astore_1
    //   351: new 213	java/lang/RuntimeException
    //   354: dup
    //   355: new 114	com/google/protobuf/InvalidProtocolBufferException
    //   358: dup
    //   359: aload_1
    //   360: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: invokespecial 228	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 217	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   370: invokespecial 220	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   373: athrow
    //   374: getstatic 33	com/google/protobuf/Any:DEFAULT_INSTANCE	Lcom/google/protobuf/Any;
    //   377: areturn
    //   378: getstatic 230	com/google/protobuf/Any:PARSER	Lcom/google/protobuf/Parser;
    //   381: ifnonnull +28 -> 409
    //   384: ldc 2
    //   386: monitorenter
    //   387: getstatic 230	com/google/protobuf/Any:PARSER	Lcom/google/protobuf/Parser;
    //   390: ifnonnull +16 -> 406
    //   393: new 232	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   396: dup
    //   397: getstatic 33	com/google/protobuf/Any:DEFAULT_INSTANCE	Lcom/google/protobuf/Any;
    //   400: invokespecial 235	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   403: putstatic 230	com/google/protobuf/Any:PARSER	Lcom/google/protobuf/Parser;
    //   406: ldc 2
    //   408: monitorexit
    //   409: getstatic 230	com/google/protobuf/Any:PARSER	Lcom/google/protobuf/Parser;
    //   412: areturn
    //   413: astore_1
    //   414: ldc 2
    //   416: monitorexit
    //   417: aload_1
    //   418: athrow
    //   419: goto -123 -> 296
    //   422: iconst_1
    //   423: istore 4
    //   425: goto -178 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	Any
    //   0	428	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	428	2	paramObject1	Object
    //   0	428	3	paramObject2	Object
    //   245	179	4	i	int
    //   256	42	5	j	int
    //   110	114	6	bool1	boolean
    //   128	102	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   252	258	322	com/google/protobuf/InvalidProtocolBufferException
    //   296	305	322	com/google/protobuf/InvalidProtocolBufferException
    //   311	319	322	com/google/protobuf/InvalidProtocolBufferException
    //   339	347	322	com/google/protobuf/InvalidProtocolBufferException
    //   252	258	336	finally
    //   296	305	336	finally
    //   311	319	336	finally
    //   323	336	336	finally
    //   339	347	336	finally
    //   351	374	336	finally
    //   252	258	350	java/io/IOException
    //   296	305	350	java/io/IOException
    //   311	319	350	java/io/IOException
    //   339	347	350	java/io/IOException
    //   387	406	413	finally
    //   406	409	413	finally
    //   414	417	413	finally
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (!this.typeUrl_.isEmpty()) {
      i = 0 + CodedOutputStream.computeStringSize(1, getTypeUrl());
    }
    int j = i;
    if (!this.value_.isEmpty()) {
      j = i + CodedOutputStream.computeBytesSize(2, this.value_);
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getTypeUrl()
  {
    return this.typeUrl_;
  }
  
  public ByteString getTypeUrlBytes()
  {
    return ByteString.copyFromUtf8(this.typeUrl_);
  }
  
  public ByteString getValue()
  {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.typeUrl_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getTypeUrl());
    }
    if (!this.value_.isEmpty()) {
      paramCodedOutputStream.writeBytes(2, this.value_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Any, Builder>
    implements AnyOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearTypeUrl()
    {
      copyOnWrite();
      ((Any)this.instance).clearTypeUrl();
      return this;
    }
    
    public Builder clearValue()
    {
      copyOnWrite();
      ((Any)this.instance).clearValue();
      return this;
    }
    
    public String getTypeUrl()
    {
      return ((Any)this.instance).getTypeUrl();
    }
    
    public ByteString getTypeUrlBytes()
    {
      return ((Any)this.instance).getTypeUrlBytes();
    }
    
    public ByteString getValue()
    {
      return ((Any)this.instance).getValue();
    }
    
    public Builder setTypeUrl(String paramString)
    {
      copyOnWrite();
      ((Any)this.instance).setTypeUrl(paramString);
      return this;
    }
    
    public Builder setTypeUrlBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Any)this.instance).setTypeUrlBytes(paramByteString);
      return this;
    }
    
    public Builder setValue(ByteString paramByteString)
    {
      copyOnWrite();
      ((Any)this.instance).setValue(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Any.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */