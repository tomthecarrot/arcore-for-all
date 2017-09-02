package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
class zzba<K, V>
  implements zzl<K, V>
{
  private LruCache<K, V> zzcuV;
  
  zzba(int paramInt, final zzm.zza<K, V> paramzza)
  {
    this.zzcuV = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return paramzza.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V get(K paramK)
  {
    return (V)this.zzcuV.get(paramK);
  }
  
  public void zzh(K paramK, V paramV)
  {
    this.zzcuV.put(paramK, paramV);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */