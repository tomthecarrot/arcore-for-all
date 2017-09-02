package com.google.android.gms.common.server.response;

import android.content.ContentValues;

public abstract class FastContentValuesJsonResponse
  extends FastJsonResponse
{
  private final ContentValues zzaTs;
  
  public FastContentValuesJsonResponse()
  {
    this.zzaTs = new ContentValues();
  }
  
  public FastContentValuesJsonResponse(ContentValues paramContentValues)
  {
    this.zzaTs = paramContentValues;
  }
  
  protected Object getValueObject(String paramString)
  {
    return this.zzaTs.get(paramString);
  }
  
  public ContentValues getValues()
  {
    return this.zzaTs;
  }
  
  protected boolean isPrimitiveFieldSet(String paramString)
  {
    return this.zzaTs.containsKey(paramString);
  }
  
  protected void setBoolean(String paramString, boolean paramBoolean)
  {
    this.zzaTs.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  protected void setDecodedBytes(String paramString, byte[] paramArrayOfByte)
  {
    this.zzaTs.put(paramString, paramArrayOfByte);
  }
  
  protected void setDouble(String paramString, double paramDouble)
  {
    this.zzaTs.put(paramString, Double.valueOf(paramDouble));
  }
  
  protected void setFloat(String paramString, float paramFloat)
  {
    this.zzaTs.put(paramString, Float.valueOf(paramFloat));
  }
  
  protected void setInteger(String paramString, int paramInt)
  {
    this.zzaTs.put(paramString, Integer.valueOf(paramInt));
  }
  
  protected void setLong(String paramString, long paramLong)
  {
    this.zzaTs.put(paramString, Long.valueOf(paramLong));
  }
  
  protected void setString(String paramString1, String paramString2)
  {
    this.zzaTs.put(paramString1, paramString2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/FastContentValuesJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */