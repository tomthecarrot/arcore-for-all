package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class zzbbp
{
  public static final Map<String, Integer> zzccf = new HashMap();
  public static final Handler zzccg = new Handler(Looper.getMainLooper());
  public static final String[] zzcch = new String[0];
  public static final Pattern zzcci = Pattern.compile("\\,");
  public static final Pattern zzccj = Pattern.compile("[     ᠎             　\t\013\f\034\035\036\037\n\r]+");
  public static final Pattern zzcck = Pattern.compile(Pattern.quote(String.valueOf('\001')));
  public static final Pattern zzccl = Pattern.compile(Pattern.quote(String.valueOf('\002')));
  public static final String zzccm = String.valueOf('\001');
  public static final String zzccn = String.valueOf('\002');
  public static final SecureRandom zzcco = new SecureRandom();
  private static final ThreadLocal<StringBuilder> zzccp = new ThreadLocal()
  {
    protected StringBuilder zzRS()
    {
      return new StringBuilder();
    }
  };
  private static final ThreadLocal<String[]> zzccq = new ThreadLocal()
  {
    protected String[] zzRT()
    {
      return new String[1];
    }
  };
  private static final ThreadLocal<String[]> zzccr = new ThreadLocal()
  {
    protected String[] zzRT()
    {
      return new String[2];
    }
  };
  private static final ThreadLocal<String[]> zzccs = new ThreadLocal()
  {
    protected String[] zzRT()
    {
      return new String[3];
    }
  };
  private static final ThreadLocal<String[]> zzcct = new ThreadLocal()
  {
    protected String[] zzRT()
    {
      return new String[4];
    }
  };
  private static final ThreadLocal<String[]> zzccu = new ThreadLocal()
  {
    protected String[] zzRT()
    {
      return new String[5];
    }
  };
  
  static
  {
    zzccf.put("circle", Integer.valueOf(-1));
    zzccf.put("extendedCircles", Integer.valueOf(4));
    zzccf.put("myCircles", Integer.valueOf(3));
    zzccf.put("domain", Integer.valueOf(2));
    zzccf.put("public", Integer.valueOf(1));
    zzccf.put(null, Integer.valueOf(-2));
  }
  
  public static StringBuilder zzRR()
  {
    StringBuilder localStringBuilder = (StringBuilder)zzccp.get();
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
  
  public static void zzaw(String paramString1, String paramString2)
  {
    zzac.zzi(paramString1, paramString2);
    if ((paramString1.startsWith("g:")) || (paramString1.startsWith("e:"))) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, String.valueOf(paramString2).concat(": Expecting qualified-id, not gaia-id"));
      return;
    }
  }
  
  public static String[] zzax(String paramString1, String paramString2)
  {
    String[] arrayOfString = (String[])zzccr.get();
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramString2;
    return arrayOfString;
  }
  
  public static Random zzbU(Context paramContext)
  {
    paramContext = (Random)paramContext.getSystemService("gms.people.random");
    if (paramContext != null) {
      return paramContext;
    }
    return zzcco;
  }
  
  public static String zziA(String paramString)
  {
    int i = 0;
    while ((i < paramString.length()) && (paramString.charAt(i) == '0')) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  public static String zzir(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  public static String[] zzis(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return zzcch;
    }
    return zzcci.split(paramString, 0);
  }
  
  public static String zzit(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("g:"))) {
      return null;
    }
    return paramString.substring("g:".length());
  }
  
  public static String zziu(String paramString)
  {
    zzac.zzC(paramString);
    String str = String.valueOf("g:");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  public static String zziv(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("e:"))) {
      return null;
    }
    return paramString.substring("e:".length());
  }
  
  public static String zziw(String paramString)
  {
    zzac.zzdc(paramString);
    String str = String.valueOf("e:");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  public static boolean zzix(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("e:"));
  }
  
  public static boolean zziy(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("g:"));
  }
  
  public static boolean zziz(String paramString)
  {
    return (zzix(paramString)) || (zziy(paramString));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */