package com.google.location.visualmapping.common;

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
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class S2Proto
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class LatLngAltProto
    extends GeneratedMessageLite<LatLngAltProto, Builder>
    implements S2Proto.LatLngAltProtoOrBuilder
  {
    public static final int ALTITUDE_METERS_FIELD_NUMBER = 3;
    private static final LatLngAltProto DEFAULT_INSTANCE = new LatLngAltProto();
    public static final int LATITUDE_DEGREES_FIELD_NUMBER = 1;
    public static final int LONGITUDE_DEGREES_FIELD_NUMBER = 2;
    private static volatile Parser<LatLngAltProto> PARSER;
    private double altitudeMeters_;
    private int bitField0_;
    private double latitudeDegrees_;
    private double longitudeDegrees_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAltitudeMeters()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.altitudeMeters_ = 0.0D;
    }
    
    private void clearLatitudeDegrees()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.latitudeDegrees_ = 0.0D;
    }
    
    private void clearLongitudeDegrees()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.longitudeDegrees_ = 0.0D;
    }
    
    public static LatLngAltProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LatLngAltProto paramLatLngAltProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLatLngAltProto);
    }
    
    public static LatLngAltProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngAltProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngAltProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LatLngAltProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LatLngAltProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LatLngAltProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngAltProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LatLngAltProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LatLngAltProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAltitudeMeters(double paramDouble)
    {
      this.bitField0_ |= 0x4;
      this.altitudeMeters_ = paramDouble;
    }
    
    private void setLatitudeDegrees(double paramDouble)
    {
      this.bitField0_ |= 0x1;
      this.latitudeDegrees_ = paramDouble;
    }
    
    private void setLongitudeDegrees(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.longitudeDegrees_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 149	com/google/location/visualmapping/common/S2Proto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 155	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+193->201, 7:+380->388, 8:+384->392
      //   56: new 157	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 158	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/S2Proto$LatLngAltProto
      //   67: dup
      //   68: invokespecial 35	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 37	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/S2Proto$LatLngAltProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 161	com/google/location/visualmapping/common/S2Proto$LatLngAltProto$Builder:<init>	(Lcom/google/location/visualmapping/common/S2Proto$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 163	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/S2Proto$LatLngAltProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 167	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasLatitudeDegrees	()Z
      //   105: aload_0
      //   106: getfield 77	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:latitudeDegrees_	D
      //   109: aload_3
      //   110: invokevirtual 167	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasLatitudeDegrees	()Z
      //   113: aload_3
      //   114: getfield 77	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:latitudeDegrees_	D
      //   117: invokeinterface 171 7 0
      //   122: putfield 77	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:latitudeDegrees_	D
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 174	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasLongitudeDegrees	()Z
      //   131: aload_0
      //   132: getfield 79	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:longitudeDegrees_	D
      //   135: aload_3
      //   136: invokevirtual 174	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasLongitudeDegrees	()Z
      //   139: aload_3
      //   140: getfield 79	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:longitudeDegrees_	D
      //   143: invokeinterface 171 7 0
      //   148: putfield 79	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:longitudeDegrees_	D
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 177	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasAltitudeMeters	()Z
      //   157: aload_0
      //   158: getfield 75	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:altitudeMeters_	D
      //   161: aload_3
      //   162: invokevirtual 177	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:hasAltitudeMeters	()Z
      //   165: aload_3
      //   166: getfield 75	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:altitudeMeters_	D
      //   169: invokeinterface 171 7 0
      //   174: putfield 75	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:altitudeMeters_	D
      //   177: aload_0
      //   178: astore_1
      //   179: aload_2
      //   180: getstatic 183	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   183: if_acmpne -111 -> 72
      //   186: aload_0
      //   187: aload_0
      //   188: getfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   191: aload_3
      //   192: getfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   195: ior
      //   196: putfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   199: aload_0
      //   200: areturn
      //   201: aload_2
      //   202: checkcast 185	com/google/protobuf/CodedInputStream
      //   205: astore_1
      //   206: aload_3
      //   207: checkcast 187	com/google/protobuf/ExtensionRegistryLite
      //   210: astore_2
      //   211: iconst_0
      //   212: istore 4
      //   214: iload 4
      //   216: ifne +172 -> 388
      //   219: aload_1
      //   220: invokevirtual 190	com/google/protobuf/CodedInputStream:readTag	()I
      //   223: istore 5
      //   225: iload 5
      //   227: lookupswitch	default:+206->433, 0:+209->436, 9:+57->284, 17:+95->322, 25:+140->367
      //   268: aload_0
      //   269: iload 5
      //   271: aload_1
      //   272: invokevirtual 194	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   275: ifne -61 -> 214
      //   278: iconst_1
      //   279: istore 4
      //   281: goto -67 -> 214
      //   284: aload_0
      //   285: aload_0
      //   286: getfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   289: iconst_1
      //   290: ior
      //   291: putfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   294: aload_0
      //   295: aload_1
      //   296: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   299: putfield 77	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:latitudeDegrees_	D
      //   302: goto -88 -> 214
      //   305: astore_1
      //   306: new 200	java/lang/RuntimeException
      //   309: dup
      //   310: aload_1
      //   311: aload_0
      //   312: invokevirtual 204	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   315: invokespecial 207	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   318: athrow
      //   319: astore_1
      //   320: aload_1
      //   321: athrow
      //   322: aload_0
      //   323: aload_0
      //   324: getfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   327: iconst_2
      //   328: ior
      //   329: putfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   332: aload_0
      //   333: aload_1
      //   334: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   337: putfield 79	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:longitudeDegrees_	D
      //   340: goto -126 -> 214
      //   343: astore_1
      //   344: new 200	java/lang/RuntimeException
      //   347: dup
      //   348: new 107	com/google/protobuf/InvalidProtocolBufferException
      //   351: dup
      //   352: aload_1
      //   353: invokevirtual 211	java/io/IOException:getMessage	()Ljava/lang/String;
      //   356: invokespecial 214	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   359: aload_0
      //   360: invokevirtual 204	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   363: invokespecial 207	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   366: athrow
      //   367: aload_0
      //   368: aload_0
      //   369: getfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   372: iconst_4
      //   373: ior
      //   374: putfield 73	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:bitField0_	I
      //   377: aload_0
      //   378: aload_1
      //   379: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   382: putfield 75	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:altitudeMeters_	D
      //   385: goto -171 -> 214
      //   388: getstatic 37	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltProto;
      //   391: areturn
      //   392: getstatic 216	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:PARSER	Lcom/google/protobuf/Parser;
      //   395: ifnonnull +28 -> 423
      //   398: ldc 2
      //   400: monitorenter
      //   401: getstatic 216	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:PARSER	Lcom/google/protobuf/Parser;
      //   404: ifnonnull +16 -> 420
      //   407: new 218	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   410: dup
      //   411: getstatic 37	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltProto;
      //   414: invokespecial 221	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   417: putstatic 216	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:PARSER	Lcom/google/protobuf/Parser;
      //   420: ldc 2
      //   422: monitorexit
      //   423: getstatic 216	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:PARSER	Lcom/google/protobuf/Parser;
      //   426: areturn
      //   427: astore_1
      //   428: ldc 2
      //   430: monitorexit
      //   431: aload_1
      //   432: athrow
      //   433: goto -165 -> 268
      //   436: iconst_1
      //   437: istore 4
      //   439: goto -225 -> 214
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	442	0	this	LatLngAltProto
      //   0	442	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	442	2	paramObject1	Object
      //   0	442	3	paramObject2	Object
      //   212	226	4	i	int
      //   223	47	5	j	int
      // Exception table:
      //   from	to	target	type
      //   219	225	305	com/google/protobuf/InvalidProtocolBufferException
      //   268	278	305	com/google/protobuf/InvalidProtocolBufferException
      //   284	302	305	com/google/protobuf/InvalidProtocolBufferException
      //   322	340	305	com/google/protobuf/InvalidProtocolBufferException
      //   367	385	305	com/google/protobuf/InvalidProtocolBufferException
      //   219	225	319	finally
      //   268	278	319	finally
      //   284	302	319	finally
      //   306	319	319	finally
      //   322	340	319	finally
      //   344	367	319	finally
      //   367	385	319	finally
      //   219	225	343	java/io/IOException
      //   268	278	343	java/io/IOException
      //   284	302	343	java/io/IOException
      //   322	340	343	java/io/IOException
      //   367	385	343	java/io/IOException
      //   401	420	427	finally
      //   420	423	427	finally
      //   428	431	427	finally
    }
    
    public double getAltitudeMeters()
    {
      return this.altitudeMeters_;
    }
    
    public double getLatitudeDegrees()
    {
      return this.latitudeDegrees_;
    }
    
    public double getLongitudeDegrees()
    {
      return this.longitudeDegrees_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeDoubleSize(1, this.latitudeDegrees_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeDoubleSize(2, this.longitudeDegrees_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeDoubleSize(3, this.altitudeMeters_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAltitudeMeters()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasLatitudeDegrees()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasLongitudeDegrees()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeDouble(1, this.latitudeDegrees_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.longitudeDegrees_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeDouble(3, this.altitudeMeters_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<S2Proto.LatLngAltProto, Builder>
      implements S2Proto.LatLngAltProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearAltitudeMeters()
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).clearAltitudeMeters();
        return this;
      }
      
      public Builder clearLatitudeDegrees()
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).clearLatitudeDegrees();
        return this;
      }
      
      public Builder clearLongitudeDegrees()
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).clearLongitudeDegrees();
        return this;
      }
      
      public double getAltitudeMeters()
      {
        return ((S2Proto.LatLngAltProto)this.instance).getAltitudeMeters();
      }
      
      public double getLatitudeDegrees()
      {
        return ((S2Proto.LatLngAltProto)this.instance).getLatitudeDegrees();
      }
      
      public double getLongitudeDegrees()
      {
        return ((S2Proto.LatLngAltProto)this.instance).getLongitudeDegrees();
      }
      
      public boolean hasAltitudeMeters()
      {
        return ((S2Proto.LatLngAltProto)this.instance).hasAltitudeMeters();
      }
      
      public boolean hasLatitudeDegrees()
      {
        return ((S2Proto.LatLngAltProto)this.instance).hasLatitudeDegrees();
      }
      
      public boolean hasLongitudeDegrees()
      {
        return ((S2Proto.LatLngAltProto)this.instance).hasLongitudeDegrees();
      }
      
      public Builder setAltitudeMeters(double paramDouble)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).setAltitudeMeters(paramDouble);
        return this;
      }
      
      public Builder setLatitudeDegrees(double paramDouble)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).setLatitudeDegrees(paramDouble);
        return this;
      }
      
      public Builder setLongitudeDegrees(double paramDouble)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltProto)this.instance).setLongitudeDegrees(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface LatLngAltProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getAltitudeMeters();
    
    public abstract double getLatitudeDegrees();
    
    public abstract double getLongitudeDegrees();
    
    public abstract boolean hasAltitudeMeters();
    
    public abstract boolean hasLatitudeDegrees();
    
    public abstract boolean hasLongitudeDegrees();
  }
  
  public static final class LatLngAltTrajectoryProto
    extends GeneratedMessageLite<LatLngAltTrajectoryProto, Builder>
    implements S2Proto.LatLngAltTrajectoryProtoOrBuilder
  {
    private static final LatLngAltTrajectoryProto DEFAULT_INSTANCE = new LatLngAltTrajectoryProto();
    private static volatile Parser<LatLngAltTrajectoryProto> PARSER;
    public static final int POINTS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<S2Proto.LatLngAltProto> points_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllPoints(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
    {
      ensurePointsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.points_);
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
    
    private void clearPoints()
    {
      this.points_ = emptyProtobufList();
    }
    
    private void ensurePointsIsMutable()
    {
      if (!this.points_.isModifiable()) {
        this.points_ = GeneratedMessageLite.mutableCopy(this.points_);
      }
    }
    
    public static LatLngAltTrajectoryProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LatLngAltTrajectoryProto paramLatLngAltTrajectoryProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLatLngAltTrajectoryProto);
    }
    
    public static LatLngAltTrajectoryProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngAltTrajectoryProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LatLngAltTrajectoryProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngAltTrajectoryProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LatLngAltTrajectoryProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removePoints(int paramInt)
    {
      ensurePointsIsMutable();
      this.points_.remove(paramInt);
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
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 203	com/google/location/visualmapping/common/S2Proto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 209	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+281->289, 8:+285->293
      //   56: new 211	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 212	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 213 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 216	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto$Builder:<init>	(Lcom/google/location/visualmapping/common/S2Proto$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 218	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 222 3 0
      //   123: putfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   126: aload_0
      //   127: astore_1
      //   128: aload_2
      //   129: getstatic 228	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   132: if_acmpne -60 -> 72
      //   135: aload_0
      //   136: areturn
      //   137: aload_2
      //   138: checkcast 230	com/google/protobuf/CodedInputStream
      //   141: astore_1
      //   142: aload_3
      //   143: checkcast 232	com/google/protobuf/ExtensionRegistryLite
      //   146: astore_2
      //   147: iconst_0
      //   148: istore 4
      //   150: iload 4
      //   152: ifne +137 -> 289
      //   155: aload_1
      //   156: invokevirtual 235	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+171->334, 0:+174->337, 10:+41->204
      //   188: aload_0
      //   189: iload 5
      //   191: aload_1
      //   192: invokevirtual 239	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   195: ifne -45 -> 150
      //   198: iconst_1
      //   199: istore 4
      //   201: goto -51 -> 150
      //   204: aload_0
      //   205: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   208: invokeinterface 122 1 0
      //   213: ifne +14 -> 227
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   221: invokestatic 126	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   224: putfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   227: aload_0
      //   228: getfield 42	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:points_	Lcom/google/protobuf/Internal$ProtobufList;
      //   231: aload_1
      //   232: invokestatic 243	com/google/location/visualmapping/common/S2Proto$LatLngAltProto:parser	()Lcom/google/protobuf/Parser;
      //   235: aload_2
      //   236: invokevirtual 247	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   239: invokeinterface 118 2 0
      //   244: pop
      //   245: goto -95 -> 150
      //   248: astore_1
      //   249: new 249	java/lang/RuntimeException
      //   252: dup
      //   253: aload_1
      //   254: aload_0
      //   255: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   261: athrow
      //   262: astore_1
      //   263: aload_1
      //   264: athrow
      //   265: astore_1
      //   266: new 249	java/lang/RuntimeException
      //   269: dup
      //   270: new 154	com/google/protobuf/InvalidProtocolBufferException
      //   273: dup
      //   274: aload_1
      //   275: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   278: invokespecial 263	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   281: aload_0
      //   282: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: getstatic 31	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto;
      //   292: areturn
      //   293: getstatic 265	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +28 -> 324
      //   299: ldc 2
      //   301: monitorenter
      //   302: getstatic 265	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:PARSER	Lcom/google/protobuf/Parser;
      //   305: ifnonnull +16 -> 321
      //   308: new 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   311: dup
      //   312: getstatic 31	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto;
      //   315: invokespecial 270	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   318: putstatic 265	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:PARSER	Lcom/google/protobuf/Parser;
      //   321: ldc 2
      //   323: monitorexit
      //   324: getstatic 265	com/google/location/visualmapping/common/S2Proto$LatLngAltTrajectoryProto:PARSER	Lcom/google/protobuf/Parser;
      //   327: areturn
      //   328: astore_1
      //   329: ldc 2
      //   331: monitorexit
      //   332: aload_1
      //   333: athrow
      //   334: goto -146 -> 188
      //   337: iconst_1
      //   338: istore 4
      //   340: goto -190 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	343	0	this	LatLngAltTrajectoryProto
      //   0	343	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	343	2	paramObject1	Object
      //   0	343	3	paramObject2	Object
      //   148	191	4	i	int
      //   159	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   155	161	248	com/google/protobuf/InvalidProtocolBufferException
      //   188	198	248	com/google/protobuf/InvalidProtocolBufferException
      //   204	227	248	com/google/protobuf/InvalidProtocolBufferException
      //   227	245	248	com/google/protobuf/InvalidProtocolBufferException
      //   155	161	262	finally
      //   188	198	262	finally
      //   204	227	262	finally
      //   227	245	262	finally
      //   249	262	262	finally
      //   266	289	262	finally
      //   155	161	265	java/io/IOException
      //   188	198	265	java/io/IOException
      //   204	227	265	java/io/IOException
      //   227	245	265	java/io/IOException
      //   302	321	328	finally
      //   321	324	328	finally
      //   329	332	328	finally
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
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.points_.size())
      {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.points_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.points_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.points_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<S2Proto.LatLngAltTrajectoryProto, Builder>
      implements S2Proto.LatLngAltTrajectoryProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllPoints(Iterable<? extends S2Proto.LatLngAltProto> paramIterable)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).addAllPoints(paramIterable);
        return this;
      }
      
      public Builder addPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).addPoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).addPoints(paramInt, paramLatLngAltProto);
        return this;
      }
      
      public Builder addPoints(S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).addPoints(paramBuilder);
        return this;
      }
      
      public Builder addPoints(S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).addPoints(paramLatLngAltProto);
        return this;
      }
      
      public Builder clearPoints()
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).clearPoints();
        return this;
      }
      
      public S2Proto.LatLngAltProto getPoints(int paramInt)
      {
        return ((S2Proto.LatLngAltTrajectoryProto)this.instance).getPoints(paramInt);
      }
      
      public int getPointsCount()
      {
        return ((S2Proto.LatLngAltTrajectoryProto)this.instance).getPointsCount();
      }
      
      public List<S2Proto.LatLngAltProto> getPointsList()
      {
        return Collections.unmodifiableList(((S2Proto.LatLngAltTrajectoryProto)this.instance).getPointsList());
      }
      
      public Builder removePoints(int paramInt)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).removePoints(paramInt);
        return this;
      }
      
      public Builder setPoints(int paramInt, S2Proto.LatLngAltProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).setPoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setPoints(int paramInt, S2Proto.LatLngAltProto paramLatLngAltProto)
      {
        copyOnWrite();
        ((S2Proto.LatLngAltTrajectoryProto)this.instance).setPoints(paramInt, paramLatLngAltProto);
        return this;
      }
    }
  }
  
  public static abstract interface LatLngAltTrajectoryProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract S2Proto.LatLngAltProto getPoints(int paramInt);
    
    public abstract int getPointsCount();
    
    public abstract List<S2Proto.LatLngAltProto> getPointsList();
  }
  
  public static final class LatLngProto
    extends GeneratedMessageLite<LatLngProto, Builder>
    implements S2Proto.LatLngProtoOrBuilder
  {
    private static final LatLngProto DEFAULT_INSTANCE = new LatLngProto();
    public static final int LATITUDE_DEGREES_FIELD_NUMBER = 1;
    public static final int LONGITUDE_DEGREES_FIELD_NUMBER = 2;
    private static volatile Parser<LatLngProto> PARSER;
    private int bitField0_;
    private double latitudeDegrees_;
    private double longitudeDegrees_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearLatitudeDegrees()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.latitudeDegrees_ = 0.0D;
    }
    
    private void clearLongitudeDegrees()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.longitudeDegrees_ = 0.0D;
    }
    
    public static LatLngProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LatLngProto paramLatLngProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLatLngProto);
    }
    
    public static LatLngProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LatLngProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LatLngProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LatLngProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LatLngProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LatLngProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LatLngProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LatLngProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LatLngProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setLatitudeDegrees(double paramDouble)
    {
      this.bitField0_ |= 0x1;
      this.latitudeDegrees_ = paramDouble;
    }
    
    private void setLongitudeDegrees(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.longitudeDegrees_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 136	com/google/location/visualmapping/common/S2Proto$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 142	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
      //   56: new 144	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 145	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/S2Proto$LatLngProto
      //   67: dup
      //   68: invokespecial 32	com/google/location/visualmapping/common/S2Proto$LatLngProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/google/location/visualmapping/common/S2Proto$LatLngProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/S2Proto$LatLngProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 148	com/google/location/visualmapping/common/S2Proto$LatLngProto$Builder:<init>	(Lcom/google/location/visualmapping/common/S2Proto$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 150	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/S2Proto$LatLngProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 154	com/google/location/visualmapping/common/S2Proto$LatLngProto:hasLatitudeDegrees	()Z
      //   105: aload_0
      //   106: getfield 64	com/google/location/visualmapping/common/S2Proto$LatLngProto:latitudeDegrees_	D
      //   109: aload_3
      //   110: invokevirtual 154	com/google/location/visualmapping/common/S2Proto$LatLngProto:hasLatitudeDegrees	()Z
      //   113: aload_3
      //   114: getfield 64	com/google/location/visualmapping/common/S2Proto$LatLngProto:latitudeDegrees_	D
      //   117: invokeinterface 158 7 0
      //   122: putfield 64	com/google/location/visualmapping/common/S2Proto$LatLngProto:latitudeDegrees_	D
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 161	com/google/location/visualmapping/common/S2Proto$LatLngProto:hasLongitudeDegrees	()Z
      //   131: aload_0
      //   132: getfield 66	com/google/location/visualmapping/common/S2Proto$LatLngProto:longitudeDegrees_	D
      //   135: aload_3
      //   136: invokevirtual 161	com/google/location/visualmapping/common/S2Proto$LatLngProto:hasLongitudeDegrees	()Z
      //   139: aload_3
      //   140: getfield 66	com/google/location/visualmapping/common/S2Proto$LatLngProto:longitudeDegrees_	D
      //   143: invokeinterface 158 7 0
      //   148: putfield 66	com/google/location/visualmapping/common/S2Proto$LatLngProto:longitudeDegrees_	D
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 167	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   165: aload_3
      //   166: getfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   169: ior
      //   170: putfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
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
      //   201: lookupswitch	default:+179->380, 0:+182->383, 9:+51->252, 17:+89->290
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 178	com/google/location/visualmapping/common/S2Proto$LatLngProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 182	com/google/protobuf/CodedInputStream:readDouble	()D
      //   267: putfield 64	com/google/location/visualmapping/common/S2Proto$LatLngProto:latitudeDegrees_	D
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
      //   292: getfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   295: iconst_2
      //   296: ior
      //   297: putfield 62	com/google/location/visualmapping/common/S2Proto$LatLngProto:bitField0_	I
      //   300: aload_0
      //   301: aload_1
      //   302: invokevirtual 182	com/google/protobuf/CodedInputStream:readDouble	()D
      //   305: putfield 66	com/google/location/visualmapping/common/S2Proto$LatLngProto:longitudeDegrees_	D
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
      //   335: getstatic 34	com/google/location/visualmapping/common/S2Proto$LatLngProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngProto;
      //   338: areturn
      //   339: getstatic 200	com/google/location/visualmapping/common/S2Proto$LatLngProto:PARSER	Lcom/google/protobuf/Parser;
      //   342: ifnonnull +28 -> 370
      //   345: ldc 2
      //   347: monitorenter
      //   348: getstatic 200	com/google/location/visualmapping/common/S2Proto$LatLngProto:PARSER	Lcom/google/protobuf/Parser;
      //   351: ifnonnull +16 -> 367
      //   354: new 202	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   357: dup
      //   358: getstatic 34	com/google/location/visualmapping/common/S2Proto$LatLngProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/S2Proto$LatLngProto;
      //   361: invokespecial 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   364: putstatic 200	com/google/location/visualmapping/common/S2Proto$LatLngProto:PARSER	Lcom/google/protobuf/Parser;
      //   367: ldc 2
      //   369: monitorexit
      //   370: getstatic 200	com/google/location/visualmapping/common/S2Proto$LatLngProto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	389	0	this	LatLngProto
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
    
    public double getLatitudeDegrees()
    {
      return this.latitudeDegrees_;
    }
    
    public double getLongitudeDegrees()
    {
      return this.longitudeDegrees_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeDoubleSize(1, this.latitudeDegrees_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeDoubleSize(2, this.longitudeDegrees_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasLatitudeDegrees()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasLongitudeDegrees()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeDouble(1, this.latitudeDegrees_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.longitudeDegrees_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<S2Proto.LatLngProto, Builder>
      implements S2Proto.LatLngProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearLatitudeDegrees()
      {
        copyOnWrite();
        ((S2Proto.LatLngProto)this.instance).clearLatitudeDegrees();
        return this;
      }
      
      public Builder clearLongitudeDegrees()
      {
        copyOnWrite();
        ((S2Proto.LatLngProto)this.instance).clearLongitudeDegrees();
        return this;
      }
      
      public double getLatitudeDegrees()
      {
        return ((S2Proto.LatLngProto)this.instance).getLatitudeDegrees();
      }
      
      public double getLongitudeDegrees()
      {
        return ((S2Proto.LatLngProto)this.instance).getLongitudeDegrees();
      }
      
      public boolean hasLatitudeDegrees()
      {
        return ((S2Proto.LatLngProto)this.instance).hasLatitudeDegrees();
      }
      
      public boolean hasLongitudeDegrees()
      {
        return ((S2Proto.LatLngProto)this.instance).hasLongitudeDegrees();
      }
      
      public Builder setLatitudeDegrees(double paramDouble)
      {
        copyOnWrite();
        ((S2Proto.LatLngProto)this.instance).setLatitudeDegrees(paramDouble);
        return this;
      }
      
      public Builder setLongitudeDegrees(double paramDouble)
      {
        copyOnWrite();
        ((S2Proto.LatLngProto)this.instance).setLongitudeDegrees(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface LatLngProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getLatitudeDegrees();
    
    public abstract double getLongitudeDegrees();
    
    public abstract boolean hasLatitudeDegrees();
    
    public abstract boolean hasLongitudeDegrees();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/common/S2Proto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */