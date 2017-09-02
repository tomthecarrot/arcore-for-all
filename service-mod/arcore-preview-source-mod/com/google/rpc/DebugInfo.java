package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class DebugInfo
  extends GeneratedMessageLite<DebugInfo, Builder>
  implements DebugInfoOrBuilder
{
  private static final DebugInfo DEFAULT_INSTANCE = new DebugInfo();
  public static final int DETAIL_FIELD_NUMBER = 2;
  private static volatile Parser<DebugInfo> PARSER;
  public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
  private int bitField0_;
  private String detail_ = "";
  private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllStackEntries(Iterable<String> paramIterable)
  {
    ensureStackEntriesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.stackEntries_);
  }
  
  private void addStackEntries(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureStackEntriesIsMutable();
    this.stackEntries_.add(paramString);
  }
  
  private void addStackEntriesBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    ensureStackEntriesIsMutable();
    this.stackEntries_.add(paramByteString.toStringUtf8());
  }
  
  private void clearDetail()
  {
    this.detail_ = getDefaultInstance().getDetail();
  }
  
  private void clearStackEntries()
  {
    this.stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensureStackEntriesIsMutable()
  {
    if (!this.stackEntries_.isModifiable()) {
      this.stackEntries_ = GeneratedMessageLite.mutableCopy(this.stackEntries_);
    }
  }
  
  public static DebugInfo getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DebugInfo paramDebugInfo)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDebugInfo);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<DebugInfo> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDetail(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.detail_ = paramString;
  }
  
  private void setDetailBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.detail_ = paramByteString.toStringUtf8();
  }
  
  private void setStackEntries(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureStackEntriesIsMutable();
    this.stackEntries_.set(paramInt, paramString);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 206	com/google/rpc/DebugInfo$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 212	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+204->212, 7:+373->381, 8:+377->385
    //   56: new 214	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 215	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/rpc/DebugInfo
    //   67: dup
    //   68: invokespecial 33	com/google/rpc/DebugInfo:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 35	com/google/rpc/DebugInfo:DEFAULT_INSTANCE	Lcom/google/rpc/DebugInfo;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 216 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/rpc/DebugInfo$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 219	com/google/rpc/DebugInfo$Builder:<init>	(Lcom/google/rpc/DebugInfo$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 221	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/rpc/DebugInfo
    //   107: astore_3
    //   108: aload_0
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   114: aload_3
    //   115: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 225 3 0
    //   123: putfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   126: aload_0
    //   127: getfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   130: invokevirtual 230	java/lang/String:isEmpty	()Z
    //   133: ifne +67 -> 200
    //   136: iconst_1
    //   137: istore 6
    //   139: aload_0
    //   140: getfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   143: astore_1
    //   144: aload_3
    //   145: getfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   148: invokevirtual 230	java/lang/String:isEmpty	()Z
    //   151: ifne +55 -> 206
    //   154: iconst_1
    //   155: istore 7
    //   157: aload_0
    //   158: aload_2
    //   159: iload 6
    //   161: aload_1
    //   162: iload 7
    //   164: aload_3
    //   165: getfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   168: invokeinterface 234 5 0
    //   173: putfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   176: aload_0
    //   177: astore_1
    //   178: aload_2
    //   179: getstatic 240	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   182: if_acmpne -110 -> 72
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 242	com/google/rpc/DebugInfo:bitField0_	I
    //   190: aload_3
    //   191: getfield 242	com/google/rpc/DebugInfo:bitField0_	I
    //   194: ior
    //   195: putfield 242	com/google/rpc/DebugInfo:bitField0_	I
    //   198: aload_0
    //   199: areturn
    //   200: iconst_0
    //   201: istore 6
    //   203: goto -64 -> 139
    //   206: iconst_0
    //   207: istore 7
    //   209: goto -52 -> 157
    //   212: aload_2
    //   213: checkcast 244	com/google/protobuf/CodedInputStream
    //   216: astore_1
    //   217: aload_3
    //   218: checkcast 246	com/google/protobuf/ExtensionRegistryLite
    //   221: astore_2
    //   222: iconst_0
    //   223: istore 4
    //   225: iload 4
    //   227: ifne +154 -> 381
    //   230: aload_1
    //   231: invokevirtual 249	com/google/protobuf/CodedInputStream:readTag	()I
    //   234: istore 5
    //   236: iload 5
    //   238: lookupswitch	default:+188->426, 0:+191->429, 10:+49->287, 18:+108->346
    //   272: aload_1
    //   273: iload 5
    //   275: invokevirtual 253	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   278: ifne -53 -> 225
    //   281: iconst_1
    //   282: istore 4
    //   284: goto -59 -> 225
    //   287: aload_1
    //   288: invokevirtual 256	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   291: astore_2
    //   292: aload_0
    //   293: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   296: invokeinterface 132 1 0
    //   301: ifne +14 -> 315
    //   304: aload_0
    //   305: aload_0
    //   306: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   309: invokestatic 136	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   312: putfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   315: aload_0
    //   316: getfield 46	com/google/rpc/DebugInfo:stackEntries_	Lcom/google/protobuf/Internal$ProtobufList;
    //   319: aload_2
    //   320: invokeinterface 113 2 0
    //   325: pop
    //   326: goto -101 -> 225
    //   329: astore_1
    //   330: new 258	java/lang/RuntimeException
    //   333: dup
    //   334: aload_1
    //   335: aload_0
    //   336: invokevirtual 262	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   339: invokespecial 265	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   342: athrow
    //   343: astore_1
    //   344: aload_1
    //   345: athrow
    //   346: aload_0
    //   347: aload_1
    //   348: invokevirtual 256	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   351: putfield 50	com/google/rpc/DebugInfo:detail_	Ljava/lang/String;
    //   354: goto -129 -> 225
    //   357: astore_1
    //   358: new 258	java/lang/RuntimeException
    //   361: dup
    //   362: new 163	com/google/protobuf/InvalidProtocolBufferException
    //   365: dup
    //   366: aload_1
    //   367: invokevirtual 268	java/io/IOException:getMessage	()Ljava/lang/String;
    //   370: invokespecial 270	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   373: aload_0
    //   374: invokevirtual 262	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   377: invokespecial 265	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   380: athrow
    //   381: getstatic 35	com/google/rpc/DebugInfo:DEFAULT_INSTANCE	Lcom/google/rpc/DebugInfo;
    //   384: areturn
    //   385: getstatic 272	com/google/rpc/DebugInfo:PARSER	Lcom/google/protobuf/Parser;
    //   388: ifnonnull +28 -> 416
    //   391: ldc 2
    //   393: monitorenter
    //   394: getstatic 272	com/google/rpc/DebugInfo:PARSER	Lcom/google/protobuf/Parser;
    //   397: ifnonnull +16 -> 413
    //   400: new 274	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   403: dup
    //   404: getstatic 35	com/google/rpc/DebugInfo:DEFAULT_INSTANCE	Lcom/google/rpc/DebugInfo;
    //   407: invokespecial 277	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   410: putstatic 272	com/google/rpc/DebugInfo:PARSER	Lcom/google/protobuf/Parser;
    //   413: ldc 2
    //   415: monitorexit
    //   416: getstatic 272	com/google/rpc/DebugInfo:PARSER	Lcom/google/protobuf/Parser;
    //   419: areturn
    //   420: astore_1
    //   421: ldc 2
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: goto -154 -> 272
    //   429: iconst_1
    //   430: istore 4
    //   432: goto -207 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	DebugInfo
    //   0	435	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	435	2	paramObject1	Object
    //   0	435	3	paramObject2	Object
    //   223	208	4	i	int
    //   234	40	5	j	int
    //   137	65	6	bool1	boolean
    //   155	53	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   230	236	329	com/google/protobuf/InvalidProtocolBufferException
    //   272	281	329	com/google/protobuf/InvalidProtocolBufferException
    //   287	315	329	com/google/protobuf/InvalidProtocolBufferException
    //   315	326	329	com/google/protobuf/InvalidProtocolBufferException
    //   346	354	329	com/google/protobuf/InvalidProtocolBufferException
    //   230	236	343	finally
    //   272	281	343	finally
    //   287	315	343	finally
    //   315	326	343	finally
    //   330	343	343	finally
    //   346	354	343	finally
    //   358	381	343	finally
    //   230	236	357	java/io/IOException
    //   272	281	357	java/io/IOException
    //   287	315	357	java/io/IOException
    //   315	326	357	java/io/IOException
    //   346	354	357	java/io/IOException
    //   394	413	420	finally
    //   413	416	420	finally
    //   421	424	420	finally
  }
  
  public String getDetail()
  {
    return this.detail_;
  }
  
  public ByteString getDetailBytes()
  {
    return ByteString.copyFromUtf8(this.detail_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (i < this.stackEntries_.size())
    {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.stackEntries_.get(i));
      i += 1;
    }
    j = 0 + j + getStackEntriesList().size() * 1;
    i = j;
    if (!this.detail_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(2, getDetail());
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getStackEntries(int paramInt)
  {
    return (String)this.stackEntries_.get(paramInt);
  }
  
  public ByteString getStackEntriesBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.stackEntries_.get(paramInt));
  }
  
  public int getStackEntriesCount()
  {
    return this.stackEntries_.size();
  }
  
  public List<String> getStackEntriesList()
  {
    return this.stackEntries_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.stackEntries_.size())
    {
      paramCodedOutputStream.writeString(1, (String)this.stackEntries_.get(i));
      i += 1;
    }
    if (!this.detail_.isEmpty()) {
      paramCodedOutputStream.writeString(2, getDetail());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<DebugInfo, Builder>
    implements DebugInfoOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllStackEntries(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).addAllStackEntries(paramIterable);
      return this;
    }
    
    public Builder addStackEntries(String paramString)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntries(paramString);
      return this;
    }
    
    public Builder addStackEntriesBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntriesBytes(paramByteString);
      return this;
    }
    
    public Builder clearDetail()
    {
      copyOnWrite();
      ((DebugInfo)this.instance).clearDetail();
      return this;
    }
    
    public Builder clearStackEntries()
    {
      copyOnWrite();
      ((DebugInfo)this.instance).clearStackEntries();
      return this;
    }
    
    public String getDetail()
    {
      return ((DebugInfo)this.instance).getDetail();
    }
    
    public ByteString getDetailBytes()
    {
      return ((DebugInfo)this.instance).getDetailBytes();
    }
    
    public String getStackEntries(int paramInt)
    {
      return ((DebugInfo)this.instance).getStackEntries(paramInt);
    }
    
    public ByteString getStackEntriesBytes(int paramInt)
    {
      return ((DebugInfo)this.instance).getStackEntriesBytes(paramInt);
    }
    
    public int getStackEntriesCount()
    {
      return ((DebugInfo)this.instance).getStackEntriesCount();
    }
    
    public List<String> getStackEntriesList()
    {
      return Collections.unmodifiableList(((DebugInfo)this.instance).getStackEntriesList());
    }
    
    public Builder setDetail(String paramString)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetail(paramString);
      return this;
    }
    
    public Builder setDetailBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetailBytes(paramByteString);
      return this;
    }
    
    public Builder setStackEntries(int paramInt, String paramString)
    {
      copyOnWrite();
      ((DebugInfo)this.instance).setStackEntries(paramInt, paramString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/rpc/DebugInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */