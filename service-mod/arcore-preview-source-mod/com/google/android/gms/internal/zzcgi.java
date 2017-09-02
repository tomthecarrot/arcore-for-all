package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzcgi
{
  final int tag;
  final byte[] zzbTg;
  
  zzcgi(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbTg = paramArrayOfByte;
  }
  
  int computeSerializedSize()
  {
    return zzcfy.zzBG(this.tag) + 0 + this.zzbTg.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzcgi)) {
        return false;
      }
      paramObject = (zzcgi)paramObject;
    } while ((this.tag == ((zzcgi)paramObject).tag) && (Arrays.equals(this.zzbTg, ((zzcgi)paramObject).zzbTg)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.zzbTg);
  }
  
  void writeTo(zzcfy paramzzcfy)
    throws IOException
  {
    paramzzcfy.zzBF(this.tag);
    paramzzcfy.zzav(this.zzbTg);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */