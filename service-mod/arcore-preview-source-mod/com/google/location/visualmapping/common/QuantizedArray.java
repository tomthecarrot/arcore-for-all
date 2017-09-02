package com.google.location.visualmapping.common;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.LongList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class QuantizedArray
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class QuantizedArrayProto
    extends GeneratedMessageLite<QuantizedArrayProto, Builder>
    implements QuantizedArray.QuantizedArrayProtoOrBuilder
  {
    private static final QuantizedArrayProto DEFAULT_INSTANCE = new QuantizedArrayProto();
    public static final int MAX_ORIGINAL_VALUE_FIELD_NUMBER = 3;
    public static final int MIN_ORIGINAL_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<QuantizedArrayProto> PARSER;
    public static final int QUANTIZATION_BITS_FIELD_NUMBER = 1;
    public static final int QUANTIZED_VALUES_FIELD_NUMBER = 4;
    private int bitField0_;
    private double maxOriginalValue_;
    private double minOriginalValue_;
    private int quantizationBits_;
    private int quantizedValuesMemoizedSerializedSize = -1;
    private Internal.LongList quantizedValues_ = emptyLongList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllQuantizedValues(Iterable<? extends Long> paramIterable)
    {
      ensureQuantizedValuesIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.quantizedValues_);
    }
    
    private void addQuantizedValues(long paramLong)
    {
      ensureQuantizedValuesIsMutable();
      this.quantizedValues_.addLong(paramLong);
    }
    
    private void clearMaxOriginalValue()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.maxOriginalValue_ = 0.0D;
    }
    
    private void clearMinOriginalValue()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.minOriginalValue_ = 0.0D;
    }
    
    private void clearQuantizationBits()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.quantizationBits_ = 0;
    }
    
    private void clearQuantizedValues()
    {
      this.quantizedValues_ = emptyLongList();
    }
    
    private void ensureQuantizedValuesIsMutable()
    {
      if (!this.quantizedValues_.isModifiable()) {
        this.quantizedValues_ = GeneratedMessageLite.mutableCopy(this.quantizedValues_);
      }
    }
    
    public static QuantizedArrayProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(QuantizedArrayProto paramQuantizedArrayProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuantizedArrayProto);
    }
    
    public static QuantizedArrayProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (QuantizedArrayProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static QuantizedArrayProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuantizedArrayProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static QuantizedArrayProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static QuantizedArrayProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static QuantizedArrayProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static QuantizedArrayProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static QuantizedArrayProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static QuantizedArrayProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static QuantizedArrayProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static QuantizedArrayProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (QuantizedArrayProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<QuantizedArrayProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMaxOriginalValue(double paramDouble)
    {
      this.bitField0_ |= 0x4;
      this.maxOriginalValue_ = paramDouble;
    }
    
    private void setMinOriginalValue(double paramDouble)
    {
      this.bitField0_ |= 0x2;
      this.minOriginalValue_ = paramDouble;
    }
    
    private void setQuantizationBits(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.quantizationBits_ = paramInt;
    }
    
    private void setQuantizedValues(int paramInt, long paramLong)
    {
      ensureQuantizedValuesIsMutable();
      this.quantizedValues_.setLong(paramInt, paramLong);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 213	com/google/location/visualmapping/common/QuantizedArray$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 219	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+220->228, 7:+535->543, 8:+539->547
      //   56: new 221	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 222	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   67: dup
      //   68: invokespecial 40	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 42	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   82: invokeinterface 223 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 226	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto$Builder:<init>	(Lcom/google/location/visualmapping/common/QuantizedArray$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 228	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 231	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasQuantizationBits	()Z
      //   114: aload_0
      //   115: getfield 132	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizationBits_	I
      //   118: aload_3
      //   119: invokevirtual 231	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasQuantizationBits	()Z
      //   122: aload_3
      //   123: getfield 132	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizationBits_	I
      //   126: invokeinterface 235 5 0
      //   131: putfield 132	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizationBits_	I
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: invokevirtual 238	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasMinOriginalValue	()Z
      //   140: aload_0
      //   141: getfield 130	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:minOriginalValue_	D
      //   144: aload_3
      //   145: invokevirtual 238	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasMinOriginalValue	()Z
      //   148: aload_3
      //   149: getfield 130	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:minOriginalValue_	D
      //   152: invokeinterface 242 7 0
      //   157: putfield 130	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:minOriginalValue_	D
      //   160: aload_0
      //   161: aload_2
      //   162: aload_0
      //   163: invokevirtual 245	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasMaxOriginalValue	()Z
      //   166: aload_0
      //   167: getfield 128	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:maxOriginalValue_	D
      //   170: aload_3
      //   171: invokevirtual 245	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:hasMaxOriginalValue	()Z
      //   174: aload_3
      //   175: getfield 128	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:maxOriginalValue_	D
      //   178: invokeinterface 242 7 0
      //   183: putfield 128	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:maxOriginalValue_	D
      //   186: aload_0
      //   187: aload_2
      //   188: aload_0
      //   189: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   192: aload_3
      //   193: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   196: invokeinterface 249 3 0
      //   201: putfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   204: aload_0
      //   205: astore_1
      //   206: aload_2
      //   207: getstatic 255	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   210: if_acmpne -138 -> 72
      //   213: aload_0
      //   214: aload_0
      //   215: getfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   218: aload_3
      //   219: getfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   222: ior
      //   223: putfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   226: aload_0
      //   227: areturn
      //   228: aload_2
      //   229: checkcast 257	com/google/protobuf/CodedInputStream
      //   232: astore_1
      //   233: aload_3
      //   234: checkcast 259	com/google/protobuf/ExtensionRegistryLite
      //   237: astore_2
      //   238: iconst_0
      //   239: istore 4
      //   241: iload 4
      //   243: ifne +300 -> 543
      //   246: aload_1
      //   247: invokevirtual 262	com/google/protobuf/CodedInputStream:readTag	()I
      //   250: istore 5
      //   252: iload 5
      //   254: lookupswitch	default:+334->588, 0:+337->591, 8:+74->328, 17:+112->366, 25:+157->411, 32:+178->432, 34:+217->471
      //   312: aload_0
      //   313: iload 5
      //   315: aload_1
      //   316: invokevirtual 266	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   319: ifne -78 -> 241
      //   322: iconst_1
      //   323: istore 4
      //   325: goto -84 -> 241
      //   328: aload_0
      //   329: aload_0
      //   330: getfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   333: iconst_1
      //   334: ior
      //   335: putfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   338: aload_0
      //   339: aload_1
      //   340: invokevirtual 269	com/google/protobuf/CodedInputStream:readInt32	()I
      //   343: putfield 132	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizationBits_	I
      //   346: goto -105 -> 241
      //   349: astore_1
      //   350: new 271	java/lang/RuntimeException
      //   353: dup
      //   354: aload_1
      //   355: aload_0
      //   356: invokevirtual 275	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   359: invokespecial 278	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   362: athrow
      //   363: astore_1
      //   364: aload_1
      //   365: athrow
      //   366: aload_0
      //   367: aload_0
      //   368: getfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   371: iconst_2
      //   372: ior
      //   373: putfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   376: aload_0
      //   377: aload_1
      //   378: invokevirtual 282	com/google/protobuf/CodedInputStream:readDouble	()D
      //   381: putfield 130	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:minOriginalValue_	D
      //   384: goto -143 -> 241
      //   387: astore_1
      //   388: new 271	java/lang/RuntimeException
      //   391: dup
      //   392: new 168	com/google/protobuf/InvalidProtocolBufferException
      //   395: dup
      //   396: aload_1
      //   397: invokevirtual 286	java/io/IOException:getMessage	()Ljava/lang/String;
      //   400: invokespecial 289	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   403: aload_0
      //   404: invokevirtual 275	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   407: invokespecial 278	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   410: athrow
      //   411: aload_0
      //   412: aload_0
      //   413: getfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   416: iconst_4
      //   417: ior
      //   418: putfield 126	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:bitField0_	I
      //   421: aload_0
      //   422: aload_1
      //   423: invokevirtual 282	com/google/protobuf/CodedInputStream:readDouble	()D
      //   426: putfield 128	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:maxOriginalValue_	D
      //   429: goto -188 -> 241
      //   432: aload_0
      //   433: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   436: invokeinterface 136 1 0
      //   441: ifne +14 -> 455
      //   444: aload_0
      //   445: aload_0
      //   446: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   449: invokestatic 140	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   452: putfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   455: aload_0
      //   456: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   459: aload_1
      //   460: invokevirtual 293	com/google/protobuf/CodedInputStream:readUInt64	()J
      //   463: invokeinterface 124 3 0
      //   468: goto -227 -> 241
      //   471: aload_1
      //   472: aload_1
      //   473: invokevirtual 296	com/google/protobuf/CodedInputStream:readRawVarint32	()I
      //   476: invokevirtual 300	com/google/protobuf/CodedInputStream:pushLimit	(I)I
      //   479: istore 5
      //   481: aload_0
      //   482: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   485: invokeinterface 136 1 0
      //   490: ifne +21 -> 511
      //   493: aload_1
      //   494: invokevirtual 303	com/google/protobuf/CodedInputStream:getBytesUntilLimit	()I
      //   497: ifle +14 -> 511
      //   500: aload_0
      //   501: aload_0
      //   502: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   505: invokestatic 140	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   508: putfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   511: aload_1
      //   512: invokevirtual 303	com/google/protobuf/CodedInputStream:getBytesUntilLimit	()I
      //   515: ifle +19 -> 534
      //   518: aload_0
      //   519: getfield 55	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:quantizedValues_	Lcom/google/protobuf/Internal$LongList;
      //   522: aload_1
      //   523: invokevirtual 293	com/google/protobuf/CodedInputStream:readUInt64	()J
      //   526: invokeinterface 124 3 0
      //   531: goto -20 -> 511
      //   534: aload_1
      //   535: iload 5
      //   537: invokevirtual 306	com/google/protobuf/CodedInputStream:popLimit	(I)V
      //   540: goto -299 -> 241
      //   543: getstatic 42	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   546: areturn
      //   547: getstatic 308	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:PARSER	Lcom/google/protobuf/Parser;
      //   550: ifnonnull +28 -> 578
      //   553: ldc 2
      //   555: monitorenter
      //   556: getstatic 308	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:PARSER	Lcom/google/protobuf/Parser;
      //   559: ifnonnull +16 -> 575
      //   562: new 310	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   565: dup
      //   566: getstatic 42	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto;
      //   569: invokespecial 313	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   572: putstatic 308	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:PARSER	Lcom/google/protobuf/Parser;
      //   575: ldc 2
      //   577: monitorexit
      //   578: getstatic 308	com/google/location/visualmapping/common/QuantizedArray$QuantizedArrayProto:PARSER	Lcom/google/protobuf/Parser;
      //   581: areturn
      //   582: astore_1
      //   583: ldc 2
      //   585: monitorexit
      //   586: aload_1
      //   587: athrow
      //   588: goto -276 -> 312
      //   591: iconst_1
      //   592: istore 4
      //   594: goto -353 -> 241
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	597	0	this	QuantizedArrayProto
      //   0	597	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	597	2	paramObject1	Object
      //   0	597	3	paramObject2	Object
      //   239	354	4	i	int
      //   250	286	5	j	int
      // Exception table:
      //   from	to	target	type
      //   246	252	349	com/google/protobuf/InvalidProtocolBufferException
      //   312	322	349	com/google/protobuf/InvalidProtocolBufferException
      //   328	346	349	com/google/protobuf/InvalidProtocolBufferException
      //   366	384	349	com/google/protobuf/InvalidProtocolBufferException
      //   411	429	349	com/google/protobuf/InvalidProtocolBufferException
      //   432	455	349	com/google/protobuf/InvalidProtocolBufferException
      //   455	468	349	com/google/protobuf/InvalidProtocolBufferException
      //   471	511	349	com/google/protobuf/InvalidProtocolBufferException
      //   511	531	349	com/google/protobuf/InvalidProtocolBufferException
      //   534	540	349	com/google/protobuf/InvalidProtocolBufferException
      //   246	252	363	finally
      //   312	322	363	finally
      //   328	346	363	finally
      //   350	363	363	finally
      //   366	384	363	finally
      //   388	411	363	finally
      //   411	429	363	finally
      //   432	455	363	finally
      //   455	468	363	finally
      //   471	511	363	finally
      //   511	531	363	finally
      //   534	540	363	finally
      //   246	252	387	java/io/IOException
      //   312	322	387	java/io/IOException
      //   328	346	387	java/io/IOException
      //   366	384	387	java/io/IOException
      //   411	429	387	java/io/IOException
      //   432	455	387	java/io/IOException
      //   455	468	387	java/io/IOException
      //   471	511	387	java/io/IOException
      //   511	531	387	java/io/IOException
      //   534	540	387	java/io/IOException
      //   556	575	582	finally
      //   575	578	582	finally
      //   583	586	582	finally
    }
    
    public double getMaxOriginalValue()
    {
      return this.maxOriginalValue_;
    }
    
    public double getMinOriginalValue()
    {
      return this.minOriginalValue_;
    }
    
    public int getQuantizationBits()
    {
      return this.quantizationBits_;
    }
    
    public long getQuantizedValues(int paramInt)
    {
      return this.quantizedValues_.getLong(paramInt);
    }
    
    public int getQuantizedValuesCount()
    {
      return this.quantizedValues_.size();
    }
    
    public List<Long> getQuantizedValuesList()
    {
      return this.quantizedValues_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeInt32Size(1, this.quantizationBits_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeDoubleSize(2, this.minOriginalValue_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeDoubleSize(3, this.maxOriginalValue_);
      }
      i = 0;
      int k = 0;
      while (k < this.quantizedValues_.size())
      {
        i += CodedOutputStream.computeUInt64SizeNoTag(this.quantizedValues_.getLong(k));
        k += 1;
      }
      k = j + i;
      j = k;
      if (!getQuantizedValuesList().isEmpty()) {
        j = k + 1 + CodedOutputStream.computeInt32SizeNoTag(i);
      }
      this.quantizedValuesMemoizedSerializedSize = i;
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasMaxOriginalValue()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasMinOriginalValue()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasQuantizationBits()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      getSerializedSize();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt32(1, this.quantizationBits_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeDouble(2, this.minOriginalValue_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeDouble(3, this.maxOriginalValue_);
      }
      if (getQuantizedValuesList().size() > 0)
      {
        paramCodedOutputStream.writeUInt32NoTag(34);
        paramCodedOutputStream.writeUInt32NoTag(this.quantizedValuesMemoizedSerializedSize);
      }
      int i = 0;
      while (i < this.quantizedValues_.size())
      {
        paramCodedOutputStream.writeUInt64NoTag(this.quantizedValues_.getLong(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<QuantizedArray.QuantizedArrayProto, Builder>
      implements QuantizedArray.QuantizedArrayProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllQuantizedValues(Iterable<? extends Long> paramIterable)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).addAllQuantizedValues(paramIterable);
        return this;
      }
      
      public Builder addQuantizedValues(long paramLong)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).addQuantizedValues(paramLong);
        return this;
      }
      
      public Builder clearMaxOriginalValue()
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).clearMaxOriginalValue();
        return this;
      }
      
      public Builder clearMinOriginalValue()
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).clearMinOriginalValue();
        return this;
      }
      
      public Builder clearQuantizationBits()
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).clearQuantizationBits();
        return this;
      }
      
      public Builder clearQuantizedValues()
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).clearQuantizedValues();
        return this;
      }
      
      public double getMaxOriginalValue()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).getMaxOriginalValue();
      }
      
      public double getMinOriginalValue()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).getMinOriginalValue();
      }
      
      public int getQuantizationBits()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).getQuantizationBits();
      }
      
      public long getQuantizedValues(int paramInt)
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).getQuantizedValues(paramInt);
      }
      
      public int getQuantizedValuesCount()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).getQuantizedValuesCount();
      }
      
      public List<Long> getQuantizedValuesList()
      {
        return Collections.unmodifiableList(((QuantizedArray.QuantizedArrayProto)this.instance).getQuantizedValuesList());
      }
      
      public boolean hasMaxOriginalValue()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).hasMaxOriginalValue();
      }
      
      public boolean hasMinOriginalValue()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).hasMinOriginalValue();
      }
      
      public boolean hasQuantizationBits()
      {
        return ((QuantizedArray.QuantizedArrayProto)this.instance).hasQuantizationBits();
      }
      
      public Builder setMaxOriginalValue(double paramDouble)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).setMaxOriginalValue(paramDouble);
        return this;
      }
      
      public Builder setMinOriginalValue(double paramDouble)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).setMinOriginalValue(paramDouble);
        return this;
      }
      
      public Builder setQuantizationBits(int paramInt)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).setQuantizationBits(paramInt);
        return this;
      }
      
      public Builder setQuantizedValues(int paramInt, long paramLong)
      {
        copyOnWrite();
        ((QuantizedArray.QuantizedArrayProto)this.instance).setQuantizedValues(paramInt, paramLong);
        return this;
      }
    }
  }
  
  public static abstract interface QuantizedArrayProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract double getMaxOriginalValue();
    
    public abstract double getMinOriginalValue();
    
    public abstract int getQuantizationBits();
    
    public abstract long getQuantizedValues(int paramInt);
    
    public abstract int getQuantizedValuesCount();
    
    public abstract List<Long> getQuantizedValuesList();
    
    public abstract boolean hasMaxOriginalValue();
    
    public abstract boolean hasMinOriginalValue();
    
    public abstract boolean hasQuantizationBits();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/common/QuantizedArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */