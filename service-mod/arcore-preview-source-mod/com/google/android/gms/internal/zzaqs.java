package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class zzaqs<T>
{
  private final int zzBo;
  private final String zzBp;
  private final T zzBq;
  
  private zzaqs(int paramInt, String paramString, T paramT)
  {
    this.zzBo = paramInt;
    this.zzBp = paramString;
    this.zzBq = paramT;
    zzaqw.zzGx().zza(this);
  }
  
  public static zza zzb(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new zza(paramInt, paramString, paramBoolean);
  }
  
  public static zzb zzb(int paramInt1, String paramString, int paramInt2)
  {
    return new zzb(paramInt1, paramString, Integer.valueOf(paramInt2));
  }
  
  public static zzc zzb(int paramInt, String paramString, long paramLong)
  {
    return new zzc(paramInt, paramString, Long.valueOf(paramLong));
  }
  
  public static zzd zzc(int paramInt, String paramString1, String paramString2)
  {
    return new zzd(paramInt, paramString1, paramString2);
  }
  
  public T get()
  {
    return (T)zzaqw.zzGy().zzb(this);
  }
  
  public T getDefault()
  {
    return (T)this.zzBq;
  }
  
  public String getKey()
  {
    return this.zzBp;
  }
  
  public int getSource()
  {
    return this.zzBo;
  }
  
  protected abstract T zza(zzaqv paramzzaqv);
  
  public static class zza
    extends zzaqs<Boolean>
  {
    public zza(int paramInt, String paramString, Boolean paramBoolean)
    {
      super(paramString, paramBoolean, null);
    }
    
    public Boolean zzb(zzaqv paramzzaqv)
    {
      try
      {
        boolean bool = paramzzaqv.getBooleanFlagValue(getKey(), ((Boolean)getDefault()).booleanValue(), getSource());
        return Boolean.valueOf(bool);
      }
      catch (RemoteException paramzzaqv) {}
      return (Boolean)getDefault();
    }
  }
  
  public static class zzb
    extends zzaqs<Integer>
  {
    public zzb(int paramInt, String paramString, Integer paramInteger)
    {
      super(paramString, paramInteger, null);
    }
    
    public Integer zzc(zzaqv paramzzaqv)
    {
      try
      {
        int i = paramzzaqv.getIntFlagValue(getKey(), ((Integer)getDefault()).intValue(), getSource());
        return Integer.valueOf(i);
      }
      catch (RemoteException paramzzaqv) {}
      return (Integer)getDefault();
    }
  }
  
  public static class zzc
    extends zzaqs<Long>
  {
    public zzc(int paramInt, String paramString, Long paramLong)
    {
      super(paramString, paramLong, null);
    }
    
    public Long zzd(zzaqv paramzzaqv)
    {
      try
      {
        long l = paramzzaqv.getLongFlagValue(getKey(), ((Long)getDefault()).longValue(), getSource());
        return Long.valueOf(l);
      }
      catch (RemoteException paramzzaqv) {}
      return (Long)getDefault();
    }
  }
  
  public static class zzd
    extends zzaqs<String>
  {
    public zzd(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1, paramString2, null);
    }
    
    public String zze(zzaqv paramzzaqv)
    {
      try
      {
        paramzzaqv = paramzzaqv.getStringFlagValue(getKey(), (String)getDefault(), getSource());
        return paramzzaqv;
      }
      catch (RemoteException paramzzaqv) {}
      return (String)getDefault();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */