package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class FieldMask
  extends GeneratedMessageLite<FieldMask, Builder>
  implements FieldMaskOrBuilder
{
  private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
  private static volatile Parser<FieldMask> PARSER;
  public static final int PATHS_FIELD_NUMBER = 1;
  private Internal.ProtobufList<String> paths_ = GeneratedMessageLite.emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllPaths(Iterable<String> paramIterable)
  {
    ensurePathsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.paths_);
  }
  
  private void addPaths(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensurePathsIsMutable();
    this.paths_.add(paramString);
  }
  
  private void addPathsBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    ensurePathsIsMutable();
    this.paths_.add(paramByteString.toStringUtf8());
  }
  
  private void clearPaths()
  {
    this.paths_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensurePathsIsMutable()
  {
    if (!this.paths_.isModifiable()) {
      this.paths_ = GeneratedMessageLite.mutableCopy(this.paths_);
    }
  }
  
  public static FieldMask getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FieldMask paramFieldMask)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFieldMask);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FieldMask)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldMask> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setPaths(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensurePathsIsMutable();
    this.paths_.set(paramInt, paramString);
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 180	com/google/protobuf/FieldMask$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 186	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+278->286, 8:+282->290
    //   56: new 188	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 189	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/FieldMask
    //   67: dup
    //   68: invokespecial 28	com/google/protobuf/FieldMask:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 30	com/google/protobuf/FieldMask:DEFAULT_INSTANCE	Lcom/google/protobuf/FieldMask;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 190 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/protobuf/FieldMask$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 193	com/google/protobuf/FieldMask$Builder:<init>	(Lcom/google/protobuf/FieldMask$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 195	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/protobuf/FieldMask
    //   107: astore_1
    //   108: aload_0
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   114: aload_1
    //   115: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 199 3 0
    //   123: putfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: getstatic 205	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   132: if_acmpne -60 -> 72
    //   135: aload_0
    //   136: areturn
    //   137: aload_2
    //   138: checkcast 207	com/google/protobuf/CodedInputStream
    //   141: astore_1
    //   142: aload_3
    //   143: checkcast 209	com/google/protobuf/ExtensionRegistryLite
    //   146: astore_2
    //   147: iconst_0
    //   148: istore 4
    //   150: iload 4
    //   152: ifne +134 -> 286
    //   155: aload_1
    //   156: invokevirtual 212	com/google/protobuf/CodedInputStream:readTag	()I
    //   159: istore 5
    //   161: iload 5
    //   163: lookupswitch	default:+168->331, 0:+171->334, 10:+40->203
    //   188: aload_1
    //   189: iload 5
    //   191: invokevirtual 216	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   194: ifne -44 -> 150
    //   197: iconst_1
    //   198: istore 4
    //   200: goto -50 -> 150
    //   203: aload_1
    //   204: invokevirtual 219	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   212: invokeinterface 105 1 0
    //   217: ifne +14 -> 231
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   225: invokestatic 109	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   228: putfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   231: aload_0
    //   232: getfield 41	com/google/protobuf/FieldMask:paths_	Lcom/google/protobuf/Internal$ProtobufList;
    //   235: aload_2
    //   236: invokeinterface 92 2 0
    //   241: pop
    //   242: goto -92 -> 150
    //   245: astore_1
    //   246: new 221	java/lang/RuntimeException
    //   249: dup
    //   250: aload_1
    //   251: aload_0
    //   252: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   255: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: new 221	java/lang/RuntimeException
    //   266: dup
    //   267: new 137	com/google/protobuf/InvalidProtocolBufferException
    //   270: dup
    //   271: aload_1
    //   272: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   275: invokespecial 233	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   282: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   285: athrow
    //   286: getstatic 30	com/google/protobuf/FieldMask:DEFAULT_INSTANCE	Lcom/google/protobuf/FieldMask;
    //   289: areturn
    //   290: getstatic 235	com/google/protobuf/FieldMask:PARSER	Lcom/google/protobuf/Parser;
    //   293: ifnonnull +28 -> 321
    //   296: ldc 2
    //   298: monitorenter
    //   299: getstatic 235	com/google/protobuf/FieldMask:PARSER	Lcom/google/protobuf/Parser;
    //   302: ifnonnull +16 -> 318
    //   305: new 237	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   308: dup
    //   309: getstatic 30	com/google/protobuf/FieldMask:DEFAULT_INSTANCE	Lcom/google/protobuf/FieldMask;
    //   312: invokespecial 240	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   315: putstatic 235	com/google/protobuf/FieldMask:PARSER	Lcom/google/protobuf/Parser;
    //   318: ldc 2
    //   320: monitorexit
    //   321: getstatic 235	com/google/protobuf/FieldMask:PARSER	Lcom/google/protobuf/Parser;
    //   324: areturn
    //   325: astore_1
    //   326: ldc 2
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    //   331: goto -143 -> 188
    //   334: iconst_1
    //   335: istore 4
    //   337: goto -187 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	FieldMask
    //   0	340	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	340	2	paramObject1	Object
    //   0	340	3	paramObject2	Object
    //   148	188	4	i	int
    //   159	31	5	j	int
    // Exception table:
    //   from	to	target	type
    //   155	161	245	com/google/protobuf/InvalidProtocolBufferException
    //   188	197	245	com/google/protobuf/InvalidProtocolBufferException
    //   203	231	245	com/google/protobuf/InvalidProtocolBufferException
    //   231	242	245	com/google/protobuf/InvalidProtocolBufferException
    //   155	161	259	finally
    //   188	197	259	finally
    //   203	231	259	finally
    //   231	242	259	finally
    //   246	259	259	finally
    //   263	286	259	finally
    //   155	161	262	java/io/IOException
    //   188	197	262	java/io/IOException
    //   203	231	262	java/io/IOException
    //   231	242	262	java/io/IOException
    //   299	318	325	finally
    //   318	321	325	finally
    //   326	329	325	finally
  }
  
  public String getPaths(int paramInt)
  {
    return (String)this.paths_.get(paramInt);
  }
  
  public ByteString getPathsBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.paths_.get(paramInt));
  }
  
  public int getPathsCount()
  {
    return this.paths_.size();
  }
  
  public List<String> getPathsList()
  {
    return this.paths_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (i < this.paths_.size())
    {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.paths_.get(i));
      i += 1;
    }
    i = 0 + j + getPathsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.paths_.size())
    {
      paramCodedOutputStream.writeString(1, (String)this.paths_.get(i));
      i += 1;
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<FieldMask, Builder>
    implements FieldMaskOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllPaths(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((FieldMask)this.instance).addAllPaths(paramIterable);
      return this;
    }
    
    public Builder addPaths(String paramString)
    {
      copyOnWrite();
      ((FieldMask)this.instance).addPaths(paramString);
      return this;
    }
    
    public Builder addPathsBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((FieldMask)this.instance).addPathsBytes(paramByteString);
      return this;
    }
    
    public Builder clearPaths()
    {
      copyOnWrite();
      ((FieldMask)this.instance).clearPaths();
      return this;
    }
    
    public String getPaths(int paramInt)
    {
      return ((FieldMask)this.instance).getPaths(paramInt);
    }
    
    public ByteString getPathsBytes(int paramInt)
    {
      return ((FieldMask)this.instance).getPathsBytes(paramInt);
    }
    
    public int getPathsCount()
    {
      return ((FieldMask)this.instance).getPathsCount();
    }
    
    public List<String> getPathsList()
    {
      return Collections.unmodifiableList(((FieldMask)this.instance).getPathsList());
    }
    
    public Builder setPaths(int paramInt, String paramString)
    {
      copyOnWrite();
      ((FieldMask)this.instance).setPaths(paramInt, paramString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FieldMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */