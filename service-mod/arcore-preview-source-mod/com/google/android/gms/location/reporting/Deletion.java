package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Deletion
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Deletion> CREATOR = new zza();
  private final Account zzagc;
  private final long zzaie;
  private final long zzbHH;
  private final long zzbHI;
  
  public Deletion(Account paramAccount, long paramLong1, long paramLong2, long paramLong3)
  {
    this.zzagc = paramAccount;
    this.zzbHH = paramLong1;
    this.zzbHI = paramLong2;
    this.zzaie = paramLong3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Deletion)) {
        return false;
      }
      paramObject = (Deletion)paramObject;
    } while ((this.zzbHH == ((Deletion)paramObject).zzbHH) && (this.zzbHI == ((Deletion)paramObject).zzbHI) && (this.zzaie == ((Deletion)paramObject).zzaie) && (zzaa.equal(this.zzagc, ((Deletion)paramObject).zzagc)));
    return false;
  }
  
  public Account getAccount()
  {
    return this.zzagc;
  }
  
  public long getEndTimeMs()
  {
    return this.zzbHI;
  }
  
  public long getStartTimeMs()
  {
    return this.zzbHH;
  }
  
  public long getTimestampMs()
  {
    return this.zzaie;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzagc, Long.valueOf(this.zzbHH), Long.valueOf(this.zzbHI), Long.valueOf(this.zzaie) });
  }
  
  public String toString()
  {
    String str = String.valueOf(this.zzagc);
    long l1 = this.zzbHH;
    long l2 = this.zzbHI;
    long l3 = this.zzaie;
    return String.valueOf(str).length() + 122 + "Deletion{mAccount=" + str + ", mStartTimeMs=" + l1 + ", mEndTimeMs=" + l2 + ", mTimestampMs=" + l3 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/Deletion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */