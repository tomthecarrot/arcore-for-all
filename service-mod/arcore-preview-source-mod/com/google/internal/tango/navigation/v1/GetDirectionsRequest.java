package com.google.internal.tango.navigation.v1;

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
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class GetDirectionsRequest
  extends GeneratedMessageLite<GetDirectionsRequest, Builder>
  implements GetDirectionsRequestOrBuilder
{
  public static final int ALGORITHM_FIELD_NUMBER = 5;
  private static final GetDirectionsRequest DEFAULT_INSTANCE = new GetDirectionsRequest();
  public static final int GOAL_FIELD_NUMBER = 3;
  public static final int LOCALIZATION_CONTEXT_FIELD_NUMBER = 1;
  private static volatile Parser<GetDirectionsRequest> PARSER;
  public static final int START_FIELD_NUMBER = 2;
  public static final int WAYPOINTS_FIELD_NUMBER = 4;
  private int algorithm_;
  private int bitField0_;
  private Waypoint goal_;
  private ByteString localizationContext_ = ByteString.EMPTY;
  private Waypoint start_;
  private Internal.ProtobufList<Waypoint> waypoints_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllWaypoints(Iterable<? extends Waypoint> paramIterable)
  {
    ensureWaypointsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.waypoints_);
  }
  
  private void addWaypoints(int paramInt, Waypoint.Builder paramBuilder)
  {
    ensureWaypointsIsMutable();
    this.waypoints_.add(paramInt, paramBuilder.build());
  }
  
  private void addWaypoints(int paramInt, Waypoint paramWaypoint)
  {
    if (paramWaypoint == null) {
      throw new NullPointerException();
    }
    ensureWaypointsIsMutable();
    this.waypoints_.add(paramInt, paramWaypoint);
  }
  
  private void addWaypoints(Waypoint.Builder paramBuilder)
  {
    ensureWaypointsIsMutable();
    this.waypoints_.add(paramBuilder.build());
  }
  
  private void addWaypoints(Waypoint paramWaypoint)
  {
    if (paramWaypoint == null) {
      throw new NullPointerException();
    }
    ensureWaypointsIsMutable();
    this.waypoints_.add(paramWaypoint);
  }
  
  private void clearAlgorithm()
  {
    this.algorithm_ = 0;
  }
  
  private void clearGoal()
  {
    this.goal_ = null;
  }
  
  private void clearLocalizationContext()
  {
    this.localizationContext_ = getDefaultInstance().getLocalizationContext();
  }
  
  private void clearStart()
  {
    this.start_ = null;
  }
  
  private void clearWaypoints()
  {
    this.waypoints_ = emptyProtobufList();
  }
  
  private void ensureWaypointsIsMutable()
  {
    if (!this.waypoints_.isModifiable()) {
      this.waypoints_ = GeneratedMessageLite.mutableCopy(this.waypoints_);
    }
  }
  
  public static GetDirectionsRequest getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeGoal(Waypoint paramWaypoint)
  {
    if ((this.goal_ != null) && (this.goal_ != Waypoint.getDefaultInstance()))
    {
      this.goal_ = ((Waypoint)((Waypoint.Builder)Waypoint.newBuilder(this.goal_).mergeFrom(paramWaypoint)).buildPartial());
      return;
    }
    this.goal_ = paramWaypoint;
  }
  
  private void mergeStart(Waypoint paramWaypoint)
  {
    if ((this.start_ != null) && (this.start_ != Waypoint.getDefaultInstance()))
    {
      this.start_ = ((Waypoint)((Waypoint.Builder)Waypoint.newBuilder(this.start_).mergeFrom(paramWaypoint)).buildPartial());
      return;
    }
    this.start_ = paramWaypoint;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetDirectionsRequest paramGetDirectionsRequest)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetDirectionsRequest);
  }
  
  public static GetDirectionsRequest parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (GetDirectionsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetDirectionsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetDirectionsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDirectionsRequest parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetDirectionsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetDirectionsRequest parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetDirectionsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDirectionsRequest parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetDirectionsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDirectionsRequest parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static GetDirectionsRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (GetDirectionsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetDirectionsRequest> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeWaypoints(int paramInt)
  {
    ensureWaypointsIsMutable();
    this.waypoints_.remove(paramInt);
  }
  
  private void setAlgorithm(PathfindingAlgorithm paramPathfindingAlgorithm)
  {
    if (paramPathfindingAlgorithm == null) {
      throw new NullPointerException();
    }
    this.algorithm_ = paramPathfindingAlgorithm.getNumber();
  }
  
  private void setAlgorithmValue(int paramInt)
  {
    this.algorithm_ = paramInt;
  }
  
  private void setGoal(Waypoint.Builder paramBuilder)
  {
    this.goal_ = ((Waypoint)paramBuilder.build());
  }
  
  private void setGoal(Waypoint paramWaypoint)
  {
    if (paramWaypoint == null) {
      throw new NullPointerException();
    }
    this.goal_ = paramWaypoint;
  }
  
  private void setLocalizationContext(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.localizationContext_ = paramByteString;
  }
  
  private void setStart(Waypoint.Builder paramBuilder)
  {
    this.start_ = ((Waypoint)paramBuilder.build());
  }
  
  private void setStart(Waypoint paramWaypoint)
  {
    if (paramWaypoint == null) {
      throw new NullPointerException();
    }
    this.start_ = paramWaypoint;
  }
  
  private void setWaypoints(int paramInt, Waypoint.Builder paramBuilder)
  {
    ensureWaypointsIsMutable();
    this.waypoints_.set(paramInt, paramBuilder.build());
  }
  
  private void setWaypoints(int paramInt, Waypoint paramWaypoint)
  {
    if (paramWaypoint == null) {
      throw new NullPointerException();
    }
    ensureWaypointsIsMutable();
    this.waypoints_.set(paramInt, paramWaypoint);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 306	com/google/internal/tango/navigation/v1/GetDirectionsRequest$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 311	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+304->312, 7:+634->642, 8:+638->646
    //   56: new 313	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 314	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/navigation/v1/GetDirectionsRequest
    //   67: dup
    //   68: invokespecial 43	com/google/internal/tango/navigation/v1/GetDirectionsRequest:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 45	com/google/internal/tango/navigation/v1/GetDirectionsRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/GetDirectionsRequest;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 315 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/internal/tango/navigation/v1/GetDirectionsRequest$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 318	com/google/internal/tango/navigation/v1/GetDirectionsRequest$Builder:<init>	(Lcom/google/internal/tango/navigation/v1/GetDirectionsRequest$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 320	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/internal/tango/navigation/v1/GetDirectionsRequest
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   112: getstatic 55	com/google/protobuf/ByteString:EMPTY	Lcom/google/protobuf/ByteString;
    //   115: if_acmpeq +173 -> 288
    //   118: iconst_1
    //   119: istore 6
    //   121: aload_0
    //   122: getfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   125: astore_1
    //   126: aload_3
    //   127: getfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   130: getstatic 55	com/google/protobuf/ByteString:EMPTY	Lcom/google/protobuf/ByteString;
    //   133: if_acmpeq +161 -> 294
    //   136: iconst_1
    //   137: istore 7
    //   139: aload_0
    //   140: aload_2
    //   141: iload 6
    //   143: aload_1
    //   144: iload 7
    //   146: aload_3
    //   147: getfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   150: invokeinterface 324 5 0
    //   155: putfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   158: aload_0
    //   159: aload_2
    //   160: aload_0
    //   161: getfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   164: aload_3
    //   165: getfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   168: invokeinterface 328 3 0
    //   173: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   176: putfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   179: aload_0
    //   180: aload_2
    //   181: aload_0
    //   182: getfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   185: aload_3
    //   186: getfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   189: invokeinterface 328 3 0
    //   194: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   197: putfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   200: aload_0
    //   201: aload_2
    //   202: aload_0
    //   203: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   206: aload_3
    //   207: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   210: invokeinterface 332 3 0
    //   215: putfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   218: aload_0
    //   219: getfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   222: ifeq +78 -> 300
    //   225: iconst_1
    //   226: istore 6
    //   228: aload_0
    //   229: getfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   232: istore 4
    //   234: aload_3
    //   235: getfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   238: ifeq +68 -> 306
    //   241: iconst_1
    //   242: istore 7
    //   244: aload_0
    //   245: aload_2
    //   246: iload 6
    //   248: iload 4
    //   250: iload 7
    //   252: aload_3
    //   253: getfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   256: invokeinterface 336 5 0
    //   261: putfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   264: aload_0
    //   265: astore_1
    //   266: aload_2
    //   267: getstatic 342	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   270: if_acmpne -198 -> 72
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 344	com/google/internal/tango/navigation/v1/GetDirectionsRequest:bitField0_	I
    //   278: aload_3
    //   279: getfield 344	com/google/internal/tango/navigation/v1/GetDirectionsRequest:bitField0_	I
    //   282: ior
    //   283: putfield 344	com/google/internal/tango/navigation/v1/GetDirectionsRequest:bitField0_	I
    //   286: aload_0
    //   287: areturn
    //   288: iconst_0
    //   289: istore 6
    //   291: goto -170 -> 121
    //   294: iconst_0
    //   295: istore 7
    //   297: goto -158 -> 139
    //   300: iconst_0
    //   301: istore 6
    //   303: goto -75 -> 228
    //   306: iconst_0
    //   307: istore 7
    //   309: goto -65 -> 244
    //   312: aload_2
    //   313: checkcast 346	com/google/protobuf/CodedInputStream
    //   316: astore_2
    //   317: aload_3
    //   318: checkcast 348	com/google/protobuf/ExtensionRegistryLite
    //   321: astore_3
    //   322: iconst_0
    //   323: istore 4
    //   325: iload 4
    //   327: ifne +315 -> 642
    //   330: aload_2
    //   331: invokevirtual 351	com/google/protobuf/CodedInputStream:readTag	()I
    //   334: istore 5
    //   336: iload 5
    //   338: lookupswitch	default:+349->687, 0:+352->690, 10:+73->411, 18:+101->439, 26:+187->525, 34:+249->587, 40:+293->631
    //   396: aload_2
    //   397: iload 5
    //   399: invokevirtual 355	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   402: ifne -77 -> 325
    //   405: iconst_1
    //   406: istore 4
    //   408: goto -83 -> 325
    //   411: aload_0
    //   412: aload_2
    //   413: invokevirtual 358	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
    //   416: putfield 57	com/google/internal/tango/navigation/v1/GetDirectionsRequest:localizationContext_	Lcom/google/protobuf/ByteString;
    //   419: goto -94 -> 325
    //   422: astore_1
    //   423: new 360	java/lang/RuntimeException
    //   426: dup
    //   427: aload_1
    //   428: aload_0
    //   429: invokevirtual 364	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   432: invokespecial 367	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   435: athrow
    //   436: astore_1
    //   437: aload_1
    //   438: athrow
    //   439: aconst_null
    //   440: astore_1
    //   441: aload_0
    //   442: getfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   445: ifnull +14 -> 459
    //   448: aload_0
    //   449: getfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   452: invokevirtual 368	com/google/internal/tango/navigation/v1/Waypoint:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   455: checkcast 177	com/google/internal/tango/navigation/v1/Waypoint$Builder
    //   458: astore_1
    //   459: aload_0
    //   460: aload_2
    //   461: invokestatic 370	com/google/internal/tango/navigation/v1/Waypoint:parser	()Lcom/google/protobuf/Parser;
    //   464: aload_3
    //   465: invokevirtual 374	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   468: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   471: putfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   474: aload_1
    //   475: ifnull -150 -> 325
    //   478: aload_1
    //   479: aload_0
    //   480: getfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   483: invokevirtual 227	com/google/internal/tango/navigation/v1/Waypoint$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   486: pop
    //   487: aload_0
    //   488: aload_1
    //   489: invokevirtual 230	com/google/internal/tango/navigation/v1/Waypoint$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   492: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   495: putfield 206	com/google/internal/tango/navigation/v1/GetDirectionsRequest:start_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   498: goto -173 -> 325
    //   501: astore_1
    //   502: new 360	java/lang/RuntimeException
    //   505: dup
    //   506: new 253	com/google/protobuf/InvalidProtocolBufferException
    //   509: dup
    //   510: aload_1
    //   511: invokevirtual 378	java/io/IOException:getMessage	()Ljava/lang/String;
    //   514: invokespecial 381	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   517: aload_0
    //   518: invokevirtual 364	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   521: invokespecial 367	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   524: athrow
    //   525: aconst_null
    //   526: astore_1
    //   527: aload_0
    //   528: getfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   531: ifnull +14 -> 545
    //   534: aload_0
    //   535: getfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   538: invokevirtual 368	com/google/internal/tango/navigation/v1/Waypoint:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   541: checkcast 177	com/google/internal/tango/navigation/v1/Waypoint$Builder
    //   544: astore_1
    //   545: aload_0
    //   546: aload_2
    //   547: invokestatic 370	com/google/internal/tango/navigation/v1/Waypoint:parser	()Lcom/google/protobuf/Parser;
    //   550: aload_3
    //   551: invokevirtual 374	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   554: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   557: putfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   560: aload_1
    //   561: ifnull -236 -> 325
    //   564: aload_1
    //   565: aload_0
    //   566: getfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   569: invokevirtual 227	com/google/internal/tango/navigation/v1/Waypoint$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   572: pop
    //   573: aload_0
    //   574: aload_1
    //   575: invokevirtual 230	com/google/internal/tango/navigation/v1/Waypoint$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   578: checkcast 216	com/google/internal/tango/navigation/v1/Waypoint
    //   581: putfield 197	com/google/internal/tango/navigation/v1/GetDirectionsRequest:goal_	Lcom/google/internal/tango/navigation/v1/Waypoint;
    //   584: goto -259 -> 325
    //   587: aload_0
    //   588: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   591: invokeinterface 210 1 0
    //   596: ifne +14 -> 610
    //   599: aload_0
    //   600: aload_0
    //   601: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   604: invokestatic 214	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   607: putfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   610: aload_0
    //   611: getfield 63	com/google/internal/tango/navigation/v1/GetDirectionsRequest:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
    //   614: aload_2
    //   615: invokestatic 370	com/google/internal/tango/navigation/v1/Waypoint:parser	()Lcom/google/protobuf/Parser;
    //   618: aload_3
    //   619: invokevirtual 374	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   622: invokeinterface 193 2 0
    //   627: pop
    //   628: goto -303 -> 325
    //   631: aload_0
    //   632: aload_2
    //   633: invokevirtual 384	com/google/protobuf/CodedInputStream:readEnum	()I
    //   636: putfield 195	com/google/internal/tango/navigation/v1/GetDirectionsRequest:algorithm_	I
    //   639: goto -314 -> 325
    //   642: getstatic 45	com/google/internal/tango/navigation/v1/GetDirectionsRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/GetDirectionsRequest;
    //   645: areturn
    //   646: getstatic 386	com/google/internal/tango/navigation/v1/GetDirectionsRequest:PARSER	Lcom/google/protobuf/Parser;
    //   649: ifnonnull +28 -> 677
    //   652: ldc 2
    //   654: monitorenter
    //   655: getstatic 386	com/google/internal/tango/navigation/v1/GetDirectionsRequest:PARSER	Lcom/google/protobuf/Parser;
    //   658: ifnonnull +16 -> 674
    //   661: new 388	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   664: dup
    //   665: getstatic 45	com/google/internal/tango/navigation/v1/GetDirectionsRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/GetDirectionsRequest;
    //   668: invokespecial 391	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   671: putstatic 386	com/google/internal/tango/navigation/v1/GetDirectionsRequest:PARSER	Lcom/google/protobuf/Parser;
    //   674: ldc 2
    //   676: monitorexit
    //   677: getstatic 386	com/google/internal/tango/navigation/v1/GetDirectionsRequest:PARSER	Lcom/google/protobuf/Parser;
    //   680: areturn
    //   681: astore_1
    //   682: ldc 2
    //   684: monitorexit
    //   685: aload_1
    //   686: athrow
    //   687: goto -291 -> 396
    //   690: iconst_1
    //   691: istore 4
    //   693: goto -368 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	GetDirectionsRequest
    //   0	696	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	696	2	paramObject1	Object
    //   0	696	3	paramObject2	Object
    //   232	460	4	i	int
    //   334	64	5	j	int
    //   119	183	6	bool1	boolean
    //   137	171	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   330	336	422	com/google/protobuf/InvalidProtocolBufferException
    //   396	405	422	com/google/protobuf/InvalidProtocolBufferException
    //   411	419	422	com/google/protobuf/InvalidProtocolBufferException
    //   441	459	422	com/google/protobuf/InvalidProtocolBufferException
    //   459	474	422	com/google/protobuf/InvalidProtocolBufferException
    //   478	498	422	com/google/protobuf/InvalidProtocolBufferException
    //   527	545	422	com/google/protobuf/InvalidProtocolBufferException
    //   545	560	422	com/google/protobuf/InvalidProtocolBufferException
    //   564	584	422	com/google/protobuf/InvalidProtocolBufferException
    //   587	610	422	com/google/protobuf/InvalidProtocolBufferException
    //   610	628	422	com/google/protobuf/InvalidProtocolBufferException
    //   631	639	422	com/google/protobuf/InvalidProtocolBufferException
    //   330	336	436	finally
    //   396	405	436	finally
    //   411	419	436	finally
    //   423	436	436	finally
    //   441	459	436	finally
    //   459	474	436	finally
    //   478	498	436	finally
    //   502	525	436	finally
    //   527	545	436	finally
    //   545	560	436	finally
    //   564	584	436	finally
    //   587	610	436	finally
    //   610	628	436	finally
    //   631	639	436	finally
    //   330	336	501	java/io/IOException
    //   396	405	501	java/io/IOException
    //   411	419	501	java/io/IOException
    //   441	459	501	java/io/IOException
    //   459	474	501	java/io/IOException
    //   478	498	501	java/io/IOException
    //   527	545	501	java/io/IOException
    //   545	560	501	java/io/IOException
    //   564	584	501	java/io/IOException
    //   587	610	501	java/io/IOException
    //   610	628	501	java/io/IOException
    //   631	639	501	java/io/IOException
    //   655	674	681	finally
    //   674	677	681	finally
    //   682	685	681	finally
  }
  
  public PathfindingAlgorithm getAlgorithm()
  {
    PathfindingAlgorithm localPathfindingAlgorithm2 = PathfindingAlgorithm.forNumber(this.algorithm_);
    PathfindingAlgorithm localPathfindingAlgorithm1 = localPathfindingAlgorithm2;
    if (localPathfindingAlgorithm2 == null) {
      localPathfindingAlgorithm1 = PathfindingAlgorithm.UNRECOGNIZED;
    }
    return localPathfindingAlgorithm1;
  }
  
  public int getAlgorithmValue()
  {
    return this.algorithm_;
  }
  
  public Waypoint getGoal()
  {
    if (this.goal_ == null) {
      return Waypoint.getDefaultInstance();
    }
    return this.goal_;
  }
  
  public ByteString getLocalizationContext()
  {
    return this.localizationContext_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if (!this.localizationContext_.isEmpty()) {
      j = 0 + CodedOutputStream.computeBytesSize(1, this.localizationContext_);
    }
    i = j;
    if (this.start_ != null) {
      i = j + CodedOutputStream.computeMessageSize(2, getStart());
    }
    j = i;
    if (this.goal_ != null) {
      j = i + CodedOutputStream.computeMessageSize(3, getGoal());
    }
    int k = 0;
    i = j;
    j = k;
    while (j < this.waypoints_.size())
    {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.waypoints_.get(j));
      j += 1;
    }
    j = i;
    if (this.algorithm_ != PathfindingAlgorithm.PATHFINDING_ALGORITHM_UNDEFINED.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(5, this.algorithm_);
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Waypoint getStart()
  {
    if (this.start_ == null) {
      return Waypoint.getDefaultInstance();
    }
    return this.start_;
  }
  
  public Waypoint getWaypoints(int paramInt)
  {
    return (Waypoint)this.waypoints_.get(paramInt);
  }
  
  public int getWaypointsCount()
  {
    return this.waypoints_.size();
  }
  
  public List<Waypoint> getWaypointsList()
  {
    return this.waypoints_;
  }
  
  public WaypointOrBuilder getWaypointsOrBuilder(int paramInt)
  {
    return (WaypointOrBuilder)this.waypoints_.get(paramInt);
  }
  
  public List<? extends WaypointOrBuilder> getWaypointsOrBuilderList()
  {
    return this.waypoints_;
  }
  
  public boolean hasGoal()
  {
    return this.goal_ != null;
  }
  
  public boolean hasStart()
  {
    return this.start_ != null;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (!this.localizationContext_.isEmpty()) {
      paramCodedOutputStream.writeBytes(1, this.localizationContext_);
    }
    if (this.start_ != null) {
      paramCodedOutputStream.writeMessage(2, getStart());
    }
    if (this.goal_ != null) {
      paramCodedOutputStream.writeMessage(3, getGoal());
    }
    int i = 0;
    while (i < this.waypoints_.size())
    {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.waypoints_.get(i));
      i += 1;
    }
    if (this.algorithm_ != PathfindingAlgorithm.PATHFINDING_ALGORITHM_UNDEFINED.getNumber()) {
      paramCodedOutputStream.writeEnum(5, this.algorithm_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<GetDirectionsRequest, Builder>
    implements GetDirectionsRequestOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllWaypoints(Iterable<? extends Waypoint> paramIterable)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).addAllWaypoints(paramIterable);
      return this;
    }
    
    public Builder addWaypoints(int paramInt, Waypoint.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).addWaypoints(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addWaypoints(int paramInt, Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).addWaypoints(paramInt, paramWaypoint);
      return this;
    }
    
    public Builder addWaypoints(Waypoint.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).addWaypoints(paramBuilder);
      return this;
    }
    
    public Builder addWaypoints(Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).addWaypoints(paramWaypoint);
      return this;
    }
    
    public Builder clearAlgorithm()
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).clearAlgorithm();
      return this;
    }
    
    public Builder clearGoal()
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).clearGoal();
      return this;
    }
    
    public Builder clearLocalizationContext()
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).clearLocalizationContext();
      return this;
    }
    
    public Builder clearStart()
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).clearStart();
      return this;
    }
    
    public Builder clearWaypoints()
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).clearWaypoints();
      return this;
    }
    
    public PathfindingAlgorithm getAlgorithm()
    {
      return ((GetDirectionsRequest)this.instance).getAlgorithm();
    }
    
    public int getAlgorithmValue()
    {
      return ((GetDirectionsRequest)this.instance).getAlgorithmValue();
    }
    
    public Waypoint getGoal()
    {
      return ((GetDirectionsRequest)this.instance).getGoal();
    }
    
    public ByteString getLocalizationContext()
    {
      return ((GetDirectionsRequest)this.instance).getLocalizationContext();
    }
    
    public Waypoint getStart()
    {
      return ((GetDirectionsRequest)this.instance).getStart();
    }
    
    public Waypoint getWaypoints(int paramInt)
    {
      return ((GetDirectionsRequest)this.instance).getWaypoints(paramInt);
    }
    
    public int getWaypointsCount()
    {
      return ((GetDirectionsRequest)this.instance).getWaypointsCount();
    }
    
    public List<Waypoint> getWaypointsList()
    {
      return Collections.unmodifiableList(((GetDirectionsRequest)this.instance).getWaypointsList());
    }
    
    public boolean hasGoal()
    {
      return ((GetDirectionsRequest)this.instance).hasGoal();
    }
    
    public boolean hasStart()
    {
      return ((GetDirectionsRequest)this.instance).hasStart();
    }
    
    public Builder mergeGoal(Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).mergeGoal(paramWaypoint);
      return this;
    }
    
    public Builder mergeStart(Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).mergeStart(paramWaypoint);
      return this;
    }
    
    public Builder removeWaypoints(int paramInt)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).removeWaypoints(paramInt);
      return this;
    }
    
    public Builder setAlgorithm(PathfindingAlgorithm paramPathfindingAlgorithm)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setAlgorithm(paramPathfindingAlgorithm);
      return this;
    }
    
    public Builder setAlgorithmValue(int paramInt)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setAlgorithmValue(paramInt);
      return this;
    }
    
    public Builder setGoal(Waypoint.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setGoal(paramBuilder);
      return this;
    }
    
    public Builder setGoal(Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setGoal(paramWaypoint);
      return this;
    }
    
    public Builder setLocalizationContext(ByteString paramByteString)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setLocalizationContext(paramByteString);
      return this;
    }
    
    public Builder setStart(Waypoint.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setStart(paramBuilder);
      return this;
    }
    
    public Builder setStart(Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setStart(paramWaypoint);
      return this;
    }
    
    public Builder setWaypoints(int paramInt, Waypoint.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setWaypoints(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setWaypoints(int paramInt, Waypoint paramWaypoint)
    {
      copyOnWrite();
      ((GetDirectionsRequest)this.instance).setWaypoints(paramInt, paramWaypoint);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/GetDirectionsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */