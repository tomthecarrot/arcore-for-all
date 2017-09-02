package com.google.location.visualmapping.vpsmanagement;

import com.google.location.visualmapping.visualmapstore.Collection.CollectionSummaryProto;
import com.google.location.visualmapping.visualmapstore.Collection.CollectionSummaryProto.Builder;
import com.google.location.visualmapping.visualmapstore.Collection.CollectionSummaryProtoOrBuilder;
import com.google.location.visualmapping.visualmapstore.common.AggregatedLocalizationResults.LocalizationStatsProto;
import com.google.location.visualmapping.visualmapstore.common.AggregatedLocalizationResults.LocalizationStatsProto.Builder;
import com.google.location.visualmapping.visualmapstore.common.AggregatedLocalizationResults.S2CellLocalizationResultsProto;
import com.google.location.visualmapping.visualmapstore.common.AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder;
import com.google.location.visualmapping.visualmapstore.common.AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.IntList;
import com.google.protobuf.Internal.ListAdapter;
import com.google.protobuf.Internal.ListAdapter.Converter;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp.Builder;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class VpsManagementWire
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class ListCollectionsRequestProto
    extends GeneratedMessageLite<ListCollectionsRequestProto, Builder>
    implements VpsManagementWire.ListCollectionsRequestProtoOrBuilder
  {
    private static final ListCollectionsRequestProto DEFAULT_INSTANCE = new ListCollectionsRequestProto();
    public static final int MAX_RESULTS_FIELD_NUMBER = 1;
    private static volatile Parser<ListCollectionsRequestProto> PARSER;
    public static final int VENUE_GROUP_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private int maxResults_;
    private String venueGroupId_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMaxResults()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.maxResults_ = 0;
    }
    
    private void clearVenueGroupId()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.venueGroupId_ = getDefaultInstance().getVenueGroupId();
    }
    
    public static ListCollectionsRequestProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListCollectionsRequestProto paramListCollectionsRequestProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCollectionsRequestProto);
    }
    
    public static ListCollectionsRequestProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListCollectionsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListCollectionsRequestProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsRequestProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListCollectionsRequestProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsRequestProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListCollectionsRequestProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsRequestProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListCollectionsRequestProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsRequestProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListCollectionsRequestProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListCollectionsRequestProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMaxResults(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.maxResults_ = paramInt;
    }
    
    private void setVenueGroupId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.venueGroupId_ = paramString;
    }
    
    private void setVenueGroupIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.venueGroupId_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 160	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 166	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+329->337, 8:+333->341
      //   56: new 168	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 169	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto
      //   67: dup
      //   68: invokespecial 32	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 172	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 174	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 178	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:hasMaxResults	()Z
      //   105: aload_0
      //   106: getfield 76	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:maxResults_	I
      //   109: aload_3
      //   110: invokevirtual 178	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:hasMaxResults	()Z
      //   113: aload_3
      //   114: getfield 76	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:maxResults_	I
      //   117: invokeinterface 182 5 0
      //   122: putfield 76	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:maxResults_	I
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 185	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:hasVenueGroupId	()Z
      //   131: aload_0
      //   132: getfield 43	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:venueGroupId_	Ljava/lang/String;
      //   135: aload_3
      //   136: invokevirtual 185	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:hasVenueGroupId	()Z
      //   139: aload_3
      //   140: getfield 43	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:venueGroupId_	Ljava/lang/String;
      //   143: invokeinterface 189 5 0
      //   148: putfield 43	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:venueGroupId_	Ljava/lang/String;
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 195	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   165: aload_3
      //   166: getfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   169: ior
      //   170: putfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 197	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 199	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +147 -> 337
      //   193: aload_1
      //   194: invokevirtual 202	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+181->382, 0:+184->385, 8:+51->252, 18:+89->290
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 206	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 209	com/google/protobuf/CodedInputStream:readInt32	()I
      //   267: putfield 76	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:maxResults_	I
      //   270: goto -82 -> 188
      //   273: astore_1
      //   274: new 211	java/lang/RuntimeException
      //   277: dup
      //   278: aload_1
      //   279: aload_0
      //   280: invokevirtual 215	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   283: invokespecial 218	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   286: athrow
      //   287: astore_1
      //   288: aload_1
      //   289: athrow
      //   290: aload_1
      //   291: invokevirtual 221	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   294: astore_2
      //   295: aload_0
      //   296: aload_0
      //   297: getfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   300: iconst_2
      //   301: ior
      //   302: putfield 74	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:bitField0_	I
      //   305: aload_0
      //   306: aload_2
      //   307: putfield 43	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:venueGroupId_	Ljava/lang/String;
      //   310: goto -122 -> 188
      //   313: astore_1
      //   314: new 211	java/lang/RuntimeException
      //   317: dup
      //   318: new 110	com/google/protobuf/InvalidProtocolBufferException
      //   321: dup
      //   322: aload_1
      //   323: invokevirtual 224	java/io/IOException:getMessage	()Ljava/lang/String;
      //   326: invokespecial 226	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   329: aload_0
      //   330: invokevirtual 215	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   333: invokespecial 218	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   336: athrow
      //   337: getstatic 34	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto;
      //   340: areturn
      //   341: getstatic 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   344: ifnonnull +28 -> 372
      //   347: ldc 2
      //   349: monitorenter
      //   350: getstatic 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   353: ifnonnull +16 -> 369
      //   356: new 230	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   359: dup
      //   360: getstatic 34	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto;
      //   363: invokespecial 233	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   366: putstatic 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   369: ldc 2
      //   371: monitorexit
      //   372: getstatic 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   375: areturn
      //   376: astore_1
      //   377: ldc 2
      //   379: monitorexit
      //   380: aload_1
      //   381: athrow
      //   382: goto -146 -> 236
      //   385: iconst_1
      //   386: istore 4
      //   388: goto -200 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	391	0	this	ListCollectionsRequestProto
      //   0	391	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	391	2	paramObject1	Object
      //   0	391	3	paramObject2	Object
      //   186	201	4	i	int
      //   197	41	5	j	int
      // Exception table:
      //   from	to	target	type
      //   193	199	273	com/google/protobuf/InvalidProtocolBufferException
      //   236	246	273	com/google/protobuf/InvalidProtocolBufferException
      //   252	270	273	com/google/protobuf/InvalidProtocolBufferException
      //   290	310	273	com/google/protobuf/InvalidProtocolBufferException
      //   193	199	287	finally
      //   236	246	287	finally
      //   252	270	287	finally
      //   274	287	287	finally
      //   290	310	287	finally
      //   314	337	287	finally
      //   193	199	313	java/io/IOException
      //   236	246	313	java/io/IOException
      //   252	270	313	java/io/IOException
      //   290	310	313	java/io/IOException
      //   350	369	376	finally
      //   369	372	376	finally
      //   377	380	376	finally
    }
    
    public int getMaxResults()
    {
      return this.maxResults_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeInt32Size(1, this.maxResults_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeStringSize(2, getVenueGroupId());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getVenueGroupId()
    {
      return this.venueGroupId_;
    }
    
    public ByteString getVenueGroupIdBytes()
    {
      return ByteString.copyFromUtf8(this.venueGroupId_);
    }
    
    public boolean hasMaxResults()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasVenueGroupId()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt32(1, this.maxResults_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getVenueGroupId());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListCollectionsRequestProto, Builder>
      implements VpsManagementWire.ListCollectionsRequestProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearMaxResults()
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsRequestProto)this.instance).clearMaxResults();
        return this;
      }
      
      public Builder clearVenueGroupId()
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsRequestProto)this.instance).clearVenueGroupId();
        return this;
      }
      
      public int getMaxResults()
      {
        return ((VpsManagementWire.ListCollectionsRequestProto)this.instance).getMaxResults();
      }
      
      public String getVenueGroupId()
      {
        return ((VpsManagementWire.ListCollectionsRequestProto)this.instance).getVenueGroupId();
      }
      
      public ByteString getVenueGroupIdBytes()
      {
        return ((VpsManagementWire.ListCollectionsRequestProto)this.instance).getVenueGroupIdBytes();
      }
      
      public boolean hasMaxResults()
      {
        return ((VpsManagementWire.ListCollectionsRequestProto)this.instance).hasMaxResults();
      }
      
      public boolean hasVenueGroupId()
      {
        return ((VpsManagementWire.ListCollectionsRequestProto)this.instance).hasVenueGroupId();
      }
      
      public Builder setMaxResults(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsRequestProto)this.instance).setMaxResults(paramInt);
        return this;
      }
      
      public Builder setVenueGroupId(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsRequestProto)this.instance).setVenueGroupId(paramString);
        return this;
      }
      
      public Builder setVenueGroupIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsRequestProto)this.instance).setVenueGroupIdBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface ListCollectionsRequestProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract int getMaxResults();
    
    public abstract String getVenueGroupId();
    
    public abstract ByteString getVenueGroupIdBytes();
    
    public abstract boolean hasMaxResults();
    
    public abstract boolean hasVenueGroupId();
  }
  
  public static final class ListCollectionsResponseProto
    extends GeneratedMessageLite<ListCollectionsResponseProto, Builder>
    implements VpsManagementWire.ListCollectionsResponseProtoOrBuilder
  {
    public static final int COLLECTIONS_FIELD_NUMBER = 1;
    private static final ListCollectionsResponseProto DEFAULT_INSTANCE = new ListCollectionsResponseProto();
    private static volatile Parser<ListCollectionsResponseProto> PARSER;
    private Internal.ProtobufList<Collection.CollectionSummaryProto> collections_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllCollections(Iterable<? extends Collection.CollectionSummaryProto> paramIterable)
    {
      ensureCollectionsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.collections_);
    }
    
    private void addCollections(int paramInt, Collection.CollectionSummaryProto.Builder paramBuilder)
    {
      ensureCollectionsIsMutable();
      this.collections_.add(paramInt, paramBuilder.build());
    }
    
    private void addCollections(int paramInt, Collection.CollectionSummaryProto paramCollectionSummaryProto)
    {
      if (paramCollectionSummaryProto == null) {
        throw new NullPointerException();
      }
      ensureCollectionsIsMutable();
      this.collections_.add(paramInt, paramCollectionSummaryProto);
    }
    
    private void addCollections(Collection.CollectionSummaryProto.Builder paramBuilder)
    {
      ensureCollectionsIsMutable();
      this.collections_.add(paramBuilder.build());
    }
    
    private void addCollections(Collection.CollectionSummaryProto paramCollectionSummaryProto)
    {
      if (paramCollectionSummaryProto == null) {
        throw new NullPointerException();
      }
      ensureCollectionsIsMutable();
      this.collections_.add(paramCollectionSummaryProto);
    }
    
    private void clearCollections()
    {
      this.collections_ = emptyProtobufList();
    }
    
    private void ensureCollectionsIsMutable()
    {
      if (!this.collections_.isModifiable()) {
        this.collections_ = GeneratedMessageLite.mutableCopy(this.collections_);
      }
    }
    
    public static ListCollectionsResponseProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListCollectionsResponseProto paramListCollectionsResponseProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCollectionsResponseProto);
    }
    
    public static ListCollectionsResponseProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListCollectionsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListCollectionsResponseProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsResponseProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListCollectionsResponseProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsResponseProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListCollectionsResponseProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsResponseProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListCollectionsResponseProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListCollectionsResponseProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListCollectionsResponseProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListCollectionsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListCollectionsResponseProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeCollections(int paramInt)
    {
      ensureCollectionsIsMutable();
      this.collections_.remove(paramInt);
    }
    
    private void setCollections(int paramInt, Collection.CollectionSummaryProto.Builder paramBuilder)
    {
      ensureCollectionsIsMutable();
      this.collections_.set(paramInt, paramBuilder.build());
    }
    
    private void setCollections(int paramInt, Collection.CollectionSummaryProto paramCollectionSummaryProto)
    {
      if (paramCollectionSummaryProto == null) {
        throw new NullPointerException();
      }
      ensureCollectionsIsMutable();
      this.collections_.set(paramInt, paramCollectionSummaryProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 203	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 209	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+281->289, 8:+285->293
      //   56: new 211	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 212	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 213 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 216	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 218	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 222 3 0
      //   123: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
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
      //   152: ifne +137 -> 289
      //   155: aload_1
      //   156: invokevirtual 235	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+171->334, 0:+174->337, 10:+41->204
      //   188: aload_0
      //   189: iload 5
      //   191: aload_1
      //   192: invokevirtual 239	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   195: ifne -45 -> 150
      //   198: iconst_1
      //   199: istore 4
      //   201: goto -51 -> 150
      //   204: aload_0
      //   205: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   208: invokeinterface 122 1 0
      //   213: ifne +14 -> 227
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   221: invokestatic 126	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   224: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   227: aload_0
      //   228: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:collections_	Lcom/google/protobuf/Internal$ProtobufList;
      //   231: aload_1
      //   232: invokestatic 243	com/google/location/visualmapping/visualmapstore/Collection$CollectionSummaryProto:parser	()Lcom/google/protobuf/Parser;
      //   235: aload_2
      //   236: invokevirtual 247	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   239: invokeinterface 118 2 0
      //   244: pop
      //   245: goto -95 -> 150
      //   248: astore_1
      //   249: new 249	java/lang/RuntimeException
      //   252: dup
      //   253: aload_1
      //   254: aload_0
      //   255: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   261: athrow
      //   262: astore_1
      //   263: aload_1
      //   264: athrow
      //   265: astore_1
      //   266: new 249	java/lang/RuntimeException
      //   269: dup
      //   270: new 154	com/google/protobuf/InvalidProtocolBufferException
      //   273: dup
      //   274: aload_1
      //   275: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   278: invokespecial 263	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   281: aload_0
      //   282: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto;
      //   292: areturn
      //   293: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +28 -> 324
      //   299: ldc 2
      //   301: monitorenter
      //   302: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   305: ifnonnull +16 -> 321
      //   308: new 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   311: dup
      //   312: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto;
      //   315: invokespecial 270	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   318: putstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   321: ldc 2
      //   323: monitorexit
      //   324: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListCollectionsResponseProto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	343	0	this	ListCollectionsResponseProto
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
    
    public Collection.CollectionSummaryProto getCollections(int paramInt)
    {
      return (Collection.CollectionSummaryProto)this.collections_.get(paramInt);
    }
    
    public int getCollectionsCount()
    {
      return this.collections_.size();
    }
    
    public List<Collection.CollectionSummaryProto> getCollectionsList()
    {
      return this.collections_;
    }
    
    public Collection.CollectionSummaryProtoOrBuilder getCollectionsOrBuilder(int paramInt)
    {
      return (Collection.CollectionSummaryProtoOrBuilder)this.collections_.get(paramInt);
    }
    
    public List<? extends Collection.CollectionSummaryProtoOrBuilder> getCollectionsOrBuilderList()
    {
      return this.collections_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.collections_.size())
      {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.collections_.get(i));
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
      while (i < this.collections_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.collections_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListCollectionsResponseProto, Builder>
      implements VpsManagementWire.ListCollectionsResponseProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllCollections(Iterable<? extends Collection.CollectionSummaryProto> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).addAllCollections(paramIterable);
        return this;
      }
      
      public Builder addCollections(int paramInt, Collection.CollectionSummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).addCollections(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addCollections(int paramInt, Collection.CollectionSummaryProto paramCollectionSummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).addCollections(paramInt, paramCollectionSummaryProto);
        return this;
      }
      
      public Builder addCollections(Collection.CollectionSummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).addCollections(paramBuilder);
        return this;
      }
      
      public Builder addCollections(Collection.CollectionSummaryProto paramCollectionSummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).addCollections(paramCollectionSummaryProto);
        return this;
      }
      
      public Builder clearCollections()
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).clearCollections();
        return this;
      }
      
      public Collection.CollectionSummaryProto getCollections(int paramInt)
      {
        return ((VpsManagementWire.ListCollectionsResponseProto)this.instance).getCollections(paramInt);
      }
      
      public int getCollectionsCount()
      {
        return ((VpsManagementWire.ListCollectionsResponseProto)this.instance).getCollectionsCount();
      }
      
      public List<Collection.CollectionSummaryProto> getCollectionsList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListCollectionsResponseProto)this.instance).getCollectionsList());
      }
      
      public Builder removeCollections(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).removeCollections(paramInt);
        return this;
      }
      
      public Builder setCollections(int paramInt, Collection.CollectionSummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).setCollections(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setCollections(int paramInt, Collection.CollectionSummaryProto paramCollectionSummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListCollectionsResponseProto)this.instance).setCollections(paramInt, paramCollectionSummaryProto);
        return this;
      }
    }
  }
  
  public static abstract interface ListCollectionsResponseProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract Collection.CollectionSummaryProto getCollections(int paramInt);
    
    public abstract int getCollectionsCount();
    
    public abstract List<Collection.CollectionSummaryProto> getCollectionsList();
  }
  
  public static final class ListLocalizationResultsRequestProto
    extends GeneratedMessageLite<ListLocalizationResultsRequestProto, Builder>
    implements VpsManagementWire.ListLocalizationResultsRequestProtoOrBuilder
  {
    private static final ListLocalizationResultsRequestProto DEFAULT_INSTANCE = new ListLocalizationResultsRequestProto();
    public static final int MAX_DAYS_SINCE_COLLECTION_FIELD_NUMBER = 4;
    private static volatile Parser<ListLocalizationResultsRequestProto> PARSER;
    public static final int S2_CELL_LEVEL_FIELD_NUMBER = 3;
    public static final int TILE_TAG_FIELD_NUMBER = 2;
    public static final int VENUE_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private int maxDaysSinceCollection_;
    private int s2CellLevel_;
    private String tileTag_ = "";
    private String venueName_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMaxDaysSinceCollection()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.maxDaysSinceCollection_ = 0;
    }
    
    private void clearS2CellLevel()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.s2CellLevel_ = 0;
    }
    
    private void clearTileTag()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.tileTag_ = getDefaultInstance().getTileTag();
    }
    
    private void clearVenueName()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.venueName_ = getDefaultInstance().getVenueName();
    }
    
    public static ListLocalizationResultsRequestProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListLocalizationResultsRequestProto paramListLocalizationResultsRequestProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListLocalizationResultsRequestProto);
    }
    
    public static ListLocalizationResultsRequestProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListLocalizationResultsRequestProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListLocalizationResultsRequestProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListLocalizationResultsRequestProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMaxDaysSinceCollection(int paramInt)
    {
      this.bitField0_ |= 0x8;
      this.maxDaysSinceCollection_ = paramInt;
    }
    
    private void setS2CellLevel(int paramInt)
    {
      this.bitField0_ |= 0x4;
      this.s2CellLevel_ = paramInt;
    }
    
    private void setTileTag(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.tileTag_ = paramString;
    }
    
    private void setTileTagBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.tileTag_ = paramByteString.toStringUtf8();
    }
    
    private void setVenueName(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.venueName_ = paramString;
    }
    
    private void setVenueNameBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.venueName_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 193	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 199	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+219->227, 7:+442->450, 8:+446->454
      //   56: new 201	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 202	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto
      //   67: dup
      //   68: invokespecial 38	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 205	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 207	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 211	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasVenueName	()Z
      //   105: aload_0
      //   106: getfield 49	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:venueName_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 211	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasVenueName	()Z
      //   113: aload_3
      //   114: getfield 49	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:venueName_	Ljava/lang/String;
      //   117: invokeinterface 215 5 0
      //   122: putfield 49	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:venueName_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 218	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasTileTag	()Z
      //   131: aload_0
      //   132: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:tileTag_	Ljava/lang/String;
      //   135: aload_3
      //   136: invokevirtual 218	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasTileTag	()Z
      //   139: aload_3
      //   140: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:tileTag_	Ljava/lang/String;
      //   143: invokeinterface 215 5 0
      //   148: putfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:tileTag_	Ljava/lang/String;
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 221	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasS2CellLevel	()Z
      //   157: aload_0
      //   158: getfield 106	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:s2CellLevel_	I
      //   161: aload_3
      //   162: invokevirtual 221	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasS2CellLevel	()Z
      //   165: aload_3
      //   166: getfield 106	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:s2CellLevel_	I
      //   169: invokeinterface 225 5 0
      //   174: putfield 106	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:s2CellLevel_	I
      //   177: aload_0
      //   178: aload_2
      //   179: aload_0
      //   180: invokevirtual 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasMaxDaysSinceCollection	()Z
      //   183: aload_0
      //   184: getfield 104	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:maxDaysSinceCollection_	I
      //   187: aload_3
      //   188: invokevirtual 228	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:hasMaxDaysSinceCollection	()Z
      //   191: aload_3
      //   192: getfield 104	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:maxDaysSinceCollection_	I
      //   195: invokeinterface 225 5 0
      //   200: putfield 104	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:maxDaysSinceCollection_	I
      //   203: aload_0
      //   204: astore_1
      //   205: aload_2
      //   206: getstatic 234	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   209: if_acmpne -137 -> 72
      //   212: aload_0
      //   213: aload_0
      //   214: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   217: aload_3
      //   218: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   221: ior
      //   222: putfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   225: aload_0
      //   226: areturn
      //   227: aload_2
      //   228: checkcast 236	com/google/protobuf/CodedInputStream
      //   231: astore_1
      //   232: aload_3
      //   233: checkcast 238	com/google/protobuf/ExtensionRegistryLite
      //   236: astore_2
      //   237: iconst_0
      //   238: istore 4
      //   240: iload 4
      //   242: ifne +208 -> 450
      //   245: aload_1
      //   246: invokevirtual 241	com/google/protobuf/CodedInputStream:readTag	()I
      //   249: istore 5
      //   251: iload 5
      //   253: lookupswitch	default:+242->495, 0:+245->498, 10:+67->320, 18:+107->360, 24:+154->407, 32:+175->428
      //   304: aload_0
      //   305: iload 5
      //   307: aload_1
      //   308: invokevirtual 245	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   311: ifne -71 -> 240
      //   314: iconst_1
      //   315: istore 4
      //   317: goto -77 -> 240
      //   320: aload_1
      //   321: invokevirtual 248	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   324: astore_2
      //   325: aload_0
      //   326: aload_0
      //   327: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   330: iconst_1
      //   331: ior
      //   332: putfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   335: aload_0
      //   336: aload_2
      //   337: putfield 49	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:venueName_	Ljava/lang/String;
      //   340: goto -100 -> 240
      //   343: astore_1
      //   344: new 250	java/lang/RuntimeException
      //   347: dup
      //   348: aload_1
      //   349: aload_0
      //   350: invokevirtual 254	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   353: invokespecial 257	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   356: athrow
      //   357: astore_1
      //   358: aload_1
      //   359: athrow
      //   360: aload_1
      //   361: invokevirtual 248	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   364: astore_2
      //   365: aload_0
      //   366: aload_0
      //   367: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   370: iconst_2
      //   371: ior
      //   372: putfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   375: aload_0
      //   376: aload_2
      //   377: putfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:tileTag_	Ljava/lang/String;
      //   380: goto -140 -> 240
      //   383: astore_1
      //   384: new 250	java/lang/RuntimeException
      //   387: dup
      //   388: new 143	com/google/protobuf/InvalidProtocolBufferException
      //   391: dup
      //   392: aload_1
      //   393: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   396: invokespecial 262	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   399: aload_0
      //   400: invokevirtual 254	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   403: invokespecial 257	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   406: athrow
      //   407: aload_0
      //   408: aload_0
      //   409: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   412: iconst_4
      //   413: ior
      //   414: putfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   417: aload_0
      //   418: aload_1
      //   419: invokevirtual 265	com/google/protobuf/CodedInputStream:readInt32	()I
      //   422: putfield 106	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:s2CellLevel_	I
      //   425: goto -185 -> 240
      //   428: aload_0
      //   429: aload_0
      //   430: getfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   433: bipush 8
      //   435: ior
      //   436: putfield 102	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:bitField0_	I
      //   439: aload_0
      //   440: aload_1
      //   441: invokevirtual 265	com/google/protobuf/CodedInputStream:readInt32	()I
      //   444: putfield 104	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:maxDaysSinceCollection_	I
      //   447: goto -207 -> 240
      //   450: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto;
      //   453: areturn
      //   454: getstatic 267	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   457: ifnonnull +28 -> 485
      //   460: ldc 2
      //   462: monitorenter
      //   463: getstatic 267	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   466: ifnonnull +16 -> 482
      //   469: new 269	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   472: dup
      //   473: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto;
      //   476: invokespecial 272	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   479: putstatic 267	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   482: ldc 2
      //   484: monitorexit
      //   485: getstatic 267	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   488: areturn
      //   489: astore_1
      //   490: ldc 2
      //   492: monitorexit
      //   493: aload_1
      //   494: athrow
      //   495: goto -191 -> 304
      //   498: iconst_1
      //   499: istore 4
      //   501: goto -261 -> 240
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	504	0	this	ListLocalizationResultsRequestProto
      //   0	504	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	504	2	paramObject1	Object
      //   0	504	3	paramObject2	Object
      //   238	262	4	i	int
      //   249	57	5	j	int
      // Exception table:
      //   from	to	target	type
      //   245	251	343	com/google/protobuf/InvalidProtocolBufferException
      //   304	314	343	com/google/protobuf/InvalidProtocolBufferException
      //   320	340	343	com/google/protobuf/InvalidProtocolBufferException
      //   360	380	343	com/google/protobuf/InvalidProtocolBufferException
      //   407	425	343	com/google/protobuf/InvalidProtocolBufferException
      //   428	447	343	com/google/protobuf/InvalidProtocolBufferException
      //   245	251	357	finally
      //   304	314	357	finally
      //   320	340	357	finally
      //   344	357	357	finally
      //   360	380	357	finally
      //   384	407	357	finally
      //   407	425	357	finally
      //   428	447	357	finally
      //   245	251	383	java/io/IOException
      //   304	314	383	java/io/IOException
      //   320	340	383	java/io/IOException
      //   360	380	383	java/io/IOException
      //   407	425	383	java/io/IOException
      //   428	447	383	java/io/IOException
      //   463	482	489	finally
      //   482	485	489	finally
      //   490	493	489	finally
    }
    
    public int getMaxDaysSinceCollection()
    {
      return this.maxDaysSinceCollection_;
    }
    
    public int getS2CellLevel()
    {
      return this.s2CellLevel_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getVenueName());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getTileTag());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeInt32Size(3, this.s2CellLevel_);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeInt32Size(4, this.maxDaysSinceCollection_);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTileTag()
    {
      return this.tileTag_;
    }
    
    public ByteString getTileTagBytes()
    {
      return ByteString.copyFromUtf8(this.tileTag_);
    }
    
    public String getVenueName()
    {
      return this.venueName_;
    }
    
    public ByteString getVenueNameBytes()
    {
      return ByteString.copyFromUtf8(this.venueName_);
    }
    
    public boolean hasMaxDaysSinceCollection()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasS2CellLevel()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasTileTag()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasVenueName()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getVenueName());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getTileTag());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeInt32(3, this.s2CellLevel_);
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeInt32(4, this.maxDaysSinceCollection_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListLocalizationResultsRequestProto, Builder>
      implements VpsManagementWire.ListLocalizationResultsRequestProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearMaxDaysSinceCollection()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).clearMaxDaysSinceCollection();
        return this;
      }
      
      public Builder clearS2CellLevel()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).clearS2CellLevel();
        return this;
      }
      
      public Builder clearTileTag()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).clearTileTag();
        return this;
      }
      
      public Builder clearVenueName()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).clearVenueName();
        return this;
      }
      
      public int getMaxDaysSinceCollection()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getMaxDaysSinceCollection();
      }
      
      public int getS2CellLevel()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getS2CellLevel();
      }
      
      public String getTileTag()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getTileTag();
      }
      
      public ByteString getTileTagBytes()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getTileTagBytes();
      }
      
      public String getVenueName()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getVenueName();
      }
      
      public ByteString getVenueNameBytes()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).getVenueNameBytes();
      }
      
      public boolean hasMaxDaysSinceCollection()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).hasMaxDaysSinceCollection();
      }
      
      public boolean hasS2CellLevel()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).hasS2CellLevel();
      }
      
      public boolean hasTileTag()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).hasTileTag();
      }
      
      public boolean hasVenueName()
      {
        return ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).hasVenueName();
      }
      
      public Builder setMaxDaysSinceCollection(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setMaxDaysSinceCollection(paramInt);
        return this;
      }
      
      public Builder setS2CellLevel(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setS2CellLevel(paramInt);
        return this;
      }
      
      public Builder setTileTag(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setTileTag(paramString);
        return this;
      }
      
      public Builder setTileTagBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setTileTagBytes(paramByteString);
        return this;
      }
      
      public Builder setVenueName(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setVenueName(paramString);
        return this;
      }
      
      public Builder setVenueNameBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsRequestProto)this.instance).setVenueNameBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface ListLocalizationResultsRequestProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract int getMaxDaysSinceCollection();
    
    public abstract int getS2CellLevel();
    
    public abstract String getTileTag();
    
    public abstract ByteString getTileTagBytes();
    
    public abstract String getVenueName();
    
    public abstract ByteString getVenueNameBytes();
    
    public abstract boolean hasMaxDaysSinceCollection();
    
    public abstract boolean hasS2CellLevel();
    
    public abstract boolean hasTileTag();
    
    public abstract boolean hasVenueName();
  }
  
  public static final class ListLocalizationResultsResponseProto
    extends GeneratedMessageLite<ListLocalizationResultsResponseProto, Builder>
    implements VpsManagementWire.ListLocalizationResultsResponseProtoOrBuilder
  {
    public static final int AGGREGATE_STATS_FIELD_NUMBER = 2;
    private static final ListLocalizationResultsResponseProto DEFAULT_INSTANCE = new ListLocalizationResultsResponseProto();
    public static final int MOST_RECENT_COLLECTION_FIELD_NUMBER = 3;
    private static volatile Parser<ListLocalizationResultsResponseProto> PARSER;
    public static final int S2_CELL_LOCALIZATION_RESULTS_FIELD_NUMBER = 1;
    private AggregatedLocalizationResults.LocalizationStatsProto aggregateStats_;
    private int bitField0_;
    private Timestamp mostRecentCollection_;
    private Internal.ProtobufList<AggregatedLocalizationResults.S2CellLocalizationResultsProto> s2CellLocalizationResults_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllS2CellLocalizationResults(Iterable<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProto> paramIterable)
    {
      ensureS2CellLocalizationResultsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.s2CellLocalizationResults_);
    }
    
    private void addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramInt, paramBuilder.build());
    }
    
    private void addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramInt, paramS2CellLocalizationResultsProto);
    }
    
    private void addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramBuilder.build());
    }
    
    private void addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.add(paramS2CellLocalizationResultsProto);
    }
    
    private void clearAggregateStats()
    {
      this.aggregateStats_ = null;
      this.bitField0_ &= 0xFFFFFFFE;
    }
    
    private void clearMostRecentCollection()
    {
      this.mostRecentCollection_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearS2CellLocalizationResults()
    {
      this.s2CellLocalizationResults_ = emptyProtobufList();
    }
    
    private void ensureS2CellLocalizationResultsIsMutable()
    {
      if (!this.s2CellLocalizationResults_.isModifiable()) {
        this.s2CellLocalizationResults_ = GeneratedMessageLite.mutableCopy(this.s2CellLocalizationResults_);
      }
    }
    
    public static ListLocalizationResultsResponseProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if ((this.aggregateStats_ != null) && (this.aggregateStats_ != AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance())) {}
      for (this.aggregateStats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)((AggregatedLocalizationResults.LocalizationStatsProto.Builder)AggregatedLocalizationResults.LocalizationStatsProto.newBuilder(this.aggregateStats_).mergeFrom(paramLocalizationStatsProto)).buildPartial());; this.aggregateStats_ = paramLocalizationStatsProto)
      {
        this.bitField0_ |= 0x1;
        return;
      }
    }
    
    private void mergeMostRecentCollection(Timestamp paramTimestamp)
    {
      if ((this.mostRecentCollection_ != null) && (this.mostRecentCollection_ != Timestamp.getDefaultInstance())) {}
      for (this.mostRecentCollection_ = ((Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.mostRecentCollection_).mergeFrom(paramTimestamp)).buildPartial());; this.mostRecentCollection_ = paramTimestamp)
      {
        this.bitField0_ |= 0x2;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListLocalizationResultsResponseProto paramListLocalizationResultsResponseProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListLocalizationResultsResponseProto);
    }
    
    public static ListLocalizationResultsResponseProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListLocalizationResultsResponseProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListLocalizationResultsResponseProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListLocalizationResultsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListLocalizationResultsResponseProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeS2CellLocalizationResults(int paramInt)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.remove(paramInt);
    }
    
    private void setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
    {
      this.aggregateStats_ = ((AggregatedLocalizationResults.LocalizationStatsProto)paramBuilder.build());
      this.bitField0_ |= 0x1;
    }
    
    private void setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
    {
      if (paramLocalizationStatsProto == null) {
        throw new NullPointerException();
      }
      this.aggregateStats_ = paramLocalizationStatsProto;
      this.bitField0_ |= 0x1;
    }
    
    private void setMostRecentCollection(Timestamp.Builder paramBuilder)
    {
      this.mostRecentCollection_ = ((Timestamp)paramBuilder.build());
      this.bitField0_ |= 0x2;
    }
    
    private void setMostRecentCollection(Timestamp paramTimestamp)
    {
      if (paramTimestamp == null) {
        throw new NullPointerException();
      }
      this.mostRecentCollection_ = paramTimestamp;
      this.bitField0_ |= 0x2;
    }
    
    private void setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
    {
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.set(paramInt, paramBuilder.build());
    }
    
    private void setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
    {
      if (paramS2CellLocalizationResultsProto == null) {
        throw new NullPointerException();
      }
      ensureS2CellLocalizationResultsIsMutable();
      this.s2CellLocalizationResults_.set(paramInt, paramS2CellLocalizationResultsProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 284	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 290	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+184->192, 7:+503->511, 8:+507->515
      //   56: new 292	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 293	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto
      //   67: dup
      //   68: invokespecial 38	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 294 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 297	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 299	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_3
      //   115: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 303 3 0
      //   123: putfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   126: aload_0
      //   127: aload_2
      //   128: aload_0
      //   129: getfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   132: aload_3
      //   133: getfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   136: invokeinterface 307 3 0
      //   141: checkcast 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   144: putfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   147: aload_0
      //   148: aload_2
      //   149: aload_0
      //   150: getfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   153: aload_3
      //   154: getfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   157: invokeinterface 307 3 0
      //   162: checkcast 200	com/google/protobuf/Timestamp
      //   165: putfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   168: aload_0
      //   169: astore_1
      //   170: aload_2
      //   171: getstatic 313	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   174: if_acmpne -102 -> 72
      //   177: aload_0
      //   178: aload_0
      //   179: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   182: aload_3
      //   183: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   186: ior
      //   187: putfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   190: aload_0
      //   191: areturn
      //   192: aload_2
      //   193: checkcast 315	com/google/protobuf/CodedInputStream
      //   196: astore_2
      //   197: aload_3
      //   198: checkcast 317	com/google/protobuf/ExtensionRegistryLite
      //   201: astore_3
      //   202: iconst_0
      //   203: istore 4
      //   205: iload 4
      //   207: ifne +304 -> 511
      //   210: aload_2
      //   211: invokevirtual 320	com/google/protobuf/CodedInputStream:readTag	()I
      //   214: istore 5
      //   216: iload 5
      //   218: lookupswitch	default:+338->556, 0:+341->559, 10:+58->276, 18:+119->337, 26:+218->436
      //   260: aload_0
      //   261: iload 5
      //   263: aload_2
      //   264: invokevirtual 324	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   267: ifne -62 -> 205
      //   270: iconst_1
      //   271: istore 4
      //   273: goto -68 -> 205
      //   276: aload_0
      //   277: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   280: invokeinterface 175 1 0
      //   285: ifne +14 -> 299
      //   288: aload_0
      //   289: aload_0
      //   290: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   293: invokestatic 179	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   296: putfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   299: aload_0
      //   300: getfield 51	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:s2CellLocalizationResults_	Lcom/google/protobuf/Internal$ProtobufList;
      //   303: aload_2
      //   304: invokestatic 328	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$S2CellLocalizationResultsProto:parser	()Lcom/google/protobuf/Parser;
      //   307: aload_3
      //   308: invokevirtual 332	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   311: invokeinterface 165 2 0
      //   316: pop
      //   317: goto -112 -> 205
      //   320: astore_1
      //   321: new 334	java/lang/RuntimeException
      //   324: dup
      //   325: aload_1
      //   326: aload_0
      //   327: invokevirtual 338	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   330: invokespecial 341	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   333: athrow
      //   334: astore_1
      //   335: aload_1
      //   336: athrow
      //   337: aconst_null
      //   338: astore_1
      //   339: aload_0
      //   340: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   343: iconst_1
      //   344: iand
      //   345: iconst_1
      //   346: if_icmpne +14 -> 360
      //   349: aload_0
      //   350: getfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   353: invokevirtual 342	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   356: checkcast 191	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder
      //   359: astore_1
      //   360: aload_0
      //   361: aload_2
      //   362: invokestatic 343	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto:parser	()Lcom/google/protobuf/Parser;
      //   365: aload_3
      //   366: invokevirtual 332	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   369: checkcast 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   372: putfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   375: aload_1
      //   376: ifnull +23 -> 399
      //   379: aload_1
      //   380: aload_0
      //   381: getfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   384: invokevirtual 195	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   387: pop
      //   388: aload_0
      //   389: aload_1
      //   390: invokevirtual 198	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   393: checkcast 182	com/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto
      //   396: putfield 167	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:aggregateStats_	Lcom/google/location/visualmapping/visualmapstore/common/AggregatedLocalizationResults$LocalizationStatsProto;
      //   399: aload_0
      //   400: aload_0
      //   401: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   404: iconst_1
      //   405: ior
      //   406: putfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   409: goto -204 -> 205
      //   412: astore_1
      //   413: new 334	java/lang/RuntimeException
      //   416: dup
      //   417: new 233	com/google/protobuf/InvalidProtocolBufferException
      //   420: dup
      //   421: aload_1
      //   422: invokevirtual 347	java/io/IOException:getMessage	()Ljava/lang/String;
      //   425: invokespecial 350	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   428: aload_0
      //   429: invokevirtual 338	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   432: invokespecial 341	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   435: athrow
      //   436: aconst_null
      //   437: astore_1
      //   438: aload_0
      //   439: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   442: iconst_2
      //   443: iand
      //   444: iconst_2
      //   445: if_icmpne +14 -> 459
      //   448: aload_0
      //   449: getfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   452: invokevirtual 351	com/google/protobuf/Timestamp:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   455: checkcast 208	com/google/protobuf/Timestamp$Builder
      //   458: astore_1
      //   459: aload_0
      //   460: aload_2
      //   461: invokestatic 352	com/google/protobuf/Timestamp:parser	()Lcom/google/protobuf/Parser;
      //   464: aload_3
      //   465: invokevirtual 332	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   468: checkcast 200	com/google/protobuf/Timestamp
      //   471: putfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   474: aload_1
      //   475: ifnull +23 -> 498
      //   478: aload_1
      //   479: aload_0
      //   480: getfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   483: invokevirtual 209	com/google/protobuf/Timestamp$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   486: pop
      //   487: aload_0
      //   488: aload_1
      //   489: invokevirtual 210	com/google/protobuf/Timestamp$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   492: checkcast 200	com/google/protobuf/Timestamp
      //   495: putfield 171	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:mostRecentCollection_	Lcom/google/protobuf/Timestamp;
      //   498: aload_0
      //   499: aload_0
      //   500: getfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   503: iconst_2
      //   504: ior
      //   505: putfield 169	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:bitField0_	I
      //   508: goto -303 -> 205
      //   511: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto;
      //   514: areturn
      //   515: getstatic 354	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   518: ifnonnull +28 -> 546
      //   521: ldc 2
      //   523: monitorenter
      //   524: getstatic 354	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   527: ifnonnull +16 -> 543
      //   530: new 356	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   533: dup
      //   534: getstatic 40	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto;
      //   537: invokespecial 359	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   540: putstatic 354	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   543: ldc 2
      //   545: monitorexit
      //   546: getstatic 354	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListLocalizationResultsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   549: areturn
      //   550: astore_1
      //   551: ldc 2
      //   553: monitorexit
      //   554: aload_1
      //   555: athrow
      //   556: goto -296 -> 260
      //   559: iconst_1
      //   560: istore 4
      //   562: goto -357 -> 205
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	565	0	this	ListLocalizationResultsResponseProto
      //   0	565	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	565	2	paramObject1	Object
      //   0	565	3	paramObject2	Object
      //   203	358	4	i	int
      //   214	48	5	j	int
      // Exception table:
      //   from	to	target	type
      //   210	216	320	com/google/protobuf/InvalidProtocolBufferException
      //   260	270	320	com/google/protobuf/InvalidProtocolBufferException
      //   276	299	320	com/google/protobuf/InvalidProtocolBufferException
      //   299	317	320	com/google/protobuf/InvalidProtocolBufferException
      //   339	360	320	com/google/protobuf/InvalidProtocolBufferException
      //   360	375	320	com/google/protobuf/InvalidProtocolBufferException
      //   379	399	320	com/google/protobuf/InvalidProtocolBufferException
      //   399	409	320	com/google/protobuf/InvalidProtocolBufferException
      //   438	459	320	com/google/protobuf/InvalidProtocolBufferException
      //   459	474	320	com/google/protobuf/InvalidProtocolBufferException
      //   478	498	320	com/google/protobuf/InvalidProtocolBufferException
      //   498	508	320	com/google/protobuf/InvalidProtocolBufferException
      //   210	216	334	finally
      //   260	270	334	finally
      //   276	299	334	finally
      //   299	317	334	finally
      //   321	334	334	finally
      //   339	360	334	finally
      //   360	375	334	finally
      //   379	399	334	finally
      //   399	409	334	finally
      //   413	436	334	finally
      //   438	459	334	finally
      //   459	474	334	finally
      //   478	498	334	finally
      //   498	508	334	finally
      //   210	216	412	java/io/IOException
      //   260	270	412	java/io/IOException
      //   276	299	412	java/io/IOException
      //   299	317	412	java/io/IOException
      //   339	360	412	java/io/IOException
      //   360	375	412	java/io/IOException
      //   379	399	412	java/io/IOException
      //   399	409	412	java/io/IOException
      //   438	459	412	java/io/IOException
      //   459	474	412	java/io/IOException
      //   478	498	412	java/io/IOException
      //   498	508	412	java/io/IOException
      //   524	543	550	finally
      //   543	546	550	finally
      //   551	554	550	finally
    }
    
    public AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats()
    {
      if (this.aggregateStats_ == null) {
        return AggregatedLocalizationResults.LocalizationStatsProto.getDefaultInstance();
      }
      return this.aggregateStats_;
    }
    
    public Timestamp getMostRecentCollection()
    {
      if (this.mostRecentCollection_ == null) {
        return Timestamp.getDefaultInstance();
      }
      return this.mostRecentCollection_;
    }
    
    public AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt)
    {
      return (AggregatedLocalizationResults.S2CellLocalizationResultsProto)this.s2CellLocalizationResults_.get(paramInt);
    }
    
    public int getS2CellLocalizationResultsCount()
    {
      return this.s2CellLocalizationResults_.size();
    }
    
    public List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList()
    {
      return this.s2CellLocalizationResults_;
    }
    
    public AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder getS2CellLocalizationResultsOrBuilder(int paramInt)
    {
      return (AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder)this.s2CellLocalizationResults_.get(paramInt);
    }
    
    public List<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProtoOrBuilder> getS2CellLocalizationResultsOrBuilderList()
    {
      return this.s2CellLocalizationResults_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (j < this.s2CellLocalizationResults_.size())
      {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.s2CellLocalizationResults_.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x1) == 1) {
        j = i + CodedOutputStream.computeMessageSize(2, getAggregateStats());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeMessageSize(3, getMostRecentCollection());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAggregateStats()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasMostRecentCollection()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.s2CellLocalizationResults_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.s2CellLocalizationResults_.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeMessage(2, getAggregateStats());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(3, getMostRecentCollection());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListLocalizationResultsResponseProto, Builder>
      implements VpsManagementWire.ListLocalizationResultsResponseProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllS2CellLocalizationResults(Iterable<? extends AggregatedLocalizationResults.S2CellLocalizationResultsProto> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).addAllS2CellLocalizationResults(paramIterable);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).addS2CellLocalizationResults(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).addS2CellLocalizationResults(paramInt, paramS2CellLocalizationResultsProto);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).addS2CellLocalizationResults(paramBuilder);
        return this;
      }
      
      public Builder addS2CellLocalizationResults(AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).addS2CellLocalizationResults(paramS2CellLocalizationResultsProto);
        return this;
      }
      
      public Builder clearAggregateStats()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).clearAggregateStats();
        return this;
      }
      
      public Builder clearMostRecentCollection()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).clearMostRecentCollection();
        return this;
      }
      
      public Builder clearS2CellLocalizationResults()
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).clearS2CellLocalizationResults();
        return this;
      }
      
      public AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats()
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).getAggregateStats();
      }
      
      public Timestamp getMostRecentCollection()
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).getMostRecentCollection();
      }
      
      public AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt)
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).getS2CellLocalizationResults(paramInt);
      }
      
      public int getS2CellLocalizationResultsCount()
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).getS2CellLocalizationResultsCount();
      }
      
      public List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).getS2CellLocalizationResultsList());
      }
      
      public boolean hasAggregateStats()
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).hasAggregateStats();
      }
      
      public boolean hasMostRecentCollection()
      {
        return ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).hasMostRecentCollection();
      }
      
      public Builder mergeAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).mergeAggregateStats(paramLocalizationStatsProto);
        return this;
      }
      
      public Builder mergeMostRecentCollection(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).mergeMostRecentCollection(paramTimestamp);
        return this;
      }
      
      public Builder removeS2CellLocalizationResults(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).removeS2CellLocalizationResults(paramInt);
        return this;
      }
      
      public Builder setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setAggregateStats(paramBuilder);
        return this;
      }
      
      public Builder setAggregateStats(AggregatedLocalizationResults.LocalizationStatsProto paramLocalizationStatsProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setAggregateStats(paramLocalizationStatsProto);
        return this;
      }
      
      public Builder setMostRecentCollection(Timestamp.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setMostRecentCollection(paramBuilder);
        return this;
      }
      
      public Builder setMostRecentCollection(Timestamp paramTimestamp)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setMostRecentCollection(paramTimestamp);
        return this;
      }
      
      public Builder setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setS2CellLocalizationResults(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setS2CellLocalizationResults(int paramInt, AggregatedLocalizationResults.S2CellLocalizationResultsProto paramS2CellLocalizationResultsProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListLocalizationResultsResponseProto)this.instance).setS2CellLocalizationResults(paramInt, paramS2CellLocalizationResultsProto);
        return this;
      }
    }
  }
  
  public static abstract interface ListLocalizationResultsResponseProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract AggregatedLocalizationResults.LocalizationStatsProto getAggregateStats();
    
    public abstract Timestamp getMostRecentCollection();
    
    public abstract AggregatedLocalizationResults.S2CellLocalizationResultsProto getS2CellLocalizationResults(int paramInt);
    
    public abstract int getS2CellLocalizationResultsCount();
    
    public abstract List<AggregatedLocalizationResults.S2CellLocalizationResultsProto> getS2CellLocalizationResultsList();
    
    public abstract boolean hasAggregateStats();
    
    public abstract boolean hasMostRecentCollection();
  }
  
  public static final class ListMapObjectsRequestProto
    extends GeneratedMessageLite<ListMapObjectsRequestProto, Builder>
    implements VpsManagementWire.ListMapObjectsRequestProtoOrBuilder
  {
    private static final ListMapObjectsRequestProto DEFAULT_INSTANCE;
    public static final int FLOORS_FIELD_NUMBER = 3;
    public static final int OBJECT_CATEGORIES_FIELD_NUMBER = 2;
    private static volatile Parser<ListMapObjectsRequestProto> PARSER;
    public static final int VENUE_GROUP_ID_FIELD_NUMBER = 1;
    private static final Internal.ListAdapter.Converter<Integer, MapObjectOuterClass.MapObjectCategory> objectCategories_converter_ = new Internal.ListAdapter.Converter()
    {
      public MapObjectOuterClass.MapObjectCategory convert(Integer paramAnonymousInteger)
      {
        MapObjectOuterClass.MapObjectCategory localMapObjectCategory = MapObjectOuterClass.MapObjectCategory.forNumber(paramAnonymousInteger.intValue());
        paramAnonymousInteger = localMapObjectCategory;
        if (localMapObjectCategory == null) {
          paramAnonymousInteger = MapObjectOuterClass.MapObjectCategory.UNKNOWN_MAP_OBJECT_CATEGORY;
        }
        return paramAnonymousInteger;
      }
    };
    private int bitField0_;
    private Internal.ProtobufList<String> floors_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.IntList objectCategories_ = emptyIntList();
    private String venueGroupId_ = "";
    
    static
    {
      DEFAULT_INSTANCE = new ListMapObjectsRequestProto();
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFloors(Iterable<String> paramIterable)
    {
      ensureFloorsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.floors_);
    }
    
    private void addAllObjectCategories(Iterable<? extends MapObjectOuterClass.MapObjectCategory> paramIterable)
    {
      ensureObjectCategoriesIsMutable();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        MapObjectOuterClass.MapObjectCategory localMapObjectCategory = (MapObjectOuterClass.MapObjectCategory)paramIterable.next();
        this.objectCategories_.addInt(localMapObjectCategory.getNumber());
      }
    }
    
    private void addFloors(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureFloorsIsMutable();
      this.floors_.add(paramString);
    }
    
    private void addFloorsBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      ensureFloorsIsMutable();
      this.floors_.add(paramByteString.toStringUtf8());
    }
    
    private void addObjectCategories(MapObjectOuterClass.MapObjectCategory paramMapObjectCategory)
    {
      if (paramMapObjectCategory == null) {
        throw new NullPointerException();
      }
      ensureObjectCategoriesIsMutable();
      this.objectCategories_.addInt(paramMapObjectCategory.getNumber());
    }
    
    private void clearFloors()
    {
      this.floors_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearObjectCategories()
    {
      this.objectCategories_ = emptyIntList();
    }
    
    private void clearVenueGroupId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.venueGroupId_ = getDefaultInstance().getVenueGroupId();
    }
    
    private void ensureFloorsIsMutable()
    {
      if (!this.floors_.isModifiable()) {
        this.floors_ = GeneratedMessageLite.mutableCopy(this.floors_);
      }
    }
    
    private void ensureObjectCategoriesIsMutable()
    {
      if (!this.objectCategories_.isModifiable()) {
        this.objectCategories_ = GeneratedMessageLite.mutableCopy(this.objectCategories_);
      }
    }
    
    public static ListMapObjectsRequestProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListMapObjectsRequestProto paramListMapObjectsRequestProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListMapObjectsRequestProto);
    }
    
    public static ListMapObjectsRequestProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListMapObjectsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListMapObjectsRequestProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsRequestProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListMapObjectsRequestProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsRequestProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListMapObjectsRequestProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsRequestProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListMapObjectsRequestProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsRequestProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListMapObjectsRequestProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListMapObjectsRequestProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setFloors(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureFloorsIsMutable();
      this.floors_.set(paramInt, paramString);
    }
    
    private void setObjectCategories(int paramInt, MapObjectOuterClass.MapObjectCategory paramMapObjectCategory)
    {
      if (paramMapObjectCategory == null) {
        throw new NullPointerException();
      }
      ensureObjectCategoriesIsMutable();
      this.objectCategories_.setInt(paramInt, paramMapObjectCategory.getNumber());
    }
    
    private void setVenueGroupId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.venueGroupId_ = paramString;
    }
    
    private void setVenueGroupIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.venueGroupId_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 285	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 290	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+90->98, 5:+99->107, 6:+195->203, 7:+542->550, 8:+546->554
      //   56: new 292	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 293	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto
      //   67: dup
      //   68: invokespecial 46	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 48	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   82: invokeinterface 294 1 0
      //   87: aload_0
      //   88: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   91: invokeinterface 295 1 0
      //   96: aconst_null
      //   97: areturn
      //   98: new 14	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto$Builder
      //   101: dup
      //   102: aconst_null
      //   103: invokespecial 298	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   106: areturn
      //   107: aload_2
      //   108: checkcast 300	com/google/protobuf/GeneratedMessageLite$Visitor
      //   111: astore_2
      //   112: aload_3
      //   113: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto
      //   116: astore_3
      //   117: aload_0
      //   118: aload_2
      //   119: aload_0
      //   120: invokevirtual 303	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:hasVenueGroupId	()Z
      //   123: aload_0
      //   124: getfield 57	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:venueGroupId_	Ljava/lang/String;
      //   127: aload_3
      //   128: invokevirtual 303	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:hasVenueGroupId	()Z
      //   131: aload_3
      //   132: getfield 57	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:venueGroupId_	Ljava/lang/String;
      //   135: invokeinterface 307 5 0
      //   140: putfield 57	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:venueGroupId_	Ljava/lang/String;
      //   143: aload_0
      //   144: aload_2
      //   145: aload_0
      //   146: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   149: aload_3
      //   150: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   153: invokeinterface 311 3 0
      //   158: putfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   161: aload_0
      //   162: aload_2
      //   163: aload_0
      //   164: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   167: aload_3
      //   168: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   171: invokeinterface 315 3 0
      //   176: putfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   179: aload_0
      //   180: astore_1
      //   181: aload_2
      //   182: getstatic 321	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   185: if_acmpne -113 -> 72
      //   188: aload_0
      //   189: aload_0
      //   190: getfield 192	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:bitField0_	I
      //   193: aload_3
      //   194: getfield 192	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:bitField0_	I
      //   197: ior
      //   198: putfield 192	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:bitField0_	I
      //   201: aload_0
      //   202: areturn
      //   203: aload_2
      //   204: checkcast 323	com/google/protobuf/CodedInputStream
      //   207: astore_1
      //   208: aload_3
      //   209: checkcast 325	com/google/protobuf/ExtensionRegistryLite
      //   212: astore_2
      //   213: iconst_0
      //   214: istore 4
      //   216: iload 4
      //   218: ifne +332 -> 550
      //   221: aload_1
      //   222: invokevirtual 328	com/google/protobuf/CodedInputStream:readTag	()I
      //   225: istore 5
      //   227: iload 5
      //   229: lookupswitch	default:+366->595, 0:+369->598, 10:+67->296, 16:+107->336, 18:+192->421, 26:+279->508
      //   280: aload_0
      //   281: iload 5
      //   283: aload_1
      //   284: invokevirtual 332	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   287: ifne -71 -> 216
      //   290: iconst_1
      //   291: istore 4
      //   293: goto -77 -> 216
      //   296: aload_1
      //   297: invokevirtual 335	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   300: astore_2
      //   301: aload_0
      //   302: aload_0
      //   303: getfield 192	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:bitField0_	I
      //   306: iconst_1
      //   307: ior
      //   308: putfield 192	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:bitField0_	I
      //   311: aload_0
      //   312: aload_2
      //   313: putfield 57	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:venueGroupId_	Ljava/lang/String;
      //   316: goto -100 -> 216
      //   319: astore_1
      //   320: new 337	java/lang/RuntimeException
      //   323: dup
      //   324: aload_1
      //   325: aload_0
      //   326: invokevirtual 341	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   329: invokespecial 344	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   332: athrow
      //   333: astore_1
      //   334: aload_1
      //   335: athrow
      //   336: aload_0
      //   337: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   340: invokeinterface 206 1 0
      //   345: ifne +14 -> 359
      //   348: aload_0
      //   349: aload_0
      //   350: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   353: invokestatic 209	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   356: putfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   359: aload_1
      //   360: invokevirtual 347	com/google/protobuf/CodedInputStream:readEnum	()I
      //   363: istore 5
      //   365: iload 5
      //   367: invokestatic 351	com/google/location/visualmapping/vpsmanagement/MapObjectOuterClass$MapObjectCategory:forNumber	(I)Lcom/google/location/visualmapping/vpsmanagement/MapObjectOuterClass$MapObjectCategory;
      //   370: ifnonnull +37 -> 407
      //   373: aload_0
      //   374: iconst_2
      //   375: iload 5
      //   377: invokespecial 355	com/google/protobuf/GeneratedMessageLite:mergeVarintField	(II)V
      //   380: goto -164 -> 216
      //   383: astore_1
      //   384: new 337	java/lang/RuntimeException
      //   387: dup
      //   388: new 236	com/google/protobuf/InvalidProtocolBufferException
      //   391: dup
      //   392: aload_1
      //   393: invokevirtual 358	java/io/IOException:getMessage	()Ljava/lang/String;
      //   396: invokespecial 360	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   399: aload_0
      //   400: invokevirtual 341	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   403: invokespecial 344	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   406: athrow
      //   407: aload_0
      //   408: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   411: iload 5
      //   413: invokeinterface 174 2 0
      //   418: goto -202 -> 216
      //   421: aload_0
      //   422: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   425: invokeinterface 206 1 0
      //   430: ifne +14 -> 444
      //   433: aload_0
      //   434: aload_0
      //   435: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   438: invokestatic 209	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   441: putfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   444: aload_1
      //   445: aload_1
      //   446: invokevirtual 363	com/google/protobuf/CodedInputStream:readRawVarint32	()I
      //   449: invokevirtual 367	com/google/protobuf/CodedInputStream:pushLimit	(I)I
      //   452: istore 5
      //   454: aload_1
      //   455: invokevirtual 370	com/google/protobuf/CodedInputStream:getBytesUntilLimit	()I
      //   458: ifle +41 -> 499
      //   461: aload_1
      //   462: invokevirtual 347	com/google/protobuf/CodedInputStream:readEnum	()I
      //   465: istore 6
      //   467: iload 6
      //   469: invokestatic 351	com/google/location/visualmapping/vpsmanagement/MapObjectOuterClass$MapObjectCategory:forNumber	(I)Lcom/google/location/visualmapping/vpsmanagement/MapObjectOuterClass$MapObjectCategory;
      //   472: ifnonnull +13 -> 485
      //   475: aload_0
      //   476: iconst_2
      //   477: iload 6
      //   479: invokespecial 355	com/google/protobuf/GeneratedMessageLite:mergeVarintField	(II)V
      //   482: goto -28 -> 454
      //   485: aload_0
      //   486: getfield 63	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:objectCategories_	Lcom/google/protobuf/Internal$IntList;
      //   489: iload 6
      //   491: invokeinterface 174 2 0
      //   496: goto -42 -> 454
      //   499: aload_1
      //   500: iload 5
      //   502: invokevirtual 373	com/google/protobuf/CodedInputStream:popLimit	(I)V
      //   505: goto -289 -> 216
      //   508: aload_1
      //   509: invokevirtual 335	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   512: astore_2
      //   513: aload_0
      //   514: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   517: invokeinterface 201 1 0
      //   522: ifne +14 -> 536
      //   525: aload_0
      //   526: aload_0
      //   527: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   530: invokestatic 205	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   533: putfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   536: aload_0
      //   537: getfield 69	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:floors_	Lcom/google/protobuf/Internal$ProtobufList;
      //   540: aload_2
      //   541: invokeinterface 184 2 0
      //   546: pop
      //   547: goto -331 -> 216
      //   550: getstatic 48	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto;
      //   553: areturn
      //   554: getstatic 375	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   557: ifnonnull +28 -> 585
      //   560: ldc 2
      //   562: monitorenter
      //   563: getstatic 375	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   566: ifnonnull +16 -> 582
      //   569: new 377	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   572: dup
      //   573: getstatic 48	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto;
      //   576: invokespecial 380	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   579: putstatic 375	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   582: ldc 2
      //   584: monitorexit
      //   585: getstatic 375	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   588: areturn
      //   589: astore_1
      //   590: ldc 2
      //   592: monitorexit
      //   593: aload_1
      //   594: athrow
      //   595: goto -315 -> 280
      //   598: iconst_1
      //   599: istore 4
      //   601: goto -385 -> 216
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	604	0	this	ListMapObjectsRequestProto
      //   0	604	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	604	2	paramObject1	Object
      //   0	604	3	paramObject2	Object
      //   214	386	4	i	int
      //   225	276	5	j	int
      //   465	25	6	k	int
      // Exception table:
      //   from	to	target	type
      //   221	227	319	com/google/protobuf/InvalidProtocolBufferException
      //   280	290	319	com/google/protobuf/InvalidProtocolBufferException
      //   296	316	319	com/google/protobuf/InvalidProtocolBufferException
      //   336	359	319	com/google/protobuf/InvalidProtocolBufferException
      //   359	380	319	com/google/protobuf/InvalidProtocolBufferException
      //   407	418	319	com/google/protobuf/InvalidProtocolBufferException
      //   421	444	319	com/google/protobuf/InvalidProtocolBufferException
      //   444	454	319	com/google/protobuf/InvalidProtocolBufferException
      //   454	482	319	com/google/protobuf/InvalidProtocolBufferException
      //   485	496	319	com/google/protobuf/InvalidProtocolBufferException
      //   499	505	319	com/google/protobuf/InvalidProtocolBufferException
      //   508	536	319	com/google/protobuf/InvalidProtocolBufferException
      //   536	547	319	com/google/protobuf/InvalidProtocolBufferException
      //   221	227	333	finally
      //   280	290	333	finally
      //   296	316	333	finally
      //   320	333	333	finally
      //   336	359	333	finally
      //   359	380	333	finally
      //   384	407	333	finally
      //   407	418	333	finally
      //   421	444	333	finally
      //   444	454	333	finally
      //   454	482	333	finally
      //   485	496	333	finally
      //   499	505	333	finally
      //   508	536	333	finally
      //   536	547	333	finally
      //   221	227	383	java/io/IOException
      //   280	290	383	java/io/IOException
      //   296	316	383	java/io/IOException
      //   336	359	383	java/io/IOException
      //   359	380	383	java/io/IOException
      //   407	418	383	java/io/IOException
      //   421	444	383	java/io/IOException
      //   444	454	383	java/io/IOException
      //   454	482	383	java/io/IOException
      //   485	496	383	java/io/IOException
      //   499	505	383	java/io/IOException
      //   508	536	383	java/io/IOException
      //   536	547	383	java/io/IOException
      //   563	582	589	finally
      //   582	585	589	finally
      //   590	593	589	finally
    }
    
    public String getFloors(int paramInt)
    {
      return (String)this.floors_.get(paramInt);
    }
    
    public ByteString getFloorsBytes(int paramInt)
    {
      return ByteString.copyFromUtf8((String)this.floors_.get(paramInt));
    }
    
    public int getFloorsCount()
    {
      return this.floors_.size();
    }
    
    public List<String> getFloorsList()
    {
      return this.floors_;
    }
    
    public MapObjectOuterClass.MapObjectCategory getObjectCategories(int paramInt)
    {
      return (MapObjectOuterClass.MapObjectCategory)objectCategories_converter_.convert(Integer.valueOf(this.objectCategories_.getInt(paramInt)));
    }
    
    public int getObjectCategoriesCount()
    {
      return this.objectCategories_.size();
    }
    
    public List<MapObjectOuterClass.MapObjectCategory> getObjectCategoriesList()
    {
      return new Internal.ListAdapter(this.objectCategories_, objectCategories_converter_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getVenueGroupId());
      }
      int j = 0;
      int k = 0;
      while (k < this.objectCategories_.size())
      {
        j += CodedOutputStream.computeEnumSizeNoTag(this.objectCategories_.getInt(k));
        k += 1;
      }
      int n = this.objectCategories_.size();
      int m = 0;
      k = 0;
      while (k < this.floors_.size())
      {
        m += CodedOutputStream.computeStringSizeNoTag((String)this.floors_.get(k));
        k += 1;
      }
      i = i + j + n * 1 + m + getFloorsList().size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getVenueGroupId()
    {
      return this.venueGroupId_;
    }
    
    public ByteString getVenueGroupIdBytes()
    {
      return ByteString.copyFromUtf8(this.venueGroupId_);
    }
    
    public boolean hasVenueGroupId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getVenueGroupId());
      }
      int i = 0;
      while (i < this.objectCategories_.size())
      {
        paramCodedOutputStream.writeEnum(2, this.objectCategories_.getInt(i));
        i += 1;
      }
      i = 0;
      while (i < this.floors_.size())
      {
        paramCodedOutputStream.writeString(3, (String)this.floors_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListMapObjectsRequestProto, Builder>
      implements VpsManagementWire.ListMapObjectsRequestProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllFloors(Iterable<String> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).addAllFloors(paramIterable);
        return this;
      }
      
      public Builder addAllObjectCategories(Iterable<? extends MapObjectOuterClass.MapObjectCategory> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).addAllObjectCategories(paramIterable);
        return this;
      }
      
      public Builder addFloors(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).addFloors(paramString);
        return this;
      }
      
      public Builder addFloorsBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).addFloorsBytes(paramByteString);
        return this;
      }
      
      public Builder addObjectCategories(MapObjectOuterClass.MapObjectCategory paramMapObjectCategory)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).addObjectCategories(paramMapObjectCategory);
        return this;
      }
      
      public Builder clearFloors()
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).clearFloors();
        return this;
      }
      
      public Builder clearObjectCategories()
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).clearObjectCategories();
        return this;
      }
      
      public Builder clearVenueGroupId()
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).clearVenueGroupId();
        return this;
      }
      
      public String getFloors(int paramInt)
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getFloors(paramInt);
      }
      
      public ByteString getFloorsBytes(int paramInt)
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getFloorsBytes(paramInt);
      }
      
      public int getFloorsCount()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getFloorsCount();
      }
      
      public List<String> getFloorsList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getFloorsList());
      }
      
      public MapObjectOuterClass.MapObjectCategory getObjectCategories(int paramInt)
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getObjectCategories(paramInt);
      }
      
      public int getObjectCategoriesCount()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getObjectCategoriesCount();
      }
      
      public List<MapObjectOuterClass.MapObjectCategory> getObjectCategoriesList()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getObjectCategoriesList();
      }
      
      public String getVenueGroupId()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getVenueGroupId();
      }
      
      public ByteString getVenueGroupIdBytes()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).getVenueGroupIdBytes();
      }
      
      public boolean hasVenueGroupId()
      {
        return ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).hasVenueGroupId();
      }
      
      public Builder setFloors(int paramInt, String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).setFloors(paramInt, paramString);
        return this;
      }
      
      public Builder setObjectCategories(int paramInt, MapObjectOuterClass.MapObjectCategory paramMapObjectCategory)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).setObjectCategories(paramInt, paramMapObjectCategory);
        return this;
      }
      
      public Builder setVenueGroupId(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).setVenueGroupId(paramString);
        return this;
      }
      
      public Builder setVenueGroupIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsRequestProto)this.instance).setVenueGroupIdBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface ListMapObjectsRequestProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getFloors(int paramInt);
    
    public abstract ByteString getFloorsBytes(int paramInt);
    
    public abstract int getFloorsCount();
    
    public abstract List<String> getFloorsList();
    
    public abstract MapObjectOuterClass.MapObjectCategory getObjectCategories(int paramInt);
    
    public abstract int getObjectCategoriesCount();
    
    public abstract List<MapObjectOuterClass.MapObjectCategory> getObjectCategoriesList();
    
    public abstract String getVenueGroupId();
    
    public abstract ByteString getVenueGroupIdBytes();
    
    public abstract boolean hasVenueGroupId();
  }
  
  public static final class ListMapObjectsResponseProto
    extends GeneratedMessageLite<ListMapObjectsResponseProto, Builder>
    implements VpsManagementWire.ListMapObjectsResponseProtoOrBuilder
  {
    private static final ListMapObjectsResponseProto DEFAULT_INSTANCE = new ListMapObjectsResponseProto();
    public static final int OBJECTS_FIELD_NUMBER = 1;
    private static volatile Parser<ListMapObjectsResponseProto> PARSER;
    private Internal.ProtobufList<MapObjectOuterClass.MapObject> objects_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllObjects(Iterable<? extends MapObjectOuterClass.MapObject> paramIterable)
    {
      ensureObjectsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.objects_);
    }
    
    private void addObjects(int paramInt, MapObjectOuterClass.MapObject.Builder paramBuilder)
    {
      ensureObjectsIsMutable();
      this.objects_.add(paramInt, paramBuilder.build());
    }
    
    private void addObjects(int paramInt, MapObjectOuterClass.MapObject paramMapObject)
    {
      if (paramMapObject == null) {
        throw new NullPointerException();
      }
      ensureObjectsIsMutable();
      this.objects_.add(paramInt, paramMapObject);
    }
    
    private void addObjects(MapObjectOuterClass.MapObject.Builder paramBuilder)
    {
      ensureObjectsIsMutable();
      this.objects_.add(paramBuilder.build());
    }
    
    private void addObjects(MapObjectOuterClass.MapObject paramMapObject)
    {
      if (paramMapObject == null) {
        throw new NullPointerException();
      }
      ensureObjectsIsMutable();
      this.objects_.add(paramMapObject);
    }
    
    private void clearObjects()
    {
      this.objects_ = emptyProtobufList();
    }
    
    private void ensureObjectsIsMutable()
    {
      if (!this.objects_.isModifiable()) {
        this.objects_ = GeneratedMessageLite.mutableCopy(this.objects_);
      }
    }
    
    public static ListMapObjectsResponseProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListMapObjectsResponseProto paramListMapObjectsResponseProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListMapObjectsResponseProto);
    }
    
    public static ListMapObjectsResponseProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListMapObjectsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListMapObjectsResponseProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsResponseProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListMapObjectsResponseProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsResponseProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListMapObjectsResponseProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsResponseProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListMapObjectsResponseProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListMapObjectsResponseProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListMapObjectsResponseProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListMapObjectsResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListMapObjectsResponseProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeObjects(int paramInt)
    {
      ensureObjectsIsMutable();
      this.objects_.remove(paramInt);
    }
    
    private void setObjects(int paramInt, MapObjectOuterClass.MapObject.Builder paramBuilder)
    {
      ensureObjectsIsMutable();
      this.objects_.set(paramInt, paramBuilder.build());
    }
    
    private void setObjects(int paramInt, MapObjectOuterClass.MapObject paramMapObject)
    {
      if (paramMapObject == null) {
        throw new NullPointerException();
      }
      ensureObjectsIsMutable();
      this.objects_.set(paramInt, paramMapObject);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 203	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 209	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+281->289, 8:+285->293
      //   56: new 211	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 212	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 213 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 216	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 218	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 222 3 0
      //   123: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
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
      //   152: ifne +137 -> 289
      //   155: aload_1
      //   156: invokevirtual 235	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+171->334, 0:+174->337, 10:+41->204
      //   188: aload_0
      //   189: iload 5
      //   191: aload_1
      //   192: invokevirtual 239	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   195: ifne -45 -> 150
      //   198: iconst_1
      //   199: istore 4
      //   201: goto -51 -> 150
      //   204: aload_0
      //   205: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   208: invokeinterface 122 1 0
      //   213: ifne +14 -> 227
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   221: invokestatic 126	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   224: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   227: aload_0
      //   228: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:objects_	Lcom/google/protobuf/Internal$ProtobufList;
      //   231: aload_1
      //   232: invokestatic 243	com/google/location/visualmapping/vpsmanagement/MapObjectOuterClass$MapObject:parser	()Lcom/google/protobuf/Parser;
      //   235: aload_2
      //   236: invokevirtual 247	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   239: invokeinterface 118 2 0
      //   244: pop
      //   245: goto -95 -> 150
      //   248: astore_1
      //   249: new 249	java/lang/RuntimeException
      //   252: dup
      //   253: aload_1
      //   254: aload_0
      //   255: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   261: athrow
      //   262: astore_1
      //   263: aload_1
      //   264: athrow
      //   265: astore_1
      //   266: new 249	java/lang/RuntimeException
      //   269: dup
      //   270: new 154	com/google/protobuf/InvalidProtocolBufferException
      //   273: dup
      //   274: aload_1
      //   275: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   278: invokespecial 263	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   281: aload_0
      //   282: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto;
      //   292: areturn
      //   293: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +28 -> 324
      //   299: ldc 2
      //   301: monitorenter
      //   302: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   305: ifnonnull +16 -> 321
      //   308: new 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   311: dup
      //   312: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto;
      //   315: invokespecial 270	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   318: putstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   321: ldc 2
      //   323: monitorexit
      //   324: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListMapObjectsResponseProto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	343	0	this	ListMapObjectsResponseProto
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
    
    public MapObjectOuterClass.MapObject getObjects(int paramInt)
    {
      return (MapObjectOuterClass.MapObject)this.objects_.get(paramInt);
    }
    
    public int getObjectsCount()
    {
      return this.objects_.size();
    }
    
    public List<MapObjectOuterClass.MapObject> getObjectsList()
    {
      return this.objects_;
    }
    
    public MapObjectOuterClass.MapObjectOrBuilder getObjectsOrBuilder(int paramInt)
    {
      return (MapObjectOuterClass.MapObjectOrBuilder)this.objects_.get(paramInt);
    }
    
    public List<? extends MapObjectOuterClass.MapObjectOrBuilder> getObjectsOrBuilderList()
    {
      return this.objects_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.objects_.size())
      {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.objects_.get(i));
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
      while (i < this.objects_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.objects_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListMapObjectsResponseProto, Builder>
      implements VpsManagementWire.ListMapObjectsResponseProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllObjects(Iterable<? extends MapObjectOuterClass.MapObject> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).addAllObjects(paramIterable);
        return this;
      }
      
      public Builder addObjects(int paramInt, MapObjectOuterClass.MapObject.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).addObjects(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addObjects(int paramInt, MapObjectOuterClass.MapObject paramMapObject)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).addObjects(paramInt, paramMapObject);
        return this;
      }
      
      public Builder addObjects(MapObjectOuterClass.MapObject.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).addObjects(paramBuilder);
        return this;
      }
      
      public Builder addObjects(MapObjectOuterClass.MapObject paramMapObject)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).addObjects(paramMapObject);
        return this;
      }
      
      public Builder clearObjects()
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).clearObjects();
        return this;
      }
      
      public MapObjectOuterClass.MapObject getObjects(int paramInt)
      {
        return ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).getObjects(paramInt);
      }
      
      public int getObjectsCount()
      {
        return ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).getObjectsCount();
      }
      
      public List<MapObjectOuterClass.MapObject> getObjectsList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListMapObjectsResponseProto)this.instance).getObjectsList());
      }
      
      public Builder removeObjects(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).removeObjects(paramInt);
        return this;
      }
      
      public Builder setObjects(int paramInt, MapObjectOuterClass.MapObject.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).setObjects(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setObjects(int paramInt, MapObjectOuterClass.MapObject paramMapObject)
      {
        copyOnWrite();
        ((VpsManagementWire.ListMapObjectsResponseProto)this.instance).setObjects(paramInt, paramMapObject);
        return this;
      }
    }
  }
  
  public static abstract interface ListMapObjectsResponseProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract MapObjectOuterClass.MapObject getObjects(int paramInt);
    
    public abstract int getObjectsCount();
    
    public abstract List<MapObjectOuterClass.MapObject> getObjectsList();
  }
  
  public static final class ListTrajectoriesRequestProto
    extends GeneratedMessageLite<ListTrajectoriesRequestProto, Builder>
    implements VpsManagementWire.ListTrajectoriesRequestProtoOrBuilder
  {
    public static final int ADF_UUIDS_FIELD_NUMBER = 1;
    private static final ListTrajectoriesRequestProto DEFAULT_INSTANCE = new ListTrajectoriesRequestProto();
    private static volatile Parser<ListTrajectoriesRequestProto> PARSER;
    private Internal.ProtobufList<String> adfUuids_ = GeneratedMessageLite.emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAdfUuids(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureAdfUuidsIsMutable();
      this.adfUuids_.add(paramString);
    }
    
    private void addAdfUuidsBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      ensureAdfUuidsIsMutable();
      this.adfUuids_.add(paramByteString.toStringUtf8());
    }
    
    private void addAllAdfUuids(Iterable<String> paramIterable)
    {
      ensureAdfUuidsIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.adfUuids_);
    }
    
    private void clearAdfUuids()
    {
      this.adfUuids_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureAdfUuidsIsMutable()
    {
      if (!this.adfUuids_.isModifiable()) {
        this.adfUuids_ = GeneratedMessageLite.mutableCopy(this.adfUuids_);
      }
    }
    
    public static ListTrajectoriesRequestProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListTrajectoriesRequestProto paramListTrajectoriesRequestProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListTrajectoriesRequestProto);
    }
    
    public static ListTrajectoriesRequestProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListTrajectoriesRequestProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListTrajectoriesRequestProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesRequestProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListTrajectoriesRequestProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAdfUuids(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureAdfUuidsIsMutable();
      this.adfUuids_.set(paramInt, paramString);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 180	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 186	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+279->287, 8:+283->291
      //   56: new 188	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 189	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 190 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 193	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 195	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 199 3 0
      //   123: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   126: aload_0
      //   127: astore_1
      //   128: aload_2
      //   129: getstatic 205	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   132: if_acmpne -60 -> 72
      //   135: aload_0
      //   136: areturn
      //   137: aload_2
      //   138: checkcast 207	com/google/protobuf/CodedInputStream
      //   141: astore_1
      //   142: aload_3
      //   143: checkcast 209	com/google/protobuf/ExtensionRegistryLite
      //   146: astore_2
      //   147: iconst_0
      //   148: istore 4
      //   150: iload 4
      //   152: ifne +135 -> 287
      //   155: aload_1
      //   156: invokevirtual 212	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+169->332, 0:+172->335, 10:+41->204
      //   188: aload_0
      //   189: iload 5
      //   191: aload_1
      //   192: invokevirtual 216	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   195: ifne -45 -> 150
      //   198: iconst_1
      //   199: istore 4
      //   201: goto -51 -> 150
      //   204: aload_1
      //   205: invokevirtual 219	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   208: astore_2
      //   209: aload_0
      //   210: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   213: invokeinterface 103 1 0
      //   218: ifne +14 -> 232
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   226: invokestatic 107	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   229: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   232: aload_0
      //   233: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:adfUuids_	Lcom/google/protobuf/Internal$ProtobufList;
      //   236: aload_2
      //   237: invokeinterface 85 2 0
      //   242: pop
      //   243: goto -93 -> 150
      //   246: astore_1
      //   247: new 221	java/lang/RuntimeException
      //   250: dup
      //   251: aload_1
      //   252: aload_0
      //   253: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   256: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   259: athrow
      //   260: astore_1
      //   261: aload_1
      //   262: athrow
      //   263: astore_1
      //   264: new 221	java/lang/RuntimeException
      //   267: dup
      //   268: new 135	com/google/protobuf/InvalidProtocolBufferException
      //   271: dup
      //   272: aload_1
      //   273: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
      //   276: invokespecial 233	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   279: aload_0
      //   280: invokevirtual 225	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   283: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   286: athrow
      //   287: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto;
      //   290: areturn
      //   291: getstatic 235	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   294: ifnonnull +28 -> 322
      //   297: ldc 2
      //   299: monitorenter
      //   300: getstatic 235	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   303: ifnonnull +16 -> 319
      //   306: new 237	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   309: dup
      //   310: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto;
      //   313: invokespecial 240	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   316: putstatic 235	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   319: ldc 2
      //   321: monitorexit
      //   322: getstatic 235	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesRequestProto:PARSER	Lcom/google/protobuf/Parser;
      //   325: areturn
      //   326: astore_1
      //   327: ldc 2
      //   329: monitorexit
      //   330: aload_1
      //   331: athrow
      //   332: goto -144 -> 188
      //   335: iconst_1
      //   336: istore 4
      //   338: goto -188 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	341	0	this	ListTrajectoriesRequestProto
      //   0	341	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	341	2	paramObject1	Object
      //   0	341	3	paramObject2	Object
      //   148	189	4	i	int
      //   159	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   155	161	246	com/google/protobuf/InvalidProtocolBufferException
      //   188	198	246	com/google/protobuf/InvalidProtocolBufferException
      //   204	232	246	com/google/protobuf/InvalidProtocolBufferException
      //   232	243	246	com/google/protobuf/InvalidProtocolBufferException
      //   155	161	260	finally
      //   188	198	260	finally
      //   204	232	260	finally
      //   232	243	260	finally
      //   247	260	260	finally
      //   264	287	260	finally
      //   155	161	263	java/io/IOException
      //   188	198	263	java/io/IOException
      //   204	232	263	java/io/IOException
      //   232	243	263	java/io/IOException
      //   300	319	326	finally
      //   319	322	326	finally
      //   327	330	326	finally
    }
    
    public String getAdfUuids(int paramInt)
    {
      return (String)this.adfUuids_.get(paramInt);
    }
    
    public ByteString getAdfUuidsBytes(int paramInt)
    {
      return ByteString.copyFromUtf8((String)this.adfUuids_.get(paramInt));
    }
    
    public int getAdfUuidsCount()
    {
      return this.adfUuids_.size();
    }
    
    public List<String> getAdfUuidsList()
    {
      return this.adfUuids_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.adfUuids_.size())
      {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.adfUuids_.get(i));
        i += 1;
      }
      i = 0 + j + getAdfUuidsList().size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.adfUuids_.size())
      {
        paramCodedOutputStream.writeString(1, (String)this.adfUuids_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListTrajectoriesRequestProto, Builder>
      implements VpsManagementWire.ListTrajectoriesRequestProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAdfUuids(String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).addAdfUuids(paramString);
        return this;
      }
      
      public Builder addAdfUuidsBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).addAdfUuidsBytes(paramByteString);
        return this;
      }
      
      public Builder addAllAdfUuids(Iterable<String> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).addAllAdfUuids(paramIterable);
        return this;
      }
      
      public Builder clearAdfUuids()
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).clearAdfUuids();
        return this;
      }
      
      public String getAdfUuids(int paramInt)
      {
        return ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).getAdfUuids(paramInt);
      }
      
      public ByteString getAdfUuidsBytes(int paramInt)
      {
        return ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).getAdfUuidsBytes(paramInt);
      }
      
      public int getAdfUuidsCount()
      {
        return ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).getAdfUuidsCount();
      }
      
      public List<String> getAdfUuidsList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).getAdfUuidsList());
      }
      
      public Builder setAdfUuids(int paramInt, String paramString)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesRequestProto)this.instance).setAdfUuids(paramInt, paramString);
        return this;
      }
    }
  }
  
  public static abstract interface ListTrajectoriesRequestProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getAdfUuids(int paramInt);
    
    public abstract ByteString getAdfUuidsBytes(int paramInt);
    
    public abstract int getAdfUuidsCount();
    
    public abstract List<String> getAdfUuidsList();
  }
  
  public static final class ListTrajectoriesResponseProto
    extends GeneratedMessageLite<ListTrajectoriesResponseProto, Builder>
    implements VpsManagementWire.ListTrajectoriesResponseProtoOrBuilder
  {
    private static final ListTrajectoriesResponseProto DEFAULT_INSTANCE = new ListTrajectoriesResponseProto();
    private static volatile Parser<ListTrajectoriesResponseProto> PARSER;
    public static final int TRAJECTORIES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<TrajectorySummary.TrajectorySummaryProto> trajectories_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTrajectories(Iterable<? extends TrajectorySummary.TrajectorySummaryProto> paramIterable)
    {
      ensureTrajectoriesIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.trajectories_);
    }
    
    private void addTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
    {
      ensureTrajectoriesIsMutable();
      this.trajectories_.add(paramInt, paramBuilder.build());
    }
    
    private void addTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
    {
      if (paramTrajectorySummaryProto == null) {
        throw new NullPointerException();
      }
      ensureTrajectoriesIsMutable();
      this.trajectories_.add(paramInt, paramTrajectorySummaryProto);
    }
    
    private void addTrajectories(TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
    {
      ensureTrajectoriesIsMutable();
      this.trajectories_.add(paramBuilder.build());
    }
    
    private void addTrajectories(TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
    {
      if (paramTrajectorySummaryProto == null) {
        throw new NullPointerException();
      }
      ensureTrajectoriesIsMutable();
      this.trajectories_.add(paramTrajectorySummaryProto);
    }
    
    private void clearTrajectories()
    {
      this.trajectories_ = emptyProtobufList();
    }
    
    private void ensureTrajectoriesIsMutable()
    {
      if (!this.trajectories_.isModifiable()) {
        this.trajectories_ = GeneratedMessageLite.mutableCopy(this.trajectories_);
      }
    }
    
    public static ListTrajectoriesResponseProto getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ListTrajectoriesResponseProto paramListTrajectoriesResponseProto)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListTrajectoriesResponseProto);
    }
    
    public static ListTrajectoriesResponseProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListTrajectoriesResponseProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ListTrajectoriesResponseProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ListTrajectoriesResponseProto)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ListTrajectoriesResponseProto> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeTrajectories(int paramInt)
    {
      ensureTrajectoriesIsMutable();
      this.trajectories_.remove(paramInt);
    }
    
    private void setTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
    {
      ensureTrajectoriesIsMutable();
      this.trajectories_.set(paramInt, paramBuilder.build());
    }
    
    private void setTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
    {
      if (paramTrajectorySummaryProto == null) {
        throw new NullPointerException();
      }
      ensureTrajectoriesIsMutable();
      this.trajectories_.set(paramInt, paramTrajectorySummaryProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 203	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 209	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+129->137, 7:+281->289, 8:+285->293
      //   56: new 211	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 212	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto
      //   67: dup
      //   68: invokespecial 29	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 213 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 216	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto$Builder:<init>	(Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 218	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto
      //   107: astore_1
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   114: aload_1
      //   115: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   118: invokeinterface 222 3 0
      //   123: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
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
      //   152: ifne +137 -> 289
      //   155: aload_1
      //   156: invokevirtual 235	com/google/protobuf/CodedInputStream:readTag	()I
      //   159: istore 5
      //   161: iload 5
      //   163: lookupswitch	default:+171->334, 0:+174->337, 10:+41->204
      //   188: aload_0
      //   189: iload 5
      //   191: aload_1
      //   192: invokevirtual 239	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   195: ifne -45 -> 150
      //   198: iconst_1
      //   199: istore 4
      //   201: goto -51 -> 150
      //   204: aload_0
      //   205: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   208: invokeinterface 122 1 0
      //   213: ifne +14 -> 227
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   221: invokestatic 126	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   224: putfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   227: aload_0
      //   228: getfield 42	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:trajectories_	Lcom/google/protobuf/Internal$ProtobufList;
      //   231: aload_1
      //   232: invokestatic 243	com/google/location/visualmapping/vpsmanagement/TrajectorySummary$TrajectorySummaryProto:parser	()Lcom/google/protobuf/Parser;
      //   235: aload_2
      //   236: invokevirtual 247	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   239: invokeinterface 118 2 0
      //   244: pop
      //   245: goto -95 -> 150
      //   248: astore_1
      //   249: new 249	java/lang/RuntimeException
      //   252: dup
      //   253: aload_1
      //   254: aload_0
      //   255: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   261: athrow
      //   262: astore_1
      //   263: aload_1
      //   264: athrow
      //   265: astore_1
      //   266: new 249	java/lang/RuntimeException
      //   269: dup
      //   270: new 154	com/google/protobuf/InvalidProtocolBufferException
      //   273: dup
      //   274: aload_1
      //   275: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
      //   278: invokespecial 263	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   281: aload_0
      //   282: invokevirtual 253	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto;
      //   292: areturn
      //   293: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +28 -> 324
      //   299: ldc 2
      //   301: monitorenter
      //   302: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   305: ifnonnull +16 -> 321
      //   308: new 267	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   311: dup
      //   312: getstatic 31	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:DEFAULT_INSTANCE	Lcom/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto;
      //   315: invokespecial 270	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   318: putstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:PARSER	Lcom/google/protobuf/Parser;
      //   321: ldc 2
      //   323: monitorexit
      //   324: getstatic 265	com/google/location/visualmapping/vpsmanagement/VpsManagementWire$ListTrajectoriesResponseProto:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	343	0	this	ListTrajectoriesResponseProto
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
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.trajectories_.size())
      {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.trajectories_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public TrajectorySummary.TrajectorySummaryProto getTrajectories(int paramInt)
    {
      return (TrajectorySummary.TrajectorySummaryProto)this.trajectories_.get(paramInt);
    }
    
    public int getTrajectoriesCount()
    {
      return this.trajectories_.size();
    }
    
    public List<TrajectorySummary.TrajectorySummaryProto> getTrajectoriesList()
    {
      return this.trajectories_;
    }
    
    public TrajectorySummary.TrajectorySummaryProtoOrBuilder getTrajectoriesOrBuilder(int paramInt)
    {
      return (TrajectorySummary.TrajectorySummaryProtoOrBuilder)this.trajectories_.get(paramInt);
    }
    
    public List<? extends TrajectorySummary.TrajectorySummaryProtoOrBuilder> getTrajectoriesOrBuilderList()
    {
      return this.trajectories_;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.trajectories_.size())
      {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.trajectories_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<VpsManagementWire.ListTrajectoriesResponseProto, Builder>
      implements VpsManagementWire.ListTrajectoriesResponseProtoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllTrajectories(Iterable<? extends TrajectorySummary.TrajectorySummaryProto> paramIterable)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).addAllTrajectories(paramIterable);
        return this;
      }
      
      public Builder addTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).addTrajectories(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).addTrajectories(paramInt, paramTrajectorySummaryProto);
        return this;
      }
      
      public Builder addTrajectories(TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).addTrajectories(paramBuilder);
        return this;
      }
      
      public Builder addTrajectories(TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).addTrajectories(paramTrajectorySummaryProto);
        return this;
      }
      
      public Builder clearTrajectories()
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).clearTrajectories();
        return this;
      }
      
      public TrajectorySummary.TrajectorySummaryProto getTrajectories(int paramInt)
      {
        return ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).getTrajectories(paramInt);
      }
      
      public int getTrajectoriesCount()
      {
        return ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).getTrajectoriesCount();
      }
      
      public List<TrajectorySummary.TrajectorySummaryProto> getTrajectoriesList()
      {
        return Collections.unmodifiableList(((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).getTrajectoriesList());
      }
      
      public Builder removeTrajectories(int paramInt)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).removeTrajectories(paramInt);
        return this;
      }
      
      public Builder setTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).setTrajectories(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setTrajectories(int paramInt, TrajectorySummary.TrajectorySummaryProto paramTrajectorySummaryProto)
      {
        copyOnWrite();
        ((VpsManagementWire.ListTrajectoriesResponseProto)this.instance).setTrajectories(paramInt, paramTrajectorySummaryProto);
        return this;
      }
    }
  }
  
  public static abstract interface ListTrajectoriesResponseProtoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract TrajectorySummary.TrajectorySummaryProto getTrajectories(int paramInt);
    
    public abstract int getTrajectoriesCount();
    
    public abstract List<TrajectorySummary.TrajectorySummaryProto> getTrajectoriesList();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/vpsmanagement/VpsManagementWire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */