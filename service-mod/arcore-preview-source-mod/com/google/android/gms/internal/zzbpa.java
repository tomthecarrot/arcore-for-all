package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;

public class zzbpa
{
  @Nullable
  private final String zzcAd;
  private final boolean zzcAe;
  @Nullable
  private final Integer zzcBt;
  private final String zzcaK;
  @Nullable
  private final String zzcvL;
  
  public zzbpa(String paramString1, Integer paramInteger, String paramString2, boolean paramBoolean)
  {
    this(paramString1, paramInteger, paramString2, paramBoolean, "");
  }
  
  public zzbpa(String paramString1, Integer paramInteger, String paramString2, boolean paramBoolean, String paramString3)
  {
    zzac.zzC(paramString1);
    zzac.zzC(paramString3);
    this.zzcaK = paramString1;
    this.zzcBt = paramInteger;
    this.zzcAd = paramString2;
    this.zzcAe = paramBoolean;
    this.zzcvL = paramString3;
  }
  
  public String getContainerId()
  {
    return this.zzcaK;
  }
  
  public String zzZA()
  {
    return this.zzcvL;
  }
  
  public String zzZw()
  {
    return this.zzcAd;
  }
  
  public String zzZx()
  {
    if (this.zzcAd != null)
    {
      String str1 = this.zzcAd;
      String str2 = this.zzcaK;
      return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "_" + str2;
    }
    return this.zzcaK;
  }
  
  public boolean zzZy()
  {
    return this.zzcAe;
  }
  
  public Integer zzaam()
  {
    return this.zzcBt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */