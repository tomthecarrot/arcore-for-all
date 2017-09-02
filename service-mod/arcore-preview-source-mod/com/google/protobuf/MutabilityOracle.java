package com.google.protobuf;

abstract interface MutabilityOracle
{
  public static final MutabilityOracle IMMUTABLE = new MutabilityOracle()
  {
    public void ensureMutable()
    {
      throw new UnsupportedOperationException();
    }
  };
  
  public abstract void ensureMutable();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/MutabilityOracle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */