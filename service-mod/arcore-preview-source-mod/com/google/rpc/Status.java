package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.Any.Builder;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Status
  extends GeneratedMessageLite<Status, Builder>
  implements StatusOrBuilder
{
  public static final int CODE_FIELD_NUMBER = 1;
  private static final Status DEFAULT_INSTANCE = new Status();
  public static final int DETAILS_FIELD_NUMBER = 3;
  public static final int MESSAGE_FIELD_NUMBER = 2;
  private static volatile Parser<Status> PARSER;
  private int bitField0_;
  private int code_;
  private Internal.ProtobufList<Any> details_ = emptyProtobufList();
  private String message_ = "";
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDetails(Iterable<? extends Any> paramIterable)
  {
    ensureDetailsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.details_);
  }
  
  private void addDetails(int paramInt, Any.Builder paramBuilder)
  {
    ensureDetailsIsMutable();
    this.details_.add(paramInt, paramBuilder.build());
  }
  
  private void addDetails(int paramInt, Any paramAny)
  {
    if (paramAny == null) {
      throw new NullPointerException();
    }
    ensureDetailsIsMutable();
    this.details_.add(paramInt, paramAny);
  }
  
  private void addDetails(Any.Builder paramBuilder)
  {
    ensureDetailsIsMutable();
    this.details_.add(paramBuilder.build());
  }
  
  private void addDetails(Any paramAny)
  {
    if (paramAny == null) {
      throw new NullPointerException();
    }
    ensureDetailsIsMutable();
    this.details_.add(paramAny);
  }
  
  private void clearCode()
  {
    this.code_ = 0;
  }
  
  private void clearDetails()
  {
    this.details_ = emptyProtobufList();
  }
  
  private void clearMessage()
  {
    this.message_ = getDefaultInstance().getMessage();
  }
  
  private void ensureDetailsIsMutable()
  {
    if (!this.details_.isModifiable()) {
      this.details_ = GeneratedMessageLite.mutableCopy(this.details_);
    }
  }
  
  public static Status getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Status paramStatus)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramStatus);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Status parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Status parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Status> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeDetails(int paramInt)
  {
    ensureDetailsIsMutable();
    this.details_.remove(paramInt);
  }
  
  private void setCode(int paramInt)
  {
    this.code_ = paramInt;
  }
  
  private void setDetails(int paramInt, Any.Builder paramBuilder)
  {
    ensureDetailsIsMutable();
    this.details_.set(paramInt, paramBuilder.build());
  }
  
  private void setDetails(int paramInt, Any paramAny)
  {
    if (paramAny == null) {
      throw new NullPointerException();
    }
    ensureDetailsIsMutable();
    this.details_.set(paramInt, paramAny);
  }
  
  private void setMessage(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.message_ = paramString;
  }
  
  private void setMessageBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.message_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 252	com/google/rpc/Status$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 258	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+262->270, 7:+454->462, 8:+458->466
    //   56: new 260	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 261	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/rpc/Status
    //   67: dup
    //   68: invokespecial 36	com/google/rpc/Status:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 38	com/google/rpc/Status:DEFAULT_INSTANCE	Lcom/google/rpc/Status;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 262 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/rpc/Status$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 265	com/google/rpc/Status$Builder:<init>	(Lcom/google/rpc/Status$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 267	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/rpc/Status
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 155	com/google/rpc/Status:code_	I
    //   112: ifeq +134 -> 246
    //   115: iconst_1
    //   116: istore 6
    //   118: aload_0
    //   119: getfield 155	com/google/rpc/Status:code_	I
    //   122: istore 4
    //   124: aload_3
    //   125: getfield 155	com/google/rpc/Status:code_	I
    //   128: ifeq +124 -> 252
    //   131: iconst_1
    //   132: istore 7
    //   134: aload_0
    //   135: aload_2
    //   136: iload 6
    //   138: iload 4
    //   140: iload 7
    //   142: aload_3
    //   143: getfield 155	com/google/rpc/Status:code_	I
    //   146: invokeinterface 271 5 0
    //   151: putfield 155	com/google/rpc/Status:code_	I
    //   154: aload_0
    //   155: getfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   158: invokevirtual 276	java/lang/String:isEmpty	()Z
    //   161: ifne +97 -> 258
    //   164: iconst_1
    //   165: istore 6
    //   167: aload_0
    //   168: getfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   171: astore_1
    //   172: aload_3
    //   173: getfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   176: invokevirtual 276	java/lang/String:isEmpty	()Z
    //   179: ifne +85 -> 264
    //   182: iconst_1
    //   183: istore 7
    //   185: aload_0
    //   186: aload_2
    //   187: iload 6
    //   189: aload_1
    //   190: iload 7
    //   192: aload_3
    //   193: getfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   196: invokeinterface 280 5 0
    //   201: putfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   204: aload_0
    //   205: aload_2
    //   206: aload_0
    //   207: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   210: aload_3
    //   211: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   214: invokeinterface 284 3 0
    //   219: putfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   222: aload_0
    //   223: astore_1
    //   224: aload_2
    //   225: getstatic 290	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   228: if_acmpne -156 -> 72
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 292	com/google/rpc/Status:bitField0_	I
    //   236: aload_3
    //   237: getfield 292	com/google/rpc/Status:bitField0_	I
    //   240: ior
    //   241: putfield 292	com/google/rpc/Status:bitField0_	I
    //   244: aload_0
    //   245: areturn
    //   246: iconst_0
    //   247: istore 6
    //   249: goto -131 -> 118
    //   252: iconst_0
    //   253: istore 7
    //   255: goto -121 -> 134
    //   258: iconst_0
    //   259: istore 6
    //   261: goto -94 -> 167
    //   264: iconst_0
    //   265: istore 7
    //   267: goto -82 -> 185
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
    //   296: lookupswitch	default:+211->507, 0:+214->510, 8:+59->355, 18:+87->383, 26:+122->418
    //   340: aload_1
    //   341: iload 5
    //   343: invokevirtual 303	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   346: ifne -63 -> 283
    //   349: iconst_1
    //   350: istore 4
    //   352: goto -69 -> 283
    //   355: aload_0
    //   356: aload_1
    //   357: invokevirtual 306	com/google/protobuf/CodedInputStream:readInt32	()I
    //   360: putfield 155	com/google/rpc/Status:code_	I
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
    //   385: invokevirtual 318	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   388: putfield 47	com/google/rpc/Status:message_	Ljava/lang/String;
    //   391: goto -108 -> 283
    //   394: astore_1
    //   395: new 308	java/lang/RuntimeException
    //   398: dup
    //   399: new 197	com/google/protobuf/InvalidProtocolBufferException
    //   402: dup
    //   403: aload_1
    //   404: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   407: invokespecial 321	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   410: aload_0
    //   411: invokevirtual 312	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   414: invokespecial 315	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   417: athrow
    //   418: aload_0
    //   419: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   422: invokeinterface 166 1 0
    //   427: ifne +14 -> 441
    //   430: aload_0
    //   431: aload_0
    //   432: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   435: invokestatic 170	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   438: putfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   441: aload_0
    //   442: getfield 53	com/google/rpc/Status:details_	Lcom/google/protobuf/Internal$ProtobufList;
    //   445: aload_1
    //   446: invokestatic 325	com/google/protobuf/Any:parser	()Lcom/google/protobuf/Parser;
    //   449: aload_2
    //   450: invokevirtual 329	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   453: invokeinterface 153 2 0
    //   458: pop
    //   459: goto -176 -> 283
    //   462: getstatic 38	com/google/rpc/Status:DEFAULT_INSTANCE	Lcom/google/rpc/Status;
    //   465: areturn
    //   466: getstatic 331	com/google/rpc/Status:PARSER	Lcom/google/protobuf/Parser;
    //   469: ifnonnull +28 -> 497
    //   472: ldc 2
    //   474: monitorenter
    //   475: getstatic 331	com/google/rpc/Status:PARSER	Lcom/google/protobuf/Parser;
    //   478: ifnonnull +16 -> 494
    //   481: new 333	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   484: dup
    //   485: getstatic 38	com/google/rpc/Status:DEFAULT_INSTANCE	Lcom/google/rpc/Status;
    //   488: invokespecial 336	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   491: putstatic 331	com/google/rpc/Status:PARSER	Lcom/google/protobuf/Parser;
    //   494: ldc 2
    //   496: monitorexit
    //   497: getstatic 331	com/google/rpc/Status:PARSER	Lcom/google/protobuf/Parser;
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
    //   0	516	0	this	Status
    //   0	516	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	516	2	paramObject1	Object
    //   0	516	3	paramObject2	Object
    //   122	390	4	i	int
    //   292	50	5	j	int
    //   116	144	6	bool1	boolean
    //   132	134	7	bool2	boolean
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
  
  public int getCode()
  {
    return this.code_;
  }
  
  public Any getDetails(int paramInt)
  {
    return (Any)this.details_.get(paramInt);
  }
  
  public int getDetailsCount()
  {
    return this.details_.size();
  }
  
  public List<Any> getDetailsList()
  {
    return this.details_;
  }
  
  public AnyOrBuilder getDetailsOrBuilder(int paramInt)
  {
    return (AnyOrBuilder)this.details_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getDetailsOrBuilderList()
  {
    return this.details_;
  }
  
  public String getMessage()
  {
    return this.message_;
  }
  
  public ByteString getMessageBytes()
  {
    return ByteString.copyFromUtf8(this.message_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if (this.code_ != 0) {
      j = 0 + CodedOutputStream.computeInt32Size(1, this.code_);
    }
    i = j;
    if (!this.message_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(2, getMessage());
    }
    int k = 0;
    j = i;
    i = k;
    while (i < this.details_.size())
    {
      j += CodedOutputStream.computeMessageSize(3, (MessageLite)this.details_.get(i));
      i += 1;
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.code_ != 0) {
      paramCodedOutputStream.writeInt32(1, this.code_);
    }
    if (!this.message_.isEmpty()) {
      paramCodedOutputStream.writeString(2, getMessage());
    }
    int i = 0;
    while (i < this.details_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.details_.get(i));
      i += 1;
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Status, Builder>
    implements StatusOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllDetails(Iterable<? extends Any> paramIterable)
    {
      copyOnWrite();
      ((Status)this.instance).addAllDetails(paramIterable);
      return this;
    }
    
    public Builder addDetails(int paramInt, Any.Builder paramBuilder)
    {
      copyOnWrite();
      ((Status)this.instance).addDetails(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addDetails(int paramInt, Any paramAny)
    {
      copyOnWrite();
      ((Status)this.instance).addDetails(paramInt, paramAny);
      return this;
    }
    
    public Builder addDetails(Any.Builder paramBuilder)
    {
      copyOnWrite();
      ((Status)this.instance).addDetails(paramBuilder);
      return this;
    }
    
    public Builder addDetails(Any paramAny)
    {
      copyOnWrite();
      ((Status)this.instance).addDetails(paramAny);
      return this;
    }
    
    public Builder clearCode()
    {
      copyOnWrite();
      ((Status)this.instance).clearCode();
      return this;
    }
    
    public Builder clearDetails()
    {
      copyOnWrite();
      ((Status)this.instance).clearDetails();
      return this;
    }
    
    public Builder clearMessage()
    {
      copyOnWrite();
      ((Status)this.instance).clearMessage();
      return this;
    }
    
    public int getCode()
    {
      return ((Status)this.instance).getCode();
    }
    
    public Any getDetails(int paramInt)
    {
      return ((Status)this.instance).getDetails(paramInt);
    }
    
    public int getDetailsCount()
    {
      return ((Status)this.instance).getDetailsCount();
    }
    
    public List<Any> getDetailsList()
    {
      return Collections.unmodifiableList(((Status)this.instance).getDetailsList());
    }
    
    public String getMessage()
    {
      return ((Status)this.instance).getMessage();
    }
    
    public ByteString getMessageBytes()
    {
      return ((Status)this.instance).getMessageBytes();
    }
    
    public Builder removeDetails(int paramInt)
    {
      copyOnWrite();
      ((Status)this.instance).removeDetails(paramInt);
      return this;
    }
    
    public Builder setCode(int paramInt)
    {
      copyOnWrite();
      ((Status)this.instance).setCode(paramInt);
      return this;
    }
    
    public Builder setDetails(int paramInt, Any.Builder paramBuilder)
    {
      copyOnWrite();
      ((Status)this.instance).setDetails(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setDetails(int paramInt, Any paramAny)
    {
      copyOnWrite();
      ((Status)this.instance).setDetails(paramInt, paramAny);
      return this;
    }
    
    public Builder setMessage(String paramString)
    {
      copyOnWrite();
      ((Status)this.instance).setMessage(paramString);
      return this;
    }
    
    public Builder setMessageBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Status)this.instance).setMessageBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/rpc/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */