package javax.annotation.concurrent;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Immutable {}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/concurrent/Immutable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */