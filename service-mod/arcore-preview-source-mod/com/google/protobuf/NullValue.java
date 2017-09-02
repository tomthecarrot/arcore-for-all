package com.google.protobuf;

public enum NullValue
  implements Internal.EnumLite
{
  NULL_VALUE(0),  UNRECOGNIZED(-1);
  
  public static final int NULL_VALUE_VALUE = 0;
  private static final Internal.EnumLiteMap<NullValue> internalValueMap = new Internal.EnumLiteMap()
  {
    public NullValue findValueByNumber(int paramAnonymousInt)
    {
      return NullValue.forNumber(paramAnonymousInt);
    }
  };
  private final int value;
  
  private NullValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static NullValue forNumber(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return NULL_VALUE;
  }
  
  public static Internal.EnumLiteMap<NullValue> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static NullValue valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/NullValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */