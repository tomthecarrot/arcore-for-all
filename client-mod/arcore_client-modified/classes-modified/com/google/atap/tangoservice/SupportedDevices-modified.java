/*
 * Decompiled with CFR 0_122.
 *
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.atap.tangoservice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class SupportedDevices {
    private static final String TAG = SupportedDevices.class.getSimpleName();

    public static boolean isSupported(Context context) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            int requestedMajorVersion = appInfo.metaData.getInt("com.google.ar.version.major");
            int requestedMinorVersion = appInfo.metaData.getInt("com.google.ar.version.minor");
            int availableMajorVersion = 0;
            int availableMinorVersion = 0;
            if (requestedMajorVersion > availableMajorVersion) {
                Log.e((String)TAG, (String)"Major version of AR Core is too low.");
                return false;
            }
            if (requestedMajorVersion == availableMajorVersion && requestedMinorVersion > availableMinorVersion) {
                Log.e((String)TAG, (String)"Minor version of AR Core is too low.");
                return false;
            }
        }
        catch (PackageManager.NameNotFoundException e) {
            Log.e((String)TAG, (String)"Unexpected error: Packagename of app doing isSupported check should exist.");
        }
        if (!SupportedDevices.deviceCalibrationAvailable()) {
            Log.e((String)TAG, (String)"Device calibration unavailable. Just kidding! ;)");
            //return false;
        }
        return true;
    }

    private static boolean deviceCalibrationAvailable() {
        return Build.FINGERPRINT.contains("sailfish:7") || Build.FINGERPRINT.contains("sailfish:O") || Build.FINGERPRINT.contains("sailfish:8") || Build.FINGERPRINT.contains("marlin:7") || Build.FINGERPRINT.contains("marlin:O") || Build.FINGERPRINT.contains("marlin:8") || Build.FINGERPRINT.contains("walleye:O") || Build.FINGERPRINT.contains("walleye:8") || Build.FINGERPRINT.contains("taimen:O") || Build.FINGERPRINT.contains("taimen:8") || Build.FINGERPRINT.contains("SC-02J/SC-02J:7") || Build.FINGERPRINT.contains("SCV36_jp_kdi/SCV36:7") || Build.FINGERPRINT.contains("dreamqlteue/dreamqlteue:7") || Build.FINGERPRINT.contains("dreamqltesq/dreamqltesq:7") || Build.FINGERPRINT.contains("dreamqlteldusq/dreamqltesq:7") || Build.FINGERPRINT.contains("dreamqltezm/dreamqltecmcc:7") || Build.FINGERPRINT.contains("dreamqltevl/dreamqltecan:7") || SupportedDevices.isSupportedExynosDevice();
    }

    public static boolean isSupportedExynosDevice() {
        return Build.FINGERPRINT.contains("dreamlteldu/dreamlte:7") || Build.FINGERPRINT.contains("dreamlteks/dreamlteks:7") || Build.FINGERPRINT.contains("dreamltexx/dreamlte:7");
    }
}
