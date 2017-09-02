package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  static final String[] zzctP = "gtm.lifetime".toString().split("\\.");
  private static final Pattern zzctQ = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<zzb, Integer> zzctR;
  private final Map<String, Object> zzctS;
  private final ReentrantLock zzctT;
  private final LinkedList<Map<String, Object>> zzctU;
  private final zzc zzctV;
  private final CountDownLatch zzctW;
  
  DataLayer()
  {
    this(new zzc()
    {
      public void zza(DataLayer.zzc.zza paramAnonymouszza)
      {
        paramAnonymouszza.zzae(new ArrayList());
      }
      
      public void zza(List<DataLayer.zza> paramAnonymousList, long paramAnonymousLong) {}
      
      public void zzjJ(String paramAnonymousString) {}
    });
  }
  
  DataLayer(zzc paramzzc)
  {
    this.zzctV = paramzzc;
    this.zzctR = new ConcurrentHashMap();
    this.zzctS = new HashMap();
    this.zzctT = new ReentrantLock();
    this.zzctU = new LinkedList();
    this.zzctW = new CountDownLatch(1);
    zzXr();
  }
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("expected even number of key-value pairs");
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!(paramVarArgs[i] instanceof String))
      {
        paramVarArgs = String.valueOf(paramVarArgs[i]);
        throw new IllegalArgumentException(String.valueOf(paramVarArgs).length() + 21 + "key is not a string: " + paramVarArgs);
      }
      localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  private void zzXr()
  {
    this.zzctV.zza(new DataLayer.zzc.zza()
    {
      public void zzae(List<DataLayer.zza> paramAnonymousList)
      {
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          DataLayer.zza localzza = (DataLayer.zza)paramAnonymousList.next();
          DataLayer.zza(DataLayer.this, DataLayer.this.zzr(localzza.zzBp, localzza.mValue));
        }
        DataLayer.zza(DataLayer.this).countDown();
      }
    });
  }
  
  private void zzXs()
  {
    int i = 0;
    for (;;)
    {
      Map localMap = (Map)this.zzctU.poll();
      if (localMap != null)
      {
        zzak(localMap);
        i += 1;
        if (i > 500)
        {
          this.zzctU.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void zza(Map<String, Object> paramMap, String paramString, Collection<zza> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.length() == 0) {}
      for (paramMap = "";; paramMap = ".")
      {
        String str = (String)localEntry.getKey();
        paramMap = String.valueOf(paramString).length() + String.valueOf(paramMap).length() + String.valueOf(str).length() + paramString + paramMap + str;
        if (!(localEntry.getValue() instanceof Map)) {
          break label143;
        }
        zza((Map)localEntry.getValue(), paramMap, paramCollection);
        break;
      }
      label143:
      if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new zza(paramMap, localEntry.getValue()));
      }
    }
  }
  
  private void zzaf(Map<String, Object> paramMap)
  {
    this.zzctT.lock();
    try
    {
      this.zzctU.offer(paramMap);
      if (this.zzctT.getHoldCount() == 1) {
        zzXs();
      }
      zzag(paramMap);
      return;
    }
    finally
    {
      this.zzctT.unlock();
    }
  }
  
  private void zzag(Map<String, Object> paramMap)
  {
    Long localLong = zzah(paramMap);
    if (localLong == null) {
      return;
    }
    paramMap = zzaj(paramMap);
    this.zzctV.zza(paramMap, localLong.longValue());
  }
  
  private Long zzah(Map<String, Object> paramMap)
  {
    paramMap = zzai(paramMap);
    if (paramMap == null) {
      return null;
    }
    return zzjI(paramMap.toString());
  }
  
  private Object zzai(Map<String, Object> paramMap)
  {
    String[] arrayOfString = zzctP;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject = paramMap;
      if (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramMap instanceof Map)) {
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      paramMap = ((Map)paramMap).get(localObject);
      i += 1;
    }
  }
  
  private List<zza> zzaj(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    zza(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void zzak(Map<String, Object> paramMap)
  {
    synchronized (this.zzctS)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zzd(zzr(str, paramMap.get(str)), this.zzctS);
      }
    }
    zzal(paramMap);
  }
  
  private void zzal(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.zzctR.keySet().iterator();
    while (localIterator.hasNext()) {
      ((zzb)localIterator.next()).zzae(paramMap);
    }
  }
  
  static Long zzjI(String paramString)
  {
    Matcher localMatcher = zzctQ.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "unknown _lifetime: ".concat(paramString);; paramString = new String("unknown _lifetime: "))
      {
        Log.i(paramString);
        return null;
      }
    }
    long l;
    try
    {
      l = Long.parseLong(localMatcher.group(1));
      if (l <= 0L)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "non-positive _lifetime: ".concat(paramString);
          Log.i(paramString);
          return null;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        str = String.valueOf(paramString);
        if (str.length() != 0) {}
        for (str = "illegal number in _lifetime value: ".concat(str);; str = new String("illegal number in _lifetime value: "))
        {
          Log.w(str);
          l = 0L;
          break;
        }
        paramString = new String("non-positive _lifetime: ");
      }
      String str = localMatcher.group(2);
      if (str.length() == 0) {
        return Long.valueOf(l);
      }
      switch (str.charAt(0))
      {
      default: 
        paramString = String.valueOf(paramString);
        if (paramString.length() == 0) {}
        break;
      }
    }
    for (paramString = "unknown units in _lifetime: ".concat(paramString);; paramString = new String("unknown units in _lifetime: "))
    {
      Log.w(paramString);
      return null;
      return Long.valueOf(l * 1000L);
      return Long.valueOf(l * 1000L * 60L);
      return Long.valueOf(l * 1000L * 60L * 60L);
      return Long.valueOf(l * 1000L * 60L * 60L * 24L);
    }
  }
  
  public Object get(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (this.zzctS)
      {
        Map localMap1 = this.zzctS;
        String[] arrayOfString = paramString.split("\\.");
        int j = arrayOfString.length;
        paramString = localMap1;
        i = 0;
        if (i < j)
        {
          localMap1 = arrayOfString[i];
          if (!(paramString instanceof Map)) {
            return null;
          }
          paramString = ((Map)paramString).get(localMap1);
          if (paramString == null) {
            return null;
          }
        }
        else
        {
          return paramString;
        }
      }
      i += 1;
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(zzr(paramString, paramObject));
  }
  
  public void push(Map<String, Object> paramMap)
  {
    try
    {
      this.zzctW.await();
      zzaf(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  public void pushEvent(String paramString, Map<String, Object> paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap.put("event", paramString);
    push(paramMap);
  }
  
  public String toString()
  {
    synchronized (this.zzctS)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.zzctS.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
      }
    }
    String str = ((StringBuilder)localObject).toString();
    return str;
  }
  
  void zza(zzb paramzzb)
  {
    this.zzctR.put(paramzzb, Integer.valueOf(0));
  }
  
  void zzb(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    if (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        zzb((List)localObject, (List)paramList2.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(i) instanceof Map)) {
            paramList2.set(i, new HashMap());
          }
          zzd((Map)localObject, (Map)paramList2.get(i));
        }
        else if (localObject != OBJECT_NOT_PRESENT)
        {
          paramList2.set(i, localObject);
        }
      }
    }
  }
  
  void zzd(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        zzb((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        zzd((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  void zzjH(String paramString)
  {
    push(paramString, null);
    this.zzctV.zzjJ(paramString);
  }
  
  Map<String, Object> zzr(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap2;
    for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2)
    {
      localHashMap2 = new HashMap();
      paramString.put(arrayOfString[i], localHashMap2);
      i += 1;
    }
    paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
    return localHashMap1;
  }
  
  static final class zza
  {
    public final Object mValue;
    public final String zzBp;
    
    zza(String paramString, Object paramObject)
    {
      this.zzBp = paramString;
      this.mValue = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      do
      {
        return false;
        paramObject = (zza)paramObject;
      } while ((!this.zzBp.equals(((zza)paramObject).zzBp)) || (!this.mValue.equals(((zza)paramObject).mValue)));
      return true;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(this.zzBp.hashCode()), Integer.valueOf(this.mValue.hashCode()) });
    }
    
    public String toString()
    {
      String str1 = this.zzBp;
      String str2 = String.valueOf(this.mValue.toString());
      return String.valueOf(str1).length() + 13 + String.valueOf(str2).length() + "Key: " + str1 + " value: " + str2;
    }
  }
  
  static abstract interface zzb
  {
    public abstract void zzae(Map<String, Object> paramMap);
  }
  
  static abstract interface zzc
  {
    public abstract void zza(zza paramzza);
    
    public abstract void zza(List<DataLayer.zza> paramList, long paramLong);
    
    public abstract void zzjJ(String paramString);
    
    public static abstract interface zza
    {
      public abstract void zzae(List<DataLayer.zza> paramList);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */