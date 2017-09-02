package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.internal.zzc;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class zzf
  extends zza
{
  public static final Parcelable.Creator<zzf> CREATOR = new zzg();
  public static final Comparator<zzd> zzbDc = new Comparator()
  {
    public int zza(zzd paramAnonymouszzd1, zzd paramAnonymouszzd2)
    {
      int i = paramAnonymouszzd1.getActivityType();
      int j = paramAnonymouszzd2.getActivityType();
      if (i != j) {
        if (i >= j) {}
      }
      do
      {
        return -1;
        return 1;
        i = paramAnonymouszzd1.zzKf();
        j = paramAnonymouszzd2.zzKf();
        if (i == j) {
          return 0;
        }
      } while (i < j);
      return 1;
    }
  };
  @Nullable
  private final String mTag;
  private final List<zzd> zzbDd;
  private final List<zzc> zzbDe;
  
  public zzf(List<zzd> paramList, @Nullable String paramString, @Nullable List<zzc> paramList1)
  {
    zzac.zzb(paramList, "transitions can't be null");
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      zzac.zzb(bool, "transitions can't be empty.");
      zzO(paramList);
      this.zzbDd = Collections.unmodifiableList(paramList);
      this.mTag = paramString;
      if (paramList1 != null) {
        break label67;
      }
    }
    label67:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList1))
    {
      this.zzbDe = paramList;
      return;
      bool = false;
      break;
    }
  }
  
  private static void zzO(List<zzd> paramList)
  {
    TreeSet localTreeSet = new TreeSet(zzbDc);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzd localzzd = (zzd)paramList.next();
      zzac.zzb(localTreeSet.add(localzzd), String.format("Found duplicated transition: %s.", new Object[] { localzzd }));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zzf)paramObject;
    } while ((zzaa.equal(this.zzbDd, ((zzf)paramObject).zzbDd)) && (zzaa.equal(this.mTag, ((zzf)paramObject).mTag)) && (zzaa.equal(this.zzbDe, ((zzf)paramObject).zzbDe)));
    return false;
  }
  
  @Nullable
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.zzbDd.hashCode();
    if (this.mTag != null) {}
    for (int i = this.mTag.hashCode();; i = 0)
    {
      if (this.zzbDe != null) {
        j = this.zzbDe.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    String str1 = String.valueOf(this.zzbDd);
    String str2 = this.mTag;
    String str3 = String.valueOf(this.zzbDe);
    return String.valueOf(str1).length() + 61 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ActivityTransitionRequest [mTransitions=" + str1 + ", mTag='" + str2 + "'" + ", mClients=" + str3 + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public List<zzd> zzKg()
  {
    return this.zzbDd;
  }
  
  public List<zzc> zzKh()
  {
    return this.zzbDe;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */