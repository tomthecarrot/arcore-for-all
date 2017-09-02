package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;

final class CharSequenceReader
  extends Reader
{
  private int mark;
  private int pos;
  private CharSequence seq;
  
  public CharSequenceReader(CharSequence paramCharSequence)
  {
    this.seq = ((CharSequence)Preconditions.checkNotNull(paramCharSequence));
  }
  
  private void checkOpen()
    throws IOException
  {
    if (this.seq == null) {
      throw new IOException("reader closed");
    }
  }
  
  private boolean hasRemaining()
  {
    return remaining() > 0;
  }
  
  private int remaining()
  {
    return this.seq.length() - this.pos;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.seq = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void mark(int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_1
    //   5: iflt +35 -> 40
    //   8: iload_2
    //   9: ldc 49
    //   11: iconst_1
    //   12: anewarray 51	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic 61	com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokespecial 63	com/google/common/io/CharSequenceReader:checkOpen	()V
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   34: putfield 65	com/google/common/io/CharSequenceReader:mark	I
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -34 -> 8
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	CharSequenceReader
    //   0	50	1	paramInt	int
    //   1	41	2	bool	boolean
    //   45	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	37	45	finally
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  /* Error */
  public int read()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 63	com/google/common/io/CharSequenceReader:checkOpen	()V
    //   6: aload_0
    //   7: invokespecial 69	com/google/common/io/CharSequenceReader:hasRemaining	()Z
    //   10: ifeq +32 -> 42
    //   13: aload_0
    //   14: getfield 24	com/google/common/io/CharSequenceReader:seq	Ljava/lang/CharSequence;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   22: istore_1
    //   23: aload_0
    //   24: iload_1
    //   25: iconst_1
    //   26: iadd
    //   27: putfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   30: aload_2
    //   31: iload_1
    //   32: invokeinterface 73 2 0
    //   37: istore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: iconst_m1
    //   43: istore_1
    //   44: goto -6 -> 38
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	CharSequenceReader
    //   22	22	1	i	int
    //   17	14	2	localCharSequence	CharSequence
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  /* Error */
  public int read(java.nio.CharBuffer paramCharBuffer)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 20	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokespecial 63	com/google/common/io/CharSequenceReader:checkOpen	()V
    //   11: aload_0
    //   12: invokespecial 69	com/google/common/io/CharSequenceReader:hasRemaining	()Z
    //   15: istore 5
    //   17: iload 5
    //   19: ifne +9 -> 28
    //   22: iconst_m1
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: aload_1
    //   29: invokevirtual 77	java/nio/CharBuffer:remaining	()I
    //   32: aload_0
    //   33: invokespecial 40	com/google/common/io/CharSequenceReader:remaining	()I
    //   36: invokestatic 83	java/lang/Math:min	(II)I
    //   39: istore 4
    //   41: iconst_0
    //   42: istore_2
    //   43: iload 4
    //   45: istore_3
    //   46: iload_2
    //   47: iload 4
    //   49: if_icmpge -25 -> 24
    //   52: aload_0
    //   53: getfield 24	com/google/common/io/CharSequenceReader:seq	Ljava/lang/CharSequence;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   62: istore_3
    //   63: aload_0
    //   64: iload_3
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   70: aload_1
    //   71: aload 6
    //   73: iload_3
    //   74: invokeinterface 73 2 0
    //   79: invokevirtual 87	java/nio/CharBuffer:put	(C)Ljava/nio/CharBuffer;
    //   82: pop
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -44 -> 43
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	CharSequenceReader
    //   0	95	1	paramCharBuffer	java.nio.CharBuffer
    //   42	45	2	i	int
    //   23	51	3	j	int
    //   39	11	4	k	int
    //   15	3	5	bool	boolean
    //   56	16	6	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   2	17	90	finally
    //   28	41	90	finally
    //   52	83	90	finally
  }
  
  /* Error */
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: iload_2
    //   4: iload_3
    //   5: iadd
    //   6: aload_1
    //   7: arraylength
    //   8: invokestatic 92	com/google/common/base/Preconditions:checkPositionIndexes	(III)V
    //   11: aload_0
    //   12: invokespecial 63	com/google/common/io/CharSequenceReader:checkOpen	()V
    //   15: aload_0
    //   16: invokespecial 69	com/google/common/io/CharSequenceReader:hasRemaining	()Z
    //   19: istore 6
    //   21: iload 6
    //   23: ifne +11 -> 34
    //   26: iconst_m1
    //   27: istore 4
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 4
    //   33: ireturn
    //   34: iload_3
    //   35: aload_0
    //   36: invokespecial 40	com/google/common/io/CharSequenceReader:remaining	()I
    //   39: invokestatic 83	java/lang/Math:min	(II)I
    //   42: istore 5
    //   44: iconst_0
    //   45: istore_3
    //   46: iload 5
    //   48: istore 4
    //   50: iload_3
    //   51: iload 5
    //   53: if_icmpge -24 -> 29
    //   56: aload_0
    //   57: getfield 24	com/google/common/io/CharSequenceReader:seq	Ljava/lang/CharSequence;
    //   60: astore 7
    //   62: aload_0
    //   63: getfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   66: istore 4
    //   68: aload_0
    //   69: iload 4
    //   71: iconst_1
    //   72: iadd
    //   73: putfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   76: aload_1
    //   77: iload_2
    //   78: iload_3
    //   79: iadd
    //   80: aload 7
    //   82: iload 4
    //   84: invokeinterface 73 2 0
    //   89: castore
    //   90: iload_3
    //   91: iconst_1
    //   92: iadd
    //   93: istore_3
    //   94: goto -48 -> 46
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	CharSequenceReader
    //   0	102	1	paramArrayOfChar	char[]
    //   0	102	2	paramInt1	int
    //   0	102	3	paramInt2	int
    //   27	56	4	i	int
    //   42	12	5	j	int
    //   19	3	6	bool	boolean
    //   60	21	7	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   2	21	97	finally
    //   34	44	97	finally
    //   56	90	97	finally
  }
  
  public boolean ready()
    throws IOException
  {
    try
    {
      checkOpen();
      return true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      checkOpen();
      this.pos = this.mark;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public long skip(long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: iflt +53 -> 61
    //   11: iload 4
    //   13: ldc 98
    //   15: iconst_1
    //   16: anewarray 51	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: lload_1
    //   22: invokestatic 103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: aastore
    //   26: invokestatic 61	com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: invokespecial 63	com/google/common/io/CharSequenceReader:checkOpen	()V
    //   33: aload_0
    //   34: invokespecial 40	com/google/common/io/CharSequenceReader:remaining	()I
    //   37: i2l
    //   38: lload_1
    //   39: invokestatic 106	java/lang/Math:min	(JJ)J
    //   42: l2i
    //   43: istore_3
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   49: iload_3
    //   50: iadd
    //   51: putfield 45	com/google/common/io/CharSequenceReader:pos	I
    //   54: iload_3
    //   55: i2l
    //   56: lstore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: lload_1
    //   60: lreturn
    //   61: iconst_0
    //   62: istore 4
    //   64: goto -53 -> 11
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	CharSequenceReader
    //   0	74	1	paramLong	long
    //   43	12	3	i	int
    //   1	62	4	bool	boolean
    //   67	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	54	67	finally
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/CharSequenceReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */