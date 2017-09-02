package com.google.internal.tango.foi.v1beta1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.rpc.Status;
import com.google.rpc.Status.Builder;
import java.io.IOException;
import java.io.InputStream;

public final class FoiResult
  extends GeneratedMessageLite<FoiResult, Builder>
  implements FoiResultOrBuilder
{
  private static final FoiResult DEFAULT_INSTANCE = new FoiResult();
  public static final int FOI_FIELD_NUMBER = 1;
  private static volatile Parser<FoiResult> PARSER;
  public static final int STATUS_FIELD_NUMBER = 2;
  private int bitField0_;
  private Foi foi_;
  private Status status_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFoi()
  {
    this.foi_ = null;
    this.bitField0_ &= 0xFFFFFFFE;
  }
  
  private void clearStatus()
  {
    this.status_ = null;
    this.bitField0_ &= 0xFFFFFFFD;
  }
  
  public static FoiResult getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeFoi(Foi paramFoi)
  {
    if ((this.foi_ != null) && (this.foi_ != Foi.getDefaultInstance())) {}
    for (this.foi_ = ((Foi)((Foi.Builder)Foi.newBuilder(this.foi_).mergeFrom(paramFoi)).buildPartial());; this.foi_ = paramFoi)
    {
      this.bitField0_ |= 0x1;
      return;
    }
  }
  
  private void mergeStatus(Status paramStatus)
  {
    if ((this.status_ != null) && (this.status_ != Status.getDefaultInstance())) {}
    for (this.status_ = ((Status)((Status.Builder)Status.newBuilder(this.status_).mergeFrom(paramStatus)).buildPartial());; this.status_ = paramStatus)
    {
      this.bitField0_ |= 0x2;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FoiResult paramFoiResult)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFoiResult);
  }
  
  public static FoiResult parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FoiResult)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FoiResult parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiResult)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiResult parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FoiResult parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FoiResult parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FoiResult parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiResult parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FoiResult parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiResult parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static FoiResult parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FoiResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FoiResult> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFoi(Foi.Builder paramBuilder)
  {
    this.foi_ = ((Foi)paramBuilder.build());
    this.bitField0_ |= 0x1;
  }
  
  private void setFoi(Foi paramFoi)
  {
    if (paramFoi == null) {
      throw new NullPointerException();
    }
    this.foi_ = paramFoi;
    this.bitField0_ |= 0x1;
  }
  
  private void setStatus(Status.Builder paramBuilder)
  {
    this.status_ = ((Status)paramBuilder.build());
    this.bitField0_ |= 0x2;
  }
  
  private void setStatus(Status paramStatus)
  {
    if (paramStatus == null) {
      throw new NullPointerException();
    }
    this.status_ = paramStatus;
    this.bitField0_ |= 0x2;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 188	com/google/internal/tango/foi/v1beta1/FoiResult$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 194	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+157->165, 7:+423->431, 8:+427->435
    //   56: new 196	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 197	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/foi/v1beta1/FoiResult
    //   67: dup
    //   68: invokespecial 32	com/google/internal/tango/foi/v1beta1/FoiResult:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiResult:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiResult;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/internal/tango/foi/v1beta1/FoiResult$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 200	com/google/internal/tango/foi/v1beta1/FoiResult$Builder:<init>	(Lcom/google/internal/tango/foi/v1beta1/FoiResult$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 202	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/internal/tango/foi/v1beta1/FoiResult
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   105: aload_3
    //   106: getfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   109: invokeinterface 206 3 0
    //   114: checkcast 89	com/google/internal/tango/foi/v1beta1/Foi
    //   117: putfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   120: aload_0
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   126: aload_3
    //   127: getfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   130: invokeinterface 206 3 0
    //   135: checkcast 108	com/google/rpc/Status
    //   138: putfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   141: aload_0
    //   142: astore_1
    //   143: aload_2
    //   144: getstatic 212	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   147: if_acmpne -75 -> 72
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   155: aload_3
    //   156: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   159: ior
    //   160: putfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   163: aload_0
    //   164: areturn
    //   165: aload_2
    //   166: checkcast 214	com/google/protobuf/CodedInputStream
    //   169: astore_2
    //   170: aload_3
    //   171: checkcast 216	com/google/protobuf/ExtensionRegistryLite
    //   174: astore_3
    //   175: iconst_0
    //   176: istore 4
    //   178: iload 4
    //   180: ifne +251 -> 431
    //   183: aload_2
    //   184: invokevirtual 219	com/google/protobuf/CodedInputStream:readTag	()I
    //   187: istore 5
    //   189: iload 5
    //   191: lookupswitch	default:+285->476, 0:+288->479, 10:+49->240, 18:+141->332
    //   224: aload_0
    //   225: iload 5
    //   227: aload_2
    //   228: invokevirtual 223	com/google/internal/tango/foi/v1beta1/FoiResult:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   231: ifne -53 -> 178
    //   234: iconst_1
    //   235: istore 4
    //   237: goto -59 -> 178
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_0
    //   243: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   246: iconst_1
    //   247: iand
    //   248: iconst_1
    //   249: if_icmpne +14 -> 263
    //   252: aload_0
    //   253: getfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   256: invokevirtual 224	com/google/internal/tango/foi/v1beta1/Foi:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   259: checkcast 98	com/google/internal/tango/foi/v1beta1/Foi$Builder
    //   262: astore_1
    //   263: aload_0
    //   264: aload_2
    //   265: invokestatic 226	com/google/internal/tango/foi/v1beta1/Foi:parser	()Lcom/google/protobuf/Parser;
    //   268: aload_3
    //   269: invokevirtual 230	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   272: checkcast 89	com/google/internal/tango/foi/v1beta1/Foi
    //   275: putfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   278: aload_1
    //   279: ifnull +23 -> 302
    //   282: aload_1
    //   283: aload_0
    //   284: getfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   287: invokevirtual 102	com/google/internal/tango/foi/v1beta1/Foi$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   290: pop
    //   291: aload_0
    //   292: aload_1
    //   293: invokevirtual 106	com/google/internal/tango/foi/v1beta1/Foi$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   296: checkcast 89	com/google/internal/tango/foi/v1beta1/Foi
    //   299: putfield 82	com/google/internal/tango/foi/v1beta1/FoiResult:foi_	Lcom/google/internal/tango/foi/v1beta1/Foi;
    //   302: aload_0
    //   303: aload_0
    //   304: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   307: iconst_1
    //   308: ior
    //   309: putfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   312: goto -134 -> 178
    //   315: astore_1
    //   316: new 232	java/lang/RuntimeException
    //   319: dup
    //   320: aload_1
    //   321: aload_0
    //   322: invokevirtual 236	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   325: invokespecial 239	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   328: athrow
    //   329: astore_1
    //   330: aload_1
    //   331: athrow
    //   332: aconst_null
    //   333: astore_1
    //   334: aload_0
    //   335: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   338: iconst_2
    //   339: iand
    //   340: iconst_2
    //   341: if_icmpne +14 -> 355
    //   344: aload_0
    //   345: getfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   348: invokevirtual 240	com/google/rpc/Status:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   351: checkcast 116	com/google/rpc/Status$Builder
    //   354: astore_1
    //   355: aload_0
    //   356: aload_2
    //   357: invokestatic 241	com/google/rpc/Status:parser	()Lcom/google/protobuf/Parser;
    //   360: aload_3
    //   361: invokevirtual 230	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   364: checkcast 108	com/google/rpc/Status
    //   367: putfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   370: aload_1
    //   371: ifnull +23 -> 394
    //   374: aload_1
    //   375: aload_0
    //   376: getfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   379: invokevirtual 117	com/google/rpc/Status$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   382: pop
    //   383: aload_0
    //   384: aload_1
    //   385: invokevirtual 118	com/google/rpc/Status$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   388: checkcast 108	com/google/rpc/Status
    //   391: putfield 86	com/google/internal/tango/foi/v1beta1/FoiResult:status_	Lcom/google/rpc/Status;
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   399: iconst_2
    //   400: ior
    //   401: putfield 84	com/google/internal/tango/foi/v1beta1/FoiResult:bitField0_	I
    //   404: goto -226 -> 178
    //   407: astore_1
    //   408: new 232	java/lang/RuntimeException
    //   411: dup
    //   412: new 141	com/google/protobuf/InvalidProtocolBufferException
    //   415: dup
    //   416: aload_1
    //   417: invokevirtual 245	java/io/IOException:getMessage	()Ljava/lang/String;
    //   420: invokespecial 248	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   423: aload_0
    //   424: invokevirtual 236	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   427: invokespecial 239	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   430: athrow
    //   431: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiResult:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiResult;
    //   434: areturn
    //   435: getstatic 250	com/google/internal/tango/foi/v1beta1/FoiResult:PARSER	Lcom/google/protobuf/Parser;
    //   438: ifnonnull +28 -> 466
    //   441: ldc 2
    //   443: monitorenter
    //   444: getstatic 250	com/google/internal/tango/foi/v1beta1/FoiResult:PARSER	Lcom/google/protobuf/Parser;
    //   447: ifnonnull +16 -> 463
    //   450: new 252	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   453: dup
    //   454: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiResult:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiResult;
    //   457: invokespecial 255	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   460: putstatic 250	com/google/internal/tango/foi/v1beta1/FoiResult:PARSER	Lcom/google/protobuf/Parser;
    //   463: ldc 2
    //   465: monitorexit
    //   466: getstatic 250	com/google/internal/tango/foi/v1beta1/FoiResult:PARSER	Lcom/google/protobuf/Parser;
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
    //   0	485	0	this	FoiResult
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
  
  public Foi getFoi()
  {
    if (this.foi_ == null) {
      return Foi.getDefaultInstance();
    }
    return this.foi_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      i = 0 + CodedOutputStream.computeMessageSize(1, getFoi());
    }
    int j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeMessageSize(2, getStatus());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Status getStatus()
  {
    if (this.status_ == null) {
      return Status.getDefaultInstance();
    }
    return this.status_;
  }
  
  public boolean hasFoi()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasStatus()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(1, getFoi());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(2, getStatus());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<FoiResult, Builder>
    implements FoiResultOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearFoi()
    {
      copyOnWrite();
      ((FoiResult)this.instance).clearFoi();
      return this;
    }
    
    public Builder clearStatus()
    {
      copyOnWrite();
      ((FoiResult)this.instance).clearStatus();
      return this;
    }
    
    public Foi getFoi()
    {
      return ((FoiResult)this.instance).getFoi();
    }
    
    public Status getStatus()
    {
      return ((FoiResult)this.instance).getStatus();
    }
    
    public boolean hasFoi()
    {
      return ((FoiResult)this.instance).hasFoi();
    }
    
    public boolean hasStatus()
    {
      return ((FoiResult)this.instance).hasStatus();
    }
    
    public Builder mergeFoi(Foi paramFoi)
    {
      copyOnWrite();
      ((FoiResult)this.instance).mergeFoi(paramFoi);
      return this;
    }
    
    public Builder mergeStatus(Status paramStatus)
    {
      copyOnWrite();
      ((FoiResult)this.instance).mergeStatus(paramStatus);
      return this;
    }
    
    public Builder setFoi(Foi.Builder paramBuilder)
    {
      copyOnWrite();
      ((FoiResult)this.instance).setFoi(paramBuilder);
      return this;
    }
    
    public Builder setFoi(Foi paramFoi)
    {
      copyOnWrite();
      ((FoiResult)this.instance).setFoi(paramFoi);
      return this;
    }
    
    public Builder setStatus(Status.Builder paramBuilder)
    {
      copyOnWrite();
      ((FoiResult)this.instance).setStatus(paramBuilder);
      return this;
    }
    
    public Builder setStatus(Status paramStatus)
    {
      copyOnWrite();
      ((FoiResult)this.instance).setStatus(paramStatus);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/FoiResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */