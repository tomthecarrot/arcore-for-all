package com.google.android.gms.internal;

public final class zzcgc
  implements Cloneable
{
  private static final zzcgd Gb = new zzcgd();
  private boolean Gc = false;
  private int[] Gd;
  private zzcgd[] Ge;
  private int mSize;
  
  zzcgc()
  {
    this(10);
  }
  
  zzcgc(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.Gd = new int[paramInt];
    this.Ge = new zzcgd[paramInt];
    this.mSize = 0;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private int zzBL(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.Gd[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzcgd[] paramArrayOfzzcgd1, zzcgd[] paramArrayOfzzcgd2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzcgd1[i].equals(paramArrayOfzzcgd2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzcgc)) {
        return false;
      }
      paramObject = (zzcgc)paramObject;
      if (size() != ((zzcgc)paramObject).size()) {
        return false;
      }
    } while ((zza(this.Gd, ((zzcgc)paramObject).Gd, this.mSize)) && (zza(this.Ge, ((zzcgc)paramObject).Ge, this.mSize)));
    return false;
  }
  
  public int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.Gd[i]) * 31 + this.Ge[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    return this.mSize;
  }
  
  zzcgd zzBJ(int paramInt)
  {
    paramInt = zzBL(paramInt);
    if ((paramInt < 0) || (this.Ge[paramInt] == Gb)) {
      return null;
    }
    return this.Ge[paramInt];
  }
  
  zzcgd zzBK(int paramInt)
  {
    return this.Ge[paramInt];
  }
  
  void zza(int paramInt, zzcgd paramzzcgd)
  {
    int i = zzBL(paramInt);
    if (i >= 0)
    {
      this.Ge[i] = paramzzcgd;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < this.mSize) && (this.Ge[i] == Gb))
    {
      this.Gd[i] = paramInt;
      this.Ge[i] = paramzzcgd;
      return;
    }
    if (this.mSize >= this.Gd.length)
    {
      int j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      zzcgd[] arrayOfzzcgd = new zzcgd[j];
      System.arraycopy(this.Gd, 0, arrayOfInt, 0, this.Gd.length);
      System.arraycopy(this.Ge, 0, arrayOfzzcgd, 0, this.Ge.length);
      this.Gd = arrayOfInt;
      this.Ge = arrayOfzzcgd;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.Gd, i, this.Gd, i + 1, this.mSize - i);
      System.arraycopy(this.Ge, i, this.Ge, i + 1, this.mSize - i);
    }
    this.Gd[i] = paramInt;
    this.Ge[i] = paramzzcgd;
    this.mSize += 1;
  }
  
  public final zzcgc zzand()
  {
    int j = size();
    zzcgc localzzcgc = new zzcgc(j);
    System.arraycopy(this.Gd, 0, localzzcgc.Gd, 0, j);
    int i = 0;
    while (i < j)
    {
      if (this.Ge[i] != null) {
        localzzcgc.Ge[i] = ((zzcgd)this.Ge[i].clone());
      }
      i += 1;
    }
    localzzcgc.mSize = j;
    return localzzcgc;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */