package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zze;
import com.google.android.gms.common.util.zzaa;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzw;

public class WakeLock
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private static String zzcsI = "*gcore*:";
  private final Context mContext;
  private final String zzaUr;
  private final String zzaUt;
  private WorkSource zzbCT;
  private int zzbDF;
  private final PowerManager.WakeLock zzcsJ;
  private final int zzcsK;
  private final String zzcsL;
  private boolean zzcsM = true;
  private int zzcsN;
  
  public WakeLock(Context paramContext, int paramInt, String paramString) {}
  
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzac.zzi(paramString1, "Wake lock name can NOT be empty");
    this.zzcsK = paramInt;
    this.zzcsL = paramString2;
    this.zzaUt = paramString4;
    this.mContext = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf(zzcsI);
      paramString4 = String.valueOf(paramString1);
      if (paramString4.length() != 0) {
        paramString2 = paramString2.concat(paramString4);
      }
    }
    for (this.zzaUr = paramString2;; this.zzaUr = paramString1)
    {
      this.zzcsJ = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      if (zzaa.zzbm(this.mContext))
      {
        paramString1 = paramString3;
        if (zzw.zzdj(paramString3)) {
          paramString1 = paramContext.getPackageName();
        }
        this.zzbCT = zzaa.zzH(paramContext, paramString1);
        addWorkSource(this.zzbCT);
      }
      return;
      paramString2 = new String(paramString2);
      break;
    }
  }
  
  private void zzc(WorkSource paramWorkSource)
  {
    try
    {
      this.zzcsJ.setWorkSource(paramWorkSource);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      Log.wtf(TAG, paramWorkSource.toString());
    }
  }
  
  private void zzju(String paramString)
  {
    boolean bool = zzjv(paramString);
    paramString = zzp(paramString, bool);
    try
    {
      if (this.zzcsM)
      {
        int i = this.zzbDF - 1;
        this.zzbDF = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzcsM) || (this.zzcsN != 1)) {
          break label107;
        }
      }
      zze.zzAH().zza(this.mContext, zzc.zza(this.zzcsJ, paramString), 8, this.zzaUr, paramString, this.zzaUt, this.zzcsK, zzaa.zzb(this.zzbCT));
      this.zzcsN -= 1;
      label107:
      return;
    }
    finally {}
  }
  
  private boolean zzjv(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.zzcsL));
  }
  
  private void zzo(String paramString, long paramLong)
  {
    boolean bool = zzjv(paramString);
    paramString = zzp(paramString, bool);
    try
    {
      if (this.zzcsM)
      {
        int i = this.zzbDF;
        this.zzbDF = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzcsM) || (this.zzcsN != 0)) {
          break label113;
        }
      }
      zze.zzAH().zza(this.mContext, zzc.zza(this.zzcsJ, paramString), 7, this.zzaUr, paramString, this.zzaUt, this.zzcsK, zzaa.zzb(this.zzbCT), paramLong);
      this.zzcsN += 1;
      label113:
      return;
    }
    finally {}
  }
  
  private String zzp(String paramString, boolean paramBoolean)
  {
    if (this.zzcsM)
    {
      if (paramBoolean) {
        return paramString;
      }
      return this.zzcsL;
    }
    return this.zzcsL;
  }
  
  public void acquire()
  {
    zzo(null, 0L);
    this.zzcsJ.acquire();
  }
  
  public void acquire(long paramLong)
  {
    zzt.zzAR();
    zzo(null, paramLong);
    this.zzcsJ.acquire(paramLong);
  }
  
  public void acquire(String paramString)
  {
    zzo(paramString, 0L);
    this.zzcsJ.acquire();
  }
  
  public void acquire(String paramString, long paramLong)
  {
    zzt.zzAR();
    zzo(paramString, paramLong);
    this.zzcsJ.acquire(paramLong);
  }
  
  public void addWorkSource(WorkSource paramWorkSource)
  {
    if ((paramWorkSource != null) && (zzaa.zzbm(this.mContext)))
    {
      if (this.zzbCT == null) {
        break label39;
      }
      this.zzbCT.add(paramWorkSource);
    }
    for (;;)
    {
      zzc(this.zzbCT);
      return;
      label39:
      this.zzbCT = paramWorkSource;
    }
  }
  
  public PowerManager.WakeLock getWakeLock()
  {
    return this.zzcsJ;
  }
  
  public boolean isHeld()
  {
    return this.zzcsJ.isHeld();
  }
  
  public void release()
  {
    zzju(null);
    this.zzcsJ.release();
  }
  
  public void release(int paramInt)
  {
    zzju(null);
    this.zzcsJ.release(paramInt);
  }
  
  public void release(String paramString)
  {
    zzju(paramString);
    this.zzcsJ.release();
  }
  
  public void release(String paramString, int paramInt)
  {
    zzju(paramString);
    this.zzcsJ.release(paramInt);
  }
  
  public void removeWorkSource(WorkSource paramWorkSource)
  {
    if ((paramWorkSource != null) && (zzaa.zzbm(this.mContext)))
    {
      if (this.zzbCT != null) {
        this.zzbCT.remove(paramWorkSource);
      }
      zzc(this.zzbCT);
    }
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    this.zzcsJ.setReferenceCounted(paramBoolean);
    this.zzcsM = paramBoolean;
  }
  
  public void setWorkSource(WorkSource paramWorkSource)
  {
    if (zzaa.zzbm(this.mContext))
    {
      zzc(paramWorkSource);
      this.zzbCT = paramWorkSource;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/stats/WakeLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */