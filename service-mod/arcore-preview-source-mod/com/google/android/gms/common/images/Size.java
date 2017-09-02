package com.google.android.gms.common.images;

public final class Size
{
  private final int zzrN;
  private final int zzrO;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zzrN = paramInt1;
    this.zzrO = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string must not be null");
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0) {
      throw zzcT(paramString);
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw zzcT(paramString);
    }
  }
  
  private static NumberFormatException zzcT(String paramString)
  {
    throw new NumberFormatException(String.valueOf(paramString).length() + 16 + "Invalid Size: \"" + paramString + "\"");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof Size));
    paramObject = (Size)paramObject;
    if ((this.zzrN == ((Size)paramObject).zzrN) && (this.zzrO == ((Size)paramObject).zzrO)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getHeight()
  {
    return this.zzrO;
  }
  
  public int getWidth()
  {
    return this.zzrN;
  }
  
  public int hashCode()
  {
    return this.zzrO ^ (this.zzrN << 16 | this.zzrN >>> 16);
  }
  
  public String toString()
  {
    int i = this.zzrN;
    int j = this.zzrO;
    return 23 + i + "x" + j;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/images/Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */