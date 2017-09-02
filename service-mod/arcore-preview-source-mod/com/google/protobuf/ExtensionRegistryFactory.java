package com.google.protobuf;

import java.lang.reflect.Method;

final class ExtensionRegistryFactory
{
  static final Class<?> EXTENSION_REGISTRY_CLASS = ;
  static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";
  
  public static ExtensionRegistryLite create()
  {
    if (EXTENSION_REGISTRY_CLASS != null) {
      try
      {
        ExtensionRegistryLite localExtensionRegistryLite = invokeSubclassFactory("newInstance");
        return localExtensionRegistryLite;
      }
      catch (Exception localException) {}
    }
    return new ExtensionRegistryLite();
  }
  
  public static ExtensionRegistryLite createEmpty()
  {
    if (EXTENSION_REGISTRY_CLASS != null) {
      try
      {
        ExtensionRegistryLite localExtensionRegistryLite = invokeSubclassFactory("getEmptyRegistry");
        return localExtensionRegistryLite;
      }
      catch (Exception localException) {}
    }
    return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
  }
  
  private static final ExtensionRegistryLite invokeSubclassFactory(String paramString)
    throws Exception
  {
    return (ExtensionRegistryLite)EXTENSION_REGISTRY_CLASS.getMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }
  
  static boolean isFullRegistry(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (EXTENSION_REGISTRY_CLASS != null) && (EXTENSION_REGISTRY_CLASS.isAssignableFrom(paramExtensionRegistryLite.getClass()));
  }
  
  static Class<?> reflectExtensionRegistry()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ExtensionRegistryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */