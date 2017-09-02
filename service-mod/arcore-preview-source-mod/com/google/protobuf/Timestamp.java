package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Timestamp
  extends GeneratedMessageLite<Timestamp, Builder>
  implements TimestampOrBuilder
{
  private static final Timestamp DEFAULT_INSTANCE = new Timestamp();
  public static final int NANOS_FIELD_NUMBER = 2;
  private static volatile Parser<Timestamp> PARSER;
  public static final int SECONDS_FIELD_NUMBER = 1;
  private int nanos_;
  private long seconds_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearNanos()
  {
    this.nanos_ = 0;
  }
  
  private void clearSeconds()
  {
    this.seconds_ = 0L;
  }
  
  public static Timestamp getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Timestamp paramTimestamp)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTimestamp);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Timestamp)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Timestamp)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Timestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Timestamp> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setNanos(int paramInt)
  {
    this.nanos_ = paramInt;
  }
  
  private void setSeconds(long paramLong)
  {
    this.seconds_ = paramLong;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 132	com/google/protobuf/Timestamp$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 138	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+222->230, 7:+362->370, 8:+366->374
    //   56: new 140	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 141	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Timestamp
    //   67: dup
    //   68: invokespecial 30	com/google/protobuf/Timestamp:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 32	com/google/protobuf/Timestamp:DEFAULT_INSTANCE	Lcom/google/protobuf/Timestamp;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/Timestamp$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 144	com/google/protobuf/Timestamp$Builder:<init>	(Lcom/google/protobuf/Timestamp$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 146	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/Timestamp
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   103: lconst_0
    //   104: lcmp
    //   105: ifeq +101 -> 206
    //   108: iconst_1
    //   109: istore 6
    //   111: aload_0
    //   112: getfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   115: lstore 8
    //   117: aload_1
    //   118: getfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   121: lconst_0
    //   122: lcmp
    //   123: ifeq +89 -> 212
    //   126: iconst_1
    //   127: istore 7
    //   129: aload_0
    //   130: aload_2
    //   131: iload 6
    //   133: lload 8
    //   135: iload 7
    //   137: aload_1
    //   138: getfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   141: invokeinterface 150 7 0
    //   146: putfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   149: aload_0
    //   150: getfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   153: ifeq +65 -> 218
    //   156: iconst_1
    //   157: istore 6
    //   159: aload_0
    //   160: getfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   163: istore 4
    //   165: aload_1
    //   166: getfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   169: ifeq +55 -> 224
    //   172: iconst_1
    //   173: istore 7
    //   175: aload_0
    //   176: aload_2
    //   177: iload 6
    //   179: iload 4
    //   181: iload 7
    //   183: aload_1
    //   184: getfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   187: invokeinterface 154 5 0
    //   192: putfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   195: aload_0
    //   196: astore_1
    //   197: aload_2
    //   198: getstatic 160	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   201: if_acmpne -129 -> 72
    //   204: aload_0
    //   205: areturn
    //   206: iconst_0
    //   207: istore 6
    //   209: goto -98 -> 111
    //   212: iconst_0
    //   213: istore 7
    //   215: goto -86 -> 129
    //   218: iconst_0
    //   219: istore 6
    //   221: goto -62 -> 159
    //   224: iconst_0
    //   225: istore 7
    //   227: goto -52 -> 175
    //   230: aload_2
    //   231: checkcast 162	com/google/protobuf/CodedInputStream
    //   234: astore_1
    //   235: aload_3
    //   236: checkcast 164	com/google/protobuf/ExtensionRegistryLite
    //   239: astore_2
    //   240: iconst_0
    //   241: istore 4
    //   243: iload 4
    //   245: ifne +125 -> 370
    //   248: aload_1
    //   249: invokevirtual 167	com/google/protobuf/CodedInputStream:readTag	()I
    //   252: istore 5
    //   254: iload 5
    //   256: lookupswitch	default:+159->415, 0:+162->418, 8:+51->307, 16:+79->335
    //   292: aload_1
    //   293: iload 5
    //   295: invokevirtual 171	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   298: ifne -55 -> 243
    //   301: iconst_1
    //   302: istore 4
    //   304: goto -61 -> 243
    //   307: aload_0
    //   308: aload_1
    //   309: invokevirtual 175	com/google/protobuf/CodedInputStream:readInt64	()J
    //   312: putfield 64	com/google/protobuf/Timestamp:seconds_	J
    //   315: goto -72 -> 243
    //   318: astore_1
    //   319: new 177	java/lang/RuntimeException
    //   322: dup
    //   323: aload_1
    //   324: aload_0
    //   325: invokevirtual 181	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   328: invokespecial 184	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   331: athrow
    //   332: astore_1
    //   333: aload_1
    //   334: athrow
    //   335: aload_0
    //   336: aload_1
    //   337: invokevirtual 187	com/google/protobuf/CodedInputStream:readInt32	()I
    //   340: putfield 62	com/google/protobuf/Timestamp:nanos_	I
    //   343: goto -100 -> 243
    //   346: astore_1
    //   347: new 177	java/lang/RuntimeException
    //   350: dup
    //   351: new 92	com/google/protobuf/InvalidProtocolBufferException
    //   354: dup
    //   355: aload_1
    //   356: invokevirtual 191	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokespecial 194	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   362: aload_0
    //   363: invokevirtual 181	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   366: invokespecial 184	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   369: athrow
    //   370: getstatic 32	com/google/protobuf/Timestamp:DEFAULT_INSTANCE	Lcom/google/protobuf/Timestamp;
    //   373: areturn
    //   374: getstatic 196	com/google/protobuf/Timestamp:PARSER	Lcom/google/protobuf/Parser;
    //   377: ifnonnull +28 -> 405
    //   380: ldc 2
    //   382: monitorenter
    //   383: getstatic 196	com/google/protobuf/Timestamp:PARSER	Lcom/google/protobuf/Parser;
    //   386: ifnonnull +16 -> 402
    //   389: new 198	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   392: dup
    //   393: getstatic 32	com/google/protobuf/Timestamp:DEFAULT_INSTANCE	Lcom/google/protobuf/Timestamp;
    //   396: invokespecial 201	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   399: putstatic 196	com/google/protobuf/Timestamp:PARSER	Lcom/google/protobuf/Parser;
    //   402: ldc 2
    //   404: monitorexit
    //   405: getstatic 196	com/google/protobuf/Timestamp:PARSER	Lcom/google/protobuf/Parser;
    //   408: areturn
    //   409: astore_1
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_1
    //   414: athrow
    //   415: goto -123 -> 292
    //   418: iconst_1
    //   419: istore 4
    //   421: goto -178 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	Timestamp
    //   0	424	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	424	2	paramObject1	Object
    //   0	424	3	paramObject2	Object
    //   163	257	4	i	int
    //   252	42	5	j	int
    //   109	111	6	bool1	boolean
    //   127	99	7	bool2	boolean
    //   115	19	8	l	long
    // Exception table:
    //   from	to	target	type
    //   248	254	318	com/google/protobuf/InvalidProtocolBufferException
    //   292	301	318	com/google/protobuf/InvalidProtocolBufferException
    //   307	315	318	com/google/protobuf/InvalidProtocolBufferException
    //   335	343	318	com/google/protobuf/InvalidProtocolBufferException
    //   248	254	332	finally
    //   292	301	332	finally
    //   307	315	332	finally
    //   319	332	332	finally
    //   335	343	332	finally
    //   347	370	332	finally
    //   248	254	346	java/io/IOException
    //   292	301	346	java/io/IOException
    //   307	315	346	java/io/IOException
    //   335	343	346	java/io/IOException
    //   383	402	409	finally
    //   402	405	409	finally
    //   410	413	409	finally
  }
  
  public int getNanos()
  {
    return this.nanos_;
  }
  
  public long getSeconds()
  {
    return this.seconds_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (this.seconds_ != 0L) {
      i = 0 + CodedOutputStream.computeInt64Size(1, this.seconds_);
    }
    int j = i;
    if (this.nanos_ != 0) {
      j = i + CodedOutputStream.computeInt32Size(2, this.nanos_);
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.seconds_ != 0L) {
      paramCodedOutputStream.writeInt64(1, this.seconds_);
    }
    if (this.nanos_ != 0) {
      paramCodedOutputStream.writeInt32(2, this.nanos_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Timestamp, Builder>
    implements TimestampOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearNanos()
    {
      copyOnWrite();
      ((Timestamp)this.instance).clearNanos();
      return this;
    }
    
    public Builder clearSeconds()
    {
      copyOnWrite();
      ((Timestamp)this.instance).clearSeconds();
      return this;
    }
    
    public int getNanos()
    {
      return ((Timestamp)this.instance).getNanos();
    }
    
    public long getSeconds()
    {
      return ((Timestamp)this.instance).getSeconds();
    }
    
    public Builder setNanos(int paramInt)
    {
      copyOnWrite();
      ((Timestamp)this.instance).setNanos(paramInt);
      return this;
    }
    
    public Builder setSeconds(long paramLong)
    {
      copyOnWrite();
      ((Timestamp)this.instance).setSeconds(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Timestamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */