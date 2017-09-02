package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class EnumValue
  extends GeneratedMessageLite<EnumValue, Builder>
  implements EnumValueOrBuilder
{
  private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int NUMBER_FIELD_NUMBER = 2;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private static volatile Parser<EnumValue> PARSER;
  private int bitField0_;
  private String name_ = "";
  private int number_;
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable)
  {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder)
  {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption)
  {
    if (paramOption == null) {
      throw new NullPointerException();
    }
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramOption);
  }
  
  private void addOptions(Option.Builder paramBuilder)
  {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption)
  {
    if (paramOption == null) {
      throw new NullPointerException();
    }
    ensureOptionsIsMutable();
    this.options_.add(paramOption);
  }
  
  private void clearName()
  {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearNumber()
  {
    this.number_ = 0;
  }
  
  private void clearOptions()
  {
    this.options_ = emptyProtobufList();
  }
  
  private void ensureOptionsIsMutable()
  {
    if (!this.options_.isModifiable()) {
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
    }
  }
  
  public static EnumValue getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(EnumValue paramEnumValue)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramEnumValue);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (EnumValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValue> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt)
  {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
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
  
  private void setNumber(int paramInt)
  {
    this.number_ = paramInt;
  }
  
  private void setOptions(int paramInt, Option.Builder paramBuilder)
  {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption)
  {
    if (paramOption == null) {
      throw new NullPointerException();
    }
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramOption);
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 252	com/google/protobuf/EnumValue$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 258	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+262->270, 7:+454->462, 8:+458->466
    //   56: new 260	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 261	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/EnumValue
    //   67: dup
    //   68: invokespecial 36	com/google/protobuf/EnumValue:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 38	com/google/protobuf/EnumValue:DEFAULT_INSTANCE	Lcom/google/protobuf/EnumValue;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 262 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/protobuf/EnumValue$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 265	com/google/protobuf/EnumValue$Builder:<init>	(Lcom/google/protobuf/EnumValue$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 267	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/protobuf/EnumValue
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   112: invokevirtual 272	java/lang/String:isEmpty	()Z
    //   115: ifne +131 -> 246
    //   118: iconst_1
    //   119: istore 6
    //   121: aload_0
    //   122: getfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   125: astore_1
    //   126: aload_3
    //   127: getfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   130: invokevirtual 272	java/lang/String:isEmpty	()Z
    //   133: ifne +119 -> 252
    //   136: iconst_1
    //   137: istore 7
    //   139: aload_0
    //   140: aload_2
    //   141: iload 6
    //   143: aload_1
    //   144: iload 7
    //   146: aload_3
    //   147: getfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   150: invokeinterface 276 5 0
    //   155: putfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 162	com/google/protobuf/EnumValue:number_	I
    //   162: ifeq +96 -> 258
    //   165: iconst_1
    //   166: istore 6
    //   168: aload_0
    //   169: getfield 162	com/google/protobuf/EnumValue:number_	I
    //   172: istore 4
    //   174: aload_3
    //   175: getfield 162	com/google/protobuf/EnumValue:number_	I
    //   178: ifeq +86 -> 264
    //   181: iconst_1
    //   182: istore 7
    //   184: aload_0
    //   185: aload_2
    //   186: iload 6
    //   188: iload 4
    //   190: iload 7
    //   192: aload_3
    //   193: getfield 162	com/google/protobuf/EnumValue:number_	I
    //   196: invokeinterface 280 5 0
    //   201: putfield 162	com/google/protobuf/EnumValue:number_	I
    //   204: aload_0
    //   205: aload_2
    //   206: aload_0
    //   207: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   210: aload_3
    //   211: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   214: invokeinterface 284 3 0
    //   219: putfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   222: aload_0
    //   223: astore_1
    //   224: aload_2
    //   225: getstatic 290	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   228: if_acmpne -156 -> 72
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 292	com/google/protobuf/EnumValue:bitField0_	I
    //   236: aload_3
    //   237: getfield 292	com/google/protobuf/EnumValue:bitField0_	I
    //   240: ior
    //   241: putfield 292	com/google/protobuf/EnumValue:bitField0_	I
    //   244: aload_0
    //   245: areturn
    //   246: iconst_0
    //   247: istore 6
    //   249: goto -128 -> 121
    //   252: iconst_0
    //   253: istore 7
    //   255: goto -116 -> 139
    //   258: iconst_0
    //   259: istore 6
    //   261: goto -93 -> 168
    //   264: iconst_0
    //   265: istore 7
    //   267: goto -83 -> 184
    //   270: aload_2
    //   271: checkcast 294	com/google/protobuf/CodedInputStream
    //   274: astore_1
    //   275: aload_3
    //   276: checkcast 296	com/google/protobuf/ExtensionRegistryLite
    //   279: astore_2
    //   280: iconst_0
    //   281: istore 4
    //   283: iload 4
    //   285: ifne +177 -> 462
    //   288: aload_1
    //   289: invokevirtual 299	com/google/protobuf/CodedInputStream:readTag	()I
    //   292: istore 5
    //   294: iload 5
    //   296: lookupswitch	default:+211->507, 0:+214->510, 10:+59->355, 16:+87->383, 26:+122->418
    //   340: aload_1
    //   341: iload 5
    //   343: invokevirtual 303	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   346: ifne -63 -> 283
    //   349: iconst_1
    //   350: istore 4
    //   352: goto -69 -> 283
    //   355: aload_0
    //   356: aload_1
    //   357: invokevirtual 306	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   360: putfield 47	com/google/protobuf/EnumValue:name_	Ljava/lang/String;
    //   363: goto -80 -> 283
    //   366: astore_1
    //   367: new 308	java/lang/RuntimeException
    //   370: dup
    //   371: aload_1
    //   372: aload_0
    //   373: invokevirtual 312	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   376: invokespecial 315	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   379: athrow
    //   380: astore_1
    //   381: aload_1
    //   382: athrow
    //   383: aload_0
    //   384: aload_1
    //   385: invokevirtual 318	com/google/protobuf/CodedInputStream:readInt32	()I
    //   388: putfield 162	com/google/protobuf/EnumValue:number_	I
    //   391: goto -108 -> 283
    //   394: astore_1
    //   395: new 308	java/lang/RuntimeException
    //   398: dup
    //   399: new 197	com/google/protobuf/InvalidProtocolBufferException
    //   402: dup
    //   403: aload_1
    //   404: invokevirtual 321	java/io/IOException:getMessage	()Ljava/lang/String;
    //   407: invokespecial 323	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   410: aload_0
    //   411: invokevirtual 312	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   414: invokespecial 315	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   417: athrow
    //   418: aload_0
    //   419: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   422: invokeinterface 166 1 0
    //   427: ifne +14 -> 441
    //   430: aload_0
    //   431: aload_0
    //   432: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   435: invokestatic 170	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   438: putfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   441: aload_0
    //   442: getfield 53	com/google/protobuf/EnumValue:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   445: aload_1
    //   446: invokestatic 327	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   449: aload_2
    //   450: invokevirtual 331	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   453: invokeinterface 153 2 0
    //   458: pop
    //   459: goto -176 -> 283
    //   462: getstatic 38	com/google/protobuf/EnumValue:DEFAULT_INSTANCE	Lcom/google/protobuf/EnumValue;
    //   465: areturn
    //   466: getstatic 333	com/google/protobuf/EnumValue:PARSER	Lcom/google/protobuf/Parser;
    //   469: ifnonnull +28 -> 497
    //   472: ldc 2
    //   474: monitorenter
    //   475: getstatic 333	com/google/protobuf/EnumValue:PARSER	Lcom/google/protobuf/Parser;
    //   478: ifnonnull +16 -> 494
    //   481: new 335	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   484: dup
    //   485: getstatic 38	com/google/protobuf/EnumValue:DEFAULT_INSTANCE	Lcom/google/protobuf/EnumValue;
    //   488: invokespecial 338	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   491: putstatic 333	com/google/protobuf/EnumValue:PARSER	Lcom/google/protobuf/Parser;
    //   494: ldc 2
    //   496: monitorexit
    //   497: getstatic 333	com/google/protobuf/EnumValue:PARSER	Lcom/google/protobuf/Parser;
    //   500: areturn
    //   501: astore_1
    //   502: ldc 2
    //   504: monitorexit
    //   505: aload_1
    //   506: athrow
    //   507: goto -167 -> 340
    //   510: iconst_1
    //   511: istore 4
    //   513: goto -230 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	EnumValue
    //   0	516	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	516	2	paramObject1	Object
    //   0	516	3	paramObject2	Object
    //   172	340	4	i	int
    //   292	50	5	j	int
    //   119	141	6	bool1	boolean
    //   137	129	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   288	294	366	com/google/protobuf/InvalidProtocolBufferException
    //   340	349	366	com/google/protobuf/InvalidProtocolBufferException
    //   355	363	366	com/google/protobuf/InvalidProtocolBufferException
    //   383	391	366	com/google/protobuf/InvalidProtocolBufferException
    //   418	441	366	com/google/protobuf/InvalidProtocolBufferException
    //   441	459	366	com/google/protobuf/InvalidProtocolBufferException
    //   288	294	380	finally
    //   340	349	380	finally
    //   355	363	380	finally
    //   367	380	380	finally
    //   383	391	380	finally
    //   395	418	380	finally
    //   418	441	380	finally
    //   441	459	380	finally
    //   288	294	394	java/io/IOException
    //   340	349	394	java/io/IOException
    //   355	363	394	java/io/IOException
    //   383	391	394	java/io/IOException
    //   418	441	394	java/io/IOException
    //   441	459	394	java/io/IOException
    //   475	494	501	finally
    //   494	497	501	finally
    //   502	505	501	finally
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getNumber()
  {
    return this.number_;
  }
  
  public Option getOptions(int paramInt)
  {
    return (Option)this.options_.get(paramInt);
  }
  
  public int getOptionsCount()
  {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList()
  {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt)
  {
    return (OptionOrBuilder)this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList()
  {
    return this.options_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if (!this.name_.isEmpty()) {
      j = 0 + CodedOutputStream.computeStringSize(1, getName());
    }
    i = j;
    if (this.number_ != 0) {
      i = j + CodedOutputStream.computeInt32Size(2, this.number_);
    }
    int k = 0;
    j = i;
    i = k;
    while (i < this.options_.size())
    {
      j += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.name_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getName());
    }
    if (this.number_ != 0) {
      paramCodedOutputStream.writeInt32(2, this.number_);
    }
    int i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<EnumValue, Builder>
    implements EnumValueOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllOptions(Iterable<? extends Option> paramIterable)
    {
      copyOnWrite();
      ((EnumValue)this.instance).addAllOptions(paramIterable);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((EnumValue)this.instance).addOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((EnumValue)this.instance).addOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder addOptions(Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((EnumValue)this.instance).addOptions(paramBuilder);
      return this;
    }
    
    public Builder addOptions(Option paramOption)
    {
      copyOnWrite();
      ((EnumValue)this.instance).addOptions(paramOption);
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((EnumValue)this.instance).clearName();
      return this;
    }
    
    public Builder clearNumber()
    {
      copyOnWrite();
      ((EnumValue)this.instance).clearNumber();
      return this;
    }
    
    public Builder clearOptions()
    {
      copyOnWrite();
      ((EnumValue)this.instance).clearOptions();
      return this;
    }
    
    public String getName()
    {
      return ((EnumValue)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((EnumValue)this.instance).getNameBytes();
    }
    
    public int getNumber()
    {
      return ((EnumValue)this.instance).getNumber();
    }
    
    public Option getOptions(int paramInt)
    {
      return ((EnumValue)this.instance).getOptions(paramInt);
    }
    
    public int getOptionsCount()
    {
      return ((EnumValue)this.instance).getOptionsCount();
    }
    
    public List<Option> getOptionsList()
    {
      return Collections.unmodifiableList(((EnumValue)this.instance).getOptionsList());
    }
    
    public Builder removeOptions(int paramInt)
    {
      copyOnWrite();
      ((EnumValue)this.instance).removeOptions(paramInt);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((EnumValue)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((EnumValue)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      copyOnWrite();
      ((EnumValue)this.instance).setNumber(paramInt);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((EnumValue)this.instance).setOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((EnumValue)this.instance).setOptions(paramInt, paramOption);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/EnumValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */