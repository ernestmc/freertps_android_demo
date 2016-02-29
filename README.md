# freertps Android demo

In this demo we run a rosjava node to tests the freertps library.

# What you need

* Android NDK
* rosjava
* freertps compiled library (for the target architecture, mostly ARM)

# How to build

1. Copy the freertps library into `src/androidpkg1/androidp1/src/main/jni/static_lib/libfreertps_lib.a`
2. Edit the file `src/androidpkg1/local.properties`
and set the `ndk.dir` variable to the path where the Android NDK is
installed on your system.
3. In the root of the project run `catkin_make`
4. If everthing went well you should have the compiled Android package
located in `src/androidpkg1/androidp1/build/outputs/apk/androidp1-debug.apk`

# Installing to the device and running

1. Run `adb install -r androidp1-debug.apk`
2. In your Android device locate and run the application Androidp1. When
it starts select `Show advanced options` and `New public master`

# Debugging

You can read the debug information using the following command:
```
$ adb logcat | grep -i Androidp1
```
