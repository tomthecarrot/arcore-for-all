package com.google.atap.tangoutilitylib;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceMetadata
  implements Parcelable
{
  public static final Parcelable.Creator<PlaceMetadata> CREATOR = new Parcelable.Creator()
  {
    public PlaceMetadata createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PlaceMetadata(paramAnonymousParcel, null);
    }
    
    public PlaceMetadata[] newArray(int paramAnonymousInt)
    {
      return new PlaceMetadata[paramAnonymousInt];
    }
  };
  private static final String KEY_ALTITUDE = "alt";
  private static final String KEY_BEARING = "bearing";
  private static final String KEY_CREATION_TIMESTAMP = "creation_timestamp";
  private static final String KEY_DESCRIPTION = "description";
  private static final String KEY_ICON = "icon";
  private static final String KEY_IMAGE = "image";
  private static final String KEY_INDOOR_FLOOR_LEVEL = "indoor_floor_level";
  private static final String KEY_KEYWORDS = "keywords";
  private static final String KEY_LATITUDE = "lat";
  private static final String KEY_LOCATION = "location";
  private static final String KEY_LONGITUDE = "lng";
  private static final String KEY_NAME = "name";
  private static final String KEY_PLACE_ID = "place_id";
  private static final String KEY_PROVIDER = "provider";
  private static final String KEY_SCOPE = "scope";
  private static final String KEY_SPONSORED = "sponsored";
  private static final String KEY_VICINITY = "vicinity";
  public static final int SCOPE_APP = 1;
  public static final int SCOPE_GOOGLE = 0;
  public static final String[] SCOPE_STRINGS;
  public static final String TAG = PlaceMetadata.class.getSimpleName();
  private long mCreationTimestamp = 0L;
  private String mDescription = "";
  private String mIconUrl = "";
  private String mImage;
  private String mIndoorFloorLevel = "";
  private boolean mIsSponsored;
  private String[] mKeywords;
  private Location mLocation = new Location("tango");
  private String mName = "";
  private String mPlaceId = "";
  private int mScope = 1;
  private String mVicinity = "";
  
  static
  {
    SCOPE_STRINGS = new String[] { "GOOGLE", "APP" };
  }
  
  public PlaceMetadata()
  {
    this(null, null, null, 1, null, null, null, false, null, null, null, 0L);
  }
  
  private PlaceMetadata(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public PlaceMetadata(String paramString1, String paramString2, String paramString3, int paramInt, Location paramLocation, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt, paramLocation, paramString4, null, false, null, null, null, 0L);
  }
  
  public PlaceMetadata(String paramString1, String paramString2, String paramString3, int paramInt, Location paramLocation, String paramString4, String paramString5, boolean paramBoolean, String[] paramArrayOfString, String paramString6, String paramString7, long paramLong)
  {
    if (paramString1 != null) {
      this.mName = paramString1;
    }
    if (paramString2 != null) {
      this.mPlaceId = paramString2;
    }
    if (paramString3 != null) {
      this.mVicinity = paramString3;
    }
    if (paramLocation != null) {
      this.mLocation = paramLocation;
    }
    if (paramString4 != null) {
      this.mIconUrl = paramString4;
    }
    if (paramString5 != null) {
      this.mImage = paramString5;
    }
    this.mIsSponsored = paramBoolean;
    this.mKeywords = paramArrayOfString;
    if (paramString6 != null) {
      this.mDescription = paramString6;
    }
    setScope(paramInt);
    if (paramString7 != null) {
      this.mIndoorFloorLevel = paramString7;
    }
    this.mCreationTimestamp = paramLong;
  }
  
  public static PlaceMetadata build(JSONObject paramJSONObject)
  {
    try
    {
      PlaceMetadata localPlaceMetadata = new PlaceMetadata();
      localPlaceMetadata.setName(paramJSONObject.getString("name"));
      localPlaceMetadata.setLocation(locationFromJsonObject(paramJSONObject.getJSONObject("location")));
      localPlaceMetadata.setPlaceId(paramJSONObject.optString("place_id", ""));
      localPlaceMetadata.setVicinity(paramJSONObject.optString("vicinity", ""));
      localPlaceMetadata.setScope(scopeStringToInt(paramJSONObject.optString("scope", SCOPE_STRINGS[1])));
      localPlaceMetadata.setIconUrl(paramJSONObject.optString("icon", ""));
      localPlaceMetadata.setImage(paramJSONObject.optString("image", ""));
      localPlaceMetadata.setIsSponsored(paramJSONObject.optBoolean("sponsored", false));
      JSONArray localJSONArray = paramJSONObject.optJSONArray("keywords");
      if (localJSONArray != null)
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = localJSONArray.getString(i);
          i += 1;
        }
        localPlaceMetadata.setKeywords(arrayOfString);
      }
      localPlaceMetadata.setDescription(paramJSONObject.optString("description", ""));
      localPlaceMetadata.setIndoorFloorLevel(paramJSONObject.optString("indoor_floor_level", ""));
      localPlaceMetadata.setCreationTimestamp(paramJSONObject.optLong("creation_timestamp", 0L));
      return localPlaceMetadata;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e(TAG, "Failed to parse JSON object into PlaceMetadata: " + paramJSONObject.toString());
    }
    return null;
  }
  
  private static Location locationFromJsonObject(JSONObject paramJSONObject)
    throws JSONException
  {
    Location localLocation = new Location(paramJSONObject.getString("provider"));
    localLocation.setLatitude(paramJSONObject.optDouble("lat"));
    localLocation.setLongitude(paramJSONObject.optDouble("lng"));
    localLocation.setAltitude(paramJSONObject.optDouble("alt"));
    localLocation.setBearing(Float.parseFloat(paramJSONObject.getString("bearing")));
    return localLocation;
  }
  
  private static JSONObject locationToJsonObject(Location paramLocation)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("provider", paramLocation.getProvider());
      localJSONObject.put("lat", paramLocation.getLatitude());
      localJSONObject.put("lng", paramLocation.getLongitude());
      localJSONObject.put("alt", paramLocation.getAltitude());
      localJSONObject.put("bearing", Float.toString(paramLocation.getBearing()));
      return localJSONObject;
    }
    catch (JSONException paramLocation)
    {
      Log.e(TAG, "Error: Failed to serialize to JSON: " + paramLocation.toString());
    }
    return localJSONObject;
  }
  
  private static String scopeIntToString(int paramInt)
  {
    return SCOPE_STRINGS[paramInt];
  }
  
  private static int scopeStringToInt(String paramString)
    throws IllegalArgumentException
  {
    if (paramString.equals(SCOPE_STRINGS[1])) {
      return 1;
    }
    if (paramString.equals(SCOPE_STRINGS[0])) {
      return 0;
    }
    throw new IllegalArgumentException(String.format("Invalid scope string [%s]", new Object[] { paramString }));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getCreationTimestamp()
  {
    return this.mCreationTimestamp;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public String getIconUrl()
  {
    return this.mIconUrl;
  }
  
  public String getImage()
  {
    return this.mImage;
  }
  
  public String getIndoorFloorLevel()
  {
    return this.mIndoorFloorLevel;
  }
  
  public String[] getKeywords()
  {
    return this.mKeywords;
  }
  
  public Location getLocation()
  {
    return this.mLocation;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPlaceId()
  {
    return this.mPlaceId;
  }
  
  public int getScope()
  {
    return this.mScope;
  }
  
  public String getVicinity()
  {
    return this.mVicinity;
  }
  
  public boolean isSponsored()
  {
    return this.mIsSponsored;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mPlaceId = paramParcel.readString();
    this.mVicinity = paramParcel.readString();
    this.mScope = paramParcel.readInt();
    this.mLocation = ((Location)Location.CREATOR.createFromParcel(paramParcel));
    this.mIconUrl = paramParcel.readString();
    this.mImage = paramParcel.readString();
    this.mKeywords = paramParcel.createStringArray();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsSponsored = bool;
      this.mDescription = paramParcel.readString();
      this.mIndoorFloorLevel = paramParcel.readString();
      this.mCreationTimestamp = paramParcel.readLong();
      return;
    }
  }
  
  public void setCreationTimestamp(long paramLong)
  {
    this.mCreationTimestamp = paramLong;
  }
  
  public void setDescription(String paramString)
    throws NullPointerException
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mDescription = paramString;
  }
  
  public void setIconUrl(String paramString)
    throws NullPointerException
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mIconUrl = paramString;
  }
  
  public void setImage(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mImage = paramString;
  }
  
  public void setIndoorFloorLevel(String paramString)
  {
    this.mIndoorFloorLevel = paramString;
  }
  
  public void setIsSponsored(boolean paramBoolean)
  {
    this.mIsSponsored = paramBoolean;
  }
  
  public void setKeywords(String[] paramArrayOfString)
  {
    this.mKeywords = paramArrayOfString;
  }
  
  public void setLocation(Location paramLocation)
    throws NullPointerException
  {
    if (paramLocation == null) {
      throw new NullPointerException();
    }
    this.mLocation = paramLocation;
  }
  
  public void setName(String paramString)
    throws NullPointerException
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mName = paramString;
  }
  
  public void setPlaceId(String paramString)
    throws NullPointerException
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mPlaceId = paramString;
  }
  
  public void setScope(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException();
    }
    this.mScope = paramInt;
  }
  
  public void setVicinity(String paramString)
    throws NullPointerException
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mVicinity = paramString;
  }
  
  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.mName);
      localJSONObject.put("place_id", this.mPlaceId);
      localJSONObject.put("vicinity", this.mVicinity);
      localJSONObject.put("scope", scopeIntToString(this.mScope));
      localJSONObject.put("icon", this.mIconUrl);
      localJSONObject.put("location", locationToJsonObject(this.mLocation));
      localJSONObject.put("image", this.mImage);
      localJSONObject.put("sponsored", this.mIsSponsored);
      if (this.mKeywords != null) {
        localJSONObject.put("keywords", new JSONArray(Arrays.asList(this.mKeywords)));
      }
      localJSONObject.put("description", this.mDescription);
      localJSONObject.put("indoor_floor_level", this.mIndoorFloorLevel);
      localJSONObject.put("creation_timestamp", this.mCreationTimestamp);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e(TAG, "Error: Failed to serializing to JSON: " + localJSONException.toString());
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlaceMetadata: name: ").append(this.mName).append(" place_id: ").append(this.mPlaceId).append("\n");
    localStringBuilder.append("               location: [").append(this.mLocation.getLatitude()).append(", ");
    localStringBuilder.append(this.mLocation.getLongitude()).append(", ").append(this.mLocation.getAltitude()).append(", ");
    localStringBuilder.append(this.mLocation.getBearing()).append("], vicinity: ").append(this.mVicinity).append(", scope: ").append(this.mScope).append(", sponsored: ").append(this.mIsSponsored).append("\n");
    localStringBuilder.append("               icon: ").append(this.mIconUrl).append("\n");
    localStringBuilder.append("               image: ").append(this.mImage).append("\n");
    localStringBuilder.append("               keywords: ").append(Arrays.toString(this.mKeywords)).append("\n");
    localStringBuilder.append("               description: ").append(this.mDescription).append("\n");
    localStringBuilder.append("               floor level: ").append(this.mIndoorFloorLevel).append("\n");
    localStringBuilder.append("               creation timestamp: ").append(this.mCreationTimestamp);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mPlaceId);
    paramParcel.writeString(this.mVicinity);
    paramParcel.writeInt(this.mScope);
    this.mLocation.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mIconUrl);
    paramParcel.writeString(this.mImage);
    paramParcel.writeStringArray(this.mKeywords);
    if (this.mIsSponsored) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mDescription);
      paramParcel.writeString(this.mIndoorFloorLevel);
      paramParcel.writeLong(this.mCreationTimestamp);
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/PlaceMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */