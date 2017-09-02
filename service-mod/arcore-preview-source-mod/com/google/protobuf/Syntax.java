package com.google.protobuf;

public enum Syntax
  implements Internal.EnumLite
{
  SYNTAX_PROTO2(0),  SYNTAX_PROTO3(1),  UNRECOGNIZED(-1);
  
  public static final int SYNTAX_PROTO2_VALUE = 0;
  public static final int SYNTAX_PROTO3_VALUE = 1;
  private static final Internal.EnumLiteMap<Syntax> internalValueMap = new Internal.EnumLiteMap()
  {
    public Syntax findValueByNumber(int paramAnonymousInt)
    {
      return Syntax.forNumber(paramAnonymousInt);
    }
  };
  private final int value;
  
  private Syntax(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Syntax forNumber(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return SYNTAX_PROTO2;
    }
    return SYNTAX_PROTO3;
  }
  
  public static Internal.EnumLiteMap<Syntax> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  @Deprecated
  public static Syntax valueOf(int paramInt)
  {
    return forNumber(paramInt);
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Syntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */