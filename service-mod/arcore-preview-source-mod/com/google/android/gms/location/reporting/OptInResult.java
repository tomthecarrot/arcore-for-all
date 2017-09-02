package com.google.android.gms.location.reporting;

public class OptInResult
{
  public static final int ACCOUNT_MISSING = 2;
  public static final int ACCOUNT_NOT_VALID = 3;
  public static final int CAN_NOT_BE_ACTIVATED = 7;
  @Deprecated
  public static final int COMMUNICATION_FAILURE = 8;
  public static final int REMOTE_EXCEPTION = 9;
  @Deprecated
  public static final int REPORTING_NOT_ALLOWED = 1;
  public static final int SENDER_MISSING = 4;
  public static final int SENDER_NON_GOOGLE = 6;
  public static final int SENDER_NOT_AUTHORIZED = 5;
  public static final int SETTINGS_CANNOT_BE_CHANGED = 10;
  public static final int SUCCESS = 0;
  public static final int TAG_TOO_LONG = 11;
  public static final int UNKNOWN = 1;
  
  public static int sanitize(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/OptInResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */