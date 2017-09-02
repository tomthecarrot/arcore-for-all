package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zzd<T>
  extends IObjectWrapper.zza
{
  private final T mWrappedObject;
  
  private zzd(T paramT)
  {
    this.mWrappedObject = paramT;
  }
  
  public static <T> T zzI(IObjectWrapper paramIObjectWrapper)
  {
    int j = 0;
    if ((paramIObjectWrapper instanceof zzd)) {
      return (T)((zzd)paramIObjectWrapper).mWrappedObject;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramIObjectWrapper = null;
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      if (localField.isSynthetic()) {
        break label169;
      }
      j += 1;
      paramIObjectWrapper = localField;
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      if (j == 1)
      {
        if (!paramIObjectWrapper.isAccessible())
        {
          paramIObjectWrapper.setAccessible(true);
          try
          {
            paramIObjectWrapper = paramIObjectWrapper.get(localIBinder);
            return paramIObjectWrapper;
          }
          catch (NullPointerException paramIObjectWrapper)
          {
            throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
          }
          catch (IllegalAccessException paramIObjectWrapper)
          {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
          }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
      }
      i = arrayOfField.length;
      throw new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + i);
    }
  }
  
  public static <T> IObjectWrapper zzJ(T paramT)
  {
    return new zzd(paramT);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/dynamic/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */