package com.google.location.visualmapping.visualmapstore.common;

import com.google.location.visualmapping.common.S2Proto.LatLngAltProto;
import com.google.location.visualmapping.common.S2Proto.LatLngAltProto.Builder;
import com.google.location.visualmapping.common.S2Proto.LatLngAltProtoOrBuilder;
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

public final class AggregatedLocalizationResults
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class DistanceLocalizedCount
    extends GeneratedMessageLite<DistanceLocalizedCount, Builder>
    implements AggregatedLocalizationResults.DistanceLocalizedCountOrBuilder
  {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final DistanceLocalizedCount DEFAULT_INSTANCE = new DistanceLocalizedCount();
    public static final int DISTANCE_CENTIMETERS_FIELD_NUMBER = 1;
    private static volatile Parser<DistanceLocalizedCount> PARSER;
    private int bitField0_;
    private long count_;
    private long distanceCentimeters_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCount()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.count_ = 0L;
    }
    
    private void clearDistanceCentimeters()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.distanceCentimeters_ = 0L;
    }
    
    public static DistanceLocalizedCount getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DistanceLocalizedCount paramDistanceLocalizedCount)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDistanceLocalizedCount);
    }
    
    public static DistanceLocalizedCount parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (DistanceLocalizedCount)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static DistanceLocalizedCount parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (DistanceLocalizedCount)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static DistanceLocalizedCount parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static DistanceLocalizedCount parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static DistanceLocalizedCount parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static DistanceLocalizedCount parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static DistanceLocalizedCount parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static DistanceLocalizedCount parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static DistanceLocalizedCount parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static DistanceLocalizedCount parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (DistanceLocalizedCount)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<DistanceLocalizedCount> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCount(long paramLong)
    {
      this.bitField0_ |= 0x2;
      this.count_ = paramLong;
    }
    
    private void setDistanceCentimeters(long paramLong)
    {
      this.bitField0_ |= 0x1;
      this.distanceCentimeters_ = paramLong;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 136	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 142	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
      //   56: new 144	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 145	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount
      //   67: dup
      //   68: invokespecial 32	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 148	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 150	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 154	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:hasDistanceCentimeters	()Z
      //   105: aload_0
      //   106: getfield 66	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:distanceCentimeters_	J
      //   109: aload_3
      //   110: invokevirtual 154	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:hasDistanceCentimeters	()Z
      //   113: aload_3
      //   114: getfield 66	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:distanceCentimeters_	J
      //   117: invokeinterface 158 7 0
      //   122: putfield 66	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:distanceCentimeters_	J
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:hasCount	()Z
      //   131: aload_0
      //   132: getfield 64	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:count_	J
      //   135: aload_3
      //   136: invokevirtual 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:hasCount	()Z
      //   139: aload_3
      //   140: getfield 64	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:count_	J
      //   143: invokeinterface 158 7 0
      //   148: putfield 64	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:count_	J
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 167	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   165: aload_3
      //   166: getfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   169: ior
      //   170: putfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 169	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 171	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +145 -> 335
      //   193: aload_1
      //   194: invokevirtual 174	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+179->380, 0:+182->383, 8:+51->252, 16:+89->290
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 182	com/google/protobuf/CodedInputStream:readInt64	()J
      //   267: putfield 66	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:distanceCentimeters_	J
      //   270: goto -82 -> 188
      //   273: astore_1
      //   274: new 184	java/lang/RuntimeException
      //   277: dup
      //   278: aload_1
      //   279: aload_0
      //   280: invokevirtual 188	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   283: invokespecial 191	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   286: athrow
      //   287: astore_1
      //   288: aload_1
      //   289: athrow
      //   290: aload_0
      //   291: aload_0
      //   292: getfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   295: iconst_2
      //   296: ior
      //   297: putfield 62	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:bitField0_	I
      //   300: aload_0
      //   301: aload_1
      //   302: invokevirtual 182	com/google/protobuf/CodedInputStream:readInt64	()J
      //   305: putfield 64	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:count_	J
      //   308: goto -120 -> 188
      //   311: astore_1
      //   312: new 184	java/lang/RuntimeException
      //   315: dup
      //   316: new 94	com/google/protobuf/InvalidProtocolBufferException
      //   319: dup
      //   320: aload_1
      //   321: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
      //   324: invokespecial 198	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   327: aload_0
      //   328: invokevirtual 188	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   331: invokespecial 191	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   334: athrow
      //   335: getstatic 34	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount;
      //   338: areturn
      //   339: getstatic 200	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:PARSER	Lcom/google/protobuf/Parser;
      //   342: ifnonnull +28 -> 370
      //   345: ldc 2
      //   347: monitorenter
      //   348: getstatic 200	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:PARSER	Lcom/google/protobuf/Parser;
      //   351: ifnonnull +16 -> 367
      //   354: new 202	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   357: dup
      //   358: getstatic 34	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount;
      //   361: invokespecial 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   364: putstatic 200	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:PARSER	Lcom/google/protobuf/Parser;
      //   367: ldc 2
      //   369: monitorexit
      //   370: getstatic 200	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	389	0	this	DistanceLocalizedCount
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
    
    public long getCount()
    {
      return this.count_;
    }
    
    public long getDistanceCentimeters()
    {
      return this.distanceCentimeters_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeInt64Size(1, this.distanceCentimeters_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeInt64Size(2, this.count_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCount()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasDistanceCentimeters()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt64(1, this.distanceCentimeters_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeInt64(2, this.count_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.DistanceLocalizedCount, Builder>
      implements AggregatedLocalizationResults.DistanceLocalizedCountOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearCount()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).clearCount();
        return this;
      }
      
      public Builder clearDistanceCentimeters()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).clearDistanceCentimeters();
        return this;
      }
      
      public long getCount()
      {
        return ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).getCount();
      }
      
      public long getDistanceCentimeters()
      {
        return ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).getDistanceCentimeters();
      }
      
      public boolean hasCount()
      {
        return ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).hasCount();
      }
      
      public boolean hasDistanceCentimeters()
      {
        return ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).hasDistanceCentimeters();
      }
      
      public Builder setCount(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).setCount(paramLong);
        return this;
      }
      
      public Builder setDistanceCentimeters(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.DistanceLocalizedCount)this.instance).setDistanceCentimeters(paramLong);
        return this;
      }
    }
  }
  
  public static abstract interface DistanceLocalizedCountOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract long getCount();
    
    public abstract long getDistanceCentimeters();
    
    public abstract boolean hasCount();
    
    public abstract boolean hasDistanceCentimeters();
  }
  
  public static final class LocalizationResultGroupClassifierProto
    extends GeneratedMessageLite<LocalizationResultGroupClassifierProto, Builder>
    implements AggregatedLocalizationResults.LocalizationResultGroupClassifierProtoOrBuilder
  {
    public static final int ALTITUDE_FIELD_NUMBER = 2;
    public static final int DATASET_TYPE_FIELD_NUMBER = 1;
    private static final LocalizationResultGroupClassifierProto DEFAULT_INSTANCE = new LocalizationResultGroupClassifierProto();
    private static volatile Parser<LocalizationResultGroupClassifierProto> PARSER;
    private long altitude_;
    private int bitField0_;
    private String datasetType_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAltitude()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.altitude_ = 0L;
    }
    
    private void clearDatasetType()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.datasetType_ = getDefaultInstance().getDatasetType();
    }
    
    public static LocalizationResultGroupClassifierProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocalizationResultGroupClassifierProto paramLocalizationResultGroupClassifierProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizationResultGroupClassifierProto);
    }
    
    public static LocalizationResultGroupClassifierProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultGroupClassifierProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LocalizationResultGroupClassifierProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupClassifierProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LocalizationResultGroupClassifierProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAltitude(long paramLong)
    {
      this.bitField0_ |= 0x2;
      this.altitude_ = paramLong;
    }
    
    private void setDatasetType(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.datasetType_ = paramString;
    }
    
    private void setDatasetTypeBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.datasetType_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 167	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+329->337, 8:+333->341
      //   56: new 169	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 170	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto
      //   67: dup
      //   68: invokespecial 33	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 173	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 175	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 179	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:hasDatasetType	()Z
      //   105: aload_0
      //   106: getfield 44	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:datasetType_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 179	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:hasDatasetType	()Z
      //   113: aload_3
      //   114: getfield 44	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:datasetType_	Ljava/lang/String;
      //   117: invokeinterface 183 5 0
      //   122: putfield 44	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:datasetType_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 186	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:hasAltitude	()Z
      //   131: aload_0
      //   132: getfield 77	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:altitude_	J
      //   135: aload_3
      //   136: invokevirtual 186	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:hasAltitude	()Z
      //   139: aload_3
      //   140: getfield 77	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:altitude_	J
      //   143: invokeinterface 190 7 0
      //   148: putfield 77	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:altitude_	J
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 196	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   165: aload_3
      //   166: getfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   169: ior
      //   170: putfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 198	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 200	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +147 -> 337
      //   193: aload_1
      //   194: invokevirtual 203	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+181->382, 0:+184->385, 10:+51->252, 16:+91->292
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 207	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_1
      //   253: invokevirtual 210	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   256: astore_2
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   262: iconst_1
      //   263: ior
      //   264: putfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   267: aload_0
      //   268: aload_2
      //   269: putfield 44	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:datasetType_	Ljava/lang/String;
      //   272: goto -84 -> 188
      //   275: astore_1
      //   276: new 212	java/lang/RuntimeException
      //   279: dup
      //   280: aload_1
      //   281: aload_0
      //   282: invokevirtual 216	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: astore_1
      //   290: aload_1
      //   291: athrow
      //   292: aload_0
      //   293: aload_0
      //   294: getfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   297: iconst_2
      //   298: ior
      //   299: putfield 75	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:bitField0_	I
      //   302: aload_0
      //   303: aload_1
      //   304: invokevirtual 223	com/google/protobuf/CodedInputStream:readInt64	()J
      //   307: putfield 77	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:altitude_	J
      //   310: goto -122 -> 188
      //   313: astore_1
      //   314: new 212	java/lang/RuntimeException
      //   317: dup
      //   318: new 111	com/google/protobuf/InvalidProtocolBufferException
      //   321: dup
      //   322: aload_1
      //   323: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
      //   326: invokespecial 228	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   329: aload_0
      //   330: invokevirtual 216	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   333: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   336: athrow
      //   337: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   340: areturn
      //   341: getstatic 230	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:PARSER	Lcom/google/protobuf/Parser;
      //   344: ifnonnull +28 -> 372
      //   347: ldc 2
      //   349: monitorenter
      //   350: getstatic 230	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:PARSER	Lcom/google/protobuf/Parser;
      //   353: ifnonnull +16 -> 369
      //   356: new 232	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   359: dup
      //   360: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   363: invokespecial 235	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   366: putstatic 230	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:PARSER	Lcom/google/protobuf/Parser;
      //   369: ldc 2
      //   371: monitorexit
      //   372: getstatic 230	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:PARSER	Lcom/google/protobuf/Parser;
      //   375: areturn
      //   376: astore_1
      //   377: ldc 2
      //   379: monitorexit
      //   380: aload_1
      //   381: athrow
      //   382: goto -146 -> 236
      //   385: iconst_1
      //   386: istore 4
      //   388: goto -200 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	391	0	this	LocalizationResultGroupClassifierProto
      //   0	391	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	391	2	paramObject1	Object
      //   0	391	3	paramObject2	Object
      //   186	201	4	i	int
      //   197	41	5	j	int
      // Exception table:
      //   from	to	target	type
      //   193	199	275	com/google/protobuf/InvalidProtocolBufferException
      //   236	246	275	com/google/protobuf/InvalidProtocolBufferException
      //   252	272	275	com/google/protobuf/InvalidProtocolBufferException
      //   292	310	275	com/google/protobuf/InvalidProtocolBufferException
      //   193	199	289	finally
      //   236	246	289	finally
      //   252	272	289	finally
      //   276	289	289	finally
      //   292	310	289	finally
      //   314	337	289	finally
      //   193	199	313	java/io/IOException
      //   236	246	313	java/io/IOException
      //   252	272	313	java/io/IOException
      //   292	310	313	java/io/IOException
      //   350	369	376	finally
      //   369	372	376	finally
      //   377	380	376	finally
    }
    
    public long getAltitude()
    {
      return this.altitude_;
    }
    
    public String getDatasetType()
    {
      return this.datasetType_;
    }
    
    public ByteString getDatasetTypeBytes()
    {
      return ByteString.copyFromUtf8(this.datasetType_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getDatasetType());
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeInt64Size(2, this.altitude_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAltitude()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasDatasetType()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getDatasetType());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeInt64(2, this.altitude_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.LocalizationResultGroupClassifierProto, Builder>
      implements AggregatedLocalizationResults.LocalizationResultGroupClassifierProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearAltitude()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).clearAltitude();
        return this;
      }
      
      public Builder clearDatasetType()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).clearDatasetType();
        return this;
      }
      
      public long getAltitude()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).getAltitude();
      }
      
      public String getDatasetType()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).getDatasetType();
      }
      
      public ByteString getDatasetTypeBytes()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).getDatasetTypeBytes();
      }
      
      public boolean hasAltitude()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).hasAltitude();
      }
      
      public boolean hasDatasetType()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).hasDatasetType();
      }
      
      public Builder setAltitude(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).setAltitude(paramLong);
        return this;
      }
      
      public Builder setDatasetType(String paramString)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).setDatasetType(paramString);
        return this;
      }
      
      public Builder setDatasetTypeBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)this.instance).setDatasetTypeBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface LocalizationResultGroupClassifierProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract long getAltitude();
    
    public abstract String getDatasetType();
    
    public abstract ByteString getDatasetTypeBytes();
    
    public abstract boolean hasAltitude();
    
    public abstract boolean hasDatasetType();
  }
  
  public static final class LocalizationResultGroupProto
    extends GeneratedMessageLite<LocalizationResultGroupProto, Builder>
    implements AggregatedLocalizationResults.LocalizationResultGroupProtoOrBuilder
  {
    public static final int CLASSIFIERS_FIELD_NUMBER = 1;
    private static final LocalizationResultGroupProto DEFAULT_INSTANCE = new LocalizationResultGroupProto();
    private static volatile Parser<LocalizationResultGroupProto> PARSER;
    public static final int STATS_FIELD_NUMBER = 2;
    private int bitField0_;
    private AggregatedLocalizationResults.LocalizationResultGroupClassifierProto classifiers_;
    private AggregatedLocalizationResults.LocalizationStatsProto stats_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearClassifiers()
    {
      this.classifiers_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    private void clearStats()
    {
      this.stats_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    public static LocalizationResultGroupProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto paramLocalizationResultGroupClassifierProto)
    {
      if ((this.classifiers_ != null) && (this.classifiers_ != AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.getDefaultInstance())) {}
      for (this.classifiers_ = ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.Builder)AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.newBuilder(this.classifiers_).mergeFrom(paramLocalizationResultGroupClassifierProto)).buildPartial());; this.classifiers_ = paramLocalizationResultGroupClassifierProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    private void mergeStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if ((this.stats_ != null) && (this.stats_ != AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance())) {}
      for (this.stats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)((AggregatedLocalizationResults.LocalizationStatsProto.Builder)AggregatedLocalizationResults.LocalizationStatsProto.newBuilder(this.stats_).mergeFrom(paramLocalizationStatsProto)).buildPartial());; this.stats_ = paramLocalizationStatsProto)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocalizationResultGroupProto paramLocalizationResultGroupProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizationResultGroupProto);
    }
    
    public static LocalizationResultGroupProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultGroupProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultGroupProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LocalizationResultGroupProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LocalizationResultGroupProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultGroupProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultGroupProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LocalizationResultGroupProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultGroupProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LocalizationResultGroupProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.Builder paramBuilder)
    {
      this.classifiers_ = ((AggregatedLocalizationResults.LocalizationResultGroupClassifierProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto paramLocalizationResultGroupClassifierProto)
    {
      if (paramLocalizationResultGroupClassifierProto == null) {
        throw new NullPointerException();
      }
      this.classifiers_ = paramLocalizationResultGroupClassifierProto;
      this.bitField0_ |= 0x1;
    }
    
    private void setStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
    {
      this.stats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if (paramLocalizationStatsProto == null) {
        throw new NullPointerException();
      }
      this.stats_ = paramLocalizationStatsProto;
      this.bitField0_ |= 0x2;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 191	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 197	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+157->165, 7:+423->431, 8:+427->435
      //   56: new 199	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 200	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto
      //   67: dup
      //   68: invokespecial 33	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 203	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 205	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   105: aload_3
      //   106: getfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   109: invokeinterface 209 3 0
      //   114: checkcast 90	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto
      //   117: putfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   120: aload_0
      //   121: aload_2
      //   122: aload_0
      //   123: getfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   126: aload_3
      //   127: getfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   130: invokeinterface 209 3 0
      //   135: checkcast 109	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   138: putfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   141: aload_0
      //   142: astore_1
      //   143: aload_2
      //   144: getstatic 215	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   147: if_acmpne -75 -> 72
      //   150: aload_0
      //   151: aload_0
      //   152: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   155: aload_3
      //   156: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   159: ior
      //   160: putfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   163: aload_0
      //   164: areturn
      //   165: aload_2
      //   166: checkcast 217	com/google/protobuf/CodedInputStream
      //   169: astore_2
      //   170: aload_3
      //   171: checkcast 219	com/google/protobuf/ExtensionRegistryLite
      //   174: astore_3
      //   175: iconst_0
      //   176: istore 4
      //   178: iload 4
      //   180: ifne +251 -> 431
      //   183: aload_2
      //   184: invokevirtual 222	com/google/protobuf/CodedInputStream:readTag	()I
      //   187: istore 5
      //   189: iload 5
      //   191: lookupswitch	default:+285->476, 0:+288->479, 10:+49->240, 18:+141->332
      //   224: aload_0
      //   225: iload 5
      //   227: aload_2
      //   228: invokevirtual 226	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   231: ifne -53 -> 178
      //   234: iconst_1
      //   235: istore 4
      //   237: goto -59 -> 178
      //   240: aconst_null
      //   241: astore_1
      //   242: aload_0
      //   243: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   246: iconst_1
      //   247: iand
      //   248: iconst_1
      //   249: if_icmpne +14 -> 263
      //   252: aload_0
      //   253: getfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   256: invokevirtual 227	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   259: checkcast 99	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto$Builder
      //   262: astore_1
      //   263: aload_0
      //   264: aload_2
      //   265: invokestatic 229	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto:parser	()Lcom/google/protobuf/Parser;
      //   268: aload_3
      //   269: invokevirtual 233	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   272: checkcast 90	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto
      //   275: putfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   278: aload_1
      //   279: ifnull +23 -> 302
      //   282: aload_1
      //   283: aload_0
      //   284: getfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   287: invokevirtual 103	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   290: pop
      //   291: aload_0
      //   292: aload_1
      //   293: invokevirtual 107	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   296: checkcast 90	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto
      //   299: putfield 83	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:classifiers_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupClassifierProto;
      //   302: aload_0
      //   303: aload_0
      //   304: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   307: iconst_1
      //   308: ior
      //   309: putfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   312: goto -134 -> 178
      //   315: astore_1
      //   316: new 235	java/lang/RuntimeException
      //   319: dup
      //   320: aload_1
      //   321: aload_0
      //   322: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   325: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   328: athrow
      //   329: astore_1
      //   330: aload_1
      //   331: athrow
      //   332: aconst_null
      //   333: astore_1
      //   334: aload_0
      //   335: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   338: iconst_2
      //   339: iand
      //   340: iconst_2
      //   341: if_icmpne +14 -> 355
      //   344: aload_0
      //   345: getfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   348: invokevirtual 243	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   351: checkcast 117	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder
      //   354: astore_1
      //   355: aload_0
      //   356: aload_2
      //   357: invokestatic 244	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:parser	()Lcom/google/protobuf/Parser;
      //   360: aload_3
      //   361: invokevirtual 233	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   364: checkcast 109	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   367: putfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   370: aload_1
      //   371: ifnull +23 -> 394
      //   374: aload_1
      //   375: aload_0
      //   376: getfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   379: invokevirtual 118	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   382: pop
      //   383: aload_0
      //   384: aload_1
      //   385: invokevirtual 119	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   388: checkcast 109	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   391: putfield 87	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:stats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   394: aload_0
      //   395: aload_0
      //   396: getfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   399: iconst_2
      //   400: ior
      //   401: putfield 85	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:bitField0_	I
      //   404: goto -226 -> 178
      //   407: astore_1
      //   408: new 235	java/lang/RuntimeException
      //   411: dup
      //   412: new 142	com/google/protobuf/InvalidProtocolBufferException
      //   415: dup
      //   416: aload_1
      //   417: invokevirtual 248	java/io/IOException:getMessage	()Ljava/lang/String;
      //   420: invokespecial 251	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   423: aload_0
      //   424: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   427: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   430: athrow
      //   431: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto;
      //   434: areturn
      //   435: getstatic 253	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:PARSER	Lcom/google/protobuf/Parser;
      //   438: ifnonnull +28 -> 466
      //   441: ldc 2
      //   443: monitorenter
      //   444: getstatic 253	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:PARSER	Lcom/google/protobuf/Parser;
      //   447: ifnonnull +16 -> 463
      //   450: new 255	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   453: dup
      //   454: getstatic 35	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto;
      //   457: invokespecial 258	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   460: putstatic 253	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:PARSER	Lcom/google/protobuf/Parser;
      //   463: ldc 2
      //   465: monitorexit
      //   466: getstatic 253	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:PARSER	Lcom/google/protobuf/Parser;
      //   469: areturn
      //   470: astore_1
      //   471: ldc 2
      //   473: monitorexit
      //   474: aload_1
      //   475: athrow
      //   476: goto -252 -> 224
      //   479: iconst_1
      //   480: istore 4
      //   482: goto -304 -> 178
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	485	0	this	LocalizationResultGroupProto
      //   0	485	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	485	2	paramObject1	Object
      //   0	485	3	paramObject2	Object
      //   176	305	4	i	int
      //   187	39	5	j	int
      // Exception table:
      //   from	to	target	type
      //   183	189	315	com/google/protobuf/InvalidProtocolBufferException
      //   224	234	315	com/google/protobuf/InvalidProtocolBufferException
      //   242	263	315	com/google/protobuf/InvalidProtocolBufferException
      //   263	278	315	com/google/protobuf/InvalidProtocolBufferException
      //   282	302	315	com/google/protobuf/InvalidProtocolBufferException
      //   302	312	315	com/google/protobuf/InvalidProtocolBufferException
      //   334	355	315	com/google/protobuf/InvalidProtocolBufferException
      //   355	370	315	com/google/protobuf/InvalidProtocolBufferException
      //   374	394	315	com/google/protobuf/InvalidProtocolBufferException
      //   394	404	315	com/google/protobuf/InvalidProtocolBufferException
      //   183	189	329	finally
      //   224	234	329	finally
      //   242	263	329	finally
      //   263	278	329	finally
      //   282	302	329	finally
      //   302	312	329	finally
      //   316	329	329	finally
      //   334	355	329	finally
      //   355	370	329	finally
      //   374	394	329	finally
      //   394	404	329	finally
      //   408	431	329	finally
      //   183	189	407	java/io/IOException
      //   224	234	407	java/io/IOException
      //   242	263	407	java/io/IOException
      //   263	278	407	java/io/IOException
      //   282	302	407	java/io/IOException
      //   302	312	407	java/io/IOException
      //   334	355	407	java/io/IOException
      //   355	370	407	java/io/IOException
      //   374	394	407	java/io/IOException
      //   394	404	407	java/io/IOException
      //   444	463	470	finally
      //   463	466	470	finally
      //   471	474	470	finally
    }
    
    public AggregatedLocalizationResults.LocalizationResultGroupClassifierProto getClassifiers()
    {
      if (this.classifiers_ == null) {
        return AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.getDefaultInstance();
      }
      return this.classifiers_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, getClassifiers());
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(2, getStats());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public AggregatedLocalizationResults.LocalizationStatsProto getStats()
    {
      if (this.stats_ == null) {
        return AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance();
      }
      return this.stats_;
    }
    
    public boolean hasClassifiers()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasStats()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getClassifiers());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, getStats());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.LocalizationResultGroupProto, Builder>
      implements AggregatedLocalizationResults.LocalizationResultGroupProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearClassifiers()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).clearClassifiers();
        return this;
      }
      
      public Builder clearStats()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).clearStats();
        return this;
      }
      
      public AggregatedLocalizationResults.LocalizationResultGroupClassifierProto getClassifiers()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).getClassifiers();
      }
      
      public AggregatedLocalizationResults.LocalizationStatsProto getStats()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).getStats();
      }
      
      public boolean hasClassifiers()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).hasClassifiers();
      }
      
      public boolean hasStats()
      {
        return ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).hasStats();
      }
      
      public Builder mergeClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto paramLocalizationResultGroupClassifierProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).mergeClassifiers(paramLocalizationResultGroupClassifierProto);
        return this;
      }
      
      public Builder mergeStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).mergeStats(paramLocalizationStatsProto);
        return this;
      }
      
      public Builder setClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).setClassifiers(paramBuilder);
        return this;
      }
      
      public Builder setClassifiers(AggregatedLocalizationResults.LocalizationResultGroupClassifierProto paramLocalizationResultGroupClassifierProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).setClassifiers(paramLocalizationResultGroupClassifierProto);
        return this;
      }
      
      public Builder setStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).setStats(paramBuilder);
        return this;
      }
      
      public Builder setStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultGroupProto)this.instance).setStats(paramLocalizationStatsProto);
        return this;
      }
    }
  }
  
  public static abstract interface LocalizationResultGroupProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract AggregatedLocalizationResults.LocalizationResultGroupClassifierProto getClassifiers();
    
    public abstract AggregatedLocalizationResults.LocalizationStatsProto getStats();
    
    public abstract boolean hasClassifiers();
    
    public abstract boolean hasStats();
  }
  
  public static final class LocalizationResultsProto
    extends GeneratedMessageLite<LocalizationResultsProto, Builder>
    implements AggregatedLocalizationResults.LocalizationResultsProtoOrBuilder
  {
    public static final int AGGREGATE_STATS_FIELD_NUMBER = 2;
    private static final LocalizationResultsProto DEFAULT_INSTANCE = new LocalizationResultsProto();
    public static final int MOST_RECENT_COLLECTION_FIELD_NUMBER = 3;
    public static final int NUM_DAYS_PRIOR_TO_MOST_RECENT_COLLECTION_INCLUDED_FIELD_NUMBER = 4;
    private static volatile Parser<LocalizationResultsProto> PARSER;
    public static final int S2_CELL_LOCALIZATION_RESULTS_FIELD_NUMBER = 1;
    private AggregatedLocalizationResults.LocalizationStatsProto aggregateStats_;
    private int bitField0_;
    private Timestamp mostRecentCollection_;
    private int numDaysPriorToMostRecentCollectionIncluded_;
    private Internal.ProtobufList<AggregatedLocalizationResults.S2CellLocalizationResultsProto> s2CellLocalizationResults_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllS2CellLocalizationResults(Iterable<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProto> paramIterable)
    {
      ensureS2CellLocalizationResultsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.s2CellLocalizationResults_);
    }
    
    private void addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramInt, paramBuilder.build());
    }
    
    private void addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramInt, paramS2CellLocalizationResultsProto);
    }
    
    private void addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramBuilder.build());
    }
    
    private void addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramS2CellLocalizationResultsProto);
    }
    
    private void clearAggregateStats()
    {
      this.aggregateStats_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    private void clearMostRecentCollection()
    {
      this.mostRecentCollection_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearNumDaysPriorToMostRecentCollectionIncluded()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.numDaysPriorToMostRecentCollectionIncluded_ = 0;
    }
    
    private void clearS2CellLocalizationResults()
    {
      this.s2CellLocalizationResults_ = emptyProtobufList();
    }
    
    private void ensureS2CellLocalizationResultsIsMutable()
    {
      if (!this.s2CellLocalizationResults_.isModifiable()) {
        this.s2CellLocalizationResults_ = GeneratedMessageLite.mutableCopy(this.s2CellLocalizationResults_);
      }
    }
    
    public static LocalizationResultsProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if ((this.aggregateStats_ != null) && (this.aggregateStats_ != AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance())) {}
      for (this.aggregateStats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)((AggregatedLocalizationResults.LocalizationStatsProto.Builder)AggregatedLocalizationResults.LocalizationStatsProto.newBuilder(this.aggregateStats_).mergeFrom(paramLocalizationStatsProto)).buildPartial());; this.aggregateStats_ = paramLocalizationStatsProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    private void mergeMostRecentCollection(Timestamp paramTimestamp)
    {
      if ((this.mostRecentCollection_ != null) && (this.mostRecentCollection_ != Timestamp.getDefaultInstance())) {}
      for (this.mostRecentCollection_ = ((Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.mostRecentCollection_).mergeFrom(paramTimestamp)).buildPartial());; this.mostRecentCollection_ = paramTimestamp)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocalizationResultsProto paramLocalizationResultsProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizationResultsProto);
    }
    
    public static LocalizationResultsProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultsProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultsProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LocalizationResultsProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultsProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LocalizationResultsProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultsProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationResultsProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationResultsProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LocalizationResultsProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LocalizationResultsProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeS2CellLocalizationResults(int paramInt)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.remove(paramInt);
    }
    
    private void setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
    {
      this.aggregateStats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if (paramLocalizationStatsProto == null) {
        throw new NullPointerException();
      }
      this.aggregateStats_ = paramLocalizationStatsProto;
      this.bitField0_ |= 0x1;
    }
    
    private void setMostRecentCollection(Timestamp.Builder paramBuilder)
    {
      this.mostRecentCollection_ = ((Timestamp)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setMostRecentCollection(Timestamp paramTimestamp)
    {
      if (paramTimestamp == null) {
        throw new NullPointerException();
      }
      this.mostRecentCollection_ = paramTimestamp;
      this.bitField0_ |= 0x2;
    }
    
    private void setNumDaysPriorToMostRecentCollectionIncluded(int paramInt)
    {
      this.bitField0_ |= 0x4;
      this.numDaysPriorToMostRecentCollectionIncluded_ = paramInt;
    }
    
    private void setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.set(paramInt, paramBuilder.build());
    }
    
    private void setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.set(paramInt, paramS2CellLocalizationResultsProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 297	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 303	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+210->218, 7:+560->568, 8:+564->572
      //   56: new 305	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 306	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto
      //   67: dup
      //   68: invokespecial 41	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 43	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 307 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 310	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 312	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_3
      //   115: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 316 3 0
      //   123: putfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   126: aload_0
      //   127: aload_2
      //   128: aload_0
      //   129: getfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   132: aload_3
      //   133: getfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   136: invokeinterface 320 3 0
      //   141: checkcast 195	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   144: putfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   147: aload_0
      //   148: aload_2
      //   149: aload_0
      //   150: getfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   153: aload_3
      //   154: getfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   157: invokeinterface 320 3 0
      //   162: checkcast 213	com/google/protobuf/Timestamp
      //   165: putfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   168: aload_0
      //   169: aload_2
      //   170: aload_0
      //   171: invokevirtual 323	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:hasNumDaysPriorToMostRecentCollectionIncluded	()Z
      //   174: aload_0
      //   175: getfield 184	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:numDaysPriorToMostRecentCollectionIncluded_	I
      //   178: aload_3
      //   179: invokevirtual 323	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:hasNumDaysPriorToMostRecentCollectionIncluded	()Z
      //   182: aload_3
      //   183: getfield 184	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:numDaysPriorToMostRecentCollectionIncluded_	I
      //   186: invokeinterface 327 5 0
      //   191: putfield 184	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:numDaysPriorToMostRecentCollectionIncluded_	I
      //   194: aload_0
      //   195: astore_1
      //   196: aload_2
      //   197: getstatic 333	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   200: if_acmpne -128 -> 72
      //   203: aload_0
      //   204: aload_0
      //   205: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   208: aload_3
      //   209: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   212: ior
      //   213: putfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   216: aload_0
      //   217: areturn
      //   218: aload_2
      //   219: checkcast 335	com/google/protobuf/CodedInputStream
      //   222: astore_2
      //   223: aload_3
      //   224: checkcast 337	com/google/protobuf/ExtensionRegistryLite
      //   227: astore_3
      //   228: iconst_0
      //   229: istore 4
      //   231: iload 4
      //   233: ifne +335 -> 568
      //   236: aload_2
      //   237: invokevirtual 340	com/google/protobuf/CodedInputStream:readTag	()I
      //   240: istore 5
      //   242: iload 5
      //   244: lookupswitch	default:+369->613, 0:+372->616, 10:+68->312, 18:+129->373, 26:+228->472, 32:+303->547
      //   296: aload_0
      //   297: iload 5
      //   299: aload_2
      //   300: invokevirtual 344	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   303: ifne -72 -> 231
      //   306: iconst_1
      //   307: istore 4
      //   309: goto -78 -> 231
      //   312: aload_0
      //   313: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   316: invokeinterface 188 1 0
      //   321: ifne +14 -> 335
      //   324: aload_0
      //   325: aload_0
      //   326: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   329: invokestatic 192	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   332: putfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   335: aload_0
      //   336: getfield 54	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   339: aload_2
      //   340: invokestatic 348	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:parser	()Lcom/google/protobuf/Parser;
      //   343: aload_3
      //   344: invokevirtual 352	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   347: invokeinterface 176 2 0
      //   352: pop
      //   353: goto -122 -> 231
      //   356: astore_1
      //   357: new 354	java/lang/RuntimeException
      //   360: dup
      //   361: aload_1
      //   362: aload_0
      //   363: invokevirtual 358	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   366: invokespecial 361	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   369: athrow
      //   370: astore_1
      //   371: aload_1
      //   372: athrow
      //   373: aconst_null
      //   374: astore_1
      //   375: aload_0
      //   376: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   379: iconst_1
      //   380: iand
      //   381: iconst_1
      //   382: if_icmpne +14 -> 396
      //   385: aload_0
      //   386: getfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   389: invokevirtual 362	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   392: checkcast 204	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder
      //   395: astore_1
      //   396: aload_0
      //   397: aload_2
      //   398: invokestatic 363	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:parser	()Lcom/google/protobuf/Parser;
      //   401: aload_3
      //   402: invokevirtual 352	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   405: checkcast 195	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   408: putfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   411: aload_1
      //   412: ifnull +23 -> 435
      //   415: aload_1
      //   416: aload_0
      //   417: getfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   420: invokevirtual 208	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   423: pop
      //   424: aload_0
      //   425: aload_1
      //   426: invokevirtual 211	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   429: checkcast 195	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   432: putfield 178	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   435: aload_0
      //   436: aload_0
      //   437: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   440: iconst_1
      //   441: ior
      //   442: putfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   445: goto -214 -> 231
      //   448: astore_1
      //   449: new 354	java/lang/RuntimeException
      //   452: dup
      //   453: new 246	com/google/protobuf/InvalidProtocolBufferException
      //   456: dup
      //   457: aload_1
      //   458: invokevirtual 367	java/io/IOException:getMessage	()Ljava/lang/String;
      //   461: invokespecial 370	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   464: aload_0
      //   465: invokevirtual 358	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   468: invokespecial 361	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   471: athrow
      //   472: aconst_null
      //   473: astore_1
      //   474: aload_0
      //   475: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   478: iconst_2
      //   479: iand
      //   480: iconst_2
      //   481: if_icmpne +14 -> 495
      //   484: aload_0
      //   485: getfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   488: invokevirtual 371	com/google/protobuf/Timestamp:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   491: checkcast 221	com/google/protobuf/Timestamp$Builder
      //   494: astore_1
      //   495: aload_0
      //   496: aload_2
      //   497: invokestatic 372	com/google/protobuf/Timestamp:parser	()Lcom/google/protobuf/Parser;
      //   500: aload_3
      //   501: invokevirtual 352	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   504: checkcast 213	com/google/protobuf/Timestamp
      //   507: putfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   510: aload_1
      //   511: ifnull +23 -> 534
      //   514: aload_1
      //   515: aload_0
      //   516: getfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   519: invokevirtual 222	com/google/protobuf/Timestamp$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   522: pop
      //   523: aload_0
      //   524: aload_1
      //   525: invokevirtual 223	com/google/protobuf/Timestamp$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   528: checkcast 213	com/google/protobuf/Timestamp
      //   531: putfield 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   534: aload_0
      //   535: aload_0
      //   536: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   539: iconst_2
      //   540: ior
      //   541: putfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   544: goto -313 -> 231
      //   547: aload_0
      //   548: aload_0
      //   549: getfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   552: iconst_4
      //   553: ior
      //   554: putfield 180	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:bitField0_	I
      //   557: aload_0
      //   558: aload_2
      //   559: invokevirtual 375	com/google/protobuf/CodedInputStream:readInt32	()I
      //   562: putfield 184	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:numDaysPriorToMostRecentCollectionIncluded_	I
      //   565: goto -334 -> 231
      //   568: getstatic 43	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto;
      //   571: areturn
      //   572: getstatic 377	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   575: ifnonnull +28 -> 603
      //   578: ldc 2
      //   580: monitorenter
      //   581: getstatic 377	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   584: ifnonnull +16 -> 600
      //   587: new 379	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   590: dup
      //   591: getstatic 43	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto;
      //   594: invokespecial 382	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   597: putstatic 377	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   600: ldc 2
      //   602: monitorexit
      //   603: getstatic 377	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   606: areturn
      //   607: astore_1
      //   608: ldc 2
      //   610: monitorexit
      //   611: aload_1
      //   612: athrow
      //   613: goto -317 -> 296
      //   616: iconst_1
      //   617: istore 4
      //   619: goto -388 -> 231
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	622	0	this	LocalizationResultsProto
      //   0	622	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	622	2	paramObject1	Object
      //   0	622	3	paramObject2	Object
      //   229	389	4	i	int
      //   240	58	5	j	int
      // Exception table:
      //   from	to	target	type
      //   236	242	356	com/google/protobuf/InvalidProtocolBufferException
      //   296	306	356	com/google/protobuf/InvalidProtocolBufferException
      //   312	335	356	com/google/protobuf/InvalidProtocolBufferException
      //   335	353	356	com/google/protobuf/InvalidProtocolBufferException
      //   375	396	356	com/google/protobuf/InvalidProtocolBufferException
      //   396	411	356	com/google/protobuf/InvalidProtocolBufferException
      //   415	435	356	com/google/protobuf/InvalidProtocolBufferException
      //   435	445	356	com/google/protobuf/InvalidProtocolBufferException
      //   474	495	356	com/google/protobuf/InvalidProtocolBufferException
      //   495	510	356	com/google/protobuf/InvalidProtocolBufferException
      //   514	534	356	com/google/protobuf/InvalidProtocolBufferException
      //   534	544	356	com/google/protobuf/InvalidProtocolBufferException
      //   547	565	356	com/google/protobuf/InvalidProtocolBufferException
      //   236	242	370	finally
      //   296	306	370	finally
      //   312	335	370	finally
      //   335	353	370	finally
      //   357	370	370	finally
      //   375	396	370	finally
      //   396	411	370	finally
      //   415	435	370	finally
      //   435	445	370	finally
      //   449	472	370	finally
      //   474	495	370	finally
      //   495	510	370	finally
      //   514	534	370	finally
      //   534	544	370	finally
      //   547	565	370	finally
      //   236	242	448	java/io/IOException
      //   296	306	448	java/io/IOException
      //   312	335	448	java/io/IOException
      //   335	353	448	java/io/IOException
      //   375	396	448	java/io/IOException
      //   396	411	448	java/io/IOException
      //   415	435	448	java/io/IOException
      //   435	445	448	java/io/IOException
      //   474	495	448	java/io/IOException
      //   495	510	448	java/io/IOException
      //   514	534	448	java/io/IOException
      //   534	544	448	java/io/IOException
      //   547	565	448	java/io/IOException
      //   581	600	607	finally
      //   600	603	607	finally
      //   608	611	607	finally
    }
    
    public AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats()
    {
      if (this.aggregateStats_ == null) {
        return AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance();
      }
      return this.aggregateStats_;
    }
    
    public Timestamp getMostRecentCollection()
    {
      if (this.mostRecentCollection_ == null) {
        return Timestamp.getDefaultInstance();
      }
      return this.mostRecentCollection_;
    }
    
    public int getNumDaysPriorToMostRecentCollectionIncluded()
    {
      return this.numDaysPriorToMostRecentCollectionIncluded_;
    }
    
    public AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt)
    {
      return (AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.s2CellLocalizationResults_.get(paramInt);
    }
    
    public int getS2CellLocalizationResultsCount()
    {
      return this.s2CellLocalizationResults_.size();
    }
    
    public List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList()
    {
      return this.s2CellLocalizationResults_;
    }
    
    public AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder getS2CellLocalizationResultsOrBuilder(int paramInt)
    {
      return (AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder)this.s2CellLocalizationResults_.get(paramInt);
    }
    
    public List<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder> getS2CellLocalizationResultsOrBuilderList()
    {
      return this.s2CellLocalizationResults_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (j < this.s2CellLocalizationResults_.size())
      {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.s2CellLocalizationResults_.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x1) == 1) {
        j = i + CodedOutputStream.computeMessageSize(2, getAggregateStats());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeMessageSize(3, getMostRecentCollection());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeInt32Size(4, this.numDaysPriorToMostRecentCollectionIncluded_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAggregateStats()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasMostRecentCollection()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasNumDaysPriorToMostRecentCollectionIncluded()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.s2CellLocalizationResults_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.s2CellLocalizationResults_.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(2, getAggregateStats());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(3, getMostRecentCollection());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeInt32(4, this.numDaysPriorToMostRecentCollectionIncluded_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.LocalizationResultsProto, Builder>
      implements AggregatedLocalizationResults.LocalizationResultsProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllS2CellLocalizationResults(Iterable<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProto> paramIterable)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).addAllS2CellLocalizationResults(paramIterable);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).addS2CellLocalizationResults(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).addS2CellLocalizationResults(paramInt, paramS2CellLocalizationResultsProto);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).addS2CellLocalizationResults(paramBuilder);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).addS2CellLocalizationResults(paramS2CellLocalizationResultsProto);
        return this;
      }
      
      public Builder clearAggregateStats()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).clearAggregateStats();
        return this;
      }
      
      public Builder clearMostRecentCollection()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).clearMostRecentCollection();
        return this;
      }
      
      public Builder clearNumDaysPriorToMostRecentCollectionIncluded()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).clearNumDaysPriorToMostRecentCollectionIncluded();
        return this;
      }
      
      public Builder clearS2CellLocalizationResults()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).clearS2CellLocalizationResults();
        return this;
      }
      
      public AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getAggregateStats();
      }
      
      public Timestamp getMostRecentCollection()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getMostRecentCollection();
      }
      
      public int getNumDaysPriorToMostRecentCollectionIncluded()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getNumDaysPriorToMostRecentCollectionIncluded();
      }
      
      public AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt)
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getS2CellLocalizationResults(paramInt);
      }
      
      public int getS2CellLocalizationResultsCount()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getS2CellLocalizationResultsCount();
      }
      
      public List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList()
      {
        return Collections.unmodifiableList(((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).getS2CellLocalizationResultsList());
      }
      
      public boolean hasAggregateStats()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).hasAggregateStats();
      }
      
      public boolean hasMostRecentCollection()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).hasMostRecentCollection();
      }
      
      public boolean hasNumDaysPriorToMostRecentCollectionIncluded()
      {
        return ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).hasNumDaysPriorToMostRecentCollectionIncluded();
      }
      
      public Builder mergeAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).mergeAggregateStats(paramLocalizationStatsProto);
        return this;
      }
      
      public Builder mergeMostRecentCollection(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).mergeMostRecentCollection(paramTimestamp);
        return this;
      }
      
      public Builder removeS2CellLocalizationResults(int paramInt)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).removeS2CellLocalizationResults(paramInt);
        return this;
      }
      
      public Builder setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setAggregateStats(paramBuilder);
        return this;
      }
      
      public Builder setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setAggregateStats(paramLocalizationStatsProto);
        return this;
      }
      
      public Builder setMostRecentCollection(Timestamp.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setMostRecentCollection(paramBuilder);
        return this;
      }
      
      public Builder setMostRecentCollection(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setMostRecentCollection(paramTimestamp);
        return this;
      }
      
      public Builder setNumDaysPriorToMostRecentCollectionIncluded(int paramInt)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setNumDaysPriorToMostRecentCollectionIncluded(paramInt);
        return this;
      }
      
      public Builder setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setS2CellLocalizationResults(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationResultsProto)this.instance).setS2CellLocalizationResults(paramInt, paramS2CellLocalizationResultsProto);
        return this;
      }
    }
  }
  
  public static abstract interface LocalizationResultsProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats();
    
    public abstract Timestamp getMostRecentCollection();
    
    public abstract int getNumDaysPriorToMostRecentCollectionIncluded();
    
    public abstract AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt);
    
    public abstract int getS2CellLocalizationResultsCount();
    
    public abstract List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList();
    
    public abstract boolean hasAggregateStats();
    
    public abstract boolean hasMostRecentCollection();
    
    public abstract boolean hasNumDaysPriorToMostRecentCollectionIncluded();
  }
  
  public static final class LocalizationStatsProto
    extends GeneratedMessageLite<LocalizationStatsProto, Builder>
    implements AggregatedLocalizationResults.LocalizationStatsProtoOrBuilder
  {
    public static final int ACCURACY_FIELD_NUMBER = 7;
    private static final LocalizationStatsProto DEFAULT_INSTANCE = new LocalizationStatsProto();
    public static final int DISTANCE_LOCALIZED_COUNTS_FIELD_NUMBER = 9;
    public static final int NUM_FALSE_NEGATIVE_FIELD_NUMBER = 4;
    public static final int NUM_FALSE_POSITIVE_FIELD_NUMBER = 3;
    public static final int NUM_LOCALIZED_BEFORE_DISTANCE_THRESHOLD_FIELD_NUMBER = 8;
    public static final int NUM_TRUE_NEGATIVE_FIELD_NUMBER = 2;
    public static final int NUM_TRUE_POSITIVE_FIELD_NUMBER = 1;
    private static volatile Parser<LocalizationStatsProto> PARSER;
    public static final int PRECISION_FIELD_NUMBER = 5;
    public static final int RECALL_FIELD_NUMBER = 6;
    private double accuracy_;
    private int bitField0_;
    private Internal.ProtobufList<AggregatedLocalizationResults.DistanceLocalizedCount> distanceLocalizedCounts_ = emptyProtobufList();
    private long numFalseNegative_;
    private long numFalsePositive_;
    private long numLocalizedBeforeDistanceThreshold_;
    private long numTrueNegative_;
    private long numTruePositive_;
    private double precision_;
    private double recall_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllDistanceLocalizedCounts(Iterable<? extends AggregatedLocalizationResults.DistanceLocalizedCount> paramIterable)
    {
      ensureDistanceLocalizedCountsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.distanceLocalizedCounts_);
    }
    
    private void addDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
    {
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.add(paramInt, paramBuilder.build());
    }
    
    private void addDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
    {
      if (paramDistanceLocalizedCount == null) {
        throw new NullPointerException();
      }
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.add(paramInt, paramDistanceLocalizedCount);
    }
    
    private void addDistanceLocalizedCounts(AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
    {
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.add(paramBuilder.build());
    }
    
    private void addDistanceLocalizedCounts(AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
    {
      if (paramDistanceLocalizedCount == null) {
        throw new NullPointerException();
      }
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.add(paramDistanceLocalizedCount);
    }
    
    private void clearAccuracy()
    {
      this.bitField0_ &= 0xFF7F;
      this.accuracy_ = 0.0D;
    }
    
    private void clearDistanceLocalizedCounts()
    {
      this.distanceLocalizedCounts_ = emptyProtobufList();
    }
    
    private void clearNumFalseNegative()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.numFalseNegative_ = 0L;
    }
    
    private void clearNumFalsePositive()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.numFalsePositive_ = 0L;
    }
    
    private void clearNumLocalizedBeforeDistanceThreshold()
    {
      this.bitField0_ &= 0xFFFFFFEF;
      this.numLocalizedBeforeDistanceThreshold_ = 0L;
    }
    
    private void clearNumTrueNegative()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.numTrueNegative_ = 0L;
    }
    
    private void clearNumTruePositive()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.numTruePositive_ = 0L;
    }
    
    private void clearPrecision()
    {
      this.bitField0_ &= 0xFFFFFFDF;
      this.precision_ = 0.0D;
    }
    
    private void clearRecall()
    {
      this.bitField0_ &= 0xFFFFFFBF;
      this.recall_ = 0.0D;
    }
    
    private void ensureDistanceLocalizedCountsIsMutable()
    {
      if (!this.distanceLocalizedCounts_.isModifiable()) {
        this.distanceLocalizedCounts_ = GeneratedMessageLite.mutableCopy(this.distanceLocalizedCounts_);
      }
    }
    
    public static LocalizationStatsProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocalizationStatsProto paramLocalizationStatsProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizationStatsProto);
    }
    
    public static LocalizationStatsProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationStatsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationStatsProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationStatsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationStatsProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LocalizationStatsProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LocalizationStatsProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LocalizationStatsProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationStatsProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationStatsProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationStatsProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LocalizationStatsProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationStatsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LocalizationStatsProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeDistanceLocalizedCounts(int paramInt)
    {
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.remove(paramInt);
    }
    
    private void setAccuracy(double paramDouble)
    {
      this.bitField0_ |= 0x80;
      this.accuracy_ = paramDouble;
    }
    
    private void setDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
    {
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.set(paramInt, paramBuilder.build());
    }
    
    private void setDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
    {
      if (paramDistanceLocalizedCount == null) {
        throw new NullPointerException();
      }
      ensureDistanceLocalizedCountsIsMutable();
      this.distanceLocalizedCounts_.set(paramInt, paramDistanceLocalizedCount);
    }
    
    private void setNumFalseNegative(long paramLong)
    {
      this.bitField0_ |= 0x8;
      this.numFalseNegative_ = paramLong;
    }
    
    private void setNumFalsePositive(long paramLong)
    {
      this.bitField0_ |= 0x4;
      this.numFalsePositive_ = paramLong;
    }
    
    private void setNumLocalizedBeforeDistanceThreshold(long paramLong)
    {
      this.bitField0_ |= 0x10;
      this.numLocalizedBeforeDistanceThreshold_ = paramLong;
    }
    
    private void setNumTrueNegative(long paramLong)
    {
      this.bitField0_ |= 0x2;
      this.numTrueNegative_ = paramLong;
    }
    
    private void setNumTruePositive(long paramLong)
    {
      this.bitField0_ |= 0x1;
      this.numTruePositive_ = paramLong;
    }
    
    private void setPrecision(double paramDouble)
    {
      this.bitField0_ |= 0x20;
      this.precision_ = paramDouble;
    }
    
    private void setRecall(double paramDouble)
    {
      this.bitField0_ |= 0x40;
      this.recall_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 316	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 322	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+350->358, 7:+743->751, 8:+747->755
      //   56: new 324	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 325	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   67: dup
      //   68: invokespecial 56	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 58	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 326 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 329	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 331	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 334	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumTruePositive	()Z
      //   114: aload_0
      //   115: getfield 227	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTruePositive_	J
      //   118: aload_3
      //   119: invokevirtual 334	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumTruePositive	()Z
      //   122: aload_3
      //   123: getfield 227	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTruePositive_	J
      //   126: invokeinterface 338 7 0
      //   131: putfield 227	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTruePositive_	J
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: invokevirtual 341	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumTrueNegative	()Z
      //   140: aload_0
      //   141: getfield 225	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTrueNegative_	J
      //   144: aload_3
      //   145: invokevirtual 341	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumTrueNegative	()Z
      //   148: aload_3
      //   149: getfield 225	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTrueNegative_	J
      //   152: invokeinterface 338 7 0
      //   157: putfield 225	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTrueNegative_	J
      //   160: aload_0
      //   161: aload_2
      //   162: aload_0
      //   163: invokevirtual 344	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumFalsePositive	()Z
      //   166: aload_0
      //   167: getfield 221	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalsePositive_	J
      //   170: aload_3
      //   171: invokevirtual 344	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumFalsePositive	()Z
      //   174: aload_3
      //   175: getfield 221	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalsePositive_	J
      //   178: invokeinterface 338 7 0
      //   183: putfield 221	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalsePositive_	J
      //   186: aload_0
      //   187: aload_2
      //   188: aload_0
      //   189: invokevirtual 347	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumFalseNegative	()Z
      //   192: aload_0
      //   193: getfield 219	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalseNegative_	J
      //   196: aload_3
      //   197: invokevirtual 347	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumFalseNegative	()Z
      //   200: aload_3
      //   201: getfield 219	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalseNegative_	J
      //   204: invokeinterface 338 7 0
      //   209: putfield 219	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalseNegative_	J
      //   212: aload_0
      //   213: aload_2
      //   214: aload_0
      //   215: invokevirtual 350	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumLocalizedBeforeDistanceThreshold	()Z
      //   218: aload_0
      //   219: getfield 223	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numLocalizedBeforeDistanceThreshold_	J
      //   222: aload_3
      //   223: invokevirtual 350	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasNumLocalizedBeforeDistanceThreshold	()Z
      //   226: aload_3
      //   227: getfield 223	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numLocalizedBeforeDistanceThreshold_	J
      //   230: invokeinterface 338 7 0
      //   235: putfield 223	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numLocalizedBeforeDistanceThreshold_	J
      //   238: aload_0
      //   239: aload_2
      //   240: aload_0
      //   241: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   244: aload_3
      //   245: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   248: invokeinterface 354 3 0
      //   253: putfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   256: aload_0
      //   257: aload_2
      //   258: aload_0
      //   259: invokevirtual 357	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasPrecision	()Z
      //   262: aload_0
      //   263: getfield 229	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:precision_	D
      //   266: aload_3
      //   267: invokevirtual 357	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasPrecision	()Z
      //   270: aload_3
      //   271: getfield 229	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:precision_	D
      //   274: invokeinterface 361 7 0
      //   279: putfield 229	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:precision_	D
      //   282: aload_0
      //   283: aload_2
      //   284: aload_0
      //   285: invokevirtual 364	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasRecall	()Z
      //   288: aload_0
      //   289: getfield 231	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:recall_	D
      //   292: aload_3
      //   293: invokevirtual 364	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasRecall	()Z
      //   296: aload_3
      //   297: getfield 231	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:recall_	D
      //   300: invokeinterface 361 7 0
      //   305: putfield 231	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:recall_	D
      //   308: aload_0
      //   309: aload_2
      //   310: aload_0
      //   311: invokevirtual 367	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasAccuracy	()Z
      //   314: aload_0
      //   315: getfield 217	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:accuracy_	D
      //   318: aload_3
      //   319: invokevirtual 367	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:hasAccuracy	()Z
      //   322: aload_3
      //   323: getfield 217	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:accuracy_	D
      //   326: invokeinterface 361 7 0
      //   331: putfield 217	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:accuracy_	D
      //   334: aload_0
      //   335: astore_1
      //   336: aload_2
      //   337: getstatic 373	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   340: if_acmpne -268 -> 72
      //   343: aload_0
      //   344: aload_0
      //   345: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   348: aload_3
      //   349: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   352: ior
      //   353: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   356: aload_0
      //   357: areturn
      //   358: aload_2
      //   359: checkcast 375	com/google/protobuf/CodedInputStream
      //   362: astore_1
      //   363: aload_3
      //   364: checkcast 377	com/google/protobuf/ExtensionRegistryLite
      //   367: astore_2
      //   368: iconst_0
      //   369: istore 4
      //   371: iload 4
      //   373: ifne +378 -> 751
      //   376: aload_1
      //   377: invokevirtual 380	com/google/protobuf/CodedInputStream:readTag	()I
      //   380: istore 5
      //   382: iload 5
      //   384: lookupswitch	default:+412->796, 0:+415->799, 8:+108->492, 16:+146->530, 24:+191->575, 32:+212->596, 41:+234->618, 49:+256->640, 57:+278->662, 64:+301->685, 74:+323->707
      //   476: aload_0
      //   477: iload 5
      //   479: aload_1
      //   480: invokevirtual 384	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   483: ifne -112 -> 371
      //   486: iconst_1
      //   487: istore 4
      //   489: goto -118 -> 371
      //   492: aload_0
      //   493: aload_0
      //   494: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   497: iconst_1
      //   498: ior
      //   499: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   502: aload_0
      //   503: aload_1
      //   504: invokevirtual 388	com/google/protobuf/CodedInputStream:readInt64	()J
      //   507: putfield 227	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTruePositive_	J
      //   510: goto -139 -> 371
      //   513: astore_1
      //   514: new 390	java/lang/RuntimeException
      //   517: dup
      //   518: aload_1
      //   519: aload_0
      //   520: invokevirtual 394	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   523: invokespecial 397	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   526: athrow
      //   527: astore_1
      //   528: aload_1
      //   529: athrow
      //   530: aload_0
      //   531: aload_0
      //   532: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   535: iconst_2
      //   536: ior
      //   537: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   540: aload_0
      //   541: aload_1
      //   542: invokevirtual 388	com/google/protobuf/CodedInputStream:readInt64	()J
      //   545: putfield 225	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numTrueNegative_	J
      //   548: goto -177 -> 371
      //   551: astore_1
      //   552: new 390	java/lang/RuntimeException
      //   555: dup
      //   556: new 267	com/google/protobuf/InvalidProtocolBufferException
      //   559: dup
      //   560: aload_1
      //   561: invokevirtual 401	java/io/IOException:getMessage	()Ljava/lang/String;
      //   564: invokespecial 404	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   567: aload_0
      //   568: invokevirtual 394	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   571: invokespecial 397	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   574: athrow
      //   575: aload_0
      //   576: aload_0
      //   577: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   580: iconst_4
      //   581: ior
      //   582: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   585: aload_0
      //   586: aload_1
      //   587: invokevirtual 388	com/google/protobuf/CodedInputStream:readInt64	()J
      //   590: putfield 221	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalsePositive_	J
      //   593: goto -222 -> 371
      //   596: aload_0
      //   597: aload_0
      //   598: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   601: bipush 8
      //   603: ior
      //   604: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   607: aload_0
      //   608: aload_1
      //   609: invokevirtual 388	com/google/protobuf/CodedInputStream:readInt64	()J
      //   612: putfield 219	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numFalseNegative_	J
      //   615: goto -244 -> 371
      //   618: aload_0
      //   619: aload_0
      //   620: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   623: bipush 32
      //   625: ior
      //   626: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   629: aload_0
      //   630: aload_1
      //   631: invokevirtual 408	com/google/protobuf/CodedInputStream:readDouble	()D
      //   634: putfield 229	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:precision_	D
      //   637: goto -266 -> 371
      //   640: aload_0
      //   641: aload_0
      //   642: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   645: bipush 64
      //   647: ior
      //   648: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   651: aload_0
      //   652: aload_1
      //   653: invokevirtual 408	com/google/protobuf/CodedInputStream:readDouble	()D
      //   656: putfield 231	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:recall_	D
      //   659: goto -288 -> 371
      //   662: aload_0
      //   663: aload_0
      //   664: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   667: sipush 128
      //   670: ior
      //   671: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   674: aload_0
      //   675: aload_1
      //   676: invokevirtual 408	com/google/protobuf/CodedInputStream:readDouble	()D
      //   679: putfield 217	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:accuracy_	D
      //   682: goto -311 -> 371
      //   685: aload_0
      //   686: aload_0
      //   687: getfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   690: bipush 16
      //   692: ior
      //   693: putfield 215	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:bitField0_	I
      //   696: aload_0
      //   697: aload_1
      //   698: invokevirtual 388	com/google/protobuf/CodedInputStream:readInt64	()J
      //   701: putfield 223	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:numLocalizedBeforeDistanceThreshold_	J
      //   704: goto -333 -> 371
      //   707: aload_0
      //   708: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   711: invokeinterface 235 1 0
      //   716: ifne +14 -> 730
      //   719: aload_0
      //   720: aload_0
      //   721: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   724: invokestatic 239	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   727: putfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   730: aload_0
      //   731: getfield 69	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:distanceLocalizedCounts_	Lcom/google/protobuf/Internal$ProtobufList;
      //   734: aload_1
      //   735: invokestatic 412	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$DistanceLocalizedCount:parser	()Lcom/google/protobuf/Parser;
      //   738: aload_2
      //   739: invokevirtual 416	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   742: invokeinterface 213 2 0
      //   747: pop
      //   748: goto -377 -> 371
      //   751: getstatic 58	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   754: areturn
      //   755: getstatic 418	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:PARSER	Lcom/google/protobuf/Parser;
      //   758: ifnonnull +28 -> 786
      //   761: ldc 2
      //   763: monitorenter
      //   764: getstatic 418	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:PARSER	Lcom/google/protobuf/Parser;
      //   767: ifnonnull +16 -> 783
      //   770: new 420	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   773: dup
      //   774: getstatic 58	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   777: invokespecial 423	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   780: putstatic 418	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:PARSER	Lcom/google/protobuf/Parser;
      //   783: ldc 2
      //   785: monitorexit
      //   786: getstatic 418	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:PARSER	Lcom/google/protobuf/Parser;
      //   789: areturn
      //   790: astore_1
      //   791: ldc 2
      //   793: monitorexit
      //   794: aload_1
      //   795: athrow
      //   796: goto -320 -> 476
      //   799: iconst_1
      //   800: istore 4
      //   802: goto -431 -> 371
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	805	0	this	LocalizationStatsProto
      //   0	805	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	805	2	paramObject1	Object
      //   0	805	3	paramObject2	Object
      //   369	432	4	i	int
      //   380	98	5	j	int
      // Exception table:
      //   from	to	target	type
      //   376	382	513	com/google/protobuf/InvalidProtocolBufferException
      //   476	486	513	com/google/protobuf/InvalidProtocolBufferException
      //   492	510	513	com/google/protobuf/InvalidProtocolBufferException
      //   530	548	513	com/google/protobuf/InvalidProtocolBufferException
      //   575	593	513	com/google/protobuf/InvalidProtocolBufferException
      //   596	615	513	com/google/protobuf/InvalidProtocolBufferException
      //   618	637	513	com/google/protobuf/InvalidProtocolBufferException
      //   640	659	513	com/google/protobuf/InvalidProtocolBufferException
      //   662	682	513	com/google/protobuf/InvalidProtocolBufferException
      //   685	704	513	com/google/protobuf/InvalidProtocolBufferException
      //   707	730	513	com/google/protobuf/InvalidProtocolBufferException
      //   730	748	513	com/google/protobuf/InvalidProtocolBufferException
      //   376	382	527	finally
      //   476	486	527	finally
      //   492	510	527	finally
      //   514	527	527	finally
      //   530	548	527	finally
      //   552	575	527	finally
      //   575	593	527	finally
      //   596	615	527	finally
      //   618	637	527	finally
      //   640	659	527	finally
      //   662	682	527	finally
      //   685	704	527	finally
      //   707	730	527	finally
      //   730	748	527	finally
      //   376	382	551	java/io/IOException
      //   476	486	551	java/io/IOException
      //   492	510	551	java/io/IOException
      //   530	548	551	java/io/IOException
      //   575	593	551	java/io/IOException
      //   596	615	551	java/io/IOException
      //   618	637	551	java/io/IOException
      //   640	659	551	java/io/IOException
      //   662	682	551	java/io/IOException
      //   685	704	551	java/io/IOException
      //   707	730	551	java/io/IOException
      //   730	748	551	java/io/IOException
      //   764	783	790	finally
      //   783	786	790	finally
      //   791	794	790	finally
    }
    
    @Deprecated
    public double getAccuracy()
    {
      return this.accuracy_;
    }
    
    public AggregatedLocalizationResults.DistanceLocalizedCount getDistanceLocalizedCounts(int paramInt)
    {
      return (AggregatedLocalizationResults.DistanceLocalizedCount)this.distanceLocalizedCounts_.get(paramInt);
    }
    
    public int getDistanceLocalizedCountsCount()
    {
      return this.distanceLocalizedCounts_.size();
    }
    
    public List<AggregatedLocalizationResults.DistanceLocalizedCount> getDistanceLocalizedCountsList()
    {
      return this.distanceLocalizedCounts_;
    }
    
    public AggregatedLocalizationResults.DistanceLocalizedCountOrBuilder getDistanceLocalizedCountsOrBuilder(int paramInt)
    {
      return (AggregatedLocalizationResults.DistanceLocalizedCountOrBuilder)this.distanceLocalizedCounts_.get(paramInt);
    }
    
    public List<? extends AggregatedLocalizationResults.DistanceLocalizedCountOrBuilder> getDistanceLocalizedCountsOrBuilderList()
    {
      return this.distanceLocalizedCounts_;
    }
    
    public long getNumFalseNegative()
    {
      return this.numFalseNegative_;
    }
    
    public long getNumFalsePositive()
    {
      return this.numFalsePositive_;
    }
    
    @Deprecated
    public long getNumLocalizedBeforeDistanceThreshold()
    {
      return this.numLocalizedBeforeDistanceThreshold_;
    }
    
    public long getNumTrueNegative()
    {
      return this.numTrueNegative_;
    }
    
    public long getNumTruePositive()
    {
      return this.numTruePositive_;
    }
    
    public double getPrecision()
    {
      return this.precision_;
    }
    
    @Deprecated
    public double getRecall()
    {
      return this.recall_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeInt64Size(1, this.numTruePositive_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeInt64Size(2, this.numTrueNegative_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeInt64Size(3, this.numFalsePositive_);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeInt64Size(4, this.numFalseNegative_);
      }
      j = i;
      if ((this.bitField0_ & 0x20) == 32) {
        j = i + CodedOutputStream.computeDoubleSize(5, this.precision_);
      }
      i = j;
      if ((this.bitField0_ & 0x40) == 64) {
        i = j + CodedOutputStream.computeDoubleSize(6, this.recall_);
      }
      j = i;
      if ((this.bitField0_ & 0x80) == 128) {
        j = i + CodedOutputStream.computeDoubleSize(7, this.accuracy_);
      }
      i = j;
      if ((this.bitField0_ & 0x10) == 16) {
        i = j + CodedOutputStream.computeInt64Size(8, this.numLocalizedBeforeDistanceThreshold_);
      }
      int k = 0;
      j = i;
      i = k;
      while (i < this.distanceLocalizedCounts_.size())
      {
        j += CodedOutputStream.computeMessageSize(9, (MessageLite)this.distanceLocalizedCounts_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    @Deprecated
    public boolean hasAccuracy()
    {
      return (this.bitField0_ & 0x80) == 128;
    }
    
    public boolean hasNumFalseNegative()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasNumFalsePositive()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    @Deprecated
    public boolean hasNumLocalizedBeforeDistanceThreshold()
    {
      return (this.bitField0_ & 0x10) == 16;
    }
    
    public boolean hasNumTrueNegative()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasNumTruePositive()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasPrecision()
    {
      return (this.bitField0_ & 0x20) == 32;
    }
    
    @Deprecated
    public boolean hasRecall()
    {
      return (this.bitField0_ & 0x40) == 64;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt64(1, this.numTruePositive_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeInt64(2, this.numTrueNegative_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeInt64(3, this.numFalsePositive_);
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeInt64(4, this.numFalseNegative_);
      }
      if ((this.bitField0_ & 0x20) == 32) {
        paramCodedOutputStream.writeDouble(5, this.precision_);
      }
      if ((this.bitField0_ & 0x40) == 64) {
        paramCodedOutputStream.writeDouble(6, this.recall_);
      }
      if ((this.bitField0_ & 0x80) == 128) {
        paramCodedOutputStream.writeDouble(7, this.accuracy_);
      }
      if ((this.bitField0_ & 0x10) == 16) {
        paramCodedOutputStream.writeInt64(8, this.numLocalizedBeforeDistanceThreshold_);
      }
      int i = 0;
      while (i < this.distanceLocalizedCounts_.size())
      {
        paramCodedOutputStream.writeMessage(9, (MessageLite)this.distanceLocalizedCounts_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.LocalizationStatsProto, Builder>
      implements AggregatedLocalizationResults.LocalizationStatsProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllDistanceLocalizedCounts(Iterable<? extends AggregatedLocalizationResults.DistanceLocalizedCount> paramIterable)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).addAllDistanceLocalizedCounts(paramIterable);
        return this;
      }
      
      public Builder addDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).addDistanceLocalizedCounts(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).addDistanceLocalizedCounts(paramInt, paramDistanceLocalizedCount);
        return this;
      }
      
      public Builder addDistanceLocalizedCounts(AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).addDistanceLocalizedCounts(paramBuilder);
        return this;
      }
      
      public Builder addDistanceLocalizedCounts(AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).addDistanceLocalizedCounts(paramDistanceLocalizedCount);
        return this;
      }
      
      @Deprecated
      public Builder clearAccuracy()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearAccuracy();
        return this;
      }
      
      public Builder clearDistanceLocalizedCounts()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearDistanceLocalizedCounts();
        return this;
      }
      
      public Builder clearNumFalseNegative()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearNumFalseNegative();
        return this;
      }
      
      public Builder clearNumFalsePositive()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearNumFalsePositive();
        return this;
      }
      
      @Deprecated
      public Builder clearNumLocalizedBeforeDistanceThreshold()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearNumLocalizedBeforeDistanceThreshold();
        return this;
      }
      
      public Builder clearNumTrueNegative()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearNumTrueNegative();
        return this;
      }
      
      public Builder clearNumTruePositive()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearNumTruePositive();
        return this;
      }
      
      public Builder clearPrecision()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearPrecision();
        return this;
      }
      
      @Deprecated
      public Builder clearRecall()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).clearRecall();
        return this;
      }
      
      @Deprecated
      public double getAccuracy()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getAccuracy();
      }
      
      public AggregatedLocalizationResults.DistanceLocalizedCount getDistanceLocalizedCounts(int paramInt)
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getDistanceLocalizedCounts(paramInt);
      }
      
      public int getDistanceLocalizedCountsCount()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getDistanceLocalizedCountsCount();
      }
      
      public List<AggregatedLocalizationResults.DistanceLocalizedCount> getDistanceLocalizedCountsList()
      {
        return Collections.unmodifiableList(((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getDistanceLocalizedCountsList());
      }
      
      public long getNumFalseNegative()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getNumFalseNegative();
      }
      
      public long getNumFalsePositive()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getNumFalsePositive();
      }
      
      @Deprecated
      public long getNumLocalizedBeforeDistanceThreshold()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getNumLocalizedBeforeDistanceThreshold();
      }
      
      public long getNumTrueNegative()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getNumTrueNegative();
      }
      
      public long getNumTruePositive()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getNumTruePositive();
      }
      
      public double getPrecision()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getPrecision();
      }
      
      @Deprecated
      public double getRecall()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).getRecall();
      }
      
      @Deprecated
      public boolean hasAccuracy()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasAccuracy();
      }
      
      public boolean hasNumFalseNegative()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasNumFalseNegative();
      }
      
      public boolean hasNumFalsePositive()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasNumFalsePositive();
      }
      
      @Deprecated
      public boolean hasNumLocalizedBeforeDistanceThreshold()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasNumLocalizedBeforeDistanceThreshold();
      }
      
      public boolean hasNumTrueNegative()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasNumTrueNegative();
      }
      
      public boolean hasNumTruePositive()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasNumTruePositive();
      }
      
      public boolean hasPrecision()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasPrecision();
      }
      
      @Deprecated
      public boolean hasRecall()
      {
        return ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).hasRecall();
      }
      
      public Builder removeDistanceLocalizedCounts(int paramInt)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).removeDistanceLocalizedCounts(paramInt);
        return this;
      }
      
      @Deprecated
      public Builder setAccuracy(double paramDouble)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setAccuracy(paramDouble);
        return this;
      }
      
      public Builder setDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setDistanceLocalizedCounts(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setDistanceLocalizedCounts(int paramInt, AggregatedLocalizationResults.DistanceLocalizedCount paramDistanceLocalizedCount)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setDistanceLocalizedCounts(paramInt, paramDistanceLocalizedCount);
        return this;
      }
      
      public Builder setNumFalseNegative(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setNumFalseNegative(paramLong);
        return this;
      }
      
      public Builder setNumFalsePositive(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setNumFalsePositive(paramLong);
        return this;
      }
      
      @Deprecated
      public Builder setNumLocalizedBeforeDistanceThreshold(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setNumLocalizedBeforeDistanceThreshold(paramLong);
        return this;
      }
      
      public Builder setNumTrueNegative(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setNumTrueNegative(paramLong);
        return this;
      }
      
      public Builder setNumTruePositive(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setNumTruePositive(paramLong);
        return this;
      }
      
      public Builder setPrecision(double paramDouble)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setPrecision(paramDouble);
        return this;
      }
      
      @Deprecated
      public Builder setRecall(double paramDouble)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.LocalizationStatsProto)this.instance).setRecall(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface LocalizationStatsProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    @Deprecated
    public abstract double getAccuracy();
    
    public abstract AggregatedLocalizationResults.DistanceLocalizedCount getDistanceLocalizedCounts(int paramInt);
    
    public abstract int getDistanceLocalizedCountsCount();
    
    public abstract List<AggregatedLocalizationResults.DistanceLocalizedCount> getDistanceLocalizedCountsList();
    
    public abstract long getNumFalseNegative();
    
    public abstract long getNumFalsePositive();
    
    @Deprecated
    public abstract long getNumLocalizedBeforeDistanceThreshold();
    
    public abstract long getNumTrueNegative();
    
    public abstract long getNumTruePositive();
    
    public abstract double getPrecision();
    
    @Deprecated
    public abstract double getRecall();
    
    @Deprecated
    public abstract boolean hasAccuracy();
    
    public abstract boolean hasNumFalseNegative();
    
    public abstract boolean hasNumFalsePositive();
    
    @Deprecated
    public abstract boolean hasNumLocalizedBeforeDistanceThreshold();
    
    public abstract boolean hasNumTrueNegative();
    
    public abstract boolean hasNumTruePositive();
    
    public abstract boolean hasPrecision();
    
    @Deprecated
    public abstract boolean hasRecall();
  }
  
  public static final class S2CellLocalizationResultsProto
    extends GeneratedMessageLite<S2CellLocalizationResultsProto, Builder>
    implements AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder
  {
    private static final S2CellLocalizationResultsProto DEFAULT_INSTANCE = new S2CellLocalizationResultsProto();
    private static volatile Parser<S2CellLocalizationResultsProto> PARSER;
    public static final int RESULT_GROUPS_FIELD_NUMBER = 2;
    public static final int S2_CELL_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<AggregatedLocalizationResults.LocalizationResultGroupProto> resultGroups_ = emptyProtobufList();
    private AggregatedLocalizationResults.S2CellProto s2Cell_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllResultGroups(Iterable<? extends AggregatedLocalizationResults.LocalizationResultGroupProto> paramIterable)
    {
      ensureResultGroupsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.resultGroups_);
    }
    
    private void addResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
    {
      ensureResultGroupsIsMutable();
      this.resultGroups_.add(paramInt, paramBuilder.build());
    }
    
    private void addResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
    {
      if (paramLocalizationResultGroupProto == null) {
        throw new NullPointerException();
      }
      ensureResultGroupsIsMutable();
      this.resultGroups_.add(paramInt, paramLocalizationResultGroupProto);
    }
    
    private void addResultGroups(AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
    {
      ensureResultGroupsIsMutable();
      this.resultGroups_.add(paramBuilder.build());
    }
    
    private void addResultGroups(AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
    {
      if (paramLocalizationResultGroupProto == null) {
        throw new NullPointerException();
      }
      ensureResultGroupsIsMutable();
      this.resultGroups_.add(paramLocalizationResultGroupProto);
    }
    
    private void clearResultGroups()
    {
      this.resultGroups_ = emptyProtobufList();
    }
    
    private void clearS2Cell()
    {
      this.s2Cell_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    private void ensureResultGroupsIsMutable()
    {
      if (!this.resultGroups_.isModifiable()) {
        this.resultGroups_ = GeneratedMessageLite.mutableCopy(this.resultGroups_);
      }
    }
    
    public static S2CellLocalizationResultsProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeS2Cell(AggregatedLocalizationResults.S2CellProto paramS2CellProto)
    {
      if ((this.s2Cell_ != null) && (this.s2Cell_ != AggregatedLocalizationResults.S2CellProto.getDefaultInstance())) {}
      for (this.s2Cell_ = ((AggregatedLocalizationResults.S2CellProto)((AggregatedLocalizationResults.S2CellProto.Builder)AggregatedLocalizationResults.S2CellProto.newBuilder(this.s2Cell_).mergeFrom(paramS2CellProto)).buildPartial());; this.s2Cell_ = paramS2CellProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramS2CellLocalizationResultsProto);
    }
    
    public static S2CellLocalizationResultsProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellLocalizationResultsProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static S2CellLocalizationResultsProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellLocalizationResultsProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<S2CellLocalizationResultsProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeResultGroups(int paramInt)
    {
      ensureResultGroupsIsMutable();
      this.resultGroups_.remove(paramInt);
    }
    
    private void setResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
    {
      ensureResultGroupsIsMutable();
      this.resultGroups_.set(paramInt, paramBuilder.build());
    }
    
    private void setResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
    {
      if (paramLocalizationResultGroupProto == null) {
        throw new NullPointerException();
      }
      ensureResultGroupsIsMutable();
      this.resultGroups_.set(paramInt, paramLocalizationResultGroupProto);
    }
    
    private void setS2Cell(AggregatedLocalizationResults.S2CellProto.Builder paramBuilder)
    {
      this.s2Cell_ = ((AggregatedLocalizationResults.S2CellProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setS2Cell(AggregatedLocalizationResults.S2CellProto paramS2CellProto)
    {
      if (paramS2CellProto == null) {
        throw new NullPointerException();
      }
      this.s2Cell_ = paramS2CellProto;
      this.bitField0_ |= 0x1;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 246	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 252	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+163->171, 7:+400->408, 8:+404->412
      //   56: new 254	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 255	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto
      //   67: dup
      //   68: invokespecial 34	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 36	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 256 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 259	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 261	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   114: aload_3
      //   115: getfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   118: invokeinterface 265 3 0
      //   123: checkcast 157	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto
      //   126: putfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   129: aload_0
      //   130: aload_2
      //   131: aload_0
      //   132: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   135: aload_3
      //   136: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   139: invokeinterface 269 3 0
      //   144: putfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   147: aload_0
      //   148: astore_1
      //   149: aload_2
      //   150: getstatic 275	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   153: if_acmpne -81 -> 72
      //   156: aload_0
      //   157: aload_0
      //   158: getfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   161: aload_3
      //   162: getfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   165: ior
      //   166: putfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   169: aload_0
      //   170: areturn
      //   171: aload_2
      //   172: checkcast 277	com/google/protobuf/CodedInputStream
      //   175: astore_2
      //   176: aload_3
      //   177: checkcast 279	com/google/protobuf/ExtensionRegistryLite
      //   180: astore_3
      //   181: iconst_0
      //   182: istore 4
      //   184: iload 4
      //   186: ifne +222 -> 408
      //   189: aload_2
      //   190: invokevirtual 282	com/google/protobuf/CodedInputStream:readTag	()I
      //   193: istore 5
      //   195: iload 5
      //   197: lookupswitch	default:+256->453, 0:+259->456, 10:+51->248, 18:+143->340
      //   232: aload_0
      //   233: iload 5
      //   235: aload_2
      //   236: invokevirtual 286	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   239: ifne -55 -> 184
      //   242: iconst_1
      //   243: istore 4
      //   245: goto -61 -> 184
      //   248: aconst_null
      //   249: astore_1
      //   250: aload_0
      //   251: getfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   254: iconst_1
      //   255: iand
      //   256: iconst_1
      //   257: if_icmpne +14 -> 271
      //   260: aload_0
      //   261: getfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   264: invokevirtual 287	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   267: checkcast 166	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto$Builder
      //   270: astore_1
      //   271: aload_0
      //   272: aload_2
      //   273: invokestatic 289	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:parser	()Lcom/google/protobuf/Parser;
      //   276: aload_3
      //   277: invokevirtual 293	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   280: checkcast 157	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto
      //   283: putfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   286: aload_1
      //   287: ifnull +23 -> 310
      //   290: aload_1
      //   291: aload_0
      //   292: getfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   295: invokevirtual 170	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   298: pop
      //   299: aload_0
      //   300: aload_1
      //   301: invokevirtual 173	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   304: checkcast 157	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto
      //   307: putfield 144	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:s2Cell_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   310: aload_0
      //   311: aload_0
      //   312: getfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   315: iconst_1
      //   316: ior
      //   317: putfield 146	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:bitField0_	I
      //   320: goto -136 -> 184
      //   323: astore_1
      //   324: new 295	java/lang/RuntimeException
      //   327: dup
      //   328: aload_1
      //   329: aload_0
      //   330: invokevirtual 299	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   333: invokespecial 302	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   336: athrow
      //   337: astore_1
      //   338: aload_1
      //   339: athrow
      //   340: aload_0
      //   341: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   344: invokeinterface 150 1 0
      //   349: ifne +14 -> 363
      //   352: aload_0
      //   353: aload_0
      //   354: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   357: invokestatic 154	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   360: putfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   363: aload_0
      //   364: getfield 47	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:resultGroups_	Lcom/google/protobuf/Internal$ProtobufList;
      //   367: aload_2
      //   368: invokestatic 305	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationResultGroupProto:parser	()Lcom/google/protobuf/Parser;
      //   371: aload_3
      //   372: invokevirtual 293	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   375: invokeinterface 142 2 0
      //   380: pop
      //   381: goto -197 -> 184
      //   384: astore_1
      //   385: new 295	java/lang/RuntimeException
      //   388: dup
      //   389: new 196	com/google/protobuf/InvalidProtocolBufferException
      //   392: dup
      //   393: aload_1
      //   394: invokevirtual 309	java/io/IOException:getMessage	()Ljava/lang/String;
      //   397: invokespecial 312	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   400: aload_0
      //   401: invokevirtual 299	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   404: invokespecial 302	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   407: athrow
      //   408: getstatic 36	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto;
      //   411: areturn
      //   412: getstatic 314	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   415: ifnonnull +28 -> 443
      //   418: ldc 2
      //   420: monitorenter
      //   421: getstatic 314	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   424: ifnonnull +16 -> 440
      //   427: new 316	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   430: dup
      //   431: getstatic 36	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto;
      //   434: invokespecial 319	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   437: putstatic 314	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   440: ldc 2
      //   442: monitorexit
      //   443: getstatic 314	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:PARSER	Lcom/google/protobuf/Parser;
      //   446: areturn
      //   447: astore_1
      //   448: ldc 2
      //   450: monitorexit
      //   451: aload_1
      //   452: athrow
      //   453: goto -221 -> 232
      //   456: iconst_1
      //   457: istore 4
      //   459: goto -275 -> 184
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	462	0	this	S2CellLocalizationResultsProto
      //   0	462	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	462	2	paramObject1	Object
      //   0	462	3	paramObject2	Object
      //   182	276	4	i	int
      //   193	41	5	j	int
      // Exception table:
      //   from	to	target	type
      //   189	195	323	com/google/protobuf/InvalidProtocolBufferException
      //   232	242	323	com/google/protobuf/InvalidProtocolBufferException
      //   250	271	323	com/google/protobuf/InvalidProtocolBufferException
      //   271	286	323	com/google/protobuf/InvalidProtocolBufferException
      //   290	310	323	com/google/protobuf/InvalidProtocolBufferException
      //   310	320	323	com/google/protobuf/InvalidProtocolBufferException
      //   340	363	323	com/google/protobuf/InvalidProtocolBufferException
      //   363	381	323	com/google/protobuf/InvalidProtocolBufferException
      //   189	195	337	finally
      //   232	242	337	finally
      //   250	271	337	finally
      //   271	286	337	finally
      //   290	310	337	finally
      //   310	320	337	finally
      //   324	337	337	finally
      //   340	363	337	finally
      //   363	381	337	finally
      //   385	408	337	finally
      //   189	195	384	java/io/IOException
      //   232	242	384	java/io/IOException
      //   250	271	384	java/io/IOException
      //   271	286	384	java/io/IOException
      //   290	310	384	java/io/IOException
      //   310	320	384	java/io/IOException
      //   340	363	384	java/io/IOException
      //   363	381	384	java/io/IOException
      //   421	440	447	finally
      //   440	443	447	finally
      //   448	451	447	finally
    }
    
    public AggregatedLocalizationResults.LocalizationResultGroupProto getResultGroups(int paramInt)
    {
      return (AggregatedLocalizationResults.LocalizationResultGroupProto)this.resultGroups_.get(paramInt);
    }
    
    public int getResultGroupsCount()
    {
      return this.resultGroups_.size();
    }
    
    public List<AggregatedLocalizationResults.LocalizationResultGroupProto> getResultGroupsList()
    {
      return this.resultGroups_;
    }
    
    public AggregatedLocalizationResults.LocalizationResultGroupProtoOrBuilder getResultGroupsOrBuilder(int paramInt)
    {
      return (AggregatedLocalizationResults.LocalizationResultGroupProtoOrBuilder)this.resultGroups_.get(paramInt);
    }
    
    public List<? extends AggregatedLocalizationResults.LocalizationResultGroupProtoOrBuilder> getResultGroupsOrBuilderList()
    {
      return this.resultGroups_;
    }
    
    public AggregatedLocalizationResults.S2CellProto getS2Cell()
    {
      if (this.s2Cell_ == null) {
        return AggregatedLocalizationResults.S2CellProto.getDefaultInstance();
      }
      return this.s2Cell_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, getS2Cell());
      }
      int k = 0;
      int j = i;
      i = k;
      while (i < this.resultGroups_.size())
      {
        j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.resultGroups_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasS2Cell()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getS2Cell());
      }
      int i = 0;
      while (i < this.resultGroups_.size())
      {
        paramCodedOutputStream.writeMessage(2, (MessageLite)this.resultGroups_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.S2CellLocalizationResultsProto, Builder>
      implements AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllResultGroups(Iterable<? extends AggregatedLocalizationResults.LocalizationResultGroupProto> paramIterable)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).addAllResultGroups(paramIterable);
        return this;
      }
      
      public Builder addResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).addResultGroups(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).addResultGroups(paramInt, paramLocalizationResultGroupProto);
        return this;
      }
      
      public Builder addResultGroups(AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).addResultGroups(paramBuilder);
        return this;
      }
      
      public Builder addResultGroups(AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).addResultGroups(paramLocalizationResultGroupProto);
        return this;
      }
      
      public Builder clearResultGroups()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).clearResultGroups();
        return this;
      }
      
      public Builder clearS2Cell()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).clearS2Cell();
        return this;
      }
      
      public AggregatedLocalizationResults.LocalizationResultGroupProto getResultGroups(int paramInt)
      {
        return ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).getResultGroups(paramInt);
      }
      
      public int getResultGroupsCount()
      {
        return ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).getResultGroupsCount();
      }
      
      public List<AggregatedLocalizationResults.LocalizationResultGroupProto> getResultGroupsList()
      {
        return Collections.unmodifiableList(((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).getResultGroupsList());
      }
      
      public AggregatedLocalizationResults.S2CellProto getS2Cell()
      {
        return ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).getS2Cell();
      }
      
      public boolean hasS2Cell()
      {
        return ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).hasS2Cell();
      }
      
      public Builder mergeS2Cell(AggregatedLocalizationResults.S2CellProto paramS2CellProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).mergeS2Cell(paramS2CellProto);
        return this;
      }
      
      public Builder removeResultGroups(int paramInt)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).removeResultGroups(paramInt);
        return this;
      }
      
      public Builder setResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).setResultGroups(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setResultGroups(int paramInt, AggregatedLocalizationResults.LocalizationResultGroupProto paramLocalizationResultGroupProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).setResultGroups(paramInt, paramLocalizationResultGroupProto);
        return this;
      }
      
      public Builder setS2Cell(AggregatedLocalizationResults.S2CellProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).setS2Cell(paramBuilder);
        return this;
      }
      
      public Builder setS2Cell(AggregatedLocalizationResults.S2CellProto paramS2CellProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.instance).setS2Cell(paramS2CellProto);
        return this;
      }
    }
  }
  
  public static abstract interface S2CellLocalizationResultsProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract AggregatedLocalizationResults.LocalizationResultGroupProto getResultGroups(int paramInt);
    
    public abstract int getResultGroupsCount();
    
    public abstract List<AggregatedLocalizationResults.LocalizationResultGroupProto> getResultGroupsList();
    
    public abstract AggregatedLocalizationResults.S2CellProto getS2Cell();
    
    public abstract boolean hasS2Cell();
  }
  
  public static final class S2CellProto
    extends GeneratedMessageLite<S2CellProto, Builder>
    implements AggregatedLocalizationResults.S2CellProtoOrBuilder
  {
    private static final S2CellProto DEFAULT_INSTANCE = new S2CellProto();
    public static final int LEVEL_FIELD_NUMBER = 2;
    private static volatile Parser<S2CellProto> PARSER;
    public static final int TOKEN_FIELD_NUMBER = 1;
    public static final int VERTICES_FIELD_NUMBER = 3;
    private int bitField0_;
    private long level_;
    private String token_ = "";
    private Internal.ProtobufList<S2Proto.LatLngAltProto> vertices_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllVertices(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
    {
      ensureVerticesIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.vertices_);
    }
    
    private void addVertices(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensureVerticesIsMutable();
      this.vertices_.add(paramInt, paramBuilder.build());
    }
    
    private void addVertices(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensureVerticesIsMutable();
      this.vertices_.add(paramInt, paramLatLngAltProto);
    }
    
    private void addVertices(S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensureVerticesIsMutable();
      this.vertices_.add(paramBuilder.build());
    }
    
    private void addVertices(S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensureVerticesIsMutable();
      this.vertices_.add(paramLatLngAltProto);
    }
    
    private void clearLevel()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.level_ = 0L;
    }
    
    private void clearToken()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.token_ = getDefaultInstance().getToken();
    }
    
    private void clearVertices()
    {
      this.vertices_ = emptyProtobufList();
    }
    
    private void ensureVerticesIsMutable()
    {
      if (!this.vertices_.isModifiable()) {
        this.vertices_ = GeneratedMessageLite.mutableCopy(this.vertices_);
      }
    }
    
    public static S2CellProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(S2CellProto paramS2CellProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramS2CellProto);
    }
    
    public static S2CellProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static S2CellProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static S2CellProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static S2CellProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static S2CellProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static S2CellProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static S2CellProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (S2CellProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<S2CellProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeVertices(int paramInt)
    {
      ensureVerticesIsMutable();
      this.vertices_.remove(paramInt);
    }
    
    private void setLevel(long paramLong)
    {
      this.bitField0_ |= 0x2;
      this.level_ = paramLong;
    }
    
    private void setToken(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.token_ = paramString;
    }
    
    private void setTokenBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.token_ = paramByteString.toStringUtf8();
    }
    
    private void setVertices(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
    {
      ensureVerticesIsMutable();
      this.vertices_.set(paramInt, paramBuilder.build());
    }
    
    private void setVertices(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
    {
      if (paramLatLngAltProto == null) {
        throw new NullPointerException();
      }
      ensureVerticesIsMutable();
      this.vertices_.set(paramInt, paramLatLngAltProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 257	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 263	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+194->202, 7:+409->417, 8:+413->421
      //   56: new 265	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 266	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto
      //   67: dup
      //   68: invokespecial 38	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 267 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 270	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto$Builder:<init>	(Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 272	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 275	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:hasToken	()Z
      //   114: aload_0
      //   115: getfield 49	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:token_	Ljava/lang/String;
      //   118: aload_3
      //   119: invokevirtual 275	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:hasToken	()Z
      //   122: aload_3
      //   123: getfield 49	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:token_	Ljava/lang/String;
      //   126: invokeinterface 279 5 0
      //   131: putfield 49	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:token_	Ljava/lang/String;
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: invokevirtual 282	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:hasLevel	()Z
      //   140: aload_0
      //   141: getfield 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:level_	J
      //   144: aload_3
      //   145: invokevirtual 282	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:hasLevel	()Z
      //   148: aload_3
      //   149: getfield 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:level_	J
      //   152: invokeinterface 286 7 0
      //   157: putfield 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:level_	J
      //   160: aload_0
      //   161: aload_2
      //   162: aload_0
      //   163: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   166: aload_3
      //   167: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   170: invokeinterface 290 3 0
      //   175: putfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   178: aload_0
      //   179: astore_1
      //   180: aload_2
      //   181: getstatic 296	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   184: if_acmpne -112 -> 72
      //   187: aload_0
      //   188: aload_0
      //   189: getfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   192: aload_3
      //   193: getfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   196: ior
      //   197: putfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   200: aload_0
      //   201: areturn
      //   202: aload_2
      //   203: checkcast 298	com/google/protobuf/CodedInputStream
      //   206: astore_1
      //   207: aload_3
      //   208: checkcast 300	com/google/protobuf/ExtensionRegistryLite
      //   211: astore_2
      //   212: iconst_0
      //   213: istore 4
      //   215: iload 4
      //   217: ifne +200 -> 417
      //   220: aload_1
      //   221: invokevirtual 303	com/google/protobuf/CodedInputStream:readTag	()I
      //   224: istore 5
      //   226: iload 5
      //   228: lookupswitch	default:+234->462, 0:+237->465, 10:+60->288, 16:+100->328, 26:+145->373
      //   272: aload_0
      //   273: iload 5
      //   275: aload_1
      //   276: invokevirtual 307	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   279: ifne -64 -> 215
      //   282: iconst_1
      //   283: istore 4
      //   285: goto -70 -> 215
      //   288: aload_1
      //   289: invokevirtual 310	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   292: astore_3
      //   293: aload_0
      //   294: aload_0
      //   295: getfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   298: iconst_1
      //   299: ior
      //   300: putfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   303: aload_0
      //   304: aload_3
      //   305: putfield 49	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:token_	Ljava/lang/String;
      //   308: goto -93 -> 215
      //   311: astore_1
      //   312: new 312	java/lang/RuntimeException
      //   315: dup
      //   316: aload_1
      //   317: aload_0
      //   318: invokevirtual 316	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   321: invokespecial 319	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   324: athrow
      //   325: astore_1
      //   326: aload_1
      //   327: athrow
      //   328: aload_0
      //   329: aload_0
      //   330: getfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   333: iconst_2
      //   334: ior
      //   335: putfield 159	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:bitField0_	I
      //   338: aload_0
      //   339: aload_1
      //   340: invokevirtual 323	com/google/protobuf/CodedInputStream:readInt64	()J
      //   343: putfield 161	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:level_	J
      //   346: goto -131 -> 215
      //   349: astore_1
      //   350: new 312	java/lang/RuntimeException
      //   353: dup
      //   354: new 203	com/google/protobuf/InvalidProtocolBufferException
      //   357: dup
      //   358: aload_1
      //   359: invokevirtual 326	java/io/IOException:getMessage	()Ljava/lang/String;
      //   362: invokespecial 328	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   365: aload_0
      //   366: invokevirtual 316	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   369: invokespecial 319	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   372: athrow
      //   373: aload_0
      //   374: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   377: invokeinterface 172 1 0
      //   382: ifne +14 -> 396
      //   385: aload_0
      //   386: aload_0
      //   387: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   390: invokestatic 176	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   393: putfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   396: aload_0
      //   397: getfield 55	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:vertices_	Lcom/google/protobuf/Internal$ProtobufList;
      //   400: aload_1
      //   401: invokestatic 332	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:parser	()Lcom/google/protobuf/Parser;
      //   404: aload_2
      //   405: invokevirtual 336	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   408: invokeinterface 157 2 0
      //   413: pop
      //   414: goto -199 -> 215
      //   417: getstatic 40	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   420: areturn
      //   421: getstatic 338	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:PARSER	Lcom/google/protobuf/Parser;
      //   424: ifnonnull +28 -> 452
      //   427: ldc 2
      //   429: monitorenter
      //   430: getstatic 338	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:PARSER	Lcom/google/protobuf/Parser;
      //   433: ifnonnull +16 -> 449
      //   436: new 340	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   439: dup
      //   440: getstatic 40	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto;
      //   443: invokespecial 343	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   446: putstatic 338	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:PARSER	Lcom/google/protobuf/Parser;
      //   449: ldc 2
      //   451: monitorexit
      //   452: getstatic 338	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellProto:PARSER	Lcom/google/protobuf/Parser;
      //   455: areturn
      //   456: astore_1
      //   457: ldc 2
      //   459: monitorexit
      //   460: aload_1
      //   461: athrow
      //   462: goto -190 -> 272
      //   465: iconst_1
      //   466: istore 4
      //   468: goto -253 -> 215
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	471	0	this	S2CellProto
      //   0	471	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	471	2	paramObject1	Object
      //   0	471	3	paramObject2	Object
      //   213	254	4	i	int
      //   224	50	5	j	int
      // Exception table:
      //   from	to	target	type
      //   220	226	311	com/google/protobuf/InvalidProtocolBufferException
      //   272	282	311	com/google/protobuf/InvalidProtocolBufferException
      //   288	308	311	com/google/protobuf/InvalidProtocolBufferException
      //   328	346	311	com/google/protobuf/InvalidProtocolBufferException
      //   373	396	311	com/google/protobuf/InvalidProtocolBufferException
      //   396	414	311	com/google/protobuf/InvalidProtocolBufferException
      //   220	226	325	finally
      //   272	282	325	finally
      //   288	308	325	finally
      //   312	325	325	finally
      //   328	346	325	finally
      //   350	373	325	finally
      //   373	396	325	finally
      //   396	414	325	finally
      //   220	226	349	java/io/IOException
      //   272	282	349	java/io/IOException
      //   288	308	349	java/io/IOException
      //   328	346	349	java/io/IOException
      //   373	396	349	java/io/IOException
      //   396	414	349	java/io/IOException
      //   430	449	456	finally
      //   449	452	456	finally
      //   457	460	456	finally
    }
    
    public long getLevel()
    {
      return this.level_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getToken());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeInt64Size(2, this.level_);
      }
      int k = 0;
      j = i;
      i = k;
      while (i < this.vertices_.size())
      {
        j += CodedOutputStream.computeMessageSize(3, (MessageLite)this.vertices_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getToken()
    {
      return this.token_;
    }
    
    public ByteString getTokenBytes()
    {
      return ByteString.copyFromUtf8(this.token_);
    }
    
    public S2Proto.LatLngAltProto getVertices(int paramInt)
    {
      return (S2Proto.LatLngAltProto)this.vertices_.get(paramInt);
    }
    
    public int getVerticesCount()
    {
      return this.vertices_.size();
    }
    
    public List<S2Proto.LatLngAltProto> getVerticesList()
    {
      return this.vertices_;
    }
    
    public S2Proto.LatLngAltProtoOrBuilder getVerticesOrBuilder(int paramInt)
    {
      return (S2Proto.LatLngAltProtoOrBuilder)this.vertices_.get(paramInt);
    }
    
    public List<? extends S2Proto.LatLngAltProtoOrBuilder> getVerticesOrBuilderList()
    {
      return this.vertices_;
    }
    
    public boolean hasLevel()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasToken()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getToken());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeInt64(2, this.level_);
      }
      int i = 0;
      while (i < this.vertices_.size())
      {
        paramCodedOutputStream.writeMessage(3, (MessageLite)this.vertices_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AggregatedLocalizationResults.S2CellProto, Builder>
      implements AggregatedLocalizationResults.S2CellProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllVertices(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).addAllVertices(paramIterable);
        return this;
      }
      
      public Builder addVertices(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).addVertices(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addVertices(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).addVertices(paramInt, paramLatLngAltProto);
        return this;
      }
      
      public Builder addVertices(S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).addVertices(paramBuilder);
        return this;
      }
      
      public Builder addVertices(S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).addVertices(paramLatLngAltProto);
        return this;
      }
      
      public Builder clearLevel()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).clearLevel();
        return this;
      }
      
      public Builder clearToken()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).clearToken();
        return this;
      }
      
      public Builder clearVertices()
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).clearVertices();
        return this;
      }
      
      public long getLevel()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).getLevel();
      }
      
      public String getToken()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).getToken();
      }
      
      public ByteString getTokenBytes()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).getTokenBytes();
      }
      
      public S2Proto.LatLngAltProto getVertices(int paramInt)
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).getVertices(paramInt);
      }
      
      public int getVerticesCount()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).getVerticesCount();
      }
      
      public List<S2Proto.LatLngAltProto> getVerticesList()
      {
        return Collections.unmodifiableList(((AggregatedLocalizationResults.S2CellProto)this.instance).getVerticesList());
      }
      
      public boolean hasLevel()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).hasLevel();
      }
      
      public boolean hasToken()
      {
        return ((AggregatedLocalizationResults.S2CellProto)this.instance).hasToken();
      }
      
      public Builder removeVertices(int paramInt)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).removeVertices(paramInt);
        return this;
      }
      
      public Builder setLevel(long paramLong)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).setLevel(paramLong);
        return this;
      }
      
      public Builder setToken(String paramString)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).setToken(paramString);
        return this;
      }
      
      public Builder setTokenBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).setTokenBytes(paramByteString);
        return this;
      }
      
      public Builder setVertices(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).setVertices(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setVertices(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((AggregatedLocalizationResults.S2CellProto)this.instance).setVertices(paramInt, paramLatLngAltProto);
        return this;
      }
    }
  }
  
  public static abstract interface S2CellProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract long getLevel();
    
    public abstract String getToken();
    
    public abstract ByteString getTokenBytes();
    
    public abstract S2Proto.LatLngAltProto getVertices(int paramInt);
    
    public abstract int getVerticesCount();
    
    public abstract List<S2Proto.LatLngAltProto> getVerticesList();
    
    public abstract boolean hasLevel();
    
    public abstract boolean hasToken();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */