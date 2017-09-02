package com.google.atap.tangoutilitylib;

import android.location.Location;
import com.google.atap.tangoservice.TangoPoseData;

public class TangoPoseLocationUtils
{
  private static final String TAG = TangoPoseLocationUtils.class.getSimpleName();
  
  static
  {
    System.loadLibrary("tango_utility_lib");
  }
  
  private static void checkArrayLength(double[] paramArrayOfDouble, int paramInt)
  {
    throwIfNull(paramArrayOfDouble);
    if (paramArrayOfDouble.length != paramInt) {
      throw new IllegalArgumentException(String.format("Expected array length = %d, got %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfDouble.length) }));
    }
  }
  
  public static double computeDeviceHeadingInAdfFrame(TangoPoseData paramTangoPoseData)
  {
    throwIfNull(paramTangoPoseData);
    if ((!isValidFramePair(paramTangoPoseData, 2, 4)) && (!isValidFramePair(paramTangoPoseData, 1, 4)) && (!isValidFramePair(paramTangoPoseData, 1, 10))) {
      throw new IllegalArgumentException(String.format("Invalid frame pair [%s, %s], expected [%s, %s] or [%s, %s]or [%s, %s].", new Object[] { TangoPoseData.FRAME_NAMES[paramTangoPoseData.baseFrame], TangoPoseData.FRAME_NAMES[paramTangoPoseData.targetFrame], TangoPoseData.FRAME_NAMES[2], TangoPoseData.FRAME_NAMES[4], TangoPoseData.FRAME_NAMES[1], TangoPoseData.FRAME_NAMES[4], TangoPoseData.FRAME_NAMES[1], TangoPoseData.FRAME_NAMES[10] }));
    }
    return nativeDeviceOrientationInAdfToHeadingInAdf(paramTangoPoseData.rotation);
  }
  
  public static Location convertAdfPoseToLocation(TangoPoseData paramTangoPoseData)
  {
    throwIfNull(paramTangoPoseData);
    throwIfFramePairInvalid(paramTangoPoseData, 0, 1);
    double[] arrayOfDouble = new double[4];
    if (!nativeAdfPoseInEcefToLocation(paramTangoPoseData.translation, paramTangoPoseData.rotation, arrayOfDouble)) {
      return null;
    }
    return makeLocationFromArray(arrayOfDouble);
  }
  
  public static Location convertDevicePoseToLocation(TangoPoseData paramTangoPoseData)
  {
    throwIfNull(paramTangoPoseData);
    throwIfFramePairInvalid(paramTangoPoseData, 0, 4);
    double[] arrayOfDouble = new double[4];
    nativeDevicePoseInEcefToLocation(paramTangoPoseData.translation, paramTangoPoseData.rotation, arrayOfDouble);
    return makeLocationFromArray(arrayOfDouble);
  }
  
  public static Location convertDevicePoseToLocation(TangoPoseData paramTangoPoseData, Location paramLocation)
  {
    throwIfNull(paramTangoPoseData);
    throwIfNull(paramLocation);
    throwIfFramePairInvalid(paramTangoPoseData, 1, 4);
    Location localLocation = convertPositionInAdfToLocation(paramTangoPoseData.translation, paramLocation);
    localLocation.setBearing(paramLocation.getBearing() + (float)computeDeviceHeadingInAdfFrame(paramTangoPoseData));
    return localLocation;
  }
  
  public static Location convertFoiPoseToLocation(TangoPoseData paramTangoPoseData, Location paramLocation)
  {
    throwIfNull(paramTangoPoseData);
    throwIfNull(paramLocation);
    throwIfFramePairInvalid(paramTangoPoseData, 1, 10);
    Location localLocation = convertPositionInAdfToLocation(paramTangoPoseData.translation, paramLocation);
    localLocation.setBearing(paramLocation.getBearing() + (float)computeDeviceHeadingInAdfFrame(paramTangoPoseData));
    return localLocation;
  }
  
  public static TangoPoseData convertLocationToAdfPose(Location paramLocation)
  {
    throwIfNull(paramLocation);
    TangoPoseData localTangoPoseData = new TangoPoseData();
    nativeLocationToAdfPoseInEcef(makeArrayFromLocation(paramLocation), localTangoPoseData.translation, localTangoPoseData.rotation);
    localTangoPoseData.timestamp = 0.0D;
    localTangoPoseData.baseFrame = 0;
    localTangoPoseData.targetFrame = 1;
    return localTangoPoseData;
  }
  
  public static double[] convertLocationToPositionInAdf(Location paramLocation1, Location paramLocation2)
  {
    throwIfNull(paramLocation1);
    throwIfNull(paramLocation2);
    double[] arrayOfDouble = new double[3];
    nativeLocationToPositionInAdfGivenAdfLocation(makeArrayFromLocation(paramLocation1), makeArrayFromLocation(paramLocation2), arrayOfDouble);
    return arrayOfDouble;
  }
  
  public static double[] convertLocationToPositionInAdf(Location paramLocation, TangoPoseData paramTangoPoseData)
  {
    throwIfNull(paramLocation);
    throwIfNull(paramTangoPoseData);
    throwIfFramePairInvalid(paramTangoPoseData, 0, 1);
    double[] arrayOfDouble = new double[3];
    nativeLocationToPositionInAdfGivenAdfPoseInEcef(makeArrayFromLocation(paramLocation), paramTangoPoseData.translation, paramTangoPoseData.rotation, arrayOfDouble);
    return arrayOfDouble;
  }
  
  public static double[] convertLocationToPositionInEcef(Location paramLocation)
  {
    throwIfNull(paramLocation);
    double[] arrayOfDouble = new double[3];
    nativeLocationToPositionInEcef(makeArrayFromLocation(paramLocation), arrayOfDouble);
    return arrayOfDouble;
  }
  
  public static Location convertPositionInAdfToLocation(double[] paramArrayOfDouble, Location paramLocation)
  {
    throwIfNull(paramArrayOfDouble);
    checkArrayLength(paramArrayOfDouble, 3);
    throwIfNull(paramLocation);
    double[] arrayOfDouble = new double[4];
    nativePositionInAdfToLocationGivenAdfLocation(paramArrayOfDouble, makeArrayFromLocation(paramLocation), arrayOfDouble);
    paramArrayOfDouble = makeLocationFromArray(arrayOfDouble);
    paramArrayOfDouble.removeBearing();
    return paramArrayOfDouble;
  }
  
  public static Location convertPositionInAdfToLocation(double[] paramArrayOfDouble, TangoPoseData paramTangoPoseData)
  {
    throwIfNull(paramArrayOfDouble);
    checkArrayLength(paramArrayOfDouble, 3);
    throwIfNull(paramTangoPoseData);
    throwIfFramePairInvalid(paramTangoPoseData, 0, 1);
    double[] arrayOfDouble = new double[4];
    nativePositionInAdfToLocationGivenAdfPoseInEcef(paramArrayOfDouble, paramTangoPoseData.translation, paramTangoPoseData.rotation, arrayOfDouble);
    paramArrayOfDouble = makeLocationFromArray(arrayOfDouble);
    paramArrayOfDouble.removeBearing();
    return paramArrayOfDouble;
  }
  
  public static Location convertPositionInEcefToLocation(double[] paramArrayOfDouble)
  {
    throwIfNull(paramArrayOfDouble);
    checkArrayLength(paramArrayOfDouble, 3);
    double[] arrayOfDouble = new double[4];
    nativePositionInEcefToLocation(paramArrayOfDouble, arrayOfDouble);
    paramArrayOfDouble = makeLocationFromArray(arrayOfDouble);
    paramArrayOfDouble.removeBearing();
    return paramArrayOfDouble;
  }
  
  private static boolean isValidFramePair(TangoPoseData paramTangoPoseData, int paramInt1, int paramInt2)
  {
    throwIfNull(paramTangoPoseData);
    return (paramTangoPoseData.baseFrame == paramInt1) && (paramTangoPoseData.targetFrame == paramInt2);
  }
  
  private static double[] makeArrayFromLocation(Location paramLocation)
  {
    throwIfNull(paramLocation);
    return new double[] { paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getBearing() };
  }
  
  private static String makeCheckFramesMessage(TangoPoseData paramTangoPoseData, int paramInt1, int paramInt2)
  {
    throwIfNull(paramTangoPoseData);
    return String.format("Invalid frame pair [%s, %s], expected [%s, %s].", new Object[] { TangoPoseData.FRAME_NAMES[paramTangoPoseData.baseFrame], TangoPoseData.FRAME_NAMES[paramTangoPoseData.targetFrame], TangoPoseData.FRAME_NAMES[paramInt1], TangoPoseData.FRAME_NAMES[paramInt2] });
  }
  
  private static Location makeLocationFromArray(double[] paramArrayOfDouble)
  {
    throwIfNull(paramArrayOfDouble);
    checkArrayLength(paramArrayOfDouble, 4);
    Location localLocation = new Location("tango");
    localLocation.setLatitude(paramArrayOfDouble[0]);
    localLocation.setLongitude(paramArrayOfDouble[1]);
    localLocation.setAltitude(paramArrayOfDouble[2]);
    localLocation.setBearing((float)paramArrayOfDouble[3]);
    return localLocation;
  }
  
  private static native boolean nativeAdfPoseInEcefToLocation(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  private static native double nativeDeviceOrientationInAdfToHeadingInAdf(double[] paramArrayOfDouble);
  
  private static native void nativeDevicePoseInEcefToLocation(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  private static native void nativeLocationToAdfPoseInEcef(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  private static native void nativeLocationToPositionInAdfGivenAdfLocation(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  private static native void nativeLocationToPositionInAdfGivenAdfPoseInEcef(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4);
  
  private static native void nativeLocationToPositionInEcef(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  private static native void nativePositionInAdfToLocationGivenAdfLocation(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3);
  
  private static native void nativePositionInAdfToLocationGivenAdfPoseInEcef(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3, double[] paramArrayOfDouble4);
  
  private static native void nativePositionInEcefToLocation(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  private static void throwIfFramePairInvalid(TangoPoseData paramTangoPoseData, int paramInt1, int paramInt2)
  {
    throwIfNull(paramTangoPoseData);
    if ((paramTangoPoseData.baseFrame != paramInt1) || (paramTangoPoseData.targetFrame != paramInt2)) {
      throw new IllegalArgumentException(makeCheckFramesMessage(paramTangoPoseData, paramInt1, paramInt2));
    }
  }
  
  private static void throwIfNull(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/TangoPoseLocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */