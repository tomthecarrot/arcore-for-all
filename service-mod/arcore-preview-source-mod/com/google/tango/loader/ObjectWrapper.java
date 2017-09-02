package com.google.tango.loader;

import java.lang.reflect.Field;

public final class ObjectWrapper<T>
  extends IObjectWrapper.Stub
{
  private final T wrappedObject;
  
  private ObjectWrapper(T paramT)
  {
    this.wrappedObject = paramT;
  }
  
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper, Class<T> paramClass)
  {
    if ((paramIObjectWrapper instanceof ObjectWrapper)) {
      return (T)((ObjectWrapper)paramIObjectWrapper).wrappedObject;
    }
    if (paramIObjectWrapper == null) {
      return null;
    }
    paramIObjectWrapper = paramIObjectWrapper.asBinder();
    Object localObject = paramIObjectWrapper.getClass().getDeclaredFields();
    if (localObject.length == 1)
    {
      localObject = localObject[0];
      if (!((Field)localObject).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          paramIObjectWrapper = ((Field)localObject).get(paramIObjectWrapper);
          if (!paramClass.isInstance(paramIObjectWrapper)) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.");
          }
        }
        catch (NullPointerException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
          paramIObjectWrapper = paramClass.cast(paramIObjectWrapper);
          return paramIObjectWrapper;
        }
        catch (IllegalArgumentException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramIObjectWrapper);
        }
        catch (IllegalAccessException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
  
  public static <T> IObjectWrapper wrap(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    return new ObjectWrapper(paramT);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/loader/ObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */