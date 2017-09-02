package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzbpf
{
  private final List<zzbpa> zzcBA = new ArrayList();
  
  public String getId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.zzcBA.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      zzbpa localzzbpa = (zzbpa)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localzzbpa.getContainerId());
        break;
        localStringBuilder.append("#");
      }
    }
    return localStringBuilder.toString();
  }
  
  public zzbpf zza(zzbpa paramzzbpa)
    throws IllegalArgumentException
  {
    zzac.zzC(paramzzbpa);
    Iterator localIterator = this.zzcBA.iterator();
    while (localIterator.hasNext()) {
      if (((zzbpa)localIterator.next()).getContainerId().equals(paramzzbpa.getContainerId()))
      {
        paramzzbpa = String.valueOf(paramzzbpa.getContainerId());
        if (paramzzbpa.length() != 0) {}
        for (paramzzbpa = "The container is already being requested. ".concat(paramzzbpa);; paramzzbpa = new String("The container is already being requested. ")) {
          throw new IllegalArgumentException(paramzzbpa);
        }
      }
    }
    this.zzcBA.add(paramzzbpa);
    return this;
  }
  
  public List<zzbpa> zzaan()
  {
    return this.zzcBA;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */