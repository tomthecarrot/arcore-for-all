package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Method
  extends GeneratedMessageLite<Method, Builder>
  implements MethodOrBuilder
{
  private static final Method DEFAULT_INSTANCE = new Method();
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 6;
  private static volatile Parser<Method> PARSER;
  public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
  public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
  public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
  public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
  public static final int SYNTAX_FIELD_NUMBER = 7;
  private int bitField0_;
  private String name_ = "";
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  private boolean requestStreaming_;
  private String requestTypeUrl_ = "";
  private boolean responseStreaming_;
  private String responseTypeUrl_ = "";
  private int syntax_;
  
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
  
  private void clearOptions()
  {
    this.options_ = emptyProtobufList();
  }
  
  private void clearRequestStreaming()
  {
    this.requestStreaming_ = false;
  }
  
  private void clearRequestTypeUrl()
  {
    this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
  }
  
  private void clearResponseStreaming()
  {
    this.responseStreaming_ = false;
  }
  
  private void clearResponseTypeUrl()
  {
    this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
  }
  
  private void clearSyntax()
  {
    this.syntax_ = 0;
  }
  
  private void ensureOptionsIsMutable()
  {
    if (!this.options_.isModifiable()) {
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
    }
  }
  
  public static Method getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Method paramMethod)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMethod);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Method parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Method parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Method)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Method> parser()
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
  
  private void setRequestStreaming(boolean paramBoolean)
  {
    this.requestStreaming_ = paramBoolean;
  }
  
  private void setRequestTypeUrl(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.requestTypeUrl_ = paramString;
  }
  
  private void setRequestTypeUrlBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.requestTypeUrl_ = paramByteString.toStringUtf8();
  }
  
  private void setResponseStreaming(boolean paramBoolean)
  {
    this.responseStreaming_ = paramBoolean;
  }
  
  private void setResponseTypeUrl(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.responseTypeUrl_ = paramString;
  }
  
  private void setResponseTypeUrlBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.responseTypeUrl_ = paramByteString.toStringUtf8();
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
    //   0: getstatic 333	com/google/protobuf/Method$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 338	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+502->510, 7:+770->778, 8:+774->782
    //   56: new 340	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 341	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Method
    //   67: dup
    //   68: invokespecial 49	com/google/protobuf/Method:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 51	com/google/protobuf/Method:DEFAULT_INSTANCE	Lcom/google/protobuf/Method;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 342 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/protobuf/Method$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 345	com/google/protobuf/Method$Builder:<init>	(Lcom/google/protobuf/Method$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 347	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/protobuf/Method
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   112: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   115: ifne +323 -> 438
    //   118: iconst_1
    //   119: istore 6
    //   121: aload_0
    //   122: getfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   125: astore_1
    //   126: aload_3
    //   127: getfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   130: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   133: ifne +311 -> 444
    //   136: iconst_1
    //   137: istore 7
    //   139: aload_0
    //   140: aload_2
    //   141: iload 6
    //   143: aload_1
    //   144: iload 7
    //   146: aload_3
    //   147: getfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   150: invokeinterface 356 5 0
    //   155: putfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   162: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   165: ifne +285 -> 450
    //   168: iconst_1
    //   169: istore 6
    //   171: aload_0
    //   172: getfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   175: astore_1
    //   176: aload_3
    //   177: getfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   180: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   183: ifne +273 -> 456
    //   186: iconst_1
    //   187: istore 7
    //   189: aload_0
    //   190: aload_2
    //   191: iload 6
    //   193: aload_1
    //   194: iload 7
    //   196: aload_3
    //   197: getfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   200: invokeinterface 356 5 0
    //   205: putfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   212: ifeq +250 -> 462
    //   215: iconst_1
    //   216: istore 6
    //   218: aload_0
    //   219: getfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   222: istore 8
    //   224: aload_3
    //   225: getfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   228: ifeq +240 -> 468
    //   231: iconst_1
    //   232: istore 7
    //   234: aload_0
    //   235: aload_2
    //   236: iload 6
    //   238: iload 8
    //   240: iload 7
    //   242: aload_3
    //   243: getfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   246: invokeinterface 360 5 0
    //   251: putfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   254: aload_0
    //   255: getfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   258: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   261: ifne +213 -> 474
    //   264: iconst_1
    //   265: istore 6
    //   267: aload_0
    //   268: getfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   271: astore_1
    //   272: aload_3
    //   273: getfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   276: invokevirtual 352	java/lang/String:isEmpty	()Z
    //   279: ifne +201 -> 480
    //   282: iconst_1
    //   283: istore 7
    //   285: aload_0
    //   286: aload_2
    //   287: iload 6
    //   289: aload_1
    //   290: iload 7
    //   292: aload_3
    //   293: getfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   296: invokeinterface 356 5 0
    //   301: putfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   304: aload_0
    //   305: getfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   308: ifeq +178 -> 486
    //   311: iconst_1
    //   312: istore 6
    //   314: aload_0
    //   315: getfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   318: istore 8
    //   320: aload_3
    //   321: getfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   324: ifeq +168 -> 492
    //   327: iconst_1
    //   328: istore 7
    //   330: aload_0
    //   331: aload_2
    //   332: iload 6
    //   334: iload 8
    //   336: iload 7
    //   338: aload_3
    //   339: getfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   342: invokeinterface 360 5 0
    //   347: putfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   350: aload_0
    //   351: aload_2
    //   352: aload_0
    //   353: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_3
    //   357: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   360: invokeinterface 364 3 0
    //   365: putfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   368: aload_0
    //   369: getfield 237	com/google/protobuf/Method:syntax_	I
    //   372: ifeq +126 -> 498
    //   375: iconst_1
    //   376: istore 6
    //   378: aload_0
    //   379: getfield 237	com/google/protobuf/Method:syntax_	I
    //   382: istore 4
    //   384: aload_3
    //   385: getfield 237	com/google/protobuf/Method:syntax_	I
    //   388: ifeq +116 -> 504
    //   391: iconst_1
    //   392: istore 7
    //   394: aload_0
    //   395: aload_2
    //   396: iload 6
    //   398: iload 4
    //   400: iload 7
    //   402: aload_3
    //   403: getfield 237	com/google/protobuf/Method:syntax_	I
    //   406: invokeinterface 368 5 0
    //   411: putfield 237	com/google/protobuf/Method:syntax_	I
    //   414: aload_0
    //   415: astore_1
    //   416: aload_2
    //   417: getstatic 374	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   420: if_acmpne -348 -> 72
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 376	com/google/protobuf/Method:bitField0_	I
    //   428: aload_3
    //   429: getfield 376	com/google/protobuf/Method:bitField0_	I
    //   432: ior
    //   433: putfield 376	com/google/protobuf/Method:bitField0_	I
    //   436: aload_0
    //   437: areturn
    //   438: iconst_0
    //   439: istore 6
    //   441: goto -320 -> 121
    //   444: iconst_0
    //   445: istore 7
    //   447: goto -308 -> 139
    //   450: iconst_0
    //   451: istore 6
    //   453: goto -282 -> 171
    //   456: iconst_0
    //   457: istore 7
    //   459: goto -270 -> 189
    //   462: iconst_0
    //   463: istore 6
    //   465: goto -247 -> 218
    //   468: iconst_0
    //   469: istore 7
    //   471: goto -237 -> 234
    //   474: iconst_0
    //   475: istore 6
    //   477: goto -210 -> 267
    //   480: iconst_0
    //   481: istore 7
    //   483: goto -198 -> 285
    //   486: iconst_0
    //   487: istore 6
    //   489: goto -175 -> 314
    //   492: iconst_0
    //   493: istore 7
    //   495: goto -165 -> 330
    //   498: iconst_0
    //   499: istore 6
    //   501: goto -123 -> 378
    //   504: iconst_0
    //   505: istore 7
    //   507: goto -113 -> 394
    //   510: aload_2
    //   511: checkcast 378	com/google/protobuf/CodedInputStream
    //   514: astore_1
    //   515: aload_3
    //   516: checkcast 380	com/google/protobuf/ExtensionRegistryLite
    //   519: astore_2
    //   520: iconst_0
    //   521: istore 4
    //   523: iload 4
    //   525: ifne +253 -> 778
    //   528: aload_1
    //   529: invokevirtual 383	com/google/protobuf/CodedInputStream:readTag	()I
    //   532: istore 5
    //   534: iload 5
    //   536: lookupswitch	default:+287->823, 0:+290->826, 10:+91->627, 18:+119->655, 24:+154->690, 34:+165->701, 40:+176->712, 50:+187->723, 56:+231->767
    //   612: aload_1
    //   613: iload 5
    //   615: invokevirtual 387	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   618: ifne -95 -> 523
    //   621: iconst_1
    //   622: istore 4
    //   624: goto -101 -> 523
    //   627: aload_0
    //   628: aload_1
    //   629: invokevirtual 390	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   632: putfield 60	com/google/protobuf/Method:name_	Ljava/lang/String;
    //   635: goto -112 -> 523
    //   638: astore_1
    //   639: new 392	java/lang/RuntimeException
    //   642: dup
    //   643: aload_1
    //   644: aload_0
    //   645: invokevirtual 396	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   648: invokespecial 399	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   651: athrow
    //   652: astore_1
    //   653: aload_1
    //   654: athrow
    //   655: aload_0
    //   656: aload_1
    //   657: invokevirtual 390	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   660: putfield 62	com/google/protobuf/Method:requestTypeUrl_	Ljava/lang/String;
    //   663: goto -140 -> 523
    //   666: astore_1
    //   667: new 392	java/lang/RuntimeException
    //   670: dup
    //   671: new 272	com/google/protobuf/InvalidProtocolBufferException
    //   674: dup
    //   675: aload_1
    //   676: invokevirtual 402	java/io/IOException:getMessage	()Ljava/lang/String;
    //   679: invokespecial 404	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   682: aload_0
    //   683: invokevirtual 396	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   686: invokespecial 399	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   689: athrow
    //   690: aload_0
    //   691: aload_1
    //   692: invokevirtual 407	com/google/protobuf/CodedInputStream:readBool	()Z
    //   695: putfield 227	com/google/protobuf/Method:requestStreaming_	Z
    //   698: goto -175 -> 523
    //   701: aload_0
    //   702: aload_1
    //   703: invokevirtual 390	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   706: putfield 64	com/google/protobuf/Method:responseTypeUrl_	Ljava/lang/String;
    //   709: goto -186 -> 523
    //   712: aload_0
    //   713: aload_1
    //   714: invokevirtual 407	com/google/protobuf/CodedInputStream:readBool	()Z
    //   717: putfield 232	com/google/protobuf/Method:responseStreaming_	Z
    //   720: goto -197 -> 523
    //   723: aload_0
    //   724: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   727: invokeinterface 241 1 0
    //   732: ifne +14 -> 746
    //   735: aload_0
    //   736: aload_0
    //   737: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   740: invokestatic 245	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   743: putfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   746: aload_0
    //   747: getfield 70	com/google/protobuf/Method:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   750: aload_1
    //   751: invokestatic 411	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   754: aload_2
    //   755: invokevirtual 415	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   758: invokeinterface 218 2 0
    //   763: pop
    //   764: goto -241 -> 523
    //   767: aload_0
    //   768: aload_1
    //   769: invokevirtual 418	com/google/protobuf/CodedInputStream:readEnum	()I
    //   772: putfield 237	com/google/protobuf/Method:syntax_	I
    //   775: goto -252 -> 523
    //   778: getstatic 51	com/google/protobuf/Method:DEFAULT_INSTANCE	Lcom/google/protobuf/Method;
    //   781: areturn
    //   782: getstatic 420	com/google/protobuf/Method:PARSER	Lcom/google/protobuf/Parser;
    //   785: ifnonnull +28 -> 813
    //   788: ldc 2
    //   790: monitorenter
    //   791: getstatic 420	com/google/protobuf/Method:PARSER	Lcom/google/protobuf/Parser;
    //   794: ifnonnull +16 -> 810
    //   797: new 422	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   800: dup
    //   801: getstatic 51	com/google/protobuf/Method:DEFAULT_INSTANCE	Lcom/google/protobuf/Method;
    //   804: invokespecial 425	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   807: putstatic 420	com/google/protobuf/Method:PARSER	Lcom/google/protobuf/Parser;
    //   810: ldc 2
    //   812: monitorexit
    //   813: getstatic 420	com/google/protobuf/Method:PARSER	Lcom/google/protobuf/Parser;
    //   816: areturn
    //   817: astore_1
    //   818: ldc 2
    //   820: monitorexit
    //   821: aload_1
    //   822: athrow
    //   823: goto -211 -> 612
    //   826: iconst_1
    //   827: istore 4
    //   829: goto -306 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	Method
    //   0	832	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	832	2	paramObject1	Object
    //   0	832	3	paramObject2	Object
    //   382	446	4	i	int
    //   532	82	5	j	int
    //   119	381	6	bool1	boolean
    //   137	369	7	bool2	boolean
    //   222	113	8	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   528	534	638	com/google/protobuf/InvalidProtocolBufferException
    //   612	621	638	com/google/protobuf/InvalidProtocolBufferException
    //   627	635	638	com/google/protobuf/InvalidProtocolBufferException
    //   655	663	638	com/google/protobuf/InvalidProtocolBufferException
    //   690	698	638	com/google/protobuf/InvalidProtocolBufferException
    //   701	709	638	com/google/protobuf/InvalidProtocolBufferException
    //   712	720	638	com/google/protobuf/InvalidProtocolBufferException
    //   723	746	638	com/google/protobuf/InvalidProtocolBufferException
    //   746	764	638	com/google/protobuf/InvalidProtocolBufferException
    //   767	775	638	com/google/protobuf/InvalidProtocolBufferException
    //   528	534	652	finally
    //   612	621	652	finally
    //   627	635	652	finally
    //   639	652	652	finally
    //   655	663	652	finally
    //   667	690	652	finally
    //   690	698	652	finally
    //   701	709	652	finally
    //   712	720	652	finally
    //   723	746	652	finally
    //   746	764	652	finally
    //   767	775	652	finally
    //   528	534	666	java/io/IOException
    //   612	621	666	java/io/IOException
    //   627	635	666	java/io/IOException
    //   655	663	666	java/io/IOException
    //   690	698	666	java/io/IOException
    //   701	709	666	java/io/IOException
    //   712	720	666	java/io/IOException
    //   723	746	666	java/io/IOException
    //   746	764	666	java/io/IOException
    //   767	775	666	java/io/IOException
    //   791	810	817	finally
    //   810	813	817	finally
    //   818	821	817	finally
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
  
  public boolean getRequestStreaming()
  {
    return this.requestStreaming_;
  }
  
  public String getRequestTypeUrl()
  {
    return this.requestTypeUrl_;
  }
  
  public ByteString getRequestTypeUrlBytes()
  {
    return ByteString.copyFromUtf8(this.requestTypeUrl_);
  }
  
  public boolean getResponseStreaming()
  {
    return this.responseStreaming_;
  }
  
  public String getResponseTypeUrl()
  {
    return this.responseTypeUrl_;
  }
  
  public ByteString getResponseTypeUrlBytes()
  {
    return ByteString.copyFromUtf8(this.responseTypeUrl_);
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
    if (!this.requestTypeUrl_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(2, getRequestTypeUrl());
    }
    j = i;
    if (this.requestStreaming_) {
      j = i + CodedOutputStream.computeBoolSize(3, this.requestStreaming_);
    }
    i = j;
    if (!this.responseTypeUrl_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(4, getResponseTypeUrl());
    }
    j = i;
    if (this.responseStreaming_) {
      j = i + CodedOutputStream.computeBoolSize(5, this.responseStreaming_);
    }
    int k = 0;
    i = j;
    j = k;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_);
    }
    this.memoizedSerializedSize = j;
    return j;
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
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.name_.isEmpty()) {
      paramCodedOutputStream.writeString(1, getName());
    }
    if (!this.requestTypeUrl_.isEmpty()) {
      paramCodedOutputStream.writeString(2, getRequestTypeUrl());
    }
    if (this.requestStreaming_) {
      paramCodedOutputStream.writeBool(3, this.requestStreaming_);
    }
    if (!this.responseTypeUrl_.isEmpty()) {
      paramCodedOutputStream.writeString(4, getResponseTypeUrl());
    }
    if (this.responseStreaming_) {
      paramCodedOutputStream.writeBool(5, this.responseStreaming_);
    }
    int i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.writeEnum(7, this.syntax_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Method, Builder>
    implements MethodOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllOptions(Iterable<? extends Option> paramIterable)
    {
      copyOnWrite();
      ((Method)this.instance).addAllOptions(paramIterable);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Method)this.instance).addOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Method)this.instance).addOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder addOptions(Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Method)this.instance).addOptions(paramBuilder);
      return this;
    }
    
    public Builder addOptions(Option paramOption)
    {
      copyOnWrite();
      ((Method)this.instance).addOptions(paramOption);
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Method)this.instance).clearName();
      return this;
    }
    
    public Builder clearOptions()
    {
      copyOnWrite();
      ((Method)this.instance).clearOptions();
      return this;
    }
    
    public Builder clearRequestStreaming()
    {
      copyOnWrite();
      ((Method)this.instance).clearRequestStreaming();
      return this;
    }
    
    public Builder clearRequestTypeUrl()
    {
      copyOnWrite();
      ((Method)this.instance).clearRequestTypeUrl();
      return this;
    }
    
    public Builder clearResponseStreaming()
    {
      copyOnWrite();
      ((Method)this.instance).clearResponseStreaming();
      return this;
    }
    
    public Builder clearResponseTypeUrl()
    {
      copyOnWrite();
      ((Method)this.instance).clearResponseTypeUrl();
      return this;
    }
    
    public Builder clearSyntax()
    {
      copyOnWrite();
      ((Method)this.instance).clearSyntax();
      return this;
    }
    
    public String getName()
    {
      return ((Method)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Method)this.instance).getNameBytes();
    }
    
    public Option getOptions(int paramInt)
    {
      return ((Method)this.instance).getOptions(paramInt);
    }
    
    public int getOptionsCount()
    {
      return ((Method)this.instance).getOptionsCount();
    }
    
    public List<Option> getOptionsList()
    {
      return Collections.unmodifiableList(((Method)this.instance).getOptionsList());
    }
    
    public boolean getRequestStreaming()
    {
      return ((Method)this.instance).getRequestStreaming();
    }
    
    public String getRequestTypeUrl()
    {
      return ((Method)this.instance).getRequestTypeUrl();
    }
    
    public ByteString getRequestTypeUrlBytes()
    {
      return ((Method)this.instance).getRequestTypeUrlBytes();
    }
    
    public boolean getResponseStreaming()
    {
      return ((Method)this.instance).getResponseStreaming();
    }
    
    public String getResponseTypeUrl()
    {
      return ((Method)this.instance).getResponseTypeUrl();
    }
    
    public ByteString getResponseTypeUrlBytes()
    {
      return ((Method)this.instance).getResponseTypeUrlBytes();
    }
    
    public Syntax getSyntax()
    {
      return ((Method)this.instance).getSyntax();
    }
    
    public int getSyntaxValue()
    {
      return ((Method)this.instance).getSyntaxValue();
    }
    
    public Builder removeOptions(int paramInt)
    {
      copyOnWrite();
      ((Method)this.instance).removeOptions(paramInt);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Method)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Method)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Method)this.instance).setOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Method)this.instance).setOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder setRequestStreaming(boolean paramBoolean)
    {
      copyOnWrite();
      ((Method)this.instance).setRequestStreaming(paramBoolean);
      return this;
    }
    
    public Builder setRequestTypeUrl(String paramString)
    {
      copyOnWrite();
      ((Method)this.instance).setRequestTypeUrl(paramString);
      return this;
    }
    
    public Builder setRequestTypeUrlBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Method)this.instance).setRequestTypeUrlBytes(paramByteString);
      return this;
    }
    
    public Builder setResponseStreaming(boolean paramBoolean)
    {
      copyOnWrite();
      ((Method)this.instance).setResponseStreaming(paramBoolean);
      return this;
    }
    
    public Builder setResponseTypeUrl(String paramString)
    {
      copyOnWrite();
      ((Method)this.instance).setResponseTypeUrl(paramString);
      return this;
    }
    
    public Builder setResponseTypeUrlBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Method)this.instance).setResponseTypeUrlBytes(paramByteString);
      return this;
    }
    
    public Builder setSyntax(Syntax paramSyntax)
    {
      copyOnWrite();
      ((Method)this.instance).setSyntax(paramSyntax);
      return this;
    }
    
    public Builder setSyntaxValue(int paramInt)
    {
      copyOnWrite();
      ((Method)this.instance).setSyntaxValue(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */