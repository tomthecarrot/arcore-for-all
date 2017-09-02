package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@Beta
@GwtCompatible
public abstract class Escaper
{
  private final Function<String, String> asFunction = new Function()
  {
    public String apply(String paramAnonymousString)
    {
      return Escaper.this.escape(paramAnonymousString);
    }
  };
  
  public final Function<String, String> asFunction()
  {
    return this.asFunction;
  }
  
  public abstract String escape(String paramString);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/escape/Escaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */