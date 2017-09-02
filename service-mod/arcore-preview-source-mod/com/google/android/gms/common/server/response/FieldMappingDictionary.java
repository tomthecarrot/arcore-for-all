package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<FieldMappingDictionary> CREATOR = new zzb();
  final int mVersionCode;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzaTS;
  private final ArrayList<Entry> zzaTT;
  private final String zzaTU;
  
  FieldMappingDictionary(int paramInt, ArrayList<Entry> paramArrayList, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaTT = null;
    this.zzaTS = zzi(paramArrayList);
    this.zzaTU = ((String)zzac.zzC(paramString));
    linkFields();
  }
  
  public FieldMappingDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    this.mVersionCode = 1;
    this.zzaTT = null;
    this.zzaTS = new HashMap();
    this.zzaTU = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzi(ArrayList<Entry> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Entry localEntry = (Entry)paramArrayList.get(i);
      localHashMap.put(localEntry.className, localEntry.zzAr());
      i += 1;
    }
    return localHashMap;
  }
  
  public void copyInternalFieldMappings()
  {
    Iterator localIterator1 = this.zzaTS.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)this.zzaTS.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).copyForDictionary());
      }
      this.zzaTS.put(str1, localHashMap);
    }
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> paramClass)
  {
    return (Map)this.zzaTS.get(paramClass.getCanonicalName());
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(String paramString)
  {
    return (Map)this.zzaTS.get(paramString);
  }
  
  public String getRootClassName()
  {
    return this.zzaTU;
  }
  
  public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> paramClass)
  {
    return this.zzaTS.containsKey(paramClass.getCanonicalName());
  }
  
  public void linkFields()
  {
    Iterator localIterator1 = this.zzaTS.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.zzaTS.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).setFieldMappingDictionary(this);
      }
    }
  }
  
  public void put(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.zzaTS.put(paramClass.getCanonicalName(), paramMap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.zzaTS.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)this.zzaTS.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  ArrayList<Entry> zzAq()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzaTS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, (Map)this.zzaTS.get(str)));
    }
    return localArrayList;
  }
  
  public static class Entry
    extends com.google.android.gms.common.internal.safeparcel.zza
  {
    public static final Parcelable.Creator<Entry> CREATOR = new zzc();
    final String className;
    final int versionCode;
    final ArrayList<FieldMappingDictionary.FieldMapPair> zzaTV;
    
    Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.zzaTV = paramArrayList;
    }
    
    Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.zzaTV = zzY(paramMap);
    }
    
    private static ArrayList<FieldMappingDictionary.FieldMapPair> zzY(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      if (paramMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
      return localArrayList;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc.zza(this, paramParcel, paramInt);
    }
    
    HashMap<String, FastJsonResponse.Field<?, ?>> zzAr()
    {
      HashMap localHashMap = new HashMap();
      int j = this.zzaTV.size();
      int i = 0;
      while (i < j)
      {
        FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)this.zzaTV.get(i);
        localHashMap.put(localFieldMapPair.zzaA, localFieldMapPair.zzaTW);
        i += 1;
      }
      return localHashMap;
    }
  }
  
  public static class FieldMapPair
    extends com.google.android.gms.common.internal.safeparcel.zza
  {
    public static final Parcelable.Creator<FieldMapPair> CREATOR = new zza();
    final int versionCode;
    final String zzaA;
    final FastJsonResponse.Field<?, ?> zzaTW;
    
    FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      this.versionCode = paramInt;
      this.zzaA = paramString;
      this.zzaTW = paramField;
    }
    
    FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      this.versionCode = 1;
      this.zzaA = paramString;
      this.zzaTW = paramField;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/FieldMappingDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */