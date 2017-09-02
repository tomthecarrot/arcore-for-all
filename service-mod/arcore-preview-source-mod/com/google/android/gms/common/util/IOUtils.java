package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public final class IOUtils
{
  public static void close(Closeable paramCloseable, String paramString1, String paramString2)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.d(paramString1, paramString2, paramCloseable);
    }
  }
  
  public static void closeQuietly(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {}
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor) {}
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (IOException paramServerSocket) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (IOException paramSocket) {}
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return copyStream(paramInputStream, paramOutputStream, false);
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return copyStream(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = 0L;
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i == -1) {
          break;
        }
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        break label73;
      }
    }
    finally
    {
      if (paramBoolean)
      {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      }
    }
    closeQuietly(paramInputStream);
    closeQuietly(paramOutputStream);
    label73:
    return l;
  }
  
  public static boolean isGzipByteBuffer(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length > 1) && ((paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8) == 35615);
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream)
    throws IOException
  {
    return readInputStreamFully(paramInputStream, true);
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, localByteArrayOutputStream, paramBoolean);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(File paramFile)
    throws IOException
  {
    return zzd(paramFile).zzAO();
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static long zza(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    zzac.zzC(paramInputStream);
    zzac.zzC(paramOutputStream);
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static byte[] zza(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new OutOfMemoryError(68 + "file is too large to fit in a byte array: " + paramLong + " bytes");
    }
    if (paramLong == 0L) {
      return toByteArray(paramInputStream);
    }
    return zzb(paramInputStream, (int)paramLong);
  }
  
  static byte[] zzb(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = paramInt;
    int k;
    if (i > 0)
    {
      int j = paramInt - i;
      k = paramInputStream.read(arrayOfByte, j, i);
      if (k == -1) {
        localObject = Arrays.copyOf(arrayOfByte, j);
      }
    }
    do
    {
      return (byte[])localObject;
      i -= k;
      break;
      i = paramInputStream.read();
      localObject = arrayOfByte;
    } while (i == -1);
    Object localObject = new zza(null);
    ((zza)localObject).write(i);
    zza(paramInputStream, (OutputStream)localObject);
    paramInputStream = new byte[((zza)localObject).size() + paramInt];
    System.arraycopy(arrayOfByte, 0, paramInputStream, 0, paramInt);
    ((zza)localObject).zze(paramInputStream, paramInt);
    return paramInputStream;
  }
  
  private static zzb zzd(File paramFile)
  {
    return new zzb(paramFile, null);
  }
  
  private static final class zza
    extends ByteArrayOutputStream
  {
    void zze(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
    }
  }
  
  private static final class zzb
  {
    private final File file;
    
    private zzb(File paramFile)
    {
      this.file = ((File)zzac.zzC(paramFile));
    }
    
    public byte[] zzAO()
      throws IOException
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.file);
        byte[] arrayOfByte;
        IOUtils.closeQuietly(localFileInputStream);
      }
      finally
      {
        try
        {
          arrayOfByte = IOUtils.zzb(localFileInputStream, localFileInputStream.getChannel().size());
          IOUtils.closeQuietly(localFileInputStream);
          return arrayOfByte;
        }
        finally {}
        localObject1 = finally;
        localFileInputStream = null;
      }
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */