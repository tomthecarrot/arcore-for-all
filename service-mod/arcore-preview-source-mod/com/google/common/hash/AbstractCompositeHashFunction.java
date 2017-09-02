package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.charset.Charset;

abstract class AbstractCompositeHashFunction
  extends AbstractStreamingHashFunction
{
  private static final long serialVersionUID = 0L;
  final HashFunction[] functions;
  
  AbstractCompositeHashFunction(HashFunction... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramVarArgs[i]);
      i += 1;
    }
    this.functions = paramVarArgs;
  }
  
  abstract HashCode makeHash(Hasher[] paramArrayOfHasher);
  
  public Hasher newHasher()
  {
    final Hasher[] arrayOfHasher = new Hasher[this.functions.length];
    int i = 0;
    while (i < arrayOfHasher.length)
    {
      arrayOfHasher[i] = this.functions[i].newHasher();
      i += 1;
    }
    new Hasher()
    {
      public HashCode hash()
      {
        return AbstractCompositeHashFunction.this.makeHash(arrayOfHasher);
      }
      
      public Hasher putBoolean(boolean paramAnonymousBoolean)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putBoolean(paramAnonymousBoolean);
          i += 1;
        }
        return this;
      }
      
      public Hasher putByte(byte paramAnonymousByte)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putByte(paramAnonymousByte);
          i += 1;
        }
        return this;
      }
      
      public Hasher putBytes(byte[] paramAnonymousArrayOfByte)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putBytes(paramAnonymousArrayOfByte);
          i += 1;
        }
        return this;
      }
      
      public Hasher putBytes(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putBytes(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          i += 1;
        }
        return this;
      }
      
      public Hasher putChar(char paramAnonymousChar)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putChar(paramAnonymousChar);
          i += 1;
        }
        return this;
      }
      
      public Hasher putDouble(double paramAnonymousDouble)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putDouble(paramAnonymousDouble);
          i += 1;
        }
        return this;
      }
      
      public Hasher putFloat(float paramAnonymousFloat)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putFloat(paramAnonymousFloat);
          i += 1;
        }
        return this;
      }
      
      public Hasher putInt(int paramAnonymousInt)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putInt(paramAnonymousInt);
          i += 1;
        }
        return this;
      }
      
      public Hasher putLong(long paramAnonymousLong)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putLong(paramAnonymousLong);
          i += 1;
        }
        return this;
      }
      
      public <T> Hasher putObject(T paramAnonymousT, Funnel<? super T> paramAnonymousFunnel)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putObject(paramAnonymousT, paramAnonymousFunnel);
          i += 1;
        }
        return this;
      }
      
      public Hasher putShort(short paramAnonymousShort)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putShort(paramAnonymousShort);
          i += 1;
        }
        return this;
      }
      
      public Hasher putString(CharSequence paramAnonymousCharSequence, Charset paramAnonymousCharset)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putString(paramAnonymousCharSequence, paramAnonymousCharset);
          i += 1;
        }
        return this;
      }
      
      public Hasher putUnencodedChars(CharSequence paramAnonymousCharSequence)
      {
        Hasher[] arrayOfHasher = arrayOfHasher;
        int j = arrayOfHasher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfHasher[i].putUnencodedChars(paramAnonymousCharSequence);
          i += 1;
        }
        return this;
      }
    };
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/AbstractCompositeHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */