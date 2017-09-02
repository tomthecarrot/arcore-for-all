package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated=true)
final class Platform
{
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal()
  {
    protected char[] initialValue()
    {
      return new char['Ѐ'];
    }
  };
  
  static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */