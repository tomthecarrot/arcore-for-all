package io.grpc.protobuf.lite;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.KnownLength;
import io.grpc.Metadata.BinaryMarshaller;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.MethodDescriptor.PrototypeMarshaller;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class ProtoLiteUtils
{
  private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal()
  {
    protected Reference<byte[]> initialValue()
    {
      return new WeakReference(new byte['က']);
    }
  };
  private static volatile ExtensionRegistryLite globalRegistry = ;
  
  public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T paramT)
  {
    new MethodDescriptor.PrototypeMarshaller()
    {
      private T parseFrom(CodedInputStream paramAnonymousCodedInputStream)
        throws InvalidProtocolBufferException
      {
        MessageLite localMessageLite = (MessageLite)this.val$parser.parseFrom(paramAnonymousCodedInputStream, ProtoLiteUtils.globalRegistry);
        try
        {
          paramAnonymousCodedInputStream.checkLastTagWas(0);
          return localMessageLite;
        }
        catch (InvalidProtocolBufferException paramAnonymousCodedInputStream)
        {
          paramAnonymousCodedInputStream.setUnfinishedMessage(localMessageLite);
          throw paramAnonymousCodedInputStream;
        }
      }
      
      public Class<T> getMessageClass()
      {
        return ProtoLiteUtils.this.getClass();
      }
      
      public T getMessagePrototype()
      {
        return ProtoLiteUtils.this;
      }
      
      public T parse(InputStream paramAnonymousInputStream)
      {
        if (((paramAnonymousInputStream instanceof ProtoInputStream)) && (((ProtoInputStream)paramAnonymousInputStream).parser() == this.val$parser)) {
          try
          {
            MessageLite localMessageLite = ((ProtoInputStream)paramAnonymousInputStream).message();
            return localMessageLite;
          }
          catch (IllegalStateException localIllegalStateException) {}
        }
        Object localObject2 = null;
        Object localObject1 = localObject2;
        for (;;)
        {
          int j;
          int i;
          try
          {
            if (!(paramAnonymousInputStream instanceof KnownLength)) {
              break label206;
            }
            j = paramAnonymousInputStream.available();
            if ((j <= 0) || (j > 4194304)) {
              break label238;
            }
            localObject2 = (byte[])((Reference)ProtoLiteUtils.bufs.get()).get();
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (localObject2.length >= j) {}
            }
            else
            {
              localObject1 = new byte[j];
              ProtoLiteUtils.bufs.set(new WeakReference(localObject1));
            }
          }
          catch (IOException paramAnonymousInputStream)
          {
            int k;
            throw new RuntimeException(paramAnonymousInputStream);
          }
          k = paramAnonymousInputStream.read((byte[])localObject1, i, j - i);
          if (k != -1)
          {
            i += k;
          }
          else
          {
            if (j != i) {
              throw new RuntimeException("size inaccurate: " + j + " != " + i);
            }
            localObject1 = CodedInputStream.newInstance((byte[])localObject1, 0, j);
            label206:
            label238:
            do
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = CodedInputStream.newInstance(paramAnonymousInputStream);
              }
              ((CodedInputStream)localObject2).setSizeLimit(Integer.MAX_VALUE);
              try
              {
                paramAnonymousInputStream = parseFrom((CodedInputStream)localObject2);
                return paramAnonymousInputStream;
              }
              catch (InvalidProtocolBufferException paramAnonymousInputStream)
              {
                throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(paramAnonymousInputStream).asRuntimeException();
              }
              localObject1 = localObject2;
            } while (j != 0);
            paramAnonymousInputStream = ProtoLiteUtils.this;
            return paramAnonymousInputStream;
            i = 0;
          }
        }
      }
      
      public InputStream stream(T paramAnonymousT)
      {
        return new ProtoInputStream(paramAnonymousT, this.val$parser);
      }
    };
  }
  
  public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(T paramT)
  {
    new Metadata.BinaryMarshaller()
    {
      public T parseBytes(byte[] paramAnonymousArrayOfByte)
      {
        try
        {
          paramAnonymousArrayOfByte = (MessageLite)ProtoLiteUtils.this.getParserForType().parseFrom(paramAnonymousArrayOfByte, ProtoLiteUtils.globalRegistry);
          return paramAnonymousArrayOfByte;
        }
        catch (InvalidProtocolBufferException paramAnonymousArrayOfByte)
        {
          throw new IllegalArgumentException(paramAnonymousArrayOfByte);
        }
      }
      
      public byte[] toBytes(T paramAnonymousT)
      {
        return paramAnonymousT.toByteArray();
      }
    };
  }
  
  public static void setExtensionRegistry(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    globalRegistry = (ExtensionRegistryLite)Preconditions.checkNotNull(paramExtensionRegistryLite, "newRegistry");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/protobuf/lite/ProtoLiteUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */