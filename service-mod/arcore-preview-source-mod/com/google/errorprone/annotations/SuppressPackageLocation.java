package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.PACKAGE})
public @interface SuppressPackageLocation {}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/errorprone/annotations/SuppressPackageLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */