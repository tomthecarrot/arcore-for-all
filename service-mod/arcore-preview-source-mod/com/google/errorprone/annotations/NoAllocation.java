package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NoAllocation {}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/errorprone/annotations/NoAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */