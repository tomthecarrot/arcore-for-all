package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder;
import com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class PluginProtos
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class CodeGeneratorRequest
    extends GeneratedMessageLite<CodeGeneratorRequest, Builder>
    implements PluginProtos.CodeGeneratorRequestOrBuilder
  {
    private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
    public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
    public static final int PARAMETER_FIELD_NUMBER = 2;
    private static volatile Parser<CodeGeneratorRequest> PARSER;
    public static final int PROTO_FILE_FIELD_NUMBER = 15;
    private int bitField0_;
    private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    private byte memoizedIsInitialized = -1;
    private String parameter_ = "";
    private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFileToGenerate(Iterable<String> paramIterable)
    {
      ensureFileToGenerateIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.fileToGenerate_);
    }
    
    private void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> paramIterable)
    {
      ensureProtoFileIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.protoFile_);
    }
    
    private void addFileToGenerate(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureFileToGenerateIsMutable();
      this.fileToGenerate_.add(paramString);
    }
    
    private void addFileToGenerateBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      ensureFileToGenerateIsMutable();
      this.fileToGenerate_.add(paramByteString.toStringUtf8());
    }
    
    private void addProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
    {
      ensureProtoFileIsMutable();
      this.protoFile_.add(paramInt, paramBuilder.build());
    }
    
    private void addProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
    {
      if (paramFileDescriptorProto == null) {
        throw new NullPointerException();
      }
      ensureProtoFileIsMutable();
      this.protoFile_.add(paramInt, paramFileDescriptorProto);
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
    {
      ensureProtoFileIsMutable();
      this.protoFile_.add(paramBuilder.build());
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
    {
      if (paramFileDescriptorProto == null) {
        throw new NullPointerException();
      }
      ensureProtoFileIsMutable();
      this.protoFile_.add(paramFileDescriptorProto);
    }
    
    private void clearFileToGenerate()
    {
      this.fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearParameter()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.parameter_ = getDefaultInstance().getParameter();
    }
    
    private void clearProtoFile()
    {
      this.protoFile_ = emptyProtobufList();
    }
    
    private void ensureFileToGenerateIsMutable()
    {
      if (!this.fileToGenerate_.isModifiable()) {
        this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_);
      }
    }
    
    private void ensureProtoFileIsMutable()
    {
      if (!this.protoFile_.isModifiable()) {
        this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_);
      }
    }
    
    public static CodeGeneratorRequest getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorRequest paramCodeGeneratorRequest)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCodeGeneratorRequest);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorRequest> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeProtoFile(int paramInt)
    {
      ensureProtoFileIsMutable();
      this.protoFile_.remove(paramInt);
    }
    
    private void setFileToGenerate(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureFileToGenerateIsMutable();
      this.fileToGenerate_.set(paramInt, paramString);
    }
    
    private void setParameter(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.parameter_ = paramString;
    }
    
    private void setParameterBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.parameter_ = paramByteString.toStringUtf8();
    }
    
    private void setProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
    {
      ensureProtoFileIsMutable();
      this.protoFile_.set(paramInt, paramBuilder.build());
    }
    
    private void setProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
    {
      if (paramFileDescriptorProto == null) {
        throw new NullPointerException();
      }
      ensureProtoFileIsMutable();
      this.protoFile_.set(paramInt, paramFileDescriptorProto);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 278	com/google/protobuf/compiler/PluginProtos$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 284	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+157->165, 4:+177->185, 5:+186->194, 6:+282->290, 7:+518->526, 8:+522->530
      //   56: new 286	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 287	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   67: dup
      //   68: invokespecial 40	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: aload_0
      //   75: getfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:memoizedIsInitialized	B
      //   78: istore 4
      //   80: iload 4
      //   82: iconst_1
      //   83: if_icmpne +7 -> 90
      //   86: getstatic 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   89: areturn
      //   90: iload 4
      //   92: ifne +5 -> 97
      //   95: aconst_null
      //   96: areturn
      //   97: aload_2
      //   98: checkcast 289	java/lang/Boolean
      //   101: invokevirtual 292	java/lang/Boolean:booleanValue	()Z
      //   104: istore 6
      //   106: iconst_0
      //   107: istore 4
      //   109: iload 4
      //   111: aload_0
      //   112: invokevirtual 295	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:getProtoFileCount	()I
      //   115: if_icmpge +36 -> 151
      //   118: aload_0
      //   119: iload 4
      //   121: invokevirtual 299	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:getProtoFile	(I)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;
      //   124: invokevirtual 304	com/google/protobuf/DescriptorProtos$FileDescriptorProto:isInitialized	()Z
      //   127: ifne +15 -> 142
      //   130: iload 6
      //   132: ifeq +8 -> 140
      //   135: aload_0
      //   136: iconst_0
      //   137: putfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:memoizedIsInitialized	B
      //   140: aconst_null
      //   141: areturn
      //   142: iload 4
      //   144: iconst_1
      //   145: iadd
      //   146: istore 4
      //   148: goto -39 -> 109
      //   151: iload 6
      //   153: ifeq +8 -> 161
      //   156: aload_0
      //   157: iconst_1
      //   158: putfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:memoizedIsInitialized	B
      //   161: getstatic 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   164: areturn
      //   165: aload_0
      //   166: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   169: invokeinterface 305 1 0
      //   174: aload_0
      //   175: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   178: invokeinterface 305 1 0
      //   183: aconst_null
      //   184: areturn
      //   185: new 12	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder
      //   188: dup
      //   189: aconst_null
      //   190: invokespecial 308	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder:<init>	(Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   193: areturn
      //   194: aload_2
      //   195: checkcast 310	com/google/protobuf/GeneratedMessageLite$Visitor
      //   198: astore_2
      //   199: aload_3
      //   200: checkcast 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   203: astore_3
      //   204: aload_0
      //   205: aload_2
      //   206: aload_0
      //   207: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   210: aload_3
      //   211: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   214: invokeinterface 314 3 0
      //   219: putfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   222: aload_0
      //   223: aload_2
      //   224: aload_0
      //   225: invokevirtual 317	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:hasParameter	()Z
      //   228: aload_0
      //   229: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parameter_	Ljava/lang/String;
      //   232: aload_3
      //   233: invokevirtual 317	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:hasParameter	()Z
      //   236: aload_3
      //   237: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parameter_	Ljava/lang/String;
      //   240: invokeinterface 321 5 0
      //   245: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parameter_	Ljava/lang/String;
      //   248: aload_0
      //   249: aload_2
      //   250: aload_0
      //   251: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   254: aload_3
      //   255: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   258: invokeinterface 314 3 0
      //   263: putfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   266: aload_0
      //   267: astore_1
      //   268: aload_2
      //   269: getstatic 327	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   272: if_acmpne -200 -> 72
      //   275: aload_0
      //   276: aload_0
      //   277: getfield 188	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
      //   280: aload_3
      //   281: getfield 188	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
      //   284: ior
      //   285: putfield 188	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
      //   288: aload_0
      //   289: areturn
      //   290: aload_2
      //   291: checkcast 329	com/google/protobuf/CodedInputStream
      //   294: astore_1
      //   295: aload_3
      //   296: checkcast 331	com/google/protobuf/ExtensionRegistryLite
      //   299: astore_2
      //   300: iconst_0
      //   301: istore 4
      //   303: iload 4
      //   305: ifne +221 -> 526
      //   308: aload_1
      //   309: invokevirtual 334	com/google/protobuf/CodedInputStream:readTag	()I
      //   312: istore 5
      //   314: iload 5
      //   316: lookupswitch	default:+255->571, 0:+258->574, 10:+60->376, 18:+119->435, 122:+166->482
      //   360: aload_0
      //   361: iload 5
      //   363: aload_1
      //   364: invokevirtual 338	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   367: ifne -64 -> 303
      //   370: iconst_1
      //   371: istore 4
      //   373: goto -70 -> 303
      //   376: aload_1
      //   377: invokevirtual 341	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   380: astore_3
      //   381: aload_0
      //   382: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   385: invokeinterface 198 1 0
      //   390: ifne +14 -> 404
      //   393: aload_0
      //   394: aload_0
      //   395: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   398: invokestatic 202	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   401: putfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   404: aload_0
      //   405: getfield 55	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:fileToGenerate_	Lcom/google/protobuf/Internal$ProtobufList;
      //   408: aload_3
      //   409: invokeinterface 171 2 0
      //   414: pop
      //   415: goto -112 -> 303
      //   418: astore_1
      //   419: new 343	java/lang/RuntimeException
      //   422: dup
      //   423: aload_1
      //   424: aload_0
      //   425: invokevirtual 347	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   428: invokespecial 350	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   431: athrow
      //   432: astore_1
      //   433: aload_1
      //   434: athrow
      //   435: aload_1
      //   436: invokevirtual 341	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   439: astore_3
      //   440: aload_0
      //   441: aload_0
      //   442: getfield 188	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
      //   445: iconst_1
      //   446: ior
      //   447: putfield 188	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:bitField0_	I
      //   450: aload_0
      //   451: aload_3
      //   452: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:parameter_	Ljava/lang/String;
      //   455: goto -152 -> 303
      //   458: astore_1
      //   459: new 343	java/lang/RuntimeException
      //   462: dup
      //   463: new 229	com/google/protobuf/InvalidProtocolBufferException
      //   466: dup
      //   467: aload_1
      //   468: invokevirtual 353	java/io/IOException:getMessage	()Ljava/lang/String;
      //   471: invokespecial 355	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   474: aload_0
      //   475: invokevirtual 347	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   478: invokespecial 350	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   481: athrow
      //   482: aload_0
      //   483: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   486: invokeinterface 198 1 0
      //   491: ifne +14 -> 505
      //   494: aload_0
      //   495: aload_0
      //   496: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   499: invokestatic 202	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   502: putfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   505: aload_0
      //   506: getfield 62	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:protoFile_	Lcom/google/protobuf/Internal$ProtobufList;
      //   509: aload_1
      //   510: invokestatic 357	com/google/protobuf/DescriptorProtos$FileDescriptorProto:parser	()Lcom/google/protobuf/Parser;
      //   513: aload_2
      //   514: invokevirtual 361	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   517: invokeinterface 171 2 0
      //   522: pop
      //   523: goto -220 -> 303
      //   526: getstatic 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   529: areturn
      //   530: getstatic 363	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:PARSER	Lcom/google/protobuf/Parser;
      //   533: ifnonnull +28 -> 561
      //   536: ldc 2
      //   538: monitorenter
      //   539: getstatic 363	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:PARSER	Lcom/google/protobuf/Parser;
      //   542: ifnonnull +16 -> 558
      //   545: new 365	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   548: dup
      //   549: getstatic 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   552: invokespecial 368	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   555: putstatic 363	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:PARSER	Lcom/google/protobuf/Parser;
      //   558: ldc 2
      //   560: monitorexit
      //   561: getstatic 363	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:PARSER	Lcom/google/protobuf/Parser;
      //   564: areturn
      //   565: astore_1
      //   566: ldc 2
      //   568: monitorexit
      //   569: aload_1
      //   570: athrow
      //   571: goto -211 -> 360
      //   574: iconst_1
      //   575: istore 4
      //   577: goto -274 -> 303
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	580	0	this	CodeGeneratorRequest
      //   0	580	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	580	2	paramObject1	Object
      //   0	580	3	paramObject2	Object
      //   78	498	4	i	int
      //   312	50	5	j	int
      //   104	48	6	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   308	314	418	com/google/protobuf/InvalidProtocolBufferException
      //   360	370	418	com/google/protobuf/InvalidProtocolBufferException
      //   376	404	418	com/google/protobuf/InvalidProtocolBufferException
      //   404	415	418	com/google/protobuf/InvalidProtocolBufferException
      //   435	455	418	com/google/protobuf/InvalidProtocolBufferException
      //   482	505	418	com/google/protobuf/InvalidProtocolBufferException
      //   505	523	418	com/google/protobuf/InvalidProtocolBufferException
      //   308	314	432	finally
      //   360	370	432	finally
      //   376	404	432	finally
      //   404	415	432	finally
      //   419	432	432	finally
      //   435	455	432	finally
      //   459	482	432	finally
      //   482	505	432	finally
      //   505	523	432	finally
      //   308	314	458	java/io/IOException
      //   360	370	458	java/io/IOException
      //   376	404	458	java/io/IOException
      //   404	415	458	java/io/IOException
      //   435	455	458	java/io/IOException
      //   482	505	458	java/io/IOException
      //   505	523	458	java/io/IOException
      //   539	558	565	finally
      //   558	561	565	finally
      //   566	569	565	finally
    }
    
    public String getFileToGenerate(int paramInt)
    {
      return (String)this.fileToGenerate_.get(paramInt);
    }
    
    public ByteString getFileToGenerateBytes(int paramInt)
    {
      return ByteString.copyFromUtf8((String)this.fileToGenerate_.get(paramInt));
    }
    
    public int getFileToGenerateCount()
    {
      return this.fileToGenerate_.size();
    }
    
    public List<String> getFileToGenerateList()
    {
      return this.fileToGenerate_;
    }
    
    public String getParameter()
    {
      return this.parameter_;
    }
    
    public ByteString getParameterBytes()
    {
      return ByteString.copyFromUtf8(this.parameter_);
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int paramInt)
    {
      return (DescriptorProtos.FileDescriptorProto)this.protoFile_.get(paramInt);
    }
    
    public int getProtoFileCount()
    {
      return this.protoFile_.size();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList()
    {
      return this.protoFile_;
    }
    
    public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int paramInt)
    {
      return (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(paramInt);
    }
    
    public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList()
    {
      return this.protoFile_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (i < this.fileToGenerate_.size())
      {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.fileToGenerate_.get(i));
        i += 1;
      }
      j = 0 + j + getFileToGenerateList().size() * 1;
      i = j;
      if ((this.bitField0_ & 0x1) == 1) {
        i = j + CodedOutputStream.computeStringSize(2, getParameter());
      }
      int k = 0;
      j = i;
      i = k;
      while (i < this.protoFile_.size())
      {
        j += CodedOutputStream.computeMessageSize(15, (MessageLite)this.protoFile_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasParameter()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = 0;
      while (i < this.fileToGenerate_.size())
      {
        paramCodedOutputStream.writeString(1, (String)this.fileToGenerate_.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(2, getParameter());
      }
      i = 0;
      while (i < this.protoFile_.size())
      {
        paramCodedOutputStream.writeMessage(15, (MessageLite)this.protoFile_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<PluginProtos.CodeGeneratorRequest, Builder>
      implements PluginProtos.CodeGeneratorRequestOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllFileToGenerate(Iterable<String> paramIterable)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllFileToGenerate(paramIterable);
        return this;
      }
      
      public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> paramIterable)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllProtoFile(paramIterable);
        return this;
      }
      
      public Builder addFileToGenerate(String paramString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerate(paramString);
        return this;
      }
      
      public Builder addFileToGenerateBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerateBytes(paramByteString);
        return this;
      }
      
      public Builder addProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(paramInt, paramFileDescriptorProto);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(paramBuilder);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(paramFileDescriptorProto);
        return this;
      }
      
      public Builder clearFileToGenerate()
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearFileToGenerate();
        return this;
      }
      
      public Builder clearParameter()
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearParameter();
        return this;
      }
      
      public Builder clearProtoFile()
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearProtoFile();
        return this;
      }
      
      public String getFileToGenerate(int paramInt)
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerate(paramInt);
      }
      
      public ByteString getFileToGenerateBytes(int paramInt)
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateBytes(paramInt);
      }
      
      public int getFileToGenerateCount()
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateCount();
      }
      
      public List<String> getFileToGenerateList()
      {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateList());
      }
      
      public String getParameter()
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameter();
      }
      
      public ByteString getParameterBytes()
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameterBytes();
      }
      
      public DescriptorProtos.FileDescriptorProto getProtoFile(int paramInt)
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFile(paramInt);
      }
      
      public int getProtoFileCount()
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileCount();
      }
      
      public List<DescriptorProtos.FileDescriptorProto> getProtoFileList()
      {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileList());
      }
      
      public boolean hasParameter()
      {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).hasParameter();
      }
      
      public Builder removeProtoFile(int paramInt)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).removeProtoFile(paramInt);
        return this;
      }
      
      public Builder setFileToGenerate(int paramInt, String paramString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setFileToGenerate(paramInt, paramString);
        return this;
      }
      
      public Builder setParameter(String paramString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameter(paramString);
        return this;
      }
      
      public Builder setParameterBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameterBytes(paramByteString);
        return this;
      }
      
      public Builder setProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setProtoFile(int paramInt, DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(paramInt, paramFileDescriptorProto);
        return this;
      }
    }
  }
  
  public static abstract interface CodeGeneratorRequestOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getFileToGenerate(int paramInt);
    
    public abstract ByteString getFileToGenerateBytes(int paramInt);
    
    public abstract int getFileToGenerateCount();
    
    public abstract List<String> getFileToGenerateList();
    
    public abstract String getParameter();
    
    public abstract ByteString getParameterBytes();
    
    public abstract DescriptorProtos.FileDescriptorProto getProtoFile(int paramInt);
    
    public abstract int getProtoFileCount();
    
    public abstract List<DescriptorProtos.FileDescriptorProto> getProtoFileList();
    
    public abstract boolean hasParameter();
  }
  
  public static final class CodeGeneratorResponse
    extends GeneratedMessageLite<CodeGeneratorResponse, Builder>
    implements PluginProtos.CodeGeneratorResponseOrBuilder
  {
    private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int FILE_FIELD_NUMBER = 15;
    private static volatile Parser<CodeGeneratorResponse> PARSER;
    private int bitField0_;
    private String error_ = "";
    private Internal.ProtobufList<File> file_ = emptyProtobufList();
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFile(Iterable<? extends File> paramIterable)
    {
      ensureFileIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.file_);
    }
    
    private void addFile(int paramInt, PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
    {
      ensureFileIsMutable();
      this.file_.add(paramInt, paramBuilder.build());
    }
    
    private void addFile(int paramInt, File paramFile)
    {
      if (paramFile == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      this.file_.add(paramInt, paramFile);
    }
    
    private void addFile(PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
    {
      ensureFileIsMutable();
      this.file_.add(paramBuilder.build());
    }
    
    private void addFile(File paramFile)
    {
      if (paramFile == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      this.file_.add(paramFile);
    }
    
    private void clearError()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.error_ = getDefaultInstance().getError();
    }
    
    private void clearFile()
    {
      this.file_ = emptyProtobufList();
    }
    
    private void ensureFileIsMutable()
    {
      if (!this.file_.isModifiable()) {
        this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
      }
    }
    
    public static CodeGeneratorResponse getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorResponse paramCodeGeneratorResponse)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCodeGeneratorResponse);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorResponse> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeFile(int paramInt)
    {
      ensureFileIsMutable();
      this.file_.remove(paramInt);
    }
    
    private void setError(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.error_ = paramString;
    }
    
    private void setErrorBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.error_ = paramByteString.toStringUtf8();
    }
    
    private void setFile(int paramInt, PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
    {
      ensureFileIsMutable();
      this.file_.set(paramInt, paramBuilder.build());
    }
    
    private void setFile(int paramInt, File paramFile)
    {
      if (paramFile == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      this.file_.set(paramInt, paramFile);
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 247	com/google/protobuf/compiler/PluginProtos$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 253	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+168->176, 7:+352->360, 8:+356->364
      //   56: new 255	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 256	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   67: dup
      //   68: invokespecial 42	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 44	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 257 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 260	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder:<init>	(Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 262	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 265	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:hasError	()Z
      //   114: aload_0
      //   115: getfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:error_	Ljava/lang/String;
      //   118: aload_3
      //   119: invokevirtual 265	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:hasError	()Z
      //   122: aload_3
      //   123: getfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:error_	Ljava/lang/String;
      //   126: invokeinterface 269 5 0
      //   131: putfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:error_	Ljava/lang/String;
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   140: aload_3
      //   141: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   144: invokeinterface 273 3 0
      //   149: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   152: aload_0
      //   153: astore_1
      //   154: aload_2
      //   155: getstatic 279	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   158: if_acmpne -86 -> 72
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 151	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
      //   166: aload_3
      //   167: getfield 151	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
      //   170: ior
      //   171: putfield 151	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
      //   174: aload_0
      //   175: areturn
      //   176: aload_2
      //   177: checkcast 281	com/google/protobuf/CodedInputStream
      //   180: astore_1
      //   181: aload_3
      //   182: checkcast 283	com/google/protobuf/ExtensionRegistryLite
      //   185: astore_2
      //   186: iconst_0
      //   187: istore 4
      //   189: iload 4
      //   191: ifne +169 -> 360
      //   194: aload_1
      //   195: invokevirtual 286	com/google/protobuf/CodedInputStream:readTag	()I
      //   198: istore 5
      //   200: iload 5
      //   202: lookupswitch	default:+203->405, 0:+206->408, 10:+50->252, 122:+90->292
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 290	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -54 -> 189
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -60 -> 189
      //   252: aload_1
      //   253: invokevirtual 293	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   256: astore_3
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 151	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
      //   262: iconst_1
      //   263: ior
      //   264: putfield 151	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:bitField0_	I
      //   267: aload_0
      //   268: aload_3
      //   269: putfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:error_	Ljava/lang/String;
      //   272: goto -83 -> 189
      //   275: astore_1
      //   276: new 295	java/lang/RuntimeException
      //   279: dup
      //   280: aload_1
      //   281: aload_0
      //   282: invokevirtual 299	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 302	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: astore_1
      //   290: aload_1
      //   291: athrow
      //   292: aload_0
      //   293: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   296: invokeinterface 162 1 0
      //   301: ifne +14 -> 315
      //   304: aload_0
      //   305: aload_0
      //   306: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   309: invokestatic 166	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   312: putfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   315: aload_0
      //   316: getfield 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:file_	Lcom/google/protobuf/Internal$ProtobufList;
      //   319: aload_1
      //   320: invokestatic 304	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:parser	()Lcom/google/protobuf/Parser;
      //   323: aload_2
      //   324: invokevirtual 308	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   327: invokeinterface 149 2 0
      //   332: pop
      //   333: goto -144 -> 189
      //   336: astore_1
      //   337: new 295	java/lang/RuntimeException
      //   340: dup
      //   341: new 193	com/google/protobuf/InvalidProtocolBufferException
      //   344: dup
      //   345: aload_1
      //   346: invokevirtual 311	java/io/IOException:getMessage	()Ljava/lang/String;
      //   349: invokespecial 313	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   352: aload_0
      //   353: invokevirtual 299	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   356: invokespecial 302	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   359: athrow
      //   360: getstatic 44	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   363: areturn
      //   364: getstatic 315	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:PARSER	Lcom/google/protobuf/Parser;
      //   367: ifnonnull +28 -> 395
      //   370: ldc 2
      //   372: monitorenter
      //   373: getstatic 315	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:PARSER	Lcom/google/protobuf/Parser;
      //   376: ifnonnull +16 -> 392
      //   379: new 317	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   382: dup
      //   383: getstatic 44	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   386: invokespecial 320	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   389: putstatic 315	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:PARSER	Lcom/google/protobuf/Parser;
      //   392: ldc 2
      //   394: monitorexit
      //   395: getstatic 315	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:PARSER	Lcom/google/protobuf/Parser;
      //   398: areturn
      //   399: astore_1
      //   400: ldc 2
      //   402: monitorexit
      //   403: aload_1
      //   404: athrow
      //   405: goto -169 -> 236
      //   408: iconst_1
      //   409: istore 4
      //   411: goto -222 -> 189
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	414	0	this	CodeGeneratorResponse
      //   0	414	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	414	2	paramObject1	Object
      //   0	414	3	paramObject2	Object
      //   187	223	4	i	int
      //   198	40	5	j	int
      // Exception table:
      //   from	to	target	type
      //   194	200	275	com/google/protobuf/InvalidProtocolBufferException
      //   236	246	275	com/google/protobuf/InvalidProtocolBufferException
      //   252	272	275	com/google/protobuf/InvalidProtocolBufferException
      //   292	315	275	com/google/protobuf/InvalidProtocolBufferException
      //   315	333	275	com/google/protobuf/InvalidProtocolBufferException
      //   194	200	289	finally
      //   236	246	289	finally
      //   252	272	289	finally
      //   276	289	289	finally
      //   292	315	289	finally
      //   315	333	289	finally
      //   337	360	289	finally
      //   194	200	336	java/io/IOException
      //   236	246	336	java/io/IOException
      //   252	272	336	java/io/IOException
      //   292	315	336	java/io/IOException
      //   315	333	336	java/io/IOException
      //   373	392	399	finally
      //   392	395	399	finally
      //   400	403	399	finally
    }
    
    public String getError()
    {
      return this.error_;
    }
    
    public ByteString getErrorBytes()
    {
      return ByteString.copyFromUtf8(this.error_);
    }
    
    public File getFile(int paramInt)
    {
      return (File)this.file_.get(paramInt);
    }
    
    public int getFileCount()
    {
      return this.file_.size();
    }
    
    public List<File> getFileList()
    {
      return this.file_;
    }
    
    public FileOrBuilder getFileOrBuilder(int paramInt)
    {
      return (FileOrBuilder)this.file_.get(paramInt);
    }
    
    public List<? extends FileOrBuilder> getFileOrBuilderList()
    {
      return this.file_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getError());
      }
      int k = 0;
      int j = i;
      i = k;
      while (i < this.file_.size())
      {
        j += CodedOutputStream.computeMessageSize(15, (MessageLite)this.file_.get(i));
        i += 1;
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasError()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getError());
      }
      int i = 0;
      while (i < this.file_.size())
      {
        paramCodedOutputStream.writeMessage(15, (MessageLite)this.file_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<PluginProtos.CodeGeneratorResponse, Builder>
      implements PluginProtos.CodeGeneratorResponseOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> paramIterable)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addAllFile(paramIterable);
        return this;
      }
      
      public Builder addFile(int paramInt, PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(paramInt, paramBuilder);
        return this;
      }
      
      public Builder addFile(int paramInt, PluginProtos.CodeGeneratorResponse.File paramFile)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(paramInt, paramFile);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(paramBuilder);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File paramFile)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(paramFile);
        return this;
      }
      
      public Builder clearError()
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearError();
        return this;
      }
      
      public Builder clearFile()
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearFile();
        return this;
      }
      
      public String getError()
      {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getError();
      }
      
      public ByteString getErrorBytes()
      {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getErrorBytes();
      }
      
      public PluginProtos.CodeGeneratorResponse.File getFile(int paramInt)
      {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFile(paramInt);
      }
      
      public int getFileCount()
      {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFileCount();
      }
      
      public List<PluginProtos.CodeGeneratorResponse.File> getFileList()
      {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorResponse)this.instance).getFileList());
      }
      
      public boolean hasError()
      {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).hasError();
      }
      
      public Builder removeFile(int paramInt)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).removeFile(paramInt);
        return this;
      }
      
      public Builder setError(String paramString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setError(paramString);
        return this;
      }
      
      public Builder setErrorBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setErrorBytes(paramByteString);
        return this;
      }
      
      public Builder setFile(int paramInt, PluginProtos.CodeGeneratorResponse.File.Builder paramBuilder)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(paramInt, paramBuilder);
        return this;
      }
      
      public Builder setFile(int paramInt, PluginProtos.CodeGeneratorResponse.File paramFile)
      {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(paramInt, paramFile);
        return this;
      }
    }
    
    public static final class File
      extends GeneratedMessageLite<File, Builder>
      implements PluginProtos.CodeGeneratorResponse.FileOrBuilder
    {
      public static final int CONTENT_FIELD_NUMBER = 15;
      private static final File DEFAULT_INSTANCE = new File();
      public static final int INSERTION_POINT_FIELD_NUMBER = 2;
      public static final int NAME_FIELD_NUMBER = 1;
      private static volatile Parser<File> PARSER;
      private int bitField0_;
      private String content_ = "";
      private String insertionPoint_ = "";
      private String name_ = "";
      
      static
      {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearContent()
      {
        this.bitField0_ &= 0xFFFFFFFB;
        this.content_ = getDefaultInstance().getContent();
      }
      
      private void clearInsertionPoint()
      {
        this.bitField0_ &= 0xFFFFFFFD;
        this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
      }
      
      private void clearName()
      {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = getDefaultInstance().getName();
      }
      
      public static File getDefaultInstance()
      {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder()
      {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(File paramFile)
      {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFile);
      }
      
      public static File parseDelimitedFrom(InputStream paramInputStream)
        throws IOException
      {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
      }
      
      public static File parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
      }
      
      public static File parseFrom(ByteString paramByteString)
        throws InvalidProtocolBufferException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
      }
      
      public static File parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
      }
      
      public static File parseFrom(CodedInputStream paramCodedInputStream)
        throws IOException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
      }
      
      public static File parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
      }
      
      public static File parseFrom(InputStream paramInputStream)
        throws IOException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
      }
      
      public static File parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
      }
      
      public static File parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
      }
      
      public static File parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
      }
      
      public static Parser<File> parser()
      {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setContent(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.content_ = paramString;
      }
      
      private void setContentBytes(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.content_ = paramByteString.toStringUtf8();
      }
      
      private void setInsertionPoint(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = paramString;
      }
      
      private void setInsertionPointBytes(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = paramByteString.toStringUtf8();
      }
      
      private void setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramString;
      }
      
      private void setNameBytes(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramByteString.toStringUtf8();
      }
      
      /* Error */
      protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
      {
        // Byte code:
        //   0: getstatic 188	com/google/protobuf/compiler/PluginProtos$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
        //   3: aload_1
        //   4: invokevirtual 194	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
        //   7: iaload
        //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+193->201, 7:+386->394, 8:+390->398
        //   56: new 196	java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial 197	java/lang/UnsupportedOperationException:<init>	()V
        //   63: athrow
        //   64: new 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   67: dup
        //   68: invokespecial 38	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:<init>	()V
        //   71: astore_1
        //   72: aload_1
        //   73: areturn
        //   74: getstatic 40	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   77: areturn
        //   78: aconst_null
        //   79: areturn
        //   80: new 15	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder
        //   83: dup
        //   84: aconst_null
        //   85: invokespecial 200	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder:<init>	(Lcom/google/protobuf/compiler/PluginProtos$1;)V
        //   88: areturn
        //   89: aload_2
        //   90: checkcast 202	com/google/protobuf/GeneratedMessageLite$Visitor
        //   93: astore_2
        //   94: aload_3
        //   95: checkcast 2	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   98: astore_3
        //   99: aload_0
        //   100: aload_2
        //   101: aload_0
        //   102: invokevirtual 206	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasName	()Z
        //   105: aload_0
        //   106: getfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:name_	Ljava/lang/String;
        //   109: aload_3
        //   110: invokevirtual 206	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasName	()Z
        //   113: aload_3
        //   114: getfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:name_	Ljava/lang/String;
        //   117: invokeinterface 210 5 0
        //   122: putfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:name_	Ljava/lang/String;
        //   125: aload_0
        //   126: aload_2
        //   127: aload_0
        //   128: invokevirtual 213	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasInsertionPoint	()Z
        //   131: aload_0
        //   132: getfield 51	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:insertionPoint_	Ljava/lang/String;
        //   135: aload_3
        //   136: invokevirtual 213	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasInsertionPoint	()Z
        //   139: aload_3
        //   140: getfield 51	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:insertionPoint_	Ljava/lang/String;
        //   143: invokeinterface 210 5 0
        //   148: putfield 51	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:insertionPoint_	Ljava/lang/String;
        //   151: aload_0
        //   152: aload_2
        //   153: aload_0
        //   154: invokevirtual 216	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasContent	()Z
        //   157: aload_0
        //   158: getfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:content_	Ljava/lang/String;
        //   161: aload_3
        //   162: invokevirtual 216	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:hasContent	()Z
        //   165: aload_3
        //   166: getfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:content_	Ljava/lang/String;
        //   169: invokeinterface 210 5 0
        //   174: putfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:content_	Ljava/lang/String;
        //   177: aload_0
        //   178: astore_1
        //   179: aload_2
        //   180: getstatic 222	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   183: if_acmpne -111 -> 72
        //   186: aload_0
        //   187: aload_0
        //   188: getfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   191: aload_3
        //   192: getfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   195: ior
        //   196: putfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   199: aload_0
        //   200: areturn
        //   201: aload_2
        //   202: checkcast 224	com/google/protobuf/CodedInputStream
        //   205: astore_1
        //   206: aload_3
        //   207: checkcast 226	com/google/protobuf/ExtensionRegistryLite
        //   210: astore_2
        //   211: iconst_0
        //   212: istore 4
        //   214: iload 4
        //   216: ifne +178 -> 394
        //   219: aload_1
        //   220: invokevirtual 229	com/google/protobuf/CodedInputStream:readTag	()I
        //   223: istore 5
        //   225: iload 5
        //   227: lookupswitch	default:+212->439, 0:+215->442, 10:+57->284, 18:+97->324, 122:+144->371
        //   268: aload_0
        //   269: iload 5
        //   271: aload_1
        //   272: invokevirtual 233	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
        //   275: ifne -61 -> 214
        //   278: iconst_1
        //   279: istore 4
        //   281: goto -67 -> 214
        //   284: aload_1
        //   285: invokevirtual 236	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
        //   288: astore_2
        //   289: aload_0
        //   290: aload_0
        //   291: getfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   294: iconst_1
        //   295: ior
        //   296: putfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   299: aload_0
        //   300: aload_2
        //   301: putfield 49	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:name_	Ljava/lang/String;
        //   304: goto -90 -> 214
        //   307: astore_1
        //   308: new 238	java/lang/RuntimeException
        //   311: dup
        //   312: aload_1
        //   313: aload_0
        //   314: invokevirtual 242	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   317: invokespecial 245	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   320: athrow
        //   321: astore_1
        //   322: aload_1
        //   323: athrow
        //   324: aload_1
        //   325: invokevirtual 236	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
        //   328: astore_2
        //   329: aload_0
        //   330: aload_0
        //   331: getfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   334: iconst_2
        //   335: ior
        //   336: putfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   339: aload_0
        //   340: aload_2
        //   341: putfield 51	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:insertionPoint_	Ljava/lang/String;
        //   344: goto -130 -> 214
        //   347: astore_1
        //   348: new 238	java/lang/RuntimeException
        //   351: dup
        //   352: new 138	com/google/protobuf/InvalidProtocolBufferException
        //   355: dup
        //   356: aload_1
        //   357: invokevirtual 248	java/io/IOException:getMessage	()Ljava/lang/String;
        //   360: invokespecial 250	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
        //   363: aload_0
        //   364: invokevirtual 242	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   367: invokespecial 245	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   370: athrow
        //   371: aload_1
        //   372: invokevirtual 236	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
        //   375: astore_2
        //   376: aload_0
        //   377: aload_0
        //   378: getfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   381: iconst_4
        //   382: ior
        //   383: putfield 98	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:bitField0_	I
        //   386: aload_0
        //   387: aload_2
        //   388: putfield 53	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:content_	Ljava/lang/String;
        //   391: goto -177 -> 214
        //   394: getstatic 40	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   397: areturn
        //   398: getstatic 252	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
        //   401: ifnonnull +28 -> 429
        //   404: ldc 2
        //   406: monitorenter
        //   407: getstatic 252	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
        //   410: ifnonnull +16 -> 426
        //   413: new 254	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   416: dup
        //   417: getstatic 40	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:DEFAULT_INSTANCE	Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   420: invokespecial 257	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
        //   423: putstatic 252	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
        //   426: ldc 2
        //   428: monitorexit
        //   429: getstatic 252	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
        //   432: areturn
        //   433: astore_1
        //   434: ldc 2
        //   436: monitorexit
        //   437: aload_1
        //   438: athrow
        //   439: goto -171 -> 268
        //   442: iconst_1
        //   443: istore 4
        //   445: goto -231 -> 214
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	448	0	this	File
        //   0	448	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
        //   0	448	2	paramObject1	Object
        //   0	448	3	paramObject2	Object
        //   212	232	4	i	int
        //   223	47	5	j	int
        // Exception table:
        //   from	to	target	type
        //   219	225	307	com/google/protobuf/InvalidProtocolBufferException
        //   268	278	307	com/google/protobuf/InvalidProtocolBufferException
        //   284	304	307	com/google/protobuf/InvalidProtocolBufferException
        //   324	344	307	com/google/protobuf/InvalidProtocolBufferException
        //   371	391	307	com/google/protobuf/InvalidProtocolBufferException
        //   219	225	321	finally
        //   268	278	321	finally
        //   284	304	321	finally
        //   308	321	321	finally
        //   324	344	321	finally
        //   348	371	321	finally
        //   371	391	321	finally
        //   219	225	347	java/io/IOException
        //   268	278	347	java/io/IOException
        //   284	304	347	java/io/IOException
        //   324	344	347	java/io/IOException
        //   371	391	347	java/io/IOException
        //   407	426	433	finally
        //   426	429	433	finally
        //   434	437	433	finally
      }
      
      public String getContent()
      {
        return this.content_;
      }
      
      public ByteString getContentBytes()
      {
        return ByteString.copyFromUtf8(this.content_);
      }
      
      public String getInsertionPoint()
      {
        return this.insertionPoint_;
      }
      
      public ByteString getInsertionPointBytes()
      {
        return ByteString.copyFromUtf8(this.insertionPoint_);
      }
      
      public String getName()
      {
        return this.name_;
      }
      
      public ByteString getNameBytes()
      {
        return ByteString.copyFromUtf8(this.name_);
      }
      
      public int getSerializedSize()
      {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
          return i;
        }
        int j = 0;
        if ((this.bitField0_ & 0x1) == 1) {
          j = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        i = j;
        if ((this.bitField0_ & 0x2) == 2) {
          i = j + CodedOutputStream.computeStringSize(2, getInsertionPoint());
        }
        j = i;
        if ((this.bitField0_ & 0x4) == 4) {
          j = i + CodedOutputStream.computeStringSize(15, getContent());
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public boolean hasContent()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public boolean hasInsertionPoint()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public boolean hasName()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public void writeTo(CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        if ((this.bitField0_ & 0x1) == 1) {
          paramCodedOutputStream.writeString(1, getName());
        }
        if ((this.bitField0_ & 0x2) == 2) {
          paramCodedOutputStream.writeString(2, getInsertionPoint());
        }
        if ((this.bitField0_ & 0x4) == 4) {
          paramCodedOutputStream.writeString(15, getContent());
        }
        this.unknownFields.writeTo(paramCodedOutputStream);
      }
      
      public static final class Builder
        extends GeneratedMessageLite.Builder<PluginProtos.CodeGeneratorResponse.File, Builder>
        implements PluginProtos.CodeGeneratorResponse.FileOrBuilder
      {
        private Builder()
        {
          super();
        }
        
        public Builder clearContent()
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
          return this;
        }
        
        public Builder clearInsertionPoint()
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
          return this;
        }
        
        public Builder clearName()
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
          return this;
        }
        
        public String getContent()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
        }
        
        public ByteString getContentBytes()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
        }
        
        public String getInsertionPoint()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
        }
        
        public ByteString getInsertionPointBytes()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
        }
        
        public String getName()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
        }
        
        public ByteString getNameBytes()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
        }
        
        public boolean hasContent()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
        }
        
        public boolean hasInsertionPoint()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
        }
        
        public boolean hasName()
        {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
        }
        
        public Builder setContent(String paramString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(paramString);
          return this;
        }
        
        public Builder setContentBytes(ByteString paramByteString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(paramByteString);
          return this;
        }
        
        public Builder setInsertionPoint(String paramString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(paramString);
          return this;
        }
        
        public Builder setInsertionPointBytes(ByteString paramByteString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(paramByteString);
          return this;
        }
        
        public Builder setName(String paramString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(paramString);
          return this;
        }
        
        public Builder setNameBytes(ByteString paramByteString)
        {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(paramByteString);
          return this;
        }
      }
    }
    
    public static abstract interface FileOrBuilder
      extends MessageLiteOrBuilder
    {
      public abstract String getContent();
      
      public abstract ByteString getContentBytes();
      
      public abstract String getInsertionPoint();
      
      public abstract ByteString getInsertionPointBytes();
      
      public abstract String getName();
      
      public abstract ByteString getNameBytes();
      
      public abstract boolean hasContent();
      
      public abstract boolean hasInsertionPoint();
      
      public abstract boolean hasName();
    }
  }
  
  public static abstract interface CodeGeneratorResponseOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getError();
    
    public abstract ByteString getErrorBytes();
    
    public abstract PluginProtos.CodeGeneratorResponse.File getFile(int paramInt);
    
    public abstract int getFileCount();
    
    public abstract List<PluginProtos.CodeGeneratorResponse.File> getFileList();
    
    public abstract boolean hasError();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/compiler/PluginProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */