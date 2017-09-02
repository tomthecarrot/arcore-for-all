package com.google.tango.javacommon;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileUtils
{
  private static final String TAG = FileUtils.class.getSimpleName();
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['ࠀ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void createFileIfMissing(Context paramContext, String paramString)
  {
    try
    {
      paramContext.openFileInput(paramString).close();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        paramContext = new OutputStreamWriter(paramContext.openFileOutput(paramString, 0));
        paramContext.write("");
        paramContext.close();
        return;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void deleteDirectoryRecursive(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (paramString.isDirectory())
    {
      File[] arrayOfFile = paramString.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        deleteDirectoryRecursive(arrayOfFile[i].getPath());
        i += 1;
      }
    }
    Log.d(TAG, "Deleting file: " + paramString.toString());
    paramString.delete();
  }
  
  public static boolean fileEmpty(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2).length() == 0L;
  }
  
  public static boolean fileExists(Context paramContext, String paramString)
  {
    try
    {
      paramContext.openFileInput(paramString);
      return true;
    }
    catch (FileNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean fileExists(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    return (paramString1.exists()) && (new File(paramString1, paramString2).exists());
  }
  
  public static long fileLastModified(String paramString)
  {
    return new File(paramString).lastModified();
  }
  
  public static long fileLastModified(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2).lastModified();
  }
  
  private static File getFileAndCreateIfNecessary(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    paramString1.setReadable(true, true);
    paramString1.setWritable(true, true);
    paramString1 = new File(paramString1, paramString2);
    if (!paramString1.exists()) {
      paramString1.createNewFile();
    }
    paramString1.setReadable(true, true);
    paramString1.setWritable(true, true);
    return paramString1;
  }
  
  public static String[] list(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.isDirectory()) {
      paramString1 = new String[0];
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.list(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.matches(this.val$fileNameRegex);
        }
      });
      paramString1 = paramString2;
    } while (paramString2 != null);
    return new String[0];
  }
  
  public static boolean nonEmptyDirectoryExists(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.isDirectory()) && (paramString.listFiles().length != 0);
  }
  
  public static String readFromFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.openFileInput(paramString);
      StringBuilder localStringBuilder;
      if (paramContext != null)
      {
        paramString = new BufferedReader(new InputStreamReader(paramContext));
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          String str = paramString.readLine();
          if (str == null) {
            break;
          }
          localStringBuilder.append(str);
          localStringBuilder.append("\n");
        }
      }
      return "";
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e(TAG, "File not found: " + paramContext.toString());
      return "";
      paramContext.close();
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      Log.e(TAG, "Cannot read file: " + paramContext.toString());
    }
  }
  
  public static boolean setFileLastModified(String paramString1, String paramString2, long paramLong)
  {
    return new File(paramString1, paramString2).setLastModified(paramLong);
  }
  
  /* Error */
  public static boolean writeBytesToFile(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 7
    //   11: aload 5
    //   13: astore 4
    //   15: aload_1
    //   16: aload_2
    //   17: invokestatic 198	com/google/tango/javacommon/FileUtils:getFileAndCreateIfNecessary	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   20: astore 8
    //   22: aload 7
    //   24: astore 4
    //   26: aload_0
    //   27: ifnull +28 -> 55
    //   30: aload 5
    //   32: astore 4
    //   34: new 200	java/io/FileOutputStream
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore 5
    //   45: aload 5
    //   47: aload_0
    //   48: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   51: aload 5
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +8 -> 65
    //   60: aload 4
    //   62: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: ireturn
    //   69: astore_0
    //   70: getstatic 18	com/google/tango/javacommon/FileUtils:TAG	Ljava/lang/String;
    //   73: new 93	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   80: ldc -47
    //   82: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc -45
    //   91: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 184	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore 5
    //   113: aload 6
    //   115: astore_0
    //   116: aload_0
    //   117: astore 4
    //   119: getstatic 18	com/google/tango/javacommon/FileUtils:TAG	Ljava/lang/String;
    //   122: new 93	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   129: ldc -43
    //   131: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc -45
    //   140: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 184	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: pop
    //   154: aload_0
    //   155: astore 4
    //   157: aload 5
    //   159: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   162: aload_0
    //   163: ifnull -96 -> 67
    //   166: aload_0
    //   167: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: getstatic 18	com/google/tango/javacommon/FileUtils:TAG	Ljava/lang/String;
    //   176: new 93	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   183: ldc -47
    //   185: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc -45
    //   194: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 184	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload_0
    //   209: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore_0
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 207	java/io/FileOutputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: getstatic 18	com/google/tango/javacommon/FileUtils:TAG	Ljava/lang/String;
    //   231: new 93	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   238: ldc -47
    //   240: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc -45
    //   249: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 184	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   262: pop
    //   263: aload_0
    //   264: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   267: iconst_0
    //   268: ireturn
    //   269: astore_0
    //   270: aload 5
    //   272: astore 4
    //   274: goto -59 -> 215
    //   277: astore 4
    //   279: aload 5
    //   281: astore_0
    //   282: aload 4
    //   284: astore 5
    //   286: goto -170 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramArrayOfByte	byte[]
    //   0	289	1	paramString1	String
    //   0	289	2	paramString2	String
    //   1	67	3	bool	boolean
    //   13	260	4	localObject1	Object
    //   277	6	4	localIOException1	IOException
    //   6	46	5	localFileOutputStream	java.io.FileOutputStream
    //   111	169	5	localIOException2	IOException
    //   284	1	5	localObject2	Object
    //   3	111	6	localObject3	Object
    //   9	14	7	localObject4	Object
    //   20	19	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   60	65	69	java/io/IOException
    //   15	22	111	java/io/IOException
    //   34	45	111	java/io/IOException
    //   166	170	172	java/io/IOException
    //   15	22	214	finally
    //   34	45	214	finally
    //   119	154	214	finally
    //   157	162	214	finally
    //   220	225	227	java/io/IOException
    //   45	51	269	finally
    //   45	51	277	java/io/IOException
  }
  
  public static void writeToFile(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = new OutputStreamWriter(paramContext.openFileOutput(paramString1, 0));
      paramContext.write(paramString2);
      paramContext.close();
      return;
    }
    catch (IOException paramContext)
    {
      Log.e(TAG, "File write failed: " + paramContext.toString());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/javacommon/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */