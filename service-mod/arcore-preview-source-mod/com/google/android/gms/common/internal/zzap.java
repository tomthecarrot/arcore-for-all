package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class zzap
{
  public static String zza(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramAttributeSet == null) {
      paramString1 = null;
    }
    for (;;)
    {
      paramAttributeSet = paramString1;
      String str1;
      String str2;
      if (paramString1 != null)
      {
        paramAttributeSet = paramString1;
        if (paramString1.startsWith("@string/"))
        {
          paramAttributeSet = paramString1;
          if (paramBoolean1)
          {
            str1 = paramString1.substring("@string/".length());
            str2 = paramContext.getPackageName();
            paramAttributeSet = new TypedValue();
          }
        }
      }
      try
      {
        paramContext.getResources().getValue(String.valueOf(str2).length() + 8 + String.valueOf(str1).length() + str2 + ":string/" + str1, paramAttributeSet, true);
        if (paramAttributeSet.string != null)
        {
          paramAttributeSet = paramAttributeSet.string.toString();
          if ((paramBoolean2) && (paramAttributeSet == null)) {
            Log.w(paramString3, String.valueOf(paramString2).length() + 33 + "Required XML attribute \"" + paramString2 + "\" missing");
          }
          return paramAttributeSet;
          paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
        }
      }
      catch (Resources.NotFoundException paramContext)
      {
        for (;;)
        {
          Log.w(paramString3, String.valueOf(paramString2).length() + 30 + String.valueOf(paramString1).length() + "Could not find resource for " + paramString2 + ": " + paramString1);
          continue;
          paramContext = String.valueOf(paramAttributeSet);
          Log.w(paramString3, String.valueOf(paramString2).length() + 28 + String.valueOf(paramContext).length() + "Resource " + paramString2 + " was not a string: " + paramContext);
          paramAttributeSet = paramString1;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */