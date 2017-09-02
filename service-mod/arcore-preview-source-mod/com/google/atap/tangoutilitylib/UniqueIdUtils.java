package com.google.atap.tangoutilitylib;

public class UniqueIdUtils
{
  static
  {
    System.loadLibrary("tango_utility_lib");
  }
  
  public static String generateId()
  {
    return nativeGenerateId();
  }
  
  public static boolean isValid(String paramString)
  {
    return nativeIsValid(paramString);
  }
  
  private static native String nativeGenerateId();
  
  private static native boolean nativeIsValid(String paramString);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/UniqueIdUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */