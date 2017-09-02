package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public class zzc<T, R extends AbstractDataBuffer<T>,  extends Result>
  extends zzf<R>
  implements DataBuffer<T>
{
  public void close()
  {
    ((AbstractDataBuffer)zzxf()).close();
  }
  
  public T get(int paramInt)
  {
    return (T)((AbstractDataBuffer)zzxf()).get(paramInt);
  }
  
  public int getCount()
  {
    return ((AbstractDataBuffer)zzxf()).getCount();
  }
  
  public boolean isClosed()
  {
    return ((AbstractDataBuffer)zzxf()).isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return ((AbstractDataBuffer)zzxf()).iterator();
  }
  
  public void release()
  {
    ((AbstractDataBuffer)zzxf()).release();
  }
  
  public Iterator<T> singleRefIterator()
  {
    return ((AbstractDataBuffer)zzxf()).singleRefIterator();
  }
  
  public Bundle zzwW()
  {
    return ((AbstractDataBuffer)zzxf()).zzwW();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */