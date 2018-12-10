# ARCore for All
Google ARCore (dev preview 1) for "unsupported" Android devices

## Summary
Google's ARCore developer preview for Android is awesome. Unfortunately, my Android phone (Samsung GS8+) was not on the supported list, and apps built with ARCore exit at start on my device. However, its hardware actually can run ARCore!

I modified the Android library to strip the ARCore device check, and ARCore started working on the device.

## Developer Preview 2
ARCore has been updated to Preview 2 by Google. More devices are now supported. Another project on GitHub, [ARCore Patch](https://github.com/thestr4ng3r/arcore-patch), aims to extend unofficial device support for the new version.  

## Developer Preview 1
Please see below for research on the first preview build.

### See Experimental Branch
This branch is unlikely to work on most devices.  
**Please check out the [service mod](https://github.com/tomthecarrot/arcore-for-all/tree/service-mod) branch** of this repo to help us develop the latest experiment to bring ARCore to more devices. Thanks!

## Android Installation
In your Android project, simply replace the Google-provided `arcore_client.aar` with the one in this repo, and voilà! ARCore on any Android device.

~Make sure to first install ARCore Service - "Preparing your Device" section of [Google's instructions](https://developers.google.com/ar/develop/java/getting-started)~  

## Unity Installation
In your Unity project, simply replace the Google-provided `unitygar.aar` (located in `GoogleARCore/SDK/Plugins/`) with the one in this repo, and voilà! ARCore on any Android device, within Unity.

~Make sure to first install ARCore Service - "Preparing your Device" section of [Google's instructions](https://developers.google.com/ar/develop/java/getting-started)~  

## Requirements
1. **Capable Android Hardware** - Since Google does not yet officially support more than a few devices, it's unknown which devices will actually work. My estimate is that devices from the past year should work, but it's currently unclear. Feel free to try and see if it works on your device, then let us know! There is a [research document](https://github.com/tomthecarrot/arcore-for-all/blob/master/Device-Research.md) so we can identify necessary modifications.
2. **64-bit Architecture** - The library does not contain a build for 32-bit processors, [as pointed out by @szugyi](https://github.com/tomthecarrot/arcore-for-all/issues/13#issuecomment-328300515).

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
8. **Open a text editor and delete `return false` from the end of `isSupported()`**
9. **Compile the modified SupportedDevice class**: `javac -cp /path/to/sdk/platform/android.jar -source 1.7 -target 1.7 SupportedDevices.java`
10. **Delete the Java source**: `rm SupportedDevices.java`
11. **Change directory back to aar-tmp**: `cd ../../../../../`
12. **Create a JAR from the modified classes directory**: `jar cvf classes.jar -C classes-tmp .`
13. **Change directory back to repo root**: `cd ..`
14. **Create an AAR from the modified aar directory**: `jar cvf arcore_client.aar -C aar-tmp .`

After the above steps, you will have a modified `arcore_client.aar` with device verification stripped. Now you can replace the AAR in your project and build to any hardware-capable Android device!

## Android (pre-Nougat) Build Instructions
The official library has a minimum SDK version of Android 7.0 (Nougat). See [@kenfast's research for installing on pre-7.0](https://github.com/tomthecarrot/arcore-for-all/issues/70#issue-257430177).

## Unity Build Instructions
_these instructions contributed by GitHub user [Ila Maheshwari](https://github.com/ilamaheshwari). Thank you!_   
1. Connect your Android device to your computer using a USB cable. You may see a prompt asking you to confirm that you wish to enable USB debugging on the device. If so, click OK.
2. In Unity, open the Build Settings from the top menu (File > Build Settings).
3. Click "Add Open Scenes" to add the Main scene to the list of scenes that will be built. Click Build And Run.
4. You will be prompted to choose where to build your apk. A good place to do this is in a dedicated builds directory in the root of your project.
5. Create a directory called "Builds" in the root of your project (not within your Assets directory, but at the same level as it). Select that directory as the location to which to build.
6. In the text input field marked Save As, enter "Android" and click Save.
7. Unity will now create an apk file called "Android" in the "Builds" folder. Run `adb install [filename].apk` to install it to your device.

## Credit
Original library by [Google](https://developers.google.com/ar/develop/java/getting-started)  
Modification by [Thomas Suarez ("tomthecarrot")](http://tomthecarrot.com/)
