package com.google.android.gms.tagmanager;

class zzcv
  extends Number
  implements Comparable<zzcv>
{
  private double zzcwQ;
  private long zzcwR;
  private boolean zzcwS;
  
  private zzcv(double paramDouble)
  {
    this.zzcwQ = paramDouble;
    this.zzcwS = false;
  }
  
  private zzcv(long paramLong)
  {
    this.zzcwR = paramLong;
    this.zzcwS = true;
  }
  
  public static zzcv zza(Double paramDouble)
  {
    return new zzcv(paramDouble.doubleValue());
  }
  
  public static zzcv zzaR(long paramLong)
  {
    return new zzcv(paramLong);
  }
  
  public static zzcv zzjZ(String paramString)
    throws NumberFormatException
  {
    try
    {
      zzcv localzzcv1 = new zzcv(Long.parseLong(paramString));
      return localzzcv1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        zzcv localzzcv2 = new zzcv(Double.parseDouble(paramString));
        return localzzcv2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(String.valueOf(paramString).concat(" is not a valid TypedNumber"));
      }
    }
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (zzYB()) {
      return this.zzcwR;
    }
    return this.zzcwQ;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzcv)) && (zza((zzcv)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return zzYD();
  }
  
  public long longValue()
  {
    return zzYC();
  }
  
  public short shortValue()
  {
    return zzYE();
  }
  
  public String toString()
  {
    if (zzYB()) {
      return Long.toString(this.zzcwR);
    }
    return Double.toString(this.zzcwQ);
  }
  
  public boolean zzYA()
  {
    return !zzYB();
  }
  
  public boolean zzYB()
  {
    return this.zzcwS;
  }
  
  public long zzYC()
  {
    if (zzYB()) {
      return this.zzcwR;
    }
    return this.zzcwQ;
  }
  
  public int zzYD()
  {
    return (int)longValue();
  }
  
  public short zzYE()
  {
    return (short)(int)longValue();
  }
  
  public int zza(zzcv paramzzcv)
  {
    if ((zzYB()) && (paramzzcv.zzYB())) {
      return new Long(this.zzcwR).compareTo(Long.valueOf(paramzzcv.zzcwR));
    }
    return Double.compare(doubleValue(), paramzzcv.doubleValue());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */