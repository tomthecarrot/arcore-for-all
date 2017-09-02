package com.google.location.visualmapping.common;

import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.location.visualmapping.visualmapstore.TileInfoProto.Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class LocalizationContext
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class LocalizationContextProto
    extends GeneratedMessageLite<LocalizationContextProto, Builder>
    implements LocalizationContext.LocalizationContextProtoOrBuilder
  {
    private static final LocalizationContextProto DEFAULT_INSTANCE = new LocalizationContextProto();
    private static volatile Parser<LocalizationContextProto> PARSER;
    public static final int TILE_INFO_FIELD_NUMBER = 1;
    private TileInfoProto tileInfo_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearTileInfo()
    {
      this.tileInfo_ = null;
    }
    
    public static LocalizationContextProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeTileInfo(TileInfoProto paramTileInfoProto)
    {
      if ((this.tileInfo_ != null) && (this.tileInfo_ != TileInfoProto.getDefaultInstance()))
      {
        this.tileInfo_ = ((TileInfoProto)((TileInfoProto.Builder)TileInfoProto.newBuilder(this.tileInfo_).mergeFrom(paramTileInfoProto)).buildPartial());
        return;
      }
      this.tileInfo_ = paramTileInfoProto;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocalizationContextProto paramLocalizationContextProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizationContextProto);
    }
    
    public static LocalizationContextProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationContextProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationContextProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationContextProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationContextProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static LocalizationContextProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static LocalizationContextProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static LocalizationContextProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationContextProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static LocalizationContextProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static LocalizationContextProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static LocalizationContextProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (LocalizationContextProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<LocalizationContextProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setTileInfo(TileInfoProto.Builder paramBuilder)
    {
      this.tileInfo_ = ((TileInfoProto)paramBuilder.build());
    }
    
    private void setTileInfo(TileInfoProto paramTileInfoProto)
    {
      if (paramTileInfoProto == null) {
        throw new NullPointerException();
      }
      this.tileInfo_ = paramTileInfoProto;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 150	com/google/location/visualmapping/common/LocalizationContext$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 156	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+123->131, 7:+294->302, 8:+298->306
      //   56: new 158	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 159	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto
      //   67: dup
      //   68: invokespecial 28	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 30	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 162	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto$Builder:<init>	(Lcom/google/location/visualmapping/common/LocalizationContext$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 164	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto
      //   98: astore_1
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: getfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   105: aload_1
      //   106: getfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   109: invokeinterface 168 3 0
      //   114: checkcast 62	com/google/location/visualmapping/visualmapstore/TileInfoProto
      //   117: putfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   120: aload_0
      //   121: astore_1
      //   122: aload_2
      //   123: getstatic 174	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   126: if_acmpne -54 -> 72
      //   129: aload_0
      //   130: areturn
      //   131: aload_2
      //   132: checkcast 176	com/google/protobuf/CodedInputStream
      //   135: astore_2
      //   136: aload_3
      //   137: checkcast 178	com/google/protobuf/ExtensionRegistryLite
      //   140: astore_3
      //   141: iconst_0
      //   142: istore 4
      //   144: iload 4
      //   146: ifne +156 -> 302
      //   149: aload_2
      //   150: invokevirtual 181	com/google/protobuf/CodedInputStream:readTag	()I
      //   153: istore 5
      //   155: iload 5
      //   157: lookupswitch	default:+190->347, 0:+193->350, 10:+42->199
      //   184: aload_2
      //   185: iload 5
      //   187: invokevirtual 185	com/google/protobuf/CodedInputStream:skipField	(I)Z
      //   190: ifne -46 -> 144
      //   193: iconst_1
      //   194: istore 4
      //   196: goto -52 -> 144
      //   199: aconst_null
      //   200: astore_1
      //   201: aload_0
      //   202: getfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   205: ifnull +14 -> 219
      //   208: aload_0
      //   209: getfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   212: invokevirtual 186	com/google/location/visualmapping/visualmapstore/TileInfoProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   215: checkcast 71	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder
      //   218: astore_1
      //   219: aload_0
      //   220: aload_2
      //   221: invokestatic 188	com/google/location/visualmapping/visualmapstore/TileInfoProto:parser	()Lcom/google/protobuf/Parser;
      //   224: aload_3
      //   225: invokevirtual 192	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   228: checkcast 62	com/google/location/visualmapping/visualmapstore/TileInfoProto
      //   231: putfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   234: aload_1
      //   235: ifnull -91 -> 144
      //   238: aload_1
      //   239: aload_0
      //   240: getfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   243: invokevirtual 75	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   246: pop
      //   247: aload_0
      //   248: aload_1
      //   249: invokevirtual 79	com/google/location/visualmapping/visualmapstore/TileInfoProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   252: checkcast 62	com/google/location/visualmapping/visualmapstore/TileInfoProto
      //   255: putfield 59	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:tileInfo_	Lcom/google/location/visualmapping/visualmapstore/TileInfoProto;
      //   258: goto -114 -> 144
      //   261: astore_1
      //   262: new 194	java/lang/RuntimeException
      //   265: dup
      //   266: aload_1
      //   267: aload_0
      //   268: invokevirtual 198	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   271: invokespecial 201	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   274: athrow
      //   275: astore_1
      //   276: aload_1
      //   277: athrow
      //   278: astore_1
      //   279: new 194	java/lang/RuntimeException
      //   282: dup
      //   283: new 102	com/google/protobuf/InvalidProtocolBufferException
      //   286: dup
      //   287: aload_1
      //   288: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
      //   291: invokespecial 208	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   294: aload_0
      //   295: invokevirtual 198	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   298: invokespecial 201	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   301: athrow
      //   302: getstatic 30	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto;
      //   305: areturn
      //   306: getstatic 210	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:PARSER	Lcom/google/protobuf/Parser;
      //   309: ifnonnull +28 -> 337
      //   312: ldc 2
      //   314: monitorenter
      //   315: getstatic 210	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:PARSER	Lcom/google/protobuf/Parser;
      //   318: ifnonnull +16 -> 334
      //   321: new 212	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   324: dup
      //   325: getstatic 30	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto;
      //   328: invokespecial 215	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   331: putstatic 210	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:PARSER	Lcom/google/protobuf/Parser;
      //   334: ldc 2
      //   336: monitorexit
      //   337: getstatic 210	com/google/location/visualmapping/common/LocalizationContext$LocalizationContextProto:PARSER	Lcom/google/protobuf/Parser;
      //   340: areturn
      //   341: astore_1
      //   342: ldc 2
      //   344: monitorexit
      //   345: aload_1
      //   346: athrow
      //   347: goto -163 -> 184
      //   350: iconst_1
      //   351: istore 4
      //   353: goto -209 -> 144
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	356	0	this	LocalizationContextProto
      //   0	356	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	356	2	paramObject1	Object
      //   0	356	3	paramObject2	Object
      //   142	210	4	i	int
      //   153	33	5	j	int
      // Exception table:
      //   from	to	target	type
      //   149	155	261	com/google/protobuf/InvalidProtocolBufferException
      //   184	193	261	com/google/protobuf/InvalidProtocolBufferException
      //   201	219	261	com/google/protobuf/InvalidProtocolBufferException
      //   219	234	261	com/google/protobuf/InvalidProtocolBufferException
      //   238	258	261	com/google/protobuf/InvalidProtocolBufferException
      //   149	155	275	finally
      //   184	193	275	finally
      //   201	219	275	finally
      //   219	234	275	finally
      //   238	258	275	finally
      //   262	275	275	finally
      //   279	302	275	finally
      //   149	155	278	java/io/IOException
      //   184	193	278	java/io/IOException
      //   201	219	278	java/io/IOException
      //   219	234	278	java/io/IOException
      //   238	258	278	java/io/IOException
      //   315	334	341	finally
      //   334	337	341	finally
      //   342	345	341	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (this.tileInfo_ != null) {
        i = 0 + CodedOutputStream.computeMessageSize(1, getTileInfo());
      }
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public TileInfoProto getTileInfo()
    {
      if (this.tileInfo_ == null) {
        return TileInfoProto.getDefaultInstance();
      }
      return this.tileInfo_;
    }
    
    public boolean hasTileInfo()
    {
      return this.tileInfo_ != null;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (this.tileInfo_ != null) {
        paramCodedOutputStream.writeMessage(1, getTileInfo());
      }
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<LocalizationContext.LocalizationContextProto, Builder>
      implements LocalizationContext.LocalizationContextProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearTileInfo()
      {
        copyOnWrite();
        ((LocalizationContext.LocalizationContextProto)this.instance).clearTileInfo();
        return this;
      }
      
      public TileInfoProto getTileInfo()
      {
        return ((LocalizationContext.LocalizationContextProto)this.instance).getTileInfo();
      }
      
      public boolean hasTileInfo()
      {
        return ((LocalizationContext.LocalizationContextProto)this.instance).hasTileInfo();
      }
      
      public Builder mergeTileInfo(TileInfoProto paramTileInfoProto)
      {
        copyOnWrite();
        ((LocalizationContext.LocalizationContextProto)this.instance).mergeTileInfo(paramTileInfoProto);
        return this;
      }
      
      public Builder setTileInfo(TileInfoProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((LocalizationContext.LocalizationContextProto)this.instance).setTileInfo(paramBuilder);
        return this;
      }
      
      public Builder setTileInfo(TileInfoProto paramTileInfoProto)
      {
        copyOnWrite();
        ((LocalizationContext.LocalizationContextProto)this.instance).setTileInfo(paramTileInfoProto);
        return this;
      }
    }
  }
  
  public static abstract interface LocalizationContextProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract TileInfoProto getTileInfo();
    
    public abstract boolean hasTileInfo();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/common/LocalizationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */