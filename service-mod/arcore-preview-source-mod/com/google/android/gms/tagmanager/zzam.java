package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzam
{
  private final long zzafb;
  private final long zzcuC;
  private final long zzcuD;
  private String zzcuE;
  
  zzam(long paramLong1, long paramLong2, long paramLong3)
  {
    this.zzcuC = paramLong1;
    this.zzafb = paramLong2;
    this.zzcuD = paramLong3;
  }
  
  long zzXH()
  {
    return this.zzcuC;
  }
  
  long zzXI()
  {
    return this.zzcuD;
  }
  
  String zzXJ()
  {
    return this.zzcuE;
  }
  
  void zzjO(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    this.zzcuE = paramString;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */