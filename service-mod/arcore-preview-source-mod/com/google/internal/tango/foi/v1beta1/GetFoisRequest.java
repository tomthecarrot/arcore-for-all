package com.google.internal.tango.foi.v1beta1;

import com.google.location.visualmapping.visualmapstore.TileInfoProto;
import com.google.location.visualmapping.visualmapstore.TileInfoProto.Builder;
import com.google.location.visualmapping.visualmapstore.TileInfoProtoOrBuilder;
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

public final class GetFoisRequest
  extends GeneratedMessageLite<GetFoisRequest, Builder>
  implements GetFoisRequestOrBuilder
{
  private static final GetFoisRequest DEFAULT_INSTANCE = new GetFoisRequest();
  public static final int FOI_IDS_FIELD_NUMBER = 2;
  public static final int LOCALIZATION_CONTEXT_FIELD_NUMBER = 4;
  private static volatile Parser<GetFoisRequest> PARSER;
  public static final int TILE_INFO_FIELD_NUMBER = 3;
  private Internal.ProtobufList<String> foiIds_ = GeneratedMessageLite.emptyProtobufList();
  private Internal.ProtobufList<ByteString> localizationContext_ = emptyProtobufList();
  private Internal.ProtobufList<TileInfoProto> tileInfo_ = emptyProtobufList();
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFoiIds(Iterable<String> paramIterable)
  {
    ensureFoiIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.foiIds_);
  }
  
  private void addAllLocalizationContext(Iterable<? extends ByteString> paramIterable)
  {
    ensureLocalizationContextIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.localizationContext_);
  }
  
  private void addAllTileInfo(Iterable<? extends TileInfoProto> paramIterable)
  {
    ensureTileInfoIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.tileInfo_);
  }
  
  private void addFoiIds(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureFoiIdsIsMutable();
    this.foiIds_.add(paramString);
  }
  
  private void addFoiIdsBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureFoiIdsIsMutable();
    this.foiIds_.add(paramByteString.toStringUtf8());
  }
  
  private void addLocalizationContext(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureLocalizationContextIsMutable();
    this.localizationContext_.add(paramByteString);
  }
  
  private void addTileInfo(int paramInt, TileInfoProto.Builder paramBuilder)
  {
    ensureTileInfoIsMutable();
    this.tileInfo_.add(paramInt, paramBuilder.build());
  }
  
  private void addTileInfo(int paramInt, TileInfoProto paramTileInfoProto)
  {
    if (paramTileInfoProto == null) {
      throw new NullPointerException();
    }
    ensureTileInfoIsMutable();
    this.tileInfo_.add(paramInt, paramTileInfoProto);
  }
  
  private void addTileInfo(TileInfoProto.Builder paramBuilder)
  {
    ensureTileInfoIsMutable();
    this.tileInfo_.add(paramBuilder.build());
  }
  
  private void addTileInfo(TileInfoProto paramTileInfoProto)
  {
    if (paramTileInfoProto == null) {
      throw new NullPointerException();
    }
    ensureTileInfoIsMutable();
    this.tileInfo_.add(paramTileInfoProto);
  }
  
  private void clearFoiIds()
  {
    this.foiIds_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearLocalizationContext()
  {
    this.localizationContext_ = emptyProtobufList();
  }
  
  private void clearTileInfo()
  {
    this.tileInfo_ = emptyProtobufList();
  }
  
  private void ensureFoiIdsIsMutable()
  {
    if (!this.foiIds_.isModifiable()) {
      this.foiIds_ = GeneratedMessageLite.mutableCopy(this.foiIds_);
    }
  }
  
  private void ensureLocalizationContextIsMutable()
  {
    if (!this.localizationContext_.isModifiable()) {
      this.localizationContext_ = GeneratedMessageLite.mutableCopy(this.localizationContext_);
    }
  }
  
  private void ensureTileInfoIsMutable()
  {
    if (!this.tileInfo_.isModifiable()) {
      this.tileInfo_ = GeneratedMessageLite.mutableCopy(this.tileInfo_);
    }
  }
  
  public static GetFoisRequest getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetFoisRequest paramGetFoisRequest)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetFoisRequest);
  }
  
  public static GetFoisRequest parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (GetFoisRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetFoisRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetFoisRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetFoisRequest parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetFoisRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetFoisRequest parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetFoisRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetFoisRequest parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetFoisRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetFoisRequest parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static GetFoisRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (GetFoisRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetFoisRequest> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeTileInfo(int paramInt)
  {
    ensureTileInfoIsMutable();
    this.tileInfo_.remove(paramInt);
  }
  
  private void setFoiIds(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureFoiIdsIsMutable();
    this.foiIds_.set(paramInt, paramString);
  }
  
  private void setLocalizationContext(int paramInt, ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureLocalizationContextIsMutable();
    this.localizationContext_.set(paramInt, paramByteString);
  }
  
  private void setTileInfo(int paramInt, TileInfoProto.Builder paramBuilder)
  {
    ensureTileInfoIsMutable();
    this.tileInfo_.set(paramInt, paramBuilder.build());
  }
  
  private void setTileInfo(int paramInt, TileInfoProto paramTileInfoProto)
  {
    if (paramTileInfoProto == null) {
      throw new NullPointerException();
    }
    ensureTileInfoIsMutable();
    this.tileInfo_.set(paramInt, paramTileInfoProto);
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 271	com/google/internal/tango/foi/v1beta1/GetFoisRequest$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 277	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+99->107, 5:+108->116, 6:+183->191, 7:+435->443, 8:+439->447
    //   56: new 279	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 280	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/google/internal/tango/foi/v1beta1/GetFoisRequest
    //   67: dup
    //   68: invokespecial 36	com/google/internal/tango/foi/v1beta1/GetFoisRequest:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 38	com/google/internal/tango/foi/v1beta1/GetFoisRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/GetFoisRequest;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 281 1 0
    //   87: aload_0
    //   88: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   91: invokeinterface 281 1 0
    //   96: aload_0
    //   97: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   100: invokeinterface 281 1 0
    //   105: aconst_null
    //   106: areturn
    //   107: new 11	com/google/internal/tango/foi/v1beta1/GetFoisRequest$Builder
    //   110: dup
    //   111: aconst_null
    //   112: invokespecial 284	com/google/internal/tango/foi/v1beta1/GetFoisRequest$Builder:<init>	(Lcom/google/internal/tango/foi/v1beta1/GetFoisRequest$1;)V
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 286	com/google/protobuf/GeneratedMessageLite$Visitor
    //   120: astore_2
    //   121: aload_3
    //   122: checkcast 2	com/google/internal/tango/foi/v1beta1/GetFoisRequest
    //   125: astore_1
    //   126: aload_0
    //   127: aload_2
    //   128: aload_0
    //   129: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   132: aload_1
    //   133: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   136: invokeinterface 290 3 0
    //   141: putfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   144: aload_0
    //   145: aload_2
    //   146: aload_0
    //   147: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   150: aload_1
    //   151: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   154: invokeinterface 290 3 0
    //   159: putfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   162: aload_0
    //   163: aload_2
    //   164: aload_0
    //   165: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   168: aload_1
    //   169: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface 290 3 0
    //   177: putfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   180: aload_0
    //   181: astore_1
    //   182: aload_2
    //   183: getstatic 296	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   186: if_acmpne -114 -> 72
    //   189: aload_0
    //   190: areturn
    //   191: aload_2
    //   192: checkcast 298	com/google/protobuf/CodedInputStream
    //   195: astore_1
    //   196: aload_3
    //   197: checkcast 300	com/google/protobuf/ExtensionRegistryLite
    //   200: astore_2
    //   201: iconst_0
    //   202: istore 4
    //   204: iload 4
    //   206: ifne +237 -> 443
    //   209: aload_1
    //   210: invokevirtual 303	com/google/protobuf/CodedInputStream:readTag	()I
    //   213: istore 5
    //   215: iload 5
    //   217: lookupswitch	default:+271->488, 0:+274->491, 18:+59->276, 26:+118->335, 34:+186->403
    //   260: aload_0
    //   261: iload 5
    //   263: aload_1
    //   264: invokevirtual 307	com/google/internal/tango/foi/v1beta1/GetFoisRequest:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   267: ifne -63 -> 204
    //   270: iconst_1
    //   271: istore 4
    //   273: goto -69 -> 204
    //   276: aload_1
    //   277: invokevirtual 310	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   285: invokeinterface 192 1 0
    //   290: ifne +14 -> 304
    //   293: aload_0
    //   294: aload_0
    //   295: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   298: invokestatic 196	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   301: putfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   304: aload_0
    //   305: getfield 49	com/google/internal/tango/foi/v1beta1/GetFoisRequest:foiIds_	Lcom/google/protobuf/Internal$ProtobufList;
    //   308: aload_3
    //   309: invokeinterface 173 2 0
    //   314: pop
    //   315: goto -111 -> 204
    //   318: astore_1
    //   319: new 312	java/lang/RuntimeException
    //   322: dup
    //   323: aload_1
    //   324: aload_0
    //   325: invokevirtual 316	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   328: invokespecial 319	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   331: athrow
    //   332: astore_1
    //   333: aload_1
    //   334: athrow
    //   335: aload_0
    //   336: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   339: invokeinterface 192 1 0
    //   344: ifne +14 -> 358
    //   347: aload_0
    //   348: aload_0
    //   349: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   352: invokestatic 196	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   355: putfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   358: aload_0
    //   359: getfield 52	com/google/internal/tango/foi/v1beta1/GetFoisRequest:tileInfo_	Lcom/google/protobuf/Internal$ProtobufList;
    //   362: aload_1
    //   363: invokestatic 323	com/google/location/visualmapping/visualmapstore/TileInfoProto:parser	()Lcom/google/protobuf/Parser;
    //   366: aload_2
    //   367: invokevirtual 327	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   370: invokeinterface 173 2 0
    //   375: pop
    //   376: goto -172 -> 204
    //   379: astore_1
    //   380: new 312	java/lang/RuntimeException
    //   383: dup
    //   384: new 224	com/google/protobuf/InvalidProtocolBufferException
    //   387: dup
    //   388: aload_1
    //   389: invokevirtual 330	java/io/IOException:getMessage	()Ljava/lang/String;
    //   392: invokespecial 332	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   395: aload_0
    //   396: invokevirtual 316	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   399: invokespecial 319	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   402: athrow
    //   403: aload_0
    //   404: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   407: invokeinterface 192 1 0
    //   412: ifne +14 -> 426
    //   415: aload_0
    //   416: aload_0
    //   417: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   420: invokestatic 196	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   423: putfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   426: aload_0
    //   427: getfield 54	com/google/internal/tango/foi/v1beta1/GetFoisRequest:localizationContext_	Lcom/google/protobuf/Internal$ProtobufList;
    //   430: aload_1
    //   431: invokevirtual 336	com/google/protobuf/CodedInputStream:readBytes	()Lcom/google/protobuf/ByteString;
    //   434: invokeinterface 173 2 0
    //   439: pop
    //   440: goto -236 -> 204
    //   443: getstatic 38	com/google/internal/tango/foi/v1beta1/GetFoisRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/GetFoisRequest;
    //   446: areturn
    //   447: getstatic 338	com/google/internal/tango/foi/v1beta1/GetFoisRequest:PARSER	Lcom/google/protobuf/Parser;
    //   450: ifnonnull +28 -> 478
    //   453: ldc 2
    //   455: monitorenter
    //   456: getstatic 338	com/google/internal/tango/foi/v1beta1/GetFoisRequest:PARSER	Lcom/google/protobuf/Parser;
    //   459: ifnonnull +16 -> 475
    //   462: new 340	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   465: dup
    //   466: getstatic 38	com/google/internal/tango/foi/v1beta1/GetFoisRequest:DEFAULT_INSTANCE	Lcom/google/internal/tango/foi/v1beta1/GetFoisRequest;
    //   469: invokespecial 343	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   472: putstatic 338	com/google/internal/tango/foi/v1beta1/GetFoisRequest:PARSER	Lcom/google/protobuf/Parser;
    //   475: ldc 2
    //   477: monitorexit
    //   478: getstatic 338	com/google/internal/tango/foi/v1beta1/GetFoisRequest:PARSER	Lcom/google/protobuf/Parser;
    //   481: areturn
    //   482: astore_1
    //   483: ldc 2
    //   485: monitorexit
    //   486: aload_1
    //   487: athrow
    //   488: goto -228 -> 260
    //   491: iconst_1
    //   492: istore 4
    //   494: goto -290 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	GetFoisRequest
    //   0	497	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	497	2	paramObject1	Object
    //   0	497	3	paramObject2	Object
    //   202	291	4	i	int
    //   213	49	5	j	int
    // Exception table:
    //   from	to	target	type
    //   209	215	318	com/google/protobuf/InvalidProtocolBufferException
    //   260	270	318	com/google/protobuf/InvalidProtocolBufferException
    //   276	304	318	com/google/protobuf/InvalidProtocolBufferException
    //   304	315	318	com/google/protobuf/InvalidProtocolBufferException
    //   335	358	318	com/google/protobuf/InvalidProtocolBufferException
    //   358	376	318	com/google/protobuf/InvalidProtocolBufferException
    //   403	426	318	com/google/protobuf/InvalidProtocolBufferException
    //   426	440	318	com/google/protobuf/InvalidProtocolBufferException
    //   209	215	332	finally
    //   260	270	332	finally
    //   276	304	332	finally
    //   304	315	332	finally
    //   319	332	332	finally
    //   335	358	332	finally
    //   358	376	332	finally
    //   380	403	332	finally
    //   403	426	332	finally
    //   426	440	332	finally
    //   209	215	379	java/io/IOException
    //   260	270	379	java/io/IOException
    //   276	304	379	java/io/IOException
    //   304	315	379	java/io/IOException
    //   335	358	379	java/io/IOException
    //   358	376	379	java/io/IOException
    //   403	426	379	java/io/IOException
    //   426	440	379	java/io/IOException
    //   456	475	482	finally
    //   475	478	482	finally
    //   483	486	482	finally
  }
  
  public String getFoiIds(int paramInt)
  {
    return (String)this.foiIds_.get(paramInt);
  }
  
  public ByteString getFoiIdsBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.foiIds_.get(paramInt));
  }
  
  public int getFoiIdsCount()
  {
    return this.foiIds_.size();
  }
  
  public List<String> getFoiIdsList()
  {
    return this.foiIds_;
  }
  
  public ByteString getLocalizationContext(int paramInt)
  {
    return (ByteString)this.localizationContext_.get(paramInt);
  }
  
  public int getLocalizationContextCount()
  {
    return this.localizationContext_.size();
  }
  
  public List<ByteString> getLocalizationContextList()
  {
    return this.localizationContext_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (i < this.foiIds_.size())
    {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.foiIds_.get(i));
      i += 1;
    }
    i = 0 + j + getFoiIdsList().size() * 1;
    j = 0;
    while (j < this.tileInfo_.size())
    {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.tileInfo_.get(j));
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < this.localizationContext_.size())
    {
      k += CodedOutputStream.computeBytesSizeNoTag((ByteString)this.localizationContext_.get(j));
      j += 1;
    }
    i = i + k + getLocalizationContextList().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  @Deprecated
  public TileInfoProto getTileInfo(int paramInt)
  {
    return (TileInfoProto)this.tileInfo_.get(paramInt);
  }
  
  @Deprecated
  public int getTileInfoCount()
  {
    return this.tileInfo_.size();
  }
  
  @Deprecated
  public List<TileInfoProto> getTileInfoList()
  {
    return this.tileInfo_;
  }
  
  @Deprecated
  public TileInfoProtoOrBuilder getTileInfoOrBuilder(int paramInt)
  {
    return (TileInfoProtoOrBuilder)this.tileInfo_.get(paramInt);
  }
  
  @Deprecated
  public List<? extends TileInfoProtoOrBuilder> getTileInfoOrBuilderList()
  {
    return this.tileInfo_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < this.foiIds_.size())
    {
      paramCodedOutputStream.writeString(2, (String)this.foiIds_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.tileInfo_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.tileInfo_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.localizationContext_.size())
    {
      paramCodedOutputStream.writeBytes(4, (ByteString)this.localizationContext_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<GetFoisRequest, Builder>
    implements GetFoisRequestOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllFoiIds(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addAllFoiIds(paramIterable);
      return this;
    }
    
    public Builder addAllLocalizationContext(Iterable<? extends ByteString> paramIterable)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addAllLocalizationContext(paramIterable);
      return this;
    }
    
    @Deprecated
    public Builder addAllTileInfo(Iterable<? extends TileInfoProto> paramIterable)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addAllTileInfo(paramIterable);
      return this;
    }
    
    public Builder addFoiIds(String paramString)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addFoiIds(paramString);
      return this;
    }
    
    public Builder addFoiIdsBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addFoiIdsBytes(paramByteString);
      return this;
    }
    
    public Builder addLocalizationContext(ByteString paramByteString)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addLocalizationContext(paramByteString);
      return this;
    }
    
    @Deprecated
    public Builder addTileInfo(int paramInt, TileInfoProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addTileInfo(paramInt, paramBuilder);
      return this;
    }
    
    @Deprecated
    public Builder addTileInfo(int paramInt, TileInfoProto paramTileInfoProto)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addTileInfo(paramInt, paramTileInfoProto);
      return this;
    }
    
    @Deprecated
    public Builder addTileInfo(TileInfoProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addTileInfo(paramBuilder);
      return this;
    }
    
    @Deprecated
    public Builder addTileInfo(TileInfoProto paramTileInfoProto)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).addTileInfo(paramTileInfoProto);
      return this;
    }
    
    public Builder clearFoiIds()
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).clearFoiIds();
      return this;
    }
    
    public Builder clearLocalizationContext()
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).clearLocalizationContext();
      return this;
    }
    
    @Deprecated
    public Builder clearTileInfo()
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).clearTileInfo();
      return this;
    }
    
    public String getFoiIds(int paramInt)
    {
      return ((GetFoisRequest)this.instance).getFoiIds(paramInt);
    }
    
    public ByteString getFoiIdsBytes(int paramInt)
    {
      return ((GetFoisRequest)this.instance).getFoiIdsBytes(paramInt);
    }
    
    public int getFoiIdsCount()
    {
      return ((GetFoisRequest)this.instance).getFoiIdsCount();
    }
    
    public List<String> getFoiIdsList()
    {
      return Collections.unmodifiableList(((GetFoisRequest)this.instance).getFoiIdsList());
    }
    
    public ByteString getLocalizationContext(int paramInt)
    {
      return ((GetFoisRequest)this.instance).getLocalizationContext(paramInt);
    }
    
    public int getLocalizationContextCount()
    {
      return ((GetFoisRequest)this.instance).getLocalizationContextCount();
    }
    
    public List<ByteString> getLocalizationContextList()
    {
      return Collections.unmodifiableList(((GetFoisRequest)this.instance).getLocalizationContextList());
    }
    
    @Deprecated
    public TileInfoProto getTileInfo(int paramInt)
    {
      return ((GetFoisRequest)this.instance).getTileInfo(paramInt);
    }
    
    @Deprecated
    public int getTileInfoCount()
    {
      return ((GetFoisRequest)this.instance).getTileInfoCount();
    }
    
    @Deprecated
    public List<TileInfoProto> getTileInfoList()
    {
      return Collections.unmodifiableList(((GetFoisRequest)this.instance).getTileInfoList());
    }
    
    @Deprecated
    public Builder removeTileInfo(int paramInt)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).removeTileInfo(paramInt);
      return this;
    }
    
    public Builder setFoiIds(int paramInt, String paramString)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).setFoiIds(paramInt, paramString);
      return this;
    }
    
    public Builder setLocalizationContext(int paramInt, ByteString paramByteString)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).setLocalizationContext(paramInt, paramByteString);
      return this;
    }
    
    @Deprecated
    public Builder setTileInfo(int paramInt, TileInfoProto.Builder paramBuilder)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).setTileInfo(paramInt, paramBuilder);
      return this;
    }
    
    @Deprecated
    public Builder setTileInfo(int paramInt, TileInfoProto paramTileInfoProto)
    {
      copyOnWrite();
      ((GetFoisRequest)this.instance).setTileInfo(paramInt, paramTileInfoProto);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/internal/tango/foi/v1beta1/GetFoisRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */