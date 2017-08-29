# ARCore for All
Google ARCore for all devices (not just "supported" ones)

## Summary
Google's ARCore developer preview for Android is awesome. Unfortunately, my Android phone (Samsung GS8+) is "unsupported", and apps built with ARCore exit at start on my device. However, its hardware actually can run ARCore!

I modified the Android library to strip the ARCore device check, and ARCore is now working on the device.

## Installation
In your project, simply replace the Google-provided `arcore_client.aar` with the one in this repo, and voilà! ARCore on any Android device.

## Disclaimer
Please keep in mind that (at the time of this writing) only 3 Android devices are officially supported by ARCore, so this hack might not work. I also take no responsibility for damage to your software. It's worth a try, though! ;)

## Build Instructions
Coming soon
