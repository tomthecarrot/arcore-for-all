package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class FloatValue
  extends GeneratedMessageLite<FloatValue, Builder>
  implements FloatValueOrBuilder
{
  private static final FloatValue DEFAULT_INSTANCE = new FloatValue();
  private static volatile Parser<FloatValue> PARSER;
  public static final int VALUE_FIELD_NUMBER = 1;
  private float value_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue()
  {
    this.value_ = 0.0F;
  }
  
  public static FloatValue getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FloatValue paramFloatValue)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFloatValue);
  }
  
  public static FloatValue parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FloatValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FloatValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FloatValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FloatValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FloatValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FloatValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static FloatValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (FloatValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<FloatValue> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(float paramFloat)
  {
    this.value_ = paramFloat;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 117	com/google/protobuf/FloatValue$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 123	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+164->172, 7:+283->291, 8:+287->295
    //   56: new 125	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 126	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/FloatValue
    //   67: dup
    //   68: invokespecial 27	com/google/protobuf/FloatValue:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 29	com/google/protobuf/FloatValue:DEFAULT_INSTANCE	Lcom/google/protobuf/FloatValue;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/FloatValue$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 129	com/google/protobuf/FloatValue$Builder:<init>	(Lcom/google/protobuf/FloatValue$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 131	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/FloatValue
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 49	com/google/protobuf/FloatValue:value_	F
    //   103: fconst_0
    //   104: fcmpl
    //   105: ifeq +55 -> 160
    //   108: iconst_1
    //   109: istore 7
    //   111: aload_0
    //   112: getfield 49	com/google/protobuf/FloatValue:value_	F
    //   115: fstore 4
    //   117: aload_1
    //   118: getfield 49	com/google/protobuf/FloatValue:value_	F
    //   121: fconst_0
    //   122: fcmpl
    //   123: ifeq +43 -> 166
    //   126: iconst_1
    //   127: istore 8
    //   129: aload_0
    //   130: aload_2
    //   131: iload 7
    //   133: fload 4
    //   135: iload 8
    //   137: aload_1
    //   138: getfield 49	com/google/protobuf/FloatValue:value_	F
    //   141: invokeinterface 135 5 0
    //   146: putfield 49	com/google/protobuf/FloatValue:value_	F
    //   149: aload_0
    //   150: astore_1
    //   151: aload_2
    //   152: getstatic 141	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   155: if_acmpne -83 -> 72
    //   158: aload_0
    //   159: areturn
    //   160: iconst_0
    //   161: istore 7
    //   163: goto -52 -> 111
    //   166: iconst_0
    //   167: istore 8
    //   169: goto -40 -> 129
    //   172: aload_2
    //   173: checkcast 143	com/google/protobuf/CodedInputStream
    //   176: astore_1
    //   177: aload_3
    //   178: checkcast 145	com/google/protobuf/ExtensionRegistryLite
    //   181: astore_2
    //   182: iconst_0
    //   183: istore 5
    //   185: iload 5
    //   187: ifne +104 -> 291
    //   190: aload_1
    //   191: invokevirtual 148	com/google/protobuf/CodedInputStream:readTag	()I
    //   194: istore 6
    //   196: iload 6
    //   198: lookupswitch	default:+138->336, 0:+141->339, 13:+41->239
    //   224: aload_1
    //   225: iload 6
    //   227: invokevirtual 152	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   230: ifne -45 -> 185
    //   233: iconst_1
    //   234: istore 5
    //   236: goto -51 -> 185
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 156	com/google/protobuf/CodedInputStream:readFloat	()F
    //   244: putfield 49	com/google/protobuf/FloatValue:value_	F
    //   247: goto -62 -> 185
    //   250: astore_1
    //   251: new 158	java/lang/RuntimeException
    //   254: dup
    //   255: aload_1
    //   256: aload_0
    //   257: invokevirtual 162	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   260: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   263: athrow
    //   264: astore_1
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: new 158	java/lang/RuntimeException
    //   271: dup
    //   272: new 77	com/google/protobuf/InvalidProtocolBufferException
    //   275: dup
    //   276: aload_1
    //   277: invokevirtual 169	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokespecial 172	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 162	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   287: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   290: athrow
    //   291: getstatic 29	com/google/protobuf/FloatValue:DEFAULT_INSTANCE	Lcom/google/protobuf/FloatValue;
    //   294: areturn
    //   295: getstatic 174	com/google/protobuf/FloatValue:PARSER	Lcom/google/protobuf/Parser;
    //   298: ifnonnull +28 -> 326
    //   301: ldc 2
    //   303: monitorenter
    //   304: getstatic 174	com/google/protobuf/FloatValue:PARSER	Lcom/google/protobuf/Parser;
    //   307: ifnonnull +16 -> 323
    //   310: new 176	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   313: dup
    //   314: getstatic 29	com/google/protobuf/FloatValue:DEFAULT_INSTANCE	Lcom/google/protobuf/FloatValue;
    //   317: invokespecial 179	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   320: putstatic 174	com/google/protobuf/FloatValue:PARSER	Lcom/google/protobuf/Parser;
    //   323: ldc 2
    //   325: monitorexit
    //   326: getstatic 174	com/google/protobuf/FloatValue:PARSER	Lcom/google/protobuf/Parser;
    //   329: areturn
    //   330: astore_1
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload_1
    //   335: athrow
    //   336: goto -112 -> 224
    //   339: iconst_1
    //   340: istore 5
    //   342: goto -157 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	FloatValue
    //   0	345	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	345	2	paramObject1	Object
    //   0	345	3	paramObject2	Object
    //   115	19	4	f	float
    //   183	158	5	i	int
    //   194	32	6	j	int
    //   109	53	7	bool1	boolean
    //   127	41	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   190	196	250	com/google/protobuf/InvalidProtocolBufferException
    //   224	233	250	com/google/protobuf/InvalidProtocolBufferException
    //   239	247	250	com/google/protobuf/InvalidProtocolBufferException
    //   190	196	264	finally
    //   224	233	264	finally
    //   239	247	264	finally
    //   251	264	264	finally
    //   268	291	264	finally
    //   190	196	267	java/io/IOException
    //   224	233	267	java/io/IOException
    //   239	247	267	java/io/IOException
    //   304	323	330	finally
    //   323	326	330	finally
    //   331	334	330	finally
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (this.value_ != 0.0F) {
      i = 0 + CodedOutputStream.computeFloatSize(1, this.value_);
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public float getValue()
  {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.value_ != 0.0F) {
      paramCodedOutputStream.writeFloat(1, this.value_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<FloatValue, Builder>
    implements FloatValueOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearValue()
    {
      copyOnWrite();
      ((FloatValue)this.instance).clearValue();
      return this;
    }
    
    public float getValue()
    {
      return ((FloatValue)this.instance).getValue();
    }
    
    public Builder setValue(float paramFloat)
    {
      copyOnWrite();
      ((FloatValue)this.instance).setValue(paramFloat);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FloatValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */