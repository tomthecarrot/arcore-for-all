package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Map;

@GwtCompatible(emulated=true)
final class Platform
{
  static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> paramClass, String paramString)
  {
    paramString = (WeakReference)Enums.getEnumConstants(paramClass).get(paramString);
    if (paramString == null) {
      return Optional.absent();
    }
    return Optional.of(paramClass.cast(paramString.get()));
  }
  
  static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher)
  {
    return paramCharMatcher.precomputedInternal();
  }
  
  static long systemNanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */