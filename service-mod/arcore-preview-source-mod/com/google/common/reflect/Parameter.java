package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
public final class Parameter
  implements AnnotatedElement
{
  private final ImmutableList<Annotation> annotations;
  private final Invokable<?, ?> declaration;
  private final int position;
  private final TypeToken<?> type;
  
  Parameter(Invokable<?, ?> paramInvokable, int paramInt, TypeToken<?> paramTypeToken, Annotation[] paramArrayOfAnnotation)
  {
    this.declaration = paramInvokable;
    this.position = paramInt;
    this.type = paramTypeToken;
    this.annotations = ImmutableList.copyOf(paramArrayOfAnnotation);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Parameter))
    {
      paramObject = (Parameter)paramObject;
      bool1 = bool2;
      if (this.position == ((Parameter)paramObject).position)
      {
        bool1 = bool2;
        if (this.declaration.equals(((Parameter)paramObject).declaration)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    Preconditions.checkNotNull(paramClass);
    Iterator localIterator = this.annotations.iterator();
    while (localIterator.hasNext())
    {
      Annotation localAnnotation = (Annotation)localIterator.next();
      if (paramClass.isInstance(localAnnotation)) {
        return (Annotation)paramClass.cast(localAnnotation);
      }
    }
    return null;
  }
  
  public Annotation[] getAnnotations()
  {
    return getDeclaredAnnotations();
  }
  
  public <A extends Annotation> A[] getAnnotationsByType(Class<A> paramClass)
  {
    return getDeclaredAnnotationsByType(paramClass);
  }
  
  @Nullable
  public <A extends Annotation> A getDeclaredAnnotation(Class<A> paramClass)
  {
    Preconditions.checkNotNull(paramClass);
    return (Annotation)FluentIterable.from(this.annotations).filter(paramClass).first().orNull();
  }
  
  public Annotation[] getDeclaredAnnotations()
  {
    return (Annotation[])this.annotations.toArray(new Annotation[this.annotations.size()]);
  }
  
  public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> paramClass)
  {
    return (Annotation[])FluentIterable.from(this.annotations).filter(paramClass).toArray(paramClass);
  }
  
  public Invokable<?, ?> getDeclaringInvokable()
  {
    return this.declaration;
  }
  
  public TypeToken<?> getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.position;
  }
  
  public boolean isAnnotationPresent(Class<? extends Annotation> paramClass)
  {
    return getAnnotation(paramClass) != null;
  }
  
  public String toString()
  {
    return this.type + " arg" + this.position;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */