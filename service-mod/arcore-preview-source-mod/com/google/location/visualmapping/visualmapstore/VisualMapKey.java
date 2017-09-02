package com.google.location.visualmapping.visualmapstore;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class VisualMapKey
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class AdfClusterNavigationGraphKeyProto
    extends GeneratedMessageLite<AdfClusterNavigationGraphKeyProto, Builder>
    implements VisualMapKey.AdfClusterNavigationGraphKeyProtoOrBuilder
  {
    private static final AdfClusterNavigationGraphKeyProto DEFAULT_INSTANCE = new AdfClusterNavigationGraphKeyProto();
    private static volatile Parser<AdfClusterNavigationGraphKeyProto> PARSER;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String uuid_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearUuid()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.uuid_ = getDefaultInstance().getUuid();
    }
    
    public static AdfClusterNavigationGraphKeyProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AdfClusterNavigationGraphKeyProto paramAdfClusterNavigationGraphKeyProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAdfClusterNavigationGraphKeyProto);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static AdfClusterNavigationGraphKeyProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AdfClusterNavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<AdfClusterNavigationGraphKeyProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setUuid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramString;
    }
    
    private void setUuidBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 145	com/google/location/visualmapping/visualmapstore/VisualMapKey$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 151	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+272->280, 8:+276->284
      //   56: new 153	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 154	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 157	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 159	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:hasUuid	()Z
      //   105: aload_0
      //   106: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:hasUuid	()Z
      //   113: aload_3
      //   114: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   117: invokeinterface 167 5 0
      //   122: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 173	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:bitField0_	I
      //   139: aload_3
      //   140: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:bitField0_	I
      //   143: ior
      //   144: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 175	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 177	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +116 -> 280
      //   167: aload_1
      //   168: invokevirtual 180	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+150->325, 0:+153->328, 10:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 184	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_1
      //   217: invokevirtual 187	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   220: astore_2
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:bitField0_	I
      //   226: iconst_1
      //   227: ior
      //   228: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:bitField0_	I
      //   231: aload_0
      //   232: aload_2
      //   233: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   236: goto -74 -> 162
      //   239: astore_1
      //   240: new 189	java/lang/RuntimeException
      //   243: dup
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   252: athrow
      //   253: astore_1
      //   254: aload_1
      //   255: athrow
      //   256: astore_1
      //   257: new 189	java/lang/RuntimeException
      //   260: dup
      //   261: new 95	com/google/protobuf/InvalidProtocolBufferException
      //   264: dup
      //   265: aload_1
      //   266: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
      //   269: invokespecial 201	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   272: aload_0
      //   273: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   276: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   279: athrow
      //   280: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto;
      //   283: areturn
      //   284: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   287: ifnonnull +28 -> 315
      //   290: ldc 2
      //   292: monitorenter
      //   293: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +16 -> 312
      //   299: new 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   302: dup
      //   303: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto;
      //   306: invokespecial 208	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   309: putstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   312: ldc 2
      //   314: monitorexit
      //   315: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfClusterNavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   318: areturn
      //   319: astore_1
      //   320: ldc 2
      //   322: monitorexit
      //   323: aload_1
      //   324: athrow
      //   325: goto -125 -> 200
      //   328: iconst_1
      //   329: istore 4
      //   331: goto -169 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	334	0	this	AdfClusterNavigationGraphKeyProto
      //   0	334	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	334	2	paramObject1	Object
      //   0	334	3	paramObject2	Object
      //   160	170	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	239	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	239	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	239	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	253	finally
      //   200	210	253	finally
      //   216	236	253	finally
      //   240	253	253	finally
      //   257	280	253	finally
      //   167	173	256	java/io/IOException
      //   200	210	256	java/io/IOException
      //   216	236	256	java/io/IOException
      //   293	312	319	finally
      //   312	315	319	finally
      //   320	323	319	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getUuid());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getUuid()
    {
      return this.uuid_;
    }
    
    public ByteString getUuidBytes()
    {
      return ByteString.copyFromUtf8(this.uuid_);
    }
    
    public boolean hasUuid()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getUuid());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VisualMapKey.AdfClusterNavigationGraphKeyProto, Builder>
      implements VisualMapKey.AdfClusterNavigationGraphKeyProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearUuid()
      {
        copyOnWrite();
        ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).clearUuid();
        return this;
      }
      
      public String getUuid()
      {
        return ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).getUuid();
      }
      
      public ByteString getUuidBytes()
      {
        return ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).getUuidBytes();
      }
      
      public boolean hasUuid()
      {
        return ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).hasUuid();
      }
      
      public Builder setUuid(String paramString)
      {
        copyOnWrite();
        ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).setUuid(paramString);
        return this;
      }
      
      public Builder setUuidBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VisualMapKey.AdfClusterNavigationGraphKeyProto)this.instance).setUuidBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface AdfClusterNavigationGraphKeyProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getUuid();
    
    public abstract ByteString getUuidBytes();
    
    public abstract boolean hasUuid();
  }
  
  public static final class AdfKeyProto
    extends GeneratedMessageLite<AdfKeyProto, Builder>
    implements VisualMapKey.AdfKeyProtoOrBuilder
  {
    private static final AdfKeyProto DEFAULT_INSTANCE = new AdfKeyProto();
    private static volatile Parser<AdfKeyProto> PARSER;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String uuid_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearUuid()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.uuid_ = getDefaultInstance().getUuid();
    }
    
    public static AdfKeyProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AdfKeyProto paramAdfKeyProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAdfKeyProto);
    }
    
    public static AdfKeyProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AdfKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AdfKeyProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfKeyProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static AdfKeyProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static AdfKeyProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static AdfKeyProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfKeyProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AdfKeyProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AdfKeyProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static AdfKeyProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AdfKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<AdfKeyProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setUuid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramString;
    }
    
    private void setUuidBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 145	com/google/location/visualmapping/visualmapstore/VisualMapKey$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 151	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+272->280, 8:+276->284
      //   56: new 153	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 154	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 157	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 159	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:hasUuid	()Z
      //   105: aload_0
      //   106: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:uuid_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:hasUuid	()Z
      //   113: aload_3
      //   114: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:uuid_	Ljava/lang/String;
      //   117: invokeinterface 167 5 0
      //   122: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:uuid_	Ljava/lang/String;
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 173	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:bitField0_	I
      //   139: aload_3
      //   140: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:bitField0_	I
      //   143: ior
      //   144: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 175	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 177	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +116 -> 280
      //   167: aload_1
      //   168: invokevirtual 180	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+150->325, 0:+153->328, 10:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 184	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_1
      //   217: invokevirtual 187	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   220: astore_2
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:bitField0_	I
      //   226: iconst_1
      //   227: ior
      //   228: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:bitField0_	I
      //   231: aload_0
      //   232: aload_2
      //   233: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:uuid_	Ljava/lang/String;
      //   236: goto -74 -> 162
      //   239: astore_1
      //   240: new 189	java/lang/RuntimeException
      //   243: dup
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   252: athrow
      //   253: astore_1
      //   254: aload_1
      //   255: athrow
      //   256: astore_1
      //   257: new 189	java/lang/RuntimeException
      //   260: dup
      //   261: new 95	com/google/protobuf/InvalidProtocolBufferException
      //   264: dup
      //   265: aload_1
      //   266: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
      //   269: invokespecial 201	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   272: aload_0
      //   273: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   276: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   279: athrow
      //   280: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto;
      //   283: areturn
      //   284: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   287: ifnonnull +28 -> 315
      //   290: ldc 2
      //   292: monitorenter
      //   293: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +16 -> 312
      //   299: new 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   302: dup
      //   303: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto;
      //   306: invokespecial 208	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   309: putstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   312: ldc 2
      //   314: monitorexit
      //   315: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$AdfKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   318: areturn
      //   319: astore_1
      //   320: ldc 2
      //   322: monitorexit
      //   323: aload_1
      //   324: athrow
      //   325: goto -125 -> 200
      //   328: iconst_1
      //   329: istore 4
      //   331: goto -169 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	334	0	this	AdfKeyProto
      //   0	334	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	334	2	paramObject1	Object
      //   0	334	3	paramObject2	Object
      //   160	170	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	239	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	239	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	239	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	253	finally
      //   200	210	253	finally
      //   216	236	253	finally
      //   240	253	253	finally
      //   257	280	253	finally
      //   167	173	256	java/io/IOException
      //   200	210	256	java/io/IOException
      //   216	236	256	java/io/IOException
      //   293	312	319	finally
      //   312	315	319	finally
      //   320	323	319	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getUuid());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getUuid()
    {
      return this.uuid_;
    }
    
    public ByteString getUuidBytes()
    {
      return ByteString.copyFromUtf8(this.uuid_);
    }
    
    public boolean hasUuid()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getUuid());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VisualMapKey.AdfKeyProto, Builder>
      implements VisualMapKey.AdfKeyProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearUuid()
      {
        copyOnWrite();
        ((VisualMapKey.AdfKeyProto)this.instance).clearUuid();
        return this;
      }
      
      public String getUuid()
      {
        return ((VisualMapKey.AdfKeyProto)this.instance).getUuid();
      }
      
      public ByteString getUuidBytes()
      {
        return ((VisualMapKey.AdfKeyProto)this.instance).getUuidBytes();
      }
      
      public boolean hasUuid()
      {
        return ((VisualMapKey.AdfKeyProto)this.instance).hasUuid();
      }
      
      public Builder setUuid(String paramString)
      {
        copyOnWrite();
        ((VisualMapKey.AdfKeyProto)this.instance).setUuid(paramString);
        return this;
      }
      
      public Builder setUuidBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VisualMapKey.AdfKeyProto)this.instance).setUuidBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface AdfKeyProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getUuid();
    
    public abstract ByteString getUuidBytes();
    
    public abstract boolean hasUuid();
  }
  
  public static final class NavigationGraphKeyProto
    extends GeneratedMessageLite<NavigationGraphKeyProto, Builder>
    implements VisualMapKey.NavigationGraphKeyProtoOrBuilder
  {
    private static final NavigationGraphKeyProto DEFAULT_INSTANCE = new NavigationGraphKeyProto();
    private static volatile Parser<NavigationGraphKeyProto> PARSER;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String uuid_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearUuid()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.uuid_ = getDefaultInstance().getUuid();
    }
    
    public static NavigationGraphKeyProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(NavigationGraphKeyProto paramNavigationGraphKeyProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramNavigationGraphKeyProto);
    }
    
    public static NavigationGraphKeyProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (NavigationGraphKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static NavigationGraphKeyProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NavigationGraphKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static NavigationGraphKeyProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static NavigationGraphKeyProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static NavigationGraphKeyProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static NavigationGraphKeyProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static NavigationGraphKeyProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static NavigationGraphKeyProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static NavigationGraphKeyProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static NavigationGraphKeyProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (NavigationGraphKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<NavigationGraphKeyProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setUuid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramString;
    }
    
    private void setUuidBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.uuid_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 145	com/google/location/visualmapping/visualmapstore/VisualMapKey$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 151	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+272->280, 8:+276->284
      //   56: new 153	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 154	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 157	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 159	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:hasUuid	()Z
      //   105: aload_0
      //   106: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 163	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:hasUuid	()Z
      //   113: aload_3
      //   114: getfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   117: invokeinterface 167 5 0
      //   122: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 173	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:bitField0_	I
      //   139: aload_3
      //   140: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:bitField0_	I
      //   143: ior
      //   144: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 175	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 177	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +116 -> 280
      //   167: aload_1
      //   168: invokevirtual 180	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+150->325, 0:+153->328, 10:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 184	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_1
      //   217: invokevirtual 187	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   220: astore_2
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:bitField0_	I
      //   226: iconst_1
      //   227: ior
      //   228: putfield 61	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:bitField0_	I
      //   231: aload_0
      //   232: aload_2
      //   233: putfield 40	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:uuid_	Ljava/lang/String;
      //   236: goto -74 -> 162
      //   239: astore_1
      //   240: new 189	java/lang/RuntimeException
      //   243: dup
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   252: athrow
      //   253: astore_1
      //   254: aload_1
      //   255: athrow
      //   256: astore_1
      //   257: new 189	java/lang/RuntimeException
      //   260: dup
      //   261: new 95	com/google/protobuf/InvalidProtocolBufferException
      //   264: dup
      //   265: aload_1
      //   266: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
      //   269: invokespecial 201	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   272: aload_0
      //   273: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   276: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   279: athrow
      //   280: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto;
      //   283: areturn
      //   284: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   287: ifnonnull +28 -> 315
      //   290: ldc 2
      //   292: monitorenter
      //   293: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +16 -> 312
      //   299: new 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   302: dup
      //   303: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto;
      //   306: invokespecial 208	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   309: putstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   312: ldc 2
      //   314: monitorexit
      //   315: getstatic 203	com/google/location/visualmapping/visualmapstore/VisualMapKey$NavigationGraphKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   318: areturn
      //   319: astore_1
      //   320: ldc 2
      //   322: monitorexit
      //   323: aload_1
      //   324: athrow
      //   325: goto -125 -> 200
      //   328: iconst_1
      //   329: istore 4
      //   331: goto -169 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	334	0	this	NavigationGraphKeyProto
      //   0	334	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	334	2	paramObject1	Object
      //   0	334	3	paramObject2	Object
      //   160	170	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	239	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	239	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	239	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	253	finally
      //   200	210	253	finally
      //   216	236	253	finally
      //   240	253	253	finally
      //   257	280	253	finally
      //   167	173	256	java/io/IOException
      //   200	210	256	java/io/IOException
      //   216	236	256	java/io/IOException
      //   293	312	319	finally
      //   312	315	319	finally
      //   320	323	319	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getUuid());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getUuid()
    {
      return this.uuid_;
    }
    
    public ByteString getUuidBytes()
    {
      return ByteString.copyFromUtf8(this.uuid_);
    }
    
    public boolean hasUuid()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getUuid());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VisualMapKey.NavigationGraphKeyProto, Builder>
      implements VisualMapKey.NavigationGraphKeyProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearUuid()
      {
        copyOnWrite();
        ((VisualMapKey.NavigationGraphKeyProto)this.instance).clearUuid();
        return this;
      }
      
      public String getUuid()
      {
        return ((VisualMapKey.NavigationGraphKeyProto)this.instance).getUuid();
      }
      
      public ByteString getUuidBytes()
      {
        return ((VisualMapKey.NavigationGraphKeyProto)this.instance).getUuidBytes();
      }
      
      public boolean hasUuid()
      {
        return ((VisualMapKey.NavigationGraphKeyProto)this.instance).hasUuid();
      }
      
      public Builder setUuid(String paramString)
      {
        copyOnWrite();
        ((VisualMapKey.NavigationGraphKeyProto)this.instance).setUuid(paramString);
        return this;
      }
      
      public Builder setUuidBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VisualMapKey.NavigationGraphKeyProto)this.instance).setUuidBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface NavigationGraphKeyProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getUuid();
    
    public abstract ByteString getUuidBytes();
    
    public abstract boolean hasUuid();
  }
  
  public static final class TileKeyProto
    extends GeneratedMessageLite<TileKeyProto, Builder>
    implements VisualMapKey.TileKeyProtoOrBuilder
  {
    private static final TileKeyProto DEFAULT_INSTANCE = new TileKeyProto();
    private static volatile Parser<TileKeyProto> PARSER;
    public static final int S2_CELL_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private S2CellId.S2CellIdProto s2CellId_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearS2CellId()
    {
      this.s2CellId_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    public static TileKeyProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
    {
      if ((this.s2CellId_ != null) && (this.s2CellId_ != S2CellId.S2CellIdProto.getDefaultInstance())) {}
      for (this.s2CellId_ = ((S2CellId.S2CellIdProto)((S2CellId.S2CellIdProto.Builder)S2CellId.S2CellIdProto.newBuilder(this.s2CellId_).mergeFrom(paramS2CellIdProto)).buildPartial());; this.s2CellId_ = paramS2CellIdProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TileKeyProto paramTileKeyProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTileKeyProto);
    }
    
    public static TileKeyProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TileKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TileKeyProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileKeyProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TileKeyProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static TileKeyProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static TileKeyProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static TileKeyProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static TileKeyProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TileKeyProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TileKeyProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static TileKeyProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TileKeyProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<TileKeyProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setS2CellId(S2CellId.S2CellIdProto.Builder paramBuilder)
    {
      this.s2CellId_ = ((S2CellId.S2CellIdProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
    {
      if (paramS2CellIdProto == null) {
        throw new NullPointerException();
      }
      this.s2CellId_ = paramS2CellIdProto;
      this.bitField0_ |= 0x1;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 153	com/google/location/visualmapping/visualmapstore/VisualMapKey$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 159	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+136->144, 7:+320->328, 8:+324->332
      //   56: new 161	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 162	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 165	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 167	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   105: aload_3
      //   106: getfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   109: invokeinterface 171 3 0
      //   114: checkcast 65	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
      //   117: putfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   120: aload_0
      //   121: astore_1
      //   122: aload_2
      //   123: getstatic 177	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   126: if_acmpne -54 -> 72
      //   129: aload_0
      //   130: aload_0
      //   131: getfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   134: aload_3
      //   135: getfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   138: ior
      //   139: putfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   142: aload_0
      //   143: areturn
      //   144: aload_2
      //   145: checkcast 179	com/google/protobuf/CodedInputStream
      //   148: astore_2
      //   149: aload_3
      //   150: checkcast 181	com/google/protobuf/ExtensionRegistryLite
      //   153: astore_3
      //   154: iconst_0
      //   155: istore 4
      //   157: iload 4
      //   159: ifne +169 -> 328
      //   162: aload_2
      //   163: invokevirtual 184	com/google/protobuf/CodedInputStream:readTag	()I
      //   166: istore 5
      //   168: iload 5
      //   170: lookupswitch	default:+203->373, 0:+206->376, 10:+42->212
      //   196: aload_0
      //   197: iload 5
      //   199: aload_2
      //   200: invokevirtual 188	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   203: ifne -46 -> 157
      //   206: iconst_1
      //   207: istore 4
      //   209: goto -52 -> 157
      //   212: aconst_null
      //   213: astore_1
      //   214: aload_0
      //   215: getfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   218: iconst_1
      //   219: iand
      //   220: iconst_1
      //   221: if_icmpne +14 -> 235
      //   224: aload_0
      //   225: getfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   228: invokevirtual 189	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   231: checkcast 74	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder
      //   234: astore_1
      //   235: aload_0
      //   236: aload_2
      //   237: invokestatic 191	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:parser	()Lcom/google/protobuf/Parser;
      //   240: aload_3
      //   241: invokevirtual 195	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   244: checkcast 65	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
      //   247: putfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   250: aload_1
      //   251: ifnull +23 -> 274
      //   254: aload_1
      //   255: aload_0
      //   256: getfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   259: invokevirtual 78	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   262: pop
      //   263: aload_0
      //   264: aload_1
      //   265: invokevirtual 82	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   268: checkcast 65	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
      //   271: putfield 60	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   274: aload_0
      //   275: aload_0
      //   276: getfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   279: iconst_1
      //   280: ior
      //   281: putfield 62	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:bitField0_	I
      //   284: goto -127 -> 157
      //   287: astore_1
      //   288: new 197	java/lang/RuntimeException
      //   291: dup
      //   292: aload_1
      //   293: aload_0
      //   294: invokevirtual 201	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   297: invokespecial 204	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   300: athrow
      //   301: astore_1
      //   302: aload_1
      //   303: athrow
      //   304: astore_1
      //   305: new 197	java/lang/RuntimeException
      //   308: dup
      //   309: new 105	com/google/protobuf/InvalidProtocolBufferException
      //   312: dup
      //   313: aload_1
      //   314: invokevirtual 208	java/io/IOException:getMessage	()Ljava/lang/String;
      //   317: invokespecial 211	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   320: aload_0
      //   321: invokevirtual 201	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   324: invokespecial 204	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   327: athrow
      //   328: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto;
      //   331: areturn
      //   332: getstatic 213	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   335: ifnonnull +28 -> 363
      //   338: ldc 2
      //   340: monitorenter
      //   341: getstatic 213	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   344: ifnonnull +16 -> 360
      //   347: new 215	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   350: dup
      //   351: getstatic 31	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto;
      //   354: invokespecial 218	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   357: putstatic 213	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   360: ldc 2
      //   362: monitorexit
      //   363: getstatic 213	com/google/location/visualmapping/visualmapstore/VisualMapKey$TileKeyProto:PARSER	Lcom/google/protobuf/Parser;
      //   366: areturn
      //   367: astore_1
      //   368: ldc 2
      //   370: monitorexit
      //   371: aload_1
      //   372: athrow
      //   373: goto -177 -> 196
      //   376: iconst_1
      //   377: istore 4
      //   379: goto -222 -> 157
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	382	0	this	TileKeyProto
      //   0	382	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	382	2	paramObject1	Object
      //   0	382	3	paramObject2	Object
      //   155	223	4	i	int
      //   166	32	5	j	int
      // Exception table:
      //   from	to	target	type
      //   162	168	287	com/google/protobuf/InvalidProtocolBufferException
      //   196	206	287	com/google/protobuf/InvalidProtocolBufferException
      //   214	235	287	com/google/protobuf/InvalidProtocolBufferException
      //   235	250	287	com/google/protobuf/InvalidProtocolBufferException
      //   254	274	287	com/google/protobuf/InvalidProtocolBufferException
      //   274	284	287	com/google/protobuf/InvalidProtocolBufferException
      //   162	168	301	finally
      //   196	206	301	finally
      //   214	235	301	finally
      //   235	250	301	finally
      //   254	274	301	finally
      //   274	284	301	finally
      //   288	301	301	finally
      //   305	328	301	finally
      //   162	168	304	java/io/IOException
      //   196	206	304	java/io/IOException
      //   214	235	304	java/io/IOException
      //   235	250	304	java/io/IOException
      //   254	274	304	java/io/IOException
      //   274	284	304	java/io/IOException
      //   341	360	367	finally
      //   360	363	367	finally
      //   368	371	367	finally
    }
    
    public S2CellId.S2CellIdProto getS2CellId()
    {
      if (this.s2CellId_ == null) {
        return S2CellId.S2CellIdProto.getDefaultInstance();
      }
      return this.s2CellId_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, getS2CellId());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasS2CellId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getS2CellId());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VisualMapKey.TileKeyProto, Builder>
      implements VisualMapKey.TileKeyProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearS2CellId()
      {
        copyOnWrite();
        ((VisualMapKey.TileKeyProto)this.instance).clearS2CellId();
        return this;
      }
      
      public S2CellId.S2CellIdProto getS2CellId()
      {
        return ((VisualMapKey.TileKeyProto)this.instance).getS2CellId();
      }
      
      public boolean hasS2CellId()
      {
        return ((VisualMapKey.TileKeyProto)this.instance).hasS2CellId();
      }
      
      public Builder mergeS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
      {
        copyOnWrite();
        ((VisualMapKey.TileKeyProto)this.instance).mergeS2CellId(paramS2CellIdProto);
        return this;
      }
      
      public Builder setS2CellId(S2CellId.S2CellIdProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VisualMapKey.TileKeyProto)this.instance).setS2CellId(paramBuilder);
        return this;
      }
      
      public Builder setS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
      {
        copyOnWrite();
        ((VisualMapKey.TileKeyProto)this.instance).setS2CellId(paramS2CellIdProto);
        return this;
      }
    }
  }
  
  public static abstract interface TileKeyProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract S2CellId.S2CellIdProto getS2CellId();
    
    public abstract boolean hasS2CellId();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/visualmapstore/VisualMapKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */