package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@Beta
public final class TypeResolver
{
  private final TypeTable typeTable;
  
  public TypeResolver()
  {
    this.typeTable = new TypeTable();
  }
  
  private TypeResolver(TypeTable paramTypeTable)
  {
    this.typeTable = paramTypeTable;
  }
  
  static TypeResolver accordingTo(Type paramType)
  {
    return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(paramType));
  }
  
  private static <T> T expectArgument(Class<T> paramClass, Object paramObject)
  {
    try
    {
      Object localObject = paramClass.cast(paramObject);
      return (T)localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalArgumentException(paramObject + " is not a " + paramClass.getSimpleName());
    }
  }
  
  private static void populateTypeMappings(Map<TypeVariableKey, Type> paramMap, Type paramType1, final Type paramType2)
  {
    if (paramType1.equals(paramType2)) {}
    while (paramType2 instanceof WildcardType != paramType1 instanceof WildcardType) {
      return;
    }
    new TypeVisitor()
    {
      void visitClass(Class<?> paramAnonymousClass)
      {
        throw new IllegalArgumentException("No type mapping from " + paramAnonymousClass);
      }
      
      void visitGenericArrayType(GenericArrayType paramAnonymousGenericArrayType)
      {
        Type localType = Types.getComponentType(paramType2);
        if (localType != null) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "%s is not an array type.", new Object[] { paramType2 });
          TypeResolver.populateTypeMappings(this.val$mappings, paramAnonymousGenericArrayType.getGenericComponentType(), localType);
          return;
        }
      }
      
      void visitParameterizedType(ParameterizedType paramAnonymousParameterizedType)
      {
        ParameterizedType localParameterizedType = (ParameterizedType)TypeResolver.expectArgument(ParameterizedType.class, paramType2);
        Preconditions.checkArgument(paramAnonymousParameterizedType.getRawType().equals(localParameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", new Object[] { paramAnonymousParameterizedType, paramType2 });
        Type[] arrayOfType1 = paramAnonymousParameterizedType.getActualTypeArguments();
        Type[] arrayOfType2 = localParameterizedType.getActualTypeArguments();
        if (arrayOfType1.length == arrayOfType2.length) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "%s not compatible with %s", new Object[] { paramAnonymousParameterizedType, localParameterizedType });
          int i = 0;
          while (i < arrayOfType1.length)
          {
            TypeResolver.populateTypeMappings(this.val$mappings, arrayOfType1[i], arrayOfType2[i]);
            i += 1;
          }
        }
      }
      
      void visitTypeVariable(TypeVariable<?> paramAnonymousTypeVariable)
      {
        this.val$mappings.put(new TypeResolver.TypeVariableKey(paramAnonymousTypeVariable), paramType2);
      }
      
      void visitWildcardType(WildcardType paramAnonymousWildcardType)
      {
        Object localObject = (WildcardType)TypeResolver.expectArgument(WildcardType.class, paramType2);
        Type[] arrayOfType1 = paramAnonymousWildcardType.getUpperBounds();
        Type[] arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
        Type[] arrayOfType3 = paramAnonymousWildcardType.getLowerBounds();
        localObject = ((WildcardType)localObject).getLowerBounds();
        if ((arrayOfType1.length == arrayOfType2.length) && (arrayOfType3.length == localObject.length)) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "Incompatible type: %s vs. %s", new Object[] { paramAnonymousWildcardType, paramType2 });
          i = 0;
          while (i < arrayOfType1.length)
          {
            TypeResolver.populateTypeMappings(this.val$mappings, arrayOfType1[i], arrayOfType2[i]);
            i += 1;
          }
        }
        int i = 0;
        while (i < arrayOfType3.length)
        {
          TypeResolver.populateTypeMappings(this.val$mappings, arrayOfType3[i], localObject[i]);
          i += 1;
        }
      }
    }.visit(new Type[] { paramType1 });
  }
  
  private Type resolveGenericArrayType(GenericArrayType paramGenericArrayType)
  {
    return Types.newArrayType(resolveType(paramGenericArrayType.getGenericComponentType()));
  }
  
  private ParameterizedType resolveParameterizedType(ParameterizedType paramParameterizedType)
  {
    Type localType1 = paramParameterizedType.getOwnerType();
    if (localType1 == null) {}
    for (localType1 = null;; localType1 = resolveType(localType1))
    {
      Type localType2 = resolveType(paramParameterizedType.getRawType());
      paramParameterizedType = resolveTypes(paramParameterizedType.getActualTypeArguments());
      return Types.newParameterizedTypeWithOwner(localType1, (Class)localType2, paramParameterizedType);
    }
  }
  
  private Type[] resolveTypes(Type[] paramArrayOfType)
  {
    Type[] arrayOfType = new Type[paramArrayOfType.length];
    int i = 0;
    while (i < paramArrayOfType.length)
    {
      arrayOfType[i] = resolveType(paramArrayOfType[i]);
      i += 1;
    }
    return arrayOfType;
  }
  
  private WildcardType resolveWildcardType(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    paramWildcardType = paramWildcardType.getUpperBounds();
    return new Types.WildcardTypeImpl(resolveTypes(arrayOfType), resolveTypes(paramWildcardType));
  }
  
  public Type resolveType(Type paramType)
  {
    Preconditions.checkNotNull(paramType);
    Type localType;
    if ((paramType instanceof TypeVariable)) {
      localType = this.typeTable.resolve((TypeVariable)paramType);
    }
    do
    {
      return localType;
      if ((paramType instanceof ParameterizedType)) {
        return resolveParameterizedType((ParameterizedType)paramType);
      }
      if ((paramType instanceof GenericArrayType)) {
        return resolveGenericArrayType((GenericArrayType)paramType);
      }
      localType = paramType;
    } while (!(paramType instanceof WildcardType));
    return resolveWildcardType((WildcardType)paramType);
  }
  
  public TypeResolver where(Type paramType1, Type paramType2)
  {
    HashMap localHashMap = Maps.newHashMap();
    populateTypeMappings(localHashMap, (Type)Preconditions.checkNotNull(paramType1), (Type)Preconditions.checkNotNull(paramType2));
    return where(localHashMap);
  }
  
  TypeResolver where(Map<TypeVariableKey, ? extends Type> paramMap)
  {
    return new TypeResolver(this.typeTable.where(paramMap));
  }
  
  private static final class TypeMappingIntrospector
    extends TypeVisitor
  {
    private static final TypeResolver.WildcardCapturer wildcardCapturer = new TypeResolver.WildcardCapturer(null);
    private final Map<TypeResolver.TypeVariableKey, Type> mappings = Maps.newHashMap();
    
    static ImmutableMap<TypeResolver.TypeVariableKey, Type> getTypeMappings(Type paramType)
    {
      TypeMappingIntrospector localTypeMappingIntrospector = new TypeMappingIntrospector();
      localTypeMappingIntrospector.visit(new Type[] { wildcardCapturer.capture(paramType) });
      return ImmutableMap.copyOf(localTypeMappingIntrospector.mappings);
    }
    
    private void map(TypeResolver.TypeVariableKey paramTypeVariableKey, Type paramType)
    {
      if (this.mappings.containsKey(paramTypeVariableKey)) {
        return;
      }
      for (Type localType = paramType;; localType = (Type)this.mappings.get(TypeResolver.TypeVariableKey.forLookup(localType)))
      {
        if (localType == null) {
          break label72;
        }
        if (paramTypeVariableKey.equalsType(localType))
        {
          while (paramType != null) {
            paramType = (Type)this.mappings.remove(TypeResolver.TypeVariableKey.forLookup(paramType));
          }
          break;
        }
      }
      label72:
      this.mappings.put(paramTypeVariableKey, paramType);
    }
    
    void visitClass(Class<?> paramClass)
    {
      visit(new Type[] { paramClass.getGenericSuperclass() });
      visit(paramClass.getGenericInterfaces());
    }
    
    void visitParameterizedType(ParameterizedType paramParameterizedType)
    {
      Class localClass = (Class)paramParameterizedType.getRawType();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
      if (arrayOfTypeVariable.length == arrayOfType.length) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        int i = 0;
        while (i < arrayOfTypeVariable.length)
        {
          map(new TypeResolver.TypeVariableKey(arrayOfTypeVariable[i]), arrayOfType[i]);
          i += 1;
        }
      }
      visit(new Type[] { localClass });
      visit(new Type[] { paramParameterizedType.getOwnerType() });
    }
    
    void visitTypeVariable(TypeVariable<?> paramTypeVariable)
    {
      visit(paramTypeVariable.getBounds());
    }
    
    void visitWildcardType(WildcardType paramWildcardType)
    {
      visit(paramWildcardType.getUpperBounds());
    }
  }
  
  private static class TypeTable
  {
    private final ImmutableMap<TypeResolver.TypeVariableKey, Type> map;
    
    TypeTable()
    {
      this.map = ImmutableMap.of();
    }
    
    private TypeTable(ImmutableMap<TypeResolver.TypeVariableKey, Type> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    final Type resolve(final TypeVariable<?> paramTypeVariable)
    {
      resolveInternal(paramTypeVariable, new TypeTable()
      {
        public Type resolveInternal(TypeVariable<?> paramAnonymousTypeVariable, TypeResolver.TypeTable paramAnonymousTypeTable)
        {
          if (paramAnonymousTypeVariable.getGenericDeclaration().equals(paramTypeVariable.getGenericDeclaration())) {
            return paramAnonymousTypeVariable;
          }
          return jdField_this.resolveInternal(paramAnonymousTypeVariable, paramAnonymousTypeTable);
        }
      });
    }
    
    Type resolveInternal(TypeVariable<?> paramTypeVariable, TypeTable paramTypeTable)
    {
      Object localObject = (Type)this.map.get(new TypeResolver.TypeVariableKey(paramTypeVariable));
      if (localObject == null)
      {
        localObject = paramTypeVariable.getBounds();
        if (localObject.length == 0) {}
        do
        {
          return paramTypeVariable;
          paramTypeTable = new TypeResolver(paramTypeTable, null).resolveTypes((Type[])localObject);
        } while ((Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY) && (Arrays.equals((Object[])localObject, paramTypeTable)));
        return Types.newArtificialTypeVariable(paramTypeVariable.getGenericDeclaration(), paramTypeVariable.getName(), paramTypeTable);
      }
      return new TypeResolver(paramTypeTable, null).resolveType((Type)localObject);
    }
    
    final TypeTable where(Map<TypeResolver.TypeVariableKey, ? extends Type> paramMap)
    {
      ImmutableMap.Builder localBuilder = ImmutableMap.builder();
      localBuilder.putAll(this.map);
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        TypeResolver.TypeVariableKey localTypeVariableKey = (TypeResolver.TypeVariableKey)((Map.Entry)localObject).getKey();
        localObject = (Type)((Map.Entry)localObject).getValue();
        if (!localTypeVariableKey.equalsType((Type)localObject)) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "Type variable %s bound to itself", new Object[] { localTypeVariableKey });
          localBuilder.put(localTypeVariableKey, localObject);
          break;
        }
      }
      return new TypeTable(localBuilder.build());
    }
  }
  
  static final class TypeVariableKey
  {
    private final TypeVariable<?> var;
    
    TypeVariableKey(TypeVariable<?> paramTypeVariable)
    {
      this.var = ((TypeVariable)Preconditions.checkNotNull(paramTypeVariable));
    }
    
    private boolean equalsTypeVariable(TypeVariable<?> paramTypeVariable)
    {
      return (this.var.getGenericDeclaration().equals(paramTypeVariable.getGenericDeclaration())) && (this.var.getName().equals(paramTypeVariable.getName()));
    }
    
    static Object forLookup(Type paramType)
    {
      if ((paramType instanceof TypeVariable)) {
        return new TypeVariableKey((TypeVariable)paramType);
      }
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof TypeVariableKey)) {
        return equalsTypeVariable(((TypeVariableKey)paramObject).var);
      }
      return false;
    }
    
    boolean equalsType(Type paramType)
    {
      if ((paramType instanceof TypeVariable)) {
        return equalsTypeVariable((TypeVariable)paramType);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.var.getGenericDeclaration(), this.var.getName() });
    }
    
    public String toString()
    {
      return this.var.toString();
    }
  }
  
  private static final class WildcardCapturer
  {
    private final AtomicInteger id = new AtomicInteger();
    
    private Type[] capture(Type[] paramArrayOfType)
    {
      Type[] arrayOfType = new Type[paramArrayOfType.length];
      int i = 0;
      while (i < paramArrayOfType.length)
      {
        arrayOfType[i] = capture(paramArrayOfType[i]);
        i += 1;
      }
      return arrayOfType;
    }
    
    private Type captureNullable(@Nullable Type paramType)
    {
      if (paramType == null) {
        return null;
      }
      return capture(paramType);
    }
    
    Type capture(Type paramType)
    {
      Preconditions.checkNotNull(paramType);
      if ((paramType instanceof Class)) {}
      WildcardType localWildcardType;
      do
      {
        do
        {
          return paramType;
        } while ((paramType instanceof TypeVariable));
        if ((paramType instanceof GenericArrayType)) {
          return Types.newArrayType(capture(((GenericArrayType)paramType).getGenericComponentType()));
        }
        if ((paramType instanceof ParameterizedType))
        {
          paramType = (ParameterizedType)paramType;
          return Types.newParameterizedTypeWithOwner(captureNullable(paramType.getOwnerType()), (Class)paramType.getRawType(), capture(paramType.getActualTypeArguments()));
        }
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        localWildcardType = (WildcardType)paramType;
      } while (localWildcardType.getLowerBounds().length != 0);
      paramType = localWildcardType.getUpperBounds();
      return Types.newArtificialTypeVariable(WildcardCapturer.class, "capture#" + this.id.incrementAndGet() + "-of ? extends " + Joiner.on('&').join(paramType), localWildcardType.getUpperBounds());
      throw new AssertionError("must have been one of the known types");
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/TypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */