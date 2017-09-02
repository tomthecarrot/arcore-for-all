package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzcgh
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject == null) {}
    int m;
    Class localClass;
    Object localObject4;
    do
    {
      return;
      if (!(paramObject instanceof zzcgg)) {
        break;
      }
      m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(zzmV(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      int i = 0;
      if (i < n)
      {
        Object localObject5 = localObject1[i];
        j = ((Field)localObject5).getModifiers();
        localObject3 = ((Field)localObject5).getName();
        if ("cachedSize".equals(localObject3)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((j & 0x1) == 1) && ((j & 0x8) != 8) && (!((String)localObject3).startsWith("_")) && (!((String)localObject3).endsWith("_")))
          {
            localObject4 = ((Field)localObject5).getType();
            localObject5 = ((Field)localObject5).get(paramObject);
            if (((Class)localObject4).isArray())
            {
              if (((Class)localObject4).getComponentType() == Byte.TYPE)
              {
                zza((String)localObject3, localObject5, paramStringBuffer1, paramStringBuffer2);
              }
              else
              {
                if (localObject5 == null) {}
                for (j = 0;; j = Array.getLength(localObject5))
                {
                  int k = 0;
                  while (k < j)
                  {
                    zza((String)localObject3, Array.get(localObject5, k), paramStringBuffer1, paramStringBuffer2);
                    k += 1;
                  }
                  break;
                }
              }
            }
            else {
              zza((String)localObject3, localObject5, paramStringBuffer1, paramStringBuffer2);
            }
          }
        }
      }
      Object localObject3 = localClass.getMethods();
      int j = localObject3.length;
      i = 0;
      if (i < j)
      {
        localObject1 = localObject3[i].getName();
        if (((String)localObject1).startsWith("set")) {
          localObject4 = ((String)localObject1).substring(3);
        }
        for (;;)
        {
          try
          {
            localObject1 = String.valueOf(localObject4);
            if (((String)localObject1).length() == 0) {
              continue;
            }
            localObject1 = "has".concat((String)localObject1);
            localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
            if (((Boolean)((Method)localObject1).invoke(paramObject, new Object[0])).booleanValue()) {
              continue;
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            continue;
            try
            {
              Object localObject2 = String.valueOf(localObject4);
              if (((String)localObject2).length() == 0) {
                continue;
              }
              localObject2 = "get".concat((String)localObject2);
              localObject2 = localClass.getMethod((String)localObject2, new Class[0]);
              zza((String)localObject4, ((Method)localObject2).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
              continue;
              localObject2 = new String("get");
              continue;
            }
            catch (NoSuchMethodException localNoSuchMethodException2) {}
          }
          i += 1;
          break;
          localObject1 = new String("has");
        }
      }
    } while (paramString == null);
    paramStringBuffer1.setLength(m);
    paramStringBuffer2.append(paramStringBuffer1).append(">\n");
    return;
    paramString = zzmV(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramString = zzck((String)paramObject);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[])) {
        zza((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void zza(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j == 92) || (j == 34)) {
        paramStringBuffer.append('\\').append((char)j);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
    }
    paramStringBuffer.append('"');
  }
  
  private static String zzck(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200) {
        str = String.valueOf(paramString.substring(0, 200)).concat("[...]");
      }
    }
    return zzdh(str);
  }
  
  private static String zzdh(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static <T extends zzcgg> String zzg(T paramT)
  {
    if (paramT == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      zza(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0) {
        return "Error printing proto: ".concat(paramT);
      }
      return new String("Error printing proto: ");
    }
    catch (InvocationTargetException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0) {
        return "Error printing proto: ".concat(paramT);
      }
    }
    return new String("Error printing proto: ");
  }
  
  private static String zzmV(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzcgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */