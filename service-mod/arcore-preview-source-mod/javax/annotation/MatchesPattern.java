package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo=String.class)
public @interface MatchesPattern
{
  int flags() default 0;
  
  @RegEx
  String value();
  
  public static class Checker
    implements TypeQualifierValidator<MatchesPattern>
  {
    public When forConstantValue(MatchesPattern paramMatchesPattern, Object paramObject)
    {
      if (Pattern.compile(paramMatchesPattern.value(), paramMatchesPattern.flags()).matcher((String)paramObject).matches()) {
        return When.ALWAYS;
      }
      return When.NEVER;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/javax/annotation/MatchesPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */