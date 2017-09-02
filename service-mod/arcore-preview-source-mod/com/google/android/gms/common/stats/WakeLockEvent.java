package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
  private final long mTimeout;
  final int mVersionCode;
  private final float zzaUA;
  private long zzaUB;
  private final long zzaUp;
  private int zzaUq;
  private final String zzaUr;
  private final String zzaUs;
  private final String zzaUt;
  private final int zzaUu;
  private final List<String> zzaUv;
  private final String zzaUw;
  private final long zzaUx;
  private int zzaUy;
  private final String zzaUz;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.zzaUp = paramLong1;
    this.zzaUq = paramInt2;
    this.zzaUr = paramString1;
    this.zzaUs = paramString3;
    this.zzaUt = paramString5;
    this.zzaUu = paramInt3;
    this.zzaUB = -1L;
    this.zzaUv = paramList;
    this.zzaUw = paramString2;
    this.zzaUx = paramLong2;
    this.zzaUy = paramInt4;
    this.zzaUz = paramString4;
    this.zzaUA = paramFloat;
    this.mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }
  
  public long getDurationMillis()
  {
    return this.zzaUB;
  }
  
  public int getEventType()
  {
    return this.zzaUq;
  }
  
  public long getTimeMillis()
  {
    return this.zzaUp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzAA()
  {
    return this.zzaUv;
  }
  
  public String zzAB()
  {
    return this.zzaUw;
  }
  
  public long zzAC()
  {
    return this.zzaUx;
  }
  
  public int zzAD()
  {
    return this.zzaUy;
  }
  
  public String zzAE()
  {
    return this.zzaUz;
  }
  
  public float zzAF()
  {
    return this.zzaUA;
  }
  
  public long zzAG()
  {
    return this.mTimeout;
  }
  
  public String zzAv()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzAw());
    String str7 = String.valueOf("\t");
    int i = zzAz();
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76:
    String str11;
    String str3;
    label94:
    String str12;
    float f;
    String str13;
    if (zzAA() == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = zzAD();
      str10 = String.valueOf("\t");
      if (zzAx() != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (zzAE() != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = zzAF();
      str13 = String.valueOf("\t");
      if (zzAy() != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = zzAy())
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", zzAA());
      break;
      str2 = zzAx();
      break label76;
      str3 = zzAE();
      break label94;
    }
  }
  
  public String zzAw()
  {
    return this.zzaUr;
  }
  
  public String zzAx()
  {
    return this.zzaUs;
  }
  
  public String zzAy()
  {
    return this.zzaUt;
  }
  
  public int zzAz()
  {
    return this.zzaUu;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/stats/WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */