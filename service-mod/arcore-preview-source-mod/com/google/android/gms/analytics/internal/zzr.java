package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzr<T extends zzq>
  extends zzc
{
  zza<T> zzaeH;
  
  public zzr(zzf paramzzf, zza<T> paramzza)
  {
    super(paramzzf);
    this.zzaeH = paramzza;
  }
  
  private T zza(XmlResourceParser paramXmlResourceParser)
  {
    for (;;)
    {
      try
      {
        paramXmlResourceParser.next();
        i = paramXmlResourceParser.getEventType();
        if (i == 1) {
          continue;
        }
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            continue;
          }
          str1 = paramXmlResourceParser.getAttributeValue(null, "name");
          str2 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            this.zzaeH.zzp(str1, str2);
          }
        }
      }
      catch (XmlPullParserException paramXmlResourceParser)
      {
        zze("Error parsing tracker configuration file", paramXmlResourceParser);
        return this.zzaeH.zzou();
        if (!str1.equals("bool")) {
          continue;
        }
        String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
        str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          bool = Boolean.parseBoolean(str1);
          this.zzaeH.zze(str2, bool);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          zzc("Error parsing bool configuration value", str1, localNumberFormatException1);
        }
        continue;
      }
      catch (IOException paramXmlResourceParser)
      {
        int i;
        zze("Error parsing tracker configuration file", paramXmlResourceParser);
        continue;
        if (!str1.equals("integer")) {
          continue;
        }
        String str3 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str3)) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          i = Integer.parseInt(str1);
          this.zzaeH.zzd(str3, i);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          zzc("Error parsing int configuration value", str1, localNumberFormatException2);
        }
        continue;
      }
      i = paramXmlResourceParser.next();
      continue;
      if (!str1.equals("string")) {
        continue;
      }
      str1 = paramXmlResourceParser.getAttributeValue(null, "name");
      str2 = paramXmlResourceParser.nextText().trim();
      if ((!TextUtils.isEmpty(str1)) && (str2 != null)) {
        this.zzaeH.zzq(str1, str2);
      }
    }
  }
  
  public T zzaB(int paramInt)
  {
    try
    {
      zzq localzzq = zza(zznp().zznC().getResources().getXml(paramInt));
      return localzzq;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      zzd("inflate() called with unknown resourceId", localNotFoundException);
    }
    return null;
  }
  
  public static abstract interface zza<U extends zzq>
  {
    public abstract void zzd(String paramString, int paramInt);
    
    public abstract void zze(String paramString, boolean paramBoolean);
    
    public abstract U zzou();
    
    public abstract void zzp(String paramString1, String paramString2);
    
    public abstract void zzq(String paramString1, String paramString2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */