package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class BoolValue
  extends GeneratedMessageLite<BoolValue, Builder>
  implements BoolValueOrBuilder
{
  private static final BoolValue DEFAULT_INSTANCE = new BoolValue();
  private static volatile Parser<BoolValue> PARSER;
  public static final int VALUE_FIELD_NUMBER = 1;
  private boolean value_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue()
  {
    this.value_ = false;
  }
  
  public static BoolValue getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BoolValue paramBoolValue)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBoolValue);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (BoolValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<BoolValue> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(boolean paramBoolean)
  {
    this.value_ = paramBoolean;
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: getstatic 117	com/google/protobuf/BoolValue$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   6: aload_1
    //   7: invokevirtual 123	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   10: iaload
    //   11: tableswitch	default:+45->56, 1:+53->64, 2:+63->74, 3:+67->78, 4:+69->80, 5:+78->89, 6:+154->165, 7:+272->283, 8:+276->287
    //   56: new 125	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 126	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/BoolValue
    //   67: dup
    //   68: invokespecial 27	com/google/protobuf/BoolValue:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 29	com/google/protobuf/BoolValue:DEFAULT_INSTANCE	Lcom/google/protobuf/BoolValue;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/google/protobuf/BoolValue$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 129	com/google/protobuf/BoolValue$Builder:<init>	(Lcom/google/protobuf/BoolValue$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 131	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/google/protobuf/BoolValue
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 49	com/google/protobuf/BoolValue:value_	Z
    //   103: ifeq +50 -> 153
    //   106: iconst_1
    //   107: istore 6
    //   109: aload_0
    //   110: getfield 49	com/google/protobuf/BoolValue:value_	Z
    //   113: istore 8
    //   115: aload_1
    //   116: getfield 49	com/google/protobuf/BoolValue:value_	Z
    //   119: ifeq +40 -> 159
    //   122: aload_0
    //   123: aload_2
    //   124: iload 6
    //   126: iload 8
    //   128: iload 7
    //   130: aload_1
    //   131: getfield 49	com/google/protobuf/BoolValue:value_	Z
    //   134: invokeinterface 135 5 0
    //   139: putfield 49	com/google/protobuf/BoolValue:value_	Z
    //   142: aload_0
    //   143: astore_1
    //   144: aload_2
    //   145: getstatic 141	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   148: if_acmpne -76 -> 72
    //   151: aload_0
    //   152: areturn
    //   153: iconst_0
    //   154: istore 6
    //   156: goto -47 -> 109
    //   159: iconst_0
    //   160: istore 7
    //   162: goto -40 -> 122
    //   165: aload_2
    //   166: checkcast 143	com/google/protobuf/CodedInputStream
    //   169: astore_1
    //   170: aload_3
    //   171: checkcast 145	com/google/protobuf/ExtensionRegistryLite
    //   174: astore_2
    //   175: iconst_0
    //   176: istore 4
    //   178: iload 4
    //   180: ifne +103 -> 283
    //   183: aload_1
    //   184: invokevirtual 148	com/google/protobuf/CodedInputStream:readTag	()I
    //   187: istore 5
    //   189: iload 5
    //   191: lookupswitch	default:+137->328, 0:+140->331, 8:+40->231
    //   216: aload_1
    //   217: iload 5
    //   219: invokevirtual 152	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   222: ifne -44 -> 178
    //   225: iconst_1
    //   226: istore 4
    //   228: goto -50 -> 178
    //   231: aload_0
    //   232: aload_1
    //   233: invokevirtual 156	com/google/protobuf/CodedInputStream:readBool	()Z
    //   236: putfield 49	com/google/protobuf/BoolValue:value_	Z
    //   239: goto -61 -> 178
    //   242: astore_1
    //   243: new 158	java/lang/RuntimeException
    //   246: dup
    //   247: aload_1
    //   248: aload_0
    //   249: invokevirtual 162	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   252: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   255: athrow
    //   256: astore_1
    //   257: aload_1
    //   258: athrow
    //   259: astore_1
    //   260: new 158	java/lang/RuntimeException
    //   263: dup
    //   264: new 77	com/google/protobuf/InvalidProtocolBufferException
    //   267: dup
    //   268: aload_1
    //   269: invokevirtual 169	java/io/IOException:getMessage	()Ljava/lang/String;
    //   272: invokespecial 172	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   275: aload_0
    //   276: invokevirtual 162	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   279: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   282: athrow
    //   283: getstatic 29	com/google/protobuf/BoolValue:DEFAULT_INSTANCE	Lcom/google/protobuf/BoolValue;
    //   286: areturn
    //   287: getstatic 174	com/google/protobuf/BoolValue:PARSER	Lcom/google/protobuf/Parser;
    //   290: ifnonnull +28 -> 318
    //   293: ldc 2
    //   295: monitorenter
    //   296: getstatic 174	com/google/protobuf/BoolValue:PARSER	Lcom/google/protobuf/Parser;
    //   299: ifnonnull +16 -> 315
    //   302: new 176	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   305: dup
    //   306: getstatic 29	com/google/protobuf/BoolValue:DEFAULT_INSTANCE	Lcom/google/protobuf/BoolValue;
    //   309: invokespecial 179	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   312: putstatic 174	com/google/protobuf/BoolValue:PARSER	Lcom/google/protobuf/Parser;
    //   315: ldc 2
    //   317: monitorexit
    //   318: getstatic 174	com/google/protobuf/BoolValue:PARSER	Lcom/google/protobuf/Parser;
    //   321: areturn
    //   322: astore_1
    //   323: ldc 2
    //   325: monitorexit
    //   326: aload_1
    //   327: athrow
    //   328: goto -112 -> 216
    //   331: iconst_1
    //   332: istore 4
    //   334: goto -156 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	BoolValue
    //   0	337	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	337	2	paramObject1	Object
    //   0	337	3	paramObject2	Object
    //   176	157	4	i	int
    //   187	31	5	j	int
    //   107	48	6	bool1	boolean
    //   1	160	7	bool2	boolean
    //   113	14	8	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   183	189	242	com/google/protobuf/InvalidProtocolBufferException
    //   216	225	242	com/google/protobuf/InvalidProtocolBufferException
    //   231	239	242	com/google/protobuf/InvalidProtocolBufferException
    //   183	189	256	finally
    //   216	225	256	finally
    //   231	239	256	finally
    //   243	256	256	finally
    //   260	283	256	finally
    //   183	189	259	java/io/IOException
    //   216	225	259	java/io/IOException
    //   231	239	259	java/io/IOException
    //   296	315	322	finally
    //   315	318	322	finally
    //   323	326	322	finally
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (this.value_) {
      i = 0 + CodedOutputStream.computeBoolSize(1, this.value_);
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean getValue()
  {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if (this.value_) {
      paramCodedOutputStream.writeBool(1, this.value_);
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<BoolValue, Builder>
    implements BoolValueOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearValue()
    {
      copyOnWrite();
      ((BoolValue)this.instance).clearValue();
      return this;
    }
    
    public boolean getValue()
    {
      return ((BoolValue)this.instance).getValue();
    }
    
    public Builder setValue(boolean paramBoolean)
    {
      copyOnWrite();
      ((BoolValue)this.instance).setValue(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/BoolValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */