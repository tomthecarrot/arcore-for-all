package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzaPE;
  protected int zzaPF;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    this.zzaPE = ((DataBuffer)zzac.zzC(paramDataBuffer));
    this.zzaPF = -1;
  }
  
  public boolean hasNext()
  {
    return this.zzaPF < this.zzaPE.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext())
    {
      i = this.zzaPF;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    DataBuffer localDataBuffer = this.zzaPE;
    int i = this.zzaPF + 1;
    this.zzaPF = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/data/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */