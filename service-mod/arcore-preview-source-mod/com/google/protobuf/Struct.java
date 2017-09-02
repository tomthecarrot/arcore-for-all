package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Struct
  extends GeneratedMessageLite<Struct, Builder>
  implements StructOrBuilder
{
  private static final Struct DEFAULT_INSTANCE = new Struct();
  public static final int FIELDS_FIELD_NUMBER = 1;
  private static volatile Parser<Struct> PARSER;
  private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static Struct getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Value> getMutableFieldsMap()
  {
    return internalGetMutableFields();
  }
  
  private MapFieldLite<String, Value> internalGetFields()
  {
    return this.fields_;
  }
  
  private MapFieldLite<String, Value> internalGetMutableFields()
  {
    if (!this.fields_.isMutable()) {
      this.fields_ = this.fields_.mutableCopy();
    }
    return this.fields_;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Struct paramStruct)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramStruct);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Struct)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Struct)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Struct parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Struct parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Struct)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Struct> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  public boolean containsFields(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    return internalGetFields().containsKey(paramString);
  }
  
  /* Error */
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 146	com/google/protobuf/Struct$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 152	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+79->87, 5:+88->96, 6:+127->135, 7:+272->280, 8:+276->284
    //   56: new 154	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 155	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/protobuf/Struct
    //   67: dup
    //   68: invokespecial 31	com/google/protobuf/Struct:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 33	com/google/protobuf/Struct:DEFAULT_INSTANCE	Lcom/google/protobuf/Struct;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   82: invokevirtual 156	com/google/protobuf/MapFieldLite:makeImmutable	()V
    //   85: aconst_null
    //   86: areturn
    //   87: new 11	com/google/protobuf/Struct$Builder
    //   90: dup
    //   91: aconst_null
    //   92: invokespecial 159	com/google/protobuf/Struct$Builder:<init>	(Lcom/google/protobuf/Struct$1;)V
    //   95: areturn
    //   96: aload_2
    //   97: checkcast 161	com/google/protobuf/GeneratedMessageLite$Visitor
    //   100: astore_2
    //   101: aload_3
    //   102: checkcast 2	com/google/protobuf/Struct
    //   105: astore_1
    //   106: aload_0
    //   107: aload_2
    //   108: aload_0
    //   109: getfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   112: aload_1
    //   113: invokespecial 136	com/google/protobuf/Struct:internalGetFields	()Lcom/google/protobuf/MapFieldLite;
    //   116: invokeinterface 165 3 0
    //   121: putfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   124: aload_0
    //   125: astore_1
    //   126: aload_2
    //   127: getstatic 171	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   130: if_acmpne -58 -> 72
    //   133: aload_0
    //   134: areturn
    //   135: aload_2
    //   136: checkcast 173	com/google/protobuf/CodedInputStream
    //   139: astore_1
    //   140: aload_3
    //   141: checkcast 175	com/google/protobuf/ExtensionRegistryLite
    //   144: astore_2
    //   145: iconst_0
    //   146: istore 4
    //   148: iload 4
    //   150: ifne +130 -> 280
    //   153: aload_1
    //   154: invokevirtual 178	com/google/protobuf/CodedInputStream:readTag	()I
    //   157: istore 5
    //   159: iload 5
    //   161: lookupswitch	default:+164->325, 0:+167->328, 10:+42->203
    //   188: aload_1
    //   189: iload 5
    //   191: invokevirtual 182	com/google/protobuf/CodedInputStream:skipField	(I)Z
    //   194: ifne -46 -> 148
    //   197: iconst_1
    //   198: istore 4
    //   200: goto -52 -> 148
    //   203: aload_0
    //   204: getfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   207: invokevirtual 66	com/google/protobuf/MapFieldLite:isMutable	()Z
    //   210: ifne +14 -> 224
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   218: invokevirtual 69	com/google/protobuf/MapFieldLite:mutableCopy	()Lcom/google/protobuf/MapFieldLite;
    //   221: putfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   224: getstatic 186	com/google/protobuf/Struct$FieldsDefaultEntryHolder:defaultEntry	Lcom/google/protobuf/MapEntryLite;
    //   227: aload_0
    //   228: getfield 46	com/google/protobuf/Struct:fields_	Lcom/google/protobuf/MapFieldLite;
    //   231: aload_1
    //   232: aload_2
    //   233: invokevirtual 192	com/google/protobuf/MapEntryLite:parseInto	(Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   236: goto -88 -> 148
    //   239: astore_1
    //   240: new 194	java/lang/RuntimeException
    //   243: dup
    //   244: aload_1
    //   245: aload_0
    //   246: invokevirtual 198	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   249: invokespecial 201	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   252: athrow
    //   253: astore_1
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: new 194	java/lang/RuntimeException
    //   260: dup
    //   261: new 96	com/google/protobuf/InvalidProtocolBufferException
    //   264: dup
    //   265: aload_1
    //   266: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: invokespecial 208	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: invokevirtual 198	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   276: invokespecial 201	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   279: athrow
    //   280: getstatic 33	com/google/protobuf/Struct:DEFAULT_INSTANCE	Lcom/google/protobuf/Struct;
    //   283: areturn
    //   284: getstatic 210	com/google/protobuf/Struct:PARSER	Lcom/google/protobuf/Parser;
    //   287: ifnonnull +28 -> 315
    //   290: ldc 2
    //   292: monitorenter
    //   293: getstatic 210	com/google/protobuf/Struct:PARSER	Lcom/google/protobuf/Parser;
    //   296: ifnonnull +16 -> 312
    //   299: new 212	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   302: dup
    //   303: getstatic 33	com/google/protobuf/Struct:DEFAULT_INSTANCE	Lcom/google/protobuf/Struct;
    //   306: invokespecial 215	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   309: putstatic 210	com/google/protobuf/Struct:PARSER	Lcom/google/protobuf/Parser;
    //   312: ldc 2
    //   314: monitorexit
    //   315: getstatic 210	com/google/protobuf/Struct:PARSER	Lcom/google/protobuf/Parser;
    //   318: areturn
    //   319: astore_1
    //   320: ldc 2
    //   322: monitorexit
    //   323: aload_1
    //   324: athrow
    //   325: goto -137 -> 188
    //   328: iconst_1
    //   329: istore 4
    //   331: goto -183 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	Struct
    //   0	334	1	paramMethodToInvoke	GeneratedMessageLite.MethodToInvoke
    //   0	334	2	paramObject1	Object
    //   0	334	3	paramObject2	Object
    //   146	184	4	i	int
    //   157	33	5	j	int
    // Exception table:
    //   from	to	target	type
    //   153	159	239	com/google/protobuf/InvalidProtocolBufferException
    //   188	197	239	com/google/protobuf/InvalidProtocolBufferException
    //   203	224	239	com/google/protobuf/InvalidProtocolBufferException
    //   224	236	239	com/google/protobuf/InvalidProtocolBufferException
    //   153	159	253	finally
    //   188	197	253	finally
    //   203	224	253	finally
    //   224	236	253	finally
    //   240	253	253	finally
    //   257	280	253	finally
    //   153	159	256	java/io/IOException
    //   188	197	256	java/io/IOException
    //   203	224	256	java/io/IOException
    //   224	236	256	java/io/IOException
    //   293	312	319	finally
    //   312	315	319	finally
    //   320	323	319	finally
  }
  
  @Deprecated
  public Map<String, Value> getFields()
  {
    return getFieldsMap();
  }
  
  public int getFieldsCount()
  {
    return internalGetFields().size();
  }
  
  public Map<String, Value> getFieldsMap()
  {
    return Collections.unmodifiableMap(internalGetFields());
  }
  
  public Value getFieldsOrDefault(String paramString, Value paramValue)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    MapFieldLite localMapFieldLite = internalGetFields();
    if (localMapFieldLite.containsKey(paramString)) {
      return (Value)localMapFieldLite.get(paramString);
    }
    return paramValue;
  }
  
  public Value getFieldsOrThrow(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    MapFieldLite localMapFieldLite = internalGetFields();
    if (!localMapFieldLite.containsKey(paramString)) {
      throw new IllegalArgumentException();
    }
    return (Value)localMapFieldLite.get(paramString);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    Iterator localIterator = internalGetFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(1, localEntry.getKey(), localEntry.getValue());
    }
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    Iterator localIterator = internalGetFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FieldsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 1, localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Struct, Builder>
    implements StructOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearFields()
    {
      copyOnWrite();
      ((Struct)this.instance).getMutableFieldsMap().clear();
      return this;
    }
    
    public boolean containsFields(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      return ((Struct)this.instance).getFieldsMap().containsKey(paramString);
    }
    
    @Deprecated
    public Map<String, Value> getFields()
    {
      return getFieldsMap();
    }
    
    public int getFieldsCount()
    {
      return ((Struct)this.instance).getFieldsMap().size();
    }
    
    public Map<String, Value> getFieldsMap()
    {
      return Collections.unmodifiableMap(((Struct)this.instance).getFieldsMap());
    }
    
    public Value getFieldsOrDefault(String paramString, Value paramValue)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      Map localMap = ((Struct)this.instance).getFieldsMap();
      if (localMap.containsKey(paramString)) {
        return (Value)localMap.get(paramString);
      }
      return paramValue;
    }
    
    public Value getFieldsOrThrow(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      Map localMap = ((Struct)this.instance).getFieldsMap();
      if (!localMap.containsKey(paramString)) {
        throw new IllegalArgumentException();
      }
      return (Value)localMap.get(paramString);
    }
    
    public Builder putAllFields(Map<String, Value> paramMap)
    {
      copyOnWrite();
      ((Struct)this.instance).getMutableFieldsMap().putAll(paramMap);
      return this;
    }
    
    public Builder putFields(String paramString, Value paramValue)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (paramValue == null) {
        throw new NullPointerException();
      }
      copyOnWrite();
      ((Struct)this.instance).getMutableFieldsMap().put(paramString, paramValue);
      return this;
    }
    
    public Builder removeFields(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      copyOnWrite();
      ((Struct)this.instance).getMutableFieldsMap().remove(paramString);
      return this;
    }
  }
  
  private static final class FieldsDefaultEntryHolder
  {
    static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Struct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */