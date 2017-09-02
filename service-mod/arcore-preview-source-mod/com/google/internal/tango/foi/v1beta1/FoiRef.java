package com.google.internal.tango.foi.v1beta1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class FoiRef
  extends GeneratedMessageLite<FoiRef, Builder>
  implements FoiRefOrBuilder
{
  private static final FoiRef DEFAULT_INSTANCE = new FoiRef();
  public static final int ECEF_FIELD_NUMBER = 1;
  private static volatile Parser<FoiRef> PARSER;
  private int bitField0_;
  private int referenceToCase_ = 0;
  private Object referenceTo_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearEcef()
  {
    if (this.referenceToCase_ == 1)
    {
      this.referenceToCase_ = 0;
      this.referenceTo_ = null;
    }
  }
  
  private void clearReferenceTo()
  {
    this.referenceToCase_ = 0;
    this.referenceTo_ = null;
  }
  
  public static FoiRef getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FoiRef paramFoiRef)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFoiRef);
  }
  
  public static FoiRef parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FoiRef)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FoiRef parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiRef)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiRef parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FoiRef parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FoiRef parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FoiRef parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiRef parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FoiRef parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FoiRef parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static FoiRef parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FoiRef)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FoiRef> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setEcef(boolean paramBoolean)
  {
    this.referenceToCase_ = 1;
    this.referenceTo_ = Boolean.valueOf(paramBoolean);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: getstatic 134	com/google/internal/tango/foi/v1beta1/FoiRef$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   9: aload_1
    //   10: invokevirtual 140	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   13: iaload
    //   14: tableswitch	default:+46->60, 1:+54->68, 2:+64->78, 3:+68->82, 4:+70->84, 5:+79->93, 6:+226->240, 7:+354->368, 8:+358->372
    //   60: new 142	java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial 143	java/lang/UnsupportedOperationException:<init>	()V
    //   67: athrow
    //   68: new 2	com/google/internal/tango/foi/v1beta1/FoiRef
    //   71: dup
    //   72: invokespecial 32	com/google/internal/tango/foi/v1beta1/FoiRef:<init>	()V
    //   75: astore_1
    //   76: aload_1
    //   77: areturn
    //   78: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiRef:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   81: areturn
    //   82: aconst_null
    //   83: areturn
    //   84: new 11	com/google/internal/tango/foi/v1beta1/FoiRef$Builder
    //   87: dup
    //   88: aconst_null
    //   89: invokespecial 146	com/google/internal/tango/foi/v1beta1/FoiRef$Builder:<init>	(Lcom/google/internal/tango/foi/v1beta1/FoiRef$1;)V
    //   92: areturn
    //   93: aload_2
    //   94: checkcast 148	com/google/protobuf/GeneratedMessageLite$Visitor
    //   97: astore_2
    //   98: aload_3
    //   99: checkcast 2	com/google/internal/tango/foi/v1beta1/FoiRef
    //   102: astore_3
    //   103: getstatic 151	com/google/internal/tango/foi/v1beta1/FoiRef$1:$SwitchMap$com$google$internal$tango$foi$v1beta1$FoiRef$ReferenceToCase	[I
    //   106: aload_3
    //   107: invokevirtual 155	com/google/internal/tango/foi/v1beta1/FoiRef:getReferenceToCase	()Lcom/google/internal/tango/foi/v1beta1/FoiRef$ReferenceToCase;
    //   110: invokevirtual 156	com/google/internal/tango/foi/v1beta1/FoiRef$ReferenceToCase:ordinal	()I
    //   113: iaload
    //   114: tableswitch	default:+22->136, 1:+61->175, 2:+98->212
    //   136: aload_0
    //   137: astore_1
    //   138: aload_2
    //   139: getstatic 162	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   142: if_acmpne -66 -> 76
    //   145: aload_3
    //   146: getfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   149: ifeq +11 -> 160
    //   152: aload_0
    //   153: aload_3
    //   154: getfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   157: putfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 164	com/google/internal/tango/foi/v1beta1/FoiRef:bitField0_	I
    //   165: aload_3
    //   166: getfield 164	com/google/internal/tango/foi/v1beta1/FoiRef:bitField0_	I
    //   169: ior
    //   170: putfield 164	com/google/internal/tango/foi/v1beta1/FoiRef:bitField0_	I
    //   173: aload_0
    //   174: areturn
    //   175: aload_0
    //   176: getfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   179: iconst_1
    //   180: if_icmpne +26 -> 206
    //   183: aload_0
    //   184: aload_2
    //   185: iload 6
    //   187: aload_0
    //   188: getfield 60	com/google/internal/tango/foi/v1beta1/FoiRef:referenceTo_	Ljava/lang/Object;
    //   191: aload_3
    //   192: getfield 60	com/google/internal/tango/foi/v1beta1/FoiRef:referenceTo_	Ljava/lang/Object;
    //   195: invokeinterface 168 4 0
    //   200: putfield 60	com/google/internal/tango/foi/v1beta1/FoiRef:referenceTo_	Ljava/lang/Object;
    //   203: goto -67 -> 136
    //   206: iconst_0
    //   207: istore 6
    //   209: goto -26 -> 183
    //   212: aload_0
    //   213: getfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   216: ifeq +18 -> 234
    //   219: iload 7
    //   221: istore 6
    //   223: aload_2
    //   224: iload 6
    //   226: invokeinterface 171 2 0
    //   231: goto -95 -> 136
    //   234: iconst_0
    //   235: istore 6
    //   237: goto -14 -> 223
    //   240: aload_2
    //   241: checkcast 173	com/google/protobuf/CodedInputStream
    //   244: astore_1
    //   245: aload_3
    //   246: checkcast 175	com/google/protobuf/ExtensionRegistryLite
    //   249: astore_2
    //   250: iconst_0
    //   251: istore 4
    //   253: iload 4
    //   255: ifne +113 -> 368
    //   258: aload_1
    //   259: invokevirtual 178	com/google/protobuf/CodedInputStream:readTag	()I
    //   262: istore 5
    //   264: iload 5
    //   266: lookupswitch	default:+147->413, 0:+150->416, 8:+42->308
    //   292: aload_0
    //   293: iload 5
    //   295: aload_1
    //   296: invokevirtual 182	com/google/internal/tango/foi/v1beta1/FoiRef:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   299: ifne -46 -> 253
    //   302: iconst_1
    //   303: istore 4
    //   305: goto -52 -> 253
    //   308: aload_0
    //   309: iconst_1
    //   310: putfield 41	com/google/internal/tango/foi/v1beta1/FoiRef:referenceToCase_	I
    //   313: aload_0
    //   314: aload_1
    //   315: invokevirtual 186	com/google/protobuf/CodedInputStream:readBool	()Z
    //   318: invokestatic 128	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   321: putfield 60	com/google/internal/tango/foi/v1beta1/FoiRef:referenceTo_	Ljava/lang/Object;
    //   324: goto -71 -> 253
    //   327: astore_1
    //   328: new 188	java/lang/RuntimeException
    //   331: dup
    //   332: aload_1
    //   333: aload_0
    //   334: invokevirtual 192	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   337: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   340: athrow
    //   341: astore_1
    //   342: aload_1
    //   343: athrow
    //   344: astore_1
    //   345: new 188	java/lang/RuntimeException
    //   348: dup
    //   349: new 88	com/google/protobuf/InvalidProtocolBufferException
    //   352: dup
    //   353: aload_1
    //   354: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   357: invokespecial 202	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   360: aload_0
    //   361: invokevirtual 192	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   364: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   367: athrow
    //   368: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiRef:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   371: areturn
    //   372: getstatic 204	com/google/internal/tango/foi/v1beta1/FoiRef:PARSER	Lcom/google/protobuf/Parser;
    //   375: ifnonnull +28 -> 403
    //   378: ldc 2
    //   380: monitorenter
    //   381: getstatic 204	com/google/internal/tango/foi/v1beta1/FoiRef:PARSER	Lcom/google/protobuf/Parser;
    //   384: ifnonnull +16 -> 400
    //   387: new 206	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   390: dup
    //   391: getstatic 34	com/google/internal/tango/foi/v1beta1/FoiRef:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/FoiRef;
    //   394: invokespecial 209	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   397: putstatic 204	com/google/internal/tango/foi/v1beta1/FoiRef:PARSER	Lcom/google/protobuf/Parser;
    //   400: ldc 2
    //   402: monitorexit
    //   403: getstatic 204	com/google/internal/tango/foi/v1beta1/FoiRef:PARSER	Lcom/google/protobuf/Parser;
    //   406: areturn
    //   407: astore_1
    //   408: ldc 2
    //   410: monitorexit
    //   411: aload_1
    //   412: athrow
    //   413: goto -121 -> 292
    //   416: iconst_1
    //   417: istore 4
    //   419: goto -166 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	FoiRef
    //   0	422	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	422	2	paramObject1	Object
    //   0	422	3	paramObject2	Object
    //   251	167	4	i	int
    //   262	32	5	j	int
    //   4	232	6	bool1	boolean
    //   1	219	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   258	264	327	com/google/protobuf/InvalidProtocolBufferException
    //   292	302	327	com/google/protobuf/InvalidProtocolBufferException
    //   308	324	327	com/google/protobuf/InvalidProtocolBufferException
    //   258	264	341	finally
    //   292	302	341	finally
    //   308	324	341	finally
    //   328	341	341	finally
    //   345	368	341	finally
    //   258	264	344	java/io/IOException
    //   292	302	344	java/io/IOException
    //   308	324	344	java/io/IOException
    //   381	400	407	finally
    //   400	403	407	finally
    //   408	411	407	finally
  }
  
  public boolean getEcef()
  {
    if (this.referenceToCase_ == 1) {
      return ((Boolean)this.referenceTo_).booleanValue();
    }
    return false;
  }
  
  public ReferenceToCase getReferenceToCase()
  {
    return ReferenceToCase.forNumber(this.referenceToCase_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (this.referenceToCase_ == 1) {
      i = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean)this.referenceTo_).booleanValue());
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasEcef()
  {
    return this.referenceToCase_ == 1;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.referenceToCase_ == 1) {
      paramCodedOutputStream.writeBool(1, ((Boolean)this.referenceTo_).booleanValue());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<FoiRef, Builder>
    implements FoiRefOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearEcef()
    {
      copyOnWrite();
      ((FoiRef)this.instance).clearEcef();
      return this;
    }
    
    public Builder clearReferenceTo()
    {
      copyOnWrite();
      ((FoiRef)this.instance).clearReferenceTo();
      return this;
    }
    
    public boolean getEcef()
    {
      return ((FoiRef)this.instance).getEcef();
    }
    
    public FoiRef.ReferenceToCase getReferenceToCase()
    {
      return ((FoiRef)this.instance).getReferenceToCase();
    }
    
    public boolean hasEcef()
    {
      return ((FoiRef)this.instance).hasEcef();
    }
    
    public Builder setEcef(boolean paramBoolean)
    {
      copyOnWrite();
      ((FoiRef)this.instance).setEcef(paramBoolean);
      return this;
    }
  }
  
  public static enum ReferenceToCase
    implements Internal.EnumLite
  {
    ECEF(1),  REFERENCETO_NOT_SET(0);
    
    private final int value;
    
    private ReferenceToCase(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static ReferenceToCase forNumber(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ECEF;
      }
      return REFERENCETO_NOT_SET;
    }
    
    @Deprecated
    public static ReferenceToCase valueOf(int paramInt)
    {
      return forNumber(paramInt);
    }
    
    public int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/FoiRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */