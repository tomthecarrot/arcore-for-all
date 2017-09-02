package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class TypeVisitor
{
  private final Set<Type> visited = Sets.newHashSet();
  
  public final void visit(Type... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Type localType = paramVarArgs[i];
      if ((localType == null) || (!this.visited.add(localType)))
      {
        i += 1;
      }
      else
      {
        for (;;)
        {
          try
          {
            if ((localType instanceof TypeVariable))
            {
              visitTypeVariable((TypeVariable)localType);
              if (1 != 0) {
                break;
              }
              this.visited.remove(localType);
              break;
            }
            if ((localType instanceof WildcardType))
            {
              visitWildcardType((WildcardType)localType);
              continue;
            }
            if (!(localType instanceof ParameterizedType)) {
              break label136;
            }
          }
          finally
          {
            if (0 == 0) {
              this.visited.remove(localType);
            }
          }
          visitParameterizedType((ParameterizedType)localType);
          continue;
          label136:
          if ((localType instanceof Class))
          {
            visitClass((Class)localType);
          }
          else
          {
            if (!(localType instanceof GenericArrayType)) {
              break label176;
            }
            visitGenericArrayType((GenericArrayType)localType);
          }
        }
        label176:
        throw new AssertionError("Unknown type: " + localType);
      }
    }
  }
  
  void visitClass(Class<?> paramClass) {}
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType) {}
  
  void visitParameterizedType(ParameterizedType paramParameterizedType) {}
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable) {}
  
  void visitWildcardType(WildcardType paramWildcardType) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/TypeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */