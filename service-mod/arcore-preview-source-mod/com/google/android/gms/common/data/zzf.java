package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzaPZ = false;
  private ArrayList<Integer> zzaQa;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzzh()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.zzaPZ) {
          break label204;
        }
        int j = this.zzaML.getCount();
        this.zzaQa = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        this.zzaQa.add(Integer.valueOf(0));
        String str3 = zzzg();
        i = this.zzaML.zzfN(0);
        String str1 = this.zzaML.getString(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = this.zzaML.zzfN(i);
        str2 = this.zzaML.getString(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.zzaQa.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        this.zzaPZ = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzzh();
    return (T)zzz(zzfP(paramInt), zzfQ(paramInt));
  }
  
  public int getCount()
  {
    zzzh();
    return this.zzaQa.size();
  }
  
  int zzfP(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zzaQa.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.zzaQa.get(paramInt)).intValue();
  }
  
  protected int zzfQ(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.zzaQa.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.zzaQa.size() - 1) {}
    for (int i = this.zzaML.getCount() - ((Integer)this.zzaQa.get(paramInt)).intValue();; i = ((Integer)this.zzaQa.get(paramInt + 1)).intValue() - ((Integer)this.zzaQa.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzfP(paramInt);
      int k = this.zzaML.zzfN(paramInt);
      String str = zzzi();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.zzaML.getString(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T zzz(int paramInt1, int paramInt2);
  
  protected abstract String zzzg();
  
  protected String zzzi()
  {
    return null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/data/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */