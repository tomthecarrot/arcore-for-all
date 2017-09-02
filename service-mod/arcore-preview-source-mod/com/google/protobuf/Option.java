package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Option
  extends GeneratedMessageLite<Option, Builder>
  implements OptionOrBuilder
{
  private static final Option DEFAULT_INSTANCE = new Option();
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<Option> PARSER;
  public static final int VALUE_FIELD_NUMBER = 2;
  private String name_ = "";
  private Any value_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName()
  {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearValue()
  {
    this.value_ = null;
  }
  
  public static Option getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeValue(Any paramAny)
  {
    if ((this.value_ != null) && (this.value_ != Any.getDefaultInstance()))
    {
      this.value_ = ((Any)((Any.Builder)Any.newBuilder(this.value_).mergeFrom(paramAny)).buildPartial());
      return;
    }
    this.value_ = paramAny;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Option paramOption)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramOption);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Option)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Option)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Option parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Option parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Option parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Option)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Option> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setName(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.name_ = paramString;
  }
  
  private void setNameBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.name_ = paramByteString.toStringUtf8();
  }
  
  private void setValue(Any.Builder paramBuilder)
  {
    this.value_ = ((Any)paramBuilder.build());
  }
  
  private void setValue(Any paramAny)
  {
    if (paramAny == null) {
      throw new NullPointerException();
    }
    this.value_ = paramAny;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 185	com/google/protobuf/Option$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 191	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+185->193, 7:+373->381, 8:+377->385
    //   56: new 193	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 194	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Option
    //   67: dup
    //   68: invokespecial 31	com/google/protobuf/Option:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 33	com/google/protobuf/Option:DEFAULT_INSTANCE	Lcom/google/protobuf/Option;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/Option$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 197	com/google/protobuf/Option$Builder:<init>	(Lcom/google/protobuf/Option$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 199	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/Option
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   103: invokevirtual 205	java/lang/String:isEmpty	()Z
    //   106: ifne +75 -> 181
    //   109: iconst_1
    //   110: istore 6
    //   112: aload_0
    //   113: getfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   116: astore_3
    //   117: aload_1
    //   118: getfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   121: invokevirtual 205	java/lang/String:isEmpty	()Z
    //   124: ifne +63 -> 187
    //   127: iconst_1
    //   128: istore 7
    //   130: aload_0
    //   131: aload_2
    //   132: iload 6
    //   134: aload_3
    //   135: iload 7
    //   137: aload_1
    //   138: getfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   141: invokeinterface 209 5 0
    //   146: putfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   149: aload_0
    //   150: aload_2
    //   151: aload_0
    //   152: getfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   155: aload_1
    //   156: getfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   159: invokeinterface 213 3 0
    //   164: checkcast 91	com/google/protobuf/Any
    //   167: putfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   170: aload_0
    //   171: astore_1
    //   172: aload_2
    //   173: getstatic 219	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   176: if_acmpne -104 -> 72
    //   179: aload_0
    //   180: areturn
    //   181: iconst_0
    //   182: istore 6
    //   184: goto -72 -> 112
    //   187: iconst_0
    //   188: istore 7
    //   190: goto -60 -> 130
    //   193: aload_2
    //   194: checkcast 221	com/google/protobuf/CodedInputStream
    //   197: astore_2
    //   198: aload_3
    //   199: checkcast 223	com/google/protobuf/ExtensionRegistryLite
    //   202: astore_3
    //   203: iconst_0
    //   204: istore 4
    //   206: iload 4
    //   208: ifne +173 -> 381
    //   211: aload_2
    //   212: invokevirtual 226	com/google/protobuf/CodedInputStream:readTag	()I
    //   215: istore 5
    //   217: iload 5
    //   219: lookupswitch	default:+207->426, 0:+210->429, 10:+48->267, 18:+76->295
    //   252: aload_2
    //   253: iload 5
    //   255: invokevirtual 230	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   258: ifne -52 -> 206
    //   261: iconst_1
    //   262: istore 4
    //   264: goto -58 -> 206
    //   267: aload_0
    //   268: aload_2
    //   269: invokevirtual 233	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   272: putfield 42	com/google/protobuf/Option:name_	Ljava/lang/String;
    //   275: goto -69 -> 206
    //   278: astore_1
    //   279: new 235	java/lang/RuntimeException
    //   282: dup
    //   283: aload_1
    //   284: aload_0
    //   285: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   288: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   291: athrow
    //   292: astore_1
    //   293: aload_1
    //   294: athrow
    //   295: aconst_null
    //   296: astore_1
    //   297: aload_0
    //   298: getfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: getfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   308: invokevirtual 243	com/google/protobuf/Any:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   311: checkcast 100	com/google/protobuf/Any$Builder
    //   314: astore_1
    //   315: aload_0
    //   316: aload_2
    //   317: invokestatic 245	com/google/protobuf/Any:parser	()Lcom/google/protobuf/Parser;
    //   320: aload_3
    //   321: invokevirtual 249	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   324: checkcast 91	com/google/protobuf/Any
    //   327: putfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   330: aload_1
    //   331: ifnull -125 -> 206
    //   334: aload_1
    //   335: aload_0
    //   336: getfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   339: invokevirtual 104	com/google/protobuf/Any$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   342: pop
    //   343: aload_0
    //   344: aload_1
    //   345: invokevirtual 108	com/google/protobuf/Any$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   348: checkcast 91	com/google/protobuf/Any
    //   351: putfield 89	com/google/protobuf/Option:value_	Lcom/google/protobuf/Any;
    //   354: goto -148 -> 206
    //   357: astore_1
    //   358: new 235	java/lang/RuntimeException
    //   361: dup
    //   362: new 131	com/google/protobuf/InvalidProtocolBufferException
    //   365: dup
    //   366: aload_1
    //   367: invokevirtual 252	java/io/IOException:getMessage	()Ljava/lang/String;
    //   370: invokespecial 254	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   373: aload_0
    //   374: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   377: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   380: athrow
    //   381: getstatic 33	com/google/protobuf/Option:DEFAULT_INSTANCE	Lcom/google/protobuf/Option;
    //   384: areturn
    //   385: getstatic 256	com/google/protobuf/Option:PARSER	Lcom/google/protobuf/Parser;
    //   388: ifnonnull +28 -> 416
    //   391: ldc 2
    //   393: monitorenter
    //   394: getstatic 256	com/google/protobuf/Option:PARSER	Lcom/google/protobuf/Parser;
    //   397: ifnonnull +16 -> 413
    //   400: new 258	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   403: dup
    //   404: getstatic 33	com/google/protobuf/Option:DEFAULT_INSTANCE	Lcom/google/protobuf/Option;
    //   407: invokespecial 261	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   410: putstatic 256	com/google/protobuf/Option:PARSER	Lcom/google/protobuf/Parser;
    //   413: ldc 2
    //   415: monitorexit
    //   416: getstatic 256	com/google/protobuf/Option:PARSER	Lcom/google/protobuf/Parser;
    //   419: areturn
    //   420: astore_1
    //   421: ldc 2
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: goto -174 -> 252
    //   429: iconst_1
    //   430: istore 4
    //   432: goto -226 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	Option
    //   0	435	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	435	2	paramObject1	Object
    //   0	435	3	paramObject2	Object
    //   204	227	4	i	int
    //   215	39	5	j	int
    //   110	73	6	bool1	boolean
    //   128	61	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   211	217	278	com/google/protobuf/InvalidProtocolBufferException
    //   252	261	278	com/google/protobuf/InvalidProtocolBufferException
    //   267	275	278	com/google/protobuf/InvalidProtocolBufferException
    //   297	315	278	com/google/protobuf/InvalidProtocolBufferException
    //   315	330	278	com/google/protobuf/InvalidProtocolBufferException
    //   334	354	278	com/google/protobuf/InvalidProtocolBufferException
    //   211	217	292	finally
    //   252	261	292	finally
    //   267	275	292	finally
    //   279	292	292	finally
    //   297	315	292	finally
    //   315	330	292	finally
    //   334	354	292	finally
    //   358	381	292	finally
    //   211	217	357	java/io/IOException
    //   252	261	357	java/io/IOException
    //   267	275	357	java/io/IOException
    //   297	315	357	java/io/IOException
    //   315	330	357	java/io/IOException
    //   334	354	357	java/io/IOException
    //   394	413	420	finally
    //   413	416	420	finally
    //   421	424	420	finally
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (!this.name_.isEmpty()) {
      i = 0 + CodedOutputStream.computeStringSize(1, getName());
    }
    int j = i;
    if (this.value_ != null) {
      j = i + CodedOutputStream.computeMessageSize(2, getValue());
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Any getValue()
  {
    if (this.value_ == null) {
      return Any.getDefaultInstance();
    }
    return this.value_;
  }
  
  public boolean hasValue()
  {
    return this.value_ != null;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.name_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getName());
    }
    if (this.value_ != null) {
      paramCodedOutputStream.writeMessage(2, getValue());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Option, Builder>
    implements OptionOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Option)this.instance).clearName();
      return this;
    }
    
    public Builder clearValue()
    {
      copyOnWrite();
      ((Option)this.instance).clearValue();
      return this;
    }
    
    public String getName()
    {
      return ((Option)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Option)this.instance).getNameBytes();
    }
    
    public Any getValue()
    {
      return ((Option)this.instance).getValue();
    }
    
    public boolean hasValue()
    {
      return ((Option)this.instance).hasValue();
    }
    
    public Builder mergeValue(Any paramAny)
    {
      copyOnWrite();
      ((Option)this.instance).mergeValue(paramAny);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Option)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Option)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setValue(Any.Builder paramBuilder)
    {
      copyOnWrite();
      ((Option)this.instance).setValue(paramBuilder);
      return this;
    }
    
    public Builder setValue(Any paramAny)
    {
      copyOnWrite();
      ((Option)this.instance).setValue(paramAny);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Option.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */