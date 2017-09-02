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
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Directions
  extends GeneratedMessageLite<Directions, Builder>
  implements DirectionsOrBuilder
{
  public static final int ALGORITHM_FIELD_NUMBER = 2;
  private static final Directions DEFAULT_INSTANCE = new Directions();
  public static final int LEGS_FIELD_NUMBER = 1;
  private static volatile Parser<Directions> PARSER;
  private int algorithm_;
  private int bitField0_;
  private Internal.ProtobufList<Leg> legs_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllLegs(Iterable<? extends Leg> paramIterable)
  {
    ensureLegsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.legs_);
  }
  
  private void addLegs(int paramInt, Directions.Leg.Builder paramBuilder)
  {
    ensureLegsIsMutable();
    this.legs_.add(paramInt, paramBuilder.build());
  }
  
  private void addLegs(int paramInt, Leg paramLeg)
  {
    if (paramLeg == null) {
      throw new NullPointerException();
    }
    ensureLegsIsMutable();
    this.legs_.add(paramInt, paramLeg);
  }
  
  private void addLegs(Directions.Leg.Builder paramBuilder)
  {
    ensureLegsIsMutable();
    this.legs_.add(paramBuilder.build());
  }
  
  private void addLegs(Leg paramLeg)
  {
    if (paramLeg == null) {
      throw new NullPointerException();
    }
    ensureLegsIsMutable();
    this.legs_.add(paramLeg);
  }
  
  private void clearAlgorithm()
  {
    this.algorithm_ = 0;
  }
  
  private void clearLegs()
  {
    this.legs_ = emptyProtobufList();
  }
  
  private void ensureLegsIsMutable()
  {
    if (!this.legs_.isModifiable()) {
      this.legs_ = GeneratedMessageLite.mutableCopy(this.legs_);
    }
  }
  
  public static Directions getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Directions paramDirections)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDirections);
  }
  
  public static Directions parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Directions)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Directions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Directions)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Directions parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Directions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Directions parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Directions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Directions parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Directions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Directions parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Directions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Directions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Directions> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeLegs(int paramInt)
  {
    ensureLegsIsMutable();
    this.legs_.remove(paramInt);
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
  
  private void setLegs(int paramInt, Directions.Leg.Builder paramBuilder)
  {
    ensureLegsIsMutable();
    this.legs_.set(paramInt, paramBuilder.build());
  }
  
  private void setLegs(int paramInt, Leg paramLeg)
  {
    if (paramLeg == null) {
      throw new NullPointerException();
    }
    ensureLegsIsMutable();
    this.legs_.set(paramInt, paramLeg);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 232	com/google/internal/tango/navigation/v1/Directions$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 237	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+200->208, 7:+371->379, 8:+375->383
    //   56: new 239	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 240	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/navigation/v1/Directions
    //   67: dup
    //   68: invokespecial 40	com/google/internal/tango/navigation/v1/Directions:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 42	com/google/internal/tango/navigation/v1/Directions:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 241 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/internal/tango/navigation/v1/Directions$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 244	com/google/internal/tango/navigation/v1/Directions$Builder:<init>	(Lcom/google/internal/tango/navigation/v1/Directions$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 246	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/internal/tango/navigation/v1/Directions
    //   107: astore_3
    //   108: aload_0
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   114: aload_3
    //   115: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 250 3 0
    //   123: putfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   126: aload_0
    //   127: getfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   130: ifeq +66 -> 196
    //   133: iconst_1
    //   134: istore 6
    //   136: aload_0
    //   137: getfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   140: istore 4
    //   142: aload_3
    //   143: getfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   146: ifeq +56 -> 202
    //   149: iconst_1
    //   150: istore 7
    //   152: aload_0
    //   153: aload_2
    //   154: iload 6
    //   156: iload 4
    //   158: iload 7
    //   160: aload_3
    //   161: getfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   164: invokeinterface 254 5 0
    //   169: putfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: getstatic 260	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   178: if_acmpne -106 -> 72
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 262	com/google/internal/tango/navigation/v1/Directions:bitField0_	I
    //   186: aload_3
    //   187: getfield 262	com/google/internal/tango/navigation/v1/Directions:bitField0_	I
    //   190: ior
    //   191: putfield 262	com/google/internal/tango/navigation/v1/Directions:bitField0_	I
    //   194: aload_0
    //   195: areturn
    //   196: iconst_0
    //   197: istore 6
    //   199: goto -63 -> 136
    //   202: iconst_0
    //   203: istore 7
    //   205: goto -53 -> 152
    //   208: aload_2
    //   209: checkcast 264	com/google/protobuf/CodedInputStream
    //   212: astore_1
    //   213: aload_3
    //   214: checkcast 266	com/google/protobuf/ExtensionRegistryLite
    //   217: astore_2
    //   218: iconst_0
    //   219: istore 4
    //   221: iload 4
    //   223: ifne +156 -> 379
    //   226: aload_1
    //   227: invokevirtual 269	com/google/protobuf/CodedInputStream:readTag	()I
    //   230: istore 5
    //   232: iload 5
    //   234: lookupswitch	default:+190->424, 0:+193->427, 10:+49->283, 16:+110->344
    //   268: aload_1
    //   269: iload 5
    //   271: invokevirtual 273	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   274: ifne -53 -> 221
    //   277: iconst_1
    //   278: istore 4
    //   280: goto -59 -> 221
    //   283: aload_0
    //   284: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   287: invokeinterface 147 1 0
    //   292: ifne +14 -> 306
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   300: invokestatic 151	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   303: putfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   306: aload_0
    //   307: getfield 53	com/google/internal/tango/navigation/v1/Directions:legs_	Lcom/google/protobuf/Internal$ProtobufList;
    //   310: aload_1
    //   311: invokestatic 275	com/google/internal/tango/navigation/v1/Directions$Leg:parser	()Lcom/google/protobuf/Parser;
    //   314: aload_2
    //   315: invokevirtual 279	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   318: invokeinterface 141 2 0
    //   323: pop
    //   324: goto -103 -> 221
    //   327: astore_1
    //   328: new 281	java/lang/RuntimeException
    //   331: dup
    //   332: aload_1
    //   333: aload_0
    //   334: invokevirtual 285	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   337: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   340: athrow
    //   341: astore_1
    //   342: aload_1
    //   343: athrow
    //   344: aload_0
    //   345: aload_1
    //   346: invokevirtual 291	com/google/protobuf/CodedInputStream:readEnum	()I
    //   349: putfield 143	com/google/internal/tango/navigation/v1/Directions:algorithm_	I
    //   352: goto -131 -> 221
    //   355: astore_1
    //   356: new 281	java/lang/RuntimeException
    //   359: dup
    //   360: new 179	com/google/protobuf/InvalidProtocolBufferException
    //   363: dup
    //   364: aload_1
    //   365: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   368: invokespecial 298	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   371: aload_0
    //   372: invokevirtual 285	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   375: invokespecial 288	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   378: athrow
    //   379: getstatic 42	com/google/internal/tango/navigation/v1/Directions:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions;
    //   382: areturn
    //   383: getstatic 300	com/google/internal/tango/navigation/v1/Directions:PARSER	Lcom/google/protobuf/Parser;
    //   386: ifnonnull +28 -> 414
    //   389: ldc 2
    //   391: monitorenter
    //   392: getstatic 300	com/google/internal/tango/navigation/v1/Directions:PARSER	Lcom/google/protobuf/Parser;
    //   395: ifnonnull +16 -> 411
    //   398: new 302	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   401: dup
    //   402: getstatic 42	com/google/internal/tango/navigation/v1/Directions:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions;
    //   405: invokespecial 305	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   408: putstatic 300	com/google/internal/tango/navigation/v1/Directions:PARSER	Lcom/google/protobuf/Parser;
    //   411: ldc 2
    //   413: monitorexit
    //   414: getstatic 300	com/google/internal/tango/navigation/v1/Directions:PARSER	Lcom/google/protobuf/Parser;
    //   417: areturn
    //   418: astore_1
    //   419: ldc 2
    //   421: monitorexit
    //   422: aload_1
    //   423: athrow
    //   424: goto -156 -> 268
    //   427: iconst_1
    //   428: istore 4
    //   430: goto -209 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	Directions
    //   0	433	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	433	2	paramObject1	Object
    //   0	433	3	paramObject2	Object
    //   140	289	4	i	int
    //   230	40	5	j	int
    //   134	64	6	bool1	boolean
    //   150	54	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   226	232	327	com/google/protobuf/InvalidProtocolBufferException
    //   268	277	327	com/google/protobuf/InvalidProtocolBufferException
    //   283	306	327	com/google/protobuf/InvalidProtocolBufferException
    //   306	324	327	com/google/protobuf/InvalidProtocolBufferException
    //   344	352	327	com/google/protobuf/InvalidProtocolBufferException
    //   226	232	341	finally
    //   268	277	341	finally
    //   283	306	341	finally
    //   306	324	341	finally
    //   328	341	341	finally
    //   344	352	341	finally
    //   356	379	341	finally
    //   226	232	355	java/io/IOException
    //   268	277	355	java/io/IOException
    //   283	306	355	java/io/IOException
    //   306	324	355	java/io/IOException
    //   344	352	355	java/io/IOException
    //   392	411	418	finally
    //   411	414	418	finally
    //   419	422	418	finally
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
  
  public Leg getLegs(int paramInt)
  {
    return (Leg)this.legs_.get(paramInt);
  }
  
  public int getLegsCount()
  {
    return this.legs_.size();
  }
  
  public List<Leg> getLegsList()
  {
    return this.legs_;
  }
  
  public LegOrBuilder getLegsOrBuilder(int paramInt)
  {
    return (LegOrBuilder)this.legs_.get(paramInt);
  }
  
  public List<? extends LegOrBuilder> getLegsOrBuilderList()
  {
    return this.legs_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (j < this.legs_.size())
    {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.legs_.get(j));
      j += 1;
    }
    j = i;
    if (this.algorithm_ != PathfindingAlgorithm.PATHFINDING_ALGORITHM_UNDEFINED.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(2, this.algorithm_);
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.legs_.size())
    {
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.legs_.get(i));
      i += 1;
    }
    if (this.algorithm_ != PathfindingAlgorithm.PATHFINDING_ALGORITHM_UNDEFINED.getNumber()) {
      paramCodedOutputStream.writeEnum(2, this.algorithm_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Directions, Builder>
    implements DirectionsOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllLegs(Iterable<? extends Directions.Leg> paramIterable)
    {
      copyOnWrite();
      ((Directions)this.instance).addAllLegs(paramIterable);
      return this;
    }
    
    public Builder addLegs(int paramInt, Directions.Leg.Builder paramBuilder)
    {
      copyOnWrite();
      ((Directions)this.instance).addLegs(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addLegs(int paramInt, Directions.Leg paramLeg)
    {
      copyOnWrite();
      ((Directions)this.instance).addLegs(paramInt, paramLeg);
      return this;
    }
    
    public Builder addLegs(Directions.Leg.Builder paramBuilder)
    {
      copyOnWrite();
      ((Directions)this.instance).addLegs(paramBuilder);
      return this;
    }
    
    public Builder addLegs(Directions.Leg paramLeg)
    {
      copyOnWrite();
      ((Directions)this.instance).addLegs(paramLeg);
      return this;
    }
    
    public Builder clearAlgorithm()
    {
      copyOnWrite();
      ((Directions)this.instance).clearAlgorithm();
      return this;
    }
    
    public Builder clearLegs()
    {
      copyOnWrite();
      ((Directions)this.instance).clearLegs();
      return this;
    }
    
    public PathfindingAlgorithm getAlgorithm()
    {
      return ((Directions)this.instance).getAlgorithm();
    }
    
    public int getAlgorithmValue()
    {
      return ((Directions)this.instance).getAlgorithmValue();
    }
    
    public Directions.Leg getLegs(int paramInt)
    {
      return ((Directions)this.instance).getLegs(paramInt);
    }
    
    public int getLegsCount()
    {
      return ((Directions)this.instance).getLegsCount();
    }
    
    public List<Directions.Leg> getLegsList()
    {
      return Collections.unmodifiableList(((Directions)this.instance).getLegsList());
    }
    
    public Builder removeLegs(int paramInt)
    {
      copyOnWrite();
      ((Directions)this.instance).removeLegs(paramInt);
      return this;
    }
    
    public Builder setAlgorithm(PathfindingAlgorithm paramPathfindingAlgorithm)
    {
      copyOnWrite();
      ((Directions)this.instance).setAlgorithm(paramPathfindingAlgorithm);
      return this;
    }
    
    public Builder setAlgorithmValue(int paramInt)
    {
      copyOnWrite();
      ((Directions)this.instance).setAlgorithmValue(paramInt);
      return this;
    }
    
    public Builder setLegs(int paramInt, Directions.Leg.Builder paramBuilder)
    {
      copyOnWrite();
      ((Directions)this.instance).setLegs(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setLegs(int paramInt, Directions.Leg paramLeg)
    {
      copyOnWrite();
      ((Directions)this.instance).setLegs(paramInt, paramLeg);
      return this;
    }
  }
  
  public static final class Leg
    extends GeneratedMessageLite<Leg, Builder>
    implements Directions.LegOrBuilder
  {
    private static final Leg DEFAULT_INSTANCE = new Leg();
    private static volatile Parser<Leg> PARSER;
    public static final int WAYPOINTS_FIELD_NUMBER = 1;
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
    
    public static Leg getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Leg paramLeg)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLeg);
    }
    
    public static Leg parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Leg)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Leg parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Leg)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Leg parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static Leg parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static Leg parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static Leg parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static Leg parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Leg parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Leg parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static Leg parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Leg)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<Leg> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeWaypoints(int paramInt)
    {
      ensureWaypointsIsMutable();
      this.waypoints_.remove(paramInt);
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
      //   0: getstatic 203	com/google/internal/tango/navigation/v1/Directions$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 209	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+280->288, 8:+284->292
      //   56: new 211	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 212	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/internal/tango/navigation/v1/Directions$Leg
      //   67: dup
      //   68: invokespecial 29	com/google/internal/tango/navigation/v1/Directions$Leg:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/internal/tango/navigation/v1/Directions$Leg:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions$Leg;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 213 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/internal/tango/navigation/v1/Directions$Leg$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 216	com/google/internal/tango/navigation/v1/Directions$Leg$Builder:<init>	(Lcom/google/internal/tango/navigation/v1/Directions$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 218	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/internal/tango/navigation/v1/Directions$Leg
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 222 3 0
      //   123: putfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
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
      //   152: ifne +136 -> 288
      //   155: aload_1
      //   156: invokevirtual 235	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+170->333, 0:+173->336, 10:+40->203
      //   188: aload_1
      //   189: iload 5
      //   191: invokevirtual 239	com/google/protobuf/CodedInputStream:skipField	(I)Z
      //   194: ifne -44 -> 150
      //   197: iconst_1
      //   198: istore 4
      //   200: goto -50 -> 150
      //   203: aload_0
      //   204: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   207: invokeinterface 122 1 0
      //   212: ifne +14 -> 226
      //   215: aload_0
      //   216: aload_0
      //   217: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   220: invokestatic 126	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   223: putfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   226: aload_0
      //   227: getfield 42	com/google/internal/tango/navigation/v1/Directions$Leg:waypoints_	Lcom/google/protobuf/Internal$ProtobufList;
      //   230: aload_1
      //   231: invokestatic 243	com/google/internal/tango/navigation/v1/Waypoint:parser	()Lcom/google/protobuf/Parser;
      //   234: aload_2
      //   235: invokevirtual 247	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   238: invokeinterface 118 2 0
      //   243: pop
      //   244: goto -94 -> 150
      //   247: astore_1
      //   248: new 249	java/lang/RuntimeException
      //   251: dup
      //   252: aload_1
      //   253: aload_0
      //   254: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   257: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   260: athrow
      //   261: astore_1
      //   262: aload_1
      //   263: athrow
      //   264: astore_1
      //   265: new 249	java/lang/RuntimeException
      //   268: dup
      //   269: new 154	com/google/protobuf/InvalidProtocolBufferException
      //   272: dup
      //   273: aload_1
      //   274: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   277: invokespecial 263	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   280: aload_0
      //   281: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   284: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   287: athrow
      //   288: getstatic 31	com/google/internal/tango/navigation/v1/Directions$Leg:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions$Leg;
      //   291: areturn
      //   292: getstatic 265	com/google/internal/tango/navigation/v1/Directions$Leg:PARSER	Lcom/google/protobuf/Parser;
      //   295: ifnonnull +28 -> 323
      //   298: ldc 2
      //   300: monitorenter
      //   301: getstatic 265	com/google/internal/tango/navigation/v1/Directions$Leg:PARSER	Lcom/google/protobuf/Parser;
      //   304: ifnonnull +16 -> 320
      //   307: new 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   310: dup
      //   311: getstatic 31	com/google/internal/tango/navigation/v1/Directions$Leg:DEFAULT_INSTANCE	Lcom/google/internal/tango/navigation/v1/Directions$Leg;
      //   314: invokespecial 270	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   317: putstatic 265	com/google/internal/tango/navigation/v1/Directions$Leg:PARSER	Lcom/google/protobuf/Parser;
      //   320: ldc 2
      //   322: monitorexit
      //   323: getstatic 265	com/google/internal/tango/navigation/v1/Directions$Leg:PARSER	Lcom/google/protobuf/Parser;
      //   326: areturn
      //   327: astore_1
      //   328: ldc 2
      //   330: monitorexit
      //   331: aload_1
      //   332: athrow
      //   333: goto -145 -> 188
      //   336: iconst_1
      //   337: istore 4
      //   339: goto -189 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	342	0	this	Leg
      //   0	342	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	342	2	paramObject1	Object
      //   0	342	3	paramObject2	Object
      //   148	190	4	i	int
      //   159	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   155	161	247	com/google/protobuf/InvalidProtocolBufferException
      //   188	197	247	com/google/protobuf/InvalidProtocolBufferException
      //   203	226	247	com/google/protobuf/InvalidProtocolBufferException
      //   226	244	247	com/google/protobuf/InvalidProtocolBufferException
      //   155	161	261	finally
      //   188	197	261	finally
      //   203	226	261	finally
      //   226	244	261	finally
      //   248	261	261	finally
      //   265	288	261	finally
      //   155	161	264	java/io/IOException
      //   188	197	264	java/io/IOException
      //   203	226	264	java/io/IOException
      //   226	244	264	java/io/IOException
      //   301	320	327	finally
      //   320	323	327	finally
      //   328	331	327	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.waypoints_.size())
      {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.waypoints_.get(i));
        i += 1;
      }
      this.memoizedSerializedSize = j;
      return j;
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
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.waypoints_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.waypoints_.get(i));
        i += 1;
      }
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<Directions.Leg, Builder>
      implements Directions.LegOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllWaypoints(Iterable<? extends Waypoint> paramIterable)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).addAllWaypoints(paramIterable);
        return this;
      }
      
      public Builder addWaypoints(int paramInt, Waypoint.Builder paramBuilder)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).addWaypoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addWaypoints(int paramInt, Waypoint paramWaypoint)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).addWaypoints(paramInt, paramWaypoint);
        return this;
      }
      
      public Builder addWaypoints(Waypoint.Builder paramBuilder)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).addWaypoints(paramBuilder);
        return this;
      }
      
      public Builder addWaypoints(Waypoint paramWaypoint)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).addWaypoints(paramWaypoint);
        return this;
      }
      
      public Builder clearWaypoints()
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).clearWaypoints();
        return this;
      }
      
      public Waypoint getWaypoints(int paramInt)
      {
        return ((Directions.Leg)this.instance).getWaypoints(paramInt);
      }
      
      public int getWaypointsCount()
      {
        return ((Directions.Leg)this.instance).getWaypointsCount();
      }
      
      public List<Waypoint> getWaypointsList()
      {
        return Collections.unmodifiableList(((Directions.Leg)this.instance).getWaypointsList());
      }
      
      public Builder removeWaypoints(int paramInt)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).removeWaypoints(paramInt);
        return this;
      }
      
      public Builder setWaypoints(int paramInt, Waypoint.Builder paramBuilder)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).setWaypoints(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setWaypoints(int paramInt, Waypoint paramWaypoint)
      {
        copyOnWrite();
        ((Directions.Leg)this.instance).setWaypoints(paramInt, paramWaypoint);
        return this;
      }
    }
  }
  
  public static abstract interface LegOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract Waypoint getWaypoints(int paramInt);
    
    public abstract int getWaypointsCount();
    
    public abstract List<Waypoint> getWaypointsList();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/navigation/v1/Directions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */