package com.google.internal.tango.foi.v1beta1;

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
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class MutateFoisReply
  extends GeneratedMessageLite<MutateFoisReply, Builder>
  implements MutateFoisReplyOrBuilder
{
  private static final MutateFoisReply DEFAULT_INSTANCE = new MutateFoisReply();
  private static volatile Parser<MutateFoisReply> PARSER;
  public static final int RESULTS_FIELD_NUMBER = 2;
  private Internal.ProtobufList<FoiResult> results_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllResults(Iterable<? extends FoiResult> paramIterable)
  {
    ensureResultsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.results_);
  }
  
  private void addResults(int paramInt, FoiResult.Builder paramBuilder)
  {
    ensureResultsIsMutable();
    this.results_.add(paramInt, paramBuilder.build());
  }
  
  private void addResults(int paramInt, FoiResult paramFoiResult)
  {
    if (paramFoiResult == null) {
      throw new NullPointerException();
    }
    ensureResultsIsMutable();
    this.results_.add(paramInt, paramFoiResult);
  }
  
  private void addResults(FoiResult.Builder paramBuilder)
  {
    ensureResultsIsMutable();
    this.results_.add(paramBuilder.build());
  }
  
  private void addResults(FoiResult paramFoiResult)
  {
    if (paramFoiResult == null) {
      throw new NullPointerException();
    }
    ensureResultsIsMutable();
    this.results_.add(paramFoiResult);
  }
  
  private void clearResults()
  {
    this.results_ = emptyProtobufList();
  }
  
  private void ensureResultsIsMutable()
  {
    if (!this.results_.isModifiable()) {
      this.results_ = GeneratedMessageLite.mutableCopy(this.results_);
    }
  }
  
  public static MutateFoisReply getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MutateFoisReply paramMutateFoisReply)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMutateFoisReply);
  }
  
  public static MutateFoisReply parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (MutateFoisReply)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MutateFoisReply parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (MutateFoisReply)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MutateFoisReply parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MutateFoisReply parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MutateFoisReply parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MutateFoisReply parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MutateFoisReply parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MutateFoisReply parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MutateFoisReply parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static MutateFoisReply parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (MutateFoisReply)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<MutateFoisReply> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeResults(int paramInt)
  {
    ensureResultsIsMutable();
    this.results_.remove(paramInt);
  }
  
  private void setResults(int paramInt, FoiResult.Builder paramBuilder)
  {
    ensureResultsIsMutable();
    this.results_.set(paramInt, paramBuilder.build());
  }
  
  private void setResults(int paramInt, FoiResult paramFoiResult)
  {
    if (paramFoiResult == null) {
      throw new NullPointerException();
    }
    ensureResultsIsMutable();
    this.results_.set(paramInt, paramFoiResult);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 200	com/google/internal/tango/foi/v1beta1/MutateFoisReply$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 206	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+281->289, 8:+285->293
    //   56: new 208	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 209	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/foi/v1beta1/MutateFoisReply
    //   67: dup
    //   68: invokespecial 28	com/google/internal/tango/foi/v1beta1/MutateFoisReply:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 30	com/google/internal/tango/foi/v1beta1/MutateFoisReply:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/MutateFoisReply;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 210 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/internal/tango/foi/v1beta1/MutateFoisReply$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 213	com/google/internal/tango/foi/v1beta1/MutateFoisReply$Builder:<init>	(Lcom/google/internal/tango/foi/v1beta1/MutateFoisReply$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 215	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/internal/tango/foi/v1beta1/MutateFoisReply
    //   107: astore_1
    //   108: aload_0
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   114: aload_1
    //   115: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 219 3 0
    //   123: putfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: getstatic 225	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   132: if_acmpne -60 -> 72
    //   135: aload_0
    //   136: areturn
    //   137: aload_2
    //   138: checkcast 227	com/google/protobuf/CodedInputStream
    //   141: astore_1
    //   142: aload_3
    //   143: checkcast 229	com/google/protobuf/ExtensionRegistryLite
    //   146: astore_2
    //   147: iconst_0
    //   148: istore 4
    //   150: iload 4
    //   152: ifne +137 -> 289
    //   155: aload_1
    //   156: invokevirtual 232	com/google/protobuf/CodedInputStream:readTag	()I
    //   159: istore 5
    //   161: iload 5
    //   163: lookupswitch	default:+171->334, 0:+174->337, 18:+41->204
    //   188: aload_0
    //   189: iload 5
    //   191: aload_1
    //   192: invokevirtual 236	com/google/internal/tango/foi/v1beta1/MutateFoisReply:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   195: ifne -45 -> 150
    //   198: iconst_1
    //   199: istore 4
    //   201: goto -51 -> 150
    //   204: aload_0
    //   205: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   208: invokeinterface 121 1 0
    //   213: ifne +14 -> 227
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   221: invokestatic 125	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   224: putfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   227: aload_0
    //   228: getfield 41	com/google/internal/tango/foi/v1beta1/MutateFoisReply:results_	Lcom/google/protobuf/Internal$ProtobufList;
    //   231: aload_1
    //   232: invokestatic 240	com/google/internal/tango/foi/v1beta1/FoiResult:parser	()Lcom/google/protobuf/Parser;
    //   235: aload_2
    //   236: invokevirtual 244	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   239: invokeinterface 117 2 0
    //   244: pop
    //   245: goto -95 -> 150
    //   248: astore_1
    //   249: new 246	java/lang/RuntimeException
    //   252: dup
    //   253: aload_1
    //   254: aload_0
    //   255: invokevirtual 250	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   258: invokespecial 253	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   261: athrow
    //   262: astore_1
    //   263: aload_1
    //   264: athrow
    //   265: astore_1
    //   266: new 246	java/lang/RuntimeException
    //   269: dup
    //   270: new 153	com/google/protobuf/InvalidProtocolBufferException
    //   273: dup
    //   274: aload_1
    //   275: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokespecial 260	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: invokevirtual 250	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   285: invokespecial 253	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   288: athrow
    //   289: getstatic 30	com/google/internal/tango/foi/v1beta1/MutateFoisReply:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/MutateFoisReply;
    //   292: areturn
    //   293: getstatic 262	com/google/internal/tango/foi/v1beta1/MutateFoisReply:PARSER	Lcom/google/protobuf/Parser;
    //   296: ifnonnull +28 -> 324
    //   299: ldc 2
    //   301: monitorenter
    //   302: getstatic 262	com/google/internal/tango/foi/v1beta1/MutateFoisReply:PARSER	Lcom/google/protobuf/Parser;
    //   305: ifnonnull +16 -> 321
    //   308: new 264	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   311: dup
    //   312: getstatic 30	com/google/internal/tango/foi/v1beta1/MutateFoisReply:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/MutateFoisReply;
    //   315: invokespecial 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   318: putstatic 262	com/google/internal/tango/foi/v1beta1/MutateFoisReply:PARSER	Lcom/google/protobuf/Parser;
    //   321: ldc 2
    //   323: monitorexit
    //   324: getstatic 262	com/google/internal/tango/foi/v1beta1/MutateFoisReply:PARSER	Lcom/google/protobuf/Parser;
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
    //   0	343	0	this	MutateFoisReply
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
  
  public FoiResult getResults(int paramInt)
  {
    return (FoiResult)this.results_.get(paramInt);
  }
  
  public int getResultsCount()
  {
    return this.results_.size();
  }
  
  public List<FoiResult> getResultsList()
  {
    return this.results_;
  }
  
  public FoiResultOrBuilder getResultsOrBuilder(int paramInt)
  {
    return (FoiResultOrBuilder)this.results_.get(paramInt);
  }
  
  public List<? extends FoiResultOrBuilder> getResultsOrBuilderList()
  {
    return this.results_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (i < this.results_.size())
    {
      j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.results_.get(i));
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
    while (i < this.results_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.results_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<MutateFoisReply, Builder>
    implements MutateFoisReplyOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllResults(Iterable<? extends FoiResult> paramIterable)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).addAllResults(paramIterable);
      return this;
    }
    
    public Builder addResults(int paramInt, FoiResult.Builder paramBuilder)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).addResults(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addResults(int paramInt, FoiResult paramFoiResult)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).addResults(paramInt, paramFoiResult);
      return this;
    }
    
    public Builder addResults(FoiResult.Builder paramBuilder)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).addResults(paramBuilder);
      return this;
    }
    
    public Builder addResults(FoiResult paramFoiResult)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).addResults(paramFoiResult);
      return this;
    }
    
    public Builder clearResults()
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).clearResults();
      return this;
    }
    
    public FoiResult getResults(int paramInt)
    {
      return ((MutateFoisReply)this.instance).getResults(paramInt);
    }
    
    public int getResultsCount()
    {
      return ((MutateFoisReply)this.instance).getResultsCount();
    }
    
    public List<FoiResult> getResultsList()
    {
      return Collections.unmodifiableList(((MutateFoisReply)this.instance).getResultsList());
    }
    
    public Builder removeResults(int paramInt)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).removeResults(paramInt);
      return this;
    }
    
    public Builder setResults(int paramInt, FoiResult.Builder paramBuilder)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).setResults(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setResults(int paramInt, FoiResult paramFoiResult)
    {
      copyOnWrite();
      ((MutateFoisReply)this.instance).setResults(paramInt, paramFoiResult);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/MutateFoisReply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */