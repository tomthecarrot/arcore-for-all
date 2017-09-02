package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier
public @interface Nonnull
{
  When when() default When.ALWAYS;
  
  public static class Checker
    implements TypeQualifierValidator<Nonnull>
  {
    public When forConstantValue(Nonnull paramNonnull, Object paramObject)
    {
      if (paramObject == null) {
        return When.NEVER;
      }
      return When.ALWAYS;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/Nonnull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */