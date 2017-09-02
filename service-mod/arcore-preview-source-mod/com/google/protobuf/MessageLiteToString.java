package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class MessageLiteToString
{
  private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
  private static final String BYTES_SUFFIX = "Bytes";
  private static final String LIST_SUFFIX = "List";
  
  private static final String camelCaseToSnakeCase(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean isDefaultValue(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Boolean)) {
      if (!((Boolean)paramObject).booleanValue()) {
        bool = true;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return bool;
                bool = false;
              }
              if (!(paramObject instanceof Integer)) {
                break;
              }
            } while (((Integer)paramObject).intValue() == 0);
            return false;
            if (!(paramObject instanceof Float)) {
              break;
            }
          } while (((Float)paramObject).floatValue() == 0.0F);
          return false;
          if (!(paramObject instanceof Double)) {
            break;
          }
        } while (((Double)paramObject).doubleValue() == 0.0D);
        return false;
        if ((paramObject instanceof String)) {
          return paramObject.equals("");
        }
        if ((paramObject instanceof ByteString)) {
          return paramObject.equals(ByteString.EMPTY);
        }
        if (!(paramObject instanceof MessageLite)) {
          break;
        }
      } while (paramObject == ((MessageLite)paramObject).getDefaultInstanceForType());
      return false;
      if (!(paramObject instanceof Enum)) {
        break;
      }
    } while (((Enum)paramObject).ordinal() == 0);
    return false;
    return false;
  }
  
  static final void printField(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        printField(paramStringBuilder, paramInt, paramString, ((Iterator)paramObject).next());
      }
    }
    paramStringBuilder.append('\n');
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"").append(TextFormatEscaper.escapeText((String)paramObject)).append('"');
      return;
    }
    if ((paramObject instanceof ByteString))
    {
      paramStringBuilder.append(": \"").append(TextFormatEscaper.escapeBytes((ByteString)paramObject)).append('"');
      return;
    }
    if ((paramObject instanceof GeneratedMessageLite))
    {
      paramStringBuilder.append(" {");
      reflectivePrintWithIndent((GeneratedMessageLite)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = 0;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
  }
  
  private static void reflectivePrintWithIndent(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new HashMap();
    Object localObject3 = new TreeSet();
    Object localObject4 = paramMessageLite.getClass().getDeclaredMethods();
    int j = localObject4.length;
    int i = 0;
    Object localObject5;
    while (i < j)
    {
      localObject5 = localObject4[i];
      ((Map)localObject2).put(((Method)localObject5).getName(), localObject5);
      if (((Method)localObject5).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject5).getName(), localObject5);
        if (((Method)localObject5).getName().startsWith("get")) {
          ((Set)localObject3).add(((Method)localObject5).getName());
        }
      }
      i += 1;
    }
    localObject3 = ((Set)localObject3).iterator();
    label554:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((String)((Iterator)localObject3).next()).replaceFirst("get", "");
      Object localObject6;
      if ((((String)localObject4).endsWith("List")) && (!((String)localObject4).endsWith("OrBuilderList")))
      {
        localObject5 = ((String)localObject4).substring(0, 1).toLowerCase() + ((String)localObject4).substring(1, ((String)localObject4).length() - "List".length());
        localObject6 = (Method)((Map)localObject1).get("get" + (String)localObject4);
        if (localObject6 != null)
        {
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase((String)localObject5), GeneratedMessageLite.invokeOrDie((Method)localObject6, paramMessageLite, new Object[0]));
          continue;
        }
      }
      if (((Method)((Map)localObject2).get("set" + (String)localObject4) != null) && ((!((String)localObject4).endsWith("Bytes")) || (!((Map)localObject1).containsKey("get" + ((String)localObject4).substring(0, ((String)localObject4).length() - "Bytes".length())))))
      {
        localObject5 = ((String)localObject4).substring(0, 1).toLowerCase() + ((String)localObject4).substring(1);
        localObject6 = (Method)((Map)localObject1).get("get" + (String)localObject4);
        localObject4 = (Method)((Map)localObject1).get("has" + (String)localObject4);
        if (localObject6 != null)
        {
          localObject6 = GeneratedMessageLite.invokeOrDie((Method)localObject6, paramMessageLite, new Object[0]);
          boolean bool;
          if (localObject4 == null) {
            if (!isDefaultValue(localObject6)) {
              bool = true;
            }
          }
          for (;;)
          {
            if (!bool) {
              break label554;
            }
            printField(paramStringBuilder, paramInt, camelCaseToSnakeCase((String)localObject5), localObject6);
            break;
            bool = false;
            continue;
            bool = ((Boolean)GeneratedMessageLite.invokeOrDie((Method)localObject4, paramMessageLite, new Object[0])).booleanValue();
          }
        }
      }
    }
    if ((paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage))
    {
      localObject1 = ((GeneratedMessageLite.ExtendableMessage)paramMessageLite).extensions.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        printField(paramStringBuilder, paramInt, "[" + ((GeneratedMessageLite.ExtensionDescriptor)((Map.Entry)localObject2).getKey()).getNumber() + "]", ((Map.Entry)localObject2).getValue());
      }
    }
    if (((GeneratedMessageLite)paramMessageLite).unknownFields != null) {
      ((GeneratedMessageLite)paramMessageLite).unknownFields.printWithIndent(paramStringBuilder, paramInt);
    }
  }
  
  static String toString(MessageLite paramMessageLite, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(paramString);
    reflectivePrintWithIndent(paramMessageLite, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/MessageLiteToString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */