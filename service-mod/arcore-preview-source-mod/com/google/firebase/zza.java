package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaak;

public class zza
  implements zzaak
{
  public Exception zzO(Status paramStatus)
  {
    if (paramStatus.getStatusCode() == 8) {
      return new FirebaseException(paramStatus.zzxh());
    }
    return new FirebaseApiNotAvailableException(paramStatus.zzxh());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/firebase/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */