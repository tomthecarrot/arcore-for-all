package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class ListValue
  extends GeneratedMessageLite<ListValue, Builder>
  implements ListValueOrBuilder
{
  private static final ListValue DEFAULT_INSTANCE = new ListValue();
  private static volatile Parser<ListValue> PARSER;
  public static final int VALUES_FIELD_NUMBER = 1;
  private Internal.ProtobufList<Value> values_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllValues(Iterable<? extends Value> paramIterable)
  {
    ensureValuesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.values_);
  }
  
  private void addValues(int paramInt, Value.Builder paramBuilder)
  {
    ensureValuesIsMutable();
    this.values_.add(paramInt, paramBuilder.build());
  }
  
  private void addValues(int paramInt, Value paramValue)
  {
    if (paramValue == null) {
      throw new NullPointerException();
    }
    ensureValuesIsMutable();
    this.values_.add(paramInt, paramValue);
  }
  
  private void addValues(Value.Builder paramBuilder)
  {
    ensureValuesIsMutable();
    this.values_.add(paramBuilder.build());
  }
  
  private void addValues(Value paramValue)
  {
    if (paramValue == null) {
      throw new NullPointerException();
    }
    ensureValuesIsMutable();
    this.values_.add(paramValue);
  }
  
  private void clearValues()
  {
    this.values_ = emptyProtobufList();
  }
  
  private void ensureValuesIsMutable()
  {
    if (!this.values_.isModifiable()) {
      this.values_ = GeneratedMessageLite.mutableCopy(this.values_);
    }
  }
  
  public static ListValue getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListValue paramListValue)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListValue);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ListValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ListValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ListValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListValue> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeValues(int paramInt)
  {
    ensureValuesIsMutable();
    this.values_.remove(paramInt);
  }
  
  private void setValues(int paramInt, Value.Builder paramBuilder)
  {
    ensureValuesIsMutable();
    this.values_.set(paramInt, paramBuilder.build());
  }
  
  private void setValues(int paramInt, Value paramValue)
  {
    if (paramValue == null) {
      throw new NullPointerException();
    }
    ensureValuesIsMutable();
    this.values_.set(paramInt, paramValue);
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 200	com/google/protobuf/ListValue$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 206	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+280->288, 8:+284->292
    //   56: new 208	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 209	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/ListValue
    //   67: dup
    //   68: invokespecial 28	com/google/protobuf/ListValue:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 30	com/google/protobuf/ListValue:DEFAULT_INSTANCE	Lcom/google/protobuf/ListValue;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 210 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: new 11	com/google/protobuf/ListValue$Builder
    //   92: dup
    //   93: aconst_null
    //   94: invokespecial 213	com/google/protobuf/ListValue$Builder:<init>	(Lcom/google/protobuf/ListValue$1;)V
    //   97: areturn
    //   98: aload_2
    //   99: checkcast 215	com/google/protobuf/GeneratedMessageLite$Visitor
    //   102: astore_2
    //   103: aload_3
    //   104: checkcast 2	com/google/protobuf/ListValue
    //   107: astore_1
    //   108: aload_0
    //   109: aload_2
    //   110: aload_0
    //   111: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   114: aload_1
    //   115: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 219 3 0
    //   123: putfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
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
    //   152: ifne +136 -> 288
    //   155: aload_1
    //   156: invokevirtual 232	com/google/protobuf/CodedInputStream:readTag	()I
    //   159: istore 5
    //   161: iload 5
    //   163: lookupswitch	default:+170->333, 0:+173->336, 10:+40->203
    //   188: aload_1
    //   189: iload 5
    //   191: invokevirtual 236	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   194: ifne -44 -> 150
    //   197: iconst_1
    //   198: istore 4
    //   200: goto -50 -> 150
    //   203: aload_0
    //   204: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   207: invokeinterface 121 1 0
    //   212: ifne +14 -> 226
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   220: invokestatic 125	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   223: putfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   226: aload_0
    //   227: getfield 41	com/google/protobuf/ListValue:values_	Lcom/google/protobuf/Internal$ProtobufList;
    //   230: aload_1
    //   231: invokestatic 240	com/google/protobuf/Value:parser	()Lcom/google/protobuf/Parser;
    //   234: aload_2
    //   235: invokevirtual 244	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   238: invokeinterface 117 2 0
    //   243: pop
    //   244: goto -94 -> 150
    //   247: astore_1
    //   248: new 246	java/lang/RuntimeException
    //   251: dup
    //   252: aload_1
    //   253: aload_0
    //   254: invokevirtual 250	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial 253	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   260: athrow
    //   261: astore_1
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: new 246	java/lang/RuntimeException
    //   268: dup
    //   269: new 153	com/google/protobuf/InvalidProtocolBufferException
    //   272: dup
    //   273: aload_1
    //   274: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   277: invokespecial 260	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   280: aload_0
    //   281: invokevirtual 250	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   284: invokespecial 253	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   287: athrow
    //   288: getstatic 30	com/google/protobuf/ListValue:DEFAULT_INSTANCE	Lcom/google/protobuf/ListValue;
    //   291: areturn
    //   292: getstatic 262	com/google/protobuf/ListValue:PARSER	Lcom/google/protobuf/Parser;
    //   295: ifnonnull +28 -> 323
    //   298: ldc 2
    //   300: monitorenter
    //   301: getstatic 262	com/google/protobuf/ListValue:PARSER	Lcom/google/protobuf/Parser;
    //   304: ifnonnull +16 -> 320
    //   307: new 264	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   310: dup
    //   311: getstatic 30	com/google/protobuf/ListValue:DEFAULT_INSTANCE	Lcom/google/protobuf/ListValue;
    //   314: invokespecial 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   317: putstatic 262	com/google/protobuf/ListValue:PARSER	Lcom/google/protobuf/Parser;
    //   320: ldc 2
    //   322: monitorexit
    //   323: getstatic 262	com/google/protobuf/ListValue:PARSER	Lcom/google/protobuf/Parser;
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
    //   0	342	0	this	ListValue
    //   0	342	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
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
    while (i < this.values_.size())
    {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(i));
      i += 1;
    }
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Value getValues(int paramInt)
  {
    return (Value)this.values_.get(paramInt);
  }
  
  public int getValuesCount()
  {
    return this.values_.size();
  }
  
  public List<Value> getValuesList()
  {
    return this.values_;
  }
  
  public ValueOrBuilder getValuesOrBuilder(int paramInt)
  {
    return (ValueOrBuilder)this.values_.get(paramInt);
  }
  
  public List<? extends ValueOrBuilder> getValuesOrBuilderList()
  {
    return this.values_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.values_.size())
    {
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.values_.get(i));
      i += 1;
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<ListValue, Builder>
    implements ListValueOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllValues(Iterable<? extends Value> paramIterable)
    {
      copyOnWrite();
      ((ListValue)this.instance).addAllValues(paramIterable);
      return this;
    }
    
    public Builder addValues(int paramInt, Value.Builder paramBuilder)
    {
      copyOnWrite();
      ((ListValue)this.instance).addValues(paramInt, paramBuilder);
      return this;
    }
    
    public Builder addValues(int paramInt, Value paramValue)
    {
      copyOnWrite();
      ((ListValue)this.instance).addValues(paramInt, paramValue);
      return this;
    }
    
    public Builder addValues(Value.Builder paramBuilder)
    {
      copyOnWrite();
      ((ListValue)this.instance).addValues(paramBuilder);
      return this;
    }
    
    public Builder addValues(Value paramValue)
    {
      copyOnWrite();
      ((ListValue)this.instance).addValues(paramValue);
      return this;
    }
    
    public Builder clearValues()
    {
      copyOnWrite();
      ((ListValue)this.instance).clearValues();
      return this;
    }
    
    public Value getValues(int paramInt)
    {
      return ((ListValue)this.instance).getValues(paramInt);
    }
    
    public int getValuesCount()
    {
      return ((ListValue)this.instance).getValuesCount();
    }
    
    public List<Value> getValuesList()
    {
      return Collections.unmodifiableList(((ListValue)this.instance).getValuesList());
    }
    
    public Builder removeValues(int paramInt)
    {
      copyOnWrite();
      ((ListValue)this.instance).removeValues(paramInt);
      return this;
    }
    
    public Builder setValues(int paramInt, Value.Builder paramBuilder)
    {
      copyOnWrite();
      ((ListValue)this.instance).setValues(paramInt, paramBuilder);
      return this;
    }
    
    public Builder setValues(int paramInt, Value paramValue)
    {
      copyOnWrite();
      ((ListValue)this.instance).setValues(paramInt, paramValue);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ListValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */