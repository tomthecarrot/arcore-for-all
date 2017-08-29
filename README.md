# ARCore for All
Google ARCore for all devices (not just "supported" ones)

## Summary
Google's ARCore developer preview for Android is awesome. Unfortunately, my Android phone (Samsung GS8+) is "unsupported", and apps built with ARCore exit at start on my device. However, its hardware actually can run ARCore!

I modified the Android library to strip the ARCore device check, and ARCore is now working on the device.

## Android Installation
In your Android project, simply replace the Google-provided `arcore_client.aar` with the one in this repo, and voilà! ARCore on any Android device.

## Unity Installation
In your Unity project, simply replace the Google-provided `unitygar.aar` (located in `GoogleARCore/SDK/Plugins/`) with the one in this repo, and voilà! ARCore on any Android device, within Unity.

## Disclaimer
Please keep in mind that (at the time of this writing) only 3 Android devices are officially supported by ARCore, so this hack might not work. I also take no responsibility for damage to your software. It's worth a try, though! ;)

## Android Build Instructions
To modify the original ARCore AAR library, follow the below instructions. You will need a java class decompiler, such as [CFR](http://www.benf.org/other/cfr/).
1. **Open a command line interface**
2. **Unzip the AAR to a temporary directory**: `unzip arcore_client-original.aar -d aar-tmp`
3. **Enter the temporary aar directory**: `cd aar-tmp`
4. **Unzip classes.jar to a temporary directory**: `unzip classes.jar -d classes-tmp`
5. **Enter the temporary classes directory**: `cd classes-tmp`
6. **Enter the directory containing the SupportedDevices class**: `cd com/google/atap/tangoservice`
7. **Decompile the SupportedDevices class**: `java -jar /path/to/cfr.jar SupportedDevices.class > SupportedDevices.java`
8. **Remove `return false` from the end of `isSupported()`**
9. **Change directory back to aar-tmp**: `cd ../../../../../`
10. **Create a JAR from the modified classes directory**: `jar cvf classes.jar -C classes-tmp .`
11. **Change directory back to repo root**: `cd ..`
12. **Create an AAR from the modified aar directory**: `jar cvf arcore_client.aar -C aar-tmp .`

After the above steps, you will have a modified `arcore_client.aar` with device verification stripped. Now you can replace the AAR in your project and build to any hardware-capable Android device!

## Unity Build Instructions
Coming soon

## Credit
Original library by [Google](https://developers.google.com/ar/develop/java/getting-started)  
Modification by [Thomas Suarez ("tomthecarrot")](http://tomthecarrot.com/)
