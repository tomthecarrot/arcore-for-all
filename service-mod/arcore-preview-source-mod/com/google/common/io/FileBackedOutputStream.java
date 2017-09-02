package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
public final class FileBackedOutputStream
  extends OutputStream
{
  private File file;
  private final int fileThreshold;
  private MemoryOutput memory;
  private OutputStream out;
  private final boolean resetOnFinalize;
  private final ByteSource source;
  
  public FileBackedOutputStream(int paramInt)
  {
    this(paramInt, false);
  }
  
  public FileBackedOutputStream(int paramInt, boolean paramBoolean)
  {
    this.fileThreshold = paramInt;
    this.resetOnFinalize = paramBoolean;
    this.memory = new MemoryOutput(null);
    this.out = this.memory;
    if (paramBoolean)
    {
      this.source = new ByteSource()
      {
        protected void finalize()
        {
          try
          {
            FileBackedOutputStream.this.reset();
            return;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace(System.err);
          }
        }
        
        public InputStream openStream()
          throws IOException
        {
          return FileBackedOutputStream.this.openInputStream();
        }
      };
      return;
    }
    this.source = new ByteSource()
    {
      public InputStream openStream()
        throws IOException
      {
        return FileBackedOutputStream.this.openInputStream();
      }
    };
  }
  
  /* Error */
  private InputStream openInputStream()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   6: ifnull +19 -> 25
    //   9: new 63	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   17: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: new 68	java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   33: invokevirtual 72	com/google/common/io/FileBackedOutputStream$MemoryOutput:getBuffer	()[B
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   41: invokevirtual 76	com/google/common/io/FileBackedOutputStream$MemoryOutput:getCount	()I
    //   44: invokespecial 79	java/io/ByteArrayInputStream:<init>	([BII)V
    //   47: astore_1
    //   48: goto -27 -> 21
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	FileBackedOutputStream
    //   20	28	1	localObject1	Object
    //   51	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	51	finally
    //   25	48	51	finally
  }
  
  private void update(int paramInt)
    throws IOException
  {
    if ((this.file == null) && (this.memory.getCount() + paramInt > this.fileThreshold))
    {
      File localFile = File.createTempFile("FileBackedOutputStream", null);
      if (this.resetOnFinalize) {
        localFile.deleteOnExit();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
      localFileOutputStream.flush();
      this.out = localFileOutputStream;
      this.file = localFile;
      this.memory = null;
    }
  }
  
  public ByteSource asByteSource()
  {
    return this.source;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.out.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      this.out.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  File getFile()
  {
    try
    {
      File localFile = this.file;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void reset()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 112	com/google/common/io/FileBackedOutputStream:close	()V
    //   6: aload_0
    //   7: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   10: ifnonnull +79 -> 89
    //   13: aload_0
    //   14: new 10	com/google/common/io/FileBackedOutputStream$MemoryOutput
    //   17: dup
    //   18: aconst_null
    //   19: invokespecial 40	com/google/common/io/FileBackedOutputStream$MemoryOutput:<init>	(Lcom/google/common/io/FileBackedOutputStream$1;)V
    //   22: putfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   30: putfield 44	com/google/common/io/FileBackedOutputStream:out	Ljava/io/OutputStream;
    //   33: aload_0
    //   34: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   37: ifnull +153 -> 190
    //   40: aload_0
    //   41: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   44: astore_1
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   50: aload_1
    //   51: invokevirtual 116	java/io/File:delete	()Z
    //   54: ifne +136 -> 190
    //   57: new 54	java/io/IOException
    //   60: dup
    //   61: new 118	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   68: ldc 121
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 135	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: aload_0
    //   90: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   93: invokevirtual 137	com/google/common/io/FileBackedOutputStream$MemoryOutput:reset	()V
    //   96: goto -71 -> 25
    //   99: astore_1
    //   100: aload_0
    //   101: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   104: ifnonnull +74 -> 178
    //   107: aload_0
    //   108: new 10	com/google/common/io/FileBackedOutputStream$MemoryOutput
    //   111: dup
    //   112: aconst_null
    //   113: invokespecial 40	com/google/common/io/FileBackedOutputStream$MemoryOutput:<init>	(Lcom/google/common/io/FileBackedOutputStream$1;)V
    //   116: putfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   124: putfield 44	com/google/common/io/FileBackedOutputStream:out	Ljava/io/OutputStream;
    //   127: aload_0
    //   128: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   131: ifnull +57 -> 188
    //   134: aload_0
    //   135: getfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   138: astore_2
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 61	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   144: aload_2
    //   145: invokevirtual 116	java/io/File:delete	()Z
    //   148: ifne +40 -> 188
    //   151: new 54	java/io/IOException
    //   154: dup
    //   155: new 118	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   162: ldc 121
    //   164: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 135	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: aload_0
    //   179: getfield 42	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   182: invokevirtual 137	com/google/common/io/FileBackedOutputStream$MemoryOutput:reset	()V
    //   185: goto -66 -> 119
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: monitorexit
    //   192: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	FileBackedOutputStream
    //   44	30	1	localFile1	File
    //   84	4	1	localObject1	Object
    //   99	90	1	localObject2	Object
    //   138	30	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   6	25	84	finally
    //   25	84	84	finally
    //   89	96	84	finally
    //   100	119	84	finally
    //   119	178	84	finally
    //   178	185	84	finally
    //   188	190	84	finally
    //   2	6	99	finally
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      update(1);
      this.out.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      write(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      update(paramInt2);
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  private static class MemoryOutput
    extends ByteArrayOutputStream
  {
    byte[] getBuffer()
    {
      return this.buf;
    }
    
    int getCount()
    {
      return this.count;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/FileBackedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */