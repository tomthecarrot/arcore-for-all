package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public abstract class zzc
{
  protected final DataHolder zzaML;
  protected int zzaPH;
  private int zzaPI;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zzaML = ((DataHolder)zzac.zzC(paramDataHolder));
    zzfL(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzaa.equal(Integer.valueOf(((zzc)paramObject).zzaPH), Integer.valueOf(this.zzaPH)))
      {
        bool1 = bool2;
        if (zzaa.equal(Integer.valueOf(((zzc)paramObject).zzaPI), Integer.valueOf(this.zzaPI)))
        {
          bool1 = bool2;
          if (((zzc)paramObject).zzaML == this.zzaML) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.zzaML.getBoolean(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.zzaML.getByteArray(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected double getDouble(String paramString)
  {
    return this.zzaML.getDouble(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected float getFloat(String paramString)
  {
    return this.zzaML.getFloat(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected int getInteger(String paramString)
  {
    return this.zzaML.getInteger(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected long getLong(String paramString)
  {
    return this.zzaML.getLong(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected String getString(String paramString)
  {
    return this.zzaML.getString(paramString, this.zzaPH, this.zzaPI);
  }
  
  public boolean hasColumn(String paramString)
  {
    return this.zzaML.hasColumn(paramString);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzaPH), Integer.valueOf(this.zzaPI), this.zzaML });
  }
  
  public boolean isDataValid()
  {
    return !this.zzaML.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zzaML.copyToBuffer(paramString, this.zzaPH, this.zzaPI, paramCharArrayBuffer);
  }
  
  protected Uri zzcQ(String paramString)
  {
    return this.zzaML.parseUri(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected boolean zzcR(String paramString)
  {
    return this.zzaML.hasNull(paramString, this.zzaPH, this.zzaPI);
  }
  
  protected void zzfL(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzaML.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzav(bool);
      this.zzaPH = paramInt;
      this.zzaPI = this.zzaML.zzfN(this.zzaPH);
      return;
    }
  }
  
  protected int zzzb()
  {
    return this.zzaPH;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/data/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */