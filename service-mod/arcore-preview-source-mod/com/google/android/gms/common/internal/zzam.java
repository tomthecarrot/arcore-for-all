package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R.string;

public class zzam
{
  private final Resources zzaSM;
  private final String zzaSN;
  
  public zzam(Context paramContext)
  {
    zzac.zzC(paramContext);
    this.zzaSM = paramContext.getResources();
    this.zzaSN = this.zzaSM.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public String getString(String paramString)
  {
    int i = this.zzaSM.getIdentifier(paramString, "string", this.zzaSN);
    if (i == 0) {
      return null;
    }
    return this.zzaSM.getString(i);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */