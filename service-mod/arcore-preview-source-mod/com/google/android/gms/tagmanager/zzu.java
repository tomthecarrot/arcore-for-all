package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzu
  implements DataLayer.zzc
{
  private static final String zzctZ = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  private final Context mContext;
  private final Executor zzajg;
  private zza zzcua;
  private int zzcub;
  private Clock zzvi;
  
  public zzu(Context paramContext)
  {
    this(paramContext, zzh.zzAM(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  zzu(Context paramContext, Clock paramClock, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.zzvi = paramClock;
    this.zzcub = paramInt;
    this.zzajg = paramExecutor;
    this.zzcua = new zza(this.mContext, paramString);
  }
  
  /* Error */
  private byte[] zzT(Object paramObject)
  {
    // Byte code:
    //   0: new 93	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 94	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 96	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 99	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 103	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_3
    //   23: invokevirtual 107	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 110	java/io/ObjectOutputStream:close	()V
    //   31: aload_3
    //   32: invokevirtual 111	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 110	java/io/ObjectOutputStream:close	()V
    //   48: aload_3
    //   49: invokevirtual 111	java/io/ByteArrayOutputStream:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 110	java/io/ObjectOutputStream:close	()V
    //   68: aload_3
    //   69: invokevirtual 111	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_2
    //   75: goto -3 -> 72
    //   78: astore_1
    //   79: goto -19 -> 60
    //   82: astore_1
    //   83: goto -43 -> 40
    //   86: astore_2
    //   87: aload_1
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzu
    //   0	89	1	paramObject	Object
    //   16	49	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   74	1	2	localIOException1	java.io.IOException
    //   86	1	2	localIOException2	java.io.IOException
    //   7	62	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   8	17	37	java/io/IOException
    //   44	48	54	java/io/IOException
    //   48	52	54	java/io/IOException
    //   8	17	57	finally
    //   64	68	74	java/io/IOException
    //   68	72	74	java/io/IOException
    //   17	27	78	finally
    //   17	27	82	java/io/IOException
    //   27	35	86	java/io/IOException
  }
  
  /* Error */
  private Object zzW(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 117	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 120	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_3
    //   9: new 122	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 125	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 129	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   27: aload_3
    //   28: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   31: aload_2
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   44: aload_3
    //   45: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aconst_null
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   64: aload_3
    //   65: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_1
    //   71: aconst_null
    //   72: areturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   84: aload_3
    //   85: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   88: aload_2
    //   89: athrow
    //   90: astore_1
    //   91: goto -3 -> 88
    //   94: astore_2
    //   95: goto -19 -> 76
    //   98: astore_2
    //   99: goto -43 -> 56
    //   102: astore_2
    //   103: goto -67 -> 36
    //   106: astore_1
    //   107: aload_2
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	zzu
    //   0	109	1	paramArrayOfByte	byte[]
    //   22	10	2	localObject1	Object
    //   73	16	2	localObject2	Object
    //   94	1	2	localObject3	Object
    //   98	1	2	localClassNotFoundException	ClassNotFoundException
    //   102	6	2	localIOException	java.io.IOException
    //   8	77	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   9	18	33	java/io/IOException
    //   40	44	50	java/io/IOException
    //   44	48	50	java/io/IOException
    //   9	18	53	java/lang/ClassNotFoundException
    //   60	64	70	java/io/IOException
    //   64	68	70	java/io/IOException
    //   9	18	73	finally
    //   80	84	90	java/io/IOException
    //   84	88	90	java/io/IOException
    //   18	23	94	finally
    //   18	23	98	java/lang/ClassNotFoundException
    //   18	23	102	java/io/IOException
    //   23	31	106	java/io/IOException
  }
  
  private List<DataLayer.zza> zzXv()
  {
    try
    {
      zzaQ(this.zzvi.currentTimeMillis());
      List localList = zzaf(zzXw());
      return localList;
    }
    finally
    {
      zzXy();
    }
  }
  
  private List<zzb> zzXw()
  {
    Object localObject = zzjL("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SQLiteDatabase)localObject).query("datalayer", new String[] { "key", "value" }, null, null, null, null, "ID", null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        localArrayList.add(new zzb(((Cursor)localObject).getString(0), ((Cursor)localObject).getBlob(1)));
      }
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private int zzXx()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = zzjL("Error opening database for getNumStoredEntries.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from datalayer", null);
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          localObject1 = localObject5;
          localObject3 = localObject5;
          long l = ((Cursor)localObject5).getLong(0);
          i = (int)l;
        }
        j = i;
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        Log.w("Error getting numStoredEntries");
        return 0;
      }
      finally
      {
        Object localObject4;
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
    }
  }
  
  private void zzXy()
  {
    try
    {
      this.zzcua.close();
      return;
    }
    catch (SQLiteException localSQLiteException) {}
  }
  
  private void zzaQ(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzjL("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", new String[] { Long.toString(paramLong) });
      Log.v(33 + "Deleted " + i + " expired items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error deleting old entries.");
    }
  }
  
  private List<DataLayer.zza> zzaf(List<zzb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzb localzzb = (zzb)paramList.next();
      localArrayList.add(new DataLayer.zza(localzzb.zzBp, zzW(localzzb.zzcuh)));
    }
    return localArrayList;
  }
  
  private List<zzb> zzag(List<DataLayer.zza> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.zza localzza = (DataLayer.zza)paramList.next();
      localArrayList.add(new zzb(localzza.zzBp, zzT(localzza.mValue)));
    }
    return localArrayList;
  }
  
  /* Error */
  private void zzb(List<zzb> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/android/gms/tagmanager/zzu:zzvi	Lcom/google/android/gms/common/util/Clock;
    //   6: invokeinterface 139 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 143	com/google/android/gms/tagmanager/zzu:zzaQ	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 313 1 0
    //   26: invokespecial 316	com/google/android/gms/tagmanager/zzu:zzwm	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 319	com/google/android/gms/tagmanager/zzu:zzc	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 153	com/google/android/gms/tagmanager/zzu:zzXy	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 153	com/google/android/gms/tagmanager/zzu:zzXy	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	zzu
    //   0	57	1	paramList	List<zzb>
    //   0	57	2	paramLong	long
    //   11	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	52	finally
    //   46	52	52	finally
  }
  
  private void zzc(List<zzb> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzjL("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        zzb localzzb = (zzb)paramList.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", localzzb.zzBp);
        localContentValues.put("value", localzzb.zzcuh);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  private void zzi(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = zzjL("Error opening database for deleteEntries.");
    } while (localSQLiteDatabase == null);
    String str = String.format("%s in (%s)", new Object[] { "ID", TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    try
    {
      localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      paramArrayOfString = String.valueOf(Arrays.toString(paramArrayOfString));
      if (paramArrayOfString.length() == 0) {}
    }
    for (paramArrayOfString = "Error deleting entries ".concat(paramArrayOfString);; paramArrayOfString = new String("Error deleting entries "))
    {
      Log.w(paramArrayOfString);
      return;
    }
  }
  
  private void zzjK(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = zzjL("Error opening database for clearKeysWithPrefix.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] { paramString, String.valueOf(paramString).concat(".%") });
      Log.v(25 + "Cleared " + i + " items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      String str = String.valueOf(localSQLiteException);
      Log.w(String.valueOf(paramString).length() + 44 + String.valueOf(str).length() + "Error deleting entries with key prefix: " + paramString + " (" + str + ").");
      return;
    }
    finally
    {
      zzXy();
    }
  }
  
  private SQLiteDatabase zzjL(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzcua.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(paramString);
    }
    return null;
  }
  
  private void zzwm(int paramInt)
  {
    paramInt = zzXx() - this.zzcub + paramInt;
    if (paramInt > 0)
    {
      List localList = zzwn(paramInt);
      paramInt = localList.size();
      Log.i(64 + "DataLayer store full, deleting " + paramInt + " entries to make room.");
      zzi((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  private List<String> zzwn(int paramInt)
  {
    // Byte code:
    //   0: new 163	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 164	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 426
    //   16: invokestatic 222	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 428
    //   26: invokespecial 161	com/google/android/gms/tagmanager/zzu:zzjL	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +6 -> 37
    //   34: aload 6
    //   36: areturn
    //   37: ldc_w 430
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc 38
    //   48: aastore
    //   49: invokestatic 50	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 4
    //   54: iload_1
    //   55: invokestatic 434	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_3
    //   61: ldc 36
    //   63: iconst_1
    //   64: anewarray 46	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 38
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 170	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokeinterface 210 1 0
    //   95: ifeq +40 -> 135
    //   98: aload 4
    //   100: astore_3
    //   101: aload 6
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 214 2 0
    //   111: invokestatic 436	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: invokeinterface 193 2 0
    //   119: pop
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 176 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne -34 -> 98
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 194 1 0
    //   147: aload 6
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 439	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   163: invokestatic 372	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: astore 5
    //   168: aload 4
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 375	java/lang/String:length	()I
    //   176: ifeq +39 -> 215
    //   179: aload 4
    //   181: astore_3
    //   182: ldc_w 441
    //   185: aload 5
    //   187: invokevirtual 381	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 5
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: invokestatic 222	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ifnull -55 -> 147
    //   205: aload 4
    //   207: invokeinterface 194 1 0
    //   212: goto -65 -> 147
    //   215: aload 4
    //   217: astore_3
    //   218: new 46	java/lang/String
    //   221: dup
    //   222: ldc_w 441
    //   225: invokespecial 383	java/lang/String:<init>	(Ljava/lang/String;)V
    //   228: astore 5
    //   230: goto -38 -> 192
    //   233: astore 5
    //   235: aload_3
    //   236: astore 4
    //   238: aload 5
    //   240: astore_3
    //   241: aload 4
    //   243: ifnull +10 -> 253
    //   246: aload 4
    //   248: invokeinterface 194 1 0
    //   253: aload_3
    //   254: athrow
    //   255: astore_3
    //   256: aconst_null
    //   257: astore 4
    //   259: goto -18 -> 241
    //   262: astore 5
    //   264: goto -109 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	zzu
    //   0	267	1	paramInt	int
    //   130	2	2	bool	boolean
    //   29	225	3	localObject1	Object
    //   255	1	3	localObject2	Object
    //   52	206	4	localObject3	Object
    //   58	21	5	str1	String
    //   150	9	5	localSQLiteException1	SQLiteException
    //   166	63	5	str2	String
    //   233	6	5	localObject4	Object
    //   262	1	5	localSQLiteException2	SQLiteException
    //   7	141	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   37	85	150	android/database/sqlite/SQLiteException
    //   88	98	233	finally
    //   101	120	233	finally
    //   123	131	233	finally
    //   158	168	233	finally
    //   171	179	233	finally
    //   182	192	233	finally
    //   195	200	233	finally
    //   218	230	233	finally
    //   37	85	255	finally
    //   88	98	262	android/database/sqlite/SQLiteException
    //   101	120	262	android/database/sqlite/SQLiteException
    //   123	131	262	android/database/sqlite/SQLiteException
  }
  
  public void zza(final DataLayer.zzc.zza paramzza)
  {
    this.zzajg.execute(new Runnable()
    {
      public void run()
      {
        paramzza.zzae(zzu.zza(zzu.this));
      }
    });
  }
  
  public void zza(final List<DataLayer.zza> paramList, final long paramLong)
  {
    paramList = zzag(paramList);
    this.zzajg.execute(new Runnable()
    {
      public void run()
      {
        zzu.zza(zzu.this, paramList, paramLong);
      }
    });
  }
  
  public void zzjJ(final String paramString)
  {
    this.zzajg.execute(new Runnable()
    {
      public void run()
      {
        zzu.zza(zzu.this, paramString);
      }
    });
  }
  
  class zza
    extends SQLiteOpenHelper
  {
    zza(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    /* Error */
    private boolean zza(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: ldc 22
      //   6: iconst_1
      //   7: anewarray 24	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 26
      //   14: aastore
      //   15: ldc 28
      //   17: iconst_1
      //   18: anewarray 24	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 34	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 40 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 44 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: aload_1
      //   55: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   58: astore_1
      //   59: aload_1
      //   60: invokevirtual 52	java/lang/String:length	()I
      //   63: ifeq +26 -> 89
      //   66: ldc 54
      //   68: aload_1
      //   69: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   72: astore_1
      //   73: aload_1
      //   74: invokestatic 64	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: ifnull +9 -> 87
      //   81: aload_2
      //   82: invokeinterface 44 1 0
      //   87: iconst_0
      //   88: ireturn
      //   89: new 24	java/lang/String
      //   92: dup
      //   93: ldc 54
      //   95: invokespecial 66	java/lang/String:<init>	(Ljava/lang/String;)V
      //   98: astore_1
      //   99: goto -26 -> 73
      //   102: astore_1
      //   103: aload_2
      //   104: ifnull +9 -> 113
      //   107: aload_2
      //   108: invokeinterface 44 1 0
      //   113: aload_1
      //   114: athrow
      //   115: astore_1
      //   116: aload 4
      //   118: astore_2
      //   119: goto -16 -> 103
      //   122: astore_1
      //   123: goto -20 -> 103
      //   126: astore 4
      //   128: goto -74 -> 54
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zza
      //   0	131	1	paramString	String
      //   0	131	2	paramSQLiteDatabase	SQLiteDatabase
      //   38	12	3	bool	boolean
      //   1	116	4	localObject	Object
      //   126	1	4	localSQLiteException	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	51	android/database/sqlite/SQLiteException
      //   54	73	102	finally
      //   73	77	102	finally
      //   89	99	102	finally
      //   3	32	115	finally
      //   32	39	122	finally
      //   32	39	126	android/database/sqlite/SQLiteException
    }
    
    private void zzm(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
        int i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        paramSQLiteDatabase.close();
        if ((!localHashSet.remove("key")) || (!localHashSet.remove("value")) || (!localHashSet.remove("ID")) || (!localHashSet.remove("expires"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      if (!((Set)localObject).isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      Object localObject1 = null;
      try
      {
        localObject2 = super.getWritableDatabase();
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Object localObject2;
          zzu.zzb(zzu.this).getDatabasePath("google_tagmanager.db").delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      zzah.zzbC(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!zza("datalayer", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(zzu.zzXz());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      zzm(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
  
  private static class zzb
  {
    final String zzBp;
    final byte[] zzcuh;
    
    zzb(String paramString, byte[] paramArrayOfByte)
    {
      this.zzBp = paramString;
      this.zzcuh = paramArrayOfByte;
    }
    
    public String toString()
    {
      String str = this.zzBp;
      int i = Arrays.hashCode(this.zzcuh);
      return String.valueOf(str).length() + 54 + "KeyAndSerialized: key = " + str + " serialized hash = " + i;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */