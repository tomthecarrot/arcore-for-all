package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo=CharSequence.class)
public @interface Syntax
{
  String value();
  
  When when() default When.ALWAYS;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/Syntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */