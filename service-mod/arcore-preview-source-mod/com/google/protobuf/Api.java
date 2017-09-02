package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Api
  extends GeneratedMessageLite<Api, Builder>
  implements ApiOrBuilder
{
  private static final Api DEFAULT_INSTANCE = new Api();
  public static final int METHODS_FIELD_NUMBER = 2;
  public static final int MIXINS_FIELD_NUMBER = 6;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private static volatile Parser<Api> PARSER;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  public static final int SYNTAX_FIELD_NUMBER = 7;
  public static final int VERSION_FIELD_NUMBER = 4;
  private int bitField0_;
  private Internal.ProtobufList<Method> methods_ = emptyProtobufList();
  private Internal.ProtobufList<Mixin> mixins_ = emptyProtobufList();
  private String name_ = "";
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  private SourceContext sourceContext_;
  private int syntax_;
  private String version_ = "";
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllMethods(Iterable<? extends Method> paramIterable)
  {
    ensureMethodsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.methods_);
  }
  
  private void addAllMixins(Iterable<? extends Mixin> paramIterable)
  {
    ensureMixinsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.mixins_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable)
  {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addMethods(int paramInt, Method.Builder paramBuilder)
  {
    ensureMethodsIsMutable();
    this.methods_.add(paramInt, paramBuilder.build());
  }
  
  private void addMethods(int paramInt, Method paramMethod)
  {
    if (paramMethod == null) {
      throw new NullPointerException();
    }
    ensureMethodsIsMutable();
    this.methods_.add(paramInt, paramMethod);
  }
  
  private void addMethods(Method.Builder paramBuilder)
  {
    ensureMethodsIsMutable();
    this.methods_.add(paramBuilder.build());
  }
  
  private void addMethods(Method paramMethod)
  {
    if (paramMethod == null) {
      throw new NullPointerException();
    }
    ensureMethodsIsMutable();
    this.methods_.add(paramMethod);
  }
  
  private void addMixins(int paramInt, Mixin.Builder paramBuilder)
  {
    ensureMixinsIsMutable();
    this.mixins_.add(paramInt, paramBuilder.build());
  }
  
  private void addMixins(int paramInt, Mixin paramMixin)
  {
    if (paramMixin == null) {
      throw new NullPointerException();
    }
    ensureMixinsIsMutable();
    this.mixins_.add(paramInt, paramMixin);
  }
  
  private void addMixins(Mixin.Builder paramBuilder)
  {
    ensureMixinsIsMutable();
    this.mixins_.add(paramBuilder.build());
  }
  
  private void addMixins(Mixin paramMixin)
  {
    if (paramMixin == null) {
      throw new NullPointerException();
    }
    ensureMixinsIsMutable();
    this.mixins_.add(paramMixin);
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
  
  private void clearMethods()
  {
    this.methods_ = emptyProtobufList();
  }
  
  private void clearMixins()
  {
    this.mixins_ = emptyProtobufList();
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
  
  private void clearVersion()
  {
    this.version_ = getDefaultInstance().getVersion();
  }
  
  private void ensureMethodsIsMutable()
  {
    if (!this.methods_.isModifiable()) {
      this.methods_ = GeneratedMessageLite.mutableCopy(this.methods_);
    }
  }
  
  private void ensureMixinsIsMutable()
  {
    if (!this.mixins_.isModifiable()) {
      this.mixins_ = GeneratedMessageLite.mutableCopy(this.mixins_);
    }
  }
  
  private void ensureOptionsIsMutable()
  {
    if (!this.options_.isModifiable()) {
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
    }
  }
  
  public static Api getDefaultInstance()
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
  
  public static Builder newBuilder(Api paramApi)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramApi);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Api parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Api parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Api)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Api> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeMethods(int paramInt)
  {
    ensureMethodsIsMutable();
    this.methods_.remove(paramInt);
  }
  
  private void removeMixins(int paramInt)
  {
    ensureMixinsIsMutable();
    this.mixins_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt)
  {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setMethods(int paramInt, Method.Builder paramBuilder)
  {
    ensureMethodsIsMutable();
    this.methods_.set(paramInt, paramBuilder.build());
  }
  
  private void setMethods(int paramInt, Method paramMethod)
  {
    if (paramMethod == null) {
      throw new NullPointerException();
    }
    ensureMethodsIsMutable();
    this.methods_.set(paramInt, paramMethod);
  }
  
  private void setMixins(int paramInt, Mixin.Builder paramBuilder)
  {
    ensureMixinsIsMutable();
    this.mixins_.set(paramInt, paramBuilder.build());
  }
  
  private void setMixins(int paramInt, Mixin paramMixin)
  {
    if (paramMixin == null) {
      throw new NullPointerException();
    }
    ensureMixinsIsMutable();
    this.mixins_.set(paramInt, paramMixin);
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
  
  private void setVersion(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.version_ = paramString;
  }
  
  private void setVersionBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.version_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 430	com/google/protobuf/Api$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 435	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+99->107, 5:+108->116, 6:+399->407, 7:+783->791, 8:+787->795
    //   56: new 437	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 438	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Api
    //   67: dup
    //   68: invokespecial 51	com/google/protobuf/Api:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 53	com/google/protobuf/Api:DEFAULT_INSTANCE	Lcom/google/protobuf/Api;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 439 1 0
    //   87: aload_0
    //   88: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   91: invokeinterface 439 1 0
    //   96: aload_0
    //   97: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   100: invokeinterface 439 1 0
    //   105: aconst_null
    //   106: areturn
    //   107: new 11	com/google/protobuf/Api$Builder
    //   110: dup
    //   111: aconst_null
    //   112: invokespecial 442	com/google/protobuf/Api$Builder:<init>	(Lcom/google/protobuf/Api$1;)V
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 444	com/google/protobuf/GeneratedMessageLite$Visitor
    //   120: astore_2
    //   121: aload_3
    //   122: checkcast 2	com/google/protobuf/Api
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   130: invokevirtual 449	java/lang/String:isEmpty	()Z
    //   133: ifne +238 -> 371
    //   136: iconst_1
    //   137: istore 6
    //   139: aload_0
    //   140: getfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   143: astore_1
    //   144: aload_3
    //   145: getfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   148: invokevirtual 449	java/lang/String:isEmpty	()Z
    //   151: ifne +226 -> 377
    //   154: iconst_1
    //   155: istore 7
    //   157: aload_0
    //   158: aload_2
    //   159: iload 6
    //   161: aload_1
    //   162: iload 7
    //   164: aload_3
    //   165: getfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   168: invokeinterface 453 5 0
    //   173: putfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_2
    //   178: aload_0
    //   179: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   182: aload_3
    //   183: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   186: invokeinterface 457 3 0
    //   191: putfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   194: aload_0
    //   195: aload_2
    //   196: aload_0
    //   197: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   200: aload_3
    //   201: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   204: invokeinterface 457 3 0
    //   209: putfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   212: aload_0
    //   213: getfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   216: invokevirtual 449	java/lang/String:isEmpty	()Z
    //   219: ifne +164 -> 383
    //   222: iconst_1
    //   223: istore 6
    //   225: aload_0
    //   226: getfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   229: astore_1
    //   230: aload_3
    //   231: getfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   234: invokevirtual 449	java/lang/String:isEmpty	()Z
    //   237: ifne +152 -> 389
    //   240: iconst_1
    //   241: istore 7
    //   243: aload_0
    //   244: aload_2
    //   245: iload 6
    //   247: aload_1
    //   248: iload 7
    //   250: aload_3
    //   251: getfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   254: invokeinterface 453 5 0
    //   259: putfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   262: aload_0
    //   263: aload_2
    //   264: aload_0
    //   265: getfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   268: aload_3
    //   269: getfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   272: invokeinterface 461 3 0
    //   277: checkcast 329	com/google/protobuf/SourceContext
    //   280: putfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   283: aload_0
    //   284: aload_2
    //   285: aload_0
    //   286: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   289: aload_3
    //   290: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   293: invokeinterface 457 3 0
    //   298: putfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   301: aload_0
    //   302: getfield 316	com/google/protobuf/Api:syntax_	I
    //   305: ifeq +90 -> 395
    //   308: iconst_1
    //   309: istore 6
    //   311: aload_0
    //   312: getfield 316	com/google/protobuf/Api:syntax_	I
    //   315: istore 4
    //   317: aload_3
    //   318: getfield 316	com/google/protobuf/Api:syntax_	I
    //   321: ifeq +80 -> 401
    //   324: iconst_1
    //   325: istore 7
    //   327: aload_0
    //   328: aload_2
    //   329: iload 6
    //   331: iload 4
    //   333: iload 7
    //   335: aload_3
    //   336: getfield 316	com/google/protobuf/Api:syntax_	I
    //   339: invokeinterface 465 5 0
    //   344: putfield 316	com/google/protobuf/Api:syntax_	I
    //   347: aload_0
    //   348: astore_1
    //   349: aload_2
    //   350: getstatic 471	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   353: if_acmpne -281 -> 72
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 473	com/google/protobuf/Api:bitField0_	I
    //   361: aload_3
    //   362: getfield 473	com/google/protobuf/Api:bitField0_	I
    //   365: ior
    //   366: putfield 473	com/google/protobuf/Api:bitField0_	I
    //   369: aload_0
    //   370: areturn
    //   371: iconst_0
    //   372: istore 6
    //   374: goto -235 -> 139
    //   377: iconst_0
    //   378: istore 7
    //   380: goto -223 -> 157
    //   383: iconst_0
    //   384: istore 6
    //   386: goto -161 -> 225
    //   389: iconst_0
    //   390: istore 7
    //   392: goto -149 -> 243
    //   395: iconst_0
    //   396: istore 6
    //   398: goto -87 -> 311
    //   401: iconst_0
    //   402: istore 7
    //   404: goto -77 -> 327
    //   407: aload_2
    //   408: checkcast 475	com/google/protobuf/CodedInputStream
    //   411: astore_2
    //   412: aload_3
    //   413: checkcast 477	com/google/protobuf/ExtensionRegistryLite
    //   416: astore_3
    //   417: iconst_0
    //   418: istore 4
    //   420: iload 4
    //   422: ifne +369 -> 791
    //   425: aload_2
    //   426: invokevirtual 480	com/google/protobuf/CodedInputStream:readTag	()I
    //   429: istore 5
    //   431: iload 5
    //   433: lookupswitch	default:+403->836, 0:+406->839, 10:+90->523, 18:+118->551, 26:+186->619, 34:+230->663, 42:+241->674, 50:+303->736, 56:+347->780
    //   508: aload_2
    //   509: iload 5
    //   511: invokevirtual 484	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   514: ifne -94 -> 420
    //   517: iconst_1
    //   518: istore 4
    //   520: goto -100 -> 420
    //   523: aload_0
    //   524: aload_2
    //   525: invokevirtual 487	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   528: putfield 62	com/google/protobuf/Api:name_	Ljava/lang/String;
    //   531: goto -111 -> 420
    //   534: astore_1
    //   535: new 489	java/lang/RuntimeException
    //   538: dup
    //   539: aload_1
    //   540: aload_0
    //   541: invokevirtual 493	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   544: invokespecial 496	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   547: athrow
    //   548: astore_1
    //   549: aload_1
    //   550: athrow
    //   551: aload_0
    //   552: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   555: invokeinterface 323 1 0
    //   560: ifne +14 -> 574
    //   563: aload_0
    //   564: aload_0
    //   565: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   568: invokestatic 327	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   571: putfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   574: aload_0
    //   575: getfield 68	com/google/protobuf/Api:methods_	Lcom/google/protobuf/Internal$ProtobufList;
    //   578: aload_2
    //   579: invokestatic 500	com/google/protobuf/Method:parser	()Lcom/google/protobuf/Parser;
    //   582: aload_3
    //   583: invokevirtual 504	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   586: invokeinterface 299 2 0
    //   591: pop
    //   592: goto -172 -> 420
    //   595: astore_1
    //   596: new 489	java/lang/RuntimeException
    //   599: dup
    //   600: new 368	com/google/protobuf/InvalidProtocolBufferException
    //   603: dup
    //   604: aload_1
    //   605: invokevirtual 507	java/io/IOException:getMessage	()Ljava/lang/String;
    //   608: invokespecial 509	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   611: aload_0
    //   612: invokevirtual 493	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   615: invokespecial 496	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   618: athrow
    //   619: aload_0
    //   620: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   623: invokeinterface 323 1 0
    //   628: ifne +14 -> 642
    //   631: aload_0
    //   632: aload_0
    //   633: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   636: invokestatic 327	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   639: putfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   642: aload_0
    //   643: getfield 70	com/google/protobuf/Api:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   646: aload_2
    //   647: invokestatic 512	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   650: aload_3
    //   651: invokevirtual 504	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   654: invokeinterface 299 2 0
    //   659: pop
    //   660: goto -240 -> 420
    //   663: aload_0
    //   664: aload_2
    //   665: invokevirtual 487	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   668: putfield 72	com/google/protobuf/Api:version_	Ljava/lang/String;
    //   671: goto -251 -> 420
    //   674: aconst_null
    //   675: astore_1
    //   676: aload_0
    //   677: getfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   680: ifnull +14 -> 694
    //   683: aload_0
    //   684: getfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   687: invokevirtual 513	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   690: checkcast 338	com/google/protobuf/SourceContext$Builder
    //   693: astore_1
    //   694: aload_0
    //   695: aload_2
    //   696: invokestatic 514	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   699: aload_3
    //   700: invokevirtual 504	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   703: checkcast 329	com/google/protobuf/SourceContext
    //   706: putfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   709: aload_1
    //   710: ifnull -290 -> 420
    //   713: aload_1
    //   714: aload_0
    //   715: getfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   718: invokevirtual 342	com/google/protobuf/SourceContext$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   721: pop
    //   722: aload_0
    //   723: aload_1
    //   724: invokevirtual 345	com/google/protobuf/SourceContext$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   727: checkcast 329	com/google/protobuf/SourceContext
    //   730: putfield 314	com/google/protobuf/Api:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   733: goto -313 -> 420
    //   736: aload_0
    //   737: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   740: invokeinterface 323 1 0
    //   745: ifne +14 -> 759
    //   748: aload_0
    //   749: aload_0
    //   750: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   753: invokestatic 327	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   756: putfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   759: aload_0
    //   760: getfield 74	com/google/protobuf/Api:mixins_	Lcom/google/protobuf/Internal$ProtobufList;
    //   763: aload_2
    //   764: invokestatic 517	com/google/protobuf/Mixin:parser	()Lcom/google/protobuf/Parser;
    //   767: aload_3
    //   768: invokevirtual 504	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   771: invokeinterface 299 2 0
    //   776: pop
    //   777: goto -357 -> 420
    //   780: aload_0
    //   781: aload_2
    //   782: invokevirtual 520	com/google/protobuf/CodedInputStream:readEnum	()I
    //   785: putfield 316	com/google/protobuf/Api:syntax_	I
    //   788: goto -368 -> 420
    //   791: getstatic 53	com/google/protobuf/Api:DEFAULT_INSTANCE	Lcom/google/protobuf/Api;
    //   794: areturn
    //   795: getstatic 522	com/google/protobuf/Api:PARSER	Lcom/google/protobuf/Parser;
    //   798: ifnonnull +28 -> 826
    //   801: ldc 2
    //   803: monitorenter
    //   804: getstatic 522	com/google/protobuf/Api:PARSER	Lcom/google/protobuf/Parser;
    //   807: ifnonnull +16 -> 823
    //   810: new 524	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   813: dup
    //   814: getstatic 53	com/google/protobuf/Api:DEFAULT_INSTANCE	Lcom/google/protobuf/Api;
    //   817: invokespecial 527	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   820: putstatic 522	com/google/protobuf/Api:PARSER	Lcom/google/protobuf/Parser;
    //   823: ldc 2
    //   825: monitorexit
    //   826: getstatic 522	com/google/protobuf/Api:PARSER	Lcom/google/protobuf/Parser;
    //   829: areturn
    //   830: astore_1
    //   831: ldc 2
    //   833: monitorexit
    //   834: aload_1
    //   835: athrow
    //   836: goto -328 -> 508
    //   839: iconst_1
    //   840: istore 4
    //   842: goto -422 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	845	0	this	Api
    //   0	845	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	845	2	paramObject1	Object
    //   0	845	3	paramObject2	Object
    //   315	526	4	i	int
    //   429	81	5	j	int
    //   137	260	6	bool1	boolean
    //   155	248	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   425	431	534	com/google/protobuf/InvalidProtocolBufferException
    //   508	517	534	com/google/protobuf/InvalidProtocolBufferException
    //   523	531	534	com/google/protobuf/InvalidProtocolBufferException
    //   551	574	534	com/google/protobuf/InvalidProtocolBufferException
    //   574	592	534	com/google/protobuf/InvalidProtocolBufferException
    //   619	642	534	com/google/protobuf/InvalidProtocolBufferException
    //   642	660	534	com/google/protobuf/InvalidProtocolBufferException
    //   663	671	534	com/google/protobuf/InvalidProtocolBufferException
    //   676	694	534	com/google/protobuf/InvalidProtocolBufferException
    //   694	709	534	com/google/protobuf/InvalidProtocolBufferException
    //   713	733	534	com/google/protobuf/InvalidProtocolBufferException
    //   736	759	534	com/google/protobuf/InvalidProtocolBufferException
    //   759	777	534	com/google/protobuf/InvalidProtocolBufferException
    //   780	788	534	com/google/protobuf/InvalidProtocolBufferException
    //   425	431	548	finally
    //   508	517	548	finally
    //   523	531	548	finally
    //   535	548	548	finally
    //   551	574	548	finally
    //   574	592	548	finally
    //   596	619	548	finally
    //   619	642	548	finally
    //   642	660	548	finally
    //   663	671	548	finally
    //   676	694	548	finally
    //   694	709	548	finally
    //   713	733	548	finally
    //   736	759	548	finally
    //   759	777	548	finally
    //   780	788	548	finally
    //   425	431	595	java/io/IOException
    //   508	517	595	java/io/IOException
    //   523	531	595	java/io/IOException
    //   551	574	595	java/io/IOException
    //   574	592	595	java/io/IOException
    //   619	642	595	java/io/IOException
    //   642	660	595	java/io/IOException
    //   663	671	595	java/io/IOException
    //   676	694	595	java/io/IOException
    //   694	709	595	java/io/IOException
    //   713	733	595	java/io/IOException
    //   736	759	595	java/io/IOException
    //   759	777	595	java/io/IOException
    //   780	788	595	java/io/IOException
    //   804	823	830	finally
    //   823	826	830	finally
    //   831	834	830	finally
  }
  
  public Method getMethods(int paramInt)
  {
    return (Method)this.methods_.get(paramInt);
  }
  
  public int getMethodsCount()
  {
    return this.methods_.size();
  }
  
  public List<Method> getMethodsList()
  {
    return this.methods_;
  }
  
  public MethodOrBuilder getMethodsOrBuilder(int paramInt)
  {
    return (MethodOrBuilder)this.methods_.get(paramInt);
  }
  
  public List<? extends MethodOrBuilder> getMethodsOrBuilderList()
  {
    return this.methods_;
  }
  
  public Mixin getMixins(int paramInt)
  {
    return (Mixin)this.mixins_.get(paramInt);
  }
  
  public int getMixinsCount()
  {
    return this.mixins_.size();
  }
  
  public List<Mixin> getMixinsList()
  {
    return this.mixins_;
  }
  
  public MixinOrBuilder getMixinsOrBuilder(int paramInt)
  {
    return (MixinOrBuilder)this.mixins_.get(paramInt);
  }
  
  public List<? extends MixinOrBuilder> getMixinsOrBuilderList()
  {
    return this.mixins_;
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
    while (j < this.methods_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.methods_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (!this.version_.isEmpty()) {
      j = i + CodedOutputStream.computeStringSize(4, getVersion());
    }
    i = j;
    if (this.sourceContext_ != null) {
      i = j + CodedOutputStream.computeMessageSize(5, getSourceContext());
    }
    j = 0;
    while (j < this.mixins_.size())
    {
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.mixins_.get(j));
      j += 1;
    }
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_);
    }
    this.memoizedSerializedSize = j;
    return j;
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
  
  public String getVersion()
  {
    return this.version_;
  }
  
  public ByteString getVersionBytes()
  {
    return ByteString.copyFromUtf8(this.version_);
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
    while (i < this.methods_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.methods_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (!this.version_.isEmpty()) {
      paramCodedOutputStream.writeString(4, getVersion());
    }
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.writeMessage(5, getSourceContext());
    }
    i = 0;
    while (i < this.mixins_.size())
    {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.mixins_.get(i));
      i += 1;
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.writeEnum(7, this.syntax_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Api, Builder>
    implements ApiOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllMethods(Iterable<? extends Method> paramIterable)
    {
      copyOnWrite();
      ((Api)this.instance).addAllMethods(paramIterable);
      return this;
    }
    
    public Builder addAllMixins(Iterable<? extends Mixin> paramIterable)
    {
      copyOnWrite();
      ((Api)this.instance).addAllMixins(paramIterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> paramIterable)
    {
      copyOnWrite();
      ((Api)this.instance).addAllOptions(paramIterable);
      return this;
    }
    
    public Builder addMethods(int paramInt, Method.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addMethods(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addMethods(int paramInt, Method paramMethod)
    {
      copyOnWrite();
      ((Api)this.instance).addMethods(paramInt, paramMethod);
      return this;
    }
    
    public Builder addMethods(Method.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addMethods(paramBuilder);
      return this;
    }
    
    public Builder addMethods(Method paramMethod)
    {
      copyOnWrite();
      ((Api)this.instance).addMethods(paramMethod);
      return this;
    }
    
    public Builder addMixins(int paramInt, Mixin.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addMixins(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addMixins(int paramInt, Mixin paramMixin)
    {
      copyOnWrite();
      ((Api)this.instance).addMixins(paramInt, paramMixin);
      return this;
    }
    
    public Builder addMixins(Mixin.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addMixins(paramBuilder);
      return this;
    }
    
    public Builder addMixins(Mixin paramMixin)
    {
      copyOnWrite();
      ((Api)this.instance).addMixins(paramMixin);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Api)this.instance).addOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder addOptions(Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).addOptions(paramBuilder);
      return this;
    }
    
    public Builder addOptions(Option paramOption)
    {
      copyOnWrite();
      ((Api)this.instance).addOptions(paramOption);
      return this;
    }
    
    public Builder clearMethods()
    {
      copyOnWrite();
      ((Api)this.instance).clearMethods();
      return this;
    }
    
    public Builder clearMixins()
    {
      copyOnWrite();
      ((Api)this.instance).clearMixins();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Api)this.instance).clearName();
      return this;
    }
    
    public Builder clearOptions()
    {
      copyOnWrite();
      ((Api)this.instance).clearOptions();
      return this;
    }
    
    public Builder clearSourceContext()
    {
      copyOnWrite();
      ((Api)this.instance).clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax()
    {
      copyOnWrite();
      ((Api)this.instance).clearSyntax();
      return this;
    }
    
    public Builder clearVersion()
    {
      copyOnWrite();
      ((Api)this.instance).clearVersion();
      return this;
    }
    
    public Method getMethods(int paramInt)
    {
      return ((Api)this.instance).getMethods(paramInt);
    }
    
    public int getMethodsCount()
    {
      return ((Api)this.instance).getMethodsCount();
    }
    
    public List<Method> getMethodsList()
    {
      return Collections.unmodifiableList(((Api)this.instance).getMethodsList());
    }
    
    public Mixin getMixins(int paramInt)
    {
      return ((Api)this.instance).getMixins(paramInt);
    }
    
    public int getMixinsCount()
    {
      return ((Api)this.instance).getMixinsCount();
    }
    
    public List<Mixin> getMixinsList()
    {
      return Collections.unmodifiableList(((Api)this.instance).getMixinsList());
    }
    
    public String getName()
    {
      return ((Api)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Api)this.instance).getNameBytes();
    }
    
    public Option getOptions(int paramInt)
    {
      return ((Api)this.instance).getOptions(paramInt);
    }
    
    public int getOptionsCount()
    {
      return ((Api)this.instance).getOptionsCount();
    }
    
    public List<Option> getOptionsList()
    {
      return Collections.unmodifiableList(((Api)this.instance).getOptionsList());
    }
    
    public SourceContext getSourceContext()
    {
      return ((Api)this.instance).getSourceContext();
    }
    
    public Syntax getSyntax()
    {
      return ((Api)this.instance).getSyntax();
    }
    
    public int getSyntaxValue()
    {
      return ((Api)this.instance).getSyntaxValue();
    }
    
    public String getVersion()
    {
      return ((Api)this.instance).getVersion();
    }
    
    public ByteString getVersionBytes()
    {
      return ((Api)this.instance).getVersionBytes();
    }
    
    public boolean hasSourceContext()
    {
      return ((Api)this.instance).hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Api)this.instance).mergeSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder removeMethods(int paramInt)
    {
      copyOnWrite();
      ((Api)this.instance).removeMethods(paramInt);
      return this;
    }
    
    public Builder removeMixins(int paramInt)
    {
      copyOnWrite();
      ((Api)this.instance).removeMixins(paramInt);
      return this;
    }
    
    public Builder removeOptions(int paramInt)
    {
      copyOnWrite();
      ((Api)this.instance).removeOptions(paramInt);
      return this;
    }
    
    public Builder setMethods(int paramInt, Method.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).setMethods(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setMethods(int paramInt, Method paramMethod)
    {
      copyOnWrite();
      ((Api)this.instance).setMethods(paramInt, paramMethod);
      return this;
    }
    
    public Builder setMixins(int paramInt, Mixin.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).setMixins(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setMixins(int paramInt, Mixin paramMixin)
    {
      copyOnWrite();
      ((Api)this.instance).setMixins(paramInt, paramMixin);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Api)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Api)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).setOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Api)this.instance).setOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder setSourceContext(SourceContext.Builder paramBuilder)
    {
      copyOnWrite();
      ((Api)this.instance).setSourceContext(paramBuilder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Api)this.instance).setSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder setSyntax(Syntax paramSyntax)
    {
      copyOnWrite();
      ((Api)this.instance).setSyntax(paramSyntax);
      return this;
    }
    
    public Builder setSyntaxValue(int paramInt)
    {
      copyOnWrite();
      ((Api)this.instance).setSyntaxValue(paramInt);
      return this;
    }
    
    public Builder setVersion(String paramString)
    {
      copyOnWrite();
      ((Api)this.instance).setVersion(paramString);
      return this;
    }
    
    public Builder setVersionBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Api)this.instance).setVersionBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */