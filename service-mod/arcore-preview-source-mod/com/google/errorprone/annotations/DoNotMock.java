package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface DoNotMock
{
  String value();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/errorprone/annotations/DoNotMock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */