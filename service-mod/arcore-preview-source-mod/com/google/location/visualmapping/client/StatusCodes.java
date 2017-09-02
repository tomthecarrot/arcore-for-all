package com.google.location.visualmapping.client;

import java.util.HashMap;
import java.util.Map;

public class StatusCodes
{
  public static final int BAD_REQUEST = 4;
  public static final int INTERNAL_ERROR = 1;
  public static final int NETWORK_ERROR = 7;
  public static final int NOT_FOUND = 5;
  public static final int NO_CONNECTION = 6;
  public static final int SERVER_ERROR = 3;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 8;
  private static Map<Integer, String> debugStrings = null;
  
  static int httpErrorToStatusCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 404: 
      return 5;
    }
    return 4;
  }
  
  private static void initializeDebugMap()
  {
    debugStrings = new HashMap();
    debugStrings.put(Integer.valueOf(0), "SUCCESS");
    debugStrings.put(Integer.valueOf(1), "INTERNAL_ERROR");
    debugStrings.put(Integer.valueOf(3), "SERVER_ERROR");
    debugStrings.put(Integer.valueOf(4), "BAD_REQUEST");
    debugStrings.put(Integer.valueOf(5), "NOT_FOUND");
    debugStrings.put(Integer.valueOf(6), "NO_CONNECTION");
    debugStrings.put(Integer.valueOf(7), "NETWORK_ERROR");
    debugStrings.put(Integer.valueOf(8), "TIMEOUT");
  }
  
  public static String toDebugString(int paramInt)
  {
    Object localObject;
    if (paramInt >= 100) {
      localObject = "HTTP code: " + paramInt;
    }
    String str;
    do
    {
      return (String)localObject;
      if (debugStrings == null) {
        initializeDebugMap();
      }
      str = (String)debugStrings.get(Integer.valueOf(paramInt));
      localObject = str;
    } while (str != null);
    return "Unknown status code: " + paramInt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/StatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */