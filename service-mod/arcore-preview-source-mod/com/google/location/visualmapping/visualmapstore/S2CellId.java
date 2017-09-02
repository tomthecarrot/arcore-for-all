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

public final class S2CellId
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class S2CellIdProto
    extends GeneratedMessageLite<S2CellIdProto, Builder>
    implements S2CellId.S2CellIdProtoOrBuilder
  {
    private static final S2CellIdProto DEFAULT_INSTANCE = new S2CellIdProto();
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<S2CellIdProto> PARSER;
    private int bitField0_;
    private long id_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.id_ = 0L;
    }
    
    public static S2CellIdProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(S2CellIdProto paramS2CellIdProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramS2CellIdProto);
    }
    
    public static S2CellIdProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellIdProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellIdProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellIdProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellIdProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static S2CellIdProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static S2CellIdProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static S2CellIdProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellIdProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellIdProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellIdProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static S2CellIdProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellIdProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<S2CellIdProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setId(long paramLong)
    {
      this.bitField0_ |= 0x1;
      this.id_ = paramLong;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 123	com/google/location/visualmapping/visualmapstore/S2CellId$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 129	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+270->278, 8:+274->282
      //   56: new 131	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 132	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 135	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/S2CellId$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 137	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 141	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:hasId	()Z
      //   105: aload_0
      //   106: getfield 53	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:id_	J
      //   109: aload_3
      //   110: invokevirtual 141	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:hasId	()Z
      //   113: aload_3
      //   114: getfield 53	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:id_	J
      //   117: invokeinterface 145 7 0
      //   122: putfield 53	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:id_	J
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 151	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 51	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:bitField0_	I
      //   139: aload_3
      //   140: getfield 51	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:bitField0_	I
      //   143: ior
      //   144: putfield 51	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 153	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 155	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +114 -> 278
      //   167: aload_1
      //   168: invokevirtual 158	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+148->323, 0:+151->326, 8:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 162	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 51	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:bitField0_	I
      //   221: iconst_1
      //   222: ior
      //   223: putfield 51	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:bitField0_	I
      //   226: aload_0
      //   227: aload_1
      //   228: invokevirtual 166	com/google/protobuf/CodedInputStream:readUInt64	()J
      //   231: putfield 53	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:id_	J
      //   234: goto -72 -> 162
      //   237: astore_1
      //   238: new 168	java/lang/RuntimeException
      //   241: dup
      //   242: aload_1
      //   243: aload_0
      //   244: invokevirtual 172	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   247: invokespecial 175	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   250: athrow
      //   251: astore_1
      //   252: aload_1
      //   253: athrow
      //   254: astore_1
      //   255: new 168	java/lang/RuntimeException
      //   258: dup
      //   259: new 81	com/google/protobuf/InvalidProtocolBufferException
      //   262: dup
      //   263: aload_1
      //   264: invokevirtual 179	java/io/IOException:getMessage	()Ljava/lang/String;
      //   267: invokespecial 182	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   270: aload_0
      //   271: invokevirtual 172	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   274: invokespecial 175	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   277: athrow
      //   278: getstatic 31	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   281: areturn
      //   282: getstatic 184	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:PARSER	Lcom/google/protobuf/Parser;
      //   285: ifnonnull +28 -> 313
      //   288: ldc 2
      //   290: monitorenter
      //   291: getstatic 184	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:PARSER	Lcom/google/protobuf/Parser;
      //   294: ifnonnull +16 -> 310
      //   297: new 186	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   300: dup
      //   301: getstatic 31	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
      //   304: invokespecial 189	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   307: putstatic 184	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:PARSER	Lcom/google/protobuf/Parser;
      //   310: ldc 2
      //   312: monitorexit
      //   313: getstatic 184	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:PARSER	Lcom/google/protobuf/Parser;
      //   316: areturn
      //   317: astore_1
      //   318: ldc 2
      //   320: monitorexit
      //   321: aload_1
      //   322: athrow
      //   323: goto -123 -> 200
      //   326: iconst_1
      //   327: istore 4
      //   329: goto -167 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	S2CellIdProto
      //   0	332	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	332	2	paramObject1	Object
      //   0	332	3	paramObject2	Object
      //   160	168	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	237	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	237	com/google/protobuf/InvalidProtocolBufferException
      //   216	234	237	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	251	finally
      //   200	210	251	finally
      //   216	234	251	finally
      //   238	251	251	finally
      //   255	278	251	finally
      //   167	173	254	java/io/IOException
      //   200	210	254	java/io/IOException
      //   216	234	254	java/io/IOException
      //   291	310	317	finally
      //   310	313	317	finally
      //   318	321	317	finally
    }
    
    public long getId()
    {
      return this.id_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeUInt64Size(1, this.id_);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeUInt64(1, this.id_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<S2CellId.S2CellIdProto, Builder>
      implements S2CellId.S2CellIdProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearId()
      {
        copyOnWrite();
        ((S2CellId.S2CellIdProto)this.instance).clearId();
        return this;
      }
      
      public long getId()
      {
        return ((S2CellId.S2CellIdProto)this.instance).getId();
      }
      
      public boolean hasId()
      {
        return ((S2CellId.S2CellIdProto)this.instance).hasId();
      }
      
      public Builder setId(long paramLong)
      {
        copyOnWrite();
        ((S2CellId.S2CellIdProto)this.instance).setId(paramLong);
        return this;
      }
    }
  }
  
  public static abstract interface S2CellIdProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract long getId();
    
    public abstract boolean hasId();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/visualmapstore/S2CellId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */