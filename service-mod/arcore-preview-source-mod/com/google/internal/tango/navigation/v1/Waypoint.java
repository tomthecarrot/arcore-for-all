package com.google.internal.tango.navigation.v1;

import com.google.location.visualmapping.common.LinearAlgebra.Vector3Proto;
import com.google.location.visualmapping.common.LinearAlgebra.Vector3Proto.Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Waypoint
  extends GeneratedMessageLite<Waypoint, Builder>
  implements WaypointOrBuilder
{
  private static final Waypoint DEFAULT_INSTANCE = new Waypoint();
  public static final int ECEF_P_FIELD_NUMBER = 1;
  public static final int FOI_ID_FIELD_NUMBER = 2;
  private static volatile Parser<Waypoint> PARSER;
  private int positionCase_ = 0;
  private Object position_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearEcefP()
  {
    if (this.positionCase_ == 1)
    {
      this.positionCase_ = 0;
      this.position_ = null;
    }
  }
  
  private void clearFoiId()
  {
    if (this.positionCase_ == 2)
    {
      this.positionCase_ = 0;
      this.position_ = null;
    }
  }
  
  private void clearPosition()
  {
    this.positionCase_ = 0;
    this.position_ = null;
  }
  
  public static Waypoint getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeEcefP(LinearAlgebra.Vector3Proto paramVector3Proto)
  {
    if ((this.positionCase_ == 1) && (this.position_ != LinearAlgebra.Vector3Proto.getDefaultInstance())) {}
    for (this.position_ = ((LinearAlgebra.Vector3Proto.Builder)LinearAlgebra.Vector3Proto.newBuilder((LinearAlgebra.Vector3Proto)this.position_).mergeFrom(paramVector3Proto)).buildPartial();; this.position_ = paramVector3Proto)
    {
      this.positionCase_ = 1;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Waypoint paramWaypoint)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWaypoint);
  }
  
  public static Waypoint parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Waypoint)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Waypoint parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Waypoint)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Waypoint parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Waypoint parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Waypoint parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Waypoint parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Waypoint parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Waypoint parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Waypoint parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Waypoint parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Waypoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Waypoint> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setEcefP(LinearAlgebra.Vector3Proto.Builder paramBuilder)
  {
    this.position_ = paramBuilder.build();
    this.positionCase_ = 1;
  }
  
  private void setEcefP(LinearAlgebra.Vector3Proto paramVector3Proto)
  {
    if (paramVector3Proto == null) {
      throw new NullPointerException();
    }
    this.position_ = paramVector3Proto;
    this.positionCase_ = 1;
  }
  
  private void setFoiId(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.positionCase_ = 2;
    this.position_ = paramString;
  }
  
  private void setFoiIdBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    checkByteStringIsUtf8(paramByteString);
    this.positionCase_ = 2;
    this.position_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 184	com/google/internal/tango/navigation/v1/Waypoint$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 190	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+263->271, 7:+466->474, 8:+470->478
    //   56: new 192	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 193	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/navigation/v1/Waypoint
    //   67: dup
    //   68: invokespecial 33	com/google/internal/tango/navigation/v1/Waypoint:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 35	com/google/internal/tango/navigation/v1/Waypoint:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/internal/tango/navigation/v1/Waypoint$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 196	com/google/internal/tango/navigation/v1/Waypoint$Builder:<init>	(Lcom/google/internal/tango/navigation/v1/Waypoint$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 198	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/internal/tango/navigation/v1/Waypoint
    //   98: astore_3
    //   99: getstatic 201	com/google/internal/tango/navigation/v1/Waypoint$1:$SwitchMap$com$google$internal$tango$navigation$v1$Waypoint$PositionCase	[I
    //   102: aload_3
    //   103: invokevirtual 205	com/google/internal/tango/navigation/v1/Waypoint:getPositionCase	()Lcom/google/internal/tango/navigation/v1/Waypoint$PositionCase;
    //   106: invokevirtual 206	com/google/internal/tango/navigation/v1/Waypoint$PositionCase:ordinal	()I
    //   109: iaload
    //   110: tableswitch	default:+26->136, 1:+54->164, 2:+94->204, 3:+134->244
    //   136: aload_0
    //   137: astore_1
    //   138: aload_2
    //   139: getstatic 212	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   142: if_acmpne -70 -> 72
    //   145: aload_0
    //   146: astore_1
    //   147: aload_3
    //   148: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   151: ifeq -79 -> 72
    //   154: aload_0
    //   155: aload_3
    //   156: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   159: putfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   162: aload_0
    //   163: areturn
    //   164: aload_0
    //   165: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   168: iconst_1
    //   169: if_icmpne +29 -> 198
    //   172: iconst_1
    //   173: istore 6
    //   175: aload_0
    //   176: aload_2
    //   177: iload 6
    //   179: aload_0
    //   180: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   183: aload_3
    //   184: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   187: invokeinterface 216 4 0
    //   192: putfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   195: goto -59 -> 136
    //   198: iconst_0
    //   199: istore 6
    //   201: goto -26 -> 175
    //   204: aload_0
    //   205: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   208: iconst_2
    //   209: if_icmpne +29 -> 238
    //   212: iconst_1
    //   213: istore 6
    //   215: aload_0
    //   216: aload_2
    //   217: iload 6
    //   219: aload_0
    //   220: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   223: aload_3
    //   224: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   227: invokeinterface 219 4 0
    //   232: putfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   235: goto -99 -> 136
    //   238: iconst_0
    //   239: istore 6
    //   241: goto -26 -> 215
    //   244: aload_0
    //   245: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   248: ifeq +17 -> 265
    //   251: iconst_1
    //   252: istore 6
    //   254: aload_2
    //   255: iload 6
    //   257: invokeinterface 223 2 0
    //   262: goto -126 -> 136
    //   265: iconst_0
    //   266: istore 6
    //   268: goto -14 -> 254
    //   271: aload_2
    //   272: checkcast 225	com/google/protobuf/CodedInputStream
    //   275: astore_2
    //   276: aload_3
    //   277: checkcast 227	com/google/protobuf/ExtensionRegistryLite
    //   280: astore_3
    //   281: iconst_0
    //   282: istore 4
    //   284: iload 4
    //   286: ifne +188 -> 474
    //   289: aload_2
    //   290: invokevirtual 230	com/google/protobuf/CodedInputStream:readTag	()I
    //   293: istore 5
    //   295: iload 5
    //   297: lookupswitch	default:+222->519, 0:+225->522, 10:+50->347, 18:+135->432
    //   332: aload_2
    //   333: iload 5
    //   335: invokevirtual 234	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   338: ifne -54 -> 284
    //   341: iconst_1
    //   342: istore 4
    //   344: goto -60 -> 284
    //   347: aconst_null
    //   348: astore_1
    //   349: aload_0
    //   350: getfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   353: iconst_1
    //   354: if_icmpne +17 -> 371
    //   357: aload_0
    //   358: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   361: checkcast 89	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
    //   364: invokevirtual 235	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   367: checkcast 98	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder
    //   370: astore_1
    //   371: aload_0
    //   372: aload_2
    //   373: invokestatic 237	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto:parser	()Lcom/google/protobuf/Parser;
    //   376: aload_3
    //   377: invokevirtual 241	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   380: putfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   383: aload_1
    //   384: ifnull +23 -> 407
    //   387: aload_1
    //   388: aload_0
    //   389: getfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   392: checkcast 89	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto
    //   395: invokevirtual 102	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   398: pop
    //   399: aload_0
    //   400: aload_1
    //   401: invokevirtual 106	com/google/location/visualmapping/common/LinearAlgebra$Vector3Proto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   404: putfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   407: aload_0
    //   408: iconst_1
    //   409: putfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   412: goto -128 -> 284
    //   415: astore_1
    //   416: new 243	java/lang/RuntimeException
    //   419: dup
    //   420: aload_1
    //   421: aload_0
    //   422: invokevirtual 247	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   425: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   428: athrow
    //   429: astore_1
    //   430: aload_1
    //   431: athrow
    //   432: aload_2
    //   433: invokevirtual 253	com/google/protobuf/CodedInputStream:readStringRequireUtf8	()Ljava/lang/String;
    //   436: astore_1
    //   437: aload_0
    //   438: iconst_2
    //   439: putfield 42	com/google/internal/tango/navigation/v1/Waypoint:positionCase_	I
    //   442: aload_0
    //   443: aload_1
    //   444: putfield 86	com/google/internal/tango/navigation/v1/Waypoint:position_	Ljava/lang/Object;
    //   447: goto -163 -> 284
    //   450: astore_1
    //   451: new 243	java/lang/RuntimeException
    //   454: dup
    //   455: new 129	com/google/protobuf/InvalidProtocolBufferException
    //   458: dup
    //   459: aload_1
    //   460: invokevirtual 256	java/io/IOException:getMessage	()Ljava/lang/String;
    //   463: invokespecial 258	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   466: aload_0
    //   467: invokevirtual 247	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   470: invokespecial 250	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   473: athrow
    //   474: getstatic 35	com/google/internal/tango/navigation/v1/Waypoint:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   477: areturn
    //   478: getstatic 260	com/google/internal/tango/navigation/v1/Waypoint:PARSER	Lcom/google/protobuf/Parser;
    //   481: ifnonnull +28 -> 509
    //   484: ldc 2
    //   486: monitorenter
    //   487: getstatic 260	com/google/internal/tango/navigation/v1/Waypoint:PARSER	Lcom/google/protobuf/Parser;
    //   490: ifnonnull +16 -> 506
    //   493: new 262	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   496: dup
    //   497: getstatic 35	com/google/internal/tango/navigation/v1/Waypoint:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   500: invokespecial 265	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   503: putstatic 260	com/google/internal/tango/navigation/v1/Waypoint:PARSER	Lcom/google/protobuf/Parser;
    //   506: ldc 2
    //   508: monitorexit
    //   509: getstatic 260	com/google/internal/tango/navigation/v1/Waypoint:PARSER	Lcom/google/protobuf/Parser;
    //   512: areturn
    //   513: astore_1
    //   514: ldc 2
    //   516: monitorexit
    //   517: aload_1
    //   518: athrow
    //   519: goto -187 -> 332
    //   522: iconst_1
    //   523: istore 4
    //   525: goto -241 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	Waypoint
    //   0	528	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	528	2	paramObject1	Object
    //   0	528	3	paramObject2	Object
    //   282	242	4	i	int
    //   293	41	5	j	int
    //   173	94	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   289	295	415	com/google/protobuf/InvalidProtocolBufferException
    //   332	341	415	com/google/protobuf/InvalidProtocolBufferException
    //   349	371	415	com/google/protobuf/InvalidProtocolBufferException
    //   371	383	415	com/google/protobuf/InvalidProtocolBufferException
    //   387	407	415	com/google/protobuf/InvalidProtocolBufferException
    //   407	412	415	com/google/protobuf/InvalidProtocolBufferException
    //   432	447	415	com/google/protobuf/InvalidProtocolBufferException
    //   289	295	429	finally
    //   332	341	429	finally
    //   349	371	429	finally
    //   371	383	429	finally
    //   387	407	429	finally
    //   407	412	429	finally
    //   416	429	429	finally
    //   432	447	429	finally
    //   451	474	429	finally
    //   289	295	450	java/io/IOException
    //   332	341	450	java/io/IOException
    //   349	371	450	java/io/IOException
    //   371	383	450	java/io/IOException
    //   387	407	450	java/io/IOException
    //   407	412	450	java/io/IOException
    //   432	447	450	java/io/IOException
    //   487	506	513	finally
    //   506	509	513	finally
    //   514	517	513	finally
  }
  
  public LinearAlgebra.Vector3Proto getEcefP()
  {
    if (this.positionCase_ == 1) {
      return (LinearAlgebra.Vector3Proto)this.position_;
    }
    return LinearAlgebra.Vector3Proto.getDefaultInstance();
  }
  
  public String getFoiId()
  {
    String str = "";
    if (this.positionCase_ == 2) {
      str = (String)this.position_;
    }
    return str;
  }
  
  public ByteString getFoiIdBytes()
  {
    String str = "";
    if (this.positionCase_ == 2) {
      str = (String)this.position_;
    }
    return ByteString.copyFromUtf8(str);
  }
  
  public PositionCase getPositionCase()
  {
    return PositionCase.forNumber(this.positionCase_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (this.positionCase_ == 1) {
      i = 0 + CodedOutputStream.computeMessageSize(1, (LinearAlgebra.Vector3Proto)this.position_);
    }
    int j = i;
    if (this.positionCase_ == 2) {
      j = i + CodedOutputStream.computeStringSize(2, getFoiId());
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.positionCase_ == 1) {
      paramCodedOutputStream.writeMessage(1, (LinearAlgebra.Vector3Proto)this.position_);
    }
    if (this.positionCase_ == 2) {
      paramCodedOutputStream.writeString(2, getFoiId());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Waypoint, Builder>
    implements WaypointOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearEcefP()
    {
      copyOnWrite();
      ((Waypoint)this.instance).clearEcefP();
      return this;
    }
    
    public Builder clearFoiId()
    {
      copyOnWrite();
      ((Waypoint)this.instance).clearFoiId();
      return this;
    }
    
    public Builder clearPosition()
    {
      copyOnWrite();
      ((Waypoint)this.instance).clearPosition();
      return this;
    }
    
    public LinearAlgebra.Vector3Proto getEcefP()
    {
      return ((Waypoint)this.instance).getEcefP();
    }
    
    public String getFoiId()
    {
      return ((Waypoint)this.instance).getFoiId();
    }
    
    public ByteString getFoiIdBytes()
    {
      return ((Waypoint)this.instance).getFoiIdBytes();
    }
    
    public Waypoint.PositionCase getPositionCase()
    {
      return ((Waypoint)this.instance).getPositionCase();
    }
    
    public Builder mergeEcefP(LinearAlgebra.Vector3Proto paramVector3Proto)
    {
      copyOnWrite();
      ((Waypoint)this.instance).mergeEcefP(paramVector3Proto);
      return this;
    }
    
    public Builder setEcefP(LinearAlgebra.Vector3Proto.Builder paramBuilder)
    {
      copyOnWrite();
      ((Waypoint)this.instance).setEcefP(paramBuilder);
      return this;
    }
    
    public Builder setEcefP(LinearAlgebra.Vector3Proto paramVector3Proto)
    {
      copyOnWrite();
      ((Waypoint)this.instance).setEcefP(paramVector3Proto);
      return this;
    }
    
    public Builder setFoiId(String paramString)
    {
      copyOnWrite();
      ((Waypoint)this.instance).setFoiId(paramString);
      return this;
    }
    
    public Builder setFoiIdBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Waypoint)this.instance).setFoiIdBytes(paramByteString);
      return this;
    }
  }
  
  public static enum PositionCase
    implements Internal.EnumLite
  {
    ECEF_P(1),  FOI_ID(2),  POSITION_NOT_SET(0);
    
    private final int value;
    
    private PositionCase(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static PositionCase forNumber(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ECEF_P;
      case 2: 
        return FOI_ID;
      }
      return POSITION_NOT_SET;
    }
    
    @Deprecated
    public static PositionCase valueOf(int paramInt)
    {
      return forNumber(paramInt);
    }
    
    public int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/Waypoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */