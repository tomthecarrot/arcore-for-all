package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http2
  implements Variant
{
  private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
  
  private static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException ioException(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
    throws IOException
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  private static int readMedium(BufferedSource paramBufferedSource)
    throws IOException
  {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private static void writeMedium(BufferedSink paramBufferedSink, int paramInt)
    throws IOException
  {
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class ContinuationSource
    implements Source
  {
    byte flags;
    int left;
    int length;
    short padding;
    private final BufferedSource source;
    int streamId;
    
    public ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }
    
    private void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = Http2.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(this.source.readByte() & 0xFF);
      this.flags = ((byte)(this.source.readByte() & 0xFF));
      if (Http2.logger.isLoggable(Level.FINE)) {
        Http2.logger.fine(Http2.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags));
      }
      this.streamId = (this.source.readInt() & 0x7FFFFFFF);
      if (b != 9) {
        throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
      }
      if (this.streamId != i) {
        throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
    }
    
    public void close()
      throws IOException
    {}
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      while (this.left == 0)
      {
        this.source.skip(this.padding);
        this.padding = 0;
        if ((this.flags & 0x4) != 0) {
          return -1L;
        }
        readContinuationHeader();
      }
      paramLong = this.source.read(paramBuffer, Math.min(paramLong, this.left));
      if (paramLong == -1L) {
        return -1L;
      }
      this.left = ((int)(this.left - paramLong));
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
  
  static final class FrameLogger
  {
    private static final String[] BINARY;
    private static final String[] FLAGS;
    private static final String[] TYPES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    
    static
    {
      FLAGS = new String[64];
      BINARY = new String['Ā'];
      int i = 0;
      while (i < BINARY.length)
      {
        BINARY[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i += 1;
      }
      FLAGS[0] = "";
      FLAGS[1] = "END_STREAM";
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 1;
      FLAGS[8] = "PADDED";
      int j = arrayOfInt1.length;
      i = 0;
      while (i < j)
      {
        k = arrayOfInt1[i];
        FLAGS[(k | 0x8)] = (FLAGS[k] + "|PADDED");
        i += 1;
      }
      FLAGS[4] = "END_HEADERS";
      FLAGS[32] = "PRIORITY";
      FLAGS[36] = "END_HEADERS|PRIORITY";
      int[] arrayOfInt2 = new int[3];
      int[] tmp240_238 = arrayOfInt2;
      tmp240_238[0] = 4;
      int[] tmp244_240 = tmp240_238;
      tmp244_240[1] = 32;
      int[] tmp249_244 = tmp244_240;
      tmp249_244[2] = 36;
      tmp249_244;
      int k = arrayOfInt2.length;
      i = 0;
      while (i < k)
      {
        int m = arrayOfInt2[i];
        int n = arrayOfInt1.length;
        j = 0;
        while (j < n)
        {
          int i1 = arrayOfInt1[j];
          FLAGS[(i1 | m)] = (FLAGS[i1] + '|' + FLAGS[m]);
          FLAGS[(i1 | m | 0x8)] = (FLAGS[i1] + '|' + FLAGS[m] + "|PADDED");
          j += 1;
        }
        i += 1;
      }
      i = 0;
      while (i < FLAGS.length)
      {
        if (FLAGS[i] == null) {
          FLAGS[i] = BINARY[i];
        }
        i += 1;
      }
    }
    
    static String formatFlags(byte paramByte1, byte paramByte2)
    {
      if (paramByte2 == 0) {
        return "";
      }
      switch (paramByte1)
      {
      case 5: 
      default: 
        if (paramByte2 >= FLAGS.length) {
          break;
        }
      }
      for (String str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
      {
        return str.replace("HEADERS", "PUSH_PROMISE");
        if (paramByte2 == 1) {
          return "ACK";
        }
        return BINARY[paramByte2];
        return BINARY[paramByte2];
      }
      if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
        return str.replace("PRIORITY", "COMPRESSED");
      }
      return str;
    }
    
    static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str1;
      String str3;
      if (paramByte1 < TYPES.length)
      {
        str1 = TYPES[paramByte1];
        str3 = formatFlags(paramByte1, paramByte2);
        if (!paramBoolean) {
          break label91;
        }
      }
      label91:
      for (String str2 = "<<";; str2 = ">>")
      {
        return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
        str1 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
        break;
      }
    }
  }
  
  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final Http2.ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;
    
    Reader(BufferedSource paramBufferedSource, int paramInt, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.client = paramBoolean;
      this.continuation = new Http2.ContinuationSource(this.source);
      this.hpackReader = new Hpack.Reader(paramInt, this.continuation);
    }
    
    private void readData(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      int i = 1;
      short s = 0;
      boolean bool;
      if ((paramByte & 0x1) != 0)
      {
        bool = true;
        if ((paramByte & 0x20) == 0) {
          break label43;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label49;
        }
        throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        bool = false;
        break;
        label43:
        i = 0;
      }
      label49:
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.source.readByte() & 0xFF);
      }
      paramInt1 = Http2.lengthWithoutPadding(paramInt1, paramByte, s);
      paramHandler.data(bool, paramInt2, this.source, paramInt1);
      this.source.skip(s);
    }
    
    private void readGoAway(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt1 < 8) {
        throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 != 0) {
        throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
      }
      paramByte = this.source.readInt();
      paramInt2 = this.source.readInt();
      paramInt1 -= 8;
      ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt2);
      if (localErrorCode == null) {
        throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      ByteString localByteString = ByteString.EMPTY;
      if (paramInt1 > 0) {
        localByteString = this.source.readByteString(paramInt1);
      }
      paramHandler.goAway(paramByte, localErrorCode, localByteString);
    }
    
    private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
      throws IOException
    {
      Http2.ContinuationSource localContinuationSource = this.continuation;
      this.continuation.left = paramInt1;
      localContinuationSource.length = paramInt1;
      this.continuation.padding = paramShort;
      this.continuation.flags = paramByte;
      this.continuation.streamId = paramInt2;
      this.hpackReader.readHeaders();
      return this.hpackReader.getAndResetHeaderList();
    }
    
    private void readHeaders(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt2 == 0) {
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
      }
      boolean bool;
      if ((paramByte & 0x1) != 0)
      {
        bool = true;
        if ((paramByte & 0x8) == 0) {
          break label108;
        }
      }
      label108:
      for (short s = (short)(this.source.readByte() & 0xFF);; s = 0)
      {
        int i = paramInt1;
        if ((paramByte & 0x20) != 0)
        {
          readPriority(paramHandler, paramInt2);
          i = paramInt1 - 5;
        }
        paramHandler.headers(false, bool, paramInt2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, paramByte, s), s, paramByte, paramInt2), HeadersMode.HTTP_20_HEADERS);
        return;
        bool = false;
        break;
      }
    }
    
    private void readPing(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      boolean bool = true;
      if (paramInt1 != 8) {
        throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 != 0) {
        throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
      }
      paramInt1 = this.source.readInt();
      paramInt2 = this.source.readInt();
      if ((paramByte & 0x1) != 0) {}
      for (;;)
      {
        paramHandler.ping(bool, paramInt1, paramInt2);
        return;
        bool = false;
      }
    }
    
    private void readPriority(FrameReader.Handler paramHandler, int paramInt)
      throws IOException
    {
      int i = this.source.readInt();
      if ((0x80000000 & i) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramHandler.priority(paramInt, i & 0x7FFFFFFF, (this.source.readByte() & 0xFF) + 1, bool);
        return;
      }
    }
    
    private void readPriority(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt1 != 5) {
        throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 == 0) {
        throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
      }
      readPriority(paramHandler, paramInt2);
    }
    
    private void readPushPromise(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      short s = 0;
      if (paramInt2 == 0) {
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      }
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.source.readByte() & 0xFF);
      }
      paramHandler.pushPromise(paramInt2, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock(Http2.lengthWithoutPadding(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
    }
    
    private void readRstStream(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt1 != 4) {
        throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 == 0) {
        throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
      }
      paramInt1 = this.source.readInt();
      ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt1);
      if (localErrorCode == null) {
        throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      paramHandler.rstStream(paramInt2, localErrorCode);
    }
    
    private void readSettings(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 0) {
        throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
      }
      if ((paramByte & 0x1) != 0)
      {
        if (paramInt1 != 0) {
          throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        }
        paramHandler.ackSettings();
      }
      Settings localSettings;
      label255:
      do
      {
        return;
        if (paramInt1 % 6 != 0) {
          throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
        }
        localSettings = new Settings();
        paramByte = 0;
        if (paramByte < paramInt1)
        {
          int i = this.source.readShort();
          int j = this.source.readInt();
          paramInt2 = i;
          switch (i)
          {
          default: 
            throw Http2.ioException("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Short.valueOf(i) });
          case 2: 
            paramInt2 = i;
            if (j != 0)
            {
              paramInt2 = i;
              if (j != 1) {
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          case 3: 
            paramInt2 = 4;
          }
          do
          {
            do
            {
              localSettings.set(paramInt2, 0, j);
              paramByte += 6;
              break;
              paramInt2 = 7;
            } while (j >= 0);
            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            if (j < 16384) {
              break label255;
            }
            paramInt2 = i;
          } while (j <= 16777215);
          throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(j) });
        }
        paramHandler.settings(false, localSettings);
      } while (localSettings.getHeaderTableSize() < 0);
      this.hpackReader.headerTableSizeSetting(localSettings.getHeaderTableSize());
    }
    
    private void readWindowUpdate(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
      throws IOException
    {
      if (paramInt1 != 4) {
        throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      long l = this.source.readInt() & 0x7FFFFFFF;
      if (l == 0L) {
        throw Http2.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      paramHandler.windowUpdate(paramInt2, l);
    }
    
    public void close()
      throws IOException
    {
      this.source.close();
    }
    
    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      int i;
      try
      {
        this.source.require(9L);
        i = Http2.readMedium(this.source);
        if ((i < 0) || (i > 16384)) {
          throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      catch (IOException paramHandler)
      {
        return false;
      }
      byte b1 = (byte)(this.source.readByte() & 0xFF);
      byte b2 = (byte)(this.source.readByte() & 0xFF);
      int j = this.source.readInt() & 0x7FFFFFFF;
      if (Http2.logger.isLoggable(Level.FINE)) {
        Http2.logger.fine(Http2.FrameLogger.formatHeader(true, j, i, b1, b2));
      }
      switch (b1)
      {
      default: 
        this.source.skip(i);
        return true;
      case 0: 
        readData(paramHandler, i, b2, j);
        return true;
      case 1: 
        readHeaders(paramHandler, i, b2, j);
        return true;
      case 2: 
        readPriority(paramHandler, i, b2, j);
        return true;
      case 3: 
        readRstStream(paramHandler, i, b2, j);
        return true;
      case 4: 
        readSettings(paramHandler, i, b2, j);
        return true;
      case 5: 
        readPushPromise(paramHandler, i, b2, j);
        return true;
      case 6: 
        readPing(paramHandler, i, b2, j);
        return true;
      case 7: 
        readGoAway(paramHandler, i, b2, j);
        return true;
      }
      readWindowUpdate(paramHandler, i, b2, j);
      return true;
    }
    
    public void readConnectionPreface()
      throws IOException
    {
      if (this.client) {}
      ByteString localByteString;
      do
      {
        return;
        localByteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (Http2.logger.isLoggable(Level.FINE)) {
          Http2.logger.fine(String.format("<< CONNECTION %s", new Object[] { localByteString.hex() }));
        }
      } while (Http2.CONNECTION_PREFACE.equals(localByteString));
      throw Http2.ioException("Expected a connection header but was %s", new Object[] { localByteString.utf8() });
    }
  }
  
  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;
    
    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      this.hpackBuffer = new Buffer();
      this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
      this.maxFrameSize = 16384;
    }
    
    private void writeContinuationFrames(int paramInt, long paramLong)
      throws IOException
    {
      if (paramLong > 0L)
      {
        int i = (int)Math.min(this.maxFrameSize, paramLong);
        paramLong -= i;
        if (paramLong == 0L) {}
        for (byte b = 4;; b = 0)
        {
          frameHeader(paramInt, i, (byte)9, b);
          this.sink.write(this.hpackBuffer, i);
          break;
        }
      }
    }
    
    public void ackSettings(Settings paramSettings)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.maxFrameSize = paramSettings.getMaxFrameSize(this.maxFrameSize);
      frameHeader(0, 0, (byte)4, (byte)1);
      this.sink.flush();
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.closed = true;
        this.sink.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void connectionPreface()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool = this.client;
      if (!bool) {}
      for (;;)
      {
        return;
        if (Http2.logger.isLoggable(Level.FINE)) {
          Http2.logger.fine(String.format(">> CONNECTION %s", new Object[] { Http2.CONNECTION_PREFACE.hex() }));
        }
        this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
        this.sink.flush();
      }
    }
    
    public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b = 0;
      if (paramBoolean) {
        b = (byte)1;
      }
      dataFrame(paramInt1, b, paramBuffer, paramInt2);
    }
    
    void dataFrame(int paramInt1, byte paramByte, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      frameHeader(paramInt1, paramInt2, (byte)0, paramByte);
      if (paramInt2 > 0) {
        this.sink.write(paramBuffer, paramInt2);
      }
    }
    
    public void flush()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.sink.flush();
    }
    
    void frameHeader(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
      throws IOException
    {
      if (Http2.logger.isLoggable(Level.FINE)) {
        Http2.logger.fine(Http2.FrameLogger.formatHeader(false, paramInt1, paramInt2, paramByte1, paramByte2));
      }
      if (paramInt2 > this.maxFrameSize) {
        throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.maxFrameSize), Integer.valueOf(paramInt2) });
      }
      if ((0x80000000 & paramInt1) != 0) {
        throw Http2.illegalArgument("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      Http2.writeMedium(this.sink, paramInt2);
      this.sink.writeByte(paramByte1 & 0xFF);
      this.sink.writeByte(paramByte2 & 0xFF);
      this.sink.writeInt(0x7FFFFFFF & paramInt1);
    }
    
    public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.httpCode == -1) {
        throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
      }
      frameHeader(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
      this.sink.writeInt(paramInt);
      this.sink.writeInt(paramErrorCode.httpCode);
      if (paramArrayOfByte.length > 0) {
        this.sink.write(paramArrayOfByte);
      }
      this.sink.flush();
    }
    
    public void headers(int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      headers(false, paramInt, paramList);
    }
    
    void headers(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(this.maxFrameSize, l);
      if (l == i) {}
      for (byte b1 = 4;; b1 = 0)
      {
        byte b2 = b1;
        if (paramBoolean) {
          b2 = (byte)(b1 | 0x1);
        }
        frameHeader(paramInt, i, (byte)1, b2);
        this.sink.write(this.hpackBuffer, i);
        if (l > i) {
          writeContinuationFrames(paramInt, l - i);
        }
        return;
      }
    }
    
    public int maxDataLength()
    {
      return this.maxFrameSize;
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramBoolean) {}
      for (byte b = 1;; b = 0)
      {
        frameHeader(0, 8, (byte)6, b);
        this.sink.writeInt(paramInt1);
        this.sink.writeInt(paramInt2);
        this.sink.flush();
        return;
      }
    }
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.hpackWriter.writeHeaders(paramList);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(this.maxFrameSize - 4, l);
      if (l == i) {}
      for (byte b = 4;; b = 0)
      {
        frameHeader(paramInt1, i + 4, (byte)5, b);
        this.sink.writeInt(0x7FFFFFFF & paramInt2);
        this.sink.write(this.hpackBuffer, i);
        if (l > i) {
          writeContinuationFrames(paramInt1, l - i);
        }
        return;
      }
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.httpCode == -1) {
        throw new IllegalArgumentException();
      }
      frameHeader(paramInt, 4, (byte)3, (byte)0);
      this.sink.writeInt(paramErrorCode.httpCode);
      this.sink.flush();
    }
    
    public void settings(Settings paramSettings)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      frameHeader(0, paramSettings.size() * 6, (byte)4, (byte)0);
      int i = 0;
      if (i < 10) {
        if (paramSettings.isSet(i)) {
          break label105;
        }
      }
      for (;;)
      {
        int j;
        this.sink.writeShort(j);
        this.sink.writeInt(paramSettings.get(i));
        break label98;
        this.sink.flush();
        return;
        label98:
        i += 1;
        break;
        label105:
        int k = i;
        if (k == 4)
        {
          j = 3;
        }
        else
        {
          j = k;
          if (k == 7) {
            j = 4;
          }
        }
      }
    }
    
    public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      headers(paramBoolean, paramInt, paramList);
    }
    
    public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      if (paramBoolean2) {
        try
        {
          throw new UnsupportedOperationException();
        }
        finally {}
      }
      if (this.closed) {
        throw new IOException("closed");
      }
      headers(paramBoolean1, paramInt1, paramList);
    }
    
    public void windowUpdate(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      frameHeader(paramInt, 4, (byte)8, (byte)0);
      this.sink.writeInt((int)paramLong);
      this.sink.flush();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/squareup/okhttp/internal/framed/Http2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */