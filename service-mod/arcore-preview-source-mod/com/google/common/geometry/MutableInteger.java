package com.google.common.geometry;

public class MutableInteger
{
  private Integer cachedIntegerValue = null;
  private int value;
  
  public MutableInteger(int paramInt)
  {
    this.value = paramInt;
  }
  
  public void add(int paramInt)
  {
    setValue(this.value + paramInt);
  }
  
  public void decrement()
  {
    subtract(1);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MutableInteger)) && (((MutableInteger)paramObject).value == this.value);
  }
  
  public int hashCode()
  {
    return integerValue().hashCode();
  }
  
  public void increment()
  {
    add(1);
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public Integer integerValue()
  {
    if (this.cachedIntegerValue == null) {
      this.cachedIntegerValue = Integer.valueOf(intValue());
    }
    return this.cachedIntegerValue;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
    this.cachedIntegerValue = null;
  }
  
  public void subtract(int paramInt)
  {
    add(paramInt * -1);
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/MutableInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */