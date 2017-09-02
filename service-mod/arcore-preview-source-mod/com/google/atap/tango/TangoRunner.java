package com.google.atap.tango;

import java.io.IOException;
import java.io.InputStream;

public class TangoRunner
{
  /* Error */
  public static void runTango(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 21	com/google/atap/tango/BootReceiver:isTangoDevKitDevice	()Z
    //   3: ifeq +11 -> 14
    //   6: getstatic 27	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 19
    //   11: if_icmpgt +4 -> 15
    //   14: return
    //   15: ldc 29
    //   17: ldc 31
    //   19: invokestatic 37	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: invokestatic 43	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   26: ldc 45
    //   28: invokevirtual 49	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   31: pop
    //   32: invokestatic 52	com/google/atap/tango/TangoRunner:symlinksReady	()Z
    //   35: ifne +34 -> 69
    //   38: ldc2_w 53
    //   41: invokestatic 60	java/lang/Thread:sleep	(J)V
    //   44: goto -12 -> 32
    //   47: astore_0
    //   48: ldc 29
    //   50: ldc 62
    //   52: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: aload_0
    //   57: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   60: ldc 29
    //   62: ldc 70
    //   64: invokestatic 37	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: return
    //   69: invokestatic 43	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   72: ldc 72
    //   74: invokevirtual 49	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   77: pop
    //   78: goto -18 -> 60
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 73	java/lang/InterruptedException:printStackTrace	()V
    //   86: goto -26 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   23	32	47	java/io/IOException
    //   32	44	47	java/io/IOException
    //   69	78	47	java/io/IOException
    //   23	32	81	java/lang/InterruptedException
    //   32	44	81	java/lang/InterruptedException
    //   69	78	81	java/lang/InterruptedException
  }
  
  public static boolean symlinksReady()
  {
    try
    {
      InputStream localInputStream = Runtime.getRuntime().exec("getprop service.tango_service.updated 1").getInputStream();
      byte[] arrayOfByte = new byte[80];
      Object localObject = new String();
      int i;
      String str;
      do
      {
        i = localInputStream.read(arrayOfByte);
        str = (String)localObject + new String(arrayOfByte, 0, i);
        localObject = str;
      } while (i >= 80);
      boolean bool = str.trim().equals("1");
      if (bool) {
        return false;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */