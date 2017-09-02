package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzd
  implements zzi
{
  private static final Uri zzabD;
  private final LogPrinter zzabE = new LogPrinter(4, "GA/LogCatTransport");
  
  static
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("local");
    zzabD = localBuilder.build();
  }
  
  public void zzb(zze paramzze)
  {
    Object localObject = new ArrayList(paramzze.zzmI());
    Collections.sort((List)localObject, new Comparator()
    {
      public int zza(zzf paramAnonymouszzf1, zzf paramAnonymouszzf2)
      {
        return paramAnonymouszzf1.getClass().getCanonicalName().compareTo(paramAnonymouszzf2.getClass().getCanonicalName());
      }
    });
    paramzze = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((zzf)((Iterator)localObject).next()).toString();
      if (!TextUtils.isEmpty(str))
      {
        if (paramzze.length() != 0) {
          paramzze.append(", ");
        }
        paramzze.append(str);
      }
    }
    this.zzabE.println(paramzze.toString());
  }
  
  public Uri zzmx()
  {
    return zzabD;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */