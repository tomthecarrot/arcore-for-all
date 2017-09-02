package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19
{
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {}
    while (TextUtils.isEmpty(getRawType(paramContext, paramUri))) {
      return false;
    }
    return true;
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {}
    String str;
    int i;
    do
    {
      do
      {
        return false;
        str = getRawType(paramContext, paramUri);
        i = queryForInt(paramContext, paramUri, "flags", 0);
      } while (TextUtils.isEmpty(str));
      if ((i & 0x4) != 0) {
        return true;
      }
      if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
        return true;
      }
    } while ((TextUtils.isEmpty(str)) || ((i & 0x2) == 0));
    return true;
  }
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  public static boolean delete(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 5
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 42	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 71
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: astore 4
    //   35: aload_1
    //   36: invokeinterface 83 1 0
    //   41: istore_2
    //   42: iload_2
    //   43: ifle +11 -> 54
    //   46: iconst_1
    //   47: istore_3
    //   48: aload_1
    //   49: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   52: iload_3
    //   53: ireturn
    //   54: iconst_0
    //   55: istore_3
    //   56: goto -8 -> 48
    //   59: astore_1
    //   60: aload_0
    //   61: astore 4
    //   63: ldc 8
    //   65: new 87	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   72: ldc 90
    //   74: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 107	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: aload_0
    //   89: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aload 4
    //   97: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	Context
    //   0	102	1	paramUri	Uri
    //   41	2	2	i	int
    //   47	9	3	bool	boolean
    //   7	89	4	localObject	Object
    //   4	8	5	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   11	30	59	java/lang/Exception
    //   35	42	59	java/lang/Exception
    //   11	30	94	finally
    //   35	42	94	finally
    //   63	88	94	finally
  }
  
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramUri = getRawType(paramContext, paramUri);
    paramContext = paramUri;
    if ("vnd.android.document/directory".equals(paramUri)) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      paramUri = localContentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      paramContext = paramUri;
      localObject = paramUri;
      if (paramUri.moveToFirst())
      {
        paramContext = paramUri;
        localObject = paramUri;
        if (!paramUri.isNull(0))
        {
          paramContext = paramUri;
          localObject = paramUri;
          long l = paramUri.getLong(0);
          closeQuietly(paramUri);
          return l;
        }
      }
      closeQuietly(paramUri);
      return paramLong;
    }
    catch (Exception paramUri)
    {
      localObject = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      return paramLong;
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject);
    }
  }
  
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      paramUri = localContentResolver.query(paramUri, new String[] { paramString1 }, null, null, null);
      paramContext = paramUri;
      localObject = paramUri;
      if (paramUri.moveToFirst())
      {
        paramContext = paramUri;
        localObject = paramUri;
        if (!paramUri.isNull(0))
        {
          paramContext = paramUri;
          localObject = paramUri;
          paramString1 = paramUri.getString(0);
          closeQuietly(paramUri);
          return paramString1;
        }
      }
      closeQuietly(paramUri);
      return paramString2;
    }
    catch (Exception paramUri)
    {
      localObject = paramContext;
      Log.w("DocumentFile", "Failed query: " + paramUri);
      closeQuietly(paramContext);
      return paramString2;
    }
    finally
    {
      closeQuietly((AutoCloseable)localObject);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/provider/DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */