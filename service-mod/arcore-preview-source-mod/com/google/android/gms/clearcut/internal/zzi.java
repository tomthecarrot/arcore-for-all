package com.google.android.gms.clearcut.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger.LogSampler;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabz;
import com.google.android.gms.internal.zzaca;
import com.google.android.gms.internal.zzbtf;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class zzi
  implements ClearcutLogger.LogSampler
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  static Boolean zzaJH = null;
  final zza zzaJI;
  
  public zzi()
  {
    this(new zza(null));
  }
  
  public zzi(Context paramContext)
  {
    this(new zza(paramContext));
  }
  
  zzi(zza paramzza)
  {
    this.zzaJI = ((zza)zzac.zzC(paramzza));
  }
  
  static long zzM(long paramLong)
  {
    return zzd.zzp(ByteBuffer.allocate(8).putLong(paramLong).array());
  }
  
  static boolean zza(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      throw new IllegalArgumentException(72 + "negative values not supported: " + paramLong2 + "/" + paramLong3);
    }
    return (paramLong3 > 0L) && (zzk.zzf(paramLong1, paramLong3) < paramLong2);
  }
  
  static zzb zzcG(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String str = "";
    int j = paramString.indexOf(',');
    if (j >= 0)
    {
      str = paramString.substring(0, j);
      i = j + 1;
    }
    j = paramString.indexOf('/', i);
    if (j <= 0)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to parse the rule: ".concat(paramString);; paramString = new String("Failed to parse the rule: "))
      {
        Log.e("LogSamplerImpl", paramString);
        return null;
      }
    }
    try
    {
      l1 = Long.parseLong(paramString.substring(i, j));
      l2 = Long.parseLong(paramString.substring(j + 1));
      if ((l1 < 0L) || (l2 < 0L))
      {
        Log.e("LogSamplerImpl", 72 + "negative values not supported: " + l1 + "/" + l2);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      long l2;
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "parseLong() failed while parsing: ".concat(paramString);; paramString = new String("parseLong() failed while parsing: "))
      {
        Log.e("LogSamplerImpl", paramString, localNumberFormatException);
        return null;
      }
      return new zzb(localNumberFormatException, l1, l2);
    }
  }
  
  static long zzd(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return zzM(paramLong);
    }
    paramString = paramString.getBytes(UTF_8);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length + 8);
    localByteBuffer.put(paramString);
    localByteBuffer.putLong(paramLong);
    return zzd.zzp(localByteBuffer.array());
  }
  
  public boolean shouldLog(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {}
    for (;;)
    {
      if (paramString == null) {}
      long l;
      do
      {
        return true;
        if (paramInt < 0) {
          break label73;
        }
        paramString = String.valueOf(paramInt);
        break;
        l = this.zzaJI.zzwJ();
        paramString = zzcG(this.zzaJI.zzcH(paramString));
      } while (paramString == null);
      return zza(zzd(paramString.zzaJJ, l), paramString.zzaJK, paramString.zzaJL);
      label73:
      paramString = null;
    }
  }
  
  static class zza
  {
    final ContentResolver mContentResolver;
    
    zza(Context paramContext)
    {
      if ((paramContext == null) || (!zzaL(paramContext)))
      {
        this.mContentResolver = null;
        return;
      }
      this.mContentResolver = paramContext.getContentResolver();
      zzbtf.zzb(this.mContentResolver, new String[] { "gms:playlog:service:sampling_" });
    }
    
    private static boolean zzaL(Context paramContext)
    {
      if (zzi.zzaJH == null) {
        if (zzaca.zzbp(paramContext).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        zzi.zzaJH = Boolean.valueOf(bool);
        return zzi.zzaJH.booleanValue();
      }
    }
    
    String zzcH(String paramString)
    {
      if (this.mContentResolver == null) {
        return null;
      }
      ContentResolver localContentResolver = this.mContentResolver;
      String str = String.valueOf("gms:playlog:service:sampling_");
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = str.concat(paramString);; paramString = new String(str)) {
        return zzbtf.zza(localContentResolver, paramString, null);
      }
    }
    
    long zzwJ()
    {
      if (this.mContentResolver == null) {
        return 0L;
      }
      return zzbtf.getLong(this.mContentResolver, "android_id", 0L);
    }
  }
  
  static class zzb
  {
    public final String zzaJJ;
    public final long zzaJK;
    public final long zzaJL;
    
    public zzb(String paramString, long paramLong1, long paramLong2)
    {
      this.zzaJJ = paramString;
      this.zzaJK = paramLong1;
      this.zzaJL = paramLong2;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */