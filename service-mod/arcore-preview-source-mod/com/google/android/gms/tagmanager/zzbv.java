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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class zzbv
  implements zzap
{
  private static final String zzaed = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  private final Context mContext;
  private final zzb zzcvi;
  private volatile zzz zzcvj;
  private final zzaq zzcvk;
  private final String zzcvl;
  private long zzcvm;
  private final int zzcvn;
  private Clock zzvi;
  
  zzbv(zzaq paramzzaq, Context paramContext)
  {
    this(paramzzaq, paramContext, "gtm_urls.db", 2000);
  }
  
  zzbv(zzaq paramzzaq, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzcvl = paramString;
    this.zzcvk = paramzzaq;
    this.zzvi = zzh.zzAM();
    this.zzcvi = new zzb(this.mContext, this.zzcvl);
    this.zzcvj = new zzcs(this.mContext, new zza());
    this.zzcvm = 0L;
    this.zzcvn = paramInt;
  }
  
  private void zzXU()
  {
    int i = zzXV() - this.zzcvn + 1;
    if (i > 0)
    {
      List localList = zzws(i);
      i = localList.size();
      Log.v(51 + "Store full, deleting " + i + " hits to make room.");
      zzj((String[])localList.toArray(new String[0]));
    }
  }
  
  private void zzh(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = zzjL("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    localContentValues.put("hit_url", paramString);
    localContentValues.put("hit_first_send_time", Integer.valueOf(0));
    try
    {
      localSQLiteDatabase.insert("gtm_hits", null, localContentValues);
      this.zzcvk.zzby(false);
      return;
    }
    catch (SQLiteException paramString)
    {
      Log.w("Error storing hit");
    }
  }
  
  private SQLiteDatabase zzjL(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzcvi.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(paramString);
    }
    return null;
  }
  
  private void zzn(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = zzjL("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
    try
    {
      localSQLiteDatabase.update("gtm_hits", localContentValues, "hit_id=?", new String[] { String.valueOf(paramLong1) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(69 + "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
      zzz(paramLong1);
    }
  }
  
  private void zzz(long paramLong)
  {
    zzj(new String[] { String.valueOf(paramLong) });
  }
  
  public void dispatch()
  {
    Log.v("GTM Dispatch running...");
    if (!this.zzcvj.zzXA()) {}
    do
    {
      return;
      List localList = zzwt(40);
      if (localList.isEmpty())
      {
        Log.v("...nothing to dispatch");
        this.zzcvk.zzby(true);
        return;
      }
      this.zzcvj.zzah(localList);
    } while (zzXW() <= 0);
    zzcq.zzYs().dispatch();
  }
  
  int zzXV()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = zzjL("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from gtm_hits", null);
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
        Log.w("Error getting numStoredHits");
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
  
  /* Error */
  int zzXW()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc -34
    //   6: invokespecial 175	com/google/android/gms/tagmanager/zzbv:zzjL	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_3
    //   17: ldc 35
    //   19: iconst_2
    //   20: anewarray 45	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 37
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 43
    //   32: aastore
    //   33: ldc_w 290
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 294	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 297 1 0
    //   50: istore_2
    //   51: iload_2
    //   52: istore_1
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: aload_3
    //   58: invokeinterface 286 1 0
    //   63: iload_2
    //   64: istore_1
    //   65: iload_1
    //   66: ireturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_3
    //   70: ldc_w 299
    //   73: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: ifnull +56 -> 133
    //   80: aload_3
    //   81: invokeinterface 286 1 0
    //   86: iconst_0
    //   87: istore_1
    //   88: goto -23 -> 65
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokeinterface 286 1 0
    //   104: aload_3
    //   105: athrow
    //   106: astore 5
    //   108: aload_3
    //   109: astore 4
    //   111: aload 5
    //   113: astore_3
    //   114: goto -22 -> 92
    //   117: astore 5
    //   119: aload_3
    //   120: astore 4
    //   122: aload 5
    //   124: astore_3
    //   125: goto -33 -> 92
    //   128: astore 4
    //   130: goto -60 -> 70
    //   133: iconst_0
    //   134: istore_1
    //   135: goto -70 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	zzbv
    //   52	83	1	i	int
    //   50	14	2	j	int
    //   9	49	3	localObject1	Object
    //   67	1	3	localSQLiteException1	SQLiteException
    //   69	12	3	localObject2	Object
    //   91	18	3	localObject3	Object
    //   113	12	3	localObject4	Object
    //   1	120	4	localObject5	Object
    //   128	1	4	localSQLiteException2	SQLiteException
    //   106	6	5	localObject6	Object
    //   117	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   16	44	67	android/database/sqlite/SQLiteException
    //   16	44	91	finally
    //   44	51	106	finally
    //   70	76	117	finally
    //   44	51	128	android/database/sqlite/SQLiteException
  }
  
  public void zzg(long paramLong, String paramString)
  {
    zznS();
    zzXU();
    zzh(paramLong, paramString);
  }
  
  void zzj(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = zzjL("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = this.zzcvk;
        if (zzXV() == 0)
        {
          paramArrayOfString.zzby(bool);
          return;
        }
      }
      catch (SQLiteException paramArrayOfString)
      {
        Log.w("Error deleting hits");
        return;
      }
      bool = false;
    }
  }
  
  int zznS()
  {
    boolean bool = true;
    long l = this.zzvi.currentTimeMillis();
    if (l <= this.zzcvm + 86400000L) {}
    do
    {
      return 0;
      this.zzcvm = l;
      localObject = zzjL("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.zzvi.currentTimeMillis() - 2592000000L) });
    Object localObject = this.zzcvk;
    if (zzXV() == 0) {}
    for (;;)
    {
      ((zzaq)localObject).zzby(bool);
      return i;
      bool = false;
    }
  }
  
  /* Error */
  List<String> zzws(int paramInt)
  {
    // Byte code:
    //   0: new 351	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 352	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 354
    //   16: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 356
    //   26: invokespecial 175	com/google/android/gms/tagmanager/zzbv:zzjL	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +6 -> 37
    //   34: aload 6
    //   36: areturn
    //   37: ldc_w 358
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc 37
    //   48: aastore
    //   49: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 4
    //   54: iload_1
    //   55: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_3
    //   61: ldc 35
    //   63: iconst_1
    //   64: anewarray 45	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 37
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 364	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokeinterface 279 1 0
    //   95: ifeq +40 -> 135
    //   98: aload 4
    //   100: astore_3
    //   101: aload 6
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 283 2 0
    //   111: invokestatic 227	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: invokeinterface 368 2 0
    //   119: pop
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 371 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne -34 -> 98
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 286 1 0
    //   147: aload 6
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 374	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   163: invokestatic 377	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: astore 5
    //   168: aload 4
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 380	java/lang/String:length	()I
    //   176: ifeq +39 -> 215
    //   179: aload 4
    //   181: astore_3
    //   182: ldc_w 382
    //   185: aload 5
    //   187: invokevirtual 386	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 5
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ifnull -55 -> 147
    //   205: aload 4
    //   207: invokeinterface 286 1 0
    //   212: goto -65 -> 147
    //   215: aload 4
    //   217: astore_3
    //   218: new 45	java/lang/String
    //   221: dup
    //   222: ldc_w 382
    //   225: invokespecial 388	java/lang/String:<init>	(Ljava/lang/String;)V
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
    //   248: invokeinterface 286 1 0
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
    //   0	267	0	this	zzbv
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
    //   7	141	6	localArrayList	java.util.ArrayList
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
  
  /* Error */
  public List<zzam> zzwt(int paramInt)
  {
    // Byte code:
    //   0: new 351	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 352	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 392
    //   13: invokespecial 175	com/google/android/gms/tagmanager/zzbv:zzjL	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +10 -> 30
    //   23: aload 5
    //   25: astore 6
    //   27: aload 6
    //   29: areturn
    //   30: aconst_null
    //   31: astore 6
    //   33: ldc_w 358
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 37
    //   44: aastore
    //   45: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore 4
    //   50: iload_1
    //   51: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   54: astore 7
    //   56: aload 8
    //   58: ldc 35
    //   60: iconst_3
    //   61: anewarray 45	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 37
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 39
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc 43
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aload 4
    //   85: aload 7
    //   87: invokevirtual 364	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 4
    //   92: new 351	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 352	java/util/ArrayList:<init>	()V
    //   99: astore 7
    //   101: aload 4
    //   103: invokeinterface 279 1 0
    //   108: ifeq +54 -> 162
    //   111: aload 7
    //   113: new 394	com/google/android/gms/tagmanager/zzam
    //   116: dup
    //   117: aload 4
    //   119: iconst_0
    //   120: invokeinterface 283 2 0
    //   125: aload 4
    //   127: iconst_1
    //   128: invokeinterface 283 2 0
    //   133: aload 4
    //   135: iconst_2
    //   136: invokeinterface 283 2 0
    //   141: invokespecial 397	com/google/android/gms/tagmanager/zzam:<init>	(JJJ)V
    //   144: invokeinterface 368 2 0
    //   149: pop
    //   150: aload 4
    //   152: invokeinterface 371 1 0
    //   157: istore_3
    //   158: iload_3
    //   159: ifne -48 -> 111
    //   162: aload 4
    //   164: ifnull +10 -> 174
    //   167: aload 4
    //   169: invokeinterface 286 1 0
    //   174: aload 4
    //   176: astore 5
    //   178: ldc_w 358
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: ldc 37
    //   189: aastore
    //   190: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   193: astore 6
    //   195: aload 4
    //   197: astore 5
    //   199: iload_1
    //   200: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   203: astore 9
    //   205: aload 4
    //   207: astore 5
    //   209: aload 8
    //   211: ldc 35
    //   213: iconst_2
    //   214: anewarray 45	java/lang/String
    //   217: dup
    //   218: iconst_0
    //   219: ldc 37
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: ldc 41
    //   226: aastore
    //   227: aconst_null
    //   228: aconst_null
    //   229: aconst_null
    //   230: aconst_null
    //   231: aload 6
    //   233: aload 9
    //   235: invokevirtual 364	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   238: astore 6
    //   240: aload 6
    //   242: invokeinterface 279 1 0
    //   247: ifeq +53 -> 300
    //   250: iconst_0
    //   251: istore_1
    //   252: aload 6
    //   254: checkcast 399	android/database/sqlite/SQLiteCursor
    //   257: invokevirtual 403	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   260: invokevirtual 408	android/database/CursorWindow:getNumRows	()I
    //   263: ifle +149 -> 412
    //   266: aload 7
    //   268: iload_1
    //   269: invokeinterface 412 2 0
    //   274: checkcast 394	com/google/android/gms/tagmanager/zzam
    //   277: aload 6
    //   279: iconst_1
    //   280: invokeinterface 415 2 0
    //   285: invokevirtual 418	com/google/android/gms/tagmanager/zzam:zzjO	(Ljava/lang/String;)V
    //   288: aload 6
    //   290: invokeinterface 371 1 0
    //   295: istore_3
    //   296: iload_3
    //   297: ifne +429 -> 726
    //   300: aload 6
    //   302: ifnull +10 -> 312
    //   305: aload 6
    //   307: invokeinterface 286 1 0
    //   312: aload 7
    //   314: areturn
    //   315: astore 6
    //   317: aconst_null
    //   318: astore 7
    //   320: aload 5
    //   322: astore 4
    //   324: aload 7
    //   326: astore 5
    //   328: aload 6
    //   330: invokevirtual 374	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   333: invokestatic 377	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   336: astore 6
    //   338: aload 6
    //   340: invokevirtual 380	java/lang/String:length	()I
    //   343: ifeq +37 -> 380
    //   346: ldc_w 382
    //   349: aload 6
    //   351: invokevirtual 386	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   354: astore 6
    //   356: aload 6
    //   358: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   361: aload 4
    //   363: astore 6
    //   365: aload 5
    //   367: ifnull -340 -> 27
    //   370: aload 5
    //   372: invokeinterface 286 1 0
    //   377: aload 4
    //   379: areturn
    //   380: new 45	java/lang/String
    //   383: dup
    //   384: ldc_w 382
    //   387: invokespecial 388	java/lang/String:<init>	(Ljava/lang/String;)V
    //   390: astore 6
    //   392: goto -36 -> 356
    //   395: astore 4
    //   397: aload 5
    //   399: ifnull +10 -> 409
    //   402: aload 5
    //   404: invokeinterface 286 1 0
    //   409: aload 4
    //   411: athrow
    //   412: ldc_w 420
    //   415: iconst_1
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: aload 7
    //   423: iload_1
    //   424: invokeinterface 412 2 0
    //   429: checkcast 394	com/google/android/gms/tagmanager/zzam
    //   432: invokevirtual 423	com/google/android/gms/tagmanager/zzam:zzXH	()J
    //   435: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   442: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   445: goto -157 -> 288
    //   448: astore 5
    //   450: aload 6
    //   452: astore 4
    //   454: aload 5
    //   456: astore 6
    //   458: aload 4
    //   460: astore 5
    //   462: aload 6
    //   464: invokevirtual 374	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   467: invokestatic 377	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   470: astore 6
    //   472: aload 4
    //   474: astore 5
    //   476: aload 6
    //   478: invokevirtual 380	java/lang/String:length	()I
    //   481: ifeq +122 -> 603
    //   484: aload 4
    //   486: astore 5
    //   488: ldc_w 425
    //   491: aload 6
    //   493: invokevirtual 386	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 6
    //   498: aload 4
    //   500: astore 5
    //   502: aload 6
    //   504: invokestatic 216	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   507: aload 4
    //   509: astore 5
    //   511: new 351	java/util/ArrayList
    //   514: dup
    //   515: invokespecial 352	java/util/ArrayList:<init>	()V
    //   518: astore 6
    //   520: iconst_0
    //   521: istore_1
    //   522: aload 4
    //   524: astore 5
    //   526: aload 7
    //   528: invokeinterface 429 1 0
    //   533: astore 7
    //   535: aload 4
    //   537: astore 5
    //   539: aload 7
    //   541: invokeinterface 434 1 0
    //   546: ifeq +42 -> 588
    //   549: aload 4
    //   551: astore 5
    //   553: aload 7
    //   555: invokeinterface 438 1 0
    //   560: checkcast 394	com/google/android/gms/tagmanager/zzam
    //   563: astore 8
    //   565: aload 4
    //   567: astore 5
    //   569: aload 8
    //   571: invokevirtual 441	com/google/android/gms/tagmanager/zzam:zzXJ	()Ljava/lang/String;
    //   574: invokestatic 444	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   577: istore_3
    //   578: iload_1
    //   579: istore_2
    //   580: iload_3
    //   581: ifeq +60 -> 641
    //   584: iload_1
    //   585: ifeq +54 -> 639
    //   588: aload 4
    //   590: ifnull +10 -> 600
    //   593: aload 4
    //   595: invokeinterface 286 1 0
    //   600: aload 6
    //   602: areturn
    //   603: aload 4
    //   605: astore 5
    //   607: new 45	java/lang/String
    //   610: dup
    //   611: ldc_w 425
    //   614: invokespecial 388	java/lang/String:<init>	(Ljava/lang/String;)V
    //   617: astore 6
    //   619: goto -121 -> 498
    //   622: astore 4
    //   624: aload 5
    //   626: ifnull +10 -> 636
    //   629: aload 5
    //   631: invokeinterface 286 1 0
    //   636: aload 4
    //   638: athrow
    //   639: iconst_1
    //   640: istore_2
    //   641: aload 4
    //   643: astore 5
    //   645: aload 6
    //   647: aload 8
    //   649: invokeinterface 368 2 0
    //   654: pop
    //   655: iload_2
    //   656: istore_1
    //   657: goto -122 -> 535
    //   660: astore 4
    //   662: aload 6
    //   664: astore 5
    //   666: goto -42 -> 624
    //   669: astore 6
    //   671: goto -213 -> 458
    //   674: astore 4
    //   676: aload 6
    //   678: astore 5
    //   680: goto -283 -> 397
    //   683: astore 6
    //   685: aload 4
    //   687: astore 5
    //   689: aload 6
    //   691: astore 4
    //   693: goto -296 -> 397
    //   696: astore 6
    //   698: aload 4
    //   700: astore 7
    //   702: aload 5
    //   704: astore 4
    //   706: aload 7
    //   708: astore 5
    //   710: goto -382 -> 328
    //   713: astore 6
    //   715: aload 4
    //   717: astore 5
    //   719: aload 7
    //   721: astore 4
    //   723: goto -395 -> 328
    //   726: iload_1
    //   727: iconst_1
    //   728: iadd
    //   729: istore_1
    //   730: goto -478 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	zzbv
    //   0	733	1	paramInt	int
    //   579	77	2	i	int
    //   157	424	3	bool	boolean
    //   48	330	4	localObject1	Object
    //   395	15	4	localObject2	Object
    //   452	152	4	localObject3	Object
    //   622	20	4	localObject4	Object
    //   660	1	4	localObject5	Object
    //   674	12	4	localObject6	Object
    //   691	31	4	localObject7	Object
    //   7	396	5	localObject8	Object
    //   448	7	5	localSQLiteException1	SQLiteException
    //   460	258	5	localObject9	Object
    //   25	281	6	localObject10	Object
    //   315	14	6	localSQLiteException2	SQLiteException
    //   336	327	6	localObject11	Object
    //   669	8	6	localSQLiteException3	SQLiteException
    //   683	7	6	localObject12	Object
    //   696	1	6	localSQLiteException4	SQLiteException
    //   713	1	6	localSQLiteException5	SQLiteException
    //   54	666	7	localObject13	Object
    //   16	632	8	localObject14	Object
    //   203	31	9	str	String
    // Exception table:
    //   from	to	target	type
    //   33	92	315	android/database/sqlite/SQLiteException
    //   328	356	395	finally
    //   356	361	395	finally
    //   380	392	395	finally
    //   240	250	448	android/database/sqlite/SQLiteException
    //   252	288	448	android/database/sqlite/SQLiteException
    //   288	296	448	android/database/sqlite/SQLiteException
    //   412	445	448	android/database/sqlite/SQLiteException
    //   178	195	622	finally
    //   199	205	622	finally
    //   209	240	622	finally
    //   462	472	622	finally
    //   476	484	622	finally
    //   488	498	622	finally
    //   502	507	622	finally
    //   511	520	622	finally
    //   526	535	622	finally
    //   539	549	622	finally
    //   553	565	622	finally
    //   569	578	622	finally
    //   607	619	622	finally
    //   645	655	622	finally
    //   240	250	660	finally
    //   252	288	660	finally
    //   288	296	660	finally
    //   412	445	660	finally
    //   178	195	669	android/database/sqlite/SQLiteException
    //   199	205	669	android/database/sqlite/SQLiteException
    //   209	240	669	android/database/sqlite/SQLiteException
    //   33	92	674	finally
    //   92	101	683	finally
    //   101	111	683	finally
    //   111	158	683	finally
    //   92	101	696	android/database/sqlite/SQLiteException
    //   101	111	713	android/database/sqlite/SQLiteException
    //   111	158	713	android/database/sqlite/SQLiteException
  }
  
  class zza
    implements zzcs.zza
  {
    zza() {}
    
    public void zza(zzam paramzzam)
    {
      zzbv.zza(zzbv.this, paramzzam.zzXH());
    }
    
    public void zzb(zzam paramzzam)
    {
      zzbv.zza(zzbv.this, paramzzam.zzXH());
      long l = paramzzam.zzXH();
      Log.v(57 + "Permanent failure dispatching hitId: " + l);
    }
    
    public void zzc(zzam paramzzam)
    {
      long l = paramzzam.zzXI();
      if (l == 0L) {
        zzbv.zza(zzbv.this, paramzzam.zzXH(), zzbv.zza(zzbv.this).currentTimeMillis());
      }
      while (l + 14400000L >= zzbv.zza(zzbv.this).currentTimeMillis()) {
        return;
      }
      zzbv.zza(zzbv.this, paramzzam.zzXH());
      l = paramzzam.zzXH();
      Log.v(47 + "Giving up on failed hitId: " + l);
    }
  }
  
  class zzb
    extends SQLiteOpenHelper
  {
    private boolean zzcvp;
    private long zzcvq = 0L;
    
    zzb(Context paramContext, String paramString)
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
      //   4: ldc 29
      //   6: iconst_1
      //   7: anewarray 31	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 33
      //   14: aastore
      //   15: ldc 35
      //   17: iconst_1
      //   18: anewarray 31	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 41	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 47 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 51 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: aload_1
      //   55: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   58: astore_1
      //   59: aload_1
      //   60: invokevirtual 59	java/lang/String:length	()I
      //   63: ifeq +26 -> 89
      //   66: ldc 61
      //   68: aload_1
      //   69: invokevirtual 65	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   72: astore_1
      //   73: aload_1
      //   74: invokestatic 71	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: ifnull +9 -> 87
      //   81: aload_2
      //   82: invokeinterface 51 1 0
      //   87: iconst_0
      //   88: ireturn
      //   89: new 31	java/lang/String
      //   92: dup
      //   93: ldc 61
      //   95: invokespecial 73	java/lang/String:<init>	(Ljava/lang/String;)V
      //   98: astore_1
      //   99: goto -26 -> 73
      //   102: astore_1
      //   103: aload_2
      //   104: ifnull +9 -> 113
      //   107: aload_2
      //   108: invokeinterface 51 1 0
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
      //   0	131	0	this	zzb
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
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
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
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_time")) || (!localHashSet.remove("hit_first_send_time"))) {
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
      if ((this.zzcvp) && (this.zzcvq + 3600000L > zzbv.zza(zzbv.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.zzcvp = true;
      this.zzcvq = zzbv.zza(zzbv.this).currentTimeMillis();
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
          zzbv.zzc(zzbv.this).getDatabasePath(zzbv.zzb(zzbv.this)).delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      this.zzcvp = false;
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
        if (!zza("gtm_hits", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(zzbv.zzXX());
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
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */