package com.google.internal.tango.foi.v1beta1;

import com.google.location.visualmapping.common.LinearAlgebra.TransformationProto;
import com.google.location.visualmapping.common.LinearAlgebra.TransformationProto.Builder;
import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.location.visualmapping.visualmapstore.TileInfoProto.Builder;
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

public final class Foi
  extends GeneratedMessageLite<Foi, Builder>
  implements FoiOrBuilder
{
  private static final Foi DEFAULT_INSTANCE = new Foi();
  public static final int ID_FIELD_NUMBER = 1;
  public static final int LOCALIZATION_CONTEXT_FIELD_NUMBER = 7;
  public static final int PARENT_FOI_FIELD_NUMBER = 4;
  private static volatile Parser<Foi> PARSER;
  public static final int TILE_INFO_FIELD_NUMBER = 6;
  public static final int TOKEN_FIELD_NUMBER = 3;
  public static final int TRANSFORMATION_FROM_PARENT_FRAME_FIELD_NUMBER = 5;
  private int bitField0_;
  private String id_ = "";
  private ByteString localizationContext_ = ByteString.EMPTY;
  private FoiRef parentFoi_;
  private TileInfoProto tileInfo_;
  private long token_;
  private LinearAlgebra.TransformationProto transformationFromParentFrame_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearId()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.id_ = getDefaultInstance().getId();
  }
  
  private void clearLocalizationContext()
  {
    this.bitField0_ &= 0xFFFFFFDF;
    this.localizationContext_ = getDefaultInstance().getLocalizationContext();
  }
  
  private void clearParentFoi()
  {
    this.parentFoi_ = null;
    this.bitField0_ &= 0xFFFFFFFB;
  }
  
  private void clearTileInfo()
  {
    this.tileInfo_ = null;
    this.bitField0_ &= 0xFFFFFFEF;
  }
  
  private void clearToken()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.token_ = 0L;
  }
  
  private void clearTransformationFromParentFrame()
  {
    this.transformationFromParentFrame_ = null;
    this.bitField0_ &= 0xFFFFFFF7;
  }
  
  public static Foi getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeParentFoi(FoiRef paramFoiRef)
  {
    if ((this.parentFoi_ != null) && (this.parentFoi_ != FoiRef.getDefaultInstance())) {}
    for (this.parentFoi_ = ((FoiRef)((FoiRef.Builder)FoiRef.newBuilder(this.parentFoi_).mergeFrom(paramFoiRef)).buildPartial());; this.parentFoi_ = paramFoiRef)
    {
      this.bitField0_ |= 0x4;
      return;
    }
  }
  
  private void mergeTileInfo(TileInfoProto paramTileInfoProto)
  {
    if ((this.tileInfo_ != null) && (this.tileInfo_ != TileInfoProto.getDefaultInstance())) {}
    for (this.tileInfo_ = ((TileInfoProto)((TileInfoProto.Builder)TileInfoProto.newBuilder(this.tileInfo_).mergeFrom(paramTileInfoProto)).buildPartial());; this.tileInfo_ = paramTileInfoProto)
    {
      this.bitField0_ |= 0x10;
      return;
    }
  }
  
  private void mergeTransformationFromParentFrame(LinearAlgebra.TransformationProto paramTransformationProto)
  {
    if ((this.transformationFromParentFrame_ != null) && (this.transformationFromParentFrame_ != LinearAlgebra.TransformationProto.getDefaultInstance())) {}
    for (this.transformationFromParentFrame_ = ((LinearAlgebra.TransformationProto)((LinearAlgebra.TransformationProto.Builder)LinearAlgebra.TransformationProto.newBuilder(this.transformationFromParentFrame_).mergeFrom(paramTransformationProto)).buildPartial());; this.transformationFromParentFrame_ = paramTransformationProto)
    {
      this.bitField0_ |= 0x8;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Foi paramFoi)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFoi);
  }
  
  public static Foi parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Foi)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Foi parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Foi)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Foi parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Foi parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Foi parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Foi parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Foi parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Foi parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Foi parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Foi parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Foi)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Foi> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setId(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.id_ = paramString;
  }
  
  private void setIdBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.id_ = paramByteString.toStringUtf8();
  }
  
  private void setLocalizationContext(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x20;
    this.localizationContext_ = paramByteString;
  }
  
  private void setParentFoi(FoiRef.Builder paramBuilder)
  {
    this.parentFoi_ = ((FoiRef)paramBuilder.build());
    this.bitField0_ |= 0x4;
  }
  
  private void setParentFoi(FoiRef paramFoiRef)
  {
    if (paramFoiRef == null) {
      throw new NullPointerException();
    }
    this.parentFoi_ = paramFoiRef;
    this.bitField0_ |= 0x4;
  }
  
  private void setTileInfo(TileInfoProto.Builder paramBuilder)
  {
    this.tileInfo_ = ((TileInfoProto)paramBuilder.build());
    this.bitField0_ |= 0x10;
  }
  
  private void setTileInfo(TileInfoProto paramTileInfoProto)
  {
    if (paramTileInfoProto == null) {
      throw new NullPointerException();
    }
    this.tileInfo_ = paramTileInfoProto;
    this.bitField0_ |= 0x10;
  }
  
  private void setToken(long paramLong)
  {
    this.bitField0_ |= 0x2;
    this.token_ = paramLong;
  }
  
  private void setTransformationFromParentFrame(LinearAlgebra.TransformationProto.Builder paramBuilder)
  {
    this.transformationFromParentFrame_ = ((LinearAlgebra.TransformationProto)paramBuilder.build());
    this.bitField0_ |= 0x8;
  }
  
  private void setTransformationFromParentFrame(LinearAlgebra.TransformationProto paramTransformationProto)
  {
    if (paramTransformationProto == null) {
      throw new NullPointerException();
    }
    this.transformationFromParentFrame_ = paramTransformationProto;
    this.bitField0_ |= 0x8;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 298	com/google/internal/tango/foi/v1beta1/Foi$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 304	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+256->264, 7:+702->710, 8:+706->714
    //   56: new 306	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 307	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/foi/v1beta1/Foi
    //   67: dup
    //   68: invokespecial 48	com/google/internal/tango/foi/v1beta1/Foi:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 50	com/google/internal/tango/foi/v1beta1/Foi:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/internal/tango/foi/v1beta1/Foi$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 310	com/google/internal/tango/foi/v1beta1/Foi$Builder:<init>	(Lcom/google/internal/tango/foi/v1beta1/Foi$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 312	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/internal/tango/foi/v1beta1/Foi
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 316	com/google/internal/tango/foi/v1beta1/Foi:hasId	()Z
    //   105: aload_0
    //   106: getfield 59	com/google/internal/tango/foi/v1beta1/Foi:id_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 316	com/google/internal/tango/foi/v1beta1/Foi:hasId	()Z
    //   113: aload_3
    //   114: getfield 59	com/google/internal/tango/foi/v1beta1/Foi:id_	Ljava/lang/String;
    //   117: invokeinterface 320 5 0
    //   122: putfield 59	com/google/internal/tango/foi/v1beta1/Foi:id_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 323	com/google/internal/tango/foi/v1beta1/Foi:hasToken	()Z
    //   131: aload_0
    //   132: getfield 179	com/google/internal/tango/foi/v1beta1/Foi:token_	J
    //   135: aload_3
    //   136: invokevirtual 323	com/google/internal/tango/foi/v1beta1/Foi:hasToken	()Z
    //   139: aload_3
    //   140: getfield 179	com/google/internal/tango/foi/v1beta1/Foi:token_	J
    //   143: invokeinterface 327 7 0
    //   148: putfield 179	com/google/internal/tango/foi/v1beta1/Foi:token_	J
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: getfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   157: aload_3
    //   158: getfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   161: invokeinterface 331 3 0
    //   166: checkcast 183	com/google/internal/tango/foi/v1beta1/FoiRef
    //   169: putfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   172: aload_0
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   178: aload_3
    //   179: getfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   182: invokeinterface 331 3 0
    //   187: checkcast 214	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
    //   190: putfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   193: aload_0
    //   194: aload_2
    //   195: aload_0
    //   196: getfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   199: aload_3
    //   200: getfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   203: invokeinterface 331 3 0
    //   208: checkcast 202	com/google/location/visualmapping/visualmapstore/TileInfoProto
    //   211: putfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   214: aload_0
    //   215: aload_2
    //   216: aload_0
    //   217: invokevirtual 334	com/google/internal/tango/foi/v1beta1/Foi:hasLocalizationContext	()Z
    //   220: aload_0
    //   221: getfield 66	com/google/internal/tango/foi/v1beta1/Foi:localizationContext_	Lcom/google/protobuf/ByteString;
    //   224: aload_3
    //   225: invokevirtual 334	com/google/internal/tango/foi/v1beta1/Foi:hasLocalizationContext	()Z
    //   228: aload_3
    //   229: getfield 66	com/google/internal/tango/foi/v1beta1/Foi:localizationContext_	Lcom/google/protobuf/ByteString;
    //   232: invokeinterface 338 5 0
    //   237: putfield 66	com/google/internal/tango/foi/v1beta1/Foi:localizationContext_	Lcom/google/protobuf/ByteString;
    //   240: aload_0
    //   241: astore_1
    //   242: aload_2
    //   243: getstatic 344	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   246: if_acmpne -174 -> 72
    //   249: aload_0
    //   250: aload_0
    //   251: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   254: aload_3
    //   255: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   258: ior
    //   259: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   262: aload_0
    //   263: areturn
    //   264: aload_2
    //   265: checkcast 346	com/google/protobuf/CodedInputStream
    //   268: astore_2
    //   269: aload_3
    //   270: checkcast 348	com/google/protobuf/ExtensionRegistryLite
    //   273: astore_3
    //   274: iconst_0
    //   275: istore 4
    //   277: iload 4
    //   279: ifne +431 -> 710
    //   282: aload_2
    //   283: invokevirtual 351	com/google/protobuf/CodedInputStream:readTag	()I
    //   286: istore 5
    //   288: iload 5
    //   290: lookupswitch	default:+465->755, 0:+468->758, 10:+82->372, 24:+122->412, 34:+167->457, 42:+242->532, 50:+320->610, 58:+398->688
    //   356: aload_0
    //   357: iload 5
    //   359: aload_2
    //   360: invokevirtual 355	com/google/internal/tango/foi/v1beta1/Foi:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   363: ifne -86 -> 277
    //   366: iconst_1
    //   367: istore 4
    //   369: goto -92 -> 277
    //   372: aload_2
    //   373: invokevirtual 358	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   376: astore_1
    //   377: aload_0
    //   378: aload_0
    //   379: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   382: iconst_1
    //   383: ior
    //   384: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   387: aload_0
    //   388: aload_1
    //   389: putfield 59	com/google/internal/tango/foi/v1beta1/Foi:id_	Ljava/lang/String;
    //   392: goto -115 -> 277
    //   395: astore_1
    //   396: new 360	java/lang/RuntimeException
    //   399: dup
    //   400: aload_1
    //   401: aload_0
    //   402: invokevirtual 364	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   405: invokespecial 367	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   408: athrow
    //   409: astore_1
    //   410: aload_1
    //   411: athrow
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   417: iconst_2
    //   418: ior
    //   419: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   422: aload_0
    //   423: aload_2
    //   424: invokevirtual 371	com/google/protobuf/CodedInputStream:readInt64	()J
    //   427: putfield 179	com/google/internal/tango/foi/v1beta1/Foi:token_	J
    //   430: goto -153 -> 277
    //   433: astore_1
    //   434: new 360	java/lang/RuntimeException
    //   437: dup
    //   438: new 247	com/google/protobuf/InvalidProtocolBufferException
    //   441: dup
    //   442: aload_1
    //   443: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   446: invokespecial 376	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   449: aload_0
    //   450: invokevirtual 364	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   453: invokespecial 367	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   456: athrow
    //   457: aconst_null
    //   458: astore_1
    //   459: aload_0
    //   460: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   463: iconst_4
    //   464: iand
    //   465: iconst_4
    //   466: if_icmpne +14 -> 480
    //   469: aload_0
    //   470: getfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   473: invokevirtual 377	com/google/internal/tango/foi/v1beta1/FoiRef:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   476: checkcast 192	com/google/internal/tango/foi/v1beta1/FoiRef$Builder
    //   479: astore_1
    //   480: aload_0
    //   481: aload_2
    //   482: invokestatic 379	com/google/internal/tango/foi/v1beta1/FoiRef:parser	()Lcom/google/protobuf/Parser;
    //   485: aload_3
    //   486: invokevirtual 383	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   489: checkcast 183	com/google/internal/tango/foi/v1beta1/FoiRef
    //   492: putfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   495: aload_1
    //   496: ifnull +23 -> 519
    //   499: aload_1
    //   500: aload_0
    //   501: getfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   504: invokevirtual 196	com/google/internal/tango/foi/v1beta1/FoiRef$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   507: pop
    //   508: aload_0
    //   509: aload_1
    //   510: invokevirtual 200	com/google/internal/tango/foi/v1beta1/FoiRef$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   513: checkcast 183	com/google/internal/tango/foi/v1beta1/FoiRef
    //   516: putfield 175	com/google/internal/tango/foi/v1beta1/Foi:parentFoi_	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   519: aload_0
    //   520: aload_0
    //   521: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   524: iconst_4
    //   525: ior
    //   526: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   529: goto -252 -> 277
    //   532: aconst_null
    //   533: astore_1
    //   534: aload_0
    //   535: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   538: bipush 8
    //   540: iand
    //   541: bipush 8
    //   543: if_icmpne +14 -> 557
    //   546: aload_0
    //   547: getfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   550: invokevirtual 384	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   553: checkcast 222	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder
    //   556: astore_1
    //   557: aload_0
    //   558: aload_2
    //   559: invokestatic 385	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:parser	()Lcom/google/protobuf/Parser;
    //   562: aload_3
    //   563: invokevirtual 383	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   566: checkcast 214	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
    //   569: putfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   572: aload_1
    //   573: ifnull +23 -> 596
    //   576: aload_1
    //   577: aload_0
    //   578: getfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   581: invokevirtual 223	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   584: pop
    //   585: aload_0
    //   586: aload_1
    //   587: invokevirtual 224	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   590: checkcast 214	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
    //   593: putfield 181	com/google/internal/tango/foi/v1beta1/Foi:transformationFromParentFrame_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
    //   596: aload_0
    //   597: aload_0
    //   598: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   601: bipush 8
    //   603: ior
    //   604: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   607: goto -330 -> 277
    //   610: aconst_null
    //   611: astore_1
    //   612: aload_0
    //   613: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   616: bipush 16
    //   618: iand
    //   619: bipush 16
    //   621: if_icmpne +14 -> 635
    //   624: aload_0
    //   625: getfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   628: invokevirtual 386	com/google/location/visualmapping/visualmapstore/TileInfoProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   631: checkcast 210	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder
    //   634: astore_1
    //   635: aload_0
    //   636: aload_2
    //   637: invokestatic 387	com/google/location/visualmapping/visualmapstore/TileInfoProto:parser	()Lcom/google/protobuf/Parser;
    //   640: aload_3
    //   641: invokevirtual 383	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   644: checkcast 202	com/google/location/visualmapping/visualmapstore/TileInfoProto
    //   647: putfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   650: aload_1
    //   651: ifnull +23 -> 674
    //   654: aload_1
    //   655: aload_0
    //   656: getfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   659: invokevirtual 211	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   662: pop
    //   663: aload_0
    //   664: aload_1
    //   665: invokevirtual 212	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   668: checkcast 202	com/google/location/visualmapping/visualmapstore/TileInfoProto
    //   671: putfield 177	com/google/internal/tango/foi/v1beta1/Foi:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
    //   674: aload_0
    //   675: aload_0
    //   676: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   679: bipush 16
    //   681: ior
    //   682: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   685: goto -408 -> 277
    //   688: aload_0
    //   689: aload_0
    //   690: getfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   693: bipush 32
    //   695: ior
    //   696: putfield 162	com/google/internal/tango/foi/v1beta1/Foi:bitField0_	I
    //   699: aload_0
    //   700: aload_2
    //   701: invokevirtual 390	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
    //   704: putfield 66	com/google/internal/tango/foi/v1beta1/Foi:localizationContext_	Lcom/google/protobuf/ByteString;
    //   707: goto -430 -> 277
    //   710: getstatic 50	com/google/internal/tango/foi/v1beta1/Foi:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   713: areturn
    //   714: getstatic 392	com/google/internal/tango/foi/v1beta1/Foi:PARSER	Lcom/google/protobuf/Parser;
    //   717: ifnonnull +28 -> 745
    //   720: ldc 2
    //   722: monitorenter
    //   723: getstatic 392	com/google/internal/tango/foi/v1beta1/Foi:PARSER	Lcom/google/protobuf/Parser;
    //   726: ifnonnull +16 -> 742
    //   729: new 394	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   732: dup
    //   733: getstatic 50	com/google/internal/tango/foi/v1beta1/Foi:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   736: invokespecial 397	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   739: putstatic 392	com/google/internal/tango/foi/v1beta1/Foi:PARSER	Lcom/google/protobuf/Parser;
    //   742: ldc 2
    //   744: monitorexit
    //   745: getstatic 392	com/google/internal/tango/foi/v1beta1/Foi:PARSER	Lcom/google/protobuf/Parser;
    //   748: areturn
    //   749: astore_1
    //   750: ldc 2
    //   752: monitorexit
    //   753: aload_1
    //   754: athrow
    //   755: goto -399 -> 356
    //   758: iconst_1
    //   759: istore 4
    //   761: goto -484 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	Foi
    //   0	764	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	764	2	paramObject1	Object
    //   0	764	3	paramObject2	Object
    //   275	485	4	i	int
    //   286	72	5	j	int
    // Exception table:
    //   from	to	target	type
    //   282	288	395	com/google/protobuf/InvalidProtocolBufferException
    //   356	366	395	com/google/protobuf/InvalidProtocolBufferException
    //   372	392	395	com/google/protobuf/InvalidProtocolBufferException
    //   412	430	395	com/google/protobuf/InvalidProtocolBufferException
    //   459	480	395	com/google/protobuf/InvalidProtocolBufferException
    //   480	495	395	com/google/protobuf/InvalidProtocolBufferException
    //   499	519	395	com/google/protobuf/InvalidProtocolBufferException
    //   519	529	395	com/google/protobuf/InvalidProtocolBufferException
    //   534	557	395	com/google/protobuf/InvalidProtocolBufferException
    //   557	572	395	com/google/protobuf/InvalidProtocolBufferException
    //   576	596	395	com/google/protobuf/InvalidProtocolBufferException
    //   596	607	395	com/google/protobuf/InvalidProtocolBufferException
    //   612	635	395	com/google/protobuf/InvalidProtocolBufferException
    //   635	650	395	com/google/protobuf/InvalidProtocolBufferException
    //   654	674	395	com/google/protobuf/InvalidProtocolBufferException
    //   674	685	395	com/google/protobuf/InvalidProtocolBufferException
    //   688	707	395	com/google/protobuf/InvalidProtocolBufferException
    //   282	288	409	finally
    //   356	366	409	finally
    //   372	392	409	finally
    //   396	409	409	finally
    //   412	430	409	finally
    //   434	457	409	finally
    //   459	480	409	finally
    //   480	495	409	finally
    //   499	519	409	finally
    //   519	529	409	finally
    //   534	557	409	finally
    //   557	572	409	finally
    //   576	596	409	finally
    //   596	607	409	finally
    //   612	635	409	finally
    //   635	650	409	finally
    //   654	674	409	finally
    //   674	685	409	finally
    //   688	707	409	finally
    //   282	288	433	java/io/IOException
    //   356	366	433	java/io/IOException
    //   372	392	433	java/io/IOException
    //   412	430	433	java/io/IOException
    //   459	480	433	java/io/IOException
    //   480	495	433	java/io/IOException
    //   499	519	433	java/io/IOException
    //   519	529	433	java/io/IOException
    //   534	557	433	java/io/IOException
    //   557	572	433	java/io/IOException
    //   576	596	433	java/io/IOException
    //   596	607	433	java/io/IOException
    //   612	635	433	java/io/IOException
    //   635	650	433	java/io/IOException
    //   654	674	433	java/io/IOException
    //   674	685	433	java/io/IOException
    //   688	707	433	java/io/IOException
    //   723	742	749	finally
    //   742	745	749	finally
    //   750	753	749	finally
  }
  
  public String getId()
  {
    return this.id_;
  }
  
  public ByteString getIdBytes()
  {
    return ByteString.copyFromUtf8(this.id_);
  }
  
  public ByteString getLocalizationContext()
  {
    return this.localizationContext_;
  }
  
  public FoiRef getParentFoi()
  {
    if (this.parentFoi_ == null) {
      return FoiRef.getDefaultInstance();
    }
    return this.parentFoi_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeStringSize(1, getId());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt64Size(3, this.token_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeMessageSize(4, getParentFoi());
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeMessageSize(5, getTransformationFromParentFrame());
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeMessageSize(6, getTileInfo());
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeBytesSize(7, this.localizationContext_);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  @Deprecated
  public TileInfoProto getTileInfo()
  {
    if (this.tileInfo_ == null) {
      return TileInfoProto.getDefaultInstance();
    }
    return this.tileInfo_;
  }
  
  public long getToken()
  {
    return this.token_;
  }
  
  public LinearAlgebra.TransformationProto getTransformationFromParentFrame()
  {
    if (this.transformationFromParentFrame_ == null) {
      return LinearAlgebra.TransformationProto.getDefaultInstance();
    }
    return this.transformationFromParentFrame_;
  }
  
  public boolean hasId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasLocalizationContext()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasParentFoi()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  @Deprecated
  public boolean hasTileInfo()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasToken()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasTransformationFromParentFrame()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeString(1, getId());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt64(3, this.token_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(4, getParentFoi());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeMessage(5, getTransformationFromParentFrame());
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeMessage(6, getTileInfo());
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeBytes(7, this.localizationContext_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Foi, Builder>
    implements FoiOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearId()
    {
      copyOnWrite();
      ((Foi)this.instance).clearId();
      return this;
    }
    
    public Builder clearLocalizationContext()
    {
      copyOnWrite();
      ((Foi)this.instance).clearLocalizationContext();
      return this;
    }
    
    public Builder clearParentFoi()
    {
      copyOnWrite();
      ((Foi)this.instance).clearParentFoi();
      return this;
    }
    
    @Deprecated
    public Builder clearTileInfo()
    {
      copyOnWrite();
      ((Foi)this.instance).clearTileInfo();
      return this;
    }
    
    public Builder clearToken()
    {
      copyOnWrite();
      ((Foi)this.instance).clearToken();
      return this;
    }
    
    public Builder clearTransformationFromParentFrame()
    {
      copyOnWrite();
      ((Foi)this.instance).clearTransformationFromParentFrame();
      return this;
    }
    
    public String getId()
    {
      return ((Foi)this.instance).getId();
    }
    
    public ByteString getIdBytes()
    {
      return ((Foi)this.instance).getIdBytes();
    }
    
    public ByteString getLocalizationContext()
    {
      return ((Foi)this.instance).getLocalizationContext();
    }
    
    public FoiRef getParentFoi()
    {
      return ((Foi)this.instance).getParentFoi();
    }
    
    @Deprecated
    public TileInfoProto getTileInfo()
    {
      return ((Foi)this.instance).getTileInfo();
    }
    
    public long getToken()
    {
      return ((Foi)this.instance).getToken();
    }
    
    public LinearAlgebra.TransformationProto getTransformationFromParentFrame()
    {
      return ((Foi)this.instance).getTransformationFromParentFrame();
    }
    
    public boolean hasId()
    {
      return ((Foi)this.instance).hasId();
    }
    
    public boolean hasLocalizationContext()
    {
      return ((Foi)this.instance).hasLocalizationContext();
    }
    
    public boolean hasParentFoi()
    {
      return ((Foi)this.instance).hasParentFoi();
    }
    
    @Deprecated
    public boolean hasTileInfo()
    {
      return ((Foi)this.instance).hasTileInfo();
    }
    
    public boolean hasToken()
    {
      return ((Foi)this.instance).hasToken();
    }
    
    public boolean hasTransformationFromParentFrame()
    {
      return ((Foi)this.instance).hasTransformationFromParentFrame();
    }
    
    public Builder mergeParentFoi(FoiRef paramFoiRef)
    {
      copyOnWrite();
      ((Foi)this.instance).mergeParentFoi(paramFoiRef);
      return this;
    }
    
    @Deprecated
    public Builder mergeTileInfo(TileInfoProto paramTileInfoProto)
    {
      copyOnWrite();
      ((Foi)this.instance).mergeTileInfo(paramTileInfoProto);
      return this;
    }
    
    public Builder mergeTransformationFromParentFrame(LinearAlgebra.TransformationProto paramTransformationProto)
    {
      copyOnWrite();
      ((Foi)this.instance).mergeTransformationFromParentFrame(paramTransformationProto);
      return this;
    }
    
    public Builder setId(String paramString)
    {
      copyOnWrite();
      ((Foi)this.instance).setId(paramString);
      return this;
    }
    
    public Builder setIdBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Foi)this.instance).setIdBytes(paramByteString);
      return this;
    }
    
    public Builder setLocalizationContext(ByteString paramByteString)
    {
      copyOnWrite();
      ((Foi)this.instance).setLocalizationContext(paramByteString);
      return this;
    }
    
    public Builder setParentFoi(FoiRef.Builder paramBuilder)
    {
      copyOnWrite();
      ((Foi)this.instance).setParentFoi(paramBuilder);
      return this;
    }
    
    public Builder setParentFoi(FoiRef paramFoiRef)
    {
      copyOnWrite();
      ((Foi)this.instance).setParentFoi(paramFoiRef);
      return this;
    }
    
    @Deprecated
    public Builder setTileInfo(TileInfoProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((Foi)this.instance).setTileInfo(paramBuilder);
      return this;
    }
    
    @Deprecated
    public Builder setTileInfo(TileInfoProto paramTileInfoProto)
    {
      copyOnWrite();
      ((Foi)this.instance).setTileInfo(paramTileInfoProto);
      return this;
    }
    
    public Builder setToken(long paramLong)
    {
      copyOnWrite();
      ((Foi)this.instance).setToken(paramLong);
      return this;
    }
    
    public Builder setTransformationFromParentFrame(LinearAlgebra.TransformationProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((Foi)this.instance).setTransformationFromParentFrame(paramBuilder);
      return this;
    }
    
    public Builder setTransformationFromParentFrame(LinearAlgebra.TransformationProto paramTransformationProto)
    {
      copyOnWrite();
      ((Foi)this.instance).setTransformationFromParentFrame(paramTransformationProto);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/Foi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */