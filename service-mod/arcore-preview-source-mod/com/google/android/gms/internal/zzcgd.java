package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzcgd
  implements Cloneable
{
  private zzcga<?, ?> Gf;
  private List<zzcgi> Gg = new ArrayList();
  private Object value;
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[computeSerializedSize()];
    writeTo(zzcfy.zzas(arrayOfByte));
    return arrayOfByte;
  }
  
  int computeSerializedSize()
  {
    int j;
    if (this.value != null)
    {
      j = this.Gf.zzbh(this.value);
      return j;
    }
    Iterator localIterator = this.Gg.iterator();
    for (int i = 0;; i = ((zzcgi)localIterator.next()).computeSerializedSize() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzcgd));
      paramObject = (zzcgd)paramObject;
      if ((this.value == null) || (((zzcgd)paramObject).value == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.Gf != ((zzcgd)paramObject).Gf);
    if (!this.Gf.vR.isArray()) {
      return this.value.equals(((zzcgd)paramObject).value);
    }
    if ((this.value instanceof byte[])) {
      return Arrays.equals((byte[])this.value, (byte[])((zzcgd)paramObject).value);
    }
    if ((this.value instanceof int[])) {
      return Arrays.equals((int[])this.value, (int[])((zzcgd)paramObject).value);
    }
    if ((this.value instanceof long[])) {
      return Arrays.equals((long[])this.value, (long[])((zzcgd)paramObject).value);
    }
    if ((this.value instanceof float[])) {
      return Arrays.equals((float[])this.value, (float[])((zzcgd)paramObject).value);
    }
    if ((this.value instanceof double[])) {
      return Arrays.equals((double[])this.value, (double[])((zzcgd)paramObject).value);
    }
    if ((this.value instanceof boolean[])) {
      return Arrays.equals((boolean[])this.value, (boolean[])((zzcgd)paramObject).value);
    }
    return Arrays.deepEquals((Object[])this.value, (Object[])((zzcgd)paramObject).value);
    if ((this.Gg != null) && (((zzcgd)paramObject).Gg != null)) {
      return this.Gg.equals(((zzcgd)paramObject).Gg);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzcgd)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void writeTo(zzcfy paramzzcfy)
    throws IOException
  {
    if (this.value != null) {
      this.Gf.zza(this.value, paramzzcfy);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.Gg.iterator();
      while (localIterator.hasNext()) {
        ((zzcgi)localIterator.next()).writeTo(paramzzcfy);
      }
    }
  }
  
  zzcgi zzBM(int paramInt)
  {
    if (this.Gg == null) {}
    while (paramInt >= this.Gg.size()) {
      return null;
    }
    return (zzcgi)this.Gg.get(paramInt);
  }
  
  void zza(zzcgi paramzzcgi)
  {
    this.Gg.add(paramzzcgi);
  }
  
  public final zzcgd zzane()
  {
    zzcgd localzzcgd = new zzcgd();
    try
    {
      localzzcgd.Gf = this.Gf;
      if (this.Gg == null) {
        localzzcgd.Gg = null;
      }
      while (this.value == null)
      {
        return localzzcgd;
        localzzcgd.Gg.addAll(this.Gg);
      }
      if (!(this.value instanceof zzcgg)) {
        break label93;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.value = ((zzcgg)((zzcgg)this.value).clone());
    return localCloneNotSupportedException;
    label93:
    if ((this.value instanceof byte[]))
    {
      localCloneNotSupportedException.value = ((byte[])this.value).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.value instanceof byte[][]))
    {
      localObject1 = (byte[][])this.value;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.value instanceof boolean[]))
    {
      localCloneNotSupportedException.value = ((boolean[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof int[]))
    {
      localCloneNotSupportedException.value = ((int[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof long[]))
    {
      localCloneNotSupportedException.value = ((long[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof float[]))
    {
      localCloneNotSupportedException.value = ((float[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof double[]))
    {
      localCloneNotSupportedException.value = ((double[])this.value).clone();
      return localCloneNotSupportedException;
    }
    if ((this.value instanceof zzcgg[]))
    {
      localObject1 = (zzcgg[])this.value;
      localObject2 = new zzcgg[localObject1.length];
      localCloneNotSupportedException.value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((zzcgg)localObject1[i].clone());
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  <T> T zzb(zzcga<?, T> paramzzcga)
  {
    if (this.value != null)
    {
      if (!this.Gf.equals(paramzzcga)) {
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
      }
    }
    else
    {
      this.Gf = paramzzcga;
      this.value = paramzzcga.zzay(this.Gg);
      this.Gg = null;
    }
    return (T)this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */