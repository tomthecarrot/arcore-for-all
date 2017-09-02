package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class zzabs
  extends zza
  implements FastJsonResponse.FieldConverter<String, Integer>
{
  public static final Parcelable.Creator<zzabs> CREATOR = new zzabt();
  final int mVersionCode;
  private final HashMap<String, Integer> zzaTo;
  private final SparseArray<String> zzaTp;
  private final ArrayList<zza> zzaTq;
  
  public zzabs()
  {
    this.mVersionCode = 1;
    this.zzaTo = new HashMap();
    this.zzaTp = new SparseArray();
    this.zzaTq = null;
  }
  
  zzabs(int paramInt, ArrayList<zza> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzaTo = new HashMap();
    this.zzaTp = new SparseArray();
    this.zzaTq = null;
    zzh(paramArrayList);
  }
  
  private void zzh(ArrayList<zza> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zza localzza = (zza)paramArrayList.next();
      zzl(localzza.stringValue, localzza.zzaTr);
    }
  }
  
  public int getTypeIn()
  {
    return 7;
  }
  
  public int getTypeOut()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzabt.zza(this, paramParcel, paramInt);
  }
  
  ArrayList<zza> zzAn()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzaTo.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zza(str, ((Integer)this.zzaTo.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public Integer zzdd(String paramString)
  {
    Integer localInteger = (Integer)this.zzaTo.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = (Integer)this.zzaTo.get("gms_unknown");
    }
    return paramString;
  }
  
  public String zze(Integer paramInteger)
  {
    String str = (String)this.zzaTp.get(paramInteger.intValue());
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.zzaTo.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public zzabs zzl(String paramString, int paramInt)
  {
    this.zzaTo.put(paramString, Integer.valueOf(paramInt));
    this.zzaTp.put(paramInt, paramString);
    return this;
  }
  
  public static final class zza
    extends zza
  {
    public static final Parcelable.Creator<zza> CREATOR = new zzabu();
    final String stringValue;
    final int versionCode;
    final int zzaTr;
    
    zza(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.stringValue = paramString;
      this.zzaTr = paramInt2;
    }
    
    zza(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.stringValue = paramString;
      this.zzaTr = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzabu.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */