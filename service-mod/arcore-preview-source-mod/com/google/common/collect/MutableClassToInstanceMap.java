package com.google.common.collect;

import com.google.common.primitives.Primitives;
import java.util.HashMap;
import java.util.Map;

public final class MutableClassToInstanceMap<B>
  extends MapConstraints.ConstrainedMap<Class<? extends B>, B>
  implements ClassToInstanceMap<B>
{
  private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MapConstraint()
  {
    public void checkKeyValue(Class<?> paramAnonymousClass, Object paramAnonymousObject)
    {
      MutableClassToInstanceMap.cast(paramAnonymousClass, paramAnonymousObject);
    }
  };
  private static final long serialVersionUID = 0L;
  
  private MutableClassToInstanceMap(Map<Class<? extends B>, B> paramMap)
  {
    super(paramMap, VALUE_CAN_BE_CAST_TO_KEY);
  }
  
  private static <B, T extends B> T cast(Class<T> paramClass, B paramB)
  {
    return (T)Primitives.wrap(paramClass).cast(paramB);
  }
  
  public static <B> MutableClassToInstanceMap<B> create()
  {
    return new MutableClassToInstanceMap(new HashMap());
  }
  
  public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> paramMap)
  {
    return new MutableClassToInstanceMap(paramMap);
  }
  
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return (T)cast(paramClass, get(paramClass));
  }
  
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    return (T)cast(paramClass, put(paramClass, paramT));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/MutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */