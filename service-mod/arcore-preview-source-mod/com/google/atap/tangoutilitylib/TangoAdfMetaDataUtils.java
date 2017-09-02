package com.google.atap.tangoutilitylib;

import android.text.TextUtils;
import android.util.Log;
import com.google.atap.tangoservice.TangoAreaDescriptionMetaData;
import com.google.atap.tangoservice.TangoPoseData;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class TangoAdfMetaDataUtils
{
  private static final String ADF_NAME_CHARSET = "UTF-8";
  private static final String TAG = TangoAdfMetaDataUtils.class.getSimpleName();
  
  public static TangoPoseData convertAdfMetadataByteArrayToAdfPose(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      Log.e(TAG, "Null parameter [bytes] passed in!");
      return null;
    }
    TangoPoseData localTangoPoseData = new TangoPoseData();
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 3)
    {
      System.arraycopy(paramArrayOfByte, i * 8, arrayOfByte, 0, 8);
      reverseByteArray(arrayOfByte);
      localTangoPoseData.translation[i] = ((float)ByteBuffer.wrap(arrayOfByte).getDouble());
      i += 1;
    }
    i = 0;
    while (i < 4)
    {
      System.arraycopy(paramArrayOfByte, (i + 3) * 8, arrayOfByte, 0, 8);
      reverseByteArray(arrayOfByte);
      localTangoPoseData.rotation[i] = ((float)ByteBuffer.wrap(arrayOfByte).getDouble());
      i += 1;
    }
    localTangoPoseData.baseFrame = 0;
    localTangoPoseData.targetFrame = 1;
    return localTangoPoseData;
  }
  
  public static byte[] convertAdfPoseToAdfMetadataByteArray(TangoPoseData paramTangoPoseData)
  {
    Object localObject;
    if (paramTangoPoseData == null)
    {
      Log.e(TAG, "Null parameter [pose] passed in!");
      localObject = null;
      return (byte[])localObject;
    }
    byte[] arrayOfByte1 = new byte[56];
    byte[] arrayOfByte2 = new byte[8];
    int i = 0;
    while (i < 3)
    {
      ByteBuffer.wrap(arrayOfByte2).putDouble(paramTangoPoseData.translation[i]);
      reverseByteArray(arrayOfByte2);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * 8, 8);
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = arrayOfByte1;
      if (i >= 4) {
        break;
      }
      ByteBuffer.wrap(arrayOfByte2).putDouble(paramTangoPoseData.rotation[i]);
      reverseByteArray(arrayOfByte2);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, (i + 3) * 8, 8);
      i += 1;
    }
  }
  
  public static String getName(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
  {
    byte[] arrayOfByte = paramTangoAreaDescriptionMetaData.get("id");
    paramTangoAreaDescriptionMetaData = paramTangoAreaDescriptionMetaData.get("name");
    if (paramTangoAreaDescriptionMetaData == null) {}
    try
    {
      return new String(arrayOfByte);
    }
    catch (UnsupportedEncodingException paramTangoAreaDescriptionMetaData)
    {
      Log.e(TAG, paramTangoAreaDescriptionMetaData.getMessage());
    }
    paramTangoAreaDescriptionMetaData = new String(paramTangoAreaDescriptionMetaData, "UTF-8");
    return paramTangoAreaDescriptionMetaData;
    return "";
  }
  
  public static long getTimestamp(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
  {
    if (paramTangoAreaDescriptionMetaData == null) {}
    do
    {
      return 0L;
      paramTangoAreaDescriptionMetaData = paramTangoAreaDescriptionMetaData.get("date_ms_since_epoch");
    } while (paramTangoAreaDescriptionMetaData == null);
    reverseByteArray(paramTangoAreaDescriptionMetaData);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.put(paramTangoAreaDescriptionMetaData);
    localByteBuffer.flip();
    return localByteBuffer.getLong();
  }
  
  public static TangoPoseData getTransformation(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
  {
    if (paramTangoAreaDescriptionMetaData == null)
    {
      Log.e(TAG, "Null parameter [metaData] passed in!");
      return null;
    }
    paramTangoAreaDescriptionMetaData = paramTangoAreaDescriptionMetaData.get("transformation");
    if (paramTangoAreaDescriptionMetaData != null)
    {
      if (paramTangoAreaDescriptionMetaData.length != 56)
      {
        Log.e(TAG, String.format("Adf metadata [transformation] got %d bytes, expected 56.", new Object[] { Integer.valueOf(paramTangoAreaDescriptionMetaData.length) }));
        return null;
      }
      return convertAdfMetadataByteArrayToAdfPose(paramTangoAreaDescriptionMetaData);
    }
    Log.e(TAG, "Failed to find [transformation] key in adf metadata!");
    return null;
  }
  
  public static String getUuid(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
  {
    String str = "";
    if (paramTangoAreaDescriptionMetaData == null) {
      return "";
    }
    paramTangoAreaDescriptionMetaData = paramTangoAreaDescriptionMetaData.get("id");
    if (paramTangoAreaDescriptionMetaData == null) {
      return "";
    }
    try
    {
      paramTangoAreaDescriptionMetaData = new String(paramTangoAreaDescriptionMetaData, "UTF-8");
      return paramTangoAreaDescriptionMetaData;
    }
    catch (UnsupportedEncodingException paramTangoAreaDescriptionMetaData)
    {
      for (;;)
      {
        Log.e(TAG, paramTangoAreaDescriptionMetaData.getMessage());
        paramTangoAreaDescriptionMetaData = str;
      }
    }
  }
  
  private static void reverseByteArray(byte[] paramArrayOfByte)
  {
    for (int j = 0; j < paramArrayOfByte.length / 2; j = (byte)(j + 1))
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(paramArrayOfByte.length - j - 1)];
      paramArrayOfByte[(paramArrayOfByte.length - j - 1)] = i;
    }
  }
  
  public static void setName(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramTangoAreaDescriptionMetaData.set("name", paramString.getBytes("UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramTangoAreaDescriptionMetaData)
    {
      Log.e(TAG, paramTangoAreaDescriptionMetaData.getMessage());
    }
  }
  
  public static void setTransformation(TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData, TangoPoseData paramTangoPoseData)
  {
    if ((paramTangoAreaDescriptionMetaData == null) || (paramTangoPoseData == null))
    {
      Log.e(TAG, "Null parameters passed in!");
      return;
    }
    paramTangoAreaDescriptionMetaData.set("transformation", convertAdfPoseToAdfMetadataByteArray(paramTangoPoseData));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/TangoAdfMetaDataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */