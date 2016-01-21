# freertps Android demo

In this demo we run a rosjava node to tests the freertps library.

# What you need

* Android NDK
* rosjava
* freertps compiled library (for the target architecture, mostly ARM)

# How to build

1. Copy the freertps library into `src/androidpkg1/androidp1/src/main/jni/static_lib/libfreertps_lib.a`
2. Edit the file `/home/ecorbellini/repos/ernesto/freertps_android_test/src/androidpkg1/local.properties`
and set the `ndk.dir` variable to the path where the Android NDK is
installed on your system.
3. In the root of the project run ```catkin_make```
4. If everthing went well you should have the compiled Android package
located in `src/androidpkg1/androidp1/build/outputs/apk/androidp1-debug.apk`

# Installing to the device and running
1. Run `adb install -r androidp1-debug.apk`
2. In your Android device locate and run the application Androidp1. When
it starts select `Show advanced options` and `New public master`

Note: the application is currently not working and crashes with the
following stack trace:
```
I/DEBUG   (  260): Abort message: 'stack corruption detected'
I/DEBUG   (  260):     r0 00000000  r1 000018a2  r2 00000006  r3 00000000
I/DEBUG   (  260):     r4 aee62db8  r5 00000006  r6 00000058  r7 0000010c
I/DEBUG   (  260):     r8 12ece200  r9 a98d9c00  sl 12dbf070  fp 00000000
I/DEBUG   (  260):     ip 000018a2  sp aee62308  lr b6f1207d  pc b6f363c4  cpsr 60070010
I/DEBUG   (  260): 
I/DEBUG   (  260): backtrace:
I/DEBUG   (  260):     #00 pc 000383c4  /system/lib/libc.so (tgkill+12)
I/DEBUG   (  260):     #01 pc 00014079  /system/lib/libc.so (pthread_kill+52)
I/DEBUG   (  260):     #02 pc 00014c97  /system/lib/libc.so (raise+10)
I/DEBUG   (  260):     #03 pc 000115dd  /system/lib/libc.so (__libc_android_abort+36)
I/DEBUG   (  260):     #04 pc 0000fc9c  /system/lib/libc.so (abort+4)
I/DEBUG   (  260):     #05 pc 000127ad  /system/lib/libc.so (__libc_fatal+16)
I/DEBUG   (  260):     #06 pc 000369a3  /system/lib/libc.so (__stack_chk_fail+6)
I/DEBUG   (  260):     #07 pc 00005f7b  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so
I/DEBUG   (  260):     #08 pc 00006041  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so (getifaddrs+188)
I/DEBUG   (  260):     #09 pc 000050cd  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so (frudp_init+60)
I/DEBUG   (  260):     #10 pc 000058bf  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so (freertps_system_init+26)
I/DEBUG   (  260):     #11 pc 00002a29  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so (f1+16)
I/DEBUG   (  260):     #12 pc 00002ab3  /data/app/com.github.rosjava.android.androidp1-1/lib/arm/libfreertps_listener.so (Java_com_github_rosjava_android_androidp1_FreeRTPSListener_listener+2)
I/DEBUG   (  260):     #13 pc 00077153  /data/dalvik-cache/arm/data@app@com.github.rosjava.android.androidp1-1@base.apk@classes.dex
```
