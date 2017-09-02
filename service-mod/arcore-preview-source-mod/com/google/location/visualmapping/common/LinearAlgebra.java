package com.google.location.visualmapping.common;

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

public final class LinearAlgebra
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class QuaternionProto
    extends GeneratedMessageLite<QuaternionProto, Builder>
    implements LinearAlgebra.QuaternionProtoOrBuilder
  {
    private static final QuaternionProto DEFAULT_INSTANCE = new QuaternionProto();
    private static volatile Parser<QuaternionProto> PARSER;
    public static final int W_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 2;
    public static final int Y_FIELD_NUMBER = 3;
    public static final int Z_FIELD_NUMBER = 4;
    private int bitField0_;
    private double w_;
    private double x_;
    private double y_;
    private double z_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearW()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.w_ = 0.0D;
    }
    
    private void clearX()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.x_ = 0.0D;
    }
    
    private void clearY()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.y_ = 0.0D;
    }
    
    private void clearZ()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.z_ = 0.0D;
    }
    
    public static QuaternionProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(QuaternionProto paramQuaternionProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuaternionProto);
    }
    
    public static QuaternionProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (QuaternionProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static QuaternionProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuaternionProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static QuaternionProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static QuaternionProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static QuaternionProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static QuaternionProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static QuaternionProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static QuaternionProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static QuaternionProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static QuaternionProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (QuaternionProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<QuaternionProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setW(double paramDouble)
    {
      this.bitField0_ |= 0x1;
      this.w_ = paramDouble;
    }
    
    private void setX(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.x_ = paramDouble;
    }
    
    private void setY(double paramDouble)
    {
      this.bitField0_ |= 0x4;
      this.y_ = paramDouble;
    }
    
    private void setZ(double paramDouble)
    {
      this.bitField0_ |= 0x8;
      this.z_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 162	com/google/location/visualmapping/common/LinearAlgebra$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 168	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+219->227, 7:+438->446, 8:+442->450
      //   56: new 170	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 171	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto
      //   67: dup
      //   68: invokespecial 38	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 174	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto$Builder:<init>	(Lcom/google/location/visualmapping/common/LinearAlgebra$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 176	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 180	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasW	()Z
      //   105: aload_0
      //   106: getfield 86	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:w_	D
      //   109: aload_3
      //   110: invokevirtual 180	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasW	()Z
      //   113: aload_3
      //   114: getfield 86	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:w_	D
      //   117: invokeinterface 184 7 0
      //   122: putfield 86	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:w_	D
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 187	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasX	()Z
      //   131: aload_0
      //   132: getfield 88	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:x_	D
      //   135: aload_3
      //   136: invokevirtual 187	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasX	()Z
      //   139: aload_3
      //   140: getfield 88	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:x_	D
      //   143: invokeinterface 184 7 0
      //   148: putfield 88	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:x_	D
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 190	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasY	()Z
      //   157: aload_0
      //   158: getfield 90	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:y_	D
      //   161: aload_3
      //   162: invokevirtual 190	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasY	()Z
      //   165: aload_3
      //   166: getfield 90	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:y_	D
      //   169: invokeinterface 184 7 0
      //   174: putfield 90	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:y_	D
      //   177: aload_0
      //   178: aload_2
      //   179: aload_0
      //   180: invokevirtual 193	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasZ	()Z
      //   183: aload_0
      //   184: getfield 92	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:z_	D
      //   187: aload_3
      //   188: invokevirtual 193	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:hasZ	()Z
      //   191: aload_3
      //   192: getfield 92	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:z_	D
      //   195: invokeinterface 184 7 0
      //   200: putfield 92	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:z_	D
      //   203: aload_0
      //   204: astore_1
      //   205: aload_2
      //   206: getstatic 199	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   209: if_acmpne -137 -> 72
      //   212: aload_0
      //   213: aload_0
      //   214: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   217: aload_3
      //   218: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   221: ior
      //   222: putfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   225: aload_0
      //   226: areturn
      //   227: aload_2
      //   228: checkcast 201	com/google/protobuf/CodedInputStream
      //   231: astore_1
      //   232: aload_3
      //   233: checkcast 203	com/google/protobuf/ExtensionRegistryLite
      //   236: astore_2
      //   237: iconst_0
      //   238: istore 4
      //   240: iload 4
      //   242: ifne +204 -> 446
      //   245: aload_1
      //   246: invokevirtual 206	com/google/protobuf/CodedInputStream:readTag	()I
      //   249: istore 5
      //   251: iload 5
      //   253: lookupswitch	default:+238->491, 0:+241->494, 9:+67->320, 17:+105->358, 25:+150->403, 33:+171->424
      //   304: aload_0
      //   305: iload 5
      //   307: aload_1
      //   308: invokevirtual 210	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   311: ifne -71 -> 240
      //   314: iconst_1
      //   315: istore 4
      //   317: goto -77 -> 240
      //   320: aload_0
      //   321: aload_0
      //   322: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   325: iconst_1
      //   326: ior
      //   327: putfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   330: aload_0
      //   331: aload_1
      //   332: invokevirtual 214	com/google/protobuf/CodedInputStream:readDouble	()D
      //   335: putfield 86	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:w_	D
      //   338: goto -98 -> 240
      //   341: astore_1
      //   342: new 216	java/lang/RuntimeException
      //   345: dup
      //   346: aload_1
      //   347: aload_0
      //   348: invokevirtual 220	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   351: invokespecial 223	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   354: athrow
      //   355: astore_1
      //   356: aload_1
      //   357: athrow
      //   358: aload_0
      //   359: aload_0
      //   360: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   363: iconst_2
      //   364: ior
      //   365: putfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   368: aload_0
      //   369: aload_1
      //   370: invokevirtual 214	com/google/protobuf/CodedInputStream:readDouble	()D
      //   373: putfield 88	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:x_	D
      //   376: goto -136 -> 240
      //   379: astore_1
      //   380: new 216	java/lang/RuntimeException
      //   383: dup
      //   384: new 120	com/google/protobuf/InvalidProtocolBufferException
      //   387: dup
      //   388: aload_1
      //   389: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
      //   392: invokespecial 230	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   395: aload_0
      //   396: invokevirtual 220	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   399: invokespecial 223	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   402: athrow
      //   403: aload_0
      //   404: aload_0
      //   405: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   408: iconst_4
      //   409: ior
      //   410: putfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   413: aload_0
      //   414: aload_1
      //   415: invokevirtual 214	com/google/protobuf/CodedInputStream:readDouble	()D
      //   418: putfield 90	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:y_	D
      //   421: goto -181 -> 240
      //   424: aload_0
      //   425: aload_0
      //   426: getfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   429: bipush 8
      //   431: ior
      //   432: putfield 84	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:bitField0_	I
      //   435: aload_0
      //   436: aload_1
      //   437: invokevirtual 214	com/google/protobuf/CodedInputStream:readDouble	()D
      //   440: putfield 92	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:z_	D
      //   443: goto -203 -> 240
      //   446: getstatic 40	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   449: areturn
      //   450: getstatic 232	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:PARSER	Lcom/google/protobuf/Parser;
      //   453: ifnonnull +28 -> 481
      //   456: ldc 2
      //   458: monitorenter
      //   459: getstatic 232	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:PARSER	Lcom/google/protobuf/Parser;
      //   462: ifnonnull +16 -> 478
      //   465: new 234	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   468: dup
      //   469: getstatic 40	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   472: invokespecial 237	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   475: putstatic 232	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:PARSER	Lcom/google/protobuf/Parser;
      //   478: ldc 2
      //   480: monitorexit
      //   481: getstatic 232	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:PARSER	Lcom/google/protobuf/Parser;
      //   484: areturn
      //   485: astore_1
      //   486: ldc 2
      //   488: monitorexit
      //   489: aload_1
      //   490: athrow
      //   491: goto -187 -> 304
      //   494: iconst_1
      //   495: istore 4
      //   497: goto -257 -> 240
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	500	0	this	QuaternionProto
      //   0	500	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	500	2	paramObject1	Object
      //   0	500	3	paramObject2	Object
      //   238	258	4	i	int
      //   249	57	5	j	int
      // Exception table:
      //   from	to	target	type
      //   245	251	341	com/google/protobuf/InvalidProtocolBufferException
      //   304	314	341	com/google/protobuf/InvalidProtocolBufferException
      //   320	338	341	com/google/protobuf/InvalidProtocolBufferException
      //   358	376	341	com/google/protobuf/InvalidProtocolBufferException
      //   403	421	341	com/google/protobuf/InvalidProtocolBufferException
      //   424	443	341	com/google/protobuf/InvalidProtocolBufferException
      //   245	251	355	finally
      //   304	314	355	finally
      //   320	338	355	finally
      //   342	355	355	finally
      //   358	376	355	finally
      //   380	403	355	finally
      //   403	421	355	finally
      //   424	443	355	finally
      //   245	251	379	java/io/IOException
      //   304	314	379	java/io/IOException
      //   320	338	379	java/io/IOException
      //   358	376	379	java/io/IOException
      //   403	421	379	java/io/IOException
      //   424	443	379	java/io/IOException
      //   459	478	485	finally
      //   478	481	485	finally
      //   486	489	485	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeDoubleSize(1, this.w_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeDoubleSize(2, this.x_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeDoubleSize(3, this.y_);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeDoubleSize(4, this.z_);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public double getW()
    {
      return this.w_;
    }
    
    public double getX()
    {
      return this.x_;
    }
    
    public double getY()
    {
      return this.y_;
    }
    
    public double getZ()
    {
      return this.z_;
    }
    
    public boolean hasW()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasX()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasY()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasZ()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeDouble(1, this.w_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.x_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeDouble(3, this.y_);
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeDouble(4, this.z_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LinearAlgebra.QuaternionProto, Builder>
      implements LinearAlgebra.QuaternionProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearW()
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).clearW();
        return this;
      }
      
      public Builder clearX()
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).clearX();
        return this;
      }
      
      public Builder clearY()
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).clearY();
        return this;
      }
      
      public Builder clearZ()
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).clearZ();
        return this;
      }
      
      public double getW()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).getW();
      }
      
      public double getX()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).getX();
      }
      
      public double getY()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).getY();
      }
      
      public double getZ()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).getZ();
      }
      
      public boolean hasW()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).hasW();
      }
      
      public boolean hasX()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).hasX();
      }
      
      public boolean hasY()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).hasY();
      }
      
      public boolean hasZ()
      {
        return ((LinearAlgebra.QuaternionProto)this.instance).hasZ();
      }
      
      public Builder setW(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).setW(paramDouble);
        return this;
      }
      
      public Builder setX(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).setX(paramDouble);
        return this;
      }
      
      public Builder setY(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).setY(paramDouble);
        return this;
      }
      
      public Builder setZ(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.QuaternionProto)this.instance).setZ(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface QuaternionProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getW();
    
    public abstract double getX();
    
    public abstract double getY();
    
    public abstract double getZ();
    
    public abstract boolean hasW();
    
    public abstract boolean hasX();
    
    public abstract boolean hasY();
    
    public abstract boolean hasZ();
  }
  
  public static final class TransformationProto
    extends GeneratedMessageLite<TransformationProto, Builder>
    implements LinearAlgebra.TransformationProtoOrBuilder
  {
    private static final TransformationProto DEFAULT_INSTANCE = new TransformationProto();
    private static volatile Parser<TransformationProto> PARSER;
    public static final int P_FIELD_NUMBER = 1;
    public static final int Q_FIELD_NUMBER = 2;
    private int bitField0_;
    private LinearAlgebra.Vector3Proto p_;
    private LinearAlgebra.QuaternionProto q_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearP()
    {
      this.p_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    private void clearQ()
    {
      this.q_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    public static TransformationProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeP(LinearAlgebra.Vector3Proto paramVector3Proto)
    {
      if ((this.p_ != null) && (this.p_ != LinearAlgebra.Vector3Proto.getDefaultInstance())) {}
      for (this.p_ = ((LinearAlgebra.Vector3Proto)((LinearAlgebra.Vector3Proto.Builder)LinearAlgebra.Vector3Proto.newBuilder(this.p_).mergeFrom(paramVector3Proto)).buildPartial());; this.p_ = paramVector3Proto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    private void mergeQ(LinearAlgebra.QuaternionProto paramQuaternionProto)
    {
      if ((this.q_ != null) && (this.q_ != LinearAlgebra.QuaternionProto.getDefaultInstance())) {}
      for (this.q_ = ((LinearAlgebra.QuaternionProto)((LinearAlgebra.QuaternionProto.Builder)LinearAlgebra.QuaternionProto.newBuilder(this.q_).mergeFrom(paramQuaternionProto)).buildPartial());; this.q_ = paramQuaternionProto)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TransformationProto paramTransformationProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTransformationProto);
    }
    
    public static TransformationProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TransformationProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TransformationProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TransformationProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TransformationProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static TransformationProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static TransformationProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static TransformationProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static TransformationProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TransformationProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TransformationProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static TransformationProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TransformationProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<TransformationProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setP(LinearAlgebra.Vector3Proto.Builder paramBuilder)
    {
      this.p_ = ((LinearAlgebra.Vector3Proto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setP(LinearAlgebra.Vector3Proto paramVector3Proto)
    {
      if (paramVector3Proto == null) {
        throw new NullPointerException();
      }
      this.p_ = paramVector3Proto;
      this.bitField0_ |= 0x1;
    }
    
    private void setQ(LinearAlgebra.QuaternionProto.Builder paramBuilder)
    {
      this.q_ = ((LinearAlgebra.QuaternionProto)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setQ(LinearAlgebra.QuaternionProto paramQuaternionProto)
    {
      if (paramQuaternionProto == null) {
        throw new NullPointerException();
      }
      this.q_ = paramQuaternionProto;
      this.bitField0_ |= 0x2;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 191	com/google/location/visualmapping/common/LinearAlgebra$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 197	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+157->165, 7:+423->431, 8:+427->435
      //   56: new 199	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 200	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
      //   67: dup
      //   68: invokespecial 33	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 35	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 203	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto$Builder:<init>	(Lcom/google/location/visualmapping/common/LinearAlgebra$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 205	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   105: aload_3
      //   106: getfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   109: invokeinterface 209 3 0
      //   114: checkcast 90	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
      //   117: putfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   120: aload_0
      //   121: aload_2
      //   122: aload_0
      //   123: getfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   126: aload_3
      //   127: getfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   130: invokeinterface 209 3 0
      //   135: checkcast 109	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto
      //   138: putfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   141: aload_0
      //   142: astore_1
      //   143: aload_2
      //   144: getstatic 215	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   147: if_acmpne -75 -> 72
      //   150: aload_0
      //   151: aload_0
      //   152: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   155: aload_3
      //   156: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   159: ior
      //   160: putfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
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
      //   228: invokevirtual 226	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   231: ifne -53 -> 178
      //   234: iconst_1
      //   235: istore 4
      //   237: goto -59 -> 178
      //   240: aconst_null
      //   241: astore_1
      //   242: aload_0
      //   243: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   246: iconst_1
      //   247: iand
      //   248: iconst_1
      //   249: if_icmpne +14 -> 263
      //   252: aload_0
      //   253: getfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   256: invokevirtual 227	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   259: checkcast 99	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder
      //   262: astore_1
      //   263: aload_0
      //   264: aload_2
      //   265: invokestatic 229	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:parser	()Lcom/google/protobuf/Parser;
      //   268: aload_3
      //   269: invokevirtual 233	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   272: checkcast 90	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
      //   275: putfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   278: aload_1
      //   279: ifnull +23 -> 302
      //   282: aload_1
      //   283: aload_0
      //   284: getfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   287: invokevirtual 103	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   290: pop
      //   291: aload_0
      //   292: aload_1
      //   293: invokevirtual 107	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   296: checkcast 90	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
      //   299: putfield 83	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:p_	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   302: aload_0
      //   303: aload_0
      //   304: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   307: iconst_1
      //   308: ior
      //   309: putfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
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
      //   335: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   338: iconst_2
      //   339: iand
      //   340: iconst_2
      //   341: if_icmpne +14 -> 355
      //   344: aload_0
      //   345: getfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   348: invokevirtual 243	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   351: checkcast 117	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto$Builder
      //   354: astore_1
      //   355: aload_0
      //   356: aload_2
      //   357: invokestatic 244	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto:parser	()Lcom/google/protobuf/Parser;
      //   360: aload_3
      //   361: invokevirtual 233	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   364: checkcast 109	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto
      //   367: putfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   370: aload_1
      //   371: ifnull +23 -> 394
      //   374: aload_1
      //   375: aload_0
      //   376: getfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   379: invokevirtual 118	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   382: pop
      //   383: aload_0
      //   384: aload_1
      //   385: invokevirtual 119	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   388: checkcast 109	com/google/location/visualmapping/common/LinearAlgebra$QuaternionProto
      //   391: putfield 87	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:q_	Lcom/google/location/visualmapping/common/LinearAlgebra$QuaternionProto;
      //   394: aload_0
      //   395: aload_0
      //   396: getfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
      //   399: iconst_2
      //   400: ior
      //   401: putfield 85	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:bitField0_	I
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
      //   431: getstatic 35	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   434: areturn
      //   435: getstatic 253	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:PARSER	Lcom/google/protobuf/Parser;
      //   438: ifnonnull +28 -> 466
      //   441: ldc 2
      //   443: monitorenter
      //   444: getstatic 253	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:PARSER	Lcom/google/protobuf/Parser;
      //   447: ifnonnull +16 -> 463
      //   450: new 255	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   453: dup
      //   454: getstatic 35	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$TransformationProto;
      //   457: invokespecial 258	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   460: putstatic 253	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:PARSER	Lcom/google/protobuf/Parser;
      //   463: ldc 2
      //   465: monitorexit
      //   466: getstatic 253	com/google/location/visualmapping/common/LinearAlgebra$TransformationProto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	485	0	this	TransformationProto
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
    
    public LinearAlgebra.Vector3Proto getP()
    {
      if (this.p_ == null) {
        return LinearAlgebra.Vector3Proto.getDefaultInstance();
      }
      return this.p_;
    }
    
    public LinearAlgebra.QuaternionProto getQ()
    {
      if (this.q_ == null) {
        return LinearAlgebra.QuaternionProto.getDefaultInstance();
      }
      return this.q_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeMessageSize(1, getP());
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(2, getQ());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasP()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasQ()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(1, getP());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, getQ());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LinearAlgebra.TransformationProto, Builder>
      implements LinearAlgebra.TransformationProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearP()
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).clearP();
        return this;
      }
      
      public Builder clearQ()
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).clearQ();
        return this;
      }
      
      public LinearAlgebra.Vector3Proto getP()
      {
        return ((LinearAlgebra.TransformationProto)this.instance).getP();
      }
      
      public LinearAlgebra.QuaternionProto getQ()
      {
        return ((LinearAlgebra.TransformationProto)this.instance).getQ();
      }
      
      public boolean hasP()
      {
        return ((LinearAlgebra.TransformationProto)this.instance).hasP();
      }
      
      public boolean hasQ()
      {
        return ((LinearAlgebra.TransformationProto)this.instance).hasQ();
      }
      
      public Builder mergeP(LinearAlgebra.Vector3Proto paramVector3Proto)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).mergeP(paramVector3Proto);
        return this;
      }
      
      public Builder mergeQ(LinearAlgebra.QuaternionProto paramQuaternionProto)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).mergeQ(paramQuaternionProto);
        return this;
      }
      
      public Builder setP(LinearAlgebra.Vector3Proto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).setP(paramBuilder);
        return this;
      }
      
      public Builder setP(LinearAlgebra.Vector3Proto paramVector3Proto)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).setP(paramVector3Proto);
        return this;
      }
      
      public Builder setQ(LinearAlgebra.QuaternionProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).setQ(paramBuilder);
        return this;
      }
      
      public Builder setQ(LinearAlgebra.QuaternionProto paramQuaternionProto)
      {
        copyOnWrite();
        ((LinearAlgebra.TransformationProto)this.instance).setQ(paramQuaternionProto);
        return this;
      }
    }
  }
  
  public static abstract interface TransformationProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract LinearAlgebra.Vector3Proto getP();
    
    public abstract LinearAlgebra.QuaternionProto getQ();
    
    public abstract boolean hasP();
    
    public abstract boolean hasQ();
  }
  
  public static final class Vector2Proto
    extends GeneratedMessageLite<Vector2Proto, Builder>
    implements LinearAlgebra.Vector2ProtoOrBuilder
  {
    private static final Vector2Proto DEFAULT_INSTANCE = new Vector2Proto();
    private static volatile Parser<Vector2Proto> PARSER;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private int bitField0_;
    private double x_;
    private double y_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearX()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.x_ = 0.0D;
    }
    
    private void clearY()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.y_ = 0.0D;
    }
    
    public static Vector2Proto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Vector2Proto paramVector2Proto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramVector2Proto);
    }
    
    public static Vector2Proto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Vector2Proto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Vector2Proto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector2Proto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector2Proto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static Vector2Proto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static Vector2Proto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static Vector2Proto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector2Proto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Vector2Proto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector2Proto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static Vector2Proto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Vector2Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<Vector2Proto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setX(double paramDouble)
    {
      this.bitField0_ |= 0x1;
      this.x_ = paramDouble;
    }
    
    private void setY(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.y_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 136	com/google/location/visualmapping/common/LinearAlgebra$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 142	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
      //   56: new 144	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 145	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto
      //   67: dup
      //   68: invokespecial 32	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector2Proto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 148	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto$Builder:<init>	(Lcom/google/location/visualmapping/common/LinearAlgebra$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 150	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 154	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:hasX	()Z
      //   105: aload_0
      //   106: getfield 64	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:x_	D
      //   109: aload_3
      //   110: invokevirtual 154	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:hasX	()Z
      //   113: aload_3
      //   114: getfield 64	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:x_	D
      //   117: invokeinterface 158 7 0
      //   122: putfield 64	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:x_	D
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 161	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:hasY	()Z
      //   131: aload_0
      //   132: getfield 66	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:y_	D
      //   135: aload_3
      //   136: invokevirtual 161	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:hasY	()Z
      //   139: aload_3
      //   140: getfield 66	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:y_	D
      //   143: invokeinterface 158 7 0
      //   148: putfield 66	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:y_	D
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 167	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   165: aload_3
      //   166: getfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   169: ior
      //   170: putfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
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
      //   240: invokevirtual 178	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 182	com/google/protobuf/CodedInputStream:readDouble	()D
      //   267: putfield 64	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:x_	D
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
      //   292: getfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   295: iconst_2
      //   296: ior
      //   297: putfield 62	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:bitField0_	I
      //   300: aload_0
      //   301: aload_1
      //   302: invokevirtual 182	com/google/protobuf/CodedInputStream:readDouble	()D
      //   305: putfield 66	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:y_	D
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
      //   335: getstatic 34	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector2Proto;
      //   338: areturn
      //   339: getstatic 200	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:PARSER	Lcom/google/protobuf/Parser;
      //   342: ifnonnull +28 -> 370
      //   345: ldc 2
      //   347: monitorenter
      //   348: getstatic 200	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:PARSER	Lcom/google/protobuf/Parser;
      //   351: ifnonnull +16 -> 367
      //   354: new 202	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   357: dup
      //   358: getstatic 34	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector2Proto;
      //   361: invokespecial 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   364: putstatic 200	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:PARSER	Lcom/google/protobuf/Parser;
      //   367: ldc 2
      //   369: monitorexit
      //   370: getstatic 200	com/google/location/visualmapping/common/LinearAlgebra$Vector2Proto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	389	0	this	Vector2Proto
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
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeDoubleSize(1, this.x_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeDoubleSize(2, this.y_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public double getX()
    {
      return this.x_;
    }
    
    public double getY()
    {
      return this.y_;
    }
    
    public boolean hasX()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasY()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeDouble(1, this.x_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.y_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LinearAlgebra.Vector2Proto, Builder>
      implements LinearAlgebra.Vector2ProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearX()
      {
        copyOnWrite();
        ((LinearAlgebra.Vector2Proto)this.instance).clearX();
        return this;
      }
      
      public Builder clearY()
      {
        copyOnWrite();
        ((LinearAlgebra.Vector2Proto)this.instance).clearY();
        return this;
      }
      
      public double getX()
      {
        return ((LinearAlgebra.Vector2Proto)this.instance).getX();
      }
      
      public double getY()
      {
        return ((LinearAlgebra.Vector2Proto)this.instance).getY();
      }
      
      public boolean hasX()
      {
        return ((LinearAlgebra.Vector2Proto)this.instance).hasX();
      }
      
      public boolean hasY()
      {
        return ((LinearAlgebra.Vector2Proto)this.instance).hasY();
      }
      
      public Builder setX(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.Vector2Proto)this.instance).setX(paramDouble);
        return this;
      }
      
      public Builder setY(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.Vector2Proto)this.instance).setY(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface Vector2ProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getX();
    
    public abstract double getY();
    
    public abstract boolean hasX();
    
    public abstract boolean hasY();
  }
  
  public static final class Vector3Proto
    extends GeneratedMessageLite<Vector3Proto, Builder>
    implements LinearAlgebra.Vector3ProtoOrBuilder
  {
    private static final Vector3Proto DEFAULT_INSTANCE = new Vector3Proto();
    private static volatile Parser<Vector3Proto> PARSER;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    public static final int Z_FIELD_NUMBER = 3;
    private int bitField0_;
    private double x_;
    private double y_;
    private double z_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearX()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.x_ = 0.0D;
    }
    
    private void clearY()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.y_ = 0.0D;
    }
    
    private void clearZ()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.z_ = 0.0D;
    }
    
    public static Vector3Proto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Vector3Proto paramVector3Proto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramVector3Proto);
    }
    
    public static Vector3Proto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Vector3Proto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Vector3Proto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector3Proto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector3Proto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static Vector3Proto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static Vector3Proto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static Vector3Proto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector3Proto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Vector3Proto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Vector3Proto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static Vector3Proto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Vector3Proto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<Vector3Proto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setX(double paramDouble)
    {
      this.bitField0_ |= 0x1;
      this.x_ = paramDouble;
    }
    
    private void setY(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.y_ = paramDouble;
    }
    
    private void setZ(double paramDouble)
    {
      this.bitField0_ |= 0x4;
      this.z_ = paramDouble;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 149	com/google/location/visualmapping/common/LinearAlgebra$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 155	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+193->201, 7:+380->388, 8:+384->392
      //   56: new 157	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 158	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
      //   67: dup
      //   68: invokespecial 35	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 37	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 161	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder:<init>	(Lcom/google/location/visualmapping/common/LinearAlgebra$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 163	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 167	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasX	()Z
      //   105: aload_0
      //   106: getfield 75	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:x_	D
      //   109: aload_3
      //   110: invokevirtual 167	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasX	()Z
      //   113: aload_3
      //   114: getfield 75	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:x_	D
      //   117: invokeinterface 171 7 0
      //   122: putfield 75	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:x_	D
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 174	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasY	()Z
      //   131: aload_0
      //   132: getfield 77	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:y_	D
      //   135: aload_3
      //   136: invokevirtual 174	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasY	()Z
      //   139: aload_3
      //   140: getfield 77	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:y_	D
      //   143: invokeinterface 171 7 0
      //   148: putfield 77	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:y_	D
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 177	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasZ	()Z
      //   157: aload_0
      //   158: getfield 79	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:z_	D
      //   161: aload_3
      //   162: invokevirtual 177	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:hasZ	()Z
      //   165: aload_3
      //   166: getfield 79	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:z_	D
      //   169: invokeinterface 171 7 0
      //   174: putfield 79	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:z_	D
      //   177: aload_0
      //   178: astore_1
      //   179: aload_2
      //   180: getstatic 183	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   183: if_acmpne -111 -> 72
      //   186: aload_0
      //   187: aload_0
      //   188: getfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   191: aload_3
      //   192: getfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   195: ior
      //   196: putfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
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
      //   272: invokevirtual 194	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   275: ifne -61 -> 214
      //   278: iconst_1
      //   279: istore 4
      //   281: goto -67 -> 214
      //   284: aload_0
      //   285: aload_0
      //   286: getfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   289: iconst_1
      //   290: ior
      //   291: putfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   294: aload_0
      //   295: aload_1
      //   296: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   299: putfield 75	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:x_	D
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
      //   324: getfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   327: iconst_2
      //   328: ior
      //   329: putfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   332: aload_0
      //   333: aload_1
      //   334: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   337: putfield 77	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:y_	D
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
      //   369: getfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   372: iconst_4
      //   373: ior
      //   374: putfield 73	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:bitField0_	I
      //   377: aload_0
      //   378: aload_1
      //   379: invokevirtual 198	com/google/protobuf/CodedInputStream:readDouble	()D
      //   382: putfield 79	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:z_	D
      //   385: goto -171 -> 214
      //   388: getstatic 37	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   391: areturn
      //   392: getstatic 216	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:PARSER	Lcom/google/protobuf/Parser;
      //   395: ifnonnull +28 -> 423
      //   398: ldc 2
      //   400: monitorenter
      //   401: getstatic 216	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:PARSER	Lcom/google/protobuf/Parser;
      //   404: ifnonnull +16 -> 420
      //   407: new 218	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   410: dup
      //   411: getstatic 37	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LinearAlgebra$Vector3Proto;
      //   414: invokespecial 221	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   417: putstatic 216	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:PARSER	Lcom/google/protobuf/Parser;
      //   420: ldc 2
      //   422: monitorexit
      //   423: getstatic 216	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	442	0	this	Vector3Proto
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
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeDoubleSize(1, this.x_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeDoubleSize(2, this.y_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeDoubleSize(3, this.z_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public double getX()
    {
      return this.x_;
    }
    
    public double getY()
    {
      return this.y_;
    }
    
    public double getZ()
    {
      return this.z_;
    }
    
    public boolean hasX()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasY()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasZ()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeDouble(1, this.x_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.y_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeDouble(3, this.z_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LinearAlgebra.Vector3Proto, Builder>
      implements LinearAlgebra.Vector3ProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearX()
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).clearX();
        return this;
      }
      
      public Builder clearY()
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).clearY();
        return this;
      }
      
      public Builder clearZ()
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).clearZ();
        return this;
      }
      
      public double getX()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).getX();
      }
      
      public double getY()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).getY();
      }
      
      public double getZ()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).getZ();
      }
      
      public boolean hasX()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).hasX();
      }
      
      public boolean hasY()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).hasY();
      }
      
      public boolean hasZ()
      {
        return ((LinearAlgebra.Vector3Proto)this.instance).hasZ();
      }
      
      public Builder setX(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).setX(paramDouble);
        return this;
      }
      
      public Builder setY(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).setY(paramDouble);
        return this;
      }
      
      public Builder setZ(double paramDouble)
      {
        copyOnWrite();
        ((LinearAlgebra.Vector3Proto)this.instance).setZ(paramDouble);
        return this;
      }
    }
  }
  
  public static abstract interface Vector3ProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getX();
    
    public abstract double getY();
    
    public abstract double getZ();
    
    public abstract boolean hasX();
    
    public abstract boolean hasY();
    
    public abstract boolean hasZ();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/common/LinearAlgebra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */