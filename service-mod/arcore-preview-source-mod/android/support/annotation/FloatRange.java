package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface FloatRange
{
  double from() default Double.NEGATIVE_INFINITY;
  
  boolean fromInclusive() default true;
  
  double to() default Double.POSITIVE_INFINITY;
  
  boolean toInclusive() default true;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/annotation/FloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */