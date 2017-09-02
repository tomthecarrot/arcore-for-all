package com.google.location.visualmapping.cloudlocalization;

import com.google.location.visualmapping.common.LinearAlgebra.TransformationProto;
import com.google.location.visualmapping.common.LinearAlgebra.TransformationProto.Builder;
import com.google.location.visualmapping.common.QuantizedArray.QuantizedArrayProto;
import com.google.location.visualmapping.common.QuantizedArray.QuantizedArrayProto.Builder;
import com.google.location.visualmapping.visualmapstore.VersionConstantsProto.VersionConstants.SupportedTileParsingVersion;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.FloatList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp.Builder;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class LocalizationQueryData
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class CameraProto
    extends GeneratedMessageLite<CameraProto, Builder>
    implements LocalizationQueryData.CameraProtoOrBuilder
  {
    public static final int CONGAS_IMAGE_FEATURES_FIELD_NUMBER = 3;
    private static final CameraProto DEFAULT_INSTANCE = new CameraProto();
    public static final int FREAK_IMAGE_FEATURES_FIELD_NUMBER = 2;
    public static final int I_T_C_FIELD_NUMBER = 1;
    private static volatile Parser<CameraProto> PARSER;
    private int bitField0_;
    private LocalizationQueryData.CongasImageFeaturesProto congasImageFeatures_;
    private LocalizationQueryData.FreakImageFeaturesProto freakImageFeatures_;
    private LinearAlgebra.TransformationProto iTC_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCongasImageFeatures()
    {
      this.congasImageFeatures_ = null;
      this.bitField0_ &= 0xFFFFFFFB;
    }
    
    private void clearFreakImageFeatures()
    {
      this.freakImageFeatures_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearITC()
    {
      this.iTC_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    public static CameraProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto paramCongasImageFeaturesProto)
    {
      if ((this.congasImageFeatures_ != null) && (this.congasImageFeatures_ != LocalizationQueryData.CongasImageFeaturesProto.getDefaultInstance())) {}
      for (this.congasImageFeatures_ = ((LocalizationQueryData.CongasImageFeaturesProto)((LocalizationQueryData.CongasImageFeaturesProto.Builder)LocalizationQueryData.CongasImageFeaturesProto.newBuilder(this.congasImageFeatures_).mergeFrom(paramCongasImageFeaturesProto)).buildPartial());; this.congasImageFeatures_ = paramCongasImageFeaturesProto)
      {
        this.bitField0_ |= 0x4;
        return;
      }
    }
    
    private void mergeFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto paramFreakImageFeaturesProto)
    {
      if ((this.freakImageFeatures_ != null) && (this.freakImageFeatures_ != LocalizationQueryData.FreakImageFeaturesProto.getDefaultInstance())) {}
      for (this.freakImageFeatures_ = ((LocalizationQueryData.FreakImageFeaturesProto)((LocalizationQueryData.FreakImageFeaturesProto.Builder)LocalizationQueryData.FreakImageFeaturesProto.newBuilder(this.freakImageFeatures_).mergeFrom(paramFreakImageFeaturesProto)).buildPartial());; this.freakImageFeatures_ = paramFreakImageFeaturesProto)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    private void mergeITC(LinearAlgebra.TransformationProto paramTransformationProto)
    {
      if ((this.iTC_ != null) && (this.iTC_ != LinearAlgebra.TransformationProto.getDefaultInstance())) {}
      for (this.iTC_ = ((LinearAlgebra.TransformationProto)((LinearAlgebra.TransformationProto.Builder)LinearAlgebra.TransformationProto.newBuilder(this.iTC_).mergeFrom(paramTransformationProto)).buildPartial());; this.iTC_ = paramTransformationProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CameraProto paramCameraProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCameraProto);
    }
    
    public static CameraProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CameraProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CameraProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CameraProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CameraProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static CameraProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static CameraProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static CameraProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static CameraProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CameraProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CameraProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static CameraProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CameraProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<CameraProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto.Builder paramBuilder)
    {
      this.congasImageFeatures_ = ((LocalizationQueryData.CongasImageFeaturesProto)paramBuilder.build());
      this.bitField0_ |= 0x4;
    }
    
    private void setCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto paramCongasImageFeaturesProto)
    {
      if (paramCongasImageFeaturesProto == null) {
        throw new NullPointerException();
      }
      this.congasImageFeatures_ = paramCongasImageFeaturesProto;
      this.bitField0_ |= 0x4;
    }
    
    private void setFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto.Builder paramBuilder)
    {
      this.freakImageFeatures_ = ((LocalizationQueryData.FreakImageFeaturesProto)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto paramFreakImageFeaturesProto)
    {
      if (paramFreakImageFeaturesProto == null) {
        throw new NullPointerException();
      }
      this.freakImageFeatures_ = paramFreakImageFeaturesProto;
      this.bitField0_ |= 0x2;
    }
    
    private void setITC(LinearAlgebra.TransformationProto.Builder paramBuilder)
    {
      this.iTC_ = ((LinearAlgebra.TransformationProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setITC(LinearAlgebra.TransformationProto paramTransformationProto)
    {
      if (paramTransformationProto == null) {
        throw new NullPointerException();
      }
      this.iTC_ = paramTransformationProto;
      this.bitField0_ |= 0x1;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 229	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 235	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+178->186, 7:+530->538, 8:+534->542
      //   56: new 237	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 238	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto
      //   67: dup
      //   68: invokespecial 37	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 39	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 241	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto$Builder:<init>	(Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 243	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   105: aload_3
      //   106: getfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   109: invokeinterface 247 3 0
      //   114: checkcast 146	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
      //   117: putfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   120: aload_0
      //   121: aload_2
      //   122: aload_0
      //   123: getfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   126: aload_3
      //   127: getfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   130: invokeinterface 247 3 0
      //   135: checkcast 134	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto
      //   138: putfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   141: aload_0
      //   142: aload_2
      //   143: aload_0
      //   144: getfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   147: aload_3
      //   148: getfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   151: invokeinterface 247 3 0
      //   156: checkcast 115	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto
      //   159: putfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   162: aload_0
      //   163: astore_1
      //   164: aload_2
      //   165: getstatic 253	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   168: if_acmpne -96 -> 72
      //   171: aload_0
      //   172: aload_0
      //   173: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   176: aload_3
      //   177: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   180: ior
      //   181: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   184: aload_0
      //   185: areturn
      //   186: aload_2
      //   187: checkcast 255	com/google/protobuf/CodedInputStream
      //   190: astore_2
      //   191: aload_3
      //   192: checkcast 257	com/google/protobuf/ExtensionRegistryLite
      //   195: astore_3
      //   196: iconst_0
      //   197: istore 4
      //   199: iload 4
      //   201: ifne +337 -> 538
      //   204: aload_2
      //   205: invokevirtual 260	com/google/protobuf/CodedInputStream:readTag	()I
      //   208: istore 5
      //   210: iload 5
      //   212: lookupswitch	default:+371->583, 0:+374->586, 10:+60->272, 18:+152->364, 26:+251->463
      //   256: aload_0
      //   257: iload 5
      //   259: aload_2
      //   260: invokevirtual 264	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   263: ifne -64 -> 199
      //   266: iconst_1
      //   267: istore 4
      //   269: goto -70 -> 199
      //   272: aconst_null
      //   273: astore_1
      //   274: aload_0
      //   275: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   278: iconst_1
      //   279: iand
      //   280: iconst_1
      //   281: if_icmpne +14 -> 295
      //   284: aload_0
      //   285: getfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   288: invokevirtual 265	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   291: checkcast 154	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder
      //   294: astore_1
      //   295: aload_0
      //   296: aload_2
      //   297: invokestatic 267	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:parser	()Lcom/google/protobuf/Parser;
      //   300: aload_3
      //   301: invokevirtual 271	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   304: checkcast 146	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
      //   307: putfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   310: aload_1
      //   311: ifnull +23 -> 334
      //   314: aload_1
      //   315: aload_0
      //   316: getfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   319: invokevirtual 155	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   322: pop
      //   323: aload_0
      //   324: aload_1
      //   325: invokevirtual 156	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   328: checkcast 146	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
      //   331: putfield 112	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:iTC_	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   334: aload_0
      //   335: aload_0
      //   336: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   339: iconst_1
      //   340: ior
      //   341: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   344: goto -145 -> 199
      //   347: astore_1
      //   348: new 273	java/lang/RuntimeException
      //   351: dup
      //   352: aload_1
      //   353: aload_0
      //   354: invokevirtual 277	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   357: invokespecial 280	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   360: athrow
      //   361: astore_1
      //   362: aload_1
      //   363: athrow
      //   364: aconst_null
      //   365: astore_1
      //   366: aload_0
      //   367: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   370: iconst_2
      //   371: iand
      //   372: iconst_2
      //   373: if_icmpne +14 -> 387
      //   376: aload_0
      //   377: getfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   380: invokevirtual 281	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   383: checkcast 142	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto$Builder
      //   386: astore_1
      //   387: aload_0
      //   388: aload_2
      //   389: invokestatic 282	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:parser	()Lcom/google/protobuf/Parser;
      //   392: aload_3
      //   393: invokevirtual 271	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   396: checkcast 134	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto
      //   399: putfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   402: aload_1
      //   403: ifnull +23 -> 426
      //   406: aload_1
      //   407: aload_0
      //   408: getfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   411: invokevirtual 143	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   414: pop
      //   415: aload_0
      //   416: aload_1
      //   417: invokevirtual 144	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   420: checkcast 134	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto
      //   423: putfield 110	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:freakImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   426: aload_0
      //   427: aload_0
      //   428: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   431: iconst_2
      //   432: ior
      //   433: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   436: goto -237 -> 199
      //   439: astore_1
      //   440: new 273	java/lang/RuntimeException
      //   443: dup
      //   444: new 179	com/google/protobuf/InvalidProtocolBufferException
      //   447: dup
      //   448: aload_1
      //   449: invokevirtual 286	java/io/IOException:getMessage	()Ljava/lang/String;
      //   452: invokespecial 289	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   455: aload_0
      //   456: invokevirtual 277	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   459: invokespecial 280	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   462: athrow
      //   463: aconst_null
      //   464: astore_1
      //   465: aload_0
      //   466: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   469: iconst_4
      //   470: iand
      //   471: iconst_4
      //   472: if_icmpne +14 -> 486
      //   475: aload_0
      //   476: getfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   479: invokevirtual 290	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   482: checkcast 124	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto$Builder
      //   485: astore_1
      //   486: aload_0
      //   487: aload_2
      //   488: invokestatic 291	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:parser	()Lcom/google/protobuf/Parser;
      //   491: aload_3
      //   492: invokevirtual 271	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   495: checkcast 115	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto
      //   498: putfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   501: aload_1
      //   502: ifnull +23 -> 525
      //   505: aload_1
      //   506: aload_0
      //   507: getfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   510: invokevirtual 128	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   513: pop
      //   514: aload_0
      //   515: aload_1
      //   516: invokevirtual 132	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   519: checkcast 115	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto
      //   522: putfield 106	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:congasImageFeatures_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   525: aload_0
      //   526: aload_0
      //   527: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   530: iconst_4
      //   531: ior
      //   532: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:bitField0_	I
      //   535: goto -336 -> 199
      //   538: getstatic 39	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto;
      //   541: areturn
      //   542: getstatic 293	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:PARSER	Lcom/google/protobuf/Parser;
      //   545: ifnonnull +28 -> 573
      //   548: ldc 2
      //   550: monitorenter
      //   551: getstatic 293	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:PARSER	Lcom/google/protobuf/Parser;
      //   554: ifnonnull +16 -> 570
      //   557: new 295	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   560: dup
      //   561: getstatic 39	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto;
      //   564: invokespecial 298	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   567: putstatic 293	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:PARSER	Lcom/google/protobuf/Parser;
      //   570: ldc 2
      //   572: monitorexit
      //   573: getstatic 293	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CameraProto:PARSER	Lcom/google/protobuf/Parser;
      //   576: areturn
      //   577: astore_1
      //   578: ldc 2
      //   580: monitorexit
      //   581: aload_1
      //   582: athrow
      //   583: goto -327 -> 256
      //   586: iconst_1
      //   587: istore 4
      //   589: goto -390 -> 199
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	592	0	this	CameraProto
      //   0	592	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	592	2	paramObject1	Object
      //   0	592	3	paramObject2	Object
      //   197	391	4	i	int
      //   208	50	5	j	int
      // Exception table:
      //   from	to	target	type
      //   204	210	347	com/google/protobuf/InvalidProtocolBufferException
      //   256	266	347	com/google/protobuf/InvalidProtocolBufferException
      //   274	295	347	com/google/protobuf/InvalidProtocolBufferException
      //   295	310	347	com/google/protobuf/InvalidProtocolBufferException
      //   314	334	347	com/google/protobuf/InvalidProtocolBufferException
      //   334	344	347	com/google/protobuf/InvalidProtocolBufferException
      //   366	387	347	com/google/protobuf/InvalidProtocolBufferException
      //   387	402	347	com/google/protobuf/InvalidProtocolBufferException
      //   406	426	347	com/google/protobuf/InvalidProtocolBufferException
      //   426	436	347	com/google/protobuf/InvalidProtocolBufferException
      //   465	486	347	com/google/protobuf/InvalidProtocolBufferException
      //   486	501	347	com/google/protobuf/InvalidProtocolBufferException
      //   505	525	347	com/google/protobuf/InvalidProtocolBufferException
      //   525	535	347	com/google/protobuf/InvalidProtocolBufferException
      //   204	210	361	finally
      //   256	266	361	finally
      //   274	295	361	finally
      //   295	310	361	finally
      //   314	334	361	finally
      //   334	344	361	finally
      //   348	361	361	finally
      //   366	387	361	finally
      //   387	402	361	finally
      //   406	426	361	finally
      //   426	436	361	finally
      //   440	463	361	finally
      //   465	486	361	finally
      //   486	501	361	finally
      //   505	525	361	finally
      //   525	535	361	finally
      //   204	210	439	java/io/IOException
      //   256	266	439	java/io/IOException
      //   274	295	439	java/io/IOException
      //   295	310	439	java/io/IOException
      //   314	334	439	java/io/IOException
      //   334	344	439	java/io/IOException
      //   366	387	439	java/io/IOException
      //   387	402	439	java/io/IOException
      //   406	426	439	java/io/IOException
      //   426	436	439	java/io/IOException
      //   465	486	439	java/io/IOException
      //   486	501	439	java/io/IOException
      //   505	525	439	java/io/IOException
      //   525	535	439	java/io/IOException
      //   551	570	577	finally
      //   570	573	577	finally
      //   578	581	577	finally
    }
    
    public LocalizationQueryData.CongasImageFeaturesProto getCongasImageFeatures()
    {
      if (this.congasImageFeatures_ == null) {
        return LocalizationQueryData.CongasImageFeaturesProto.getDefaultInstance();
      }
      return this.congasImageFeatures_;
    }
    
    public LocalizationQueryData.FreakImageFeaturesProto getFreakImageFeatures()
    {
      if (this.freakImageFeatures_ == null) {
        return LocalizationQueryData.FreakImageFeaturesProto.getDefaultInstance();
      }
      return this.freakImageFeatures_;
    }
    
    public LinearAlgebra.TransformationProto getITC()
    {
      if (this.iTC_ == null) {
        return LinearAlgebra.TransformationProto.getDefaultInstance();
      }
      return this.iTC_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeMessageSize(1, getITC());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeMessageSize(2, getFreakImageFeatures());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeMessageSize(3, getCongasImageFeatures());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCongasImageFeatures()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasFreakImageFeatures()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasITC()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getITC());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, getFreakImageFeatures());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeMessage(3, getCongasImageFeatures());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationQueryData.CameraProto, Builder>
      implements LocalizationQueryData.CameraProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearCongasImageFeatures()
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).clearCongasImageFeatures();
        return this;
      }
      
      public Builder clearFreakImageFeatures()
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).clearFreakImageFeatures();
        return this;
      }
      
      public Builder clearITC()
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).clearITC();
        return this;
      }
      
      public LocalizationQueryData.CongasImageFeaturesProto getCongasImageFeatures()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).getCongasImageFeatures();
      }
      
      public LocalizationQueryData.FreakImageFeaturesProto getFreakImageFeatures()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).getFreakImageFeatures();
      }
      
      public LinearAlgebra.TransformationProto getITC()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).getITC();
      }
      
      public boolean hasCongasImageFeatures()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).hasCongasImageFeatures();
      }
      
      public boolean hasFreakImageFeatures()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).hasFreakImageFeatures();
      }
      
      public boolean hasITC()
      {
        return ((LocalizationQueryData.CameraProto)this.instance).hasITC();
      }
      
      public Builder mergeCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto paramCongasImageFeaturesProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).mergeCongasImageFeatures(paramCongasImageFeaturesProto);
        return this;
      }
      
      public Builder mergeFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto paramFreakImageFeaturesProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).mergeFreakImageFeatures(paramFreakImageFeaturesProto);
        return this;
      }
      
      public Builder mergeITC(LinearAlgebra.TransformationProto paramTransformationProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).mergeITC(paramTransformationProto);
        return this;
      }
      
      public Builder setCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setCongasImageFeatures(paramBuilder);
        return this;
      }
      
      public Builder setCongasImageFeatures(LocalizationQueryData.CongasImageFeaturesProto paramCongasImageFeaturesProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setCongasImageFeatures(paramCongasImageFeaturesProto);
        return this;
      }
      
      public Builder setFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setFreakImageFeatures(paramBuilder);
        return this;
      }
      
      public Builder setFreakImageFeatures(LocalizationQueryData.FreakImageFeaturesProto paramFreakImageFeaturesProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setFreakImageFeatures(paramFreakImageFeaturesProto);
        return this;
      }
      
      public Builder setITC(LinearAlgebra.TransformationProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setITC(paramBuilder);
        return this;
      }
      
      public Builder setITC(LinearAlgebra.TransformationProto paramTransformationProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CameraProto)this.instance).setITC(paramTransformationProto);
        return this;
      }
    }
  }
  
  public static abstract interface CameraProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract LocalizationQueryData.CongasImageFeaturesProto getCongasImageFeatures();
    
    public abstract LocalizationQueryData.FreakImageFeaturesProto getFreakImageFeatures();
    
    public abstract LinearAlgebra.TransformationProto getITC();
    
    public abstract boolean hasCongasImageFeatures();
    
    public abstract boolean hasFreakImageFeatures();
    
    public abstract boolean hasITC();
  }
  
  public static final class CompressedFreakDescriptorsProto
    extends GeneratedMessageLite<CompressedFreakDescriptorsProto, Builder>
    implements LocalizationQueryData.CompressedFreakDescriptorsProtoOrBuilder
  {
    private static final CompressedFreakDescriptorsProto DEFAULT_INSTANCE = new CompressedFreakDescriptorsProto();
    public static final int NUM_BYTES_PER_DESCRIPTOR_FIELD_NUMBER = 2;
    public static final int ORDERED_SAMPLING_POINT_BYTES_FIELD_NUMBER = 1;
    private static volatile Parser<CompressedFreakDescriptorsProto> PARSER;
    private int bitField0_;
    private int numBytesPerDescriptor_;
    private ByteString orderedSamplingPointBytes_ = ByteString.EMPTY;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearNumBytesPerDescriptor()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.numBytesPerDescriptor_ = 0;
    }
    
    private void clearOrderedSamplingPointBytes()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.orderedSamplingPointBytes_ = getDefaultInstance().getOrderedSamplingPointBytes();
    }
    
    public static CompressedFreakDescriptorsProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CompressedFreakDescriptorsProto paramCompressedFreakDescriptorsProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCompressedFreakDescriptorsProto);
    }
    
    public static CompressedFreakDescriptorsProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CompressedFreakDescriptorsProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static CompressedFreakDescriptorsProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CompressedFreakDescriptorsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<CompressedFreakDescriptorsProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setNumBytesPerDescriptor(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.numBytesPerDescriptor_ = paramInt;
    }
    
    private void setOrderedSamplingPointBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.orderedSamplingPointBytes_ = paramByteString;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 152	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 158	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
      //   56: new 160	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 161	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto
      //   67: dup
      //   68: invokespecial 32	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 164	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto$Builder:<init>	(Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 166	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 170	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:hasOrderedSamplingPointBytes	()Z
      //   105: aload_0
      //   106: getfield 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:orderedSamplingPointBytes_	Lcom/google/protobuf/ByteString;
      //   109: aload_3
      //   110: invokevirtual 170	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:hasOrderedSamplingPointBytes	()Z
      //   113: aload_3
      //   114: getfield 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:orderedSamplingPointBytes_	Lcom/google/protobuf/ByteString;
      //   117: invokeinterface 174 5 0
      //   122: putfield 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:orderedSamplingPointBytes_	Lcom/google/protobuf/ByteString;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 177	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:hasNumBytesPerDescriptor	()Z
      //   131: aload_0
      //   132: getfield 73	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:numBytesPerDescriptor_	I
      //   135: aload_3
      //   136: invokevirtual 177	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:hasNumBytesPerDescriptor	()Z
      //   139: aload_3
      //   140: getfield 73	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:numBytesPerDescriptor_	I
      //   143: invokeinterface 181 5 0
      //   148: putfield 73	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:numBytesPerDescriptor_	I
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 187	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   165: aload_3
      //   166: getfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   169: ior
      //   170: putfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 189	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 191	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +145 -> 335
      //   193: aload_1
      //   194: invokevirtual 194	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+179->380, 0:+182->383, 10:+51->252, 16:+89->290
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 198	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 201	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
      //   267: putfield 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:orderedSamplingPointBytes_	Lcom/google/protobuf/ByteString;
      //   270: goto -82 -> 188
      //   273: astore_1
      //   274: new 203	java/lang/RuntimeException
      //   277: dup
      //   278: aload_1
      //   279: aload_0
      //   280: invokevirtual 207	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   283: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   286: athrow
      //   287: astore_1
      //   288: aload_1
      //   289: athrow
      //   290: aload_0
      //   291: aload_0
      //   292: getfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   295: iconst_2
      //   296: ior
      //   297: putfield 71	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:bitField0_	I
      //   300: aload_0
      //   301: aload_1
      //   302: invokevirtual 213	com/google/protobuf/CodedInputStream:readInt32	()I
      //   305: putfield 73	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:numBytesPerDescriptor_	I
      //   308: goto -120 -> 188
      //   311: astore_1
      //   312: new 203	java/lang/RuntimeException
      //   315: dup
      //   316: new 107	com/google/protobuf/InvalidProtocolBufferException
      //   319: dup
      //   320: aload_1
      //   321: invokevirtual 217	java/io/IOException:getMessage	()Ljava/lang/String;
      //   324: invokespecial 220	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   327: aload_0
      //   328: invokevirtual 207	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   331: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   334: athrow
      //   335: getstatic 34	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   338: areturn
      //   339: getstatic 222	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:PARSER	Lcom/google/protobuf/Parser;
      //   342: ifnonnull +28 -> 370
      //   345: ldc 2
      //   347: monitorenter
      //   348: getstatic 222	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:PARSER	Lcom/google/protobuf/Parser;
      //   351: ifnonnull +16 -> 367
      //   354: new 224	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   357: dup
      //   358: getstatic 34	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   361: invokespecial 227	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   364: putstatic 222	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:PARSER	Lcom/google/protobuf/Parser;
      //   367: ldc 2
      //   369: monitorexit
      //   370: getstatic 222	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:PARSER	Lcom/google/protobuf/Parser;
      //   373: areturn
      //   374: astore_1
      //   375: ldc 2
      //   377: monitorexit
      //   378: aload_1
      //   379: athrow
      //   380: goto -144 -> 236
      //   383: iconst_1
      //   384: istore 4
      //   386: goto -198 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	389	0	this	CompressedFreakDescriptorsProto
      //   0	389	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	389	2	paramObject1	Object
      //   0	389	3	paramObject2	Object
      //   186	199	4	i	int
      //   197	41	5	j	int
      // Exception table:
      //   from	to	target	type
      //   193	199	273	com/google/protobuf/InvalidProtocolBufferException
      //   236	246	273	com/google/protobuf/InvalidProtocolBufferException
      //   252	270	273	com/google/protobuf/InvalidProtocolBufferException
      //   290	308	273	com/google/protobuf/InvalidProtocolBufferException
      //   193	199	287	finally
      //   236	246	287	finally
      //   252	270	287	finally
      //   274	287	287	finally
      //   290	308	287	finally
      //   312	335	287	finally
      //   193	199	311	java/io/IOException
      //   236	246	311	java/io/IOException
      //   252	270	311	java/io/IOException
      //   290	308	311	java/io/IOException
      //   348	367	374	finally
      //   367	370	374	finally
      //   375	378	374	finally
    }
    
    public int getNumBytesPerDescriptor()
    {
      return this.numBytesPerDescriptor_;
    }
    
    public ByteString getOrderedSamplingPointBytes()
    {
      return this.orderedSamplingPointBytes_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeBytesSize(1, this.orderedSamplingPointBytes_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeInt32Size(2, this.numBytesPerDescriptor_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasNumBytesPerDescriptor()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasOrderedSamplingPointBytes()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeBytes(1, this.orderedSamplingPointBytes_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeInt32(2, this.numBytesPerDescriptor_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationQueryData.CompressedFreakDescriptorsProto, Builder>
      implements LocalizationQueryData.CompressedFreakDescriptorsProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearNumBytesPerDescriptor()
      {
        copyOnWrite();
        ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).clearNumBytesPerDescriptor();
        return this;
      }
      
      public Builder clearOrderedSamplingPointBytes()
      {
        copyOnWrite();
        ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).clearOrderedSamplingPointBytes();
        return this;
      }
      
      public int getNumBytesPerDescriptor()
      {
        return ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).getNumBytesPerDescriptor();
      }
      
      public ByteString getOrderedSamplingPointBytes()
      {
        return ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).getOrderedSamplingPointBytes();
      }
      
      public boolean hasNumBytesPerDescriptor()
      {
        return ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).hasNumBytesPerDescriptor();
      }
      
      public boolean hasOrderedSamplingPointBytes()
      {
        return ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).hasOrderedSamplingPointBytes();
      }
      
      public Builder setNumBytesPerDescriptor(int paramInt)
      {
        copyOnWrite();
        ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).setNumBytesPerDescriptor(paramInt);
        return this;
      }
      
      public Builder setOrderedSamplingPointBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((LocalizationQueryData.CompressedFreakDescriptorsProto)this.instance).setOrderedSamplingPointBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface CompressedFreakDescriptorsProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract int getNumBytesPerDescriptor();
    
    public abstract ByteString getOrderedSamplingPointBytes();
    
    public abstract boolean hasNumBytesPerDescriptor();
    
    public abstract boolean hasOrderedSamplingPointBytes();
  }
  
  public static final class CongasImageFeaturesProto
    extends GeneratedMessageLite<CongasImageFeaturesProto, Builder>
    implements LocalizationQueryData.CongasImageFeaturesProtoOrBuilder
  {
    public static final int DATA_FACTOR_FIELD_NUMBER = 3;
    public static final int DATA_FIELD_NUMBER = 4;
    private static final CongasImageFeaturesProto DEFAULT_INSTANCE = new CongasImageFeaturesProto();
    public static final int FEATURE_ORIENTATIONS_FIELD_NUMBER = 5;
    public static final int NORMALIZED_MEASUREMENTS_FIELD_NUMBER = 2;
    public static final int NUM_FEATURES_FIELD_NUMBER = 1;
    private static volatile Parser<CongasImageFeaturesProto> PARSER;
    private int bitField0_;
    private int dataFactorMemoizedSerializedSize = -1;
    private Internal.FloatList dataFactor_ = emptyFloatList();
    private ByteString data_ = ByteString.EMPTY;
    private QuantizedArray.QuantizedArrayProto featureOrientations_;
    private QuantizedArray.QuantizedArrayProto normalizedMeasurements_;
    private int numFeatures_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllDataFactor(Iterable<? extends Float> paramIterable)
    {
      ensureDataFactorIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.dataFactor_);
    }
    
    private void addDataFactor(float paramFloat)
    {
      ensureDataFactorIsMutable();
      this.dataFactor_.addFloat(paramFloat);
    }
    
    private void clearData()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.data_ = getDefaultInstance().getData();
    }
    
    private void clearDataFactor()
    {
      this.dataFactor_ = emptyFloatList();
    }
    
    private void clearFeatureOrientations()
    {
      this.featureOrientations_ = null;
      this.bitField0_ &= 0xFFFFFFF7;
    }
    
    private void clearNormalizedMeasurements()
    {
      this.normalizedMeasurements_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearNumFeatures()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.numFeatures_ = 0;
    }
    
    private void ensureDataFactorIsMutable()
    {
      if (!this.dataFactor_.isModifiable()) {
        this.dataFactor_ = GeneratedMessageLite.mutableCopy(this.dataFactor_);
      }
    }
    
    public static CongasImageFeaturesProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if ((this.featureOrientations_ != null) && (this.featureOrientations_ != QuantizedArray.QuantizedArrayProto.getDefaultInstance())) {}
      for (this.featureOrientations_ = ((QuantizedArray.QuantizedArrayProto)((QuantizedArray.QuantizedArrayProto.Builder)QuantizedArray.QuantizedArrayProto.newBuilder(this.featureOrientations_).mergeFrom(paramQuantizedArrayProto)).buildPartial());; this.featureOrientations_ = paramQuantizedArrayProto)
      {
        this.bitField0_ |= 0x8;
        return;
      }
    }
    
    private void mergeNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if ((this.normalizedMeasurements_ != null) && (this.normalizedMeasurements_ != QuantizedArray.QuantizedArrayProto.getDefaultInstance())) {}
      for (this.normalizedMeasurements_ = ((QuantizedArray.QuantizedArrayProto)((QuantizedArray.QuantizedArrayProto.Builder)QuantizedArray.QuantizedArrayProto.newBuilder(this.normalizedMeasurements_).mergeFrom(paramQuantizedArrayProto)).buildPartial());; this.normalizedMeasurements_ = paramQuantizedArrayProto)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CongasImageFeaturesProto paramCongasImageFeaturesProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCongasImageFeaturesProto);
    }
    
    public static CongasImageFeaturesProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CongasImageFeaturesProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CongasImageFeaturesProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CongasImageFeaturesProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CongasImageFeaturesProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static CongasImageFeaturesProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static CongasImageFeaturesProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static CongasImageFeaturesProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static CongasImageFeaturesProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CongasImageFeaturesProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CongasImageFeaturesProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static CongasImageFeaturesProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CongasImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<CongasImageFeaturesProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setData(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.data_ = paramByteString;
    }
    
    private void setDataFactor(int paramInt, float paramFloat)
    {
      ensureDataFactorIsMutable();
      this.dataFactor_.setFloat(paramInt, paramFloat);
    }
    
    private void setFeatureOrientations(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
    {
      this.featureOrientations_ = ((QuantizedArray.QuantizedArrayProto)paramBuilder.build());
      this.bitField0_ |= 0x8;
    }
    
    private void setFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if (paramQuantizedArrayProto == null) {
        throw new NullPointerException();
      }
      this.featureOrientations_ = paramQuantizedArrayProto;
      this.bitField0_ |= 0x8;
    }
    
    private void setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
    {
      this.normalizedMeasurements_ = ((QuantizedArray.QuantizedArrayProto)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if (paramQuantizedArrayProto == null) {
        throw new NullPointerException();
      }
      this.normalizedMeasurements_ = paramQuantizedArrayProto;
      this.bitField0_ |= 0x2;
    }
    
    private void setNumFeatures(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.numFeatures_ = paramInt;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 277	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 283	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+236->244, 7:+715->723, 8:+719->727
      //   56: new 285	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 286	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto
      //   67: dup
      //   68: invokespecial 44	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   82: invokeinterface 287 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 290	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto$Builder:<init>	(Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 292	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:hasNumFeatures	()Z
      //   114: aload_0
      //   115: getfield 176	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:numFeatures_	I
      //   118: aload_3
      //   119: invokevirtual 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:hasNumFeatures	()Z
      //   122: aload_3
      //   123: getfield 176	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:numFeatures_	I
      //   126: invokeinterface 299 5 0
      //   131: putfield 176	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:numFeatures_	I
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: getfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   140: aload_3
      //   141: getfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   144: invokeinterface 303 3 0
      //   149: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   152: putfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   155: aload_0
      //   156: aload_2
      //   157: aload_0
      //   158: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   161: aload_3
      //   162: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   165: invokeinterface 307 3 0
      //   170: putfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   173: aload_0
      //   174: aload_2
      //   175: aload_0
      //   176: invokevirtual 310	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:hasData	()Z
      //   179: aload_0
      //   180: getfield 66	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:data_	Lcom/google/protobuf/ByteString;
      //   183: aload_3
      //   184: invokevirtual 310	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:hasData	()Z
      //   187: aload_3
      //   188: getfield 66	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:data_	Lcom/google/protobuf/ByteString;
      //   191: invokeinterface 314 5 0
      //   196: putfield 66	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:data_	Lcom/google/protobuf/ByteString;
      //   199: aload_0
      //   200: aload_2
      //   201: aload_0
      //   202: getfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   205: aload_3
      //   206: getfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   209: invokeinterface 303 3 0
      //   214: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   217: putfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   220: aload_0
      //   221: astore_1
      //   222: aload_2
      //   223: getstatic 320	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   226: if_acmpne -154 -> 72
      //   229: aload_0
      //   230: aload_0
      //   231: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   234: aload_3
      //   235: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   238: ior
      //   239: putfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   242: aload_0
      //   243: areturn
      //   244: aload_2
      //   245: checkcast 322	com/google/protobuf/CodedInputStream
      //   248: astore_2
      //   249: aload_3
      //   250: checkcast 324	com/google/protobuf/ExtensionRegistryLite
      //   253: astore_3
      //   254: iconst_0
      //   255: istore 4
      //   257: iload 4
      //   259: ifne +464 -> 723
      //   262: aload_2
      //   263: invokevirtual 327	com/google/protobuf/CodedInputStream:readTag	()I
      //   266: istore 5
      //   268: iload 5
      //   270: lookupswitch	default:+498->768, 0:+501->771, 8:+82->352, 18:+120->390, 26:+258->528, 29:+219->489, 34:+354->624, 42:+375->645
      //   336: aload_0
      //   337: iload 5
      //   339: aload_2
      //   340: invokevirtual 331	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   343: ifne -86 -> 257
      //   346: iconst_1
      //   347: istore 4
      //   349: goto -92 -> 257
      //   352: aload_0
      //   353: aload_0
      //   354: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   357: iconst_1
      //   358: ior
      //   359: putfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   362: aload_0
      //   363: aload_2
      //   364: invokevirtual 334	com/google/protobuf/CodedInputStream:readInt32	()I
      //   367: putfield 176	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:numFeatures_	I
      //   370: goto -113 -> 257
      //   373: astore_1
      //   374: new 336	java/lang/RuntimeException
      //   377: dup
      //   378: aload_1
      //   379: aload_0
      //   380: invokevirtual 340	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   383: invokespecial 343	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   386: athrow
      //   387: astore_1
      //   388: aload_1
      //   389: athrow
      //   390: aconst_null
      //   391: astore_1
      //   392: aload_0
      //   393: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   396: iconst_2
      //   397: iand
      //   398: iconst_2
      //   399: if_icmpne +14 -> 413
      //   402: aload_0
      //   403: getfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   406: invokevirtual 344	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   409: checkcast 195	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder
      //   412: astore_1
      //   413: aload_0
      //   414: aload_2
      //   415: invokestatic 346	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:parser	()Lcom/google/protobuf/Parser;
      //   418: aload_3
      //   419: invokevirtual 350	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   422: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   425: putfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   428: aload_1
      //   429: ifnull +23 -> 452
      //   432: aload_1
      //   433: aload_0
      //   434: getfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   437: invokevirtual 199	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   440: pop
      //   441: aload_0
      //   442: aload_1
      //   443: invokevirtual 203	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   446: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   449: putfield 174	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   452: aload_0
      //   453: aload_0
      //   454: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   457: iconst_2
      //   458: ior
      //   459: putfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   462: goto -205 -> 257
      //   465: astore_1
      //   466: new 336	java/lang/RuntimeException
      //   469: dup
      //   470: new 226	com/google/protobuf/InvalidProtocolBufferException
      //   473: dup
      //   474: aload_1
      //   475: invokevirtual 354	java/io/IOException:getMessage	()Ljava/lang/String;
      //   478: invokespecial 357	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   481: aload_0
      //   482: invokevirtual 340	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   485: invokespecial 343	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   488: athrow
      //   489: aload_0
      //   490: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   493: invokeinterface 180 1 0
      //   498: ifne +14 -> 512
      //   501: aload_0
      //   502: aload_0
      //   503: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   506: invokestatic 184	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$FloatList;)Lcom/google/protobuf/Internal$FloatList;
      //   509: putfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   512: aload_0
      //   513: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   516: aload_2
      //   517: invokevirtual 361	com/google/protobuf/CodedInputStream:readFloat	()F
      //   520: invokeinterface 161 2 0
      //   525: goto -268 -> 257
      //   528: aload_2
      //   529: invokevirtual 364	com/google/protobuf/CodedInputStream:readRawVarint32	()I
      //   532: istore 5
      //   534: aload_2
      //   535: iload 5
      //   537: invokevirtual 368	com/google/protobuf/CodedInputStream:pushLimit	(I)I
      //   540: istore 6
      //   542: aload_0
      //   543: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   546: invokeinterface 180 1 0
      //   551: ifne +41 -> 592
      //   554: aload_2
      //   555: invokevirtual 371	com/google/protobuf/CodedInputStream:getBytesUntilLimit	()I
      //   558: ifle +34 -> 592
      //   561: aload_0
      //   562: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   565: invokeinterface 374 1 0
      //   570: istore 7
      //   572: aload_0
      //   573: aload_0
      //   574: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   577: iload 5
      //   579: iconst_4
      //   580: idiv
      //   581: iload 7
      //   583: iadd
      //   584: invokeinterface 378 2 0
      //   589: putfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   592: aload_2
      //   593: invokevirtual 371	com/google/protobuf/CodedInputStream:getBytesUntilLimit	()I
      //   596: ifle +19 -> 615
      //   599: aload_0
      //   600: getfield 59	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:dataFactor_	Lcom/google/protobuf/Internal$FloatList;
      //   603: aload_2
      //   604: invokevirtual 361	com/google/protobuf/CodedInputStream:readFloat	()F
      //   607: invokeinterface 161 2 0
      //   612: goto -20 -> 592
      //   615: aload_2
      //   616: iload 6
      //   618: invokevirtual 381	com/google/protobuf/CodedInputStream:popLimit	(I)V
      //   621: goto -364 -> 257
      //   624: aload_0
      //   625: aload_0
      //   626: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   629: iconst_4
      //   630: ior
      //   631: putfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   634: aload_0
      //   635: aload_2
      //   636: invokevirtual 384	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
      //   639: putfield 66	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:data_	Lcom/google/protobuf/ByteString;
      //   642: goto -385 -> 257
      //   645: aconst_null
      //   646: astore_1
      //   647: aload_0
      //   648: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   651: bipush 8
      //   653: iand
      //   654: bipush 8
      //   656: if_icmpne +14 -> 670
      //   659: aload_0
      //   660: getfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   663: invokevirtual 344	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   666: checkcast 195	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder
      //   669: astore_1
      //   670: aload_0
      //   671: aload_2
      //   672: invokestatic 346	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:parser	()Lcom/google/protobuf/Parser;
      //   675: aload_3
      //   676: invokevirtual 350	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   679: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   682: putfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   685: aload_1
      //   686: ifnull +23 -> 709
      //   689: aload_1
      //   690: aload_0
      //   691: getfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   694: invokevirtual 199	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   697: pop
      //   698: aload_0
      //   699: aload_1
      //   700: invokevirtual 203	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   703: checkcast 186	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   706: putfield 172	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   709: aload_0
      //   710: aload_0
      //   711: getfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   714: bipush 8
      //   716: ior
      //   717: putfield 163	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:bitField0_	I
      //   720: goto -463 -> 257
      //   723: getstatic 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   726: areturn
      //   727: getstatic 386	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   730: ifnonnull +28 -> 758
      //   733: ldc 2
      //   735: monitorenter
      //   736: getstatic 386	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   739: ifnonnull +16 -> 755
      //   742: new 388	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   745: dup
      //   746: getstatic 46	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto;
      //   749: invokespecial 391	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   752: putstatic 386	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   755: ldc 2
      //   757: monitorexit
      //   758: getstatic 386	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CongasImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   761: areturn
      //   762: astore_1
      //   763: ldc 2
      //   765: monitorexit
      //   766: aload_1
      //   767: athrow
      //   768: goto -432 -> 336
      //   771: iconst_1
      //   772: istore 4
      //   774: goto -517 -> 257
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	777	0	this	CongasImageFeaturesProto
      //   0	777	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	777	2	paramObject1	Object
      //   0	777	3	paramObject2	Object
      //   255	518	4	i	int
      //   266	315	5	j	int
      //   540	77	6	k	int
      //   570	14	7	m	int
      // Exception table:
      //   from	to	target	type
      //   262	268	373	com/google/protobuf/InvalidProtocolBufferException
      //   336	346	373	com/google/protobuf/InvalidProtocolBufferException
      //   352	370	373	com/google/protobuf/InvalidProtocolBufferException
      //   392	413	373	com/google/protobuf/InvalidProtocolBufferException
      //   413	428	373	com/google/protobuf/InvalidProtocolBufferException
      //   432	452	373	com/google/protobuf/InvalidProtocolBufferException
      //   452	462	373	com/google/protobuf/InvalidProtocolBufferException
      //   489	512	373	com/google/protobuf/InvalidProtocolBufferException
      //   512	525	373	com/google/protobuf/InvalidProtocolBufferException
      //   528	592	373	com/google/protobuf/InvalidProtocolBufferException
      //   592	612	373	com/google/protobuf/InvalidProtocolBufferException
      //   615	621	373	com/google/protobuf/InvalidProtocolBufferException
      //   624	642	373	com/google/protobuf/InvalidProtocolBufferException
      //   647	670	373	com/google/protobuf/InvalidProtocolBufferException
      //   670	685	373	com/google/protobuf/InvalidProtocolBufferException
      //   689	709	373	com/google/protobuf/InvalidProtocolBufferException
      //   709	720	373	com/google/protobuf/InvalidProtocolBufferException
      //   262	268	387	finally
      //   336	346	387	finally
      //   352	370	387	finally
      //   374	387	387	finally
      //   392	413	387	finally
      //   413	428	387	finally
      //   432	452	387	finally
      //   452	462	387	finally
      //   466	489	387	finally
      //   489	512	387	finally
      //   512	525	387	finally
      //   528	592	387	finally
      //   592	612	387	finally
      //   615	621	387	finally
      //   624	642	387	finally
      //   647	670	387	finally
      //   670	685	387	finally
      //   689	709	387	finally
      //   709	720	387	finally
      //   262	268	465	java/io/IOException
      //   336	346	465	java/io/IOException
      //   352	370	465	java/io/IOException
      //   392	413	465	java/io/IOException
      //   413	428	465	java/io/IOException
      //   432	452	465	java/io/IOException
      //   452	462	465	java/io/IOException
      //   489	512	465	java/io/IOException
      //   512	525	465	java/io/IOException
      //   528	592	465	java/io/IOException
      //   592	612	465	java/io/IOException
      //   615	621	465	java/io/IOException
      //   624	642	465	java/io/IOException
      //   647	670	465	java/io/IOException
      //   670	685	465	java/io/IOException
      //   689	709	465	java/io/IOException
      //   709	720	465	java/io/IOException
      //   736	755	762	finally
      //   755	758	762	finally
      //   763	766	762	finally
    }
    
    public ByteString getData()
    {
      return this.data_;
    }
    
    public float getDataFactor(int paramInt)
    {
      return this.dataFactor_.getFloat(paramInt);
    }
    
    public int getDataFactorCount()
    {
      return this.dataFactor_.size();
    }
    
    public List<Float> getDataFactorList()
    {
      return this.dataFactor_;
    }
    
    public QuantizedArray.QuantizedArrayProto getFeatureOrientations()
    {
      if (this.featureOrientations_ == null) {
        return QuantizedArray.QuantizedArrayProto.getDefaultInstance();
      }
      return this.featureOrientations_;
    }
    
    public QuantizedArray.QuantizedArrayProto getNormalizedMeasurements()
    {
      if (this.normalizedMeasurements_ == null) {
        return QuantizedArray.QuantizedArrayProto.getDefaultInstance();
      }
      return this.normalizedMeasurements_;
    }
    
    public int getNumFeatures()
    {
      return this.numFeatures_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeInt32Size(1, this.numFeatures_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(2, getNormalizedMeasurements());
      }
      int k = getDataFactorList().size() * 4;
      j += k;
      i = j;
      if (!getDataFactorList().isEmpty()) {
        i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k);
      }
      this.dataFactorMemoizedSerializedSize = k;
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeBytesSize(4, this.data_);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeMessageSize(5, getFeatureOrientations());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasData()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasFeatureOrientations()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasNormalizedMeasurements()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasNumFeatures()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      getSerializedSize();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt32(1, this.numFeatures_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, getNormalizedMeasurements());
      }
      if (getDataFactorList().size() > 0)
      {
        paramCodedOutputStream.writeUInt32NoTag(26);
        paramCodedOutputStream.writeUInt32NoTag(this.dataFactorMemoizedSerializedSize);
      }
      int i = 0;
      while (i < this.dataFactor_.size())
      {
        paramCodedOutputStream.writeFloatNoTag(this.dataFactor_.getFloat(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeBytes(4, this.data_);
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeMessage(5, getFeatureOrientations());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationQueryData.CongasImageFeaturesProto, Builder>
      implements LocalizationQueryData.CongasImageFeaturesProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllDataFactor(Iterable<? extends Float> paramIterable)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).addAllDataFactor(paramIterable);
        return this;
      }
      
      public Builder addDataFactor(float paramFloat)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).addDataFactor(paramFloat);
        return this;
      }
      
      public Builder clearData()
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).clearData();
        return this;
      }
      
      public Builder clearDataFactor()
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).clearDataFactor();
        return this;
      }
      
      public Builder clearFeatureOrientations()
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).clearFeatureOrientations();
        return this;
      }
      
      public Builder clearNormalizedMeasurements()
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).clearNormalizedMeasurements();
        return this;
      }
      
      public Builder clearNumFeatures()
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).clearNumFeatures();
        return this;
      }
      
      public ByteString getData()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getData();
      }
      
      public float getDataFactor(int paramInt)
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getDataFactor(paramInt);
      }
      
      public int getDataFactorCount()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getDataFactorCount();
      }
      
      public List<Float> getDataFactorList()
      {
        return Collections.unmodifiableList(((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getDataFactorList());
      }
      
      public QuantizedArray.QuantizedArrayProto getFeatureOrientations()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getFeatureOrientations();
      }
      
      public QuantizedArray.QuantizedArrayProto getNormalizedMeasurements()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getNormalizedMeasurements();
      }
      
      public int getNumFeatures()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).getNumFeatures();
      }
      
      public boolean hasData()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).hasData();
      }
      
      public boolean hasFeatureOrientations()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).hasFeatureOrientations();
      }
      
      public boolean hasNormalizedMeasurements()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).hasNormalizedMeasurements();
      }
      
      public boolean hasNumFeatures()
      {
        return ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).hasNumFeatures();
      }
      
      public Builder mergeFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).mergeFeatureOrientations(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder mergeNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).mergeNormalizedMeasurements(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setData(ByteString paramByteString)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setData(paramByteString);
        return this;
      }
      
      public Builder setDataFactor(int paramInt, float paramFloat)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setDataFactor(paramInt, paramFloat);
        return this;
      }
      
      public Builder setFeatureOrientations(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setFeatureOrientations(paramBuilder);
        return this;
      }
      
      public Builder setFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setFeatureOrientations(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setNormalizedMeasurements(paramBuilder);
        return this;
      }
      
      public Builder setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setNormalizedMeasurements(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setNumFeatures(int paramInt)
      {
        copyOnWrite();
        ((LocalizationQueryData.CongasImageFeaturesProto)this.instance).setNumFeatures(paramInt);
        return this;
      }
    }
  }
  
  public static abstract interface CongasImageFeaturesProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract ByteString getData();
    
    public abstract float getDataFactor(int paramInt);
    
    public abstract int getDataFactorCount();
    
    public abstract List<Float> getDataFactorList();
    
    public abstract QuantizedArray.QuantizedArrayProto getFeatureOrientations();
    
    public abstract QuantizedArray.QuantizedArrayProto getNormalizedMeasurements();
    
    public abstract int getNumFeatures();
    
    public abstract boolean hasData();
    
    public abstract boolean hasFeatureOrientations();
    
    public abstract boolean hasNormalizedMeasurements();
    
    public abstract boolean hasNumFeatures();
  }
  
  public static final class FreakImageFeaturesProto
    extends GeneratedMessageLite<FreakImageFeaturesProto, Builder>
    implements LocalizationQueryData.FreakImageFeaturesProtoOrBuilder
  {
    public static final int COMPRESSED_FREAK_DESCRIPTORS_FIELD_NUMBER = 3;
    private static final FreakImageFeaturesProto DEFAULT_INSTANCE = new FreakImageFeaturesProto();
    public static final int FEATURE_ORIENTATIONS_FIELD_NUMBER = 4;
    public static final int NORMALIZED_MEASUREMENTS_FIELD_NUMBER = 2;
    public static final int NUM_FEATURES_FIELD_NUMBER = 1;
    private static volatile Parser<FreakImageFeaturesProto> PARSER;
    private int bitField0_;
    private LocalizationQueryData.CompressedFreakDescriptorsProto compressedFreakDescriptors_;
    private QuantizedArray.QuantizedArrayProto featureOrientations_;
    private QuantizedArray.QuantizedArrayProto normalizedMeasurements_;
    private int numFeatures_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCompressedFreakDescriptors()
    {
      this.compressedFreakDescriptors_ = null;
      this.bitField0_ &= 0xFFFFFFFB;
    }
    
    private void clearFeatureOrientations()
    {
      this.featureOrientations_ = null;
      this.bitField0_ &= 0xFFFFFFF7;
    }
    
    private void clearNormalizedMeasurements()
    {
      this.normalizedMeasurements_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearNumFeatures()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.numFeatures_ = 0;
    }
    
    public static FreakImageFeaturesProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto paramCompressedFreakDescriptorsProto)
    {
      if ((this.compressedFreakDescriptors_ != null) && (this.compressedFreakDescriptors_ != LocalizationQueryData.CompressedFreakDescriptorsProto.getDefaultInstance())) {}
      for (this.compressedFreakDescriptors_ = ((LocalizationQueryData.CompressedFreakDescriptorsProto)((LocalizationQueryData.CompressedFreakDescriptorsProto.Builder)LocalizationQueryData.CompressedFreakDescriptorsProto.newBuilder(this.compressedFreakDescriptors_).mergeFrom(paramCompressedFreakDescriptorsProto)).buildPartial());; this.compressedFreakDescriptors_ = paramCompressedFreakDescriptorsProto)
      {
        this.bitField0_ |= 0x4;
        return;
      }
    }
    
    private void mergeFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if ((this.featureOrientations_ != null) && (this.featureOrientations_ != QuantizedArray.QuantizedArrayProto.getDefaultInstance())) {}
      for (this.featureOrientations_ = ((QuantizedArray.QuantizedArrayProto)((QuantizedArray.QuantizedArrayProto.Builder)QuantizedArray.QuantizedArrayProto.newBuilder(this.featureOrientations_).mergeFrom(paramQuantizedArrayProto)).buildPartial());; this.featureOrientations_ = paramQuantizedArrayProto)
      {
        this.bitField0_ |= 0x8;
        return;
      }
    }
    
    private void mergeNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if ((this.normalizedMeasurements_ != null) && (this.normalizedMeasurements_ != QuantizedArray.QuantizedArrayProto.getDefaultInstance())) {}
      for (this.normalizedMeasurements_ = ((QuantizedArray.QuantizedArrayProto)((QuantizedArray.QuantizedArrayProto.Builder)QuantizedArray.QuantizedArrayProto.newBuilder(this.normalizedMeasurements_).mergeFrom(paramQuantizedArrayProto)).buildPartial());; this.normalizedMeasurements_ = paramQuantizedArrayProto)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FreakImageFeaturesProto paramFreakImageFeaturesProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFreakImageFeaturesProto);
    }
    
    public static FreakImageFeaturesProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (FreakImageFeaturesProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static FreakImageFeaturesProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FreakImageFeaturesProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static FreakImageFeaturesProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static FreakImageFeaturesProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static FreakImageFeaturesProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static FreakImageFeaturesProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static FreakImageFeaturesProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static FreakImageFeaturesProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static FreakImageFeaturesProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static FreakImageFeaturesProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (FreakImageFeaturesProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<FreakImageFeaturesProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto.Builder paramBuilder)
    {
      this.compressedFreakDescriptors_ = ((LocalizationQueryData.CompressedFreakDescriptorsProto)paramBuilder.build());
      this.bitField0_ |= 0x4;
    }
    
    private void setCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto paramCompressedFreakDescriptorsProto)
    {
      if (paramCompressedFreakDescriptorsProto == null) {
        throw new NullPointerException();
      }
      this.compressedFreakDescriptors_ = paramCompressedFreakDescriptorsProto;
      this.bitField0_ |= 0x4;
    }
    
    private void setFeatureOrientations(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
    {
      this.featureOrientations_ = ((QuantizedArray.QuantizedArrayProto)paramBuilder.build());
      this.bitField0_ |= 0x8;
    }
    
    private void setFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if (paramQuantizedArrayProto == null) {
        throw new NullPointerException();
      }
      this.featureOrientations_ = paramQuantizedArrayProto;
      this.bitField0_ |= 0x8;
    }
    
    private void setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
    {
      this.normalizedMeasurements_ = ((QuantizedArray.QuantizedArrayProto)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
    {
      if (paramQuantizedArrayProto == null) {
        throw new NullPointerException();
      }
      this.normalizedMeasurements_ = paramQuantizedArrayProto;
      this.bitField0_ |= 0x2;
    }
    
    private void setNumFeatures(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.numFeatures_ = paramInt;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 226	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 232	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+204->212, 7:+586->594, 8:+590->598
      //   56: new 234	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 235	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto
      //   67: dup
      //   68: invokespecial 39	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 41	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 238	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto$Builder:<init>	(Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 240	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 244	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:hasNumFeatures	()Z
      //   105: aload_0
      //   106: getfield 122	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:numFeatures_	I
      //   109: aload_3
      //   110: invokevirtual 244	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:hasNumFeatures	()Z
      //   113: aload_3
      //   114: getfield 122	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:numFeatures_	I
      //   117: invokeinterface 248 5 0
      //   122: putfield 122	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:numFeatures_	I
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: getfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   131: aload_3
      //   132: getfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   135: invokeinterface 252 3 0
      //   140: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   143: putfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   146: aload_0
      //   147: aload_2
      //   148: aload_0
      //   149: getfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   152: aload_3
      //   153: getfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   156: invokeinterface 252 3 0
      //   161: checkcast 125	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto
      //   164: putfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   167: aload_0
      //   168: aload_2
      //   169: aload_0
      //   170: getfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   173: aload_3
      //   174: getfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   177: invokeinterface 252 3 0
      //   182: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   185: putfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   188: aload_0
      //   189: astore_1
      //   190: aload_2
      //   191: getstatic 258	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   194: if_acmpne -122 -> 72
      //   197: aload_0
      //   198: aload_0
      //   199: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   202: aload_3
      //   203: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   206: ior
      //   207: putfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   210: aload_0
      //   211: areturn
      //   212: aload_2
      //   213: checkcast 260	com/google/protobuf/CodedInputStream
      //   216: astore_2
      //   217: aload_3
      //   218: checkcast 262	com/google/protobuf/ExtensionRegistryLite
      //   221: astore_3
      //   222: iconst_0
      //   223: istore 4
      //   225: iload 4
      //   227: ifne +367 -> 594
      //   230: aload_2
      //   231: invokevirtual 265	com/google/protobuf/CodedInputStream:readTag	()I
      //   234: istore 5
      //   236: iload 5
      //   238: lookupswitch	default:+401->639, 0:+404->642, 8:+66->304, 18:+104->342, 26:+203->441, 34:+278->516
      //   288: aload_0
      //   289: iload 5
      //   291: aload_2
      //   292: invokevirtual 269	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   295: ifne -70 -> 225
      //   298: iconst_1
      //   299: istore 4
      //   301: goto -76 -> 225
      //   304: aload_0
      //   305: aload_0
      //   306: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   309: iconst_1
      //   310: ior
      //   311: putfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   314: aload_0
      //   315: aload_2
      //   316: invokevirtual 272	com/google/protobuf/CodedInputStream:readInt32	()I
      //   319: putfield 122	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:numFeatures_	I
      //   322: goto -97 -> 225
      //   325: astore_1
      //   326: new 274	java/lang/RuntimeException
      //   329: dup
      //   330: aload_1
      //   331: aload_0
      //   332: invokevirtual 278	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   335: invokespecial 281	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   338: athrow
      //   339: astore_1
      //   340: aload_1
      //   341: athrow
      //   342: aconst_null
      //   343: astore_1
      //   344: aload_0
      //   345: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   348: iconst_2
      //   349: iand
      //   350: iconst_2
      //   351: if_icmpne +14 -> 365
      //   354: aload_0
      //   355: getfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   358: invokevirtual 282	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   361: checkcast 152	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder
      //   364: astore_1
      //   365: aload_0
      //   366: aload_2
      //   367: invokestatic 284	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:parser	()Lcom/google/protobuf/Parser;
      //   370: aload_3
      //   371: invokevirtual 288	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   374: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   377: putfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   380: aload_1
      //   381: ifnull +23 -> 404
      //   384: aload_1
      //   385: aload_0
      //   386: getfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   389: invokevirtual 153	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   392: pop
      //   393: aload_0
      //   394: aload_1
      //   395: invokevirtual 154	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   398: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   401: putfield 120	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:normalizedMeasurements_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   404: aload_0
      //   405: aload_0
      //   406: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   409: iconst_2
      //   410: ior
      //   411: putfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   414: goto -189 -> 225
      //   417: astore_1
      //   418: new 274	java/lang/RuntimeException
      //   421: dup
      //   422: new 177	com/google/protobuf/InvalidProtocolBufferException
      //   425: dup
      //   426: aload_1
      //   427: invokevirtual 292	java/io/IOException:getMessage	()Ljava/lang/String;
      //   430: invokespecial 295	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   433: aload_0
      //   434: invokevirtual 278	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   437: invokespecial 281	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   440: athrow
      //   441: aconst_null
      //   442: astore_1
      //   443: aload_0
      //   444: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   447: iconst_4
      //   448: iand
      //   449: iconst_4
      //   450: if_icmpne +14 -> 464
      //   453: aload_0
      //   454: getfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   457: invokevirtual 296	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   460: checkcast 134	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto$Builder
      //   463: astore_1
      //   464: aload_0
      //   465: aload_2
      //   466: invokestatic 297	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto:parser	()Lcom/google/protobuf/Parser;
      //   469: aload_3
      //   470: invokevirtual 288	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   473: checkcast 125	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto
      //   476: putfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   479: aload_1
      //   480: ifnull +23 -> 503
      //   483: aload_1
      //   484: aload_0
      //   485: getfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   488: invokevirtual 138	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   491: pop
      //   492: aload_0
      //   493: aload_1
      //   494: invokevirtual 142	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   497: checkcast 125	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto
      //   500: putfield 114	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:compressedFreakDescriptors_	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$CompressedFreakDescriptorsProto;
      //   503: aload_0
      //   504: aload_0
      //   505: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   508: iconst_4
      //   509: ior
      //   510: putfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   513: goto -288 -> 225
      //   516: aconst_null
      //   517: astore_1
      //   518: aload_0
      //   519: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   522: bipush 8
      //   524: iand
      //   525: bipush 8
      //   527: if_icmpne +14 -> 541
      //   530: aload_0
      //   531: getfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   534: invokevirtual 282	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   537: checkcast 152	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder
      //   540: astore_1
      //   541: aload_0
      //   542: aload_2
      //   543: invokestatic 284	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:parser	()Lcom/google/protobuf/Parser;
      //   546: aload_3
      //   547: invokevirtual 288	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   550: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   553: putfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   556: aload_1
      //   557: ifnull +23 -> 580
      //   560: aload_1
      //   561: aload_0
      //   562: getfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   565: invokevirtual 153	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   568: pop
      //   569: aload_0
      //   570: aload_1
      //   571: invokevirtual 154	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   574: checkcast 144	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   577: putfield 118	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:featureOrientations_	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   580: aload_0
      //   581: aload_0
      //   582: getfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   585: bipush 8
      //   587: ior
      //   588: putfield 116	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:bitField0_	I
      //   591: goto -366 -> 225
      //   594: getstatic 41	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   597: areturn
      //   598: getstatic 299	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   601: ifnonnull +28 -> 629
      //   604: ldc 2
      //   606: monitorenter
      //   607: getstatic 299	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   610: ifnonnull +16 -> 626
      //   613: new 301	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   616: dup
      //   617: getstatic 41	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto;
      //   620: invokespecial 304	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   623: putstatic 299	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   626: ldc 2
      //   628: monitorexit
      //   629: getstatic 299	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$FreakImageFeaturesProto:PARSER	Lcom/google/protobuf/Parser;
      //   632: areturn
      //   633: astore_1
      //   634: ldc 2
      //   636: monitorexit
      //   637: aload_1
      //   638: athrow
      //   639: goto -351 -> 288
      //   642: iconst_1
      //   643: istore 4
      //   645: goto -420 -> 225
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	648	0	this	FreakImageFeaturesProto
      //   0	648	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	648	2	paramObject1	Object
      //   0	648	3	paramObject2	Object
      //   223	421	4	i	int
      //   234	56	5	j	int
      // Exception table:
      //   from	to	target	type
      //   230	236	325	com/google/protobuf/InvalidProtocolBufferException
      //   288	298	325	com/google/protobuf/InvalidProtocolBufferException
      //   304	322	325	com/google/protobuf/InvalidProtocolBufferException
      //   344	365	325	com/google/protobuf/InvalidProtocolBufferException
      //   365	380	325	com/google/protobuf/InvalidProtocolBufferException
      //   384	404	325	com/google/protobuf/InvalidProtocolBufferException
      //   404	414	325	com/google/protobuf/InvalidProtocolBufferException
      //   443	464	325	com/google/protobuf/InvalidProtocolBufferException
      //   464	479	325	com/google/protobuf/InvalidProtocolBufferException
      //   483	503	325	com/google/protobuf/InvalidProtocolBufferException
      //   503	513	325	com/google/protobuf/InvalidProtocolBufferException
      //   518	541	325	com/google/protobuf/InvalidProtocolBufferException
      //   541	556	325	com/google/protobuf/InvalidProtocolBufferException
      //   560	580	325	com/google/protobuf/InvalidProtocolBufferException
      //   580	591	325	com/google/protobuf/InvalidProtocolBufferException
      //   230	236	339	finally
      //   288	298	339	finally
      //   304	322	339	finally
      //   326	339	339	finally
      //   344	365	339	finally
      //   365	380	339	finally
      //   384	404	339	finally
      //   404	414	339	finally
      //   418	441	339	finally
      //   443	464	339	finally
      //   464	479	339	finally
      //   483	503	339	finally
      //   503	513	339	finally
      //   518	541	339	finally
      //   541	556	339	finally
      //   560	580	339	finally
      //   580	591	339	finally
      //   230	236	417	java/io/IOException
      //   288	298	417	java/io/IOException
      //   304	322	417	java/io/IOException
      //   344	365	417	java/io/IOException
      //   365	380	417	java/io/IOException
      //   384	404	417	java/io/IOException
      //   404	414	417	java/io/IOException
      //   443	464	417	java/io/IOException
      //   464	479	417	java/io/IOException
      //   483	503	417	java/io/IOException
      //   503	513	417	java/io/IOException
      //   518	541	417	java/io/IOException
      //   541	556	417	java/io/IOException
      //   560	580	417	java/io/IOException
      //   580	591	417	java/io/IOException
      //   607	626	633	finally
      //   626	629	633	finally
      //   634	637	633	finally
    }
    
    public LocalizationQueryData.CompressedFreakDescriptorsProto getCompressedFreakDescriptors()
    {
      if (this.compressedFreakDescriptors_ == null) {
        return LocalizationQueryData.CompressedFreakDescriptorsProto.getDefaultInstance();
      }
      return this.compressedFreakDescriptors_;
    }
    
    public QuantizedArray.QuantizedArrayProto getFeatureOrientations()
    {
      if (this.featureOrientations_ == null) {
        return QuantizedArray.QuantizedArrayProto.getDefaultInstance();
      }
      return this.featureOrientations_;
    }
    
    public QuantizedArray.QuantizedArrayProto getNormalizedMeasurements()
    {
      if (this.normalizedMeasurements_ == null) {
        return QuantizedArray.QuantizedArrayProto.getDefaultInstance();
      }
      return this.normalizedMeasurements_;
    }
    
    public int getNumFeatures()
    {
      return this.numFeatures_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeInt32Size(1, this.numFeatures_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeMessageSize(2, getNormalizedMeasurements());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeMessageSize(3, getCompressedFreakDescriptors());
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeMessageSize(4, getFeatureOrientations());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCompressedFreakDescriptors()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasFeatureOrientations()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasNormalizedMeasurements()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasNumFeatures()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt32(1, this.numFeatures_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, getNormalizedMeasurements());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeMessage(3, getCompressedFreakDescriptors());
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeMessage(4, getFeatureOrientations());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationQueryData.FreakImageFeaturesProto, Builder>
      implements LocalizationQueryData.FreakImageFeaturesProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearCompressedFreakDescriptors()
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).clearCompressedFreakDescriptors();
        return this;
      }
      
      public Builder clearFeatureOrientations()
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).clearFeatureOrientations();
        return this;
      }
      
      public Builder clearNormalizedMeasurements()
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).clearNormalizedMeasurements();
        return this;
      }
      
      public Builder clearNumFeatures()
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).clearNumFeatures();
        return this;
      }
      
      public LocalizationQueryData.CompressedFreakDescriptorsProto getCompressedFreakDescriptors()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).getCompressedFreakDescriptors();
      }
      
      public QuantizedArray.QuantizedArrayProto getFeatureOrientations()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).getFeatureOrientations();
      }
      
      public QuantizedArray.QuantizedArrayProto getNormalizedMeasurements()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).getNormalizedMeasurements();
      }
      
      public int getNumFeatures()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).getNumFeatures();
      }
      
      public boolean hasCompressedFreakDescriptors()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).hasCompressedFreakDescriptors();
      }
      
      public boolean hasFeatureOrientations()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).hasFeatureOrientations();
      }
      
      public boolean hasNormalizedMeasurements()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).hasNormalizedMeasurements();
      }
      
      public boolean hasNumFeatures()
      {
        return ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).hasNumFeatures();
      }
      
      public Builder mergeCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto paramCompressedFreakDescriptorsProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).mergeCompressedFreakDescriptors(paramCompressedFreakDescriptorsProto);
        return this;
      }
      
      public Builder mergeFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).mergeFeatureOrientations(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder mergeNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).mergeNormalizedMeasurements(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setCompressedFreakDescriptors(paramBuilder);
        return this;
      }
      
      public Builder setCompressedFreakDescriptors(LocalizationQueryData.CompressedFreakDescriptorsProto paramCompressedFreakDescriptorsProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setCompressedFreakDescriptors(paramCompressedFreakDescriptorsProto);
        return this;
      }
      
      public Builder setFeatureOrientations(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setFeatureOrientations(paramBuilder);
        return this;
      }
      
      public Builder setFeatureOrientations(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setFeatureOrientations(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setNormalizedMeasurements(paramBuilder);
        return this;
      }
      
      public Builder setNormalizedMeasurements(QuantizedArray.QuantizedArrayProto paramQuantizedArrayProto)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setNormalizedMeasurements(paramQuantizedArrayProto);
        return this;
      }
      
      public Builder setNumFeatures(int paramInt)
      {
        copyOnWrite();
        ((LocalizationQueryData.FreakImageFeaturesProto)this.instance).setNumFeatures(paramInt);
        return this;
      }
    }
  }
  
  public static abstract interface FreakImageFeaturesProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract LocalizationQueryData.CompressedFreakDescriptorsProto getCompressedFreakDescriptors();
    
    public abstract QuantizedArray.QuantizedArrayProto getFeatureOrientations();
    
    public abstract QuantizedArray.QuantizedArrayProto getNormalizedMeasurements();
    
    public abstract int getNumFeatures();
    
    public abstract boolean hasCompressedFreakDescriptors();
    
    public abstract boolean hasFeatureOrientations();
    
    public abstract boolean hasNormalizedMeasurements();
    
    public abstract boolean hasNumFeatures();
  }
  
  public static final class TileVersionProto
    extends GeneratedMessageLite<TileVersionProto, Builder>
    implements LocalizationQueryData.TileVersionProtoOrBuilder
  {
    public static final int COMPRESSION_VERSION_FIELD_NUMBER = 3;
    private static final TileVersionProto DEFAULT_INSTANCE = new TileVersionProto();
    private static volatile Parser<TileVersionProto> PARSER;
    public static final int PRIMARY_TAG_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_UTC_FIELD_NUMBER = 1;
    private int bitField0_;
    private int compressionVersion_;
    private String primaryTag_ = "";
    private Timestamp timestampUtc_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCompressionVersion()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.compressionVersion_ = 0;
    }
    
    private void clearPrimaryTag()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.primaryTag_ = getDefaultInstance().getPrimaryTag();
    }
    
    private void clearTimestampUtc()
    {
      this.timestampUtc_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    public static TileVersionProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeTimestampUtc(Timestamp paramTimestamp)
    {
      if ((this.timestampUtc_ != null) && (this.timestampUtc_ != Timestamp.getDefaultInstance())) {}
      for (this.timestampUtc_ = ((Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.timestampUtc_).mergeFrom(paramTimestamp)).buildPartial());; this.timestampUtc_ = paramTimestamp)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TileVersionProto paramTileVersionProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTileVersionProto);
    }
    
    public static TileVersionProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TileVersionProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TileVersionProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileVersionProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TileVersionProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static TileVersionProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static TileVersionProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static TileVersionProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static TileVersionProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TileVersionProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TileVersionProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static TileVersionProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TileVersionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<TileVersionProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCompressionVersion(VersionConstantsProto.VersionConstants.SupportedTileParsingVersion paramSupportedTileParsingVersion)
    {
      if (paramSupportedTileParsingVersion == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.compressionVersion_ = paramSupportedTileParsingVersion.getNumber();
    }
    
    private void setPrimaryTag(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.primaryTag_ = paramString;
    }
    
    private void setPrimaryTagBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.primaryTag_ = paramByteString.toStringUtf8();
    }
    
    private void setTimestampUtc(Timestamp.Builder paramBuilder)
    {
      this.timestampUtc_ = ((Timestamp)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setTimestampUtc(Timestamp paramTimestamp)
    {
      if (paramTimestamp == null) {
        throw new NullPointerException();
      }
      this.timestampUtc_ = paramTimestamp;
      this.bitField0_ |= 0x1;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 209	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 214	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+188->196, 7:+454->462, 8:+458->466
      //   56: new 216	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 217	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto
      //   67: dup
      //   68: invokespecial 36	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 38	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 220	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto$Builder:<init>	(Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 222	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   105: aload_3
      //   106: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   109: invokeinterface 226 3 0
      //   114: checkcast 110	com/google/protobuf/Timestamp
      //   117: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   120: aload_0
      //   121: aload_2
      //   122: aload_0
      //   123: invokevirtual 230	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:hasPrimaryTag	()Z
      //   126: aload_0
      //   127: getfield 47	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:primaryTag_	Ljava/lang/String;
      //   130: aload_3
      //   131: invokevirtual 230	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:hasPrimaryTag	()Z
      //   134: aload_3
      //   135: getfield 47	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:primaryTag_	Ljava/lang/String;
      //   138: invokeinterface 234 5 0
      //   143: putfield 47	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:primaryTag_	Ljava/lang/String;
      //   146: aload_0
      //   147: aload_2
      //   148: aload_0
      //   149: invokevirtual 237	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:hasCompressionVersion	()Z
      //   152: aload_0
      //   153: getfield 99	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:compressionVersion_	I
      //   156: aload_3
      //   157: invokevirtual 237	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:hasCompressionVersion	()Z
      //   160: aload_3
      //   161: getfield 99	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:compressionVersion_	I
      //   164: invokeinterface 241 5 0
      //   169: putfield 99	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:compressionVersion_	I
      //   172: aload_0
      //   173: astore_1
      //   174: aload_2
      //   175: getstatic 247	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   178: if_acmpne -106 -> 72
      //   181: aload_0
      //   182: aload_0
      //   183: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   186: aload_3
      //   187: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   190: ior
      //   191: putfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   194: aload_0
      //   195: areturn
      //   196: aload_2
      //   197: checkcast 249	com/google/protobuf/CodedInputStream
      //   200: astore_2
      //   201: aload_3
      //   202: checkcast 251	com/google/protobuf/ExtensionRegistryLite
      //   205: astore_3
      //   206: iconst_0
      //   207: istore 4
      //   209: iload 4
      //   211: ifne +251 -> 462
      //   214: aload_2
      //   215: invokevirtual 254	com/google/protobuf/CodedInputStream:readTag	()I
      //   218: istore 5
      //   220: iload 5
      //   222: lookupswitch	default:+285->507, 0:+288->510, 10:+58->280, 18:+150->372, 24:+197->419
      //   264: aload_0
      //   265: iload 5
      //   267: aload_2
      //   268: invokevirtual 258	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   271: ifne -62 -> 209
      //   274: iconst_1
      //   275: istore 4
      //   277: goto -68 -> 209
      //   280: aconst_null
      //   281: astore_1
      //   282: aload_0
      //   283: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   286: iconst_1
      //   287: iand
      //   288: iconst_1
      //   289: if_icmpne +14 -> 303
      //   292: aload_0
      //   293: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   296: invokevirtual 259	com/google/protobuf/Timestamp:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   299: checkcast 119	com/google/protobuf/Timestamp$Builder
      //   302: astore_1
      //   303: aload_0
      //   304: aload_2
      //   305: invokestatic 261	com/google/protobuf/Timestamp:parser	()Lcom/google/protobuf/Parser;
      //   308: aload_3
      //   309: invokevirtual 265	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   312: checkcast 110	com/google/protobuf/Timestamp
      //   315: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   318: aload_1
      //   319: ifnull +23 -> 342
      //   322: aload_1
      //   323: aload_0
      //   324: getfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   327: invokevirtual 123	com/google/protobuf/Timestamp$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   330: pop
      //   331: aload_0
      //   332: aload_1
      //   333: invokevirtual 127	com/google/protobuf/Timestamp$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   336: checkcast 110	com/google/protobuf/Timestamp
      //   339: putfield 108	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:timestampUtc_	Lcom/google/protobuf/Timestamp;
      //   342: aload_0
      //   343: aload_0
      //   344: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   347: iconst_1
      //   348: ior
      //   349: putfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   352: goto -143 -> 209
      //   355: astore_1
      //   356: new 267	java/lang/RuntimeException
      //   359: dup
      //   360: aload_1
      //   361: aload_0
      //   362: invokevirtual 271	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   365: invokespecial 274	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   368: athrow
      //   369: astore_1
      //   370: aload_1
      //   371: athrow
      //   372: aload_2
      //   373: invokevirtual 277	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   376: astore_1
      //   377: aload_0
      //   378: aload_0
      //   379: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   382: iconst_2
      //   383: ior
      //   384: putfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   387: aload_0
      //   388: aload_1
      //   389: putfield 47	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:primaryTag_	Ljava/lang/String;
      //   392: goto -183 -> 209
      //   395: astore_1
      //   396: new 267	java/lang/RuntimeException
      //   399: dup
      //   400: new 150	com/google/protobuf/InvalidProtocolBufferException
      //   403: dup
      //   404: aload_1
      //   405: invokevirtual 280	java/io/IOException:getMessage	()Ljava/lang/String;
      //   408: invokespecial 282	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   411: aload_0
      //   412: invokevirtual 271	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   415: invokespecial 274	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   418: athrow
      //   419: aload_2
      //   420: invokevirtual 285	com/google/protobuf/CodedInputStream:readEnum	()I
      //   423: istore 5
      //   425: iload 5
      //   427: invokestatic 289	com/google/location/visualmapping/visualmapstore/VersionConstantsProto$VersionConstants$SupportedTileParsingVersion:forNumber	(I)Lcom/google/location/visualmapping/visualmapstore/VersionConstantsProto$VersionConstants$SupportedTileParsingVersion;
      //   430: ifnonnull +13 -> 443
      //   433: aload_0
      //   434: iconst_3
      //   435: iload 5
      //   437: invokespecial 293	com/google/protobuf/GeneratedMessageLite:mergeVarintField	(II)V
      //   440: goto -231 -> 209
      //   443: aload_0
      //   444: aload_0
      //   445: getfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   448: iconst_4
      //   449: ior
      //   450: putfield 97	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:bitField0_	I
      //   453: aload_0
      //   454: iload 5
      //   456: putfield 99	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:compressionVersion_	I
      //   459: goto -250 -> 209
      //   462: getstatic 38	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto;
      //   465: areturn
      //   466: getstatic 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:PARSER	Lcom/google/protobuf/Parser;
      //   469: ifnonnull +28 -> 497
      //   472: ldc 2
      //   474: monitorenter
      //   475: getstatic 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:PARSER	Lcom/google/protobuf/Parser;
      //   478: ifnonnull +16 -> 494
      //   481: new 297	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   484: dup
      //   485: getstatic 38	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto;
      //   488: invokespecial 300	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   491: putstatic 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:PARSER	Lcom/google/protobuf/Parser;
      //   494: ldc 2
      //   496: monitorexit
      //   497: getstatic 295	com/google/location/visualmapping/cloudlocalization/LocalizationQueryData$TileVersionProto:PARSER	Lcom/google/protobuf/Parser;
      //   500: areturn
      //   501: astore_1
      //   502: ldc 2
      //   504: monitorexit
      //   505: aload_1
      //   506: athrow
      //   507: goto -243 -> 264
      //   510: iconst_1
      //   511: istore 4
      //   513: goto -304 -> 209
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	516	0	this	TileVersionProto
      //   0	516	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	516	2	paramObject1	Object
      //   0	516	3	paramObject2	Object
      //   207	305	4	i	int
      //   218	237	5	j	int
      // Exception table:
      //   from	to	target	type
      //   214	220	355	com/google/protobuf/InvalidProtocolBufferException
      //   264	274	355	com/google/protobuf/InvalidProtocolBufferException
      //   282	303	355	com/google/protobuf/InvalidProtocolBufferException
      //   303	318	355	com/google/protobuf/InvalidProtocolBufferException
      //   322	342	355	com/google/protobuf/InvalidProtocolBufferException
      //   342	352	355	com/google/protobuf/InvalidProtocolBufferException
      //   372	392	355	com/google/protobuf/InvalidProtocolBufferException
      //   419	440	355	com/google/protobuf/InvalidProtocolBufferException
      //   443	459	355	com/google/protobuf/InvalidProtocolBufferException
      //   214	220	369	finally
      //   264	274	369	finally
      //   282	303	369	finally
      //   303	318	369	finally
      //   322	342	369	finally
      //   342	352	369	finally
      //   356	369	369	finally
      //   372	392	369	finally
      //   396	419	369	finally
      //   419	440	369	finally
      //   443	459	369	finally
      //   214	220	395	java/io/IOException
      //   264	274	395	java/io/IOException
      //   282	303	395	java/io/IOException
      //   303	318	395	java/io/IOException
      //   322	342	395	java/io/IOException
      //   342	352	395	java/io/IOException
      //   372	392	395	java/io/IOException
      //   419	440	395	java/io/IOException
      //   443	459	395	java/io/IOException
      //   475	494	501	finally
      //   494	497	501	finally
      //   502	505	501	finally
    }
    
    public VersionConstantsProto.VersionConstants.SupportedTileParsingVersion getCompressionVersion()
    {
      VersionConstantsProto.VersionConstants.SupportedTileParsingVersion localSupportedTileParsingVersion2 = VersionConstantsProto.VersionConstants.SupportedTileParsingVersion.forNumber(this.compressionVersion_);
      VersionConstantsProto.VersionConstants.SupportedTileParsingVersion localSupportedTileParsingVersion1 = localSupportedTileParsingVersion2;
      if (localSupportedTileParsingVersion2 == null) {
        localSupportedTileParsingVersion1 = VersionConstantsProto.VersionConstants.SupportedTileParsingVersion.UNDEFINED;
      }
      return localSupportedTileParsingVersion1;
    }
    
    public String getPrimaryTag()
    {
      return this.primaryTag_;
    }
    
    public ByteString getPrimaryTagBytes()
    {
      return ByteString.copyFromUtf8(this.primaryTag_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeMessageSize(1, getTimestampUtc());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getPrimaryTag());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeEnumSize(3, this.compressionVersion_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public Timestamp getTimestampUtc()
    {
      if (this.timestampUtc_ == null) {
        return Timestamp.getDefaultInstance();
      }
      return this.timestampUtc_;
    }
    
    public boolean hasCompressionVersion()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasPrimaryTag()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasTimestampUtc()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getTimestampUtc());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getPrimaryTag());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeEnum(3, this.compressionVersion_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationQueryData.TileVersionProto, Builder>
      implements LocalizationQueryData.TileVersionProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearCompressionVersion()
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).clearCompressionVersion();
        return this;
      }
      
      public Builder clearPrimaryTag()
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).clearPrimaryTag();
        return this;
      }
      
      public Builder clearTimestampUtc()
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).clearTimestampUtc();
        return this;
      }
      
      public VersionConstantsProto.VersionConstants.SupportedTileParsingVersion getCompressionVersion()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).getCompressionVersion();
      }
      
      public String getPrimaryTag()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).getPrimaryTag();
      }
      
      public ByteString getPrimaryTagBytes()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).getPrimaryTagBytes();
      }
      
      public Timestamp getTimestampUtc()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).getTimestampUtc();
      }
      
      public boolean hasCompressionVersion()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).hasCompressionVersion();
      }
      
      public boolean hasPrimaryTag()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).hasPrimaryTag();
      }
      
      public boolean hasTimestampUtc()
      {
        return ((LocalizationQueryData.TileVersionProto)this.instance).hasTimestampUtc();
      }
      
      public Builder mergeTimestampUtc(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).mergeTimestampUtc(paramTimestamp);
        return this;
      }
      
      public Builder setCompressionVersion(VersionConstantsProto.VersionConstants.SupportedTileParsingVersion paramSupportedTileParsingVersion)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).setCompressionVersion(paramSupportedTileParsingVersion);
        return this;
      }
      
      public Builder setPrimaryTag(String paramString)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).setPrimaryTag(paramString);
        return this;
      }
      
      public Builder setPrimaryTagBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).setPrimaryTagBytes(paramByteString);
        return this;
      }
      
      public Builder setTimestampUtc(Timestamp.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).setTimestampUtc(paramBuilder);
        return this;
      }
      
      public Builder setTimestampUtc(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((LocalizationQueryData.TileVersionProto)this.instance).setTimestampUtc(paramTimestamp);
        return this;
      }
    }
  }
  
  public static abstract interface TileVersionProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract VersionConstantsProto.VersionConstants.SupportedTileParsingVersion getCompressionVersion();
    
    public abstract String getPrimaryTag();
    
    public abstract ByteString getPrimaryTagBytes();
    
    public abstract Timestamp getTimestampUtc();
    
    public abstract boolean hasCompressionVersion();
    
    public abstract boolean hasPrimaryTag();
    
    public abstract boolean hasTimestampUtc();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/cloudlocalization/LocalizationQueryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */