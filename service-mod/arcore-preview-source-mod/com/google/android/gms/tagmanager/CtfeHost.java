package com.google.android.gms.tagmanager;

class CtfeHost
{
  private String zzctL = "https://www.googletagmanager.com";
  
  public String getCtfeServerAddress()
  {
    return this.zzctL;
  }
  
  public void setCtfeServerAddress(String paramString)
  {
    this.zzctL = paramString;
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "The Ctfe server endpoint was changed to: ".concat(paramString);; paramString = new String("The Ctfe server endpoint was changed to: "))
    {
      Log.i(paramString);
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/CtfeHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */