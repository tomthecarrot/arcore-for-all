package com.google.android.gms.internal;

import java.io.IOException;

public class zzcgf
  extends IOException
{
  public zzcgf(String paramString)
  {
    super(paramString);
  }
  
  static zzcgf zzanf()
  {
    return new zzcgf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzcgf zzang()
  {
    return new zzcgf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzcgf zzanh()
  {
    return new zzcgf("CodedInputStream encountered a malformed varint.");
  }
  
  static zzcgf zzani()
  {
    return new zzcgf("Protocol message contained an invalid tag (zero).");
  }
  
  static zzcgf zzanj()
  {
    return new zzcgf("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzcgf zzank()
  {
    return new zzcgf("Protocol message tag had invalid wire type.");
  }
  
  static zzcgf zzanl()
  {
    return new zzcgf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */