package com.google.location.visualmapping.visualmapstore;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class TileInfoProto
  extends GeneratedMessageLite<TileInfoProto, Builder>
  implements TileInfoProtoOrBuilder
{
  private static final TileInfoProto DEFAULT_INSTANCE = new TileInfoProto();
  public static final int NAMESPACE_FIELD_NUMBER = 2;
  private static volatile Parser<TileInfoProto> PARSER;
  public static final int S2_CELL_ID_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 3;
  private int bitField0_;
  private String namespace_ = "";
  private S2CellId.S2CellIdProto s2CellId_;
  private long version_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearNamespace()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.namespace_ = getDefaultInstance().getNamespace();
  }
  
  private void clearS2CellId()
  {
    this.s2CellId_ = null;
    this.bitField0_ &= 0xFFFFFFFE;
  }
  
  private void clearVersion()
  {
    this.bitField0_ &= 0xFFFFFFFB;
    this.version_ = 0L;
  }
  
  public static TileInfoProto getDefaultInstance()
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
  
  public static Builder newBuilder(TileInfoProto paramTileInfoProto)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTileInfoProto);
  }
  
  public static TileInfoProto parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (TileInfoProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TileInfoProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TileInfoProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TileInfoProto parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TileInfoProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TileInfoProto parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TileInfoProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TileInfoProto parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TileInfoProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TileInfoProto parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static TileInfoProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (TileInfoProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<TileInfoProto> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setNamespace(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.namespace_ = paramString;
  }
  
  private void setNamespaceBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.namespace_ = paramByteString.toStringUtf8();
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
  
  private void setVersion(long paramLong)
  {
    this.bitField0_ |= 0x4;
    this.version_ = paramLong;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 201	com/google/location/visualmapping/visualmapstore/TileInfoProto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 207	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+188->196, 7:+432->440, 8:+436->444
    //   56: new 209	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 210	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/location/visualmapping/visualmapstore/TileInfoProto
    //   67: dup
    //   68: invokespecial 36	com/google/location/visualmapping/visualmapstore/TileInfoProto:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 38	com/google/location/visualmapping/visualmapstore/TileInfoProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 213	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/TileInfoProto$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 215	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/TileInfoProto
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   105: aload_3
    //   106: getfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   109: invokeinterface 219 3 0
    //   114: checkcast 110	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
    //   117: putfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   120: aload_0
    //   121: aload_2
    //   122: aload_0
    //   123: invokevirtual 223	com/google/location/visualmapping/visualmapstore/TileInfoProto:hasNamespace	()Z
    //   126: aload_0
    //   127: getfield 47	com/google/location/visualmapping/visualmapstore/TileInfoProto:namespace_	Ljava/lang/String;
    //   130: aload_3
    //   131: invokevirtual 223	com/google/location/visualmapping/visualmapstore/TileInfoProto:hasNamespace	()Z
    //   134: aload_3
    //   135: getfield 47	com/google/location/visualmapping/visualmapstore/TileInfoProto:namespace_	Ljava/lang/String;
    //   138: invokeinterface 227 5 0
    //   143: putfield 47	com/google/location/visualmapping/visualmapstore/TileInfoProto:namespace_	Ljava/lang/String;
    //   146: aload_0
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 230	com/google/location/visualmapping/visualmapstore/TileInfoProto:hasVersion	()Z
    //   152: aload_0
    //   153: getfield 108	com/google/location/visualmapping/visualmapstore/TileInfoProto:version_	J
    //   156: aload_3
    //   157: invokevirtual 230	com/google/location/visualmapping/visualmapstore/TileInfoProto:hasVersion	()Z
    //   160: aload_3
    //   161: getfield 108	com/google/location/visualmapping/visualmapstore/TileInfoProto:version_	J
    //   164: invokeinterface 234 7 0
    //   169: putfield 108	com/google/location/visualmapping/visualmapstore/TileInfoProto:version_	J
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: getstatic 240	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   178: if_acmpne -106 -> 72
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   186: aload_3
    //   187: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   190: ior
    //   191: putfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   194: aload_0
    //   195: areturn
    //   196: aload_2
    //   197: checkcast 242	com/google/protobuf/CodedInputStream
    //   200: astore_2
    //   201: aload_3
    //   202: checkcast 244	com/google/protobuf/ExtensionRegistryLite
    //   205: astore_3
    //   206: iconst_0
    //   207: istore 4
    //   209: iload 4
    //   211: ifne +229 -> 440
    //   214: aload_2
    //   215: invokevirtual 247	com/google/protobuf/CodedInputStream:readTag	()I
    //   218: istore 5
    //   220: iload 5
    //   222: lookupswitch	default:+263->485, 0:+266->488, 10:+58->280, 18:+150->372, 24:+197->419
    //   264: aload_0
    //   265: iload 5
    //   267: aload_2
    //   268: invokevirtual 251	com/google/location/visualmapping/visualmapstore/TileInfoProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   271: ifne -62 -> 209
    //   274: iconst_1
    //   275: istore 4
    //   277: goto -68 -> 209
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_0
    //   283: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   286: iconst_1
    //   287: iand
    //   288: iconst_1
    //   289: if_icmpne +14 -> 303
    //   292: aload_0
    //   293: getfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   296: invokevirtual 252	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   299: checkcast 119	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder
    //   302: astore_1
    //   303: aload_0
    //   304: aload_2
    //   305: invokestatic 254	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto:parser	()Lcom/google/protobuf/Parser;
    //   308: aload_3
    //   309: invokevirtual 258	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   312: checkcast 110	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
    //   315: putfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   318: aload_1
    //   319: ifnull +23 -> 342
    //   322: aload_1
    //   323: aload_0
    //   324: getfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   327: invokevirtual 123	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   330: pop
    //   331: aload_0
    //   332: aload_1
    //   333: invokevirtual 127	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   336: checkcast 110	com/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto
    //   339: putfield 106	com/google/location/visualmapping/visualmapstore/TileInfoProto:s2CellId_	Lcom/google/location/visualmapping/visualmapstore/S2CellId$S2CellIdProto;
    //   342: aload_0
    //   343: aload_0
    //   344: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   347: iconst_1
    //   348: ior
    //   349: putfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   352: goto -143 -> 209
    //   355: astore_1
    //   356: new 260	java/lang/RuntimeException
    //   359: dup
    //   360: aload_1
    //   361: aload_0
    //   362: invokevirtual 264	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   365: invokespecial 267	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   368: athrow
    //   369: astore_1
    //   370: aload_1
    //   371: athrow
    //   372: aload_2
    //   373: invokevirtual 270	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   376: astore_1
    //   377: aload_0
    //   378: aload_0
    //   379: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   382: iconst_2
    //   383: ior
    //   384: putfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   387: aload_0
    //   388: aload_1
    //   389: putfield 47	com/google/location/visualmapping/visualmapstore/TileInfoProto:namespace_	Ljava/lang/String;
    //   392: goto -183 -> 209
    //   395: astore_1
    //   396: new 260	java/lang/RuntimeException
    //   399: dup
    //   400: new 150	com/google/protobuf/InvalidProtocolBufferException
    //   403: dup
    //   404: aload_1
    //   405: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   408: invokespecial 275	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   411: aload_0
    //   412: invokevirtual 264	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   415: invokespecial 267	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   418: athrow
    //   419: aload_0
    //   420: aload_0
    //   421: getfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   424: iconst_4
    //   425: ior
    //   426: putfield 97	com/google/location/visualmapping/visualmapstore/TileInfoProto:bitField0_	I
    //   429: aload_0
    //   430: aload_2
    //   431: invokevirtual 279	com/google/protobuf/CodedInputStream:readInt64	()J
    //   434: putfield 108	com/google/location/visualmapping/visualmapstore/TileInfoProto:version_	J
    //   437: goto -228 -> 209
    //   440: getstatic 38	com/google/location/visualmapping/visualmapstore/TileInfoProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   443: areturn
    //   444: getstatic 281	com/google/location/visualmapping/visualmapstore/TileInfoProto:PARSER	Lcom/google/protobuf/Parser;
    //   447: ifnonnull +28 -> 475
    //   450: ldc 2
    //   452: monitorenter
    //   453: getstatic 281	com/google/location/visualmapping/visualmapstore/TileInfoProto:PARSER	Lcom/google/protobuf/Parser;
    //   456: ifnonnull +16 -> 472
    //   459: new 283	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   462: dup
    //   463: getstatic 38	com/google/location/visualmapping/visualmapstore/TileInfoProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   466: invokespecial 286	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   469: putstatic 281	com/google/location/visualmapping/visualmapstore/TileInfoProto:PARSER	Lcom/google/protobuf/Parser;
    //   472: ldc 2
    //   474: monitorexit
    //   475: getstatic 281	com/google/location/visualmapping/visualmapstore/TileInfoProto:PARSER	Lcom/google/protobuf/Parser;
    //   478: areturn
    //   479: astore_1
    //   480: ldc 2
    //   482: monitorexit
    //   483: aload_1
    //   484: athrow
    //   485: goto -221 -> 264
    //   488: iconst_1
    //   489: istore 4
    //   491: goto -282 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	TileInfoProto
    //   0	494	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	494	2	paramObject1	Object
    //   0	494	3	paramObject2	Object
    //   207	283	4	i	int
    //   218	48	5	j	int
    // Exception table:
    //   from	to	target	type
    //   214	220	355	com/google/protobuf/InvalidProtocolBufferException
    //   264	274	355	com/google/protobuf/InvalidProtocolBufferException
    //   282	303	355	com/google/protobuf/InvalidProtocolBufferException
    //   303	318	355	com/google/protobuf/InvalidProtocolBufferException
    //   322	342	355	com/google/protobuf/InvalidProtocolBufferException
    //   342	352	355	com/google/protobuf/InvalidProtocolBufferException
    //   372	392	355	com/google/protobuf/InvalidProtocolBufferException
    //   419	437	355	com/google/protobuf/InvalidProtocolBufferException
    //   214	220	369	finally
    //   264	274	369	finally
    //   282	303	369	finally
    //   303	318	369	finally
    //   322	342	369	finally
    //   342	352	369	finally
    //   356	369	369	finally
    //   372	392	369	finally
    //   396	419	369	finally
    //   419	437	369	finally
    //   214	220	395	java/io/IOException
    //   264	274	395	java/io/IOException
    //   282	303	395	java/io/IOException
    //   303	318	395	java/io/IOException
    //   322	342	395	java/io/IOException
    //   342	352	395	java/io/IOException
    //   372	392	395	java/io/IOException
    //   419	437	395	java/io/IOException
    //   453	472	479	finally
    //   472	475	479	finally
    //   480	483	479	finally
  }
  
  public String getNamespace()
  {
    return this.namespace_;
  }
  
  public ByteString getNamespaceBytes()
  {
    return ByteString.copyFromUtf8(this.namespace_);
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
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeMessageSize(1, getS2CellId());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeStringSize(2, getNamespace());
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeInt64Size(3, this.version_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public long getVersion()
  {
    return this.version_;
  }
  
  public boolean hasNamespace()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasS2CellId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasVersion()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(1, getS2CellId());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeString(2, getNamespace());
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeInt64(3, this.version_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<TileInfoProto, Builder>
    implements TileInfoProtoOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearNamespace()
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).clearNamespace();
      return this;
    }
    
    public Builder clearS2CellId()
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).clearS2CellId();
      return this;
    }
    
    public Builder clearVersion()
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).clearVersion();
      return this;
    }
    
    public String getNamespace()
    {
      return ((TileInfoProto)this.instance).getNamespace();
    }
    
    public ByteString getNamespaceBytes()
    {
      return ((TileInfoProto)this.instance).getNamespaceBytes();
    }
    
    public S2CellId.S2CellIdProto getS2CellId()
    {
      return ((TileInfoProto)this.instance).getS2CellId();
    }
    
    public long getVersion()
    {
      return ((TileInfoProto)this.instance).getVersion();
    }
    
    public boolean hasNamespace()
    {
      return ((TileInfoProto)this.instance).hasNamespace();
    }
    
    public boolean hasS2CellId()
    {
      return ((TileInfoProto)this.instance).hasS2CellId();
    }
    
    public boolean hasVersion()
    {
      return ((TileInfoProto)this.instance).hasVersion();
    }
    
    public Builder mergeS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).mergeS2CellId(paramS2CellIdProto);
      return this;
    }
    
    public Builder setNamespace(String paramString)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).setNamespace(paramString);
      return this;
    }
    
    public Builder setNamespaceBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).setNamespaceBytes(paramByteString);
      return this;
    }
    
    public Builder setS2CellId(S2CellId.S2CellIdProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).setS2CellId(paramBuilder);
      return this;
    }
    
    public Builder setS2CellId(S2CellId.S2CellIdProto paramS2CellIdProto)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).setS2CellId(paramS2CellIdProto);
      return this;
    }
    
    public Builder setVersion(long paramLong)
    {
      copyOnWrite();
      ((TileInfoProto)this.instance).setVersion(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/visualmapstore/TileInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */