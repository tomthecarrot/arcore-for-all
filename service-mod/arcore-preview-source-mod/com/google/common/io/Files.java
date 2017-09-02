package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Beta
public final class Files
{
  private static final TreeTraverser<File> FILE_TREE_TRAVERSER = new TreeTraverser()
  {
    public Iterable<File> children(File paramAnonymousFile)
    {
      if (paramAnonymousFile.isDirectory())
      {
        paramAnonymousFile = paramAnonymousFile.listFiles();
        if (paramAnonymousFile != null) {
          return Collections.unmodifiableList(Arrays.asList(paramAnonymousFile));
        }
      }
      return Collections.emptyList();
    }
    
    public String toString()
    {
      return "Files.fileTreeTraverser()";
    }
  };
  private static final int TEMP_DIR_ATTEMPTS = 10000;
  
  public static void append(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException
  {
    write(paramCharSequence, paramFile, paramCharset, true);
  }
  
  public static ByteSink asByteSink(File paramFile, FileWriteMode... paramVarArgs)
  {
    return new FileByteSink(paramFile, paramVarArgs, null);
  }
  
  public static ByteSource asByteSource(File paramFile)
  {
    return new FileByteSource(paramFile, null);
  }
  
  public static CharSink asCharSink(File paramFile, Charset paramCharset, FileWriteMode... paramVarArgs)
  {
    return asByteSink(paramFile, paramVarArgs).asCharSink(paramCharset);
  }
  
  public static CharSource asCharSource(File paramFile, Charset paramCharset)
  {
    return asByteSource(paramFile).asCharSource(paramCharset);
  }
  
  public static void copy(File paramFile1, File paramFile2)
    throws IOException
  {
    if (!paramFile1.equals(paramFile2)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Source %s and destination %s must be different", new Object[] { paramFile1, paramFile2 });
      asByteSource(paramFile1).copyTo(asByteSink(paramFile2, new FileWriteMode[0]));
      return;
    }
  }
  
  public static void copy(File paramFile, OutputStream paramOutputStream)
    throws IOException
  {
    asByteSource(paramFile).copyTo(paramOutputStream);
  }
  
  public static void copy(File paramFile, Charset paramCharset, Appendable paramAppendable)
    throws IOException
  {
    asCharSource(paramFile, paramCharset).copyTo(paramAppendable);
  }
  
  public static void createParentDirs(File paramFile)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile);
    File localFile = paramFile.getCanonicalFile().getParentFile();
    if (localFile == null) {}
    do
    {
      return;
      localFile.mkdirs();
    } while (localFile.isDirectory());
    throw new IOException("Unable to create parent directories of " + paramFile);
  }
  
  public static File createTempDir()
  {
    File localFile1 = new File(System.getProperty("java.io.tmpdir"));
    String str = System.currentTimeMillis() + "-";
    int i = 0;
    while (i < 10000)
    {
      File localFile2 = new File(localFile1, str + i);
      if (localFile2.mkdir()) {
        return localFile2;
      }
      i += 1;
    }
    throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + 9999 + ')');
  }
  
  public static boolean equal(File paramFile1, File paramFile2)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile1);
    Preconditions.checkNotNull(paramFile2);
    if ((paramFile1 == paramFile2) || (paramFile1.equals(paramFile2))) {
      return true;
    }
    long l1 = paramFile1.length();
    long l2 = paramFile2.length();
    if ((l1 != 0L) && (l2 != 0L) && (l1 != l2)) {
      return false;
    }
    return asByteSource(paramFile1).contentEquals(asByteSource(paramFile2));
  }
  
  public static TreeTraverser<File> fileTreeTraverser()
  {
    return FILE_TREE_TRAVERSER;
  }
  
  public static String getFileExtension(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    paramString = new File(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static String getNameWithoutExtension(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    paramString = new File(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static HashCode hash(File paramFile, HashFunction paramHashFunction)
    throws IOException
  {
    return asByteSource(paramFile).hash(paramHashFunction);
  }
  
  public static Predicate<File> isDirectory()
  {
    return FilePredicate.IS_DIRECTORY;
  }
  
  public static Predicate<File> isFile()
  {
    return FilePredicate.IS_FILE;
  }
  
  public static MappedByteBuffer map(File paramFile)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile);
    return map(paramFile, FileChannel.MapMode.READ_ONLY);
  }
  
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramMapMode);
    if (!paramFile.exists()) {
      throw new FileNotFoundException(paramFile.toString());
    }
    return map(paramFile, paramMapMode, paramFile.length());
  }
  
  /* Error */
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws FileNotFoundException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 114	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokestatic 114	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: invokestatic 261	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   13: astore 5
    //   15: aload_1
    //   16: getstatic 240	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   19: if_acmpne +39 -> 58
    //   22: ldc_w 263
    //   25: astore 4
    //   27: aload 5
    //   29: new 265	java/io/RandomAccessFile
    //   32: dup
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 266	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: invokevirtual 270	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   42: checkcast 265	java/io/RandomAccessFile
    //   45: aload_1
    //   46: lload_2
    //   47: invokestatic 273	com/google/common/io/Files:map	(Ljava/io/RandomAccessFile;Ljava/nio/channels/FileChannel$MapMode;J)Ljava/nio/MappedByteBuffer;
    //   50: astore_0
    //   51: aload 5
    //   53: invokevirtual 276	com/google/common/io/Closer:close	()V
    //   56: aload_0
    //   57: areturn
    //   58: ldc_w 278
    //   61: astore 4
    //   63: goto -36 -> 27
    //   66: astore_0
    //   67: aload 5
    //   69: aload_0
    //   70: invokevirtual 282	com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   73: athrow
    //   74: astore_0
    //   75: aload 5
    //   77: invokevirtual 276	com/google/common/io/Closer:close	()V
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramFile	File
    //   0	82	1	paramMapMode	FileChannel.MapMode
    //   0	82	2	paramLong	long
    //   25	37	4	str	String
    //   13	63	5	localCloser	Closer
    // Exception table:
    //   from	to	target	type
    //   15	22	66	java/lang/Throwable
    //   27	51	66	java/lang/Throwable
    //   15	22	74	finally
    //   27	51	74	finally
    //   67	74	74	finally
  }
  
  private static MappedByteBuffer map(RandomAccessFile paramRandomAccessFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      paramRandomAccessFile = ((FileChannel)localCloser.register(paramRandomAccessFile.getChannel())).map(paramMapMode, 0L, paramLong);
      return paramRandomAccessFile;
    }
    catch (Throwable paramRandomAccessFile)
    {
      throw localCloser.rethrow(paramRandomAccessFile);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  private static FileWriteMode[] modes(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new FileWriteMode[] { FileWriteMode.APPEND };
    }
    return new FileWriteMode[0];
  }
  
  public static void move(File paramFile1, File paramFile2)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile1);
    Preconditions.checkNotNull(paramFile2);
    if (!paramFile1.equals(paramFile2)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Source %s and destination %s must be different", new Object[] { paramFile1, paramFile2 });
      if (paramFile1.renameTo(paramFile2)) {
        return;
      }
      copy(paramFile1, paramFile2);
      if (paramFile1.delete()) {
        return;
      }
      if (paramFile2.delete()) {
        break;
      }
      throw new IOException("Unable to delete " + paramFile2);
    }
    throw new IOException("Unable to delete " + paramFile1);
  }
  
  public static BufferedReader newReader(File paramFile, Charset paramCharset)
    throws FileNotFoundException
  {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramCharset);
    return new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), paramCharset));
  }
  
  public static BufferedWriter newWriter(File paramFile, Charset paramCharset)
    throws FileNotFoundException
  {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramCharset);
    return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramCharset));
  }
  
  public static <T> T readBytes(File paramFile, ByteProcessor<T> paramByteProcessor)
    throws IOException
  {
    return (T)asByteSource(paramFile).read(paramByteProcessor);
  }
  
  static byte[] readFile(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new OutOfMemoryError("file is too large to fit in a byte array: " + paramLong + " bytes");
    }
    if (paramLong == 0L) {
      return ByteStreams.toByteArray(paramInputStream);
    }
    return ByteStreams.toByteArray(paramInputStream, (int)paramLong);
  }
  
  public static String readFirstLine(File paramFile, Charset paramCharset)
    throws IOException
  {
    return asCharSource(paramFile, paramCharset).readFirstLine();
  }
  
  public static <T> T readLines(File paramFile, Charset paramCharset, LineProcessor<T> paramLineProcessor)
    throws IOException
  {
    return (T)asCharSource(paramFile, paramCharset).readLines(paramLineProcessor);
  }
  
  public static List<String> readLines(File paramFile, Charset paramCharset)
    throws IOException
  {
    (List)readLines(paramFile, paramCharset, new LineProcessor()
    {
      final List<String> result = Lists.newArrayList();
      
      public List<String> getResult()
      {
        return this.result;
      }
      
      public boolean processLine(String paramAnonymousString)
      {
        this.result.add(paramAnonymousString);
        return true;
      }
    });
  }
  
  public static String simplifyPath(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() == 0) {
      paramString = ".";
    }
    Object localObject1;
    do
    {
      return paramString;
      Object localObject2 = Splitter.on('/').omitEmptyStrings().split(paramString);
      localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (!str.equals(".")) {
          if (str.equals(".."))
          {
            if ((((List)localObject1).size() > 0) && (!((String)((List)localObject1).get(((List)localObject1).size() - 1)).equals(".."))) {
              ((List)localObject1).remove(((List)localObject1).size() - 1);
            } else {
              ((List)localObject1).add("..");
            }
          }
          else {
            ((List)localObject1).add(str);
          }
        }
      }
      localObject2 = Joiner.on('/').join((Iterable)localObject1);
      localObject1 = localObject2;
      if (paramString.charAt(0) == '/') {}
      for (localObject1 = "/" + (String)localObject2; ((String)localObject1).startsWith("/../"); localObject1 = ((String)localObject1).substring(3)) {}
      if (((String)localObject1).equals("/..")) {
        return "/";
      }
      paramString = (String)localObject1;
    } while (!"".equals(localObject1));
    return ".";
  }
  
  public static byte[] toByteArray(File paramFile)
    throws IOException
  {
    return asByteSource(paramFile).read();
  }
  
  public static String toString(File paramFile, Charset paramCharset)
    throws IOException
  {
    return asCharSource(paramFile, paramCharset).read();
  }
  
  public static void touch(File paramFile)
    throws IOException
  {
    Preconditions.checkNotNull(paramFile);
    if ((!paramFile.createNewFile()) && (!paramFile.setLastModified(System.currentTimeMillis()))) {
      throw new IOException("Unable to update modification time of " + paramFile);
    }
  }
  
  public static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException
  {
    asCharSink(paramFile, paramCharset, new FileWriteMode[0]).write(paramCharSequence);
  }
  
  private static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    asCharSink(paramFile, paramCharset, modes(paramBoolean)).write(paramCharSequence);
  }
  
  public static void write(byte[] paramArrayOfByte, File paramFile)
    throws IOException
  {
    asByteSink(paramFile, new FileWriteMode[0]).write(paramArrayOfByte);
  }
  
  private static final class FileByteSink
    extends ByteSink
  {
    private final File file;
    private final ImmutableSet<FileWriteMode> modes;
    
    private FileByteSink(File paramFile, FileWriteMode... paramVarArgs)
    {
      this.file = ((File)Preconditions.checkNotNull(paramFile));
      this.modes = ImmutableSet.copyOf(paramVarArgs);
    }
    
    public FileOutputStream openStream()
      throws IOException
    {
      return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
    }
    
    public String toString()
    {
      return "Files.asByteSink(" + this.file + ", " + this.modes + ")";
    }
  }
  
  private static final class FileByteSource
    extends ByteSource
  {
    private final File file;
    
    private FileByteSource(File paramFile)
    {
      this.file = ((File)Preconditions.checkNotNull(paramFile));
    }
    
    public FileInputStream openStream()
      throws IOException
    {
      return new FileInputStream(this.file);
    }
    
    public byte[] read()
      throws IOException
    {
      Closer localCloser = Closer.create();
      try
      {
        Object localObject1 = (FileInputStream)localCloser.register(openStream());
        localObject1 = Files.readFile((InputStream)localObject1, ((FileInputStream)localObject1).getChannel().size());
        return (byte[])localObject1;
      }
      catch (Throwable localThrowable)
      {
        throw localCloser.rethrow(localThrowable);
      }
      finally
      {
        localCloser.close();
      }
    }
    
    public long size()
      throws IOException
    {
      if (!this.file.isFile()) {
        throw new FileNotFoundException(this.file.toString());
      }
      return this.file.length();
    }
    
    public Optional<Long> sizeIfKnown()
    {
      if (this.file.isFile()) {
        return Optional.of(Long.valueOf(this.file.length()));
      }
      return Optional.absent();
    }
    
    public String toString()
    {
      return "Files.asByteSource(" + this.file + ")";
    }
  }
  
  private static abstract enum FilePredicate
    implements Predicate<File>
  {
    IS_DIRECTORY,  IS_FILE;
    
    private FilePredicate() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */