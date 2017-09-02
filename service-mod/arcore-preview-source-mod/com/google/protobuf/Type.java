package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Type
  extends GeneratedMessageLite<Type, Builder>
  implements TypeOrBuilder
{
  private static final Type DEFAULT_INSTANCE = new Type();
  public static final int FIELDS_FIELD_NUMBER = 2;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int ONEOFS_FIELD_NUMBER = 3;
  public static final int OPTIONS_FIELD_NUMBER = 4;
  private static volatile Parser<Type> PARSER;
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  public static final int SYNTAX_FIELD_NUMBER = 6;
  private int bitField0_;
  private Internal.ProtobufList<Field> fields_ = emptyProtobufList();
  private String name_ = "";
  private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.emptyProtobufList();
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  private SourceContext sourceContext_;
  private int syntax_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFields(Iterable<? extends Field> paramIterable)
  {
    ensureFieldsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.fields_);
  }
  
  private void addAllOneofs(Iterable<String> paramIterable)
  {
    ensureOneofsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.oneofs_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable)
  {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addFields(int paramInt, Field.Builder paramBuilder)
  {
    ensureFieldsIsMutable();
    this.fields_.add(paramInt, paramBuilder.build());
  }
  
  private void addFields(int paramInt, Field paramField)
  {
    if (paramField == null) {
      throw new NullPointerException();
    }
    ensureFieldsIsMutable();
    this.fields_.add(paramInt, paramField);
  }
  
  private void addFields(Field.Builder paramBuilder)
  {
    ensureFieldsIsMutable();
    this.fields_.add(paramBuilder.build());
  }
  
  private void addFields(Field paramField)
  {
    if (paramField == null) {
      throw new NullPointerException();
    }
    ensureFieldsIsMutable();
    this.fields_.add(paramField);
  }
  
  private void addOneofs(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureOneofsIsMutable();
    this.oneofs_.add(paramString);
  }
  
  private void addOneofsBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    ensureOneofsIsMutable();
    this.oneofs_.add(paramByteString.toStringUtf8());
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
  
  private void clearFields()
  {
    this.fields_ = emptyProtobufList();
  }
  
  private void clearName()
  {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOneofs()
  {
    this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
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
  
  private void ensureFieldsIsMutable()
  {
    if (!this.fields_.isModifiable()) {
      this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_);
    }
  }
  
  private void ensureOneofsIsMutable()
  {
    if (!this.oneofs_.isModifiable()) {
      this.oneofs_ = GeneratedMessageLite.mutableCopy(this.oneofs_);
    }
  }
  
  private void ensureOptionsIsMutable()
  {
    if (!this.options_.isModifiable()) {
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_);
    }
  }
  
  public static Type getDefaultInstance()
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
  
  public static Builder newBuilder(Type paramType)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramType);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Type parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Type parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Type> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFields(int paramInt)
  {
    ensureFieldsIsMutable();
    this.fields_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt)
  {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setFields(int paramInt, Field.Builder paramBuilder)
  {
    ensureFieldsIsMutable();
    this.fields_.set(paramInt, paramBuilder.build());
  }
  
  private void setFields(int paramInt, Field paramField)
  {
    if (paramField == null) {
      throw new NullPointerException();
    }
    ensureFieldsIsMutable();
    this.fields_.set(paramInt, paramField);
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
  
  private void setOneofs(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureOneofsIsMutable();
    this.oneofs_.set(paramInt, paramString);
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
    //   0: getstatic 390	com/google/protobuf/Type$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 395	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+99->107, 5:+108->116, 6:+337->345, 7:+698->706, 8:+702->710
    //   56: new 397	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 398	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Type
    //   67: dup
    //   68: invokespecial 48	com/google/protobuf/Type:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 50	com/google/protobuf/Type:DEFAULT_INSTANCE	Lcom/google/protobuf/Type;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 399 1 0
    //   87: aload_0
    //   88: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   91: invokeinterface 399 1 0
    //   96: aload_0
    //   97: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   100: invokeinterface 399 1 0
    //   105: aconst_null
    //   106: areturn
    //   107: new 11	com/google/protobuf/Type$Builder
    //   110: dup
    //   111: aconst_null
    //   112: invokespecial 402	com/google/protobuf/Type$Builder:<init>	(Lcom/google/protobuf/Type$1;)V
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 404	com/google/protobuf/GeneratedMessageLite$Visitor
    //   120: astore_2
    //   121: aload_3
    //   122: checkcast 2	com/google/protobuf/Type
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   130: invokevirtual 409	java/lang/String:isEmpty	()Z
    //   133: ifne +188 -> 321
    //   136: iconst_1
    //   137: istore 6
    //   139: aload_0
    //   140: getfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   143: astore_1
    //   144: aload_3
    //   145: getfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   148: invokevirtual 409	java/lang/String:isEmpty	()Z
    //   151: ifne +176 -> 327
    //   154: iconst_1
    //   155: istore 7
    //   157: aload_0
    //   158: aload_2
    //   159: iload 6
    //   161: aload_1
    //   162: iload 7
    //   164: aload_3
    //   165: getfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   168: invokeinterface 413 5 0
    //   173: putfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_2
    //   178: aload_0
    //   179: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   182: aload_3
    //   183: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   186: invokeinterface 417 3 0
    //   191: putfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   194: aload_0
    //   195: aload_2
    //   196: aload_0
    //   197: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   200: aload_3
    //   201: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   204: invokeinterface 417 3 0
    //   209: putfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   212: aload_0
    //   213: aload_2
    //   214: aload_0
    //   215: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   218: aload_3
    //   219: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   222: invokeinterface 417 3 0
    //   227: putfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   230: aload_0
    //   231: aload_2
    //   232: aload_0
    //   233: getfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   236: aload_3
    //   237: getfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   240: invokeinterface 421 3 0
    //   245: checkcast 297	com/google/protobuf/SourceContext
    //   248: putfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   251: aload_0
    //   252: getfield 287	com/google/protobuf/Type:syntax_	I
    //   255: ifeq +78 -> 333
    //   258: iconst_1
    //   259: istore 6
    //   261: aload_0
    //   262: getfield 287	com/google/protobuf/Type:syntax_	I
    //   265: istore 4
    //   267: aload_3
    //   268: getfield 287	com/google/protobuf/Type:syntax_	I
    //   271: ifeq +68 -> 339
    //   274: iconst_1
    //   275: istore 7
    //   277: aload_0
    //   278: aload_2
    //   279: iload 6
    //   281: iload 4
    //   283: iload 7
    //   285: aload_3
    //   286: getfield 287	com/google/protobuf/Type:syntax_	I
    //   289: invokeinterface 425 5 0
    //   294: putfield 287	com/google/protobuf/Type:syntax_	I
    //   297: aload_0
    //   298: astore_1
    //   299: aload_2
    //   300: getstatic 431	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   303: if_acmpne -231 -> 72
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 433	com/google/protobuf/Type:bitField0_	I
    //   311: aload_3
    //   312: getfield 433	com/google/protobuf/Type:bitField0_	I
    //   315: ior
    //   316: putfield 433	com/google/protobuf/Type:bitField0_	I
    //   319: aload_0
    //   320: areturn
    //   321: iconst_0
    //   322: istore 6
    //   324: goto -185 -> 139
    //   327: iconst_0
    //   328: istore 7
    //   330: goto -173 -> 157
    //   333: iconst_0
    //   334: istore 6
    //   336: goto -75 -> 261
    //   339: iconst_0
    //   340: istore 7
    //   342: goto -65 -> 277
    //   345: aload_2
    //   346: checkcast 435	com/google/protobuf/CodedInputStream
    //   349: astore_2
    //   350: aload_3
    //   351: checkcast 437	com/google/protobuf/ExtensionRegistryLite
    //   354: astore_3
    //   355: iconst_0
    //   356: istore 4
    //   358: iload 4
    //   360: ifne +346 -> 706
    //   363: aload_2
    //   364: invokevirtual 440	com/google/protobuf/CodedInputStream:readTag	()I
    //   367: istore 5
    //   369: iload 5
    //   371: lookupswitch	default:+380->751, 0:+383->754, 10:+80->451, 18:+108->479, 26:+176->547, 34:+218->589, 42:+262->633, 48:+324->695
    //   436: aload_2
    //   437: iload 5
    //   439: invokevirtual 444	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   442: ifne -84 -> 358
    //   445: iconst_1
    //   446: istore 4
    //   448: goto -90 -> 358
    //   451: aload_0
    //   452: aload_2
    //   453: invokevirtual 447	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   456: putfield 59	com/google/protobuf/Type:name_	Ljava/lang/String;
    //   459: goto -101 -> 358
    //   462: astore_1
    //   463: new 449	java/lang/RuntimeException
    //   466: dup
    //   467: aload_1
    //   468: aload_0
    //   469: invokevirtual 453	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   472: invokespecial 456	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   475: athrow
    //   476: astore_1
    //   477: aload_1
    //   478: athrow
    //   479: aload_0
    //   480: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   483: invokeinterface 291 1 0
    //   488: ifne +14 -> 502
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   496: invokestatic 295	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   499: putfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   502: aload_0
    //   503: getfield 65	com/google/protobuf/Type:fields_	Lcom/google/protobuf/Internal$ProtobufList;
    //   506: aload_2
    //   507: invokestatic 460	com/google/protobuf/Field:parser	()Lcom/google/protobuf/Parser;
    //   510: aload_3
    //   511: invokevirtual 464	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   514: invokeinterface 265 2 0
    //   519: pop
    //   520: goto -162 -> 358
    //   523: astore_1
    //   524: new 449	java/lang/RuntimeException
    //   527: dup
    //   528: new 336	com/google/protobuf/InvalidProtocolBufferException
    //   531: dup
    //   532: aload_1
    //   533: invokevirtual 467	java/io/IOException:getMessage	()Ljava/lang/String;
    //   536: invokespecial 469	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   539: aload_0
    //   540: invokevirtual 453	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   543: invokespecial 456	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   546: athrow
    //   547: aload_2
    //   548: invokevirtual 447	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   551: astore_1
    //   552: aload_0
    //   553: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   556: invokeinterface 291 1 0
    //   561: ifne +14 -> 575
    //   564: aload_0
    //   565: aload_0
    //   566: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   569: invokestatic 295	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   572: putfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   575: aload_0
    //   576: getfield 68	com/google/protobuf/Type:oneofs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   579: aload_1
    //   580: invokeinterface 265 2 0
    //   585: pop
    //   586: goto -228 -> 358
    //   589: aload_0
    //   590: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   593: invokeinterface 291 1 0
    //   598: ifne +14 -> 612
    //   601: aload_0
    //   602: aload_0
    //   603: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   606: invokestatic 295	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   609: putfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   612: aload_0
    //   613: getfield 70	com/google/protobuf/Type:options_	Lcom/google/protobuf/Internal$ProtobufList;
    //   616: aload_2
    //   617: invokestatic 472	com/google/protobuf/Option:parser	()Lcom/google/protobuf/Parser;
    //   620: aload_3
    //   621: invokevirtual 464	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   624: invokeinterface 265 2 0
    //   629: pop
    //   630: goto -272 -> 358
    //   633: aconst_null
    //   634: astore_1
    //   635: aload_0
    //   636: getfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   639: ifnull +14 -> 653
    //   642: aload_0
    //   643: getfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   646: invokevirtual 473	com/google/protobuf/SourceContext:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   649: checkcast 306	com/google/protobuf/SourceContext$Builder
    //   652: astore_1
    //   653: aload_0
    //   654: aload_2
    //   655: invokestatic 474	com/google/protobuf/SourceContext:parser	()Lcom/google/protobuf/Parser;
    //   658: aload_3
    //   659: invokevirtual 464	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   662: checkcast 297	com/google/protobuf/SourceContext
    //   665: putfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   668: aload_1
    //   669: ifnull -311 -> 358
    //   672: aload_1
    //   673: aload_0
    //   674: getfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   677: invokevirtual 310	com/google/protobuf/SourceContext$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   680: pop
    //   681: aload_0
    //   682: aload_1
    //   683: invokevirtual 313	com/google/protobuf/SourceContext$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   686: checkcast 297	com/google/protobuf/SourceContext
    //   689: putfield 285	com/google/protobuf/Type:sourceContext_	Lcom/google/protobuf/SourceContext;
    //   692: goto -334 -> 358
    //   695: aload_0
    //   696: aload_2
    //   697: invokevirtual 477	com/google/protobuf/CodedInputStream:readEnum	()I
    //   700: putfield 287	com/google/protobuf/Type:syntax_	I
    //   703: goto -345 -> 358
    //   706: getstatic 50	com/google/protobuf/Type:DEFAULT_INSTANCE	Lcom/google/protobuf/Type;
    //   709: areturn
    //   710: getstatic 479	com/google/protobuf/Type:PARSER	Lcom/google/protobuf/Parser;
    //   713: ifnonnull +28 -> 741
    //   716: ldc 2
    //   718: monitorenter
    //   719: getstatic 479	com/google/protobuf/Type:PARSER	Lcom/google/protobuf/Parser;
    //   722: ifnonnull +16 -> 738
    //   725: new 481	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   728: dup
    //   729: getstatic 50	com/google/protobuf/Type:DEFAULT_INSTANCE	Lcom/google/protobuf/Type;
    //   732: invokespecial 484	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   735: putstatic 479	com/google/protobuf/Type:PARSER	Lcom/google/protobuf/Parser;
    //   738: ldc 2
    //   740: monitorexit
    //   741: getstatic 479	com/google/protobuf/Type:PARSER	Lcom/google/protobuf/Parser;
    //   744: areturn
    //   745: astore_1
    //   746: ldc 2
    //   748: monitorexit
    //   749: aload_1
    //   750: athrow
    //   751: goto -315 -> 436
    //   754: iconst_1
    //   755: istore 4
    //   757: goto -399 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	Type
    //   0	760	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	760	2	paramObject1	Object
    //   0	760	3	paramObject2	Object
    //   265	491	4	i	int
    //   367	71	5	j	int
    //   137	198	6	bool1	boolean
    //   155	186	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   363	369	462	com/google/protobuf/InvalidProtocolBufferException
    //   436	445	462	com/google/protobuf/InvalidProtocolBufferException
    //   451	459	462	com/google/protobuf/InvalidProtocolBufferException
    //   479	502	462	com/google/protobuf/InvalidProtocolBufferException
    //   502	520	462	com/google/protobuf/InvalidProtocolBufferException
    //   547	575	462	com/google/protobuf/InvalidProtocolBufferException
    //   575	586	462	com/google/protobuf/InvalidProtocolBufferException
    //   589	612	462	com/google/protobuf/InvalidProtocolBufferException
    //   612	630	462	com/google/protobuf/InvalidProtocolBufferException
    //   635	653	462	com/google/protobuf/InvalidProtocolBufferException
    //   653	668	462	com/google/protobuf/InvalidProtocolBufferException
    //   672	692	462	com/google/protobuf/InvalidProtocolBufferException
    //   695	703	462	com/google/protobuf/InvalidProtocolBufferException
    //   363	369	476	finally
    //   436	445	476	finally
    //   451	459	476	finally
    //   463	476	476	finally
    //   479	502	476	finally
    //   502	520	476	finally
    //   524	547	476	finally
    //   547	575	476	finally
    //   575	586	476	finally
    //   589	612	476	finally
    //   612	630	476	finally
    //   635	653	476	finally
    //   653	668	476	finally
    //   672	692	476	finally
    //   695	703	476	finally
    //   363	369	523	java/io/IOException
    //   436	445	523	java/io/IOException
    //   451	459	523	java/io/IOException
    //   479	502	523	java/io/IOException
    //   502	520	523	java/io/IOException
    //   547	575	523	java/io/IOException
    //   575	586	523	java/io/IOException
    //   589	612	523	java/io/IOException
    //   612	630	523	java/io/IOException
    //   635	653	523	java/io/IOException
    //   653	668	523	java/io/IOException
    //   672	692	523	java/io/IOException
    //   695	703	523	java/io/IOException
    //   719	738	745	finally
    //   738	741	745	finally
    //   746	749	745	finally
  }
  
  public Field getFields(int paramInt)
  {
    return (Field)this.fields_.get(paramInt);
  }
  
  public int getFieldsCount()
  {
    return this.fields_.size();
  }
  
  public List<Field> getFieldsList()
  {
    return this.fields_;
  }
  
  public FieldOrBuilder getFieldsOrBuilder(int paramInt)
  {
    return (FieldOrBuilder)this.fields_.get(paramInt);
  }
  
  public List<? extends FieldOrBuilder> getFieldsOrBuilderList()
  {
    return this.fields_;
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getOneofs(int paramInt)
  {
    return (String)this.oneofs_.get(paramInt);
  }
  
  public ByteString getOneofsBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.oneofs_.get(paramInt));
  }
  
  public int getOneofsCount()
  {
    return this.oneofs_.size();
  }
  
  public List<String> getOneofsList()
  {
    return this.oneofs_;
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
    while (j < this.fields_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.fields_.get(j));
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < this.oneofs_.size())
    {
      k += CodedOutputStream.computeStringSizeNoTag((String)this.oneofs_.get(j));
      j += 1;
    }
    i = i + k + getOneofsList().size() * 1;
    j = 0;
    while (j < this.options_.size())
    {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.options_.get(j));
      j += 1;
    }
    j = i;
    if (this.sourceContext_ != null) {
      j = i + CodedOutputStream.computeMessageSize(5, getSourceContext());
    }
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      i = j + CodedOutputStream.computeEnumSize(6, this.syntax_);
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
    while (i < this.fields_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.fields_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.oneofs_.size())
    {
      paramCodedOutputStream.writeString(3, (String)this.oneofs_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.options_.size())
    {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.options_.get(i));
      i += 1;
    }
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.writeMessage(5, getSourceContext());
    }
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
      paramCodedOutputStream.writeEnum(6, this.syntax_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Type, Builder>
    implements TypeOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllFields(Iterable<? extends Field> paramIterable)
    {
      copyOnWrite();
      ((Type)this.instance).addAllFields(paramIterable);
      return this;
    }
    
    public Builder addAllOneofs(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Type)this.instance).addAllOneofs(paramIterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> paramIterable)
    {
      copyOnWrite();
      ((Type)this.instance).addAllOptions(paramIterable);
      return this;
    }
    
    public Builder addFields(int paramInt, Field.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).addFields(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addFields(int paramInt, Field paramField)
    {
      copyOnWrite();
      ((Type)this.instance).addFields(paramInt, paramField);
      return this;
    }
    
    public Builder addFields(Field.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).addFields(paramBuilder);
      return this;
    }
    
    public Builder addFields(Field paramField)
    {
      copyOnWrite();
      ((Type)this.instance).addFields(paramField);
      return this;
    }
    
    public Builder addOneofs(String paramString)
    {
      copyOnWrite();
      ((Type)this.instance).addOneofs(paramString);
      return this;
    }
    
    public Builder addOneofsBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Type)this.instance).addOneofsBytes(paramByteString);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).addOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Type)this.instance).addOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder addOptions(Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).addOptions(paramBuilder);
      return this;
    }
    
    public Builder addOptions(Option paramOption)
    {
      copyOnWrite();
      ((Type)this.instance).addOptions(paramOption);
      return this;
    }
    
    public Builder clearFields()
    {
      copyOnWrite();
      ((Type)this.instance).clearFields();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Type)this.instance).clearName();
      return this;
    }
    
    public Builder clearOneofs()
    {
      copyOnWrite();
      ((Type)this.instance).clearOneofs();
      return this;
    }
    
    public Builder clearOptions()
    {
      copyOnWrite();
      ((Type)this.instance).clearOptions();
      return this;
    }
    
    public Builder clearSourceContext()
    {
      copyOnWrite();
      ((Type)this.instance).clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax()
    {
      copyOnWrite();
      ((Type)this.instance).clearSyntax();
      return this;
    }
    
    public Field getFields(int paramInt)
    {
      return ((Type)this.instance).getFields(paramInt);
    }
    
    public int getFieldsCount()
    {
      return ((Type)this.instance).getFieldsCount();
    }
    
    public List<Field> getFieldsList()
    {
      return Collections.unmodifiableList(((Type)this.instance).getFieldsList());
    }
    
    public String getName()
    {
      return ((Type)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Type)this.instance).getNameBytes();
    }
    
    public String getOneofs(int paramInt)
    {
      return ((Type)this.instance).getOneofs(paramInt);
    }
    
    public ByteString getOneofsBytes(int paramInt)
    {
      return ((Type)this.instance).getOneofsBytes(paramInt);
    }
    
    public int getOneofsCount()
    {
      return ((Type)this.instance).getOneofsCount();
    }
    
    public List<String> getOneofsList()
    {
      return Collections.unmodifiableList(((Type)this.instance).getOneofsList());
    }
    
    public Option getOptions(int paramInt)
    {
      return ((Type)this.instance).getOptions(paramInt);
    }
    
    public int getOptionsCount()
    {
      return ((Type)this.instance).getOptionsCount();
    }
    
    public List<Option> getOptionsList()
    {
      return Collections.unmodifiableList(((Type)this.instance).getOptionsList());
    }
    
    public SourceContext getSourceContext()
    {
      return ((Type)this.instance).getSourceContext();
    }
    
    public Syntax getSyntax()
    {
      return ((Type)this.instance).getSyntax();
    }
    
    public int getSyntaxValue()
    {
      return ((Type)this.instance).getSyntaxValue();
    }
    
    public boolean hasSourceContext()
    {
      return ((Type)this.instance).hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Type)this.instance).mergeSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder removeFields(int paramInt)
    {
      copyOnWrite();
      ((Type)this.instance).removeFields(paramInt);
      return this;
    }
    
    public Builder removeOptions(int paramInt)
    {
      copyOnWrite();
      ((Type)this.instance).removeOptions(paramInt);
      return this;
    }
    
    public Builder setFields(int paramInt, Field.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).setFields(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setFields(int paramInt, Field paramField)
    {
      copyOnWrite();
      ((Type)this.instance).setFields(paramInt, paramField);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Type)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Type)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setOneofs(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Type)this.instance).setOneofs(paramInt, paramString);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).setOptions(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setOptions(int paramInt, Option paramOption)
    {
      copyOnWrite();
      ((Type)this.instance).setOptions(paramInt, paramOption);
      return this;
    }
    
    public Builder setSourceContext(SourceContext.Builder paramBuilder)
    {
      copyOnWrite();
      ((Type)this.instance).setSourceContext(paramBuilder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext paramSourceContext)
    {
      copyOnWrite();
      ((Type)this.instance).setSourceContext(paramSourceContext);
      return this;
    }
    
    public Builder setSyntax(Syntax paramSyntax)
    {
      copyOnWrite();
      ((Type)this.instance).setSyntax(paramSyntax);
      return this;
    }
    
    public Builder setSyntaxValue(int paramInt)
    {
      copyOnWrite();
      ((Type)this.instance).setSyntaxValue(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */