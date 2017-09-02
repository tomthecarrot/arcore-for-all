package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

final class MessageDigestHashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  private final int bytes;
  private final MessageDigest prototype;
  private final boolean supportsClone;
  private final String toString;
  
  MessageDigestHashFunction(String paramString1, int paramInt, String paramString2)
  {
    this.toString = ((String)Preconditions.checkNotNull(paramString2));
    this.prototype = getMessageDigest(paramString1);
    int i = this.prototype.getDigestLength();
    if ((paramInt >= 4) && (paramInt <= i)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "bytes (%s) must be >= 4 and < %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      this.bytes = paramInt;
      this.supportsClone = supportsClone();
      return;
    }
  }
  
  MessageDigestHashFunction(String paramString1, String paramString2)
  {
    this.prototype = getMessageDigest(paramString1);
    this.bytes = this.prototype.getDigestLength();
    this.toString = ((String)Preconditions.checkNotNull(paramString2));
    this.supportsClone = supportsClone();
  }
  
  private static MessageDigest getMessageDigest(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  private boolean supportsClone()
  {
    try
    {
      this.prototype.clone();
      return true;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return false;
  }
  
  public int bits()
  {
    return this.bytes * 8;
  }
  
  public Hasher newHasher()
  {
    if (this.supportsClone) {
      try
      {
        MessageDigestHasher localMessageDigestHasher = new MessageDigestHasher((MessageDigest)this.prototype.clone(), this.bytes, null);
        return localMessageDigestHasher;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
  }
  
  public String toString()
  {
    return this.toString;
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
  }
  
  private static final class MessageDigestHasher
    extends AbstractByteHasher
  {
    private final int bytes;
    private final MessageDigest digest;
    private boolean done;
    
    private MessageDigestHasher(MessageDigest paramMessageDigest, int paramInt)
    {
      this.digest = paramMessageDigest;
      this.bytes = paramInt;
    }
    
    private void checkNotDone()
    {
      if (!this.done) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot re-use a Hasher after calling hash() on it");
        return;
      }
    }
    
    public HashCode hash()
    {
      checkNotDone();
      this.done = true;
      if (this.bytes == this.digest.getDigestLength()) {
        return HashCode.fromBytesNoCopy(this.digest.digest());
      }
      return HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
    }
    
    protected void update(byte paramByte)
    {
      checkNotDone();
      this.digest.update(paramByte);
    }
    
    protected void update(byte[] paramArrayOfByte)
    {
      checkNotDone();
      this.digest.update(paramArrayOfByte);
    }
    
    protected void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      checkNotDone();
      this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final String algorithmName;
    private final int bytes;
    private final String toString;
    
    private SerializedForm(String paramString1, int paramInt, String paramString2)
    {
      this.algorithmName = paramString1;
      this.bytes = paramInt;
      this.toString = paramString2;
    }
    
    private Object readResolve()
    {
      return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/MessageDigestHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */