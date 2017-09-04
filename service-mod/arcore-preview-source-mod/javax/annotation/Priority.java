package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Priority
{
  int value();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/Priority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */