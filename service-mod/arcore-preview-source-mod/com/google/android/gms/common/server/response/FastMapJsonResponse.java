package com.google.android.gms.common.server.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastMapJsonResponse
  extends FastJsonResponse
{
  private final HashMap<String, Object> zzaTx = new HashMap();
  
  public Object getValueObject(String paramString)
  {
    return this.zzaTx.get(paramString);
  }
  
  public HashMap<String, Object> getValues()
  {
    return this.zzaTx;
  }
  
  protected boolean isPrimitiveFieldSet(String paramString)
  {
    return this.zzaTx.containsKey(paramString);
  }
  
  public void setBigDecimal(String paramString, BigDecimal paramBigDecimal)
  {
    this.zzaTx.put(paramString, paramBigDecimal);
  }
  
  public void setBigDecimals(String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setBigInteger(String paramString, BigInteger paramBigInteger)
  {
    this.zzaTx.put(paramString, paramBigInteger);
  }
  
  public void setBigIntegers(String paramString, ArrayList<BigInteger> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setBoolean(String paramString, boolean paramBoolean)
  {
    this.zzaTx.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void setBooleans(String paramString, ArrayList<Boolean> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setDecodedBytes(String paramString, byte[] paramArrayOfByte)
  {
    this.zzaTx.put(paramString, paramArrayOfByte);
  }
  
  public void setDouble(String paramString, double paramDouble)
  {
    this.zzaTx.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void setDoubles(String paramString, ArrayList<Double> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  protected void setFloat(String paramString, float paramFloat)
  {
    this.zzaTx.put(paramString, Float.valueOf(paramFloat));
  }
  
  protected void setFloats(String paramString, ArrayList<Float> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setInteger(String paramString, int paramInt)
  {
    this.zzaTx.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void setIntegers(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setLong(String paramString, long paramLong)
  {
    this.zzaTx.put(paramString, Long.valueOf(paramLong));
  }
  
  public void setLongs(String paramString, ArrayList<Long> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
  
  public void setString(String paramString1, String paramString2)
  {
    this.zzaTx.put(paramString1, paramString2);
  }
  
  public void setStringMap(String paramString, Map<String, String> paramMap)
  {
    this.zzaTx.put(paramString, paramMap);
  }
  
  public void setStrings(String paramString, ArrayList<String> paramArrayList)
  {
    this.zzaTx.put(paramString, paramArrayList);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/FastMapJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */