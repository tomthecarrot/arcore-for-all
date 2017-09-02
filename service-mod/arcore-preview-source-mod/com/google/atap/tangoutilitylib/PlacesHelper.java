package com.google.atap.tangoutilitylib;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlacesHelper
{
  private static final boolean DEBUG = false;
  private static final int JSON_INDENT_FACTOR = 4;
  private static final String PLACES_DATA_DIR = "/Tango/Data/";
  private static final String PLACES_FILE_NAME = "places_override.txt";
  private static final String TAG = PlacesHelper.class.getSimpleName();
  
  public static String getDefaultFileName()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tango/Data/" + "places_override.txt";
  }
  
  public static ArrayList<PlaceMetadata> getPlaces(int paramInt, Context paramContext)
    throws IOException
  {
    return parsePlacesResponse(ResourceHelper.getResultFromRawResource(paramInt, paramContext));
  }
  
  public static ArrayList<PlaceMetadata> getPlaces(String paramString)
    throws IOException
  {
    String str = paramString;
    if (paramString == null) {
      str = getDefaultFileName();
    }
    return parsePlacesResponse(ResourceHelper.getResultFromFile(str));
  }
  
  public static ArrayList<PlaceMetadata> parsePlacesResponse(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject1).getString("status");
      if (((String)localObject2).equals("OK"))
      {
        localObject1 = ((JSONObject)localObject1).getJSONArray("results");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = PlaceMetadata.build(((JSONArray)localObject1).getJSONObject(i));
          if (localObject2 == null) {
            return new ArrayList();
          }
          localArrayList.add(localObject2);
          i += 1;
        }
      }
      if (((String)localObject2).equals("ZERO_RESULTS"))
      {
        Log.e(TAG, "Response status was [" + (String)localObject2 + "]. Nothing to parse!");
        return localArrayList;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e(TAG, "Caught exception: " + localJSONException.toString());
      Log.e(TAG, "Failed to parse JSON from string:\n" + paramString);
      return new ArrayList();
    }
    Log.e(TAG, "Response status was [" + (String)localObject2 + "], not parsing places.");
    return localJSONException;
  }
  
  public static boolean savePlacesToFile(String paramString, ArrayList<PlaceMetadata> paramArrayList)
  {
    String str = paramString;
    if (paramString == null) {
      str = getDefaultFileName();
    }
    try
    {
      paramString = serializePlacesResponse(paramArrayList);
      ResourceHelper.saveStringToFile(str, paramString.toString(4) + "\n");
      return true;
    }
    catch (JSONException paramString)
    {
      Log.e(TAG, "JSON Error: " + paramString.toString());
      return false;
    }
    catch (IOException paramString)
    {
      Log.e(TAG, "File write failed: " + paramString.toString());
    }
    return false;
  }
  
  public static JSONArray serializePlacesArray(ArrayList<PlaceMetadata> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localJSONArray.put(((PlaceMetadata)paramArrayList.get(i)).toJsonObject());
      i += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject serializePlacesResponse(ArrayList<PlaceMetadata> paramArrayList)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("html_attributions", new JSONArray());
    paramArrayList = serializePlacesArray(paramArrayList);
    localJSONObject.put("results", paramArrayList);
    if (paramArrayList.length() > 0) {}
    for (paramArrayList = "OK";; paramArrayList = "ZERO_RESULTS")
    {
      localJSONObject.put("status", paramArrayList);
      return localJSONObject;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/PlacesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */