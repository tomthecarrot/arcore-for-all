package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzcga<M extends zzcfz<M>, T>
{
  protected final boolean Ga;
  public final int tag;
  protected final int type;
  protected final Class<T> vR;
  
  private zzcga(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.vR = paramClass;
    this.tag = paramInt2;
    this.Ga = paramBoolean;
  }
  
  public static <M extends zzcfz<M>, T extends zzcgg> zzcga<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzcga(paramInt, paramClass, (int)paramLong, false);
  }
  
  private T zzaA(List<zzcgi> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zzcgi)paramList.get(paramList.size() - 1);
    return (T)this.vR.cast(zzbd(zzcfx.zzar(paramList.zzbTg)));
  }
  
  private T zzaz(List<zzcgi> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (zzcgi)paramList.get(i);
      if (((zzcgi)localObject).zzbTg.length != 0) {
        zza((zzcgi)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.vR.cast(Array.newInstance(this.vR.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<zzcgi>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzcga)) {
        return false;
      }
      paramObject = (zzcga)paramObject;
    } while ((this.type == ((zzcga)paramObject).type) && (this.vR == ((zzcga)paramObject).vR) && (this.tag == ((zzcga)paramObject).tag) && (this.Ga == ((zzcga)paramObject).Ga));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.type;
    int k = this.vR.hashCode();
    int m = this.tag;
    if (this.Ga) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected void zza(zzcgi paramzzcgi, List<Object> paramList)
  {
    paramList.add(zzbd(zzcfx.zzar(paramzzcgi.zzbTg)));
  }
  
  void zza(Object paramObject, zzcfy paramzzcfy)
    throws IOException
  {
    if (this.Ga)
    {
      zzc(paramObject, paramzzcfy);
      return;
    }
    zzb(paramObject, paramzzcfy);
  }
  
  final T zzay(List<zzcgi> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.Ga) {
      return (T)zzaz(paramList);
    }
    return (T)zzaA(paramList);
  }
  
  protected void zzb(Object paramObject, zzcfy paramzzcfy)
  {
    for (;;)
    {
      try
      {
        paramzzcfy.zzBF(this.tag);
        switch (this.type)
        {
        case 10: 
          i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (zzcgg)paramObject;
      int i = zzcgj.zzBO(this.tag);
      paramzzcfy.zzb((zzcgg)paramObject);
      paramzzcfy.zzae(i, 4);
      return;
      paramzzcfy.zzc((zzcgg)paramObject);
      return;
    }
  }
  
  protected Object zzbd(zzcfx paramzzcfx)
  {
    Object localObject;
    if (this.Ga) {
      localObject = this.vR.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          int i = this.type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (InstantiationException paramzzcfx)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzcfx);
        localObject = this.vR;
        continue;
        zzcgg localzzcgg = (zzcgg)((Class)localObject).newInstance();
        paramzzcfx.zza(localzzcgg, zzcgj.zzBO(this.tag));
        return localzzcgg;
        localzzcgg = (zzcgg)((Class)localObject).newInstance();
        paramzzcfx.zza(localzzcgg);
        return localzzcgg;
      }
      catch (IllegalAccessException paramzzcfx)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramzzcfx);
      }
      catch (IOException paramzzcfx)
      {
        throw new IllegalArgumentException("Error reading extension field", paramzzcfx);
      }
    }
  }
  
  int zzbh(Object paramObject)
  {
    if (this.Ga) {
      return zzbi(paramObject);
    }
    return zzbj(paramObject);
  }
  
  protected int zzbi(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzbj(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int zzbj(Object paramObject)
  {
    int i = zzcgj.zzBO(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return zzcfy.zzb(i, (zzcgg)paramObject);
    }
    return zzcfy.zzc(i, (zzcgg)paramObject);
  }
  
  protected void zzc(Object paramObject, zzcfy paramzzcfy)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzzcfy);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */