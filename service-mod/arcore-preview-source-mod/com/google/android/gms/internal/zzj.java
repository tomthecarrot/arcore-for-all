package com.google.android.gms.internal;

import java.util.Map;

public class zzj
{
  public final byte[] data;
  public final Map<String, String> headers;
  public final int statusCode;
  public final long zzA;
  public final boolean zzz;
  
  public zzj(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.headers = paramMap;
    this.zzz = paramBoolean;
    this.zzA = paramLong;
  }
  
  public zzj(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */