package com.google.android.gms.internal;

import android.accounts.Account;
import android.support.annotation.Nullable;
import android.util.Log;

public class zzask
{
  public static String zzh(@Nullable Integer paramInteger)
  {
    if (paramInteger == null) {
      return "(null)";
    }
    if (Log.isLoggable("GCoreUlr", 2)) {
      return String.valueOf(paramInteger);
    }
    int i = paramInteger.intValue();
    return 15 + "tag#" + i % 20;
  }
  
  public static String zzi(@Nullable Account paramAccount)
  {
    if (paramAccount == null) {
      return "null";
    }
    if (Log.isLoggable("GCoreUlr", 2)) {
      return paramAccount.name;
    }
    int i = paramAccount.name.hashCode();
    return 20 + "account#" + i % 20 + "#";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */