package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD})
public @interface RestrictedApi
{
  String allowedOnPath() default "";
  
  String checkerName() default "RestrictedApi";
  
  String explanation();
  
  String link();
  
  Class<? extends Annotation>[] whitelistAnnotations() default {};
  
  Class<? extends Annotation>[] whitelistWithWarningAnnotations() default {};
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/errorprone/annotations/RestrictedApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */