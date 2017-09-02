package com.google.tango.cloudlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.tango.javacommon.FileUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class NavigationGraphCache
{
  private static final long CACHE_TIME_MS = 86400000L;
  private static final String SHARED_PREF_NAME = "NavigationGraphCache";
  private static final String TAG = "NavigationGraphCache";
  private final String mAdfDirPath;
  private final Context mContext;
  
  NavigationGraphCache(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mAdfDirPath = paramString;
  }
  
  Set<String> getCachedNavGraphs(long paramLong)
  {
    Set localSet = this.mContext.getSharedPreferences("NavigationGraphCache", 0).getStringSet(Utils.asToken(Long.valueOf(paramLong)), null);
    Object localObject;
    if ((localSet == null) || (localSet.isEmpty()))
    {
      localObject = null;
      return (Set<String>)localObject;
    }
    Iterator localIterator = localSet.iterator();
    do
    {
      localObject = localSet;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
    } while (System.currentTimeMillis() - FileUtils.fileLastModified((String)localObject) <= 86400000L);
    Log.i("NavigationGraphCache", "Navigation graph " + (String)localObject + " older than " + 86400000L + " ms, invalidating cache.");
    return null;
  }
  
  Set<String> setCachedNavGraphs(Set<Long> paramSet, Map<String, byte[]> paramMap)
  {
    Log.d("NavigationGraphCache", "Caching " + paramMap.keySet());
    HashSet localHashSet = new HashSet();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if (!FileUtils.writeBytesToFile((byte[])localEntry.getValue(), this.mAdfDirPath, str))
      {
        Log.e("NavigationGraphCache", "Failed to write downloaded nav graph to disk.");
        return null;
      }
      localHashSet.add(this.mAdfDirPath + "/" + str);
    }
    paramMap = this.mContext.getSharedPreferences("NavigationGraphCache", 0).edit();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      paramMap.putStringSet(Utils.asToken((Long)paramSet.next()), localHashSet);
    }
    paramMap.commit();
    return localHashSet;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/NavigationGraphCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */