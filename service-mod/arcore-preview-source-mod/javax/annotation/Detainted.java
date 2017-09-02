package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Untainted(when=When.ALWAYS)
@TypeQualifierNickname
public @interface Detainted {}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/Detainted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */