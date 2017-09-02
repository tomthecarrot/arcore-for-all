package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Mixin
  extends GeneratedMessageLite<Mixin, Builder>
  implements MixinOrBuilder
{
  private static final Mixin DEFAULT_INSTANCE = new Mixin();
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<Mixin> PARSER;
  public static final int ROOT_FIELD_NUMBER = 2;
  private String name_ = "";
  private String root_ = "";
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName()
  {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearRoot()
  {
    this.root_ = getDefaultInstance().getRoot();
  }
  
  public static Mixin getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Mixin paramMixin)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMixin);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Mixin)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Mixin)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Mixin parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Mixin)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Mixin> parser()
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
  
  private void setRoot(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.root_ = paramString;
  }
  
  private void setRootBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.root_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 162	com/google/protobuf/Mixin$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 168	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+226->234, 7:+366->374, 8:+370->378
    //   56: new 170	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 171	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Mixin
    //   67: dup
    //   68: invokespecial 30	com/google/protobuf/Mixin:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 32	com/google/protobuf/Mixin:DEFAULT_INSTANCE	Lcom/google/protobuf/Mixin;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/Mixin$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 174	com/google/protobuf/Mixin$Builder:<init>	(Lcom/google/protobuf/Mixin$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 176	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/Mixin
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   103: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   106: ifne +104 -> 210
    //   109: iconst_1
    //   110: istore 6
    //   112: aload_0
    //   113: getfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   116: astore_3
    //   117: aload_1
    //   118: getfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   121: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   124: ifne +92 -> 216
    //   127: iconst_1
    //   128: istore 7
    //   130: aload_0
    //   131: aload_2
    //   132: iload 6
    //   134: aload_3
    //   135: iload 7
    //   137: aload_1
    //   138: getfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   141: invokeinterface 186 5 0
    //   146: putfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   153: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   156: ifne +66 -> 222
    //   159: iconst_1
    //   160: istore 6
    //   162: aload_0
    //   163: getfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   166: astore_3
    //   167: aload_1
    //   168: getfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   171: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   174: ifne +54 -> 228
    //   177: iconst_1
    //   178: istore 7
    //   180: aload_0
    //   181: aload_2
    //   182: iload 6
    //   184: aload_3
    //   185: iload 7
    //   187: aload_1
    //   188: getfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   191: invokeinterface 186 5 0
    //   196: putfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   199: aload_0
    //   200: astore_1
    //   201: aload_2
    //   202: getstatic 192	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
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
    //   235: checkcast 194	com/google/protobuf/CodedInputStream
    //   238: astore_1
    //   239: aload_3
    //   240: checkcast 196	com/google/protobuf/ExtensionRegistryLite
    //   243: astore_2
    //   244: iconst_0
    //   245: istore 4
    //   247: iload 4
    //   249: ifne +125 -> 374
    //   252: aload_1
    //   253: invokevirtual 199	com/google/protobuf/CodedInputStream:readTag	()I
    //   256: istore 5
    //   258: iload 5
    //   260: lookupswitch	default:+159->419, 0:+162->422, 10:+51->311, 18:+79->339
    //   296: aload_1
    //   297: iload 5
    //   299: invokevirtual 203	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   302: ifne -55 -> 247
    //   305: iconst_1
    //   306: istore 4
    //   308: goto -61 -> 247
    //   311: aload_0
    //   312: aload_1
    //   313: invokevirtual 206	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   316: putfield 41	com/google/protobuf/Mixin:name_	Ljava/lang/String;
    //   319: goto -72 -> 247
    //   322: astore_1
    //   323: new 208	java/lang/RuntimeException
    //   326: dup
    //   327: aload_1
    //   328: aload_0
    //   329: invokevirtual 212	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   332: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   335: athrow
    //   336: astore_1
    //   337: aload_1
    //   338: athrow
    //   339: aload_0
    //   340: aload_1
    //   341: invokevirtual 206	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   344: putfield 43	com/google/protobuf/Mixin:root_	Ljava/lang/String;
    //   347: goto -100 -> 247
    //   350: astore_1
    //   351: new 208	java/lang/RuntimeException
    //   354: dup
    //   355: new 111	com/google/protobuf/InvalidProtocolBufferException
    //   358: dup
    //   359: aload_1
    //   360: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: invokespecial 220	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 212	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   370: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   373: athrow
    //   374: getstatic 32	com/google/protobuf/Mixin:DEFAULT_INSTANCE	Lcom/google/protobuf/Mixin;
    //   377: areturn
    //   378: getstatic 222	com/google/protobuf/Mixin:PARSER	Lcom/google/protobuf/Parser;
    //   381: ifnonnull +28 -> 409
    //   384: ldc 2
    //   386: monitorenter
    //   387: getstatic 222	com/google/protobuf/Mixin:PARSER	Lcom/google/protobuf/Parser;
    //   390: ifnonnull +16 -> 406
    //   393: new 224	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   396: dup
    //   397: getstatic 32	com/google/protobuf/Mixin:DEFAULT_INSTANCE	Lcom/google/protobuf/Mixin;
    //   400: invokespecial 227	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   403: putstatic 222	com/google/protobuf/Mixin:PARSER	Lcom/google/protobuf/Parser;
    //   406: ldc 2
    //   408: monitorexit
    //   409: getstatic 222	com/google/protobuf/Mixin:PARSER	Lcom/google/protobuf/Parser;
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
    //   0	428	0	this	Mixin
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
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getRoot()
  {
    return this.root_;
  }
  
  public ByteString getRootBytes()
  {
    return ByteString.copyFromUtf8(this.root_);
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
    if (!this.root_.isEmpty()) {
      j = i + CodedOutputStream.computeStringSize(2, getRoot());
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
    if (!this.root_.isEmpty()) {
      paramCodedOutputStream.writeString(2, getRoot());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Mixin, Builder>
    implements MixinOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Mixin)this.instance).clearName();
      return this;
    }
    
    public Builder clearRoot()
    {
      copyOnWrite();
      ((Mixin)this.instance).clearRoot();
      return this;
    }
    
    public String getName()
    {
      return ((Mixin)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Mixin)this.instance).getNameBytes();
    }
    
    public String getRoot()
    {
      return ((Mixin)this.instance).getRoot();
    }
    
    public ByteString getRootBytes()
    {
      return ((Mixin)this.instance).getRootBytes();
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Mixin)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Mixin)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setRoot(String paramString)
    {
      copyOnWrite();
      ((Mixin)this.instance).setRoot(paramString);
      return this;
    }
    
    public Builder setRootBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Mixin)this.instance).setRootBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Mixin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */