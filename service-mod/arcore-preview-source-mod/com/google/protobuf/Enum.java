package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Enum
  extends GeneratedMessageLite<Enum, Builder>
  implements EnumOrBuilder
{
  private static final Enum DEFAULT_INSTANCE = new Enum();
  public static final int ENUMVALUE_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private static volatile Parser<Enum> PARSER;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
  public static final int SYNTAX_FIELD_NUMBER = 5;
  private int bitField0_;
  private Internal.ProtobufList<EnumValue> enumvalue_ = emptyProtobufList();
  private String name_ = "";
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  private SourceContext sourceContext_;
  private int syntax_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllEnumvalue(Iterable<? extends EnumValue> paramIterable)
  {
    ensureEnumvalueIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.enumvalue_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable)
  {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addEnumvalue(int paramInt, EnumValue.Builder paramBuilder)
  {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramInt, paramBuilder.build());
  }
  
  private void addEnumvalue(int paramInt, EnumValue paramEnumValue)
  {
    if (paramEnumValue == null) {
      throw new NullPointerException();
    }
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramInt, paramEnumValue);
  }
  
  private void addEnumvalue(EnumValue.Builder paramBuilder)
  {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramBuilder.build());
  }
  
  private void addEnumvalue(EnumValue paramEnumValue)
  {
    if (paramEnumValue == null) {
      throw new NullPointerException();
    }
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramEnumValue);
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
  
  private void clearEnumvalue()
  {
    this.enumvalue_ = emptyProtobufList();
  }
  
  private void clearName()
  {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions()
  {
    this.options_ = emptyProtobufList();
  }
  
  private void clearSourceContext()
  {
    this.sourceContext_ = null;
  }
  
  private void clearSyntax()
  {
    this.syntax_ = 0;
  }
  
  private void ensureEnumvalueIsMutable()
  {
    if (!this.enumvalue_.isModifiable()) {
      this.enumvalue_ = GeneratedMessageLite.mutableCopy(this.enumvalue_);
    }
  }
  
  private void ensureOptionsIsMutable()
  {
    if (!this.options_.isModifiable()) {
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
    }
  }
  
  public static Enum getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeSourceContext(SourceContext paramSourceContext)
  {
    if ((this.sourceContext_ != null) && (this.sourceContext_ != SourceContext.getDefaultInstance()))
    {
      this.sourceContext_ = ((SourceContext)((SourceContext.Builder)SourceContext.newBuilder(this.sourceContext_).mergeFrom(paramSourceContext)).buildPartial());
      return;
    }
    this.sourceContext_ = paramSourceContext;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Enum paramEnum)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramEnum);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Enum parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Enum)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Enum> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeEnumvalue(int paramInt)
  {
    ensureEnumvalueIsMutable();
    this.enumvalue_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt)
  {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setEnumvalue(int paramInt, EnumValue.Builder paramBuilder)
  {
    ensureEnumvalueIsMutable();
    this.enumvalue_.set(paramInt, paramBuilder.build());
  }
  
  private void setEnumvalue(int paramInt, EnumValue paramEnumValue)
  {
    if (paramEnumValue == null) {
      throw new NullPointerException();
    }
    ensureEnumvalueIsMutable();
    this.enumvalue_.set(paramInt, paramEnumValue);
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
  
  private void setSourceContext(SourceContext.Builder paramBuilder)
  {
    this.sourceContext_ = ((SourceContext)paramBuilder.build());
  }
  
  private void setSourceContext(SourceContext paramSourceContext)
  {
    if (paramSourceContext == null) {
      throw new NullPointerException();
    }
    this.sourceContext_ = paramSourceContext;
  }
  
  private void setSyntax(Syntax paramSyntax)
  {
    if (paramSyntax == null) {
      throw new NullPointerException();
    }
    this.syntax_ = paramSyntax.getNumber();
  }
  
  private void setSyntaxValue(int paramInt)
  {
    this.syntax_ = paramInt;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 357	com/google/protobuf/Enum$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 362	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+90->98, 5:+99->107, 6:+310->318, 7:+624->632, 8:+628->636
    //   56: new 364	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 365	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Enum
    //   67: dup
    //   68: invokespecial 44	com/google/protobuf/Enum:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 46	com/google/protobuf/Enum:DEFAULT_INSTANCE	Lcom/google/protobuf/Enum;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 366 1 0
    //   87: aload_0
    //   88: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   91: invokeinterface 366 1 0
    //   96: aconst_null
    //   97: areturn
    //   98: new 11	com/google/protobuf/Enum$Builder
    //   101: dup
    //   102: aconst_null
    //   103: invokespecial 369	com/google/protobuf/Enum$Builder:<init>	(Lcom/google/protobuf/Enum$1;)V
    //   106: areturn
    //   107: aload_2
    //   108: checkcast 371	com/google/protobuf/GeneratedMessageLite$Visitor
    //   111: astore_2
    //   112: aload_3
    //   113: checkcast 2	com/google/protobuf/Enum
    //   116: astore_3
    //   117: aload_0
    //   118: getfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   121: invokevirtual 376	java/lang/String:isEmpty	()Z
    //   124: ifne +170 -> 294
    //   127: iconst_1
    //   128: istore 6
    //   130: aload_0
    //   131: getfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   134: astore_1
    //   135: aload_3
    //   136: getfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   139: invokevirtual 376	java/lang/String:isEmpty	()Z
    //   142: ifne +158 -> 300
    //   145: iconst_1
    //   146: istore 7
    //   148: aload_0
    //   149: aload_2
    //   150: iload 6
    //   152: aload_1
    //   153: iload 7
    //   155: aload_3
    //   156: getfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   159: invokeinterface 380 5 0
    //   164: putfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   167: aload_0
    //   168: aload_2
    //   169: aload_0
    //   170: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   173: aload_3
    //   174: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   177: invokeinterface 384 3 0
    //   182: putfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   185: aload_0
    //   186: aload_2
    //   187: aload_0
    //   188: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_3
    //   192: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   195: invokeinterface 384 3 0
    //   200: putfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: getfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   209: aload_3
    //   210: getfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   213: invokeinterface 388 3 0
    //   218: checkcast 256	com/google/protobuf/SourceContext
    //   221: putfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   224: aload_0
    //   225: getfield 246	com/google/protobuf/Enum:syntax_	I
    //   228: ifeq +78 -> 306
    //   231: iconst_1
    //   232: istore 6
    //   234: aload_0
    //   235: getfield 246	com/google/protobuf/Enum:syntax_	I
    //   238: istore 4
    //   240: aload_3
    //   241: getfield 246	com/google/protobuf/Enum:syntax_	I
    //   244: ifeq +68 -> 312
    //   247: iconst_1
    //   248: istore 7
    //   250: aload_0
    //   251: aload_2
    //   252: iload 6
    //   254: iload 4
    //   256: iload 7
    //   258: aload_3
    //   259: getfield 246	com/google/protobuf/Enum:syntax_	I
    //   262: invokeinterface 392 5 0
    //   267: putfield 246	com/google/protobuf/Enum:syntax_	I
    //   270: aload_0
    //   271: astore_1
    //   272: aload_2
    //   273: getstatic 398	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   276: if_acmpne -204 -> 72
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 400	com/google/protobuf/Enum:bitField0_	I
    //   284: aload_3
    //   285: getfield 400	com/google/protobuf/Enum:bitField0_	I
    //   288: ior
    //   289: putfield 400	com/google/protobuf/Enum:bitField0_	I
    //   292: aload_0
    //   293: areturn
    //   294: iconst_0
    //   295: istore 6
    //   297: goto -167 -> 130
    //   300: iconst_0
    //   301: istore 7
    //   303: goto -155 -> 148
    //   306: iconst_0
    //   307: istore 6
    //   309: goto -75 -> 234
    //   312: iconst_0
    //   313: istore 7
    //   315: goto -65 -> 250
    //   318: aload_2
    //   319: checkcast 402	com/google/protobuf/CodedInputStream
    //   322: astore_2
    //   323: aload_3
    //   324: checkcast 404	com/google/protobuf/ExtensionRegistryLite
    //   327: astore_3
    //   328: iconst_0
    //   329: istore 4
    //   331: iload 4
    //   333: ifne +299 -> 632
    //   336: aload_2
    //   337: invokevirtual 407	com/google/protobuf/CodedInputStream:readTag	()I
    //   340: istore 5
    //   342: iload 5
    //   344: lookupswitch	default:+333->677, 0:+336->680, 10:+75->419, 18:+103->447, 26:+171->515, 34:+215->559, 40:+277->621
    //   404: aload_2
    //   405: iload 5
    //   407: invokevirtual 411	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   410: ifne -79 -> 331
    //   413: iconst_1
    //   414: istore 4
    //   416: goto -85 -> 331
    //   419: aload_0
    //   420: aload_2
    //   421: invokevirtual 414	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   424: putfield 55	com/google/protobuf/Enum:name_	Ljava/lang/String;
    //   427: goto -96 -> 331
    //   430: astore_1
    //   431: new 416	java/lang/RuntimeException
    //   434: dup
    //   435: aload_1
    //   436: aload_0
    //   437: invokevirtual 420	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   440: invokespecial 423	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   443: athrow
    //   444: astore_1
    //   445: aload_1
    //   446: athrow
    //   447: aload_0
    //   448: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   451: invokeinterface 250 1 0
    //   456: ifne +14 -> 470
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   464: invokestatic 254	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   467: putfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   470: aload_0
    //   471: getfield 61	com/google/protobuf/Enum:enumvalue_	Lcom/google/protobuf/Internal$ProtobufList;
    //   474: aload_2
    //   475: invokestatic 427	com/google/protobuf/EnumValue:parser	()Lcom/google/protobuf/Parser;
    //   478: aload_3
    //   479: invokevirtual 431	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   482: invokeinterface 232 2 0
    //   487: pop
    //   488: goto -157 -> 331
    //   491: astore_1
    //   492: new 416	java/lang/RuntimeException
    //   495: dup
    //   496: new 295	com/google/protobuf/InvalidProtocolBufferException
    //   499: dup
    //   500: aload_1
    //   501: invokevirtual 434	java/io/IOException:getMessage	()Ljava/lang/String;
    //   504: invokespecial 436	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   507: aload_0
    //   508: invokevirtual 420	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   511: invokespecial 423	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   514: athrow
    //   515: aload_0
    //   516: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   519: invokeinterface 250 1 0
    //   524: ifne +14 -> 538
    //   527: aload_0
    //   528: aload_0
    //   529: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   532: invokestatic 254	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   535: putfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   538: aload_0
    //   539: getfield 63	com/google/protobuf/Enum:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   542: aload_2
    //   543: invokestatic 439	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   546: aload_3
    //   547: invokevirtual 431	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   550: invokeinterface 232 2 0
    //   555: pop
    //   556: goto -225 -> 331
    //   559: aconst_null
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   565: ifnull +14 -> 579
    //   568: aload_0
    //   569: getfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   572: invokevirtual 440	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   575: checkcast 265	com/google/protobuf/SourceContext$Builder
    //   578: astore_1
    //   579: aload_0
    //   580: aload_2
    //   581: invokestatic 441	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   584: aload_3
    //   585: invokevirtual 431	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   588: checkcast 256	com/google/protobuf/SourceContext
    //   591: putfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   594: aload_1
    //   595: ifnull -264 -> 331
    //   598: aload_1
    //   599: aload_0
    //   600: getfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   603: invokevirtual 269	com/google/protobuf/SourceContext$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   606: pop
    //   607: aload_0
    //   608: aload_1
    //   609: invokevirtual 272	com/google/protobuf/SourceContext$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   612: checkcast 256	com/google/protobuf/SourceContext
    //   615: putfield 244	com/google/protobuf/Enum:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   618: goto -287 -> 331
    //   621: aload_0
    //   622: aload_2
    //   623: invokevirtual 444	com/google/protobuf/CodedInputStream:readEnum	()I
    //   626: putfield 246	com/google/protobuf/Enum:syntax_	I
    //   629: goto -298 -> 331
    //   632: getstatic 46	com/google/protobuf/Enum:DEFAULT_INSTANCE	Lcom/google/protobuf/Enum;
    //   635: areturn
    //   636: getstatic 446	com/google/protobuf/Enum:PARSER	Lcom/google/protobuf/Parser;
    //   639: ifnonnull +28 -> 667
    //   642: ldc 2
    //   644: monitorenter
    //   645: getstatic 446	com/google/protobuf/Enum:PARSER	Lcom/google/protobuf/Parser;
    //   648: ifnonnull +16 -> 664
    //   651: new 448	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   654: dup
    //   655: getstatic 46	com/google/protobuf/Enum:DEFAULT_INSTANCE	Lcom/google/protobuf/Enum;
    //   658: invokespecial 451	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   661: putstatic 446	com/google/protobuf/Enum:PARSER	Lcom/google/protobuf/Parser;
    //   664: ldc 2
    //   666: monitorexit
    //   667: getstatic 446	com/google/protobuf/Enum:PARSER	Lcom/google/protobuf/Parser;
    //   670: areturn
    //   671: astore_1
    //   672: ldc 2
    //   674: monitorexit
    //   675: aload_1
    //   676: athrow
    //   677: goto -273 -> 404
    //   680: iconst_1
    //   681: istore 4
    //   683: goto -352 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	Enum
    //   0	686	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	686	2	paramObject1	Object
    //   0	686	3	paramObject2	Object
    //   238	444	4	i	int
    //   340	66	5	j	int
    //   128	180	6	bool1	boolean
    //   146	168	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   336	342	430	com/google/protobuf/InvalidProtocolBufferException
    //   404	413	430	com/google/protobuf/InvalidProtocolBufferException
    //   419	427	430	com/google/protobuf/InvalidProtocolBufferException
    //   447	470	430	com/google/protobuf/InvalidProtocolBufferException
    //   470	488	430	com/google/protobuf/InvalidProtocolBufferException
    //   515	538	430	com/google/protobuf/InvalidProtocolBufferException
    //   538	556	430	com/google/protobuf/InvalidProtocolBufferException
    //   561	579	430	com/google/protobuf/InvalidProtocolBufferException
    //   579	594	430	com/google/protobuf/InvalidProtocolBufferException
    //   598	618	430	com/google/protobuf/InvalidProtocolBufferException
    //   621	629	430	com/google/protobuf/InvalidProtocolBufferException
    //   336	342	444	finally
    //   404	413	444	finally
    //   419	427	444	finally
    //   431	444	444	finally
    //   447	470	444	finally
    //   470	488	444	finally
    //   492	515	444	finally
    //   515	538	444	finally
    //   538	556	444	finally
    //   561	579	444	finally
    //   579	594	444	finally
    //   598	618	444	finally
    //   621	629	444	finally
    //   336	342	491	java/io/IOException
    //   404	413	491	java/io/IOException
    //   419	427	491	java/io/IOException
    //   447	470	491	java/io/IOException
    //   470	488	491	java/io/IOException
    //   515	538	491	java/io/IOException
    //   538	556	491	java/io/IOException
    //   561	579	491	java/io/IOException
    //   579	594	491	java/io/IOException
    //   598	618	491	java/io/IOException
    //   621	629	491	java/io/IOException
    //   645	664	671	finally
    //   664	667	671	finally
    //   672	675	671	finally
  }
  
  public EnumValue getEnumvalue(int paramInt)
  {
    return (EnumValue)this.enumvalue_.get(paramInt);
  }
  
  public int getEnumvalueCount()
  {
    return this.enumvalue_.size();
  }
  
  public List<EnumValue> getEnumvalueList()
  {
    return this.enumvalue_;
  }
  
  public EnumValueOrBuilder getEnumvalueOrBuilder(int paramInt)
  {
    return (EnumValueOrBuilder)this.enumvalue_.get(paramInt);
  }
  
  public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList()
  {
    return this.enumvalue_;
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
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
    i = 0;
    if (!this.name_.isEmpty()) {
      i = 0 + CodedOutputStream.computeStringSize(1, getName());
    }
    int j = 0;
    while (j < this.enumvalue_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.enumvalue_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (this.sourceContext_ != null) {
      j = i + CodedOutputStream.computeMessageSize(4, getSourceContext());
    }
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      i = j + CodedOutputStream.computeEnumSize(5, this.syntax_);
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public SourceContext getSourceContext()
  {
    if (this.sourceContext_ == null) {
      return SourceContext.getDefaultInstance();
    }
    return this.sourceContext_;
  }
  
  public Syntax getSyntax()
  {
    Syntax localSyntax2 = Syntax.forNumber(this.syntax_);
    Syntax localSyntax1 = localSyntax2;
    if (localSyntax2 == null) {
      localSyntax1 = Syntax.UNRECOGNIZED;
    }
    return localSyntax1;
  }
  
  public int getSyntaxValue()
  {
    return this.syntax_;
  }
  
  public boolean hasSourceContext()
  {
    return this.sourceContext_ != null;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.name_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getName());
    }
    int i = 0;
    while (i < this.enumvalue_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.enumvalue_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.writeMessage(4, getSourceContext());
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.writeEnum(5, this.syntax_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Enum, Builder>
    implements EnumOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllEnumvalue(Iterable<? extends EnumValue> paramIterable)
    {
      copyOnWrite();
      ((Enum)this.instance).addAllEnumvalue(paramIterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> paramIterable)
    {
      copyOnWrite();
      ((Enum)this.instance).addAllOptions(paramIterable);
      return this;
    }
    
    public Builder addEnumvalue(int paramInt, EnumValue.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).addEnumvalue(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addEnumvalue(int paramInt, EnumValue paramEnumValue)
    {
      copyOnWrite();
      ((Enum)this.instance).addEnumvalue(paramInt, paramEnumValue);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).addEnumvalue(paramBuilder);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue paramEnumValue)
    {
      copyOnWrite();
      ((Enum)this.instance).addEnumvalue(paramEnumValue);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).addOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Enum)this.instance).addOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder addOptions(Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).addOptions(paramBuilder);
      return this;
    }
    
    public Builder addOptions(Option paramOption)
    {
      copyOnWrite();
      ((Enum)this.instance).addOptions(paramOption);
      return this;
    }
    
    public Builder clearEnumvalue()
    {
      copyOnWrite();
      ((Enum)this.instance).clearEnumvalue();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Enum)this.instance).clearName();
      return this;
    }
    
    public Builder clearOptions()
    {
      copyOnWrite();
      ((Enum)this.instance).clearOptions();
      return this;
    }
    
    public Builder clearSourceContext()
    {
      copyOnWrite();
      ((Enum)this.instance).clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax()
    {
      copyOnWrite();
      ((Enum)this.instance).clearSyntax();
      return this;
    }
    
    public EnumValue getEnumvalue(int paramInt)
    {
      return ((Enum)this.instance).getEnumvalue(paramInt);
    }
    
    public int getEnumvalueCount()
    {
      return ((Enum)this.instance).getEnumvalueCount();
    }
    
    public List<EnumValue> getEnumvalueList()
    {
      return Collections.unmodifiableList(((Enum)this.instance).getEnumvalueList());
    }
    
    public String getName()
    {
      return ((Enum)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Enum)this.instance).getNameBytes();
    }
    
    public Option getOptions(int paramInt)
    {
      return ((Enum)this.instance).getOptions(paramInt);
    }
    
    public int getOptionsCount()
    {
      return ((Enum)this.instance).getOptionsCount();
    }
    
    public List<Option> getOptionsList()
    {
      return Collections.unmodifiableList(((Enum)this.instance).getOptionsList());
    }
    
    public SourceContext getSourceContext()
    {
      return ((Enum)this.instance).getSourceContext();
    }
    
    public Syntax getSyntax()
    {
      return ((Enum)this.instance).getSyntax();
    }
    
    public int getSyntaxValue()
    {
      return ((Enum)this.instance).getSyntaxValue();
    }
    
    public boolean hasSourceContext()
    {
      return ((Enum)this.instance).hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Enum)this.instance).mergeSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder removeEnumvalue(int paramInt)
    {
      copyOnWrite();
      ((Enum)this.instance).removeEnumvalue(paramInt);
      return this;
    }
    
    public Builder removeOptions(int paramInt)
    {
      copyOnWrite();
      ((Enum)this.instance).removeOptions(paramInt);
      return this;
    }
    
    public Builder setEnumvalue(int paramInt, EnumValue.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).setEnumvalue(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setEnumvalue(int paramInt, EnumValue paramEnumValue)
    {
      copyOnWrite();
      ((Enum)this.instance).setEnumvalue(paramInt, paramEnumValue);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Enum)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Enum)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).setOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Enum)this.instance).setOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder setSourceContext(SourceContext.Builder paramBuilder)
    {
      copyOnWrite();
      ((Enum)this.instance).setSourceContext(paramBuilder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Enum)this.instance).setSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder setSyntax(Syntax paramSyntax)
    {
      copyOnWrite();
      ((Enum)this.instance).setSyntax(paramSyntax);
      return this;
    }
    
    public Builder setSyntaxValue(int paramInt)
    {
      copyOnWrite();
      ((Enum)this.instance).setSyntaxValue(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Enum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */