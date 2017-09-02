package com.google.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException
  extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;
  private MessageLite unfinishedMessage = null;
  
  public InvalidProtocolBufferException(IOException paramIOException)
  {
    super(paramIOException.getMessage(), paramIOException);
  }
  
  public InvalidProtocolBufferException(String paramString)
  {
    super(paramString);
  }
  
  static InvalidProtocolBufferException invalidEndTag()
  {
    return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
  }
  
  static InvalidProtocolBufferException invalidTag()
  {
    return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
  }
  
  static InvalidProtocolBufferException invalidUtf8()
  {
    return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
  }
  
  static InvalidProtocolBufferException invalidWireType()
  {
    return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
  }
  
  static InvalidProtocolBufferException malformedVarint()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
  }
  
  static InvalidProtocolBufferException negativeSize()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static InvalidProtocolBufferException parseFailure()
  {
    return new InvalidProtocolBufferException("Failed to parse the message.");
  }
  
  static InvalidProtocolBufferException recursionLimitExceeded()
  {
    return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static InvalidProtocolBufferException sizeLimitExceeded()
  {
    return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static InvalidProtocolBufferException truncatedMessage()
  {
    return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  public MessageLite getUnfinishedMessage()
  {
    return this.unfinishedMessage;
  }
  
  public InvalidProtocolBufferException setUnfinishedMessage(MessageLite paramMessageLite)
  {
    this.unfinishedMessage = paramMessageLite;
    return this;
  }
  
  public IOException unwrapIOException()
  {
    if ((getCause() instanceof IOException)) {
      return (IOException)getCause();
    }
    return this;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/InvalidProtocolBufferException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */