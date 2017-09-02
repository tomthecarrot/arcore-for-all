package com.google.location.visualmapping.vpsmanagement;

import com.google.location.visualmapping.common.S2Proto.LatLngAltProto;
import com.google.location.visualmapping.common.S2Proto.LatLngAltProto.Builder;
import com.google.location.visualmapping.common.S2Proto.LatLngAltProtoOrBuilder;
import com.google.location.visualmapping.visualmapstore.Types.DatasetType;
import com.google.location.visualmapping.visualmapstore.VisualMapStored.Annotation;
import com.google.location.visualmapping.visualmapstore.VisualMapStored.Annotation.Builder;
import com.google.location.visualmapping.visualmapstore.VisualMapStored.AnnotationOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp.Builder;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class TrajectorySummary
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class TrajectorySummaryProto
    extends GeneratedMessageLite<TrajectorySummaryProto, Builder>
    implements TrajectorySummary.TrajectorySummaryProtoOrBuilder
  {
    public static final int ADF_UUID_FIELD_NUMBER = 1;
    public static final int ANNOTATIONS_FIELD_NUMBER = 6;
    private static final TrajectorySummaryProto DEFAULT_INSTANCE = new TrajectorySummaryProto();
    private static volatile Parser<TrajectorySummaryProto> PARSER;
    public static final int POINTS_FIELD_NUMBER = 5;
    public static final int ROSBAG_UUID_FIELD_NUMBER = 2;
    public static final int TIME_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 4;
    private String adfUuid_ = "";
    private Internal.ProtobufList<VisualMapStored.Annotation> annotations_ = emptyProtobufList();
    private int bitField0_;
    private Internal.ProtobufList<S2Proto.LatLngAltProto> points_ = emptyProtobufList();
    private String rosbagUuid_ = "";
    private Timestamp time_;
    private int type_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllAnnotations(Iterable<? extends VisualMapStored.Annotation> paramIterable)
    {
      ensureAnnotationsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.annotations_);
    }
    
    private void addAllPoints(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
    {
      ensurePointsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.points_);
    }
    
    private void addAnnotations(int paramInt, VisualMapStored.Annotation.Builder paramBuilder)
    {
      ensureAnnotationsIsMutable();
      this.annotations_.add(paramInt, paramBuilder.build());
    }
    
    private void addAnnotations(int paramInt, VisualMapStored.Annotation paramAnnotation)
    {
      if (paramAnnotation == null) {
        throw new NullPointerException();
      }
      ensureAnnotationsIsMutable();
      this.annotations_.add(paramInt, paramAnnotation);
    }
    
    private void addAnnotations(VisualMapStored.Annotation.Builder paramBuilder)
    {
      ensureAnnotationsIsMutable();
      this.annotations_.add(paramBuilder.build());
    }
    
    private void addAnnotations(VisualMapStored.Annotation paramAnnotation)
    {
      if (paramAnnotation == null) {
        throw new NullPointerException();
      }
      ensureAnnotationsIsMutable();
      this.annotations_.add(paramAnnotation);
    }
    
    private void addPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensurePointsIsMutable();
      this.points_.add(paramInt, paramBuilder.build());
    }
    
    private void addPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensurePointsIsMutable();
      this.points_.add(paramInt, paramLatLngAltProto);
    }
    
    private void addPoints(S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensurePointsIsMutable();
      this.points_.add(paramBuilder.build());
    }
    
    private void addPoints(S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensurePointsIsMutable();
      this.points_.add(paramLatLngAltProto);
    }
    
    private void clearAdfUuid()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.adfUuid_ = getDefaultInstance().getAdfUuid();
    }
    
    private void clearAnnotations()
    {
      this.annotations_ = emptyProtobufList();
    }
    
    private void clearPoints()
    {
      this.points_ = emptyProtobufList();
    }
    
    private void clearRosbagUuid()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.rosbagUuid_ = getDefaultInstance().getRosbagUuid();
    }
    
    private void clearTime()
    {
      this.time_ = null;
      this.bitField0_ &= 0xFFFFFFFB;
    }
    
    private void clearType()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.type_ = 0;
    }
    
    private void ensureAnnotationsIsMutable()
    {
      if (!this.annotations_.isModifiable()) {
        this.annotations_ = GeneratedMessageLite.mutableCopy(this.annotations_);
      }
    }
    
    private void ensurePointsIsMutable()
    {
      if (!this.points_.isModifiable()) {
        this.points_ = GeneratedMessageLite.mutableCopy(this.points_);
      }
    }
    
    public static TrajectorySummaryProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeTime(Timestamp paramTimestamp)
    {
      if ((this.time_ != null) && (this.time_ != Timestamp.getDefaultInstance())) {}
      for (this.time_ = ((Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.time_).mergeFrom(paramTimestamp)).buildPartial());; this.time_ = paramTimestamp)
      {
        this.bitField0_ |= 0x4;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TrajectorySummaryProto paramTrajectorySummaryProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTrajectorySummaryProto);
    }
    
    public static TrajectorySummaryProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TrajectorySummaryProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TrajectorySummaryProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TrajectorySummaryProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TrajectorySummaryProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static TrajectorySummaryProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static TrajectorySummaryProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static TrajectorySummaryProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static TrajectorySummaryProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TrajectorySummaryProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TrajectorySummaryProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static TrajectorySummaryProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TrajectorySummaryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<TrajectorySummaryProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeAnnotations(int paramInt)
    {
      ensureAnnotationsIsMutable();
      this.annotations_.remove(paramInt);
    }
    
    private void removePoints(int paramInt)
    {
      ensurePointsIsMutable();
      this.points_.remove(paramInt);
    }
    
    private void setAdfUuid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.adfUuid_ = paramString;
    }
    
    private void setAdfUuidBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.adfUuid_ = paramByteString.toStringUtf8();
    }
    
    private void setAnnotations(int paramInt, VisualMapStored.Annotation.Builder paramBuilder)
    {
      ensureAnnotationsIsMutable();
      this.annotations_.set(paramInt, paramBuilder.build());
    }
    
    private void setAnnotations(int paramInt, VisualMapStored.Annotation paramAnnotation)
    {
      if (paramAnnotation == null) {
        throw new NullPointerException();
      }
      ensureAnnotationsIsMutable();
      this.annotations_.set(paramInt, paramAnnotation);
    }
    
    private void setPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensurePointsIsMutable();
      this.points_.set(paramInt, paramBuilder.build());
    }
    
    private void setPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensurePointsIsMutable();
      this.points_.set(paramInt, paramLatLngAltProto);
    }
    
    private void setRosbagUuid(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.rosbagUuid_ = paramString;
    }
    
    private void setRosbagUuidBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.rosbagUuid_ = paramByteString.toStringUtf8();
    }
    
    private void setTime(Timestamp.Builder paramBuilder)
    {
      this.time_ = ((Timestamp)paramBuilder.build());
      this.bitField0_ |= 0x4;
    }
    
    private void setTime(Timestamp paramTimestamp)
    {
      if (paramTimestamp == null) {
        throw new NullPointerException();
      }
      this.time_ = paramTimestamp;
      this.bitField0_ |= 0x4;
    }
    
    private void setType(Types.DatasetType paramDatasetType)
    {
      if (paramDatasetType == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x8;
      this.type_ = paramDatasetType.getNumber();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 375	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 380	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+90->98, 5:+99->107, 6:+268->276, 7:+670->678, 8:+674->682
      //   56: new 382	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 383	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto
      //   67: dup
      //   68: invokespecial 48	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 50	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 384 1 0
      //   87: aload_0
      //   88: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   91: invokeinterface 384 1 0
      //   96: aconst_null
      //   97: areturn
      //   98: new 12	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto$Builder
      //   101: dup
      //   102: aconst_null
      //   103: invokespecial 387	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/TrajectorySummary$1;)V
      //   106: areturn
      //   107: aload_2
      //   108: checkcast 389	com/google/protobuf/GeneratedMessageLite$Visitor
      //   111: astore_2
      //   112: aload_3
      //   113: checkcast 2	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto
      //   116: astore_3
      //   117: aload_0
      //   118: aload_2
      //   119: aload_0
      //   120: invokevirtual 392	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasAdfUuid	()Z
      //   123: aload_0
      //   124: getfield 59	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:adfUuid_	Ljava/lang/String;
      //   127: aload_3
      //   128: invokevirtual 392	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasAdfUuid	()Z
      //   131: aload_3
      //   132: getfield 59	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:adfUuid_	Ljava/lang/String;
      //   135: invokeinterface 396 5 0
      //   140: putfield 59	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:adfUuid_	Ljava/lang/String;
      //   143: aload_0
      //   144: aload_2
      //   145: aload_0
      //   146: invokevirtual 399	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasRosbagUuid	()Z
      //   149: aload_0
      //   150: getfield 61	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:rosbagUuid_	Ljava/lang/String;
      //   153: aload_3
      //   154: invokevirtual 399	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasRosbagUuid	()Z
      //   157: aload_3
      //   158: getfield 61	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:rosbagUuid_	Ljava/lang/String;
      //   161: invokeinterface 396 5 0
      //   166: putfield 61	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:rosbagUuid_	Ljava/lang/String;
      //   169: aload_0
      //   170: aload_2
      //   171: aload_0
      //   172: getfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   175: aload_3
      //   176: getfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   179: invokeinterface 403 3 0
      //   184: checkcast 275	com/google/protobuf/Timestamp
      //   187: putfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   190: aload_0
      //   191: aload_2
      //   192: aload_0
      //   193: invokevirtual 406	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasType	()Z
      //   196: aload_0
      //   197: getfield 265	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:type_	I
      //   200: aload_3
      //   201: invokevirtual 406	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:hasType	()Z
      //   204: aload_3
      //   205: getfield 265	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:type_	I
      //   208: invokeinterface 410 5 0
      //   213: putfield 265	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:type_	I
      //   216: aload_0
      //   217: aload_2
      //   218: aload_0
      //   219: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   222: aload_3
      //   223: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   226: invokeinterface 414 3 0
      //   231: putfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   234: aload_0
      //   235: aload_2
      //   236: aload_0
      //   237: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   240: aload_3
      //   241: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   244: invokeinterface 414 3 0
      //   249: putfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   252: aload_0
      //   253: astore_1
      //   254: aload_2
      //   255: getstatic 420	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   258: if_acmpne -186 -> 72
      //   261: aload_0
      //   262: aload_0
      //   263: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   266: aload_3
      //   267: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   270: ior
      //   271: putfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   274: aload_0
      //   275: areturn
      //   276: aload_2
      //   277: checkcast 422	com/google/protobuf/CodedInputStream
      //   280: astore_2
      //   281: aload_3
      //   282: checkcast 424	com/google/protobuf/ExtensionRegistryLite
      //   285: astore_3
      //   286: iconst_0
      //   287: istore 4
      //   289: iload 4
      //   291: ifne +387 -> 678
      //   294: aload_2
      //   295: invokevirtual 427	com/google/protobuf/CodedInputStream:readTag	()I
      //   298: istore 5
      //   300: iload 5
      //   302: lookupswitch	default:+421->723, 0:+424->726, 10:+82->384, 18:+122->424, 26:+169->471, 32:+244->546, 42:+288->590, 50:+332->634
      //   368: aload_0
      //   369: iload 5
      //   371: aload_2
      //   372: invokevirtual 431	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   375: ifne -86 -> 289
      //   378: iconst_1
      //   379: istore 4
      //   381: goto -92 -> 289
      //   384: aload_2
      //   385: invokevirtual 434	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   388: astore_1
      //   389: aload_0
      //   390: aload_0
      //   391: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   394: iconst_1
      //   395: ior
      //   396: putfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   399: aload_0
      //   400: aload_1
      //   401: putfield 59	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:adfUuid_	Ljava/lang/String;
      //   404: goto -115 -> 289
      //   407: astore_1
      //   408: new 436	java/lang/RuntimeException
      //   411: dup
      //   412: aload_1
      //   413: aload_0
      //   414: invokevirtual 440	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   417: invokespecial 443	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   420: athrow
      //   421: astore_1
      //   422: aload_1
      //   423: athrow
      //   424: aload_2
      //   425: invokevirtual 434	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   428: astore_1
      //   429: aload_0
      //   430: aload_0
      //   431: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   434: iconst_2
      //   435: ior
      //   436: putfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   439: aload_0
      //   440: aload_1
      //   441: putfield 61	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:rosbagUuid_	Ljava/lang/String;
      //   444: goto -155 -> 289
      //   447: astore_1
      //   448: new 436	java/lang/RuntimeException
      //   451: dup
      //   452: new 314	com/google/protobuf/InvalidProtocolBufferException
      //   455: dup
      //   456: aload_1
      //   457: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
      //   460: invokespecial 448	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   463: aload_0
      //   464: invokevirtual 440	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   467: invokespecial 443	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   470: athrow
      //   471: aconst_null
      //   472: astore_1
      //   473: aload_0
      //   474: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   477: iconst_4
      //   478: iand
      //   479: iconst_4
      //   480: if_icmpne +14 -> 494
      //   483: aload_0
      //   484: getfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   487: invokevirtual 449	com/google/protobuf/Timestamp:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   490: checkcast 284	com/google/protobuf/Timestamp$Builder
      //   493: astore_1
      //   494: aload_0
      //   495: aload_2
      //   496: invokestatic 451	com/google/protobuf/Timestamp:parser	()Lcom/google/protobuf/Parser;
      //   499: aload_3
      //   500: invokevirtual 455	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   503: checkcast 275	com/google/protobuf/Timestamp
      //   506: putfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   509: aload_1
      //   510: ifnull +23 -> 533
      //   513: aload_1
      //   514: aload_0
      //   515: getfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   518: invokevirtual 288	com/google/protobuf/Timestamp$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   521: pop
      //   522: aload_0
      //   523: aload_1
      //   524: invokevirtual 291	com/google/protobuf/Timestamp$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   527: checkcast 275	com/google/protobuf/Timestamp
      //   530: putfield 263	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:time_	Lcom/google/protobuf/Timestamp;
      //   533: aload_0
      //   534: aload_0
      //   535: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   538: iconst_4
      //   539: ior
      //   540: putfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   543: goto -254 -> 289
      //   546: aload_2
      //   547: invokevirtual 458	com/google/protobuf/CodedInputStream:readEnum	()I
      //   550: istore 5
      //   552: iload 5
      //   554: invokestatic 462	com/google/location/visualmapping/visualmapstore/Types$DatasetType:forNumber	(I)Lcom/google/location/visualmapping/visualmapstore/Types$DatasetType;
      //   557: ifnonnull +13 -> 570
      //   560: aload_0
      //   561: iconst_4
      //   562: iload 5
      //   564: invokespecial 466	com/google/protobuf/GeneratedMessageLite:mergeVarintField	(II)V
      //   567: goto -278 -> 289
      //   570: aload_0
      //   571: aload_0
      //   572: getfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   575: bipush 8
      //   577: ior
      //   578: putfield 251	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:bitField0_	I
      //   581: aload_0
      //   582: iload 5
      //   584: putfield 265	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:type_	I
      //   587: goto -298 -> 289
      //   590: aload_0
      //   591: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   594: invokeinterface 269 1 0
      //   599: ifne +14 -> 613
      //   602: aload_0
      //   603: aload_0
      //   604: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   607: invokestatic 273	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   610: putfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   613: aload_0
      //   614: getfield 67	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   617: aload_2
      //   618: invokestatic 469	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:parser	()Lcom/google/protobuf/Parser;
      //   621: aload_3
      //   622: invokevirtual 455	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   625: invokeinterface 246 2 0
      //   630: pop
      //   631: goto -342 -> 289
      //   634: aload_0
      //   635: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   638: invokeinterface 269 1 0
      //   643: ifne +14 -> 657
      //   646: aload_0
      //   647: aload_0
      //   648: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   651: invokestatic 273	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   654: putfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   657: aload_0
      //   658: getfield 69	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:annotations_	Lcom/google/protobuf/Internal$ProtobufList;
      //   661: aload_2
      //   662: invokestatic 472	com/google/location/visualmapping/visualmapstore/VisualMapStored$Annotation:parser	()Lcom/google/protobuf/Parser;
      //   665: aload_3
      //   666: invokevirtual 455	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   669: invokeinterface 246 2 0
      //   674: pop
      //   675: goto -386 -> 289
      //   678: getstatic 50	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto;
      //   681: areturn
      //   682: getstatic 474	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:PARSER	Lcom/google/protobuf/Parser;
      //   685: ifnonnull +28 -> 713
      //   688: ldc 2
      //   690: monitorenter
      //   691: getstatic 474	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:PARSER	Lcom/google/protobuf/Parser;
      //   694: ifnonnull +16 -> 710
      //   697: new 476	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   700: dup
      //   701: getstatic 50	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto;
      //   704: invokespecial 479	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   707: putstatic 474	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:PARSER	Lcom/google/protobuf/Parser;
      //   710: ldc 2
      //   712: monitorexit
      //   713: getstatic 474	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:PARSER	Lcom/google/protobuf/Parser;
      //   716: areturn
      //   717: astore_1
      //   718: ldc 2
      //   720: monitorexit
      //   721: aload_1
      //   722: athrow
      //   723: goto -355 -> 368
      //   726: iconst_1
      //   727: istore 4
      //   729: goto -440 -> 289
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	732	0	this	TrajectorySummaryProto
      //   0	732	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	732	2	paramObject1	Object
      //   0	732	3	paramObject2	Object
      //   287	441	4	i	int
      //   298	285	5	j	int
      // Exception table:
      //   from	to	target	type
      //   294	300	407	com/google/protobuf/InvalidProtocolBufferException
      //   368	378	407	com/google/protobuf/InvalidProtocolBufferException
      //   384	404	407	com/google/protobuf/InvalidProtocolBufferException
      //   424	444	407	com/google/protobuf/InvalidProtocolBufferException
      //   473	494	407	com/google/protobuf/InvalidProtocolBufferException
      //   494	509	407	com/google/protobuf/InvalidProtocolBufferException
      //   513	533	407	com/google/protobuf/InvalidProtocolBufferException
      //   533	543	407	com/google/protobuf/InvalidProtocolBufferException
      //   546	567	407	com/google/protobuf/InvalidProtocolBufferException
      //   570	587	407	com/google/protobuf/InvalidProtocolBufferException
      //   590	613	407	com/google/protobuf/InvalidProtocolBufferException
      //   613	631	407	com/google/protobuf/InvalidProtocolBufferException
      //   634	657	407	com/google/protobuf/InvalidProtocolBufferException
      //   657	675	407	com/google/protobuf/InvalidProtocolBufferException
      //   294	300	421	finally
      //   368	378	421	finally
      //   384	404	421	finally
      //   408	421	421	finally
      //   424	444	421	finally
      //   448	471	421	finally
      //   473	494	421	finally
      //   494	509	421	finally
      //   513	533	421	finally
      //   533	543	421	finally
      //   546	567	421	finally
      //   570	587	421	finally
      //   590	613	421	finally
      //   613	631	421	finally
      //   634	657	421	finally
      //   657	675	421	finally
      //   294	300	447	java/io/IOException
      //   368	378	447	java/io/IOException
      //   384	404	447	java/io/IOException
      //   424	444	447	java/io/IOException
      //   473	494	447	java/io/IOException
      //   494	509	447	java/io/IOException
      //   513	533	447	java/io/IOException
      //   533	543	447	java/io/IOException
      //   546	567	447	java/io/IOException
      //   570	587	447	java/io/IOException
      //   590	613	447	java/io/IOException
      //   613	631	447	java/io/IOException
      //   634	657	447	java/io/IOException
      //   657	675	447	java/io/IOException
      //   691	710	717	finally
      //   710	713	717	finally
      //   718	721	717	finally
    }
    
    public String getAdfUuid()
    {
      return this.adfUuid_;
    }
    
    public ByteString getAdfUuidBytes()
    {
      return ByteString.copyFromUtf8(this.adfUuid_);
    }
    
    public VisualMapStored.Annotation getAnnotations(int paramInt)
    {
      return (VisualMapStored.Annotation)this.annotations_.get(paramInt);
    }
    
    public int getAnnotationsCount()
    {
      return this.annotations_.size();
    }
    
    public List<VisualMapStored.Annotation> getAnnotationsList()
    {
      return this.annotations_;
    }
    
    public VisualMapStored.AnnotationOrBuilder getAnnotationsOrBuilder(int paramInt)
    {
      return (VisualMapStored.AnnotationOrBuilder)this.annotations_.get(paramInt);
    }
    
    public List<? extends VisualMapStored.AnnotationOrBuilder> getAnnotationsOrBuilderList()
    {
      return this.annotations_;
    }
    
    public S2Proto.LatLngAltProto getPoints(int paramInt)
    {
      return (S2Proto.LatLngAltProto)this.points_.get(paramInt);
    }
    
    public int getPointsCount()
    {
      return this.points_.size();
    }
    
    public List<S2Proto.LatLngAltProto> getPointsList()
    {
      return this.points_;
    }
    
    public S2Proto.LatLngAltProtoOrBuilder getPointsOrBuilder(int paramInt)
    {
      return (S2Proto.LatLngAltProtoOrBuilder)this.points_.get(paramInt);
    }
    
    public List<? extends S2Proto.LatLngAltProtoOrBuilder> getPointsOrBuilderList()
    {
      return this.points_;
    }
    
    public String getRosbagUuid()
    {
      return this.rosbagUuid_;
    }
    
    public ByteString getRosbagUuidBytes()
    {
      return ByteString.copyFromUtf8(this.rosbagUuid_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getAdfUuid());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getRosbagUuid());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeMessageSize(3, getTime());
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeEnumSize(4, this.type_);
      }
      j = 0;
      while (j < this.points_.size())
      {
        i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.points_.get(j));
        j += 1;
      }
      int k = 0;
      j = i;
      i = k;
      while (i < this.annotations_.size())
      {
        j += CodedOutputStream.computeMessageSize(6, (MessageLite)this.annotations_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public Timestamp getTime()
    {
      if (this.time_ == null) {
        return Timestamp.getDefaultInstance();
      }
      return this.time_;
    }
    
    public Types.DatasetType getType()
    {
      Types.DatasetType localDatasetType2 = Types.DatasetType.forNumber(this.type_);
      Types.DatasetType localDatasetType1 = localDatasetType2;
      if (localDatasetType2 == null) {
        localDatasetType1 = Types.DatasetType.DATASET_TYPE_UNKNOWN;
      }
      return localDatasetType1;
    }
    
    public boolean hasAdfUuid()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasRosbagUuid()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasTime()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasType()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getAdfUuid());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getRosbagUuid());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeMessage(3, getTime());
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeEnum(4, this.type_);
      }
      int i = 0;
      while (i < this.points_.size())
      {
        paramCodedOutputStream.writeMessage(5, (MessageLite)this.points_.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.annotations_.size())
      {
        paramCodedOutputStream.writeMessage(6, (MessageLite)this.annotations_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<TrajectorySummary.TrajectorySummaryProto, Builder>
      implements TrajectorySummary.TrajectorySummaryProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllAnnotations(Iterable<? extends VisualMapStored.Annotation> paramIterable)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAllAnnotations(paramIterable);
        return this;
      }
      
      public Builder addAllPoints(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAllPoints(paramIterable);
        return this;
      }
      
      public Builder addAnnotations(int paramInt, VisualMapStored.Annotation.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAnnotations(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addAnnotations(int paramInt, VisualMapStored.Annotation paramAnnotation)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAnnotations(paramInt, paramAnnotation);
        return this;
      }
      
      public Builder addAnnotations(VisualMapStored.Annotation.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAnnotations(paramBuilder);
        return this;
      }
      
      public Builder addAnnotations(VisualMapStored.Annotation paramAnnotation)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addAnnotations(paramAnnotation);
        return this;
      }
      
      public Builder addPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addPoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addPoints(paramInt, paramLatLngAltProto);
        return this;
      }
      
      public Builder addPoints(S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addPoints(paramBuilder);
        return this;
      }
      
      public Builder addPoints(S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).addPoints(paramLatLngAltProto);
        return this;
      }
      
      public Builder clearAdfUuid()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearAdfUuid();
        return this;
      }
      
      public Builder clearAnnotations()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearAnnotations();
        return this;
      }
      
      public Builder clearPoints()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearPoints();
        return this;
      }
      
      public Builder clearRosbagUuid()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearRosbagUuid();
        return this;
      }
      
      public Builder clearTime()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearTime();
        return this;
      }
      
      public Builder clearType()
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).clearType();
        return this;
      }
      
      public String getAdfUuid()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getAdfUuid();
      }
      
      public ByteString getAdfUuidBytes()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getAdfUuidBytes();
      }
      
      public VisualMapStored.Annotation getAnnotations(int paramInt)
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getAnnotations(paramInt);
      }
      
      public int getAnnotationsCount()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getAnnotationsCount();
      }
      
      public List<VisualMapStored.Annotation> getAnnotationsList()
      {
        return Collections.unmodifiableList(((TrajectorySummary.TrajectorySummaryProto)this.instance).getAnnotationsList());
      }
      
      public S2Proto.LatLngAltProto getPoints(int paramInt)
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getPoints(paramInt);
      }
      
      public int getPointsCount()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getPointsCount();
      }
      
      public List<S2Proto.LatLngAltProto> getPointsList()
      {
        return Collections.unmodifiableList(((TrajectorySummary.TrajectorySummaryProto)this.instance).getPointsList());
      }
      
      public String getRosbagUuid()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getRosbagUuid();
      }
      
      public ByteString getRosbagUuidBytes()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getRosbagUuidBytes();
      }
      
      public Timestamp getTime()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getTime();
      }
      
      public Types.DatasetType getType()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).getType();
      }
      
      public boolean hasAdfUuid()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).hasAdfUuid();
      }
      
      public boolean hasRosbagUuid()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).hasRosbagUuid();
      }
      
      public boolean hasTime()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).hasTime();
      }
      
      public boolean hasType()
      {
        return ((TrajectorySummary.TrajectorySummaryProto)this.instance).hasType();
      }
      
      public Builder mergeTime(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).mergeTime(paramTimestamp);
        return this;
      }
      
      public Builder removeAnnotations(int paramInt)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).removeAnnotations(paramInt);
        return this;
      }
      
      public Builder removePoints(int paramInt)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).removePoints(paramInt);
        return this;
      }
      
      public Builder setAdfUuid(String paramString)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setAdfUuid(paramString);
        return this;
      }
      
      public Builder setAdfUuidBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setAdfUuidBytes(paramByteString);
        return this;
      }
      
      public Builder setAnnotations(int paramInt, VisualMapStored.Annotation.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setAnnotations(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setAnnotations(int paramInt, VisualMapStored.Annotation paramAnnotation)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setAnnotations(paramInt, paramAnnotation);
        return this;
      }
      
      public Builder setPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setPoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setPoints(paramInt, paramLatLngAltProto);
        return this;
      }
      
      public Builder setRosbagUuid(String paramString)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setRosbagUuid(paramString);
        return this;
      }
      
      public Builder setRosbagUuidBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setRosbagUuidBytes(paramByteString);
        return this;
      }
      
      public Builder setTime(Timestamp.Builder paramBuilder)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setTime(paramBuilder);
        return this;
      }
      
      public Builder setTime(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setTime(paramTimestamp);
        return this;
      }
      
      public Builder setType(Types.DatasetType paramDatasetType)
      {
        copyOnWrite();
        ((TrajectorySummary.TrajectorySummaryProto)this.instance).setType(paramDatasetType);
        return this;
      }
    }
  }
  
  public static abstract interface TrajectorySummaryProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getAdfUuid();
    
    public abstract ByteString getAdfUuidBytes();
    
    public abstract VisualMapStored.Annotation getAnnotations(int paramInt);
    
    public abstract int getAnnotationsCount();
    
    public abstract List<VisualMapStored.Annotation> getAnnotationsList();
    
    public abstract S2Proto.LatLngAltProto getPoints(int paramInt);
    
    public abstract int getPointsCount();
    
    public abstract List<S2Proto.LatLngAltProto> getPointsList();
    
    public abstract String getRosbagUuid();
    
    public abstract ByteString getRosbagUuidBytes();
    
    public abstract Timestamp getTime();
    
    public abstract Types.DatasetType getType();
    
    public abstract boolean hasAdfUuid();
    
    public abstract boolean hasRosbagUuid();
    
    public abstract boolean hasTime();
    
    public abstract boolean hasType();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/vpsmanagement/TrajectorySummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */