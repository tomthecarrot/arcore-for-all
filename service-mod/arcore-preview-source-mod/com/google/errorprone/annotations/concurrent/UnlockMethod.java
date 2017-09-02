package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface UnlockMethod
{
  String[] value();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/errorprone/annotations/concurrent/UnlockMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */